package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateViewInLiveBgResultModel;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l0 implements ih0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f74234a;

    public l0(m0 r100) {
        this.f74234a = r100;
    }

    @Override // ih0.h
    public final void a(UpdateLinkmicStatusResultModel.Code r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "errCode");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        LiveUpdateViewInLiveBgResultModel r103 = new LiveUpdateViewInLiveBgResultModel();
        if (r100 != UpdateLinkmicStatusResultModel.Code.Success) goto L5;
        LiveUpdateViewInLiveBgResultModel.Code r104 = LiveUpdateViewInLiveBgResultModel.Code.Success;
    L6:
        r103.a(r104);
        r103.c(r101);
        r103.b(r102);
        this.f74234a.finishWithResult(r103);
        return;
    L5:
        r104 = LiveUpdateViewInLiveBgResultModel.Code.Failed;
        goto L6
    }
}
