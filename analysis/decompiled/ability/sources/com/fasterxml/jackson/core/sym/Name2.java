package com.fasterxml.jackson.core.sym;

/* loaded from: classes2.dex */
public final class Name2 extends Name {
    private final int q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2261q2;

    public Name2(String str, int i, int i6, int i10) {
        super(str, i);
        this.q1 = i6;
        this.f2261q2 = i10;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6, int i10) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6) {
        return i == this.q1 && i6 == this.f2261q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.q1 && iArr[1] == this.f2261q2;
    }
}
