package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FitWindowsViewGroup.OnFitSystemWindowsListener f824a;

    public FitWindowsFrameLayout(@NonNull Context r10) {
        super(r10);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r10) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r11 = this.f824a;
        if (r11 == null) goto L6;
        r11.onFitSystemWindows(r10);
    L6:
        return super.fitSystemWindows(r10);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r10) {
        this.f824a = r10;
    }

    public FitWindowsFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }
}
