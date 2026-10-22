package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DataItem {
    private final MajorType majorType;
    private Tag tag;

    protected DataItem(MajorType majorType) {
        this.majorType = majorType;
        majorType.getClass();
    }

    public MajorType getMajorType() {
        return this.majorType;
    }

    public void setTag(int tag) {
        if (tag < 0) goto L6;
        this.tag = new Tag(tag);
        return;
    L6:
        throw new IllegalArgumentException("tag number must be 0 or greater");
    }

    public void setTag(Tag tag) {
        tag.getClass();
        this.tag = tag;
    }

    public void removeTag() {
        this.tag = null;
    }

    public Tag getTag() {
        return this.tag;
    }

    public boolean hasTag() {
        if (this.tag == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object object) {
        if ((object instanceof DataItem) == false) goto L18;
        DataItem other = (DataItem) object;
        if (this.tag == null) goto L13;
        if (this.tag.equals(other.tag) == true) goto L9;
        return false;
    L9:
        if (this.majorType == other.majorType) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (other.tag == null) goto L15;
        return false;
    L15:
        if (this.majorType == other.majorType) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.majorType, this.tag});
    }

    protected void assertTrue(boolean condition, String message) {
        if (condition == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(message);
    }
}
