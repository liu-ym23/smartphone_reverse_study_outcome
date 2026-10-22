package io.ktor.server.application;

import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/application/ClassLoaderAwareContinuationInterceptor;", "Lkotlin/coroutines/c;", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Le9/c;", "continuation", "interceptContinuation", "(Le9/c;)Le9/c;", "Lkotlin/coroutines/d$c;", "key", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ClassLoaderAwareContinuationInterceptor implements kotlin.coroutines.c {
    public static final ClassLoaderAwareContinuationInterceptor INSTANCE = new ClassLoaderAwareContinuationInterceptor();
    private static final d.c<?> key = kotlin.coroutines.c.INSTANCE;

    private ClassLoaderAwareContinuationInterceptor() {
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r10, p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) c.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> cVar) {
        return (E) c.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c<?> getKey() {
        return key;
    }

    @Override // kotlin.coroutines.c
    public <T> InterfaceC4014c<T> interceptContinuation(InterfaceC4014c<? super T> continuation) {
        kotlin.jvm.internal.p.i(continuation, "continuation");
        return new InterfaceC4014c<T>(continuation, Thread.currentThread().getContextClassLoader()) { // from class: io.ktor.server.application.ClassLoaderAwareContinuationInterceptor.interceptContinuation.1
            final /* synthetic */ ClassLoader $classLoader;
            final /* synthetic */ InterfaceC4014c<T> $continuation;
            private final kotlin.coroutines.d context;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$continuation = continuation;
                this.$classLoader = classLoader;
                this.context = continuation.getContext();
            }

            @Override // e9.InterfaceC4014c
            public kotlin.coroutines.d getContext() {
                return this.context;
            }

            @Override // e9.InterfaceC4014c
            public void resumeWith(Object result) {
                Thread.currentThread().setContextClassLoader(this.$classLoader);
                this.$continuation.resumeWith(result);
            }
        };
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return c.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return c.a.d(this, dVar);
    }

    @Override // kotlin.coroutines.c
    public void releaseInterceptedContinuation(InterfaceC4014c<?> interfaceC4014c) {
        c.a.e(this, interfaceC4014c);
    }
}
