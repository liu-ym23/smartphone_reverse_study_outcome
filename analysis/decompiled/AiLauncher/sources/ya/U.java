package ya;

import java.util.List;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public class U implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f44050a;

    /* renamed from: b, reason: collision with root package name */
    public final List f44051b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f44052c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f44053d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5238k f44054e;

    public U(v0 v0Var, List list, s0 s0Var, boolean z10, InterfaceC5238k interfaceC5238k) {
        this.f44050a = v0Var;
        this.f44051b = list;
        this.f44052c = s0Var;
        this.f44053d = z10;
        this.f44054e = interfaceC5238k;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return V.q(this.f44050a, this.f44051b, this.f44052c, this.f44053d, this.f44054e, (kotlin.reflect.jvm.internal.impl.types.checker.c) obj);
    }
}
