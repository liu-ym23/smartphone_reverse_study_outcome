package V4;

import com.stepos.common.ChatContentType;

/* renamed from: V4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0256c extends AbstractC0262i {
    public final String b;
    public final String c;
    public final String d = "";
    public final ChatContentType e = ChatContentType.c;

    public C0256c(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    @Override // V4.AbstractC0262i
    public final ChatContentType a() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0256c)) {
            return false;
        }
        C0256c c0256c = (C0256c) obj;
        c0256c.getClass();
        return kotlin.jvm.internal.k.b(this.b, c0256c.b) && kotlin.jvm.internal.k.b(this.c, c0256c.c) && kotlin.jvm.internal.k.b(this.d, c0256c.d);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return B7.a.q(B7.a.w("Audio(fileId=null, uri=", this.b, ", mimeType=", this.c, ", displayName="), this.d, ")");
    }
}
