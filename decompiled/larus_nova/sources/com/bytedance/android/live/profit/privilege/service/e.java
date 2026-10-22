package com.bytedance.android.live.profit.privilege.service;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends b7.a {
    @Override // b7.a, b7.b
    public final void onRelease() {
        ALogger.e("PrivilegePreloadService", "card released");
    }

    public e() {
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        ALogger.w("PrivilegePreloadService", "load succeed");
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        ALogger.e("PrivilegePreloadService", "load error: code=" + r101 + ", reason=" + r102);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        ALogger.e("PrivilegePreloadService", "load error: url=" + r101 + ", reason=" + r102);
    }
}
