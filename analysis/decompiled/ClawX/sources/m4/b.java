package m4;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public final int f3897a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3898b;

    /* renamed from: c, reason: collision with root package name */
    public String f3899c;
    public final /* synthetic */ c d;

    public b(c cVar, int i8, int i9) {
        this.d = cVar;
        this.f3897a = i8;
        this.f3898b = i9;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        int i9 = this.f3897a + i8;
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "index is negative: ").toString());
        }
        if (i9 < this.f3898b) {
            return this.d.c(i9);
        }
        StringBuilder sbS = a8.b.s(i8, "index (", ") should be less than length (");
        sbS.append(length());
        sbS.append(')');
        throw new IllegalArgumentException(sbS.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.length() == length()) {
                int length = length();
                for (int i8 = 0; i8 < length; i8++) {
                    if (this.d.c(this.f3897a + i8) != charSequence.charAt(i8)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f3899c;
        if (str != null) {
            return str.hashCode();
        }
        int iC = 0;
        for (int i8 = this.f3897a; i8 < this.f3898b; i8++) {
            iC = (iC * 31) + this.d.c(i8);
        }
        return iC;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3898b - this.f3897a;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "start is negative: ").toString());
        }
        if (i8 > i9) {
            throw new IllegalArgumentException(("start (" + i8 + ") should be less or equal to end (" + i9 + ')').toString());
        }
        int i10 = this.f3898b;
        int i11 = this.f3897a;
        if (i9 <= i10 - i11) {
            if (i8 == i9) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            return new b(this.d, i8 + i11, i11 + i9);
        }
        throw new IllegalArgumentException(("end should be less than length (" + length() + ')').toString());
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.f3899c;
        if (str != null) {
            return str;
        }
        String string = this.d.b(this.f3897a, this.f3898b).toString();
        this.f3899c = string;
        return string;
    }
}
