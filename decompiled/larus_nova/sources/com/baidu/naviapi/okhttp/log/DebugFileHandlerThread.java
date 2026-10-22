package com.baidu.naviapi.okhttp.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class DebugFileHandlerThread {
    public static final String DEFAULT_NAME = "DebugFileHandlerThread";
    public static final int MSG_CORE_FILE_ADD = 304;
    public static final int MSG_CORE_FILE_CHECK = 305;
    public static final int MSG_DEBUG_FILE_ADD = 300;
    public static final int MSG_DEL_ALL_LOG_FILES = 306;
    public static final int MSG_NAVI_DEBUG_FILE_ADD = 303;
    private List<Callback> mCallbacks;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    public static abstract class Callback {
        private Set<Integer> mCareMsgs;

        public abstract void careAbouts();

        public abstract void execute(Message r100);

        public String getName() {
            return "default";
        }

        public Callback() {
            this.mCareMsgs = new HashSet();
        }

        public final void careAbout(int r100) {
            this.mCareMsgs.add(Integer.valueOf(r100));
        }

        public final boolean isCareAbout(int r100) {
            return this.mCareMsgs.contains(Integer.valueOf(r100));
        }
    }

    public Looper getLooper() {
        HandlerThread r100 = this.mHandlerThread;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLooper();
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public DebugFileHandlerThread(String r100) {
        this.mHandlerThread = null;
        this.mHandler = null;
        this.mCallbacks = new ArrayList();
        init(r100);
    }

    public static /* synthetic */ List access$000(DebugFileHandlerThread r100) {
        return r100.mCallbacks;
    }

    private void init(String r100) {
        if (this.mHandlerThread == null) goto L5;
        return;
    L5:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2(r100);
        this.mHandlerThread = r101;
        ThreadMethodProxy.start(r101);
        final Looper r102 = this.mHandlerThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r102);
    }

    public void registerCallback(Callback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mCallbacks.contains(r100) == true) goto L8;
        r100.careAbouts();
        this.mCallbacks.add(r100);
        return;
    }

    public void removeMessage(int r100) {
        Handler r101 = this.mHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.hasMessages(r100) == false) goto L9;
        this.mHandler.removeMessages(r100);
        return;
    }

    public boolean sendMessage(int r100) {
        return sendMessage(r100, 0, 0, null, 0);
    }

    public void unregisterCallback(Callback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mCallbacks.contains(r100) == false) goto L8;
        this.mCallbacks.remove(r100);
        return;
    }

    public boolean sendMessage(int r100, int r101, int r102, Object r103, long r104) {
        Handler r105 = this.mHandler;
        if (r105 != null) goto L6;
        return false;
    L6:
        Message r106 = r105.obtainMessage(r100);
        r106.arg1 = r101;
        r106.arg2 = r102;
        if (r103 == null) goto L10;
        r106.obj = r103;
    L10:
        if (r104 > 0) goto L12;
        this.mHandler.sendMessage(r106);
        return true;
    L12:
        this.mHandler.sendMessageDelayed(r106, r104);
        return true;
    }
}
