package com.stepos.widget.dialog;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/widget/dialog/StepOSCheckableLayout;", "Landroid/widget/LinearLayout;", "Landroid/widget/Checkable;", "", "checked", "LC7/r;", "setChecked", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSCheckableLayout extends LinearLayout implements Checkable {
    public static final int[] b = {R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    public boolean f4105a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCheckableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4105a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4105a) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, b);
        }
        k.c(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.f4105a == checked) {
            return;
        }
        this.f4105a = checked;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4105a);
    }
}
