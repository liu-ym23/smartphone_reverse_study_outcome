package com.google.zxing.datamatrix.encoder;

import D3.e;
import G3.j;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.chatui.view.AssistantImageCardView;
import com.stepos.datacenter.vector.EmbedProvider;
import io.ktor.util.date.GMTDateParser;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class MinimalEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f21813a = {'!', JsonFactory.DEFAULT_QUOTE_CHAR, '#', '$', '%', '&', '\'', '(', ')', GMTDateParser.ANY, '+', ',', '-', '.', JsonPointer.SEPARATOR, ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    public enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21814a;

        static {
            int[] iArr = new int[SymbolShapeHint.values().length];
            f21814a = iArr;
            try {
                iArr[SymbolShapeHint.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21814a[SymbolShapeHint.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class b {

        /* renamed from: g, reason: collision with root package name */
        public static final int[] f21815g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 204, AssistantImageCardView.MAX_WIDTH_DP, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: h, reason: collision with root package name */
        public static final int[] f21816h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, 144, 174, 204, AssistantImageCardView.MAX_WIDTH_DP, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: i, reason: collision with root package name */
        public static final int[] f21817i = {5, 10, 16, 33, 32, 49};

        /* renamed from: a, reason: collision with root package name */
        public final c f21818a;

        /* renamed from: b, reason: collision with root package name */
        public final Mode f21819b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21820c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21821d;

        /* renamed from: e, reason: collision with root package name */
        public final b f21822e;

        /* renamed from: f, reason: collision with root package name */
        public final int f21823f;

        public /* synthetic */ b(c cVar, Mode mode, int i10, int i11, b bVar, a aVar) {
            this(cVar, mode, i10, i11, bVar);
        }

        public static byte[] h(int i10) {
            return new byte[]{(byte) i10};
        }

        public static byte[] i(int i10, int i11) {
            return new byte[]{(byte) i10, (byte) i11};
        }

        public static int j(boolean z10, int i10, char c10, int i11) {
            if (c10 == i11) {
                return 27;
            }
            if (z10) {
                if (c10 <= 31) {
                    return c10;
                }
                if (c10 == ' ') {
                    return 3;
                }
                return c10 <= '/' ? c10 - '!' : c10 <= '9' ? c10 - ',' : c10 <= '@' ? c10 - '+' : c10 <= 'Z' ? c10 - '3' : c10 <= '_' ? c10 - 'E' : c10 <= 127 ? c10 - '`' : c10;
            }
            if (c10 == 0) {
                return 0;
            }
            if (i10 == 0 && c10 <= 3) {
                return c10 - 1;
            }
            if (i10 == 1 && c10 <= 31) {
                return c10;
            }
            if (c10 == ' ') {
                return 3;
            }
            if (c10 >= '!' && c10 <= '/') {
                return c10 - '!';
            }
            if (c10 >= '0' && c10 <= '9') {
                return c10 - ',';
            }
            if (c10 >= ':' && c10 <= '@') {
                return c10 - '+';
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                return c10 - '@';
            }
            if (c10 >= '[' && c10 <= '_') {
                return c10 - 'E';
            }
            if (c10 == '`') {
                return 0;
            }
            return (c10 < 'a' || c10 > 'z') ? (c10 < '{' || c10 > 127) ? c10 : c10 - '`' : c10 - 'S';
        }

        public static int v(char c10, boolean z10, int i10) {
            if (z10 && MinimalEncoder.l(c10)) {
                return 0;
            }
            if (!z10 && MinimalEncoder.n(c10)) {
                return 0;
            }
            if (z10 && MinimalEncoder.m(c10, i10)) {
                return 1;
            }
            return (z10 || !MinimalEncoder.o(c10, i10)) ? 2 : 1;
        }

        public static int w(char c10) {
            if (c10 == '\r') {
                return 0;
            }
            if (c10 == '*') {
                return 1;
            }
            if (c10 == '>') {
                return 2;
            }
            if (c10 == ' ') {
                return 3;
            }
            return (c10 < '0' || c10 > '9') ? (c10 < 'A' || c10 > 'Z') ? c10 : c10 - '3' : c10 - ',';
        }

        public static void y(byte[] bArr, int i10, int i11, int i12, int i13) {
            int i14 = ((i11 & 255) * EmbedProvider.DEFAULT_MAX_INPUT_CHARS) + ((i12 & 255) * 40) + (i13 & 255) + 1;
            bArr[i10] = (byte) (i14 / 256);
            bArr[i10 + 1] = (byte) (i14 % 256);
        }

        public int g() {
            int i10 = 0;
            while (this != null && this.f21819b == Mode.B256 && i10 <= 250) {
                i10++;
                this = this.f21822e;
            }
            return i10;
        }

        public byte[] k(boolean z10, int i10) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f21821d; i11++) {
                char cCharAt = this.f21818a.charAt(this.f21820c + i11);
                if ((z10 && j.h(cCharAt)) || (!z10 && j.j(cCharAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z10, 0, cCharAt, i10)));
                } else if (MinimalEncoder.k(cCharAt, i10)) {
                    char c10 = (char) ((cCharAt & 255) - 128);
                    if (!(z10 && j.h(c10)) && (z10 || !j.j(c10))) {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        int iV = v(c10, z10, i10);
                        arrayList.add(Byte.valueOf((byte) iV));
                        arrayList.add(Byte.valueOf((byte) j(z10, iV, c10, i10)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        arrayList.add(Byte.valueOf((byte) j(z10, 0, c10, i10)));
                    }
                } else {
                    int iV2 = v(cCharAt, z10, i10);
                    arrayList.add(Byte.valueOf((byte) iV2));
                    arrayList.add(Byte.valueOf((byte) j(z10, iV2, cCharAt, i10)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i12 = 0;
            for (int i13 = 0; i13 < arrayList.size(); i13 += 3) {
                y(bArr, i12, ((Byte) arrayList.get(i13)).byteValue() & 255, ((Byte) arrayList.get(i13 + 1)).byteValue() & 255, ((Byte) arrayList.get(i13 + 2)).byteValue() & 255);
                i12 += 2;
            }
            return bArr;
        }

        public int l(int i10) {
            return r(i10) - i10;
        }

        public byte[] m() {
            int iOrdinal = this.f21819b.ordinal();
            return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? new byte[0] : h(this.f21818a.charAt(this.f21820c)) : n() : x() : k(false, this.f21818a.f()) : k(true, this.f21818a.f()) : this.f21818a.a(this.f21820c) ? i(241, this.f21818a.b(this.f21820c) + 1) : MinimalEncoder.k(this.f21818a.charAt(this.f21820c), this.f21818a.f()) ? i(235, this.f21818a.charAt(this.f21820c) - 127) : this.f21821d == 2 ? h(((this.f21818a.charAt(this.f21820c) - '0') * 10) + this.f21818a.charAt(this.f21820c + 1) + 82) : this.f21818a.h(this.f21820c) ? h(232) : h(this.f21818a.charAt(this.f21820c) + 1);
        }

        public byte[] n() {
            int iCeil = (int) Math.ceil(this.f21821d / 4.0d);
            byte[] bArr = new byte[iCeil * 3];
            int i10 = this.f21820c;
            int iMin = Math.min((this.f21821d + i10) - 1, this.f21818a.length() - 1);
            for (int i11 = 0; i11 < iCeil; i11 += 3) {
                int[] iArr = new int[4];
                for (int i12 = 0; i12 < 4; i12++) {
                    if (i10 <= iMin) {
                        iArr[i12] = this.f21818a.charAt(i10) & '?';
                        i10++;
                    } else {
                        iArr[i12] = i10 == iMin + 1 ? 31 : 0;
                    }
                }
                int i13 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i11] = (byte) ((i13 >> 16) & 255);
                bArr[i11 + 1] = (byte) ((i13 >> 8) & 255);
                bArr[i11 + 2] = (byte) (i13 & 255);
            }
            return bArr;
        }

        public Mode o() {
            if (this.f21819b == Mode.EDF) {
                if (this.f21821d < 4) {
                    return Mode.ASCII;
                }
                int iP = p();
                if (iP > 0 && l(this.f21823f + iP) <= 2 - iP) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f21819b;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f21820c + this.f21821d >= this.f21818a.length() && l(this.f21823f) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f21823f + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f21819b;
        }

        public int p() {
            int length = this.f21818a.length();
            int i10 = this.f21820c + this.f21821d;
            int i11 = length - i10;
            if (i11 <= 4 && i10 < length) {
                if (i11 == 1) {
                    return MinimalEncoder.k(this.f21818a.charAt(i10), this.f21818a.f()) ? 0 : 1;
                }
                if (i11 == 2) {
                    if (!MinimalEncoder.k(this.f21818a.charAt(i10), this.f21818a.f())) {
                        int i12 = i10 + 1;
                        if (!MinimalEncoder.k(this.f21818a.charAt(i12), this.f21818a.f())) {
                            return (j.f(this.f21818a.charAt(i10)) && j.f(this.f21818a.charAt(i12))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i11 == 3) {
                    if (j.f(this.f21818a.charAt(i10)) && j.f(this.f21818a.charAt(i10 + 1)) && !MinimalEncoder.k(this.f21818a.charAt(i10 + 2), this.f21818a.f())) {
                        return 2;
                    }
                    return (j.f(this.f21818a.charAt(i10 + 1)) && j.f(this.f21818a.charAt(i10 + 2)) && !MinimalEncoder.k(this.f21818a.charAt(i10), this.f21818a.f())) ? 2 : 0;
                }
                if (j.f(this.f21818a.charAt(i10)) && j.f(this.f21818a.charAt(i10 + 1)) && j.f(this.f21818a.charAt(i10 + 2)) && j.f(this.f21818a.charAt(i10 + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] q() {
            /*
                r12 = this;
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r0 = r12.t()
                int r0 = r0.ordinal()
                r1 = 230(0xe6, float:3.22E-43)
                r2 = 239(0xef, float:3.35E-43)
                r3 = 238(0xee, float:3.34E-43)
                r4 = 240(0xf0, float:3.36E-43)
                r5 = 231(0xe7, float:3.24E-43)
                r6 = 5
                r7 = 4
                r8 = 3
                r9 = 2
                r10 = 1
                if (r0 == 0) goto L5f
                if (r0 == r10) goto L24
                if (r0 == r9) goto L24
                if (r0 == r8) goto L24
                if (r0 == r7) goto L6f
                if (r0 == r6) goto L5f
                goto L6f
            L24:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r0 = r12.f21819b
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r11 = r12.t()
                if (r0 == r11) goto L6f
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r12 = r12.f21819b
                int r12 = r12.ordinal()
                r0 = 254(0xfe, float:3.56E-43)
                if (r12 == 0) goto L5a
                if (r12 == r10) goto L55
                if (r12 == r9) goto L50
                if (r12 == r8) goto L4b
                if (r12 == r7) goto L46
                if (r12 == r6) goto L41
                goto L6f
            L41:
                byte[] r12 = i(r0, r5)
                return r12
            L46:
                byte[] r12 = i(r0, r4)
                return r12
            L4b:
                byte[] r12 = i(r0, r3)
                return r12
            L50:
                byte[] r12 = i(r0, r2)
                return r12
            L55:
                byte[] r12 = i(r0, r1)
                return r12
            L5a:
                byte[] r12 = h(r0)
                return r12
            L5f:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r12 = r12.f21819b
                int r12 = r12.ordinal()
                if (r12 == r10) goto L87
                if (r12 == r9) goto L82
                if (r12 == r8) goto L7d
                if (r12 == r7) goto L78
                if (r12 == r6) goto L73
            L6f:
                r12 = 0
                byte[] r12 = new byte[r12]
                return r12
            L73:
                byte[] r12 = h(r5)
                return r12
            L78:
                byte[] r12 = h(r4)
                return r12
            L7d:
                byte[] r12 = h(r3)
                return r12
            L82:
                byte[] r12 = h(r2)
                return r12
            L87:
                byte[] r12 = h(r1)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.b.q():byte[]");
        }

        public int r(int i10) {
            int i11 = a.f21814a[this.f21818a.l().ordinal()];
            if (i11 == 1) {
                for (int i12 : f21816h) {
                    if (i12 >= i10) {
                        return i12;
                    }
                }
            } else if (i11 == 2) {
                for (int i13 : f21817i) {
                    if (i13 >= i10) {
                        return i13;
                    }
                }
            }
            for (int i14 : f21815g) {
                if (i14 >= i10) {
                    return i14;
                }
            }
            int[] iArr = f21815g;
            return iArr[iArr.length - 1];
        }

        public Mode s() {
            return this.f21819b;
        }

        public Mode t() {
            b bVar = this.f21822e;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        public Mode u() {
            b bVar = this.f21822e;
            return bVar == null ? Mode.ASCII : bVar.f21819b;
        }

        public byte[] x() {
            int i10 = (this.f21821d / 3) * 2;
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                int i12 = (i11 / 2) * 3;
                y(bArr, i11, w(this.f21818a.charAt(this.f21820c + i12)), w(this.f21818a.charAt(this.f21820c + i12 + 1)), w(this.f21818a.charAt(this.f21820c + i12 + 2)));
            }
            return bArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0046 A[PHI: r11
          0x0046: PHI (r11v7 int) = (r11v4 int), (r11v4 int), (r11v4 int), (r11v10 int), (r11v10 int), (r11v18 int) binds: [B:77:0x00c1, B:79:0x00c5, B:81:0x00c9, B:58:0x0090, B:60:0x0094, B:26:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0056 A[PHI: r11
          0x0056: PHI (r11v12 int) = (r11v10 int), (r11v10 int), (r11v10 int), (r11v18 int), (r11v18 int), (r11v18 int) binds: [B:64:0x009b, B:66:0x009f, B:67:0x00a1, B:29:0x004c, B:31:0x0050, B:33:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b(com.google.zxing.datamatrix.encoder.MinimalEncoder.c r7, com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode r8, int r9, int r10, com.google.zxing.datamatrix.encoder.MinimalEncoder.b r11) {
            /*
                Method dump skipped, instructions count: 208
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.b.<init>(com.google.zxing.datamatrix.encoder.MinimalEncoder$c, com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode, int, int, com.google.zxing.datamatrix.encoder.MinimalEncoder$b):void");
        }
    }

    public static final class c extends e {

        /* renamed from: c, reason: collision with root package name */
        public final SymbolShapeHint f21824c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21825d;

        public /* synthetic */ c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11, a aVar) {
            this(str, charset, i10, symbolShapeHint, i11);
        }

        public final int k() {
            return this.f21825d;
        }

        public final SymbolShapeHint l() {
            return this.f21824c;
        }

        public c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
            super(str, charset, i10);
            this.f21824c = symbolShapeHint;
            this.f21825d = i11;
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f21826a;

        public d(b bVar) {
            int i10;
            c cVar = bVar.f21818a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i11 = 0;
            int iC = ((bVar.f21819b == Mode.C40 || bVar.f21819b == Mode.TEXT || bVar.f21819b == Mode.X12) && bVar.o() != Mode.ASCII) ? c(b.h(254), arrayList) : 0;
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f21822e) {
                iC += c(bVar2.m(), arrayList);
                if (bVar2.f21822e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (iC <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) iC));
                            i10 = iC + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (iC % 250)));
                            arrayList.add(0, Byte.valueOf((byte) ((iC / 250) + 249)));
                            i10 = iC + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i10));
                    }
                    c(bVar2.q(), arrayList);
                    iC = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.f() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i12)).intValue(), ((Integer) arrayList3.get(i12)).intValue());
            }
            int iR = bVar.r(arrayList.size());
            if (arrayList.size() < iR) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < iR) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f21826a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f21826a;
                if (i11 >= bArr.length) {
                    return;
                }
                bArr[i11] = ((Byte) arrayList.get(i11)).byteValue();
                i11++;
            }
        }

        public static void a(List<Byte> list, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i10 + i12;
                int iByteValue = (list.get(i13).byteValue() & 255) + (((i13 + 1) * 149) % 255) + 1;
                if (iByteValue > 255) {
                    iByteValue -= 256;
                }
                list.set(i13, Byte.valueOf((byte) iByteValue));
            }
        }

        public static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        public static int d(int i10) {
            int i11 = (i10 * 149) % 253;
            int i12 = i11 + 130;
            return i12 <= 254 ? i12 : i11 - 124;
        }

        public byte[] b() {
            return this.f21826a;
        }
    }

    public static void e(b[][] bVarArr, b bVar) {
        int i10 = bVar.f21820c + bVar.f21821d;
        if (bVarArr[i10][bVar.o().ordinal()] == null || bVarArr[i10][bVar.o().ordinal()].f21823f > bVar.f21823f) {
            bVarArr[i10][bVar.o().ordinal()] = bVar;
        }
    }

    public static void f(c cVar, b[][] bVarArr, int i10, b bVar) {
        if (cVar.a(i10)) {
            e(bVarArr, new b(cVar, Mode.ASCII, i10, 1, bVar, null));
            return;
        }
        char cCharAt = cVar.charAt(i10);
        int i11 = 0;
        if (bVar == null || bVar.o() != Mode.EDF) {
            if (j.f(cCharAt) && cVar.g(i10, 2) && j.f(cVar.charAt(i10 + 1))) {
                e(bVarArr, new b(cVar, Mode.ASCII, i10, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, Mode.ASCII, i10, 1, bVar, null));
            }
            Mode[] modeArr = {Mode.C40, Mode.TEXT};
            for (int i12 = 0; i12 < 2; i12++) {
                Mode mode = modeArr[i12];
                int[] iArr = new int[1];
                if (j(cVar, i10, mode == Mode.C40, iArr) > 0) {
                    e(bVarArr, new b(cVar, mode, i10, iArr[0], bVar, null));
                }
            }
            if (cVar.g(i10, 3) && j.k(cVar.charAt(i10)) && j.k(cVar.charAt(i10 + 1)) && j.k(cVar.charAt(i10 + 2))) {
                e(bVarArr, new b(cVar, Mode.X12, i10, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, Mode.B256, i10, 1, bVar, null));
        }
        while (i11 < 3) {
            int i13 = i10 + i11;
            if (!cVar.g(i13, 1) || !j.i(cVar.charAt(i13))) {
                break;
            }
            int i14 = i11 + 1;
            e(bVarArr, new b(cVar, Mode.EDF, i10, i14, bVar, null));
            i11 = i14;
        }
        if (i11 == 3 && cVar.g(i10, 4) && j.i(cVar.charAt(i10 + 3))) {
            e(bVarArr, new b(cVar, Mode.EDF, i10, 4, bVar, null));
        }
    }

    public static byte[] g(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
        return i(new c(str, charset, i10, symbolShapeHint, i11, null)).b();
    }

    public static String h(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint) {
        int i11;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i11 = 5;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i11 = 6;
        } else {
            i11 = 0;
        }
        return new String(g(str, charset, i10, symbolShapeHint, i11), StandardCharsets.ISO_8859_1);
    }

    public static d i(c cVar) {
        int length = cVar.length();
        int i10 = 0;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        f(cVar, bVarArr, 0, null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < 6; i12++) {
                b bVar = bVarArr[i11][i12];
                if (bVar != null && i11 < length) {
                    f(cVar, bVarArr, i11, bVar);
                }
            }
            for (int i13 = 0; i13 < 6; i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        while (i10 < 6) {
            b bVar2 = bVarArr[length][i10];
            if (bVar2 != null) {
                int i16 = (i10 < 1 || i10 > 3) ? bVar2.f21823f : bVar2.f21823f + 1;
                if (i16 < i15) {
                    i14 = i10;
                    i15 = i16;
                }
            }
            i10++;
        }
        if (i14 >= 0) {
            return new d(bVarArr[length][i14]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    public static int j(c cVar, int i10, boolean z10, int[] iArr) {
        int i11 = 0;
        for (int i12 = i10; i12 < cVar.length(); i12++) {
            if (cVar.a(i12)) {
                iArr[0] = 0;
                return 0;
            }
            char cCharAt = cVar.charAt(i12);
            if ((z10 && j.h(cCharAt)) || (!z10 && j.j(cCharAt))) {
                i11++;
            } else if (k(cCharAt, cVar.f())) {
                int i13 = cCharAt & 255;
                i11 = (i13 < 128 || (!(z10 && j.h((char) (i13 + (-128)))) && (z10 || !j.j((char) (i13 + (-128)))))) ? i11 + 4 : i11 + 3;
            } else {
                i11 += 2;
            }
            if (i11 % 3 == 0 || ((i11 - 2) % 3 == 0 && i12 + 1 == cVar.length())) {
                iArr[0] = (i12 - i10) + 1;
                return (int) Math.ceil(i11 / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    public static boolean k(char c10, int i10) {
        return c10 != i10 && c10 >= 128 && c10 <= 255;
    }

    public static boolean l(char c10) {
        return c10 <= 31;
    }

    public static boolean m(char c10, int i10) {
        for (char c11 : f21813a) {
            if (c11 == c10) {
                return true;
            }
        }
        return c10 == i10;
    }

    public static boolean n(char c10) {
        return l(c10);
    }

    public static boolean o(char c10, int i10) {
        return m(c10, i10);
    }
}
