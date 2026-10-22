package co.nstant.in.cbor.model;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ByteString extends ChunkableDataItem {
    private final byte[] bytes;

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ boolean isChunked() {
        return super.isChunked();
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ ChunkableDataItem setChunked(boolean r1) {
        return super.setChunked(r1);
    }

    public ByteString(byte[] bytes) {
        super(MajorType.BYTE_STRING);
        if (bytes != null) goto L5;
        this.bytes = null;
        return;
    L5:
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        if (this.bytes != null) goto L7;
        return null;
    L7:
        return this.bytes;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof ByteString) == false) goto L10;
        ByteString other = (ByteString) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (Arrays.equals(this.bytes, other.bytes) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.bytes);
    }
}
