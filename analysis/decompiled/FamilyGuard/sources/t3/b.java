package t3;

import V3.l;
import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22642a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f22643b = new b("NONE", 0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f22644c = new b("SINGLE", 1);

    /* renamed from: d, reason: collision with root package name */
    public static final b f22645d = new b("FIRST", 2);

    /* renamed from: e, reason: collision with root package name */
    public static final b f22646e = new b("MIDDLE", 3);

    /* renamed from: f, reason: collision with root package name */
    public static final b f22647f = new b("LAST", 4);

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ b[] f22648g;

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f22649h;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: t3.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0249b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22650a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.f22644c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.f22645d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.f22647f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.f22646e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.f22643b.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f22650a = iArr;
        }
    }

    static {
        b[] bVarArrB = b();
        f22648g = bVarArrB;
        f22649h = C0567b.a(bVarArrB);
        f22642a = new a(null);
    }

    private b(String str, int i5) {
    }

    private static final /* synthetic */ b[] b() {
        return new b[]{f22643b, f22644c, f22645d, f22646e, f22647f};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f22648g.clone();
    }

    public final float[] d(float f5) {
        int i5 = C0249b.f22650a[ordinal()];
        if (i5 == 1) {
            return new float[]{f5, f5, f5, f5, f5, f5, f5, f5};
        }
        if (i5 == 2) {
            return new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (i5 == 3) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, f5, f5, f5, f5};
        }
        if (i5 == 4 || i5 == 5) {
            return new float[8];
        }
        throw new l();
    }

    public final boolean e() {
        return this == f22644c || this == f22647f;
    }

    public final boolean g() {
        return this == f22644c || this == f22645d;
    }

    public final boolean h() {
        return this == f22645d || this == f22646e;
    }
}
