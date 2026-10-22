package stepos.support.v7.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class l extends HandlerThread {

    /* renamed from: b, reason: collision with root package name */
    public static volatile l f41648b;

    /* renamed from: a, reason: collision with root package name */
    public Handler f41649a;

    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            if (message.what == 0) {
                Object obj2 = message.obj;
                if ((obj2 instanceof WeakReference) && (obj = ((WeakReference) obj2).get()) != null) {
                    View view = (View) obj;
                    if (view.isAttachedToWindow()) {
                        view.performHapticFeedback(message.arg1);
                    }
                }
            }
        }
    }

    public l() {
        super("FeedbackHandlerThread");
    }

    public static l b() {
        if (f41648b == null) {
            synchronized (l.class) {
                try {
                    if (f41648b == null) {
                        f41648b = new l();
                    }
                } finally {
                }
            }
        }
        f41648b.a();
        return f41648b;
    }

    public final boolean a() {
        if (Thread.State.NEW == getState()) {
            start();
        }
        return this.f41649a != null;
    }

    public void c(View view, int i10) {
        if (view.isAttachedToWindow() && a()) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = new WeakReference(view);
            messageObtain.arg1 = i10;
            messageObtain.what = 0;
            this.f41649a.sendMessage(messageObtain);
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            Log.d("FHT_LOG", "start state" + getState());
            super.start();
            this.f41649a = new a(getLooper());
        } catch (Exception e10) {
            Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e10);
        }
    }
}
