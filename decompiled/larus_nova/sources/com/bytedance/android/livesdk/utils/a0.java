package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.model.BackendItem;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observable<BackendItem> f158810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableEmitter<BackendItem> f158811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f158812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f158813d;

    public a0() {
        this.f158810a = Observable.create(new y(this)).publish().autoConnect(0, new z(this));
        this.f158813d = false;
    }
}
