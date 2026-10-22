package com.bytedance.android.gamecp.business.instantplay;

import com.bytedance.android.gamecp.host_api.im.InteractionPlayToastScene;
import com.bytedance.android.gamecp.host_api.im.LiveImType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f56118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f56119b = null;

    static {
        int[] r100 = new int[LiveImType.values().length];
        f56118a = r100;
        r100[LiveImType.INTERACTION_PLAY_OPEN_CLOUD_GAME_MESSAGE.ordinal()] = 1;
        r100[LiveImType.TEAM_PLAY_DEBUG_ENTRANCE_MESSAGE.ordinal()] = 2;
        r100[LiveImType.INTERACTION_PLAY_AUTH_MESSAGE.ordinal()] = 3;
        r100[LiveImType.INTERACTION_PLAY_TOAST_MESSAGE.ordinal()] = 4;
        r100[LiveImType.TEAM_PLAY_APPLY_PERMIT_MESSAGE.ordinal()] = 5;
        r100[LiveImType.INTERACTION_PLAY_BAN_MESSAGE.ordinal()] = 6;
        int[] r101 = new int[InteractionPlayToastScene.values().length];
        f56119b = r101;
        r101[InteractionPlayToastScene.InteractionPlayDefaultToast.ordinal()] = 1;
        r101[InteractionPlayToastScene.InteractionPlayMinorHealthToast.ordinal()] = 2;
        r101[InteractionPlayToastScene.InteractionPlayAppNotSupportToast.ordinal()] = 3;
    }
}
