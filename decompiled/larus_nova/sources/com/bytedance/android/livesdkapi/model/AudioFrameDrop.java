package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioFrameDrop;", "", "()V", "count", "", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enable", "getEnable", "setEnable", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioFrameDrop {
    private Integer count;
    private Integer enable;

    public String toString() {
        return "AudioFrameDrop(enable=" + this.enable + ", count=" + this.count + ')';
    }

    public AudioFrameDrop() {
        this.enable = -1;
        this.count = 0;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getEnable() {
        return this.enable;
    }

    public final void setCount(Integer r100) {
        this.count = r100;
    }

    public final void setEnable(Integer r100) {
        this.enable = r100;
    }
}
