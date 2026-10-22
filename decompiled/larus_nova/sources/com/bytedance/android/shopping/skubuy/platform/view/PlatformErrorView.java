package com.bytedance.android.shopping.skubuy.platform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.i;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformErrorView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Lx43/a;", "viewModel", "", "setState", "Lkotlin/Function0;", "callback", "setOnRetryClickedCallback", "setOnCloseClickCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformErrorView extends RoundConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f183182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f183183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f183184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f183185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f183186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f183187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f183188g;

    public PlatformErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlatformErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5(final com.bytedance.android.ecom.arch.slice.render.context.b r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        SimpleDraweeView r101 = this.f183184c;
        ConstraintLayout.LayoutParams r102 = null;
        if (r101 == null) goto L9;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L7;
        r103.height = SlcDimensExtensionsKt.a(80, r100);
        r103.width = SlcDimensExtensionsKt.a(80, r100);
        Unit r104 = Unit.INSTANCE;
    L8:
        r101.setLayoutParams(r103);
        goto L9
    L7:
        r103 = null;
    L9:
        TextView r105 = this.f183185d;
        if (r105 == null) goto L19;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == true) goto L14;
        r106 = null;
    L14:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (r107 == null) goto L17;
        ((ViewGroup.MarginLayoutParams) r107).topMargin = SlcDimensExtensionsKt.a(8, r100);
        Unit r108 = Unit.INSTANCE;
    L18:
        r105.setLayoutParams(r107);
        goto L19
    L17:
        r107 = null;
    L19:
        TextView r109 = this.f183185d;
        if (r109 == null) goto L22;
        i.e(r109, 500);
    L22:
        TextView r110 = this.f183186e;
        if (r110 == null) goto L25;
        i.e(r110, 400);
    L25:
        TextView r111 = this.f183187f;
        if (r111 == null) goto L34;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ConstraintLayout.LayoutParams) == true) goto L30;
        r112 = null;
    L30:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
        if (r113 == null) goto L33;
        ((ViewGroup.MarginLayoutParams) r113).topMargin = SlcDimensExtensionsKt.a(40, r100);
        ((ViewGroup.MarginLayoutParams) r113).width = SlcDimensExtensionsKt.a(165, r100);
        ((ViewGroup.MarginLayoutParams) r113).height = SlcDimensExtensionsKt.a(44, r100);
        Unit r114 = Unit.INSTANCE;
        r102 = r113;
    L33:
        r111.setLayoutParams(r102);
    L34:
        TextView r115 = this.f183187f;
        if (r115 == null) goto L38;
        i.e(r115, 500);
        ViewCompat.setBackground(r115, com.bytedance.commerce.base.drawable.a.a(new PlatformErrorView$adapterUIScale$$inlined$let$lambda$1(this, r100)));
        return;
    }

    public final void setOnCloseClickCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f183183b = r100;
    }

    public final void setOnRetryClickedCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f183182a = r100;
    }

    public final void setState(x43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        SimpleDraweeView r101 = this.f183184c;
        if (r101 == null) goto L5;
        h0.e(r101, r100.f562437c, new r("ec_buy_now", "buy_now_error_icon"), -1, -1, 96);
    L5:
        String r102 = r100.f562438d;
        int r103 = 0;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L19;
        TextView r105 = this.f183185d;
        if (r105 == null) goto L16;
        r105.setText(r100.f562438d);
    L16:
        TextView r106 = this.f183185d;
        if (r106 == null) goto L19;
        wg.a.h(r106, true);
    L19:
        String r107 = r100.f562439e;
        if (r107 != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == true) goto L33;
        TextView r109 = this.f183186e;
        if (r109 == null) goto L30;
        r109.setText(r100.f562439e);
    L30:
        TextView r110 = this.f183186e;
        if (r110 == null) goto L33;
        wg.a.h(r110, true);
    L33:
        TextView r111 = this.f183187f;
        if (r111 == null) goto L36;
        r111.setText(r100.f562440f);
    L36:
        TextView r112 = this.f183187f;
        if (r112 == null) goto L39;
        r112.setOnClickListener(new a(this));
    L39:
        ImageView r113 = this.f183188g;
        if (r113 == null) goto L42;
        wg.a.h(r113, r100.f562436b);
    L42:
        ImageView r114 = this.f183188g;
        if (r114 == null) goto L46;
        r114.setOnClickListener(new b(this));
    L46:
        if (r100.f562435a == true) goto L49;
        r103 = 8;
    L49:
        setVisibility(r103);
        return;
    L22:
        if (r107.length() == 0) goto L25;
        r108 = false;
        goto L26
    L8:
        if (r102.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public PlatformErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.skubuy_error_view, this, true);
        this.f183184c = (SimpleDraweeView) findViewById(R.id.error_icon);
        this.f183185d = (TextView) findViewById(R.id.error_title);
        this.f183186e = (TextView) findViewById(R.id.error_subtitle);
        this.f183187f = (TextView) findViewById(R.id.error_button);
        this.f183188g = (ImageView) findViewById(R.id.error_close_icon);
        setVisibility(8);
    }

    public /* synthetic */ PlatformErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
