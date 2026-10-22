package com.bytedance.android.livesdk.gamecp;

import android.view.Window;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class t implements bw.k {
    public t() {
    }

    @Override // bw.k
    public final void B1() {
    }

    @Override // bw.k
    public final void K1() {
    }

    @Override // bw.k
    public final void S() {
    }

    @Override // bw.k
    public final void T1(String r100) {
    }

    @Override // bw.k
    public final void clear() {
    }

    @Override // bw.k
    public final void h2() {
    }

    @Override // bw.k
    public final void l1(String r100) {
    }

    @Override // bw.k
    public final void n2(Window r100) {
    }

    @Override // bw.k
    public final void C0(String r100, JSONObject r101) {
        IHostMonitor r102 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r102 == null) goto L6;
        r102.monitorStatusRate(r100, 1, r101);
        return;
    }

    @Override // bw.k
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        IHostMonitor r104 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r104 == null) goto L6;
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    }
}
