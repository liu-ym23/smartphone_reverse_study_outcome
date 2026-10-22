package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements v0.o {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12537a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12538b;

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.f12538b ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // v0.o
    public final boolean p(View view, View view2, int i10, int i11) {
        return this.f12537a;
    }

    public void setActionBarOverlay(boolean z) {
        this.f12538b = z;
    }

    public void setInterceptNestedScrollEnabled(boolean z) {
        this.f12537a = z;
    }

    @Override // v0.o
    public final void h(int i10, View view) {
    }

    @Override // v0.o
    public final void i(View view, View view2, int i10, int i11) {
    }

    @Override // v0.o
    public final void j(View view, int i10, int i11, int[] iArr, int i12) {
    }

    @Override // v0.o
    public final void l(View view, int i10, int i11, int i12, int i13, int i14) {
    }
}
