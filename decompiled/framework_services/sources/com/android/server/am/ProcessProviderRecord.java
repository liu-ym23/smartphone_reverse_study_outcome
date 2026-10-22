package com.android.server.am;

import android.util.ArrayMap;
import android.util.TimeUtils;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class ProcessProviderRecord {
    final ProcessRecord mApp;
    private final ArrayList<ContentProviderConnection> mConProviders;
    private long mLastProviderTime;
    public final ArrayMap<String, ContentProviderRecord> mPubProviders;
    private final ActivityManagerService mService;

    long getLastProviderTime() {
        return this.mLastProviderTime;
    }

    void setLastProviderTime(long lastProviderTime) {
        this.mLastProviderTime = lastProviderTime;
    }

    boolean hasProvider(String name) {
        return this.mPubProviders.containsKey(name);
    }

    ContentProviderRecord getProvider(String name) {
        return this.mPubProviders.get(name);
    }

    int numberOfProviders() {
        return this.mPubProviders.size();
    }

    ContentProviderRecord getProviderAt(int index) {
        return this.mPubProviders.valueAt(index);
    }

    void installProvider(String name, ContentProviderRecord provider) {
        this.mPubProviders.put(name, provider);
    }

    void removeProvider(String name) {
        this.mPubProviders.remove(name);
    }

    void ensureProviderCapacity(int capacity) {
        this.mPubProviders.ensureCapacity(capacity);
    }

    int numberOfProviderConnections() {
        return this.mConProviders.size();
    }

    ContentProviderConnection getProviderConnectionAt(int index) {
        return this.mConProviders.get(index);
    }

    void addProviderConnection(ContentProviderConnection connection) {
        this.mConProviders.add(connection);
    }

    boolean removeProviderConnection(ContentProviderConnection connection) {
        return this.mConProviders.remove(connection);
    }

    ProcessProviderRecord(ProcessRecord app) {
        this.mLastProviderTime = Long.MIN_VALUE;
        this.mPubProviders = new ArrayMap();
        this.mConProviders = new ArrayList();
        this.mApp = app;
        this.mService = app.mService;
    }

    boolean onCleanupApplicationRecordLocked(boolean allowRestart) {
        boolean freezing = this.mApp.getSmtEx().isFreezing();
        boolean restart = false;
        int i = this.mPubProviders.size() - 1;
    L3:
        if (i < 0) goto L24;
        ContentProviderRecord cpr = this.mPubProviders.valueAt(i);
        if (cpr.proc != this.mApp) goto L22;
        if (this.mApp.mErrorState.isBad() == true) goto L13;
        if (allowRestart == false) goto L13;
        if (freezing == true) goto L13;
        boolean alwaysRemove = false;
    L14:
        boolean inLaunching = this.mService.mCpHelper.removeDyingProviderLocked(this.mApp, cpr, alwaysRemove);
        if (alwaysRemove == true) goto L20;
        if (inLaunching == false) goto L20;
        if (cpr.hasConnectionOrHandle() == false) goto L20;
        restart = true;
    L20:
        if (freezing == true) goto L22;
        cpr.provider = null;
        cpr.setProcess(null);
    L13:
        alwaysRemove = true;
    L22:
        i = i - 1;
        goto L3
    L24:
        if (freezing == true) goto L27;
        this.mPubProviders.clear();
        this.mApp.getSmtEx().resetFreezeBlockFlagsLocked(3);
    L27:
        if (this.mService.mCpHelper.cleanupAppInLaunchingProvidersLocked(this.mApp, freezing) == false) goto L30;
        this.mService.mProcessList.noteProcessDiedLocked(this.mApp);
        restart = true;
    L30:
        if (this.mConProviders.isEmpty() == true) goto L36;
        if (freezing == true) goto L36;
        int i2 = this.mConProviders.size() - 1;
    L33:
        if (i2 < 0) goto L35;
        ContentProviderConnection conn = this.mConProviders.get(i2);
        conn.provider.connections.remove(conn);
        this.mService.stopAssociationLocked(this.mApp.uid, this.mApp.processName, conn.provider.uid, conn.provider.appInfo.longVersionCode, conn.provider.name, conn.provider.info.processName);
        i2 = i2 - 1;
        goto L33
    L35:
        this.mConProviders.clear();
    L36:
        return restart;
    }

    void dump(PrintWriter pw, String prefix, long nowUptime) {
        if (this.mLastProviderTime <= 0) goto L6;
        pw.print(prefix);
        pw.print("lastProviderTime=");
        TimeUtils.formatDuration(this.mLastProviderTime, nowUptime, pw);
        pw.println();
    L6:
        if (this.mPubProviders.size() <= 0) goto L11;
        pw.print(prefix);
        pw.println("Published Providers:");
        int i = 0;
        int size = this.mPubProviders.size();
    L8:
        if (i >= size) goto L11;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mPubProviders.keyAt(i));
        pw.print(prefix);
        pw.print("    -> ");
        pw.println(this.mPubProviders.valueAt(i));
        i = i + 1;
    L11:
        if (this.mConProviders.size() <= 0) goto L15;
        pw.print(prefix);
        pw.println("Connected Providers:");
        int i2 = 0;
        int size2 = this.mConProviders.size();
    L13:
        if (i2 >= size2) goto L18;
        pw.print(prefix);
        pw.print("  - ");
        pw.println(this.mConProviders.get(i2).toShortString());
        i2 = i2 + 1;
        goto L13
    L18:
        return;
    }

    public ArrayList<ContentProviderConnection> getConProviders() {
        return this.mConProviders;
    }
}
