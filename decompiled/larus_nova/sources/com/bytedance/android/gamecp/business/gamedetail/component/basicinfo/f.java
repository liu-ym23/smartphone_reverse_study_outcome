package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> f53705a;

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f53705a, ((f) r100).f53705a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> r100 = this.f53705a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AudienceGameDetailInfoV6Descriptions(additionalDescriptionList=" + this.f53705a + ")";
    }

    public f(List<com.bytedance.android.gamecp.business.gamedetail.base.model.a> r100) {
        this.f53705a = r100;
    }
}
