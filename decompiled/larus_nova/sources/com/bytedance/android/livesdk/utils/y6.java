package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.util.IVBoostHelper;

/* JADX INFO: loaded from: classes11.dex */
public final class y6 implements IVBoostHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y6 f159224a = null;

    public y6() {
    }

    static {
        f159224a = new y6();
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final int getTimeoutEnterRoomClick() {
        return com.bytedance.android.livesdk.k3.f142264a.getValue().mTimeoutEnterRoomClick;
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final int getTimeoutEnterRoomDraw() {
        return com.bytedance.android.livesdk.k3.f142264a.getValue().mTimeoutEnterRoomDraw;
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final int getTimeoutOpenCommerceList() {
        return com.bytedance.android.livesdk.k3.f142264a.getValue().mTimeoutOpenCommerceList;
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final int getTimeoutOpenGiftDialog() {
        return com.bytedance.android.livesdk.k3.f142264a.getValue().mTimeoutOpenGiftDialog;
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final boolean isEnable() {
        return com.bytedance.android.livesdk.k3.f142264a.getValue().mEnable;
    }

    @Override // com.bytedance.android.livesdkapi.util.IVBoostHelper
    public final void startVBoost(int r100, int r101) {
        cu2.c.a(r100, r101);
    }
}
