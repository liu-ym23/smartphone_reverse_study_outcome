package com.bytedance.ai.api;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class AppsInstalledStatusUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f33967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f33968b;

    static {
    }

    public static void a(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppsInstalledStatusUtils$getPackageInfo$1(r100, r101, null), 3, null);
    }
}
