package com.bytedance.android.shopping.store.home;

import android.graphics.Rect;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z extends mn.d {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Rect r102 = ((ln.c) r100).r();
            int r103 = Integer.MIN_VALUE;
            if (r102 == null) goto L5;
            int r104 = r102.top;
        L6:
            Integer r105 = Integer.valueOf(r104);
            Rect r106 = ((ln.c) r101).r();
            if (r106 == null) goto L10;
            r103 = r106.top;
        L10:
            return ComparisonsKt.compareValues(r105, Integer.valueOf(r103));
        L5:
            r104 = Integer.MIN_VALUE;
            goto L6
        }
    }

    public z() {
    }

    public static ln.c e(List r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();
        ln.c r103 = (ln.c) r102;
        Intrinsics.checkNotNullParameter(r103, "$this$isImageOrVideo");
        if (r103.P() != PlayAbleType.MAIN_IMAGE) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L4;
    L16:
        return (ln.c) r102;
    L8:
        if (r103.P() == PlayAbleType.VIDEO) goto L11;
        r104 = false;
        goto L12
    L14:
        r102 = null;
        goto L16
    }

    @Override // mn.d
    public final void d(List<ln.c> r100, com.bytedance.android.ec.store.utils.playable.controller.a r110, Rect r111) {
        Intrinsics.checkNotNullParameter(r100, "itemsToPlay");
        Intrinsics.checkNotNullParameter(r110, "mgr");
        Intrinsics.checkNotNullParameter(r111, "area");
        if (e(r100) != null) goto L10;
        ln.c r112 = mn.d.c(r111, r110);
        if (r112 == null) goto L10;
        if (r100.contains(r112) == false) goto L10;
        r100.remove(r112);
        ListProtector.add(r100, 0, r112);
    L10:
        if (r100.size() <= 1) goto L12;
        CollectionsKt.sortWith(r100, new a());
    L12:
        ln.c r113 = e(r100);
        List<ln.c> r101 = r110.a();
        Intrinsics.checkNotNullParameter(r101, "items");
        Iterator<T> r102 = r101.iterator();
    L14:
        if (r102.hasNext() == false) goto L29;
        Object r103 = r102.next();
        ln.c r104 = (ln.c) r103;
        Intrinsics.checkNotNullParameter(r104, "$this$isImageOrVideo");
        if (r104.P() != PlayAbleType.MAIN_IMAGE) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == true) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L14;
    L30:
        List<? extends ln.c> r107 = CollectionsKt.emptyList();
        if ((true ^ Intrinsics.areEqual(r113, (ln.c) r103)) == true) goto L40;
        if (r113 == null) goto L40;
        if (r113.isPlaying() == true) goto L38;
        r113 = null;
    L38:
        if (r113 == null) goto L41;
        r107 = CollectionsKt.listOf(r113);
    L41:
        dm.a.a("测试播放范围").a("itemsToPlay个数:" + r100.size() + ",选择一个开始播放");
        r110.e(r100, r107);
        return;
    L40:
        dm.a.a("测试播放范围").a("当前在播的卡与接下来需要播的第一个卡不是同一个,停止当前播放");
        r110.f();
        goto L41
    L24:
        if (r104.isPlaying() == false) goto L26;
        r106 = true;
        goto L27
    L18:
        if (r104.P() == PlayAbleType.VIDEO) goto L21;
        r105 = false;
        goto L22
    L29:
        r103 = null;
        goto L30
    }
}
