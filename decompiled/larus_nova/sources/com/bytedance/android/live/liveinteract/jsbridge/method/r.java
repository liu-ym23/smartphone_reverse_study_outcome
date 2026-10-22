package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GiftMessageBoardLinkmicResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f74245a;

    public r(q r100) {
        this.f74245a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((jd0.b) r100).f498192a == false) goto L5;
        q r101 = this.f74245a;
        GiftMessageBoardLinkmicResultModel r102 = new GiftMessageBoardLinkmicResultModel();
        r102.a(GiftMessageBoardLinkmicResultModel.Code.Success);
        Unit r103 = Unit.INSTANCE;
        r101.finishWithResult(r102);
        return;
    L5:
        q r104 = this.f74245a;
        GiftMessageBoardLinkmicResultModel r105 = new GiftMessageBoardLinkmicResultModel();
        r105.a(GiftMessageBoardLinkmicResultModel.Code.Failed);
        Unit r106 = Unit.INSTANCE;
        r104.finishWithResult(r105);
    }
}
