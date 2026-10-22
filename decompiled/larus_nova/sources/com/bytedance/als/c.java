package com.bytedance.als;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f38088a = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f38088a = r100;
        r100[Lifecycle.State.CREATED.ordinal()] = 1;
        r100[Lifecycle.State.STARTED.ordinal()] = 2;
        r100[Lifecycle.State.RESUMED.ordinal()] = 3;
        r100[Lifecycle.State.DESTROYED.ordinal()] = 4;
    }
}
