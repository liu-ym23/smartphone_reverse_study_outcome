package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.lynx.tasm.LynxError;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECExceptionMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45108a = 0;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f45109a;

        public a(Function0 r100) {
            this.f45109a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return this.f45109a.invoke();
        L4:
            th = move-exception;
            return Integer.valueOf(Log.e("ECExceptionMonitor", "post exception monitor failed:", th));
        }
    }

    public ECExceptionMonitor() {
    }

    public static final boolean a() {
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    static {
    }

    public static void b(Function0 r100) {
        Single.fromCallable(new a(r100)).subscribeOn(Schedulers.io()).subscribe();
    }

    @JvmStatic
    public static final void c(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        boolean r101 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r101 = false;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        ECAppInfoService r102 = ECAppInfoService.f48114e;
        if (r102.isDebug() == false) goto L11;
    L13:
        cl.d r103 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r103 == null) goto L18;
        cl.d.b.a(r103, "EC_CATCH_EXCEPTION", "[电商]发生异常： " + r100 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, null, ErrorType.WARING, 12);
        return;
    L18:
        return;
    L11:
        if (r102.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$1(r100));
    }

    @JvmStatic
    public static final void e(final Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        boolean r101 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L7;
        r101 = false;
    L7:
        if (r101 == true) goto L9;
        return;
    L9:
        ECAppInfoService r102 = ECAppInfoService.f48114e;     // Catch: Throwable -> L22
        if (r102.isDebug() == false) goto L12;
    L14:
        cl.d r103 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L22
        if (r103 == null) goto L17;
        cl.d.b.a(r103, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r100 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r100, ErrorType.WARING, 4);     // Catch: Throwable -> L22
    L17:
        cl.d r104 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L22
        if (r104 == null) goto L20;
        r104.l();     // Catch: Throwable -> L22
    L20:
        r100.printStackTrace();     // Catch: Throwable -> L22
        return;
    L12:
        if (r102.isLocalTest() == true) goto L14;
        b(new ECExceptionMonitor$ensureNotReachHere$2(r100));     // Catch: Throwable -> L22
        return;
    }

    @JvmStatic
    public static final void g(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        boolean r101 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r101 = false;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        ECAppInfoService r102 = ECAppInfoService.f48114e;
        if (r102.isDebug() == false) goto L11;
    L13:
        cl.d r103 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r103 == null) goto L18;
        cl.d.b.a(r103, "EC_CATCH_EXCEPTION", "[电商]发生异常： " + r100 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, null, ErrorType.WARING, 12);
        return;
    L18:
        return;
    L11:
        if (r102.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHereDetail$1(r100));
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        cl.d r101 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r101 == null) goto L6;
        cl.d.b.a(r101, "EC_TIP", r100, null, null, null, 28);
        return;
    }

    @JvmStatic
    public static final void f(final Throwable r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "msg");
        boolean r102 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r102 = false;
    L6:
        if (r102 == true) goto L8;
        return;
    L8:
        ECAppInfoService r103 = ECAppInfoService.f48114e;
        if (r103.isDebug() == false) goto L11;
    L13:
        cl.d r104 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r104 == null) goto L16;
        cl.d.b.a(r104, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r101 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r100, ErrorType.WARING, 4);
    L16:
        cl.d r105 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r105 == null) goto L19;
        r105.l();
    L19:
        r100.printStackTrace();
        return;
    L11:
        if (r103.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$3(r100, r101));
    }

    @JvmStatic
    public static final void d(final String r100, final Throwable r101, final String r110) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r110, "msg");
        boolean r102 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r102 = false;
    L6:
        if (r102 == true) goto L8;
        return;
    L8:
        ECAppInfoService r103 = ECAppInfoService.f48114e;
        if (r103.isDebug() == false) goto L11;
    L13:
        cl.d r104 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r104 == null) goto L16;
        cl.d.b.a(r104, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r110 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r101, ErrorType.WARING, 4);
    L16:
        cl.d r105 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r105 == null) goto L21;
        r105.l();
        return;
    L21:
        return;
    L11:
        if (r103.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$4(r100, r101, r110));
    }
}
