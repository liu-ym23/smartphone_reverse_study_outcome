package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.core.view.PointerIconCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: TypeMappingMode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeMappingMode {
    public static final TypeMappingMode CLASS_DECLARATION = null;
    public static final Companion Companion = null;
    public static final TypeMappingMode DEFAULT = null;
    public static final TypeMappingMode DEFAULT_UAST = null;
    public static final TypeMappingMode GENERIC_ARGUMENT = null;
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = null;
    public static final TypeMappingMode RETURN_TYPE_BOXED = null;
    public static final TypeMappingMode SUPER_TYPE = null;
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = null;
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = null;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    /* JADX INFO: compiled from: TypeMappingMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: TypeMappingMode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Variance.values().length];
            r0[Variance.IN_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Variance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public TypeMappingMode(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, TypeMappingMode r6, boolean r7, TypeMappingMode r8, TypeMappingMode r9, boolean r10) {
        this.needPrimitiveBoxing = r1;
        this.needInlineClassWrapping = r2;
        this.isForAnnotationParameter = r3;
        this.skipDeclarationSiteWildcards = r4;
        this.skipDeclarationSiteWildcardsIfPossible = r5;
        this.genericArgumentMode = r6;
        this.kotlinCollectionsToJavaCollections = r7;
        this.genericContravariantArgumentMode = r8;
        this.genericInvariantArgumentMode = r9;
        this.mapTypeAliases = r10;
    }

    public /* synthetic */ TypeMappingMode(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, TypeMappingMode r8, boolean r9, TypeMappingMode r10, TypeMappingMode r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = true;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r10 = r8;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r11 = r8;
    L30:
        if ((r13 & 512) == 0) goto L32;
        r12 = false;
    L32:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    static {
        Companion = new Companion(null);
        boolean r3 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        TypeMappingMode r8 = null;
        boolean r9 = false;
        TypeMappingMode r10 = null;
        TypeMappingMode r11 = null;
        boolean r12 = false;
        DefaultConstructorMarker r14 = null;
        TypeMappingMode r0 = new TypeMappingMode(r3, false, r5, r6, r7, r8, r9, r10, r11, r12, 1023, r14);
        GENERIC_ARGUMENT = r0;
        boolean r16 = false;
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
        boolean r20 = false;
        boolean r22 = false;
        TypeMappingMode r23 = null;
        TypeMappingMode r24 = null;
        boolean r25 = true;
        DefaultConstructorMarker r27 = null;
        TypeMappingMode r1 = new TypeMappingMode(r16, r17, r18, r19, r20, null, r22, r23, r24, r25, 511, r27);
        GENERIC_ARGUMENT_UAST = r1;
        RETURN_TYPE_BOXED = new TypeMappingMode(r3, true, r5, r6, r7, r8, r9, r10, r11, r12, PointerIconCompat.TYPE_GRABBING, r14);
        int r13 = 988;
        DEFAULT = new TypeMappingMode(r3, false, r5, r6, r7, r0, r9, r10, r11, r12, r13, r14);
        DEFAULT_UAST = new TypeMappingMode(r16, r17, r18, r19, r20, r1, r22, r23, r24, r25, 476, r27);
        CLASS_DECLARATION = new TypeMappingMode(r3, true, r5, r6, r7, r0, r9, r10, r11, r12, r13, r14);
        boolean r4 = false;
        boolean r15 = true;
        SUPER_TYPE = new TypeMappingMode(r3, r4, r5, r15, r7, r0, r9, r10, r11, r12, 983, r14);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(r3, r4, r5, r15, r7, r0, r9, r10, r11, r12, 919, r14);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(r3, r4, true, false, r7, r0, r9, r10, r11, r12, 984, r14);
    }

    public final TypeMappingMode toGenericArgumentMode(Variance r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "effectiveVariance");
        if (r3 == true) goto L5;
    L7:
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 != 1) goto L10;
        TypeMappingMode r5 = this.genericContravariantArgumentMode;
        if (r5 != null) goto L21;
        return this;
    L21:
        return r5;
    L10:
        if (r4 == 2) goto L14;
        r5 = this.genericArgumentMode;
        if (r5 != null) goto L21;
        return this;
    L14:
        r5 = this.genericInvariantArgumentMode;
        if (r5 != null) goto L21;
        return this;
    L5:
        if (this.isForAnnotationParameter == false) goto L7;
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }
}
