package n4;

import java.util.ArrayList;
import java.util.List;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6845a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6846b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6847c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6848d;

    public c(String str, String str2, String str3, ArrayList arrayList) {
        this.f6845a = str;
        this.f6846b = str2;
        this.f6847c = str3;
        this.f6848d = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a(this.f6845a, cVar.f6845a) && k.a(this.f6846b, cVar.f6846b) && k.a(this.f6847c, cVar.f6847c) && k.a(this.f6848d, cVar.f6848d);
    }

    public final int hashCode() {
        int iG = x.g(this.f6847c, x.g(this.f6846b, this.f6845a.hashCode() * 31, 31), 31);
        List list = this.f6848d;
        return iG + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("AgentCallParams(task=", this.f6845a, ", mode=", this.f6846b, ", context=");
        sbP.append(this.f6847c);
        sbP.append(", attachments=");
        sbP.append(this.f6848d);
        sbP.append(")");
        return sbP.toString();
    }
}
