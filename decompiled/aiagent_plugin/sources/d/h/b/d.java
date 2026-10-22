package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements d.m.b, Serializable {
    public static final Object NO_RECEIVER = null;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient d.m.b reflected;
    private final String signature;

    /* JADX INFO: compiled from: CallableReference.java */
    private static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f38488a = null;

        private a() {
        }

        static /* synthetic */ a a() {
            return f38488a;
        }

        static {
            f38488a = new a();
        }
    }

    public abstract d.m.b computeReflected();

    static {
        NO_RECEIVER = a.a();
    }

    public d() {
        this(NO_RECEIVER);
    }

    public d(Object r7) {
        this(r7, null, null, null, false);
    }

    public d(Object r1, Class r2, String r3, String r4, boolean r5) {
        this.receiver = r1;
        this.owner = r2;
        this.name = r3;
        this.signature = r4;
        this.isTopLevel = r5;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public d.m.b compute() {
        d.m.b r0 = this.reflected;
        if (r0 != null) goto L6;
        d.m.b r1 = computeReflected();
        this.reflected = r1;
        return r1;
    L6:
        return r0;
    }

    public d.m.b getReflected() {
        d.m.b r0 = compute();
        if (r0 == this) goto L6;
        return r0;
    L6:
        throw new d.h.b();
    }

    public d.m.d getOwner() {
        Class r0 = this.owner;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return aa.a(r0);
    L9:
        return aa.b(r0);
    }

    @Override // d.m.b
    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // d.m.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    @Override // d.m.b
    public d.m.k getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // d.m.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // d.m.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // d.m.b
    public Object call(Object... r1) {
        return getReflected().call(r1);
    }

    @Override // d.m.b
    public Object callBy(Map r3) {
        Map<Object, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return getReflected().callBy(r4);
    }

    @Override // d.m.b
    public d.m.l getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // d.m.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // d.m.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // d.m.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // d.m.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
