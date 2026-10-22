package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f41151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.anniex.scene.data.b f41152b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f41151a, r101.f41151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f41152b, r101.f41152b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f41151a.hashCode() * 31) + this.f41152b.hashCode();
    }

    public final String toString() {
        return "SceneInfoCollection(sceneFingerprint=" + this.f41151a + ", queryInfo=" + this.f41152b + ')';
    }

    public i(h r100, com.bytedance.android.anniex.scene.data.b r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneFingerprint");
        Intrinsics.checkNotNullParameter(r101, "queryInfo");
        this.f41151a = r100;
        this.f41152b = r101;
    }
}
