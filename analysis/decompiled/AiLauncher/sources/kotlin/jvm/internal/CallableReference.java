package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import w9.InterfaceC5744c;
import w9.InterfaceC5747f;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

/* loaded from: classes4.dex */
public abstract class CallableReference implements InterfaceC5744c, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f34814a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient InterfaceC5744c reflected;
    private final String signature;

    public static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final NoReceiver f34814a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f34814a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // w9.InterfaceC5744c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // w9.InterfaceC5744c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC5744c compute() {
        InterfaceC5744c interfaceC5744c = this.reflected;
        if (interfaceC5744c != null) {
            return interfaceC5744c;
        }
        InterfaceC5744c interfaceC5744cComputeReflected = computeReflected();
        this.reflected = interfaceC5744cComputeReflected;
        return interfaceC5744cComputeReflected;
    }

    public abstract InterfaceC5744c computeReflected();

    @Override // w9.InterfaceC5743b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // w9.InterfaceC5744c
    public String getName() {
        return this.name;
    }

    public InterfaceC5747f getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? t.c(cls) : t.b(cls);
    }

    @Override // w9.InterfaceC5744c
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    public InterfaceC5744c getReflected() {
        InterfaceC5744c interfaceC5744cCompute = compute();
        if (interfaceC5744cCompute != this) {
            return interfaceC5744cCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // w9.InterfaceC5744c
    public InterfaceC5755n getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // w9.InterfaceC5744c
    public List<InterfaceC5756o> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // w9.InterfaceC5744c
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // w9.InterfaceC5744c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // w9.InterfaceC5744c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // w9.InterfaceC5744c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // w9.InterfaceC5744c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
