package k2;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* renamed from: k2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4809a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final RunnableC4809a f34589a = new RunnableC4809a();

    public static Runnable a() {
        return f34589a;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}
