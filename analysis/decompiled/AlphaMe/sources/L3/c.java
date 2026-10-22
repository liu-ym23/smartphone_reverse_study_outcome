package L3;

import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1267a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1268b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1269c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Drawable f1270d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ActionMenuItemView f1271e;

    public c(ActionMenuItemView actionMenuItemView, int i4, int i5, int i6, Drawable drawable) {
        this.f1271e = actionMenuItemView;
        this.f1267a = i4;
        this.f1268b = i5;
        this.f1269c = i6;
        this.f1270d = drawable;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ActionMenuItemView actionMenuItemView = this.f1271e;
        actionMenuItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int height = actionMenuItemView.getHeight() - this.f1267a;
        int width = (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd();
        int i4 = this.f1268b;
        int iMax = Math.max(i4 > width ? (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd() : i4 + this.f1269c, height);
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) this.f1270d;
        stepOSPressAnimationDrawable.f11258r = iMax;
        stepOSPressAnimationDrawable.f11259s = height;
    }
}
