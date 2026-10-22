package s4;

import b4.C0567b;
import b4.InterfaceC0566a;
import y4.C1327a;
import y4.C1328b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public static final K f20307a = new K("DEFAULT", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final K f20308b = new K("LAZY", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final K f20309c = new K("ATOMIC", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final K f20310d = new K("UNDISPATCHED", 3);

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ K[] f20311e;

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f20312f;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20313a;

        static {
            int[] iArr = new int[K.values().length];
            try {
                iArr[K.f20307a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[K.f20309c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[K.f20310d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[K.f20308b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f20313a = iArr;
        }
    }

    static {
        K[] kArrB = b();
        f20311e = kArrB;
        f20312f = C0567b.a(kArrB);
    }

    private K(String str, int i5) {
    }

    private static final /* synthetic */ K[] b() {
        return new K[]{f20307a, f20308b, f20309c, f20310d};
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) f20311e.clone();
    }

    public final <R, T> void d(i4.p<? super R, ? super Z3.e<? super T>, ? extends Object> pVar, R r5, Z3.e<? super T> eVar) throws Throwable {
        int i5 = a.f20313a[ordinal()];
        if (i5 == 1) {
            C1327a.d(pVar, r5, eVar, null, 4, null);
            return;
        }
        if (i5 == 2) {
            Z3.g.a(pVar, r5, eVar);
        } else if (i5 == 3) {
            C1328b.a(pVar, r5, eVar);
        } else if (i5 != 4) {
            throw new V3.l();
        }
    }

    public final boolean e() {
        return this == f20308b;
    }
}
