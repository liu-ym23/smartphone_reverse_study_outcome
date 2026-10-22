package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f127819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f127820b = null;

    static {
        int[] r100 = new int[SelectedStatus.values().length];
        f127819a = r100;
        r100[SelectedStatus.GROUP.ordinal()] = 1;
        r100[SelectedStatus.CLICK.ordinal()] = 2;
        r100[SelectedStatus.LOCATE.ordinal()] = 3;
        int[] r101 = new int[ItemStatus.values().length];
        f127820b = r101;
        r101[ItemStatus.SELECTED.ordinal()] = 1;
        r101[ItemStatus.IDLE.ordinal()] = 2;
        r101[ItemStatus.GONE.ordinal()] = 3;
    }
}
