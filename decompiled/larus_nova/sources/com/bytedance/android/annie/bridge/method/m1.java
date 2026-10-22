package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class m1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f38728a;

    public m1(n1 r100) {
        this.f38728a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        n1 r101 = this.f38728a;
        PreloadResourceResultModel r102 = new PreloadResourceResultModel();
        r102.a(PreloadResourceResultModel.Code.Failed);
        r102.b(((Throwable) r100).getMessage());
        r101.finishWithResult(r102);
    }
}
