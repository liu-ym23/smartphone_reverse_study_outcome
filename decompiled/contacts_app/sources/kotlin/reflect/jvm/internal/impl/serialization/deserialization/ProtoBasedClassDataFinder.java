package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment r2, NameResolver r3, BinaryVersion r4, Function1<? super ClassId, ? extends SourceElement> r5) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        Intrinsics.checkNotNullParameter(r4, "metadataVersion");
        Intrinsics.checkNotNullParameter(r5, "classSource");
        this.nameResolver = r3;
        this.metadataVersion = r4;
        this.classSource = r5;
        List<ProtoBuf.Class> r6 = r2.getClass_List();
        Intrinsics.checkNotNullExpressionValue(r6, "proto.class_List");
        List<ProtoBuf.Class> r7 = r6;
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r10 = r9.next();
        r8.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf.Class) r10).getFqName()), r10);
        goto L4
    L6:
        this.classIdToProto = r8;
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        ProtoBuf.Class r0 = this.classIdToProto.get(r5);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ClassData(this.nameResolver, r0, this.metadataVersion, this.classSource.invoke(r5));
    }
}
