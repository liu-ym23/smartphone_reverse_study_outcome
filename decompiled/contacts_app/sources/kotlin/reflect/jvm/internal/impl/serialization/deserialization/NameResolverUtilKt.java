package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassId r3 = ClassId.fromString(r1.getQualifiedClassName(r2), r1.isLocalClassName(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "fromString(getQualifiedC… isLocalClassName(index))");
        return r3;
    }

    public static final Name getName(NameResolver r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Name r3 = Name.guessByFirstCharacter(r1.getString(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "guessByFirstCharacter(getString(index))");
        return r3;
    }
}
