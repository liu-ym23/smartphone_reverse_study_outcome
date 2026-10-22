package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmNameResolverKt {
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(List<JvmProtoBuf.StringTableTypes.Record> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        r0.ensureCapacity(r4.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        JvmProtoBuf.StringTableTypes.Record r1 = r5.next();
        int r2 = r1.getRange();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L4;
        r0.add(r1);
        r3 = r3 + 1;
        goto L6
    L8:
        r0.trimToSize();
        return r0;
    }
}
