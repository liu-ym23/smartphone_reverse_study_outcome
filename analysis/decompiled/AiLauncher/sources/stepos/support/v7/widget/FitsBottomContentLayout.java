package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.InterfaceC1335x;

/* loaded from: classes5.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements InterfaceC1335x {

    /* renamed from: a, reason: collision with root package name */
    public boolean f41219a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41220b;

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.f41220b ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return this.f41219a;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
    }

    public void setActionBarOverlay(boolean z10) {
        this.f41220b = z10;
    }

    public void setInterceptNestedScrollEnabled(boolean z10) {
        this.f41219a = z10;
    }
}
