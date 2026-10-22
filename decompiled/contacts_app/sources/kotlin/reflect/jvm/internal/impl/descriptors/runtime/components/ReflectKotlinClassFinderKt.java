package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId r0) {
        return toRuntimeFqName(r0);
    }

    private static final String toRuntimeFqName(ClassId r7) {
        String r1 = r7.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "relativeClassName.asString()");
        String r0 = StringsKt.replace$default(r1, '.', Typography.dollar, false, 4, null);
        if (r7.getPackageFqName().isRoot() == false) goto L6;
        return r0;
    L6:
        return r7.getPackageFqName() + '.' + r0;
    }
}
