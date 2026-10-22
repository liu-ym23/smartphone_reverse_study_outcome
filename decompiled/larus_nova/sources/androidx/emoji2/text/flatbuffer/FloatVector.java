package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public final class FloatVector extends BaseVector {
    public FloatVector() {
    }

    public float get(int r100) {
        return this.f15443bb.getFloat(__element(r100));
    }

    public FloatVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 4, r101);
        return this;
    }
}
