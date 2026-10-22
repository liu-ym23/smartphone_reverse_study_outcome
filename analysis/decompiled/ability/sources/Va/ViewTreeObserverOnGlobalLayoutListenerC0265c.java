package Va;

import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* renamed from: Va.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0265c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1436a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Drawable d;
    public final /* synthetic */ ActionMenuItemView e;

    public ViewTreeObserverOnGlobalLayoutListenerC0265c(ActionMenuItemView actionMenuItemView, int i, int i6, int i10, StepOSPressAnimationDrawable stepOSPressAnimationDrawable) {
        this.e = actionMenuItemView;
        this.f1436a = i;
        this.b = i6;
        this.c = i10;
        this.d = stepOSPressAnimationDrawable;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ActionMenuItemView actionMenuItemView = this.e;
        actionMenuItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int height = actionMenuItemView.getHeight() - this.f1436a;
        int width = (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd();
        int i = this.b;
        int iMax = Math.max(i > width ? (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd() : i + this.c, height);
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) this.d;
        stepOSPressAnimationDrawable.f3552r = iMax;
        stepOSPressAnimationDrawable.f3553s = height;
    }
}
