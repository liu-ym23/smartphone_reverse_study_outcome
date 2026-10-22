package com.bytedance.android.livesdk.message.interceptor;

import com.bytedance.android.live.base.model.message.c3;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f153536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f153537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f153538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f153539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f153540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f153541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f153542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f153543h;

    public i() {
        this("live_message");
    }

    @Override // com.bytedance.android.livesdk.message.interceptor.h, com.ss.ugc.live.sdk.msg.b
    public final void onRelease() {
        int r100 = this.f153542g;
        if (r100 <= 0) goto L10;
        int r101 = this.f153541f;
        if (r101 <= 0) goto L7;
        long r102 = (long) ((this.f153536a / r101) * 1000.0f);
    L8:
        float r103 = r100;
        long r104 = (long) ((this.f153537b / r103) * 1000.0f);
        long r105 = (long) ((this.f153538c / r103) * 1000.0f);
        long r106 = (long) ((this.f153539d / r103) * 1000.0f);
        long r107 = (long) ((this.f153540e / r103) * 1000.0f);
        bc2.c.b("httpCost: " + r102 + ", decodeCost: " + r104 + ", decodeDispatchInterval: " + r105 + ", dispatchCost: " + r106 + ", totalClientCost: " + r107);
        JSONObject r108 = new JSONObject();
        r108.put("scene", this.f153543h);
        JSONObject r110 = new JSONObject();
        r110.put("http_cost", r102);
        r110.put("decode_cost", r104);
        r110.put("decode_dispatch_interval", r105);
        r110.put("dispatch_cost", r106);
        r110.put("total_client_cost", r107);
        LiveTracingMonitor.f("ttlive_message_dispatch_cost_status", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r108, r110, new JSONObject());
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f153543h = r100;
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r110) {
        if ((r110 instanceof BaseMessage) == false) goto L16;
        BaseMessage r100 = (BaseMessage) r110;
        if (r100.isTimeCostCanUse() == true) goto L8;
        return false;
    L8:
        if (r100.getMessageFrom() != 0) goto L10;
        long r101 = r100.getReceiveTime() - r100.getHttpSendTime();
    L11:
        long r102 = r100.getDecodeEndTime() - r100.getDecodeStartTime();
        long r111 = r100.getEnqueueDispatchTime() - r100.getDecodeEndTime();
        long r112 = r100.getConsumeTime() - r100.getEnqueueDispatchTime();
        long r113 = r100.getConsumeTime() - r100.getReceiveTime();
        if (r101 <= 0) goto L14;
        this.f153536a += r101 / 1000.0f;
        this.f153541f++;
    L14:
        this.f153537b += r102 / 1000.0f;
        this.f153538c += r111 / 1000.0f;
        this.f153539d += r112 / 1000.0f;
        this.f153540e += r113 / 1000.0f;
        this.f153542g++;
        return false;
    L10:
        r101 = 0;
        goto L11
    L16:
        if ((r110 instanceof c3) == false) goto L31;
        c3 r103 = (c3) r110;
        if (r103.isTimeCostCanUse() == true) goto L21;
        return false;
    L21:
        if (r103.getMessageFrom() != 0) goto L23;
        long r104 = r103.getReceiveTime() - r103.getHttpSendTime();
    L24:
        long r105 = r103.getDecodeEndTime() - r103.getDecodeStartTime();
        long r114 = r103.getEnqueueDispatchTime() - r103.getDecodeEndTime();
        long r115 = r103.getConsumeTime() - r103.getEnqueueDispatchTime();
        long r116 = r103.getConsumeTime() - r103.getReceiveTime();
        if (r104 <= 0) goto L27;
        this.f153536a += r104 / 1000.0f;
        this.f153541f++;
    L27:
        this.f153537b += r105 / 1000.0f;
        this.f153538c += r114 / 1000.0f;
        this.f153539d += r115 / 1000.0f;
        this.f153540e += r116 / 1000.0f;
        this.f153542g++;
        return false;
    L23:
        r104 = 0;
        goto L24
    L31:
        return false;
    }
}
