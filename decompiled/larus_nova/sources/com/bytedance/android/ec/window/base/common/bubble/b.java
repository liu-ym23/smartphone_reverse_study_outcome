package com.bytedance.android.ec.window.base.common.bubble;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f49118a = null;

    static {
        int[] r100 = new int[WindowBubbleShowStrategy.values().length];
        f49118a = r100;
        r100[WindowBubbleShowStrategy.ONLY_ONE_ONCE.ordinal()] = 1;
        r100[WindowBubbleShowStrategy.ONE_BY_ONE.ordinal()] = 2;
        r100[WindowBubbleShowStrategy.ALL_ONCE.ordinal()] = 3;
    }
}
