package com.bytedance.android.gamecp.business.props;

import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class r implements bw.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f56395a;

    public r(j r100) {
        this.f56395a = r100;
    }

    @Override // bw.t
    public final void onVerifyResult(int r100) {
        int r101 = 1;
        if (r100 != 2) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        this.f56395a.e();
    L8:
        LiveTracingMonitor.EventModule r103 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r104 = this.f56395a.g();
        if (r102 == true) goto L12;
        r101 = 2;
    L12:
        r104.put("result", r101);
        Unit r105 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(1343, r104);
        return;
    L5:
        r102 = false;
        goto L6
    }
}
