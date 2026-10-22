package aa;

import p9.InterfaceC5074l;

/* renamed from: aa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1255c implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f8115a;

    /* renamed from: b, reason: collision with root package name */
    public final C1261i[] f8116b;

    public C1255c(p0 p0Var, C1261i[] c1261iArr) {
        this.f8115a = p0Var;
        this.f8116b = c1261iArr;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return AbstractC1257e.h(this.f8115a, this.f8116b, ((Number) obj).intValue());
    }
}
