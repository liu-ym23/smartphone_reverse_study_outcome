package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f142598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f142599b = null;

    static {
        int[] r100 = new int[IMusicControlNode.OperationType.values().length];
        f142598a = r100;
        IMusicControlNode.OperationType r101 = IMusicControlNode.OperationType.ADD_MUSIC;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[IMusicControlNode.OperationType.values().length];
        f142599b = r102;
        r102[r101.ordinal()] = 1;
    }
}
