package com.bytedance.android.live.revlink.link.domain.service;

import com.bytedance.android.live.revlink.impl.multianchor.ui.i;
import com.bytedance.android.live.revlink.impl.multianchor.ui.q;
import com.bytedance.android.live.revlink.impl.multianchor.ui.r;
import com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f98533a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void a() {
        this.f98533a.a();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void b(String r100) {
        this.f98533a.b(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void c(boolean r100, boolean r101) {
        this.f98533a.c(r100, r101);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final Disposable d(q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f98533a.d(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        return this.f98533a.e(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void f(String r100, String r101, boolean r110, r r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        this.f98533a.f(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void g(q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f98533a.g(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean h() {
        return this.f98533a.h();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void i(boolean r100, r.c r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f98533a.i(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean j(String r100, String r101) {
        return this.f98533a.j(r100, r101);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void k(q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f98533a.k(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void l(String r100, boolean r101, boolean r102, boolean r110, boolean r111) {
        this.f98533a.l(r100, r101, r102, r110, r111);
    }

    public a(MultiMuteManager r100) {
        Intrinsics.checkNotNullParameter(r100, "muteManager");
        this.f98533a = r100;
    }
}
