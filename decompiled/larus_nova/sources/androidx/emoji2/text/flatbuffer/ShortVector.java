package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class ShortVector extends BaseVector {
    public ShortVector() {
    }

    public short get(int r100) {
        return this.f15443bb.getShort(__element(r100));
    }

    public int getAsUnsigned(int r100) {
        return get(r100) & 65535;
    }

    public ShortVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 2, r101);
        return this;
    }
}
