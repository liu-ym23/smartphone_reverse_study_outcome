package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f179831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcTemplateContext f179832b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L10;
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f179831a, r101.f179831a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f179832b, r101.f179832b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f179831a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SlcTemplateContext r104 = this.f179832b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TemplateContextCandidate(source=" + this.f179831a + ", templateContext=" + this.f179832b + ")";
    }

    public k0(String r100, SlcTemplateContext r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "templateContext");
        this.f179831a = r100;
        this.f179832b = r101;
    }
}
