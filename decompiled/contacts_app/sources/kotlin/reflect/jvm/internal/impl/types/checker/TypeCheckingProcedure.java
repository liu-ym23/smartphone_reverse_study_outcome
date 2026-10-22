package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.framwork.core.sdklib.DBHelper;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class TypeCheckingProcedure {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 7) goto L6;
        if (r9 == 10) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 7) goto L11;
        if (r9 == 10) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r9) {
            case 1: goto L27;
            case 2: goto L14;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L14;
            case 18: goto L27;
            case 19: goto L14;
            case 20: goto L27;
            case 21: goto L16;
            case 22: goto L15;
            case 23: goto L25;
            default: goto L14;
        };
    L14:
        r5[0] = "subtype";
    L29:
        if (r9 == 7) goto L33;
        if (r9 == 10) goto L32;
        r5[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
    L34:
        switch(r9) {
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L41;
            case 10: goto L43;
            case 11: goto L40;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L39;
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L38;
            case 18: goto L38;
            case 19: goto L37;
            case 20: goto L37;
            case 21: goto L36;
            case 22: goto L36;
            case 23: goto L36;
            default: goto L35;
        };
    L35:
        r5[2] = "findCorrespondingSupertype";
        goto L43
    L36:
        r5[2] = "capture";
        goto L43
    L37:
        r5[2] = "checkSubtypeForTheSameConstructor";
        goto L43
    L38:
        r5[2] = "isSubtypeOf";
        goto L43
    L39:
        r5[2] = "getEffectiveProjectionKind";
        goto L43
    L40:
        r5[2] = "equalTypes";
        goto L43
    L41:
        r5[2] = "getInType";
        goto L43
    L42:
        r5[2] = "getOutType";
    L43:
        String r3 = String.format(r2, r5);
        if (r9 == 7) goto L48;
        if (r9 == 10) goto L48;
        throw new IllegalArgumentException(r3);
    L48:
        throw new IllegalStateException(r3);
    L32:
        r5[1] = "getInType";
        goto L34
    L33:
        r5[1] = "getOutType";
        goto L34
    L15:
        r5[0] = "supertypeArgumentProjection";
        goto L29
    L16:
        r5[0] = "subtypeArgumentProjection";
        goto L29
    L17:
        r5[0] = "typeArgumentVariance";
        goto L29
    L18:
        r5[0] = "typeParameterVariance";
        goto L29
    L19:
        r5[0] = "typeArgument";
        goto L29
    L20:
        r5[0] = "typeParameter";
        goto L29
    L21:
        r5[0] = DBHelper.COL_TYPE2;
        goto L29
    L22:
        r5[0] = "type1";
        goto L29
    L23:
        r5[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        goto L29
    L24:
        r5[0] = "argument";
        goto L29
    L25:
        r5[0] = "parameter";
        goto L29
    L26:
        r5[0] = "typeCheckingProcedureCallbacks";
        goto L29
    L27:
        r5[0] = "supertype";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    public static KotlinType findCorrespondingSupertype(KotlinType r1, KotlinType r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(1);
    L7:
        return findCorrespondingSupertype(r1, r2, new TypeCheckerProcedureCallbacksImpl());
    }

    public static KotlinType findCorrespondingSupertype(KotlinType r1, KotlinType r2, TypeCheckingProcedureCallbacks r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(3);
    L6:
        if (r3 != null) goto L9;
        $$$reportNull$$$0(4);
    L9:
        return UtilsKt.findCorrespondingSupertype(r1, r2, r3);
    }
}
