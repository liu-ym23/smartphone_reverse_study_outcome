package z2;

import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqi;

/* loaded from: classes2.dex */
public final class E5 {

    /* renamed from: a, reason: collision with root package name */
    public final zzqi f44641a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f44642b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f44643c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f44644d = null;

    public /* synthetic */ E5(C5 c52, D5 d52) {
        this.f44641a = c52.f44622a;
        this.f44642b = c52.f44623b;
    }

    @Y(zza = 1)
    public final zzqi a() {
        return this.f44641a;
    }

    @Y(zza = 2)
    public final Integer b() {
        return this.f44642b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof E5)) {
            return false;
        }
        E5 e52 = (E5) obj;
        return C1668i.a(this.f44641a, e52.f44641a) && C1668i.a(this.f44642b, e52.f44642b) && C1668i.a(null, null) && C1668i.a(null, null);
    }

    public final int hashCode() {
        return C1668i.b(this.f44641a, this.f44642b, null, null);
    }
}
