package kotlin.coroutines;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/EmptyCoroutineContext;", "LH7/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", AppAgent.CONSTRUCT, "()V", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmptyCoroutineContext implements h, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyCoroutineContext f4908a = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f4908a;
    }

    @Override // H7.h
    public final Object fold(Object obj, n nVar) {
        return obj;
    }

    @Override // H7.h
    public final f get(g key) {
        k.f(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // H7.h
    public final h minusKey(g key) {
        k.f(key, "key");
        return this;
    }

    @Override // H7.h
    public final h plus(h context) {
        k.f(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
