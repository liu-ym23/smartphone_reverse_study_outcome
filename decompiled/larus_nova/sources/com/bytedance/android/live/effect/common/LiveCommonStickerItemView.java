package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerItemView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerItemView extends RelativeLayout {
    public LiveCommonStickerItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveCommonStickerItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public LiveCommonStickerItemView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = new View(r110);
        r113.setId(R.id.select_border);
        int r114 = (int) t6.a(r110, 58.0f);
        RelativeLayout.LayoutParams r100 = new RelativeLayout.LayoutParams(r114, r114);
        r100.topMargin = s1.f(5.0f);
        r100.addRule(10);
        r100.addRule(14);
        r113.setBackgroundResource(R.drawable.ttlive_effect_common_sticker_item_border);
        r113.setVisibility(4);
        addView(r113, r100);
        SimpleDraweeView r101 = new SimpleDraweeView(r110);
        r101.setId(R.id.image);
        r101.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        t6.a(r110, 8.0f);
        int r102 = (int) t6.a(r110, 48.0f);
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(r102, r102);
        r103.addRule(14);
        r103.addRule(6);
        r103.topMargin = s1.f(10.0f);
        addView(r101, r103);
        ImageView r104 = new ImageView(r110);
        r104.setId(R.id.download_icon);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(-2, -2);
        r105.addRule(8, r113.getId());
        r105.addRule(7, r113.getId());
        r104.setBackgroundResource(R.drawable.ttlive_effect_ic_sticker_download);
        addView(r104, r105);
        ProgressBar r106 = new ProgressBar(r110);
        r106.setId(R.id.loading);
        int r107 = (int) t6.a(r110, 15.0f);
        RelativeLayout.LayoutParams r108 = new RelativeLayout.LayoutParams(r107, r107);
        r108.addRule(14);
        r108.addRule(6);
        r108.topMargin = s1.f(26.5f);
        r106.setVisibility(4);
        addView(r106, r108);
        AttributeSet r109 = null;
        MarqueeTextView r115 = new MarqueeTextView(r110, r109, 6, 0);
        r115.setId(R.id.title);
        r115.setTextColor(s1.h(R.color.liveuikit_cc));
        r115.setTextSize(2, 11.0f);
        r115.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r115.setSingleLine();
        r115.setMaxEms(5);
        r115.setFocusableInTouchMode(true);
        r115.setHorizontalFadingEdgeEnabled(true);
        r115.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams r116 = new RelativeLayout.LayoutParams(-2, -2);
        r116.addRule(14);
        r116.addRule(3, r113.getId());
        r116.topMargin = s1.f(2.0f);
        r116.bottomMargin = s1.f(3.0f);
        addView(r115, r116);
        View r117 = new View(r110);
        r117.setId(R.id.icon_cover);
        int r118 = (int) t6.a(r110, 60.0f);
        RelativeLayout.LayoutParams r119 = new RelativeLayout.LayoutParams(r118, r118);
        r119.topMargin = s1.f(5.0f);
        r119.addRule(10);
        r119.addRule(14);
        r117.setBackgroundColor(s1.h(R.color.ttlive_effect_sticker_item_unavailable_icon_cover_color));
        r117.setVisibility(4);
        addView(r117, r119);
    }

    public /* synthetic */ LiveCommonStickerItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
