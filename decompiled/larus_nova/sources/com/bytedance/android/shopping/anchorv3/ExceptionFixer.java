package com.bytedance.android.shopping.anchorv3;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ExceptionFixer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f164390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f164391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f164392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f164393d;

    static {
    }

    public static void a(StaggeredGridLayoutManager r100) {
        Object r101 = b(r100, "mLazySpanLookup", f164390a, ExceptionFixer$checkDataBeforeUpdateImpl$mLazySpanLookup$1.INSTANCE);
        Object r102 = b(r101, "mData", f164391b, ExceptionFixer$checkDataBeforeUpdateImpl$mData$1.INSTANCE);
        Object r103 = b(r101, "mFullSpanItems", f164392c, ExceptionFixer$checkDataBeforeUpdateImpl$mFullSpanItems$1.INSTANCE);
        if (r102 != null) goto L5;
    L27:
        int r104 = com.bytedance.android.shopping.utils.b.f187047e;
        com.bytedance.android.shopping.utils.b.a.a("call checkDataBeforeUpdate mData=" + r102 + " mFullSpanItems=" + r103);
        return;
    L5:
        if ((r103 instanceof List) == true) goto L7;
        Object r105 = null;
    L8:
        List r106 = (List) r105;
        if (r106 == null) goto L11;
        int r107 = r106.size();
    L12:
        if (r107 <= 0) goto L27;
        if (r103 == null) goto L26;
        int[] r108 = (int[]) r102;
        Object r109 = b(CollectionsKt.last((List) r103), "mPosition", f164393d, ExceptionFixer$checkDataBeforeUpdateImpl$position$1.INSTANCE);
        int r110 = com.bytedance.android.shopping.utils.b.f187047e;
        com.bytedance.android.shopping.utils.b.a.a("call checkDataBeforeUpdate mData.size=" + r108.length + " position=" + r109);
        if ((r109 instanceof Integer) == false) goto L30;
        Number r111 = (Number) r109;
        if (r108.length > r111.intValue()) goto L31;
        int r112 = r108.length;
    L20:
        if (r112 > r111.intValue()) goto L22;
        r112 = r112 * 2;
        goto L20
    L22:
        int[] r113 = new int[r112];
        System.arraycopy(r108, 0, r113, 0, r108.length);
        Arrays.fill(r113, r108.length, r112, -1);
        Field r114 = f164391b;
        if (r114 == null) goto L32;
        r114.set(r101, r113);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    L11:
        r107 = 0;
        goto L12
    L7:
        r105 = r103;
        goto L8
    }

    public static Object b(Object r100, String r101, Field r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r101, "filedName");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r102 != null) goto L19;
        Class<?> r104 = r100.getClass();
    L7:
        if (r104 == null) goto L18;
        Field[] r105 = r104.getDeclaredFields();
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L14;
        Field r108 = r105[r107];
        if (Intrinsics.areEqual(r108.getName(), r101) == true) goto L15;
        r107 = r107 + 1;
    L15:
        if (r108 != null) goto L16;
        r104 = r104.getSuperclass();
        goto L7
    L16:
        r108.setAccessible(true);
        r102 = r108;
        goto L19
    L14:
        r108 = null;
        goto L15
    L18:
        r102 = null;
    L19:
        if (r102 == null) goto L28;
        if (r103 == null) goto L23;
        Unit r109 = (Unit) r103.invoke(r102);
    L23:
        return r102.get(r100);
    L28:
        return null;
    }
}
