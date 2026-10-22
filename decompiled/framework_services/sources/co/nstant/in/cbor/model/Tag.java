package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Tag extends DataItem {
    private final long value;

    public Tag(long value) {
        super(MajorType.TAG);
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof Tag) == false) goto L10;
        Tag other = (Tag) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.value != other.value) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ Objects.hashCode(Long.valueOf(this.value));
    }

    public String toString() {
        return "Tag(" + this.value + ")";
    }
}
