package com.bytedance.android.btm.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.btm.api.inner.ALogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmHostDependManager {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final cd.c C = null;
    public static final cd.c D = null;
    public static final cd.c E = null;
    public static final BtmHostDependManager F = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f41933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd.c f41934b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final cd.c f41935c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final cd.c f41936d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final cd.c f41937e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final cd.c f41938f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final cd.c f41939g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final cd.c f41940h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final cd.c f41941i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final cd.c f41942j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final cd.c f41943k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final cd.c f41944l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final cd.c f41945m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final cd.c f41946n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final cd.c f41947o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final cd.c f41948p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final cd.c f41949q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final cd.c f41950r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final cd.c f41951s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final cd.c f41952t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final cd.c f41953u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final cd.c f41954v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final cd.c f41955w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final cd.c f41956x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final CopyOnWriteArraySet<d> f41957y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final CopyOnWriteArraySet<e> f41958z = null;

    public BtmHostDependManager() {
    }

    public final zc.a a() {
        return (zc.a) f41944l.getValue(this, f41933a[10]);
    }

    public final Application b() {
        return (Application) f41934b.getValue(this, f41933a[0]);
    }

    public final boolean c() {
        return ((Boolean) f41935c.getValue(this, f41933a[1])).booleanValue();
    }

    public final String d() {
        return (String) f41949q.getValue(this, f41933a[15]);
    }

    public final zc.e e() {
        return (zc.e) f41946n.getValue(this, f41933a[12]);
    }

    public final zc.g f() {
        return (zc.g) f41945m.getValue(this, f41933a[11]);
    }

    static {
        f41933a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "app", "getApp()Landroid/app/Application;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "debug", "getDebug()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "shouldDowngrade", "getShouldDowngrade()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "appLogDepend", "getAppLogDepend()Lcom/bytedance/android/btm/api/depend/IAppLogDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "settingDepend", "getSettingDepend()Lcom/bytedance/android/btm/api/depend/ISettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "defaultSettingDepend", "getDefaultSettingDepend()Lcom/bytedance/android/btm/api/depend/IDefaultSettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "schemaSettingDepend", "getSchemaSettingDepend()Lcom/bytedance/android/btm/api/depend/ISettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "localTestSettingDepend", "getLocalTestSettingDepend()Lcom/bytedance/android/btm/api/depend/ISettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "logDepend", "getLogDepend()Lcom/bytedance/android/btm/api/depend/ILogDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "clientDataTrackerConfig", "getClientDataTrackerConfig()Lcom/bytedance/android/btm/api/depend/ISettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "aLogDepend", "getALogDepend()Lcom/bytedance/android/btm/api/depend/IALogDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "monitorDepend", "getMonitorDepend()Lcom/bytedance/android/btm/api/depend/IMonitorDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "executorDepend", "getExecutorDepend()Lcom/bytedance/android/btm/api/depend/IExecutorDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "appLaunchDepend", "getAppLaunchDepend()Lcom/bytedance/android/btm/api/depend/IAppLaunchDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "appIds", "getAppIds()[Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "defaultA", "getDefaultA()Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "hasLancet", "getHasLancet()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "enableDebugCrash", "getEnableDebugCrash()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "enableBtmPageAnnotation", "getEnableBtmPageAnnotation()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "deviceId", "getDeviceId()Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "versionName", "getVersionName()Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "appId", "getAppId()I")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "updateVersionCode", "getUpdateVersionCode()Ljava/lang/String;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "uploadALog", "getUploadALog()Lkotlin/jvm/functions/Function3;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "shareNodeCD", "getShareNodeCD()Ljava/util/Map;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmHostDependManager.class), "coldStartBPage", "getColdStartBPage()Ljava/lang/String;"))};
        F = new BtmHostDependManager();
        f41934b = new cd.c(BtmHostDependManager$app$2.INSTANCE);
        f41935c = new cd.c(BtmHostDependManager$debug$2.INSTANCE);
        f41936d = new cd.c(BtmHostDependManager$shouldDowngrade$2.INSTANCE);
        f41937e = new cd.c(BtmHostDependManager$appLogDepend$2.INSTANCE);
        f41938f = new cd.c(BtmHostDependManager$settingDepend$2.INSTANCE);
        f41939g = new cd.c(BtmHostDependManager$defaultSettingDepend$2.INSTANCE);
        f41940h = new cd.c(BtmHostDependManager$schemaSettingDepend$2.INSTANCE);
        f41941i = new cd.c(BtmHostDependManager$localTestSettingDepend$2.INSTANCE);
        f41942j = new cd.c(BtmHostDependManager$logDepend$2.INSTANCE);
        f41943k = new cd.c(BtmHostDependManager$clientDataTrackerConfig$2.INSTANCE);
        f41944l = new cd.c(BtmHostDependManager$aLogDepend$2.INSTANCE);
        f41945m = new cd.c(BtmHostDependManager$monitorDepend$2.INSTANCE);
        f41946n = new cd.c(BtmHostDependManager$executorDepend$2.INSTANCE);
        f41947o = new cd.c(BtmHostDependManager$appLaunchDepend$2.INSTANCE);
        f41948p = new cd.c(BtmHostDependManager$appIds$2.INSTANCE);
        f41949q = new cd.c(BtmHostDependManager$defaultA$2.INSTANCE);
        f41950r = new cd.c(BtmHostDependManager$hasLancet$2.INSTANCE);
        f41951s = new cd.c(BtmHostDependManager$enableDebugCrash$2.INSTANCE);
        f41952t = new cd.c(BtmHostDependManager$enableBtmPageAnnotation$2.INSTANCE);
        f41953u = new cd.c(BtmHostDependManager$deviceId$2.INSTANCE);
        f41954v = new cd.c(BtmHostDependManager$versionName$2.INSTANCE);
        f41955w = new cd.c(BtmHostDependManager$appId$2.INSTANCE);
        f41956x = new cd.c(BtmHostDependManager$updateVersionCode$2.INSTANCE);
        f41957y = new CopyOnWriteArraySet();
        f41958z = new CopyOnWriteArraySet();
        A = LazyKt.lazy(BtmHostDependManager$hybridContainerSet$2.INSTANCE);
        B = LazyKt.lazy(BtmHostDependManager$unknownWhiteSet$2.INSTANCE);
        C = new cd.c(BtmHostDependManager$uploadALog$2.INSTANCE);
        D = new cd.c(BtmHostDependManager$shareNodeCD$2.INSTANCE);
        E = new cd.c(BtmHostDependManager$coldStartBPage$2.INSTANCE);
    }

    public final Context getContext() {
        Application r100 = b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getApplicationContext();
    }

    public static void g(f r100) {
        r100.getClass();
        j(new e(new WeakReference(r100.f41979a), r100.f41980b, r100.f41981c, r100.f41982d, r100.f41983e, r100.f41984f));
    }

    public static void h(i r100) {
        ((CopyOnWriteArraySet) A.getValue()).add(r100);
        BtmSDK.INSTANCE.getService().onRegisterHybridContainer(r100);
    }

    public static void j(final e r100) {
        BtmSDK r101 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.inner.e r102 = r101.getService();
        String r103 = r100.f41974b;
        String r104 = r100.f41978f;
        Object r105 = r100.f41973a.get();
        if (r105 == null) goto L7;
        String r106 = r105.getClass().getCanonicalName();
        if (r106 == null) goto L7;
    L9:
        if (r102.checkPageBtmFormat(r103, r104, false, r106, null) == false) goto L11;
        return;
    L11:
        f41958z.add(r100);
        ALogger.c(ALogger.f41996d, "NA_registerPageInstance", new BtmHostDependManager$registerPageInstance$2(r100));
        r101.getService().onRegisterPage(r100);
        return;
    L7:
        r106 = "null";
        goto L9
    }

    public static void m(final Object r100) {
        final String r101 = r100.getClass().getName();
        Iterator<e> r102 = f41958z.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        e r103 = r102.next();
        if (Intrinsics.areEqual(r103.f41973a.get(), r100) == false) goto L4;
        f41958z.remove(r103);
        BtmSDK.INSTANCE.getService().onUnregisterPage(r103);
        ALogger.c(ALogger.f41996d, "NA_unregisterPageInstance", new BtmHostDependManager$unregisterPageInstance$$inlined$forEach$lambda$1(r100, r101));
        return;
    L9:
        ALogger.c(ALogger.f41996d, "NA_unregisterPageInstance", new BtmHostDependManager$unregisterPageInstance$2(r101));
    }

    public static void k(Object r100, String r101, String r102) {
        j(new e(new WeakReference(r100), r101, false, r102, 28));
    }

    public static void l(final Object r100, final String r101, final boolean r110) {
        BtmSDK r102 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.inner.e r103 = r102.getService();
        String r104 = r100.getClass().getCanonicalName();
        if (r104 != null) goto L7;
        r104 = "null";
    L7:
        if (r103.checkPageBtmFormat(r101, null, false, r104, null) == false) goto L9;
        return;
    L9:
        e r105 = new e(new WeakReference(r100), r101, r110, null, 56);
        ALogger.c(ALogger.f41996d, "NA_registerPageInstance", new BtmHostDependManager$registerPageInstance$1(r100, r101, r110));
        f41958z.add(r105);
        r102.getService().onRegisterPage(r105);
    }

    public static void i(Class r100, String r101, boolean r110, boolean r111) {
        BtmSDK r102 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.inner.e r103 = r102.getService();
        String r104 = r100.getCanonicalName();
        if (r104 != null) goto L7;
        r104 = "null";
    L7:
        if (r103.checkPageBtmFormat(r101, null, false, r104, null) == false) goto L9;
        return;
    L9:
        d r105 = new d(r100, "", r101, r110, r111);
        f41957y.add(r105);
        r102.getService().onRegisterPage(r105);
    }
}
