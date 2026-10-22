package com.baidu.mshield.b.d;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f32366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f32367b;

    public String a() {
        return this.f32366a.a();
    }

    public a(Context r100, Handler r101) {
        this.f32367b = r100;     // Catch: Throwable -> L5
        this.f32366a = new b(r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    }

    public String a(String r100, byte[] r101) throws Throwable {
        if (r100 == null) goto L10;
        if (com.baidu.mshield.b.e.a.d(this.f32367b) == true) goto L8;
        return "";
    L8:
        return this.f32366a.a(r100, r101);
    L10:
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
