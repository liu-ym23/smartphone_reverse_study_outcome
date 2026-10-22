package u3;

import l4.C0848a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final int f22907a;

    /* renamed from: b, reason: collision with root package name */
    private final int f22908b;

    /* renamed from: c, reason: collision with root package name */
    private final int f22909c;

    /* renamed from: d, reason: collision with root package name */
    private final float f22910d;

    /* renamed from: e, reason: collision with root package name */
    private final float f22911e;

    public j(int i5, int i6, int i7, float f5, float f6) {
        this.f22907a = i5;
        this.f22908b = i6;
        this.f22909c = i7;
        this.f22910d = f5;
        this.f22911e = f6;
    }

    public final int a(float f5) {
        return C0848a.a(this.f22907a + ((this.f22908b - r0) * f5));
    }

    public final int b(float f5) {
        float f6 = this.f22910d;
        return (this.f22909c & 16777215) | (C0848a.a((f6 + ((this.f22911e - f6) * f5)) * 255) << 24);
    }
}
