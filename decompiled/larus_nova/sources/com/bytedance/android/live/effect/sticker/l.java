package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements IFetchEffectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f68209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f68210b;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        if (r101 != null) goto L5;
        PthreadHandlerThreadV2 r102 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.h();
        this.f68209a.a();
        return;
    L5:
        k r103 = this.f68209a;
        r103.f68204d.put(r101.getEffect_id(), r101);
        r103.a();
    }

    public l(k r100, long r101) {
        this.f68209a = r100;
        this.f68210b = r101;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        ALogger.d("ttlive_anchor_effect_MultiAnchorEffectHelper", "download failed,effectID:" + this.f68210b);
        PthreadHandlerThreadV2 r102 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.h();
        this.f68209a.a();
    }
}
