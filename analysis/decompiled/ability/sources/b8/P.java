package b8;

import c8.C0884A;
import c8.C0885B;
import h8.InterfaceC1499G;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* loaded from: classes4.dex */
public final class P implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2026a;
    public final S b;

    public /* synthetic */ P(S s5, int i) {
        this.f2026a = i;
        this.b = s5;
    }

    @Override // S7.a
    public final Object invoke() {
        Q q5;
        List listX0;
        switch (this.f2026a) {
            case 0:
                return v0.d(this.b.b());
            default:
                S s5 = this.b;
                InterfaceC1499G interfaceC1499GB = s5.b();
                int i = s5.b;
                AbstractC0857s abstractC0857s = s5.f2028a;
                if ((interfaceC1499GB instanceof k8.u) && kotlin.jvm.internal.k.b(v0.g(abstractC0857s.g()), interfaceC1499GB) && abstractC0857s.g().getKind() == CallableMemberDescriptor$Kind.b) {
                    InterfaceC1527j interfaceC1527jD = abstractC0857s.g().d();
                    kotlin.jvm.internal.k.d(interfaceC1527jD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class clsK = v0.k((InterfaceC1522e) interfaceC1527jD);
                    if (clsK != null) {
                        return clsK;
                    }
                    throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + interfaceC1499GB);
                }
                c8.e eVarD = abstractC0857s.d();
                if (eVarD instanceof C0885B) {
                    if (abstractC0857s.n()) {
                        C0885B c0885b = (C0885B) eVarD;
                        Y7.f fVarB = c0885b.b(i + 1);
                        int i6 = c0885b.b(0).b + 1;
                        listX0 = D7.v.X0(new Y7.f(fVarB.f1569a - i6, fVarB.b - i6, 1), c0885b.b.a());
                    } else {
                        C0885B c0885b2 = (C0885B) eVarD;
                        listX0 = D7.v.X0(c0885b2.b(i), c0885b2.b.a());
                    }
                    Type[] typeArr = (Type[]) listX0.toArray(new Type[0]);
                    Type[] typeArr2 = (Type[]) Arrays.copyOf(typeArr, typeArr.length);
                    int length = typeArr2.length;
                    if (length == 0) {
                        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
                    }
                    if (length == 1) {
                        return (Type) D7.q.A0(typeArr2);
                    }
                    q5 = new Q(typeArr2);
                } else {
                    if (!(eVarD instanceof C0884A)) {
                        return (Type) eVarD.a().get(i);
                    }
                    Class[] clsArr = (Class[]) ((Collection) ((C0884A) eVarD).d.get(i)).toArray(new Class[0]);
                    Type[] typeArr3 = (Type[]) Arrays.copyOf(clsArr, clsArr.length);
                    int length2 = typeArr3.length;
                    if (length2 == 0) {
                        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
                    }
                    if (length2 == 1) {
                        return (Type) D7.q.A0(typeArr3);
                    }
                    q5 = new Q(typeArr3);
                }
                return q5;
        }
    }
}
