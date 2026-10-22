package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b0\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/config/h61;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "net_enable", "e", "setNet_enable", "", "params_a", "I", "f", "()I", "setParams_a", "(I)V", "params_b", com.amap.api.col.s.ce.f26391f, "setParams_b", "params_c", "h", "setParams_c", "params_d", RXScreenCaptureService.KEY_INDEX, "setParams_d", "range_a", com.amap.api.col.s.ce.f26395j, "setRange_a", "range_b", com.amap.api.col.s.ce.f26396k, "setRange_b", "range_c", "l", "setRange_c", "range_d", "m", "setRange_d", "stream_enable", OfficeSDKRequestTag.KEY_NEW_USER, "setStream_enable", "time_gap_behavior", "p", "setTime_gap_behavior", "time_gap_0vv", "o", "setTime_gap_0vv", "limit_0vv", "b", "setLimit_0vv", "multi_low_speed", "d", "setMulti_low_speed", "low_speed_correct", "c", "setLow_speed_correct", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h61 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("limit_0vv")
    private int limit_0vv;

    @SerializedName("low_speed_correct")
    private int low_speed_correct;

    @SerializedName("multi_low_speed")
    private int multi_low_speed;

    @SerializedName("net_enable")
    private boolean net_enable;

    @SerializedName("params_a")
    private int params_a;

    @SerializedName("params_b")
    private int params_b;

    @SerializedName("params_c")
    private int params_c;

    @SerializedName("params_d")
    private int params_d;

    @SerializedName("range_a")
    private int range_a;

    @SerializedName("range_b")
    private int range_b;

    @SerializedName("range_c")
    private int range_c;

    @SerializedName("range_d")
    private int range_d;

    @SerializedName("stream_enable")
    private boolean stream_enable;

    @SerializedName("time_gap_0vv")
    private int time_gap_0vv;

    @SerializedName("time_gap_behavior")
    private int time_gap_behavior;

    public h61() {
        this.params_a = 93;
        this.params_b = 67;
        this.params_c = 92;
        this.params_d = 60;
        this.range_a = 600;
        this.range_b = 500;
        this.range_c = 355;
        this.time_gap_behavior = 30000;
        this.time_gap_0vv = 120000;
        this.limit_0vv = 3;
        this.multi_low_speed = 50;
        this.low_speed_correct = 100;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.limit_0vv;
    }

    public final int c() {
        return this.low_speed_correct;
    }

    public final int d() {
        return this.multi_low_speed;
    }

    public final boolean e() {
        return this.net_enable;
    }

    public final int f() {
        return this.params_a;
    }

    public final int g() {
        return this.params_b;
    }

    public final int h() {
        return this.params_c;
    }

    public final int i() {
        return this.params_d;
    }

    public final int j() {
        return this.range_a;
    }

    public final int k() {
        return this.range_b;
    }

    public final int l() {
        return this.range_c;
    }

    public final int m() {
        return this.range_d;
    }

    public final boolean n() {
        return this.stream_enable;
    }

    public final int o() {
        return this.time_gap_0vv;
    }

    public final int p() {
        return this.time_gap_behavior;
    }
}
