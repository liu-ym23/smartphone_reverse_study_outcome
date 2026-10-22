package k4;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public static final w f3637b;

    /* renamed from: c, reason: collision with root package name */
    public static final w f3638c;
    public static final w d;

    /* renamed from: e, reason: collision with root package name */
    public static final List f3639e;

    /* renamed from: a, reason: collision with root package name */
    public final String f3640a;

    static {
        w wVar = new w("GET");
        f3637b = wVar;
        w wVar2 = new w("POST");
        f3638c = wVar2;
        w wVar3 = new w("PUT");
        w wVar4 = new w("PATCH");
        w wVar5 = new w("DELETE");
        w wVar6 = new w("HEAD");
        d = wVar6;
        f3639e = c5.l.S(new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, new w("OPTIONS")});
    }

    public w(String str) {
        this.f3640a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && kotlin.jvm.internal.p.a(this.f3640a, ((w) obj).f3640a);
    }

    public final int hashCode() {
        return this.f3640a.hashCode();
    }

    public final String toString() {
        return this.f3640a;
    }
}
