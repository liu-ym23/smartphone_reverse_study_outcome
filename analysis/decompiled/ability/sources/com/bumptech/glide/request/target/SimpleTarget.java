package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import androidx.appfunctions.metadata.a;
import com.bumptech.glide.util.Util;

@Deprecated
/* loaded from: classes2.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder sb = new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        throw new IllegalArgumentException(a.o(sb, ", either provide dimensions in the constructor or call override()", this.height));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i, int i6) {
        this.width = i;
        this.height = i6;
    }
}
