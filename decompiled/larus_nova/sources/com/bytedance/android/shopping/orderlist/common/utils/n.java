package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179982a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f179984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f179985c;

        public a(String r100, boolean r101, boolean r102) {
            this.f179983a = r100;
            this.f179984b = r101;
            this.f179985c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.ec.sdk.helper.i r100 = com.bytedance.android.ec.sdk.helper.i.f48124a;     // Catch: Throwable -> L7
            Context r101 = ECAppInfoService.f48114e.getApplicationContext();     // Catch: Throwable -> L7
            String r102 = this.f179983a;     // Catch: Throwable -> L7
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r100.e(r101, r102, this.f179984b, this.f179985c);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public n() {
    }

    static {
    }

    public static void a(String r100, boolean r101, boolean r102) {
        if (r100 != null) goto L5;
        String r103 = "";
    L7:
        if ((!StringsKt.isBlank(r103)) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        com.bytedance.android.ec.sdk.helper.i r104 = com.bytedance.android.ec.sdk.helper.i.f48124a;
        Context r105 = ECAppInfoService.f48114e.getApplicationContext();
        if (r100 != null) goto L13;
        r100 = "";
    L13:
        r104.e(r105, r100, r101, r102);
        return;
    L14:
        new Handler(Looper.getMainLooper()).post(new a(r100, r101, r102));
        return;
    L5:
        r103 = r100;
        goto L7
    }
}
