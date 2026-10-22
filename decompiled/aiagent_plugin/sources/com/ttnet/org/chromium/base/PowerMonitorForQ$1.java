package com.ttnet.org.chromium.base;

import android.os.PowerManager;

/* JADX INFO: loaded from: classes4.dex */
class PowerMonitorForQ$1 implements PowerManager.OnThermalStatusChangedListener {
    PowerMonitorForQ$1() {
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public void onThermalStatusChanged(int r1) {
        p.f().a(r1);
    }
}
