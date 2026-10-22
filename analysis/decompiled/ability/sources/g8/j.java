package g8;

import H4.o;
import i8.AbstractC1558d;
import i8.C1560f;
import i8.C1562h;
import java.util.List;

/* loaded from: classes4.dex */
public final class j implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4496a;
    public final kotlin.reflect.jvm.internal.impl.builtins.jvm.b b;

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.builtins.jvm.b bVar, int i) {
        this.f4496a = i;
        this.b = bVar;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4496a;
        kotlin.reflect.jvm.internal.impl.builtins.jvm.b bVar = this.b;
        switch (i) {
            case 0:
                List listM = o.M(AbstractC1558d.a(bVar.f4949a.d, "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", "", "WARNING"));
                return listM.isEmpty() ? C1560f.f4611a : new C1562h(listM, 0);
            default:
                return bVar.f4949a.d.e();
        }
    }
}
