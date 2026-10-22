package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "", "mode", "", "width", "height", "(III)V", "getHeight", "()I", "getMode", "getWidth", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BottomContainerSize {
    private final int height;
    private final int mode;
    private final int width;

    public String toString() {
        return "BottomContainerSize(mode=" + this.mode + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getWidth() {
        return this.width;
    }

    public BottomContainerSize(int r100, int r101, int r102) {
        this.mode = r100;
        this.width = r101;
        this.height = r102;
    }
}
