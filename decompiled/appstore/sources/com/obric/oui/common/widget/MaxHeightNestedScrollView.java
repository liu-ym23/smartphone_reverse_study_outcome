package com.obric.oui.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import bg.h;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "setMaxHeight", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "a", "I", "maxHeightPx", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaxHeightNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13094a;

    @JvmOverloads
    public MaxHeightNestedScrollView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f13094a == Integer.MAX_VALUE) goto L5;
        int r12 = View.MeasureSpec.getMode(r11);
        r11 = View.MeasureSpec.makeMeasureSpec(h.g(View.MeasureSpec.getSize(r11), this.f13094a), r12);
    L5:
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() <= this.f13094a) goto L9;
        setMeasuredDimension(getMeasuredWidth(), this.f13094a);
        return;
    }

    public final void setMaxHeight(int r10) {
        if (this.f13094a != r10) goto L5;
        return;
    L5:
        this.f13094a = r10;
        requestLayout();
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f13094a = Channel.UNLIMITED;
        if (r11 == null) goto L6;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{R.attr.maxHeight});
        q.f(r13, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.f13094a = r13.getDimensionPixelSize(0, Channel.UNLIMITED);
        r13.recycle();
        return;
    }
}
