package ga;

import La.D;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.jvm.internal.p;

/* renamed from: ga.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4113a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0404a f32713f = new C0404a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final e f32714g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f32715h;

    /* renamed from: a, reason: collision with root package name */
    public final c f32716a;

    /* renamed from: b, reason: collision with root package name */
    public final c f32717b;

    /* renamed from: c, reason: collision with root package name */
    public final e f32718c;

    /* renamed from: d, reason: collision with root package name */
    public final b f32719d;

    /* renamed from: e, reason: collision with root package name */
    public final c f32720e;

    /* renamed from: ga.a$a, reason: collision with other inner class name */
    public static final class C0404a {
        public /* synthetic */ C0404a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public C0404a() {
        }
    }

    static {
        e eVar = g.f32754n;
        f32714g = eVar;
        f32715h = c.f32725c.a(eVar);
    }

    public C4113a(c cVar, c cVar2, e eVar, b bVar, c cVar3) {
        this.f32716a = cVar;
        this.f32717b = cVar2;
        this.f32718c = eVar;
        this.f32719d = bVar;
        this.f32720e = cVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4113a)) {
            return false;
        }
        C4113a c4113a = (C4113a) obj;
        return p.d(this.f32716a, c4113a.f32716a) && p.d(this.f32717b, c4113a.f32717b) && p.d(this.f32718c, c4113a.f32718c);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f32716a.hashCode()) * 31;
        c cVar = this.f32717b;
        return ((iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31) + this.f32718c.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(D.S(this.f32716a.a(), '.', JsonPointer.SEPARATOR, false, 4, null));
        sb2.append("/");
        c cVar = this.f32717b;
        if (cVar != null) {
            sb2.append(cVar);
            sb2.append(".");
        }
        sb2.append(this.f32718c);
        return sb2.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4113a(c packageName, e callableName) {
        this(packageName, null, callableName, null, null);
        p.i(packageName, "packageName");
        p.i(callableName, "callableName");
    }
}
