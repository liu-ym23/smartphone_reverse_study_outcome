package s7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.EasingType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Ls7/v;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "f", "e", "Ls7/v$a;", "Ls7/v$b;", "Ls7/v$c;", "Ls7/v$d;", "Ls7/v$e;", "Ls7/v$f;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class v {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Ls7/v$a;", "Ls7/v;", "", Const.JSON_KEY_SPEED, "<init>", "(F)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", "()F", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$a, reason: from toString */
    public static final /* data */ class Linear extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float speed;

        public Linear(float f10) {
            super(null);
            this.speed = f10;
        }

        /* renamed from: a, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Linear) && Float.compare(this.speed, ((Linear) other).speed) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.speed);
        }

        public String toString() {
            return "Linear(speed=" + this.speed + ")";
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0017\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001d\u0010!¨\u0006\""}, d2 = {"Ls7/v$b;", "Ls7/v;", "", "from", "to", "", "durationMs", "delayMs", "Lcom/stepos/motionkit/EasingType;", "easing", "<init>", "(FFJJLcom/stepos/motionkit/EasingType;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", Const.INTENT_KEY_UMID, "()F", Const.INTENT_KEY_PKGNAME, "e", "c", "J", "()J", "Lcom/stepos/motionkit/EasingType;", "()Lcom/stepos/motionkit/EasingType;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$b, reason: from toString */
    public static final /* data */ class OneShot extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float from;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float to;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long durationMs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final long delayMs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final EasingType easing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OneShot(float f10, float f11, long j10, long j11, EasingType easing) {
            super(null);
            kotlin.jvm.internal.p.i(easing, "easing");
            this.from = f10;
            this.to = f11;
            this.durationMs = j10;
            this.delayMs = j11;
            this.easing = easing;
        }

        /* renamed from: a, reason: from getter */
        public final long getDelayMs() {
            return this.delayMs;
        }

        /* renamed from: b, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: c, reason: from getter */
        public final EasingType getEasing() {
            return this.easing;
        }

        /* renamed from: d, reason: from getter */
        public final float getFrom() {
            return this.from;
        }

        /* renamed from: e, reason: from getter */
        public final float getTo() {
            return this.to;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OneShot)) {
                return false;
            }
            OneShot oneShot = (OneShot) other;
            return Float.compare(this.from, oneShot.from) == 0 && Float.compare(this.to, oneShot.to) == 0 && this.durationMs == oneShot.durationMs && this.delayMs == oneShot.delayMs && this.easing == oneShot.easing;
        }

        public int hashCode() {
            return (((((((Float.hashCode(this.from) * 31) + Float.hashCode(this.to)) * 31) + Long.hashCode(this.durationMs)) * 31) + Long.hashCode(this.delayMs)) * 31) + this.easing.hashCode();
        }

        public String toString() {
            return "OneShot(from=" + this.from + ", to=" + this.to + ", durationMs=" + this.durationMs + ", delayMs=" + this.delayMs + ", easing=" + this.easing + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls7/v$c;", "Ls7/v;", "", "min", "max", "", "periodMs", "<init>", "(FFJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", Const.INTENT_KEY_PKGNAME, "()F", "c", "J", "()J", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$c, reason: from toString */
    public static final /* data */ class Oscillate extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float min;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float max;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long periodMs;

        public Oscillate(float f10, float f11, long j10) {
            super(null);
            this.min = f10;
            this.max = f11;
            this.periodMs = j10;
        }

        /* renamed from: a, reason: from getter */
        public final float getMax() {
            return this.max;
        }

        /* renamed from: b, reason: from getter */
        public final float getMin() {
            return this.min;
        }

        /* renamed from: c, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Oscillate)) {
                return false;
            }
            Oscillate oscillate = (Oscillate) other;
            return Float.compare(this.min, oscillate.min) == 0 && Float.compare(this.max, oscillate.max) == 0 && this.periodMs == oscillate.periodMs;
        }

        public int hashCode() {
            return (((Float.hashCode(this.min) * 31) + Float.hashCode(this.max)) * 31) + Long.hashCode(this.periodMs);
        }

        public String toString() {
            return "Oscillate(min=" + this.min + ", max=" + this.max + ", periodMs=" + this.periodMs + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls7/v$d;", "Ls7/v;", "", "from", "to", "", "periodMs", "<init>", "(FFJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", "()F", Const.INTENT_KEY_PKGNAME, "c", "J", "()J", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$d, reason: from toString */
    public static final /* data */ class Sawtooth extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float from;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float to;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long periodMs;

        public Sawtooth(float f10, float f11, long j10) {
            super(null);
            this.from = f10;
            this.to = f11;
            this.periodMs = j10;
        }

        /* renamed from: a, reason: from getter */
        public final float getFrom() {
            return this.from;
        }

        /* renamed from: b, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        /* renamed from: c, reason: from getter */
        public final float getTo() {
            return this.to;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sawtooth)) {
                return false;
            }
            Sawtooth sawtooth = (Sawtooth) other;
            return Float.compare(this.from, sawtooth.from) == 0 && Float.compare(this.to, sawtooth.to) == 0 && this.periodMs == sawtooth.periodMs;
        }

        public int hashCode() {
            return (((Float.hashCode(this.from) * 31) + Float.hashCode(this.to)) * 31) + Long.hashCode(this.periodMs);
        }

        public String toString() {
            return "Sawtooth(from=" + this.from + ", to=" + this.to + ", periodMs=" + this.periodMs + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, d2 = {"Ls7/v$e;", "Ls7/v;", "", "Ls7/v$e$a;", "segments", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$e, reason: from toString */
    public static final /* data */ class Sequence extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Segment> segments;

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u0019\u0010\u001e¨\u0006\u001f"}, d2 = {"Ls7/v$e$a;", "", "", "from", "to", "", "durationMs", "Lcom/stepos/motionkit/EasingType;", "easing", "<init>", "(FFJLcom/stepos/motionkit/EasingType;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", "c", "()F", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "J", "()J", "Lcom/stepos/motionkit/EasingType;", "()Lcom/stepos/motionkit/EasingType;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: s7.v$e$a, reason: from toString */
        public static final /* data */ class Segment {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final float from;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final float to;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final long durationMs;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final EasingType easing;

            public Segment(float f10, float f11, long j10, EasingType easing) {
                kotlin.jvm.internal.p.i(easing, "easing");
                this.from = f10;
                this.to = f11;
                this.durationMs = j10;
                this.easing = easing;
            }

            /* renamed from: a, reason: from getter */
            public final long getDurationMs() {
                return this.durationMs;
            }

            /* renamed from: b, reason: from getter */
            public final EasingType getEasing() {
                return this.easing;
            }

            /* renamed from: c, reason: from getter */
            public final float getFrom() {
                return this.from;
            }

            /* renamed from: d, reason: from getter */
            public final float getTo() {
                return this.to;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Segment)) {
                    return false;
                }
                Segment segment = (Segment) other;
                return Float.compare(this.from, segment.from) == 0 && Float.compare(this.to, segment.to) == 0 && this.durationMs == segment.durationMs && this.easing == segment.easing;
            }

            public int hashCode() {
                return (((((Float.hashCode(this.from) * 31) + Float.hashCode(this.to)) * 31) + Long.hashCode(this.durationMs)) * 31) + this.easing.hashCode();
            }

            public String toString() {
                return "Segment(from=" + this.from + ", to=" + this.to + ", durationMs=" + this.durationMs + ", easing=" + this.easing + ")";
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Sequence(List<Segment> segments) {
            super(null);
            kotlin.jvm.internal.p.i(segments, "segments");
            this.segments = segments;
        }

        public final List<Segment> a() {
            return this.segments;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sequence) && kotlin.jvm.internal.p.d(this.segments, ((Sequence) other).segments);
        }

        public int hashCode() {
            return this.segments.hashCode();
        }

        public String toString() {
            return "Sequence(segments=" + this.segments + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls7/v$f;", "Ls7/v;", "", "min", "max", "", "periodMs", "<init>", "(FFJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", Const.INTENT_KEY_PKGNAME, "()F", "c", "J", "()J", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: s7.v$f, reason: from toString */
    public static final /* data */ class TriangleWave extends v {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float min;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float max;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long periodMs;

        public TriangleWave(float f10, float f11, long j10) {
            super(null);
            this.min = f10;
            this.max = f11;
            this.periodMs = j10;
        }

        /* renamed from: a, reason: from getter */
        public final float getMax() {
            return this.max;
        }

        /* renamed from: b, reason: from getter */
        public final float getMin() {
            return this.min;
        }

        /* renamed from: c, reason: from getter */
        public final long getPeriodMs() {
            return this.periodMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TriangleWave)) {
                return false;
            }
            TriangleWave triangleWave = (TriangleWave) other;
            return Float.compare(this.min, triangleWave.min) == 0 && Float.compare(this.max, triangleWave.max) == 0 && this.periodMs == triangleWave.periodMs;
        }

        public int hashCode() {
            return (((Float.hashCode(this.min) * 31) + Float.hashCode(this.max)) * 31) + Long.hashCode(this.periodMs);
        }

        public String toString() {
            return "TriangleWave(min=" + this.min + ", max=" + this.max + ", periodMs=" + this.periodMs + ")";
        }
    }

    public /* synthetic */ v(kotlin.jvm.internal.i iVar) {
        this();
    }

    public v() {
    }
}
