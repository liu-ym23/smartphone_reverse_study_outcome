package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f55065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f55066b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f55067a;

        public a(c r100) {
            this.f55067a = r100;
        }

        public final void a() {
            ViewParent r100 = this.f55067a.f55065a.f55057a.getParent();
            if ((r100 instanceof ViewGroup) == true) goto L5;
            r100 = null;
        L5:
            ViewGroup r101 = (ViewGroup) r100;
            if (r101 == null) goto L9;
            int[] r102 = new int[2];
            r101.getLocationOnScreen(r102);
            c r103 = this.f55067a;
            r103.f55065a.f55058b.setX(((r103.f55066b.getX() + (this.f55067a.f55066b.getWidth() / 2)) - (this.f55067a.f55065a.f55058b.getWidth() / 2)) - r102[0]);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f55065a.f55058b.post(new a(this));
    }

    public c(b r100, View r101) {
        this.f55065a = r100;
        this.f55066b = r101;
    }
}
