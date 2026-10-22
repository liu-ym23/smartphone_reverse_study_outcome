package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f163067a;

    public final void a() {
        long r100 = System.currentTimeMillis();
        d.f(this.f163067a);
        a r101 = this.f163067a.f163073f;
        r101.getClass();
        String r102 = MonitorGlobalSp.d("monitor_setting_response", "");     // Catch: Throwable -> L5
        lz2.b r103 = com.bytedance.android.monitorV2.util.d.e(r102);     // Catch: Throwable -> L5
        MonitorGlobalSp.b("monitor_setting_response_fetch_time");     // Catch: Throwable -> L5
        int r104 = j.f163105a;     // Catch: Throwable -> L5
        r101.f163061c = r102;     // Catch: Throwable -> L5
        r101.f163060b = r103;     // Catch: Throwable -> L5
    L7:
        if (r103 == null) goto L10;
        this.f163067a.f163068a = r103;
        k.f163106a.getClass();
        k.a.a();
    L10:
        if (this.f163067a.f163070c == true) goto L14;
        lz2.b r105 = this.f163067a.f163073f.b();
        if (r105 == null) goto L14;
        this.f163067a.f163068a = r105;
        k.f163106a.getClass();
        k.a.b();
    L14:
        nz2.b.f("HybridSettingRequestService", "_init from local");
        if (this.f163067a.f163068a.f511350e == 0) goto L17;
        this.f163067a.f163073f.getClass();
        int r106 = (int) ((MonitorGlobalSp.b("monitor_setting_response_fetch_time") + ((long) this.f163067a.f163068a.f511349d)) - (System.currentTimeMillis() / 1000));
        nz2.b.f("HybridSettingRequestService", "_init local is not null, and durationUntilUpdate is" + r106 + " secs");
    L19:
        if (r106 > 0) goto L25;
        nz2.b.f("HybridSettingRequestService_init", "monitor setting init right now");
        d r107 = this.f163067a;
        r107.getClass();
        r107.f163071d.submit(new e(r107, true));     // Catch: Throwable -> L23
    L26:
        HashMap r108 = new HashMap();
        r108.put("setting_init_type", "HybridSettingRequestService");
        HashMap r109 = new HashMap();
        r109.put("setting_init_time", Long.valueOf(System.currentTimeMillis() - r100));
        Map<String, Map<String, String>> r110 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "setting_init_perf", r108, r109);
        int r111 = j.f163105a;
        nz2.b.a("HybridSettingRequestService", "HybridSettingManagerImpl init JsonOptConfig.isJsonOptEnable(): false");
        nz2.b.a("HybridSettingRequestService", "HybridSettingManagerImpl init cost: " + (System.currentTimeMillis() - r100));
        return;
    L23:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L26
    L25:
        nz2.b.f("HybridSettingRequestService_init", "monitor setting init after " + r106 + " secs");
        HashMap r112 = new HashMap();
        r112.put(Constant.KEY_SETTING_ID, String.valueOf(this.f163067a.f163068a.f511350e));
        Map<String, Map<String, String>> r113 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "startup_init", r112, null);
        this.f163067a.g(r106);
        goto L26
    L17:
        r106 = 0;
    L5:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        r103 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100) {
        this.f163067a = r100;
    }
}
