package com.bytedance.android.ec.adapter.api.messagev2.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes43.dex */
@ProtoMessage("webcast.im.TraceTimeMetricV2")
public class TraceTimeMetricV2 {

    @SerializedName("consumer_duration")
    long consumerDuration;

    @SerializedName("msg_send_timestamp")
    long msgSendTimestamp;

    @SerializedName("op_timestamp")
    long opTimestamp;

    @SerializedName("producer_duration")
    long producerDuration;

    public TraceTimeMetricV2() {
    }

    public long getConsumerDuration() {
        return this.consumerDuration;
    }

    public long getMsgSendTimestamp() {
        return this.msgSendTimestamp;
    }

    public long getOpTimestamp() {
        return this.opTimestamp;
    }

    public long getProducerDuration() {
        return this.producerDuration;
    }

    public TraceTimeMetricV2(long r100, long r101, long r102, long r103) {
        this.opTimestamp = r100;
        this.producerDuration = r101;
        this.consumerDuration = r102;
        this.msgSendTimestamp = r103;
    }
}
