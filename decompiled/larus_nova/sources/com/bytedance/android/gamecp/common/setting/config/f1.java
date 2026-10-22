package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/f1;", "", "", "enable", "Z", "c", "()Z", "setEnable", "(Z)V", "innerPushEnable", "d", "setInnerPushEnable", "localPushEnable", "e", "setLocalPushEnable", "toastEnable", ce.f26391f, "setToastEnable", "", "apkMultiple", "D", "b", "()D", "setApkMultiple", "(D)V", "", "time", "J", "f", "()J", "setTime", "(J)V", "", "apkDownloadedTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setApkDownloadedTime", "(I)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("apk_downloaded_time")
    private int apkDownloadedTime;

    @SerializedName("apk_multiple")
    private double apkMultiple;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("inner_push_enable")
    private boolean innerPushEnable;

    @SerializedName("local_push_enable")
    private boolean localPushEnable;

    @SerializedName("time")
    private long time;

    @SerializedName("toast_enable")
    private boolean toastEnable;

    public f1() {
        this.enable = true;
        this.innerPushEnable = true;
        this.localPushEnable = true;
        this.toastEnable = true;
        this.apkMultiple = 2.5d;
        this.time = 10000;
        this.apkDownloadedTime = 7;
    }

    public final int a() {
        return this.apkDownloadedTime;
    }

    public final double b() {
        return this.apkMultiple;
    }

    public final boolean c() {
        return this.enable;
    }

    public final boolean d() {
        return this.innerPushEnable;
    }

    public final boolean e() {
        return this.localPushEnable;
    }

    public final long f() {
        return this.time;
    }

    public final boolean g() {
        return this.toastEnable;
    }
}
