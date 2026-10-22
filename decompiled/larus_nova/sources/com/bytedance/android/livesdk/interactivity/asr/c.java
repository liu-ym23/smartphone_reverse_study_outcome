package com.bytedance.android.livesdk.interactivity.asr;

import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdk.config.fw;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.bytedance.speech.speechengine.SpeechEngineLoader;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f133831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f133832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Unit> f133833c;

    public static final class a implements SpeechEngineLoader.PluginAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostPlugin f133834a;

        public a(IHostPlugin r100) {
            this.f133834a = r100;
        }

        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.bytedance.speech.speechengine.SpeechEngineLoader.PluginAdapter
        public final boolean loadFromHost(String r100) {
            if (r100 != null) goto L10;
            return true;
        L10:
            a(r100);     // Catch: Throwable -> L7
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load " + r100 + " from host success");     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("load " + r100 + " from host failed", th);
            return false;
        }

        @Override // com.bytedance.speech.speechengine.SpeechEngineLoader.PluginAdapter
        public final boolean loadFromPlugin(String r100) {
            if (r100 != null) goto L5;
            return true;
        L5:
            Pair<Boolean, String> r101 = this.f133834a.loadLibraryV2(4, jc1.a.b(), PluginType.AsrSo.getPackageName(), r100, null);
            if (r101 != null) goto L8;
            Boolean r102 = null;
        L14:
            return Intrinsics.areEqual(r102, Boolean.TRUE);
        L8:
            if (((Boolean) r101.first).booleanValue() == false) goto L10;
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load " + r100 + " from plugin success");
        L11:
            r102 = (Boolean) r101.first;
            goto L14
        L10:
            com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("load " + r100 + " from plugin failed. msg=" + ((String) r101.second));
            goto L11
        }
    }

    public static void b() {
        if (f133831a == true) goto L11;
        IHostContext r100 = TTLiveSDK.hostService().appContext();     // Catch: Throwable -> L6
        String r101 = String.valueOf(r100.appId());     // Catch: Throwable -> L6
        String r102 = r100.getServerDeviceId();     // Catch: Throwable -> L6
        String r110 = r100.getVersionName();     // Catch: Throwable -> L6
        String r111 = r100.getVersionCode();     // Catch: Throwable -> L6
        String r112 = r100.getChannel();     // Catch: Throwable -> L6
        SpeechEngineGenerator.initMonitor(r100.context(), r102, r101, r110, r111, "https://mon.zijieapi.com/monitor/appmonitor/v2/settings", "https://mon.zijieapi.com/monitor/collect/", r112);     // Catch: Throwable -> L6
        f133831a = true;     // Catch: Throwable -> L6
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("init SpeechEngineMonitor. versionName=" + r110 + " versionCode=" + r111 + " channel=" + r112);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("init speech engine monitor failed", th);
        SafetyGuard.a("init speech engine monitor failed", th, null);
        return;
    }

    public static void c() {
        SpeechEngineLoader r100 = SpeechEngineLoader.getInstance();
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load plugin. state=" + r100.state);
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 != null) goto L5;
        return;
    L5:
        long r102 = SystemClock.elapsedRealtime();
        boolean r103 = r101.load(PluginType.AsrSo.getPackageName());
        long r104 = SystemClock.elapsedRealtime() - r102;
        if (r103 == true) goto L10;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("load plugin failed. cost " + r104 + " ms");
        w52.a.d(-1, "load plugin failed", r104);
        return;
    L10:
        if (fw.f120235a.getValue().booleanValue() == true) goto L12;
    L18:
        r100.setAdapter(new a(r101));
        SpeechEngineLoader.State r105 = r100.load();
        long r106 = SystemClock.elapsedRealtime() - r102;
        if (r105 != SpeechEngineLoader.State.PLUGIN_LOADED) goto L21;
        boolean r107 = true;
    L22:
        f133832b = r107;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load plugin done. cost=" + r106 + " state=" + r105 + " loaded=" + f133832b);
        if (f133832b == false) goto L27;
        Function0<Unit> r108 = f133833c;
        if (r108 == null) goto L27;
        Unit r109 = r108.invoke();
    L27:
        if (r105 == null) goto L44;
        int r110 = com.bytedance.android.livesdk.interactivity.asr.a.f133828a[r105.ordinal()];
        if (r110 != 1) goto L32;
        w52.a.d(-3, "load so failed", r106);
        return;
    L32:
        if (r110 != 2) goto L34;
        w52.a.d(-2, "plugin not exists", r106);
        return;
    L34:
        if (r110 != 3) goto L45;
        w52.a.d(0, "plugin loaded", r106);
        return;
    L45:
        return;
    L44:
        return;
    L21:
        r107 = false;
        goto L22
    L12:
        if (jc1.a.c() == true) goto L18;
        a(c.class.getClassLoader());     // Catch: Throwable -> L15
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("load SpeechPluginBridge success");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("load SpeechPluginBridge failed", th);
        w52.a.d(-4, "load SpeechPluginBridge failed", SystemClock.elapsedRealtime() - r102);
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static void a(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        r100.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
    L12:
        throw th;
    L34:
        r100.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.loadClass("com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
