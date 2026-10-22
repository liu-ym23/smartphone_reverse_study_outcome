package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

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

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemInfoWidgetContainer;", "Landroid/widget/LinearLayout;", "Lij2/b;", "Lij2/a;", "getCurrentWidget", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemInfoWidgetContainer extends LinearLayout implements ij2.b {
    public ListItemInfoWidgetContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ListItemInfoWidgetContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // ij2.b
    public final void b() {
        d();
        removeAllViews();
    }

    @Override // ij2.b
    public final boolean c() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d() {
        List<View> r100 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof ij2.a) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((ij2.a) r104.next()).release();
        goto L10
    }

    @Override // ij2.b
    public ij2.a getCurrentWidget() {
        Object r100 = CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(this));
        if ((r100 instanceof ij2.a) == true) goto L6;
        r100 = null;
    L6:
        return (ij2.a) r100;
    }

    @Override // ij2.b
    public final void hide() {
        if (getVisibility() == 8) goto L6;
        setVisibility(8);
        return;
    }

    @Override // ij2.b
    public final void show() {
        if (getVisibility() == 0) goto L6;
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ij2.b
    public final void a(ij2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof View) == false) goto L6;
        addView((View) r100, new ViewGroup.LayoutParams(-1, -2));
        return;
    }

    public ListItemInfoWidgetContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ListItemInfoWidgetContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
