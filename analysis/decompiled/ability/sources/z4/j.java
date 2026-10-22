package z4;

import com.stepos.ability.beaninternal.ability.FunctionCallResult;

/* loaded from: classes3.dex */
public final class j extends S0.b {

    /* renamed from: q, reason: collision with root package name */
    public final FunctionCallResult f6965q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FunctionCallResult result) {
        super(21);
        kotlin.jvm.internal.k.f(result, "result");
        this.f6965q = result;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && kotlin.jvm.internal.k.b(this.f6965q, ((j) obj).f6965q);
    }

    public final int hashCode() {
        return this.f6965q.hashCode();
    }

    @Override // S0.b
    public final String toString() {
        return "None(result=" + this.f6965q + ")";
    }
}
