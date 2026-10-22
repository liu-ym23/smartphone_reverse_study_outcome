package com.android.server.audio;

import android.content.Context;
import android.media.IAudioRecordChangedDispatcher;
import android.os.Handler;
import android.os.RemoteCallbackList;
import com.android.server.utils.EventLogger;
import com.zte.activityevent.IActivityEventsServer;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ZAudioRecordingNotifier implements ZAudioRecordListener {
    private static final int LOG_NB_EVENTS_ZTE_DTS_SCENE = 10;
    private static final String TAG = "ZAudioService.ZAudioRecordingNotifier";
    private IActivityEventsServer mActiviyEventServer;
    final RemoteCallbackList<IAudioRecordChangedDispatcher> mAudioRecordChangedDispatchers;
    private Handler mHandler;
    private final EventLogger sEventLogger;

    /* JADX INFO: renamed from: $r8$lambda$n9ypo2sjgLkzut-xNlTAbfXvLcc, reason: not valid java name */
    public static /* synthetic */ void m2225$r8$lambda$n9ypo2sjgLkzutxNlTAbfXvLcc(ZAudioRecordingNotifier r0, int r1, int r2) {
        r0.lambda$onAudioRecordChange$0(r1, r2);
    }

    public ZAudioRecordingNotifier(ZAudioService service, Context context, Handler handler) {
        this.mAudioRecordChangedDispatchers = new RemoteCallbackList();
        this.sEventLogger = new EventLogger(10, "ZAudio ActiviyEventServer record notify");
        this.mHandler = handler;
        service.getAudioClientDispatcher().registerAudioRecordListener(TAG, this);
    }

    public void registerAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) {
        this.mAudioRecordChangedDispatchers.register(dispatcher);
    }

    public void unregisterAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) {
        this.mAudioRecordChangedDispatchers.unregister(dispatcher);
    }

    @Override // com.android.server.audio.ZAudioRecordListener
    public void onAudioRecordChange(ZRecordClientInterface r5) {
        boolean r0 = r5.isActive();
        final int r1 = r5.getPid();
        Handler r2 = this.mHandler;
        final int r3 = r0 ? 1 : 0;
        r2.post(new ZAudioRecordingNotifier$$ExternalSyntheticLambda0(this, r3, r1));
    }

    private /* synthetic */ void lambda$onAudioRecordChange$0(int status, int pid) {
        notifyServer(status, pid);
    }

    private void notifyServer(int status, int pid) {
        this.sEventLogger.enqueueAndLog("notifyServer mActiviyEventServer = " + this.mActiviyEventServer + "pid = " + pid + " status = " + status, 0, TAG);
        int nDispatchers = this.mAudioRecordChangedDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nDispatchers) goto L8;
        this.mAudioRecordChangedDispatchers.getBroadcastItem(i).dispatchRecordingChanged(status, pid);     // Catch: Exception -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mAudioRecordChangedDispatchers.finishBroadcast();
    }

    public void dump(PrintWriter pw) {
        pw.println("\nActivity Event Notify History:");
        this.sEventLogger.dump(pw);
    }
}
