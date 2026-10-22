package kotlin.reflect.jvm.internal.impl.builtins.functions;

import La.D;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final a f34972c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final f f34973d = new f(C1173v.p(e.a.f34968f, e.d.f34971f, e.b.f34969f, e.c.f34970f));

    /* renamed from: a, reason: collision with root package name */
    public final List<e> f34974a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<ga.c, List<e>> f34975b;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final f a() {
            return f.f34973d;
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final e f34976a;

        /* renamed from: b, reason: collision with root package name */
        public final int f34977b;

        public b(e kind, int i10) {
            p.i(kind, "kind");
            this.f34976a = kind;
            this.f34977b = i10;
        }

        public final e a() {
            return this.f34976a;
        }

        public final int b() {
            return this.f34977b;
        }

        public final e c() {
            return this.f34976a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p.d(this.f34976a, bVar.f34976a) && this.f34977b == bVar.f34977b;
        }

        public int hashCode() {
            return (this.f34976a.hashCode() * 31) + Integer.hashCode(this.f34977b);
        }

        public String toString() {
            return "KindWithArity(kind=" + this.f34976a + ", arity=" + this.f34977b + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends e> kinds) {
        p.i(kinds, "kinds");
        this.f34974a = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            ga.c cVarB = ((e) obj).b();
            Object arrayList = linkedHashMap.get(cVarB);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(cVarB, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f34975b = linkedHashMap;
    }

    public final e b(ga.c packageFqName, String className) {
        p.i(packageFqName, "packageFqName");
        p.i(className, "className");
        b bVarC = c(packageFqName, className);
        if (bVarC != null) {
            return bVarC.c();
        }
        return null;
    }

    public final b c(ga.c packageFqName, String className) {
        p.i(packageFqName, "packageFqName");
        p.i(className, "className");
        List<e> list = this.f34975b.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (e eVar : list) {
            if (D.X(className, eVar.a(), false, 2, null)) {
                String strSubstring = className.substring(eVar.a().length());
                p.h(strSubstring, "substring(...)");
                Integer numD = d(strSubstring);
                if (numD != null) {
                    return new b(eVar, numD.intValue());
                }
            }
        }
        return null;
    }

    public final Integer d(String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int iCharAt = str.charAt(i11) - '0';
            if (iCharAt < 0 || iCharAt >= 10) {
                return null;
            }
            i10 = (i10 * 10) + iCharAt;
        }
        return Integer.valueOf(i10);
    }
}
