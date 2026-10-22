package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/SellPointStrand;", "Landroid/widget/RelativeLayout;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getTvSellPoint", "()Landroid/widget/TextView;", "tvSellPoint", "b", "getIconSellPoint", "iconSellPoint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SellPointStrand extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f165521b;

    public static final class a {
    }

    static {
    }

    public SellPointStrand(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SellPointStrand(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getIconSellPoint() {
        return (TextView) this.f165521b.getValue();
    }

    private final TextView getTvSellPoint() {
        return (TextView) this.f165520a.getValue();
    }

    public SellPointStrand(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        u63.a.a(r100, R.layout.ec_commerce_layout_anchor_v3_sell_point_strand, this, true);
        this.f165520a = LazyKt.lazy(new SellPointStrand$tvSellPoint$2(this));
        this.f165521b = LazyKt.lazy(new SellPointStrand$iconSellPoint$2(this));
    }

    public /* synthetic */ SellPointStrand(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
