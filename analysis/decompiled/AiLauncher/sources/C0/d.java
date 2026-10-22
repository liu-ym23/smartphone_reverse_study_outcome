package C0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1678a;

    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final d f1679a;

        public a(d dVar) {
            this.f1679a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            c cVarB = this.f1679a.b(i10);
            if (cVarB == null) {
                return null;
            }
            return cVarB.R0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<c> listC = this.f1679a.c(str, i10);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listC.get(i11).R0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            c cVarD = this.f1679a.d(i10);
            if (cVarD == null) {
                return null;
            }
            return cVarD.R0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f1679a.f(i10, i11, bundle);
        }
    }

    public static class b extends a {
        public b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f1679a.a(i10, c.S0(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        this.f1678a = new b(this);
    }

    public void a(int i10, c cVar, String str, Bundle bundle) {
    }

    public c b(int i10) {
        return null;
    }

    public List<c> c(String str, int i10) {
        return null;
    }

    public c d(int i10) {
        return null;
    }

    public Object e() {
        return this.f1678a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public d(Object obj) {
        this.f1678a = obj;
    }
}
