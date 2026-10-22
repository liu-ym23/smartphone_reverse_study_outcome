package com.bytedance.android.livesdk.popup.manager;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f156304a = null;

    static {
        int[] r100 = new int[LivePopupInfo.State.values().length];
        f156304a = r100;
        r100[LivePopupInfo.State.SHOWING.ordinal()] = 1;
        r100[LivePopupInfo.State.WAITING.ordinal()] = 2;
        r100[LivePopupInfo.State.DISMISSED.ordinal()] = 3;
    }
}
