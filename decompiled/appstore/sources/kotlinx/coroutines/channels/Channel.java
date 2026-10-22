package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.c0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final int BUFFERED = -2;
    public static final int CONFLATED = -1;

    @NotNull
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";

    @NotNull
    public static final b Factory = null;
    public static final int OPTIONAL_CHANNEL = -3;
    public static final int RENDEZVOUS = 0;
    public static final int UNLIMITED = Integer.MAX_VALUE;

    public static final class a {
        public static boolean a(Channel r10, Object r11) {
            return SendChannel.a.b(r10, r11);
        }

        public static Object b(Channel r10) {
            return ReceiveChannel.DefaultImpls.b(r10);
        }

        public static Object c(Channel r10, Continuation r11) {
            return ReceiveChannel.DefaultImpls.c(r10, r11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f21355a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f21356b = 0;

        static {
            f21355a = new b();
            f21356b = c0.b(Channel.DEFAULT_BUFFER_PROPERTY_NAME, 64, 1, 2147483646);
        }

        public b() {
        }

        public final int a() {
            return f21356b;
        }
    }

    static {
        Factory = b.f21355a;
    }
}
