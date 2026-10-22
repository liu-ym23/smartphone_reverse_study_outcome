package com.stepos.statsrpk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2862a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Looper looper, int i) {
        super(looper);
        this.f2862a = i;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        switch (this.f2862a) {
            case 0:
                if (message.what == 5) {
                    Log.w("d", "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                    synchronized (h.class) {
                        h.f2863a = null;
                        try {
                            Looper.myLooper().quit();
                        } catch (NullPointerException e10) {
                            Log.w("d", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
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
