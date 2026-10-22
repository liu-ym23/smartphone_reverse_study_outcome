package com.bytedance.android.livesdk.performance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdk.config.cg0;
import com.bytedance.android.livesdk.performance.battery.LivePerformancePowerHelper;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;

/* JADX INFO: loaded from: classes11.dex */
public final class s extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f154759a;

    public s(t r100) {
        this.f154759a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.f154759a.getClass();
        boolean r102 = false;
        this.f154759a.f154806d = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
        this.f154759a.f154807e = r101.getIntExtra("level", -1);
        this.f154759a.f154808f = r101.getIntExtra("scale", -1);
        this.f154759a.f154809g = r101.getIntExtra("status", 1);
        this.f154759a.f154810h = r101.getIntExtra("health", 1);
        this.f154759a.f154811i = r101.getBooleanExtra("present", true);
        this.f154759a.f154812j = r101.getIntExtra("plugged", -1);
        this.f154759a.f154813k = r101.getIntExtra("voltage", -1);
        t r103 = this.f154759a;
        if (r101.getStringExtra("technology") == null) goto L7;
        r101.getStringExtra("technology");
    L7:
        r103.getClass();
        t r104 = this.f154759a;
        int r105 = r104.f154809g;
        if (r105 == 2) goto L11;
        if (r105 == 4) goto L11;
        if (r105 == 5) goto L11;
    L13:
        if (cg0.f119946a.getValue().booleanValue() == false) goto L30;
        String r106 = z.f154833a;
        t r107 = this.f154759a;
        int r108 = r107.f154807e;
        boolean r109 = r107.f154814l;
        z.f154837e = r108;
        z.f154836d = r109;
        if (z.f154838f == false) goto L19;
        if (r109 == false) goto L22;
        z.a("charge");
        z.f154838f = false;
    L22:
        float r110 = this.f154759a.f154806d;
        if (z.f154840h == true) goto L28;
        if (r110 <= 39) goto L30;
        z.f154840h = true;
        z.f154841i = System.currentTimeMillis();
        goto L30
    L28:
        if (r110 >= 39) goto L30;
        z.b("alleviate");
        goto L30
    L19:
        if (r108 >= 20) goto L22;
        if (r109 == true) goto L22;
        z.f154838f = true;
        z.f154839g = System.currentTimeMillis();
    L30:
        boolean r111 = LivePerformancePowerHelper.f154465f;
        int r112 = this.f154759a.f154809g;
        if (LivePerformancePowerHelper.f154465f == true) goto L38;
        if (r112 == 2) goto L35;
        if (r112 == 4) goto L35;
        if (r112 == 5) goto L35;
    L36:
        LivePerformancePowerHelper.f154465f = r102;
        return;
    L35:
        r102 = true;
        goto L36
    L38:
        return;
    L11:
        r104.f154814l = true;
        goto L13
    }
}
