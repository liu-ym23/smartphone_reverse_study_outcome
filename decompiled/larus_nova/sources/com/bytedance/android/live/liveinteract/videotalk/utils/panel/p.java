package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.h f79870a;

    public p(ih0.h r100) {
        this.f79870a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ih0.h r101 = this.f79870a;
        UpdateLinkmicStatusResultModel.Code r102 = UpdateLinkmicStatusResultModel.Code.Success;
        r101.a(r102, "", (JsonObject) r100);
    }
}
