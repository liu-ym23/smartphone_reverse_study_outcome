package com.stepos.alphame.manager;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.stepos.alphame.AlphaMeServer;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.engine.AppClient;
import com.stepos.alphame.engine.ReceiverList;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.Args;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ActionManager {
    private static final int PROCESS_BROADCAST_MSG = 0;
    private static final String TAG = "AlphaMe";
    private final HashMap<String, ActionRecord> mActionsRegistered;
    private final Handler mHandler;

    public class BroadcastRecord {
        String action;
        int flag;
        Object value;

        public BroadcastRecord(String str, Object obj, int i4) {
            this.action = str;
            this.value = obj;
            this.flag = i4;
        }
    }

    public static class Instance {
        private static ActionManager INSTANCE = new ActionManager(0);

        private Instance() {
        }
    }

    public /* synthetic */ ActionManager(int i4) {
        this();
    }

    public static ActionManager getInstance() {
        return Instance.INSTANCE;
    }

    private String getValueStr(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof String[] ? Arrays.toString((String[]) obj) : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBroadcast(BroadcastRecord broadcastRecord) {
        ArrayList<ReceiverList> arrayListCollectReceivers = AlphaMeServer.getInstance().collectReceivers(broadcastRecord.action);
        if (Utils.DEBUG.get()) {
            Log.i(TAG, "collectReceivers size = " + arrayListCollectReceivers.size());
        }
        if (arrayListCollectReceivers.isEmpty()) {
            Log.w(TAG, "broadcast DROPPED action=" + broadcastRecord.action + " reason=no_receiver_registered (clients may need to re-register after an AlphaMe restart)");
            return;
        }
        Iterator<ReceiverList> it = arrayListCollectReceivers.iterator();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (it.hasNext()) {
            ReceiverList next = it.next();
            AppClient clientLock = AlphaMeServer.getInstance().getClientLock(next.client);
            if (clientLock == null) {
                i5++;
            } else if (clientLock.active) {
                int i8 = clientLock.flag;
                int i9 = broadcastRecord.flag;
                if ((i8 & i9) != i9) {
                    i7++;
                } else {
                    try {
                        clientLock.client.onReceiver(new Args(broadcastRecord.action, broadcastRecord.value, Integer.valueOf(next.receiver)));
                        i4++;
                    } catch (RemoteException e4) {
                        Log.e(TAG, "onReceiver error:" + e4);
                    }
                }
            } else {
                i6++;
            }
        }
        if (i4 == 0) {
            Log.w(TAG, "broadcast DROPPED action=" + broadcastRecord.action + " receivers=" + arrayListCollectReceivers.size() + " noClient=" + i5 + " inactive=" + i6 + " flagMismatch=" + i7);
        }
    }

    public void broadcast(String str) {
        broadcast(str, 0, null);
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("Action:");
        printWriter.println("");
        int i4 = 0;
        for (ActionRecord actionRecord : this.mActionsRegistered.values()) {
            if (!actionRecord.local) {
                printWriter.println("#" + i4);
                actionRecord.dump(printWriter);
                printWriter.println("");
                i4++;
            }
        }
    }

    public ActionRecord getAction(String str) {
        ActionRecord actionRecord;
        synchronized (this) {
            actionRecord = this.mActionsRegistered.get(str);
        }
        return actionRecord;
    }

    public boolean isValid(String str) {
        boolean z4;
        synchronized (this) {
            z4 = this.mActionsRegistered.get(str) != null;
        }
        return z4;
    }

    public void register(String str, byte b4, String[] strArr) {
        register(str, b4, strArr, false);
    }

    private ActionManager() {
        this.mActionsRegistered = new HashMap<>();
        this.mHandler = new Handler(ApplicationImpl.getAlphaMeLooper()) { // from class: com.stepos.alphame.manager.ActionManager.1
            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                if (message.what != 0) {
                    return;
                }
                ActionManager.this.processBroadcast((BroadcastRecord) message.obj);
            }
        };
    }

    public void broadcast(String str, Object obj) {
        broadcast(str, 0, obj);
    }

    public void register(String str, byte b4, String[] strArr, boolean z4) {
        if (TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        synchronized (this) {
            try {
                if (this.mActionsRegistered.get(str) != null) {
                    Log.e(TAG, "Action is registered");
                } else {
                    this.mActionsRegistered.put(str, new ActionRecord(str, b4, strArr, z4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void broadcast(String str, int i4, Object obj) {
        synchronized (this) {
            try {
                AlphaMeLogger.debugLog("broadcast action = " + str + " value = " + getValueStr(obj));
                if (TextUtils.isEmpty(str)) {
                    Log.e(TAG, "Action can't be empty");
                    return;
                }
                ActionRecord actionRecord = this.mActionsRegistered.get(str);
                if (actionRecord == null) {
                    Log.e(TAG, "Can't send unregistered action " + str);
                } else if (!Args.f(actionRecord.type, Args.h(obj))) {
                    Log.e(TAG, "broadcast send wrong type value " + obj);
                } else {
                    BroadcastRecord broadcastRecord = new BroadcastRecord(str, obj, i4);
                    Message messageObtainMessage = this.mHandler.obtainMessage();
                    messageObtainMessage.what = 0;
                    messageObtainMessage.obj = broadcastRecord;
                    messageObtainMessage.sendToTarget();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
