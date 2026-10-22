package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/i6;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "enableDropFrame", "c", "setEnableDropFrame", "", "dropFrameInterval", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setDropFrameInterval", "(I)V", "minFrameRate", "e", "setMinFrameRate", "enableDropLottery", "d", "setEnableDropLottery", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i6 {

    @SerializedName("drop_frame_interval")
    private int dropFrameInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_drop_frame")
    private boolean enableDropFrame;

    @SerializedName("enable_drop_lottery")
    private boolean enableDropLottery;

    @SerializedName("min_frame_rate")
    private int minFrameRate;

    public i6() {
        this.minFrameRate = 15;
    }

    public final int a() {
        return this.dropFrameInterval;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableDropFrame;
    }

    public final boolean d() {
        return this.enableDropLottery;
    }

    public final int e() {
        return this.minFrameRate;
    }
}
