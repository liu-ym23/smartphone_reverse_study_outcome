package com.bytedance.android.ecom.bcm.track.impl.monitor;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51113a = 0;

    static {
    }

    public static com.bytedance.android.btm.api.model.g a(final com.bytedance.android.btm.api.model.h r110) {
        boolean r100 = false;
        if (com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == false) goto L9;
        return null;
    L9:
        int r103 = com.bytedance.android.ecom.bcm.track.impl.util.a.f51158a;
        JSONObject r104 = r110.f42056b;
        if (r104 == null) goto L12;
        String r105 = r104.optString("btm");
    L13:
        final String r106 = com.bytedance.android.ecom.bcm.track.impl.util.a.b(r105);
        final String r107 = com.bytedance.android.ecom.bcm.track.impl.util.a.a(r106);
        JSONObject r108 = r110.f42056b;
        if (r108 == null) goto L38;
        JSONObject r109 = r108.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r109 != null) goto L29;
        String r111 = r108.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r111.length() >= 5) goto L51;
        r109 = null;
        goto L29
    L51:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L25
        r109 = new JSONObject(r111);     // Catch: Throwable -> L25
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L28:
        Result.m9448boximpl(r113);
    L23:
        th = th;
    L27:
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        th = th;
        r109 = null;
    L29:
        if (r109 == null) goto L37;
        String r115 = r109.optString(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE);
        if (r115 != null) goto L33;
    L34:
        r100 = true;
    L35:
        if (r100 == false) goto L38;
        String r116 = "no bst_group_type in entranceInfo";
    L39:
        if (r116 == null) goto L55;
        JSONObject r117 = r110.f42056b;
        if (r117 == null) goto L45;
        String r118 = r117.optString("page_name");
        if (r118 == null) goto L45;
    L46:
        final String r119 = r118;
        JSONObject r120 = r110.f42056b;
        if (r120 == null) goto L49;
        r102 = r120.opt(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L49:
        final String r121 = r116;
        return new com.bytedance.android.btm.api.model.g(new EcomEventChecker$generateErrInfo$1(r119, r110, r106, r107, r121), 3008, String.valueOf(r102), r116);
    L45:
        r118 = "null";
        goto L46
    L55:
        return null;
    L33:
        if (r115.length() != 0) goto L35;
    L37:
        r116 = "no entranceInfo";
    L38:
        r116 = null;
        goto L39
    L12:
        r105 = "";
        goto L13
    L5:
        r101 = false;
        goto L6
    }
}
