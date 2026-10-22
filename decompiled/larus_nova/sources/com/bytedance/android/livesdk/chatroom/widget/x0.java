package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.nova.R;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 implements SingleObserver<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f119257a;

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(Object r100) {
    }

    public x0(z0 r100) {
        this.f119257a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_share_failed, 0);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        this.f119257a.f119285s.add(r100);
    }
}
