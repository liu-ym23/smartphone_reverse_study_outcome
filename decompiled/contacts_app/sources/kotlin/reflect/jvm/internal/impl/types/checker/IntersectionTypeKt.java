package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> r10) {
        Intrinsics.checkNotNullParameter(r10, GloableSearchConfig.KEY_CONFIGS);
        int r0 = r10.size();
        if (r0 == 0) goto L44;
        if (r0 == 1) goto L42;
        List<? extends UnwrappedType> r1 = r10;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
        boolean r6 = false;
        boolean r7 = false;
    L8:
        if (r4.hasNext() == false) goto L28;
        UnwrappedType r8 = (UnwrappedType) r4.next();
        if (r6 == false) goto L12;
    L15:
        r6 = true;
    L17:
        if ((r8 instanceof SimpleType) == false) goto L20;
        SimpleType r9 = (SimpleType) r8;
    L25:
        r2.add(r9);
        goto L8
    L20:
        if ((r8 instanceof FlexibleType) == false) goto L27;
        if (DynamicTypesKt.isDynamic(r8) == true) goto L23;
        r9 = ((FlexibleType) r8).getLowerBound();
        r7 = true;
        goto L25
    L23:
        return r8;
    L27:
        throw new NoWhenBranchMatchedException();
    L12:
        if (KotlinTypeKt.isError(r8) == true) goto L15;
        r6 = false;
        goto L17
    L28:
        ArrayList r3 = r2;
        if (r6 == true) goto L31;
        if (r7 == false) goto L34;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r5 = r1.iterator();
    L37:
        if (r5.hasNext() == false) goto L40;
        r11.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) r5.next()));
        goto L37
    L40:
        return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(r3), TypeIntersector.INSTANCE.intersectTypes$descriptors(r11));
    L34:
        return TypeIntersector.INSTANCE.intersectTypes$descriptors(r3);
    L31:
        return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, new String[]{r10.toString()});
    L42:
        return (UnwrappedType) CollectionsKt.single(r10);
    L44:
        throw new IllegalStateException("Expected some types".toString());
    }
}
