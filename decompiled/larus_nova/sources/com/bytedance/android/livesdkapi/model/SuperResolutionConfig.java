package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SuperResolutionConfig;", "", "()V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "operateReason", "", "getOperateReason", "()Ljava/lang/String;", "setOperateReason", "(Ljava/lang/String;)V", "srSharpenLevel", "getSrSharpenLevel", "setSrSharpenLevel", "srType", "getSrType", "setSrType", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SuperResolutionConfig {
    private int enable;
    private String operateReason;
    private int srSharpenLevel;
    private int srType;

    public String toString() {
        return "SuperResolutionConfig(enable=" + this.enable + ", srType=" + this.srType + ", srSharpenLevel=" + this.srSharpenLevel + ", operateReason=" + this.operateReason + ')';
    }

    public SuperResolutionConfig() {
        this.enable = -1;
        this.srType = -1;
        this.srSharpenLevel = -1;
        this.operateReason = "";
    }

    public final int getEnable() {
        return this.enable;
    }

    public final String getOperateReason() {
        return this.operateReason;
    }

    public final int getSrSharpenLevel() {
        return this.srSharpenLevel;
    }

    public final int getSrType() {
        return this.srType;
    }

    public final void setEnable(int r100) {
        this.enable = r100;
    }

    public final void setOperateReason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operateReason = r100;
    }

    public final void setSrSharpenLevel(int r100) {
        this.srSharpenLevel = r100;
    }

    public final void setSrType(int r100) {
        this.srType = r100;
    }
}
