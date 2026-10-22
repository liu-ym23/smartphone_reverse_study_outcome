package com.bytedance.android.livesdk.model;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Long> f153936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Long> f153937b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == false) goto L10;
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f153936a, r101.f153936a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f153937b, r101.f153937b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HashMap<String, Long> r100 = this.f153936a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, Long> r104 = this.f153937b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiCameraUIConfig(panelAutoShowMap=" + this.f153936a + ", openPanelFromUser=" + this.f153937b + ")";
    }

    public d0(HashMap<String, Long> r100, HashMap<String, Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "panelAutoShowMap");
        Intrinsics.checkNotNullParameter(r101, "openPanelFromUser");
        this.f153936a = r100;
        this.f153937b = r101;
    }
}
