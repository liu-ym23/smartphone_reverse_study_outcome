package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.UnicodeString;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class UnicodeStringEncoder extends AbstractEncoder<UnicodeString> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(UnicodeString r1) throws CborException {
        encode2(r1);
    }

    public UnicodeStringEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(UnicodeString dataItem) throws CborException {
        String string = dataItem.getString();
        if (dataItem.isChunked() == false) goto L7;
        encodeTypeChunked(MajorType.UNICODE_STRING);
        if (string == null) goto L11;
        encode2(new UnicodeString(string));
        return;
    L11:
        return;
    L7:
        if (string != null) goto L9;
        this.encoder.encode(SimpleValue.NULL);
        return;
    L9:
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        encodeTypeAndLength(MajorType.UNICODE_STRING, bytes.length);
        write(bytes);
    }
}
