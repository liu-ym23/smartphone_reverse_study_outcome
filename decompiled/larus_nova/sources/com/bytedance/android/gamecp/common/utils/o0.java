package com.bytedance.android.gamecp.common.utils;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f57250a = null;

    static {
        int[] r100 = new int[OpenMobileGameUtil.GameStatus.values().length];
        f57250a = r100;
        r100[OpenMobileGameUtil.GameStatus.GAME_STATUS_INSTALLED.ordinal()] = 1;
        r100[OpenMobileGameUtil.GameStatus.GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN.ordinal()] = 2;
        r100[OpenMobileGameUtil.GameStatus.GAME_STATUS_UNINSTALL.ordinal()] = 3;
        r100[OpenMobileGameUtil.GameStatus.GAME_STATUS_CONSIDER_OPEN_FAIL.ordinal()] = 4;
    }
}
