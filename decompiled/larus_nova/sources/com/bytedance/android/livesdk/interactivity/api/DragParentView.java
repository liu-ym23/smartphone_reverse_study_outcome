package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DragParentView;", "Landroid/widget/FrameLayout;", "Ld42/d;", "Ld42/b;", "callback", "", "setDragCallback", "", "h", "I", "getMDragAreaMarginTop", "()I", "setMDragAreaMarginTop", "(I)V", "mDragAreaMarginTop", ce.f26395j, "getMDragAreaMarginBottom", "setMDragAreaMarginBottom", "mDragAreaMarginBottom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DragParentView extends FrameLayout implements d42.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f132762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f132763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f132764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f132765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d42.b f132766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f132767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f132768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f132769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f132770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f132771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f132772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f132773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f132774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f132775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f132776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f132777p;

    public DragParentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DragParentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getMDragAreaMarginBottom() {
        return this.f132771j;
    }

    public final int getMDragAreaMarginTop() {
        return this.f132769h;
    }

    @Override // d42.d
    public void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.topMargin = this.f132767f;
        r101.leftMargin = this.f132768g;
        addView(r100, r101);
        this.f132765d = r100;
    }

    @Override // d42.c
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        l(8);
        d42.b r101 = this.f132766e;
        if (r101 == null) goto L5;
        r101.Op(this.f132776o);
    L5:
        this.f132777p = true;
    }

    @Override // d42.c
    public final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        l(8);
        d42.b r101 = this.f132766e;
        if (r101 == null) goto L5;
        r101.Op(this.f132776o);
    L5:
        this.f132777p = true;
    }

    @Override // d42.c
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        View r101 = this.f132762a;
        if (r101 != null) goto L5;
        boolean r102 = false;
    L6:
        Boolean r103 = Boolean.valueOf(r102);
        if (r103.booleanValue() == this.f132776o) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L17;
        boolean r105 = r103.booleanValue();
        this.f132776o = r105;
        d42.b r106 = this.f132766e;
        if (r106 == null) goto L17;
        r106.kn(r105);
    L17:
        l(0);
        if (this.f132777p == false) goto L24;
        d42.b r107 = this.f132766e;
        if (r107 == null) goto L22;
        r107.onDragStart();
    L22:
        this.f132777p = false;
        return;
    L24:
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r100.getLocationOnScreen(this.f132773l);
        r101.getLocationOnScreen(this.f132772k);
        k(r100, this.f132775n, this.f132773l);
        k(r101, this.f132774m, this.f132772k);
        r102 = this.f132775n.intersect(this.f132774m);
        goto L6
    }

    @Override // d42.d
    public Pair h(DragContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        Float r101 = Float.valueOf(r100.getX() / getWidth());
        float r102 = r100.getY();
        View r103 = this.f132762a;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.getHeight();
    L6:
        float r106 = r102 - r105;
        int r107 = getHeight();
        View r108 = this.f132762a;
        if (r108 == null) goto L9;
        int r109 = r108.getHeight();
    L10:
        int r110 = r107 - r109;
        View r111 = this.f132764c;
        if (r111 == null) goto L14;
        r104 = r111.getHeight();
    L14:
        return TuplesKt.to(r101, Float.valueOf(r106 / (r110 - r104)));
    L9:
        r109 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final void l(int r100) {
        this.f132763b.setVisibility(r100);
        View r101 = this.f132762a;
        if (r101 == null) goto L5;
        r101.setVisibility(r100);
    L5:
        View r102 = this.f132764c;
        if (r102 == null) goto L9;
        r102.setVisibility(r100);
        return;
    }

    @Override // d42.d
    public void setDragCallback(d42.b r100) {
        this.f132766e = r100;
    }

    public final void setMDragAreaMarginBottom(int r100) {
        this.f132771j = r100;
    }

    public final void setMDragAreaMarginTop(int r100) {
        this.f132769h = r100;
    }

    @Override // d42.d
    public void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "deleteView");
        View r102 = this.f132762a;
        if (r102 == null) goto L5;
        removeView(r102);
    L5:
        r100.setVisibility(8);
        addView(r100, new FrameLayout.LayoutParams(-1, r101));
        int r103 = UtilityKotlinExtentionsKt.i(6) + r101;
        View r104 = this.f132765d;
        if (r104 == null) goto L8;
        a1.o(r104, r103);
    L8:
        this.f132767f = r103;
        a1.o(this.f132763b, r101);
        this.f132762a = r100;
    }

    @Override // d42.d
    public final boolean e(float r100, float r101) {
        if (r100 >= (getLeft() + this.f132768g)) goto L5;
    L7:
        return false;
    L5:
        if ((r100 + r101) > (getRight() - this.f132770i)) goto L7;
        return true;
    }

    @Override // d42.d
    public boolean i(float r100, float r101) {
        if (r100 < (getTop() + this.f132769h)) goto L12;
        float r102 = r100 + r101;
        int r103 = getBottom();
        View r104 = this.f132764c;
        if (r104 == null) goto L7;
        int r105 = r104.getHeight();
    L9:
        if (r102 > ((r103 - r105) - this.f132771j)) goto L13;
        return true;
    L13:
        return false;
    L7:
        r105 = 0;
        goto L9
    L12:
        return false;
    }

    @Override // d42.d
    public void j(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "forbiddenView");
        View r102 = this.f132764c;
        if (r102 == null) goto L5;
        removeView(r102);
    L5:
        r100.setVisibility(8);
        addView(r100, new FrameLayout.LayoutParams(-1, r101, 80));
        a1.l(this.f132763b, r101);
        this.f132764c = r100;
    }

    public DragParentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f132772k = new int[2];
        this.f132773l = new int[2];
        this.f132774m = new Rect();
        this.f132775n = new Rect();
        this.f132777p = true;
        View r103 = new View(r100);
        r103.setVisibility(8);
        r103.setBackgroundResource(R.drawable.ttlive_bg_dragparent_draggable_area);
        Unit r104 = Unit.INSTANCE;
        this.f132763b = r103;
        addView(r103, -1, -1);
    }

    public static void k(View r100, Rect r101, int[] r102) {
        int r103 = 0;
        int r104 = r102[0];
        r101.left = r104;
        r101.top = r102[1];
        if (r100 == null) goto L5;
        int r105 = r100.getMeasuredWidth();
    L6:
        r101.right = r104 + r105;
        int r106 = r101.top;
        if (r100 == null) goto L9;
        r103 = r100.getMeasuredHeight();
    L9:
        r101.bottom = r106 + r103;
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // d42.d
    public final void a(int r100, int r101, int r102) {
        this.f132768g = r100;
        this.f132769h = r101;
        this.f132770i = r102;
        this.f132771j = 0;
    }

    public /* synthetic */ DragParentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
