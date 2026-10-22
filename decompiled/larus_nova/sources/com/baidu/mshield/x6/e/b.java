package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x6.EngineImpl;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f32580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.baidu.mshield.x6.b.b f32581b;

    public void a() {
        String r100 = this.f32581b.r();     // Catch: Throwable -> L16
        String r101 = EngineImpl.getInstance(this.f32580a).getPropertyByType("arid");     // Catch: Throwable -> L16
        TextUtils.isEmpty("");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "";
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        String r102 = com.baidu.mshield.b.f.e.a("" + r101);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r102) == true) goto L14;
        this.f32581b.c(r102);     // Catch: Throwable -> L16
    L14:
        this.f32581b.c(true);     // Catch: Throwable -> L16
        return;
    L11:
        String r103 = com.baidu.mshield.b.f.e.a("" + r101);     // Catch: Throwable -> L16
        if (TextUtils.equals(r100, r103) == true) goto L14;
        this.f32581b.c(r103);     // Catch: Throwable -> L16
        h.a(this.f32580a).a(3, true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }

    public b(Context r100) {
        this.f32580a = r100;
        this.f32581b = new com.baidu.mshield.x6.b.b(r100);
    }
}
