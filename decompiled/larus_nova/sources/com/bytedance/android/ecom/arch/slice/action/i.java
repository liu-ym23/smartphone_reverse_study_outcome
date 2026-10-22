package com.bytedance.android.ecom.arch.slice.action;

import com.byted.cast.common.TeaEventTrack;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, Map<String, ? extends Object>, Unit> f49991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f49992b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f49991a, r101.f49991a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f49992b, r101.f49992b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Function2<String, Map<String, ? extends Object>, Unit> r100 = this.f49991a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f49992b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExecuteContext(next=" + this.f49991a + ", preResult=" + this.f49992b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        this.f49991a = r100;
        this.f49992b = r101;
    }
}
