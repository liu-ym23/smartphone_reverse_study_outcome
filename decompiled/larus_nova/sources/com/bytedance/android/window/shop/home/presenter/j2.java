package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes14.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Pair<IntRange, int[]>> f188553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f188554b = null;

    static {
        f188553a = CollectionsKt.listOf(new Pair[]{new Pair(new IntRange(0, 60), new int[]{(int) 4284500019L, (int) 4283905836L}), new Pair(new IntRange(61, 180), new int[]{(int) 4282206261L, (int) 4281220147L}), new Pair(new IntRange(181, 240), new int[]{(int) 4280828262L, (int) 4280627288L}), new Pair(new IntRange(241, 300), new int[]{(int) 4280952390L, (int) 4281873241L}), new Pair(new IntRange(301, 360), new int[]{(int) 4284427067L, (int) 4282851108L})});
        int r100 = (int) 4284374622L;
        f188554b = new int[]{r100, r100};
    }

    public static int[] a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rgbColor");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        float[] r102 = new float[3];
        Integer r103 = com.bytedance.android.ec.core.utils.s.b(r100);
        if (r103 == null) goto L31;
        Color.colorToHSV(r103.intValue(), r102);
        int r104 = (int) r102[0];
        float r105 = r102[1];
        float r106 = r102[2];
        float r107 = 100;
        float r108 = 10;
        if ((r105 * r107) <= r108) goto L29;
        if ((r106 * r107) <= r108) goto L29;
        Iterator<T> r109 = f188553a.iterator();
    L18:
        if (r109.hasNext() == false) goto L22;
        Object r110 = r109.next();
        if (((IntRange) ((Pair) r110).component1()).contains(r104) == false) goto L18;
    L23:
        Pair r111 = (Pair) r110;
        if (r111 == null) goto L36;
        int[] r112 = (int[]) r111.getSecond();
        if (r112 == null) goto L36;
        return r112;
    L36:
        return f188554b;
    L22:
        r110 = null;
    L29:
        return f188554b;
    L31:
        return f188554b;
    L8:
        return f188554b;
    L5:
        r101 = false;
        goto L6
    }
}
