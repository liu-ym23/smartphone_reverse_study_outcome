package com.bytedance.ai.settings;

import com.bytedance.ai.utils.g;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f37592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f37593b;

    static {
        f37592a = new d();
    }

    public d() {
    }

    public static IAISDKSettings a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl((IAISDKSettings) g37.a.c("flow_ai_sdk").b(IAISDKSettings.class));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 != null) goto L9;
    L12:
        DefaultValueAISDKSettings r103 = DefaultValueAISDKSettings.INSTANCE;
        if (Result.m9455isFailureimpl(r101) == false) goto L16;
        r101 = r103;
    L16:
        return (IAISDKSettings) r101;
    L9:
        if (f37593b == true) goto L11;
        g.f37637a.w("AppletSettingsManager", "obtain settings failed", r102);
        goto L12
    L11:
        throw r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
