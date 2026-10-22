package com.bytedance.android.ecom.arch.slice.slices;

import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.f;
import com.bytedance.android.ecom.arch.slice.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes44.dex */
public final class c<Slice extends g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<Slice> f51030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<SlcContext, f, SlcBaseViewHolder<Slice>> f51031b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f51030a, r101.f51030a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51031b, r101.f51031b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        KClass<Slice> r100 = this.f51030a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function2<SlcContext, f, SlcBaseViewHolder<Slice>> r104 = this.f51031b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SliceMapValue(cls=" + this.f51030a + ", sliceVHCreator=" + this.f51031b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(KClass<Slice> r100, Function2<? super SlcContext, ? super f, ? extends SlcBaseViewHolder<Slice>> r101) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Intrinsics.checkNotNullParameter(r101, "sliceVHCreator");
        this.f51030a = r100;
        this.f51031b = r101;
    }
}
