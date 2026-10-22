package com.bytedance.android.ec.sdk.helper;

import com.bytedance.android.ec.local.api.ErrorType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48125a = 0;

    public j() {
    }

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        cl.d r102 = k.a();
        if (r102 == null) goto L6;
        r102.o(r100, r101, ErrorType.ERROR);
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        cl.d r102 = k.a();
        if (r102 == null) goto L6;
        r102.o(r100, r101, ErrorType.NOTIFY);
        return;
    }

    public static void a(String r100, String r101, Map r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        cl.d r104 = k.a();
        if (r104 == null) goto L6;
        r104.o(r100, r101, ErrorType.DEFAULT);
        return;
    }

    public static void d(String r100, String r101, Map r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        cl.d r104 = k.a();
        if (r104 == null) goto L6;
        r104.o(r100, r101, ErrorType.WARING);
        return;
    }
}
