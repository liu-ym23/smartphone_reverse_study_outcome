package n3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public b f8679a;

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f8679a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        o3.g accessibilityNodeProvider = this.f8679a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return accessibilityNodeProvider.f9153a;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f8679a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        o3.e eVar = new o3.e();
        eVar.f9150b = -1;
        eVar.f9151c = -1;
        eVar.f9149a = accessibilityNodeInfo;
        VarHandle.storeStoreFence();
        WeakHashMap weakHashMap = k0.f8724a;
        accessibilityNodeInfo.setScreenReaderFocusable(h0.c(view));
        accessibilityNodeInfo.setHeading(h0.b(view));
        accessibilityNodeInfo.setPaneTitle(h0.a(view));
        accessibilityNodeInfo.setStateDescription(j0.b(view));
        this.f8679a.onInitializeAccessibilityNodeInfo(view, eVar);
        accessibilityNodeInfo.getText();
        List<o3.b> actionList = b.getActionList(view);
        for (int i = 0; i < actionList.size(); i++) {
            eVar.b(actionList.get(i));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f8679a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f8679a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.f8679a.performAccessibilityAction(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i) {
        this.f8679a.sendAccessibilityEvent(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f8679a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
