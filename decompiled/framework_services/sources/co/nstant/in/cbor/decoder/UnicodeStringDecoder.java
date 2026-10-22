package co.nstant.in.cbor.decoder;

import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.UnicodeString;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class UnicodeStringDecoder extends AbstractDecoder<UnicodeString> {
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public /* bridge */ /* synthetic */ UnicodeString decode(int r1) throws CborException {
        return decode(r1);
    }

    public UnicodeStringDecoder(CborDecoder decoder, InputStream inputStream) {
        super(decoder, inputStream);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // co.nstant.in.cbor.decoder.AbstractDecoder
    public UnicodeString decode(int initialByte) throws CborException {
        long length = getLength(initialByte);
        if (length != (-1)) goto L11;
        if (this.decoder.isAutoDecodeInfinitiveUnicodeStrings() == true) goto L7;
        UnicodeString unicodeString = new UnicodeString(null);
        unicodeString.setChunked(true);
        return unicodeString;
    L7:
        return decodeInfinitiveLength();
    L11:
        return decodeFixedLength(length);
    }

    private UnicodeString decodeInfinitiveLength() throws CborException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    L3:
        DataItem dataItem = this.decoder.decodeNext();
        if (dataItem == null) goto L15;
        MajorType majorType = dataItem.getMajorType();
        if (Special.BREAK.equals(dataItem) == true) goto L8;
        if (majorType != MajorType.UNICODE_STRING) goto L13;
        UnicodeString unicodeString = (UnicodeString) dataItem;
        byte[] byteArray = unicodeString.toString().getBytes(StandardCharsets.UTF_8);
        bytes.write(byteArray, 0, byteArray.length);
        goto L3
    L13:
        throw new CborException("Unexpected major type " + majorType);
    L8:
        return new UnicodeString(new String(bytes.toByteArray(), StandardCharsets.UTF_8));
    L15:
        throw new CborException("Unexpected end of stream");
    }

    private UnicodeString decodeFixedLength(long length) throws CborException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream((int) length);
        long i = 0;
    L4:
        if (i >= length) goto L7;
        bytes.write(nextSymbol());
        i = i + 1;
        goto L4
    L7:
        return new UnicodeString(new String(bytes.toByteArray(), StandardCharsets.UTF_8));
    }
}
