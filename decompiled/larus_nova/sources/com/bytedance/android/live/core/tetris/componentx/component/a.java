package com.bytedance.android.live.core.tetris.componentx.component;

import androidx.lifecycle.LifecycleObserver;
import g70.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentCenter f65528a;

    public a(ComponentCenter r100) {
        this.f65528a = r100;
    }

    @Override // g70.h.a
    public final void a(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ComponentCenter r101 = this.f65528a;
        r101.getClass();
        final d70.a r102 = ComponentCenter.l(r100);
        if (r102 == null) goto L7;
        r101.g(new ComponentCenter$onComponentUnLoadStart$1(r102));
        return;
    }

    @Override // g70.h.a
    public final void b(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ComponentCenter r101 = this.f65528a;
        r101.getClass();
        final d70.a r102 = ComponentCenter.l(r100);
        if (r102 == null) goto L7;
        r101.g(new ComponentCenter$onComponentUnLoadEnd$1(r102));
        return;
    }

    @Override // g70.h.a
    public final void c(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ComponentCenter r101 = this.f65528a;
        r101.getClass();
        final d70.a r102 = ComponentCenter.l(r100);
        if (r102 == null) goto L7;
        r101.g(new ComponentCenter$onComponentLoadEnd$1(r102));
        return;
    }

    @Override // g70.h.a
    public final void d(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ComponentCenter r101 = this.f65528a;
        r101.getClass();
        final d70.a r102 = ComponentCenter.l(r100);
        if (r102 == null) goto L7;
        r101.g(new ComponentCenter$onComponentLoadStart$1(r102));
        return;
    }
}
