package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityMappingConfig;", "", "()V", "p0_end", "", "getP0_end", "()I", "setP0_end", "(I)V", "p0_start", "getP0_start", "setP0_start", "p1_end", "getP1_end", "setP1_end", "p1_start", "getP1_start", "setP1_start", "p2_end", "getP2_end", "setP2_end", "p2_start", "getP2_start", "setP2_start", "p3_end", "getP3_end", "setP3_end", "p3_start", "getP3_start", "setP3_start", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentBatchPriorityMappingConfig {

    @SerializedName("p0_end")
    private int p0_end;

    @SerializedName("p0_start")
    private int p0_start;

    @SerializedName("p1_end")
    private int p1_end;

    @SerializedName("p1_start")
    private int p1_start;

    @SerializedName("p2_end")
    private int p2_end;

    @SerializedName("p2_start")
    private int p2_start;

    @SerializedName("p3_end")
    private int p3_end;

    @SerializedName("p3_start")
    private int p3_start;

    public ComponentBatchPriorityMappingConfig() {
        this.p0_start = -1;
        this.p0_end = -1;
        this.p1_start = -1;
        this.p1_end = -1;
        this.p2_start = -1;
        this.p2_end = -1;
        this.p3_start = -1;
        this.p3_end = -1;
    }

    public final int getP0_end() {
        return this.p0_end;
    }

    public final int getP0_start() {
        return this.p0_start;
    }

    public final int getP1_end() {
        return this.p1_end;
    }

    public final int getP1_start() {
        return this.p1_start;
    }

    public final int getP2_end() {
        return this.p2_end;
    }

    public final int getP2_start() {
        return this.p2_start;
    }

    public final int getP3_end() {
        return this.p3_end;
    }

    public final int getP3_start() {
        return this.p3_start;
    }

    public final void setP0_end(int r100) {
        this.p0_end = r100;
    }

    public final void setP0_start(int r100) {
        this.p0_start = r100;
    }

    public final void setP1_end(int r100) {
        this.p1_end = r100;
    }

    public final void setP1_start(int r100) {
        this.p1_start = r100;
    }

    public final void setP2_end(int r100) {
        this.p2_end = r100;
    }

    public final void setP2_start(int r100) {
        this.p2_start = r100;
    }

    public final void setP3_end(int r100) {
        this.p3_end = r100;
    }

    public final void setP3_start(int r100) {
        this.p3_start = r100;
    }
}
