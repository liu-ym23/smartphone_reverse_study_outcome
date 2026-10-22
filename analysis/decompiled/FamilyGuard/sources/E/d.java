package E;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1274a;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final d f1275a;

        a(d dVar) {
            this.f1275a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i5) {
            c cVarB = this.f1275a.b(i5);
            if (cVarB == null) {
                return null;
            }
            return cVarB.D0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i5) {
            List<c> listC = this.f1275a.c(str, i5);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i6 = 0; i6 < size; i6++) {
                arrayList.add(listC.get(i6).D0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i5) {
            c cVarD = this.f1275a.d(i5);
            if (cVarD == null) {
                return null;
            }
            return cVarD.D0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i5, int i6, Bundle bundle) {
            return this.f1275a.f(i5, i6, bundle);
        }
    }

    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i5, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f1275a.a(i5, c.E0(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        this.f1274a = new b(this);
    }

    public void a(int i5, c cVar, String str, Bundle bundle) {
    }

    public c b(int i5) {
        return null;
    }

    public List<c> c(String str, int i5) {
        return null;
    }

    public c d(int i5) {
        return null;
    }

    public Object e() {
        return this.f1274a;
    }

    public boolean f(int i5, int i6, Bundle bundle) {
        return false;
    }

    public d(Object obj) {
        this.f1274a = obj;
    }
}
