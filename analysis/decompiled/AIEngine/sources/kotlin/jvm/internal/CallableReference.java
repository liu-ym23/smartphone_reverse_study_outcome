package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class CallableReference implements ec.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f10072a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient ec.b reflected;
    private final String signature;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final NoReceiver f10072a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f10072a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // ec.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // ec.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public ec.b compute() {
        ec.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        ec.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract ec.b computeReflected();

    @Override // ec.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // ec.b
    public String getName() {
        return this.name;
    }

    public ec.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return i.a(cls);
        }
        i.f10086a.getClass();
        return new h(cls);
    }

    @Override // ec.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public ec.b getReflected() {
        ec.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // ec.b
    public ec.i getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // ec.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // ec.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // ec.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // ec.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // ec.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // ec.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
