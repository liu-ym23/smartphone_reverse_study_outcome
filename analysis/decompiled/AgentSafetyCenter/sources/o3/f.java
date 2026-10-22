package o3;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.invoke.VarHandle;
import java.util.List;
import v1.a0;
import v1.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public w f9152a;

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        w wVar = this.f9152a;
        e eVar = new e();
        eVar.f9150b = -1;
        eVar.f9151c = -1;
        eVar.f9149a = accessibilityNodeInfo;
        VarHandle.storeStoreFence();
        wVar.f14584b.a(i, eVar, str, bundle);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        e eVarA = this.f9152a.a(i);
        if (eVarA == null) {
            return null;
        }
        return eVarA.f9149a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.f9152a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        e eVarA;
        w wVar = this.f9152a;
        a0 a0Var = wVar.f14584b;
        if (i == 1) {
            int i3 = a0Var.f14341l;
            eVarA = i3 == Integer.MIN_VALUE ? null : wVar.a(i3);
        } else {
            if (i != 2) {
                g5.f.s(k0.a.j(i, "Unknown focus type: "));
                return null;
            }
            eVarA = wVar.a(a0Var.f14340k);
        }
        if (eVarA == null) {
            return null;
        }
        return eVarA.f9149a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:597:0x01a7, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x06d3  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performAction(int r19, int r20, android.os.Bundle r21) {
        /*
            Method dump skipped, instructions count: 2166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.f.performAction(int, int, android.os.Bundle):boolean");
    }
}
