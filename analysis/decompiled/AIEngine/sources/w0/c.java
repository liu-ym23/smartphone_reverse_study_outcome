package w0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeProvider f13547a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final c f13548a;

        public a(c cVar) {
            this.f13548a = cVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            w0.b bVarB = this.f13548a.b(i10);
            if (bVarB == null) {
                return null;
            }
            return bVarB.f13532a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            this.f13548a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int i10) {
            w0.b bVarC = this.f13548a.c(i10);
            if (bVarC == null) {
                return null;
            }
            return bVarC.f13532a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f13548a.d(i10, i11, bundle);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends a {
        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            new w0.b(accessibilityNodeInfo);
            this.f13548a.getClass();
        }
    }

    public c() {
        this.f13547a = new b(this);
    }

    public w0.b b(int i10) {
        return null;
    }

    public w0.b c(int i10) {
        return null;
    }

    public boolean d(int i10, int i11, Bundle bundle) {
        return false;
    }

    public c(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f13547a = accessibilityNodeProvider;
    }

    public void a(int i10, w0.b bVar, String str, Bundle bundle) {
    }
}
