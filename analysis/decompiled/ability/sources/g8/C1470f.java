package g8;

import D7.v;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1540w;
import java.util.ArrayList;
import java.util.List;
import k8.w;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* renamed from: g8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1470f implements S7.k {
    public static final C1470f b = new C1470f();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4493a = 0;

    public /* synthetic */ C1470f() {
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        boolean z10 = false;
        switch (this.f4493a) {
            case 0:
                InterfaceC1540w module = (InterfaceC1540w) obj;
                C1469e c1469e = C1471g.d;
                kotlin.jvm.internal.k.f(module, "module");
                List list = (List) S0.b.g1(((w) module.V(C1471g.f)).e, w.h[0]);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (obj2 instanceof U8.b) {
                        arrayList.add(obj2);
                    }
                }
                return (U8.b) v.A0(arrayList);
            default:
                InterfaceC1520c interfaceC1520c = (InterfaceC1520c) obj;
                if (interfaceC1520c.getKind() == CallableMemberDescriptor$Kind.f4950a) {
                    InterfaceC1527j interfaceC1527jD = interfaceC1520c.d();
                    kotlin.jvm.internal.k.d(interfaceC1527jD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String str = C1468d.f4490a;
                    if (C1468d.f4491j.containsKey(J8.e.g((InterfaceC1522e) interfaceC1527jD))) {
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
        }
    }

    public C1470f(kotlin.reflect.jvm.internal.impl.builtins.jvm.b bVar) {
    }
}
