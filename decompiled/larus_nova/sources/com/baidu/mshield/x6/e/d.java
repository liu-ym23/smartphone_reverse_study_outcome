package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes39.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32586a;

    public void a() {
        com.baidu.mshield.x6.b.b r100 = new com.baidu.mshield.x6.b.b(this.f32586a);     // Catch: Throwable -> L30
        String r101 = com.baidu.mshield.x6.c.a.a(this.f32586a);     // Catch: Throwable -> L30
        String r102 = com.baidu.mshield.x6.c.a.b(this.f32586a);     // Catch: Throwable -> L30
        String r103 = r100.O();     // Catch: Throwable -> L30
        String r104 = r100.N();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r103 = com.baidu.mshield.b.f.e.a(r103);     // Catch: Throwable -> L30
        r100.o(r103);     // Catch: Throwable -> L30
    L6:
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r104 = com.baidu.mshield.b.f.e.a(r104);     // Catch: Throwable -> L30
        r100.n(r104);     // Catch: Throwable -> L30
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.isEmpty(r102) == true) goto L19;
        if (r103.equals(com.baidu.mshield.b.f.e.a(r101)) == true) goto L16;
    L17:
        r100.e(true);     // Catch: Throwable -> L30
        r100.o(com.baidu.mshield.b.f.e.a(r101));     // Catch: Throwable -> L30
        r100.n(com.baidu.mshield.b.f.e.a(r102));     // Catch: Throwable -> L30
        return;
    L16:
        if (r104.equals(com.baidu.mshield.b.f.e.a(r102)) == false) goto L17;
        return;
    L19:
        if (r103.equals(com.baidu.mshield.b.f.e.a(r101)) == true) goto L36;
        r100.e(true);     // Catch: Throwable -> L30
        r100.o(com.baidu.mshield.b.f.e.a(r101));     // Catch: Throwable -> L30
        r100.n("");     // Catch: Throwable -> L30
        return;
    L36:
        return;
    L22:
        if (TextUtils.isEmpty(r102) == true) goto L27;
        if (r104.equals(com.baidu.mshield.b.f.e.a(r102)) == true) goto L38;
        r100.e(true);     // Catch: Throwable -> L30
        r100.o("");     // Catch: Throwable -> L30
        r100.n(com.baidu.mshield.b.f.e.a(r102));     // Catch: Throwable -> L30
        return;
    L38:
        return;
    L27:
        if (TextUtils.isEmpty(r103) == true) goto L40;
        r100.e(true);     // Catch: Throwable -> L30
        r100.o("");     // Catch: Throwable -> L30
        r100.n("");     // Catch: Throwable -> L30
        return;
    L40:
        return;
    L30:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }

    public d(Context r100) {
        this.f32586a = r100;
    }
}
