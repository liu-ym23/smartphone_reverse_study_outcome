package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/MiaoShaPriceLabelView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiaoShaPriceLabelView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f177635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f177636c;

    public MiaoShaPriceLabelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MiaoShaPriceLabelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        r101.append("¥");
        boolean r102 = false;
        r101.setSpan(new AbsoluteSizeSpan(this.f177634a), 0, r101.length(), 17);
        if (r100.length() != 0) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        return;
    L9:
        r101.append(r100);
        r101.setSpan(new AbsoluteSizeSpan(this.f177635b), 1, r101.length(), 17);
        this.f177636c.setText(r101);
    }

    public MiaoShaPriceLabelView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        SimpleDraweeView r113 = new SimpleDraweeView(r110);
        r113.setBackground(ContextCompat.getDrawable(r110, R.drawable.shopping_homepage_miaosha_price_icon));
        Unit r100 = Unit.INSTANCE;
        int r101 = c.f47296a;
        this.f177634a = c.c(10, r110, true);
        this.f177635b = c.c(13, r110, true);
        AppCompatTextView r102 = new AppCompatTextView(r110);
        r102.setTextColor(ContextCompat.getColor(r110, R.color.shopping_home_color_FF3344));
        a.c();
        r102.setPadding(c.c(1, r110, true), 0, c.c(1, r110, true), 0);
        this.f177636c = r102;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
        setGravity(16);
        setPaddingRelative(c.c(4, r110, true), 0, c.c(10, r110, true), 0);
        BackgroundDrawable r103 = new BackgroundDrawable(r110, r111, false, 4, null);
        r103.setBgColor(ColorProtector.parseColor("#FFF4ED"));
        r103.setStrokeWidth(c.c(Double.valueOf(0.5d), r110, true));
        r103.setCornerRadius(c.c(100, r110, true));
        r103.invalidate();
        setBackground(r103);
        addView(r113, new LinearLayout.LayoutParams(-2, -2));
        addView(r102, new LinearLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ MiaoShaPriceLabelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
