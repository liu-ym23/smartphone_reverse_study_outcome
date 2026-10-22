package obric.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes5.dex */
public class SmoothSeekBar extends AppCompatSeekBar {
    private static final int MSG_SET_SMOOTH_PROGRESS = 1;
    private static final String TAG = "SmoothSeekBar";
    private static final int TIME_INTERVAL_MS = 15;
    private static SmoothHandler mHandler;
    private static final SmoothSeekBarThread mSmoothThread = null;
    private int mOriginalProgress;
    private SmoothData mSmoothData;
    private int mTargetProgress;

    /* JADX INFO: renamed from: obric.widget.SmoothSeekBar$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class SmoothData {
        private int mOriginalProgress;
        private SmoothSeekBar mSeekBar;
        private float mStep;
        private int mStepCount;
        private int mStepMaxCount;
        private int mTargetProgress;
        final /* synthetic */ SmoothSeekBar this$0;

        private SmoothData(final SmoothSeekBar this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ SmoothData(SmoothSeekBar r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ SmoothSeekBar access$100(SmoothData r0) {
            return r0.mSeekBar;
        }

        static /* synthetic */ SmoothSeekBar access$102(SmoothData r0, SmoothSeekBar r1) {
            r0.mSeekBar = r1;
            return r1;
        }

        static /* synthetic */ int access$200(SmoothData r0) {
            return r0.mTargetProgress;
        }

        static /* synthetic */ int access$202(SmoothData r0, int r1) {
            r0.mTargetProgress = r1;
            return r1;
        }

        static /* synthetic */ int access$300(SmoothData r0) {
            return r0.mOriginalProgress;
        }

        static /* synthetic */ int access$302(SmoothData r0, int r1) {
            r0.mOriginalProgress = r1;
            return r1;
        }

        static /* synthetic */ int access$400(SmoothData r0) {
            return r0.mStepMaxCount;
        }

        static /* synthetic */ int access$402(SmoothData r0, int r1) {
            r0.mStepMaxCount = r1;
            return r1;
        }

        static /* synthetic */ float access$500(SmoothData r0) {
            return r0.mStep;
        }

        static /* synthetic */ float access$502(SmoothData r0, float r1) {
            r0.mStep = r1;
            return r1;
        }

        static /* synthetic */ int access$600(SmoothData r0) {
            return r0.mStepCount;
        }

        static /* synthetic */ int access$602(SmoothData r0, int r1) {
            r0.mStepCount = r1;
            return r1;
        }

        static /* synthetic */ int access$608(SmoothData r2) {
            int r0 = r2.mStepCount;
            r2.mStepCount = r0 + 1;
            return r0;
        }
    }

    private static class SmoothHandler extends Handler {
        private SmoothHandler() {
        }

        /* synthetic */ SmoothHandler(AnonymousClass1 r1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) goto L7;
            setSmoothProgress(msg);
            return;
        }

        private void setSmoothProgress(Message msg) {
            if ((msg.obj instanceof SmoothData) == false) goto L28;
            SmoothData r4 = (SmoothData) msg.obj;
            SmoothData.access$608(r4);
            SmoothSeekBar r5 = SmoothData.access$100(r4);
            monitor-enter(r5);
        L25:
            th = move-exception;
            throw th;
        L7:
            if (SmoothData.access$200(r4) == SmoothSeekBar.access$900(SmoothData.access$100(r4))) goto L9;
        L22:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(SmoothSeekBar.TAG, "smoothing event was changed!");     // Catch: Throwable -> L25
            monitor-exit(r5);     // Catch: Throwable -> L25
            return;
        L9:
            if (SmoothData.access$300(r4) != SmoothSeekBar.access$1000(SmoothData.access$100(r4))) goto L22;
            if (SmoothData.access$600(r4) < SmoothData.access$400(r4)) goto L14;
            SmoothSeekBar.access$1300(SmoothData.access$100(r4), SmoothData.access$200(r4));     // Catch: Throwable -> L25
            SmoothSeekBar.access$1200(SmoothData.access$100(r4));     // Catch: Throwable -> L25
        L20:
            monitor-exit(r5);     // Catch: Throwable -> L25
            return;
        L14:
            if (SmoothSeekBar.access$1100(SmoothData.access$100(r4)) == (SmoothData.access$300(r4) + ((int) (SmoothData.access$500(r4) * (SmoothData.access$600(r4) - 1))))) goto L18;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(SmoothSeekBar.TAG, "progress changed by user, abort smoothing");     // Catch: Throwable -> L25
            SmoothSeekBar.access$1200(SmoothData.access$100(r4));     // Catch: Throwable -> L25
            monitor-exit(r5);     // Catch: Throwable -> L25
            return;
        L18:
            SmoothSeekBar.access$1300(SmoothData.access$100(r4), SmoothData.access$300(r4) + ((int) (SmoothData.access$500(r4) * SmoothData.access$600(r4))));     // Catch: Throwable -> L25
            SmoothSeekBar.access$1400(SmoothData.access$100(r4), 15);     // Catch: Throwable -> L25
            goto L20
        }
    }

