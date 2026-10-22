package com.bytedance.android.livesdk.utils;

import android.os.SystemClock;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.videosend.tools.VideoTools;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class l4 extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f159051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f159052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f159054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f159055e;

    public final long l() {
        if (this.f159051a <= 0) goto L5;
        long r100 = SystemClock.uptimeMillis() - this.f159051a;
    L6:
        this.f159051a = 0;
        this.f159052b = false;
        return r100;
    L5:
        r100 = 0;
        goto L6
    }

    public l4() {
        this.f159052b = false;
    }

    public final void m(int r100, String r101, String r102) {
        l();
        int r103 = this.f159054d;
        String r104 = this.f159053c;
        boolean r105 = this.f159055e;
        int r106 = a4.f158819a;
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        JSONObject r107 = new JSONObject();
        r107.put("status_msg", r101);
        JSONObject r108 = new JSONObject();
        if (r104 == null) goto L5;
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, r104);
    L5:
        r108.put(VideoTools.ERROR_TYPE_COMPRESS, r102);
        r108.put("channel_id", r103);
        r108.put("use_private_protocol", r105);
        LiveMonitor.a r109 = new LiveMonitor.a("ttlive_msg_ws_connect_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE);
        r109.l(r100);
        r109.f64902e = r107;
        r109.b(r108);
        r109.f64903f = false;
        r109.a().report();
    }
}
