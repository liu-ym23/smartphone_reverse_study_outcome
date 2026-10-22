package com.baidu.mshield.core;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.x0.EngineImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f32387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f32388b;

    /* JADX INFO: renamed from: com.baidu.mshield.core.a$a, reason: collision with other inner class name */
    public static class C0652a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.baidu.mshield.a f32389a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_baidu_mshield_core_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_core_a$a__run$___twin___() {
            this.f32389a.a("4.2.9", this.f32389a.a("4.2.9") - 1);
        }

        public C0652a(com.baidu.mshield.a r100) {
            this.f32389a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_core_a$a_com_larus_apm_impl_protector_RunnableLancet_run(C0652a r100) {
            r100.com_baidu_mshield_core_a$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f32387a = new HashMap();
    }

    public static boolean a() {
        return f32388b;
    }

    public static boolean a(Context r100) {
        com.baidu.mshield.a r101 = new com.baidu.mshield.a(r100);     // Catch: Throwable -> L8
        if (r101.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.a("4.2.9") < r101.b()) goto L14;
        EngineImpl.getInstance(r100).sendWMCrashLog(5);     // Catch: Throwable -> L8
        goto L7
    L14:
        return true;
    L8:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return true;
    }

    public static String b(Context r100) {
        com.baidu.mshield.sharedpreferences.a r101 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L23
        String r102 = r101.e();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == true) goto L5;
        return r102;
    L5:
        String r103 = r101.v();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r103) == true) goto L8;
        return r103;
    L8:
        String r104 = c.b(r100);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r104) == true) goto L33;
        String[] r105 = r104.split("\\|");     // Catch: Throwable -> L23
        if (r105 != null) goto L13;
        return r104;
    L13:
        if (r105.length == 2) goto L15;
        return r104;
    L15:
        if (TextUtils.isEmpty(r105[0]) == false) goto L17;
        return r104;
    L17:
        if (TextUtils.isEmpty(r105[1]) == true) goto L32;
        byte[] r106 = F.getInstance().re(r105[1].getBytes(), r105[0].getBytes());     // Catch: Throwable -> L23
        if (r106 == null) goto L34;
        String r107 = r105[0] + com.baidu.mshield.utility.a.a(r106);     // Catch: Throwable -> L23
        r101.m(r107);     // Catch: Throwable -> L23
        return r107;
    L34:
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    L32:
        return r104;
    L33:
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    L23:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }

    public static void c(Context r100) {
        com.baidu.mshield.b.c.a.b("canRunPlugin=" + a(r100));     // Catch: Throwable -> L8
        if (a(r100) == true) goto L6;
        return;
    L6:
        d(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public static void d(Context r100) {
        com.baidu.mshield.a r101 = new com.baidu.mshield.a(r100);
        r101.a("4.2.9", r101.a("4.2.9") + 1);
        EngineImpl.getInstance(r100).init(0, true);
        new PthreadTimer("shield/core/a").schedule(new C0652a(r101), 30000);
    }

    public static String a(String r100) {
        HashMap<String, String> r101 = f32387a;     // Catch: Throwable -> L15
        if (r101.size() <= 0) goto L21;
        monitor-enter(r101);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (r101.containsKey(r100) == false) goto L10;
        String r102 = r101.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return "";
    L21:
        return "";
    L15:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return "";
    }

    public static void b(boolean r100) {
        com.baidu.sec.privacy.b.b.a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public static void a(boolean r100) {
        f32388b = r100;
    }

    public static void a(Context r100, HashMap<String, String> r101) {
        if (r101 == null) goto L26;
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return;
    L4:
        if (r101.size() == 0) goto L27;
        HashMap<String, String> r102 = f32387a;     // Catch: Throwable -> L18
        monitor-enter(r102);     // Catch: Throwable -> L18
        Iterator<String> r103 = r101.keySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();     // Catch: Throwable -> L15
        f32387a.put(r104, r101.get(r104));     // Catch: Throwable -> L15
        goto L10
    L12:
        g.b(r101);     // Catch: Throwable -> L15
        EngineImpl.getInstance(r100).ud(r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
    L28:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L27:
        return;
    }

    public static String a(Context r100, String r101, int r102, String r103) {
        if (r102 == 0) goto L13;
    L10:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L13
    L4:
        if (a(r100) == true) goto L6;
    L14:
        goto L13
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L8;
        EngineImpl.getInstance(r100).ice(r101, r102);     // Catch: Throwable -> L10
        goto L14
    L8:
        EngineImpl.getInstance(r100).ice(r101, r102, r103);     // Catch: Throwable -> L10
    L13:
        return b(r100);
    }

    public static void a(Context r100, String r101, String r102, HashMap<String, String> r103, int... r104) {
        b(r100);     // Catch: Throwable -> L12
        c.b(r100);     // Catch: Throwable -> L12
        g.a(r103);     // Catch: Throwable -> L12
        EngineImpl.getInstance(r100).setSecurityVerifyInfo(r101, r102, r103);     // Catch: Throwable -> L12
        EngineImpl.getInstance(r100).gpol();     // Catch: Throwable -> L12
        c(r100);     // Catch: Throwable -> L12
        if (r103 == null) goto L19;
        HashMap<String, String> r105 = f32387a;     // Catch: Throwable -> L12
        monitor-enter(r105);     // Catch: Throwable -> L12
        r105.putAll(r103);     // Catch: Throwable -> L9
        monitor-exit(r105);     // Catch: Throwable -> L9
    L20:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L19:
        return;
    L12:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }
}
