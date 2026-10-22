package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes39.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback r100) {
    }

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback r100) {
        if (Util.isValidDimensions(this.width, this.height) == false) goto L7;
        r100.onSizeReady(this.width, this.height);
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    public SimpleTarget(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }
}
