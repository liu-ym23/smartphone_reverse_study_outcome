package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f93622a = null;

    static {
        int[] r100 = new int[PlayMode.values().length];
        PlayMode r101 = PlayMode.PERSONAL_PK;
        r100[r101.ordinal()] = 1;
        PlayMode r102 = PlayMode.TEAM_PK;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[PlayMode.values().length];
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        int[] r104 = new int[PlayMode.values().length];
        f93622a = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
    }
}
