package com.bytedance.android.ecom.arch.slice.action;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ActionExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f49973a;

    public static void a() {
        if (f49973a == false) goto L5;
        return;
    L5:
        f49973a = true;
        int r100 = xp.a.f564693a;
        ActionExtension$registerActions$1 r101 = ActionExtension$registerActions$1.INSTANCE;
        Intrinsics.checkNotNullParameter("SliceUpdate", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "handlerCreator");
        ActionTypes.a("SliceUpdate", r101);
        ActionExtension$registerActions$2 r102 = ActionExtension$registerActions$2.INSTANCE;
        Intrinsics.checkNotNullParameter("SliceDelete", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "handlerCreator");
        ActionTypes.a("SliceDelete", r102);
    }

    static {
    }
}
