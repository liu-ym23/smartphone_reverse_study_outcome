package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AbstractFloat extends Special {
    private final float value;

    public AbstractFloat(SpecialType specialType, float value) {
        super(specialType);
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    @Override // co.nstant.in.cbor.model.Special, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof AbstractFloat) == false) goto L10;
        AbstractFloat other = (AbstractFloat) object;
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
        return super.hashCode() ^ Objects.hashCode(Float.valueOf(this.value));
    }
}
