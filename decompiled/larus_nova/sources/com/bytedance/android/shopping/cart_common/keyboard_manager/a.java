package com.bytedance.android.shopping.cart_common.keyboard_manager;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC2579a f172072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver f172074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f172075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f172076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f172077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f172078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f172079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f172080i;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.cart_common.keyboard_manager.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC2579a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f172081a;

        public ViewTreeObserverOnGlobalLayoutListenerC2579a(a r100) {
            this.f172081a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            a r100 = this.f172081a;
            r100.getClass();
            Rect r101 = new Rect();
            r100.f172076e.getWindowVisibleDisplayFrame(r101);
            int r102 = r101.bottom - r101.top;
            if (r102 == r100.f172073b) goto L14;
            int r103 = r100.f172075d;
            int r104 = r103 - r102;
            if (r104 <= (r103 / 4)) goto L11;
            Integer r105 = r100.f172077f;
            if (r105 == null) goto L9;
            int r106 = r105.intValue();
        L10:
            int r107 = (r104 - r106) - r100.f172080i;
            r100.f172076e.setPadding(0, 0, 0, Math.max(0, r107));
            Lazy r108 = CartCommonLog.f179348a;
            CartCommonLog.a("NewCartStarter", CommonPopupKeyBoardManager$possiblyResizeChildOfContent$1.INSTANCE);
            r100.f172078g.invoke();
        L12:
            r100.f172076e.requestLayout();
            r100.f172073b = r102;
            return;
        L9:
            r106 = com.bytedance.android.shopping.extensions.b.b(64);
            goto L10
        L11:
            r100.f172076e.setPadding(0, 0, 0, 0);
            Lazy r109 = CartCommonLog.f179348a;
            CartCommonLog.a("NewCartStarter", CommonPopupKeyBoardManager$possiblyResizeChildOfContent$2.INSTANCE);
            r100.f172079h.invoke();
            goto L12
        }
    }

    @Override // com.bytedance.android.shopping.cart_common.keyboard_manager.b
    public final void onDetach() {
        ViewTreeObserver r100 = this.f172074c;
        if (r100 != null) goto L5;
    L7:
        this.f172074c = null;
        return;
    L5:
        if (r100.isAlive() == false) goto L7;
        r100.removeOnGlobalLayoutListener(this.f172072a);
        goto L7
    }

    public a(ViewGroup r100, Integer r101, Function0<Unit> r102, Function0<Unit> r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "popUpContainer");
        Intrinsics.checkNotNullParameter(r102, "onPopupKeyBoardShow");
        Intrinsics.checkNotNullParameter(r103, "onPopupKeyBoardHide");
        this.f172076e = r100;
        this.f172077f = r101;
        this.f172078g = r102;
        this.f172079h = r103;
        this.f172080i = r104;
        this.f172072a = new ViewTreeObserverOnGlobalLayoutListenerC2579a(this);
    }
}
