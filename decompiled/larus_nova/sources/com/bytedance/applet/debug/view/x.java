package com.bytedance.applet.debug.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f191661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f191662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f191663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f191664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f191665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f191666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f191667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f191668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WindowManager.LayoutParams f191669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WindowManager f191670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f191671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f191672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f191673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f191674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f191675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f191676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f191677q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f191678r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f191679s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f191680t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f191681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f191682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f191683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f191684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f191685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f191686z;

    public interface a {
        void a(View r100);

        void onClick(View r100);

        void onLongClick(View r100);
    }

    public final void a() {
        WindowManager.LayoutParams r100 = this.f191669i;
        r100.x = this.f191664d;
        if (this.f191663c == false) goto L5;
        int r101 = (int) UIUtils.dip2Px(this.f191661a, 68.0f);
    L6:
        r100.y = r101;
        if (this.f191663c == false) goto L10;
        r100.flags |= 16;
        return;
    L10:
        return;
    L5:
        r101 = this.f191666f / 3;
        goto L6
    }

    public final void b(View r100) {
        WindowManager r101 = this.f191670j;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.removeViewImmediate(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.i("AppletDebugActivity", "removeWindowView error " + e.getMessage());
    }

    public x(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "floatingView");
        this.f191661a = r100;
        this.f191662b = r101;
        this.f191663c = false;
        this.f191664d = r100.getResources().getDimensionPixelSize(R.dimen.dp_16);
        this.f191665e = r100.getResources().getDimensionPixelSize(R.dimen.dp_16);
        this.f191666f = com.larus.utils.i.c(r100);
        this.f191667g = com.larus.utils.i.d(r100);
        this.f191668h = com.larus.utils.i.e(r100);
        WindowManager.LayoutParams r102 = new WindowManager.LayoutParams();
        this.f191669i = r102;
        this.f191671k = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f191673m = new Handler(Looper.getMainLooper());
        this.f191674n = -1.0f;
        this.f191675o = -1.0f;
        this.f191676p = -1.0f;
        this.f191677q = -1.0f;
        this.f191681u = true;
        this.f191683w = 500;
        this.f191684x = 300;
        this.f191685y = 200;
        r102.type = 2;
        r102.flags = 552;
        r102.format = 1;
        r102.gravity = 8388659;
        r102.width = -2;
        r102.height = -2;
        r101.setOnTouchListener(new a0(this));
        a();
    }
}
