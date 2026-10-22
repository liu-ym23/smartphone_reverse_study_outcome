package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
public final class IntVector extends BaseVector {
    public IntVector() {
    }

    public int get(int r100) {
        return this.f15443bb.getInt(__element(r100));
    }

    public long getAsUnsigned(int r100) {
        return ((long) get(r100)) & BodyPartID.bodyIdMax;
    }

    public IntVector __assign(int r100, ByteBuffer r101) {
        __reset(r100, 4, r101);
        return this;
    }
}
