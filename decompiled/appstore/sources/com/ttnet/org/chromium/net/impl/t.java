package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class t extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f18938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f18939h;

    public static final class a extends b0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f18940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f18941b;

        public a(List r10) {
            this.f18940a = r10;
        }

        public List a() {
            return this.f18940a;
        }

        public Map b() {
            Map r10 = this.f18941b;
            if (r10 == null) goto L5;
            return r10;
        L5:
            TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator r12 = this.f18940a.iterator();
        L7:
            if (r12.hasNext() == false) goto L12;
            Map.Entry r13 = (Map.Entry) r12.next();
            ArrayList r14 = new ArrayList();
            if (r11.containsKey(r13.getKey()) == false) goto L11;
            r14.addAll((Collection) r11.get(r13.getKey()));
        L11:
            r14.add((String) r13.getValue());
            r11.put((String) r13.getKey(), Collections.unmodifiableList(r14));
            goto L7
        L12:
            Map r15 = Collections.unmodifiableMap(r11);
            this.f18941b = r15;
            return r15;
        }
    }

    public t(List r10, int r11, String r12, List r13, boolean r14, String r15, String r16, long r17) {
        this.f18932a = Collections.unmodifiableList(r10);
        this.f18933b = r11;
        this.f18934c = r12;
        this.f18939h = new a(Collections.unmodifiableList(r13));
        this.f18935d = r14;
        this.f18936e = r15;
        this.f18937f = r16;
        this.f18938g = new AtomicLong(r17);
    }

    @Override // com.ttnet.org.chromium.net.b0
    public Map a() {
        return this.f18939h.b();
    }

    @Override // com.ttnet.org.chromium.net.b0
    public List b() {
        return this.f18939h.a();
    }

    @Override // com.ttnet.org.chromium.net.b0
    public int c() {
        return this.f18933b;
    }

    @Override // com.ttnet.org.chromium.net.b0
    public String d() {
        return this.f18934c;
    }

    public String e() {
        return this.f18936e;
    }

    public String f() {
        return this.f18937f;
    }

    public long g() {
        return this.f18938g.get();
    }

    public String h() {
        List r10 = this.f18932a;
        return (String) r10.get(r10.size() - 1);
    }

    public List i() {
        return this.f18932a;
    }

    public void j(long r10) {
        this.f18938g.set(r10);
    }

    public boolean k() {
        return this.f18935d;
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), e(), f(), Long.valueOf(g())});
    }
}
