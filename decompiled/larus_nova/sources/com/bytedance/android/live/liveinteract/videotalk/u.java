package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rj0.b f79760a;

    public u(rj0.b r100) {
        this.f79760a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f79760a.onFailed(r100);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        this.f79760a.onSuccess();
    }
}
