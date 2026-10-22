package com.bytedance.android.shopping.card_list.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f171646k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f171647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f171648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f171649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f171650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f171651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f171652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f171653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewTreeObserver f171654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.card_list.manager.a f171655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f171656j;

    public static final class a {
    }

    static {
    }

    public static final void a(c r100, Boolean r101) {
        r100.getClass();
        Rect r102 = new Rect();
        View r103 = r100.f171647a;
        if (r103 == null) goto L5;
        r103.getWindowVisibleDisplayFrame(r102);
    L5:
        int r104 = r102.bottom - r102.top;
        if (r104 == r100.f171648b) goto L37;
        View r105 = r100.f171647a;
        if (r105 == null) goto L12;
        View r106 = r105.getRootView();
        if (r106 == null) goto L12;
        int r107 = r106.getHeight();
    L13:
        int r108 = r107 - r104;
        if (r108 > (r107 / 4)) goto L16;
        View r109 = r100.f171647a;
        if (r109 == null) goto L29;
        r109.setPadding(0, 0, 0, 0);
    L29:
        com.bytedance.android.shopping.card_list.manager.a r110 = r100.f171655i;
        if (r110 == null) goto L32;
        r110.a();
    L32:
        View r111 = r100.f171647a;
        if (r111 == null) goto L35;
        r111.requestLayout();
    L35:
        r100.f171648b = r104;
        return;
    L16:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L20;
        View r112 = r100.f171647a;
        if (r112 == null) goto L23;
        r112.setPadding(0, 0, 0, RangesKt.coerceAtLeast(0, (r100.f171649c - ((r107 - r108) + r100.f171650d)) - r100.f171656j));
    L23:
        com.bytedance.android.shopping.card_list.manager.a r113 = r100.f171655i;
        if (r113 == null) goto L32;
        r113.z();
        goto L32
    L20:
        View r114 = r100.f171647a;
        if (r114 == null) goto L23;
        r114.setPadding(0, 0, 0, 0);
    L12:
        r107 = 0;
        goto L13
    }

    public c(CardListRootFrameLayoutContainer r100, KeyboardManager r101, Boolean r102, int r103) {
        this.f171655i = r101;
        this.f171656j = r103;
        this.f171650d = k1.p();
    L16:
        th = move-exception;
        if (ECAppInfoService.f48114e.i() == true) goto L21;
        ECExceptionMonitor.e(th);
        return;
    L21:
        throw th;
    L4:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        this.f171647a = r100.getChildAt(0);     // Catch: Throwable -> L16
        View r104 = r100.findViewById(R.id.fl_footer_popup_container);     // Catch: Throwable -> L16
        this.f171652f = r104;     // Catch: Throwable -> L16
        View r105 = r100.findViewById(R.id.fl_footer_Hybrid_popup_container);     // Catch: Throwable -> L16
        this.f171653g = r105;     // Catch: Throwable -> L16
        ViewParent r106 = r100.getParent();     // Catch: Throwable -> L16
        if (r104 == null) goto L8;
    L10:
        if (r105 != null) goto L14;
        if ((r106 instanceof ViewGroup) == false) goto L14;
        this.f171653g = ((ViewGroup) r106).findViewById(R.id.fl_footer_Hybrid_popup_container);     // Catch: Throwable -> L16
        goto L14
    L8:
        if ((r106 instanceof ViewGroup) == false) goto L10;
        this.f171652f = ((ViewGroup) r106).findViewById(R.id.fl_footer_popup_container);     // Catch: Throwable -> L16
    L14:
        this.f171651e = new b(this, r102);     // Catch: Throwable -> L16
    }
}
