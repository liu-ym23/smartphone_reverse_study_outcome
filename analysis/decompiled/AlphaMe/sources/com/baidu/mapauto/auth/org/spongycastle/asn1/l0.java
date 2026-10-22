package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class l0 extends r {

    /* renamed from: a, reason: collision with root package name */
    public final char[] f7731a;

    public l0(char[] cArr) {
        this.f7731a = cArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(30);
        pVar.b(this.f7731a.length * 2);
        int i4 = 0;
        while (true) {
            char[] cArr = this.f7731a;
            if (i4 == cArr.length) {
                return;
            }
            char c4 = cArr[i4];
            pVar.a((byte) (c4 >> '\b'));
            pVar.a((byte) c4);
            i4++;
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (this.f7731a.length * 2) + u1.a(this.f7731a.length * 2) + 1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        char[] cArr = this.f7731a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i4 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i4;
            }
            i4 = (i4 * 257) ^ cArr[length];
        }
    }

    public final String toString() {
        return new String(this.f7731a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof l0)) {
            return false;
        }
        char[] cArr = this.f7731a;
        char[] cArr2 = ((l0) rVar).f7731a;
        if (cArr != cArr2) {
            if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
                return false;
            }
            for (int i4 = 0; i4 != cArr.length; i4++) {
                if (cArr[i4] != cArr2[i4]) {
                    return false;
                }
            }
        }
        return true;
    }
}
