package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f55521b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.dynamiccommon.page.a<JSONObject> f55522a;

    public static final class a {
        public static com.bytedance.ies.sve_core.u a() {
            return new com.bytedance.ies.sve_core.u("audience_game_detail_page_state");
        }
    }

    static {
    }

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55522a, ((g) r100).f55522a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.business.dynamiccommon.page.a<JSONObject> r100 = this.f55522a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AudienceGameDetailPageState(commonData=" + this.f55522a + ")";
    }

    public g(com.bytedance.android.gamecp.business.dynamiccommon.page.a<JSONObject> r100) {
        Intrinsics.checkNotNullParameter(r100, "commonData");
        this.f55522a = r100;
    }

    public /* synthetic */ g(int r100) {
        this(new com.bytedance.android.gamecp.business.dynamiccommon.page.a(0));
    }
}
