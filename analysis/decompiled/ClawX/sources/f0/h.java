package f0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.m f2544a;

    public h(androidx.emoji2.text.m mVar) {
        this.f2544a = mVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i8, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.f2544a.getClass();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i8) {
        g gVarL = this.f2544a.l(i8);
        if (gVarL == null) {
            return null;
        }
        return gVarL.f2542a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i8) {
        this.f2544a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i8) {
        g gVarM = this.f2544a.m(i8);
        if (gVarM == null) {
            return null;
        }
        return gVarM.f2542a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i8, int i9, Bundle bundle) {
        return this.f2544a.o(i8, i9, bundle);
    }
}
