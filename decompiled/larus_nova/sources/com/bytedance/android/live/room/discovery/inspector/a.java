package com.bytedance.android.live.room.discovery.inspector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f99543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f99544b;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.inspector.a$a, reason: collision with other inner class name */
    public static final class C1522a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f99543a == r101.f99543a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f99544b, r101.f99544b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f99543a * 31;
        l r101 = this.f99544b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "OfficialInspectorData(type=" + this.f99543a + ", config=" + this.f99544b + ")";
    }

    public final int getType() {
        return this.f99543a;
    }

    public a(int r100, l r101) {
        this.f99543a = r100;
        this.f99544b = r101;
    }
}
