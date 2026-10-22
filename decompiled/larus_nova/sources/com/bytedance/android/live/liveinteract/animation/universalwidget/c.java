package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f71324a;

    public c(Function0 r100) {
        this.f71324a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        ALogger.d("MultiLinkEffect.Widget", "check failed, exception: " + r100.getDetailMessage());
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        ALogger.d("MultiLinkEffect.Widget", "check success");
        this.f71324a.invoke();
    }
}
