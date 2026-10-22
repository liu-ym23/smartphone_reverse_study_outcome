package com.bytedance.android.ec.store.common.bubble;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f48214a = null;

    static {
        int[] r100 = new int[BubbleShowStrategy.values().length];
        f48214a = r100;
        r100[BubbleShowStrategy.ONLY_ONE_ONCE.ordinal()] = 1;
        r100[BubbleShowStrategy.ONE_BY_ONE.ordinal()] = 2;
        r100[BubbleShowStrategy.ALL_ONCE.ordinal()] = 3;
    }
}
