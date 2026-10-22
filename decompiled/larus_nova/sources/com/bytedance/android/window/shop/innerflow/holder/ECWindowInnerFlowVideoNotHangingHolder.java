package com.bytedance.android.window.shop.innerflow.holder;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tp.c;
import vp3.e;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoNotHangingHolder;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lvp3/e;", "Ltp/c;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowVideoNotHangingHolder extends ECShopInnerFlowItemHolder<e> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vp.c f189047b;

    @Override // tp.c
    public final void B() {
        this.f189047b.B();
    }

    @Override // tp.c
    public final boolean D3() {
        return this.f189047b.D3();
    }

    @Override // tp.c
    public final List<c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        return this.f189047b.L(r100);
    }

    @Override // tp.c
    public final void R() {
        this.f189047b.R();
    }

    @Override // tp.c
    public final boolean g0() {
        return this.f189047b.g0();
    }

    @Override // tp.c
    public final boolean isPlaying() {
        return this.f189047b.isPlaying();
    }

    @Override // tp.c
    public final tp.b m() {
        return this.f189047b.m();
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        this.f189047b.o2(r100);
    }

    @Override // tp.c
    public final Rect r() {
        this.f189047b.getClass();
        return null;
    }

    @Override // tp.c
    public final void startPlay() {
        this.f189047b.startPlay();
    }

    @Override // tp.c
    public final void stopPlay() {
        this.f189047b.stopPlay();
    }

    @Override // tp.c
    public final void v() {
        this.f189047b.v();
    }

    @Override // tp.c
    public final void M() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        c.a.a(r100);
    }

    @Override // tp.c
    public final WindowPlayAbleType P() {
        this.f189047b.getClass();
        return WindowPlayAbleType.OTHER;
    }

    @Override // tp.c
    public final void U0() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        c.a.b(r100);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void U3() {
        QUIManager r100 = this.f189042a;
        if (r100 == null) goto L6;
        r100.r(bq3.c.class);
        return;
    }

    @Override // tp.c
    public final void pausePlay() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        c.a.e(r100);
    }

    @Override // tp.c
    public final boolean resumePlay() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        return c.a.f(r100);
    }

    @Override // tp.c
    public final void x() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        c.a.c(r100);
    }

    @Override // tp.c
    public final void z() {
        vp.c r100 = this.f189047b;
        r100.getClass();
        c.a.d(r100);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder
    public final void T3(vp3.b r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "vo");
        QUIManager r102 = this.f189042a;
        if (r102 == null) goto L6;
        r102.c(bq3.c.class, r101);
        return;
    }

    public ECWindowInnerFlowVideoNotHangingHolder(QUIManager r100, vp.c r101) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "playProxy");
        super(r100, r100.p());
        this.f189047b = r101;
    }
}
