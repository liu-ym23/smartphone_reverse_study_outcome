package z9;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import w9.C5757p;
import w9.InterfaceC5744c;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5747f;
import w9.InterfaceC5748g;
import w9.InterfaceC5750i;
import w9.InterfaceC5751j;
import w9.InterfaceC5753l;
import w9.InterfaceC5754m;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;
import x9.C5857b;

/* loaded from: classes5.dex */
public class Q0 extends kotlin.jvm.internal.u {
    public static KDeclarationContainerImpl n(CallableReference callableReference) {
        InterfaceC5747f owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : kotlin.reflect.jvm.internal.a.f34875d;
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5748g a(FunctionReference functionReference) {
        return new kotlin.reflect.jvm.internal.f(n(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5745d b(Class cls) {
        return C6419i.m(cls);
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5747f c(Class cls, String str) {
        return C6419i.n(cls);
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5755n d(InterfaceC5755n interfaceC5755n) {
        return a1.a(interfaceC5755n);
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5750i e(MutablePropertyReference0 mutablePropertyReference0) {
        return new kotlin.reflect.jvm.internal.g(n(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5751j f(MutablePropertyReference1 mutablePropertyReference1) {
        return new kotlin.reflect.jvm.internal.h(n(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5753l g(PropertyReference0 propertyReference0) {
        return new kotlin.reflect.jvm.internal.m(n(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5754m h(PropertyReference1 propertyReference1) {
        return new kotlin.reflect.jvm.internal.n(n(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.u
    public String i(kotlin.jvm.internal.m mVar) {
        kotlin.reflect.jvm.internal.f fVarC;
        InterfaceC5748g interfaceC5748gA = ReflectLambdaKt.a(mVar);
        return (interfaceC5748gA == null || (fVarC = c1.c(interfaceC5748gA)) == null) ? super.i(mVar) : X0.f45332a.t(fVarC);
    }

    @Override // kotlin.jvm.internal.u
    public String j(Lambda lambda) {
        return i(lambda);
    }

    @Override // kotlin.jvm.internal.u
    public void k(InterfaceC5756o interfaceC5756o, List<InterfaceC5755n> list) {
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5755n l(InterfaceC5746e interfaceC5746e, List<C5757p> list, boolean z10) {
        return interfaceC5746e instanceof kotlin.jvm.internal.f ? C6419i.k(((kotlin.jvm.internal.f) interfaceC5746e).m(), list, z10) : C5857b.b(interfaceC5746e, list, z10, Collections.EMPTY_LIST);
    }

    @Override // kotlin.jvm.internal.u
    public InterfaceC5756o m(Object obj, String str, KVariance kVariance, boolean z10) {
        List<InterfaceC5756o> typeParameters;
        if (obj instanceof InterfaceC5745d) {
            typeParameters = ((InterfaceC5745d) obj).getTypeParameters();
        } else {
            if (!(obj instanceof InterfaceC5744c)) {
                throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
            }
            typeParameters = ((InterfaceC5744c) obj).getTypeParameters();
        }
        for (InterfaceC5756o interfaceC5756o : typeParameters) {
            if (interfaceC5756o.getName().equals(str)) {
                return interfaceC5756o;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }
}
