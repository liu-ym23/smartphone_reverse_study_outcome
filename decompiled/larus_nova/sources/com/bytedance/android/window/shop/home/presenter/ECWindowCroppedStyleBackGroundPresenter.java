package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowCroppedStyleBackGroundPresenter extends AbsECWindowPresenter {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f188282o = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f188283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f188284n;

    public static final class a {
    }

    static {
    }

    public final FrameLayout b0() {
        return (FrameLayout) this.f188283m.getValue();
    }

    public ECWindowCroppedStyleBackGroundPresenter() {
        this.f188283m = LazyKt.lazy(new ECWindowCroppedStyleBackGroundPresenter$container$2(this));
        this.f188284n = LazyKt.lazy(new ECWindowCroppedStyleBackGroundPresenter$croppedContainer$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        b0().setVisibility(8);
        O().getHeaderResponse().a(U(), new q(this), false);
        O().getHeaderResponse().a(U(), new p(this), false);
    }

    public static final View a0(ECWindowCroppedStyleBackGroundPresenter r100, uq3.a r101) {
        r100.getClass();
        boolean r102 = true;
        if (yq3.a.f() == 1) goto L7;
        r102 = false;
    L7:
        if (r102 == false) goto L9;
        View r103 = LayoutInflater.from(r100.u().c()).inflate(R.layout.ec_window_layout_default_background_for_settings, null);
    L10:
        View r104 = r103.findViewById(R.id.ec_window_header_bg_default);
        SimpleDraweeView r105 = (SimpleDraweeView) r103.findViewById(R.id.ec_window_background_mask);
        if (r102 == false) goto L13;
        dm.a.a("window_first_frame_opt").i("window_big_image_decode");
        ImageRequest r106 = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.ec_window_header_default_shader).build();
        r105.setController(Fresco.newDraweeControllerBuilder().setOldController(r105.getController()).setImageRequest(r106).build());
    L13:
        uq3.o r107 = r101.f551204c;
        if (r107 == null) goto L18;
        String r108 = r107.f551258i;
        if (r108 == null) goto L18;
        int[] r109 = j2.a(r108);
        GradientDrawable r110 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r110, (int[]) r109.clone());
        Unit r111 = Unit.INSTANCE;
        com.bytedance.android.ec.window.base.utils.c.d(r104, r110);
        r104.setVisibility(0);
        r105.setVisibility(0);
    L18:
        return r103;
    L9:
        r103 = LayoutInflater.from(r100.u().c()).inflate(R.layout.ec_window_layout_default_background, null);
        goto L10
    }

    public static final View Z(ECWindowCroppedStyleBackGroundPresenter r110, ECUrlModel r111, int r112) {
        View r100 = LayoutInflater.from(r110.u().c()).inflate(R.layout.ec_window_layout_backgound_v2, null);
        ECDraweeView r101 = (ECDraweeView) r100.findViewById(R.id.ec_window_header_bg_pic_opt);
        View r102 = r100.findViewById(R.id.ec_window_header_bg_second_part_opt);
        View r113 = r100.findViewById(R.id.ec_window_header_transition_mask_opt);
        com.bytedance.android.ec.core.imagex.h0.d(r101, r111, r110.O().getImageCallerContext(), null, null, null, null, 120);
        r102.setBackgroundColor(r112);
        r113.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) 71.4d, Color.red(r112), Color.green(r112), Color.blue(r112)), r112}));
        return r100;
    }
}
