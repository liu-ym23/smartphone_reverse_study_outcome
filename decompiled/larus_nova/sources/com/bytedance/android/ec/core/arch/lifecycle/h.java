package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f43855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f43856b = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f43855a = r100;
        Lifecycle.State r101 = Lifecycle.State.CREATED;
        r100[r101.ordinal()] = 1;
        Lifecycle.State r102 = Lifecycle.State.STARTED;
        r100[r102.ordinal()] = 2;
        Lifecycle.State r103 = Lifecycle.State.RESUMED;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[Lifecycle.State.values().length];
        f43856b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
