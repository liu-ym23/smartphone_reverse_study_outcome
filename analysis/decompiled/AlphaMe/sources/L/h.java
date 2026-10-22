package L;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final j f1145a;

    public h(j jVar) {
        this.f1145a = jVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i4) {
        g gVarA = this.f1145a.a(i4);
        if (gVarA == null) {
            return null;
        }
        return gVarA.f1142a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i4) {
        this.f1145a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i4) {
        g gVarB = this.f1145a.b(i4);
        if (gVarB == null) {
            return null;
        }
        return gVarB.f1142a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i4, int i5, Bundle bundle) {
        return this.f1145a.c(i4, i5, bundle);
    }
}
