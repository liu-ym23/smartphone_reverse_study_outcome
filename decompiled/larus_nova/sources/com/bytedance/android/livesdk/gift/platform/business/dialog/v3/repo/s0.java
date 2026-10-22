package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTouchPositionsStr;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class s0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f128520a;

    public s0(v0 r100) {
        this.f128520a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TouchPositionData r101 = (TouchPositionData) r100;
        if (r101 == null) goto L8;
        String r102 = r101.getTouchPositionsStr();
        if (r102 == null) goto L9;
        this.f128520a.f128553c.a(new UpdateTouchPositionsStr(r102));
        this.f128520a.f128553c.a(new LynxTouchViewVisibleChange(true, r101.getNeedShowTopDetail()));
        return;
    L9:
        return;
    }
}
