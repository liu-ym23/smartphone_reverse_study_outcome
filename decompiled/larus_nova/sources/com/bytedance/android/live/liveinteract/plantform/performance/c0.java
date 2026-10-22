package com.bytedance.android.live.liveinteract.plantform.performance;

import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f77313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Map<String, d0>, Unit> f77314b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L10;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f77313a, r101.f77313a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f77314b, r101.f77314b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HashSet<String> r100 = this.f77313a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<? super Map<String, d0>, Unit> r104 = this.f77314b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PerfAbilityCB(abilityKeys=" + this.f77313a + ", cb=" + this.f77314b + ")";
    }

    public c0(HashSet<String> r100, Function1<? super Map<String, d0>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "abilityKeys");
        Intrinsics.checkNotNullParameter(r101, "cb");
        this.f77313a = r100;
        this.f77314b = r101;
    }
}
