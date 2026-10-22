package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DoublePrecisionFloat extends Special {
    private final double value;

    public DoublePrecisionFloat(double value) {
        super(SpecialType.IEEE_754_DOUBLE_PRECISION_FLOAT);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override // co.nstant.in.cbor.model.Special, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof DoublePrecisionFloat) == false) goto L10;
        DoublePrecisionFloat other = (DoublePrecisionFloat) object;
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

    @Override // co.nstant.in.cbor.model.Special, co.nstant.in.cbor.model.DataItem
    public int hashCode() {
        return super.hashCode() ^ Objects.hashCode(Double.valueOf(this.value));
    }

    @Override // co.nstant.in.cbor.model.Special
    public String toString() {
        return String.valueOf(this.value);
    }
}
