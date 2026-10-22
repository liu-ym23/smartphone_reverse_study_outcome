package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f76993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f76994b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f76993a = r100;
        r100[DynamicUpdateType.ROOM_BATTLE.ordinal()] = 1;
        r100[DynamicUpdateType.TEAM_FIGHT.ordinal()] = 2;
        int[] r101 = new int[DynamicGetType.values().length];
        f76994b = r101;
        r101[DynamicGetType.TEAM_FIGHT.ordinal()] = 1;
        r101[DynamicGetType.CREATE_CHECK.ordinal()] = 2;
    }
}
