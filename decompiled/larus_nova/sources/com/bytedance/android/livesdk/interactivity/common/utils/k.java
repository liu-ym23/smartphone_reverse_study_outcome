package com.bytedance.android.livesdk.interactivity.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class k {
    public static final <T> List<T> c(Queue<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeUntil");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        if (r101.invoke(r104).booleanValue() == true) goto L9;
        r103.remove();
        r102.add(r104);
    L9:
        return r102;
    }

    public static final <T> List<T> d(Queue<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeWith");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        T r104 = r103.next();
        if (r101.invoke(r104).booleanValue() == false) goto L4;
        r103.remove();
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    public static final <T> int b(Queue<T> r100, int r101, List<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$pollBatch");
        Intrinsics.checkNotNullParameter(r102, "pollList");
        int r103 = RangesKt.coerceAtMost(r101, r100.size());
        if (r103 <= 0) goto L10;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        T r105 = r100.poll();
        if (r105 == null) goto L9;
        ((ArrayList) r102).add(r105);
    L9:
        r104 = r104 + 1;
    L10:
        return r103;
    }

    public static final <T> void a(Queue<T> r100, int r101, T r102, Function2<? super T, ? super List<? extends T>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$addWithCheckMaxSize");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r100.add(r102);
        if (r100.size() <= r101) goto L13;
        ArrayList r104 = new ArrayList();
        int r105 = r100.size() - r101;
        if (r105 <= 0) goto L12;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L12;
        T r107 = r100.poll();
        if (r107 == null) goto L11;
        r104.add(r107);
    L11:
        r106 = r106 + 1;
    L12:
        r103.invoke(r102, r104);
        return;
    L13:
        r103.invoke(r102, null);
    }
}
