package co.nstant.in.cbor.model;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SimpleValue extends Special {
    public static final SimpleValue FALSE = null;
    public static final SimpleValue NULL = null;
    public static final SimpleValue TRUE = null;
    public static final SimpleValue UNDEFINED = null;
    private final SimpleValueType simpleValueType;
    private final int value;

    static {
        FALSE = new SimpleValue(SimpleValueType.FALSE);
        TRUE = new SimpleValue(SimpleValueType.TRUE);
        NULL = new SimpleValue(SimpleValueType.NULL);
        UNDEFINED = new SimpleValue(SimpleValueType.UNDEFINED);
    }

    public SimpleValue(SimpleValueType simpleValueType) {
        super(SpecialType.SIMPLE_VALUE);
        this.value = simpleValueType.getValue();
        this.simpleValueType = simpleValueType;
    }

    public SimpleValue(int value) {
        if (value > 23) goto L5;
        SpecialType r0 = SpecialType.SIMPLE_VALUE;
    L6:
        super(r0);
        this.value = value;
        this.simpleValueType = SimpleValueType.ofByte(value);
        return;
    L5:
        r0 = SpecialType.SIMPLE_VALUE_NEXT_BYTE;
        goto L6
    }

    public SimpleValueType getSimpleValueType() {
        return this.simpleValueType;
    }

    public int getValue() {
        return this.value;
    }

    @Override // co.nstant.in.cbor.model.Special, co.nstant.in.cbor.model.DataItem
    public boolean equals(Object object) {
        if ((object instanceof SimpleValue) == false) goto L10;
        SimpleValue other = (SimpleValue) object;
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
        return super.hashCode() ^ Objects.hashCode(Integer.valueOf(this.value));
    }

    @Override // co.nstant.in.cbor.model.Special
    public String toString() {
        return this.simpleValueType.toString();
    }
}
