package com.bytedance.ai.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements g2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f37637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g2.d f37638b;

    static {
        f37637a = new g();
    }

    public g() {
    }

    @Override // g2.d
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r102 = f37638b;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // g2.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r102 = f37638b;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // g2.d
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r102 = f37638b;
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // g2.d
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r102 = f37638b;
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // g2.d
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r103 = f37638b;
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // g2.d
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        g2.d r103 = f37638b;
        if (r103 == null) goto L6;
        r103.w(r100, r101, r102);
        return;
    }
}
