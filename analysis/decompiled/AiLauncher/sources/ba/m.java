package ba;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes5.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final b f15344a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d f15345b = new d(JvmPrimitiveType.BOOLEAN);

    /* renamed from: c, reason: collision with root package name */
    public static final d f15346c = new d(JvmPrimitiveType.CHAR);

    /* renamed from: d, reason: collision with root package name */
    public static final d f15347d = new d(JvmPrimitiveType.BYTE);

    /* renamed from: e, reason: collision with root package name */
    public static final d f15348e = new d(JvmPrimitiveType.SHORT);

    /* renamed from: f, reason: collision with root package name */
    public static final d f15349f = new d(JvmPrimitiveType.INT);

    /* renamed from: g, reason: collision with root package name */
    public static final d f15350g = new d(JvmPrimitiveType.FLOAT);

    /* renamed from: h, reason: collision with root package name */
    public static final d f15351h = new d(JvmPrimitiveType.LONG);

    /* renamed from: i, reason: collision with root package name */
    public static final d f15352i = new d(JvmPrimitiveType.DOUBLE);

    public static final class a extends m {

        /* renamed from: j, reason: collision with root package name */
        public final m f15353j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m elementType) {
            super(null);
            kotlin.jvm.internal.p.i(elementType, "elementType");
            this.f15353j = elementType;
        }

        public final m i() {
            return this.f15353j;
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final d a() {
            return m.f15345b;
        }

        public final d b() {
            return m.f15347d;
        }

        public final d c() {
            return m.f15346c;
        }

        public final d d() {
            return m.f15352i;
        }

        public final d e() {
            return m.f15350g;
        }

        public final d f() {
            return m.f15349f;
        }

        public final d g() {
            return m.f15351h;
        }

        public final d h() {
            return m.f15348e;
        }

        public b() {
        }
    }

    public static final class c extends m {

        /* renamed from: j, reason: collision with root package name */
        public final String f15354j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String internalName) {
            super(null);
            kotlin.jvm.internal.p.i(internalName, "internalName");
            this.f15354j = internalName;
        }

        public final String i() {
            return this.f15354j;
        }
    }

    public static final class d extends m {

        /* renamed from: j, reason: collision with root package name */
        public final JvmPrimitiveType f15355j;

        public d(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.f15355j = jvmPrimitiveType;
        }

        public final JvmPrimitiveType i() {
            return this.f15355j;
        }
    }

    public /* synthetic */ m(kotlin.jvm.internal.i iVar) {
        this();
    }

    public String toString() {
        return o.f15356a.d(this);
    }

    public m() {
    }
}
