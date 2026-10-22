package com.bytedance.bdturing.utils;

import android.os.Build;

/* JADX INFO: compiled from: Consts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6628b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6629c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6630d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6631e = null;

    static {
        f6631e = new a();
        f6627a = Build.BRAND;
        f6628b = Build.MODEL;
        f6629c = Build.VERSION.SDK_INT;
        f6630d = Build.VERSION.RELEASE;
    }

    private a() {
    }
}
