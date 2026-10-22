package h3;

import n3.InterfaceC4938b;

/* renamed from: h3.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C4133i implements InterfaceC4938b {

    /* renamed from: a, reason: collision with root package name */
    public final C4137m f32910a;

    /* renamed from: b, reason: collision with root package name */
    public final C4127c f32911b;

    public C4133i(C4137m c4137m, C4127c c4127c) {
        this.f32910a = c4137m;
        this.f32911b = c4127c;
    }

    public static InterfaceC4938b a(C4137m c4137m, C4127c c4127c) {
        return new C4133i(c4137m, c4127c);
    }

    @Override // n3.InterfaceC4938b
    public Object get() {
        C4137m c4137m = this.f32910a;
        C4127c c4127c = this.f32911b;
        return c4127c.d().a(new x(c4127c, c4137m));
    }
}
