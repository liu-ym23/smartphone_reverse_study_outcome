package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.AdditionalInformation;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDecoder<T> {
    protected static final int INFINITY = -1;
    protected final CborDecoder decoder;
    protected final InputStream inputStream;

    /* JADX INFO: renamed from: co.nstant.in.cbor.decoder.AbstractDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation = null;

        static {
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation = new int[AdditionalInformation.values().length];
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L35:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.ONE_BYTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L27:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.TWO_BYTES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L25:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.FOUR_BYTES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L29:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.EIGHT_BYTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.INDEFINITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            $SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.RESERVED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public abstract T decode(int r1) throws CborException;

    public AbstractDecoder(CborDecoder decoder, InputStream inputStream) {
        this.decoder = decoder;
        this.inputStream = inputStream;
    }

    protected int nextSymbol() throws CborException {
        int symbol = this.inputStream.read();     // Catch: IOException -> L7
        if (symbol == (-1)) goto L6;
        return symbol;
    L6:
        throw new IOException("Unexpected end of stream");     // Catch: IOException -> L7
    L7:
        ioException = move-exception;
        throw new CborException(ioException);
    }

    protected long getLength(int initialByte) throws CborException {
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.ofByte(initialByte).ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L8:
        long eightByteValue = 0 | (((long) nextSymbol()) << 56);
        return (((((long) nextSymbol()) << 16) | ((((eightByteValue | (((long) nextSymbol()) << 48)) | (((long) nextSymbol()) << 40)) | (((long) nextSymbol()) << 32)) | (((long) nextSymbol()) << 24))) | (((long) nextSymbol()) << 8)) | (((long) nextSymbol()) << 0);
    L10:
        long fourByteValue = 0 | (((long) nextSymbol()) << 24);
        return (((((long) nextSymbol()) << 16) | fourByteValue) | (((long) nextSymbol()) << 8)) | (((long) nextSymbol()) << 0);
    L12:
        long twoByteValue = 0 | ((long) (nextSymbol() << 8));
        return twoByteValue | ((long) (nextSymbol() << 0));
    L5:
        throw new CborException("Reserved additional information");
    L15:
        return nextSymbol();
    L17:
        return initialByte & 31;
    }

    protected BigInteger getLengthAsBigInteger(int initialByte) throws CborException {
        switch(AnonymousClass1.$SwitchMap$co$nstant$in$cbor$model$AdditionalInformation[AdditionalInformation.ofByte(initialByte).ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L5;
        };
    L8:
        BigInteger eightByteValue = BigInteger.ZERO;
        return eightByteValue.or(BigInteger.valueOf(nextSymbol()).shiftLeft(56)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(48)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(40)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(32)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(24)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(16)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(8)).or(BigInteger.valueOf(nextSymbol()).shiftLeft(0));
    L10:
        long fourByteValue = 0 | (((long) nextSymbol()) << 24);
        return BigInteger.valueOf((((((long) nextSymbol()) << 16) | fourByteValue) | (((long) nextSymbol()) << 8)) | (((long) nextSymbol()) << 0));
    L12:
        long twoByteValue = 0 | ((long) (nextSymbol() << 8));
        return BigInteger.valueOf(twoByteValue | ((long) (nextSymbol() << 0)));
    L5:
        throw new CborException("Reserved additional information");
    L7:
        return BigInteger.valueOf(-1);
    L15:
        return BigInteger.valueOf(nextSymbol());
    L17:
        return BigInteger.valueOf(initialByte & 31);
    }
}
