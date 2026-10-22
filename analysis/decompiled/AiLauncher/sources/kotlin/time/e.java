package kotlin.time;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.Instant;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bs\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lkotlin/time/e;", "", "Lkotlin/time/Instant;", "toInstant", "()Lkotlin/time/Instant;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lkotlin/time/e$a;", "Lkotlin/time/e$b;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface e {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/time/e$a;", "Lkotlin/time/e;", "", "error", "", "input", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "Lkotlin/time/Instant;", "toInstant", "()Lkotlin/time/Instant;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getError", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/CharSequence;", "getInput", "()Ljava/lang/CharSequence;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String error;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final CharSequence input;

        public a(String error, CharSequence input) {
            p.i(error, "error");
            p.i(input, "input");
            this.error = error;
            this.input = input;
        }

        @Override // kotlin.time.e
        public Instant toInstant() {
            throw new InstantFormatException(this.error + " when parsing an Instant from \"" + d.x(this.input, 64) + JsonFactory.DEFAULT_QUOTE_CHAR);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/time/e$b;", "Lkotlin/time/e;", "", "epochSeconds", "", "nanosecondsOfSecond", "<init>", "(JI)V", "Lkotlin/time/Instant;", "toInstant", "()Lkotlin/time/Instant;", Const.INTENT_KEY_APIKEY, "J", "getEpochSeconds", "()J", Const.INTENT_KEY_PKGNAME, "I", "getNanosecondsOfSecond", "()I", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long epochSeconds;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int nanosecondsOfSecond;

        public b(long j10, int i10) {
            this.epochSeconds = j10;
            this.nanosecondsOfSecond = i10;
        }

        @Override // kotlin.time.e
        public Instant toInstant() {
            long j10 = this.epochSeconds;
            Instant.Companion companion = Instant.INSTANCE;
            if (j10 >= companion.d().getEpochSeconds() && this.epochSeconds <= companion.c().getEpochSeconds()) {
                return companion.a(this.epochSeconds, this.nanosecondsOfSecond);
            }
            throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + this.epochSeconds + ')');
        }
    }

    Instant toInstant();
}
