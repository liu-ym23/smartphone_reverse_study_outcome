package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class NameN extends Name {

    /* renamed from: q, reason: collision with root package name */
    private final int[] f2264q;
    private final int q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2265q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f2266q3;

    /* renamed from: q4, reason: collision with root package name */
    private final int f2267q4;
    private final int qlen;

    public NameN(String str, int i, int i6, int i10, int i11, int i12, int[] iArr, int i13) {
        super(str, i);
        this.q1 = i6;
        this.f2265q2 = i10;
        this.f2266q3 = i11;
        this.f2267q4 = i12;
        this.f2264q = iArr;
        this.qlen = i13;
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i6 = 0; i6 < i; i6++) {
            if (iArr[i6 + 4] != this.f2264q[i6]) {
                return false;
            }
        }
        return true;
    }

    public static NameN construct(String str, int i, int[] iArr, int i6) {
        if (i6 >= 4) {
            return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i6 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i6) : null, i6);
        }
        throw new IllegalArgumentException();
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
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        if (i != this.qlen || iArr[0] != this.q1 || iArr[1] != this.f2265q2 || iArr[2] != this.f2266q3 || iArr[3] != this.f2267q4) {
            return false;
        }
        switch (i) {
            case 8:
                if (iArr[7] != this.f2264q[3]) {
                }
                break;
            case 7:
                if (iArr[6] != this.f2264q[2]) {
                }
                break;
            case 6:
                if (iArr[5] != this.f2264q[1]) {
                }
                break;
            case 5:
                if (iArr[4] != this.f2264q[0]) {
                }
                break;
            case 4:
                return true;
        }
        return false;
    }
}
