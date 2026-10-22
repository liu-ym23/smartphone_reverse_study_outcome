package com.bytedance.android.shopping.api.mall.idl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f170547a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f170547a, ((a) r100).f170547a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f170547a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MallHostModel(screenModel=" + this.f170547a + ")";
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "screenModel");
        this.f170547a = r100;
    }
}
