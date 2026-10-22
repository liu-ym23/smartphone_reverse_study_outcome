package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bæ\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\nJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "command", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "Companion", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SharingStarted {

    @NotNull
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f21498a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SharingStarted f21499b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final SharingStarted f21500c = null;

        static {
            f21498a = new a();
            f21499b = new e1();
            f21500c = new StartedLazily();
        }

        public a() {
        }

        public static /* synthetic */ SharingStarted b(a r10, long r11, long r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r11 = 0;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r12 = Long.MAX_VALUE;
        L9:
            return r10.a(r11, r12);
        }

        public final SharingStarted a(long r10, long r11) {
            return new StartedWhileSubscribed(r10, r11);
        }

        public final SharingStarted c() {
            return f21499b;
        }

        public final SharingStarted d() {
            return f21500c;
        }
    }

    static {
        Companion = a.f21498a;
    }

    @NotNull
    Flow<SharingCommand> command(@NotNull StateFlow<Integer> r10);
}
