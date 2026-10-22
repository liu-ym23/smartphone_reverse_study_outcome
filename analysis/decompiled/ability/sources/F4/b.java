package F4;

import java.util.Arrays;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f541a;
    public final int b;
    public final boolean c;
    public final int d;
    public final Object e;
    public final byte[] f;

    public b(int i, int i6, boolean z10, int i10, Object obj, byte[] bArr) {
        this.f541a = i;
        this.b = i6;
        this.c = z10;
        this.d = i10;
        this.e = obj;
        this.f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f541a == bVar.f541a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && k.b(this.e, bVar.e) && k.b(this.f, bVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.d, androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f541a) * 31, 31), 31, this.c), 31)) * 31;
        byte[] bArr = this.f;
        return iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public final String toString() {
        String string = Arrays.toString(this.f);
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f541a, "RecognitionResult(status=", this.b, ", soundModelHandle=", ", captureAvailable=");
        sbS.append(this.c);
        sbS.append(", captureSession=");
        sbS.append(this.d);
        sbS.append(", rawEvent=");
        sbS.append(this.e);
        sbS.append(", opaqueData=");
        sbS.append(string);
        sbS.append(")");
        return sbS.toString();
    }
}
