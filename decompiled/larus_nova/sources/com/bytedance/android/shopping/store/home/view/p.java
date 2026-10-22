package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class p extends FrameLayout implements com.bytedance.android.ec.store.common.bubble.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f184727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f184728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f184729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f184730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f184731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f184732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f184733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f184734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f184735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f184736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LifecycleOwner f184737k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f184738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f184739b;

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f184738a = r100;
            this.f184739b = r101;
        }
    }

    private final int getPaddingContent() {
        return ((Number) this.f184728b.getValue()).intValue();
    }

    private final int getPaddingRoot() {
        return ((Number) this.f184727a.getValue()).intValue();
    }

    private final int getTriangleWidth() {
        return ((Number) this.f184729c.getValue()).intValue();
    }

    @Override // com.bytedance.android.ec.store.common.bubble.d
    public final void b() {
        View r100 = this.f184733g;
        FrameLayout r101 = this.f184734h;
        String r102 = this.f184735i;
        Long r103 = this.f184736j;
        ViewParent r104 = null;
        if (r101 == null) goto L7;
        Context r105 = r101.getContext();
        if (r105 == null) goto L7;
        Context r106 = th.a.e(r105, true);
    L8:
        if (r106 == null) goto L48;
        Point r107 = l0.f(r106);
        if (r107 == null) goto L51;
        if (r100 == null) goto L49;
        int r108 = r100.getWidth();
        if (r102 == null) goto L52;
        int[] r110 = new int[2];
        r100.getLocationInWindow(r110);
        a r109 = new a(r102, r110[0] + (r108 / 2));
        setupInternal(r109);
        int r111 = this.f184732f;
        int r112 = r109.f184739b;
        int r113 = r107.x;
        if (r112 <= (r113 / 2)) goto L19;
        boolean r114 = true;
    L20:
        if (r114 == false) goto L22;
        r112 = r113 - r112;
    L22:
        int r115 = r111 / 2;
        if (r112 > r115) goto L25;
        int r116 = 0;
    L26:
        ViewParent r117 = getParent();
        if ((r117 instanceof ViewGroup) == false) goto L30;
        r104 = r117;
    L30:
        ViewGroup r118 = (ViewGroup) r104;
        if (r118 == null) goto L33;
        r118.removeView(this);
    L33:
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(-2, -2);
        if (r114 == false) goto L36;
        int r120 = GravityCompat.END;
    L37:
        r119.gravity = r120 | 80;
        if (r114 == false) goto L40;
        r119.rightMargin = r116;
    L41:
        r119.bottomMargin = RangesKt.coerceAtLeast((r107.y - l0.e(r106)) - r110[1], 0);
        r101.addView(this, r119);
        this.f184736j = r103;
        final FragmentActivity r121 = l0.c(r106);
        if (r121 == null) goto L53;
        Function0<Unit> r122 = new ECStoreTipsView$popupAbove$1(r121);
        ECBubbleControllerManager.f48207b.a(this.f184737k).d();
        Long r123 = this.f184736j;
        if (r123 == null) goto L50;
        new Handler(Looper.getMainLooper()).postDelayed(new q(this, r122), r123.longValue());
        return;
    L50:
        return;
    L53:
        return;
    L40:
        r119.leftMargin = r116;
        goto L41
    L36:
        r120 = GravityCompat.START;
        goto L37
    L25:
        r116 = RangesKt.coerceAtMost(r112 - r115, r113 - r111);
        goto L26
    L19:
        r114 = false;
        goto L20
    L52:
        return;
    L49:
        return;
    L51:
        return;
    L48:
        return;
    L7:
        r106 = null;
        goto L8
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f184737k;
    }

    private final void setupInternal(a r100) {
        if (this.f184730d == null) goto L5;
        boolean r101 = true;
    L6:
        ViewGroup.LayoutParams r102 = null;
        if (r101 == true) goto L9;
    L13:
        Context r103 = th.a.e(getContext(), true);
        ShoppingAsyncInflater.f45268e.getClass();
        View r104 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r103), R.layout.ec_store_layout_popup_tips, null, 6);
        this.f184730d = (TextView) r104.findViewById(R.id.ec_store_layout_popup_tips_text);
        this.f184731e = r104.findViewById(R.id.ec_store_layout_popup_tips_triangle);
        addView(r104);
    L14:
        TextView r105 = this.f184730d;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("text");
    L17:
        int r106 = com.bytedance.android.shopping.extensions.b.b(160);
        Point r107 = l0.f(th.a.e(getContext(), true));
        if (r107 == null) goto L47;
        r105.setText(r100.f184738a);
        GradientDrawable r108 = new GradientDrawable();
        r108.setColor((int) 3845733188L);
        r108.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(8));
        Unit r109 = Unit.INSTANCE;
        int r110 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r105, "$this$setBackgroundCompat");
        r105.setBackground(r108);
        float r111 = r105.getPaint().measureText(r100.f184738a);
        int r112 = (getPaddingRoot() + getPaddingContent()) * 2;
        r106 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((int) (r111 + 0.5f)) + r112, r112), r107.x);
        View r113 = this.f184731e;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L23:
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof LinearLayout.LayoutParams) == false) goto L27;
        r102 = r114;
    L27:
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r102;
        if (r115 == null) goto L47;
        int r116 = r100.f184739b;
        int r117 = r107.x;
        if (r116 <= (r117 / 2)) goto L33;
        boolean r118 = true;
    L34:
        if (r118 == false) goto L37;
        r116 = r117 - r116;
    L37:
        if (r116 < (r106 / 2)) goto L39;
        r115.gravity = 1;
        r115.leftMargin = 0;
        r115.rightMargin = 0;
    L43:
        View r119 = this.f184731e;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("triangle");
    L46:
        r119.requestLayout();
        goto L47
    L39:
        int r120 = RangesKt.coerceAtLeast((r116 - (getTriangleWidth() / 2)) - getPaddingRoot(), 0);
        if (r118 == true) goto L42;
        r115.gravity = 3;
        r115.leftMargin = r120;
        goto L43
    L42:
        r115.gravity = 5;
        r115.rightMargin = r120;
        goto L43
    L33:
        r118 = false;
    L47:
        this.f184732f = r106;
        return;
    L9:
        if (this.f184731e == null) goto L11;
        boolean r121 = true;
    L12:
        if (r121 == true) goto L14;
    L11:
        r121 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public p(final Context r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        super(r100, null, 0);
        this.f184737k = r101;
        this.f184727a = LazyKt.lazy(new ECStoreTipsView$paddingRoot$2(r100));
        this.f184728b = LazyKt.lazy(new ECStoreTipsView$paddingContent$2(r100));
        this.f184729c = LazyKt.lazy(new ECStoreTipsView$triangleWidth$2(r100));
    }
}
