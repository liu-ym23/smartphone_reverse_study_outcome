package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f55481b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f55482a;

    public static final class a {
        public static com.bytedance.ies.sve_core.u a() {
            return new com.bytedance.ies.sve_core.u("audience_game_detail_common_state");
        }
    }

    static {
    }

    public static d c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "pageAppearance");
        return new d(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55482a, ((d) r100).f55482a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f55482a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AudienceGameDetailCommonState(pageAppearance=" + this.f55482a + ")";
    }

    public d() {
        this(new b(null, 0, 0, 0, 255));
    }

    public d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "pageAppearance");
        this.f55482a = r100;
    }
}
