package Za;

import Ua.M0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0016\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0015*\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"LZa/K;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/M0;", UxipConstants.f30680s, "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "Lkotlin/coroutines/d;", "context", "f1", "(Lkotlin/coroutines/d;)Ljava/lang/Object;", "oldState", "LY8/t;", "e0", "(Lkotlin/coroutines/d;Ljava/lang/Object;)V", "Lkotlin/coroutines/d$c;", "key", "minusKey", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d;", "Lkotlin/coroutines/d$b;", ExifInterface.LONGITUDE_EAST, "get", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d$b;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/ThreadLocal;", "c", "Lkotlin/coroutines/d$c;", "getKey", "()Lkotlin/coroutines/d$c;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.K, reason: from toString */
/* loaded from: classes5.dex */
public final class ThreadLocal<T> implements M0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final T value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final java.lang.ThreadLocal<T> threadLocal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final d.c<?> key;

    public ThreadLocal(T t10, java.lang.ThreadLocal<T> threadLocal) {
        this.value = t10;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // Ua.M0
    public void e0(kotlin.coroutines.d context, T oldState) {
        this.threadLocal.set(oldState);
    }

    @Override // Ua.M0
    public T f1(kotlin.coroutines.d context) {
        T t10 = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return t10;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ <R> R fold(R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
        return (R) M0.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> key) {
        if (!kotlin.jvm.internal.p.d(getKey(), key)) {
            return null;
        }
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.d.b
    public d.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d minusKey(d.c<?> key) {
        return kotlin.jvm.internal.p.d(getKey(), key) ? EmptyCoroutineContext.f34779a : this;
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d plus(kotlin.coroutines.d dVar) {
        return M0.a.b(this, dVar);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }
}
