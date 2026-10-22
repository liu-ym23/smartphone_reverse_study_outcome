package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.core.utils.rotation.CommonLog;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f45647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f45648b;

        public a(Application r100, Function1 r101) {
            this.f45647a = r100;
            this.f45648b = r101;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (ECAppInfoService.f48114e.b(r100) == false) goto L6;
            this.f45647a.unregisterActivityLifecycleCallbacks(this);
            this.f45648b.invoke(r100);
            return;
        }
    }

    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getParamWithActivityWillFinish");
        return UriProtector.parse(r100).getBooleanQueryParameter("android_activity_will_finish", false);
    L5:
        return false;
    }

    public static void c(final Context r100, final boolean r101, final Function2 r110, final Function2 r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$tryWaitValidActivityCreatedWithErrorMessage");
        Intrinsics.checkNotNullParameter(r110, "successCallback");
        boolean r102 = true;
        final boolean r103 = false;
        Context r104 = null;
        if (com.bytedance.android.ec.core.abtest.d.j() == false) goto L24;
        Intrinsics.checkNotNullParameter(r100, "$this$tryWaitValidActivityCreatedWithErrorMessageV2");
        Intrinsics.checkNotNullParameter(r110, "successCallback");
        ECAppInfoService r105 = ECAppInfoService.f48114e;
        if (r101 == true) goto L7;
        r102 = false;
    L7:
        final Activity r106 = r105.c(r100, r102);
        Lazy r107 = CommonLog.f45699a;
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$1(r101, r103));
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$2(r100, r106));
        if (r106 != null) goto L23;
        boolean r108 = r100 instanceof Activity;
        if (r108 == false) goto L20;
        Activity r109 = (Activity) r100;
        if (r105.b(r109) == true) goto L20;
        Context r112 = r109.getApplicationContext();
        if ((r112 instanceof Application) == false) goto L17;
        r104 = r112;
    L17:
        final Application r113 = (Application) r104;
        com.bytedance.android.ec.sdk.helper.p.f48130a.c(r109);
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$3.INSTANCE);
        final boolean r114 = r109.isTaskRoot();
        if (r113 == null) goto L50;
        r113.registerActivityLifecycleCallbacks(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$4(r113, r110, r114));
        return;
    L50:
        return;
    L20:
        if (r108 == true) goto L22;
        r111.invoke("context is not Activity V2: ".concat(r100.getClass().getName()), "activityWillFinish:" + r101 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$$inlined$also$lambda$1(r100, r111, r101, r103));
        return;
    L22:
        r111.invoke("context is HostMainPage V2: ".concat(r100.getClass().getName()), "activityWillFinish:" + r101 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$$inlined$also$lambda$2(r100, r111, r101, r103));
        return;
    L23:
        r110.invoke(r106, "");
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$6.INSTANCE);
        return;
    L24:
        ECAppInfoService r115 = ECAppInfoService.f48114e;
        if (r101 == true) goto L27;
        r102 = false;
    L27:
        Activity r116 = r115.c(r100, r102);
        Lazy r117 = CommonLog.f45699a;
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$1(r101, r103));
        if (r116 != null) goto L48;
        boolean r118 = r100 instanceof Activity;
        if (r118 == false) goto L42;
        Activity r119 = (Activity) r100;
        if (r119.isTaskRoot() == false) goto L42;
        if (r115.b(r119) == true) goto L42;
        Context r120 = r119.getApplicationContext();
        if ((r120 instanceof Application) == false) goto L39;
        r104 = r120;
    L39:
        final Application r121 = (Application) r104;
        com.bytedance.android.ec.sdk.helper.p.f48130a.c(r119);
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$2.INSTANCE);
        if (r121 == null) goto L55;
        r121.registerActivityLifecycleCallbacks(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$3(r121, r110));
        return;
    L55:
        return;
    L42:
        if (r118 == true) goto L45;
        r111.invoke("context is not Activity: ".concat(r100.getClass().getName()), "activityWillFinish:" + r101 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$1(r100, r111, r101, r103));
        return;
    L45:
        if (((Activity) r100).isTaskRoot() == true) goto L47;
        r111.invoke("context is not in TaskRoot: ".concat(r100.getClass().getName()), "activityWillFinish:" + r101 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$2(r100, r111, r101, r103));
        return;
    L47:
        r111.invoke("context is HostMainPage: ".concat(r100.getClass().getName()), "activityWillFinish:" + r101 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$3(r100, r111, r101, r103));
        return;
    L48:
        r110.invoke(r116, "");
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$5.INSTANCE);
    }

    public static final void b(Context r100, boolean r101, String r102, Function1<? super Activity, Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$tryWaitValidActivityCreated");
        Intrinsics.checkNotNullParameter(r103, "successCallback");
        Intrinsics.checkNotNullParameter(r104, "errorCallback");
        boolean r105 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        ECAppInfoService r107 = ECAppInfoService.f48114e;
        if (r101 == true) goto L11;
        if (r106 == true) goto L11;
    L12:
        Activity r108 = r107.c(r100, r105);
        if (r108 == null) goto L15;
        r103.invoke(r108);
        return;
    L15:
        if ((r100 instanceof Activity) == false) goto L26;
        Activity r109 = (Activity) r100;
        if (r109.isTaskRoot() == false) goto L26;
        if (r107.b(r109) == true) goto L26;
        Context r110 = r109.getApplicationContext();
        if ((r110 instanceof Application) == true) goto L23;
        r110 = null;
    L23:
        Application r111 = (Application) r110;
        com.bytedance.android.ec.sdk.helper.p.f48130a.c(r109);
        if (r111 == null) goto L29;
        r111.registerActivityLifecycleCallbacks(new a(r111, r103));
        return;
    L29:
        return;
    L26:
        r104.invoke();
        return;
    L11:
        r105 = true;
        goto L12
    L5:
        if (a(r102) != true) goto L7;
        r106 = true;
        goto L8
    }
}
