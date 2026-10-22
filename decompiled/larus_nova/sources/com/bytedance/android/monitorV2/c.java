package com.bytedance.android.monitorV2;

import android.content.SharedPreferences;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridSettingInitConfig f162989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f162990b;

    public final void a() {
        HybridSettingInitConfig r100 = ValidationReport.f162983a;
        ValidationReport.f162983a = this.f162989a;
        if (this.f162990b.f163040a == null) goto L8;
        SharedPreferences r101 = this.f162990b.f163040a.getSharedPreferences("monitor_sdk", 4);
        if (r101 == null) goto L9;
        g r102 = this.f162990b;
        r102.f163044e = new g.a(r102);
        r101.registerOnSharedPreferenceChangeListener(this.f162990b.f163044e);
        hz2.a.f487670b = r101.getBoolean("monitor_hdt_ignore_sample", false);
        return;
    L9:
        return;
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

    public c(g r100, HybridSettingInitConfig r101) {
        this.f162990b = r100;
        this.f162989a = r101;
    }
}
