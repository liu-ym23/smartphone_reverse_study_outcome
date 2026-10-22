package com.bytedance.android.shopping.mall.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends Dialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f178631h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f178632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f178633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RunnableC2654b f178634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f178635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f178636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f178637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f178638g;

    public static final class a {
        public static void a(Context r100, final String r101, final int r102, int r103, int r104, final int r105) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "message");
            final b r106 = new b(r100);
            r106.f178636e = r103;
            r106.f178637f = r104;
            Intrinsics.checkNotNullParameter(r101, "message");
            d.c(new MallToast$makeShow$1(r106, r101, r105, r102));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.widget.b$b, reason: collision with other inner class name */
    public static final class RunnableC2654b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f178639a;

        public RunnableC2654b(b r100) {
            this.f178639a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f178639a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            d.c(new MallToast$hidePopupToast$1(r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f178633b = true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f178633b = false;
        this.f178632a.removeCallbacks(this.f178634c);
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ec_mall_popup_toast_dialog);
        this.f178632a = new Handler(Looper.getMainLooper());
        this.f178634c = new RunnableC2654b(this);
        this.f178635d = -UIUtils.getStatusBarHeight(r100);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ec_mall_custom_toast_layout, null);     // Catch: Exception -> L34
        if (r101 == null) goto L6;
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.ec_mall_toast_container);     // Catch: Exception -> L34
    L6:
        this.f178638g = (TextView) r101.findViewById(R.id.ec_mall_toast_text);     // Catch: Exception -> L34
        setContentView(r101);     // Catch: Exception -> L34
        Window r103 = getWindow();     // Catch: Exception -> L34
        if (r103 == null) goto L9;
        r103.addFlags(8);     // Catch: Exception -> L34
    L9:
        Window r104 = getWindow();     // Catch: Exception -> L34
        if (r104 == null) goto L12;
        r104.addFlags(32);     // Catch: Exception -> L34
    L12:
        Window r105 = getWindow();     // Catch: Exception -> L34
        if (r105 == null) goto L15;
        r105.addFlags(16);     // Catch: Exception -> L34
    L15:
        Window r106 = getWindow();     // Catch: Exception -> L34
        if (r106 == null) goto L18;
        r106.addFlags(512);     // Catch: Exception -> L34
    L18:
        Window r107 = getWindow();     // Catch: Exception -> L34
        if (r107 == null) goto L21;
        r107.setLayout(-2, -2);     // Catch: Exception -> L34
    L21:
        Window r108 = getWindow();     // Catch: Exception -> L34
        if (r108 == null) goto L30;
        View r109 = r108.getDecorView();     // Catch: Exception -> L34
        if (c.f346345e == false) goto L28;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L34
        Thread r110 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L34
        if (r110 == c.f346341a) goto L28;
        c.a(r110, "getDecorView");     // Catch: Exception -> L34
    L28:
        if (r109 == null) goto L30;
        r109.setTag("ignore_eye_protection");     // Catch: Exception -> L34
    L30:
        Window r111 = getWindow();     // Catch: Exception -> L34
        if (r111 == null) goto L39;
        r111.setGravity(17);     // Catch: Exception -> L34
        return;
    L39:
        return;
    L34:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }
}
