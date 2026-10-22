package com.bumptech.glide.load.b;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LazyHeaders.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f3447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f3448d;

    /* JADX INFO: compiled from: LazyHeaders.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f3449a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<String, List<i>> f3450b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, List<i>> f3452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3453e;

        public a() {
            this.f3451c = true;
            this.f3452d = f3450b;
            this.f3453e = true;
        }

        static {
            String r0 = b();
            f3449a = r0;
            HashMap r1 = new HashMap(2);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r1.put(DownloadConstants.USER_AGENT, Collections.singletonList(new b(r0)));
        L5:
            f3450b = Collections.unmodifiableMap(r1);
        }

        public j a() {
            this.f3451c = true;
            return new j(this.f3452d);
        }

        static String b() {
            String r0 = System.getProperty("http.agent");
            if (TextUtils.isEmpty(r0) == false) goto L5;
            return r0;
        L5:
            int r1 = r0.length();
            StringBuilder r2 = new StringBuilder(r0.length());
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L17;
            char r4 = r0.charAt(r3);
            if (r4 > 31) goto L12;
            if (r4 == '\t') goto L12;
        L14:
            r2.append('?');
        L15:
            r3 = r3 + 1;
        L12:
            if (r4 >= 127) goto L14;
            r2.append(r4);
            goto L15
        L17:
            return r2.toString();
        }
    }

    /* JADX INFO: compiled from: LazyHeaders.java */
    static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3454a;

        b(String r1) {
            this.f3454a = r1;
        }

        @Override // com.bumptech.glide.load.b.i
        public String a() {
            return this.f3454a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f3454a + "'}";
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L6;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            return this.f3454a.equals(r4.f3454a);
        L6:
            return false;
        }

        public int hashCode() {
            return this.f3454a.hashCode();
        }
    }

    j(Map<String, List<i>> r3) {
        this.f3447c = Collections.unmodifiableMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.b.h
    public Map<String, String> a() {
        if (this.f3448d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f3448d != null) goto L8;
        this.f3448d = Collections.unmodifiableMap(b());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f3448d;
    }

    private Map<String, String> b() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, List<i>>> r1 = this.f3447c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = a((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin"));
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r0.put(r2.getKey(), r3);
        goto L4
    L8:
        return r0;
    }

    private String a(List<i> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        StringBuilder r7 = new StringBuilder();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        String r3 = ((i) ZeusTransformUtils.preCheckCast(r5.get(r2), i.class, "com.obric.aiagent.plugin")).a();
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r7.append(r3);
        if (r2 == (r5.size() - 1)) goto L9;
        r7.append(',');
    L9:
        r2 = r2 + 1;
        goto L3
    L11:
        return r7.toString();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f3447c + '}';
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L6;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin");
        return this.f3447c.equals(r4.f3447c);
    L6:
        return false;
    }

    public int hashCode() {
        return this.f3447c.hashCode();
    }
}
