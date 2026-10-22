package fa;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* renamed from: fa.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4070g {
    public static final List<JvmProtoBuf.StringTableTypes.Record> a(List<JvmProtoBuf.StringTableTypes.Record> list) {
        p.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        for (JvmProtoBuf.StringTableTypes.Record record : list) {
            int iE = record.E();
            for (int i10 = 0; i10 < iE; i10++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
