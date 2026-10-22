package stepos.support.v7.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class n extends HandlerThread {

    /* renamed from: b, reason: collision with root package name */
    private static volatile n f22079b;

    /* renamed from: a, reason: collision with root package name */
    private Handler f22080a;

    private static final class a extends Handler {
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

    private n() {
        super("FeedbackHandlerThread");
    }

    private boolean a() {
        if (Thread.State.NEW == getState()) {
            start();
        }
        return this.f22080a != null;
    }

    public static n b() {
        if (f22079b == null) {
            synchronized (n.class) {
                try {
                    if (f22079b == null) {
                        f22079b = new n();
                    }
                } finally {
                }
            }
        }
        f22079b.a();
        return f22079b;
    }

    public void c(View view, int i5) {
        if (view.isAttachedToWindow() && a()) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = new WeakReference(view);
            messageObtain.arg1 = i5;
            messageObtain.what = 0;
            this.f22080a.sendMessage(messageObtain);
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            Log.d("FHT_LOG", "start state" + getState());
            super.start();
            this.f22080a = new a(getLooper());
        } catch (Exception e6) {
            Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e6);
        }
    }
}
