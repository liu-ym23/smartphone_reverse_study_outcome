package com.bytedance.android.monitorV2;

import android.os.Handler;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class InternalWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f162982a = null;

    public InternalWatcher() {
    }

    static {
        f162982a = Collections.synchronizedMap(new LinkedHashMap());
    }

    public static void a(final String r100, final String r101, final Map r102, final Map r103) {
        Intrinsics.checkNotNullParameter(r101, "event");
        Handler r104 = com.bytedance.android.monitorV2.executor.a.f163034a;
        com.bytedance.android.monitorV2.executor.a.b(new InternalWatcher$notice$1(r100, r101, r102, r103));
    }

    public static /* synthetic */ void b(String r100, String r101, Map r102, Map r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        a(r100, r101, r102, r103);
    }
}
