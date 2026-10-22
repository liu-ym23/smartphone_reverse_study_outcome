package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class ChunkableDataItem extends DataItem {
    private boolean chunked;

    protected ChunkableDataItem(MajorType majorType) {
        super(majorType);
        this.chunked = false;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public ChunkableDataItem setChunked(boolean chunked) {
        this.chunked = chunked;
        return this;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof ChunkableDataItem) == false) goto L10;
        ChunkableDataItem other = (ChunkableDataItem) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.chunked != other.chunked) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ Objects.hashCode(Boolean.valueOf(this.chunked));
    }
}
