package com.bytedance.android.ec.window.base.utils;

import com.bytedance.android.ec.core.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final float[] a(List<Float> r100) {
        if (r100 == null) goto L5;
        List<Float> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r102.add(Float.valueOf(q.a(Float.valueOf(((Number) r103.next()).floatValue()))));
        goto L8
    L11:
        if (r100.size() < 4) goto L45;
        float[] r104 = new float[8];
        Float r105 = (Float) CollectionsKt.getOrNull(r102, 0);
        float r106 = 0.0f;
        if (r105 == null) goto L15;
        float r107 = r105.floatValue();
    L16:
        r104[0] = r107;
        Float r108 = (Float) CollectionsKt.getOrNull(r102, 0);
        if (r108 == null) goto L19;
        float r109 = r108.floatValue();
    L20:
        r104[1] = r109;
        Float r110 = (Float) CollectionsKt.getOrNull(r102, 1);
        if (r110 == null) goto L23;
        float r111 = r110.floatValue();
    L24:
        r104[2] = r111;
        Float r112 = (Float) CollectionsKt.getOrNull(r102, 1);
        if (r112 == null) goto L27;
        float r113 = r112.floatValue();
    L28:
        r104[3] = r113;
        Float r114 = (Float) CollectionsKt.getOrNull(r102, 2);
        if (r114 == null) goto L31;
        float r115 = r114.floatValue();
    L32:
        r104[4] = r115;
        Float r116 = (Float) CollectionsKt.getOrNull(r102, 2);
        if (r116 == null) goto L35;
        float r117 = r116.floatValue();
    L36:
        r104[5] = r117;
        Float r118 = (Float) CollectionsKt.getOrNull(r102, 3);
        if (r118 == null) goto L39;
        float r119 = r118.floatValue();
    L40:
        r104[6] = r119;
        Float r120 = (Float) CollectionsKt.getOrNull(r102, 3);
        if (r120 == null) goto L43;
        r106 = r120.floatValue();
    L43:
        r104[7] = r106;
        return r104;
    L39:
        r119 = 0.0f;
        goto L40
    L35:
        r117 = 0.0f;
        goto L36
    L31:
        r115 = 0.0f;
        goto L32
    L27:
        r113 = 0.0f;
        goto L28
    L23:
        r111 = 0.0f;
        goto L24
    L19:
        r109 = 0.0f;
        goto L20
    L15:
        r107 = 0.0f;
        goto L16
    L45:
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    L5:
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
