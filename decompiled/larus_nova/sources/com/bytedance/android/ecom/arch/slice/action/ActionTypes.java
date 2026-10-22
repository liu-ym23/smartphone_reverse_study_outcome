package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ActionTypes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Function0<l<SlcCommonAction>>> f49974a = null;

    static {
        f49974a = new HashMap();
    }

    public static void a(final String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "handlerCreator");
        HashMap<String, Function0<l<SlcCommonAction>>> r102 = f49974a;
        if (r102.containsKey(r100) == false) goto L6;
        nq.a.c(null, new ActionTypes$registerCustomAction$1(r100), 1);
        return;
    L6:
        r102.put(r100, r101);
    }
}
