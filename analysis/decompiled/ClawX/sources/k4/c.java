package k4;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends a2.g {
    public static final /* synthetic */ int d = 0;

    static {
        c5.s sVar = c5.s.f1092a;
        new c("file", sVar);
        new c("mixed", sVar);
        new c("attachment", sVar);
        new c("inline", sVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String disposition, List parameters) {
        super(disposition, parameters);
        kotlin.jvm.internal.p.e(disposition, "disposition");
        kotlin.jvm.internal.p.e(parameters, "parameters");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.p.a((String) this.f88b, (String) cVar.f88b) && kotlin.jvm.internal.p.a((List) this.f89c, (List) cVar.f89c);
    }

    public final int hashCode() {
        return ((List) this.f89c).hashCode() + (((String) this.f88b).hashCode() * 31);
    }
}
