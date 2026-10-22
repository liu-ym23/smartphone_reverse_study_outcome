package K2;

import M2.EnumC0377n;
import W3.C0403n;
import com.stepos.minor.Minor;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: i, reason: collision with root package name */
    public static final a f3643i;

    /* renamed from: j, reason: collision with root package name */
    private static final q f3644j;

    /* renamed from: k, reason: collision with root package name */
    private static final q f3645k;

    /* renamed from: l, reason: collision with root package name */
    private static final q f3646l;

    /* renamed from: m, reason: collision with root package name */
    private static final List<q> f3647m;

    /* renamed from: a, reason: collision with root package name */
    private final String f3648a;

    /* renamed from: b, reason: collision with root package name */
    private final EnumC0377n f3649b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3650c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3651d;

    /* renamed from: e, reason: collision with root package name */
    private final int f3652e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3653f;

    /* renamed from: g, reason: collision with root package name */
    private final float f3654g;

    /* renamed from: h, reason: collision with root package name */
    private final EnumC0377n f3655h;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final EnumC0377n e(int i5) {
            for (EnumC0377n enumC0377n : EnumC0377n.values()) {
                if (enumC0377n.d() == i5) {
                    return enumC0377n;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public final q b() {
            return q.f3645k;
        }

        public final q c() {
            return q.f3644j;
        }

        public final q d() {
            return q.f3646l;
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        f3643i = aVar;
        q qVar = new q("top_short", aVar.e(2), 0, r.b(1710618, 100), r.b(1710618, 60), r.b(1710618, 0), 0.5f, aVar.e(1));
        f3644j = qVar;
        q qVar2 = new q("bottom_short", aVar.e(1), 1, r.b(1710618, 0), r.b(1710618, 65), r.b(986895, 100), 0.43f, aVar.e(1));
        f3645k = qVar2;
        q qVar3 = new q("top_tall", aVar.e(2), 0, r.b(0, 80), r.b(0, 60), r.b(0, 0), 0.57f, aVar.e(1));
        f3646l = qVar3;
        f3647m = C0403n.k(qVar, qVar2, qVar3);
    }

    public q(String str, EnumC0377n enumC0377n, int i5, int i6, int i7, int i8, float f5, EnumC0377n enumC0377n2) {
        j4.k.g(str, Minor.COLUMN_ID);
        j4.k.g(enumC0377n, "direction");
        j4.k.g(enumC0377n2, "colorDirection");
        this.f3648a = str;
        this.f3649b = enumC0377n;
        this.f3650c = i5;
        this.f3651d = i6;
        this.f3652e = i7;
        this.f3653f = i8;
        this.f3654g = f5;
        this.f3655h = enumC0377n2;
    }

    public final void d(M2.C c6) {
        j4.k.g(c6, "params");
        c6.z(this.f3649b);
        c6.B(this.f3650c);
        c6.D(this.f3651d);
        c6.C(this.f3652e);
        c6.A(this.f3653f);
        c6.y(this.f3654g);
        c6.x(this.f3655h);
    }
}
