package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes7.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f106101a;

    public interface a {
        void Ql(IFollowPair r100);

        void Ym(Throwable r100);
    }

    public q() {
        this.f106101a = new CompositeDisposable();
    }
}
