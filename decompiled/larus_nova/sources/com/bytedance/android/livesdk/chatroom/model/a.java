package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b3\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/a;", "", "", "recordCount", "I", "e", "()I", "setRecordCount", "(I)V", "micSeqMs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setMicSeqMs", "micErrorTime", "getMicErrorTime", "setMicErrorTime", "tempHotTime", ce.f26391f, "setTempHotTime", "tempHotPushTime", "f", "setTempHotPushTime", "micLevel1", "getMicLevel1", "setMicLevel1", "micLevel2", "getMicLevel2", "setMicLevel2", "micLevel3", "getMicLevel3", "setMicLevel3", "micLevel4", "getMicLevel4", "setMicLevel4", "tempLevel1", "h", "setTempLevel1", "tempLevel2", RXScreenCaptureService.KEY_INDEX, "setTempLevel2", "netLevel1", "b", "setNetLevel1", "netLevel2", "c", "setNetLevel2", "netLevel3", "d", "setNetLevel3", "tempNetInterval", ce.f26395j, "setTempNetInterval", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("mic_error_time")
    private int micErrorTime;

    @SerializedName("mic_level_1")
    private int micLevel1;

    @SerializedName("mic_level_2")
    private int micLevel2;

    @SerializedName("mic_level_3")
    private int micLevel3;

    @SerializedName("mic_level_4")
    private int micLevel4;

    @SerializedName("mic_seq")
    private int micSeqMs;

    @SerializedName("net_level_1")
    private int netLevel1;

    @SerializedName("net_level_2")
    private int netLevel2;

    @SerializedName("net_level_3")
    private int netLevel3;

    @SerializedName("record_cnt")
    private int recordCount;

    @SerializedName("temp_hot_push_time")
    private int tempHotPushTime;

    @SerializedName("temp_hot_time")
    private int tempHotTime;

    @SerializedName("temp_level_1")
    private int tempLevel1;

    @SerializedName("temp_level_2")
    private int tempLevel2;

    @SerializedName("temp_net_interval_s")
    private int tempNetInterval;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.model.a$a, reason: collision with other inner class name */
    public static final class C1618a {
    }

    static {
    }

    public a() {
        this.recordCount = 200;
        this.micSeqMs = 100;
        this.micErrorTime = 10;
        this.tempHotTime = 30;
        this.tempHotPushTime = 60;
        this.micLevel1 = 49;
        this.micLevel2 = 58;
        this.micLevel3 = 61;
        this.micLevel4 = 69;
        this.tempLevel1 = 38;
        this.tempLevel2 = 40;
        this.netLevel1 = 6;
        this.netLevel2 = 5;
        this.netLevel3 = 2;
        this.tempNetInterval = 10;
    }

    public final int a() {
        return this.micSeqMs;
    }

    public final int b() {
        return this.netLevel1;
    }

    public final int c() {
        return this.netLevel2;
    }

    public final int d() {
        return this.netLevel3;
    }

    public final int e() {
        return this.recordCount;
    }

    public final int f() {
        return this.tempHotPushTime;
    }

    public final int g() {
        return this.tempHotTime;
    }

    public final int h() {
        return this.tempLevel1;
    }

    public final int i() {
        return this.tempLevel2;
    }

    public final int j() {
        return this.tempNetInterval;
    }
}
