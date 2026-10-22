package com.bytedance.android.live.effect.sticker.ui;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements IFetchEffectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f68585a;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
    }

    public h(Function1 r100) {
        this.f68585a = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        if (r101 == null) goto L5;
        this.f68585a.invoke(com.bytedance.android.live.effect.sticker.d.b(r101));
        return;
    L5:
        Unit r102 = (Unit) this.f68585a.invoke(null);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f68585a.invoke(null);
    }
}
