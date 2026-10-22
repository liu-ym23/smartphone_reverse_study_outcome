package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {

    /* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
    public static final class DefaultImpls {
        public static KotlinTypeMarker makeNullable(TypeSystemCommonBackendContext r2, KotlinTypeMarker r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            SimpleTypeMarker r0 = r2.asSimpleType(r3);
            if (r0 == null) goto L8;
            SimpleTypeMarker r4 = r2.withNullability(r0, true);
            if (r4 != null) goto L7;
            return r3;
        L7:
            return r4;
        L8:
            return r3;
        }
    }

    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r1);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r1);

    PrimitiveType getPrimitiveType(TypeConstructorMarker r1);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r1);

    KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r1);

    boolean hasAnnotation(KotlinTypeMarker r1, FqName r2);

    boolean isInlineClass(TypeConstructorMarker r1);

    boolean isUnderKotlinPackage(TypeConstructorMarker r1);

    KotlinTypeMarker makeNullable(KotlinTypeMarker r1);
}
