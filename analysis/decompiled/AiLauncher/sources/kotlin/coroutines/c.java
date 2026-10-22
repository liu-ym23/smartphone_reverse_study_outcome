package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/coroutines/c;", "Lkotlin/coroutines/d$b;", ExifInterface.GPS_DIRECTION_TRUE, "Le9/c;", "continuation", "interceptContinuation", "(Le9/c;)Le9/c;", "LY8/t;", "releaseInterceptedContinuation", "(Le9/c;)V", "r0", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface c extends d.b {

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f34783a;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <R> R a(c cVar, R r10, p<? super R, ? super d.b, ? extends R> operation) {
            kotlin.jvm.internal.p.i(operation, "operation");
            return (R) d.b.a.a(cVar, r10, operation);
        }

        public static <E extends d.b> E b(c cVar, d.c<E> key) {
            E e10;
            kotlin.jvm.internal.p.i(key, "key");
            if (!(key instanceof b)) {
                if (c.INSTANCE != key) {
                    return null;
                }
                kotlin.jvm.internal.p.g(cVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return cVar;
            }
            b bVar = (b) key;
            if (!bVar.a(cVar.getKey()) || (e10 = (E) bVar.b(cVar)) == null) {
                return null;
            }
            return e10;
        }

        public static d c(c cVar, d.c<?> key) {
            kotlin.jvm.internal.p.i(key, "key");
            if (!(key instanceof b)) {
                return c.INSTANCE == key ? EmptyCoroutineContext.f34779a : cVar;
            }
            b bVar = (b) key;
            return (!bVar.a(cVar.getKey()) || bVar.b(cVar) == null) ? cVar : EmptyCoroutineContext.f34779a;
        }

        public static d d(c cVar, d context) {
            kotlin.jvm.internal.p.i(context, "context");
            return d.b.a.d(cVar, context);
        }

        public static void e(c cVar, InterfaceC4014c<?> continuation) {
            kotlin.jvm.internal.p.i(continuation, "continuation");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/c$b;", "Lkotlin/coroutines/d$c;", "Lkotlin/coroutines/c;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.coroutines.c$b, reason: from kotlin metadata */
    public static final class Companion implements d.c<c> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f34783a = new Companion();
    }

    <T> InterfaceC4014c<T> interceptContinuation(InterfaceC4014c<? super T> continuation);

    void releaseInterceptedContinuation(InterfaceC4014c<?> continuation);
}
