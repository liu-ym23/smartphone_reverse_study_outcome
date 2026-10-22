package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/TabIndicatorScrollView;", "Landroid/widget/HorizontalScrollView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabIndicatorScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f169460f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f169461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EdgeGradientFrameLayout f169462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f169463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f169464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f169465e;

    public TabIndicatorScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TabIndicatorScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        View r100 = this.f169461a;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getMeasuredWidth();
        int r102 = getWidth();
        if (r101 <= 0) goto L14;
        if (r102 > 0) goto L10;
        return;
    L10:
        if (r101 > r102) goto L12;
        int[] r103 = new int[2];
        int[] r104 = new int[2];
        getLocationOnScreen(r103);
        getRootView().getLocationOnScreen(r104);
        r100.setTranslationX(RangesKt.coerceIn(((r104[0] + (getRootView().getWidth() / 2.0f)) - r103[0]) - (r101 / 2.0f), 0.0f, r102 - r101));
        scrollTo(0, 0);
        return;
    L12:
        r100.setTranslationX(0.0f);
        return;
    }

    public final void b() {
        View r100 = this.f169461a;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = RangesKt.coerceAtLeast(r100.getMeasuredWidth() - getWidth(), 0);
        boolean r102 = true;
        if (r101 > 0) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r101 > 0) goto L13;
    L15:
        r102 = false;
    L17:
        if (this.f169463c == r103) goto L19;
    L20:
        this.f169463c = r103;
        this.f169464d = r102;
        EdgeGradientFrameLayout r104 = this.f169462b;
        if (r104 == null) goto L31;
        if (r103 == false) goto L24;
        int r105 = this.f169465e;
    L25:
        if (r102 == false) goto L27;
        int r106 = this.f169465e;
    L28:
        r104.b(r105, 0, r106, 0);
        return;
    L27:
        r106 = 0;
        goto L28
    L24:
        r105 = 0;
        goto L25
    L31:
        return;
    L19:
        if (this.f169464d != r102) goto L20;
        return;
    L13:
        if (getScrollX() >= r101) goto L15;
    L8:
        if (getScrollX() <= 0) goto L10;
        r103 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r100 = getParent();
        if ((r100 instanceof EdgeGradientFrameLayout) == true) goto L5;
        r100 = null;
    L5:
        this.f169462b = (EdgeGradientFrameLayout) r100;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f169461a = findViewById(R.id.tv_indicator);
    }

    public TabIndicatorScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f169465e = com.bytedance.android.shopping.extensions.b.a(20);
    }

    public /* synthetic */ TabIndicatorScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        b();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        a();
        b();
    }
}
