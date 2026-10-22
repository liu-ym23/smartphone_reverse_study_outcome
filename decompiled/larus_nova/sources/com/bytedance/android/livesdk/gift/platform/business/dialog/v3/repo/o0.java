package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PayGradeChange;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f128393a;

    public o0(p0 r100) {
        this.f128393a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f128393a.f128399d.a(new PayGradeChange((PayGrade) r100));
    }
}
