package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import E9.W;
import S9.F;
import com.autonavi.aps.amapapi.config.Const;
import ea.C4019c;
import fa.C4064a;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import ma.C4926f;

/* loaded from: classes5.dex */
public class a implements f.c {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f35212j;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<ga.b, KotlinClassHeader.Kind> f35213k;

    /* renamed from: a, reason: collision with root package name */
    public int[] f35214a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f35215b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f35216c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f35217d = null;

    /* renamed from: e, reason: collision with root package name */
    public String[] f35218e = null;

    /* renamed from: f, reason: collision with root package name */
    public String[] f35219f = null;

    /* renamed from: g, reason: collision with root package name */
    public String[] f35220g = null;

    /* renamed from: h, reason: collision with root package name */
    public KotlinClassHeader.Kind f35221h = null;

    /* renamed from: i, reason: collision with root package name */
    public String[] f35222i = null;

    public static abstract class b implements f.b {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f35223a = new ArrayList();

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i10 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i10 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i10 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i10 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
        public void a() {
            g((String[]) this.f35223a.toArray(new String[0]));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
        public void b(C4926f c4926f) {
            if (c4926f == null) {
                f(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
        public void c(ga.b bVar, ga.e eVar) {
            if (bVar == null) {
                f(0);
            }
            if (eVar == null) {
                f(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
        public f.a d(ga.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.b
        public void e(Object obj) {
            if (obj instanceof String) {
                this.f35223a.add((String) obj);
            }
        }

        public abstract void g(String[] strArr);
    }

    public class c implements f.a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$a, reason: collision with other inner class name */
        public class C0445a extends b {
            public C0445a() {
            }

            public static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f35218e = strArr;
            }
        }

        public class b extends b {
            public b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f35219f = strArr;
            }
        }

        public c() {
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void b(ga.e eVar, ga.b bVar, ga.e eVar2) {
            if (bVar == null) {
                g(1);
            }
            if (eVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void c(ga.e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String strB = eVar.b();
            if ("k".equals(strB)) {
                if (obj instanceof Integer) {
                    a.this.f35221h = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strB)) {
                if (obj instanceof int[]) {
                    a.this.f35214a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(strB)) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    a.this.f35215b = str;
                    return;
                }
                return;
            }
            if ("xi".equals(strB)) {
                if (obj instanceof Integer) {
                    a.this.f35216c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strB) && (obj instanceof String)) {
                String str2 = (String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                a.this.f35217d = str2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void d(ga.e eVar, C4926f c4926f) {
            if (c4926f == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.b e(ga.e eVar) {
            String strB = eVar != null ? eVar.b() : null;
            if ("d1".equals(strB)) {
                return h();
            }
            if ("d2".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.a f(ga.e eVar, ga.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        public final f.b h() {
            return new C0445a();
        }

        public final f.b i() {
            return new b();
        }
    }

    public class d implements f.a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$a, reason: collision with other inner class name */
        public class C0446a extends b {
            public C0446a() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f35222i = strArr;
            }
        }

        public d() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void b(ga.e eVar, ga.b bVar, ga.e eVar2) {
            if (bVar == null) {
                g(1);
            }
            if (eVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void c(ga.e eVar, Object obj) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void d(ga.e eVar, C4926f c4926f) {
            if (c4926f == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.b e(ga.e eVar) {
            if (Const.INTENT_KEY_PKGNAME.equals(eVar != null ? eVar.b() : null)) {
                return h();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.a f(ga.e eVar, ga.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        public final f.b h() {
            return new C0446a();
        }
    }

    public class e implements f.a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$e$a, reason: collision with other inner class name */
        public class C0447a extends b {
            public C0447a() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f35218e = strArr;
            }
        }

        public class b extends b {
            public b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                a.this.f35219f = strArr;
            }
        }

        public e() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private f.b h() {
            return new C0447a();
        }

        private f.b i() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void b(ga.e eVar, ga.b bVar, ga.e eVar2) {
            if (bVar == null) {
                g(1);
            }
            if (eVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void c(ga.e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String strB = eVar.b();
            if ("version".equals(strB)) {
                if (obj instanceof int[]) {
                    a.this.f35214a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strB)) {
                a.this.f35215b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public void d(ga.e eVar, C4926f c4926f) {
            if (c4926f == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.b e(ga.e eVar) {
            String strB = eVar != null ? eVar.b() : null;
            if ("data".equals(strB) || "filePartClassNames".equals(strB)) {
                return h();
            }
            if ("strings".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.a
        public f.a f(ga.e eVar, ga.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }
    }

    static {
        try {
            f35212j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        } catch (AccessControlException unused) {
            f35212j = false;
        }
        HashMap map = new HashMap();
        f35213k = map;
        map.put(ga.b.k(new ga.c("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        map.put(ga.b.k(new ga.c("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        map.put(ga.b.k(new ga.c("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        map.put(ga.b.k(new ga.c("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        map.put(ga.b.k(new ga.c("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void d(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
    public void a() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f.c
    public f.a b(ga.b bVar, W w10) {
        KotlinClassHeader.Kind kind;
        if (bVar == null) {
            d(0);
        }
        if (w10 == null) {
            d(1);
        }
        ga.c cVarA = bVar.a();
        if (cVarA.equals(F.f5683a)) {
            return new c();
        }
        if (cVarA.equals(F.f5702t)) {
            return new d();
        }
        if (f35212j || this.f35221h != null || (kind = f35213k.get(bVar)) == null) {
            return null;
        }
        this.f35221h = kind;
        return new e();
    }

    public KotlinClassHeader m(C4019c c4019c) {
        if (this.f35221h == null || this.f35214a == null) {
            return null;
        }
        C4019c c4019c2 = new C4019c(this.f35214a, (this.f35216c & 8) != 0);
        if (!c4019c2.h(c4019c)) {
            this.f35220g = this.f35218e;
            this.f35218e = null;
        } else if (o() && this.f35218e == null) {
            return null;
        }
        String[] strArr = this.f35222i;
        return new KotlinClassHeader(this.f35221h, c4019c2, this.f35218e, this.f35220g, this.f35219f, this.f35215b, this.f35216c, this.f35217d, strArr != null ? C4064a.e(strArr) : null);
    }

    public KotlinClassHeader n() {
        return m(C4019c.f32404i);
    }

    public final boolean o() {
        KotlinClassHeader.Kind kind = this.f35221h;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }
}
