package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopPreviewBottomInfoPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<StoreV3LiveRoomVO> implements q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f184310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f184311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f184312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f184313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECHeaderSlideIndicator f184314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ti.l f184315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public StoreV3LiveRoomVO f184316p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f184317q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f184318r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f184319s;

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
        p r100 = (p) this.f184319s.getValue();
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    public ECShopPreviewBottomInfoPresenter(final Fragment r100) {
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f184317q = LazyKt.lazy(new ECShopPreviewBottomInfoPresenter$viewModel$2(this, r100));
        this.f184318r = LazyKt.lazy(ECShopPreviewBottomInfoPresenter$lynxCallback$2.INSTANCE);
        this.f184319s = LazyKt.lazy(new ECShopPreviewBottomInfoPresenter$modelAdapter$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(StoreV3LiveRoomVO r110) {
        this.f184316p = r110;
        p r100 = (p) this.f184319s.getValue();
        if (r100 != null) goto L5;
    L74:
        com.bytedance.android.ec.core.arch.event.c.a((ECStoreViewModel) this.f184317q.getValue(), Reflection.getOrCreateKotlinClass(kj3.d.class), Dispatchers.getMain(), new ECShopPreviewBottomInfoPresenter$onElementBind$2(this));
        return;
    L5:
        if (r100.j() != true) goto L74;
        this.f184311k = a0().findViewById(R.id.ec_header_live_bottom_block);
        this.f184312l = a0().findViewById(R.id.ec_header_live_bottom_block_info_area);
        this.f184310j = (ViewGroup) a0().findViewById(R.id.ec_header_live_status);
        this.f184313m = (TextView) a0().findViewById(R.id.store_v3_live_title_info);
        this.f184314n = (ECHeaderSlideIndicator) a0().findViewById(R.id.ec_header_live_slide_indicator);
        StoreV3LiveRoomVO r101 = this.f184316p;
        if (r101 == null) goto L56;
        im.r r102 = r101.getLiveGift();
        ti.l r103 = null;
        if (r102 == null) goto L11;
        String r104 = r102.f490422b;
    L12:
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        ShoppingAsyncInflater.a r106 = ShoppingAsyncInflater.f45268e;
        Context r107 = th.a.e(Y().c(), true);
        r106.getClass();
        ShoppingAsyncInflater.a.a(r107).aU(R.layout.ec_store_layout_header_live_status, this.f184310j, true);
        goto L56
    L21:
        if (r101.getLiveGift() == null) goto L56;
        if (this.f184310j == null) goto L56;
        ti.l r108 = this.f184315o;
        if (r108 == null) goto L28;
        r108.release();
    L28:
        ti.k r111 = (ti.k) this.f184318r.getValue();
        im.r r109 = r101.getLiveGift();
        LinkedHashMap r112 = new LinkedHashMap();
        if (r109 == null) goto L31;
        String r113 = r109.f490422b;
    L32:
        r112.put("data", r113);
        Pair[] r114 = new Pair[3];
        p r115 = (p) this.f184319s.getValue();
        if (r115 == null) goto L37;
        StoreV3LiveRoomVO r116 = r115.h();
        if (r116 == null) goto L37;
        String r117 = r116.getAnchorId();
    L38:
        String r118 = "";
        if (r117 != null) goto L41;
        r117 = "";
    L41:
        r114[0] = TuplesKt.to("anchor_id", r117);
        r114[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        p r119 = (p) this.f184319s.getValue();
        if (r119 == null) goto L46;
        StoreV3LiveRoomVO r120 = r119.h();
        if (r120 == null) goto L46;
        String r121 = r120.getRoomId();
    L47:
        if (r121 == null) goto L50;
        r118 = r121;
    L50:
        r114[2] = TuplesKt.to("room_id", r118);
        r112.put("metaInfo", MapsKt.mutableMapOf(r114));
        im.r r122 = r101.getLiveGift();
        if (r122 == null) goto L55;
        String r123 = r122.f490421a;
        if (r123 == null) goto L55;
        r103 = ECLiveHybridUtil.b(Y().c(), r123, r112, this.f184310j, r111, null, null, false, null, null, false, 4064);
    L55:
        this.f184315o = r103;
    L46:
        r121 = null;
    L37:
        r117 = null;
        goto L38
    L31:
        r113 = null;
        goto L32
    L14:
        if (r104.length() == 0) goto L17;
        r105 = false;
        goto L18
    L11:
        r104 = null;
    L56:
        View r124 = this.f184311k;
        if (r124 == null) goto L59;
        r124.setVisibility(0);
    L59:
        StoreV3LiveRoomVO r125 = this.f184316p;
        if (r125 == null) goto L66;
        String r126 = r125.getTitle();
        if (r126 == null) goto L66;
        TextView r127 = this.f184313m;
        if (r127 == null) goto L66;
        r127.setText(r126);
    L66:
        ECHeaderSlideIndicator r128 = this.f184314n;
        if (r128 == null) goto L69;
        int r129 = (int) 2164260863L;
        r128.f48708a.setBackgroundColor(r129);
        r128.f48710c.setTextColor((int) 3221225471L);
        ECLottieAnimationView r130 = r128.f48709b;
        r130.setAnimation("ec_store_lottie_slide_down_arrow_light.json");
        r130.setRepeatCount(-1);
        r130.playAnimation();
        r128.f48711d.setBackgroundColor(r129);
    L69:
        p r131 = (p) this.f184319s.getValue();
        if (r131 == null) goto L74;
        jm.b<Pair<String, Boolean>> r132 = r131.d();
        if (r132 == null) goto L74;
        r132.a(Y().e(), new k(this), false);
        goto L74
    }

    public final void k0(String r100, boolean r101) {
        if (r100 == null) goto L8;
        ECHeaderSlideIndicator r102 = this.f184314n;
        if (r102 == null) goto L8;
        TextView r103 = r102.getTextView();
        if (r103 == null) goto L8;
        r103.setText(r100);
    L8:
        if (r101 == false) goto L10;
        int r104 = 0;
    L11:
        ECHeaderSlideIndicator r105 = this.f184314n;
        if (r105 != null) goto L14;
    L15:
        ECHeaderSlideIndicator r106 = this.f184314n;
        if (r106 == null) goto L20;
        r106.setVisibility(r104);
        return;
    L20:
        return;
    L14:
        if (r104 != r105.getVisibility()) goto L15;
        return;
    L10:
        r104 = 8;
        goto L11
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.preview.q
    public final void O(float r100, int r101, boolean r102, int r103, boolean r104) {
        View r105 = this.f184312l;
        if (r105 != null) goto L6;
        return;
    L6:
        if (r100 != 0.0f) goto L8;
        int r106 = 0;
    L10:
        if (r106 == r105.getVisibility()) goto L14;
        View r107 = this.f184312l;
        if (r107 == null) goto L14;
        r107.setVisibility(r106);
    L14:
        if (r100 != 0.0f) goto L16;
    L17:
        k0(null, true);
        return;
    L16:
        if (r100 == 1.0f) goto L17;
        return;
    L8:
        r106 = 8;
        goto L10
    }
}
