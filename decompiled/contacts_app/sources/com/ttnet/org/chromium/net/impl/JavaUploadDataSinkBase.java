package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JavaUploadDataSinkBase extends UploadDataSink {
    public static final int DEFAULT_UPLOAD_BUFFER_SIZE = 8192;
    private ByteBuffer mBuffer;
    private final Executor mExecutor;
    private final AtomicInteger mSinkState;
    private long mTotalBytes;
    private final UploadDataProvider mUploadProvider;
    private final Executor mUserUploadExecutor;
    private long mWrittenBytes;

    @Retention(RetentionPolicy.SOURCE)
    @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    protected abstract void finish() throws IOException;

    protected abstract Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1);

    protected abstract Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1);

    protected abstract void initializeRead() throws IOException;

    protected abstract void initializeStart(long r1);

    protected abstract int processSuccessfulRead(ByteBuffer r1) throws IOException;

    protected abstract void processUploadError(Throwable r1);

    static /* synthetic */ ByteBuffer access$000(JavaUploadDataSinkBase r0) {
        return r0.mBuffer;
    }

    static /* synthetic */ ByteBuffer access$002(JavaUploadDataSinkBase r0, ByteBuffer r1) {
        r0.mBuffer = r1;
        return r1;
    }

    static /* synthetic */ long access$100(JavaUploadDataSinkBase r2) {
        return r2.mTotalBytes;
    }

    static /* synthetic */ long access$102(JavaUploadDataSinkBase r0, long r1) {
        r0.mTotalBytes = r1;
        return r1;
    }

    static /* synthetic */ long access$200(JavaUploadDataSinkBase r2) {
        return r2.mWrittenBytes;
    }

    static /* synthetic */ long access$214(JavaUploadDataSinkBase r2, long r3) {
        long r0 = r2.mWrittenBytes + r3;
        r2.mWrittenBytes = r0;
        return r0;
    }

    static /* synthetic */ AtomicInteger access$300(JavaUploadDataSinkBase r0) {
        return r0.mSinkState;
    }

    static /* synthetic */ UploadDataProvider access$400(JavaUploadDataSinkBase r0) {
        return r0.mUploadProvider;
    }

    static /* synthetic */ void access$500(JavaUploadDataSinkBase r0, JavaUrlRequestUtils.CheckedRunnable r1) {
        r0.executeOnUploadExecutor(r1);
    }

    static /* synthetic */ void access$600(JavaUploadDataSinkBase r0) {
        r0.startRead();
    }

    public JavaUploadDataSinkBase(final Executor r3, Executor r4, UploadDataProvider r5) {
        this.mSinkState = new AtomicInteger(3);
        this.mUserUploadExecutor = new AnonymousClass1(this, r3);
        this.mExecutor = r4;
        this.mUploadProvider = r5;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(final boolean r4) {
        if (this.mSinkState.compareAndSet(0, 2) == false) goto L7;
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass2(this, r4)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.mSinkState.get());
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        if (this.mSinkState.compareAndSet(1, 2) == false) goto L7;
        startRead();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.mSinkState.get());
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r1) {
        processUploadError(r1);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r1) {
        processUploadError(r1);
    }

    private void startRead() {
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass3(this)));
    }

    private void executeOnUploadExecutor(JavaUrlRequestUtils.CheckedRunnable r2) {
        this.mUserUploadExecutor.execute(getUploadErrorSettingRunnable(r2));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        processUploadError(e);
    }

    public void start(final boolean r2) {
        executeOnUploadExecutor(new AnonymousClass4(this, r2));
    }
}
