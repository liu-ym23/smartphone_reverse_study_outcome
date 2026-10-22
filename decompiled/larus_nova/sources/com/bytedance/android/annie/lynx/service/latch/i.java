package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements a.InterfaceC0735a, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ex.a.b f39574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ex.a.b f39575b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f39574a.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f39574a.isDisposed();
    }

    @Override // com.bytedance.android.annie.lynx.service.latch.a.InterfaceC0735a
    public final List<com.bytedance.android.latch.a.c> a() {
        return this.f39575b.a();
    }

    public i(ex.a.b r100) {
        this.f39575b = r100;
        this.f39574a = r100;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService.e
    public final void f(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "jsBridge2");
        this.f39575b.f(r100);
    }
}
