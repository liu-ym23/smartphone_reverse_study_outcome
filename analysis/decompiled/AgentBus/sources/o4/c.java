package o4;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f7301a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7302b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f7303c;

    public c(String str, byte[] bArr, byte[] bArr2) {
        q7.k.e(str, "deviceId");
        this.f7301a = str;
        this.f7302b = bArr;
        this.f7303c = bArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q7.k.a(this.f7301a, cVar.f7301a) && Arrays.equals(this.f7302b, cVar.f7302b) && Arrays.equals(this.f7303c, cVar.f7303c);
    }

    public final int hashCode() {
        return this.f7301a.hashCode();
    }

    public final String toString() {
        String string = Arrays.toString(this.f7302b);
        return a1.a.m(a1.a.p("DeviceIdentity(deviceId=", this.f7301a, ", publicKey=", string, ", privateKey="), Arrays.toString(this.f7303c), ")");
    }
}
