package stepos.support.v7.widget;

import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d0 extends HandlerThread {

    /* renamed from: f, reason: collision with root package name */
    public static volatile d0 f12739f;

    /* renamed from: c, reason: collision with root package name */
    public com.stepos.statsrpk.g f12740c;

    public final void a(StepOSRecyclerView stepOSRecyclerView) {
        if (stepOSRecyclerView.isAttachedToWindow()) {
            if (Thread.State.NEW == getState()) {
                start();
            }
            if (this.f12740c != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = new WeakReference(stepOSRecyclerView);
                messageObtain.arg1 = 0;
                messageObtain.what = 0;
                this.f12740c.sendMessage(messageObtain);
            }
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        try {
            Log.d("FHT_LOG", "start state" + getState());
            super.start();
            this.f12740c = new com.stepos.statsrpk.g(getLooper(), 1);
        } catch (Exception e10) {
            Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e10);
        }
    }
}
