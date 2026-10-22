package com.bytedance.android.live.room.util;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f100389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f100390b = null;

    static {
        int[] r100 = new int[AudienceViewInfo.values().length];
        f100389a = r100;
        AudienceViewInfo r101 = AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE;
        r100[r101.ordinal()] = 1;
        AudienceViewInfo r102 = AudienceViewInfo.TTLIVE_VIEW_AUDIENCE_LIST_ITEM;
        r100[r102.ordinal()] = 2;
        AudienceViewInfo r103 = AudienceViewInfo.TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[AudienceViewInfo.values().length];
        f100390b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
