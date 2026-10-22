package com.bytedance.android.live.liveinteract.api.utils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f71529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f71530b;

    public final void b() {
        if (((Boolean) vm2.d.f555906n.getValue(null, vm2.d.f555776a[12])).booleanValue() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.pushstream.d r100 = this.f71530b;
        if (r100 != null) goto L8;
    L15:
        Disposable r101 = this.f71529a;
        if (r101 == null) goto L18;
        r101.dispose();
    L18:
        this.f71529a = null;
        return;
    L8:
        if (r100.A() == null) goto L15;
        d0 r102 = this.f71530b.A();
        if (r102 == null) goto L12;
        r102.c0();
    L12:
        d0 r103 = this.f71530b.A();
        if (r103 == null) goto L15;
        r103.c0();
        goto L15
    }

    public p(com.bytedance.android.live.pushstream.d r100) {
        this.f71530b = r100;
    }

    public final void a(long r100) {
        if (((Boolean) vm2.d.f555906n.getValue(null, vm2.d.f555776a[12])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f71530b != null) goto L8;
        return;
    L8:
        b();
        this.f71529a = Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(new o(this, r100));
    }
}
