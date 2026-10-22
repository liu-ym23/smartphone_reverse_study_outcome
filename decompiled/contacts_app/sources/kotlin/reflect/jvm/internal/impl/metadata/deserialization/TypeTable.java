package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: compiled from: TypeTable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable r6) {
        Intrinsics.checkNotNullParameter(r6, "typeTable");
        ArrayList r0 = r6.getTypeList();
        if (r6.hasFirstNullable() == false) goto L15;
        int r1 = r6.getFirstNullable();
        List<ProtoBuf.Type> r7 = r6.getTypeList();
        Intrinsics.checkNotNullExpressionValue(r7, "typeTable.typeList");
        List<ProtoBuf.Type> r8 = r7;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
        int r3 = 0;
    L6:
        if (r9.hasNext() == false) goto L14;
        Object r4 = r9.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ProtoBuf.Type r10 = (ProtoBuf.Type) r4;
        if (r3 < r1) goto L13;
        r10 = r10.toBuilder().setNullable(true).build();
    L13:
        r2.add(r10);
        r3 = r5;
        goto L6
    L14:
        r0 = r2;
    L15:
        Intrinsics.checkNotNullExpressionValue(r0, "run {\n        val origin… else originalTypes\n    }");
        this.types = r0;
    }

    public final ProtoBuf.Type get(int r1) {
        return this.types.get(r1);
    }
}
