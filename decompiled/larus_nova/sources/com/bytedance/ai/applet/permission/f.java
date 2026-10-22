package com.bytedance.ai.applet.permission;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f34948c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f34946a == r101.f34946a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34947b, r101.f34947b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34948c, r101.f34948c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f34946a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f34947b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.f34948c.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletAuthorizeResult(success=" + this.f34946a + ", reason=" + this.f34947b + ", extras=" + this.f34948c + ')';
    }

    public f(boolean r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r102, "extras");
        this.f34946a = r100;
        this.f34947b = r101;
        this.f34948c = r102;
    }

    public /* synthetic */ f(boolean r100, String r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = MapsKt.emptyMap();
    L8:
        this(r100, r101, r102);
    }
}
