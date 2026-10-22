package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1432a;

    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r1) {
            b r0 = this.mCompat.a(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r5, int r6) {
            List<b> r4 = this.mCompat.a(r5, r6);
            if (r4 != null) goto L6;
            return null;
        L6:
            ArrayList r7 = new ArrayList();
            int r8 = r4.size();
            int r0 = 0;
        L7:
            if (r0 >= r8) goto L9;
            r7.add(((b) ZeusTransformUtils.preCheckCast(r4.get(r0), b.class, "com.obric.aiagent.plugin")).a());
            r0 = r0 + 1;
            goto L7
        L9:
            return r7;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r1, int r2, Bundle r3) {
            return this.mCompat.a(r1, r2, r3);
        }
    }

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r1) {
            b r0 = this.mCompat.b(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a();
        }
    }

    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r1, AccessibilityNodeInfo r2, String r3, Bundle r4) {
            this.mCompat.a(r1, b.a(r2), r3, r4);
        }
    }

    public b a(int r1) {
        return null;
    }

    public List<b> a(String r1, int r2) {
        return null;
    }

    public void a(int r1, b r2, String r3, Bundle r4) {
    }

    public boolean a(int r1, int r2, Bundle r3) {
        return false;
    }

    public b b(int r1) {
        return null;
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.f1432a = new AccessibilityNodeProviderApi26(this);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L9;
        this.f1432a = new AccessibilityNodeProviderApi19(this);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 16) goto L11;
        this.f1432a = new AccessibilityNodeProviderApi16(this);
        return;
    L11:
        this.f1432a = null;
    }

    public AccessibilityNodeProviderCompat(Object r1) {
        this.f1432a = r1;
    }

    public Object a() {
        return this.f1432a;
    }
}
