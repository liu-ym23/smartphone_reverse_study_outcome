package com.bytedance.android.livesdk.chatroom.ui.framework.base;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f112908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f112909b = null;

    static {
        int[] r100 = new int[IComponentScheduler.LoadMode.values().length];
        f112908a = r100;
        IComponentScheduler.LoadMode r101 = IComponentScheduler.LoadMode.DIRECT;
        r100[r101.ordinal()] = 1;
        IComponentScheduler.LoadMode r102 = IComponentScheduler.LoadMode.PREVIEW;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[IComponentScheduler.LoadMode.values().length];
        f112909b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
