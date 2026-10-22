package kotlin.jvm.internal;

import a6.h0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class m extends e implements l, v5.f {
    private final int arity;

    public m(int i8, Object obj, Class cls, String str, String str2, int i9) {
        super(obj, cls, str, str2, (i9 & 1) == 1);
        this.arity = i8;
    }

    @Override // kotlin.jvm.internal.e
    public v5.b computeReflected() {
        z.f3687a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return getName().equals(mVar.getName()) && getSignature().equals(mVar.getSignature()) && p.a(getBoundReceiver(), mVar.getBoundReceiver()) && p.a(getOwner(), mVar.getOwner());
        }
        if (obj instanceof v5.f) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.l
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // v5.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // v5.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // v5.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // v5.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // v5.f
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        v5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.e
    public v5.f getReflected() {
        v5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (v5.f) bVarCompute;
        }
        throw new h0("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
