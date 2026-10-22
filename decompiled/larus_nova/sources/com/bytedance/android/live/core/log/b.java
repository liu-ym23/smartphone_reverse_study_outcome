package com.bytedance.android.live.core.log;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements pm0.b {
    public b() {
    }

    @Override // pm0.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.d(r100, r101);
    }

    @Override // pm0.a
    public final void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ALogger.e(r100, r101);
    }

    @Override // pm0.a
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.i(r100, r101);
    }

    @Override // pm0.a
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.w(r100, r101);
    }

    @Override // pm0.a
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.e(r100, r101);
    }

    @Override // pm0.a
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        ALogger.e(r100, r101, r102);
    }

    @Override // pm0.a
    public final void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        Intrinsics.checkNotNullParameter("ttlive_exception", "tag");
        Intrinsics.checkNotNullParameter(r102, "traceElement");
        ALogger.stacktrace(6, "ttlive_exception", r102);
    }
}
