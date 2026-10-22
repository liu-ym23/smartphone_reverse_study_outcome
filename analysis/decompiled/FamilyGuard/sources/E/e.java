package E;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityRecord f1276a;

    @Deprecated
    public e(Object obj) {
        this.f1276a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static e a() {
        return new e(AccessibilityRecord.obtain());
    }

    public static void d(AccessibilityRecord accessibilityRecord, int i5) {
        accessibilityRecord.setMaxScrollX(i5);
    }

    public static void e(AccessibilityRecord accessibilityRecord, int i5) {
        accessibilityRecord.setMaxScrollY(i5);
    }

    public static void g(AccessibilityRecord accessibilityRecord, View view, int i5) {
        accessibilityRecord.setSource(view, i5);
    }

    @Deprecated
    public void b(int i5) {
        this.f1276a.setFromIndex(i5);
    }

    @Deprecated
    public void c(int i5) {
        this.f1276a.setItemCount(i5);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        AccessibilityRecord accessibilityRecord = this.f1276a;
        return accessibilityRecord == null ? eVar.f1276a == null : accessibilityRecord.equals(eVar.f1276a);
    }

    @Deprecated
    public void f(boolean z5) {
        this.f1276a.setScrollable(z5);
    }

    @Deprecated
    public void h(int i5) {
        this.f1276a.setToIndex(i5);
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f1276a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
