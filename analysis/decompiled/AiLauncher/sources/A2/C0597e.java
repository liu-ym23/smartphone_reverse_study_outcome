package A2;

import com.google.android.gms.internal.mlkit_vision_common.zzah;

/* renamed from: A2.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0597e implements InterfaceC0625i {

    /* renamed from: a, reason: collision with root package name */
    public final int f631a;

    /* renamed from: b, reason: collision with root package name */
    public final zzah f632b;

    public C0597e(int i10, zzah zzahVar) {
        this.f631a = i10;
        this.f632b = zzahVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return InterfaceC0625i.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC0625i)) {
            return false;
        }
        InterfaceC0625i interfaceC0625i = (InterfaceC0625i) obj;
        return this.f631a == interfaceC0625i.zza() && this.f632b.equals(interfaceC0625i.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f631a ^ 14552422) + (this.f632b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f631a + "intEncoding=" + this.f632b + ')';
    }

    @Override // A2.InterfaceC0625i
    public final int zza() {
        return this.f631a;
    }

    @Override // A2.InterfaceC0625i
    public final zzah zzb() {
        return this.f632b;
    }
}
