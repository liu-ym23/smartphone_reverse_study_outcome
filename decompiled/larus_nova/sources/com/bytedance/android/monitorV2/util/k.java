package com.bytedance.android.monitorV2.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f163240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f163241b;

    public k(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f163240a = r100;
        this.f163241b = new HashMap();
    }

    public final Long a(Long r100) {
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_finish", "pathX");
        Intrinsics.checkNotNullParameter("res_load_perf.res_load_start", "pathY");
        Object r101 = b("res_load_perf.res_load_finish");
        Object r102 = b("res_load_perf.res_load_start");
        if (r101 == null) goto L11;
        if (r102 != null) goto L6;
        return r100;
    L6:
        if ((r101 instanceof Number) == true) goto L8;
        return r100;
    L8:
        if ((r102 instanceof Number) == true) goto L10;
        return r100;
    L10:
        return Long.valueOf(((Number) r101).longValue() - ((Number) r102).longValue());
    L11:
        return r100;
    }

    public final Object b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L10;
        return null;
    L10:
        if (((HashMap) this.f163241b).containsKey(r110) == false) goto L14;
        return ((HashMap) this.f163241b).get(r110);
    L14:
        if (this.f163240a.has(r110) == false) goto L19;
        Object r101 = this.f163240a.opt(r110);
        if (((HashMap) this.f163241b).containsKey(r110) == true) goto L18;
        ((HashMap) this.f163241b).put(r110, r101);
    L18:
        return r101;
    L19:
        int r102 = StringsKt.lastIndexOf$default(r110, ".", 0, false, 6, null);
        if (r102 >= 0) goto L22;
        return null;
    L22:
        Object r103 = b(r110.substring(0, r102));
        if (r103 != null) goto L25;
    L32:
        return null;
    L25:
        if ((r103 instanceof JSONObject) == false) goto L32;
        Object r104 = ((JSONObject) r103).opt(r110.substring(r102 + 1));
        if (r104 != null) goto L29;
    L31:
        return r104;
    L29:
        if (((HashMap) this.f163241b).containsKey(r110) == true) goto L31;
        ((HashMap) this.f163241b).put(r110, r104);
        goto L31
    L5:
        r100 = false;
        goto L7
    }

    public static /* synthetic */ Long d(k r100, String r101) {
        return r100.c(r101, 0L);
    }

    public final Long c(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Object r102 = b(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof Number) == true) goto L8;
        return r101;
    L8:
        return Long.valueOf(((Number) r102).longValue());
    }

    public final String e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Object r102 = b(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if ((r102 instanceof String) == true) goto L8;
        return r101;
    L8:
        return (String) r102;
    }
}
