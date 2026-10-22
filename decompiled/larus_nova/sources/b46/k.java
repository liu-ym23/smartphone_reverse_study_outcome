package b46;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f17545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f17546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f17547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f17548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f17549e;

    public k(View r100, Rect r101, j r102, View r103) {
        this.f17545a = r100;
        this.f17546b = r101;
        this.f17547c = r102;
        this.f17548d = 1;
        this.f17549e = r103;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f17545a.getWindowVisibleDisplayFrame(this.f17546b);
        j r100 = this.f17547c;
        if (r100.f17542a != 0) goto L6;
        r100.f17542a = this.f17546b.bottom;
    L6:
        if (this.f17548d != 1) goto L14;
        int r101 = Math.abs(r100.f17542a - this.f17546b.bottom);
        com.bytedance.android.anniex.container.util.i r102 = com.bytedance.android.anniex.container.util.i.f40626a;
        this.f17547c.getClass();
        int r103 = 0;
        if (r101 <= r102.a(100)) goto L11;
        r103 = RangesKt.coerceAtLeast(this.f17547c.f17542a - this.f17546b.bottom, 0);
    L11:
        if (this.f17547c.f17543b == r103) goto L15;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.m("SoftKeyboardHelper", "visibleFrameRect.bottom: " + this.f17546b.bottom + " lastVisibleFrameBottom: " + this.f17547c.f17542a + "; margin: " + r103 + "; lastMargin: " + this.f17547c.f17543b, null, null, 12);
        this.f17547c.f17543b = r103;
        ViewGroup.LayoutParams r105 = this.f17549e.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r106.bottomMargin = r103;
        this.f17549e.setLayoutParams(r106);
        return;
    L15:
        return;
    }
}
