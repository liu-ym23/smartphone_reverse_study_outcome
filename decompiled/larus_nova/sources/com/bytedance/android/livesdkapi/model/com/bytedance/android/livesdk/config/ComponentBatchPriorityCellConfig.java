package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityCellConfig;", "", "()V", OPTrace.BATCH_DATA_KEY, "", "getBatch", "()I", "setBatch", "(I)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "end", "", "getEnd", "()D", "setEnd", "(D)V", "start", "getStart", "setStart", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentBatchPriorityCellConfig {

    @SerializedName(OPTrace.BATCH_DATA_KEY)
    private int batch;

    @SerializedName("dalay")
    private long delay;

    @SerializedName("end")
    private double end;

    @SerializedName("start")
    private double start;

    public ComponentBatchPriorityCellConfig() {
        this.start = -1.0d;
        this.end = -1.0d;
        this.batch = -1;
    }

    public final int getBatch() {
        return this.batch;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final double getEnd() {
        return this.end;
    }

    public final double getStart() {
        return this.start;
    }

    public final void setBatch(int r100) {
        this.batch = r100;
    }

    public final void setDelay(long r100) {
        this.delay = r100;
    }

    public final void setEnd(double r100) {
        this.end = r100;
    }

    public final void setStart(double r100) {
        this.start = r100;
    }
}
