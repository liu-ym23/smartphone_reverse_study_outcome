package com.bytedance.anniex.bd.foundation.impl;

import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {
    public i() {
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        mr3.a.f514979a.getClass();
        ALog.d(r100, r101);
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALog.e(r100, r101);
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        mr3.a.f514979a.getClass();
        ALog.i(r100, r101);
    }
}
