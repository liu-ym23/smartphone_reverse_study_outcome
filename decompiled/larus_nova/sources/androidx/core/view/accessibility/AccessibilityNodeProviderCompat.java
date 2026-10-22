package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r100) {
            this.mCompat = r100;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r100) {
            AccessibilityNodeInfoCompat r101 = this.mCompat.createAccessibilityNodeInfo(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r100) {
            AccessibilityNodeInfoCompat r101 = this.mCompat.findFocus(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r100, int r101) {
            List<AccessibilityNodeInfoCompat> r102 = this.mCompat.findAccessibilityNodeInfosByText(r100, r101);
            if (r102 != null) goto L6;
            return null;
        L6:
            ArrayList r103 = new ArrayList();
            int r104 = r102.size();
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L9;
            r103.add(((AccessibilityNodeInfoCompat) ListProtector.get(r102, r105)).unwrap());
            r105 = r105 + 1;
            goto L7
        L9:
            return r103;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r100, int r101, Bundle r102) {
            return this.mCompat.performAction(r100, r101, r102);
        }
    }

    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r100) {
            super(r100);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r100, AccessibilityNodeInfo r101, String r102, Bundle r103) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(r100, AccessibilityNodeInfoCompat.wrap(r101), r102, r103);
        }
    }

    public void addExtraDataToAccessibilityNodeInfo(int r100, AccessibilityNodeInfoCompat r101, String r102, Bundle r103) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r100) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r100, int r101) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int r100) {
        return null;
    }

    public boolean performAction(int r100, int r101, Bundle r102) {
        return false;
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mProvider = new AccessibilityNodeProviderApi26(this);
        return;
    L5:
        this.mProvider = new AccessibilityNodeProviderApi19(this);
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public AccessibilityNodeProviderCompat(Object r100) {
        this.mProvider = r100;
    }
}
