package L1;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class f {
    public abstract int getCachedSize();

    public abstract int getSerializedSize();

    public abstract f mergeFrom(b bVar);

    public f mergeFrom(byte[] bArr, int i4, int i5) throws e {
        try {
            b bVar = new b(i4, i5, bArr);
            mergeFrom(bVar);
            if (bVar.f1223e == 0) {
                return this;
            }
            throw new e("Protocol message end-group tag did not match expected tag.");
        } catch (e e4) {
            throw e4;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public boolean parseUnknownField(b bVar, int i4) throws IOException {
        return bVar.r(i4);
    }

    public byte[] toByteArray() {
        int serializedSize = getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(bArr, 0, serializedSize);
        return bArr;
    }

    public abstract void writeTo(d dVar);

    public void toByteArray(byte[] bArr, int i4, int i5) {
        try {
            d dVar = new d(i4, i5, bArr);
            writeTo(dVar);
            if (dVar.f1228b - dVar.f1229c == 0) {
            } else {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public f mergeFrom(byte[] bArr) throws e {
        return mergeFrom(bArr, 0, bArr.length);
    }
}
