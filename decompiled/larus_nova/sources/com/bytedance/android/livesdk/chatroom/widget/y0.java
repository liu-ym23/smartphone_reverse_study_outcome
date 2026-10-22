package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.nova.R;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class y0 implements SingleObserver<i81.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f119261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f119262b;

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_share_failed, 0);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        this.f119262b.f119285s.add(r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(i81.b r100) {
        z0 r101 = this.f119262b;
        r101.f119282p = true;
        r101.f119283q = this.f119261a;
    }

    public y0(z0 r100, int r101) {
        this.f119262b = r100;
        this.f119261a = r101;
    }
}
