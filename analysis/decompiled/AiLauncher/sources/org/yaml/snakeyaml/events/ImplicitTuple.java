package org.yaml.snakeyaml.events;

/* loaded from: classes5.dex */
public class ImplicitTuple {
    private final boolean nonPlain;
    private final boolean plain;

    public ImplicitTuple(boolean z10, boolean z11) {
        this.plain = z10;
        this.nonPlain = z11;
    }

    public boolean bothFalse() {
        return (this.plain || this.nonPlain) ? false : true;
    }

    public boolean canOmitTagInNonPlainScalar() {
        return this.nonPlain;
    }

    public boolean canOmitTagInPlainScalar() {
        return this.plain;
    }

    public String toString() {
        return "implicit=[" + this.plain + ", " + this.nonPlain + "]";
    }
}
