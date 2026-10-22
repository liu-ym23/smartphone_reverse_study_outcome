package com.bytedance.android.livesdk.revenue.service.effect;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.w3;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements IFetchEffectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f157307a;

    public l(w3 r100) {
        this.f157307a = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        this.f157307a.onStart();
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f157307a.a(new i(r101));
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        e r102 = this.f157307a;
        r101.getMsg();
        r102.onFail();
    }
}
