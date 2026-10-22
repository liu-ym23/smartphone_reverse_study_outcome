package com.baidu.mshield;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.mshield.rp.Receiver;
import com.baidu.mshield.utility.g;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.sec.privacy.b.b;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class MH {
    private static boolean isLoad;
    private static Receiver sdkRceiver;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f32356b;

        /* JADX INFO: renamed from: com.baidu.mshield.MH$a$a, reason: collision with other inner class name */
        public class C0650a implements com.baidu.sec.privacy.a {
            @Override // com.baidu.sec.privacy.a
            public boolean a() {
                com.baidu.mshield.b.c.a.b("MethodImpl.isAgreePolicy()=" + com.baidu.mshield.core.a.a());
                return com.baidu.mshield.core.a.a();
            }

            public C0650a(a r100) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mshield_MH$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_MH$a__run$___twin___() {
            com.baidu.mshield.b.c.a.b("===pre isUserAuthPrv===");     // Catch: Throwable -> L23
            boolean r100 = com.baidu.xclient.gdid.a.f(this.f32355a);     // Catch: Throwable -> L6
        L10:
            b.a(this.f32355a, "mshield", new C0650a(this));     // Catch: Throwable -> L23
            com.baidu.mshield.b.a.a.f32360a = "985050001";     // Catch: Throwable -> L23
            if (MH.access$000(this.f32355a) == true) goto L13;
            return;
        L13:
            com.baidu.mshield.utility.b.a(this.f32355a).b();     // Catch: Throwable -> L23
            String[] r101 = com.baidu.mshield.utility.a.i(this.f32355a);     // Catch: Throwable -> L23
            if (r101.length != 2) goto L31;
            MH.access$100(this.f32355a);     // Catch: Throwable -> L23
            String r102 = r101[0];     // Catch: Throwable -> L23
            com.baidu.mshield.b.a.a.f32360a = r102;     // Catch: Throwable -> L23
            String r103 = r101[1];     // Catch: Throwable -> L23
            if (r100 == true) goto L27;
            com.baidu.mshield.b.c.a.b("tiny_magic.so not loaded; skip initDelay native-dependent init");     // Catch: Throwable -> L23
            return;
        L27:
            com.baidu.mshield.core.a.a(this.f32355a, r102, r103, this.f32356b, new int[]{0});     // Catch: Throwable -> L19
        L33:
            return;
        L19:
            th = move-exception;
            com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L23
            return;
        L31:
            return;
        L6:
            th = move-exception;
            com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L23
            r100 = false;
        L23:
            th = move-exception;
            com.baidu.mshield.b.c.a.a(th);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_MH$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mshield_MH$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, HashMap r101) {
            this.f32355a = r100;
            this.f32356b = r101;
        }
    }

    public static String getVersion(Context r100) {
        return "4.2.9";
    }

    private MH() {
    }

    public static /* synthetic */ boolean access$000(Context r100) {
        return initAppkey(r100);
    }

    public static /* synthetic */ void access$100(Context r100) {
        registerSDKReceiver(r100);
    }

    public static String gz(Context r100) {
        return com.baidu.mshield.core.a.b(r100);
    }

    private static boolean initAppkey(Context r100) {
        String[] r101 = com.baidu.mshield.utility.a.c(r100);
        if (r101 != null) goto L5;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L15;
        return true;
    L15:
        if (com.baidu.mshield.key.a.a(r100) == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (r101.length != 2) goto L12;
        if (TextUtils.isEmpty(r101[0]) == true) goto L12;
        if (TextUtils.isEmpty(r101[1]) == true) goto L12;
        r102 = false;
        goto L13
    }

    private static Bundle obtainBundleFromProperties(HashMap<String, String> r100) {
        Bundle r101 = new Bundle();
        if (r100 != null) goto L12;
    L11:
        return r101;
    L12:
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();     // Catch: Throwable -> L9
        r101.putString(r103, r100.get(r103));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L11
    }

    private static void registerSDKReceiver(Context r100) {
        sdkRceiver = new Receiver();     // Catch: Throwable -> L11
        IntentFilter r101 = new IntentFilter();     // Catch: Throwable -> L11
        r101.addAction("com.b.r.p");     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT >= 33) goto L17;
        INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, sdkRceiver, r101);     // Catch: Throwable -> L11
    L14:
        return;
    L17:
        INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, sdkRceiver, r101, 4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public static void unInitPlugin(Context r100) {
        unregisterSDKReceiver(r100);     // Catch: Throwable -> L4
        EngineImpl.getInstance(r100).unload();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    private static void unregisterSDKReceiver(Context r100) {
        Receiver r101 = sdkRceiver;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, r101);     // Catch: Throwable -> L6
        sdkRceiver = null;     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static String init(Context r100, HashMap<String, String> r101) {
    L12:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return "";
    L4:
        if (com.baidu.mshield.utility.a.h(r100) != 1) goto L11;
        if (isLoad == true) goto L9;
        initPlugin(r100, r101);     // Catch: Throwable -> L12
        isLoad = true;     // Catch: Throwable -> L12
    L9:
        return gz(r100);
    L11:
        return g.a(r100, "init", obtainBundleFromProperties(r101)).getString("result", "");
    }

    private static void initPlugin(Context r100, HashMap<String, String> r101) {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(r100, r101), "du/mshield/MH"));
    }

    public static void setAgreePolicy(Context r100, boolean r101) {
    L7:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return;
    L3:
        if (com.baidu.mshield.utility.a.h(r100) != 1) goto L5;
        com.baidu.mshield.core.a.a(r101);     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L7
        r102.putBoolean("_agree_policy", r101);     // Catch: Throwable -> L7
        g.a(r100, "setAgreePolicy", r102);     // Catch: Throwable -> L7
        goto L10
    }

    public static void setAppStatus(Context r100, boolean r101) {
    L9:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return;
    L3:
        if (com.baidu.mshield.utility.a.h(r100) == 1) goto L5;
        Bundle r102 = new Bundle();     // Catch: Throwable -> L9
        r102.putBoolean("_app_status", r101);     // Catch: Throwable -> L9
        g.a(r100, "setAppStatus", r102);     // Catch: Throwable -> L9
    L12:
        return;
    L5:
        if (isLoad == false) goto L12;
        com.baidu.mshield.core.a.b(r101);     // Catch: Throwable -> L9
        goto L12
    }

    public static void ud(Context r100, HashMap<String, String> r101) {
    L9:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return;
    L3:
        if (com.baidu.mshield.utility.a.h(r100) == 1) goto L5;
        g.a(r100, "ud", obtainBundleFromProperties(r101));     // Catch: Throwable -> L9
    L12:
        return;
    L5:
        if (isLoad == false) goto L12;
        com.baidu.mshield.core.a.a(r100, r101);     // Catch: Throwable -> L9
        goto L12
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_MH_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r111, null, null, 3, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, r111);
    L35:
        return r100.registerReceiver(r101, r110, r111);
    }

    public static String gzfi(Context r100, String r101, int r102, HashMap<String, String> r103) {
        return gzfi(r100, r101, r102, null, r103);
    }

    public static String gzfi(Context r100, String r101, int r102, String r103, HashMap<String, String> r104) {
    L14:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return "";
    L4:
        if (com.baidu.mshield.utility.a.h(r100) == 1) goto L6;
        Bundle r105 = new Bundle();     // Catch: Throwable -> L14
        r105.putString("accountId", r101);     // Catch: Throwable -> L14
        r105.putInt("scene", r102);     // Catch: Throwable -> L14
        r105.putString("para", r103);     // Catch: Throwable -> L14
        r105.putBundle(KFAnimation.PROPERTY_TYPE_JSON_FIELD, obtainBundleFromProperties(r104));     // Catch: Throwable -> L14
        return g.a(r100, "gzfi", r105).getString("result", "");
    L6:
        if (isLoad == true) goto L9;
        init(r100, r104);     // Catch: Throwable -> L14
    L9:
        return com.baidu.mshield.core.a.a(r100, r101, r102, r103);
    }
}
