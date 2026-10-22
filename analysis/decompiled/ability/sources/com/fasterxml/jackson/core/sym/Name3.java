package com.fasterxml.jackson.core.sym;

/* loaded from: classes2.dex */
public final class Name3 extends Name {
    private final int q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2262q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f2263q3;

    public Name3(String str, int i, int i6, int i10, int i11) {
        super(str, i);
        this.q1 = i6;
        this.f2262q2 = i10;
        this.f2263q3 = i11;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i6, int i10) {
        return this.q1 == i && this.f2262q2 == i6 && this.f2263q3 == i10;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.q1 && iArr[1] == this.f2262q2 && iArr[2] == this.f2263q3;
    }
}
