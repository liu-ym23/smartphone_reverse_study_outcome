package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes17.dex */
public final class ByteVector extends BaseVector {
    public ByteVector() {
    }

    public byte get(int r100) {
        return this.f15443bb.get(__element(r100));
    }

    public int getAsUnsigned(int r100) {
        return get(r100) & UByte.MAX_VALUE;
    }

    public ByteVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 1, r101);
        return this;
    }
}
