package com.bytedance.ai.applet.services;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\rJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0018J\u001d\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u001d\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001eJ\u001d\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b J\u001d\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b$J\u001d\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020+H\u0007J\u0012\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0012\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010.\u001a\u00020\u000fH\u0007J\u0010\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u00102\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u00103R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ai/applet/services/AppletAppManagerService;", "", "<init>", "()V", "TAG", "", "installedApps", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ai/applet/app/AppletApplication;", "lifecycleCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/applet/services/AppLifecycleCallbacks;", "nativeAppClasses", "Ljava/lang/Class;", "registerNativeApp", "", "appId", "clazz", "unregisterNativeApp", "registerAppLifecycleCallbacks", "callback", "unregisterAppLifecycleCallbacks", "dispatchAppAttached", "app", "dispatchAppAttached$ai_sdk_release", "dispatchAppCreated", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dispatchAppCreated$ai_sdk_release", "dispatchAppTaskForeground", "dispatchAppTaskForeground$ai_sdk_release", "dispatchAppTaskBackground", "dispatchAppTaskBackground$ai_sdk_release", "dispatchAppResumed", "dispatchAppResumed$ai_sdk_release", "dispatchAppStopped", "dispatchAppStopped$ai_sdk_release", "dispatchAppDestroyView", "dispatchAppDestroyView$ai_sdk_release", "dispatchAppDestroyed", "dispatchAppDestroyed$ai_sdk_release", "installApp", ErrorType.MANIFEST, "Lcom/bytedance/ai/model/objects/Applet;", "uninstallApp", "terminateApp", "clearInstalledApps", "findInstalledApp", "findInstalledOnlineApp", "Lcom/bytedance/ai/applet/app/OnlineAppletApplication;", "provideApp", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppManagerService {
    public static final AppletAppManagerService INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AppletApplication> f35187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<AppLifecycleCallbacks> f35188b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Class<? extends AppletApplication>> f35189c = null;

    public AppletAppManagerService() {
    }

    static {
        INSTANCE = new AppletAppManagerService();
        f35187a = new ConcurrentHashMap();
        f35188b = new CopyOnWriteArrayList();
        f35189c = new ConcurrentHashMap();
    }

    public static AppletApplication a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        return f35187a.get(r100);
    }

    public static OnlineAppletApplication b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        AppletApplication r101 = f35187a.get(r100);
        if ((r101 instanceof OnlineAppletApplication) == true) goto L7;
        return null;
    L7:
        return (OnlineAppletApplication) r101;
    }

    public static AppletApplication c(Applet r100) {
        Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
        String r101 = r100.K;
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "installApp: " + r101);
        AppletApplication r103 = f35187a.get(r101);
        if (r103 != null) goto L31;
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "installApp: create new AppletApplication for " + r101);
        Set<String> r104 = null;
        if (r100.F != CastIntegerProtector.parseInt("2")) goto L18;
        Class<? extends AppletApplication> r105 = f35189c.get(r101);
        if (r105 != null) goto L29;
        com.bytedance.ai.applet.base.log.a.b("AppletAppManagerService", "installApp: " + r101 + " is not registered as native app", null);
        AppletApplication r106 = null;
    L19:
        if (r106 == null) goto L32;
        Intrinsics.checkNotNullParameter(r100, ErrorType.MANIFEST);
        if (r106.f34083b == null) goto L23;
        com.bytedance.ai.applet.base.log.a.b("AppletApplication", "attach: app is already attached", null);
    L27:
        f35187a.put(r101, r106);
        return r106;
    L23:
        r106.f34083b = r100;
        r100.e();
        com.bytedance.ai.applet.base.log.d r107 = new com.bytedance.ai.applet.base.log.d("AppletApplication", r106.getAppId());
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f34084c = r107;
        com.bytedance.ai.applet.base.log.d r108 = r106.i();
        StringBuilder r109 = new StringBuilder("attach: appType=");
        r109.append(r100.F);
        r109.append(", runtimeVersion=");
        r109.append(r100.C);
        r109.append(", manifestAppletId=");
        r109.append(r100.K);
        r109.append(", permKeys=");
        Map<String, PermissionDetail> r110 = r100.W;
        if (r110 == null) goto L26;
        r104 = r110.keySet();
    L26:
        r109.append(r104);
        r108.c(r109.toString());
        r106.f34086e = new v(r106);
        r106.p();
        goto L27
    L32:
        return r103;
    L29:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L10
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "installApp: " + r101 + " is native app, clazz: " + r105.getName());     // Catch: Throwable -> L10
        Object r112 = Result.m9449constructorimpl(r105.getConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: Throwable -> L10
    L12:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L16;
        com.bytedance.ai.applet.base.log.b r114 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("AppletAppManagerService", "installApp: failed to create instance for " + r101, r113);
        r112 = null;
    L16:
        r106 = (AppletApplication) r112;
    L10:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        r106 = new OnlineAppletApplication();
        goto L19
    L31:
        return r103;
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "terminateApp: " + r100);
        AppletApplication r102 = g(r100);
        if (r102 == null) goto L10;
        r102.i().c(EventVerify.TYPE_TERMINATE);
        r102.f34091j = true;
        AppletAppActivity r103 = r102.f34085d;
        if (r103 != null) goto L7;
        r102.i().c("terminate: appActivity is null");
        r102.g();
        return;
    L7:
        if (r103.isFinishing() == true) goto L12;
        r103.B1();
        return;
    L12:
        return;
    L10:
        com.bytedance.ai.applet.base.log.a.b("AppletAppManagerService", "terminateApp: applet " + r100 + " is not found", null);
    }

    public static AppletApplication g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppManagerService", "uninstallApp: " + r100);
        return f35187a.remove(r100);
    }

    public final void registerAppLifecycleCallbacks(AppLifecycleCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f35188b.addIfAbsent(r100);
    }

    public static void e(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        f35189c.put(r100, r101);
    }

    public final Object d(String r100, Continuation<? super AppletApplication> r101) {
        if ((r101 instanceof AppletAppManagerService$provideApp$1) == false) goto L7;
        AppletAppManagerService$provideApp$1 r102 = (AppletAppManagerService$provideApp$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L35:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L25:
        Applet r107 = (Applet) r104;
        if (r107 != null) goto L28;
    L36:
        com.bytedance.ai.applet.base.log.b r108 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r109 = new StringBuilder("provideApplication: applet ");
        r109.append(r100);
        r109.append(" is not match runtime version, runtimeVersion=");
        if (r107 == null) goto L39;
        String r110 = r107.C;
    L40:
        r109.append(r110);
        com.bytedance.ai.applet.base.log.a.b("AppletAppManagerService", r109.toString(), null);
        return null;
    L39:
        r110 = null;
        goto L40
    L28:
        if (r107.F != CastIntegerProtector.parseInt("2")) goto L30;
    L32:
        MainCoroutineDispatcher r111 = Dispatchers.getMain().getImmediate();
        AppletAppManagerService$provideApp$3 r112 = new AppletAppManagerService$provideApp$3(r100, r107, null);
        r102.L$0 = null;
        r102.label = 2;
        r104 = BuildersKt.withContext(r111, r112, r102);
        if (r104 != r105) goto L35;
        return r105;
    L30:
        if (c3.b.a(r107.C) == true) goto L32;
    L16:
        ResultKt.throwOnFailure(r104);
        AppletApplication r113 = a(r100);
        if (r113 == null) goto L20;
        return r113;
    L20:
        if (StringsKt.startsWith$default(r100, "db_", false, 2, null) == false) goto L22;
        AIManager r114 = AIManager.f37211a;
        AIManager.f(r100);
    L22:
        AIManager r115 = AIManager.f37211a;
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r115.D(r100, null, r102);
        if (r104 != r105) goto L25;
        return r105;
    L7:
        r102 = new AppletAppManagerService$provideApp$1(this, r101);
        goto L8
    }
}
