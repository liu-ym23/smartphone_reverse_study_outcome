package com.bytedance.crypto.cloudsync;

import com.bytedance.crypto.monitor.ErrorEvent;
import com.bytedance.crypto.monitor.NormalEvent;
import com.bytedance.crypto.monitor.proto.CloudSyncData;

/* JADX INFO: loaded from: classes.dex */
public class EventTrace {
    public EventTrace() {
    }

    public static void eventTrace(int r9, int r10, String r11, String r12, long r13, int r15) {
        int r1 = 1;
        if (r9 != 0) goto L10;
        if (r10 == 0) goto L8;
        if (r10 == 1) goto L8;
        NormalEvent.getInstance().eventRecord(0, r10, r11, r12, r13, r15);
        return;
    L8:
        NormalEvent.getInstance().eventReport(0, r10, r11, r12, r13);
        return;
    L10:
        if (r10 != 5) goto L12;
    L20:
        r1 = 2;
    L21:
        ErrorEvent.eventTrace(0, r10, r11, r12, r9, r13, CloudSyncData.newBuilder().setCryptoMode(r1).setDataSize(r15).build());
        return;
    L12:
        if (r10 == 7) goto L20;
        if (r10 == 4) goto L21;
        if (r10 == 6) goto L21;
        r1 = 0;
        goto L21
    }
}
