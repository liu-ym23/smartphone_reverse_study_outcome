package de;

import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import yd.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public Reader f3322a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f3323b;

    /* renamed from: c, reason: collision with root package name */
    public int f3324c;

    /* renamed from: d, reason: collision with root package name */
    public int f3325d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3326e;

    /* renamed from: f, reason: collision with root package name */
    public int f3327f;

    /* renamed from: g, reason: collision with root package name */
    public int f3328g;

    /* renamed from: h, reason: collision with root package name */
    public int f3329h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public char[] f3330j;

    public static boolean d(int i) {
        if ((i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133) {
            return true;
        }
        if (i >= 160 && i <= 55295) {
            return true;
        }
        if (i < 57344 || i > 65533) {
            return i >= 65536 && i <= 1114111;
        }
        return true;
    }

    public final boolean a(int i) throws IOException {
        if (!this.f3326e && this.f3325d + i >= this.f3324c) {
            Reader reader = this.f3322a;
            char[] cArr = this.f3330j;
            try {
                int i3 = reader.read(cArr, 0, cArr.length - 1);
                if (i3 > 0) {
                    int i10 = this.f3324c;
                    int i11 = this.f3325d;
                    int i12 = i10 - i11;
                    this.f3323b = Arrays.copyOfRange(this.f3323b, i11, i10 + i3);
                    int i13 = i3 - 1;
                    if (Character.isHighSurrogate(cArr[i13])) {
                        if (reader.read(cArr, i3, 1) == -1) {
                            throw new a(this.f3327f + i3, cArr[i13], "The last char is HighSurrogate (no LowSurrogate detected).");
                        }
                        i3++;
                    }
                    int i14 = 32;
                    int iCharCount = 0;
                    while (iCharCount < i3) {
                        int iCodePointAt = Character.codePointAt(cArr, iCharCount);
                        this.f3323b[i12] = iCodePointAt;
                        if (d(iCodePointAt)) {
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            iCharCount = i3;
                            i14 = iCodePointAt;
                        }
                        i12++;
                    }
                    this.f3324c = i12;
                    this.f3325d = 0;
                    if (i14 != 32) {
                        throw new a((this.f3327f + i12) - 1, i14, "special characters are not allowed");
                    }
                } else {
                    this.f3326e = true;
                }
            } catch (IOException e10) {
                throw new c(e10);
            }
        }
        return this.f3325d + i < this.f3324c;
    }

    public final void b(int i) {
        for (int i3 = 0; i3 < i && a(0); i3++) {
            int[] iArr = this.f3323b;
            int i10 = this.f3325d;
            this.f3325d = i10 + 1;
            int i11 = iArr[i10];
            this.f3327f++;
            this.f3328g++;
            if (fe.a.f4070d.a(i11) || (i11 == 13 && a(0) && this.f3323b[this.f3325d] != 10)) {
                this.f3329h++;
                this.i = 0;
            } else if (i11 != 65279) {
                this.i++;
            }
        }
    }

    public final yd.a c() {
        int i = this.f3327f;
        int i3 = this.f3329h;
        int i10 = this.i;
        int[] iArr = this.f3323b;
        int i11 = this.f3325d;
        yd.a aVar = new yd.a();
        aVar.f16119c = i;
        aVar.f16120f = i3;
        aVar.f16121g = i10;
        aVar.f16122h = iArr;
        aVar.i = i11;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public final int e() {
        if (a(0)) {
            return this.f3323b[this.f3325d];
        }
        return 0;
    }

    public final int f(int i) {
        if (a(i)) {
            return this.f3323b[this.f3325d + i];
        }
        return 0;
    }

    public final String g(int i) throws IOException {
        if (i == 0) {
            return "";
        }
        boolean zA = a(i);
        int[] iArr = this.f3323b;
        if (zA) {
            return new String(iArr, this.f3325d, i);
        }
        int i3 = this.f3325d;
        return new String(iArr, i3, Math.min(i, this.f3324c - i3));
    }

    public final String h(int i) throws IOException {
        String strG = g(i);
        this.f3325d += i;
        this.f3327f += i;
        this.f3328g += i;
        this.i += i;
        return strG;
    }
}
