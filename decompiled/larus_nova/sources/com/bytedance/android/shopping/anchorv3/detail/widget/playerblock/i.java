package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends nic.l.a implements gj.b, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f164981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.api.video.d f164982b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f164983a;

        public a(Function1 r100) {
            this.f164983a = r100;
        }
    }

    @Override // gj.h
    public final void e(int r100, Double r101, Double r102, Double r103, Double r104) {
    }

    @Override // gj.e
    public final Set<fj.e> getListeners() {
        return CollectionsKt.toMutableSet(null);
    }

    public final ECVideoPlayerView i0() {
        throw null;
    }

    @Override // gj.g
    public final void r() {
        h0(true);
    }

    @Override // gj.g
    public final void t() {
        ViewGroup r100 = this.f164981a;
        if (r100.indexOfChild(i0()) != (-1)) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L19;
        r100.addView(i0(), -1, -1);
        if ((r100 instanceof gj.i) == false) goto L15;
        r102 = r100;
    L15:
        gj.i r103 = (gj.i) r102;
        if (r103 == null) goto L20;
        r103.d(this);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // gj.g
    public final void C() {
        t();
        play();
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g
    public final void d0() {
        i0().t(null);
    }

    @Override // gj.d
    public final int getCurrentPosition() {
        return (int) i0().getCurPosition();
    }

    @Override // gj.h
    public final Object getPlayer() {
        return i0().f170618b;
    }

    @Override // gj.g
    public final View getView() {
        return i0();
    }

    @Override // gj.a
    public final boolean isMute() {
        return i0().f();
    }

    @Override // gj.d
    public final boolean isPlaying() {
        return i0().h();
    }

    @Override // gj.d
    public final void pause() {
        i0().m();
    }

    @Override // gj.d
    public final void play() {
        i0().n();
    }

    @Override // gj.d
    public final void release() {
        i0().t(null);
        i0().s();
    }

    @Override // gj.d
    public final void resume() {
        i0().u();
    }

    @Override // gj.g
    public final ViewGroup E() {
        return this.f164981a;
    }

    @Override // gj.e
    public final void A(fj.e r100) {
        Intrinsics.checkNotNullParameter(r100, "playListener");
        throw null;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g
    public final void H(com.bytedance.android.shopping.api.video.i r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        i0().a(r100);
        j0(ScaleType.FIT_CENTER);
        i0().t(null);
        i0().r(null);
    }

    @Override // gj.e
    public final void Z(fj.e r100) {
        Intrinsics.checkNotNullParameter(r100, "playListener");
        throw null;
    }

    @Override // gj.a
    public final void a(boolean r100) {
        i0().k(r100);
    }

    @Override // gj.h
    public final void a0(Function1<? super Bitmap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        ECVideoPlayerView r101 = i0();
        a r102 = new a(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        com.bytedance.android.shopping.api.video.j r103 = r101.getVideoViewHelper();
        if (r103 == null) goto L6;
        r103.getBitmap();
        return;
    }

    public final void h0(boolean r100) {
        if (r100 == false) goto L5;
        i0().m();
    L5:
        if (this.f164981a.indexOfChild(i0()) < 0) goto L13;
        this.f164981a.removeView(i0());
        ViewParent r101 = this.f164981a;
        if ((r101 instanceof gj.i) == true) goto L9;
        r101 = null;
    L9:
        gj.i r102 = (gj.i) r101;
        if (r102 == null) goto L14;
        r102.b(this);
        return;
    L14:
        return;
    }

    public final void j0(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        i0().w(r100);
    }

    @Override // gj.h
    public final void seek(float r100) {
        i0().v(r100 * 100);
    }

    @Override // gj.g
    public final void V(ViewGroup r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        h0(r101);
        this.f164981a = r100;
        t();
    }

    @Override // gj.f
    public final void f0(Object r100, com.bytedance.android.shopping.api.video.d r101) {
        if ((r100 instanceof b) == false) goto L12;
        ECVideoPlayerView r102 = i0();
        b r103 = (b) r100;
        if (r101 != null) goto L7;
        com.bytedance.android.shopping.api.video.d r104 = this.f164982b;
    L8:
        g0(r102, r103, r104);
        if (r101 == null) goto L13;
        this.f164982b = r101;
        return;
    L13:
        return;
    L7:
        r104 = r101;
        goto L8
    }

    public static boolean g0(ECVideoPlayerView r210, b r211, com.bytedance.android.shopping.api.video.d r212) {
        fj.d r100 = r211.f164970b;
        ECPDPBaseVideo r101 = r211.f164971c;
        com.bytedance.android.shopping.api.video.e r102 = null;
        if (r101 == null) goto L16;
        Long r103 = Long.valueOf(r101.getInitialStartTimeMs());
        long r104 = r103.longValue();
        long r105 = r101.getDuration();
        if (0 <= r104) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        r103.longValue();
        r212.f170643c = (int) r101.getInitialStartTimeMs();
        goto L16
    L8:
        if (r105 < r104) goto L10;
        r106 = true;
    L16:
        if (r101 != null) goto L19;
        if (r100 == null) goto L19;
        r212.f170643c = (int) r100.f477448o;
    L19:
        if (r101 == null) goto L21;
        r102 = com.bytedance.android.shopping.api.video.m.b(r101, r212);
    L42:
        if (r102 != null) goto L44;
        return false;
    L44:
        r210.b(r102);
        return true;
    L21:
        if (r100 == null) goto L42;
        com.bytedance.android.shopping.api.video.k r107 = new com.bytedance.android.shopping.api.video.k();
        String r108 = r100.f477436c;
        String r109 = "";
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        Intrinsics.checkNotNullParameter(r108, "videoKey");
        r107.f170664a = r108;
        String r110 = r100.f477436c;
        if (r110 != null) goto L28;
        r110 = "";
    L28:
        Intrinsics.checkNotNullParameter(r110, "key");
        r107.f170665b = r110;
        String r111 = r100.f477434a;
        if (r111 != null) goto L31;
        r111 = "";
    L31:
        r107.a(r111);
        String r112 = r100.f477435b;
        if (r112 != null) goto L34;
        r112 = "";
    L34:
        r107.a(r112);
        r107.f170668e = r100.f477438e * r100.f477437d;
        r107.f170669f = r100.f477439f;
        com.bytedance.android.shopping.api.video.b r113 = r107.b();
        if (r113 == null) goto L42;
        String r114 = r100.f477436c;
        if (r114 == null) goto L41;
        r109 = r114;
    L41:
        Intrinsics.checkNotNullParameter(r109, "newVid");
        Intrinsics.checkNotNullParameter(r212, "options");
        int r115 = (int) r100.f477438e;
        int r116 = (int) r100.f477437d;
        Intrinsics.checkNotNullParameter(r113, "playItem");
        ArrayList r117 = new ArrayList();
        r117.add(r113);
        r102 = new com.bytedance.android.shopping.api.video.e(r109, 0, null, r117, null, r212, -1, 0.0f, null, r115, r116, null, null);
        goto L42
    }
}
