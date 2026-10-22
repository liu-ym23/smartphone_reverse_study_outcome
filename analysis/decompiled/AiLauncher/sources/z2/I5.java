package z2;

import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;

/* loaded from: classes2.dex */
public final class I5 {

    /* renamed from: a, reason: collision with root package name */
    public Long f44700a;

    /* renamed from: b, reason: collision with root package name */
    public zzrb f44701b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f44702c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f44703d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f44704e;

    public final I5 a(Boolean bool) {
        this.f44703d = bool;
        return this;
    }

    public final I5 b(Boolean bool) {
        this.f44704e = bool;
        return this;
    }

    public final I5 c(Long l10) {
        this.f44700a = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final I5 d(zzrb zzrbVar) {
        this.f44701b = zzrbVar;
        return this;
    }

    public final I5 e(Boolean bool) {
        this.f44702c = bool;
        return this;
    }

    public final K5 f() {
        return new K5(this, null);
    }
}
