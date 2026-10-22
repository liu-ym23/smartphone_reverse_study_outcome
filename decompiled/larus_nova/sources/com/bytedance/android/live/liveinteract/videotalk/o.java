package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lg6.a f79466a;

    public o(lh6.b.C6695b r100) {
        this.f79466a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        lg6.a r101 = this.f79466a;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        lg6.a r101 = this.f79466a;
        if (r101 == null) goto L6;
        r101.a(Unit.INSTANCE);
        return;
    }
}
