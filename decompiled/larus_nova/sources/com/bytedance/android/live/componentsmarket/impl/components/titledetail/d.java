package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.view.MotionEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import zg1.d0;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f64712a;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f64713a;

        public a(d r100) {
            this.f64713a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 != null) goto L4;
        L6:
            this.f64713a.f64712a.f64714a.f64685a.onTouchEvent(r101);
            return true;
        L4:
            if (r101.getAction() != 0) goto L6;
            xs2.b.a().post(new d0());
            goto L6
        }
    }

    public d(e r100) {
        this.f64712a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f64712a.f64714a.contentView.setOnTouchListener(new a(this));     // Catch: Throwable -> L4
        this.f64712a.f64714a.contentView.setOnClickListener(f.f64715a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
