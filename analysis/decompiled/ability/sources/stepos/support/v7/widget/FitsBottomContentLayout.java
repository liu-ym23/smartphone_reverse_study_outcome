package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.NestedScrollingParent2;

/* loaded from: classes4.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements NestedScrollingParent2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6460a;
    public boolean b;

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.b ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int i, int i6, int[] iArr, int i10) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View view, int i, int i6, int i10, int i11, int i12) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i6) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i6) {
        return this.f6460a;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) {
    }

    public void setActionBarOverlay(boolean z10) {
        this.b = z10;
    }

    public void setInterceptNestedScrollEnabled(boolean z10) {
        this.f6460a = z10;
    }
}
