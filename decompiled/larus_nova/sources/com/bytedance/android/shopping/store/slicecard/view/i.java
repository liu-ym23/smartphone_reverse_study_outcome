package com.bytedance.android.shopping.store.slicecard.view;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f186415a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f186415a, ((i) r100).f186415a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<g> r100 = this.f186415a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TrustItem(richTexts=" + this.f186415a + ")";
    }

    public final boolean a() {
        List<g> r100 = this.f186415a;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((g) r101.next()).b() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public i(List<g> r100) {
        Intrinsics.checkNotNullParameter(r100, "richTexts");
        this.f186415a = r100;
    }
}
