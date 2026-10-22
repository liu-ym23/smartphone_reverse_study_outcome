package com.bytedance.android.accessibilityLib_Core.tool;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.bytedance.android.accessibilityLib_Core.config.base.AbstractBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class AccessibilityCommonToolExtKt {
    public static final int c() {
        Resources r100 = com.bytedance.android.accessibilityLib_Core.helper.a.a().getResources();
        if (r100 == null) goto L7;
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        if (r101 == null) goto L7;
        float r102 = r101.density;
    L9:
        return (int) ((60.0f * r102) + 0.5f);
    L7:
        r102 = 1.0f;
        goto L9
    }

    public static final void a(IBaseConfig r100, Function1<? super IBaseConfig, Unit> r101) {
        ArrayDeque r102 = new ArrayDeque();
        r102.add(r100);
    L4:
        if ((!r102.isEmpty()) == false) goto L16;
        IBaseConfig r103 = (IBaseConfig) r102.removeFirst();
        r101.invoke(r103);
        if ((r103 instanceof AbstractBaseConfig) == false) goto L4;
        Iterator<com.bytedance.android.accessibilityLib_Core.config.bean.b> r104 = ((AbstractBaseConfig) r103).f38149b.f38172b.iterator();
    L9:
        if (r104.hasNext() == false) goto L4;
        com.bytedance.android.accessibilityLib_Core.config.bean.a r105 = r104.next().f38171a;
        if (r105 == null) goto L13;
        IBaseConfig r106 = r105.f38170a;
    L14:
        if (r106 == null) goto L9;
        r102.add(r106);
        goto L9
    L13:
        r106 = null;
        goto L14
    }

    public static final void b(final View r100, final Function1<? super View, Boolean> r101, final Function1<? super View, Unit> r102) {
        if ((r100 instanceof ViewGroup) == true) goto L8;
        boolean r103 = r101.invoke(r100).booleanValue();
        Function0<Unit> r104 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$1(r102, r100);
        if (r103 == false) goto L30;
        r104.invoke();
        return;
    L30:
        return;
    L8:
        final ArrayDeque r105 = new ArrayDeque();
        r105.add(r100);
    L10:
        if ((!r105.isEmpty()) == false) goto L23;
        final ViewGroup r106 = (ViewGroup) r105.removeFirst();
        boolean r107 = r101.invoke(r106).booleanValue();
        Function0<Unit> r108 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$2(r102, r106);
        if (r107 == false) goto L14;
        r108.invoke();
    L14:
        Iterator<View> r109 = ViewGroupKt.getChildren(r106).iterator();
    L16:
        if (r109.hasNext() == false) goto L10;
        final View r110 = r109.next();
        boolean r111 = r101.invoke(r110).booleanValue();
        Function0<Unit> r112 = new AccessibilityCommonToolExtKt$bfsVisitWithCondition$$inlined$forEach$lambda$1(r110, r101, r102, r105);
        if (r111 == false) goto L21;
        r112.invoke();
    L21:
        if ((r110 instanceof ViewGroup) == false) goto L16;
        r105.add(r110);
        goto L16
    }
}
