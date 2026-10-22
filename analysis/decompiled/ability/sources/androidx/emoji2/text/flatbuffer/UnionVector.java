package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i, int i6, ByteBuffer byteBuffer) {
        __reset(i, i6, byteBuffer);
        return this;
    }

    public Table get(Table table, int i) {
        return Table.__union(table, __element(i), this.bb);
    }
}
