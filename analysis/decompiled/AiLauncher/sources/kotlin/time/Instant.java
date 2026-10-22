package kotlin.time;

import com.autonavi.aps.amapapi.config.Const;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001eB\u0019\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001a¨\u0006%"}, d2 = {"Lkotlin/time/Instant;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "epochSeconds", "", "nanosecondsOfSecond", "<init>", "(JI)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "other", "c", "(Lkotlin/time/Instant;)I", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "J", "e", "()J", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Instant implements Comparable<Instant>, Serializable {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Instant f36181d = new Instant(-31557014167219200L, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final Instant f36182e = new Instant(31556889864403199L, 999999999);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long epochSeconds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int nanosecondsOfSecond;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlin/time/Instant$a;", "", "<init>", "()V", "", "epochSeconds", "nanosecondAdjustment", "Lkotlin/time/Instant;", Const.INTENT_KEY_PKGNAME, "(JJ)Lkotlin/time/Instant;", "", Const.INTENT_KEY_APIKEY, "(JI)Lkotlin/time/Instant;", "", "input", "e", "(Ljava/lang/CharSequence;)Lkotlin/time/Instant;", "MIN", "Lkotlin/time/Instant;", Const.INTENT_KEY_UMID, "()Lkotlin/time/Instant;", "MAX", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.time.Instant$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Instant a(long epochSeconds, int nanosecondAdjustment) {
            return b(epochSeconds, nanosecondAdjustment);
        }

        public final Instant b(long epochSeconds, long nanosecondAdjustment) {
            long j10 = nanosecondAdjustment / 1000000000;
            if ((nanosecondAdjustment ^ 1000000000) < 0 && j10 * 1000000000 != nanosecondAdjustment) {
                j10--;
            }
            long j11 = epochSeconds + j10;
            if ((epochSeconds ^ j11) < 0 && (j10 ^ epochSeconds) >= 0) {
                return epochSeconds > 0 ? Instant.INSTANCE.c() : Instant.INSTANCE.d();
            }
            if (j11 < -31557014167219200L) {
                return d();
            }
            if (j11 > 31556889864403199L) {
                return c();
            }
            long j12 = nanosecondAdjustment % 1000000000;
            return new Instant(j11, (int) (j12 + ((((j12 ^ 1000000000) & ((-j12) | j12)) >> 63) & 1000000000)));
        }

        public final Instant c() {
            return Instant.f36182e;
        }

        public final Instant d() {
            return Instant.f36181d;
        }

        public final Instant e(CharSequence input) {
            p.i(input, "input");
            return d.n(input).toInstant();
        }

        public Companion() {
        }
    }

    public Instant(long j10, int i10) {
        this.epochSeconds = j10;
        this.nanosecondsOfSecond = i10;
        if (-31557014167219200L > j10 || j10 >= 31556889864403200L) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return c.a(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(Instant other) {
        p.i(other, "other");
        int iL = p.l(this.epochSeconds, other.epochSeconds);
        return iL != 0 ? iL : p.k(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    /* renamed from: e, reason: from getter */
    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) other;
        return this.epochSeconds == instant.epochSeconds && this.nanosecondsOfSecond == instant.nanosecondsOfSecond;
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    /* renamed from: i, reason: from getter */
    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public String toString() {
        return d.j(this);
    }
}
