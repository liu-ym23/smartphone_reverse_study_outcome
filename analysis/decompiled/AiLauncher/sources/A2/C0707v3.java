package A2;

import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.gms.internal.mlkit_vision_common.zzio;

/* renamed from: A2.v3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0707v3 {

    /* renamed from: a, reason: collision with root package name */
    public Long f1044a;

    /* renamed from: b, reason: collision with root package name */
    public zzio f1045b;

    /* renamed from: c, reason: collision with root package name */
    public zzii f1046c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f1047d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f1048e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f1049f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f1050g;

    public final C0707v3 b(Long l10) {
        this.f1044a = Long.valueOf(l10.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final C0707v3 c(Integer num) {
        this.f1047d = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final C0707v3 d(zzii zziiVar) {
        this.f1046c = zziiVar;
        return this;
    }

    public final C0707v3 e(Integer num) {
        this.f1049f = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final C0707v3 f(zzio zzioVar) {
        this.f1045b = zzioVar;
        return this;
    }

    public final C0707v3 g(Integer num) {
        this.f1048e = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final C0707v3 h(Integer num) {
        this.f1050g = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final C0719x3 j() {
        return new C0719x3(this, null);
    }
}
