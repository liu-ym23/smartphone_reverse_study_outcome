package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector() {
    }

    public double get(int r100) {
        return this.f15443bb.getDouble(__element(r100));
    }

    public DoubleVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 8, r101);
        return this;
    }
}
