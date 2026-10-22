package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Lambda<R> implements f<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.f
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        i.f10086a.getClass();
        String strA = j.a(this);
        g.e(strA, "renderLambdaToString(...)");
        return strA;
    }
}
