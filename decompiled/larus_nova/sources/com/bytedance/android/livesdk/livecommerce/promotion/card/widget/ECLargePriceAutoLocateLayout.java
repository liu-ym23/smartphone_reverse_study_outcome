package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u00010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$AutoLocateMode;", "mode", "", "setMode", "", "Lkotlin/Pair;", "Landroid/view/View;", "", "showSequence", "setCustomHideSequence", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AutoLocateMode", "LayoutParams", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECLargePriceAutoLocateLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AutoLocateMode f150416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f150417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Pair<? extends View, Boolean>> f150418c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$AutoLocateMode;", "", "HIDE_MODE", "REVERSE_MODE", "CUSTOM_MODE", "DEFAULT_MODE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AutoLocateMode extends Enum<AutoLocateMode> {
        public static final AutoLocateMode CUSTOM_MODE = null;
        public static final AutoLocateMode DEFAULT_MODE = null;
        public static final AutoLocateMode HIDE_MODE = null;
        public static final AutoLocateMode REVERSE_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AutoLocateMode[] f150419a = null;

        static {
            AutoLocateMode r100 = new AutoLocateMode("HIDE_MODE", 0);
            HIDE_MODE = r100;
            AutoLocateMode r101 = new AutoLocateMode("REVERSE_MODE", 1);
            REVERSE_MODE = r101;
            AutoLocateMode r102 = new AutoLocateMode("CUSTOM_MODE", 2);
            CUSTOM_MODE = r102;
            AutoLocateMode r103 = new AutoLocateMode("DEFAULT_MODE", 3);
            DEFAULT_MODE = r103;
            f150419a = new AutoLocateMode[]{r100, r101, r102, r103};
        }

        public static AutoLocateMode valueOf(String r100) {
            return (AutoLocateMode) r27.a.a(AutoLocateMode.class, r100);
        }

        public static AutoLocateMode[] values() {
            return (AutoLocateMode[]) f150419a.clone();
        }

        public AutoLocateMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f150420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f150421b;

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "attrs");
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_orderInHorizontal, R.attr.layout_orderInVertical});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L10;
            int r105 = r102.getIndex(r104);
            if (r105 != 1) goto L7;
            this.f150420a = r102.getInteger(r105, 0);
        L9:
            r104 = r104 + 1;
            goto L3
        L7:
            if (r105 != 0) goto L9;
            this.f150421b = r102.getInteger(r105, 0);
            goto L9
        L10:
            r102.recycle();
        }
    }

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f150422a;

        public a(boolean r100) {
            this.f150422a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            View r102 = (View) r101;
            ViewGroup.LayoutParams r103 = ((View) r100).getLayoutParams();
            if (r103 == null) goto L19;
            LayoutParams r104 = (LayoutParams) r103;
            if (this.f150422a == false) goto L7;
            int r105 = r104.f150421b;
        L8:
            ViewGroup.LayoutParams r106 = r102.getLayoutParams();
            if (r106 == null) goto L17;
            LayoutParams r107 = (LayoutParams) r106;
            if (this.f150422a == false) goto L13;
            int r108 = r107.f150421b;
        L15:
            return r105 - r108;
        L13:
            r108 = r107.f150420a;
            goto L15
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
        L7:
            r105 = r104.f150420a;
            goto L8
        L19:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
        }
    }

    public ECLargePriceAutoLocateLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECLargePriceAutoLocateLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100) {
        int r101 = getChildCount();
        boolean r102 = true;
        if (r101 > 1) goto L5;
    L4:
        r102 = false;
    L26:
        if (r102 == false) goto L55;
        ArrayList r103 = new ArrayList();
        r103.addAll(com.bytedance.commerce.base.view.b.a(this));
        CollectionsKt.sortWith(r103, new a(r100));
        removeAllViews();
        Iterator r104 = r103.iterator();
    L29:
        if (r104.hasNext() == false) goto L65;
        View r105 = (View) r104.next();
        if (r100 == false) goto L33;
    L42:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L54;
        LayoutParams r107 = (LayoutParams) r106;
        if (r100 == false) goto L51;
        Object r108 = r105.getTag();
        if (r108 == null) goto L50;
        int r109 = ((Integer) r108).intValue();
    L52:
        ((LinearLayout.LayoutParams) r107).leftMargin = r109;
        addView(r105);
        goto L29
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L51:
        r109 = 0;
        goto L52
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    L33:
        if (r105.getTag() != null) goto L42;
        ViewGroup.LayoutParams r110 = r105.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r110 = null;
    L37:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L40;
        int r112 = r111.leftMargin;
    L41:
        r105.setTag(Integer.valueOf(r112));
        goto L42
    L40:
        r112 = 0;
        goto L41
    L65:
        return;
    L55:
        return;
    L5:
        int r113 = 1;
    L6:
        if (r113 >= r101) goto L4;
        View r114 = getChildAt(r113 - 1);
        View r115 = getChildAt(r113);
        ViewGroup.LayoutParams r116 = r114.getLayoutParams();
        if (r116 == null) goto L25;
        LayoutParams r117 = (LayoutParams) r116;
        if (r100 == false) goto L12;
        int r118 = r117.f150421b;
    L13:
        ViewGroup.LayoutParams r119 = r115.getLayoutParams();
        if (r119 == null) goto L23;
        LayoutParams r120 = (LayoutParams) r119;
        if (r100 == false) goto L18;
        int r121 = r120.f150421b;
    L19:
        if (r121 < r118) goto L26;
        r113 = r113 + 1;
        goto L6
    L18:
        r121 = r120.f150420a;
        goto L19
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    L12:
        r118 = r117.f150420a;
        goto L13
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        Intrinsics.checkNotNullParameter(r100, "attrs");
        return new LayoutParams(getContext(), r100);
    }

    public final void setCustomHideSequence(List<? extends Pair<? extends View, Boolean>> r100) {
        this.f150416a = AutoLocateMode.CUSTOM_MODE;
        this.f150418c = r100;
    }

    public final void setMode(AutoLocateMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f150416a = r100;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        Intrinsics.checkNotNullParameter(r100, "attrs");
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        this.f150417b = -1;
        if (this.f150416a != AutoLocateMode.CUSTOM_MODE) goto L8;
        List<? extends Pair<? extends View, Boolean>> r101 = this.f150418c;
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L9:
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r103 >= r102) goto L44;
        ViewGroup.LayoutParams r106 = null;
        if (this.f150416a != AutoLocateMode.CUSTOM_MODE) goto L20;
        List<? extends Pair<? extends View, Boolean>> r107 = this.f150418c;
        if (r107 == null) goto L19;
        Pair r108 = (Pair) ListProtector.get(r107, r103);
        if (r108 == null) goto L19;
        View r109 = (View) r108.getFirst();
    L21:
        if (r109 == null) goto L43;
        if (r109.getVisibility() == 8) goto L43;
        r109.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r111);
        int r112 = r109.getMeasuredWidth();
        ViewGroup.LayoutParams r113 = r109.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
        r113 = null;
    L27:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L30;
        int r115 = r114.leftMargin;
    L31:
        int r116 = r112 + r115;
        ViewGroup.LayoutParams r117 = r109.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        r106 = r117;
    L35:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r106;
        if (r118 == null) goto L38;
        int r119 = r118.rightMargin;
    L39:
        int r120 = r116 + r119;
        if (r120 > (((r100 - getPaddingLeft()) - getPaddingRight()) - r104)) goto L41;
        r104 = r104 + r120;
        r105 = Math.max(r105, r109.getMeasuredHeight());
        goto L43
    L41:
        this.f150417b = r103;
        boolean r121 = false;
    L45:
        if (r121 == true) goto L47;
        int r122 = d.f150458a[this.f150416a.ordinal()];
        if (r122 == 1) goto L59;
        if (r122 == 2) goto L56;
    L61:
        super.onMeasure(r110, r111);
        return;
    L56:
        if (getOrientation() == 1) goto L61;
        a(false);
        setOrientation(1);
        goto L61
    L59:
        if (getOrientation() == 0) goto L61;
        a(true);
        setOrientation(0);
        goto L61
    L47:
        if (getOrientation() == 0) goto L49;
        a(true);
        setOrientation(0);
    L49:
        super.onMeasure(r110, r111);
        return;
    L38:
        r119 = 0;
        goto L39
    L30:
        r115 = 0;
    L43:
        r103 = r103 + 1;
    L19:
        r109 = null;
        goto L21
    L20:
        r109 = getChildAt(r103);
        goto L21
    L44:
        r121 = true;
        goto L45
    L7:
        r102 = 0;
        goto L9
    L8:
        r102 = getChildCount();
        goto L9
    }

    public ECLargePriceAutoLocateLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        this.f150416a = AutoLocateMode.HIDE_MODE;
        this.f150417b = -1;
    }

    public /* synthetic */ ECLargePriceAutoLocateLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        super.onLayout(r100, r110, r111, r112, r113);
        AutoLocateMode r101 = this.f150416a;
        if (r101 != AutoLocateMode.HIDE_MODE) goto L15;
        int r102 = getChildCount() - 1;
    L5:
        if (r102 < 1) goto L69;
        View r114 = getChildAt(r102);
        if (r114.getVisibility() == 8) goto L13;
        int r115 = this.f150417b;
        if (r115 < 0) goto L70;
        if (r102 < r115) goto L71;
        r114.layout(r114.getLeft(), r114.getTop(), r114.getLeft(), r114.getBottom());
        goto L13
    L71:
        return;
    L70:
        return;
    L13:
        r102 = r102 - 1;
        goto L5
    L69:
        return;
    L15:
        if (r101 != AutoLocateMode.CUSTOM_MODE) goto L53;
        List<? extends Pair<? extends View, Boolean>> r103 = this.f150418c;
        if (r103 != null) goto L19;
        return;
    L19:
        if (this.f150417b <= 0) goto L68;
        int r116 = r103.size() - this.f150417b;
        List<? extends Pair<? extends View, Boolean>> r104 = r103;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r118 = r104.iterator();
    L22:
        if (r118.hasNext() == false) goto L24;
        r117.add((View) ((Pair) r118.next()).getFirst());
        goto L22
    L24:
        List r119 = CollectionsKt.takeLast(r117, r116);
        int r120 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        boolean r107 = false;
    L25:
        if (r105 >= r120) goto L72;
        View r108 = getChildAt(r105);
        Iterator<T> r109 = r104.iterator();
    L27:
        ViewGroup.LayoutParams r121 = null;
        if (r109.hasNext() == false) goto L32;
        Object r122 = r109.next();
        if (Intrinsics.areEqual((View) ((Pair) r122).getFirst(), r108) == false) goto L27;
    L33:
        Pair r123 = (Pair) r122;
        if (r123 == null) goto L36;
        Boolean r124 = (Boolean) r123.getSecond();
    L38:
        if (r119.contains(r108) == true) goto L40;
    L50:
        if (r107 == false) goto L52;
        r108.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r125 = r108.getMeasuredWidth() - (r108.getRight() - r108.getLeft());
        r108.layout(r108.getLeft() - r106, r108.getTop() - (r108.getMeasuredHeight() - (r108.getBottom() - r108.getTop())), (r108.getRight() - r106) + r125, r108.getBottom());
    L52:
        r105 = r105 + 1;
        goto L25
    L40:
        if (Intrinsics.areEqual(r124, Boolean.TRUE) == false) goto L50;
        int r126 = r108.getRight() - r108.getLeft();
        ViewGroup.LayoutParams r127 = r108.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        r121 = r127;
    L45:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r121;
        if (r128 == null) goto L48;
        int r129 = r128.leftMargin;
    L49:
        r106 = r106 + (r126 + r129);
        r108.layout(r108.getLeft(), r108.getTop(), r108.getLeft(), r108.getBottom());
        r107 = true;
        goto L52
    L48:
        r129 = 0;
        goto L49
    L36:
        r124 = null;
        goto L38
    L32:
        r122 = null;
        goto L33
    L72:
        return;
    L68:
        return;
    }
}
