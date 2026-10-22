package com.bytedance.android.livesdk.arch.comp;

import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103721a = null;

    static {
        int[] r100 = new int[ITbLifecycle.State.values().length];
        f103721a = r100;
        r100[ITbLifecycle.State.Initialized.ordinal()] = 1;
        r100[ITbLifecycle.State.Destroyed.ordinal()] = 2;
        r100[ITbLifecycle.State.Created.ordinal()] = 3;
        r100[ITbLifecycle.State.Started.ordinal()] = 4;
        r100[ITbLifecycle.State.Showed.ordinal()] = 5;
        r100[ITbLifecycle.State.Hidden.ordinal()] = 6;
    }
}
