package com.android.contacts.interactions;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import junit.framework.Assert;

/* JADX INFO: loaded from: classes2.dex */
public class TestLoaderManager extends LoaderManager {
    private static final String TAG = "TestLoaderManager";
    private LoaderManager mDelegate;
    private final HashSet<Integer> mFinishedLoaders;

    static /* synthetic */ HashSet access$000(TestLoaderManager r0) {
        return r0.mFinishedLoaders;
    }

    public TestLoaderManager() {
        this.mFinishedLoaders = new HashSet();
    }

    public void setDelegate(LoaderManager r2) {
        if (r2 == null) goto L9;
        LoaderManager r0 = this.mDelegate;
        if (r0 == null) goto L6;
        if (r0 != r2) goto L9;
    L6:
        this.mDelegate = r2;
        return;
    L9:
        throw new IllegalArgumentException("TestLoaderManager cannot be shared");
    }

    public LoaderManager getDelegate() {
        return this.mDelegate;
    }

    public void reset() {
        this.mFinishedLoaders.clear();
    }

    synchronized void waitForLoaders(int... r8) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(r8.length);     // Catch: Throwable -> L18
        int r1 = r8.length;     // Catch: Throwable -> L18
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L15;
        int r4 = r8[r3];     // Catch: Throwable -> L18
        if (this.mFinishedLoaders.contains(Integer.valueOf(r4)) == true) goto L14;
        AsyncTaskLoader r5 = (AsyncTaskLoader) this.mDelegate.getLoader(r4);     // Catch: Throwable -> L18
        if (r5 == null) goto L10;
        r0.add(r5);     // Catch: Throwable -> L18
        goto L14
    L10:
        Assert.fail("Loader does not exist: " + r4);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L14:
        r3 = r3 + 1;     // Catch: Throwable -> L18
        goto L4
    L15:
        waitForLoaders((Loader[]) r0.toArray(new Loader[0]));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void waitForLoaders(Loader<?>... r8) {
        int r0 = r8.length;
        Thread[] r1 = new Thread[r0];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r8.length) goto L6;
        final AsyncTaskLoader r4 = (AsyncTaskLoader) r8[r3];
        final String r6 = "LoaderWaitingThread" + r3;
        Thread r5 = new AnonymousClass1(r6, r4);
        r1[r3] = r5;
        r5.start();
        r3 = r3 + 1;
    L6:
        if (r2 >= r0) goto L10;
        r1[r2].join();     // Catch: InterruptedException -> L11
    L9:
        r2 = r2 + 1;
        goto L6
    }

    @Override // android.app.LoaderManager
    public <D> Loader<D> initLoader(final int r3, Bundle r4, final LoaderManager.LoaderCallbacks<D> r5) {
        return this.mDelegate.initLoader(r3, r4, new AnonymousClass2(this, r5, r3));
    }

    @Override // android.app.LoaderManager
    public <D> Loader<D> restartLoader(int r1, Bundle r2, LoaderManager.LoaderCallbacks<D> r3) {
        return this.mDelegate.restartLoader(r1, r2, r3);
    }

    @Override // android.app.LoaderManager
    public void destroyLoader(int r1) {
        this.mDelegate.destroyLoader(r1);
    }

    @Override // android.app.LoaderManager
    public <D> Loader<D> getLoader(int r1) {
        return this.mDelegate.getLoader(r1);
    }

    @Override // android.app.LoaderManager
    public void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
        this.mDelegate.dump(r1, r2, r3, r4);
    }
}
