package z2;

import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;

/* renamed from: z2.n0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6206n0 {

    /* renamed from: a, reason: collision with root package name */
    public final zzrb f45061a;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f45063c;

    /* renamed from: e, reason: collision with root package name */
    public final C6184k8 f45065e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcs f45066f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcs f45067g;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f45062b = null;

    /* renamed from: d, reason: collision with root package name */
    public final E5 f45064d = null;

    public /* synthetic */ C6206n0(C6186l0 c6186l0, C6196m0 c6196m0) {
        this.f45061a = c6186l0.f45048a;
        this.f45063c = c6186l0.f45049b;
        this.f45065e = c6186l0.f45050c;
        this.f45066f = c6186l0.f45051d;
        this.f45067g = c6186l0.f45052e;
    }

    @Y(zza = 6)
    public final zzcs a() {
        return this.f45066f;
    }

    @Y(zza = 7)
    public final zzcs b() {
        return this.f45067g;
    }

    @Y(zza = 1)
    public final zzrb c() {
        return this.f45061a;
    }

    @Y(zza = 5)
    public final C6184k8 d() {
        return this.f45065e;
    }

    @Y(zza = 3)
    public final Boolean e() {
        return this.f45063c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C6206n0)) {
            return false;
        }
        C6206n0 c6206n0 = (C6206n0) obj;
        return C1668i.a(this.f45061a, c6206n0.f45061a) && C1668i.a(null, null) && C1668i.a(this.f45063c, c6206n0.f45063c) && C1668i.a(null, null) && C1668i.a(this.f45065e, c6206n0.f45065e) && C1668i.a(this.f45066f, c6206n0.f45066f) && C1668i.a(this.f45067g, c6206n0.f45067g);
    }

    public final int hashCode() {
        return C1668i.b(this.f45061a, null, this.f45063c, null, this.f45065e, this.f45066f, this.f45067g);
    }
}
