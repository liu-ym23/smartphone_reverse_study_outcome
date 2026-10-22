package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements u0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f52830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f52831b;

    @Override // com.bytedance.android.gamecp.business.download.u0.a
    public final void onContinue() {
        this.f52830a.f52878v0 = false;
        this.f52831b.invoke(Boolean.TRUE, null);
        a(1);
    }

    @Override // com.bytedance.android.gamecp.business.download.u0.a
    public final void onWaitWifi() {
        this.f52830a.f52878v0 = true;
        this.f52831b.invoke(Boolean.TRUE, null);
        a(0);
    }

    public final void a(int r100) {
        LiveTracingMonitor.EventModule r101 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r102 = new JSONObject();
        r102.put(EventConstants.ExtraJson.GAME_NAME, this.f52830a.f52836a0);
        r102.put("game_id", this.f52830a.f52855k);
        r102.put("url", this.f52830a.f52840c0);
        r102.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, this.f52830a.f52866p0);
        r102.put("continue_download", r100);
        Unit r103 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(1021, r102);
    }

    public o(p r100, Function2 r101) {
        this.f52830a = r100;
        this.f52831b = r101;
    }
}
