package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdk.utils.f5;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class RestartLiveStateRepository implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f106146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f106147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f106148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f106149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f5 f106150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f106151f;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f106147b == false) goto L5;
        return;
    L5:
        this.f106147b = true;
        this.f106146a.clear();
    }

    public RestartLiveStateRepository() {
        this.f106146a = new CompositeDisposable();
        this.f106148c = Disposables.disposed();
        this.f106149d = "live_finish_page";
        this.f106151f = LazyKt.lazy(RestartLiveStateRepository$restartLiveStatusObservable$2.INSTANCE);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f106147b;
    }
}
