package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Special extends DataItem {
    public static final Special BREAK = null;
    private final SpecialType specialType;

    static {
        BREAK = new Special(SpecialType.BREAK);
    }

    protected Special(SpecialType specialType) {
        super(MajorType.SPECIAL);
        specialType.getClass();
        this.specialType = specialType;
    }

    public SpecialType getSpecialType() {
        return this.specialType;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof Special) == false) goto L10;
        Special other = (Special) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.specialType != other.specialType) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ Objects.hashCode(this.specialType);
    }

    public String toString() {
        return this.specialType.name();
    }
}
