package androidx.datastore.preferences.protobuf;

import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    static final int f10153a = c(1, 3);

    /* renamed from: b, reason: collision with root package name */
    static final int f10154b = c(1, 4);

    /* renamed from: c, reason: collision with root package name */
    static final int f10155c = c(2, 0);

    /* renamed from: d, reason: collision with root package name */
    static final int f10156d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f10157c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f10158d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f10159e;

        /* renamed from: f, reason: collision with root package name */
        public static final b f10160f;

        /* renamed from: g, reason: collision with root package name */
        public static final b f10161g;

        /* renamed from: h, reason: collision with root package name */
        public static final b f10162h;

        /* renamed from: i, reason: collision with root package name */
        public static final b f10163i;

        /* renamed from: j, reason: collision with root package name */
        public static final b f10164j;

        /* renamed from: k, reason: collision with root package name */
        public static final b f10165k;

        /* renamed from: l, reason: collision with root package name */
        public static final b f10166l;

        /* renamed from: m, reason: collision with root package name */
        public static final b f10167m;

        /* renamed from: n, reason: collision with root package name */
        public static final b f10168n;

        /* renamed from: o, reason: collision with root package name */
        public static final b f10169o;

        /* renamed from: p, reason: collision with root package name */
        public static final b f10170p;

        /* renamed from: q, reason: collision with root package name */
        public static final b f10171q;

        /* renamed from: r, reason: collision with root package name */
        public static final b f10172r;

        /* renamed from: s, reason: collision with root package name */
        public static final b f10173s;

        /* renamed from: t, reason: collision with root package name */
        public static final b f10174t;

        /* renamed from: u, reason: collision with root package name */
        private static final /* synthetic */ b[] f10175u;

        /* renamed from: a, reason: collision with root package name */
        private final c f10176a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10177b;

        enum a extends b {
            a(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        /* renamed from: androidx.datastore.preferences.protobuf.u0$b$b, reason: collision with other inner class name */
        enum C0128b extends b {
            C0128b(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        enum c extends b {
            c(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        enum d extends b {
            d(String str, int i5, c cVar, int i6) {
                super(str, i5, cVar, i6);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f10157c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f10158d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f10159e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f10160f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f10161g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f10162h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f10163i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f10164j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f10165k = aVar;
            c cVar3 = c.MESSAGE;
            C0128b c0128b = new C0128b("GROUP", 9, cVar3, 3);
            f10166l = c0128b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f10167m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f10168n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f10169o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f10170p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f10171q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f10172r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f10173s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f10174t = bVar14;
            f10175u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0128b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f10175u.clone();
        }

        public c b() {
            return this.f10176a;
        }

        public int d() {
            return this.f10177b;
        }

        private b(String str, int i5, c cVar, int i6) {
            this.f10176a = cVar;
            this.f10177b = i6;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(BuildConfig.FLAVOR),
        BYTE_STRING(AbstractC0488h.f10009b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a, reason: collision with root package name */
        private final Object f10188a;

        c(Object obj) {
            this.f10188a = obj;
        }
    }

    public static int a(int i5) {
        return i5 >>> 3;
    }

    public static int b(int i5) {
        return i5 & 7;
    }

    static int c(int i5, int i6) {
        return (i5 << 3) | i6;
    }
}
