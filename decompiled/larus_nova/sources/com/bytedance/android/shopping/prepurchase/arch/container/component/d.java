package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180764a = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f180764a = r100;
        r100[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        r100[Lifecycle.State.CREATED.ordinal()] = 2;
        r100[Lifecycle.State.STARTED.ordinal()] = 3;
        r100[Lifecycle.State.RESUMED.ordinal()] = 4;
        r100[Lifecycle.State.DESTROYED.ordinal()] = 5;
    }
}
