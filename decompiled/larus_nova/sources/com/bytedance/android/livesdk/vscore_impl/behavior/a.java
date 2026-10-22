package com.bytedance.android.livesdk.vscore_impl.behavior;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements vr1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f159524a;

    public final void b() {
        this.f159524a.f159537m = true;
    }

    public a(b r100) {
        this.f159524a = r100;
    }

    @Override // vr1.a
    public final void a(Disposable r100) {
        RxUtilKt.c(r100, this.f159524a.f159536l);
    }
}
