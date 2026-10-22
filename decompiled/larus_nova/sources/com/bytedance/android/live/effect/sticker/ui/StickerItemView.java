package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.t6;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerItemView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerItemView extends RelativeLayout {
    public StickerItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public StickerItemView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r100 = new View(r110);
        r100.setId(R.id.select_border);
        int r101 = (int) t6.a(r110, 58.0f);
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(r101, r101);
        r102.topMargin = s1.f(5.0f);
        r102.addRule(10);
        r102.addRule(14);
        r100.setBackgroundResource(R.drawable.ttlive_effect_bg_dialog_gesture_select_v2);
        r100.setVisibility(4);
        addView(r100, r102);
        ImageView r103 = new ImageView(r110);
        r103.setId(R.id.image);
        t6.a(r110, 8.0f);
        int r104 = (int) t6.a(r110, 54.0f);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(r104, r104);
        r105.addRule(14);
        int r106 = 6;
        r105.addRule(6);
        r105.topMargin = s1.f(7.0f);
        r103.setImageResource(R.drawable.ttlive_effect_ic_gesture_yeah);
        addView(r103, r105);
        View r107 = new View(r110);
        r107.setId(R.id.dot);
        int r113 = (int) t6.a(r110, 6.0f);
        RelativeLayout.LayoutParams r114 = new RelativeLayout.LayoutParams(r113, r113);
        r114.addRule(6, r103.getId());
        r114.addRule(7, r103.getId());
        r107.setBackgroundResource(R.drawable.ttlive_effect_core_bg_red_point);
        r107.setVisibility(4);
        addView(r107, r114);
        ImageView r108 = new ImageView(r110);
        r108.setId(R.id.download_icon);
        RelativeLayout.LayoutParams r115 = new RelativeLayout.LayoutParams(-2, -2);
        r115.addRule(8, r103.getId());
        r115.addRule(7, r103.getId());
        r108.setBackgroundResource(R.drawable.ttlive_effect_ic_sticker_download);
        addView(r108, r115);
        ProgressBar r109 = new ProgressBar(r110);
        r109.setId(R.id.loading);
        int r116 = (int) t6.a(r110, 15.0f);
        RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(r116, r116);
        r117.addRule(14);
        r117.addRule(6);
        r117.topMargin = s1.f(26.5f);
        r109.setVisibility(4);
        addView(r109, r117);
        AttributeSet r118 = null;
        int r119 = 0;
        MarqueeTextView r120 = new MarqueeTextView(r110, r118, r106, r119);
        r120.setId(R.id.title);
        r120.setTextColor(s1.h(R.color.liveuikit_cc));
        r120.setTextSize(2, 10.0f);
        r120.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r120.setSingleLine();
        r120.setMaxEms(5);
        r120.setFocusableInTouchMode(true);
        r120.setHorizontalFadingEdgeEnabled(true);
        r120.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams r121 = new RelativeLayout.LayoutParams(-2, -2);
        r121.addRule(14);
        r121.addRule(3, r103.getId());
        r121.topMargin = s1.f(2.0f);
        r121.bottomMargin = s1.f(3.0f);
        addView(r120, r121);
        MarqueeTextView r122 = new MarqueeTextView(r110, r118, r106, r119);
        r122.setId(R.id.sticker_item_view_tips);
        r122.setTextColor(s1.h(R.color.ttlive_effect_multi_anchor_tips_text_color));
        r122.setTextSize(2, 8.0f);
        r122.setWidth(s1.f(39.0f));
        r122.setHeight(s1.f(14.0f));
        r122.setGravity(17);
        r122.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r122.setBackgroundResource(R.drawable.ttlive_effect_bg_dialog_top_tips);
        r122.setText("主播在用");
        r122.setVisibility(8);
        r122.setSingleLine();
        r122.setMaxEms(5);
        r122.setFocusableInTouchMode(true);
        r122.setHorizontalFadingEdgeEnabled(true);
        RelativeLayout.LayoutParams r123 = new RelativeLayout.LayoutParams(-2, -2);
        r123.addRule(6, r103.getId());
        r123.addRule(7, r103.getId());
        r123.topMargin = s1.f(3.0f);
        r123.rightMargin = s1.f(3.0f);
        addView(r122, r123);
        View r124 = new View(r110);
        r124.setId(R.id.icon_cover);
        int r125 = (int) t6.a(r110, 60.0f);
        RelativeLayout.LayoutParams r126 = new RelativeLayout.LayoutParams(r125, r125);
        r126.topMargin = s1.f(5.0f);
        r126.addRule(10);
        r126.addRule(14);
        r124.setBackgroundColor(s1.h(R.color.ttlive_effect_sticker_item_unavailable_icon_cover_color));
        r124.setVisibility(4);
        addView(r124, r126);
    }

    public /* synthetic */ StickerItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
