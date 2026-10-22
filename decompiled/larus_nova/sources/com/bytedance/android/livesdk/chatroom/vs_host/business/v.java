package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f118283a = null;

    static {
        int[] r100 = new int[VsLiveShareType.values().length];
        f118283a = r100;
        r100[VsLiveShareType.SHARE_IM.ordinal()] = 1;
        r100[VsLiveShareType.SHARE_THIRD.ordinal()] = 2;
        r100[VsLiveShareType.SHARE_DIALOG.ordinal()] = 3;
        r100[VsLiveShareType.SHARE_ACTIVITY.ordinal()] = 4;
        r100[VsLiveShareType.SHARE_VIDEO2FANSGROUP.ordinal()] = 5;
        r100[VsLiveShareType.SHARE_TEXT2FANSGROUP.ordinal()] = 6;
        r100[VsLiveShareType.REPORT_DIALOG.ordinal()] = 7;
    }
}
