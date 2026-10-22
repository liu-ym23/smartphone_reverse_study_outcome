package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4PriceViewContainer;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PriceViewContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f167933a;

    public AnchorV4PriceViewContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4PriceViewContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setMaxWidth(int r100) {
        this.f167933a = r100;
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        List<View> r102 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L13;
        Object r106 = r104.next();
        if (((View) r106).getVisibility() != 0) goto L11;
        r105 = true;
    L11:
        if (r105 == false) goto L6;
        r103.add(r106);
        goto L6
    L13:
        Iterator r107 = r103.iterator();
        int r108 = 0;
    L14:
        ViewGroup.LayoutParams r109 = null;
        if (r107.hasNext() == false) goto L24;
        View r110 = (View) r107.next();
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r109 = r111;
    L20:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r109;
        if (r112 == null) goto L23;
        r108 = r108 + (r112.leftMargin + r112.rightMargin);
    L23:
        r108 = r108 + r110.getMeasuredWidth();
        goto L14
    L24:
        int r113 = Math.min(getMeasuredWidth(), r108);
        int r114 = this.f167933a;
        if (1 > r114) goto L49;
        if (r113 <= r114) goto L46;
        setOrientation(1);
        View r115 = (View) CollectionsKt.getOrNull(r103, 1);
        if (r115 == null) goto L47;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        r109 = r116;
    L34:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r109;
        if (r117 == null) goto L48;
        r117.leftMargin = 0;
        r115.setLayoutParams(r117);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    }

    public AnchorV4PriceViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AnchorV4PriceViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
