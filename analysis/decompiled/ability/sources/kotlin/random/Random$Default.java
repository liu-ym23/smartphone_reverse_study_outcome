package kotlin.random;

import W7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"kotlin/random/Random$Default", "LW7/c;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", AppAgent.CONSTRUCT, "()V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "defaultRandom", "LW7/c;", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Random$Default extends c implements Serializable {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", AppAgent.CONSTRUCT, "()V", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final Serialized f4929a = new Serialized();

        private Serialized() {
        }

        private final Object readResolve() {
            return c.f1492a;
        }
    }

    public /* synthetic */ Random$Default(int i) {
        this();
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return Serialized.f4929a;
    }

    @Override // W7.c
    public final int a(int i) {
        return c.b.a(i);
    }

    @Override // W7.c
    public final int b() {
        return c.b.b();
    }

    @Override // W7.c
    public final int c(int i, int i6) {
        return c.b.c(i, i6);
    }

    @Override // W7.c
    public final long d() {
        return c.b.d();
    }

    @Override // W7.c
    public final long e(long j5, long j6) {
        throw null;
    }

    private Random$Default() {
    }
}
