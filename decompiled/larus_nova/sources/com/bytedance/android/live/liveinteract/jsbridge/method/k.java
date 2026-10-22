package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements my.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f74227a;

    public k(l r100) {
        this.f74227a = r100;
    }

    @Override // my.d
    public final void a(int r100, String r110, JsonObject r111) {
        Intrinsics.checkNotNullParameter(r110, "errMsg");
        l r101 = this.f74227a;
        UpdateLinkmicStatusResultModel r102 = new UpdateLinkmicStatusResultModel();
        this.f74227a.getClass();
        UpdateLinkmicStatusResultModel.Code[] r103 = UpdateLinkmicStatusResultModel.Code.values();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        UpdateLinkmicStatusResultModel.Code r106 = r103[r105];
        if (r106.getValue() != r100) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L12;
        r105 = r105 + 1;
    L12:
        if (r106 != null) goto L14;
        r106 = UpdateLinkmicStatusResultModel.Code.Failed;
    L14:
        r102.a(r106);
        r102.c(r110);
        r102.b(r111);
        Unit r108 = Unit.INSTANCE;
        r101.finishWithResult(r102);
        return;
    L7:
        r107 = false;
        goto L8
    L11:
        r106 = null;
        goto L12
    }
}
