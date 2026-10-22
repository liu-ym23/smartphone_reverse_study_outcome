package com.bytedance.android.livesdk.ceremony.viewmodel;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements IResultMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f105009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f105010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f105011c;

    public b(a r100, long r101, String r102) {
        this.f105009a = r100;
        this.f105010b = r101;
        this.f105011c = r102;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor
    public final void monitor(boolean r100, String r101, int r102, int r103, String r104) {
        if (r100 == true) goto L5;
        JSONObject r105 = new JSONObject();
        a r106 = this.f105009a;
        Long r107 = Long.valueOf(this.f105010b);
        r106.getClass();
        a.b(r105, "asset_id", r107);
        a r108 = this.f105009a;
        String r109 = this.f105011c;
        r108.getClass();
        a.b(r105, "source", r109);
        a r110 = this.f105009a;
        Integer r111 = Integer.valueOf(r102);
        r110.getClass();
        a.b(r105, "error_code", r111);
        this.f105009a.getClass();
        a.b(r105, "error_msg", r104);
        this.f105009a.getClass();
        a.b(r105, ILoadStallMonitor.EXTRA_PLAYER_TYPE, r101);
        LiveTracingMonitor.d("ttlive_activity_effect_show_error", LiveTracingMonitor.EventModule.LIVE_GIFT, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r105);
        return;
    }
}
