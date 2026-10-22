package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(com.bytedance.android.ec.vlayout.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$decreaseRange");
        r100.r(r100.h() - 1);
        if (r100.h() <= 0) goto L9;
        int r101 = ((Number) r100.f49095a.f550758b).intValue();
        int r102 = ((Number) r100.f49095a.f550757a).intValue();
        if (r102 < 0) goto L9;
        if (r101 <= r102) goto L9;
        r100.s(((Number) r100.f49095a.f550757a).intValue(), ((Number) r100.f49095a.f550758b).intValue() - 1);
        return;
    L9:
        r100.s(-1, -1);
    }

    public static final void a(vn.l r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$clearSpanCacheAfter");
        boolean r102 = true;
        int r103 = r101 + 1;
        int[] r104 = r100.f556388v.f556394a;
        if (r104 == null) goto L16;
        int r105 = r104.length;
        if (r103 < 0) goto L9;
        if (r105 <= r103) goto L9;
    L10:
        if (r102 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L17;
        Arrays.fill(r104, r103, r104.length, Integer.MIN_VALUE);
        return;
    L17:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public static final void c(VirtualLayoutManager r100, List<? extends com.bytedance.android.ec.vlayout.a> r101, List<? extends com.bytedance.android.ec.vlayout.a> r102, Function1<? super List<? extends com.bytedance.android.ec.vlayout.a>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateLayoutHelpers");
        Intrinsics.checkNotNullParameter(r101, "old");
        Intrinsics.checkNotNullParameter(r102, "new");
        ArrayList r104 = new ArrayList(r100.R());
        if ((!r101.isEmpty()) == false) goto L11;
        Integer r105 = Integer.valueOf(r104.indexOf(CollectionsKt.first(r101)));
        if (r105.intValue() >= 0) goto L7;
        return;
    L7:
        Iterator<T> r106 = r101.iterator();
    L9:
        if (r106.hasNext() == false) goto L12;
        r104.remove((com.bytedance.android.ec.vlayout.a) r106.next());
    L12:
        if (r105 == null) goto L14;
        int r107 = r105.intValue();
    L15:
        r104.addAll(r107, r102);
        Unit r108 = r103.invoke(r104);
        r100.U(r104);
        return;
    L14:
        r107 = r104.size();
        goto L15
    L11:
        r105 = null;
        goto L12
    }
}
