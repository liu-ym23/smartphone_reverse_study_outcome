package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.b0;
import vg3.i0;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Boolean> f181538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.video.f f181539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f181540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f181541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f181542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vg3.w f181543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vg3.l f181544g;

    public final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f181545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f181546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f181547c;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void a() {
            if (Intrinsics.areEqual(this, this.f181547c.f181540c) == false) goto L6;
            this.f181546b.a();
            return;
        }

        public final void c() {
            this.f181546b.resume();
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void pause() {
            this.f181546b.pause();
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final l getParams() {
            return this.f181545a;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void b(x73.c r100) {
            Intrinsics.checkNotNullParameter(r100, "sharePlayer");
            if (Intrinsics.areEqual(this, this.f181547c.f181540c) == false) goto L6;
            this.f181546b.b(r100);
            return;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v
        public final void close(boolean r100) {
            if (Intrinsics.areEqual(this, this.f181547c.f181540c) == false) goto L6;
            this.f181546b.close(r100);
            return;
        }

        public a(i r100, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r101) {
            Intrinsics.checkNotNullParameter(r101, "floatVideo");
            this.f181547c = r100;
            this.f181546b = r101;
            this.f181545a = r101.f181516j;
        }
    }

    @Override // vg3.b0
    public final a i0() {
        return this.f181540c;
    }

    @Override // vg3.b0
    public final void S0(Function0<Boolean> r100) {
        this.f181538a = r100;
    }

    @Override // vg3.b0
    public final a g1(final l r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        x r101 = r100.f181554c;
        int r102 = 0;
        Unit r103 = null;
        if (r101.f181584g == null) goto L5;
        z73.a<String, gj.b> r104 = PlayAbilityUtil.f164933a;
        PlayAbilityUtil.f(r101.f181582e.f164973e, null);
        com.bytedance.android.shopping.anchorv4.video.p007float.f.a("只有新播放器允许使用共享播放器. playerViewScene=" + r100.f181554c.f181582e.f164973e);
    L15:
        final a r105 = null;
    L20:
        if (r105 == null) goto L44;
        this.f181540c = r105;
        final m r106 = this.f181541d;
        boolean r107 = r100.a();
        final Function1<Integer, Unit> r108 = new FloatVideoManagerV2$showFloatVideo$$inlined$apply$lambda$1(r105, this, r100);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r108, "callback");
        if (r107 == false) goto L33;
        Pair<Integer, Boolean> r109 = r106.f181558a;
        if (r109 == null) goto L29;
        Integer r110 = r109.getFirst();
        if (r110 == null) goto L28;
        r102 = r110.intValue();
    L28:
        r108.invoke(Integer.valueOf(r102));
    L43:
        return r105;
    L29:
        i0 r111 = r106.f181560c;
        if (r111 == null) goto L32;
        r111.r1(new FloatVideoPositionManager$getFloatVideoTop$1(r108));
        goto L43
    L32:
        r108.invoke(0);
        goto L43
    L33:
        vg3.l r112 = r106.f181559b;
        if (r112 != null) goto L36;
    L42:
        Unit r113 = r108.invoke(0);
        goto L43
    L36:
        if (r112.J() == false) goto L40;
        i0 r114 = r106.f181560c;
        if (r114 == null) goto L41;
        r114.r1(new FloatVideoPositionManager$getFloatVideoTop$$inlined$let$lambda$1(r106, r108));
        r103 = Unit.INSTANCE;
    L41:
        if (r103 != null) goto L43;
    L40:
        r112.D(new FloatVideoPositionManager$getFloatVideoTop$$inlined$let$lambda$2(r106, r108));
        r103 = Unit.INSTANCE;
        goto L41
    L44:
        return null;
    L5:
        a r115 = this.f181540c;
        if (r115 == null) goto L16;
        l r116 = r115.f181545a;
        if (r116 == null) goto L12;
        u r117 = r116.f181556e;
        if (r117 == null) goto L12;
        r117.b(r100);
        boolean r118 = true;
    L13:
        if (r118 == true) goto L16;
        com.bytedance.android.shopping.anchorv4.video.p007float.f.a("禁止展示两个及以上的视频小窗");
    L12:
        r118 = false;
    L16:
        u r119 = r100.f181556e;
        if (r119 != null) goto L19;
        u.f181574a.getClass();
        r119 = u.a.f181575a;
    L19:
        r100.f181556e = new j(this, r119);
        r105 = new a(this, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a(r100, new k(this)));
        goto L20
    }

    @Override // vg3.b0
    public final l m0(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r110, x73.c r111, HeaderFloatVideoComponent$checkAndShowFloatVideo$$inlined$lets2$lambda$1 r112, Float r113, Map r210) {
        Intrinsics.checkNotNullParameter(r110, "videoModel");
        Intrinsics.checkNotNullParameter(r111, "sharePlayer");
        ViewGroup r114 = this.f181542e;
        Context r115 = r114.getContext();
        com.bytedance.android.shopping.anchorv4.video.f r100 = this.f181539b;
        Boolean r101 = Boolean.FALSE;
        com.bytedance.android.shopping.api.video.i r102 = r111.f562819d;
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(((ECVideoPlayerView) r102).f());
    L6:
        x r116 = new x(r100, r101, r103, AVScene.CONTENT_PRODUCT_DETAIL_HEADER, r110, true, r111, r113);
        Pair<Integer, Boolean> r104 = this.f181541d.f181558a;
        if (r104 == null) goto L11;
        Boolean r105 = r104.getSecond();
        if (r105 == null) goto L11;
        boolean r106 = r105.booleanValue();
    L13:
        return new l(r115, r114, r116, new y(r106, null, null, 121), r112, r210);
    L11:
        r106 = true;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public i(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.m r100, ViewGroup r101, vg3.a r102, vg3.w r103, vg3.l r104, i0 r105) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "avCoordinationAbility");
        this.f181542e = r101;
        this.f181543f = r103;
        this.f181544g = r104;
        this.f181539b = r102.e();
        this.f181541d = new m(r104, r105);
        r100.P1().a(new h(this));
    }

    @Override // vg3.b0
    public final l W(fj.d r110, ECPDPBaseVideo r210, Boolean r211, Boolean r212, u r213, Map r214, String r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r110, "playInfo");
        ViewGroup r100 = this.f181542e;
        if (r216 == false) goto L10;
        Function0<Boolean> r101 = this.f181538a;
        if (r101 == null) goto L10;
        if (r101.invoke().booleanValue() != true) goto L10;
        boolean r111 = false;
    L11:
        Context r102 = r100.getContext();
        com.bytedance.android.shopping.anchorv4.video.f r103 = this.f181539b;
        if (r210 == null) goto L14;
        AVScene r104 = AVScene.CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW_OPT;
    L15:
        AVScene r112 = r104;
        z73.a<String, gj.b> r105 = PlayAbilityUtil.f164933a;
        x r113 = new x(r103, r211, r212, r112, PlayAbilityUtil.b(r110, r210, PlayerViewScene.SCENE_FLOAT_WINDOW_VIDEO, 4), r111, null, null);
        this.f181541d.getClass();
        return new l(r102, r100, r113, new y(true, null, r215, 65), r213, r214);
    L14:
        r104 = AVScene.CONTENT_PRODUCT_DETAIL_FLOAT_WINDOW;
    L10:
        r111 = true;
        goto L11
    }
}
