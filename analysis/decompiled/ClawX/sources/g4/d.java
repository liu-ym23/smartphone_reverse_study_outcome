package g4;

import k4.o;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f2967a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2968b;

    /* renamed from: c, reason: collision with root package name */
    public final o f2969c;

    public d(String str, Object value, o oVar) {
        p.e(value, "value");
        this.f2967a = str;
        this.f2968b = value;
        this.f2969c = oVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return p.a(this.f2967a, dVar.f2967a) && p.a(this.f2968b, dVar.f2968b) && p.a(this.f2969c, dVar.f2969c);
    }

    public final int hashCode() {
        return this.f2969c.hashCode() + ((this.f2968b.hashCode() + (this.f2967a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "FormPart(key=" + this.f2967a + ", value=" + this.f2968b + ", headers=" + this.f2969c + ')';
    }
}
