package co.nstant.in.cbor.builder;

import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.decoder.HalfPrecisionFloatDecoder;
import co.nstant.in.cbor.encoder.HalfPrecisionFloatEncoder;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import co.nstant.in.cbor.model.NegativeInteger;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import co.nstant.in.cbor.model.UnsignedInteger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBuilder<T> {
    private final T parent;

    public AbstractBuilder(T parent) {
        this.parent = parent;
    }

    protected T getParent() {
        return this.parent;
    }

    protected void addChunk(DataItem dataItem) {
        throw new IllegalStateException();
    }

    protected DataItem convert(long value) {
        if (value < 0) goto L7;
        return new UnsignedInteger(value);
    L7:
        return new NegativeInteger(value);
    }

    protected DataItem convert(BigInteger value) {
        if (value.signum() != (-1)) goto L7;
        return new NegativeInteger(value);
    L7:
        return new UnsignedInteger(value);
    }

    protected DataItem convert(boolean value) {
        if (value == false) goto L6;
        return SimpleValue.TRUE;
    L6:
        return SimpleValue.FALSE;
    }

    protected DataItem convert(byte[] bytes) {
        return new ByteString(bytes);
    }

    protected DataItem convert(String string) {
        return new UnicodeString(string);
    }

    protected DataItem convert(float value) {
        if (isHalfPrecisionEnough(value) == false) goto L7;
        return new HalfPrecisionFloat(value);
    L7:
        return new SinglePrecisionFloat(value);
    }

    protected DataItem convert(double value) {
        return new DoublePrecisionFloat(value);
    }

    protected Tag tag(long value) {
        return new Tag(value);
    }

    private boolean isHalfPrecisionEnough(float value) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();     // Catch: CborException -> L9
        HalfPrecisionFloatEncoder encoder = getHalfPrecisionFloatEncoder(outputStream);     // Catch: CborException -> L9
        encoder.encode2(new HalfPrecisionFloat(value));     // Catch: CborException -> L9
        byte[] bytes = outputStream.toByteArray();     // Catch: CborException -> L9
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);     // Catch: CborException -> L9
        HalfPrecisionFloatDecoder decoder = getHalfPrecisionFloatDecoder(inputStream);     // Catch: CborException -> L9
        if (inputStream.read() == (-1)) goto L12;
        HalfPrecisionFloat halfPrecisionFloat = decoder.decode(0);     // Catch: CborException -> L9
        if (value != halfPrecisionFloat.getValue()) goto L16;
        return true;
    L16:
        return false;
    L12:
        throw new CborException("unexpected end of stream");     // Catch: CborException -> L9
    L14:
        return false;
    }

    protected HalfPrecisionFloatEncoder getHalfPrecisionFloatEncoder(OutputStream outputStream) {
        return new HalfPrecisionFloatEncoder(null, outputStream);
    }

    protected HalfPrecisionFloatDecoder getHalfPrecisionFloatDecoder(InputStream inputStream) {
        return new HalfPrecisionFloatDecoder(null, inputStream);
    }
}
