package com.android.server.location.injector;

import android.util.Log;
import com.android.server.location.LocationManagerService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PackageResetHelper {
    private final CopyOnWriteArrayList<Responder> mResponders;

    public interface Responder {
        boolean isResetableForPackage(String r1);

        void onPackageReset(String r1);
    }

    protected abstract void onRegister();

    protected abstract void onUnregister();

    public PackageResetHelper() {
        this.mResponders = new CopyOnWriteArrayList();
    }

    public synchronized void register(Responder responder) {
        monitor-enter(this);
        boolean empty = this.mResponders.isEmpty();     // Catch: Throwable -> L7
        this.mResponders.add(responder);     // Catch: Throwable -> L7
        if (empty == false) goto L9;
        onRegister();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void unregister(Responder responder) {
        monitor-enter(this);
        this.mResponders.remove(responder);     // Catch: Throwable -> L7
        if (this.mResponders.isEmpty() == false) goto L9;
        onUnregister();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected final void notifyPackageReset(String packageName) {
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "package " + packageName + " reset");
    L5:
        Iterator<Responder> r0 = this.mResponders.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Responder responder = r0.next();
        responder.onPackageReset(packageName);
        goto L7
    }

    protected final boolean queryResetableForPackage(String packageName) {
        Iterator<Responder> r0 = this.mResponders.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Responder responder = r0.next();
        if (responder.isResetableForPackage(packageName) == false) goto L4;
        return true;
    L10:
        return false;
    }
}
