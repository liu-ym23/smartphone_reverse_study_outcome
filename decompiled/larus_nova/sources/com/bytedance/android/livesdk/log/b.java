package com.bytedance.android.livesdk.log;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f153277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153278b;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        b0 r101 = b0.o();
        String r102 = this.f153278b;
        String r103 = this.f153277a + ' ' + r100;
        r101.getClass();
        com.bytedance.android.live.core.log.g.a(r102, r103);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        b0 r101 = b0.o();
        String r102 = this.f153278b;
        String r103 = this.f153277a + ' ' + r100;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i(r102, r103);
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f153278b = r100;
        if (r101 != null) goto L5;
        r101 = "[" + Integer.toHexString(hashCode()) + ']';
    L5:
        this.f153277a = r101;
    }
}
