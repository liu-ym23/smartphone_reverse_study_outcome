package O9;

import ea.C4018b;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f5290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5291b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5292c;

    public c(int i10, int i11, int i12) {
        this.f5290a = i10;
        this.f5291b = i11;
        this.f5292c = i12;
    }

    public final int a() {
        return this.f5291b;
    }

    public final int b() {
        return this.f5290a;
    }

    public final int c() {
        return this.f5292c;
    }

    public final boolean d(int i10) {
        return ((i10 >>> this.f5290a) & ((1 << this.f5291b) - 1)) == this.f5292c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(C4018b.d<?> field, int i10) {
        this(field.f32401a, field.f32402b, i10);
        p.i(field, "field");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(C4018b.C0396b field) {
        this(field, 1);
        p.i(field, "field");
    }
}
