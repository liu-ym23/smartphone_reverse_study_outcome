package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private br f26542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26543c;

    public final byte[] a() {
        return bs.a(a(this.f26541a, this.f26542b, this.f26543c));
    }

    private static String a(Context r100, br r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append("\"sdkversion\":\"");     // Catch: Throwable -> L5
        r103.append(r101.d());     // Catch: Throwable -> L5
        r103.append("\",\"product\":\"");     // Catch: Throwable -> L5
        r103.append(r101.b());     // Catch: Throwable -> L5
        r103.append("\",\"nt\":\"");     // Catch: Throwable -> L5
        r103.append(bm.d(r100));     // Catch: Throwable -> L5
        r103.append("\",\"details\":");     // Catch: Throwable -> L5
        r103.append(r102);     // Catch: Throwable -> L5
    L8:
        return r103.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }
}
