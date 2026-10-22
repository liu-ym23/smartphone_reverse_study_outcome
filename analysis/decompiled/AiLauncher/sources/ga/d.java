package ga;

import La.D;
import La.H;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final a f32729e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final e f32730f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f32731g;

    /* renamed from: a, reason: collision with root package name */
    public final String f32732a;

    /* renamed from: b, reason: collision with root package name */
    public transient c f32733b;

    /* renamed from: c, reason: collision with root package name */
    public transient d f32734c;

    /* renamed from: d, reason: collision with root package name */
    public transient e f32735d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final d a(e shortName) {
            p.i(shortName, "shortName");
            String strB = shortName.b();
            p.h(strB, "asString(...)");
            return new d(strB, c.f32726d.i(), shortName, null);
        }

        public a() {
        }
    }

    static {
        e eVarM = e.m("<root>");
        p.h(eVarM, "special(...)");
        f32730f = eVarM;
        Pattern patternCompile = Pattern.compile("\\.");
        p.h(patternCompile, "compile(...)");
        f32731g = patternCompile;
    }

    public /* synthetic */ d(String str, d dVar, e eVar, kotlin.jvm.internal.i iVar) {
        this(str, dVar, eVar);
    }

    public static final List<e> i(d dVar) {
        if (dVar.e()) {
            return new ArrayList();
        }
        List<e> listI = i(dVar.g());
        listI.add(dVar.j());
        return listI;
    }

    public final String a() {
        return this.f32732a;
    }

    public final d b(e name) {
        String strB;
        p.i(name, "name");
        if (e()) {
            strB = name.b();
        } else {
            strB = this.f32732a + '.' + name.b();
        }
        p.f(strB);
        return new d(strB, this, name);
    }

    public final void c() {
        int iD = d(this.f32732a);
        if (iD < 0) {
            this.f32735d = e.i(this.f32732a);
            this.f32734c = c.f32726d.i();
            return;
        }
        String strSubstring = this.f32732a.substring(iD + 1);
        p.h(strSubstring, "substring(...)");
        this.f32735d = e.i(strSubstring);
        String strSubstring2 = this.f32732a.substring(0, iD);
        p.h(strSubstring2, "substring(...)");
        this.f32734c = new d(strSubstring2);
    }

    public final int d(String str) {
        int length = str.length() - 1;
        boolean z10 = false;
        while (length >= 0) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '.' && !z10) {
                return length;
            }
            if (cCharAt == '`') {
                z10 = !z10;
            } else if (cCharAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    public final boolean e() {
        return this.f32732a.length() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && p.d(this.f32732a, ((d) obj).f32732a);
    }

    public final boolean f() {
        return this.f32733b != null || H.t0(a(), '<', 0, false, 6, null) < 0;
    }

    public final d g() {
        d dVar = this.f32734c;
        if (dVar != null) {
            return dVar;
        }
        if (e()) {
            throw new IllegalStateException(Parameters.ROOT);
        }
        c();
        d dVar2 = this.f32734c;
        p.f(dVar2);
        return dVar2;
    }

    public final List<e> h() {
        return i(this);
    }

    public int hashCode() {
        return this.f32732a.hashCode();
    }

    public final e j() {
        e eVar = this.f32735d;
        if (eVar != null) {
            return eVar;
        }
        if (e()) {
            throw new IllegalStateException(Parameters.ROOT);
        }
        c();
        e eVar2 = this.f32735d;
        p.f(eVar2);
        return eVar2;
    }

    public final e k() {
        return e() ? f32730f : j();
    }

    public final boolean l(e segment) {
        p.i(segment, "segment");
        if (e()) {
            return false;
        }
        int iT0 = H.t0(this.f32732a, '.', 0, false, 6, null);
        if (iT0 == -1) {
            iT0 = this.f32732a.length();
        }
        int i10 = iT0;
        String strB = segment.b();
        p.h(strB, "asString(...)");
        return i10 == strB.length() && D.O(this.f32732a, 0, strB, 0, i10, false, 16, null);
    }

    public final c m() {
        c cVar = this.f32733b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f32733b = cVar2;
        return cVar2;
    }

    public String toString() {
        if (!e()) {
            return this.f32732a;
        }
        String strB = f32730f.b();
        p.h(strB, "asString(...)");
        return strB;
    }

    public d(String fqName, c safe) {
        p.i(fqName, "fqName");
        p.i(safe, "safe");
        this.f32732a = fqName;
        this.f32733b = safe;
    }

    public d(String fqName) {
        p.i(fqName, "fqName");
        this.f32732a = fqName;
    }

    public d(String str, d dVar, e eVar) {
        this.f32732a = str;
        this.f32734c = dVar;
        this.f32735d = eVar;
    }
}
