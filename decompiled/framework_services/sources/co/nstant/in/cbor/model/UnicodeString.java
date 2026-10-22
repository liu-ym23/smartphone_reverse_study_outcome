package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public class UnicodeString extends ChunkableDataItem {
    private final String string;

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ boolean isChunked() {
        return super.isChunked();
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem
    public /* bridge */ /* synthetic */ ChunkableDataItem setChunked(boolean r1) {
        return super.setChunked(r1);
    }

    public UnicodeString(String string) {
        super(MajorType.UNICODE_STRING);
        this.string = string;
    }

    public String toString() {
        if (this.string != null) goto L7;
        return "null";
    L7:
        return this.string;
    }

    public String getString() {
        return this.string;
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof UnicodeString) == true) goto L5;
    L14:
        return false;
    L5:
        if (super.equals(object) == false) goto L14;
        UnicodeString other = (UnicodeString) object;
        if (this.string != null) goto L13;
        if (other.string != null) goto L15;
        return true;
    L15:
        return false;
    L13:
        return this.string.equals(other.string);
    }

    @Override // co.nstant.in.cbor.model.ChunkableDataItem, co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        if (this.string == null) goto L6;
        int hash = super.hashCode();
        return hash + this.string.hashCode();
    L6:
        return 0;
    }
}
