package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/VisibilityEventScrollView;", "Landroid/widget/HorizontalScrollView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VisibilityEventScrollView extends HorizontalScrollView {
    public VisibilityEventScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VisibilityEventScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public VisibilityEventScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ VisibilityEventScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        View r104 = (View) CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(this));
        if (r104 == null) goto L19;
        List<View> r105 = com.bytedance.commerce.base.view.b.a(r104);
        if (r105 == null) goto L23;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L8:
        if (r106.hasNext() == false) goto L24;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r110 = (View) r108;
        if ((r110 instanceof TextView) == true) goto L15;
        r110 = null;
    L15:
        TextView r111 = (TextView) r110;
        if (r111 == null) goto L18;
        r111.getLocalVisibleRect(new Rect());
    L18:
        r107 = r109;
        goto L8
    L24:
        return;
    L23:
        return;
    }
}
