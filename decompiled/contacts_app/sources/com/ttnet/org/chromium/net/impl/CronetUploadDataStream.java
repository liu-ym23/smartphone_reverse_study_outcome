package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = "CronetUploadDataStream";
    private ByteBuffer mByteBuffer;
    private long mByteBufferLimit;
    private volatile boolean mClosed;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;
    private boolean mDestroyAdapterPostponed;
    private final Executor mExecutor;
    private int mInWhichUserCallback;
    private long mLength;
    private final Object mLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private final Runnable mReadTask;
    private long mRemainingLength;
    private final CronetUrlRequest mRequest;
    private long mUploadDataStreamAdapter;

    interface Natives {
        long attachUploadDataToRequest(CronetUploadDataStream r1, long r2, long r4);

        long createAdapterForTesting(CronetUploadDataStream r1);

        long createUploadDataStreamForTesting(CronetUploadDataStream r1, long r2, long r4);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void destroy(long r1);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onReadSucceeded(long r1, CronetUploadDataStream r3, int r4, boolean r5);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onRewindSucceeded(long r1, CronetUploadDataStream r3);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    static {
    }

    static /* synthetic */ Object access$000(CronetUploadDataStream r0) {
        return r0.mLock;
    }

    static /* synthetic */ long access$100(CronetUploadDataStream r2) {
        return r2.mUploadDataStreamAdapter;
    }

    static /* synthetic */ void access$200(CronetUploadDataStream r0, int r1) {
        r0.checkState(r1);
    }

    static /* synthetic */ ByteBuffer access$300(CronetUploadDataStream r0) {
        return r0.mByteBuffer;
    }

    static /* synthetic */ int access$402(CronetUploadDataStream r0, int r1) {
        r0.mInWhichUserCallback = r1;
        return r1;
    }

    static /* synthetic */ void access$500(CronetUploadDataStream r0) {
        r0.checkCallingThread();
    }

    static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$600(CronetUploadDataStream r0) {
        return r0.mDataProvider;
    }

    static /* synthetic */ void access$700(CronetUploadDataStream r0, Throwable r1) {
        r0.onError(r1);
    }

    static /* synthetic */ boolean access$800(CronetUploadDataStream r0) {
        return r0.mClosed;
    }

    static /* synthetic */ String access$900() {
        return TAG;
    }

    public CronetUploadDataStream(UploadDataProvider r2, Executor r3, CronetUrlRequest r4) {
        this.mReadTask = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mInWhichUserCallback = 3;
        this.mExecutor = r3;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r2);
        this.mRequest = r4;
        this.mClosed = false;
    }

    void readData(ByteBuffer r3) {
        this.mByteBuffer = r3;
        this.mByteBufferLimit = r3.limit();
        postTaskToExecutor(this.mReadTask);
    }

    void rewind() {
        postTaskToExecutor(new AnonymousClass2(this));
    }

    private void checkCallingThread() {
        this.mRequest.checkCallingThread();
    }

    private void checkState(int r4) {
        if (this.mInWhichUserCallback != r4) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r4 + ", but was " + this.mInWhichUserCallback);
    }

    void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    private void onError(Throwable r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mInWhichUserCallback;     // Catch: Throwable -> L21
        if (r1 == 3) goto L20;
        if (r1 != 2) goto L9;
        boolean r2 = true;
    L10:
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L21
        this.mByteBuffer = null;     // Catch: Throwable -> L21
        destroyAdapterIfPostponed();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (r2 == true) goto L24;
    L17:
        this.mRequest.onUploadException(r7);
        return;
    L24:
        this.mDataProvider.close();     // Catch: Exception -> L15
        this.mClosed = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r2 = false;
        goto L10
    L20:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(boolean r12) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkState(0);     // Catch: Throwable -> L30
        if (this.mByteBufferLimit != this.mByteBuffer.limit()) goto L29;
        if (r12 == true) goto L10;
    L14:
        int r9 = this.mByteBuffer.position();     // Catch: Throwable -> L30
        long r4 = this.mRemainingLength - ((long) r9);     // Catch: Throwable -> L30
        this.mRemainingLength = r4;     // Catch: Throwable -> L30
        if (r4 < 0) goto L17;
    L21:
        this.mByteBuffer.position(0);     // Catch: Throwable -> L30
        this.mByteBuffer = null;     // Catch: Throwable -> L30
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L30
        destroyAdapterIfPostponed();     // Catch: Throwable -> L30
        if (this.mUploadDataStreamAdapter != 0) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L25:
        CronetUploadDataStreamJni.get().onReadSucceeded(this.mUploadDataStreamAdapter, this, r9, r12);     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L17:
        if (this.mLength < 0) goto L21;
        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)}));     // Catch: Throwable -> L30
    L10:
        if (this.mLength < 0) goto L14;
        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("ByteBuffer limit changed");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkState(0);     // Catch: Throwable -> L8
        onError(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkState(1);     // Catch: Throwable -> L12
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L12
        this.mRemainingLength = this.mLength;     // Catch: Throwable -> L12
        if (this.mUploadDataStreamAdapter != 0) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        CronetUploadDataStreamJni.get().onRewindSucceeded(this.mUploadDataStreamAdapter, this);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkState(1);     // Catch: Throwable -> L8
        onError(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void postTaskToExecutor(Runnable r3) {
        this.mExecutor.execute(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CronetUrlRequest r2 = this.mRequest;
        if (r2 == null) goto L10;
        r2.onUploadException(th);
        return;
    L10:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }

    private void destroyAdapter() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback != 0) goto L10;
        this.mDestroyAdapterPostponed = true;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L10:
        if (this.mUploadDataStreamAdapter != 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L13:
        CronetUploadDataStreamJni.get().destroy(this.mUploadDataStreamAdapter);     // Catch: Throwable -> L19
        this.mUploadDataStreamAdapter = 0;     // Catch: Throwable -> L19
        Runnable r1 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        r1.run();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L19
        postTaskToExecutor(new AnonymousClass3(this));
    }

    private void destroyAdapterIfPostponed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback == 0) goto L12;
        if (this.mDestroyAdapterPostponed == false) goto L9;
        destroyAdapter();     // Catch: Throwable -> L13
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L13
    }

    void initializeWithRequest() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInWhichUserCallback = 2;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        this.mRequest.checkCallingThread();     // Catch: Throwable -> L9
        long r1 = this.mDataProvider.getLength();     // Catch: Throwable -> L9
        this.mLength = r1;     // Catch: Throwable -> L9
        this.mRemainingLength = r1;     // Catch: Throwable -> L9
    L11:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        onError(th);
    L20:
        th = move-exception;
        throw th;
    }

    void attachNativeAdapterToRequest(long r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().attachUploadDataToRequest(this, r8, this.mLength);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long createUploadDataStreamForTesting() throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().createAdapterForTesting(this);     // Catch: Throwable -> L7
        long r1 = this.mDataProvider.getLength();     // Catch: Throwable -> L7
        this.mLength = r1;     // Catch: Throwable -> L7
        this.mRemainingLength = r1;     // Catch: Throwable -> L7
        long r2 = CronetUploadDataStreamJni.get().createUploadDataStreamForTesting(this, this.mLength, this.mUploadDataStreamAdapter);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    void setOnDestroyedCallbackForTesting(Runnable r1) {
        this.mOnDestroyedCallbackForTesting = r1;
    }
}
