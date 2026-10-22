package com.bytedance.android.gamecp.business.gamedetail.component.interactionplay;

import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f54369b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f54370a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54370a, ((e) r100).f54370a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f54370a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "InteractionPlayEntranceState(layerVisible=" + this.f54370a + ")";
    }

    public e() {
        this(Boolean.TRUE);
    }

    public e(Boolean r100) {
        this.f54370a = r100;
    }
}
