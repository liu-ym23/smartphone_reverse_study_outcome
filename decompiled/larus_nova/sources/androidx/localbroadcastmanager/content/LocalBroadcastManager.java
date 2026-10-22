package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = null;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers;

    /* JADX INFO: loaded from: classes17.dex */
    public static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent r100, ArrayList<ReceiverRecord> r101) {
            this.intent = r100;
            this.receivers = r101;
        }
    }

    public static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public String toString() {
            StringBuilder r100 = new StringBuilder(128);
            r100.append("Receiver{");
            r100.append(this.receiver);
            r100.append(" filter=");
            r100.append(this.filter);
            if (this.dead == false) goto L5;
            r100.append(" DEAD");
        L5:
            r100.append(i.f25855d);
            return r100.toString();
        }

        public ReceiverRecord(IntentFilter r100, BroadcastReceiver r101) {
            this.filter = r100;
            this.receiver = r101;
        }
    }

    static {
        mLock = new Object();
    }

    public void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r100 = this.mReceivers;
        monitor-enter(r100);
        int r101 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L19
        if (r101 <= 0) goto L6;
        BroadcastRecord[] r102 = new BroadcastRecord[r101];     // Catch: Throwable -> L19
        this.mPendingBroadcasts.toArray(r102);     // Catch: Throwable -> L19
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        int r103 = 0;
    L11:
        if (r103 >= r101) goto L2;
        BroadcastRecord r104 = r102[r103];
        int r105 = r104.receivers.size();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L18;
        ReceiverRecord r107 = (ReceiverRecord) ListProtector.get(r104.receivers, r106);
        if (r107.dead == true) goto L17;
        r107.receiver.onReceive(this.mAppContext, r104.intent);
    L17:
        r106 = r106 + 1;
        goto L13
    L18:
        r103 = r103 + 1;
        goto L11
    L6:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private LocalBroadcastManager(Context r100) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r100;
        final Looper r101 = r100.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r101);
    }

    public static LocalBroadcastManager getInstance(Context r100) {
        Object r101 = mLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBroadcastManager(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBroadcastManager r102 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    }

    public boolean sendBroadcast(Intent r210) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r100 = this.mReceivers;
        monitor-enter(r100);
        String r110 = r210.getAction();     // Catch: Throwable -> L49
        String r111 = r210.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L49
        Uri r112 = r210.getData();     // Catch: Throwable -> L49
        String r113 = r210.getScheme();     // Catch: Throwable -> L49
        Set<String> r114 = r210.getCategories();     // Catch: Throwable -> L49
        if ((r210.getFlags() & 8) == 0) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == false) goto L10;
        r210.toString();     // Catch: Throwable -> L49
    L10:
        ArrayList<ReceiverRecord> r101 = this.mActions.get(r210.getAction());     // Catch: Throwable -> L49
        if (r101 == null) goto L46;
        if (r115 == false) goto L14;
        r101.toString();     // Catch: Throwable -> L49
    L14:
        ArrayList r102 = null;
        int r103 = 0;
    L16:
        if (r103 >= r101.size()) goto L35;
        ReceiverRecord r104 = r101.get(r103);     // Catch: Throwable -> L49
        if (r115 == false) goto L21;
        Objects.toString(r104.filter);     // Catch: Throwable -> L49
    L21:
        if (r104.broadcasting == false) goto L23;
        int r116 = r103;
        ArrayList<ReceiverRecord> r211 = r101;
        String r117 = r110;
        String r212 = r111;
        ArrayList r118 = r102;
    L33:
        r102 = r118;
    L34:
        r103 = r116 + 1;     // Catch: Throwable -> L49
        r110 = r117;
        r101 = r211;
        r111 = r212;
        goto L16
    L23:
        r116 = r103;
        r117 = r110;
        r118 = r102;
        r211 = r101;
        r212 = r111;
        int r105 = r104.filter.match(r110, r111, r113, r112, r114, TAG);     // Catch: Throwable -> L49
        if (r105 < 0) goto L31;
        if (r115 == false) goto L27;
        Integer.toHexString(r105);     // Catch: Throwable -> L49
    L27:
        if (r118 != null) goto L29;
        r102 = new ArrayList();     // Catch: Throwable -> L49
    L30:
        r102.add(r104);     // Catch: Throwable -> L49
        r104.broadcasting = true;     // Catch: Throwable -> L49
        goto L34
    L29:
        r102 = r118;
        goto L30
    L31:
        if (r115 == false) goto L33;
        goto L33
    L35:
        ArrayList r119 = r102;
        if (r119 == null) goto L46;
        int r106 = 0;
    L39:
        if (r106 >= r119.size()) goto L41;
        ((ReceiverRecord) r119.get(r106)).broadcasting = false;     // Catch: Throwable -> L49
        r106 = r106 + 1;     // Catch: Throwable -> L49
        goto L39
    L41:
        this.mPendingBroadcasts.add(new BroadcastRecord(r210, r119));     // Catch: Throwable -> L49
        if (this.mHandler.hasMessages(1) == true) goto L44;
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L49
    L44:
        monitor-exit(r100);     // Catch: Throwable -> L49
        return true;
    L46:
        monitor-exit(r100);     // Catch: Throwable -> L49
        return false;
    L7:
        r115 = false;
    L49:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(Intent r100) {
        if (sendBroadcast(r100) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(BroadcastReceiver r110) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r100 = this.mReceivers;
        monitor-enter(r100);
        ArrayList<ReceiverRecord> r101 = this.mReceivers.remove(r110);     // Catch: Throwable -> L28
        if (r101 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L28
        return;
    L8:
        int r102 = r101.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r102 < 0) goto L26;
        ReceiverRecord r103 = r101.get(r102);     // Catch: Throwable -> L28
        r103.dead = true;     // Catch: Throwable -> L28
        int r104 = 0;
    L12:
        if (r104 >= r103.filter.countActions()) goto L25;
        String r105 = r103.filter.getAction(r104);     // Catch: Throwable -> L28
        ArrayList<ReceiverRecord> r106 = this.mActions.get(r105);     // Catch: Throwable -> L28
        if (r106 == null) goto L24;
        int r107 = r106.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r107 < 0) goto L22;
        ReceiverRecord r108 = r106.get(r107);     // Catch: Throwable -> L28
        if (r108.receiver != r110) goto L20;
        r108.dead = true;     // Catch: Throwable -> L28
        r106.remove(r107);     // Catch: Throwable -> L28
    L20:
        r107 = r107 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r106.size() > 0) goto L24;
        this.mActions.remove(r105);     // Catch: Throwable -> L28
    L24:
        r104 = r104 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r102 = r102 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(BroadcastReceiver r100, IntentFilter r101) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r102 = this.mReceivers;
        monitor-enter(r102);
        ReceiverRecord r103 = new ReceiverRecord(r101, r100);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r104 = this.mReceivers.get(r100);     // Catch: Throwable -> L16
        if (r104 != null) goto L7;
        r104 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r100, r104);     // Catch: Throwable -> L16
    L7:
        r104.add(r103);     // Catch: Throwable -> L16
        int r105 = 0;
    L9:
        if (r105 >= r101.countActions()) goto L14;
        String r106 = r101.getAction(r105);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r107 = this.mActions.get(r106);     // Catch: Throwable -> L16
        if (r107 != null) goto L13;
        r107 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r106, r107);     // Catch: Throwable -> L16
    L13:
        r107.add(r103);     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
