package g8;

import e8.o;
import h8.InterfaceC1494B;
import h8.InterfaceC1497E;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import k8.z;
import kotlin.collections.EmptySet;
import u1.C2031a;

/* loaded from: classes4.dex */
public final class m implements InterfaceC1497E {

    /* renamed from: a, reason: collision with root package name */
    public final W8.i f4498a;
    public final z b;
    public T8.k c;
    public final kotlin.reflect.jvm.internal.impl.storage.b d;

    public m(W8.i iVar, C2031a c2031a, z zVar) {
        this.f4498a = iVar;
        this.b = zVar;
        this.d = iVar.d(new J4.b(this, 4));
    }

    @Override // h8.InterfaceC1497E
    public final void a(G8.c fqName, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        g9.l.b(arrayList, this.d.invoke(fqName));
    }

    @Override // h8.InterfaceC1497E
    public final boolean b(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        kotlin.reflect.jvm.internal.impl.storage.b bVar = this.d;
        return (bVar.c(fqName) ? (InterfaceC1494B) bVar.invoke(fqName) : c(fqName)) == null;
    }

    public final U8.b c(G8.c fqName) throws IOException {
        InputStream inputStreamA;
        kotlin.jvm.internal.k.f(fqName, "fqName");
        if (fqName.h(o.k)) {
            U8.a.m.getClass();
            inputStreamA = U8.c.a(U8.a.a(fqName));
        } else {
            inputStreamA = null;
        }
        if (inputStreamA != null) {
            return com.stepos.ability.task.executor.e.w(fqName, this.f4498a, this.b, inputStreamA);
        }
        return null;
    }

    @Override // h8.InterfaceC1497E
    public final Collection f(G8.c fqName, S7.k kVar) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return EmptySet.f4895a;
    }
}
