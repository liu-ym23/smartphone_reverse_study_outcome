package m;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final m f6056a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6057b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f6058c;

    public e0(ib.c cVar, m mVar, boolean z4, Map map) {
        this.f6056a = mVar;
        this.f6057b = z4;
        this.f6058c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return q7.k.a(null, null) && q7.k.a(this.f6056a, e0Var.f6056a) && this.f6057b == e0Var.f6057b && q7.k.a(this.f6058c, e0Var.f6058c);
    }

    public final int hashCode() {
        int i2 = 0 * 961;
        m mVar = this.f6056a;
        return this.f6058c.hashCode() + x.e((i2 + (mVar == null ? 0 : mVar.hashCode())) * 961, 31, this.f6057b);
    }

    public final String toString() {
        return "TransitionData(fade=" + ((Object) null) + ", slide=null, changeSize=" + this.f6056a + ", scale=null, hold=" + this.f6057b + ", effectsMap=" + this.f6058c + ')';
    }

    public /* synthetic */ e0(ib.c cVar, m mVar, LinkedHashMap linkedHashMap, int i2) {
        this((i2 & 1) != 0 ? null : cVar, (i2 & 4) != 0 ? null : mVar, (i2 & 16) == 0, (i2 & 32) != 0 ? d7.a0.f2944f : linkedHashMap);
    }
}
