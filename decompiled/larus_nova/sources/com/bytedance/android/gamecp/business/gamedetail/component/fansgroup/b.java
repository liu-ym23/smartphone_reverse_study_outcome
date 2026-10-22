package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import com.bytedance.android.gamecp.business.gamedetail.base.model.GroupJoinStatus;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f54316a = null;

    static {
        int[] r100 = new int[GroupJoinStatus.values().length];
        GroupJoinStatus r101 = GroupJoinStatus.JOIN_NOW;
        r100[r101.ordinal()] = 1;
        GroupJoinStatus r102 = GroupJoinStatus.APPLY_TO_JOIN;
        r100[r102.ordinal()] = 2;
        GroupJoinStatus r103 = GroupJoinStatus.NOT_APPLY;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[GroupJoinStatus.values().length];
        f54316a = r104;
        r104[r103.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r101.ordinal()] = 3;
        r104[GroupJoinStatus.VIEW_CONDITIONS.ordinal()] = 4;
    }
}
