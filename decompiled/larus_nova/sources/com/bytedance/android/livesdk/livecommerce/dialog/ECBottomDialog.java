package com.bytedance.android.livesdk.livecommerce.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes10.dex */
public class ECBottomDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f147710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ih2.a f147711b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECBottomDialog f147712a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f147712a.J0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ECBottomDialog r100) {
            this.f147712a = r100;
        }
    }

    public interface b {
        void Nc(a r100);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        b r100 = this.f147710a;
        if (r100 != null) goto L6;
        super.cancel();
        return;
    L6:
        r100.Nc(new a(this));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Window r100 = getWindow();
        if (r100 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r101 = I0(r100).getViewTreeObserver();
        if (r101.isAlive() == false) goto L9;
        r101.removeOnPreDrawListener(this.f147711b);
        return;
    }

    public final void J0() {
        super.cancel();
    }

    public static View I0(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L7;
        this.f147711b = new ih2.a(r101);
        I0(r101).getViewTreeObserver().addOnPreDrawListener(this.f147711b);
        return;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public ECBottomDialog(Context r100, int r101) {
        super(r100, r101);
        this.f147711b = null;
        supportRequestWindowFeature(1);
    }
}
