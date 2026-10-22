package com.baidu.vi;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class VIContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f33583a;

    public VIContext() {
    }

    public static Context getContext() {
        return f33583a;
    }

    public static void init(Context r100) {
        f33583a = r100;
    }
}
