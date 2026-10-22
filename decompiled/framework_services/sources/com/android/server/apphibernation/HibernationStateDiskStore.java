package com.android.server.apphibernation;

import android.util.AtomicFile;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class HibernationStateDiskStore<T> {
    private static final long DISK_WRITE_DELAY = 60000;
    private static final String STATES_FILE_NAME = "states";
    private static final String TAG = "HibernationStateDiskStore";
    private final ScheduledExecutorService mExecutorService;
    private ScheduledFuture<?> mFuture;
    private final File mHibernationFile;
    private final ProtoReadWriter<List<T>> mProtoReadWriter;
    private List<T> mScheduledStatesToWrite;

    /* JADX INFO: renamed from: $r8$lambda$A-i74LmoZL6HEzMJZ_iVNC9qW_M, reason: not valid java name */
    public static /* synthetic */ void m1711$r8$lambda$Ai74LmoZL6HEzMJZ_iVNC9qW_M(HibernationStateDiskStore r0) {
        r0.writeHibernationStates();
    }

    HibernationStateDiskStore(File hibernationDir, ProtoReadWriter<List<T>> readWriter, ScheduledExecutorService executorService) {
        this(hibernationDir, readWriter, executorService, STATES_FILE_NAME);
    }

    HibernationStateDiskStore(File hibernationDir, ProtoReadWriter<List<T>> readWriter, ScheduledExecutorService executorService, String fileName) {
        this.mScheduledStatesToWrite = new ArrayList();
        this.mHibernationFile = new File(hibernationDir, fileName);
        this.mExecutorService = executorService;
        this.mProtoReadWriter = readWriter;
    }

    void scheduleWriteHibernationStates(List<T> hibernationStates) {
        monitor-enter(this);
        this.mScheduledStatesToWrite = hibernationStates;     // Catch: Throwable -> L8
        if (this.mExecutorService.isShutdown() == false) goto L11;
        Slog.e(TAG, "Scheduled executor service is shut down.");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mFuture == null) goto L15;
        Slog.i(TAG, "Write already scheduled. Skipping schedule.");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L15:
        this.mFuture = this.mExecutorService.schedule(new HibernationStateDiskStore$$ExternalSyntheticLambda0(this), 60000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    List<T> readHibernationStates() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHibernationFile.exists() == true) goto L10;
        Slog.i(TAG, "No hibernation file on disk for file " + this.mHibernationFile.getPath());     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        AtomicFile atomicFile = new AtomicFile(this.mHibernationFile);     // Catch: Throwable -> L8
        FileInputStream inputStream = atomicFile.openRead();     // Catch: Throwable -> L8 IOException -> L14
        ProtoInputStream protoInputStream = new ProtoInputStream(inputStream);     // Catch: Throwable -> L8 IOException -> L14
        List<T> r4 = this.mProtoReadWriter.readFromProto(protoInputStream);     // Catch: Throwable -> L8 IOException -> L14
        monitor-exit(this);     // Catch: Throwable -> L8
        return r4;
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to read states protobuf.", e);     // Catch: Throwable -> L8
        return null;
    }

    private void writeHibernationStates() {
        monitor-enter(this);
        writeStateProto(this.mScheduledStatesToWrite);     // Catch: Throwable -> L6
        this.mScheduledStatesToWrite.clear();     // Catch: Throwable -> L6
        this.mFuture = null;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void writeStateProto(List<T> states) {
        AtomicFile atomicFile = new AtomicFile(this.mHibernationFile);
        FileOutputStream fileOutputStream = atomicFile.startWrite();     // Catch: IOException -> L9
        ProtoOutputStream protoOutputStream = new ProtoOutputStream(fileOutputStream);     // Catch: Exception -> L6
        this.mProtoReadWriter.writeToProto(protoOutputStream, states);     // Catch: Exception -> L6
        protoOutputStream.flush();     // Catch: Exception -> L6
        atomicFile.finishWrite(fileOutputStream);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to finish write to states protobuf.", e);
        atomicFile.failWrite(fileOutputStream);
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to start write to states protobuf.", e);
    }
}
