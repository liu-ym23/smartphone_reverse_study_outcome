package com.bytedance.android.ecom.arch.slice.render.elements.list;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcElement f50470b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f50469a == r101.f50469a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f50470b, r101.f50470b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f50469a * 31;
        SlcElement r101 = this.f50470b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ListElementData(viewType=" + this.f50469a + ", element=" + this.f50470b + ")";
    }

    public a(int r100, SlcElement r101) {
        this.f50469a = r100;
        this.f50470b = r101;
    }
}
