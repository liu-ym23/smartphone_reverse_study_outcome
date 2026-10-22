package com.bytedance.android.live.impl;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f69057a = 0;

    static {
    }

    public static double b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        if ((r100 instanceof Integer) == false) goto L6;
        return ((Number) r100).intValue();
    L6:
        if ((r100 instanceof Double) == false) goto L9;
        return ((Number) r100).doubleValue();
    L9:
        if ((r100 instanceof Float) == false) goto L12;
        return ((Number) r100).floatValue();
    L12:
        if ((r100 instanceof Long) == false) goto L15;
        return ((Number) r100).longValue();
    L15:
        if ((r100 instanceof String) == false) goto L18;
        return CastDoubleProtector.parseDouble((String) r100);
    L18:
        return ((Double) r100).doubleValue();
    }

    public static int c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        if ((r100 instanceof Integer) == false) goto L6;
        return ((Number) r100).intValue();
    L6:
        if ((r100 instanceof Double) == false) goto L9;
        return (int) ((Number) r100).doubleValue();
    L9:
        if ((r100 instanceof Float) == false) goto L12;
        return (int) ((Number) r100).floatValue();
    L12:
        if ((r100 instanceof Long) == false) goto L15;
        return (int) ((Number) r100).longValue();
    L15:
        if ((r100 instanceof String) == false) goto L18;
        return CastIntegerProtector.parseInt((String) r100);
    L18:
        return ((Integer) r100).intValue();
    }

    public static long d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        if ((r100 instanceof Integer) == false) goto L6;
        return ((Number) r100).intValue();
    L6:
        if ((r100 instanceof Double) == false) goto L9;
        return (long) ((Number) r100).doubleValue();
    L9:
        if ((r100 instanceof Long) == false) goto L12;
        return ((Number) r100).longValue();
    L12:
        if ((r100 instanceof String) == false) goto L15;
        return CastLongProtector.parseLong((String) r100);
    L15:
        if ((r100 instanceof Float) == false) goto L18;
        return (long) ((Number) r100).floatValue();
    L18:
        return ((Long) r100).longValue();
    }

    public static String e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "cur");
        if ((r100 instanceof Integer) == true) goto L16;
        if (Intrinsics.areEqual(r100, DoubleCompanionObject.INSTANCE) == true) goto L16;
        if (Intrinsics.areEqual(r100, LongCompanionObject.INSTANCE) == true) goto L16;
        if (Intrinsics.areEqual(r100, FloatCompanionObject.INSTANCE) == true) goto L16;
        if ((r100 instanceof String) == false) goto L18;
        return (String) r100;
    L18:
        return (String) r100;
    L16:
        return r100.toString();
    }

    public static Object a(Object r100, Object r101) {
        if ((r101 instanceof Integer) == false) goto L7;
        if (r100 != null) goto L39;
    L37:
        return null;
    L39:
        return Integer.valueOf(c(r100));
    L7:
        if ((r101 instanceof Double) == false) goto L11;
        if (r100 == null) goto L37;
        return Double.valueOf(b(r100));
    L11:
        if ((r101 instanceof Long) == false) goto L15;
        if (r100 == null) goto L37;
        return Long.valueOf(d(r100));
    L15:
        if ((r101 instanceof String) == false) goto L18;
        return String.valueOf(r100);
    L18:
        if ((r101 instanceof Float) == false) goto L43;
        if (r100 == null) goto L37;
        Intrinsics.checkNotNullParameter(r100, "cur");
        if ((r100 instanceof Integer) == false) goto L24;
        float r102 = ((Number) r100).intValue();
    L44:
        return Float.valueOf(r102);
    L24:
        if ((r100 instanceof Double) == false) goto L27;
        r102 = (float) ((Number) r100).doubleValue();
        goto L44
    L27:
        if ((r100 instanceof Long) == false) goto L30;
        r102 = ((Number) r100).longValue();
        goto L44
    L30:
        if ((r100 instanceof String) == false) goto L33;
        r102 = CastFloatProtector.parseFloat((String) r100);
        goto L44
    L33:
        if ((r100 instanceof Float) == false) goto L35;
        r102 = ((Number) r100).floatValue();
        goto L44
    L35:
        r102 = ((Float) r100).floatValue();
        goto L44
    L43:
        return r100;
    }
}
