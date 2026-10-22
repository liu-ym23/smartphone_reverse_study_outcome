package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f163076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f163077b;

    public final void a() {
        long r100 = System.currentTimeMillis();
        d.f(this.f163077b);
        lz2.b r101 = this.f163077b.f163073f.a();
        if (r101 == null) goto L5;
        this.f163077b.f163068a = r101;
        k.f163106a.getClass();
        k.a.a();
        nz2.b.a("HybridSettingRequestService", this.f163077b.f163068a.f511347b.toString());
        nz2.b.f("HybridSettingRequestService_update", "monitor setting update succeeded");
        d r102 = this.f163077b;
        r102.g(r102.f163068a.f511349d);
    L7:
        if (this.f163077b.f163070c == true) goto L13;
        lz2.b r103 = this.f163077b.f163073f.b();
        if (r103 == null) goto L11;
        this.f163077b.f163068a = r103;
    L11:
        k.f163106a.getClass();
        k.a.b();
    L13:
        if (this.f163076a == false) goto L15;
        HashMap r104 = new HashMap();
        r104.put(Constant.KEY_SETTING_ID, String.valueOf(this.f163077b.f163068a.f511350e));
        Map<String, Map<String, String>> r105 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "startup_init", r104, null);
    L15:
        int r106 = j.f163105a;
        nz2.b.a("HybridSettingRequestService", "_loopUpdate JsonOptConfig.isJsonOptEnable(): false");
        nz2.b.a("HybridSettingRequestService", "_loopUpdate cost: " + (System.currentTimeMillis() - r100));
        return;
    L5:
        nz2.b.b("HybridSettingRequestService_update", "monitor setting update failed");
        this.f163077b.g(600);
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

    public e(d r100, boolean r101) {
        this.f163077b = r100;
        this.f163076a = r101;
    }
}
