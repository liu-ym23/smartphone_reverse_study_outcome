package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\n(B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R>\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00198\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Landroid/view/ViewGroup;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMaxOffsetLeft", "()I", "setMaxOffsetLeft", "(I)V", "maxOffsetLeft", "b", "getMaxOffsetRight", "setMaxOffsetRight", "maxOffsetRight", "", "c", "J", "getRollBackDuration", "()J", "setRollBackDuration", "(J)V", "rollBackDuration", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout$a;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "getChildViews", "()Ljava/util/HashMap;", "setChildViews", "(Ljava/util/HashMap;)V", "childViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseHorizontalPullLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f180472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f180473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f180474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<View, a> f180475d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getType", "()I", "setType", "(I)V", "type", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f180476a;

        public LayoutParams() {
            super(-2, -2);
            this.f180476a = -1;
        }

        public final int getType() {
            return this.f180476a;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f180476a = -1;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f180476a = -1;
            Integer r102 = null;
            if (r100 == null) goto L7;
            Resources.Theme r103 = r100.getTheme();
            if (r103 == null) goto L7;
            TypedArray r104 = r103.obtainStyledAttributes(r101, new int[]{R.attr.layout_content_fixed, R.attr.layout_type}, 0, 0);
        L8:
            if (r104 == null) goto L10;
            r102 = Integer.valueOf(r104.getInt(1, -1));
        L10:
            Intrinsics.checkNotNull(r102);
            this.f180476a = r102.intValue();
            r104.recycle();
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f180477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f180478b;

        public a() {
            this(0);
        }

        public a(int r100) {
            this.f180477a = 0;
            this.f180478b = 0;
        }
    }

    public static final class b {
    }

    static {
    }

    public BaseHorizontalPullLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseHorizontalPullLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean a() {
        View r100 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, 4);
        if (r100 == null) goto L9;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, 0) != null) goto L7;
        return false;
    L7:
        return !r100.canScrollHorizontally(-1);
    L9:
        throw new Exception("Child type \"content\" must be defined!");
    }

    public final boolean b() {
        View r100 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, 4);
        if (r100 == null) goto L10;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, 2) != null) goto L11;
        return false;
    L11:
        return !r100.canScrollHorizontally(1);
    L10:
        throw new Exception("Child type \"content\" must be defined!");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        View r102 = getChildAt(r101);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L12;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, Integer.valueOf(((LayoutParams) r103).getType())) != null) goto L10;
        a r104 = this.f180475d.put(r102, new a(0));
        r101 = r101 + 1;
        goto L3
    L10:
        throw new Exception("Each child type can only be defined once!");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    }

    public final HashMap<View, a> getChildViews() {
        return this.f180475d;
    }

    public final int getMaxOffsetLeft() {
        return this.f180472a;
    }

    public final int getMaxOffsetRight() {
        return this.f180473b;
    }

    public final long getRollBackDuration() {
        return this.f180474c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r100 instanceof LayoutParams) == false) goto L6;
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final void setChildViews(HashMap<View, a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f180475d = r100;
    }

    public final void setMaxOffsetLeft(int r100) {
        this.f180472a = r100;
    }

    public final void setMaxOffsetRight(int r100) {
        this.f180473b = r100;
    }

    public final void setRollBackDuration(long r100) {
        this.f180474c = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        Iterator<Map.Entry<View, a>> r100 = this.f180475d.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L22;
        Map.Entry<View, a> r101 = r100.next();
        View r102 = r101.getKey();
        a r103 = r101.getValue();
        measureChildWithMargins(r102, r110, 0, r111, 0);
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L21;
        LayoutParams r105 = (LayoutParams) r104;
        int r106 = r105.getType();
        if (r106 == 0) goto L12;
        if (r106 != 2) goto L4;
    L12:
        int r107 = (r102.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r105).leftMargin) + ((ViewGroup.MarginLayoutParams) r105).rightMargin;
        r103.f180478b = r107;
        int r108 = this.f180472a;
        if (r108 >= 0) goto L15;
        r108 = r107;
    L15:
        this.f180472a = r108;
        int r109 = this.f180473b;
        if (r109 < 0) goto L19;
        r107 = r109;
    L19:
        this.f180473b = r107;
        goto L4
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    }

    public BaseHorizontalPullLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180474c = 200;
        this.f180475d = new HashMap(4);
        Resources r103 = r100.getResources();
        if (r103 == null) goto L5;
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
    L6:
        int r105 = (int) TypedValue.applyDimension(1, -1.0f, r104);
        Resources.Theme r106 = r100.getTheme();
        if (r106 == null) goto L12;
        TypedArray r107 = r106.obtainStyledAttributes(r101, new int[]{R.attr.max_offset_left, R.attr.max_offset_right}, r102, 0);
        if (r107 == null) goto L13;
        this.f180472a = r107.getDimensionPixelOffset(0, r105);
        this.f180473b = r107.getDimensionPixelOffset(1, r105);
        r107.recycle();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public /* synthetic */ BaseHorizontalPullLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        View r104 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.f180475d, 4);
        if (r104 == null) goto L21;
        int r105 = r104.getMeasuredWidth();
        Iterator<Map.Entry<View, a>> r106 = this.f180475d.entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<View, a> r107 = r106.next();
        View r108 = r107.getKey();
        a r109 = r107.getValue();
        ViewGroup.LayoutParams r111 = r108.getLayoutParams();
        if (r111 == null) goto L18;
        LayoutParams r112 = (LayoutParams) r111;
        int r113 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r112).leftMargin;
        int r114 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r112).topMargin;
        int r115 = r108.getMeasuredWidth() + r113;
        int r116 = r108.getMeasuredHeight() + r114;
        int r117 = r112.getType();
        if (r117 != 0) goto L12;
        int r118 = r109.f180478b;
        r113 = r113 - r118;
        r115 = r115 - r118;
    L16:
        r109.f180477a = r113;
        r109.f180478b = 0;
        r108.layout(r113, r114, r115, r116);
        goto L6
    L12:
        if (r117 != 2) goto L16;
        r113 = r113 + r105;
        r115 = r115 + r105;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    L19:
        return;
    L21:
        throw new Exception("EasyPullLayout must have and only have one layout_type \"content\"!");
    }
}
