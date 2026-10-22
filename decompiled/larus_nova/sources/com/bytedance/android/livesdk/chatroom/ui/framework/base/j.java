package com.bytedance.android.livesdk.chatroom.ui.framework.base;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f112915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f112916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f112917c = null;

    static {
        int[] r100 = new int[IComponentScheduler.LoadBatch.values().length];
        f112915a = r100;
        IComponentScheduler.LoadBatch r101 = IComponentScheduler.LoadBatch.FIRST_SCREEN;
        r100[r101.ordinal()] = 1;
        IComponentScheduler.LoadBatch r102 = IComponentScheduler.LoadBatch.P0;
        r100[r102.ordinal()] = 2;
        IComponentScheduler.LoadBatch r103 = IComponentScheduler.LoadBatch.P1;
        r100[r103.ordinal()] = 3;
        IComponentScheduler.LoadBatch r104 = IComponentScheduler.LoadBatch.P2;
        r100[r104.ordinal()] = 4;
        IComponentScheduler.LoadBatch r105 = IComponentScheduler.LoadBatch.POTHER;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[IComponentScheduler.LoadBatch.values().length];
        f112916b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        int[] r107 = new int[IComponentScheduler.LoadBatch.values().length];
        f112917c = r107;
        r107[r102.ordinal()] = 1;
        r107[r103.ordinal()] = 2;
        r107[r104.ordinal()] = 3;
        r107[r105.ordinal()] = 4;
    }
}
