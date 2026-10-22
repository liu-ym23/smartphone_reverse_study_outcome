package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/xb1;", "", "", "scrollDelay", "I", "switchInterval", "scrollSpeed", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class xb1 {

    @SerializedName("scroll_delay")
    private int scrollDelay;

    @SerializedName("scroll_speed")
    private int scrollSpeed;

    @SerializedName("switch_interval")
    private int switchInterval;

    public xb1() {
        this.scrollDelay = 1000;
        this.switchInterval = 4000;
        this.scrollSpeed = 26;
    }

    public final int a() {
        return this.scrollSpeed;
    }
}
