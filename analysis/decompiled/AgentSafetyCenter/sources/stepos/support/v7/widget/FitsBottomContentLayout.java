package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class FitsBottomContentLayout extends FitsWindowsContentLayout implements n3.q {

    /* renamed from: c, reason: collision with root package name */
    public boolean f12609c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12610f;

    public FitsBottomContentLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return !this.f12610f ? super.dispatchApplyWindowInsets(windowInsets.inset(0, windowInsets.getInsets(WindowInsets.Type.systemBars()).top, 0, 0)) : super.dispatchApplyWindowInsets(windowInsets);
    }

    @Override // n3.q
    public final boolean m(View view, View view2, int i, int i3) {
        return this.f12609c;
    }

    public void setActionBarOverlay(boolean z10) {
        this.f12610f = z10;
    }

    public void setInterceptNestedScrollEnabled(boolean z10) {
        this.f12609c = z10;
    }

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsBottomContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // n3.q
    public final void n(View view, View view2, int i, int i3) {
    }

    @Override // n3.q
    public final void j(int i, View view) {
    }

    @Override // n3.q
    public final void l(View view, int i, int i3, int i10, int i11, int i12) {
    }

    @Override // n3.q
    public final void q(View view, int i, int i3, int[] iArr, int i10) {
    }
}
