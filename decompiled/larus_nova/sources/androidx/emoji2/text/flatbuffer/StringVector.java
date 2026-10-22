package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8;

    public StringVector() {
        this.utf8 = Utf8.getDefault();
    }

    public String get(int r100) {
        return Table.__string(__element(r100), this.f15443bb, this.utf8);
    }

    public StringVector __assign(int r100, int r101, ByteBuffer r102) {
        __reset(r100, r101, r102);
        return this;
    }
}
