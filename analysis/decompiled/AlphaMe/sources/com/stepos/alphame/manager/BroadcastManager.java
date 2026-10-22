package com.stepos.alphame.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.stepos.alphame.utils.ReceiverUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BroadcastManager {
    private static final boolean DEBUG = false;
    public static final String INTENT_ACTION_DEEP_SLEEP = "com.stepos.alphame.engine.deep.sleep";
    public static final String INTENT_ACTION_SLEEP = "com.stepos.alphame.engine.sleep";
    public static final String INTENT_ACTION_WAKEUP = "com.stepos.alphame.engine.wakeup";
    public static final int MSG_HANDLE_DEEP_SLEEP_MODE = 2;
    public static final int MSG_HANDLE_SLEEP_MODE = 1;
    public static final int MSG_HANDLE_WAKEUP_MODE = 0;
    private static final String TAG = "BroadcastManager";
    public static final int TIME_SEND_MESSAGE_DELAY = 0;

    @SuppressLint({"StaticFieldLeak"})
    private static BroadcastManager sInstance;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private List<OnSleepStateChangeListener> mListeners = new ArrayList();
    private MiscReceiver mMiscReceiver;

    public class BroadcastHandler extends Handler {
        public BroadcastHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 0) {
                BroadcastManager.this.onStateChanged(1, (Intent) message.obj);
                return;
            }
            if (i4 == 1) {
                BroadcastManager.this.onStateChanged(2, (Intent) message.obj);
            } else if (i4 == 2) {
                BroadcastManager.this.onStateChanged(3, (Intent) message.obj);
            } else {
                Log.e(BroadcastManager.TAG, "no such event: " + message.what);
            }
        }
    }

    public class MiscReceiver extends BroadcastReceiver {
        public /* synthetic */ MiscReceiver(BroadcastManager broadcastManager, int i4) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || action.length() <= 0) {
                Log.e(BroadcastManager.TAG, "receive a null intent");
                return;
            }
            if (BroadcastManager.INTENT_ACTION_WAKEUP.equals(action)) {
                BroadcastManager.this.sendMessage(0, -1, -1, intent, 0);
                return;
            }
            if (BroadcastManager.INTENT_ACTION_SLEEP.equals(action)) {
                BroadcastManager.this.sendMessage(1, -1, -1, intent, 0);
            } else if (BroadcastManager.INTENT_ACTION_DEEP_SLEEP.equals(action)) {
                BroadcastManager.this.sendMessage(2, -1, -1, intent, 0);
            } else {
                Log.e(BroadcastManager.TAG, "no such broadcast: ".concat(action));
            }
        }

        private MiscReceiver() {
        }
    }

    public interface OnSleepStateChangeListener {
        public static final int EVENT_TYPE_DEEP_SLEEP_MODE = 3;
        public static final int EVENT_TYPE_SLEEP_MODE = 2;
        public static final int EVENT_TYPE_WAKEUP_MODE = 1;

        void onStateChange(int i4, Intent intent);
    }

    public BroadcastManager(Context context) {
        this.mContext = context;
        initVariable();
        initReceiver();
    }

    public static synchronized BroadcastManager getInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new BroadcastManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private void initReceiver() {
        registerMiscReceiver();
    }

    private void initVariable() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.setPriority(10);
        this.mHandlerThread.start();
        this.mHandler = new BroadcastHandler(this.mHandlerThread.getLooper());
        this.mMiscReceiver = new MiscReceiver(this, 0);
    }

    private void registerMiscReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(INTENT_ACTION_WAKEUP);
        intentFilter.addAction(INTENT_ACTION_SLEEP);
        intentFilter.addAction(INTENT_ACTION_DEEP_SLEEP);
        ReceiverUtils.registerReceiverExported(this.mContext, this.mMiscReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int i4, int i5, int i6, Object obj, int i7) {
        if (this.mHandler.hasMessages(i4)) {
            this.mHandler.removeMessages(i4);
        }
        Message messageObtainMessage = this.mHandler.obtainMessage(i4);
        if (i5 >= 0) {
            messageObtainMessage.arg1 = i5;
        }
        if (i6 >= 0) {
            messageObtainMessage.arg2 = i6;
        }
        if (obj != null) {
            messageObtainMessage.obj = obj;
        }
        this.mHandler.sendMessageDelayed(messageObtainMessage, i7);
    }

    private void unregisterReceiver() {
        this.mContext.unregisterReceiver(this.mMiscReceiver);
    }

    public void addSleepStateChangeListener(OnSleepStateChangeListener onSleepStateChangeListener) {
        synchronized (this.mListeners) {
            try {
                if (this.mListeners.contains(onSleepStateChangeListener)) {
                    Log.e(TAG, "listener: " + onSleepStateChangeListener + " is already added");
                } else {
                    this.mListeners.add(onSleepStateChangeListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearListeners() {
        synchronized (this.mListeners) {
            this.mListeners.clear();
        }
    }

    public void exit() {
        unregisterReceiver();
        clearListeners();
    }

    public void onStateChanged(int i4, Intent intent) {
        synchronized (this.mListeners) {
            try {
                Iterator<OnSleepStateChangeListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onStateChange(i4, intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeSleepStateChangeListener(OnSleepStateChangeListener onSleepStateChangeListener) {
        synchronized (this.mListeners) {
            try {
                if (this.mListeners.contains(onSleepStateChangeListener)) {
                    this.mListeners.remove(onSleepStateChangeListener);
                } else {
                    Log.e(TAG, "listener: " + onSleepStateChangeListener + " is already removed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
