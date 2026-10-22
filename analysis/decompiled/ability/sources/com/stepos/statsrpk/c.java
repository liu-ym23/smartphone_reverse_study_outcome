package com.stepos.statsrpk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Looper looper, int i) {
        super(looper);
        this.f3979a = i;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        switch (this.f3979a) {
            case 0:
                if (message.what == 5) {
                    Log.w("d", "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                    synchronized (d.class) {
                        d.f3980a = null;
                        try {
                            Looper.myLooper().quit();
                        } catch (NullPointerException e) {
                            Log.w("d", "Exception: " + e.toString() + " - Cause: " + e.getCause());
                        }
                    }
                    return;
                }
                return;
            default:
                if (message.what == 0) {
                    Object obj2 = message.obj;
                    if ((obj2 instanceof WeakReference) && (obj = ((WeakReference) obj2).get()) != null) {
                        View view = (View) obj;
                        if (view.isAttachedToWindow()) {
                            view.performHapticFeedback(message.arg1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
