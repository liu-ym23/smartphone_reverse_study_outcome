package com.bytedance.android.live.livepkaudience.widget;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements qh0.d<rh0.a> {
    public c() {
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        if (r100.getCheckType() != BaseCheckException.CheckType.ServerPermission) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = b6.f65226c;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, 2);
        return;
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
    }
}
