package s8;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final v9.v f9614a;

    /* renamed from: b, reason: collision with root package name */
    public final List f9615b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9616c;

    /* renamed from: d, reason: collision with root package name */
    public final List f9617d;

    public x(v9.v vVar, List list, ArrayList arrayList, List list2) {
        this.f9614a = vVar;
        this.f9615b = list;
        this.f9616c = arrayList;
        this.f9617d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f9614a.equals(xVar.f9614a) && this.f9615b.equals(xVar.f9615b) && this.f9616c.equals(xVar.f9616c) && this.f9617d.equals(xVar.f9617d);
    }

    public final int hashCode() {
        return this.f9617d.hashCode() + ((this.f9616c.hashCode() + m.x.h(this.f9615b, this.f9614a.hashCode() * 961, 31)) * 961);
    }

    public final String toString() {
        return "MethodSignatureData(returnType=" + this.f9614a + ", receiverType=null, valueParameters=" + this.f9615b + ", typeParameters=" + this.f9616c + ", hasStableParameterNames=false, errors=" + this.f9617d + ')';
    }
}
