package kotlin.jvm.internal;

import Z7.t;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements t {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && k.b(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof t) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // Z7.t
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // Z7.t
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        Z7.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public t getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        Z7.c cVarCompute = compute();
        if (cVarCompute != this) {
            return (t) cVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public PropertyReference(int i, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }
}
