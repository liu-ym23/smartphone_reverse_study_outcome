package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import com.bytedance.android.gamecp.business.gamedetail.base.model.GroupJoinStatus;
import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f54325b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GroupJoinStatus f54326a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54326a, ((h) r100).f54326a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        GroupJoinStatus r100 = this.f54326a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "FansGroupState(joinStatus=" + this.f54326a + ")";
    }

    public h(GroupJoinStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "joinStatus");
        this.f54326a = r100;
    }
}
