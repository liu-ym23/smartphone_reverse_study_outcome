package s5;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f24506a;

    /* JADX INFO: renamed from: s5.a$a, reason: collision with other inner class name */
    public static class RunnableC0376a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Message f24507a;

        public RunnableC0376a(Message r10) {
            this.f24507a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24507a.sendToTarget();
        }
    }

    public static void a() {
        Handler r10 = f24506a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.hasMessages(1) == true) goto L7;
        Log.d("LinkedListForWorks", "Handler in QueuedWork has no MSG_RUN message,so we send one.");
        Message r11 = Message.obtain(f24506a);
        r11.what = 1;
        new Handler().post(new RunnableC0376a(r11));
        return;
    L7:
        Log.d("LinkedListForWorks", "Handler in QueuedWork has MSG_RUN message,no need to send one.");
    }

    public static void b() {
    }
}
