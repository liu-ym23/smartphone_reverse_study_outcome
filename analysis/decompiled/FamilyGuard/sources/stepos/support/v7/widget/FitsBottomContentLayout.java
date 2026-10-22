package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.InterfaceC0476v;

/* loaded from: classes.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements InterfaceC0476v {

    /* renamed from: a, reason: collision with root package name */
    private boolean f21565a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f21566b;

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.f21566b ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        return this.f21565a;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
    }

    void setActionBarOverlay(boolean z5) {
        this.f21566b = z5;
    }

    public void setInterceptNestedScrollEnabled(boolean z5) {
        this.f21565a = z5;
    }
}
