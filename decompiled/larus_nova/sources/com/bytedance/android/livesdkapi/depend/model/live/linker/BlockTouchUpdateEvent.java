package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BlockTouchUpdateEvent;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom", "()F", "getLeft", "getRight", "getTop", "isBlock", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BlockTouchUpdateEvent {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public final boolean isBlock() {
        float r100 = this.left;
        float r101 = 0;
        if (r100 < r101) goto L18;
        float r102 = this.top;
        if (r102 < r101) goto L18;
        float r103 = this.right;
        if (r103 < r101) goto L18;
        float r104 = this.bottom;
        if (r104 < r101) goto L18;
        if (r100 >= r103) goto L18;
        if (r102 >= r104) goto L18;
        return true;
    L18:
        return false;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public BlockTouchUpdateEvent(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
