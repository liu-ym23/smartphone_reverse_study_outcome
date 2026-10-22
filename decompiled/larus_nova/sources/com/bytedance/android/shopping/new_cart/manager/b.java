package com.bytedance.android.shopping.new_cart.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f179104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f179105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f179106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f179107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f179108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.new_cart.manager.a f179109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f179110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f179111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f179112i;

    public interface a {
        void a();

        void z();
    }

    public final void a(Boolean r100) {
        Rect r101 = new Rect();
        this.f179104a.getWindowVisibleDisplayFrame(r101);
        int r102 = r101.bottom - r101.top;
        if (r102 == this.f179105b) goto L18;
        int r103 = this.f179104a.getRootView().getHeight();
        int r104 = r103 - r102;
        if (r104 > (r103 / 4)) goto L7;
        this.f179104a.setPadding(0, 0, 0, 0);
        a r105 = this.f179108e;
        if (r105 == null) goto L16;
        r105.a();
    L16:
        this.f179104a.requestLayout();
        this.f179105b = r102;
        return;
    L7:
        if (r100.booleanValue() == false) goto L9;
        this.f179104a.setPadding(0, 0, 0, Math.max(0, (this.f179106c - ((r103 - r104) + this.f179107d)) - this.f179110g));
    L10:
        a r106 = this.f179108e;
        if (r106 == null) goto L16;
        r106.z();
        goto L16
    L9:
        this.f179104a.setPadding(0, 0, 0, 0);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.shopping.new_cart.manager.a] */
    public b(View r100, c r101, final Boolean r102, int r103) {
        this.f179108e = null;
        this.f179110g = 0;
        this.f179110g = r103;     // Catch: Throwable -> L18
        this.f179108e = r101;     // Catch: Throwable -> L18
        this.f179107d = k1.p();     // Catch: Throwable -> L18
        if ((r100 instanceof ViewGroup) == false) goto L14;
        this.f179104a = ((ViewGroup) r100).getChildAt(0);     // Catch: Throwable -> L18
        View r104 = r100.findViewById(R.id.fl_footer_popup_container);     // Catch: Throwable -> L18
        this.f179111h = r104;     // Catch: Throwable -> L18
        View r105 = r100.findViewById(R.id.fl_footer_Hybrid_popup_container);     // Catch: Throwable -> L18
        this.f179112i = r105;     // Catch: Throwable -> L18
        ViewParent r106 = r100.getParent();     // Catch: Throwable -> L18
        if (r104 == null) goto L8;
    L10:
        if (r105 != null) goto L14;
        if ((r106 instanceof ViewGroup) == false) goto L14;
        this.f179112i = ((ViewGroup) r106).findViewById(R.id.fl_footer_Hybrid_popup_container);     // Catch: Throwable -> L18
        goto L14
    L8:
        if ((r106 instanceof ViewGroup) == false) goto L10;
        this.f179111h = ((ViewGroup) r106).findViewById(R.id.fl_footer_popup_container);     // Catch: Throwable -> L18
    L14:
        if (r100 != null) goto L16;
        return;
    L16:
        this.f179109f = new com.bytedance.android.shopping.new_cart.manager.a(this, r102);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        if (ECAppInfoService.f48114e.i() == true) goto L23;
        ECExceptionMonitor.e(th);
        return;
    L23:
        throw th;
    }
}
