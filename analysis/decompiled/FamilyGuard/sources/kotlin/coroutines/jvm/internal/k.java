package kotlin.coroutines.jvm.internal;

import j4.w;

/* loaded from: classes.dex */
public abstract class k extends j implements j4.h<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final int f17946a;

    public k(int i5, Z3.e<Object> eVar) {
        super(eVar);
        this.f17946a = i5;
    }

    @Override // j4.h
    public int getArity() {
        return this.f17946a;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strF = w.f(this);
        j4.k.f(strF, "renderLambdaToString(...)");
        return strF;
    }
}
