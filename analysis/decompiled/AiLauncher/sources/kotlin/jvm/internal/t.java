package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.reflect.KVariance;
import w9.C5757p;
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
import z9.Q0;

/* loaded from: classes4.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final u f34836a;

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5745d[] f34837b;

    static {
        u uVar = null;
        try {
            uVar = (u) Q0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (uVar == null) {
            uVar = new u();
        }
        f34836a = uVar;
        f34837b = new InterfaceC5745d[0];
    }

    public static InterfaceC5748g a(FunctionReference functionReference) {
        return f34836a.a(functionReference);
    }

    public static InterfaceC5745d b(Class cls) {
        return f34836a.b(cls);
    }

    public static InterfaceC5747f c(Class cls) {
        return f34836a.c(cls, "");
    }

    public static InterfaceC5755n d(InterfaceC5755n interfaceC5755n) {
        return f34836a.d(interfaceC5755n);
    }

    public static InterfaceC5750i e(MutablePropertyReference0 mutablePropertyReference0) {
        return f34836a.e(mutablePropertyReference0);
    }

    public static InterfaceC5751j f(MutablePropertyReference1 mutablePropertyReference1) {
        return f34836a.f(mutablePropertyReference1);
    }

    public static InterfaceC5755n g(Class cls) {
        return f34836a.l(b(cls), Collections.EMPTY_LIST, true);
    }

    public static InterfaceC5753l h(PropertyReference0 propertyReference0) {
        return f34836a.g(propertyReference0);
    }

    public static InterfaceC5754m i(PropertyReference1 propertyReference1) {
        return f34836a.h(propertyReference1);
    }

    public static String j(m mVar) {
        return f34836a.i(mVar);
    }

    public static String k(Lambda lambda) {
        return f34836a.j(lambda);
    }

    public static void l(InterfaceC5756o interfaceC5756o, InterfaceC5755n interfaceC5755n) {
        f34836a.k(interfaceC5756o, Collections.singletonList(interfaceC5755n));
    }

    public static InterfaceC5755n m(Class cls) {
        return f34836a.l(b(cls), Collections.EMPTY_LIST, false);
    }

    public static InterfaceC5755n n(Class cls, C5757p c5757p) {
        return f34836a.l(b(cls), Collections.singletonList(c5757p), false);
    }

    public static InterfaceC5755n o(Class cls, C5757p c5757p, C5757p c5757p2) {
        return f34836a.l(b(cls), Arrays.asList(c5757p, c5757p2), false);
    }

    public static InterfaceC5755n p(Class cls, C5757p... c5757pArr) {
        return f34836a.l(b(cls), Z8.r.T0(c5757pArr), false);
    }

    public static InterfaceC5755n q(InterfaceC5746e interfaceC5746e) {
        return f34836a.l(interfaceC5746e, Collections.EMPTY_LIST, false);
    }

    public static InterfaceC5756o r(Object obj, String str, KVariance kVariance, boolean z10) {
        return f34836a.m(obj, str, kVariance, z10);
    }
}
