package com.bytedance.android.live.cloudgrouplive.rtc;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f64480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f64481b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f64482c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f64483d = null;

    static {
        int[] r100 = new int[RTSMessage.values().length];
        f64480a = r100;
        RTSMessage r101 = RTSMessage.SYNC_VIEW_DISPLAY;
        r100[r101.ordinal()] = 1;
        RTSMessage r102 = RTSMessage.UPDATE_AUDIO;
        r100[r102.ordinal()] = 2;
        RTSMessage r103 = RTSMessage.UPDATE_VIEW_DISPLAY;
        r100[r103.ordinal()] = 3;
        RTSMessage r104 = RTSMessage.TRANSFER_VIEW;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[RTSMessage.values().length];
        f64481b = r105;
        r105[r103.ordinal()] = 1;
        r105[r101.ordinal()] = 2;
        r105[r104.ordinal()] = 3;
        int[] r106 = new int[RTSMessage.values().length];
        f64482c = r106;
        r106[r104.ordinal()] = 1;
        r106[r101.ordinal()] = 2;
        int[] r107 = new int[RTSMessage.values().length];
        f64483d = r107;
        r107[r102.ordinal()] = 1;
        r107[r101.ordinal()] = 2;
    }
}
