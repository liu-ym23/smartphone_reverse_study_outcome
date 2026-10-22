package com.bytedance.android.ec.core.anchorv3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpMessageOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f43751a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f43752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f43753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BasePdpMessageOptWorker f43754d;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityDestroyed", "msg");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityPaused", "msg");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityResumed", "msg");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityStarted", "msg");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityStopped", "msg");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r102 = PdpMessageOpt.f43751a;
            Intrinsics.checkNotNullParameter("call onActivityCreated", "msg");
        }
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    static {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        boolean r101 = r100.isLocalTest();
        f43751a = r101;
        i r102 = ECSettingKeys.w0();
        f43752b = r102;
        if (r101 == false) goto L16;
        e("call init isEnableOptV2=" + r102.g());
        Context r103 = r100.getApplicationContext();
        Context r104 = null;
        if (r103 == null) goto L7;
        Context r105 = r103.getApplicationContext();
    L9:
        if ((r105 instanceof Application) == false) goto L12;
        r104 = r105;
    L12:
        Application r106 = (Application) r104;
        if (r106 == null) goto L17;
        r106.registerActivityLifecycleCallbacks(new a());
        return;
    L17:
        return;
    L7:
        r105 = null;
        goto L9
    }

    public static boolean b() {
        return f43752b.b();
    }

    public static boolean c() {
        i r100 = f43752b;
        Boolean r101 = r100.d();
        if (r101 == null) goto L6;
        return r101.booleanValue();
    L6:
        return r100.g();
    }

    public static boolean d() {
        i r100 = f43752b;
        Boolean r101 = r100.f();
        if (r101 == null) goto L6;
        return r101.booleanValue();
    L6:
        return r100.g();
    }

    public static void f(String r100) {
        if (Intrinsics.areEqual(r100, f43753c) == false) goto L9;
        BasePdpMessageOptWorker r101 = f43754d;
        if (r101 == null) goto L7;
        Field r102 = BasePdpMessageOptWorker.f43739f;
        r101.i();
    L7:
        f43754d = null;
        return;
    }

    public static void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "controller");
        if (Intrinsics.areEqual(r100, f43753c) == false) goto L8;
        BasePdpMessageOptWorker r102 = f43754d;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    L9:
        return;
    }

    public static void g(String r100, boolean r101) {
        if (Intrinsics.areEqual(r100, f43753c) == false) goto L8;
        BasePdpMessageOptWorker r102 = f43754d;
        if (r102 == null) goto L9;
        r102.c(r101);
        return;
    L9:
        return;
    }

    public static void h(String r100, boolean r101) {
        if (Intrinsics.areEqual(r100, f43753c) == false) goto L12;
        e("call onGetPack isCache=" + r101);
        if (r101 == true) goto L7;
        return;
    L7:
        if (f43752b.g() == true) goto L14;
        BasePdpMessageOptWorker r102 = f43754d;
        if (r102 == null) goto L15;
        r102.i();
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        i r102 = f43752b;
        if (r102.b() == true) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(f43753c, r100)) == false) goto L15;
        BasePdpMessageOptWorker r103 = f43754d;
        if (r103 == null) goto L10;
        Field r104 = BasePdpMessageOptWorker.f43739f;
        r103.i();
    L10:
        f43753c = r100;
        if (r102.g() == false) goto L13;
        BasePdpMessageOptWorker r105 = new PdpMessageOptWorkerV2(r101);
        PdpMessageOpt$startOpt$1$1 r106 = PdpMessageOpt$startOpt$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r106, "callback");
        ((ArrayList) r105.f43748e).add(r106);
    L14:
        f43754d = r105;
        goto L15
    L13:
        r105 = new j(r101);
        PdpMessageOpt$startOpt$2$1 r107 = PdpMessageOpt$startOpt$2$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "callback");
        ((ArrayList) r105.f43748e).add(r107);
    L15:
        BasePdpMessageOptWorker r108 = f43754d;
        if (r108 == null) goto L19;
        r108.g();
        return;
    }
}
