package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.videoshop.mediaview.VideoPatchLayout;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nic.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends nic.l.a implements gj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f164974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<fj.e> f164975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f164976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fj.d f164977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f164978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AVScene f164979f;

    public static final class a {
    }

    public static final class b implements cjc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f164980a;

        public b(Function1 r100) {
            this.f164980a = r100;
        }

        @Override // cjc.d
        public final void a(Bitmap r100) {
            this.f164980a.invoke(r100);
        }
    }

    static {
    }

    @Override // gj.f
    public final void f0(Object r100, com.bytedance.android.shopping.api.video.d r101) {
    }

    public final VideoPatchLayout h0() {
        return (VideoPatchLayout) this.f164974a.getValue();
    }

    @Override // gj.g
    public final void r() {
        g0(true);
    }

    @Override // gj.e
    public final Set<fj.e> getListeners() {
        return CollectionsKt.toMutableSet(this.f164975b);
    }

    @Override // gj.g
    public final void t() {
        ViewGroup r100 = this.f164976c;
        if (r100.indexOfChild(h0()) != (-1)) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L19;
        r100.addView(h0(), -1, -1);
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

    @Override // gj.d
    public final int getCurrentPosition() {
        return h0().getCurrentPosition();
    }

    @Override // gj.h
    public final Object getPlayer() {
        return h0();
    }

    @Override // gj.g
    public final View getView() {
        return h0();
    }

    @Override // gj.a
    public final boolean isMute() {
        return h0().f456045g.f472902d;
    }

    @Override // gj.d
    public final boolean isPlaying() {
        return h0().V();
    }

    @Override // gj.d
    public final void pause() {
        h0().h0();
    }

    @Override // gj.d
    public final void play() {
        h0().i0();
    }

    @Override // gj.d
    public final void release() {
        h0().k0();
    }

    @Override // gj.d
    public final void resume() {
        h0().i0();
    }

    @Override // gj.g
    public final ViewGroup E() {
        return this.f164976c;
    }

    @Override // gj.e
    public final void A(fj.e r100) {
        Intrinsics.checkNotNullParameter(r100, "playListener");
        this.f164975b.add(r100);
    }

    @Override // gj.e
    public final void Z(fj.e r100) {
        Intrinsics.checkNotNullParameter(r100, "playListener");
        this.f164975b.remove(r100);
    }

    @Override // gj.a
    public final void a(boolean r100) {
        h0().setMute(r100);
    }

    @Override // gj.h
    public final void a0(Function1<? super Bitmap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        h0().C(new b(r100));
    }

    public final void g0(boolean r100) {
        if (r100 == false) goto L5;
        h0().h0();
    L5:
        if (this.f164976c.indexOfChild(h0()) < 0) goto L13;
        this.f164976c.removeView(h0());
        ViewParent r101 = this.f164976c;
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

    @Override // gj.h
    public final void seek(float r100) {
        VideoPatchLayout r101 = h0();
        long r102 = (long) (r100 * h0().getDuration());
        if (r102 < 0) goto L7;
        qic.a r103 = r101.f456048j;
        if (r103 == null) goto L9;
        r103.seekTo(r102);
        return;
    L9:
        return;
    L7:
        r101.getClass();
    }

    @Override // nic.l.a, nic.h
    public final void B(p r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).H();
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void I(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).y(false);
        goto L4
    }

    @Override // gj.g
    public final void V(ViewGroup r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        g0(r101);
        this.f164976c = r100;
        t();
    }

    @Override // nic.l.a, nic.h
    public final void W(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).Z2();
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void Y(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).y(true);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void b(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).m3(true);
        goto L4
    L6:
        int r103 = this.f164978e;
        this.f164978e = r103 + 1;
        if (r103 != 0) goto L12;
        Iterator<T> r104 = this.f164975b.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        ((fj.e) r104.next()).R2();
        goto L10
    L16:
        return;
    L12:
        Iterator<T> r105 = this.f164975b.iterator();
    L14:
        if (r105.hasNext() == false) goto L20;
        ((fj.e) r105.next()).e();
        goto L14
    }

    @Override // nic.l.a, nic.h
    public final void h(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).Z2();
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void s(oic.f r100, tic.a r101) {
        Iterator<T> r102 = this.f164975b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((fj.e) r102.next()).m3(false);
        goto L4
    }

    public h(ViewGroup r100, fj.d r101, AVScene r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "playInfo");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f164976c = r100;
        this.f164977d = r101;
        this.f164978e = 0;
        this.f164979f = r102;
        nic.o.f519408a = uf4.a.a();
        this.f164974a = LazyKt.lazy(new PlayAbility$playerView$2(this));
        this.f164975b = new LinkedHashSet();
    }

    @Override // nic.l.a, nic.h
    public final void v(oic.f r100, tic.a r101, Error r102) {
        Iterator<T> r103 = this.f164975b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((fj.e) r103.next()).B0();
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void q(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator<T> r104 = this.f164975b.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((fj.e) r104.next()).Q((r102 * 100.0f) / r103);
        goto L4
    }

    @Override // gj.h
    public final void e(int r100, Double r101, Double r102, Double r110, Double r111) {
        h0().setTextureLayout(r100);
        VideoPatchLayout r103 = h0();
        gjc.a r104 = new gjc.a();
        JSONObject r105 = new JSONObject();
        if (r101 == null) goto L6;
        r105.put("min_x", r101.doubleValue());
    L6:
        if (r102 == null) goto L9;
        r105.put("max_x", r102.doubleValue());
    L9:
        if (r110 == null) goto L12;
        r105.put("min_y", r110.doubleValue());
    L12:
        if (r111 == null) goto L14;
        r105.put("max_y", r111.doubleValue());
    L14:
        JSONObject r106 = new JSONObject(r105.toString());
        float r112 = (float) JSONObjectProtectorUtils.getDouble(r106, "min_x");
        float r107 = 1.0f;
        if (r112 >= 0.0f) goto L18;
        r112 = 0.0f;
    L20:
        r104.f481513a = r112;
        float r108 = (float) JSONObjectProtectorUtils.getDouble(r106, "max_x");
        if (r108 >= 0.0f) goto L24;
        r108 = 0.0f;
    L26:
        r104.f481514b = r108;
        float r109 = (float) JSONObjectProtectorUtils.getDouble(r106, "min_y");
        if (r109 >= 0.0f) goto L30;
        r109 = 0.0f;
    L32:
        r104.f481515c = r109;
        float r113 = (float) JSONObjectProtectorUtils.getDouble(r106, "max_y");
        if (r113 >= 0.0f) goto L36;
        r107 = 0.0f;
    L39:
        r104.f481516d = r107;
        Unit r114 = Unit.INSTANCE;
        r103.setTextureCropStrategy(r104);
        return;
    L36:
        if (r113 > 1.0f) goto L39;
        r107 = r113;
        goto L39
    L30:
        if (r109 <= 1.0f) goto L32;
        r109 = 1.0f;
        goto L32
    L24:
        if (r108 <= 1.0f) goto L26;
        r108 = 1.0f;
        goto L26
    L18:
        if (r112 <= 1.0f) goto L20;
        r112 = 1.0f;
        goto L20
    }
}
