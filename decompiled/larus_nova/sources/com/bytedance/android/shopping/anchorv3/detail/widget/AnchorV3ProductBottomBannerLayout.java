package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ec.core.utils.g1;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/AnchorV3ProductBottomBannerLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3ProductBottomBannerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f164847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f164848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f164849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f164850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f164851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f164852f;

    public static final class a {
    }

    static {
    }

    public AnchorV3ProductBottomBannerLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3ProductBottomBannerLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static int a(Integer r100, int r101) {
        if (r100 == null) goto L7;
        int r102 = r100.intValue();
        if (r102 <= 0) goto L7;
        r101 = r102;
    L7:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r101));
    }

    public AnchorV3ProductBottomBannerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_commerce_product_row_banner_layout, this);
        this.f164847a = (SimpleDraweeView) r103.findViewById(R.id.anchor_v3_iv_banner_bg);
        this.f164848b = (SimpleDraweeView) r103.findViewById(R.id.anchor_v3_iv_banner_tag);
        this.f164849c = (TextView) r103.findViewById(R.id.anchor_v3_tv_banner_description);
        this.f164850d = (ViewGroup) r103.findViewById(R.id.top_container);
        this.f164851e = (ViewGroup) r103.findViewById(R.id.banner_item_layout);
        ImageView r104 = (ImageView) r103.findViewById(R.id.banner_arrow_view);
        this.f164852f = r104;
        Drawable r105 = r104.getDrawable();
        int r106 = g1.f45599a;
        DrawableCompat.setTint(r105, g1.a.a(r100, R.color.commerce_color_161823));
    }

    public /* synthetic */ AnchorV3ProductBottomBannerLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
