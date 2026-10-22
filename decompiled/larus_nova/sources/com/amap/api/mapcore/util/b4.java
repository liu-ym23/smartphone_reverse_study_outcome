package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class b4 implements a4 {
    @Override // com.amap.api.mapcore.util.a4
    public void flush() {
        a6.a(w3.b()).e();     // Catch: Throwable -> L4
        return;
    }

    public b4() {
    }

    @Override // com.amap.api.mapcore.util.a4
    public void a(int r100, String r101, String r102) {
        if (r100 != 0) goto L4;
        a6.a(w3.b()).a(z5.b(r101, r102));
        return;
    L4:
        a6.a(w3.b()).a(z5.a(r101, r102));
    }
}
