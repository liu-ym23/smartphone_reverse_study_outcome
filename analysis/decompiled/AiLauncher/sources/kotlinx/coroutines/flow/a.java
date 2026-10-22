package kotlinx.coroutines.flow;

import Xa.b;
import Xa.s;
import Xa.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/flow/a;", "", "LXa/t;", "", "subscriptionCount", "LXa/b;", "Lkotlinx/coroutines/flow/SharingCommand;", Const.INTENT_KEY_APIKEY, "(LXa/t;)LXa/b;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f36670a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/a$a;", "", "<init>", "()V", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/a;", Const.INTENT_KEY_APIKEY, "(JJ)Lkotlinx/coroutines/flow/a;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/coroutines/flow/a;", "c", "()Lkotlinx/coroutines/flow/a;", "Eagerly", Const.INTENT_KEY_UMID, "Lazily", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f36670a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final a Eagerly = new s();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final a Lazily = new StartedLazily();

        public static /* synthetic */ a b(Companion companion, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            if ((i10 & 2) != 0) {
                j11 = Long.MAX_VALUE;
            }
            return companion.a(j10, j11);
        }

        public final a a(long stopTimeoutMillis, long replayExpirationMillis) {
            return new StartedWhileSubscribed(stopTimeoutMillis, replayExpirationMillis);
        }

        public final a c() {
            return Eagerly;
        }

        public final a d() {
            return Lazily;
        }
    }

    b<SharingCommand> a(t<Integer> subscriptionCount);
}
