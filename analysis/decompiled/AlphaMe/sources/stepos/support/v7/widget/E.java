package stepos.support.v7.widget;

import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import g1.HandlerC0575c;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class E extends HandlerThread {

    /* renamed from: b, reason: collision with root package name */
    public static volatile E f14816b;

    /* renamed from: a, reason: collision with root package name */
    public HandlerC0575c f14817a;

    public final void a(View view) {
        if (view.isAttachedToWindow()) {
            if (Thread.State.NEW == getState()) {
                start();
            }
            if (this.f14817a != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = new WeakReference(view);
                messageObtain.arg1 = 0;
                messageObtain.what = 0;
                this.f14817a.sendMessage(messageObtain);
            }
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        try {
            Log.d("FHT_LOG", "start state" + getState());
            super.start();
            this.f14817a = new HandlerC0575c(getLooper(), 4);
        } catch (Exception e4) {
            Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e4);
        }
    }
}
