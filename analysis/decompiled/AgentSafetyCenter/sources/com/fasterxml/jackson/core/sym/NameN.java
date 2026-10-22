package com.fasterxml.jackson.core.sym;

import java.util.Arrays;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class NameN extends Name {

    /* renamed from: q, reason: collision with root package name */
    private final int[] f2298q;

    /* renamed from: q1, reason: collision with root package name */
    private final int f2299q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f2300q2;
    private final int q3;

    /* renamed from: q4, reason: collision with root package name */
    private final int f2301q4;
    private final int qlen;

    public NameN(String str, int i, int i3, int i10, int i11, int i12, int[] iArr, int i13) {
        super(str, i);
        this.f2299q1 = i3;
        this.f2300q2 = i10;
        this.q3 = i11;
        this.f2301q4 = i12;
        this.f2298q = iArr;
        this.qlen = i13;
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3 + 4] != this.f2298q[i3]) {
                return false;
            }
        }
        return true;
    }

    public static NameN construct(String str, int i, int[] iArr, int i3) {
        if (i3 >= 4) {
            return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i3 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i3) : null, i3);
        }
        f.b();
        return null;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        if (i != this.qlen || iArr[0] != this.f2299q1 || iArr[1] != this.f2300q2 || iArr[2] != this.q3 || iArr[3] != this.f2301q4) {
            return false;
        }
        switch (i) {
            case 8:
                if (iArr[7] != this.f2298q[3]) {
                }
                break;
            case 7:
                if (iArr[6] != this.f2298q[2]) {
                }
                break;
            case 6:
                if (iArr[5] != this.f2298q[1]) {
                }
                break;
            case 5:
                if (iArr[4] != this.f2298q[0]) {
                }
                break;
            case 4:
                return true;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i3, int i10) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }
}
