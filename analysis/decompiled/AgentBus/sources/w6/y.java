package w6;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f10854a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10855b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f10856c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10857d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10858e;

    public y(long j2, String str, String str2, String str3, byte[] bArr) {
        q7.k.e(str, "appId");
        q7.k.e(str2, "deviceId");
        q7.k.e(bArr, "deviceSk");
        q7.k.e(str3, "encryptedAesKey");
        this.f10854a = str;
        this.f10855b = str2;
        this.f10856c = bArr;
        this.f10857d = str3;
        this.f10858e = j2;
    }

    public static y copy$default(y yVar, String str, String str2, byte[] bArr, String str3, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yVar.f10854a;
        }
        if ((i2 & 2) != 0) {
            str2 = yVar.f10855b;
        }
        if ((i2 & 4) != 0) {
            bArr = yVar.f10856c;
        }
        byte[] bArr2 = bArr;
        if ((i2 & 8) != 0) {
            str3 = yVar.f10857d;
        }
        if ((i2 & 16) != 0) {
            j2 = yVar.f10858e;
        }
        yVar.getClass();
        q7.k.e(str, "appId");
        q7.k.e(str2, "deviceId");
        q7.k.e(bArr2, "deviceSk");
        q7.k.e(str3, "encryptedAesKey");
        return new y(j2, str, str2, str3, bArr2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return q7.k.a(this.f10854a, yVar.f10854a) && q7.k.a(this.f10855b, yVar.f10855b) && Arrays.equals(this.f10856c, yVar.f10856c) && q7.k.a(this.f10857d, yVar.f10857d) && this.f10858e == yVar.f10858e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10858e) + m.x.g(this.f10857d, (Arrays.hashCode(this.f10856c) + m.x.g(this.f10855b, this.f10854a.hashCode() * 31, 31)) * 31, 31);
    }

    public final String toString() {
        String string = Arrays.toString(this.f10856c);
        StringBuilder sbP = a1.a.p("SecureSession(appId=", this.f10854a, ", deviceId=", this.f10855b, ", deviceSk=");
        m.x.w(sbP, string, ", encryptedAesKey=", this.f10857d, ", idKey=");
        sbP.append(this.f10858e);
        sbP.append(")");
        return sbP.toString();
    }
}
