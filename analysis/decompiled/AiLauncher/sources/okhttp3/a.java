package okhttp3;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.ai.selector.config.PictureConfig;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Lokhttp3/a;", "", "", "javaName", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    public static final a f37503A;

    /* renamed from: A0, reason: collision with root package name */
    public static final a f37504A0;

    /* renamed from: B, reason: collision with root package name */
    public static final a f37505B;

    /* renamed from: B0, reason: collision with root package name */
    public static final a f37506B0;

    /* renamed from: C, reason: collision with root package name */
    public static final a f37507C;

    /* renamed from: C0, reason: collision with root package name */
    public static final a f37508C0;

    /* renamed from: D, reason: collision with root package name */
    public static final a f37509D;

    /* renamed from: D0, reason: collision with root package name */
    public static final a f37510D0;

    /* renamed from: E, reason: collision with root package name */
    public static final a f37511E;

    /* renamed from: E0, reason: collision with root package name */
    public static final a f37512E0;

    /* renamed from: F, reason: collision with root package name */
    public static final a f37513F;

    /* renamed from: F0, reason: collision with root package name */
    public static final a f37514F0;

    /* renamed from: G, reason: collision with root package name */
    public static final a f37515G;

    /* renamed from: G0, reason: collision with root package name */
    public static final a f37516G0;

    /* renamed from: H, reason: collision with root package name */
    public static final a f37517H;

    /* renamed from: H0, reason: collision with root package name */
    public static final a f37518H0;

    /* renamed from: I, reason: collision with root package name */
    public static final a f37519I;

    /* renamed from: I0, reason: collision with root package name */
    public static final a f37520I0;

    /* renamed from: J, reason: collision with root package name */
    public static final a f37521J;

    /* renamed from: J0, reason: collision with root package name */
    public static final a f37522J0;

    /* renamed from: K, reason: collision with root package name */
    public static final a f37523K;

    /* renamed from: K0, reason: collision with root package name */
    public static final a f37524K0;

    /* renamed from: L, reason: collision with root package name */
    public static final a f37525L;

    /* renamed from: L0, reason: collision with root package name */
    public static final a f37526L0;

    /* renamed from: M, reason: collision with root package name */
    public static final a f37527M;

    /* renamed from: M0, reason: collision with root package name */
    public static final a f37528M0;

    /* renamed from: N, reason: collision with root package name */
    public static final a f37529N;

    /* renamed from: N0, reason: collision with root package name */
    public static final a f37530N0;

    /* renamed from: O, reason: collision with root package name */
    public static final a f37531O;

    /* renamed from: O0, reason: collision with root package name */
    public static final a f37532O0;

    /* renamed from: P, reason: collision with root package name */
    public static final a f37533P;

    /* renamed from: P0, reason: collision with root package name */
    public static final a f37534P0;

    /* renamed from: Q, reason: collision with root package name */
    public static final a f37535Q;

    /* renamed from: Q0, reason: collision with root package name */
    public static final a f37536Q0;

    /* renamed from: R, reason: collision with root package name */
    public static final a f37537R;

    /* renamed from: R0, reason: collision with root package name */
    public static final a f37538R0;

    /* renamed from: S, reason: collision with root package name */
    public static final a f37539S;

    /* renamed from: S0, reason: collision with root package name */
    public static final a f37540S0;

    /* renamed from: T, reason: collision with root package name */
    public static final a f37541T;

    /* renamed from: T0, reason: collision with root package name */
    public static final a f37542T0;

    /* renamed from: U, reason: collision with root package name */
    public static final a f37543U;

    /* renamed from: U0, reason: collision with root package name */
    public static final a f37544U0;

    /* renamed from: V, reason: collision with root package name */
    public static final a f37545V;

    /* renamed from: V0, reason: collision with root package name */
    public static final a f37546V0;

    /* renamed from: W, reason: collision with root package name */
    public static final a f37547W;

    /* renamed from: W0, reason: collision with root package name */
    public static final a f37548W0;

    /* renamed from: X, reason: collision with root package name */
    public static final a f37549X;

    /* renamed from: X0, reason: collision with root package name */
    public static final a f37550X0;

    /* renamed from: Y, reason: collision with root package name */
    public static final a f37551Y;

    /* renamed from: Y0, reason: collision with root package name */
    public static final a f37552Y0;

    /* renamed from: Z, reason: collision with root package name */
    public static final a f37553Z;

    /* renamed from: Z0, reason: collision with root package name */
    public static final a f37554Z0;

    /* renamed from: a0, reason: collision with root package name */
    public static final a f37555a0;

    /* renamed from: a1, reason: collision with root package name */
    public static final a f37556a1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: b0, reason: collision with root package name */
    public static final a f37558b0;

    /* renamed from: b1, reason: collision with root package name */
    public static final a f37559b1;

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator<String> f37560c;

    /* renamed from: c0, reason: collision with root package name */
    public static final a f37561c0;

    /* renamed from: c1, reason: collision with root package name */
    public static final a f37562c1;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f37563d;

    /* renamed from: d0, reason: collision with root package name */
    public static final a f37564d0;

    /* renamed from: d1, reason: collision with root package name */
    public static final a f37565d1;

    /* renamed from: e, reason: collision with root package name */
    public static final a f37566e;

    /* renamed from: e0, reason: collision with root package name */
    public static final a f37567e0;

    /* renamed from: e1, reason: collision with root package name */
    public static final a f37568e1;

    /* renamed from: f, reason: collision with root package name */
    public static final a f37569f;

    /* renamed from: f0, reason: collision with root package name */
    public static final a f37570f0;

    /* renamed from: f1, reason: collision with root package name */
    public static final a f37571f1;

    /* renamed from: g, reason: collision with root package name */
    public static final a f37572g;

    /* renamed from: g0, reason: collision with root package name */
    public static final a f37573g0;

    /* renamed from: g1, reason: collision with root package name */
    public static final a f37574g1;

    /* renamed from: h, reason: collision with root package name */
    public static final a f37575h;

    /* renamed from: h0, reason: collision with root package name */
    public static final a f37576h0;

    /* renamed from: h1, reason: collision with root package name */
    public static final a f37577h1;

    /* renamed from: i, reason: collision with root package name */
    public static final a f37578i;

    /* renamed from: i0, reason: collision with root package name */
    public static final a f37579i0;

    /* renamed from: i1, reason: collision with root package name */
    public static final a f37580i1;

    /* renamed from: j, reason: collision with root package name */
    public static final a f37581j;

    /* renamed from: j0, reason: collision with root package name */
    public static final a f37582j0;

    /* renamed from: j1, reason: collision with root package name */
    public static final a f37583j1;

    /* renamed from: k, reason: collision with root package name */
    public static final a f37584k;

    /* renamed from: k0, reason: collision with root package name */
    public static final a f37585k0;

    /* renamed from: k1, reason: collision with root package name */
    public static final a f37586k1;

    /* renamed from: l, reason: collision with root package name */
    public static final a f37587l;

    /* renamed from: l0, reason: collision with root package name */
    public static final a f37588l0;

    /* renamed from: l1, reason: collision with root package name */
    public static final a f37589l1;

    /* renamed from: m, reason: collision with root package name */
    public static final a f37590m;

    /* renamed from: m0, reason: collision with root package name */
    public static final a f37591m0;

    /* renamed from: m1, reason: collision with root package name */
    public static final a f37592m1;

    /* renamed from: n, reason: collision with root package name */
    public static final a f37593n;

    /* renamed from: n0, reason: collision with root package name */
    public static final a f37594n0;

    /* renamed from: n1, reason: collision with root package name */
    public static final a f37595n1;

    /* renamed from: o, reason: collision with root package name */
    public static final a f37596o;

    /* renamed from: o0, reason: collision with root package name */
    public static final a f37597o0;

    /* renamed from: o1, reason: collision with root package name */
    public static final a f37598o1;

    /* renamed from: p, reason: collision with root package name */
    public static final a f37599p;

    /* renamed from: p0, reason: collision with root package name */
    public static final a f37600p0;

    /* renamed from: p1, reason: collision with root package name */
    public static final a f37601p1;

    /* renamed from: q, reason: collision with root package name */
    public static final a f37602q;

    /* renamed from: q0, reason: collision with root package name */
    public static final a f37603q0;

    /* renamed from: q1, reason: collision with root package name */
    public static final a f37604q1;

    /* renamed from: r, reason: collision with root package name */
    public static final a f37605r;

    /* renamed from: r0, reason: collision with root package name */
    public static final a f37606r0;

    /* renamed from: r1, reason: collision with root package name */
    public static final a f37607r1;

    /* renamed from: s, reason: collision with root package name */
    public static final a f37608s;

    /* renamed from: s0, reason: collision with root package name */
    public static final a f37609s0;

    /* renamed from: s1, reason: collision with root package name */
    public static final a f37610s1;

    /* renamed from: t, reason: collision with root package name */
    public static final a f37611t;

    /* renamed from: t0, reason: collision with root package name */
    public static final a f37612t0;

    /* renamed from: u, reason: collision with root package name */
    public static final a f37613u;

    /* renamed from: u0, reason: collision with root package name */
    public static final a f37614u0;

    /* renamed from: v, reason: collision with root package name */
    public static final a f37615v;

    /* renamed from: v0, reason: collision with root package name */
    public static final a f37616v0;

    /* renamed from: w, reason: collision with root package name */
    public static final a f37617w;

    /* renamed from: w0, reason: collision with root package name */
    public static final a f37618w0;

    /* renamed from: x, reason: collision with root package name */
    public static final a f37619x;

    /* renamed from: x0, reason: collision with root package name */
    public static final a f37620x0;

    /* renamed from: y, reason: collision with root package name */
    public static final a f37621y;

    /* renamed from: y0, reason: collision with root package name */
    public static final a f37622y0;

    /* renamed from: z, reason: collision with root package name */
    public static final a f37623z;

    /* renamed from: z0, reason: collision with root package name */
    public static final a f37624z0;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String javaName;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u001f\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"okhttp3/a$a", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "", "(Ljava/lang/String;Ljava/lang/String;)I", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.a$a, reason: collision with other inner class name */
    public static final class C0480a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String a10, String b10) {
            p.i(a10, "a");
            p.i(b10, "b");
            int iMin = Math.min(a10.length(), b10.length());
            for (int i10 = 4; i10 < iMin; i10++) {
                char cCharAt = a10.charAt(i10);
                char cCharAt2 = b10.charAt(i10);
                if (cCharAt != cCharAt2) {
                    return p.k(cCharAt, cCharAt2) < 0 ? -1 : 1;
                }
            }
            int length = a10.length();
            int length2 = b10.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b{\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0019R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00101\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u0014\u00104\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0019R\u0014\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0019R\u0014\u00106\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0019R\u0014\u00107\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u0014\u00108\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0019R\u0014\u00109\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0019R\u0014\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0019R\u0014\u0010;\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0014\u0010<\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0019R\u0014\u0010=\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0019R\u0014\u0010?\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0019R\u0014\u0010A\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u0010\u0019R\u0014\u0010C\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010\u0019R\u0014\u0010D\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010\u0019R\u0014\u0010E\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0019R\u0014\u0010G\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0019R\u0014\u0010H\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010\u0019R\u0014\u0010I\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0019R\u0014\u0010J\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0019R\u0014\u0010K\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0019R\u0014\u0010L\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010\u0019R\u0014\u0010M\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010\u0019R\u0014\u0010N\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010\u0019R\u0014\u0010O\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0019R\u0014\u0010P\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0019R\u0014\u0010Q\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u0019R\u0014\u0010R\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010\u0019R\u0014\u0010S\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0019R\u0014\u0010U\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0019R\u0014\u0010V\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010\u0019R\u0014\u0010W\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010\u0019R\u0014\u0010X\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010\u0019R\u0014\u0010Y\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010\u0019R\u0014\u0010Z\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010\u0019R\u0014\u0010[\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010\u0019R\u0014\u0010\\\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010\u0019R\u0014\u0010]\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010\u0019R\u0014\u0010^\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u0010\u0019R\u0014\u0010_\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010\u0019R\u0014\u0010`\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010\u0019R\u0014\u0010a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010\u0019R\u0014\u0010b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010\u0019R\u0014\u0010c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010\u0019R\u0014\u0010d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010\u0019R\u0014\u0010e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010\u0019R\u0014\u0010f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010\u0019R\u0014\u0010g\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010\u0019R\u0014\u0010h\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010\u0019R\u0014\u0010i\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010\u0019R\u0014\u0010j\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010\u0019R\u0014\u0010k\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010\u0019R\u0014\u0010l\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010\u0019R\u0014\u0010m\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010\u0019R\u0014\u0010n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010\u0019R\u0014\u0010o\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u0010\u0019R\u0014\u0010p\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010\u0019R\u0014\u0010q\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010\u0019R\u0014\u0010r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010\u0019R\u0014\u0010s\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010\u0019R\u0014\u0010t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bt\u0010\u0019R\u0014\u0010u\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bu\u0010\u0019R\u0014\u0010v\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010\u0019R\u0014\u0010w\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010\u0019R\u0014\u0010x\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010\u0019R\u0014\u0010y\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\by\u0010\u0019R\u0014\u0010z\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bz\u0010\u0019R\u0014\u0010{\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b{\u0010\u0019R\u0014\u0010|\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b|\u0010\u0019R\u0014\u0010}\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b}\u0010\u0019R\u0014\u0010~\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b~\u0010\u0019R\u0014\u0010\u007f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010\u0019R\u0016\u0010\u0080\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u0019R\u0016\u0010\u0081\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u0019R\u0016\u0010\u0082\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u0019R\u0016\u0010\u0083\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\u0019R\u0016\u0010\u0084\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0019R\u0016\u0010\u0085\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u0019R\u0016\u0010\u0086\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u0019R\u0016\u0010\u0087\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\u0019R\u0016\u0010\u0088\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\u0019R\u0016\u0010\u0089\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u0019R\u0016\u0010\u008a\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010\u0019R\u0016\u0010\u008b\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010\u0019R\u0016\u0010\u008c\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010\u0019R\u0016\u0010\u008d\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\u0019R\u0016\u0010\u008e\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010\u0019R\u0016\u0010\u008f\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010\u0019¨\u0006\u0090\u0001"}, d2 = {"Lokhttp3/a$b;", "", "<init>", "()V", "", "javaName", "Lokhttp3/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lokhttp3/a;", "e", "(Ljava/lang/String;)Ljava/lang/String;", "", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)Lokhttp3/a;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "c", "()Ljava/util/Comparator;", "", "INSTANCES", "Ljava/util/Map;", "TLS_RSA_WITH_NULL_MD5", "Lokhttp3/a;", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_CCM_8_SHA256", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final synchronized a b(String javaName) {
            a aVar;
            try {
                p.i(javaName, "javaName");
                aVar = (a) a.f37563d.get(javaName);
                if (aVar == null) {
                    aVar = (a) a.f37563d.get(e(javaName));
                    if (aVar == null) {
                        aVar = new a(javaName, null);
                    }
                    a.f37563d.put(javaName, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
            return aVar;
        }

        public final Comparator<String> c() {
            return a.f37560c;
        }

        public final a d(String javaName, int value) {
            a aVar = new a(javaName, null);
            a.f37563d.put(javaName, aVar);
            return aVar;
        }

        public final String e(String javaName) {
            if (D.X(javaName, "TLS_", false, 2, null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SSL_");
                String strSubstring = javaName.substring(4);
                p.h(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                return sb2.toString();
            }
            if (!D.X(javaName, "SSL_", false, 2, null)) {
                return javaName;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("TLS_");
            String strSubstring2 = javaName.substring(4);
            p.h(strSubstring2, "substring(...)");
            sb3.append(strSubstring2);
            return sb3.toString();
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f37560c = new C0480a();
        f37563d = new LinkedHashMap();
        f37566e = companion.d("SSL_RSA_WITH_NULL_MD5", 1);
        f37569f = companion.d("SSL_RSA_WITH_NULL_SHA", 2);
        f37572g = companion.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        f37575h = companion.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        f37578i = companion.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        f37581j = companion.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        f37584k = companion.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f37587l = companion.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        f37590m = companion.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        f37593n = companion.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        f37596o = companion.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        f37599p = companion.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        f37602q = companion.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        f37605r = companion.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        f37608s = companion.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        f37611t = companion.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        f37613u = companion.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        f37615v = companion.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        f37617w = companion.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        f37619x = companion.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        f37621y = companion.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        f37623z = companion.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        f37503A = companion.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        f37505B = companion.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        f37507C = companion.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        f37509D = companion.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        f37511E = companion.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        f37513F = companion.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        f37515G = companion.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f37517H = companion.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        f37519I = companion.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        f37521J = companion.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        f37523K = companion.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f37525L = companion.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        f37527M = companion.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        f37529N = companion.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        f37531O = companion.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        f37533P = companion.d("TLS_RSA_WITH_NULL_SHA256", 59);
        f37535Q = companion.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        f37537R = companion.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        f37539S = companion.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        f37541T = companion.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        f37543U = companion.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        f37545V = companion.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        f37547W = companion.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        f37549X = companion.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        f37551Y = companion.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        f37553Z = companion.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        f37555a0 = companion.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        f37558b0 = companion.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        f37561c0 = companion.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        f37564d0 = companion.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        f37567e0 = companion.d("TLS_PSK_WITH_RC4_128_SHA", 138);
        f37570f0 = companion.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        f37573g0 = companion.d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        f37576h0 = companion.d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        f37579i0 = companion.d("TLS_RSA_WITH_SEED_CBC_SHA", F.GESTURE_HEIGHT_DP);
        f37582j0 = companion.d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f37585k0 = companion.d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        f37588l0 = companion.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        f37591m0 = companion.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        f37594n0 = companion.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        f37597o0 = companion.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        f37600p0 = companion.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", PictureConfig.PREVIEW_VIDEO_CODE);
        f37603q0 = companion.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        f37606r0 = companion.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        f37609s0 = companion.d("TLS_FALLBACK_SCSV", 22016);
        f37612t0 = companion.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        f37614u0 = companion.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        f37616v0 = companion.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        f37618w0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        f37620x0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        f37622y0 = companion.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        f37624z0 = companion.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        f37504A0 = companion.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        f37506B0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        f37508C0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        f37510D0 = companion.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        f37512E0 = companion.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        f37514F0 = companion.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        f37516G0 = companion.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        f37518H0 = companion.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        f37520I0 = companion.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        f37522J0 = companion.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        f37524K0 = companion.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f37526L0 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f37528M0 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        f37530N0 = companion.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        f37532O0 = companion.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        f37534P0 = companion.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        f37536Q0 = companion.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        f37538R0 = companion.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        f37540S0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        f37542T0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        f37544U0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        f37546V0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        f37548W0 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        f37550X0 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        f37552Y0 = companion.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        f37554Z0 = companion.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f37556a1 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f37559b1 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        f37562c1 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        f37565d1 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f37568e1 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f37571f1 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        f37574g1 = companion.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        f37577h1 = companion.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        f37580i1 = companion.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        f37583j1 = companion.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f37586k1 = companion.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f37589l1 = companion.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        f37592m1 = companion.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        f37595n1 = companion.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f37598o1 = companion.d("TLS_AES_128_GCM_SHA256", 4865);
        f37601p1 = companion.d("TLS_AES_256_GCM_SHA384", 4866);
        f37604q1 = companion.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        f37607r1 = companion.d("TLS_AES_128_CCM_SHA256", 4868);
        f37610s1 = companion.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ a(String str, i iVar) {
        this(str);
    }

    /* renamed from: c, reason: from getter */
    public final String getJavaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }

    public a(String str) {
        this.javaName = str;
    }
}
