package co.nstant.in.cbor.encoder;

import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.Special;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MapEncoder extends AbstractEncoder<Map> {
    @Override // co.nstant.in.cbor.encoder.AbstractEncoder
    public /* bridge */ /* synthetic */ void encode(Map r1) throws CborException {
        encode2(r1);
    }

    public MapEncoder(CborEncoder encoder, OutputStream outputStream) {
        super(encoder, outputStream);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(Map map) throws CborException {
        Collection<DataItem> keys = map.getKeys();
        if (map.isChunked() == false) goto L5;
        encodeTypeChunked(MajorType.MAP);
    L7:
        if (keys.isEmpty() == false) goto L10;
        return;
    L10:
        if (map.isChunked() == false) goto L17;
        Iterator<DataItem> r1 = keys.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        DataItem key = r1.next();
        this.encoder.encode(key);
        this.encoder.encode(map.get(key));
        goto L13
    L15:
        this.encoder.encode(Special.BREAK);
        return;
    L17:
        TreeMap<byte[], byte[]> sortedMap = new TreeMap(new AnonymousClass1(this));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CborEncoder e = new CborEncoder(byteArrayOutputStream);
        Iterator<DataItem> r4 = keys.iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        DataItem key2 = r4.next();
        e.encode(key2);
        byte[] keyBytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        e.encode(map.get(key2));
        byte[] valueBytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        sortedMap.put(keyBytes, valueBytes);
        goto L19
    L21:
        Iterator<java.util.Map.Entry<byte[], byte[]>> r5 = sortedMap.entrySet().iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        java.util.Map.Entry<byte[], byte[]> entry = r5.next();
        write(entry.getKey());
        write(entry.getValue());
        goto L23
    L25:
        return;
    L5:
        encodeTypeAndLength(MajorType.MAP, keys.size());
        goto L7
    }
}
