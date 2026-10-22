package z2;

import com.google.android.gms.internal.mlkit_vision_barcode.zzfd;

/* loaded from: classes2.dex */
public final class U implements Y {

    /* renamed from: a, reason: collision with root package name */
    public final int f44914a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfd f44915b;

    public U(int i10, zzfd zzfdVar) {
        this.f44914a = i10;
        this.f44915b = zzfdVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return Y.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y10 = (Y) obj;
        return this.f44914a == y10.zza() && this.f44915b.equals(y10.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f44914a ^ 14552422) + (this.f44915b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f44914a + "intEncoding=" + this.f44915b + ')';
    }

    @Override // z2.Y
    public final int zza() {
        return this.f44914a;
    }

    @Override // z2.Y
    public final zzfd zzb() {
        return this.f44915b;
    }
}
