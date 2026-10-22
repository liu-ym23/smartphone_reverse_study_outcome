package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f41133b;

    public final String toString() {
        return "PageAttachEvent(name=" + this.f41132a + ", timestamp=" + this.f41133b + ')';
    }

    public final int hashCode() {
        return this.f41132a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f41132a, ((c) r100).f41132a);
    }

    public c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f41132a = r100;
        this.f41133b = r101;
    }
}
