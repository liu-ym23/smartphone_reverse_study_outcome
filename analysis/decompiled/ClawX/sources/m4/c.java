package m4;

import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements CharSequence, Appendable {

    /* renamed from: a, reason: collision with root package name */
    public final a5.e f3900a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f3901b;

    /* renamed from: c, reason: collision with root package name */
    public char[] f3902c;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3903e;

    /* renamed from: f, reason: collision with root package name */
    public int f3904f;

    /* renamed from: g, reason: collision with root package name */
    public int f3905g;

    public c() {
        a5.e pool = e.f3906a;
        p.e(pool, "pool");
        this.f3900a = pool;
    }

    public final char[] a(int i8) {
        ArrayList arrayList = this.f3901b;
        if (arrayList != null) {
            char[] cArr = this.f3902c;
            p.b(cArr);
            return (char[]) arrayList.get(i8 / cArr.length);
        }
        if (i8 >= 2048) {
            e(i8);
            throw null;
        }
        char[] cArr2 = this.f3902c;
        if (cArr2 != null) {
            return cArr2;
        }
        e(i8);
        throw null;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c3) {
        char[] cArrD = d();
        char[] cArr = this.f3902c;
        p.b(cArr);
        int length = cArr.length;
        int i8 = this.f3904f;
        cArrD[length - i8] = c3;
        this.d = null;
        this.f3904f = i8 - 1;
        this.f3905g++;
        return this;
    }

    public final CharSequence b(int i8, int i9) {
        if (i8 == i9) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        StringBuilder sb = new StringBuilder(i9 - i8);
        for (int i10 = i8 - (i8 % 2048); i10 < i9; i10 += 2048) {
            char[] cArrA = a(i10);
            int iMin = Math.min(i9 - i10, 2048);
            for (int iMax = Math.max(0, i8 - i10); iMax < iMin; iMax++) {
                sb.append(cArrA[iMax]);
            }
        }
        return sb;
    }

    public final char c(int i8) {
        char[] cArrA = a(i8);
        char[] cArr = this.f3902c;
        p.b(cArr);
        return cArrA[i8 % cArr.length];
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "index is negative: ").toString());
        }
        if (i8 < this.f3905g) {
            return c(i8);
        }
        StringBuilder sbS = a8.b.s(i8, "index ", " is not in range [0, ");
        sbS.append(this.f3905g);
        sbS.append(')');
        throw new IllegalArgumentException(sbS.toString().toString());
    }

    public final char[] d() {
        if (this.f3904f != 0) {
            char[] cArr = this.f3902c;
            p.b(cArr);
            return cArr;
        }
        char[] cArr2 = (char[]) this.f3900a.p();
        char[] cArr3 = this.f3902c;
        this.f3902c = cArr2;
        this.f3904f = cArr2.length;
        this.f3903e = false;
        if (cArr3 != null) {
            ArrayList arrayList = this.f3901b;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f3901b = arrayList;
                arrayList.add(cArr3);
            }
            arrayList.add(cArr2);
        }
        return cArr2;
    }

    public final void e(int i8) {
        if (this.f3903e) {
            throw new IllegalStateException("Buffer is already released");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i8);
        sb.append(" is not in range [0; ");
        char[] cArr = this.f3902c;
        p.b(cArr);
        sb.append(cArr.length - this.f3904f);
        sb.append(')');
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (this.f3905g == charSequence.length()) {
                int i8 = this.f3905g;
                for (int i9 = 0; i9 < i8; i9++) {
                    if (c(i9) != charSequence.charAt(i9)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.d;
        if (str != null) {
            return str.hashCode();
        }
        int i8 = this.f3905g;
        int iC = 0;
        for (int i9 = 0; i9 < i8; i9++) {
            iC = (iC * 31) + c(i9);
        }
        return iC;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3905g;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        if (i8 > i9) {
            throw new IllegalArgumentException(("startIndex (" + i8 + ") should be less or equal to endIndex (" + i9 + ')').toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "startIndex is negative: ").toString());
        }
        if (i9 <= this.f3905g) {
            return new b(this, i8, i9);
        }
        StringBuilder sbS = a8.b.s(i9, "endIndex (", ") is greater than length (");
        sbS.append(this.f3905g);
        sbS.append(')');
        throw new IllegalArgumentException(sbS.toString().toString());
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String string = b(0, this.f3905g).toString();
        this.d = string;
        return string;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i8, int i9) {
        if (charSequence == null) {
            return this;
        }
        int i10 = i8;
        while (i10 < i9) {
            char[] cArrD = d();
            int length = cArrD.length;
            int i11 = this.f3904f;
            int i12 = length - i11;
            int iMin = Math.min(i9 - i10, i11);
            for (int i13 = 0; i13 < iMin; i13++) {
                cArrD[i12 + i13] = charSequence.charAt(i10 + i13);
            }
            i10 += iMin;
            this.f3904f -= iMin;
        }
        this.d = null;
        this.f3905g = (i9 - i8) + this.f3905g;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }
}
