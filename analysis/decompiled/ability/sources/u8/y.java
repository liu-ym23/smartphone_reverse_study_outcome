package u8;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final X8.w f6738a;
    public final List b;
    public final ArrayList c;
    public final List d;

    public y(X8.w wVar, List valueParameters, ArrayList arrayList, List errors) {
        kotlin.jvm.internal.k.f(valueParameters, "valueParameters");
        kotlin.jvm.internal.k.f(errors, "errors");
        this.f6738a = wVar;
        this.b = valueParameters;
        this.c = arrayList;
        this.d = errors;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f6738a.equals(yVar.f6738a) && kotlin.jvm.internal.k.b(this.b, yVar.b) && this.c.equals(yVar.c) && kotlin.jvm.internal.k.b(this.d, yVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + androidx.appfunctions.metadata.a.d((this.c.hashCode() + androidx.appfunctions.metadata.a.e(this.b, this.f6738a.hashCode() * 961, 31)) * 31, 31, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MethodSignatureData(returnType=");
        sb.append(this.f6738a);
        sb.append(", receiverType=null, valueParameters=");
        sb.append(this.b);
        sb.append(", typeParameters=");
        sb.append(this.c);
        sb.append(", hasStableParameterNames=false, errors=");
        return B7.a.r(sb, this.d, ')');
    }
}
