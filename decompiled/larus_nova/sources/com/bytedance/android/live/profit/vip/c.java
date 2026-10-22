package com.bytedance.android.live.profit.vip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final py.k f89132a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f89132a, ((c) r100).f89132a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        py.k r100 = this.f89132a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "EmojiLabel(img=" + this.f89132a + ")";
    }

    public c(py.k r100) {
        this.f89132a = r100;
    }
}
