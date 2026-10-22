package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemProduct;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/ChannelCardView11;", "Landroid/widget/LinearLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTitleSdView", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "b", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "getContentView", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "contentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardView11 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f177594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChannelItemProduct f177595b;

    public ChannelCardView11(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelCardView11(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ChannelItemProduct getContentView() {
        return this.f177595b;
    }

    public final SimpleDraweeView getTitleSdView() {
        return this.f177594a;
    }

    public ChannelCardView11(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        SimpleDraweeView r103 = new SimpleDraweeView(r100);
        this.f177594a = r103;
        AttributeSet r104 = null;
        ChannelItemProduct r105 = new ChannelItemProduct(r100, r104, 6, 0);
        this.f177595b = r105;
        int r106 = c.f47296a;
        setLayoutParams(new LinearLayout.LayoutParams(-1, c.c(94, r100, true)));
        setOrientation(1);
        setBackgroundColor(ContextCompat.getColor(r100, R.color.shopping_home_color_FFFFFF));
        addView(r103, new LinearLayout.LayoutParams(c.c(82, r100, true), c.c(24, r100, true)));
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(c.c(60, r100, true), c.c(60, r100, true));
        r107.topMargin = c.c(2, r100, true);
        r107.setMarginStart(c.c(15, r100, true));
        Unit r108 = Unit.INSTANCE;
        addView(r105, r107);
    }

    public /* synthetic */ ChannelCardView11(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
