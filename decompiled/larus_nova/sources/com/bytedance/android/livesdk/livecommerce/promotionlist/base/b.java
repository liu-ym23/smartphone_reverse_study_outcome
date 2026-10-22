package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import com.bytedance.android.ec.core.async.DisposableScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements com.bytedance.android.ec.core.async.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f150895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f150896b;

    public b() {
        this(0);
    }

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.f150896b.add(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void clearDisposable() {
        this.f150896b.clearDisposable();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final CompositeDisposable compositeDisposable() {
        return this.f150896b.compositeDisposable();
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f150896b.remove(r100);
    }

    public void a() {
        clearDisposable();
    }

    public b(int r100) {
        DisposableScope r101 = new DisposableScope();
        Intrinsics.checkNotNullParameter(r101, "disposableScope");
        this.f150896b = r101;
    }
}
