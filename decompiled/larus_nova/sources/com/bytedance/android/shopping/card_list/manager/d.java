package com.bytedance.android.shopping.card_list.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f171657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f171658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver f171659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f171660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f171661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f171662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SlcRenderContext f171663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f171664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f171665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f171666j;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f171667a;

        public a(d r100) {
            this.f171667a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            d r100 = this.f171667a;
            if (r100.f171660d == null) goto L5;
        L9:
            View r101 = r100.f171660d;
            if (r101 != null) goto L12;
        L14:
            Rect r102 = new Rect();
            r100.f171661e.getWindowVisibleDisplayFrame(r102);
            int r103 = r102.bottom - r102.top;
            if (r103 == r100.f171658b) goto L34;
            View r104 = r100.f171661e.getRootView();
            if (r104 == null) goto L19;
            int r105 = r104.getHeight();
        L20:
            int r106 = r105 - r103;
            View r107 = r100.f171661e.getChildAt(0);
            if (r107 == null) goto L23;
            int r108 = r107.getHeight();
        L25:
            if (r106 <= (r105 / 4)) goto L31;
            Integer r109 = r100.f171662f;
            if (r109 == null) goto L29;
            int r110 = r109.intValue();
        L30:
            int r111 = ((r106 - r110) - r108) - r100.f171666j;
            r100.f171661e.setPadding(0, 0, 0, Math.max(0, r111));
            r100.f171664h.invoke();
        L32:
            r100.f171661e.requestLayout();
            r100.f171658b = r103;
            return;
        L29:
            r110 = com.bytedance.android.shopping.extensions.b.b(64);
            goto L30
        L31:
            r100.f171661e.setPadding(0, 0, 0, 0);
            r100.f171665i.invoke();
            goto L32
        L23:
            r108 = 0;
            goto L25
        L19:
            r105 = r100.f171661e.getHeight();
            goto L20
        L34:
            return;
        L12:
            if (r101.hasFocus() != true) goto L14;
            return;
        L5:
            if (r100.f171663g == null) goto L7;
            View r112 = SlcRenderContext.f(r100.f171661e, "search_input");
        L8:
            r100.f171660d = r112;
            goto L9
        L7:
            r112 = null;
            goto L8
        }
    }

    public d(ViewGroup r100, Integer r101, SlcRenderContext r102, Function0<Unit> r103, Function0<Unit> r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "popUpContainer");
        Intrinsics.checkNotNullParameter(r103, "onPopupKeyBoardShow");
        Intrinsics.checkNotNullParameter(r104, "onPopupKeyBoardHide");
        this.f171661e = r100;
        this.f171662f = r101;
        this.f171663g = r102;
        this.f171664h = r103;
        this.f171665i = r104;
        this.f171666j = r105;
        this.f171657a = new a(this);
    }
}
