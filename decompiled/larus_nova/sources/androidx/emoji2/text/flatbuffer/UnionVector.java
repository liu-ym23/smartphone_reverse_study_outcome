package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class UnionVector extends BaseVector {
    public UnionVector() {
    }

    public Table get(Table r100, int r101) {
        return Table.__union(r100, __element(r101), this.f15443bb);
    }

    public UnionVector __assign(int r100, int r101, ByteBuffer r102) {
        __reset(r100, r101, r102);
        return this;
    }
}
