package com.stepos.core.ota.crypto;

import ai.onnxruntime.providers.a;
import com.stepos.core.ota.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CryptoHeaderParser {
    public static final CryptoHeaderParser INSTANCE = new CryptoHeaderParser();
    public static final int IV_LEN = 12;
    public static final int MAGIC_ENCRYPTED = 1398031696;
    public static final int MAGIC_ZIP = 1347093252;
    public static final int MAX_BLOCK_SIZE = 1048576;
    public static final int SUPPORTED_VERSION = 1;
    public static final int TAG_BYTES = 16;

    private CryptoHeaderParser() {
    }

    public final byte[] build(CryptoHeader header) {
        g.f(header, "header");
        byte[] bArrArray = ByteBuffer.allocate(38).order(ByteOrder.BIG_ENDIAN).putInt(MAGIC_ENCRYPTED).put((byte) header.getFormatVersion()).put((byte) header.getIv().length).put(header.getIv()).putInt(header.getBlockSize()).putLong(header.getPlainLen()).putLong(header.getCipherLen()).array();
        g.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final CryptoHeader parse(byte[] head) {
        g.f(head, "head");
        if (head.length < 38) {
            throw new IllegalStateException(a.a(head.length, "header needs 38 bytes, got ").toString());
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(head, 0, 38).order(ByteOrder.BIG_ENDIAN);
        int i10 = byteBufferOrder.getInt();
        if (i10 != 1398031696) {
            throw new IllegalStateException("not an encrypted payload: magic=0x".concat(String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1))).toString());
        }
        int i11 = byteBufferOrder.get() & 255;
        CryptoAlgorithm cryptoAlgorithmFromId = CryptoAlgorithm.Companion.fromId(i11);
        if (cryptoAlgorithmFromId == null) {
            throw new IllegalStateException(a.a(i11, "unknown format version ").toString());
        }
        if (i11 != 1) {
            throw new IllegalStateException(a.a(i11, "unsupported format version ").toString());
        }
        int i12 = byteBufferOrder.get() & 255;
        if (i12 != 12) {
            throw new IllegalStateException(a.a(i12, "ivLen must be 12, got ").toString());
        }
        byte[] bArr = new byte[12];
        byteBufferOrder.get(bArr);
        int i13 = byteBufferOrder.getInt();
        if (1 > i13 || i13 >= 1048577) {
            throw new IllegalStateException(a.a(i13, "blockSize out of range: ").toString());
        }
        long j10 = byteBufferOrder.getLong();
        if (j10 <= 0) {
            throw new IllegalStateException(d.f(j10, "plainLen must be positive, got ").toString());
        }
        long j11 = byteBufferOrder.getLong();
        long j12 = i13;
        int i14 = (int) (((j10 + j12) - 1) / j12);
        long j13 = (i14 * 16) + j10;
        if (j11 == j13) {
            return new CryptoHeader(cryptoAlgorithmFromId, i11, bArr, i13, j10, j11);
        }
        StringBuilder sbQ = ai.onnxruntime.a.q(j11, "cipherLen mismatch: declared ", ", expected ");
        sbQ.append(j13);
        a0.a.s(j10, " (plainLen=", " blockSize=", sbQ);
        sbQ.append(i13);
        sbQ.append(" blocks=");
        sbQ.append(i14);
        sbQ.append(")");
        throw new IllegalStateException(sbQ.toString().toString());
    }

    public final int peekMagic(byte[] head) {
        g.f(head, "head");
        if (head.length >= 4) {
            return ByteBuffer.wrap(head, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
        }
        throw new IllegalStateException(a.a(head.length, "need 4 bytes to peek magic, got ").toString());
    }
}
