package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import ju1.m;
import ju1.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r52.e4;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements iu1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<n> f123195a;

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L15
        String r101 = e4.f536174a.getValue().shortTouchTempstateResPackWishToBuy;     // Catch: Throwable -> L15
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        ju1.h r102 = mu1.b.d(r101);     // Catch: Throwable -> L15
        if (r102 != null) goto L9;
        Unit r103 = null;
    L13:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L15
    L18:
        return new m("short_touch_tempstate_redpack_user_wish_tobuy", 0);
    L9:
        if (TextUtils.equals(r102.b(), "short_touch_tempstate_redpack_user_wish_tobuy") == false) goto L11;
        return r102;
    L11:
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public d() {
        this.f123195a = new PropertyOwner(new n(0, true));
    }

    @Override // iu1.b
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f123195a.a(r100);
        StringBuilder r101 = new StringBuilder("result = ");
        Object r102 = r100.c();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        ALogger.d("EcomRedPagWishToBuyTermStateStrategy", r101.toString());
    }

    @Override // iu1.b
    public final void b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f123195a.a(r100);
    }
}
