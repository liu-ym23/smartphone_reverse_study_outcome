package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements IFetchEffectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f59622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f59623b;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "effect");
        com.bytedance.android.live.effect.sticker.d.c(r101).subscribe(new d(this));
    }

    public e(c.a r100, String r101) {
        this.f59622a = r100;
        this.f59623b = r101;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f59622a.b(this.f59623b, r101);
    }
}
