package y7;

import ad.z;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Objects;
import rd.d;
import w7.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final rd.b f15928g = d.b(a.class);

    /* renamed from: a, reason: collision with root package name */
    public String f15929a;

    /* renamed from: b, reason: collision with root package name */
    public String f15930b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f15931c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f15932d;

    /* renamed from: e, reason: collision with root package name */
    public q f15933e;

    /* renamed from: f, reason: collision with root package name */
    public z f15934f;

    public static z a(String str) {
        z zVar = new z(5);
        zVar.f637b = "$id";
        zVar.f639d = null;
        zVar.f640e = new HashMap();
        zVar.f641f = new HashMap();
        zVar.f642g = new HashMap();
        zVar.f638c = str;
        VarHandle.storeStoreFence();
        return zVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return Objects.equals(this.f15929a, ((a) obj).f15929a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15929a.hashCode();
    }

    public final String toString() {
        return this.f15929a;
    }
}
