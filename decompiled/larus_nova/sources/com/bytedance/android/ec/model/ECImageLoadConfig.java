package com.bytedance.android.ec.model;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes44.dex */
public final class ECImageLoadConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47851b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f47852a;

    public static final class a {
    }

    public ECImageLoadConfig() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECImageLoadConfig) == true) goto L6;
        return false;
    L6:
        if (this.f47852a == ((ECImageLoadConfig) r100).f47852a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f47852a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ECImageLoadConfig(canUseRGB565=" + this.f47852a + ")";
    }

    static {
        f47851b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ECImageLoadConfig$Companion$noUseRGB565$2.INSTANCE);
    }

    public ECImageLoadConfig(boolean r100) {
        this.f47852a = r100;
    }
}
