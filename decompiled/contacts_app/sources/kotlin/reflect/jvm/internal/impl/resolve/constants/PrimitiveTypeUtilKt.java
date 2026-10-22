package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: PrimitiveTypeUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrimitiveTypeUtilKt {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return CollectionsKt.listOf(new SimpleType[]{r3.getBuiltIns().getIntType(), r3.getBuiltIns().getLongType(), r3.getBuiltIns().getByteType(), r3.getBuiltIns().getShortType()});
    }
}