    private static class SmoothSeekBarThread extends Thread {
        SmoothSeekBarThread() {
            super("SmoothSeekBarThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            SmoothSeekBar.access$702(new SmoothHandler(null));
            Looper.loop();
        }
    }

    static /* synthetic */ int access$1000(SmoothSeekBar r0) {
        return r0.getOriginalProgress();
    }

    static /* synthetic */ int access$1100(SmoothSeekBar r0) {
        return r0.getProgressOnly();
    }

    static /* synthetic */ void access$1200(SmoothSeekBar r0) {
        r0.stopSmoothProgress();
    }

    static /* synthetic */ void access$1300(SmoothSeekBar r0, int r1) {
        r0.setProgressOnly(r1);
    }

    static /* synthetic */ void access$1400(SmoothSeekBar r0, long r1) {
        r0.sendSmoothEvent(r1);
    }

    static /* synthetic */ SmoothHandler access$702(SmoothHandler r0) {
        mHandler = r0;
        return r0;
    }

    static /* synthetic */ int access$900(SmoothSeekBar r0) {
        return r0.getTargetProgress();
    }

    static {
        SmoothSeekBarThread r0 = new SmoothSeekBarThread();
        mSmoothThread = r0;
        r0.start();
    }

    public SmoothSeekBar(Context context) {
        this(context, null);
    }

    public SmoothSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.seekBarStyle);
    }

    public SmoothSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTargetProgress = -1;
        this.mOriginalProgress = -1;
    }

    public synchronized void setProgressSmooth(int progress) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (progress != this.mTargetProgress) goto L7;
        monitor-exit(this);
        return;
    L7:
        stopSmoothProgress();     // Catch: Throwable -> L17
        int r0 = progress - getProgress();     // Catch: Throwable -> L17
        int r1 = getMax() / 20;     // Catch: Throwable -> L17
        if (r0 >= r1) goto L12;
        if (r0 <= (-r1)) goto L12;
    L13:
        super.setProgress(progress);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L12:
        if (mHandler == null) goto L13;
        startSmoothProgress(progress, getProgress());     // Catch: Throwable -> L17
        goto L15
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int progress) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (progress == this.mTargetProgress) goto L6;
        stopSmoothProgress();     // Catch: Throwable -> L8
        super.setProgress(progress);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private void setProgressOnly(int progress) {
        super.setProgress(progress);
    }

    @Override // android.widget.ProgressBar
    public synchronized int getProgress() {
        monitor-enter(this);
        int r0 = this.mTargetProgress;     // Catch: Throwable -> L11
        if (r0 == (-1)) goto L8;
        monitor-exit(this);
        return r0;
    L8:
        int r1 = super.getProgress();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private int getProgressOnly() {
        return super.getProgress();
    }

    private void startSmoothProgress(int target, int original) {
        this.mTargetProgress = target;
        int r3 = super.getProgress();
        this.mOriginalProgress = r3;
        int r4 = this.mTargetProgress - r3;
        int r5 = ((Math.abs(r4) * 200) / getMax()) + 100;
        SmoothData r0 = new SmoothData(this, null);
        this.mSmoothData = r0;
        SmoothData.access$102(r0, this);
        SmoothData.access$202(this.mSmoothData, this.mTargetProgress);
        SmoothData.access$302(this.mSmoothData, this.mOriginalProgress);
        SmoothData.access$402(this.mSmoothData, r5 / 15);
        SmoothData r6 = this.mSmoothData;
        SmoothData.access$502(r6, r4 / SmoothData.access$400(r6));
        SmoothData.access$602(this.mSmoothData, 0);
        sendSmoothEvent(0);
    }

    private void stopSmoothProgress() {
        SmoothData r0 = this.mSmoothData;
        if (r0 == null) goto L6;
        this.mTargetProgress = -1;
        this.mOriginalProgress = -1;
        mHandler.removeMessages(1, r0);
        this.mSmoothData = null;
        return;
    }

    private void sendSmoothEvent(long delayMs) {
        SmoothHandler r0 = mHandler;
        r0.sendMessageDelayed(r0.obtainMessage(1, 0, 0, this.mSmoothData), delayMs);
    }

    private int getTargetProgress() {
        return this.mTargetProgress;
    }

    private int getOriginalProgress() {
        return this.mOriginalProgress;
    }
}
