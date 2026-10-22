package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.VideoHolderItem;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.i0;
import vg3.t;
import vg3.w;

/* JADX INFO: loaded from: classes13.dex */
public final class MoreVideoComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements t {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f181421m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f181422n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f181423o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f181424p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f181425q;

    public static final class a {
    }

    public static final class b extends FrameLayout implements com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f181426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECDraweeView f181427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x73.a f181428c;

        public static final class a {
        }

        static {
        }

        @Override // fj.e
        public final void B0() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void P1(boolean r100) {
        }

        @Override // fj.e
        public final void Q(float r100) {
        }

        @Override // fj.e
        public final void R2() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void b(float r100) {
        }

        @Override // fj.e
        public final void e() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e
        public final void y(boolean r100) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void y3(String r100) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void E3() {
            this.f181427b.setVisibility(0);
        }

        @Override // fj.e
        public final void H() {
            this.f181427b.setVisibility(8);
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void S() {
            this.f181427b.setVisibility(8);
        }

        @Override // fj.e
        public final void Z2() {
            this.f181427b.setVisibility(8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.MoreVideoComponent$b] */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.view.View, x73.a] */
        public b(Context r110) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r110);
            int r100 = com.bytedance.android.shopping.extensions.b.a(2);
            setPadding(r100, r100, r100, 0);
            BackgroundDrawable r101 = new BackgroundDrawable(r110, null, false, 4, null);
            r101.setCornerRadius(com.bytedance.android.shopping.extensions.b.a(Float.valueOf(12.0f)));
            r101.setBgColor((int) 3238002687L);
            r101.setStrokeColor(-1);
            r101.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(1));
            r101.invalidate();
            Unit r102 = Unit.INSTANCE;
            setBackground(r101);
            int r103 = com.bytedance.android.shopping.extensions.b.a(66);
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
            BasePdpVideoView r104 = new BasePdpVideoView(r110, null, 6, 0);
            ViewExtensionsKt.g(r104, 10.0f, 10.0f, 10.0f, 10.0f);
            ?? r105 = r104;
        L6:
            this.f181428c = r105;
            addView(r105, new FrameLayout.LayoutParams(r103, r103));
            ECDraweeView r106 = new ECDraweeView(r110, null, 0, 6, null);
            this.f181427b = r106;
            ViewExtensionsKt.g(r106, 10.0f, 10.0f, 10.0f, 10.0f);
            addView(r106, new FrameLayout.LayoutParams(r103, r103));
            TextView r107 = new TextView(r110);
            this.f181426a = r107;
            r107.setGravity(17);
            int r108 = g1.f45599a;
            r107.setCompoundDrawablesWithIntrinsicBounds(null, null, g1.a.b(r110, R.drawable.anchor_v4_more_video_arrow), null);
            r107.setTextColor(g1.a.a(r110, R.color.shopping_color_161823));
            ViewExtensionsKt.h(r107, 10);
            FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(24));
            r111.topMargin = r103;
            r111.gravity = 1;
            addView(r107, r111);
            return;
        L5:
            BasePdVideoView r109 = new BasePdVideoView(r110, null);
            ViewExtensionsKt.g(r109, 10.0f, 10.0f, 10.0f, 10.0f);
            r105 = r109;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
        public final void i2(boolean r100) {
            if (r100 == false) goto L5;
            this.f181427b.setVisibility(8);
            return;
        }

        @Override // fj.e
        public final void m3(boolean r100) {
            if (r100 == true) goto L5;
            this.f181427b.setVisibility(0);
            return;
        }
    }

    public static final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MoreVideoComponent f181429a;

        public c(MoreVideoComponent r100) {
            this.f181429a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r210) {
            HeadMoreVideo r100 = (HeadMoreVideo) r210;
            if (r100 == null) goto L107;
            MoreVideoComponent r101 = this.f181429a;
            if (r101.f181425q == true) goto L108;
            r101.f181425q = true;
            VideoModel r102 = r100.getAnchorVideo();
            AnchorV4PlayerStateManager r103 = null;
            if (r102 != null) goto L15;
            List<VideoHolderItem> r104 = r100.getVideoHolderList();
            if (r104 == null) goto L14;
            VideoHolderItem r105 = (VideoHolderItem) CollectionsKt.getOrNull(r104, r100.getAnchorIndex());
            if (r105 == null) goto L14;
            r102 = r105.getVideo();
        L14:
            r102 = null;
        L15:
            if (r102 == null) goto L109;
            z73.a<String, gj.b> r106 = PlayAbilityUtil.f164933a;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r107 = PlayAbilityUtil.a(r102, null, PlayerViewScene.SCENE_HEAD_MORE_VIDEO);
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L25;
            b r108 = r101.f181421m;
            if (r108 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L21:
            if (r108 == null) goto L32;
            x73.a r109 = r108.f181428c;
            if (r109 == null) goto L32;
            r109.k(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true, new a83.a(), PlayAbilityCacheScene.SCENE_MORE_VIDEO);
            r109.i(r107, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r109.f(true, false);
            r109.setScaleType(ScaleType.CENTER_CROP);
        L32:
            b r110 = r101.f181421m;
            if (r110 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L35:
            if (r110 != null) goto L37;
        L40:
            b r111 = r101.f181421m;
            if (r111 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L43:
            if (r111 == null) goto L47;
            TextView r112 = r111.f181426a;
            if (r112 == null) goto L47;
            r112.setText("更多视频");
        L47:
            b r113 = r101.f181421m;
            if (r113 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L50:
            if (r113 == null) goto L60;
            ECDraweeView r114 = r113.f181427b;
            if (r114 == null) goto L60;
            GenericDraweeHierarchy r115 = r114.getHierarchy();
            if (r115 == null) goto L56;
            r115.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        L56:
            String r116 = r107.f();
            if (r116 == null) goto L59;
            y.d(r114, r116);
            goto L60
        L59:
            r114.setVisibility(8);
            Unit r117 = Unit.INSTANCE;
        L60:
            b r118 = r101.f181421m;
            if (r118 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L63:
            if (r118 == null) goto L65;
            r118.setOnClickListener(new f(r101, r100));
        L65:
            vg3.a r119 = (vg3.a) r101.N1(vg3.a.class);
            if (r119 == null) goto L68;
            r103 = r119.e();
        L68:
            if (r103 == null) goto L70;
            r103.c(new g(r101, r103, r103));
        L70:
            b r120 = r101.f181421m;
            if (r120 != null) goto L73;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L73:
            if (r120 == null) goto L79;
            x73.a r121 = r120.f181428c;
            if (r121 == null) goto L79;
            if (r121.isPlaying() != true) goto L79;
        L84:
            b r122 = r101.f181421m;
            if (r122 != null) goto L88;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L88:
            if (r122 == null) goto L90;
            r122.setAlpha(0.0f);
        L90:
            b r123 = r101.f181421m;
            if (r123 != null) goto L93;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L93:
            if (r123 != null) goto L95;
        L105:
            MoreVideoComponent.j2(r101, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, r100.getTrack());
            return;
        L95:
            if (ViewCompat.isLaidOut(r123) == true) goto L97;
        L104:
            r123.addOnLayoutChangeListener(new k(r101));
            goto L105
        L97:
            if (r123.isLayoutRequested() == true) goto L104;
            b r124 = r101.f181421m;
            if (r124 != null) goto L101;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L101:
            if (r124 == null) goto L103;
            r124.setAlpha(1.0f);
        L103:
            r123.setTranslationX(r123.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
            r123.animate().translationX(0.0f).setDuration(1000).start();
        L79:
            b r125 = r101.f181421m;
            if (r125 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L82:
            if (r125 == null) goto L84;
            r125.postDelayed(new l(r101), 800);
            goto L84
        L37:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L39;
            r110.f181428c.g(r110);
            r110.f181428c.c(r110);
            goto L40
        L39:
            r110.f181428c.j(r110);
            r110.f181428c.l(r110);
            goto L40
        L25:
            b r126 = r101.f181421m;
            if (r126 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
        L28:
            if (r126 == null) goto L32;
            x73.a r127 = r126.f181428c;
            if (r127 == null) goto L32;
            r127.h(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true);
            r127.i(r107, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r127.f(true, false);
            r127.setScaleType(ScaleType.CENTER_CROP);
            goto L32
        L109:
            return;
        L108:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.l.class, w.class, vg3.a.class, i0.class});
    }

    @Override // vg3.t
    public final boolean d() {
        b r100 = this.f181421m;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L6:
        if (r100.getVisibility() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public MoreVideoComponent() {
        this.f181424p = LazyKt.lazy(new MoreVideoComponent$halfScreenMargin$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().f181904n.getValue(), this, new c(this));
        AbsComponent.Y1(this, t.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        b r100 = this.f181421m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L5:
        r100.f181428c.release();
    }

    public static final int h2(MoreVideoComponent r100) {
        if (r100.f181423o != 0) goto L15;
        i0 r101 = (i0) r100.N1(i0.class);
        if (r101 == null) goto L7;
        Rect r102 = r101.a1();
    L8:
        if (r102 == null) goto L16;
        if (r102.height() <= 0) goto L16;
        r100.f181423o = r102.bottom + com.bytedance.android.shopping.extensions.b.a(48);
    L16:
        return com.bytedance.android.shopping.extensions.b.a(152);
    L7:
        r102 = null;
    L15:
        return r100.f181423o;
    }

    public static final /* synthetic */ b i2(MoreVideoComponent r100) {
        b r101 = r100.f181421m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L5:
        return r101;
    }

    @Override // vg3.t
    public final void g(boolean r100) {
        if (r100 == false) goto L10;
        b r101 = this.f181421m;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L7:
        if (r101 == null) goto L22;
        r101.setVisibility(0);
        return;
    L22:
        return;
    L10:
        if (ECSettingKeys.A0().g() == false) goto L16;
        b r102 = this.f181421m;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L14:
        if (r102 == null) goto L24;
        r102.setVisibility(4);
        return;
    L24:
        return;
    L16:
        b r103 = this.f181421m;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L19:
        if (r103 == null) goto L26;
        r103.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        DragRelativeLayout r102 = new DragRelativeLayout(r101.getContext());
        r102.setId(R.id.layout_more_float_video);
        r102.setDockMode(3);
        b r103 = new b(r101.getContext());
        this.f181421m = r103;
        Unit r104 = Unit.INSTANCE;
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(-2, -2);
        r105.addRule(11, -1);
        r105.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r102.addView(r103, r105);
        r102.b();
        b r106 = this.f181421m;
        if (r106 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L6:
        if (ViewCompat.isLaidOut(r106) == true) goto L8;
    L10:
        r106.addOnLayoutChangeListener(new h(r102, this, r101));
    L12:
        if (ECSettingKeys.A0().g() == true) goto L14;
    L19:
        return r102;
    L14:
        if (g2().getNativeParams().getFullMode() == true) goto L19;
        b r107 = this.f181421m;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("moreVideoLayout");
    L18:
        r107.setVisibility(4);
        goto L19
    L8:
        if (r106.isLayoutRequested() == true) goto L10;
        r102.setEnableKeepLayout(true);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181849b.f181037c, this, new i(this));
        goto L12
    }

    public static void j2(MoreVideoComponent r110, String r111, Map r112) {
        r110.Z1(w.class, new MoreVideoComponent$logCommon$1(r112, "a1.b8094.c05258.d150175", r111, true, "", null, null, false, null));
    }
}
