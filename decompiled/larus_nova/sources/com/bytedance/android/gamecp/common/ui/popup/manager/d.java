package com.bytedance.android.gamecp.common.ui.popup.manager;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f57045a = null;

    static {
        int[] r100 = new int[LivePopupInfo.State.values().length];
        f57045a = r100;
        r100[LivePopupInfo.State.SHOWING.ordinal()] = 1;
        r100[LivePopupInfo.State.WAITING.ordinal()] = 2;
        r100[LivePopupInfo.State.DISMISSED.ordinal()] = 3;
    }
}
