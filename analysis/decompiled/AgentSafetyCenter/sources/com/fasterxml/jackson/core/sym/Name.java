package com.fasterxml.jackson.core.sym;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class Name {
    protected final int _hashCode;
    protected final String _name;

    public Name(String str, int i) {
        this._name = str;
        this._hashCode = i;
    }

    public abstract boolean equals(int i);

    public abstract boolean equals(int i, int i3);

    public abstract boolean equals(int i, int i3, int i10);

    public boolean equals(Object obj) {
        return obj == this;
    }

    public abstract boolean equals(int[] iArr, int i);

    public String getName() {
        return this._name;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._name;
    }
}
