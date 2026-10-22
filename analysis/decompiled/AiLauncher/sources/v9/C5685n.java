package v9;

import com.autonavi.aps.amapapi.config.Const;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;
import t9.C5526c;
import v9.C5678g;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0019\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0015\u001a\u0019\u0010 \u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b \u0010\u0017\u001a\u0019\u0010!\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\u001a\u001a\u0019\u0010\"\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010\u001d\u001a!\u0010#\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b%\u0010&\u001a!\u0010'\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b'\u0010(\u001a!\u0010)\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lv9/i;", "Lkotlin/random/Random;", "random", "", "q", "(Lv9/i;Lkotlin/random/Random;)I", "to", "Lv9/g;", "p", "(II)Lv9/g;", "step", "r", "(Lv9/g;I)Lv9/g;", "s", "(II)Lv9/i;", "", "Lv9/l;", "t", "(JJ)Lv9/l;", "minimumValue", "f", "(II)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(JJ)J", "", "e", "(FF)F", "", Const.INTENT_KEY_UMID, "(DD)D", "maximumValue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "(III)I", "o", "(JJJ)J", "m", "(FFF)F", "l", "(DDD)D", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* renamed from: v9.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5685n extends C5684m {
    public static double d(double d10, double d11) {
        return d10 < d11 ? d11 : d10;
    }

    public static float e(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long g(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static double h(double d10, double d11) {
        return d10 > d11 ? d11 : d10;
    }

    public static float i(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static int j(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long k(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static double l(double d10, double d11, double d12) {
        if (d11 <= d12) {
            return d10 < d11 ? d11 : d10 > d12 ? d12 : d10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d12 + " is less than minimum " + d11 + '.');
    }

    public static float m(float f10, float f11, float f12) {
        if (f11 <= f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + '.');
    }

    public static int n(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static long o(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    public static C5678g p(int i10, int i11) {
        return C5678g.INSTANCE.a(i10, i11, -1);
    }

    public static int q(C5680i c5680i, Random random) {
        p.i(c5680i, "<this>");
        p.i(random, "random");
        try {
            return C5526c.f(random, c5680i);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public static C5678g r(C5678g c5678g, int i10) {
        p.i(c5678g, "<this>");
        C5684m.a(i10 > 0, Integer.valueOf(i10));
        C5678g.Companion aVar = C5678g.INSTANCE;
        int iB = c5678g.getFirst();
        int iC = c5678g.getLast();
        if (c5678g.getStep() <= 0) {
            i10 = -i10;
        }
        return aVar.a(iB, iC, i10);
    }

    public static C5680i s(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? C5680i.INSTANCE.a() : new C5680i(i10, i11 - 1);
    }

    public static C5683l t(long j10, long j11) {
        return j11 <= Long.MIN_VALUE ? C5683l.INSTANCE.a() : new C5683l(j10, j11 - 1);
    }
}
