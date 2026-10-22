package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class y implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.h f77153a;

    public y(com.bytedance.android.live.liveinteract.jsbridge.method.j r100) {
        this.f77153a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        ALogger.i("PermissionUtils", "checkPermission onFailure, " + r100);
        this.f77153a.a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        ALogger.i("PermissionUtils", "checkPermission onResult");
        this.f77153a.a(UpdateLinkmicStatusResultModel.Code.Success, "checkPermission success", null);
    }
}
