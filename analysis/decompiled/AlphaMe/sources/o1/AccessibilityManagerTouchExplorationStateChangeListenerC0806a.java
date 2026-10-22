package o1;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class AccessibilityManagerTouchExplorationStateChangeListenerC0806a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13781a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f13782b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ A.b f13783c;

    public /* synthetic */ AccessibilityManagerTouchExplorationStateChangeListenerC0806a(A.b bVar, View view, int i4) {
        this.f13781a = i4;
        this.f13783c = bVar;
        this.f13782b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z4) {
        int i4 = this.f13781a;
        View view = this.f13782b;
        A.b bVar = this.f13783c;
        switch (i4) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) bVar;
                if (!z4) {
                    hideBottomViewOnScrollBehavior.getClass();
                    break;
                } else if (hideBottomViewOnScrollBehavior.f10380j == 1) {
                    hideBottomViewOnScrollBehavior.c(view);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) bVar;
                if (hideViewOnScrollBehavior.f10385d && z4 && hideViewOnScrollBehavior.f10392k == 1) {
                    hideViewOnScrollBehavior.d(view);
                    break;
                }
                break;
        }
    }
}
