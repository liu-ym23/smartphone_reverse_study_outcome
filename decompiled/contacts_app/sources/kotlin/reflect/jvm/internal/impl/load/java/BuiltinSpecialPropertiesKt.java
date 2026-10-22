package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltinSpecialPropertiesKt {
    public static final /* synthetic */ FqName access$child(FqName r0, String r1) {
        return child(r0, r1);
    }

    public static final /* synthetic */ FqName access$childSafe(FqNameUnsafe r0, String r1) {
        return childSafe(r0, r1);
    }

    private static final FqName child(FqName r0, String r1) {
        FqName r2 = r0.child(Name.identifier(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "child(Name.identifier(name))");
        return r2;
    }

    private static final FqName childSafe(FqNameUnsafe r0, String r1) {
        FqName r2 = r0.child(Name.identifier(r1)).toSafe();
        Intrinsics.checkNotNullExpressionValue(r2, "child(Name.identifier(name)).toSafe()");
        return r2;
    }
}
