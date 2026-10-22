package x9;

import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.s;
import p9.InterfaceC5063a;
import w9.C5757p;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C6004k0;
import ya.D0;
import ya.S;
import ya.V;
import ya.s0;
import ya.v0;
import z9.InterfaceC6400X;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a=\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u001e\u0010\u0016\u001a\u00020\b*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lw9/e;", "", "Lw9/p;", "arguments", "", "nullable", "", "annotations", "Lw9/n;", Const.INTENT_KEY_PKGNAME, "(Lw9/e;Ljava/util/List;ZLjava/util/List;)Lw9/n;", "Lya/s0;", "attributes", "Lya/v0;", "typeConstructor", "Lya/d0;", Const.INTENT_KEY_APIKEY, "(Lya/s0;Lya/v0;Ljava/util/List;Z)Lya/d0;", Const.INTENT_KEY_UMID, "(Lw9/e;)Lw9/n;", "getStarProjectedType$annotations", "(Lw9/e;)V", "starProjectedType", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: x9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5857b {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x9.b$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43601a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f43601a = iArr;
        }
    }

    public static final AbstractC5990d0 a(s0 s0Var, v0 v0Var, List<C5757p> list, boolean z10) {
        B0 c6004k0;
        List<b0> parameters = v0Var.getParameters();
        p.h(parameters, "getParameters(...)");
        List<C5757p> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        int i10 = 0;
        for (Object obj : list2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            C5757p c5757p = (C5757p) obj;
            s sVar = (s) c5757p.c();
            S sF = sVar != null ? sVar.getType() : null;
            KVariance kVarianceD = c5757p.d();
            int i12 = kVarianceD == null ? -1 : a.f43601a[kVarianceD.ordinal()];
            if (i12 == -1) {
                b0 b0Var = parameters.get(i10);
                p.h(b0Var, "get(...)");
                c6004k0 = new C6004k0(b0Var);
            } else if (i12 == 1) {
                Variance variance = Variance.INVARIANT;
                p.f(sF);
                c6004k0 = new D0(variance, sF);
            } else if (i12 == 2) {
                Variance variance2 = Variance.IN_VARIANCE;
                p.f(sF);
                c6004k0 = new D0(variance2, sF);
            } else {
                if (i12 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Variance variance3 = Variance.OUT_VARIANCE;
                p.f(sF);
                c6004k0 = new D0(variance3, sF);
            }
            arrayList.add(c6004k0);
            i10 = i11;
        }
        return V.m(s0Var, v0Var, arrayList, z10, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final InterfaceC5755n b(InterfaceC5746e interfaceC5746e, List<C5757p> arguments, boolean z10, List<? extends Annotation> annotations) {
        InterfaceC0799d descriptor;
        p.i(interfaceC5746e, "<this>");
        p.i(arguments, "arguments");
        p.i(annotations, "annotations");
        InterfaceC5063a interfaceC5063a = null;
        Object[] objArr = 0;
        InterfaceC6400X interfaceC6400X = interfaceC5746e instanceof InterfaceC6400X ? (InterfaceC6400X) interfaceC5746e : null;
        if (interfaceC6400X == null || (descriptor = interfaceC6400X.getDescriptor()) == null) {
            throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + interfaceC5746e + " (" + interfaceC5746e.getClass() + ')');
        }
        v0 v0VarJ = descriptor.j();
        p.h(v0VarJ, "getTypeConstructor(...)");
        List<b0> parameters = v0VarJ.getParameters();
        p.h(parameters, "getParameters(...)");
        if (parameters.size() == arguments.size()) {
            return new s(a(annotations.isEmpty() ? s0.f44124b.k() : s0.f44124b.k(), v0VarJ, arguments, z10), interfaceC5063a, 2, objArr == true ? 1 : 0);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
    }

    public static /* synthetic */ InterfaceC5755n c(InterfaceC5746e interfaceC5746e, List list, boolean z10, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = C1173v.m();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            list2 = C1173v.m();
        }
        return b(interfaceC5746e, list, z10, list2);
    }

    public static final InterfaceC5755n d(InterfaceC5746e interfaceC5746e) {
        InterfaceC0799d descriptor;
        p.i(interfaceC5746e, "<this>");
        InterfaceC6400X interfaceC6400X = interfaceC5746e instanceof InterfaceC6400X ? (InterfaceC6400X) interfaceC5746e : null;
        if (interfaceC6400X == null || (descriptor = interfaceC6400X.getDescriptor()) == null) {
            return c(interfaceC5746e, null, false, null, 7, null);
        }
        List<b0> parameters = descriptor.j().getParameters();
        p.h(parameters, "getParameters(...)");
        if (parameters.isEmpty()) {
            return c(interfaceC5746e, null, false, null, 7, null);
        }
        List<b0> list = parameters;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (b0 b0Var : list) {
            arrayList.add(C5757p.INSTANCE.c());
        }
        return c(interfaceC5746e, arrayList, false, null, 6, null);
    }
}
