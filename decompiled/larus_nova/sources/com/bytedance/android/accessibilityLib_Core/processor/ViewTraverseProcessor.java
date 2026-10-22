package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
public final class ViewTraverseProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f38299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f38300b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f38301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap<View, WeakHashMap<View, Boolean>> f38302d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f38303e = null;

    public ViewTraverseProcessor() {
    }

    static {
        f38299a = LazyKt.lazy(ViewTraverseProcessor$mInternalViewMemCache$2.INSTANCE);
        f38300b = LazyKt.lazy(ViewTraverseProcessor$mProcessorChain$2.INSTANCE);
        f38301c = true;
        f38302d = new WeakHashMap();
        f38303e = LazyKt.lazy(ViewTraverseProcessor$traversePoolThreadScope$2.INSTANCE);
    }

    public static void a(View r100) {
        BuildersKt.async$default((CoroutineScope) f38303e.getValue(), null, null, new ViewTraverseProcessor$rootViewOut$1(r100, null), 3, null);
    }

    public static void b(View r110, int r111, TraverseFromType r112) {
        if (f38301c == true) goto L37;
        return;
    L37:
    L28:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L33;
        Context r113 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L33:
        if (("TraverseProcessor >>> visit view  exception = " + e.getMessage()) == null) goto L35;
        Context r114 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L35:
        Unit r115 = Unit.INSTANCE;
        return;
    L6:
        if (("traverseView rootView = " + r110 + ", traverseFromType = " + r112.name()) == null) goto L9;
        Context r100 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
    L9:
        if (r112 != TraverseFromType.InternalVisitViewGlobalLayoutChange) goto L11;
    L16:
        boolean r101 = true;
    L17:
        if (r101 == true) goto L19;
    L26:
        BuildersKt.async$default((CoroutineScope) f38303e.getValue(), null, null, new ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(new WeakReference(r110), null, r110, r112, r111), 3, null);     // Catch: Exception -> L28
        return;
    L19:
        if (r110.getWidth() != 0) goto L26;
        if (r110.getHeight() != 0) goto L26;
        if (("width or height not valid,traverseFromType = " + r112.name()) == null) goto L38;
        Context r116 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L28
        return;
    L38:
        return;
    L11:
        if (r112 == TraverseFromType.FragmentGlobalLayoutChange) goto L16;
        if (r112 == TraverseFromType.ActivityGlobalLayoutChange) goto L16;
        r101 = false;
        goto L17
    }
}
