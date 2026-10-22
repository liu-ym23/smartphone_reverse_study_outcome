package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001\u001fB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010 ¨\u0006$"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup$LayoutParams;", "p", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "", "Landroid/view/View;", "a", "Ljava/util/List;", "mAllViews", "mLineHeight", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14943c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14945b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14943c = new a(null);
    }

    public SurnameFlowLayout(@Nullable Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f14944a = new ArrayList();
        this.f14945b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        q.g(r10, "p");
        return new ViewGroup.MarginLayoutParams(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        SurnameFlowLayout r10 = this;
        r10.f14944a.clear();
        r10.f14945b.clear();
        int r11 = getWidth();
        ArrayList r12 = new ArrayList();
        int r13 = getChildCount();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r14 >= r13) goto L13;
        int r17 = r14 + 1;
        View r23 = r10.getChildAt(r14);
        ViewGroup.LayoutParams r110 = r23.getLayoutParams();
        if (r110 == null) goto L12;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        int r24 = r23.getMeasuredWidth();
        int r112 = r23.getMeasuredHeight();
        if ((((r111.leftMargin + r24) + r111.rightMargin) + r16) <= r11) goto L10;
        r10.f14945b.add(Integer.valueOf(r15));
        r10.f14944a.add(r12);
        r12 = new ArrayList();
        r16 = 0;
    L10:
        r16 = r16 + ((r24 + r111.leftMargin) + r111.rightMargin);
        r15 = (int) Math.max(r15, (r112 + r111.topMargin) + r111.bottomMargin);
        q.f(r23, "child");
        r12.add(r23);
        r14 = r17;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r10.f14945b.add(Integer.valueOf(r15));
        r10.f14944a.add(r12);
        int r25 = r10.f14944a.size();
        int r26 = 0;
        int r27 = 0;
    L14:
        if (r26 >= r25) goto L26;
        int r28 = r26 + 1;
        List r29 = (List) r10.f14944a.get(r26);
        int r30 = ((Number) r10.f14945b.get(r26)).intValue();
        int r31 = r29.size();
        int r32 = 0;
        int r113 = 0;
    L16:
        if (r32 >= r31) goto L25;
        int r114 = r32 + 1;
        View r33 = (View) r29.get(r32);
        if (r33.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r115 = r33.getLayoutParams();
        if (r115 == null) goto L24;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        int r117 = r116.leftMargin + r113;
        int r118 = r116.topMargin + r27;
        int r119 = r33.getMeasuredWidth() + r117;
        int r34 = r118 + r33.getMeasuredHeight();
        StringBuilder r35 = new StringBuilder();
        r35.append(r33.toString());
        r35.append(" , l = ");
        r35.append(r117);
        r35.append(" , t = ");
        r35.append(r20);
        r35.append(" , r =");
        r35.append(r119);
        r35.append(" , b = ");
        r35.append(r34);
        Log.e("FlowLayout", r35.toString());
        r33.layout(r117, r118, r119, r34);
        r113 = r113 + ((r33.getMeasuredWidth() + r116.rightMargin) + r116.leftMargin);
        r25 = r25;
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r32 = r114;
        goto L16
    L25:
        r27 = r27 + r30;
        r10 = this;
        r26 = r28;
        goto L14
    }

    @Override // android.view.View
    public void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        int r10 = View.MeasureSpec.getSize(r19);
        int r11 = View.MeasureSpec.getSize(r20);
        int r12 = View.MeasureSpec.getMode(r19);
        int r13 = View.MeasureSpec.getMode(r20);
        StringBuilder r14 = new StringBuilder();
        r14.append(r10);
        r14.append(',');
        r14.append(r11);
        Log.e("FlowLayout", r14.toString());
        int r15 = getChildCount();
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r21 = 0;
        int r110 = 0;
    L3:
        if (r16 >= r15) goto L16;
        int r111 = r16 + 1;
        View r112 = getChildAt(r16);
        measureChild(r112, r19, r20);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L15;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        int r115 = r11;
        int r22 = (r112.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        int r116 = r17;
        int r117 = (r112.getMeasuredHeight() + r114.topMargin) + r114.bottomMargin;
        int r23 = r18 + r22;
        if (r23 <= r10) goto L9;
        r17 = (int) Math.max(r18, r22);
        r110 = r110 + r21;
        r18 = r22;
        r21 = r117;
    L11:
        if (r16 != (r15 - 1)) goto L13;
        r17 = (int) Math.max(r17, r18);
        r110 = r110 + r21;
    L13:
        r16 = r111;
        r11 = r115;
        goto L3
    L9:
        r21 = (int) Math.max(r21, r117);
        r18 = r23;
        r17 = r116;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r118 = r11;
        int r119 = r17;
        if (r12 == 1073741824) goto L20;
        r10 = r119;
    L20:
        if (r13 != 1073741824) goto L22;
        int r24 = r118;
    L23:
        setMeasuredDimension(r10, r24);
        return;
    L22:
        r24 = r110;
        goto L23
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        q.g(r10, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }
}
