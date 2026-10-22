package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.SimpleValue;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteStringEncoder extends AbstractEncoder<ByteString> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(ByteString r1) throws CborException {
        encode2(r1);
    }

    public ByteStringEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ByteString byteString) throws CborException {
        byte[] bytes = byteString.getBytes();
        if (byteString.isChunked() == false) goto L7;
        encodeTypeChunked(MajorType.BYTE_STRING);
        if (bytes == null) goto L11;
        encode2(new ByteString(bytes));
        return;
    L11:
        return;
    L7:
        if (bytes != null) goto L9;
        this.encoder.encode(SimpleValue.NULL);
        return;
    L9:
        encodeTypeAndLength(MajorType.BYTE_STRING, bytes.length);
        write(bytes);
    }
}
