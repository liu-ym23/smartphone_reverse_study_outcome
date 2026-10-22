package rd;

import com.obric.oui.time.ClockFormat;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f23887l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f23888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair f23889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pair f23890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pair f23891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair f23892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pair f23893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pair f23894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair f23895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Pair f23896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Pair f23897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Pair f23898k;

    public static final class a {

        /* JADX INFO: renamed from: rd.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0352a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f23899a = null;

            static {
                int[] r10 = new int[ClockFormat.values().length];
                r10[ClockFormat.H24.ordinal()] = 1;
                r10[ClockFormat.H12.ordinal()] = 2;
                f23899a = r10;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(Pair r10, ClockFormat r11) {
            q.g(r10, "<this>");
            q.g(r11, "clockFormat");
            int r12 = C0352a.f23899a[r11.ordinal()];
            if (r12 == 1) goto L10;
            if (r12 != 2) goto L8;
            return (String) r10.getSecond();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return (String) r10.getFirst();
        }

        public a() {
        }
    }

    static {
        f23887l = new a(null);
    }

    public d(Locale r10, Pair r11, Pair r12, Pair r13, Pair r14, Pair r15, Pair r16, Pair r17, Pair r18, Pair r19, Pair r110) {
        q.g(r10, "locale");
        q.g(r11, "fullPattern");
        q.g(r12, "fullPatternY");
        q.g(r13, "fullPatternYM");
        q.g(r14, "fullPatternYMD");
        q.g(r15, "fullPatternMD");
        q.g(r16, "fullPatternYMDHM");
        q.g(r17, "fullPatternYMDEHM");
        q.g(r18, "briefPatternHM");
        q.g(r19, "briefPatternMD");
        q.g(r110, "briefPatternYMDHM");
        this.f23888a = r10;
        this.f23889b = r11;
        this.f23890c = r12;
        this.f23891d = r13;
        this.f23892e = r14;
        this.f23893f = r15;
        this.f23894g = r16;
        this.f23895h = r17;
        this.f23896i = r18;
        this.f23897j = r19;
        this.f23898k = r110;
    }

    public final Pair a() {
        return this.f23896i;
    }

    public final Pair b() {
        return this.f23897j;
    }

    public final Pair c() {
        return this.f23898k;
    }

    public final Pair d() {
        return this.f23889b;
    }

    public final Pair e() {
        return this.f23893f;
    }

    public final Pair f() {
        return this.f23890c;
    }

    public final Pair g() {
        return this.f23891d;
    }

    public final Pair h() {
        return this.f23892e;
    }

    public final Pair i() {
        return this.f23895h;
    }

    public final Pair j() {
        return this.f23894g;
    }
}
