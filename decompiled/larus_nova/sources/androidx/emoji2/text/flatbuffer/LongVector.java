package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class LongVector extends BaseVector {
    public LongVector() {
    }

    public long get(int r100) {
        return this.f15443bb.getLong(__element(r100));
    }

    public LongVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 8, r101);
        return this;
    }
}
