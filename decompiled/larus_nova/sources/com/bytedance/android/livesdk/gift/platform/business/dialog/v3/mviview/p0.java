package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f127962a = null;

    static {
        int[] r100 = new int[ComboState.values().length];
        f127962a = r100;
        r100[ComboState.IDLE.ordinal()] = 1;
        r100[ComboState.ON_SINGLE_CLICK.ordinal()] = 2;
        r100[ComboState.ON_LONG_CLICK.ordinal()] = 3;
        r100[ComboState.ON_COUNT_DOWN.ordinal()] = 4;
    }
}
