package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.subjects.PublishSubject;
import vlc.l;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f63938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f63939b;

    public i(h r100, PublishSubject r101) {
        this.f63938a = r100;
        this.f63939b = r101;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        this.f63939b.onNext(GsonProtectorUtils.toJsonTree(this.f63938a.f63935d, r100).getAsJsonObject());
    }
}
