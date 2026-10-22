package V4;

import com.stepos.common.ChatContentType;

/* renamed from: V4.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0259f extends AbstractC0262i {
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final ChatContentType f;

    public C0259f(String str, String str2, String str3, int i) {
        str2 = (i & 8) != 0 ? null : str2;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = "";
        this.f = ChatContentType.b;
    }

    @Override // V4.AbstractC0262i
    public final ChatContentType a() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0259f)) {
            return false;
        }
        C0259f c0259f = (C0259f) obj;
        c0259f.getClass();
        return kotlin.jvm.internal.k.b(this.b, c0259f.b) && kotlin.jvm.internal.k.b(this.c, c0259f.c) && kotlin.jvm.internal.k.b(this.d, c0259f.d) && kotlin.jvm.internal.k.b(this.e, c0259f.e);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 961;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 961;
        String str4 = this.e;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.p(B7.a.w("Image(fileId=null, uri=", this.b, ", base64=null, thumbnailUrl=", this.c, ", mimeType="), this.d, ", url=null, displayName=", this.e, ")");
    }
}
