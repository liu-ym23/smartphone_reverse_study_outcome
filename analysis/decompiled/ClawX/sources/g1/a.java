package g1;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2906a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2907b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t.a f2908c;

    public /* synthetic */ a(t.a aVar, View view, int i8) {
        this.f2906a = i8;
        this.f2908c = aVar;
        this.f2907b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        switch (this.f2906a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f2908c;
                if (z && hideBottomViewOnScrollBehavior.f1214j == 1) {
                    hideBottomViewOnScrollBehavior.r(this.f2907b);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f2908c;
                if (z && hideViewOnScrollBehavior.f1224j == 1) {
                    hideViewOnScrollBehavior.s(this.f2907b);
                    break;
                }
                break;
        }
    }
}
