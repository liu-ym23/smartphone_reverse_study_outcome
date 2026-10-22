package com.android.server.am;

import android.content.IIntentReceiver;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class ReceiverList extends ArrayList<BroadcastFilter> implements IBinder.DeathRecipient {
    public final ProcessRecord app;
    BroadcastRecord curBroadcast;
    boolean linkedToDeath;
    final ActivityManagerService owner;
    public final int pid;
    public final IIntentReceiver receiver;
    String stringName;
    public final int uid;
    public final int userId;

    ReceiverList(ActivityManagerService _owner, ProcessRecord _app, int _pid, int _uid, int _userId, IIntentReceiver _receiver) {
        this.curBroadcast = null;
        this.linkedToDeath = false;
        this.owner = _owner;
        this.receiver = _receiver;
        this.app = _app;
        this.pid = _pid;
        this.uid = _uid;
        this.userId = _userId;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object o) {
        if (this != o) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.linkedToDeath = false;
        this.owner.unregisterReceiver(this.receiver);
    }

    public boolean containsFilter(IntentFilter filter) {
        int N = size();
        int i = 0;
    L3:
        if (i >= N) goto L9;
        BroadcastFilter f = get(i);
        if (IntentFilter.filterEquals(f, filter) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        if (this.app == null) goto L5;
        this.app.dumpDebug(proto, 1146756268033L);
        proto.write(1120986464265L, this.app.mReceivers.numberOfReceivers());
    L5:
        proto.write(1120986464258L, this.pid);
        proto.write(1120986464259L, this.uid);
        proto.write(1120986464260L, this.userId);
        if (this.curBroadcast == null) goto L8;
        this.curBroadcast.dumpDebug(proto, 1146756268037L);
    L8:
        proto.write(1133871366150L, this.linkedToDeath);
        int N = size();
        int i = 0;
    L9:
        if (i >= N) goto L11;
        BroadcastFilter bf = get(i);
        bf.dumpDebug(proto, 2246267895815L);
        i = i + 1;
        goto L9
    L11:
        int i2 = System.identityHashCode(this);
        proto.write(1138166333448L, Integer.toHexString(i2));
        proto.end(token);
    }

    void dumpLocal(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("app=");
        if (this.app == null) goto L5;
        String r0 = this.app.toShortString();
    L6:
        pw.print(r0);
        pw.print(" pid=");
        pw.print(this.pid);
        pw.print(" uid=");
        pw.print(this.uid);
        pw.print(" user=");
        pw.print(this.userId);
        if (this.app == null) goto L9;
        pw.print(" #receivers=");
        pw.print(this.app.mReceivers.numberOfReceivers());
    L9:
        pw.println();
        if (this.curBroadcast == null) goto L12;
    L13:
        pw.print(prefix);
        pw.print("curBroadcast=");
        pw.print(this.curBroadcast);
        pw.print(" linkedToDeath=");
        pw.println(this.linkedToDeath);
        return;
    L12:
        if (this.linkedToDeath == true) goto L13;
        return;
    L5:
        r0 = null;
        goto L6
    }

    void dump(PrintWriter pw, String prefix) {
        Printer pr = new PrintWriterPrinter(pw);
        dumpLocal(pw, prefix);
        String p2 = prefix + "  ";
        int N = size();
        int i = 0;
    L3:
        if (i >= N) goto L6;
        BroadcastFilter bf = get(i);
        pw.print(prefix);
        pw.print("Filter #");
        pw.print(i);
        pw.print(": BroadcastFilter{");
        pw.print(Integer.toHexString(System.identityHashCode(bf)));
        pw.println('}');
        bf.dumpInReceiverList(pw, pr, p2);
        i = i + 1;
        goto L3
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("ReceiverList{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.pid);
        sb.append(' ');
        if (this.app == null) goto L9;
        String r1 = this.app.processName;
    L10:
        sb.append(r1);
        sb.append('/');
        sb.append(this.uid);
        sb.append("/u");
        sb.append(this.userId);
        if ((this.receiver.asBinder() instanceof Binder) == false) goto L13;
        String r2 = " local:";
    L14:
        sb.append(r2);
        sb.append(Integer.toHexString(System.identityHashCode(this.receiver.asBinder())));
        sb.append('}');
        String r3 = sb.toString();
        this.stringName = r3;
        return r3;
    L13:
        r2 = " remote:";
        goto L14
    L9:
        r1 = "(unknown name)";
        goto L10
    L5:
        return this.stringName;
    }
}
