package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f180823b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f180824c = null;

    static {
        int[] r100 = new int[androidx.lifecycle.Lifecycle.State.values().length];
        f180822a = r100;
        r100[androidx.lifecycle.Lifecycle.State.DESTROYED.ordinal()] = 1;
        r100[androidx.lifecycle.Lifecycle.State.INITIALIZED.ordinal()] = 2;
        r100[androidx.lifecycle.Lifecycle.State.CREATED.ordinal()] = 3;
        r100[androidx.lifecycle.Lifecycle.State.STARTED.ordinal()] = 4;
        r100[androidx.lifecycle.Lifecycle.State.RESUMED.ordinal()] = 5;
        int[] r101 = new int[androidx.lifecycle.Lifecycle.Event.values().length];
        f180823b = r101;
        r101[androidx.lifecycle.Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r101[androidx.lifecycle.Lifecycle.Event.ON_START.ordinal()] = 2;
        r101[androidx.lifecycle.Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r101[androidx.lifecycle.Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r101[androidx.lifecycle.Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r101[androidx.lifecycle.Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r101[androidx.lifecycle.Lifecycle.Event.ON_ANY.ordinal()] = 7;
        int[] r102 = new int[Lifecycle.Event.values().length];
        f180824c = r102;
        r102[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r102[Lifecycle.Event.ON_START.ordinal()] = 2;
        r102[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r102[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r102[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r102[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r102[Lifecycle.Event.ON_ANY.ordinal()] = 7;
    }
}
