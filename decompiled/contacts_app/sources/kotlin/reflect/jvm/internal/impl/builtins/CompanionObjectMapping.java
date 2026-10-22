package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = null;
    private static final Set<ClassId> classIds = null;

    private CompanionObjectMapping() {
    }

    public final Set<ClassId> getClassIds() {
        return classIds;
    }

    static {
        INSTANCE = new CompanionObjectMapping();
        Set<PrimitiveType> r0 = PrimitiveType.NUMBER_TYPES;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(StandardNames.getPrimitiveFqName((PrimitiveType) r2.next()));
        goto L4
    L6:
        FqName r3 = StandardNames.FqNames.string.toSafe();
        Intrinsics.checkNotNullExpressionValue(r3, "string.toSafe()");
        List r4 = CollectionsKt.plus(r1, r3);
        FqName r5 = StandardNames.FqNames._boolean.toSafe();
        Intrinsics.checkNotNullExpressionValue(r5, "_boolean.toSafe()");
        List r6 = CollectionsKt.plus(r4, r5);
        FqName r7 = StandardNames.FqNames._enum.toSafe();
        Intrinsics.checkNotNullExpressionValue(r7, "_enum.toSafe()");
        List r8 = CollectionsKt.plus(r6, r7);
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r9.add(ClassId.topLevel((FqName) r10.next()));
        goto L8
    L10:
        classIds = r9;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }
}
