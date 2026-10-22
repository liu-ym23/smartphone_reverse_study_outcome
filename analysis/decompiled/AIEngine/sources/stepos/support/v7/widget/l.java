package stepos.support.v7.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends HandlerThread {

    /* renamed from: b, reason: collision with root package name */
    public static volatile l f12813b;

    /* renamed from: a, reason: collision with root package name */
    public a f12814a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
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

    public final void a(StepOSRecyclerView stepOSRecyclerView) {
        if (stepOSRecyclerView.isAttachedToWindow()) {
            if (Thread.State.NEW == getState()) {
                start();
            }
            if (this.f12814a != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = new WeakReference(stepOSRecyclerView);
                messageObtain.arg1 = 0;
                messageObtain.what = 0;
                this.f12814a.sendMessage(messageObtain);
            }
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        try {
            Log.d("FHT_LOG", "start state" + getState());
            super.start();
            this.f12814a = new a(getLooper());
        } catch (Exception e10) {
            Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e10);
        }
    }
}
