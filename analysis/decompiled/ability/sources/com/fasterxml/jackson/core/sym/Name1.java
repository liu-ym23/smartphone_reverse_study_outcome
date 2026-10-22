package com.fasterxml.jackson.core.sym;

/* loaded from: classes2.dex */
public final class Name1 extends Name {
    private static final Name1 EMPTY = new Name1("", 0, 0);

    /* renamed from: q, reason: collision with root package name */
    private final int f2260q;

    public Name1(String str, int i, int i6) {
        super(str, i);
        this.f2260q = i6;
    }

    public static Name1 getEmptyName() {
        return EMPTY;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6, int i10) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return i == this.f2260q;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6) {
        return i == this.f2260q && i6 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.f2260q;
    }
}
