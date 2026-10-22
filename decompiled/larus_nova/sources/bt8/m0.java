package bt8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class m0 {
    public static final com.larus.bmhome.actionbar.model.h a(com.larus.bmhome.actionbar.model.h r110) {
        ArrayList r100 = null;
        if (r110 == null) goto L13;
        List<com.larus.bmhome.actionbar.model.w> r101 = r110.f295167e;
        if (r101 == null) goto L11;
        List<com.larus.bmhome.actionbar.model.w> r102 = r101;
        r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r100.add(com.larus.bmhome.actionbar.model.w.a((com.larus.bmhome.actionbar.model.w) r103.next(), null, null, null, null, null, null, 8388607));
    L11:
        return com.larus.bmhome.actionbar.model.h.a(r110, null, null, null, r100, null, null, 4079);
    L13:
        return null;
    }
}
