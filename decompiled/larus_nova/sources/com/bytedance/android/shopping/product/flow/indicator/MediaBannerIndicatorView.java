package com.bytedance.android.shopping.product.flow.indicator;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaBannerIndicatorView extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f182359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f182360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f182361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f182362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BannerView f182363e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaBannerIndicatorView f182364a;

        public a(MediaBannerIndicatorView r100) {
            this.f182364a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MediaBannerIndicatorView r101 = this.f182364a;
            if (r101.f182362d <= 0) goto L10;
            BannerView r102 = r101.f182363e;
            if (r102 == null) goto L11;
            RecyclerView r103 = r102.getViewPager();
            if (r103 == null) goto L12;
            r103.scrollToPosition(0);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaBannerIndicatorView f182365a;

        public b(MediaBannerIndicatorView r100) {
            this.f182365a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MediaBannerIndicatorView r101 = this.f182365a;
            if (r101.f182362d != 0) goto L10;
            BannerView r102 = r101.f182363e;
            if (r102 == null) goto L11;
            RecyclerView r103 = r102.getViewPager();
            if (r103 == null) goto L12;
            r103.scrollToPosition(1);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public MediaBannerIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MediaBannerIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerView");
        this.f182363e = r100;
    }

    public final void c(TextView r100) {
        ColorStateList r101 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        Resources r102 = Resources.getSystem();
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        r100.setTextSize(11.0f);
        r100.setTextColor(r101);
        r100.setPadding(r103, r105, r103, r105);
    }

    @Override // yg3.c
    public final void a(int r100, int r101) {
        this.f182362d = r100;
        this.f182361c = r101 - 1;
        if (r100 != 0) goto L5;
        this.f182359a.setSelected(true);
        this.f182360b.setSelected(false);
        TextView r102 = this.f182360b;
        int r103 = g1.f45599a;
        r102.setText(g1.a.c(getContext(), com.larus.nova.R.string.shopping_anchor_v3_detail_header_indicator, new Object[]{1, Integer.valueOf(this.f182361c)}));
        return;
    L5:
        this.f182359a.setSelected(false);
        this.f182360b.setSelected(true);
        TextView r104 = this.f182360b;
        int r105 = g1.f45599a;
        r104.setText(g1.a.c(getContext(), com.larus.nova.R.string.shopping_anchor_v3_detail_header_indicator, new Object[]{Integer.valueOf((r100 - 1) + 1), Integer.valueOf(this.f182361c)}));
    }

    public MediaBannerIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setBackgroundResource(com.larus.nova.R.drawable.commerce_bg_indicator_container);
        TextView r103 = new TextView(r100);
        c(r103);
        r103.setText(r100.getResources().getString(com.larus.nova.R.string.shopping_anchor_v3_detail_header_video));
        r103.setBackgroundResource(com.larus.nova.R.drawable.commerce_bg_video_image_indicator);
        r103.setOnClickListener(new a(this));
        addView(r103, new LinearLayout.LayoutParams(-2, -2));
        Unit r104 = Unit.INSTANCE;
        this.f182359a = r103;
        TextView r105 = new TextView(r100);
        c(r105);
        int r106 = g1.f45599a;
        r105.setText(g1.a.c(r100, com.larus.nova.R.string.shopping_anchor_v3_detail_header_indicator, new Object[]{1, 0}));
        r105.setBackgroundResource(com.larus.nova.R.drawable.commerce_bg_video_image_indicator);
        r105.setOnClickListener(new b(this));
        addView(r105, new LinearLayout.LayoutParams(-2, -2));
        this.f182360b = r105;
    }

    public /* synthetic */ MediaBannerIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
