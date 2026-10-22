package com.android.server.location.settings;

import android.util.AtomicFile;
import android.util.Log;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.Preconditions;
import com.android.server.location.LocationManagerService;
import com.android.server.location.settings.SettingsStore.VersionedSettings;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
abstract class SettingsStore<T extends VersionedSettings> {
    private T mCache;
    private final AtomicFile mFile;
    private boolean mInitialized;

    interface VersionedSettings {
        public static final int VERSION_DOES_NOT_EXIST = Integer.MAX_VALUE;

        int getVersion();
    }

    public static /* synthetic */ void $r8$lambda$PzHLNa6_zX_tQkQudstwae0KhS0(SettingsStore r0, VersionedSettings r1) {
        r0.lambda$writeLazily$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$krOuTCpq0N8sAg_b0XhDCyosXk4(SettingsStore r0, CountDownLatch r1) {
        r0.lambda$deleteFile$0(r1);
    }

    protected abstract void onChange(T r1, T r2);

    protected abstract T read(int r1, DataInput r2) throws IOException;

    protected abstract void write(DataOutput r1, T r2) throws IOException;

    protected SettingsStore(File file) {
        this.mFile = new AtomicFile(file);
    }

    public final synchronized void initializeCache() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitialized == false) goto L6;
    L39:
        monitor-exit(this);
        return;
    L6:
        boolean r1 = false;
        if (this.mFile.exists() == false) goto L29;
        DataInputStream r0 = new DataInputStream(this.mFile.openRead());     // Catch: Throwable -> L16 IOException -> L18
        this.mCache = (T) read(r0.readInt(), r0);     // Catch: Throwable -> L20
        if (this.mCache.getVersion() >= Integer.MAX_VALUE) goto L12;
        boolean r4 = true;
    L13:
        Preconditions.checkState(r4);     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L16 IOException -> L18
        goto L29
    L12:
        r4 = false;
    L20:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L16 IOException -> L18
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16 IOException -> L18
    L18:
        e = move-exception;
        Log.e(LocationManagerService.TAG, "error reading location settings (" + this.mFile + "), falling back to defaults", e);     // Catch: Throwable -> L16
    L29:
        if (this.mCache == null) goto L45;
    L38:
        this.mInitialized = true;     // Catch: Throwable -> L16
        goto L39
    L45:
        this.mCache = (T) read(Integer.MAX_VALUE, new DataInputStream(new ByteArrayInputStream(new byte[0])));     // Catch: Throwable -> L16 IOException -> L35
        if (this.mCache.getVersion() >= Integer.MAX_VALUE) goto L33;
        r1 = true;
    L33:
        Preconditions.checkState(r1);     // Catch: Throwable -> L16 IOException -> L35
    L35:
        e = move-exception;
        throw new AssertionError(e);     // Catch: Throwable -> L16
    }

    public final synchronized T get() {
        monitor-enter(this);
        initializeCache();     // Catch: Throwable -> L6
        T r0 = this.mCache;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void update(Function<T, T> r5) {
        monitor-enter(this);
        initializeCache();     // Catch: Throwable -> L14
        T r0 = this.mCache;     // Catch: Throwable -> L14
        T r1 = r5.apply(r0);     // Catch: Throwable -> L14
        r1.getClass();     // Catch: Throwable -> L14
        if (r0.equals(r1) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mCache = r1;     // Catch: Throwable -> L14
        if (this.mCache.getVersion() >= Integer.MAX_VALUE) goto L10;
        boolean r2 = true;
    L11:
        Preconditions.checkState(r2);     // Catch: Throwable -> L14
        writeLazily(r1);     // Catch: Throwable -> L14
        onChange(r0, r1);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r2 = false;
    L14:
        th = move-exception;
        throw th;
    }

    synchronized void flushFile() throws InterruptedException {
        monitor-enter(this);
        CountDownLatch latch = new CountDownLatch(1);     // Catch: Throwable -> L6
        BackgroundThread.getExecutor().execute(new SettingsStore$$ExternalSyntheticLambda0(latch));     // Catch: Throwable -> L6
        latch.await();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void deleteFile() throws InterruptedException {
        monitor-enter(this);
        final CountDownLatch latch = new CountDownLatch(1);     // Catch: Throwable -> L6
        BackgroundThread.getExecutor().execute(new SettingsStore$$ExternalSyntheticLambda1(this, latch));     // Catch: Throwable -> L6
        latch.await();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$deleteFile$0(CountDownLatch latch) {
        this.mFile.delete();
        latch.countDown();
    }

    private void writeLazily(final T settings) {
        BackgroundThread.getExecutor().execute(new SettingsStore$$ExternalSyntheticLambda2(this, settings));
    }

    private /* synthetic */ void lambda$writeLazily$1(VersionedSettings settings) {
        FileOutputStream os = null;
        os = this.mFile.startWrite();     // Catch: Throwable -> L5 IOException -> L7
        DataOutputStream out = new DataOutputStream(os);     // Catch: Throwable -> L5 IOException -> L7
        out.writeInt(settings.getVersion());     // Catch: Throwable -> L5 IOException -> L7
        write(out, settings);     // Catch: Throwable -> L5 IOException -> L7
        this.mFile.finishWrite(os);     // Catch: Throwable -> L5 IOException -> L7
        return;
    L7:
        e = move-exception;
        this.mFile.failWrite(os);
        Log.e(LocationManagerService.TAG, "failure serializing location settings", e);
        return;
    L5:
        e = move-exception;
        this.mFile.failWrite(os);
        throw e;
    }
}
