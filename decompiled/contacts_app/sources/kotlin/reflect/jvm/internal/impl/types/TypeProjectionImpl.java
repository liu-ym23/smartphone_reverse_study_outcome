package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes4.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 4) goto L6;
        if (r9 == 5) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 4) goto L11;
        if (r9 == 5) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r6[0] = "projection";
    L19:
        if (r9 == 4) goto L23;
        if (r9 == 5) goto L22;
        r6[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
    L24:
        if (r9 == 3) goto L31;
        if (r9 == 4) goto L32;
        if (r9 == 5) goto L32;
        if (r9 == 6) goto L30;
        r6[2] = "<init>";
        goto L32
    L30:
        r6[2] = "refine";
    L32:
        String r3 = String.format(r2, r6);
        if (r9 == 4) goto L37;
        if (r9 == 5) goto L37;
        throw new IllegalArgumentException(r3);
    L37:
        throw new IllegalStateException(r3);
    L31:
        r6[2] = "replaceType";
        goto L32
    L22:
        r6[1] = "getType";
        goto L24
    L23:
        r6[1] = "getProjectionKind";
        goto L24
    L15:
        r6[0] = "kotlinTypeRefiner";
        goto L19
    L16:
        r6[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        goto L19
    L17:
        r6[0] = "type";
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    public TypeProjectionImpl(Variance r2, KotlinType r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.projection = r2;
        this.type = r3;
    }

    public TypeProjectionImpl(KotlinType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this(Variance.INVARIANT, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        Variance r1 = this.projection;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        KotlinType r1 = this.type;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return new TypeProjectionImpl(this.projection, r3.refineType(this.type));
    }
}
