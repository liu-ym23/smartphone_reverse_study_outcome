package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {
    public static final void a(MVIState r100, MVIState r101) {
        Iterator<Map.Entry<String, c<?, ?>>> r102 = r101.properties.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, c<?, ?>> r103 = r102.next();
        String r104 = r103.getKey();
        c<?, ?> r105 = r103.getValue();
        c<?, ?> r106 = r100.properties.get(r104);
        if (r106 == null) goto L14;
        c<?, ?> r107 = r106;
        if ((r107 instanceof SubStatePropertyImpl) == true) goto L9;
        if ((!Intrinsics.areEqual(r107.c(), r105.c())) == false) goto L4;
        r107.a(r105.c());
        goto L4
    L9:
        r107.a(r105.c());
        goto L4
    L14:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.BasePropertyImpl<STATE, kotlin.Any>");
    }
}
