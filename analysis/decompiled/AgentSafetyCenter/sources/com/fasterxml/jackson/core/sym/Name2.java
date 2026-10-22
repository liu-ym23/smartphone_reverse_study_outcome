package com.fasterxml.jackson.core.sym;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Name2 extends Name {

    /* renamed from: q1, reason: collision with root package name */
    private final int f2294q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2295q2;

    public Name2(String str, int i, int i3, int i10) {
        super(str, i);
        this.f2294q1 = i3;
        this.f2295q2 = i10;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f2294q1 && iArr[1] == this.f2295q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3, int i10) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3) {
        return i == this.f2294q1 && i3 == this.f2295q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }
}
