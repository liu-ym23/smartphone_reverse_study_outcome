package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livehostapi.platform.depend.BlockMonitorCallback;
import com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class y0 implements FpsMonitorCallback, BlockMonitorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IStallCallback f154832a;

    public y0(IStallCallback r100) {
        this.f154832a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback
    public final void onDataReady(double r100, JSONObject r101) {
        IStallCallback r102 = this.f154832a;
        if (r102 == null) goto L6;
        r102.onFpsReady(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.BlockMonitorCallback
    public final void onDataReady(long r100, int r101, long r110) {
        IStallCallback r102 = this.f154832a;
        if (r102 == null) goto L6;
        r102.onBlockReady(r100, r101, r110);
        return;
    }
}
