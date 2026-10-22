package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ*\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "interceptContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "", "releaseInterceptedContinuation", "(Lkotlin/coroutines/Continuation;)V", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "Key", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.Element {

    @NotNull
    public static final b Key = null;

    public static final class a {
        public static CoroutineContext.Element a(ContinuationInterceptor r10, CoroutineContext.Key r11) {
            q.g(r11, "key");
            if ((r11 instanceof kotlin.coroutines.b) == false) goto L11;
            kotlin.coroutines.b r12 = (kotlin.coroutines.b) r11;
            if (r12.a(r10.getKey()) == false) goto L15;
            CoroutineContext.Element r13 = r12.b(r10);
            if (r13 != null) goto L9;
            return null;
        L9:
            return r13;
        L15:
            return null;
        L11:
            if (ContinuationInterceptor.Key != r11) goto L14;
            q.e(r10, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return r10;
        L14:
            return null;
        }

        public static CoroutineContext b(ContinuationInterceptor r10, CoroutineContext.Key r11) {
            q.g(r11, "key");
            if ((r11 instanceof kotlin.coroutines.b) == false) goto L11;
            kotlin.coroutines.b r12 = (kotlin.coroutines.b) r11;
            if (r12.a(r10.getKey()) == true) goto L7;
            return r10;
        L7:
            if (r12.b(r10) != null) goto L9;
            return r10;
        L9:
            return EmptyCoroutineContext.INSTANCE;
        L11:
            if (ContinuationInterceptor.Key == r11) goto L13;
            return r10;
        L13:
            return EmptyCoroutineContext.INSTANCE;
        }
    }

    public static final class b implements CoroutineContext.Key {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f21114a = null;

        static {
            f21114a = new b();
        }

        public b() {
        }
    }

    static {
        Key = b.f21114a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> r10);

    @NotNull
    <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> r10);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> r10);

    void releaseInterceptedContinuation(@NotNull Continuation<?> r10);
}
