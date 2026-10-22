package com.android.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemProperties;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class EntropyMixer extends Binder {
    static final String DEVICE_SPECIFIC_INFO_HEADER = "Copyright (C) 2009 The Android Open Source Project\nAll Your Randomness Are Belong To Us\n";
    static final int SEED_FILE_SIZE = 512;
    private static final int SEED_UPDATE_PERIOD = 10800000;
    private static final long START_NANOTIME = 0;
    private static final long START_TIME = 0;
    private static final String TAG = "EntropyMixer";
    private static final int UPDATE_SEED_MSG = 1;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Handler mHandler;
    private final File randomReadDevice;
    private final File randomWriteDevice;
    private final AtomicFile seedFile;

    /* JADX INFO: renamed from: -$$Nest$mscheduleSeedUpdater, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m225$$Nest$mscheduleSeedUpdater(EntropyMixer r0) {
        r0.scheduleSeedUpdater();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSeedFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m226$$Nest$mupdateSeedFile(EntropyMixer r0) {
        r0.updateSeedFile();
    }

    static {
        START_TIME = System.currentTimeMillis();
        START_NANOTIME = System.nanoTime();
    }

    public EntropyMixer(Context context) {
        this(context, new File(getSystemDir(), "entropy.dat"), new File("/dev/urandom"), new File("/dev/urandom"));
    }

    EntropyMixer(Context context, File seedFile, File randomReadDevice, File randomWriteDevice) {
        final Looper r1 = IoThread.getHandler().getLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.seedFile = new AtomicFile((File) Preconditions.checkNotNull(seedFile));
        this.randomReadDevice = (File) Preconditions.checkNotNull(randomReadDevice);
        this.randomWriteDevice = (File) Preconditions.checkNotNull(randomWriteDevice);
        loadInitialEntropy();
        updateSeedFile();
        scheduleSeedUpdater();
        IntentFilter broadcastFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        broadcastFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        broadcastFilter.addAction("android.intent.action.REBOOT");
        context.registerReceiver(this.mBroadcastReceiver, broadcastFilter, null, this.mHandler);
    }

    private void scheduleSeedUpdater() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 10800000);
    }

    private void loadInitialEntropy() {
        byte[] seed = readSeedFile();
        FileOutputStream out = new FileOutputStream(this.randomWriteDevice);     // Catch: IOException -> L12
    L7:
        th = move-exception;
        out.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: IOException -> L12
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
        goto L18
    L5:
        if (seed.length == 0) goto L9;
        out.write(seed);     // Catch: Throwable -> L7
        Slog.i(TAG, "Loaded existing seed file");     // Catch: Throwable -> L7
    L9:
        out.write(getDeviceSpecificInformation());     // Catch: Throwable -> L7
        out.close();     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Error writing to " + this.randomWriteDevice, e);
    }

    private byte[] readSeedFile() {
        return this.seedFile.readFully();
    L5:
        e = move-exception;
        Slog.e(TAG, "Error reading " + this.seedFile.getBaseFile(), e);
        return new byte[0];
    L12:
        return new byte[0];
    }

    private void updateSeedFile() {
        byte[] oldSeed = readSeedFile();
        byte[] newSeed = new byte[512];
        FileInputStream in = new FileInputStream(this.randomReadDevice);     // Catch: IOException -> L8
    L12:
        th = move-exception;
        in.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L8
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L8
        goto L17
    L5:
        if (in.read(newSeed) != newSeed.length) goto L11;
        in.close();     // Catch: IOException -> L8
    L30:
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L25
        sha256.update("Android EntropyMixer v1".getBytes());
        sha256.update(longToBytes(System.currentTimeMillis()));
        sha256.update(longToBytes(System.nanoTime()));
        sha256.update(longToBytes(oldSeed.length));
        sha256.update(oldSeed);
        sha256.update(longToBytes(newSeed.length));
        sha256.update(newSeed);
        byte[] digest = sha256.digest();
        System.arraycopy(digest, 0, newSeed, newSeed.length - digest.length, digest.length);
        writeNewSeed(newSeed);
        if (oldSeed.length != 0) goto L23;
        Slog.i(TAG, "Created seed file");
        return;
    L23:
        Slog.i(TAG, "Updated seed file");
        return;
    L25:
        e = move-exception;
        Slog.wtf(TAG, "SHA-256 algorithm not found; seed file won't be updated", e);
        return;
    L11:
        throw new IOException("unexpected EOF");     // Catch: Throwable -> L12
    L8:
        e = move-exception;
        Slog.e(TAG, "Error reading " + this.randomReadDevice + "; seed file won't be properly updated", e);
        goto L30
    }

    private void writeNewSeed(byte[] newSeed) {
        FileOutputStream out = null;
        out = this.seedFile.startWrite();     // Catch: IOException -> L5
        out.write(newSeed);     // Catch: IOException -> L5
        this.seedFile.finishWrite(out);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Error writing " + this.seedFile.getBaseFile(), e);
        this.seedFile.failWrite(out);
    }

    private static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(x);
        return buffer.array();
    }

    private byte[] getDeviceSpecificInformation() {
        return (DEVICE_SPECIFIC_INFO_HEADER + START_TIME + '\n' + START_NANOTIME + '\n' + SystemProperties.get("ro.serialno") + '\n' + SystemProperties.get("ro.bootmode") + '\n' + SystemProperties.get("ro.baseband") + '\n' + SystemProperties.get("ro.carrier") + '\n' + SystemProperties.get("ro.bootloader") + '\n' + SystemProperties.get("ro.hardware") + '\n' + SystemProperties.get("ro.revision") + '\n' + SystemProperties.get("ro.build.fingerprint") + '\n' + new Object().hashCode() + '\n' + System.currentTimeMillis() + '\n' + System.nanoTime() + '\n').getBytes();
    }

    private static File getSystemDir() {
        File dataDir = Environment.getDataDirectory();
        File systemDir = new File(dataDir, "system");
        systemDir.mkdirs();
        return systemDir;
    }
}
