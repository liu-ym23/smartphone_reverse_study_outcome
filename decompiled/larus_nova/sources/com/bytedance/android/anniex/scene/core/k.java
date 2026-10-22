package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f41156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41157c;

    public final String toString() {
        return "ViewAttachEvent(url=" + this.f41155a + ", timestamp=" + this.f41156b + ", sessionId=" + this.f41157c + ')';
    }

    public final int hashCode() {
        return this.f41155a.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.f41155a, ((k) r100).f41155a);
    }

    public k(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f41155a = r100;
        this.f41156b = r101;
        this.f41157c = r102;
    }
}
