package ca0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22919a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f22919a, ((t) r100).f22919a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f22919a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OpenPopupGiftDialogEvent(clickSource=" + this.f22919a + ")";
    }

    public t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickSource");
        this.f22919a = r100;
    }
}
