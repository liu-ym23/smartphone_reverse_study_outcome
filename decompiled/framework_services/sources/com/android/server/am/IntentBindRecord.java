package com.android.server.am;

import android.content.Intent;
import android.os.IBinder;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class IntentBindRecord {
    final ArrayMap<ProcessRecord, AppBindRecord> apps;
    IBinder binder;
    boolean doRebind;
    boolean hasBound;
    final Intent.FilterComparison intent;
    boolean received;
    boolean requested;
    final ServiceRecord service;
    String stringName;

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("service=");
        pw.println(this.service);
        dumpInService(pw, prefix);
    }

    void dumpInService(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("intent={");
        pw.print(this.intent.getIntent().toShortString(false, true, false, false));
        pw.println('}');
        pw.print(prefix);
        pw.print("binder=");
        pw.println(this.binder);
        pw.print(prefix);
        pw.print("requested=");
        pw.print(this.requested);
        pw.print(" received=");
        pw.print(this.received);
        pw.print(" hasBound=");
        pw.print(this.hasBound);
        pw.print(" doRebind=");
        pw.println(this.doRebind);
        int i = 0;
    L4:
        if (i >= this.apps.size()) goto L7;
        AppBindRecord a = this.apps.valueAt(i);
        pw.print(prefix);
        pw.print("* Client AppBindRecord{");
        pw.print(Integer.toHexString(System.identityHashCode(a)));
        pw.print(' ');
        pw.print(a.client);
        pw.println('}');
        a.dumpInIntentBind(pw, prefix + "  ");
        i = i + 1;
        goto L4
    }

    IntentBindRecord(ServiceRecord _service, Intent.FilterComparison _intent) {
        this.apps = new ArrayMap();
        this.service = _service;
        this.intent = _intent;
    }

    long collectFlags() {
        long flags = 0;
        int i = this.apps.size() - 1;
    L3:
        if (i < 0) goto L9;
        ArraySet<ConnectionRecord> connections = this.apps.valueAt(i).connections;
        int j = connections.size() - 1;
    L5:
        if (j < 0) goto L7;
        flags = flags | connections.valueAt(j).getFlags();
        j = j - 1;
        goto L5
    L7:
        i = i - 1;
        goto L3
    L9:
        return flags;
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("IntentBindRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        if ((collectFlags() & 1) == 0) goto L9;
        sb.append("CR ");
    L9:
        sb.append(this.service.shortInstanceName);
        sb.append(':');
        if (this.intent == null) goto L12;
        this.intent.getIntent().toShortString(sb, false, false, false, false);
    L12:
        sb.append('}');
        String r0 = sb.toString();
        this.stringName = r0;
        return r0;
    L5:
        return this.stringName;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        if (this.intent == null) goto L5;
        ProtoOutputStream proto2 = proto;
        this.intent.getIntent().dumpDebug(proto2, 1146756268033L, false, true, false, false);
    L7:
        if (this.binder == null) goto L10;
        proto2.write(1138166333442L, this.binder.toString());
    L10:
        if ((collectFlags() & 1) == 0) goto L12;
        boolean r12 = true;
    L13:
        proto2.write(1133871366147L, r12);
        proto2.write(1133871366148L, this.requested);
        proto2.write(1133871366149L, this.received);
        proto2.write(1133871366150L, this.hasBound);
        proto2.write(1133871366151L, this.doRebind);
        int N = this.apps.size();
        int i = 0;
    L14:
        if (i >= N) goto L19;
        AppBindRecord a = this.apps.valueAt(i);
        if (a == null) goto L18;
        a.dumpDebug(proto2, 2246267895816L);
    L18:
        i = i + 1;
        goto L14
    L19:
        proto2.end(token);
        return;
    L12:
        r12 = false;
        goto L13
    L5:
        proto2 = proto;
        goto L7
    }
}
