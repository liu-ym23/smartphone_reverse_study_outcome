package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r100) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r101 = this.mListener;
        if (r101 == null) goto L6;
        r101.onFitSystemWindows(r100);
    L6:
        return super.fitSystemWindows(r100);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r100) {
        this.mListener = r100;
    }

    public FitWindowsFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
