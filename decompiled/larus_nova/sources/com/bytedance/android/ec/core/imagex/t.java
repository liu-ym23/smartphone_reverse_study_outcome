package com.bytedance.android.ec.core.imagex;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f44951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, r> f44952b = null;

    static {
        f44951a = new r("ec_default", "unknown");
        f44952b = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final r a(Context r100) {
        if (r100 == null) goto L7;
        Activity r101 = com.bytedance.android.ec.core.utils.l0.b(r100);
        if (r101 == null) goto L7;
        return new r("ec_default", "unknown", r101.getClass().getName());
    L7:
        return f44951a;
    }

    @JvmStatic
    public static final r c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r101 = com.bytedance.android.ec.core.utils.l0.b(r100);
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        String r102 = String.valueOf(r100.hashCode());
        Intrinsics.checkNotNullParameter(r102, "id");
        return (r) ((ConcurrentHashMap) f44952b).remove(r102);
    }

    @JvmStatic
    public static final void b(Context r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callerContext");
        Activity r102 = com.bytedance.android.ec.core.utils.l0.b(r100);
        if (r102 == null) goto L5;
        r100 = r102;
    L5:
        String r103 = String.valueOf(r100.hashCode());
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r101, "callerContext");
        if (StringsKt.isBlank(r103) == true) goto L10;
        ((ConcurrentHashMap) f44952b).put(r103, r101);
        return;
    }
}
