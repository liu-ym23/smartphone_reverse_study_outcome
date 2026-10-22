package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f142197a;

    public g(e r100) {
        this.f142197a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SelectMediaResultModel r101 = new SelectMediaResultModel();
        r101.a(SelectMediaResultModel.Code.Success);
        SelectMediaResultModel.a r102 = new SelectMediaResultModel.a();
        r101.b(r102);
        r102.a((List) r100);
        this.f142197a.finishWithResult(r101);
    }
}
