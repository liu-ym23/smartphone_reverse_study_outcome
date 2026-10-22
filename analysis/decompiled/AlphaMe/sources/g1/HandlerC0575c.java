package g1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.lang.ref.WeakReference;

/* renamed from: g1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class HandlerC0575c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12659a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerC0575c(Looper looper, int i4) {
        super(looper);
        this.f12659a = i4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        switch (this.f12659a) {
            case 3:
                if (message.what == 5) {
                    Log.w(DateTokenConverter.CONVERTER_KEY, "Worker received a hard kill. Thread id " + Thread.currentThread().getId());
                    synchronized (com.stepos.statsrpk.c.class) {
                        com.stepos.statsrpk.c.f12358a = null;
                        try {
                            Looper.myLooper().quit();
                        } catch (NullPointerException e4) {
                            Log.w(DateTokenConverter.CONVERTER_KEY, "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
                        }
                    }
                    return;
                }
                return;
            case 4:
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
            default:
                super.handleMessage(message);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerC0575c(Looper looper, Handler.Callback callback, int i4) {
        super(looper, callback);
        this.f12659a = i4;
    }
}
