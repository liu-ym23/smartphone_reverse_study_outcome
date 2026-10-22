package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import gf3.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/Common31ChannelCardLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTitleSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "titleSdView", "", "Lgf3/a;", "d", "Ljava/util/List;", "getProductContentList", "()Ljava/util/List;", "productContentList", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Common31ChannelCardLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f177631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f177632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f177633d;

    public Common31ChannelCardLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public Common31ChannelCardLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final List<a> getProductContentList() {
        return this.f177633d;
    }

    public final SimpleDraweeView getTitleSdView() {
        return this.f177632c;
    }

    public final void a(List r110) {
        Intrinsics.checkNotNullParameter(r110, "itemViewList");
        int r100 = r110.size();
        double r101 = (161.75d - ((double) (r100 * 48))) / ((double) (r100 - 1));
        LinearLayout r102 = new LinearLayout(getContext());
        r102.setOrientation(0);
        Iterator r111 = r110.iterator();
        int r103 = 0;
    L4:
        if (r111.hasNext() == false) goto L12;
        Object r104 = r111.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r106 = (a) r104;
        View r107 = r106.i();
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(this.f177630a, this.f177631b);
        r108.gravity = 16;
        if (r103 == 0) goto L11;
        int r109 = c.f47296a;
        r108.setMarginStart(c.c(Double.valueOf(r101), r102.getContext(), true));
    L11:
        Unit r112 = Unit.INSTANCE;
        r102.addView(r107, r108);
        ((ArrayList) this.f177633d).add(r106);
        r103 = r105;
        goto L4
    L12:
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-1, -1);
        int r114 = c.f47296a;
        r113.setMargins(0, c.c(6, getContext(), true), 0, 0);
        Unit r115 = Unit.INSTANCE;
        addView(r102, r113);
    }

    public Common31ChannelCardLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = c.f47296a;
        this.f177630a = c.c(48, r100, true);
        this.f177631b = c.c(62, r100, true);
        SimpleDraweeView r104 = new SimpleDraweeView(r100);
        this.f177632c = r104;
        this.f177633d = new ArrayList();
        setClipChildren(false);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.c.a(this, r100, r101);
        setPaddingRelative(c.c(8, r100, true), c.c(0, r100, true), c.c(8, r100, true), c.c(8, r100, true));
        setOrientation(1);
        r104.setId(ViewCompat.generateViewId());
        addView(r104, -1, c.c(24, r100, true));
    }

    public /* synthetic */ Common31ChannelCardLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
