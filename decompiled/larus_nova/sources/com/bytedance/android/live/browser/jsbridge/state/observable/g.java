package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.subjects.PublishSubject;
import vlc.l;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f63971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f63972b;

    public g(f r100, PublishSubject r101) {
        this.f63971a = r100;
        this.f63972b = r101;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        this.f63972b.onNext(GsonProtectorUtils.toJsonTree(this.f63971a.f63967f, r100).getAsJsonObject());
    }
}
