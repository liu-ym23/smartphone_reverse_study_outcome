package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f181101a = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f181101a = r100;
        r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r100[Lifecycle.Event.ON_START.ordinal()] = 2;
        r100[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r100[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r100[Lifecycle.Event.ON_ANY.ordinal()] = 7;
    }
}
