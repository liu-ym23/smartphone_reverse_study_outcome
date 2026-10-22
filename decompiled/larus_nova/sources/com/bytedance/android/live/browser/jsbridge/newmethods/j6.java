package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveHighlightTranscodingResultModel;
import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class j6 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightTranscodingResultModel f63467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f63468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n6 f63469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.ua f63470d;

    public j6(LiveHighlightTranscodingResultModel r100, List r101, n6 r102, w20.ua r103) {
        this.f63467a = r100;
        this.f63468b = r101;
        this.f63469c = r102;
        this.f63470d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        n6 r100 = this.f63469c;
        w20.ua r101 = this.f63470d;
        String r102 = r100.f63565a;
        if (r102 == null) goto L5;
        TTExecutors.getNormalExecutor().submit(new h6(r102, r101));
    L5:
        this.f63467a.a(LiveHighlightTranscodingResultModel.Code.Success);
        LiveHighlightTranscodingResultModel r103 = this.f63467a;
        LiveHighlightTranscodingResultModel.a r104 = new LiveHighlightTranscodingResultModel.a();
        r104.a(this.f63468b);
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        this.f63469c.finishWithResult(this.f63467a);
    }
}
