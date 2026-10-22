package b8;

import h8.InterfaceC1536s;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;

/* loaded from: classes4.dex */
public class r0 extends kotlin.jvm.internal.n {
    public static AbstractC0830C j(CallableReference callableReference) {
        Z7.f owner = callableReference.getOwner();
        return owner instanceof AbstractC0830C ? (AbstractC0830C) owner : C0843d.b;
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.g a(FunctionReference functionReference) {
        AbstractC0830C container = j(functionReference);
        String name = functionReference.getName();
        String signature = functionReference.getSignature();
        Object boundReceiver = functionReference.getBoundReceiver();
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(signature, "signature");
        return new C0832E(container, name, signature, null, boundReceiver);
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.d b(Class cls) {
        return AbstractC0842c.a(cls);
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.f c(Class jClass, String str) {
        Object objPutIfAbsent;
        O2.a aVar = AbstractC0842c.f2038a;
        kotlin.jvm.internal.k.f(jClass, "jClass");
        O2.a aVar2 = AbstractC0842c.b;
        aVar2.getClass();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) aVar2.c;
        Object objInvoke = concurrentHashMap.get(jClass);
        if (objInvoke == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(jClass, (objInvoke = ((S7.k) aVar2.b).invoke(jClass)))) != null) {
            objInvoke = objPutIfAbsent;
        }
        return (Z7.f) objInvoke;
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.j d(MutablePropertyReference0 mutablePropertyReference0) {
        return new C0834G(j(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.l e(MutablePropertyReference1 mutablePropertyReference1) {
        return new C0836I(j(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.q f(PropertyReference0 propertyReference0) {
        return new V(j(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.n
    public final Z7.s g(PropertyReference1 propertyReference1) {
        return new Y(j(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.n
    public final String h(kotlin.jvm.internal.h hVar) throws IOException {
        C0832E c0832eB;
        C0832E c0832eA = kotlin.reflect.jvm.a.a(hVar);
        if (c0832eA == null || (c0832eB = v0.b(c0832eA)) == null) {
            return super.h(hVar);
        }
        I8.g gVar = s0.f2054a;
        InterfaceC1536s interfaceC1536sQ = c0832eB.g();
        StringBuilder sb = new StringBuilder();
        s0.a(interfaceC1536sQ, sb);
        List listX = interfaceC1536sQ.x();
        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
        D7.v.H0(listX, sb, ", ", "(", ")", C0841b.i, 48);
        sb.append(" -> ");
        X8.w returnType = interfaceC1536sQ.getReturnType();
        kotlin.jvm.internal.k.c(returnType);
        sb.append(s0.d(returnType));
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    @Override // kotlin.jvm.internal.n
    public final String i(Lambda lambda) {
        return h(lambda);
    }
}
