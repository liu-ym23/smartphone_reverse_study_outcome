package com.bytedance.android.window.shop.widget.childcategory;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0015\b\u0016\u0017B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Landroid/view/View;", "views", "", "setConstraintChild", "Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "b", "Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "getOnSelectionChangedListener", "()Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;", "setOnSelectionChangedListener", "(Lcom/bytedance/android/window/shop/widget/childcategory/HorizontalWeightedGroupView$d;)V", "onSelectionChangedListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalWeightedGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f190000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f190001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<WindowChildCategoryVO.ChildCategoryVO, a> f190002c;

    public static final class a extends FrameLayout {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f190003f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f190004g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f190005h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatTextView f190006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatTextView f190007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatTextView f190008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f190009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f190010e;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView$a$a, reason: collision with other inner class name */
        public static final class C2764a {
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f190011a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f190012b;

            public b(a r100, int r101) {
                this.f190011a = r100;
                this.f190012b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f190011a.c(this.f190012b, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f190003f = ViewCompat.generateViewId();
            f190004g = ViewCompat.generateViewId();
            f190005h = ViewCompat.generateViewId();
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            super(r100);
            AppCompatTextView r101 = d(f190003f);
            int r102 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
            r101.setPadding(0, 0, com.bytedance.android.ec.hybrid.list.util.c.d(2), 0);
            Unit r103 = Unit.INSTANCE;
            this.f190006a = r101;
            AppCompatTextView r104 = d(f190004g);
            this.f190007b = r104;
            AppCompatTextView r105 = d(f190005h);
            r105.setPadding(com.bytedance.android.ec.hybrid.list.util.c.d(2), 0, 0, 0);
            this.f190008c = r105;
            this.f190009d = RangesKt.coerceAtLeast(com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(0.5d)), 1);
            View r106 = new View(getContext());
            this.f190010e = r106;
            FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
            r107.gravity = 17;
            addView(r106, new FrameLayout.LayoutParams(-1, -1));
            LinearLayout r108 = new LinearLayout(getContext());
            r108.addView(r101);
            r108.addView(r104);
            r108.addView(r105);
            addView(r108, r107);
        }

        public final void a(WindowChildCategoryVO.ChildCategoryVO r100) {
            Intrinsics.checkNotNullParameter(r100, "vo");
            if (r100.getSelected() == false) goto L5;
            WindowChildCategoryVO.ChildCategoryItemVO r101 = r100.getSelectedItem();
        L6:
            b(this.f190006a, r101.getPrefix());
            b(this.f190007b, r101.getTitle());
            b(this.f190008c, r101.getSuffix());
            c(r101.getBgColor(), true);
            return;
        L5:
            r101 = r100.getUnselectedItem();
            goto L6
        }

        public final AppCompatTextView d(int r100) {
            AppCompatTextView r101 = new AppCompatTextView(getContext());
            r101.setId(r100);
            r101.setMaxLines(1);
            r101.setTextSize(1, 12.0f);
            return r101;
        }

        public static void b(AppCompatTextView r100, WindowChildCategoryVO.ChildCategoryTextVO r101) {
            if (r101 == null) goto L4;
            String r102 = r101.getText();
        L5:
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            r100.setText(r102);
            if (r101 == null) goto L10;
            int r103 = r101.getTextColor();
        L11:
            r100.setTextColor(r103);
            return;
        L10:
            r103 = 0;
            goto L11
        L4:
            r102 = null;
            goto L5
        }

        public final void c(int r100, boolean r101) {
            if (this.f190010e.getHeight() <= 0) goto L5;
            View r102 = this.f190010e;
            GradientDrawable r103 = new GradientDrawable();
            r103.setStroke(this.f190009d, CJBadgeTextView.BADGE_COLOR);
            r103.setCornerRadius(getHeight() / 2.0f);
            r103.setColor(r100);
            Unit r104 = Unit.INSTANCE;
            r102.setBackground(r103);
            return;
        L5:
            if (r101 == false) goto L9;
            this.f190010e.post(new b(this, r100));
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends TextView {
        public c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    public interface d {
        void a(WindowChildCategoryVO.ChildCategoryVO r100);
    }

    static {
    }

    public final d getOnSelectionChangedListener() {
        return this.f190001b;
    }

    private final void setConstraintChild(List<? extends View> r100) {
        if (r100.size() <= 1) goto L15;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L14;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        r101.add((View) r104);
        if (r103 == (r100.size() - 1)) goto L13;
        c r106 = new c(getContext());
        r106.setId(ViewCompat.generateViewId());
        Unit r107 = Unit.INSTANCE;
        r101.add(r106);
    L13:
        r103 = r105;
        goto L6
    L14:
        r100 = r101;
    L15:
        Iterator r108 = r100.iterator();
        int r109 = 0;
    L17:
        if (r108.hasNext() == false) goto L33;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        View r112 = (View) r110;
        View r113 = (View) CollectionsKt.getOrNull(r100, r109 - 1);
        View r114 = (View) CollectionsKt.getOrNull(r100, r111);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(0, -1);
        if (r113 != null) goto L24;
        r115.leftToLeft = 0;
    L25:
        if (r114 != null) goto L27;
        r115.rightToRight = 0;
    L28:
        r115.topToTop = 0;
        r115.bottomToBottom = 0;
        if ((r112 instanceof c) == false) goto L31;
        ((ViewGroup.MarginLayoutParams) r115).width = this.f190000a;
    L32:
        addView(r112, r115);
        r109 = r111;
        goto L17
    L31:
        r115.horizontalWeight = 1.0f;
        goto L32
    L27:
        r115.rightToLeft = r114.getId();
        goto L28
    L24:
        r115.leftToRight = r113.getId();
        goto L25
    }

    public final void R5(List<WindowChildCategoryVO.ChildCategoryVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "subCategoryVOList");
        List<View> r101 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof a) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List r105 = CollectionsKt.toMutableList(r102);
        removeAllViews();
        ((LinkedHashMap) this.f190002c).clear();
        List<WindowChildCategoryVO.ChildCategoryVO> r106 = r100;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L16;
        final WindowChildCategoryVO.ChildCategoryVO r109 = (WindowChildCategoryVO.ChildCategoryVO) r108.next();
        if (r105.isEmpty() == false) goto L14;
        final a r110 = new a(getContext());
    L15:
        final HorizontalWeightedGroupView$bindData$1$1$1 r111 = new HorizontalWeightedGroupView$bindData$1$1$1(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r109, "vo");
        Intrinsics.checkNotNullParameter(r111, "changedCallback");
        r110.a(r109);
        f.b(r110, 1000L, "window_child_category", new HorizontalWeightedGroupView$ChildCategoryView$bind$1(r110, r109, r111));
        r110.setId(ViewCompat.generateViewId());
        this.f190002c.put(r109, r110);
        r107.add(r110);
        goto L10
    L14:
        r110 = (a) ListProtector.remove(r105, 0);
        goto L15
    L16:
        setConstraintChild(r107);
    }

    public final void setOnSelectionChangedListener(d r100) {
        this.f190001b = r100;
    }

    public HorizontalWeightedGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setBackgroundColor(-1);
        int r102 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f190000a = com.bytedance.android.ec.hybrid.list.util.c.d(7);
        this.f190002c = new LinkedHashMap();
    }
}
