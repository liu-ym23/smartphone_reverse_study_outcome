package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f132022a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        String r102 = "[GIFT_MSG_MAIN]" + r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        jy0.b.a(r102, r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        String r102 = "[GIFT_MSG_MAIN]" + r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        jy0.b.c(r102, r101, null, 4);
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        String r102 = "[GIFT_MSG_MAIN]" + r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        jy0.b.f(r102, r101, null, 4);
    }
}
