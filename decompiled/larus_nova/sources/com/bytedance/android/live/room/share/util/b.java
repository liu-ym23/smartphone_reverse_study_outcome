package com.bytedance.android.live.room.share.util;

import com.bytedance.android.live.room.api.share.model.LiveShareType;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f100377a = null;

    static {
        int[] r100 = new int[LiveShareType.values().length];
        f100377a = r100;
        r100[LiveShareType.SHARE_IM.ordinal()] = 1;
        r100[LiveShareType.SHARE_THIRD.ordinal()] = 2;
        r100[LiveShareType.SHARE_DIRECT.ordinal()] = 3;
        r100[LiveShareType.SHARE_DIALOG.ordinal()] = 4;
        r100[LiveShareType.SHARE_ACTIVITY.ordinal()] = 5;
        r100[LiveShareType.SHARE_VIDEO2FANSGROUP.ordinal()] = 6;
        r100[LiveShareType.SHARE_TEXT2FANSGROUP.ordinal()] = 7;
        r100[LiveShareType.REPORT_DIALOG.ordinal()] = 8;
    }
}
