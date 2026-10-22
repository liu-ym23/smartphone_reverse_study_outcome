package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes45.dex */
public final class a5 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w4 f63288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetMessageBoardDataResultModel f63289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f63290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.p9 f63291d;

    public a5(w4 r100, GetMessageBoardDataResultModel r101, long r102, w20.p9 r103) {
        this.f63288a = r100;
        this.f63289b = r101;
        this.f63290c = r102;
        this.f63291d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f63288a.finishWithResult(this.f63289b);
        w4.k(this.f63288a, this.f63290c, this.f63291d.b(), this.f63288a.f63699a);
    }
}
