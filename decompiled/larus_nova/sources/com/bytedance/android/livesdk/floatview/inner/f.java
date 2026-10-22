package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125181a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ALogger.i("InnerFloatWindowTracker", "dismiss window for reason: " + r100);
    }
}
