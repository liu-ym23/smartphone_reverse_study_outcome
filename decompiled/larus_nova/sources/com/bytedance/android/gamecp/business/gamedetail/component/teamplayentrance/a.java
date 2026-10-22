package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55099a;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55099a, ((a) r100).f55099a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f55099a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TeamPlayEntranceClickIntent(schema=" + this.f55099a + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f55099a = r100;
    }
}
