package com.amap.api.mapcore.util;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes28.dex */
public class c4 implements a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, a> f27110a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f27111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f27112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f27114d;

        public a(c4 r100, int r101, String r102, String r103) {
            this.f27111a = r102;
            this.f27112b = r103;
            this.f27113c = r101;
            this.f27114d = new AtomicInteger(0);
        }
    }

    static {
        f27110a = new ConcurrentHashMap();
    }

    @Override // com.amap.api.mapcore.util.a4
    public void flush() {
        Iterator<Map.Entry<String, a>> r100 = f27110a.entrySet().iterator();     // Catch: Throwable -> L10
    L4:
        if (r100.hasNext() == false) goto L8;
        a r101 = r100.next().getValue();     // Catch: Throwable -> L10
        if (r101 == null) goto L4;
        a(r101.f27113c, r101.f27111a, r101.f27112b, r101.f27114d.get());     // Catch: Throwable -> L10
        goto L4
    L8:
        f27110a.clear();     // Catch: Throwable -> L10
        a6.a(w3.b()).e();     // Catch: Throwable -> L10
        return;
    }

    public c4() {
    }

    @Override // com.amap.api.mapcore.util.a4
    public void a(int r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L18
        r103.append(r100);     // Catch: Throwable -> L18
        String r104 = "";
        if (r101 != null) goto L6;
        String r105 = "";
    L7:
        r103.append(r105);     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        r104 = r102;
    L11:
        r103.append(r104);     // Catch: Throwable -> L18
        String r106 = r103.toString();     // Catch: Throwable -> L18
        a r107 = f27110a.get(r106);     // Catch: Throwable -> L18
        if (r107 != null) goto L15;
        r107 = new a(this, r100, r101, r102);     // Catch: Throwable -> L18
        f27110a.put(r106, r107);     // Catch: Throwable -> L18
    L15:
        if (r107.f27114d.incrementAndGet() <= 100) goto L21;
        a(r107.f27113c, r107.f27111a, r107.f27112b, r107.f27114d.get());     // Catch: Throwable -> L18
        f27110a.remove(r106);     // Catch: Throwable -> L18
        return;
    L21:
        return;
    L6:
        r105 = r101;
    }

    private void a(int r100, String r101, String r102, int r103) {
        if (r100 != 0) goto L5;
        a6.a(w3.b()).a(z5.b(r101, r102 + " counter " + r103));
        return;
    L5:
        a6.a(w3.b()).a(z5.b(r101, r102 + " counter " + r103));
    }
}
