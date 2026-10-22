package V4;

import com.stepos.common.ChatContentType;

/* renamed from: V4.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0258e extends AbstractC0262i {
    public final String b;
    public final String c;
    public final Long d;
    public final String e;
    public final String f;
    public final ChatContentType g;

    public C0258e(String str, int i, Long l, String str2, String str3) {
        str2 = (i & 8) != 0 ? null : str2;
        l = (i & 16) != 0 ? null : l;
        this.b = str;
        this.c = str2;
        this.d = l;
        this.e = str3;
        this.f = "";
        this.g = ChatContentType.e;
    }

    @Override // V4.AbstractC0262i
    public final ChatContentType a() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0258e)) {
            return false;
        }
        C0258e c0258e = (C0258e) obj;
        c0258e.getClass();
        return kotlin.jvm.internal.k.b(this.b, c0258e.b) && kotlin.jvm.internal.k.b(this.c, c0258e.c) && kotlin.jvm.internal.k.b(this.d, c0258e.d) && kotlin.jvm.internal.k.b(this.e, c0258e.e) && kotlin.jvm.internal.k.b(this.f, c0258e.f);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 961;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.d;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("File(fileId=null, uri=", this.b, ", url=null, fileName=", this.c, ", fileSize=");
        sbW.append(this.d);
        sbW.append(", mimeType=");
        sbW.append(this.e);
        sbW.append(", displayName=");
        return B7.a.q(sbW, this.f, ")");
    }
}
