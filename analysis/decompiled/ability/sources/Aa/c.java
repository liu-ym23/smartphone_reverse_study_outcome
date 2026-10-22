package Aa;

import kotlin.jvm.internal.k;
import stepai.aios.guiagent.model.TakeoverReasonType;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f166a;
    public final TakeoverReasonType b;

    public c(String reason, TakeoverReasonType reasonType) {
        k.f(reason, "reason");
        k.f(reasonType, "reasonType");
        this.f166a = reason;
        this.b = reasonType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.b(this.f166a, cVar.f166a) && this.b == cVar.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f166a.hashCode() * 31);
    }

    public final String toString() {
        return "PendingTakeoverRequest(reason=" + this.f166a + ", reasonType=" + this.b + ")";
    }
}
