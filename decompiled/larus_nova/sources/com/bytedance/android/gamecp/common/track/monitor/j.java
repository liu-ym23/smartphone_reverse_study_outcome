package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements av.e, Function1<View, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f56852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<View, WeakReference<h>> f56853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<Object, WeakReference<View>> f56854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<View, Boolean> f56855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final av.f f56856e;

    @Override // av.e
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
    }

    @Override // av.e
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
    }

    public j(av.f r100) {
        Intrinsics.checkNotNullParameter(r100, "pageMonitor");
        this.f56856e = r100;
        this.f56852a = new WeakReference(null);
        this.f56853b = new WeakHashMap();
        this.f56854c = new WeakHashMap();
        this.f56855d = new WeakHashMap();
    }

    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WeakReference<h> r101 = this.f56853b.get(r100);
        View r102 = null;
        if (r101 == null) goto L5;
        h r103 = r101.get();
    L6:
        if (r103 == null) goto L18;
        WeakReference<View> r104 = r103.f56844d;
        if (r104 == null) goto L10;
        r102 = r104.get();
    L10:
        if (r102 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L18;
        Intrinsics.checkNotNullParameter(this, "observer");
        r103.f56843c = this;
        return;
    L12:
        if (r103.f56845e == false) goto L14;
        r105 = true;
    L18:
        if (r103 == null) goto L20;
        r103.b();
    L20:
        h r106 = new h();
        r106.c(r100, this);
        this.f56853b.put(r100, new WeakReference(r106));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // av.e
    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        WeakReference<View> r101 = this.f56854c.remove(r100);
        if (r101 == null) goto L8;
        View r102 = r101.get();
        if (r102 == null) goto L9;
        e(r102);
        return;
    L9:
        return;
    }

    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Boolean r101 = this.f56855d.get(r100);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
        return;
    L5:
        this.f56855d.put(r100, r102);
        View r103 = this.f56852a.get();
        if (r103 == null) goto L20;
        HashMap r104 = new HashMap();
        HashMap<String, String> r105 = GamecpTracker.f56755a;
        GamecpTracker.f(r103, r104);
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r104, "data");
        GPViewTrackData r106 = GamecpTracker.l(r100);
        if (r106 == null) goto L21;
        GPViewTrackData r107 = null;
        if (r106.isPageData() == true) goto L13;
        r106 = null;
    L13:
        if (r106 != null) goto L15;
        return;
    L15:
        if (r106.getRouterData().isEmpty() == false) goto L17;
        r107 = r106;
    L17:
        if (r107 == null) goto L23;
        r107.setRouterData(r104);
        return;
    L23:
        return;
    L21:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View r100) {
        this.f56852a = new WeakReference(r100);
        return Unit.INSTANCE;
    }
}
