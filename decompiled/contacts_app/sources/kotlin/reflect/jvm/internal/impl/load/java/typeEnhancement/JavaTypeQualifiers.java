package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeQualifiers {
    public static final Companion Companion = null;
    private static final JavaTypeQualifiers NONE = null;
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    private final MutabilityQualifier mutability;
    private final NullabilityQualifier nullability;

    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.access$getNONE$cp();
        }
    }

    public JavaTypeQualifiers(NullabilityQualifier r1, MutabilityQualifier r2, boolean r3, boolean r4) {
        this.nullability = r1;
        this.mutability = r2;
        this.definitelyNotNull = r3;
        this.isNullabilityQualifierForWarning = r4;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier r1, MutabilityQualifier r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNONE$cp() {
        return NONE;
    }

    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    static {
        Companion = new Companion(null);
        NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    }
}
