package bsb;

import android.os.Build;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.monitor.downgrade.DowngradeSetting;
import com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements TemperaturePerfMonitor.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DevicePerfManager f20385a;

    public k(DevicePerfManager r100) {
        this.f20385a = r100;
    }

    @Override // com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor.d
    public final void a(float r100) {
        DevicePerfManager r101 = this.f20385a;
        r101.f432372e.f20372j = r100;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return;
    L5:
        DowngradeSetting.c.a r102 = r101.f432374g;
        boolean r103 = false;
        if (r100 <= r102.HIGH_TEMPERATURE) goto L9;
        int r104 = 3;
    L16:
        if (r100 <= r102.LIGHT_TEMPERATURE) goto L18;
        r103 = true;
    L18:
        r101.c(r103, r104);
        return;
    L9:
        if (r100 <= r102.MIDDLE_TEMPERATURE) goto L12;
        r104 = 2;
        goto L16
    L12:
        if (r100 <= r102.LIGHT_TEMPERATURE) goto L14;
        r104 = 1;
        goto L16
    L14:
        r104 = 0;
        goto L16
    }

    @Override // com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor.d
    public final void onThermalStatusChanged(int r100) {
        boolean r101 = false;
        int r102 = Math.max(0, r100);
        if (r102 < 1) goto L5;
        r101 = true;
    L5:
        this.f20385a.c(r101, Math.min(r102, 3));
    }
}
