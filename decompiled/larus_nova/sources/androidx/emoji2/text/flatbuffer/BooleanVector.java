package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class BooleanVector extends BaseVector {
    public BooleanVector() {
    }

    public boolean get(int r100) {
        if (this.f15443bb.get(__element(r100)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BooleanVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 1, r101);
        return this;
    }
}
