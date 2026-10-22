package com.google.zxing.qrcode.encoder;

import com.autonavi.aps.amapapi.config.Const;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class MinimalEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final String f21839a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f21840b;

    /* renamed from: c, reason: collision with root package name */
    public final D3.c f21841c;

    /* renamed from: d, reason: collision with root package name */
    public final ErrorCorrectionLevel f21842d;

    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21843a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21843a = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21843a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21843a[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21843a[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21843a[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Mode f21844a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21845b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21846c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21847d;

        /* renamed from: e, reason: collision with root package name */
        public final b f21848e;

        /* renamed from: f, reason: collision with root package name */
        public final int f21849f;

        public /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i10, int i11, int i12, b bVar, L3.a aVar, a aVar2) {
            this(mode, i10, i11, i12, bVar, aVar);
        }

        public b(Mode mode, int i10, int i11, int i12, b bVar, L3.a aVar) {
            this.f21844a = mode;
            this.f21845b = i10;
            Mode mode2 = Mode.BYTE;
            int i13 = (mode == mode2 || bVar == null) ? i11 : bVar.f21846c;
            this.f21846c = i13;
            this.f21847d = i12;
            this.f21848e = bVar;
            boolean z10 = false;
            int characterCountBits = bVar != null ? bVar.f21849f : 0;
            if ((mode == mode2 && bVar == null && i13 != 0) || (bVar != null && i13 != bVar.f21846c)) {
                z10 = true;
            }
            characterCountBits = (bVar == null || mode != bVar.f21844a || z10) ? characterCountBits + mode.getCharacterCountBits(aVar) + 4 : characterCountBits;
            int i14 = a.f21843a[mode.ordinal()];
            if (i14 == 1) {
                characterCountBits += 13;
            } else if (i14 == 2) {
                characterCountBits += i12 == 1 ? 6 : 11;
            } else if (i14 == 3) {
                characterCountBits += i12 != 1 ? i12 == 2 ? 7 : 10 : 4;
            } else if (i14 == 4) {
                characterCountBits += MinimalEncoder.this.f21841c.c(MinimalEncoder.this.f21839a.substring(i10, i12 + i10), i11).length * 8;
                if (z10) {
                    characterCountBits += 12;
                }
            }
            this.f21849f = characterCountBits;
        }
    }

    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final List<a> f21851a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final L3.a f21852b;

        public final class a {

            /* renamed from: a, reason: collision with root package name */
            public final Mode f21854a;

            /* renamed from: b, reason: collision with root package name */
            public final int f21855b;

            /* renamed from: c, reason: collision with root package name */
            public final int f21856c;

            /* renamed from: d, reason: collision with root package name */
            public final int f21857d;

            public a(Mode mode, int i10, int i11, int i12) {
                this.f21854a = mode;
                this.f21855b = i10;
                this.f21856c = i11;
                this.f21857d = i12;
            }

            public final void d(D3.a aVar) throws WriterException {
                aVar.f(this.f21854a.getBits(), 4);
                if (this.f21857d > 0) {
                    aVar.f(e(), this.f21854a.getCharacterCountBits(c.this.f21852b));
                }
                if (this.f21854a == Mode.ECI) {
                    aVar.f(MinimalEncoder.this.f21841c.e(this.f21856c), 8);
                } else if (this.f21857d > 0) {
                    String str = MinimalEncoder.this.f21839a;
                    int i10 = this.f21855b;
                    com.google.zxing.qrcode.encoder.a.c(str.substring(i10, this.f21857d + i10), this.f21854a, aVar, MinimalEncoder.this.f21841c.d(this.f21856c));
                }
            }

            public final int e() {
                if (this.f21854a != Mode.BYTE) {
                    return this.f21857d;
                }
                D3.c cVar = MinimalEncoder.this.f21841c;
                String str = MinimalEncoder.this.f21839a;
                int i10 = this.f21855b;
                return cVar.c(str.substring(i10, this.f21857d + i10), this.f21856c).length;
            }

            public final int f(L3.a aVar) {
                int iE;
                int characterCountBits = this.f21854a.getCharacterCountBits(aVar);
                int i10 = characterCountBits + 4;
                int i11 = a.f21843a[this.f21854a.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        int i12 = this.f21857d;
                        return i10 + ((i12 / 2) * 11) + (i12 % 2 == 1 ? 6 : 0);
                    }
                    if (i11 == 3) {
                        int i13 = this.f21857d;
                        int i14 = i10 + ((i13 / 3) * 10);
                        int i15 = i13 % 3;
                        if (i15 == 1) {
                            i = 4;
                        } else if (i15 == 2) {
                            i = 7;
                        }
                        return i14 + i;
                    }
                    if (i11 != 4) {
                        return i11 != 5 ? i10 : characterCountBits + 12;
                    }
                    iE = e() * 8;
                } else {
                    iE = this.f21857d * 13;
                }
                return i10 + iE;
            }

            public final String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < str.length(); i10++) {
                    if (str.charAt(i10) < ' ' || str.charAt(i10) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i10));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f21854a);
                sb2.append('(');
                if (this.f21854a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f21841c.d(this.f21856c).displayName());
                } else {
                    String str = MinimalEncoder.this.f21839a;
                    int i10 = this.f21855b;
                    sb2.append(g(str.substring(i10, this.f21857d + i10)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        public c(L3.a aVar, b bVar) {
            int i10;
            int i11;
            int i12;
            b bVar2 = bVar;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (bVar2 == null) {
                    break;
                }
                int i15 = i13 + bVar2.f21847d;
                b bVar3 = bVar2.f21848e;
                boolean z10 = (bVar2.f21844a == Mode.BYTE && bVar3 == null && bVar2.f21846c != 0) || !(bVar3 == null || bVar2.f21846c == bVar3.f21846c);
                i10 = z10 ? 1 : i14;
                if (bVar3 == null || bVar3.f21844a != bVar2.f21844a || z10) {
                    this.f21851a.add(0, new a(bVar2.f21844a, bVar2.f21845b, bVar2.f21846c, i15));
                    i12 = 0;
                } else {
                    i12 = i15;
                }
                if (z10) {
                    this.f21851a.add(0, new a(Mode.ECI, bVar2.f21845b, bVar2.f21846c, 0));
                }
                i14 = i10;
                bVar2 = bVar3;
                i13 = i12;
            }
            if (MinimalEncoder.this.f21840b) {
                a aVar2 = this.f21851a.get(0);
                if (aVar2 != null) {
                    Mode mode = aVar2.f21854a;
                    int i16 = i14;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && i16 != 0) {
                        this.f21851a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f21851a.add(this.f21851a.get(0).f21854a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iF = aVar.f();
            int iOrdinal = MinimalEncoder.m(aVar).ordinal();
            if (iOrdinal == 0) {
                i11 = 9;
            } else if (iOrdinal != 1) {
                i10 = 27;
                i11 = 40;
            } else {
                i10 = 10;
                i11 = 26;
            }
            int iD = d(aVar);
            while (iF < i11 && !com.google.zxing.qrcode.encoder.a.v(iD, L3.a.e(iF), MinimalEncoder.this.f21842d)) {
                iF++;
            }
            while (iF > i10 && com.google.zxing.qrcode.encoder.a.v(iD, L3.a.e(iF - 1), MinimalEncoder.this.f21842d)) {
                iF--;
            }
            this.f21852b = L3.a.e(iF);
        }

        public void b(D3.a aVar) throws WriterException {
            Iterator<a> it = this.f21851a.iterator();
            while (it.hasNext()) {
                it.next().d(aVar);
            }
        }

        public int c() {
            return d(this.f21852b);
        }

        public final int d(L3.a aVar) {
            Iterator<a> it = this.f21851a.iterator();
            int iF = 0;
            while (it.hasNext()) {
                iF += it.next().f(aVar);
            }
            return iF;
        }

        public L3.a e() {
            return this.f21852b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f21851a) {
                if (aVar != null) {
                    sb2.append(Const.STR_MART_COMMA);
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    public MinimalEncoder(String str, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f21839a = str;
        this.f21840b = z10;
        this.f21841c = new D3.c(str, charset, -1);
        this.f21842d = errorCorrectionLevel;
    }

    public static c i(String str, L3.a aVar, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return new MinimalEncoder(str, charset, z10, errorCorrectionLevel).h(aVar);
    }

    public static int k(Mode mode) {
        int i10;
        if (mode == null || (i10 = a.f21843a[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    public static L3.a l(VersionSize versionSize) {
        int iOrdinal = versionSize.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? L3.a.e(40) : L3.a.e(26) : L3.a.e(9);
    }

    public static VersionSize m(L3.a aVar) {
        return aVar.f() <= 9 ? VersionSize.SMALL : aVar.f() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    public static boolean n(char c10) {
        return com.google.zxing.qrcode.encoder.a.p(c10) != -1;
    }

    public static boolean o(char c10) {
        return com.google.zxing.qrcode.encoder.a.s(String.valueOf(c10));
    }

    public static boolean p(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public void e(b[][][] bVarArr, int i10, b bVar) {
        b[] bVarArr2 = bVarArr[i10 + bVar.f21847d][bVar.f21846c];
        int iK = k(bVar.f21844a);
        b bVar2 = bVarArr2[iK];
        if (bVar2 == null || bVar2.f21849f > bVar.f21849f) {
            bVarArr2[iK] = bVar;
        }
    }

    public void f(L3.a aVar, b[][][] bVarArr, int i10, b bVar) {
        int i11;
        int iG = this.f21841c.g();
        int iF = this.f21841c.f();
        if (iF < 0 || !this.f21841c.a(this.f21839a.charAt(i10), iF)) {
            iF = 0;
        } else {
            iG = iF + 1;
        }
        int i12 = iG;
        for (int i13 = iF; i13 < i12; i13++) {
            if (this.f21841c.a(this.f21839a.charAt(i10), i13)) {
                e(bVarArr, i10, new b(this, Mode.BYTE, i10, i13, 1, bVar, aVar, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f21839a.charAt(i10))) {
            e(bVarArr, i10, new b(this, mode, i10, 0, 1, bVar, aVar, null));
        }
        int length = this.f21839a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        int i14 = 2;
        if (g(mode2, this.f21839a.charAt(i10))) {
            int i15 = i10 + 1;
            e(bVarArr, i10, new b(this, mode2, i10, 0, (i15 >= length || !g(mode2, this.f21839a.charAt(i15))) ? 1 : 2, bVar, aVar, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f21839a.charAt(i10))) {
            int i16 = i10 + 1;
            if (i16 >= length || !g(mode3, this.f21839a.charAt(i16))) {
                i11 = 1;
            } else {
                int i17 = i10 + 2;
                if (i17 < length && g(mode3, this.f21839a.charAt(i17))) {
                    i14 = 3;
                }
                i11 = i14;
            }
            e(bVarArr, i10, new b(this, mode3, i10, 0, i11, bVar, aVar, null));
        }
    }

    public boolean g(Mode mode, char c10) {
        int i10 = a.f21843a[mode.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 == 4 : p(c10) : n(c10) : o(c10);
    }

    public c h(L3.a aVar) throws WriterException {
        if (aVar != null) {
            c cVarJ = j(aVar);
            if (com.google.zxing.qrcode.encoder.a.v(cVarJ.c(), l(m(cVarJ.e())), this.f21842d)) {
                return cVarJ;
            }
            throw new WriterException("Data too big for version" + aVar);
        }
        L3.a[] aVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(aVarArr[0]), j(aVarArr[1]), j(aVarArr[2])};
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 3; i12++) {
            int iC = cVarArr[i12].c();
            if (com.google.zxing.qrcode.encoder.a.v(iC, aVarArr[i12], this.f21842d) && iC < i10) {
                i11 = i12;
                i10 = iC;
            }
        }
        if (i11 >= 0) {
            return cVarArr[i11];
        }
        throw new WriterException("Data too big for any version");
    }

    public c j(L3.a aVar) throws WriterException {
        int length = this.f21839a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f21841c.g(), 4);
        f(aVar, bVarArr, 0, null);
        for (int i10 = 1; i10 <= length; i10++) {
            for (int i11 = 0; i11 < this.f21841c.g(); i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    b bVar = bVarArr[i10][i11][i12];
                    if (bVar != null && i10 < length) {
                        f(aVar, bVarArr, i10, bVar);
                    }
                }
            }
        }
        int i13 = -1;
        int i14 = Integer.MAX_VALUE;
        int i15 = -1;
        for (int i16 = 0; i16 < this.f21841c.g(); i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                b bVar2 = bVarArr[length][i16][i17];
                if (bVar2 != null && bVar2.f21849f < i14) {
                    i14 = bVar2.f21849f;
                    i13 = i16;
                    i15 = i17;
                }
            }
        }
        if (i13 >= 0) {
            return new c(aVar, bVarArr[length][i13][i15]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f21839a + "\"");
    }
}
