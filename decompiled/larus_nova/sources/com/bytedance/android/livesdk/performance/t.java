package com.bytedance.android.livesdk.performance;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f154803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntentFilter f154804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f154805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f154806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f154807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f154808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f154809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f154810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f154811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f154812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f154813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f154814l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f154815a = null;

        static {
            f154815a = new t();
        }
    }

    public synchronized void registerReceiver() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f154805c == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        a(((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).b().context(), this.f154803a, this.f154804b);     // Catch: Exception -> L13 Throwable -> L10
        this.f154805c = true;     // Catch: Exception -> L13 Throwable -> L10
    L8:
        monitor-exit(this);
    }

    public t() {
        this.f154806d = -1.0f;
        this.f154807e = -1;
        this.f154808f = -1;
        this.f154809g = 1;
        this.f154810h = 1;
        this.f154811i = true;
        this.f154812j = -1;
        this.f154813k = -1;
        this.f154814l = false;
        this.f154803a = new s(this);
        this.f154804b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, s r101) {
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, s r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L39:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (r110 == null) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L23;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L34
        if (r102 != 1) goto L13;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L13:
        if (r102 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r102 == 3) goto L41;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
    }
}
