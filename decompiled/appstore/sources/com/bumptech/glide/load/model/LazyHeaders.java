package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        static {
            String r10 = getSanitizedUserAgent();
            DEFAULT_USER_AGENT = r10;
            HashMap r11 = new HashMap(2);
            if (TextUtils.isEmpty(r10) == true) goto L5;
            r11.put("User-Agent", Collections.singletonList(new StringHeaderFactory(r10)));
        L5:
            DEFAULT_HEADERS = Collections.unmodifiableMap(r11);
        }

        public Builder() {
            this.copyOnModify = true;
            this.headers = DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            HashMap r10 = new HashMap(this.headers.size());
            Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r11 = this.headers.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<String, List<LazyHeaderFactory>> r12 = r11.next();
            ArrayList r13 = new ArrayList(r12.getValue());
            r10.put(r12.getKey(), r13);
            goto L4
        L6:
            return r10;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify == false) goto L6;
            this.copyOnModify = false;
            this.headers = copyHeaders();
            return;
        }

        private List<LazyHeaderFactory> getFactories(String r10) {
            List<LazyHeaderFactory> r11 = this.headers.get(r10);
            if (r11 != null) goto L6;
            ArrayList r12 = new ArrayList();
            this.headers.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        @VisibleForTesting
        public static String getSanitizedUserAgent() {
            String r10 = System.getProperty("http.agent");
            if (TextUtils.isEmpty(r10) == false) goto L5;
            return r10;
        L5:
            int r11 = r10.length();
            StringBuilder r12 = new StringBuilder(r10.length());
            int r13 = 0;
        L6:
            if (r13 >= r11) goto L17;
            char r14 = r10.charAt(r13);
            if (r14 > 31) goto L12;
            if (r14 == '\t') goto L12;
        L14:
            r12.append('?');
        L15:
            r13 = r13 + 1;
        L12:
            if (r14 >= 127) goto L14;
            r12.append(r14);
            goto L15
        L17:
            return r12.toString();
        }

        public Builder addHeader(@NonNull String r10, @NonNull String r11) {
            return addHeader(r10, new StringHeaderFactory(r11));
        }

        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        public Builder setHeader(@NonNull String r10, @Nullable String r11) {
            if (r11 != null) goto L4;
            StringHeaderFactory r12 = null;
        L6:
            return setHeader(r10, r12);
        L4:
            r12 = new StringHeaderFactory(r11);
            goto L6
        }

        public Builder addHeader(@NonNull String r10, @NonNull LazyHeaderFactory r11) {
            if (this.isUserAgentDefault == true) goto L5;
        L8:
            copyIfNecessary();
            getFactories(r10).add(r11);
            return this;
        L5:
            if ("User-Agent".equalsIgnoreCase(r10) == false) goto L8;
            return setHeader(r10, r11);
        }

        public Builder setHeader(@NonNull String r10, @Nullable LazyHeaderFactory r11) {
            copyIfNecessary();
            if (r11 != null) goto L5;
            this.headers.remove(r10);
        L7:
            if (this.isUserAgentDefault == true) goto L9;
        L11:
            return this;
        L9:
            if ("User-Agent".equalsIgnoreCase(r10) == false) goto L11;
            this.isUserAgentDefault = false;
            goto L11
        L5:
            List<LazyHeaderFactory> r12 = getFactories(r10);
            r12.clear();
            r12.add(r11);
            goto L7
        }
    }

    public static final class StringHeaderFactory implements LazyHeaderFactory {

        @NonNull
        private final String value;

        public StringHeaderFactory(@NonNull String r10) {
            this.value = r10;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof StringHeaderFactory) == true) goto L5;
            return false;
        L5:
            return this.value.equals(((StringHeaderFactory) r10).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + "'}";
        }
    }

    public LazyHeaders(Map<String, List<LazyHeaderFactory>> r10) {
        this.headers = Collections.unmodifiableMap(r10);
    }

    @NonNull
    private String buildHeaderValue(@NonNull List<LazyHeaderFactory> r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        String r14 = r10.get(r13).buildHeader();
        if (TextUtils.isEmpty(r14) == true) goto L9;
        r11.append(r14);
        if (r13 == (r10.size() - 1)) goto L9;
        r11.append(',');
    L9:
        r13 = r13 + 1;
        goto L3
    L11:
        return r11.toString();
    }

    private Map<String, String> generateHeaders() {
        HashMap r10 = new HashMap();
        Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r11 = this.headers.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, List<LazyHeaderFactory>> r12 = r11.next();
        String r13 = buildHeaderValue(r12.getValue());
        if (TextUtils.isEmpty(r13) == true) goto L4;
        r10.put(r12.getKey(), r13);
        goto L4
    L8:
        return r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof LazyHeaders) == true) goto L5;
        return false;
    L5:
        return this.headers.equals(((LazyHeaders) r10).headers);
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders != null) goto L15;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.combinedHeaders != null) goto L10;
        this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L15:
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }
}
