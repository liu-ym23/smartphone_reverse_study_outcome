package com.bytedance.android.livehostapi;

import android.app.Application;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.android.livesdkapi.auth.IAuthRoutine;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import jc1.a;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TTLiveSDK extends TTMiddlewareLiveSDK {
    private static final String LIVE_FEED_CONTEXT = "com.bytedance.android.livesdk.feed.context.LiveFeedContext";
    private static final String LIVE_SDK_CONTEXT = "com.bytedance.android.livesdk.TTLiveSDKContext";
    private static volatile boolean isContextInit;
    private static volatile boolean onBootFinish;
    private static volatile boolean sDelayInited;
    private static volatile boolean sGiftResourceInited;
    private static volatile boolean sProtoInited;

    public static void idleInit() {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "idleInit", new Object[0]);
    }

    public static void initP1Components(ClassLoader r100) {
    }

    public static void initP2Components(ClassLoader r100) {
    }

    public static boolean showUserCellularEnable() {
        Object r100 = JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "showUserCellularEnable", new Object[0]);
        if ((r100 instanceof Boolean) == true) goto L5;
        return false;
    L5:
        return ((Boolean) r100).booleanValue();
    }

    public static void switchToCellularNetwork() {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "switchToCellularNetwork", new Object[0]);
    }

    public static void switchToDefaultNetwork() {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "switchToDefaultNetwork", new Object[0]);
    }

    public static synchronized boolean delayInit() {
        monitor-enter(TTLiveSDK.class);
        boolean r100 = delayInit(null);     // Catch: Throwable -> L8
        monitor-exit(TTLiveSDK.class);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    public static IHostService hostService() {
        return (IHostService) TTMiddlewareLiveSDK.sHostService;
    }

    public static synchronized void initGiftResource() {
        monitor-enter(TTLiveSDK.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sGiftResourceInited == true) goto L7;
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "initGiftResource", new Object[0]);     // Catch: Throwable -> L9
        sGiftResourceInited = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(TTLiveSDK.class);
    }

    public static synchronized void initI18nPackage() {
        monitor-enter(TTLiveSDK.class);
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "initI18nPackage", new Object[0]);     // Catch: Throwable -> L7
        monitor-exit(TTLiveSDK.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void onBootFinish() {
        monitor-enter(TTLiveSDK.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (onBootFinish == true) goto L7;
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "onBootFinish", new Object[0]);     // Catch: Throwable -> L9
        onBootFinish = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(TTLiveSDK.class);
    }

    public static void protoInit() {
        if (sProtoInited == false) goto L5;
        return;
    L5:
        monitor-enter(TTLiveSDK.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sProtoInited == false) goto L10;
        monitor-exit(TTLiveSDK.class);     // Catch: Throwable -> L13
        return;
    L10:
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "protoInit", new Object[0]);     // Catch: Throwable -> L13
        JavaCalls.callStaticMethod(LIVE_FEED_CONTEXT, "feedProtoInit", new Object[0]);     // Catch: Throwable -> L13
        sProtoInited = true;     // Catch: Throwable -> L13
        monitor-exit(TTLiveSDK.class);     // Catch: Throwable -> L13
    }

    public TTLiveSDK() {
    }

    public static synchronized boolean delayInit(ClassLoader r100) {
        monitor-enter(TTLiveSDK.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sDelayInited == false) goto L7;
    L11:
        boolean r101 = sDelayInited;     // Catch: Throwable -> L14
        monitor-exit(TTLiveSDK.class);
        return r101;
    L7:
        if (r100 == null) goto L9;
        JavaCalls.callStaticMethodWithClassLoader(LIVE_SDK_CONTEXT, "delayInit", r100, new Object[0]);     // Catch: Throwable -> L14
    L10:
        sDelayInited = true;     // Catch: Throwable -> L14
        goto L11
    L9:
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "delayInit", new Object[0]);     // Catch: Throwable -> L14
        goto L10
    }

    public static <T> T getLiveDefaultImplementation(Class<T> r100) {
        if (r100 == IAuthRoutine.class) goto L5;
        return null;
    L5:
        return (T) k.f(IAuthRoutine.class);
    }

    public static void initContext(IBaseHostService r100) {
        if (isContextInit == false) goto L5;
        return;
    L5:
        monitor-enter(TTLiveSDK.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (isContextInit == false) goto L10;
        monitor-exit(TTLiveSDK.class);     // Catch: Throwable -> L13
        return;
    L10:
        LiveHostServiceHelperForSaas.INSTANCE.registerHostServer(r100);     // Catch: Throwable -> L13
        TTMiddlewareLiveSDK.sHostService = (IHostService) r100;     // Catch: Throwable -> L13
        TTMiddlewareLiveSDK.sAppContext = TTMiddlewareLiveSDK.sHostService.appContext().context();     // Catch: Throwable -> L13
        a.f498071a = (Application) TTMiddlewareLiveSDK.sAppContext.getApplicationContext();     // Catch: Throwable -> L13
        isContextInit = true;     // Catch: Throwable -> L13
        int r101 = c.f154204a;     // Catch: Throwable -> L13
        c.d(TTMiddlewareLiveSDK.sAppContext);     // Catch: Throwable -> L13
        monitor-exit(TTLiveSDK.class);     // Catch: Throwable -> L13
    }

    public static void initSDK(IHostService r100) {
        initSDK(r100, null);
    }

    public static void preInitSDK(IBaseHostService r100) {
        initContext(r100);
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "preInitialize", new Object[]{(IHostService) TTMiddlewareLiveSDK.sHostService});
    }

    public static void setSDKInitListener(SDKInitListener r100) {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "setSDKInitListener", new Object[]{r100});
    }

    public static void triggerByActivity(int r100) {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "triggerByActivity", new Object[]{Integer.valueOf(r100)});
    }

    public static void triggerSummer(int r100) {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "triggerSummer", new Object[]{Integer.valueOf(r100)});
    }

    public static void userAccessStatus(int r100) {
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "userAccessStatus", new Object[]{Integer.valueOf(r100)});
    }

    public static void initSDK(IHostService r100, ClassLoader r101) {
        if (r101 == null) goto L5;
        JavaCalls.callStaticMethodWithClassLoader(LIVE_SDK_CONTEXT, "initialize", r101, new Object[]{r100});
        return;
    L5:
        JavaCalls.callStaticMethod(LIVE_SDK_CONTEXT, "tryInitialize", new Object[]{r100});
    }

    public static boolean initialize(IBaseHostService r100, boolean r101) {
        return initialize(r100, r101, null);
    L5:
        e = move-exception;
        if (r100 != null) goto L8;
    L14:
        throw e;
    L8:
        if (r100.monitor() == null) goto L14;
        if ((r100.monitor() instanceof IHostMonitor) == false) goto L14;
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e);     // Catch: Exception -> L15
    L13:
        ((IHostMonitor) r100.monitor()).monitorEvent("ttlive_sdk_init_error", r102, null, null);
        goto L14
    }

    public static boolean initialize(IBaseHostService r100, boolean r101, ClassLoader r102) {
        initContext(r100);
        if (r101 == false) goto L7;
        initSDK((IHostService) TTMiddlewareLiveSDK.sHostService, r102);
        return true;
    L7:
        return true;
    }
}
