package com.bytedance.android.live.revlink.link.infra.rtcbiz;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98733a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f98733a, ((d) r100).f98733a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f98733a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RenderView(linkerID=" + this.f98733a + ")";
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkerID");
        this.f98733a = r100;
    }
}
