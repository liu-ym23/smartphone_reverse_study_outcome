package com.bytedance.android.live.lynx;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$stacktraceString");
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }
}
