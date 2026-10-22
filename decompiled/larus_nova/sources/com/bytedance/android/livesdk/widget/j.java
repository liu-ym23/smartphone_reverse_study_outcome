package com.bytedance.android.livesdk.widget;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f161760a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f161761a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f161761a.f161760a.f161815y.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(j r100) {
            this.f161761a = r100;
        }
    }

    public j(m r100) {
        this.f161760a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        m r101 = this.f161760a;
        if (r101.f161813w == true) goto L9;
        RelativeLayout r102 = r101.f161804n;
        if (r102 == null) goto L8;
        r102.post(new l(r102, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        m r103 = this.f161760a;
        DialogInterface.OnClickListener r104 = r103.f161811u;
        if (r104 == null) goto L13;
        r104.onClick(r103.f161815y, 1);
        return;
    }
}
