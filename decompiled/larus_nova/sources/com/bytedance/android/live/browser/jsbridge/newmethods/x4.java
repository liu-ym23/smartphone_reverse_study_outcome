package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes45.dex */
public final class x4 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w4 f63716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetMessageBoardDataResultModel f63717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f63718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.p9 f63719d;

    public x4(w4 r100, GetMessageBoardDataResultModel r101, long r102, w20.p9 r103) {
        this.f63716a = r100;
        this.f63717b = r101;
        this.f63718c = r102;
        this.f63719d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f63716a.finishWithResult(this.f63717b);
        w4.k(this.f63716a, this.f63718c, this.f63719d.b(), this.f63716a.f63699a);
    }
}
