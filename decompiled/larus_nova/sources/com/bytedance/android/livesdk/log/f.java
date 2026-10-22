package com.bytedance.android.livesdk.log;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153288a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b0 r102 = b0.o();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (StringsKt.startsWith$default(r100, "ttlive_logger_", false, 2, null) == true) goto L6;
        r100 = "ttlive_logger_".concat(r100);
    L6:
        r102.k(r100, r101);
    }
}
