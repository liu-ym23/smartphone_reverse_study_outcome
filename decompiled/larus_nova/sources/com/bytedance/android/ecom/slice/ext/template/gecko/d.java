package com.bytedance.android.ecom.slice.ext.template.gecko;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SlcTemplateFetchType> f51256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<SlcTemplateFetchType>> f51257b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f51256a, r101.f51256a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51257b, r101.f51257b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<SlcTemplateFetchType> r100 = this.f51256a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<SlcTemplateFetchType>> r104 = this.f51257b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcForestFetchSeqConfig(defaultFetchSequences=" + this.f51256a + ", fileSuffixFetchSequences=" + this.f51257b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends SlcTemplateFetchType> r100, Map<String, ? extends List<? extends SlcTemplateFetchType>> r101) {
        this.f51256a = r100;
        this.f51257b = r101;
    }
}
