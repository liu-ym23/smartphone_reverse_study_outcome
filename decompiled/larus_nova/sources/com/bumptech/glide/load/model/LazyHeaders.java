package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class LazyHeaders implements Headers {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;

    public static final class Builder {
        private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS = null;
        private static final String DEFAULT_USER_AGENT = null;
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify;
        private Map<String, List<LazyHeaderFactory>> headers;
        private boolean isUserAgentDefault;

        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            HashMap r100 = new HashMap(this.headers.size());
            Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r101 = this.headers.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<String, List<LazyHeaderFactory>> r102 = r101.next();
            ArrayList r103 = new ArrayList(r102.getValue());
            r100.put(r102.getKey(), r103);
            goto L4
        L6:
            return r100;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify == false) goto L6;
            this.copyOnModify = false;
            this.headers = copyHeaders();
            return;
        }

        public static String getSanitizedUserAgent() {
            String r100 = System.getProperty("http.agent");
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return r100;
        L5:
            int r101 = r100.length();
            StringBuilder r102 = new StringBuilder(r100.length());
            int r103 = 0;
        L6:
            if (r103 >= r101) goto L17;
            char r104 = r100.charAt(r103);
            if (r104 > 31) goto L12;
            if (r104 == '\t') goto L12;
        L14:
            r102.append('?');
        L15:
            r103 = r103 + 1;
        L12:
            if (r104 >= 127) goto L14;
            r102.append(r104);
            goto L15
        L17:
            return r102.toString();
        }

        static {
            String r100 = getSanitizedUserAgent();
            DEFAULT_USER_AGENT = r100;
            HashMap r101 = new HashMap(2);
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r101.put("User-Agent", Collections.singletonList(new StringHeaderFactory(r100)));
        L5:
            DEFAULT_HEADERS = Collections.unmodifiableMap(r101);
        }

        public Builder() {
            this.copyOnModify = true;
            this.headers = DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        private List<LazyHeaderFactory> getFactories(String r100) {
            List<LazyHeaderFactory> r101 = this.headers.get(r100);
            if (r101 != null) goto L6;
            ArrayList r102 = new ArrayList();
            this.headers.put(r100, r102);
            return r102;
        L6:
            return r101;
        }

        public Builder addHeader(String r100, LazyHeaderFactory r101) {
            if (this.isUserAgentDefault == true) goto L5;
        L8:
            copyIfNecessary();
            getFactories(r100).add(r101);
            return this;
        L5:
            if ("User-Agent".equalsIgnoreCase(r100) == false) goto L8;
            return setHeader(r100, r101);
        }

        public Builder setHeader(String r100, LazyHeaderFactory r101) {
            copyIfNecessary();
            if (r101 != null) goto L5;
            this.headers.remove(r100);
        L7:
            if (this.isUserAgentDefault == true) goto L9;
        L11:
            return this;
        L9:
            if ("User-Agent".equalsIgnoreCase(r100) == false) goto L11;
            this.isUserAgentDefault = false;
            goto L11
        L5:
            List<LazyHeaderFactory> r102 = getFactories(r100);
            r102.clear();
            r102.add(r101);
            goto L7
        }

        public Builder addHeader(String r100, String r101) {
            return addHeader(r100, new StringHeaderFactory(r101));
        }

        public Builder setHeader(String r100, String r101) {
            if (r101 != null) goto L4;
            StringHeaderFactory r102 = null;
        L6:
            return setHeader(r100, r102);
        L4:
            r102 = new StringHeaderFactory(r101);
            goto L6
        }
    }

    public static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + "'}";
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        public StringHeaderFactory(String r100) {
            this.value = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof StringHeaderFactory) == true) goto L5;
            return false;
        L5:
            return this.value.equals(((StringHeaderFactory) r100).value);
        }
    }

    private Map<String, String> generateHeaders() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r101 = this.headers.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, List<LazyHeaderFactory>> r102 = r101.next();
        String r103 = buildHeaderValue(r102.getValue());
        if (TextUtils.isEmpty(r103) == true) goto L4;
        r100.put(r102.getKey(), r103);
        goto L4
    L8:
        return r100;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.combinedHeaders != null) goto L8;
        this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }

    public LazyHeaders(Map<String, List<LazyHeaderFactory>> r100) {
        this.headers = Collections.unmodifiableMap(r100);
    }

    private String buildHeaderValue(List<LazyHeaderFactory> r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        String r104 = ((LazyHeaderFactory) ListProtector.get(r100, r103)).buildHeader();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r101.append(r104);
        if (r103 == (r100.size() - 1)) goto L9;
        r101.append(',');
    L9:
        r103 = r103 + 1;
        goto L3
    L11:
        return r101.toString();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LazyHeaders) == true) goto L5;
        return false;
    L5:
        return this.headers.equals(((LazyHeaders) r100).headers);
    }
}
