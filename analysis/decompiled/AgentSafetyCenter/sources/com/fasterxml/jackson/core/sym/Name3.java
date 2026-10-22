package com.fasterxml.jackson.core.sym;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Name3 extends Name {

    /* renamed from: q1, reason: collision with root package name */
    private final int f2296q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2297q2;
    private final int q3;

    public Name3(String str, int i, int i3, int i10, int i11) {
        super(str, i);
        this.f2296q1 = i3;
        this.f2297q2 = i10;
        this.q3 = i11;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.f2296q1 && iArr[1] == this.f2297q2 && iArr[2] == this.q3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3, int i10) {
        return this.f2296q1 == i && this.f2297q2 == i3 && this.q3 == i10;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }
}
