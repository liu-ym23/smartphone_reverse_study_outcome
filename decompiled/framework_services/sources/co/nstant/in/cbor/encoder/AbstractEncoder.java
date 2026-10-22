package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.AdditionalInformation;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Tag;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEncoder<T> {
    protected final CborEncoder encoder;
    private final OutputStream outputStream;

    public abstract void encode(T r1) throws CborException;

    public AbstractEncoder(CborEncoder encoder, OutputStream outputStream) {
        this.encoder = encoder;
        this.outputStream = outputStream;
    }

    protected void encodeTypeChunked(MajorType majorType) throws CborException {
        int symbol = majorType.getValue() << 5;
        int symbol2 = symbol | AdditionalInformation.INDEFINITE.getValue();
        this.outputStream.write(symbol2);     // Catch: IOException -> L5
        return;
    L5:
        ioException = move-exception;
        throw new CborException(ioException);
    }

    protected void encodeTypeAndLength(MajorType majorType, long length) throws CborException {
        int symbol = majorType.getValue() << 5;
        if (length > 23) goto L6;
        write((int) (((long) symbol) | length));
        return;
    L6:
        if (length > 255) goto L9;
        write(symbol | AdditionalInformation.ONE_BYTE.getValue());
        write((int) length);
        return;
    L9:
        if (length > 65535) goto L12;
        write(symbol | AdditionalInformation.TWO_BYTES.getValue());
        write((int) (length >> 8));
        write((int) (255 & length));
        return;
    L12:
        if (length > 4294967295L) goto L14;
        write(symbol | AdditionalInformation.FOUR_BYTES.getValue());
        write((int) ((length >> 24) & 255));
        write((int) ((length >> 16) & 255));
        write((int) ((length >> 8) & 255));
        write((int) (255 & length));
        return;
    L14:
        write(symbol | AdditionalInformation.EIGHT_BYTES.getValue());
        write((int) ((length >> 56) & 255));
        write((int) ((length >> 48) & 255));
        write((int) ((length >> 40) & 255));
        write((int) ((length >> 32) & 255));
        write((int) ((length >> 24) & 255));
        write((int) ((length >> 16) & 255));
        write((int) ((length >> 8) & 255));
        write((int) (255 & length));
    }

    protected void encodeTypeAndLength(MajorType majorType, BigInteger length) throws CborException {
        if (majorType != MajorType.NEGATIVE_INTEGER) goto L5;
        boolean negative = true;
    L6:
        int symbol = majorType.getValue() << 5;
        if (length.compareTo(BigInteger.valueOf(24)) != (-1)) goto L10;
        write(length.intValue() | symbol);
        return;
    L10:
        if (length.compareTo(BigInteger.valueOf(256)) != (-1)) goto L13;
        write(symbol | AdditionalInformation.ONE_BYTE.getValue());
        write(length.intValue());
        return;
    L13:
        if (length.compareTo(BigInteger.valueOf(65536)) != (-1)) goto L16;
        write(symbol | AdditionalInformation.TWO_BYTES.getValue());
        long twoByteValue = length.longValue();
        write((int) (twoByteValue >> 8));
        write((int) (twoByteValue & 255));
        return;
    L16:
        if (length.compareTo(BigInteger.valueOf(4294967296L)) != (-1)) goto L19;
        write(symbol | AdditionalInformation.FOUR_BYTES.getValue());
        long fourByteValue = length.longValue();
        write((int) ((fourByteValue >> 24) & 255));
        write((int) ((fourByteValue >> 16) & 255));
        write((int) ((fourByteValue >> 8) & 255));
        write((int) (fourByteValue & 255));
        return;
    L19:
        if (length.compareTo(new BigInteger("18446744073709551616")) != (-1)) goto L21;
        write(symbol | AdditionalInformation.EIGHT_BYTES.getValue());
        BigInteger mask = BigInteger.valueOf(255);
        write(length.shiftRight(56).and(mask).intValue());
        write(length.shiftRight(48).and(mask).intValue());
        write(length.shiftRight(40).and(mask).intValue());
        write(length.shiftRight(32).and(mask).intValue());
        write(length.shiftRight(24).and(mask).intValue());
        write(length.shiftRight(16).and(mask).intValue());
        write(length.shiftRight(8).and(mask).intValue());
        write(length.and(mask).intValue());
        return;
    L21:
        if (negative == false) goto L23;
        this.encoder.encode(new Tag(3));
    L24:
        this.encoder.encode(new ByteString(length.toByteArray()));
        return;
    L23:
        this.encoder.encode(new Tag(2));
        goto L24
    L5:
        negative = false;
        goto L6
    }

    protected void write(int b) throws CborException {
        this.outputStream.write(b);     // Catch: IOException -> L4
        return;
    L4:
        ioException = move-exception;
        throw new CborException(ioException);
    }

    protected void write(byte[] bytes) throws CborException {
        this.outputStream.write(bytes);     // Catch: IOException -> L4
        return;
    L4:
        ioException = move-exception;
        throw new CborException(ioException);
    }
}
