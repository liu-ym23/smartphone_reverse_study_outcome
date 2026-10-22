package com.bytedance.android.live.revlink.impl.pk.ui;

import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.IGroupRivals;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f97053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f97054b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f97055c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f97056d = null;

    static {
        int[] r100 = new int[IGroupRivals.GroupType.values().length];
        f97053a = r100;
        IGroupRivals.GroupType r101 = IGroupRivals.GroupType.GroupRivalsSearchPopularityRank;
        r100[r101.ordinal()] = 1;
        IGroupRivals.GroupType r102 = IGroupRivals.GroupType.GroupRivalsSearchHourlyRank;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[IGroupRivals.GroupType.values().length];
        f97054b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        int[] r104 = new int[IGroupRivals.GroupType.values().length];
        f97055c = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        int[] r105 = new int[SearchSourceFlag.values().length];
        f97056d = r105;
        r105[SearchSourceFlag.INVITE_LINKING.ordinal()] = 1;
        r105[SearchSourceFlag.MAIN_LINK.ordinal()] = 2;
    }
}
