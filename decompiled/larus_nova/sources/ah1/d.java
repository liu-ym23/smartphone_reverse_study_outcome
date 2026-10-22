package ah1;

import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DialogInterface f3407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KeyEvent f3409c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f3407a, r101.f3407a) == true) goto L8;
        return false;
    L8:
        if (this.f3408b == r101.f3408b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f3409c, r101.f3409c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        DialogInterface r100 = this.f3407a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f3408b) * 31;
        KeyEvent r104 = this.f3409c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProcessKeyEvent(dialog=" + this.f3407a + ", keyCode=" + this.f3408b + ", event=" + this.f3409c + ")";
    }

    public d(DialogInterface r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r102, "event");
        this.f3407a = r100;
        this.f3408b = r101;
        this.f3409c = r102;
    }
}
