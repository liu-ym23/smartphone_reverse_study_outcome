package com.bytedance.android.ec.adapter.api.state;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECEcomData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f42684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42685b;

    public ECEcomData() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECEcomData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f42685b, ((ECEcomData) r100).f42685b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f42685b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECEcomData(_ecomData=" + this.f42685b + ")";
    }

    public ECEcomData(String r100) {
        this.f42685b = r100;
        this.f42684a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ECEcomData$ecomData$2(this));
    }
}
