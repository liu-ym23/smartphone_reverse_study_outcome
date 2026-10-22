package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements f<Object> {
    private final int arity;

    public RestrictedSuspendLambda(int i10, b<Object> bVar) {
        super(bVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.f
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        i.f10086a.getClass();
        String strA = j.a(this);
        g.e(strA, "renderLambdaToString(...)");
        return strA;
    }

    public RestrictedSuspendLambda(int i10) {
        this(i10, null);
    }
}
