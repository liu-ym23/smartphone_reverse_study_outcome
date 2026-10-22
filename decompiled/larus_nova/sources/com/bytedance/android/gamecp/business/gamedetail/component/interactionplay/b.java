package com.bytedance.android.gamecp.business.gamedetail.component.interactionplay;

import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54355a;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54355a, ((b) r100).f54355a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f54355a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "InteractionPlayEntranceClickIntent(schema=" + this.f54355a + ")";
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f54355a = r100;
    }
}
