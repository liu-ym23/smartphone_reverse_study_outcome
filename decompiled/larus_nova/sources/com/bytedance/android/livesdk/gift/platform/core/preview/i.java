package com.bytedance.android.livesdk.gift.platform.core.preview;

import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

/* JADX INFO: loaded from: classes9.dex */
public final class i {
    public static final <T> List<T> b(Iterable<? extends T> r100, Iterable<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$subtractWithSort");
        Intrinsics.checkNotNullParameter(r101, "other");
        List<T> r102 = CollectionsKt.toMutableList(r100);
        r102.removeAll(CollectionsKt.intersect(r102, CollectionsKt.toSet(r101)));
        return r102;
    }

    public static final <T> void a(List<T> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$move");
        if (r101 != r102) goto L5;
        return;
    L5:
        IntProgression r103 = IntProgression.Companion.fromClosedRange(r101, r102, Intrinsics.compare(r102, r101));
        int r104 = r103.getFirst();
        int r105 = r103.getLast();
        int r106 = r103.getStep();
        if (r106 < 0) goto L9;
        if (r104 <= r105) goto L10;
        return;
    L10:
        Collections.swap(r100, r101, r104);
        if (r104 == r105) goto L17;
        int r107 = r104;
        r104 = r104 + r106;
        r101 = r107;
        goto L10
    L17:
        return;
    L9:
        if (r104 >= r105) goto L10;
    }
}
