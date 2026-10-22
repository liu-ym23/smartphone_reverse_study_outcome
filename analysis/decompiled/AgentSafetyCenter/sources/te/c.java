package te;

import android.view.ViewTreeObserver;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f13330c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f13331f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ int f13332g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ StepOSPressAnimationDrawable f13333h;
    public /* synthetic */ ActionMenuItemView i;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ActionMenuItemView actionMenuItemView = this.i;
        actionMenuItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int height = actionMenuItemView.getHeight() - this.f13330c;
        int i = this.f13331f;
        int iMax = Math.max(i > (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd() ? (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd() : i + this.f13332g, height);
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f13333h;
        stepOSPressAnimationDrawable.f2530v = iMax;
        stepOSPressAnimationDrawable.f2531w = height;
    }
}
