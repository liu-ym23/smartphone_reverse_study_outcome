package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: UrlResponseInfoImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ah extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f38110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f38112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f38113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f38114e;
    private final String f;
    private final AtomicLong g;
    private final a h;

    /* JADX INFO: compiled from: UrlResponseInfoImpl.java */
    public static final class a extends aj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Map.Entry<String, String>> f38115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<String>> f38116b;

        a(List<Map.Entry<String, String>> r3) {
            this.f38115a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public List<Map.Entry<String, String>> a() {
            return this.f38115a;
        }

        public Map<String, List<String>> b() {
            Map<String, List<String>> r0 = this.f38116b;
            if (r0 == null) goto L5;
            return r0;
        L5:
            TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator<Map.Entry<String, String>> r2 = this.f38115a.iterator();
        L7:
            if (r2.hasNext() == false) goto L12;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            ArrayList r4 = new ArrayList();
            if (r1.containsKey(r3.getKey()) == false) goto L11;
            r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r1.get(r3.getKey()), Collection.class, "com.obric.aiagent.plugin"));
        L11:
            r4.add((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
            r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList(r4));
            goto L7
        L12:
            Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
            this.f38116b = r5;
            return r5;
        }
    }

    public ah(List<String> r3, int r4, String r5, List<Map.Entry<String, String>> r6, boolean r7, String r8, String r9, long r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f38110a = Collections.unmodifiableList(r11);
        this.f38111b = r4;
        this.f38112c = r5;
        this.h = new a(Collections.unmodifiableList(r12));
        this.f38113d = r7;
        this.f38114e = r8;
        this.f = r9;
        this.g = new AtomicLong(r10);
    }

    public String e() {
        List<String> r2 = this.f38110a;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), String.class, "com.obric.aiagent.plugin");
    }

    public List<String> f() {
        return this.f38110a;
    }

    @Override // com.ttnet.org.chromium.net.aj
    public int a() {
        return this.f38111b;
    }

    @Override // com.ttnet.org.chromium.net.aj
    public String b() {
        return this.f38112c;
    }

    @Override // com.ttnet.org.chromium.net.aj
    public List<Map.Entry<String, String>> c() {
        return this.h.a();
    }

    @Override // com.ttnet.org.chromium.net.aj
    public Map<String, List<String>> d() {
        return this.h.b();
    }

    public boolean g() {
        return this.f38113d;
    }

    public String h() {
        return this.f38114e;
    }

    public String i() {
        return this.f;
    }

    public long j() {
        return this.g.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), e(), f().toString(), Integer.valueOf(a()), b(), c().toString(), Boolean.valueOf(g()), h(), i(), Long.valueOf(j())});
    }

    public void a(long r1) {
        this.g.set(r1);
    }
}
