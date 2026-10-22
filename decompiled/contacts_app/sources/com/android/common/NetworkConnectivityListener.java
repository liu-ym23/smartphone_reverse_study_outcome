package com.android.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.GlobalProxyLancet;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NetworkConnectivityListener {
    private static final boolean DBG = false;
    private static final String TAG = "NetworkConnectivityListener";
    private Context mContext;
    private HashMap<Handler, Integer> mHandlers;
    private boolean mIsFailover;
    private boolean mListening;
    private NetworkInfo mNetworkInfo;
    private NetworkInfo mOtherNetworkInfo;
    private String mReason;
    private ConnectivityBroadcastReceiver mReceiver;
    private State mState;

    /* JADX INFO: renamed from: com.android.common.NetworkConnectivityListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkConnectivityListener this$0;

        private ConnectivityBroadcastReceiver(NetworkConnectivityListener r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ConnectivityBroadcastReceiver(NetworkConnectivityListener r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r3, Intent r4) {
            if (r4.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") == true) goto L5;
        L16:
            Log.w(NetworkConnectivityListener.TAG, "onReceived() called with " + NetworkConnectivityListener.access$100(this.this$0).toString() + " and " + r4);
            return;
        L5:
            if (NetworkConnectivityListener.access$000(this.this$0) == false) goto L16;
            if (r4.getBooleanExtra("noConnectivity", false) == false) goto L10;
            NetworkConnectivityListener.access$102(this.this$0, State.NOT_CONNECTED);
        L11:
            NetworkConnectivityListener.access$202(this.this$0, (NetworkInfo) r4.getParcelableExtra("networkInfo"));
            NetworkConnectivityListener.access$302(this.this$0, (NetworkInfo) r4.getParcelableExtra("otherNetwork"));
            NetworkConnectivityListener.access$402(this.this$0, r4.getStringExtra("reason"));
            NetworkConnectivityListener.access$502(this.this$0, r4.getBooleanExtra("isFailover", false));
            Iterator r5 = NetworkConnectivityListener.access$600(this.this$0).keySet().iterator();
        L13:
            if (r5.hasNext() == false) goto L15;
            Handler r6 = (Handler) r5.next();
            r6.sendMessage(Message.obtain(r6, ((Integer) NetworkConnectivityListener.access$600(this.this$0).get(r6)).intValue()));
            goto L13
        L15:
            return;
        L10:
            NetworkConnectivityListener.access$102(this.this$0, State.CONNECTED);
            goto L11
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CONNECTED = null;
        public static final State NOT_CONNECTED = null;
        public static final State UNKNOWN = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("UNKNOWN", 0);
            UNKNOWN = r0;
            State r1 = new State("CONNECTED", 1);
            CONNECTED = r1;
            State r3 = new State("NOT_CONNECTED", 2);
            NOT_CONNECTED = r3;
            $VALUES = new State[]{r0, r1, r3};
        }
    }

    static /* synthetic */ boolean access$000(NetworkConnectivityListener r0) {
        return r0.mListening;
    }

    static /* synthetic */ State access$100(NetworkConnectivityListener r0) {
        return r0.mState;
    }

    static /* synthetic */ State access$102(NetworkConnectivityListener r0, State r1) {
        r0.mState = r1;
        return r1;
    }

    static /* synthetic */ NetworkInfo access$202(NetworkConnectivityListener r0, NetworkInfo r1) {
        r0.mNetworkInfo = r1;
        return r1;
    }

    static /* synthetic */ NetworkInfo access$302(NetworkConnectivityListener r0, NetworkInfo r1) {
        r0.mOtherNetworkInfo = r1;
        return r1;
    }

    static /* synthetic */ String access$402(NetworkConnectivityListener r0, String r1) {
        r0.mReason = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(NetworkConnectivityListener r0, boolean r1) {
        r0.mIsFailover = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$600(NetworkConnectivityListener r0) {
        return r0.mHandlers;
    }

    public NetworkConnectivityListener() {
        this.mHandlers = new HashMap();
        this.mState = State.UNKNOWN;
        this.mReceiver = new ConnectivityBroadcastReceiver(this, null);
    }

    public synchronized void startListening(Context r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mListening == true) goto L6;
        this.mContext = r3;     // Catch: Throwable -> L8
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L8
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L8
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mReceiver, r0);     // Catch: Throwable -> L8
        this.mListening = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void stopListening() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mListening == false) goto L6;
        this.mContext.unregisterReceiver(this.mReceiver);     // Catch: Throwable -> L8
        this.mContext = null;     // Catch: Throwable -> L8
        this.mNetworkInfo = null;     // Catch: Throwable -> L8
        this.mOtherNetworkInfo = null;     // Catch: Throwable -> L8
        this.mIsFailover = false;     // Catch: Throwable -> L8
        this.mReason = null;     // Catch: Throwable -> L8
        this.mListening = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public void registerHandler(Handler r1, int r2) {
        this.mHandlers.put(r1, Integer.valueOf(r2));
    }

    public void unregisterHandler(Handler r1) {
        this.mHandlers.remove(r1);
    }

    public State getState() {
        return this.mState;
    }

    public NetworkInfo getNetworkInfo() {
        return this.mNetworkInfo;
    }

    public NetworkInfo getOtherNetworkInfo() {
        return this.mOtherNetworkInfo;
    }

    public boolean isFailover() {
        return this.mIsFailover;
    }

    public String getReason() {
        return this.mReason;
    }
}
