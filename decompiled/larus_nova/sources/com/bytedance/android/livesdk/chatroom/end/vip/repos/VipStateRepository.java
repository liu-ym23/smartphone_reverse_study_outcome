package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class VipStateRepository implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f106152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f106153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f106154c;

    public static final class a {
    }

    static {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f106153b = true;
        this.f106152a.clear();
    }

    public VipStateRepository() {
        this.f106152a = new CompositeDisposable();
        this.f106154c = LazyKt.lazy(VipStateRepository$vipStatusObservable$2.INSTANCE);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f106153b;
    }
}
