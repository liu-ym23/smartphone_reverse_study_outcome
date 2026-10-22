package K;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: K.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0067a extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final C0069b f947a;

    public C0067a(C0069b c0069b) {
        this.f947a = c0069b;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f947a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        L.j accessibilityNodeProvider = this.f947a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return (AccessibilityNodeProvider) accessibilityNodeProvider.f1146a;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f947a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        L.g gVar = new L.g(accessibilityNodeInfo);
        WeakHashMap weakHashMap = S.f939a;
        accessibilityNodeInfo.setScreenReaderFocusable(Boolean.valueOf(N.d(view)).booleanValue());
        accessibilityNodeInfo.setHeading(Boolean.valueOf(N.c(view)).booleanValue());
        accessibilityNodeInfo.setPaneTitle(N.b(view));
        L.c.c(accessibilityNodeInfo, P.b(view));
        this.f947a.onInitializeAccessibilityNodeInfo(view, gVar);
        accessibilityNodeInfo.getText();
        List<L.b> actionList = C0069b.getActionList(view);
        for (int i4 = 0; i4 < actionList.size(); i4++) {
            gVar.b(actionList.get(i4));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f947a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f947a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        return this.f947a.performAccessibilityAction(view, i4, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i4) {
        this.f947a.sendAccessibilityEvent(view, i4);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f947a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
