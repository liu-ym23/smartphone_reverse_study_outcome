package D3;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2254a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2255b;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final char f2256a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2257b;

        /* renamed from: c, reason: collision with root package name */
        public final b f2258c;

        /* renamed from: d, reason: collision with root package name */
        public final int f2259d;

        public boolean e() {
            return this.f2256a == 1000;
        }

        public b(char c10, c cVar, int i10, b bVar, int i11) {
            char c11 = c10 == i11 ? (char) 1000 : c10;
            this.f2256a = c11;
            this.f2257b = i10;
            this.f2258c = bVar;
            int length = c11 == 1000 ? 1 : cVar.b(c10, i10).length;
            length = (bVar == null ? 0 : bVar.f2257b) != i10 ? length + 3 : length;
            this.f2259d = bVar != null ? length + bVar.f2259d : length;
        }
    }

    public e(String str, Charset charset, int i10) {
        this.f2255b = i10;
        c cVar = new c(str, charset, i10);
        if (cVar.g() != 1) {
            this.f2254a = e(str, cVar, i10);
            return;
        }
        this.f2254a = new int[str.length()];
        for (int i11 = 0; i11 < this.f2254a.length; i11++) {
            char cCharAt = str.charAt(i11);
            int[] iArr = this.f2254a;
            if (cCharAt == i10) {
                cCharAt = 1000;
            }
            iArr[i11] = cCharAt;
        }
    }

    public static void c(b[][] bVarArr, int i10, b bVar) {
        if (bVarArr[i10][bVar.f2257b] == null || bVarArr[i10][bVar.f2257b].f2259d > bVar.f2259d) {
            bVarArr[i10][bVar.f2257b] = bVar;
        }
    }

    public static void d(String str, c cVar, b[][] bVarArr, int i10, b bVar, int i11) {
        int i12;
        int iF;
        c cVar2;
        b bVar2;
        int i13;
        char cCharAt = str.charAt(i10);
        int iG = cVar.g();
        if (cVar.f() < 0 || !(cCharAt == i11 || cVar.a(cCharAt, cVar.f()))) {
            i12 = iG;
            iF = 0;
        } else {
            iF = cVar.f();
            i12 = iF + 1;
        }
        int i14 = iF;
        while (i14 < i12) {
            if (cCharAt == i11 || cVar.a(cCharAt, i14)) {
                cVar2 = cVar;
                bVar2 = bVar;
                i13 = i11;
                c(bVarArr, i10 + 1, new b(cCharAt, cVar2, i14, bVar2, i13));
            } else {
                cVar2 = cVar;
                bVar2 = bVar;
                i13 = i11;
            }
            i14++;
            cVar = cVar2;
            bVar = bVar2;
            i11 = i13;
        }
    }

    public static int[] e(String str, c cVar, int i10) {
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, cVar.g());
        d(str, cVar, bVarArr, 0, null, i10);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < cVar.g(); i12++) {
                b bVar = bVarArr[i11][i12];
                if (bVar != null && i11 < length) {
                    d(str, cVar, bVarArr, i11, bVar, i10);
                }
            }
            for (int i13 = 0; i13 < cVar.g(); i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < cVar.g(); i16++) {
            b bVar2 = bVarArr[length][i16];
            if (bVar2 != null && bVar2.f2259d < i15) {
                i15 = bVar2.f2259d;
                i14 = i16;
            }
        }
        if (i14 < 0) {
            throw new IllegalStateException("Failed to encode \"" + str + "\"");
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 = bVarArr[length][i14]; bVar3 != null; bVar3 = bVar3.f2258c) {
            if (bVar3.e()) {
                arrayList.add(0, 1000);
            } else {
                byte[] bArrB = cVar.b(bVar3.f2256a, bVar3.f2257b);
                for (int length2 = bArrB.length - 1; length2 >= 0; length2--) {
                    arrayList.add(0, Integer.valueOf(bArrB[length2] & 255));
                }
            }
            if ((bVar3.f2258c == null ? 0 : bVar3.f2258c.f2257b) != bVar3.f2257b) {
                arrayList.add(0, Integer.valueOf(cVar.e(bVar3.f2257b) + 256));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i17 = 0; i17 < size; i17++) {
            iArr[i17] = ((Integer) arrayList.get(i17)).intValue();
        }
        return iArr;
    }

    @Override // D3.d
    public boolean a(int i10) {
        if (i10 >= 0 && i10 < length()) {
            int i11 = this.f2254a[i10];
            return i11 > 255 && i11 <= 999;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // D3.d
    public int b(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (a(i10)) {
            return this.f2254a[i10] - 256;
        }
        throw new IllegalArgumentException("value at " + i10 + " is not an ECI but a character");
    }

    @Override // D3.d
    public char charAt(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (!a(i10)) {
            return (char) (h(i10) ? this.f2255b : this.f2254a[i10]);
        }
        throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
    }

    public int f() {
        return this.f2255b;
    }

    public boolean g(int i10, int i11) {
        if ((i10 + i11) - 1 >= this.f2254a.length) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (a(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i10) {
        if (i10 >= 0 && i10 < length()) {
            return this.f2254a[i10] == 1000;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // D3.d
    public int length() {
        return this.f2254a.length;
    }

    @Override // D3.d
    public CharSequence subSequence(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < i11) {
            if (a(i10)) {
                throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
            }
            sb2.append(charAt(i10));
            i10++;
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length(); i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (a(i10)) {
                sb2.append("ECI(");
                sb2.append(b(i10));
                sb2.append(')');
            } else if (charAt(i10) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i10));
                sb2.append('\'');
            } else {
                sb2.append((int) charAt(i10));
            }
        }
        return sb2.toString();
    }
}
