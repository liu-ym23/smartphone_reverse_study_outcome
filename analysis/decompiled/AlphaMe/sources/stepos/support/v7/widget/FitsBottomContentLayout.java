package stepos.support.v7.widget;

import K.InterfaceC0086s;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes2.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements InterfaceC0086s {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14818a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14819b;

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // K.InterfaceC0086s
    public final void d(View view, View view2, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.f14819b ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // K.InterfaceC0086s
    public final void i(View view, int i4, int i5, int[] iArr, int i6) {
    }

    @Override // K.InterfaceC0086s
    public final void n(int i4, View view) {
    }

    @Override // K.InterfaceC0086s
    public final void q(View view, int i4, int i5, int i6, int i7, int i8) {
    }

    @Override // K.InterfaceC0086s
    public final boolean r(View view, View view2, int i4, int i5) {
        return this.f14818a;
    }

    public void setActionBarOverlay(boolean z4) {
        this.f14819b = z4;
    }

    public void setInterceptNestedScrollEnabled(boolean z4) {
        this.f14818a = z4;
    }
}
