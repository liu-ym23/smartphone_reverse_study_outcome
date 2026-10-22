package com.bytedance.android.live.revenue.common;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90833b;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = v.f91009a;
        v.a(this.f90833b, e(r100));
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = v.f91009a;
        v.e(this.f90833b, e(r100));
    }

    public final void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        int r101 = v.f91009a;
        v.b(this.f90833b, this.f90832a, r100);
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = v.f91009a;
        v.h(this.f90833b, e(r100));
    }

    public final String e(String r100) {
        return this.f90832a + ' ' + r100;
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f90833b = r100;
        if (r101 != null) goto L5;
        r101 = "[" + Integer.toHexString(hashCode()) + ']';
    L5:
        this.f90832a = r101;
    }
}
