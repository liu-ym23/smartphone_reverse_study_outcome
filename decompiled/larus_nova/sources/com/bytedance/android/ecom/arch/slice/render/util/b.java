package com.bytedance.android.ecom.arch.slice.render.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final boolean a(Object r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "true") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r100, 1) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final float b(List<Float> r100) {
        List<Float> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return 0.0f;
    L12:
        int r103 = r100.size();
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L25;
        if (r103 == 3) goto L24;
        return ((Number) ListProtector.get(r100, 2)).floatValue();
    L24:
        return ((Number) ListProtector.get(r100, 2)).floatValue();
    L25:
        return ((Number) ListProtector.get(r100, 0)).floatValue();
    L22:
        return ((Number) ListProtector.get(r100, 0)).floatValue();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final List<Float> d(Object r100) {
        ArrayList r101 = null;
        if (r100 != null) goto L5;
    L16:
        return r101;
    L5:
        if ((r100 instanceof List) == false) goto L16;
        List r102 = (List) r100;
        r101 = new ArrayList(r102.size());
        int r103 = ((Collection) r100).size();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L16;
        Object r105 = ListProtector.get(r102, r104);
        if ((r105 instanceof Number) == false) goto L12;
        r101.add(Float.valueOf(((Number) r105).floatValue()));
    L15:
        r104 = r104 + 1;
        goto L7
    L12:
        if ((r105 instanceof String) == false) goto L14;
        r101.add(Float.valueOf(c(r105, 0.0f)));
        goto L15
    L14:
        r101.add(Float.valueOf(0.0f));
        goto L15
    }

    public static final Float e(Object r100) {
        if (r100 != null) goto L16;
    L14:
        return null;
    L16:
        if ((r100 instanceof Number) == false) goto L8;
        float r101 = ((Number) r100).floatValue();     // Catch: Throwable -> L15
    L11:
        return Float.valueOf(r101);
    L8:
        if ((r100 instanceof String) == false) goto L13;
        r101 = CastFloatProtector.parseFloat((String) r100);     // Catch: Throwable -> L15
        goto L11
    L13:
        throw new IllegalArgumentException("无法转换为Float：非法的参数类型");     // Catch: Throwable -> L15
    }

    public static final Integer g(String r100) {
        return uq.b.h(r100);
    L4:
        return null;
    }

    public static final List<Integer> h(Object r100) {
        if ((r100 instanceof List) == false) goto L15;
        List r101 = (List) r100;
        ArrayList r102 = new ArrayList(r101.size());
        int r103 = ((Collection) r100).size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        Object r105 = ListProtector.get(r101, r104);
        if ((r105 instanceof Number) == false) goto L10;
        r102.add(Integer.valueOf(((Number) r105).intValue()));
    L12:
        r104 = r104 + 1;
        goto L5
    L10:
        if ((r105 instanceof String) == false) goto L13;
        r102.add(Integer.valueOf(f(r105, 0)));
        goto L12
    L13:
        return null;
    L14:
        return r102;
    L15:
        return null;
    }

    public static final Integer i(Object r100) {
        if (r100 != null) goto L16;
    L14:
        return null;
    L16:
        if ((r100 instanceof Number) == false) goto L8;
        int r101 = ((Number) r100).intValue();     // Catch: Throwable -> L15
    L11:
        return Integer.valueOf(r101);
    L8:
        if ((r100 instanceof String) == false) goto L13;
        r101 = CastIntegerProtector.parseInt((String) r100);     // Catch: Throwable -> L15
        goto L11
    L13:
        throw new IllegalArgumentException("无法转换为Int：非法的参数类型");     // Catch: Throwable -> L15
    }

    public static final float k(List<Float> r100) {
        if (r100 == null) goto L17;
        int r101 = r100.size();
        if (r101 != 0) goto L7;
        return 0.0f;
    L7:
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L20;
        return ((Number) ListProtector.get(r100, 3)).floatValue();
    L20:
        return ((Number) ListProtector.get(r100, 1)).floatValue();
    L21:
        return ((Number) ListProtector.get(r100, 1)).floatValue();
    L16:
        return ((Number) ListProtector.get(r100, 0)).floatValue();
    L17:
        return 0.0f;
    }

    public static /* synthetic */ long m(Object r100) {
        return l(r100, 0);
    }

    public static final Long n(Object r100) {
    L12:
        return null;
    L3:
        if ((r100 instanceof Number) == false) goto L6;
        long r101 = ((Number) r100).longValue();     // Catch: Throwable -> L12
    L9:
        return Long.valueOf(r101);
    L6:
        if ((r100 instanceof String) == false) goto L11;
        r101 = CastLongProtector.parseLong((String) r100);     // Catch: Throwable -> L12
        goto L9
    L11:
        throw new IllegalArgumentException("无法转换为Long：非法的参数类型");     // Catch: Throwable -> L12
    }

    public static final Map<String, Object> o(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L9;
        return TypeIntrinsics.asMutableMap(r100);
    L9:
        if ((r100 instanceof Map) == true) goto L11;
        return null;
    L11:
        return new HashMap((Map) r100);
    }

    public static final List<String> p(Object r100) {
        if ((r100 instanceof List) == true) goto L6;
        return null;
    L6:
        Iterable r101 = (Iterable) r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(r(r103.next()));
        goto L8
    L10:
        return r102;
    }

    public static final float q(List<Float> r100) {
        List<Float> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return 0.0f;
    L13:
        if (r100.size() == 1) goto L16;
        return ((Number) ListProtector.get(r100, 1)).floatValue();
    L16:
        return ((Number) ListProtector.get(r100, 0)).floatValue();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final String r(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L45;
        boolean r101 = true;
        if ((r100 instanceof Double) == false) goto L18;
        Number r102 = (Number) r100;
        long r103 = (long) r102.doubleValue();
        if (r102.doubleValue() == r103) goto L14;
        r101 = false;
    L14:
        if (r101 == false) goto L47;
        return String.valueOf(r103);
    L47:
        return r100.toString();
    L18:
        if ((r100 instanceof Float) == false) goto L27;
        Number r104 = (Number) r100;
        long r105 = (long) r104.floatValue();
        if (r104.floatValue() == r105) goto L23;
        r101 = false;
    L23:
        if (r101 == false) goto L49;
        return String.valueOf(r105);
    L49:
        return r100.toString();
    L27:
        if ((r100 instanceof Long) == false) goto L30;
        return r100.toString();
    L30:
        if ((r100 instanceof Integer) == false) goto L33;
        return r100.toString();
    L33:
        if ((r100 instanceof Short) == false) goto L36;
        return r100.toString();
    L36:
        if ((r100 instanceof Byte) == false) goto L39;
        return r100.toString();
    L39:
        if ((r100 instanceof Boolean) == false) goto L42;
        return r100.toString();
    L42:
        if ((r100 instanceof Character) == true) goto L44;
        return null;
    L44:
        return r100.toString();
    L45:
        return (String) r100;
    }

    public static final List<String> s(Object r100) {
        if ((r100 instanceof List) == true) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((Iterable) r100).iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        String r103 = r(r102.next());
        if (r103 == null) goto L8;
        r101.add(r103);
        goto L8
    L12:
        return r101;
    }

    public static final float t(List<Float> r100) {
        List<Float> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return 0.0f;
    L13:
        return ((Number) ListProtector.get(r100, 0)).floatValue();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final float c(Object r100, float r101) {
        if (r100 != null) goto L14;
    L12:
        return r101;
    L14:
        if ((r100 instanceof Number) == false) goto L7;
        return ((Number) r100).floatValue();
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return CastFloatProtector.parseFloat((String) r100);
    L11:
        throw new IllegalArgumentException("无法转换为Float：非法的参数类型");     // Catch: Throwable -> L13
    }

    public static final int f(Object r100, int r101) {
        if (r100 != null) goto L14;
    L12:
        return r101;
    L14:
        if ((r100 instanceof Number) == false) goto L7;
        return ((Number) r100).intValue();
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return CastIntegerProtector.parseInt((String) r100);
    L11:
        throw new IllegalArgumentException("无法转换为Int：非法的参数类型");     // Catch: Throwable -> L13
    }

    public static final int j(Object r100, com.bytedance.android.ecom.arch.slice.render.context.b r101) {
        if (Intrinsics.areEqual(r100, "auto") == false) goto L6;
        return -2;
    L6:
        if (Intrinsics.areEqual(r100, "stretch") == false) goto L9;
    L30:
        return -1;
    L9:
        if ((r100 instanceof uq.a) == false) goto L22;
        uq.a r102 = (uq.a) r100;
        int r103 = r102.f551168b;
        if (r103 != 0) goto L13;
        return -2;
    L13:
        if (r103 == 1) goto L37;
        if (r103 == 2) goto L18;
        return -2;
    L18:
        if (r102.f551167a == 100.0f) goto L30;
        return -2;
    L37:
        return (int) r102.f551167a;
    L22:
        if ((r100 instanceof Number) == false) goto L27;
        float r104 = ((Number) r100).floatValue();
        if (r104 >= 0) goto L39;
        return -2;
    L39:
        return SlcDimensExtensionsKt.a(Float.valueOf(r104), r101);
    L27:
        if ((r100 instanceof String) == true) goto L29;
        return -2;
    L29:
        if (Intrinsics.areEqual(r100, "100%") == true) goto L30;
        Float r105 = e(r100);
        if (r105 != null) goto L34;
        return -2;
    L34:
        return Math.round(SlcDimensExtensionsKt.c(r105, r101));
    }

    public static final long l(Object r100, long r101) {
        if (r100 != null) goto L14;
    L12:
        return r101;
    L14:
        if ((r100 instanceof Number) == false) goto L7;
        return ((Number) r100).longValue();
    L7:
        if ((r100 instanceof String) == false) goto L11;
        return CastLongProtector.parseLong((String) r100);
    L11:
        throw new IllegalArgumentException("无法转换为Long：非法的参数类型");     // Catch: Throwable -> L13
    }

    public static final <VType> Map<String, VType> w(Map<String, ? extends VType> r100, Map<String, ? extends VType> r101) {
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = r100.size();
    L6:
        if (r101 == null) goto L8;
        r102 = r101.size();
    L8:
        HashMap r104 = new HashMap((int) (((r103 + r102) / 0.75f) + 1.0f));
        if (r100 != null) goto L11;
    L13:
        if (r101 != null) goto L15;
    L17:
        return r104;
    L15:
        if ((!r101.isEmpty()) == false) goto L17;
        r104.putAll(r101);
        goto L17
    L11:
        if ((!r100.isEmpty()) == false) goto L13;
        r104.putAll(r100);
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public static final float u(Map<String, ? extends Object> r100, String r101, float r102) {
        if (r100 == null) goto L4;
        Object r103 = r100.get(r101);
    L5:
        Float r104 = e(r103);
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104.floatValue();
    L4:
        r103 = null;
        goto L5
    }

    public static final String v(Map<String, ? extends Object> r100, String r101, String r102) {
        if (r100 == null) goto L9;
        Object r103 = r100.get(r101);
        if (r103 == null) goto L10;
        String r104 = r(r103);
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104;
    L10:
        return r102;
    L9:
        return r102;
    }
}
