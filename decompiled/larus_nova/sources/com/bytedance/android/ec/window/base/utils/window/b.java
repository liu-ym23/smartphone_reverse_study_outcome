package com.bytedance.android.ec.window.base.utils.window;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f49791a = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f49791a = r100;
        r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r100[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
    }
}
