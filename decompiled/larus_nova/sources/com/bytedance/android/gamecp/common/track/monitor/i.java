package com.bytedance.android.gamecp.common.track.monitor;

import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, WeakReference<com.bytedance.android.gamecp.common.track.monitor.a>> f56850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, WeakReference<h>> f56851b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f56850a.size() < 200) goto L11;
        Iterator<Map.Entry<String, WeakReference<com.bytedance.android.gamecp.common.track.monitor.a>>> r100 = this.f56850a.entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L11;
        if (r100.next().getValue().get() != null) goto L6;
        r100.remove();
    L11:
        if (this.f56851b.size() < 200) goto L18;
        Iterator<Map.Entry<String, WeakReference<com.bytedance.android.gamecp.common.track.monitor.a>>> r101 = this.f56850a.entrySet().iterator();
    L14:
        if (r101.hasNext() == false) goto L29;
        if (r101.next().getValue().get() != null) goto L14;
        r101.remove();
        goto L14
    L29:
        return;
    }

    public i() {
        this.f56850a = new HashMap();
        this.f56851b = new HashMap();
    }

    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        WeakReference<com.bytedance.android.gamecp.common.track.monitor.a> r101 = this.f56850a.remove(String.valueOf(r100.hashCode()));
        if (r101 == null) goto L8;
        com.bytedance.android.gamecp.common.track.monitor.a r102 = r101.get();
        if (r102 == null) goto L9;
        r102.detachViewAppearObserver();
        return;
    L9:
        return;
    }

    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        WeakReference<h> r101 = this.f56851b.remove(String.valueOf(r100.hashCode()));
        if (r101 == null) goto L8;
        h r102 = r101.get();
        if (r102 == null) goto L9;
        r102.b();
        return;
    L9:
        return;
    }

    public final void b(View r110, float r111, boolean r210, boolean r211, Rect r212, Function2<? super Boolean, ? super Float, Unit> r213) {
        Intrinsics.checkNotNullParameter(r110, "moduleView");
        Intrinsics.checkNotNullParameter(r213, "observer");
        a();
        String r100 = String.valueOf(r110.hashCode());
        WeakReference<com.bytedance.android.gamecp.common.track.monitor.a> r101 = this.f56850a.get(r100);
        View r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.gamecp.common.track.monitor.a r103 = r101.get();
    L6:
        if (r103 == null) goto L28;
        WeakReference<View> r104 = r103.f56812b;
        if (r104 == null) goto L11;
        r102 = r104.get();
    L11:
        if (r102 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L28;
        Intrinsics.checkNotNullParameter(r213, "observer");
        if (r211 == true) goto L21;
    L23:
        r103.f56813c = r213;
        if (r211 == true) goto L26;
        return;
    L26:
        if (r103.f56814d == false) goto L33;
        r103.g(true);
        return;
    L33:
        return;
    L21:
        if (r103.f56814d == false) goto L23;
        r103.g(false);
        goto L23
    L13:
        if (r103.f56818h == false) goto L15;
        r105 = true;
    L28:
        if (r103 == null) goto L30;
        r103.detachViewAppearObserver();
    L30:
        com.bytedance.android.gamecp.common.track.monitor.a r106 = new com.bytedance.android.gamecp.common.track.monitor.a(0, false, r111, r210, r212, 19);
        r106.attachViewAppearObserver(r110, r213);
        this.f56850a.put(r100, new WeakReference(r106));
        return;
    L5:
        r103 = null;
        goto L6
    }
}
