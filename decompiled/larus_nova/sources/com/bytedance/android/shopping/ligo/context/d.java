package com.bytedance.android.shopping.ligo.context;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f176457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f176458b = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f176457a = r100;
        r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
        int[] r101 = new int[Lifecycle.Event.values().length];
        f176458b = r101;
        r101[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r101[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
    }
}
