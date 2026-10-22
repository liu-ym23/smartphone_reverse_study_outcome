package com.bytedance.android.ecom.arch.slice.action;

import android.view.View;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f49980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f49981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f49982c;

    public static final class a {
    }

    static {
    }

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f49980a, r101.f49980a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f49981b, r101.f49981b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f49982c, r101.f49982c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f49980a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f49981b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f49982c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionUIContext(view=" + this.f49980a + ", extraTrackParams=" + this.f49981b + ", extraUiParam=" + this.f49982c + ")";
    }

    public c(View r100, Map r101) {
        HashMap r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r102, "extraUiParam");
        this.f49980a = r100;
        this.f49981b = r101;
        this.f49982c = r102;
    }
}
