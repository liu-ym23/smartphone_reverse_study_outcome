package com.bytedance.android.gamecp.common.track;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class TrackViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, WeakReference<View>> f56771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<View, WeakReference<View>> f56772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TrackViewUtils f56773c = null;

    public TrackViewUtils() {
    }

    static {
        f56773c = new TrackViewUtils();
        f56771a = new WeakHashMap();
        f56772b = new WeakHashMap();
    }

    public static String a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return String.valueOf(r100.hashCode());
    }

    public static View b(View r100) {
        if (r100 != null) goto L13;
        return null;
    L13:
        return c(f56771a, r100, new TrackViewUtils$getPageParamNodeRootView$1(f56773c));
    L7:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L11;
        r101 = "getPageParamNodeRootView failure";
    L11:
        yr.c.b("TrackViewUtils", r101);
        return null;
    }

    public static View d(View r100) {
        return c(f56772b, r100, new TrackViewUtils$getShowSetRootView$1(f56773c));
    }

    public static View c(WeakHashMap r100, View r101, Function1 r102) {
        WeakReference r103 = (WeakReference) r100.get(r101);
        if (r103 == null) goto L5;
        View r104 = (View) r103.get();
    L6:
        if (r104 == null) goto L9;
        return r104;
    L9:
        if (r101.isAttachedToWindow() == false) goto L11;
    L15:
        View r105 = r101;
    L17:
        if (((Boolean) r102.invoke(r105)).booleanValue() == true) goto L26;
        if (r105 == null) goto L20;
        Object r106 = r105.getParent();
    L22:
        if ((r106 instanceof View) == true) goto L24;
        r106 = null;
    L24:
        r105 = (View) r106;
        if (r105 != null) goto L17;
    L20:
        r106 = null;
    L26:
        if (r105 == null) goto L28;
        r100.put(r101, new WeakReference(r105));
    L28:
        return r105;
    L11:
        if (r101.getParent() != null) goto L15;
        int r107 = com.bytedance.android.gamecp.common.track.monitor.a.f56810y;
        if (com.bytedance.android.gamecp.common.track.monitor.a.C0914a.b(r101) == true) goto L15;
        int r108 = i.f56806a;
        yr.c.g("TrackViewUtils", "view not add to view tree, cannot find rootView");
        goto L15
    L5:
        r104 = null;
        goto L6
    }
}
