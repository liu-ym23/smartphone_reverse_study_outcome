package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerSpeedRangeParams;", "", "upRatio", "", "upBuffer", "", "downRatio", "downBuffer", "(FIFI)V", "getDownBuffer", "()I", "getDownRatio", "()F", "getUpBuffer", "getUpRatio", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerSpeedRangeParams {
    private final int downBuffer;
    private final float downRatio;
    private final int upBuffer;
    private final float upRatio;

    public final int getDownBuffer() {
        return this.downBuffer;
    }

    public final float getDownRatio() {
        return this.downRatio;
    }

    public final int getUpBuffer() {
        return this.upBuffer;
    }

    public final float getUpRatio() {
        return this.upRatio;
    }

    public PlayerSpeedRangeParams(float r100, int r101, float r102, int r103) {
        this.upRatio = r100;
        this.upBuffer = r101;
        this.downRatio = r102;
        this.downBuffer = r103;
    }
}
