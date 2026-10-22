package z4;

import com.stepos.ability.beaninternal.ability.FunctionCallResult;

/* loaded from: classes3.dex */
public final class l extends S0.b {

    /* renamed from: q, reason: collision with root package name */
    public final FunctionCallResult f6967q;

    /* renamed from: r, reason: collision with root package name */
    public final p f6968r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FunctionCallResult card, p pVar) {
        super(21);
        kotlin.jvm.internal.k.f(card, "card");
        this.f6967q = card;
        this.f6968r = pVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.k.b(this.f6967q, lVar.f6967q) && kotlin.jvm.internal.k.b(this.f6968r, lVar.f6968r);
    }

    public final int hashCode() {
        return this.f6968r.hashCode() + (this.f6967q.hashCode() * 31);
    }

    @Override // S0.b
    public final String toString() {
        return "Wait(card=" + this.f6967q + ", session=" + this.f6968r + ")";
    }
}
