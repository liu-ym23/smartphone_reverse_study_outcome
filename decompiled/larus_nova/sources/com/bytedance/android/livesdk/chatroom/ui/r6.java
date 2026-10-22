package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class r6 implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f113934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q6 f113935b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r6 f113936a;

        public a(r6 r100) {
            this.f113936a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = this.f113936a.f113935b.f113912b;     // Catch: Throwable -> L11
            if ((r100 instanceof View) == true) goto L5;
            r100 = null;
        L5:
            View r101 = (View) r100;     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            ViewTreeObserver r102 = r101.getViewTreeObserver();     // Catch: Throwable -> L11
            if (r102 == null) goto L18;
            r102.removeOnDrawListener(this.f113936a.f113935b.f113918h);     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        Object r100 = this.f113935b.f113912b;
        Object r101 = null;
        if ((r100 instanceof View) == true) goto L5;
        r100 = null;
    L5:
        View r102 = (View) r100;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getVisibility() != 0) goto L25;
        IInteractFeedView r103 = this.f113935b.f113912b;
        if ((r103 instanceof View) == false) goto L13;
        r101 = r103;
    L13:
        View r104 = (View) r101;
        if (r104 == null) goto L18;
        if (r104.getAlpha() != 0.0f) goto L18;
        return;
    L18:
        if (this.f113934a == true) goto L27;
        this.f113934a = true;
        ii1.a r105 = this.f113935b.f113921k;
        if (r105 == null) goto L22;
        r105.q();
    L22:
        com.bytedance.android.live.core.utils.i0.h(new a(this));
        return;
    L27:
        return;
    }

    public r6(q6 r100) {
        this.f113935b = r100;
    }
}
