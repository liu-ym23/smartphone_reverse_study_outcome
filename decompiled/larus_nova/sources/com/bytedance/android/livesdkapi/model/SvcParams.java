package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SvcParams;", "", "enable", "", "discardMaxTemporalIdOffset", "", "discardInterval", "(ZII)V", "getDiscardInterval", "()I", "getDiscardMaxTemporalIdOffset", "getEnable", "()Z", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SvcParams {
    private final int discardInterval;
    private final int discardMaxTemporalIdOffset;
    private final boolean enable;

    public String toString() {
        return "SvcParams(enable=" + this.enable + ", discardMaxTemporalIdOffset=" + this.discardMaxTemporalIdOffset + ", discardInterval=" + this.discardInterval + ')';
    }

    public final int getDiscardInterval() {
        return this.discardInterval;
    }

    public final int getDiscardMaxTemporalIdOffset() {
        return this.discardMaxTemporalIdOffset;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public SvcParams(boolean r100, int r101, int r102) {
        this.enable = r100;
        this.discardMaxTemporalIdOffset = r101;
        this.discardInterval = r102;
    }
}
