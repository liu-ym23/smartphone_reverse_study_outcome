package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector() {
    }

    public FloatVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 4, r3);
        return this;
    }

    public float get(int r2) {
        return this.bb.getFloat(__element(r2));
    }
}
