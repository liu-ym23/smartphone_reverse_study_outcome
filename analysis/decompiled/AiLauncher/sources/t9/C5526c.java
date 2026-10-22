package t9;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import v9.C5680i;

@Metadata(d1 = {"\u00000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "seed", "Lkotlin/random/Random;", Const.INTENT_KEY_APIKEY, "(J)Lkotlin/random/Random;", "Lv9/i;", "range", "", "f", "(Lkotlin/random/Random;Lv9/i;)I", UxipConstants.f30680s, "e", "(I)I", "bitCount", Const.INTENT_KEY_BACKGROUND_COMMAND, "(II)I", "from", "until", "LY8/t;", "c", "(II)V", Const.INTENT_KEY_UMID, "(JJ)V", "", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: t9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5526c {
    public static final Random a(long j10) {
        return new XorWowRandom((int) j10, (int) (j10 >> 32));
    }

    public static final String b(Object from, Object until) {
        p.i(from, "from");
        p.i(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void c(int i10, int i11) {
        if (i11 <= i10) {
            throw new IllegalArgumentException(b(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final void d(long j10, long j11) {
        if (j11 <= j10) {
            throw new IllegalArgumentException(b(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int e(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final int f(Random random, C5680i range) {
        p.i(random, "<this>");
        p.i(range, "range");
        if (!range.isEmpty()) {
            return range.getLast() < Integer.MAX_VALUE ? random.h(range.getFirst(), range.getLast() + 1) : range.getFirst() > Integer.MIN_VALUE ? random.h(range.getFirst() - 1, range.getLast()) + 1 : random.f();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int g(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
