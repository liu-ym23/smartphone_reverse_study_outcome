package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 {

    public static final class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f170421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type[] f170422b;

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return this.f170422b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f170421a;
        }

        public a(Class r100, Type[] r101) {
            this.f170421a = r100;
            this.f170422b = r101;
        }
    }

    public static final String f() {
        HybridAppInfoService r100 = HybridAppInfoService.f47545p;
        if (HybridAppInfoService.j() == false) goto L6;
        return "ecom_mall_dylite";
    L6:
        String r101 = r100.getAppId();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        return "ecom_mall_".concat(r101);
    }

    public static final List<View> b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$children");
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r101 = (ViewGroup) r100;
        IntRange r102 = RangesKt.until(0, r101.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        r103.add(r101.getChildAt(((IntIterator) r104).nextInt()));
        goto L6
    L12:
        return CollectionsKt.toList(r103);
    L10:
        return CollectionsKt.emptyList();
    }

    public static final int c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$gone");
        r100.setVisibility(8);
    }

    public static final <T> String i(List<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$seriesString");
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.append(r102.next() + tb2.c.DEFAULT_TEXT);
        goto L4
    L7:
        return r101.toString();
    }

    public static final String k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return r100;
    }

    public static final String m(Object r100) {
        if (r100 != null) goto L6;
        return (String) r100;
    L6:
        return p.c(r100);
    }

    public static final void n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$visible");
        r100.setVisibility(0);
    }

    public static final ParameterizedType getType(Class<?> r100, Type... r101) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        Intrinsics.checkNotNullParameter(r101, "args");
        return new a(r100, r101);
    }

    public static final void j(View r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setBackgroundCompat");
        r100.setBackground(r101);
    }

    public static final void l(String r100, Exception r101) {
        if (HybridAppInfoService.f47545p.isLocalTest() == true) goto L7;
        EnsureManager.ensureNotReachHere(r101, r100);
        return;
    L7:
        throw new RuntimeException(r100, r101);
    }

    public static final <T, R> void a(Map<T, List<R>> r100, T r101, R r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addNewValue");
        if (r100.containsKey(r101) == false) goto L7;
        List r103 = (List) ((LinkedHashMap) r100).get(r101);
        if (r103 == null) goto L9;
        r103.add(r102);
        return;
    L9:
        return;
    L7:
        r100.put(r101, CollectionsKt.mutableListOf(new Object[]{r102}));
    }

    public static final Object d(Map<String, ? extends Object> r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOrDefaultValue");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        if (r100.containsKey(r101) == false) goto L9;
        Object r103 = r100.get(r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        return r103;
    L9:
        return r102;
    }

    public static final int g(Map<String, ? extends Object> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$optInt");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.containsKey(r101) == false) goto L11;
        Object r103 = r100.get(r101);
        if ((r103 instanceof Integer) == true) goto L7;
        r103 = null;
    L7:
        Integer r104 = (Integer) r103;
        if (r104 != null) goto L10;
        return r102;
    L10:
        return r104.intValue();
    L11:
        return r102;
    }

    public static final String h(Map<String, ? extends Object> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$optString");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        if (r100.containsKey(r101) == false) goto L12;
        Object r103 = r100.get(r101);
        if ((r103 instanceof String) == true) goto L7;
        r103 = null;
    L7:
        String r104 = (String) r103;
        if (r104 != null) goto L11;
        return r102;
    L11:
        return r104;
    L12:
        return r102;
    }
}
