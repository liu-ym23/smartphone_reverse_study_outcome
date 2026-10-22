package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.AnimMoveType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f129006a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f129007b = null;

    static {
        int[] r100 = new int[AnimMoveType.values().length];
        f129006a = r100;
        AnimMoveType r101 = AnimMoveType.Left;
        r100[r101.ordinal()] = 1;
        AnimMoveType r102 = AnimMoveType.Right;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[AnimMoveType.values().length];
        f129007b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
