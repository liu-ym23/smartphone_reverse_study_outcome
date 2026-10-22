package kotlin.jvm.internal;

import w9.InterfaceC5744c;
import w9.InterfaceC5748g;

/* loaded from: classes4.dex */
public class FunctionReference extends CallableReference implements m, InterfaceC5748g {
    private final int arity;
    private final int flags;

    public FunctionReference(int i10) {
        this(i10, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5744c computeReflected() {
        return t.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && p.d(getBoundReceiver(), functionReference.getBoundReceiver()) && p.d(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof InterfaceC5748g) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // w9.InterfaceC5748g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // w9.InterfaceC5748g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // w9.InterfaceC5748g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // w9.InterfaceC5748g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, w9.InterfaceC5744c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC5744c interfaceC5744cCompute = compute();
        if (interfaceC5744cCompute != this) {
            return interfaceC5744cCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5748g getReflected() {
        return (InterfaceC5748g) super.getReflected();
    }

    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
