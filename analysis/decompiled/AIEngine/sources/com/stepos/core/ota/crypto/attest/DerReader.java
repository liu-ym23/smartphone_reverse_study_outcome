package com.stepos.core.ota.crypto.attest;

import ai.onnxruntime.a;
import androidx.datastore.preferences.protobuf.b1;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DerReader {
    private final byte[] buf;
    private final int end;
    private int pos;

    public DerReader(byte[] buf, int i10, int i11) {
        g.f(buf, "buf");
        this.buf = buf;
        this.pos = i10;
        this.end = i11;
    }

    private final byte readByte() {
        int i10 = this.pos;
        if (i10 >= this.end) {
            throw new IllegalStateException("der truncated");
        }
        byte[] bArr = this.buf;
        this.pos = i10 + 1;
        return bArr[i10];
    }

    private final int readLength() {
        byte b10 = readByte();
        int i10 = b10 & 255;
        if ((b10 & 128) == 0) {
            return i10;
        }
        int i11 = b10 & 127;
        if (1 > i11 || i11 >= 5) {
            throw new IllegalStateException(a.g(i11, "der length octets ", " unsupported").toString());
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 << 8) | (readByte() & 255);
        }
        if (i12 >= 0) {
            return i12;
        }
        throw new IllegalStateException("der negative length");
    }

    public final boolean hasNext() {
        return this.pos < this.end;
    }

    public final DerElement next() {
        if (this.pos >= this.end) {
            return null;
        }
        byte b10 = readByte();
        int i10 = (b10 & 192) >>> 6;
        int i11 = 0;
        boolean z = (b10 & 32) != 0;
        int i12 = b10 & 31;
        if (i12 == 31) {
            do {
                byte b11 = readByte();
                i11 = (i11 << 7) | (b11 & 127);
                if ((b11 & 128) == 0) {
                    i12 = i11;
                }
            } while (i11 < 2097152);
            throw new IllegalStateException("der tag number overflow");
        }
        int length = readLength();
        int i13 = this.pos;
        int i14 = i13 + length;
        int i15 = this.end;
        if (i14 > i15) {
            throw new IllegalStateException(a0.a.f("der length ", length, i15 - i13, " exceeds remaining ").toString());
        }
        byte[] bArrU = b1.u(this.buf, i13, i13 + length);
        this.pos += length;
        return new DerElement(i10, z, i12, bArrU);
    }

    public /* synthetic */ DerReader(byte[] bArr, int i10, int i11, int i12, e eVar) {
        this(bArr, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? bArr.length : i11);
    }
}
