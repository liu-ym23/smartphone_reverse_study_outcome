package com.bytedance.android.live.ktv.common.karaokestation.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, b> f69500a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f69500a, ((c) r100).f69500a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<Integer, b> r100 = this.f69500a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "DefaultTabDataEvent(defaultTabDataMap=" + this.f69500a + ")";
    }

    public c(Map<Integer, b> r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultTabDataMap");
        this.f69500a = r100;
    }
}
