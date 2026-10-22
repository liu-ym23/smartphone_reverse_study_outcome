package com.alipay.sdk.m.a0;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f25221a;

    static {
        f25221a = new a();
    }

    public a() {
    }

    public static a a() {
        return f25221a;
    }

    public static String a(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 16).versionName;
    L4:
        return "0.0.0";
    }
}
