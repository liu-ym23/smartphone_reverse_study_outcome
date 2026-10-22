package k4;

import java.util.Arrays;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d f5605a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5606b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f5607c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5608d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5609e;

    /* renamed from: f, reason: collision with root package name */
    public final String f5610f;

    public c(d dVar, byte[] bArr, Integer num, String str, String str2, String str3) {
        k.e(dVar, "kind");
        k.e(bArr, "rawBytes");
        this.f5605a = dVar;
        this.f5606b = bArr;
        this.f5607c = num;
        this.f5608d = str;
        this.f5609e = str2;
        this.f5610f = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5605a == cVar.f5605a && k.a(this.f5606b, cVar.f5606b) && k.a(this.f5607c, cVar.f5607c) && k.a(this.f5608d, cVar.f5608d) && k.a(this.f5609e, cVar.f5609e) && k.a(this.f5610f, cVar.f5610f);
    }

    public final int hashCode() {
        int iHashCode = (Arrays.hashCode(this.f5606b) + (this.f5605a.hashCode() * 31)) * 31;
        Integer num = this.f5607c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f5608d;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f5609e;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f5610f;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "Classified(kind=" + this.f5605a + ", rawBytes=" + Arrays.toString(this.f5606b) + ", authCode=" + this.f5607c + ", authError=" + this.f5608d + ", authUid=" + this.f5609e + ", resumeToken=" + this.f5610f + ")";
    }

    public /* synthetic */ c(d dVar, byte[] bArr, String str, int i2) {
        this(dVar, bArr, null, null, null, (i2 & 32) != 0 ? null : str);
    }
}
