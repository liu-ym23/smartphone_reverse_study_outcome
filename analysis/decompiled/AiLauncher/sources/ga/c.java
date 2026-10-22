package ga;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f32725c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final c f32726d = new c("");

    /* renamed from: a, reason: collision with root package name */
    public final d f32727a;

    /* renamed from: b, reason: collision with root package name */
    public transient c f32728b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final c a(e shortName) {
            p.i(shortName, "shortName");
            return new c(d.f32729e.a(shortName));
        }

        public a() {
        }
    }

    public c(String fqName) {
        p.i(fqName, "fqName");
        this.f32727a = new d(fqName, this);
    }

    public final String a() {
        return this.f32727a.a();
    }

    public final c b(e name) {
        p.i(name, "name");
        return new c(this.f32727a.b(name), this);
    }

    public final boolean c() {
        return this.f32727a.e();
    }

    public final c d() {
        c cVar = this.f32728b;
        if (cVar != null) {
            return cVar;
        }
        if (c()) {
            throw new IllegalStateException(Parameters.ROOT);
        }
        c cVar2 = new c(this.f32727a.g());
        this.f32728b = cVar2;
        return cVar2;
    }

    public final List<e> e() {
        return this.f32727a.h();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && p.d(this.f32727a, ((c) obj).f32727a);
    }

    public final e f() {
        return this.f32727a.j();
    }

    public final e g() {
        return this.f32727a.k();
    }

    public final boolean h(e segment) {
        p.i(segment, "segment");
        return this.f32727a.l(segment);
    }

    public int hashCode() {
        return this.f32727a.hashCode();
    }

    public final d i() {
        return this.f32727a;
    }

    public String toString() {
        return this.f32727a.toString();
    }

    public c(d fqName) {
        p.i(fqName, "fqName");
        this.f32727a = fqName;
    }

    public c(d dVar, c cVar) {
        this.f32727a = dVar;
        this.f32728b = cVar;
    }
}
