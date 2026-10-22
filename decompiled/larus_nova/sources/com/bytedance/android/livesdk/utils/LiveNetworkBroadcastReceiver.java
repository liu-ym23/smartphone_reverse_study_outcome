package com.bytedance.android.livesdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class LiveNetworkBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenCert f158755d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f158756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetworkUtils.NetworkType f158757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<WeakReference<a>, Cert> f158758c;

    public interface a {
        void a(NetworkUtils.NetworkType r100);
    }

    static {
        f158755d = TokenCert.with("bpea-livenetworkbroadcastceceiver_get_network_type");
    }

    public final void d() {
        WeakReference<Context> r100 = this.f158756a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L23;
        Context r101 = this.f158756a.get();     // Catch: Exception -> L16
        ReceiverRegisterLancet.loge(this, false);     // Catch: Exception -> L16
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L20;
        r101.unregisterReceiver(this);     // Catch: Exception -> L16
    L17:
        return;
    L20:
    L12:
        e = move-exception;
        Npth.addTag("unregisterReceiver", toString());     // Catch: Exception -> L16
        e.printStackTrace();     // Catch: Exception -> L16
        goto L17
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(this, r101) == false) goto L17;
        r101.unregisterReceiver(this);     // Catch: Exception -> L12
    L24:
        return;
    }

    public LiveNetworkBroadcastReceiver() {
        this.f158757b = NetworkUtils.NetworkType.NONE;
        this.f158758c = new HashMap();
    }

    public final void c(a r100) {
        Iterator r101 = ((HashMap) this.f158758c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r100.equals(((WeakReference) r102.getKey()).get()) == false) goto L4;
        Map<WeakReference<a>, Cert> r103 = this.f158758c;
        HashMap r104 = (HashMap) r103;
        r104.remove(r102.getKey());
        return;
    }

    public final void a(a r100, TokenCert r101) {
        Map<WeakReference<a>, Cert> r102 = this.f158758c;
        HashMap r103 = (HashMap) r102;
        r103.put(new WeakReference(r100), r101);
    }

    public final void b(Context r100, TokenCert r110) {
        this.f158756a = new WeakReference(r100);
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L35:
    L28:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r101);
    L32:
        this.f158757b = NetworkUtils.b(r100, r110);
        return;
    L34:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L19;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r101, 0, null, null, 2, r100).result;     // Catch: Exception -> L28
        if (r102 != 1) goto L12;
        r100.registerReceiver(this, r101);     // Catch: Exception -> L28
        goto L32
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L28
        goto L32
    L14:
        if (r102 == 3) goto L32;
        r100.registerReceiver(this, r101);     // Catch: Exception -> L28
    L19:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L22;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L28
        r100.registerReceiver(this, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L28
        goto L32
    L22:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L24;
    L26:
        r100.registerReceiver(this, r101);     // Catch: Exception -> L28
        goto L32
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L26;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L28
        ContextCompat.registerReceiver(r100, this, r101, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L28
        goto L32
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getAction() != null) goto L6;
        return;
    L6:
        if (r101.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L24;
        NetworkUtils.NetworkType r102 = this.f158757b;
        Iterator r103 = ((HashMap) this.f158758c).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L25;
        Map.Entry r104 = (Map.Entry) r103.next();
        a r105 = (a) ((WeakReference) r104.getKey()).get();
        if (r105 == null) goto L9;
        NetworkUtils.NetworkType r106 = NetworkUtils.b(r100, (Cert) r104.getValue());
        this.f158757b = r106;
        if (r102 == r106) goto L9;
        r105.a(r106);
        goto L9
    L25:
        return;
    }
}
