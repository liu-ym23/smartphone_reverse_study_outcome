package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeParameterErasureOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public TypeParameterErasureOptions(boolean r1, boolean r2) {
        this.leaveNonTypeParameterTypes = r1;
        this.intersectUpperBounds = r2;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }
}
