package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"LUa/J;", "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "n0", Const.INTENT_KEY_PKGNAME, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface J extends d.b {

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f6334a;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <R> R a(J j10, R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
            return (R) d.b.a.a(j10, r10, pVar);
        }

        public static <E extends d.b> E b(J j10, d.c<E> cVar) {
            return (E) d.b.a.b(j10, cVar);
        }

        public static kotlin.coroutines.d c(J j10, d.c<?> cVar) {
            return d.b.a.c(j10, cVar);
        }

        public static kotlin.coroutines.d d(J j10, kotlin.coroutines.d dVar) {
            return d.b.a.d(j10, dVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LUa/J$b;", "Lkotlin/coroutines/d$c;", "LUa/J;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.J$b, reason: from kotlin metadata */
    public static final class Companion implements d.c<J> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f6334a = new Companion();
    }

    void handleException(kotlin.coroutines.d context, Throwable exception);
}
