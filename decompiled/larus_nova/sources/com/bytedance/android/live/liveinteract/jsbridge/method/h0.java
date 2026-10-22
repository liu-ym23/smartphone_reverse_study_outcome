package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendGiftPlayerEventResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.z9;

/* JADX INFO: loaded from: classes46.dex */
public final class h0 implements oh0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f74222a;

    public h0(i0 r100) {
        this.f74222a = r100;
    }

    @Override // oh0.a
    public final void a(z9 r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "errCode");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        SendGiftPlayerEventResultModel r103 = new SendGiftPlayerEventResultModel();
        if (r100.getCode() != 1) goto L5;
        SendGiftPlayerEventResultModel.Code r104 = SendGiftPlayerEventResultModel.Code.Success;
    L6:
        r103.a(r104);
        r103.c(r101);
        r103.b(r102);
        this.f74222a.finishWithResult(r103);
        return;
    L5:
        r104 = SendGiftPlayerEventResultModel.Code.Failed;
        goto L6
    }
}
