package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gj.b f181528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f181529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x73.d f181530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a f181531d;

    public static final class a implements fj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f181532a;

        @Override // fj.e
        public final void B0() {
        }

        @Override // fj.e
        public final void Q(float r100) {
        }

        @Override // fj.e
        public final void R2() {
        }

        @Override // fj.e
        public final void y(boolean r100) {
        }

        @Override // fj.e
        public final void Z2() {
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r100 = this.f181532a.f181531d;
            if (r100.f181509c == true) goto L9;
            r100.f181509c = true;
            Float r101 = r100.f181516j.f181554c.f181585h;
            if (r101 == null) goto L9;
            float r102 = r101.floatValue();
            gj.b r103 = this.f181532a.f181528a;
            if (r103 == null) goto L9;
            r103.seek(r102);
        L9:
            e r104 = this.f181532a.f181531d.f181508b;
            if (r104 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.video.f r105 = r104.f167580d;
            if (r105 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.video.f.a.b(r105, r104, false, 6);
        L14:
            this.f181532a.f181531d.f181516j.getClass();
            this.f181532a.f181531d.f181514h.b();
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r106 = this.f181532a.f181531d;
            r106.f181510d = SystemClock.elapsedRealtime();
            n r107 = this.f181532a.f181531d.f181514h;
            a0 r108 = r107.f181566a;
            if (r108 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L17:
            ECDraweeView r109 = r108.getIvCover();
            if (r109 == null) goto L20;
            Object r110 = r109.getTag();
        L21:
            if (r110 != null) goto L43;
            a0 r111 = r107.f181566a;
            if (r111 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L26:
            ECDraweeView r112 = r111.getIvCover();
            if (r112 == null) goto L29;
            r112.setTag(r107);
        L29:
            a0 r113 = r107.f181566a;
            if (r113 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
        L32:
            ECDraweeView r114 = r113.getIvCover();
            if (r114 == null) goto L40;
            ViewPropertyAnimator r115 = r114.animate();
            if (r115 == null) goto L41;
            ViewPropertyAnimator r116 = r115.alpha(0.0f);
            if (r116 == null) goto L42;
            r116.setDuration(300);
            r116.setListener(new r(r107));
            r116.start();
            return;
        L42:
            return;
        L41:
            return;
        L40:
            return;
        L43:
            return;
        L20:
            r110 = null;
            goto L21
        }

        @Override // fj.e
        public final void e() {
            if (this.f181532a.f181531d.f181516j.a() == false) goto L6;
            t.a.a(this.f181532a, false, false, true, false, 10);
            return;
        }

        @Override // fj.e
        public final void H() {
            Z2();
        }

        public a(c r100) {
            this.f181532a = r100;
        }

        @Override // fj.e
        public final void m3(boolean r100) {
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r101 = this.f181532a.f181531d;
            if (r101.f181511e == false) goto L5;
            r101.f181511e = false;
        L6:
            Lazy r102 = UIUtils.f45548a;
            UIUtils.c().post(new b(this));
            return;
        L5:
            r101.f181514h.b();
            goto L6
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void d() {
        gj.b r100 = this.f181528a;
        if (r100 != null) goto L5;
    L10:
        this.f181531d.d();
        return;
    L5:
        if (r100.isPlaying() != true) goto L10;
        u r101 = this.f181531d.f181516j.f181556e;
        if (r101 == null) goto L12;
        r101.a();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final gj.b e() {
        x r100 = this.f181531d.f181516j.f181554c;
        if (this.f181528a != null) goto L30;
        boolean r101 = true;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r102 = this.f181531d;
        if (r102.f181516j.f181554c.f181584g == null) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L21;
        z73.a<String, gj.b> r104 = PlayAbilityUtil.f164933a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r105 = r100.f181582e;
        ViewGroup r106 = r102.f181514h.getVideoContainer();
        PlayerViewScene r107 = r100.f181582e.f164973e;
        AVScene r108 = r100.f181581d;
        com.bytedance.android.shopping.api.video.d r109 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
        if (this.f181531d.f181516j.f181554c.f181584g != null) goto L15;
        r101 = false;
    L15:
        r109.f170648h = r101;
        Unit r110 = Unit.INSTANCE;
        this.f181528a = PlayAbilityUtil.d(r105, r106, r107, r108, r109, PlayAbilityCacheScene.SCENE_FLOAT_VIDEO);
    L21:
        f();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L26;
        gj.b r111 = this.f181528a;
        if (r111 == null) goto L26;
        r111.t();
    L26:
        gj.b r112 = this.f181528a;
        if (r112 == null) goto L30;
        r112.A(new a(this));
        goto L30
    L9:
        r103 = false;
        goto L10
    L16:
        z73.a<String, gj.b> r113 = PlayAbilityUtil.f164933a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r114 = r100.f181582e;
        ViewGroup r115 = this.f181531d.f181514h.getVideoContainer();
        PlayerViewScene r116 = r100.f181582e.f164973e;
        AVScene r117 = r100.f181581d;
        com.bytedance.android.shopping.api.video.d r118 = new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509);
        if (this.f181531d.f181516j.f181554c.f181584g != null) goto L20;
        r101 = false;
    L20:
        r118.f170648h = r101;
        Unit r119 = Unit.INSTANCE;
        this.f181528a = PlayAbilityUtil.d(r114, r115, r116, r117, r118, null);
    L30:
        return this.f181528a;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final l getParams() {
        return this.f181531d.f181516j;
    }

    public final void f() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L16;
        x73.c r100 = this.f181531d.f181516j.f181554c.f181584g;
        if (r100 == null) goto L31;
        gj.b r101 = r100.i(this.f181530c);
        this.f181528a = r101;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.V(this.f181531d.f181514h.getVideoContainer(), true);
        boolean r102 = r101.isMute();
        if (this.f181529b == r102) goto L15;
        this.f181529b = r102;
        e r103 = this.f181531d.f181508b;
        if (r103 == null) goto L14;
        r103.n(r102, false);
    L14:
        this.f181531d.f181514h.a();
    L15:
        r101.resume();
        return;
    L31:
        return;
    L16:
        gj.b r104 = this.f181528a;
        if ((r104 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) == true) goto L19;
        r104 = null;
    L19:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r105 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) r104;
        x73.c r106 = this.f181531d.f181516j.f181554c.f181584g;
        if (r105 == null) goto L33;
        if (r106 == null) goto L34;
        r105.H(r106.j(this.f181530c));
        boolean r107 = this.f181529b;
        com.bytedance.android.shopping.api.video.i r108 = r106.f562819d;
        if (r108 != null) goto L25;
    L26:
        c(false);
    L27:
        gj.b r109 = e();
        if (r109 == null) goto L35;
        r109.resume();
        return;
    L35:
        return;
    L25:
        if (r107 == ((ECVideoPlayerView) r108).f()) goto L27;
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final boolean b() {
        return this.f181529b;
    }

    public c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r100) {
        this.f181531d = r100;
        this.f181530c = new x73.d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void c(boolean r100) {
        this.f181529b = !this.f181529b;
        gj.b r101 = e();
        if (r101 == null) goto L5;
        r101.a(this.f181529b);
    L5:
        e r102 = this.f181531d.f181508b;
        if (r102 == null) goto L8;
        r102.n(this.f181529b, r100);
    L8:
        this.f181531d.f181514h.a();
        d r103 = this.f181531d.f181515i;
        boolean r104 = this.f181529b;
        r103.getClass();
        if (r104 == true) goto L11;
        String r105 = "open";
    L12:
        r103.b("pd_sound_icon_click", MapsKt.mapOf(TuplesKt.to("click_type", r105)));
        return;
    L11:
        r105 = "close";
        goto L12
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.t
    public final void a(boolean r100, boolean r101, boolean r102, boolean r103) {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r104 = this.f181531d;
        if (r104.f181516j.f181554c.f181584g == null) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L35;
        if (r101 == true) goto L35;
        gj.b r106 = null;
        if (r100 == true) goto L14;
        if (r102 == true) goto L14;
        if (r103 == true) goto L14;
        Boolean r107 = null;
    L15:
        x73.c r108 = this.f181531d.f181516j.f181554c.f181584g;
        if (r108 != null) goto L18;
    L21:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r109 = this.f181531d;
        DragRelativeLayout r110 = r109.f181507a;
        if (r110 == null) goto L27;
        if (r109.f181516j.f181553b.indexOfChild(r110) < 0) goto L27;
        this.f181531d.f181516j.f181553b.removeView(r110);
    L27:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == true) goto L46;
        gj.b r111 = this.f181528a;
        if ((r111 instanceof com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) == false) goto L32;
        r106 = r111;
    L32:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g r112 = (com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g) r106;
        if (r112 == null) goto L46;
        r112.d0();
    L46:
        u r113 = this.f181531d.f181516j.f181556e;
        if (r113 == null) goto L49;
        r113.onClose(r100);
    L49:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r114 = this.f181531d;
        e r115 = r114.f181508b;
        if (r115 == null) goto L52;
        r114.f181516j.f181554c.f181578a.g(r115);
    L52:
        this.f181531d.f181515i.a(r102, "quit");
        return;
    L18:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L20;
        r108.g(this.f181530c, Boolean.TRUE);
        goto L21
    L20:
        r108.h(this.f181530c, r107);
    L14:
        r104.pause();
        r107 = Boolean.FALSE;
    L35:
        gj.b r116 = this.f181528a;
        if (r116 == null) goto L38;
        r116.r();
    L38:
        gj.b r117 = this.f181528a;
        if (r117 == null) goto L41;
        r117.release();
    L41:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r118 = this.f181531d;
        DragRelativeLayout r119 = r118.f181507a;
        if (r119 == null) goto L46;
        if (r118.f181516j.f181553b.indexOfChild(r119) < 0) goto L46;
        this.f181531d.f181516j.f181553b.removeView(r119);
        goto L46
    L5:
        r105 = false;
        goto L6
    }
}
