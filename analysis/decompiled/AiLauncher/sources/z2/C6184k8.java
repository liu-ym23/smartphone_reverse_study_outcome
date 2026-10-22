package z2;

import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;

/* renamed from: z2.k8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6184k8 {

    /* renamed from: a, reason: collision with root package name */
    public final zzcs f45047a;

    public /* synthetic */ C6184k8(C6164i8 c6164i8, C6174j8 c6174j8) {
        this.f45047a = c6164i8.f45034a;
    }

    @Y(zza = 1)
    public final zzcs a() {
        return this.f45047a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6184k8) {
            return C1668i.a(this.f45047a, ((C6184k8) obj).f45047a);
        }
        return false;
    }

    public final int hashCode() {
        return C1668i.b(this.f45047a);
    }
}
