package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends RelativeLayout implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f44093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f44094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f44095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f44096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f44097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f44098g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f44099a;

        public a(Function0 r100) {
            this.f44099a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f44099a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f44100a;

        public b(Function0 r100) {
            this.f44100a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f44100a.invoke();
        }
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void a() {
        TextView r100 = this.f44093b;
        if (r100 == null) goto L6;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        r100.setText(String.format(Locale.getDefault(), this.f44092a, Arrays.copyOf(new Object[]{Integer.valueOf(this.f44098g + 1), Integer.valueOf(this.f44097f)}, 2)));
        return;
    }

    public final int getCount() {
        return this.f44097f;
    }

    public final int getCurrentPos() {
        return this.f44098g;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L5:
        setVisibility(8);
        return;
    L4:
        if (r100 == 3) goto L5;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L4;
    L5:
        setVisibility(0);
        return;
    L4:
        if (r100 == 1) goto L5;
    }

    public final void setCount(int r100) {
        this.f44097f = r100;
        a();
    }

    public final void setCurrentPos(int r100) {
        this.f44098g = r100;
        a();
    }

    public final void setOnBackPressListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f44094c = r100;
    }

    public final void setOnClickDetailButton(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        View r101 = this.f44095d;
        if (r101 == null) goto L5;
        r101.setOnClickListener(new a(r100));
    L5:
        View r102 = this.f44096e;
        if (r102 == null) goto L9;
        r102.setOnClickListener(new b(r100));
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r100, r101);
    }

    public d(Context r100, boolean r110, String r111, com.bytedance.android.ec.core.gallery2.opt.b r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f44092a = "%s/%s";
        LayoutInflater.from(r100).inflate(R.layout.ec_sku_buy_gallery_top_indicator, this, true);
        this.f44093b = (TextView) findViewById(R.id.top_indicator_count_tv);
        ((ImageView) findViewById(R.id.top_indicator_back_btn)).setOnClickListener(new c(this));
        View r101 = findViewById(R.id.detail_entrance_top_right);
        this.f44095d = r101;
        View r102 = findViewById(R.id.detail_entrance_center_bottom);
        this.f44096e = r102;
        if (r110 == false) goto L14;
        if (r112 == null) goto L7;
        r112.Q70(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("module_name", "product_detail_entrance")}));
    L7:
        if (k.c(r111) == false) goto L11;
        h0.e((GenericDraweeView) findViewById(R.id.main_pic_image_view), r111, new r("ec_buy_now", "buy_now_sku_gallery"), null, null, 120);
        ViewExtensionsKt.g(findViewById(R.id.main_pic_image_view), 6.0f, 6.0f, 6.0f, 6.0f);
        if (r102 == null) goto L15;
        r102.setVisibility(0);
        return;
    L15:
        return;
    L11:
        if (r101 == null) goto L17;
        r101.setVisibility(0);
        return;
    L17:
        return;
    }
}
