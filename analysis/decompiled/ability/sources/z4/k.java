package z4;

import com.stepos.ability.beaninternal.ability.FunctionCallResult;

/* loaded from: classes3.dex */
public final class k extends S0.b {

    /* renamed from: q, reason: collision with root package name */
    public final FunctionCallResult f6966q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(FunctionCallResult result) {
        super(21);
        kotlin.jvm.internal.k.f(result, "result");
        this.f6966q = result;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && kotlin.jvm.internal.k.b(this.f6966q, ((k) obj).f6966q);
    }

    public final int hashCode() {
        return this.f6966q.hashCode();
    }

    @Override // S0.b
    public final String toString() {
        return "Terminal(result=" + this.f6966q + ")";
    }
}
