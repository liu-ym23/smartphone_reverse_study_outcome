package com.android.server.am;

import android.util.ArraySet;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class ProcessReceiverRecord {
    final ProcessRecord mApp;
    private final ArraySet<BroadcastRecord> mCurReceivers;
    private int mCurReceiversSize;
    private final ArraySet<ReceiverList> mReceivers;
    private final ActivityManagerService mService;

    int numberOfCurReceivers() {
        return this.mCurReceiversSize;
    }

    void incrementCurReceivers() {
        this.mCurReceiversSize++;
    }

    void decrementCurReceivers() {
        this.mCurReceiversSize--;
    }

    @Deprecated
    BroadcastRecord getCurReceiverAt(int index) {
        return this.mCurReceivers.valueAt(index);
    }

    @Deprecated
    boolean hasCurReceiver(BroadcastRecord receiver) {
        return this.mCurReceivers.contains(receiver);
    }

    @Deprecated
    void addCurReceiver(BroadcastRecord receiver) {
        this.mCurReceivers.add(receiver);
        this.mCurReceiversSize = this.mCurReceivers.size();
    }

    @Deprecated
    void removeCurReceiver(BroadcastRecord receiver) {
        this.mCurReceivers.remove(receiver);
        this.mCurReceiversSize = this.mCurReceivers.size();
    }

    int numberOfReceivers() {
        return this.mReceivers.size();
    }

    void addReceiver(ReceiverList receiver) {
        this.mReceivers.add(receiver);
    }

    void removeReceiver(ReceiverList receiver) {
        this.mReceivers.remove(receiver);
    }

    ProcessReceiverRecord(ProcessRecord app) {
        this.mCurReceivers = new ArraySet();
        this.mReceivers = new ArraySet();
        this.mApp = app;
        this.mService = app.mService;
    }

    void onCleanupApplicationRecordLocked() {
        boolean freezing = this.mApp.getSmtEx().isFreezing();
        if (freezing == true) goto L10;
        int i = this.mReceivers.size() - 1;
    L5:
        if (i < 0) goto L7;
        this.mService.removeReceiverLocked(this.mReceivers.valueAt(i));
        i = i - 1;
        goto L5
    L7:
        this.mReceivers.clear();
        return;
    }

    void dump(PrintWriter pw, String prefix, long nowUptime) {
        if (this.mCurReceivers.isEmpty() == true) goto L8;
        pw.print(prefix);
        pw.println("Current mReceivers:");
        int i = 0;
        int size = this.mCurReceivers.size();
    L5:
        if (i >= size) goto L8;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mCurReceivers.valueAt(i));
        i = i + 1;
    L8:
        if (this.mReceivers.size() <= 0) goto L12;
        pw.print(prefix);
        pw.println("mReceivers:");
        int i2 = 0;
        int size2 = this.mReceivers.size();
    L10:
        if (i2 >= size2) goto L15;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mReceivers.valueAt(i2));
        i2 = i2 + 1;
        goto L10
    L15:
        return;
    }
}
