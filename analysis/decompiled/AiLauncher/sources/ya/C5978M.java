package ya;

import E9.InterfaceC0799d;
import java.util.List;

/* renamed from: ya.M, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5978M extends E0 {

    /* renamed from: c, reason: collision with root package name */
    public final E9.b0[] f44035c;

    /* renamed from: d, reason: collision with root package name */
    public final B0[] f44036d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f44037e;

    public C5978M(E9.b0[] parameters, B0[] arguments, boolean z10) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        this.f44035c = parameters;
        this.f44036d = arguments;
        this.f44037e = z10;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    @Override // ya.E0
    public boolean b() {
        return this.f44037e;
    }

    @Override // ya.E0
    public B0 e(S key) {
        kotlin.jvm.internal.p.i(key, "key");
        InterfaceC0799d interfaceC0799dD = key.H0().d();
        E9.b0 b0Var = interfaceC0799dD instanceof E9.b0 ? (E9.b0) interfaceC0799dD : null;
        if (b0Var == null) {
            return null;
        }
        int index = b0Var.getIndex();
        E9.b0[] b0VarArr = this.f44035c;
        if (index >= b0VarArr.length || !kotlin.jvm.internal.p.d(b0VarArr[index].j(), b0Var.j())) {
            return null;
        }
        return this.f44036d[index];
    }

    @Override // ya.E0
    public boolean f() {
        return this.f44036d.length == 0;
    }

    public final B0[] i() {
        return this.f44036d;
    }

    public final E9.b0[] j() {
        return this.f44035c;
    }

    public /* synthetic */ C5978M(E9.b0[] b0VarArr, B0[] b0Arr, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(b0VarArr, b0Arr, (i10 & 4) != 0 ? false : z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5978M(List<? extends E9.b0> parameters, List<? extends B0> argumentsList) {
        this((E9.b0[]) parameters.toArray(new E9.b0[0]), (B0[]) argumentsList.toArray(new B0[0]), false, 4, null);
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(argumentsList, "argumentsList");
    }
}
