package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e implements v5.b, Serializable {
    public static final Object NO_RECEIVER = d.f3666a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient v5.b reflected;
    private final String signature;

    public e(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // v5.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // v5.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public v5.b compute() {
        v5.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        v5.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract v5.b computeReflected();

    @Override // v5.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public v5.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return z.a(cls);
        }
        z.f3687a.getClass();
        return new s(cls);
    }

    @Override // v5.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract v5.b getReflected();

    @Override // v5.b
    public v5.i getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // v5.b
    public List<e0> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // v5.b
    public v5.m getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // v5.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // v5.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // v5.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
