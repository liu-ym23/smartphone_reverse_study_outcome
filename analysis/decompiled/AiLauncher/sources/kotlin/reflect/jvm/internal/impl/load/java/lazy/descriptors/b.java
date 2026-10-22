package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import E9.O;
import E9.S;
import E9.b0;
import E9.i0;
import V9.k;
import Z8.C1173v;
import Z9.r;
import ga.e;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a;

/* loaded from: classes5.dex */
public abstract class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(k c10) {
        super(c10, null, 2, 0 == true ? 1 : 0);
        p.i(c10, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void B(e name, Collection<O> result) {
        p.i(name, "name");
        p.i(result, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public S N() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public a.C0439a X(r method, List<? extends b0> methodTypeParameters, ya.S returnType, List<? extends i0> valueParameters) {
        p.i(method, "method");
        p.i(methodTypeParameters, "methodTypeParameters");
        p.i(returnType, "returnType");
        p.i(valueParameters, "valueParameters");
        return new a.C0439a(returnType, null, valueParameters, methodTypeParameters, false, C1173v.m());
    }
}
