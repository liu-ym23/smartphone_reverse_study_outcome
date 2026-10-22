package androidx.localbroadcastmanager.content;

import android.content.IntentFilter;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: LocalBroadcastManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "LocalBroadcastManager";

    /* JADX INFO: renamed from: androidx.localbroadcastmanager.content.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocalBroadcastManager.java */
    private static final class C0066a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f2113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final PluginBroadcastReceiver f2114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2115c;

        C0066a(IntentFilter r1, PluginBroadcastReceiver r2) {
            this.f2113a = r1;
            this.f2114b = r2;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(128);
            r0.append("Receiver{");
            r0.append(this.f2114b);
            r0.append(" filter=");
            r0.append(this.f2113a);
            if (this.f2115c == false) goto L5;
            r0.append(" DEAD");
        L5:
            r0.append("}");
            return r0.toString();
        }
    }

    static {
        LocalBroadcastManager.mLock = new Object();
    }

    public void registerReceiver(PluginBroadcastReceiver r8, IntentFilter r9) {
        HashMap r0 = ((LocalBroadcastManager) this).mReceivers;
        monitor-enter(r0);
        C0066a r1 = new C0066a(r9, r8);     // Catch: Throwable -> L16
        ArrayList r2 = (ArrayList) ZeusTransformUtils.preCheckCast(((LocalBroadcastManager) this).mReceivers.get(r8), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r2 = new ArrayList(1);     // Catch: Throwable -> L16
        ((LocalBroadcastManager) this).mReceivers.put(r8, r2);     // Catch: Throwable -> L16
    L7:
        r2.add(r1);     // Catch: Throwable -> L16
        int r10 = 0;
    L9:
        if (r10 >= r9.countActions()) goto L14;
        String r3 = r9.getAction(r10);     // Catch: Throwable -> L16
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(((LocalBroadcastManager) this).mActions.get(r3), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r4 != null) goto L13;
        r4 = new ArrayList(1);     // Catch: Throwable -> L16
        ((LocalBroadcastManager) this).mActions.put(r3, r4);     // Catch: Throwable -> L16
    L13:
        r4.add(r1);     // Catch: Throwable -> L16
        r10 = r10 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void unregisterReceiver(PluginBroadcastReceiver r13) {
        HashMap r0 = ((LocalBroadcastManager) this).mReceivers;
        monitor-enter(r0);
        ArrayList r1 = (ArrayList) ZeusTransformUtils.preCheckCast(((LocalBroadcastManager) this).mReceivers.remove(r13), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L8:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r2 < 0) goto L26;
        C0066a r4 = (C0066a) ZeusTransformUtils.preCheckCast(r1.get(r2), C0066a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        r4.f2115c = true;     // Catch: Throwable -> L28
        int r5 = 0;
    L12:
        if (r5 >= r4.f2113a.countActions()) goto L25;
        String r6 = r4.f2113a.getAction(r5);     // Catch: Throwable -> L28
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(((LocalBroadcastManager) this).mActions.get(r6), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r7 == null) goto L24;
        int r8 = r7.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r8 < 0) goto L22;
        C0066a r9 = (C0066a) ZeusTransformUtils.preCheckCast(r7.get(r8), C0066a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r9.f2114b != r13) goto L20;
        r9.f2115c = true;     // Catch: Throwable -> L28
        r7.remove(r8);     // Catch: Throwable -> L28
    L20:
        r8 = r8 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r7.size() > 0) goto L24;
        ((LocalBroadcastManager) this).mActions.remove(r6);     // Catch: Throwable -> L28
    L24:
        r5 = r5 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }
}
