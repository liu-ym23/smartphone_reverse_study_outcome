package r;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23671a;

    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f23672a;

        public a(b r10) {
            this.f23672a = r10;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r10) {
            AccessibilityNodeInfoCompat r11 = this.f23672a.b(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.A0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String r10, int r11) {
            List r12 = this.f23672a.c(r10, r11);
            if (r12 != null) goto L6;
            return null;
        L6:
            ArrayList r13 = new ArrayList();
            int r14 = r12.size();
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L9;
            r13.add(((AccessibilityNodeInfoCompat) r12.get(r15)).A0());
            r15 = r15 + 1;
            goto L7
        L9:
            return r13;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r10, int r11, Bundle r12) {
            return this.f23672a.f(r10, r11, r12);
        }
    }

    /* JADX INFO: renamed from: r.b$b, reason: collision with other inner class name */
    public static class C0345b extends a {
        public C0345b(b r10) {
            super(r10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r10) {
            AccessibilityNodeInfoCompat r11 = this.f23672a.d(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.A0();
        }
    }

    public static class c extends C0345b {
        public c(b r10) {
            super(r10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r10, AccessibilityNodeInfo r11, String r12, Bundle r13) {
            this.f23672a.a(r10, AccessibilityNodeInfoCompat.B0(r11), r12, r13);
        }
    }

    public b() {
        this.f23671a = new c(this);
    }

    public void a(int r10, AccessibilityNodeInfoCompat r11, String r12, Bundle r13) {
    }

    public AccessibilityNodeInfoCompat b(int r10) {
        return null;
    }

    public List c(String r10, int r11) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int r10) {
        return null;
    }

    public Object e() {
        return this.f23671a;
    }

    public boolean f(int r10, int r11, Bundle r12) {
        return false;
    }

    public b(Object r10) {
        this.f23671a = r10;
    }
}
