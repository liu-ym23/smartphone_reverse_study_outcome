package kotlin.jvm.internal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* loaded from: classes3.dex */
public abstract class FunctionReference extends CallableReference implements h, Z7.g {
    private final int arity;
    private final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c computeReflected() {
        return m.f4928a.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && k.b(getBoundReceiver(), functionReference.getBoundReceiver()) && k.b(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof Z7.g) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // Z7.g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // Z7.g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // Z7.g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // Z7.g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        Z7.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        if (AppAgent.CONSTRUCT.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public Z7.g getReflected() {
        Z7.c cVarCompute = compute();
        if (cVarCompute != this) {
            return (Z7.g) cVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }
}
