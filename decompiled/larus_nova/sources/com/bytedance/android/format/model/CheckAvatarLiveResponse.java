package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/format/model/CheckAvatarLiveResponse;", "Ljava/io/Serializable;", "()V", "nextCheckInterval", "", "getNextCheckInterval", "()J", "setNextCheckInterval", "(J)V", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "status", "getStatus", "setStatus", "timeOut", "getTimeOut", "setTimeOut", "waitHint", "", "getWaitHint", "()Ljava/lang/String;", "setWaitHint", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckAvatarLiveResponse implements Serializable {

    @SerializedName("next_check_time_gap")
    private long nextCheckInterval;

    @SerializedName("progress")
    private int progress;

    @SerializedName("status")
    private int status;

    @SerializedName("timeout")
    private long timeOut;

    @SerializedName("wait_hint")
    private String waitHint;

    public CheckAvatarLiveResponse() {
        this.waitHint = "";
    }

    public final long getNextCheckInterval() {
        return this.nextCheckInterval;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTimeOut() {
        return this.timeOut;
    }

    public final String getWaitHint() {
        return this.waitHint;
    }

    public final void setNextCheckInterval(long r100) {
        this.nextCheckInterval = r100;
    }

    public final void setProgress(int r100) {
        this.progress = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTimeOut(long r100) {
        this.timeOut = r100;
    }

    public final void setWaitHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.waitHint = r100;
    }
}
