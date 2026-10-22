package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gf3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/SinglePriceLabelView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lgf3/b;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SinglePriceLabelView extends AppCompatTextView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f177638b;

    public SinglePriceLabelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SinglePriceLabelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // gf3.b
    public final View i() {
        return this;
    }

    @Override // gf3.b
    public final void s(ChannelVO r100, int r110) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        int r102 = this.f177638b;
        Typeface r103 = null;
        if (r100 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r100.showItemPrice(r110));
    L6:
        if (r100 == null) goto L8;
        Boolean r105 = Boolean.valueOf(r100.showItemTag(r110));
    L9:
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r106) == false) goto L12;
        r101.append("¥");
        r102 = this.f177637a;
    L12:
        if (r100 == null) goto L14;
        String r107 = r100.getItemPriceOrTag(r110);
    L15:
        boolean r111 = true;
        if (r107 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == false) goto L24;
        r101 = null;
    L34:
        if (r101 != null) goto L36;
    L39:
        if (r111 == true) goto L41;
        setText(r101);
        setVisibility(0);
        return;
    L41:
        setVisibility(8);
        return;
    L36:
        if (r101.length() == 0) goto L39;
        r111 = false;
        goto L39
    L24:
        r101.append(r107);
        r101.setSpan(new ForegroundColorSpan(r102), 0, r101.length(), 17);
        if (Build.VERSION.SDK_INT < 28) goto L34;
        if (Intrinsics.areEqual(r104, r106) == false) goto L30;
        a.c();
    L32:
        if (r103 == null) goto L34;
        r101.setSpan(new TypefaceSpan(r103), 0, r101.length(), 17);
        goto L34
    L30:
        if (Intrinsics.areEqual(r105, r106) == false) goto L32;
        r103 = Typeface.create(Typeface.create("PingFang SC", 0), 600, false);
        goto L32
    L18:
        if (r107.length() == 0) goto L21;
        r108 = false;
        goto L22
    L14:
        r107 = null;
        goto L15
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public SinglePriceLabelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f177637a = ContextCompat.getColor(r100, R.color.shopping_home_color_FF3344);
        this.f177638b = ContextCompat.getColor(r100, R.color.shopping_home_color_BF161823);
        setTextColor(ContextCompat.getColor(r100, R.color.shopping_home_color_FF3344));
        a.c();
        setGravity(17);
    }

    public /* synthetic */ SinglePriceLabelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
