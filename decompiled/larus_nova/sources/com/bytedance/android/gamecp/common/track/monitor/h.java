package com.bytedance.android.gamecp.common.track.monitor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.common.utility.reflect.Reflect;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.AccessibilityDelegate f56842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super View, Unit> f56843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f56844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f56847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56849i;

    public final void b() {
        WeakReference<View> r100 = this.f56844d;
        if (r100 == null) goto L7;
        View r101 = r100.get();
        if (r101 == null) goto L7;
        r101.setAccessibilityDelegate(this.f56842b);
    L7:
        WeakReference<View> r102 = this.f56844d;
        if (r102 == null) goto L10;
        r102.clear();
    L10:
        this.f56844d = null;
        this.f56843c = null;
        this.f56842b = null;
        this.f56845e = false;
    }

    public h() {
        this.f56841a = "GPViewClickObserver";
    }

    public final void a(int r100) {
        if (r100 > 1) goto L5;
        return;
    L5:
        if ((this.f56842b instanceof h) == true) goto L9;
        yr.c.g(this.f56841a, "infinite loop method call in AccessibilityDelegate");
        return;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        int r101 = this.f56846f + 1;
        this.f56846f = r101;
        View.AccessibilityDelegate r102 = this.f56842b;
        if (r102 == null) goto L8;
        if (r101 > 1) goto L8;
        if (r102 == null) goto L7;
        AccessibilityNodeProvider r103 = r102.getAccessibilityNodeProvider(r100);
    L9:
        a(this.f56846f);
        this.f56846f = 0;
        return r103;
    L7:
        r103 = null;
    L8:
        r103 = super.getAccessibilityNodeProvider(r100);
        goto L9
    }

    public final void c(View r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (Build.VERSION.SDK_INT < 29) goto L14;
        View.AccessibilityDelegate r102 = r100.getAccessibilityDelegate();
    L12:
        this.f56842b = r102;
        r100.setAccessibilityDelegate(this);
        this.f56844d = new WeakReference(r100);
        this.f56843c = r101;
        this.f56845e = true;
        return;
    L14:
        r102 = (View.AccessibilityDelegate) Reflect.on(r100).get("mAccessibilityDelegate", new Class[]{View.AccessibilityDelegate.class});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        String r103 = this.f56841a;
        String r104 = th.getMessage();
        if (r104 != null) goto L11;
        r104 = "reflect error";
    L11:
        yr.c.b(r103, r104);
        r102 = null;
        goto L12
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = this.f56849i + 1;
        this.f56849i = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L8;
        if (r102 > 1) goto L8;
        if (r103 == null) goto L7;
        boolean r104 = r103.dispatchPopulateAccessibilityEvent(r100, r101);
    L9:
        a(this.f56849i);
        this.f56849i = 0;
        return r104;
    L7:
        r104 = false;
    L8:
        r104 = super.dispatchPopulateAccessibilityEvent(r100, r101);
        goto L9
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = this.f56847g + 1;
        this.f56847g = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L7;
        if (r102 > 1) goto L7;
        if (r103 == null) goto L8;
        r103.onInitializeAccessibilityEvent(r100, r101);
    L8:
        a(this.f56847g);
        this.f56847g = 0;
        return;
    L7:
        super.onInitializeAccessibilityEvent(r100, r101);
        goto L8
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        int r102 = this.f56846f + 1;
        this.f56846f = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L7;
        if (r102 > 1) goto L7;
        if (r103 == null) goto L8;
        r103.onInitializeAccessibilityNodeInfo(r100, r101);
    L8:
        a(this.f56846f);
        this.f56846f = 0;
        return;
    L7:
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        goto L8
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = this.f56846f + 1;
        this.f56846f = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L7;
        if (r102 > 1) goto L7;
        if (r103 == null) goto L8;
        r103.onPopulateAccessibilityEvent(r100, r101);
    L8:
        a(this.f56846f);
        this.f56846f = 0;
        return;
    L7:
        super.onPopulateAccessibilityEvent(r100, r101);
        goto L8
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        int r102 = this.f56846f + 1;
        this.f56846f = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L7;
        if (r102 > 1) goto L7;
        if (r103 == null) goto L8;
        r103.sendAccessibilityEvent(r100, r101);
    L8:
        a(this.f56846f);
        this.f56846f = 0;
        if (r101 != 1) goto L20;
        Function1<? super View, Unit> r104 = this.f56843c;
        if (r104 == null) goto L21;
        WeakReference<View> r105 = this.f56844d;
        if (r105 == null) goto L18;
        View r106 = r105.get();
        if (r106 == null) goto L18;
        r100 = r106;
    L18:
        Unit r107 = r104.invoke(r100);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        super.sendAccessibilityEvent(r100, r101);
        goto L8
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = this.f56846f + 1;
        this.f56846f = r102;
        View.AccessibilityDelegate r103 = this.f56842b;
        if (r103 == null) goto L7;
        if (r102 > 1) goto L7;
        if (r103 == null) goto L8;
        r103.sendAccessibilityEventUnchecked(r100, r101);
    L8:
        a(this.f56846f);
        this.f56846f = 0;
        return;
    L7:
        super.sendAccessibilityEventUnchecked(r100, r101);
        goto L8
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        int r103 = this.f56848h + 1;
        this.f56848h = r103;
        View.AccessibilityDelegate r104 = this.f56842b;
        if (r104 == null) goto L8;
        if (r103 > 1) goto L8;
        if (r104 == null) goto L7;
        boolean r105 = r104.onRequestSendAccessibilityEvent(r100, r101, r102);
    L9:
        a(this.f56848h);
        this.f56848h = 0;
        return r105;
    L7:
        r105 = false;
    L8:
        r105 = super.onRequestSendAccessibilityEvent(r100, r101, r102);
        goto L9
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        int r103 = this.f56846f + 1;
        this.f56846f = r103;
        View.AccessibilityDelegate r104 = this.f56842b;
        if (r104 == null) goto L8;
        if (r103 > 1) goto L8;
        if (r104 == null) goto L7;
        boolean r105 = r104.performAccessibilityAction(r100, r101, r102);
    L9:
        a(this.f56846f);
        this.f56846f = 0;
        return r105;
    L7:
        r105 = false;
    L8:
        r105 = super.performAccessibilityAction(r100, r101, r102);
        goto L9
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void addExtraDataToAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "extraDataKey");
        int r104 = this.f56846f + 1;
        this.f56846f = r104;
        View.AccessibilityDelegate r105 = this.f56842b;
        if (r105 != null) goto L5;
    L9:
        super.addExtraDataToAccessibilityNodeInfo(r100, r101, r102, r103);
    L10:
        a(this.f56846f);
        this.f56846f = 0;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        if (r104 > 1) goto L9;
        if (r105 == null) goto L10;
        r105.addExtraDataToAccessibilityNodeInfo(r100, r101, r102, r103);
        goto L10
    }
}
