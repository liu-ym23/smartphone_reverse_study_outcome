package com.bytedance.android.live.room.report;

import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f100243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f100244b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f100245c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f100246d = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f100243a = r100;
        LiveMode r101 = LiveMode.AUDIO;
        r100[r101.ordinal()] = 1;
        LiveMode r102 = LiveMode.THIRD_PARTY;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[ReportObject.values().length];
        f100244b = r103;
        r103[ReportObject.DHXT_Link_OR_PK.ordinal()] = 1;
        r103[ReportObject.XT_Anchor_OR_XT_No_Link_PK.ordinal()] = 2;
        r103[ReportObject.DH_Anchor.ordinal()] = 3;
        r103[ReportObject.Comment.ordinal()] = 4;
        r103[ReportObject.ChannelLink.ordinal()] = 5;
        r103[ReportObject.PPX.ordinal()] = 6;
        r103[ReportObject.XT.ordinal()] = 7;
        r103[ReportObject.Hotsoon_Or_Vigo.ordinal()] = 8;
        r103[ReportObject.User.ordinal()] = 9;
        int[] r104 = new int[LiveMode.values().length];
        f100245c = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        int[] r105 = new int[LiveMode.values().length];
        f100246d = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
    }
}
