package m0;

import android.text.TextUtils;

/* renamed from: m0.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1670d {

    /* renamed from: a, reason: collision with root package name */
    public String f5295a;
    public String b;
    public String c;
    public String d;
    public String e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1670d.class != obj.getClass()) {
            return false;
        }
        C1670d c1670d = (C1670d) obj;
        return TextUtils.equals(this.f5295a, c1670d.f5295a) && TextUtils.equals(this.b, c1670d.b) && TextUtils.equals(this.c, c1670d.c) && TextUtils.equals(this.d, c1670d.d) && TextUtils.equals(this.e, c1670d.e);
    }

    public final int hashCode() {
        String str = this.f5295a;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        int iHashCode2 = (str2 != null ? str2.hashCode() : 0) + iHashCode;
        String str3 = this.c;
        int iHashCode3 = (str3 != null ? str3.hashCode() : 0) + iHashCode2;
        String str4 = this.d;
        int iHashCode4 = (str4 != null ? str4.hashCode() : 0) + iHashCode3;
        String str5 = this.e;
        return (str5 != null ? str5.hashCode() : 0) + iHashCode4;
    }
}
