package com.bytedance.android.livesdk.livecommerce.utils;

import android.app.Dialog;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f153123d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f153124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f153125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f153126c;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f153127a;

        public a(y0 r100) {
            this.f153127a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            y0 r100 = this.f153127a;
            if (r100.f153126c != 0) goto L5;
            r100.f153126c = r100.f153124a.getHeight();
        L5:
            y0 r101 = this.f153127a;
            if (r101.f153126c != r101.f153124a.getHeight()) goto L8;
            return;
        L8:
            y0 r102 = this.f153127a;
            if ((r102.f153126c - r102.f153124a.getHeight()) <= 200) goto L13;
            c r103 = this.f153127a.f153125b;
            if (r103 == null) goto L16;
            r103.b();
        L16:
            y0 r104 = this.f153127a;
            r104.f153126c = r104.f153124a.getHeight();
            return;
        L13:
            c r105 = this.f153127a.f153125b;
            if (r105 == null) goto L16;
            r105.a();
            goto L16
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b();
    }

    static {
    }

    public y0(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L10:
        this.f153124a = r102;
        if (r102 == null) goto L16;
        ViewTreeObserver r104 = r102.getViewTreeObserver();
        if (r104 == null) goto L17;
        r104.addOnGlobalLayoutListener(new a(this));
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r102 = null;
        goto L10
    }
}
