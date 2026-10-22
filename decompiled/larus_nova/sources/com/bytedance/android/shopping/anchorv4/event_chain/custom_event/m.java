package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m {
    public static final com.bytedance.android.ecom.arch.slice.g a(List<? extends com.bytedance.android.ecom.arch.slice.g> r100, String r101) {
        if (r100 == null) goto L14;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r103).getSliceId(), r101) == false) goto L6;
    L11:
        com.bytedance.android.ecom.arch.slice.g r104 = (com.bytedance.android.ecom.arch.slice.g) r103;
        if (r104 == null) goto L14;
        return r104;
    L10:
        r103 = null;
    L14:
        if (r100 == null) goto L27;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if ((r107 instanceof com.bytedance.android.ecom.arch.slice.p) == false) goto L17;
        r105.add(r107);
        goto L17
    L21:
        Iterator r108 = r105.iterator();
    L23:
        if (r108.hasNext() == false) goto L27;
        com.bytedance.android.ecom.arch.slice.g r109 = a(((com.bytedance.android.ecom.arch.slice.p) r108.next()).a(), r101);
        if (r109 == null) goto L23;
        return r109;
    L27:
        return null;
    }
}
