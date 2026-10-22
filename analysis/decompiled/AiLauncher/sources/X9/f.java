package X9;

import E9.b0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ya.A0;
import ya.B0;
import ya.C5971F;
import ya.C5972G;
import ya.D0;
import ya.H0;
import ya.S;

/* loaded from: classes5.dex */
public final class f extends C5971F {

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6882a;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6882a = iArr;
        }
    }

    @Override // ya.C5971F
    public B0 a(b0 parameter, C5972G typeAttr, A0 typeParameterUpperBoundEraser, S erasedUpperBound) {
        p.i(parameter, "parameter");
        p.i(typeAttr, "typeAttr");
        p.i(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        p.i(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof X9.a)) {
            return super.a(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        X9.a aVarL = (X9.a) typeAttr;
        if (!aVarL.i()) {
            aVarL = aVarL.l(JavaTypeFlexibility.INFLEXIBLE);
        }
        int i10 = a.f6882a[aVarL.g().ordinal()];
        if (i10 == 1) {
            return new D0(Variance.INVARIANT, erasedUpperBound);
        }
        if (i10 != 2 && i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!parameter.l().getAllowsOutPosition()) {
            return new D0(Variance.INVARIANT, DescriptorUtilsKt.m(parameter).I());
        }
        List<b0> parameters = erasedUpperBound.H0().getParameters();
        p.h(parameters, "getParameters(...)");
        if (!parameters.isEmpty()) {
            return new D0(Variance.OUT_VARIANCE, erasedUpperBound);
        }
        B0 b0T = H0.t(parameter, aVarL);
        p.f(b0T);
        return b0T;
    }
}
