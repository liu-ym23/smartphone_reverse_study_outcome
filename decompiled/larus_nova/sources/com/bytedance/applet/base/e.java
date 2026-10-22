package com.bytedance.applet.base;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements g2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f191459a = null;

    static {
        f191459a = new e();
    }

    public e() {
    }

    @Override // g2.d
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.d(r100, r101);
    }

    @Override // g2.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e(r100, r101);
    }

    @Override // g2.d
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i(r100, r101);
    }

    @Override // g2.d
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w(r100, r101);
    }

    @Override // g2.d
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e(r100, r101, r102);
    }

    @Override // g2.d
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w(r100, r101, r102);
    }
}
