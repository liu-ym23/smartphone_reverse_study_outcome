package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import com.bytedance.android.livesdk.link.model.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {
    public static final List<cf2.a> a(List<? extends a1> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToWrapperList");
        ArrayList r101 = new ArrayList();
        Iterator<? extends a1> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new cf2.a(r102.next(), null, null, null));
        goto L4
    L6:
        return r101;
    }
}
