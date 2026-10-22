package com.bytedance.android.live.soloktv.viewmodel;

import com.bytedance.android.live.soloktv.model.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f101880a;

    public static e a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        return new e(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f101880a, ((e) r100).f101880a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        j r100 = this.f101880a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PracticeSongPageUIState(pageState=" + this.f101880a + ")";
    }

    public e(j r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        this.f101880a = r100;
    }
}
