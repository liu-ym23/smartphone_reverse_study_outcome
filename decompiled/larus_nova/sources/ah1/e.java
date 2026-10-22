package ah1;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f3410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MotionEvent f3411b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f3410a, r101.f3410a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3411b, r101.f3411b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f3410a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        MotionEvent r104 = this.f3411b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TouchEvent(view=" + this.f3410a + ", event=" + this.f3411b + ")";
    }

    public e(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        this.f3410a = r100;
        this.f3411b = r101;
    }
}
