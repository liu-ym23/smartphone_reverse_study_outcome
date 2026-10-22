package com.bytedance.android.shopping.anchorv4.helper;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BasePdpAddCartAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f166858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Point f166859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f166860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager f166861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f166862e;

    public abstract ECDraweeView a();

    public abstract void d(View r100, Function0<Unit> r101);

    public WindowManager.LayoutParams b() {
        WindowManager.LayoutParams r100 = new WindowManager.LayoutParams();
        r100.flags = 664;
        r100.format = -3;
        r100.type = 99;
        r100.gravity = 8388659;
        return r100;
    }

    public final Context getContext() {
        return this.f166862e;
    }

    public BasePdpAddCartAnimation(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f166862e = r100;
        this.f166858a = new Point();
        this.f166859b = new Point();
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r101 instanceof WindowManager) == true) goto L5;
        r101 = null;
    L5:
        this.f166861d = (WindowManager) r101;
    }

    public final void c(final Function0<Unit> r100) {
        final ECDraweeView r101 = a();
        WindowManager.LayoutParams r102 = b();
        WindowManager r103 = this.f166861d;
        if (r103 == null) goto L5;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
        r103.addView(r101, r102);
    L5:
        d(r101, new BasePdpAddCartAnimation$startAnimation$1(this, r100, r101));
    }

    public final void e(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof WindowManager.LayoutParams) == true) goto L5;
        r103 = null;
    L5:
        WindowManager.LayoutParams r104 = (WindowManager.LayoutParams) r103;
        if (r104 == null) goto L11;
        r104.x = r101;
        r104.y = r102;
        WindowManager r105 = this.f166861d;
        if (r105 == null) goto L12;
        r105.updateViewLayout(r100, r104);
        return;
    L12:
        return;
    }
}
