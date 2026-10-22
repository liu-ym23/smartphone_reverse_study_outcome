package com.android.server.wm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SmtSysLog;
import bytedanceos.util.FeatLog;
import com.android.server.IBoostFrameworkOptEx;
import com.android.server.IMultiPlatSvsFactory;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes3.dex */
public class WindowAnimatorSmtEx {
    private static final int ANIMATION_BOOST_ENABLE = 1;
    private static final int ANIMATION_BOOST_RELEASE = 2;
    private static final int ANIMATION_BOOST_TIMEINTERVAL = 800;
    private static final int ANIMATION_BOOST_TIMEOUT = 2000;
    private static final String TAG = "WindowAnimatorSmtEx";
    private static int mHandle;
    private int animationType;
    private BHandler bHandler;
    private boolean isBoost;
    private WindowAnimator mAnimator;
    private IBoostFrameworkOptEx mBoostFramework;
    private Object mBoostLock;
    private BoostThread mBoostThread;

    private class BHandler extends Handler {
        final /* synthetic */ WindowAnimatorSmtEx this$0;

        public BHandler(WindowAnimatorSmtEx r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L17;
                case 2: goto L5;
                default: goto L37;
            };
        L5:
            Object r0 = WindowAnimatorSmtEx.m10384$$Nest$fgetmBoostLock(this.this$0);
            monitor-enter(r0);
            removeMessages(2);     // Catch: Throwable -> L10
            if (WindowAnimatorSmtEx.m10383$$Nest$fgetmBoostFramework(this.this$0) == null) goto L12;
            FeatLog.d(WindowAnimatorSmtEx.TAG, "FEAT_BOOST_ANIMATION", 20, "ANIMATION_BOOST_RELEASE works");     // Catch: Throwable -> L10
            WindowAnimatorSmtEx.m10383$$Nest$fgetmBoostFramework(this.this$0).disableBoost();     // Catch: Throwable -> L10
        L12:
            WindowAnimatorSmtEx.m10386$$Nest$fputisBoost(this.this$0, false);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L17:
            Object r1 = WindowAnimatorSmtEx.m10384$$Nest$fgetmBoostLock(this.this$0);
            monitor-enter(r1);
        L26:
            th = move-exception;
            throw th;
        L20:
            if (WindowAnimatorSmtEx.m10383$$Nest$fgetmBoostFramework(this.this$0) != null) goto L22;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L26
            return;
        L22:
            if (WindowAnimatorSmtEx.m10382$$Nest$fgetisBoost(this.this$0) == true) goto L28;
            if (WindowAnimatorSmtEx.m10387$$Nest$sfgetmHandle() == (-1)) goto L28;
            FeatLog.d(WindowAnimatorSmtEx.TAG, "FEAT_BOOST_ANIMATION", 10, "ANIMATION_BOOST_ENABLE works");     // Catch: Throwable -> L26
            WindowAnimatorSmtEx.m10386$$Nest$fputisBoost(this.this$0, true);     // Catch: Throwable -> L26
            WindowAnimatorSmtEx.m10383$$Nest$fgetmBoostFramework(this.this$0).enableBoost(2000, WindowAnimatorSmtEx.m10380$$Nest$fgetanimationType(this.this$0));     // Catch: Throwable -> L26
            sendEmptyMessageDelayed(2, 800);     // Catch: Throwable -> L26
            goto L28
        }
    }

    private class BoostThread extends Thread {
        final /* synthetic */ WindowAnimatorSmtEx this$0;

        /* synthetic */ BoostThread(WindowAnimatorSmtEx r1, WindowAnimatorSmtExIA r2) {
            this(r1);
        }

        private BoostThread(WindowAnimatorSmtEx r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Looper.prepare();     // Catch: Exception -> L5
            WindowAnimatorSmtEx.m10385$$Nest$fputbHandler(this.this$0, new BHandler(this.this$0, Looper.myLooper()));     // Catch: Exception -> L5
            Looper.loop();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            SmtSysLog.fatal(WindowAnimatorSmtEx.TAG, "BoostThread created error!", e);
        }

        public void Interrupt() {
            WindowAnimatorSmtEx.m10381$$Nest$fgetbHandler(this.this$0).getLooper().quit();
            super.interrupt();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetanimationType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10380$$Nest$fgetanimationType(WindowAnimatorSmtEx r0) {
        return r0.animationType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetbHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ BHandler m10381$$Nest$fgetbHandler(WindowAnimatorSmtEx r0) {
        return r0.bHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetisBoost, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10382$$Nest$fgetisBoost(WindowAnimatorSmtEx r0) {
        return r0.isBoost;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBoostFramework, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBoostFrameworkOptEx m10383$$Nest$fgetmBoostFramework(WindowAnimatorSmtEx r0) {
        return r0.mBoostFramework;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBoostLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10384$$Nest$fgetmBoostLock(WindowAnimatorSmtEx r0) {
        return r0.mBoostLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputbHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10385$$Nest$fputbHandler(WindowAnimatorSmtEx r0, BHandler r1) {
        r0.bHandler = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputisBoost, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10386$$Nest$fputisBoost(WindowAnimatorSmtEx r0, boolean r1) {
        r0.isBoost = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmHandle, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10387$$Nest$sfgetmHandle() {
        return mHandle;
    }

    static {
        mHandle = -1;
    }

    WindowAnimatorSmtEx(WindowAnimator windowAnimator) {
        this.mBoostFramework = null;
        this.isBoost = false;
        this.mBoostLock = new Object();
        this.bHandler = null;
        this.animationType = -1;
        this.mAnimator = windowAnimator;
        initBoost();
    }

    WindowAnimatorSmtEx(WindowAnimator windowAnimator, int type) {
        this.mBoostFramework = null;
        this.isBoost = false;
        this.mBoostLock = new Object();
        this.bHandler = null;
        this.animationType = -1;
        this.mAnimator = windowAnimator;
        this.animationType = type;
        initBoost();
    }

    public void scheduleAnimationBoost() {
        initBoost();
        Object r0 = this.mBoostLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.bHandler != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.isBoost == true) goto L11;
        FeatLog.d(TAG, "FEAT_BOOST_ANIMATION", 0, "scheduleAnimationBoost");     // Catch: Throwable -> L9
        this.bHandler.sendEmptyMessage(1);     // Catch: Throwable -> L9
        goto L11
    }

    private void initBoost() {
        if (this.mBoostThread != null) goto L6;
        this.mBoostThread = new BoostThread(this, null);
        this.mBoostThread.start();
    L6:
        if (this.mBoostFramework != null) goto L11;
        IMultiPlatSvsFactory factory = SysOptBridge.getMultiPlatFactory();
        if (factory == null) goto L11;
        this.mBoostFramework = factory.getBoostFrameworkByPerf();
    L11:
        if (this.mBoostFramework == null) goto L16;
        this.mBoostFramework.initBoost();
        if (mHandle != (-1)) goto L17;
        mHandle = this.mBoostFramework.configBoostParams(this.animationType);
        return;
    L17:
        return;
    }
}
