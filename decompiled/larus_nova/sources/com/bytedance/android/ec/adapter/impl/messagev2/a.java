package com.bytedance.android.ec.adapter.impl.messagev2;

import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes43.dex */
@ProtoMessage("webcast.im.LiveEcomGeneralMessage")
public class a extends ExternalBaseMessage implements fe.a, ee.a {

    @SerializedName("data")
    byte[] content;

    @SerializedName("content_format")
    String contentFormat;

    @SerializedName("content_type")
    String contentType;

    @SerializedName("logic_clock")
    long logicClock;

    @SerializedName("trace_time_metric")
    TraceTimeMetricV2 traceTimeMetric;

    @Override // fe.a
    public final void f() {
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 1003;
    }

    @Override // fe.a
    public final String m() {
        return getMessageId() + "";
    }

    public a() {
    }

    @Override // fe.a
    public final TraceTimeMetricV2 d() {
        return this.traceTimeMetric;
    }

    @Override // fe.a
    public final byte[] getContent() {
        return this.content;
    }

    @Override // fe.a
    public final String getContentType() {
        return this.contentType;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_SHOPPING;
    }

    @Override // fe.a
    public final String u() {
        return this.contentFormat;
    }

    @Override // fe.a
    public final long x() {
        return this.logicClock;
    }
}
