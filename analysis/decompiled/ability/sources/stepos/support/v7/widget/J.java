package stepos.support.v7.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.apm.insight.MonitorCrash;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class J extends HandlerThread {
    public static volatile J c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6470a = 1;
    public Object b;

    public /* synthetic */ J(String str) {
        super(str);
    }

    public void a(StepOSRecyclerView stepOSRecyclerView) {
        if (stepOSRecyclerView.isAttachedToWindow()) {
            if (Thread.State.NEW == getState()) {
                start();
            }
            if (((com.stepos.statsrpk.c) this.b) != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = new WeakReference(stepOSRecyclerView);
                messageObtain.arg1 = 0;
                messageObtain.what = 0;
                ((com.stepos.statsrpk.c) this.b).sendMessage(messageObtain);
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 17, insns: 0 */
    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        switch (this.f6470a) {
            case 1:
                super.onLooperPrepared();
                synchronized (((L0.h) this.b).e) {
                    ((L0.h) this.b).d = new Handler();
                }
                ((L0.h) this.b).d.post(new A6.l((L0.h) this.b, 11));
                while (true) {
                    try {
                        Looper.loop();
                    } catch (Throwable th) {
                        try {
                            MonitorCrash monitorCrash = H.h.y;
                            if (monitorCrash != null) {
                                monitorCrash.reportCustomErr("", "apm_error", th);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            default:
                super.onLooperPrepared();
                return;
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        switch (this.f6470a) {
            case 0:
                synchronized (this) {
                    try {
                        Log.d("FHT_LOG", "start state" + getState());
                        super.start();
                        this.b = new com.stepos.statsrpk.c(getLooper(), 1);
                    } catch (Exception e) {
                        Log.e("FHT_LOG", "FeedbackHandlerThread start ex : " + e);
                    }
                }
                return;
            default:
                super.start();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(L0.h hVar) {
        super("AsyncEventManager-Thread");
        this.b = hVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(L0.h hVar, int i) {
        super("caton_dump_stack", 10);
        this.b = hVar;
    }
}
