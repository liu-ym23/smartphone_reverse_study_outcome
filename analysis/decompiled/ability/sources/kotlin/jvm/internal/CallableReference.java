package kotlin.jvm.internal;

import Z7.u;
import Z7.v;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

/* loaded from: classes3.dex */
public abstract class CallableReference implements Z7.c, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f4915a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient Z7.c reflected;
    private final String signature;

    public static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final NoReceiver f4915a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f4915a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER, null, null, null, false);
    }

    @Override // Z7.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // Z7.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public Z7.c compute() {
        Z7.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        Z7.c cVarComputeReflected = computeReflected();
        this.reflected = cVarComputeReflected;
        return cVarComputeReflected;
    }

    public abstract Z7.c computeReflected();

    @Override // Z7.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // Z7.c
    public String getName() {
        return this.name;
    }

    public Z7.f getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? m.f4928a.c(cls, "") : m.f4928a.b(cls);
    }

    @Override // Z7.c
    public List<Z7.n> getParameters() {
        return getReflected().getParameters();
    }

    public abstract Z7.c getReflected();

    @Override // Z7.c
    public u getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // Z7.c
    public List<v> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // Z7.c
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // Z7.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // Z7.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // Z7.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // Z7.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
