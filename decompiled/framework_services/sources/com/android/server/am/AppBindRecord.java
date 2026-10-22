package com.android.server.am;

import android.util.ArraySet;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class AppBindRecord {
    final ProcessRecord attributedClient;
    final ProcessRecord client;
    final ArraySet<ConnectionRecord> connections;
    final IntentBindRecord intent;
    final ServiceRecord service;

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "service=" + this.service);
        pw.println(prefix + "client=" + this.client);
        pw.println(prefix + "attributedClient=" + this.attributedClient);
        dumpInIntentBind(pw, prefix);
    }

    void dumpInIntentBind(PrintWriter pw, String prefix) {
        int N = this.connections.size();
        if (N <= 0) goto L7;
        pw.println(prefix + "Per-process Connections:");
        int i = 0;
    L5:
        if (i >= N) goto L9;
        ConnectionRecord c = this.connections.valueAt(i);
        pw.println(prefix + "  " + c);
        i = i + 1;
        goto L5
    L9:
        return;
    }

    AppBindRecord(ServiceRecord _service, IntentBindRecord _intent, ProcessRecord _client, ProcessRecord _attributedClient) {
        this.connections = new ArraySet();
        this.service = _service;
        this.intent = _intent;
        this.client = _client;
        this.attributedClient = _attributedClient;
    }

    public String toString() {
        return "AppBindRecord{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.service.shortInstanceName + ":" + this.client.processName + "}";
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.service.shortInstanceName);
        proto.write(1138166333442L, this.client.processName);
        int N = this.connections.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        ConnectionRecord conn = this.connections.valueAt(i);
        proto.write(2237677961219L, Integer.toHexString(System.identityHashCode(conn)));
        i = i + 1;
        goto L3
    L5:
        proto.end(token);
    }
}
