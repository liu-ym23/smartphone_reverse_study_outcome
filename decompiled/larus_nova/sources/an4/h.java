package an4;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h {
    public static final e a(a r100, ItemIdV2 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Iterator<T> r102 = r100.getItemFactorySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((e) r103).getItemId().name(), r101.name()) == false) goto L4;
    L10:
        return (e) r103;
    L8:
        r103 = null;
        goto L10
    }
}
