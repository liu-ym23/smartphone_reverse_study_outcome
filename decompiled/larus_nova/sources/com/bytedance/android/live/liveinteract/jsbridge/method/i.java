package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements ih0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f74223a;

    public i(l r100) {
        this.f74223a = r100;
    }

    @Override // ih0.h
    public final void a(UpdateLinkmicStatusResultModel.Code r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "errCode");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        UpdateLinkmicStatusResultModel r103 = new UpdateLinkmicStatusResultModel();
        r103.a(r100);
        r103.c(r101);
        r103.b(r102);
        this.f74223a.finishWithResult(r103);
    }
}
