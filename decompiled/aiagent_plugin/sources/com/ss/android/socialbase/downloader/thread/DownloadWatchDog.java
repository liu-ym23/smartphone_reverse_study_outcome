package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class DownloadWatchDog implements Handler.Callback {
    private static final int MSG_SCHEDULE_WATCH = 0;
    private volatile Handler handler;

    private static class Holder {
        private static final Looper LOOPER = null;

        private Holder() {
        }

        static /* synthetic */ Looper access$000() {
            return LOOPER;
        }

        static {
            HandlerThread r0 = new HandlerThread("DownloadWatchDog");
            r0.start();
            LOOPER = r0.getLooper();
        }
    }

    public interface IWatcher {
        long onScheduleWatch();
    }

    public static Looper getThreadLooper() {
        return Holder.access$000();
    }

    public DownloadWatchDog() {
        this.handler = new Handler(Holder.access$000(), this);
    }

    public void addWatcher(IWatcher r3, long r4) {
        IWatcher r5 = (IWatcher) ZeusTransformUtils.wrapperContextForParams(r3, IWatcher.class, "com.obric.aiagent.plugin");
        Handler r2 = this.handler;
        if (r2 != null) goto L5;
        return;
    L5:
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = r5;
        r2.sendMessageDelayed(r0, r4);
    }

    public void removeWatcher(IWatcher r3) {
        IWatcher r4 = (IWatcher) ZeusTransformUtils.wrapperContextForParams(r3, IWatcher.class, "com.obric.aiagent.plugin");
        Handler r2 = this.handler;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.removeMessages(0, r4);
    }

    public void release() {
        Handler r0 = this.handler;
        if (r0 != null) goto L5;
        return;
    L5:
        this.handler = null;
        r0.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        if (r5.what != 0) goto L16;
        IWatcher r6 = (IWatcher) ZeusTransformUtils.preCheckCast(r5.obj, IWatcher.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        long r0 = r6.onScheduleWatch();     // Catch: Throwable -> L9
        if (r0 <= 0) goto L15;
        addWatcher(r6, r0);     // Catch: Throwable -> L9
        return true;
    L15:
        return true;
    L9:
        th = move-exception;
        th.printStackTrace();
        return true;
    L16:
        return true;
    }
}
