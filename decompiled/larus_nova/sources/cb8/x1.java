package cb8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x1 {
    public static final <T> int a(List<? extends jc8.a> r100, jc8.a r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "blockBizModel");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        T r105 = r104.next();
        if (r102.isInstance((jc8.a) r105) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
        int r107 = 0;
    L10:
        if (r106.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((jc8.a) r106.next()).h(), r101.h()) == true) goto L17;
        r107 = r107 + 1;
    L17:
        return r107 + 1;
    L15:
        r107 = -1;
        goto L17
    }

    public static final <T> int b(jc8.k r100, jc8.a r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "blockBizModel");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        if (r100 == null) goto L7;
        List<jc8.a> r103 = r100.b();
        if (r103 == null) goto L7;
        return a(r103, r101, r102);
    L7:
        return 1;
    }
}
