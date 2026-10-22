package com.fasterxml.jackson.core.sym;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Name1 extends Name {
    private static final Name1 EMPTY = new Name1("", 0, 0);

    /* renamed from: q, reason: collision with root package name */
    private final int f2293q;

    public Name1(String str, int i, int i3) {
        super(str, i);
        this.f2293q = i3;
    }

    public static Name1 getEmptyName() {
        return EMPTY;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.f2293q;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return i == this.f2293q;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3) {
        return i == this.f2293q && i3 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3, int i10) {
        return false;
    }
}
