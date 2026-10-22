package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurnameFlowLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAllViews", "", "Landroid/view/View;", "mLineHeight", "", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameFlowLayout extends ViewGroup {
    public static final Companion Companion = null;
    private static final String TAG = "FlowLayout";
    private final List<List<View>> mAllViews;
    private final List<Integer> mLineHeight;

    /* JADX INFO: compiled from: SurnameFlowLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SurnameFlowLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAllViews = new ArrayList();
        this.mLineHeight = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        Intrinsics.checkNotNullParameter(r1, "p");
        return new ViewGroup.MarginLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r2, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    protected void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        int r1 = View.MeasureSpec.getSize(r19);
        int r2 = View.MeasureSpec.getSize(r20);
        int r3 = View.MeasureSpec.getMode(r19);
        int r4 = View.MeasureSpec.getMode(r20);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, new StringBuilder().append(r1).append(',').append(r2).toString());
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r6 >= r5) goto L16;
        int r11 = r6 + 1;
        View r12 = getChildAt(r6);
        measureChild(r12, r19, r20);
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if (r15 == null) goto L15;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        int r17 = r2;
        int r13 = (r12.getMeasuredWidth() + r16.leftMargin) + r16.rightMargin;
        int r18 = r7;
        int r14 = (r12.getMeasuredHeight() + r16.topMargin) + r16.bottomMargin;
        int r21 = r8 + r13;
        if (r21 <= r1) goto L9;
        r7 = (int) Math.max(r8, r13);
        r10 = r10 + r9;
        r8 = r13;
        r9 = r14;
    L11:
        if (r6 != (r5 - 1)) goto L13;
        r7 = (int) Math.max(r7, r8);
        r10 = r10 + r9;
    L13:
        r6 = r11;
        r2 = r17;
        goto L3
    L9:
        r9 = (int) Math.max(r9, r14);
        r8 = r21;
        r7 = r18;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r110 = r2;
        int r111 = r7;
        if (r3 == 1073741824) goto L20;
        r1 = r111;
    L20:
        if (r4 != 1073741824) goto L22;
        int r22 = r110;
    L23:
        setMeasuredDimension(r1, r22);
        return;
    L22:
        r22 = r10;
        goto L23
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        SurnameFlowLayout r0 = this;
        r0.mAllViews.clear();
        r0.mLineHeight.clear();
        int r1 = getWidth();
        ArrayList r2 = new ArrayList();
        int r3 = getChildCount();
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5 >= r3) goto L13;
        int r9 = r5 + 1;
        View r8 = r0.getChildAt(r5);
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if (r10 == null) goto L12;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        int r12 = r8.getMeasuredWidth();
        int r13 = r8.getMeasuredHeight();
        if ((((r11.leftMargin + r12) + r11.rightMargin) + r7) <= r1) goto L10;
        r0.mLineHeight.add(Integer.valueOf(r6));
        r0.mAllViews.add(r2);
        r2 = new ArrayList();
        r7 = 0;
    L10:
        r7 = r7 + ((r12 + r11.leftMargin) + r11.rightMargin);
        r6 = (int) Math.max(r6, (r13 + r11.topMargin) + r11.bottomMargin);
        Intrinsics.checkNotNullExpressionValue(r8, "child");
        r2.add(r8);
        r5 = r9;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r0.mLineHeight.add(Integer.valueOf(r6));
        r0.mAllViews.add(r2);
        int r4 = r0.mAllViews.size();
        int r14 = 0;
        int r15 = 0;
    L14:
        if (r14 >= r4) goto L26;
        int r16 = r14 + 1;
        List<View> r17 = r0.mAllViews.get(r14);
        int r23 = r0.mLineHeight.get(r14).intValue();
        int r24 = r17.size();
        int r25 = 0;
        int r110 = 0;
    L16:
        if (r25 >= r24) goto L25;
        int r111 = r25 + 1;
        View r26 = r17.get(r25);
        if (r26.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r112 = r26.getLayoutParams();
        if (r112 == null) goto L24;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r114 = r113.leftMargin + r110;
        int r115 = r113.topMargin + r15;
        int r116 = r26.getMeasuredWidth() + r114;
        int r27 = r115 + r26.getMeasuredHeight();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r26.toString() + " , l = " + r114 + " , t = " + r20 + " , r =" + r116 + " , b = " + r27);
        r26.layout(r114, r115, r116, r27);
        r110 = r110 + ((r26.getMeasuredWidth() + r113.rightMargin) + r113.leftMargin);
        r4 = r4;
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r25 = r111;
        goto L16
    L25:
        r15 = r15 + r23;
        r0 = this;
        r14 = r16;
        goto L14
    }
}
