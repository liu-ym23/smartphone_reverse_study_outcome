package com.bytedance.android.gamecp.business.instantplay.utils;

import kotlin.jvm.internal.Intrinsics;
import yr.b;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56128a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(6, "TeamPlay", r100 + " -> " + r101);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(4, "TeamPlay", r100 + " -> " + r101);
    }
}
