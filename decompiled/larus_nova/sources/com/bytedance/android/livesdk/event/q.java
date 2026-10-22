package com.bytedance.android.livesdk.event;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<r> f123363a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f123363a, ((q) r100).f123363a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<r> r100 = this.f123363a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MentionInfo(infoList=" + this.f123363a + ")";
    }

    public q(List<r> r100) {
        this.f123363a = r100;
    }
}
