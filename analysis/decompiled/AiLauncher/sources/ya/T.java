package ya;

import java.util.List;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class T implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f44046a;

    /* renamed from: b, reason: collision with root package name */
    public final List f44047b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f44048c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f44049d;

    public T(v0 v0Var, List list, s0 s0Var, boolean z10) {
        this.f44046a = v0Var;
        this.f44047b = list;
        this.f44048c = s0Var;
        this.f44049d = z10;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return V.n(this.f44046a, this.f44047b, this.f44048c, this.f44049d, (kotlin.reflect.jvm.internal.impl.types.checker.c) obj);
    }
}
