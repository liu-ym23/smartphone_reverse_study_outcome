package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.MajorType;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArrayEncoder extends AbstractEncoder<Array> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(Array r1) throws CborException {
        encode2(r1);
    }

    public ArrayEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(Array array) throws CborException {
        List<DataItem> dataItems = array.getDataItems();
        if (array.isChunked() == false) goto L5;
        encodeTypeChunked(MajorType.ARRAY);
    L6:
        Iterator<DataItem> r1 = dataItems.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        DataItem dataItem = r1.next();
        this.encoder.encode(dataItem);
        goto L8
    L10:
        return;
    L5:
        encodeTypeAndLength(MajorType.ARRAY, dataItems.size());
        goto L6
    }
}
