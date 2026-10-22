package com.bytedance.android.shopping.buynow.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171221a = 0;

    public m() {
    }

    static {
    }

    public static void a(int r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        com.bytedance.android.ec.sdk.helper.i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), com.bytedance.android.shopping.extensions.j.c(r100), false, false);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new l(r100, false, false));
    }

    public static void b(String r100) {
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        com.bytedance.android.ec.sdk.helper.i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), r100, false, false);
        return;
    L7:
        new Handler(Looper.getMainLooper()).post(new k(r100, false, false));
    }
}
