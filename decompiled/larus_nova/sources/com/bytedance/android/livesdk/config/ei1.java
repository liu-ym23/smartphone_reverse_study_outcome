package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/ei1;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "id", "I", "e", "()I", "setId", "(I)V", "uploadInterval", "f", "setUploadInterval", "duration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDuration", "", "error", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "errorType", "d", "setErrorType", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ei1 {

    @SerializedName("duration")
    private int duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("error")
    private String error;

    @SerializedName("error_type")
    private String errorType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f120130id;

    @SerializedName("upload_interval")
    private int uploadInterval;

    public ei1() {
        this.f120130id = -1;
        this.uploadInterval = 1800;
        this.duration = 600;
        this.error = "";
        this.errorType = "";
    }

    public final int a() {
        return this.duration;
    }

    public final boolean b() {
        return this.enable;
    }

    public final String c() {
        return this.error;
    }

    public final String d() {
        return this.errorType;
    }

    public final int e() {
        return this.f120130id;
    }

    public final int f() {
        return this.uploadInterval;
    }
}
