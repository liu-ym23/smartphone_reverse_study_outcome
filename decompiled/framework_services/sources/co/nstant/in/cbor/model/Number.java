package co.nstant.in.cbor.model;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class Number extends DataItem {
    private final BigInteger value;

    protected Number(MajorType majorType, BigInteger value) {
        super(majorType);
        value.getClass();
        this.value = value;
    }

    public BigInteger getValue() {
        return this.value;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof Number) == false) goto L10;
        Number other = (Number) object;
        if (super.equals(object) == true) goto L7;
        return false;
    L7:
        if (this.value.equals(other.value) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ this.value.hashCode();
    }

    public String toString() {
        return this.value.toString();
    }
}
