package com.bytedance.android.livesdk.widget;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f161778a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f161779a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f161779a.f161778a.f161815y.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(k r100) {
            this.f161779a = r100;
        }
    }

    public k(m r100) {
        this.f161778a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RelativeLayout r101 = this.f161778a.f161804n;
        if (r101 == null) goto L6;
        r101.post(new l(r101, false));
    L6:
        new Handler().postDelayed(new a(this), 100);
    }
}
