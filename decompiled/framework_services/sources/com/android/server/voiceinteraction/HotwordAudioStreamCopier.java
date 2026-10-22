package com.android.server.voiceinteraction;

import android.app.AppOpsManager;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.service.voice.HotwordAudioStream;
import android.service.voice.HotwordDetectedResult;
import android.util.Slog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
final class HotwordAudioStreamCopier {
    static final int DEFAULT_COPY_BUFFER_LENGTH_BYTES = 32768;
    static final int MAX_COPY_BUFFER_LENGTH_BYTES = 65536;
    private static final String OP_MESSAGE = "Streaming hotword audio to VoiceInteractionService";
    private static final String TAG = "HotwordAudioStreamCopier";
    private static final String TASK_ID_PREFIX = "HotwordDetectedResult@";
    private static final String THREAD_NAME_PREFIX = "Copy-";
    private final AppOpsManager mAppOpsManager;
    private final int mDetectorType;
    private final ExecutorService mExecutorService;
    private final String mVoiceInteractorAttributionTag;
    private final String mVoiceInteractorPackageName;
    private final int mVoiceInteractorUid;

    private static class CopyTaskInfo {
        private final int mCopyBufferLength;
        private final ParcelFileDescriptor mSink;
        private final ParcelFileDescriptor mSource;

        /* JADX INFO: renamed from: -$$Nest$fgetmCopyBufferLength, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9375$$Nest$fgetmCopyBufferLength(CopyTaskInfo r0) {
            return r0.mCopyBufferLength;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSink, reason: not valid java name */
        static /* bridge */ /* synthetic */ ParcelFileDescriptor m9376$$Nest$fgetmSink(CopyTaskInfo r0) {
            return r0.mSink;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ ParcelFileDescriptor m9377$$Nest$fgetmSource(CopyTaskInfo r0) {
            return r0.mSource;
        }

        CopyTaskInfo(ParcelFileDescriptor source, ParcelFileDescriptor sink, int copyBufferLength) {
            this.mSource = source;
            this.mSink = sink;
            this.mCopyBufferLength = copyBufferLength;
        }
    }

    private class HotwordDetectedResultCopyTask implements Runnable {
        private final List<CopyTaskInfo> mCopyTaskInfos;
        private final ExecutorService mExecutorService;
        private final String mResultTaskId;
        private final boolean mShouldNotifyAppOpsManager;
        private final int mTotalInitialAudioSizeBytes;
        private final int mTotalMetadataSizeBytes;
        final /* synthetic */ HotwordAudioStreamCopier this$0;

        HotwordDetectedResultCopyTask(HotwordAudioStreamCopier r1, String resultTaskId, List<CopyTaskInfo> copyTaskInfos, int totalMetadataSizeBytes, int totalInitialAudioSizeBytes, boolean shouldNotifyAppOpsManager) {
            this.this$0 = r1;
            this.mExecutorService = Executors.newCachedThreadPool();
            this.mResultTaskId = resultTaskId;
            this.mCopyTaskInfos = copyTaskInfos;
            this.mTotalMetadataSizeBytes = totalMetadataSizeBytes;
            this.mTotalInitialAudioSizeBytes = totalInitialAudioSizeBytes;
            this.mShouldNotifyAppOpsManager = shouldNotifyAppOpsManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(HotwordAudioStreamCopier.THREAD_NAME_PREFIX + this.mResultTaskId);
            int size = this.mCopyTaskInfos.size();
            ArrayList r0 = new ArrayList(size);
            int i = 0;
        L3:
            if (i >= size) goto L6;
            CopyTaskInfo copyTaskInfo = this.mCopyTaskInfos.get(i);
            String streamTaskId = this.mResultTaskId + "@" + i;
            r0.add(new SingleAudioStreamCopyTask(streamTaskId, CopyTaskInfo.m9377$$Nest$fgetmSource(copyTaskInfo), CopyTaskInfo.m9376$$Nest$fgetmSink(copyTaskInfo), CopyTaskInfo.m9375$$Nest$fgetmCopyBufferLength(copyTaskInfo), HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0)));
            i = i + 1;
            goto L3
        L6:
            if (this.mShouldNotifyAppOpsManager == true) goto L8;
        L37:
            HotwordMetricsLogger.writeAudioEgressEvent(HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), 1, HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), this.mTotalInitialAudioSizeBytes, this.mTotalMetadataSizeBytes, size);     // Catch: Throwable -> L15 InterruptedException -> L17
            this.mExecutorService.invokeAll(r0);     // Catch: Throwable -> L15 InterruptedException -> L17
            int totalStreamSizeBytes = this.mTotalInitialAudioSizeBytes;     // Catch: Throwable -> L15 InterruptedException -> L17
            Iterator r6 = r0.iterator();     // Catch: Throwable -> L15 InterruptedException -> L17
            int totalStreamSizeBytes2 = totalStreamSizeBytes;
        L13:
            if (r6.hasNext() == false) goto L19;
            SingleAudioStreamCopyTask task = (SingleAudioStreamCopyTask) r6.next();     // Catch: Throwable -> L15 InterruptedException -> L17
            totalStreamSizeBytes2 = totalStreamSizeBytes2 + SingleAudioStreamCopyTask.m9378$$Nest$fgetmTotalCopiedBytes(task);     // Catch: Throwable -> L15 InterruptedException -> L17
            goto L13
        L19:
            Slog.i(HotwordAudioStreamCopier.TAG, this.mResultTaskId + ": Task was completed. Total bytes egressed: " + totalStreamSizeBytes2 + " (including " + this.mTotalInitialAudioSizeBytes + " bytes NOT streamed), total metadata bundle size bytes: " + this.mTotalMetadataSizeBytes);     // Catch: Throwable -> L15 InterruptedException -> L17
            HotwordMetricsLogger.writeAudioEgressEvent(HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), 2, HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), totalStreamSizeBytes2, this.mTotalMetadataSizeBytes, size);     // Catch: Throwable -> L15 InterruptedException -> L17
        L21:
            if (this.mShouldNotifyAppOpsManager == false) goto L32;
        L22:
            HotwordAudioStreamCopier.m9370$$Nest$fgetmAppOpsManager(this.this$0).finishOp("android:record_audio_hotword", HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), HotwordAudioStreamCopier.m9373$$Nest$fgetmVoiceInteractorPackageName(this.this$0), HotwordAudioStreamCopier.m9372$$Nest$fgetmVoiceInteractorAttributionTag(this.this$0));
            return;
        L32:
            return;
        L15:
            th = move-exception;
            if (this.mShouldNotifyAppOpsManager == false) goto L36;
            HotwordAudioStreamCopier.m9370$$Nest$fgetmAppOpsManager(this.this$0).finishOp("android:record_audio_hotword", HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), HotwordAudioStreamCopier.m9373$$Nest$fgetmVoiceInteractorPackageName(this.this$0), HotwordAudioStreamCopier.m9372$$Nest$fgetmVoiceInteractorAttributionTag(this.this$0));
        L36:
            throw th;
        L17:
            e = move-exception;
            int totalStreamSizeBytes3 = this.mTotalInitialAudioSizeBytes;     // Catch: Throwable -> L15
            Iterator r7 = r0.iterator();     // Catch: Throwable -> L15
            int totalStreamSizeBytes4 = totalStreamSizeBytes3;
        L26:
            if (r7.hasNext() == false) goto L28;
            SingleAudioStreamCopyTask task2 = (SingleAudioStreamCopyTask) r7.next();     // Catch: Throwable -> L15
            totalStreamSizeBytes4 = totalStreamSizeBytes4 + SingleAudioStreamCopyTask.m9378$$Nest$fgetmTotalCopiedBytes(task2);     // Catch: Throwable -> L15
            goto L26
        L28:
            HotwordMetricsLogger.writeAudioEgressEvent(HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), 3, HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), totalStreamSizeBytes4, this.mTotalMetadataSizeBytes, size);     // Catch: Throwable -> L15
            Slog.i(HotwordAudioStreamCopier.TAG, this.mResultTaskId + ": Task was interrupted. Total bytes egressed: " + totalStreamSizeBytes4 + " (including " + this.mTotalInitialAudioSizeBytes + " bytes NOT streamed), total metadata bundle size bytes: " + this.mTotalMetadataSizeBytes);     // Catch: Throwable -> L15
            bestEffortPropagateError(e.getMessage());     // Catch: Throwable -> L15
            if (this.mShouldNotifyAppOpsManager == true) goto L22;
            return;
        L8:
            if (HotwordAudioStreamCopier.m9370$$Nest$fgetmAppOpsManager(this.this$0).startOpNoThrow("android:record_audio_hotword", HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), HotwordAudioStreamCopier.m9373$$Nest$fgetmVoiceInteractorPackageName(this.this$0), HotwordAudioStreamCopier.m9372$$Nest$fgetmVoiceInteractorAttributionTag(this.this$0), HotwordAudioStreamCopier.OP_MESSAGE) == 0) goto L37;
            HotwordMetricsLogger.writeAudioEgressEvent(HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), 4, HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), 0, 0, size);
            bestEffortPropagateError("Failed to obtain RECORD_AUDIO_HOTWORD permission for voice interactor with uid=" + HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0) + " packageName=" + HotwordAudioStreamCopier.m9373$$Nest$fgetmVoiceInteractorPackageName(this.this$0) + " attributionTag=" + HotwordAudioStreamCopier.m9372$$Nest$fgetmVoiceInteractorAttributionTag(this.this$0));
        }

        private void bestEffortPropagateError(String errorMessage) {
            Iterator<CopyTaskInfo> r0 = this.mCopyTaskInfos.iterator();     // Catch: IOException -> L6
        L4:
            if (r0.hasNext() == false) goto L8;
            CopyTaskInfo copyTaskInfo = r0.next();     // Catch: IOException -> L6
            CopyTaskInfo.m9377$$Nest$fgetmSource(copyTaskInfo).closeWithError(errorMessage);     // Catch: IOException -> L6
            CopyTaskInfo.m9376$$Nest$fgetmSink(copyTaskInfo).closeWithError(errorMessage);     // Catch: IOException -> L6
            goto L4
        L8:
            HotwordMetricsLogger.writeAudioEgressEvent(HotwordAudioStreamCopier.m9371$$Nest$fgetmDetectorType(this.this$0), 10, HotwordAudioStreamCopier.m9374$$Nest$fgetmVoiceInteractorUid(this.this$0), 0, 0, this.mCopyTaskInfos.size());     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            Slog.e(HotwordAudioStreamCopier.TAG, this.mResultTaskId + ": Failed to propagate error", e);
        }
    }

    private static class SingleAudioStreamCopyTask implements Callable<Void> {
        private final ParcelFileDescriptor mAudioSink;
        private final ParcelFileDescriptor mAudioSource;
        private final int mCopyBufferLength;
        private final int mDetectorType;
        private final String mStreamTaskId;
        private volatile int mTotalCopiedBytes;
        private final int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmTotalCopiedBytes, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9378$$Nest$fgetmTotalCopiedBytes(SingleAudioStreamCopyTask r0) {
            return r0.mTotalCopiedBytes;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        SingleAudioStreamCopyTask(String streamTaskId, ParcelFileDescriptor audioSource, ParcelFileDescriptor audioSink, int copyBufferLength, int detectorType, int uid) {
            this.mTotalCopiedBytes = 0;
            this.mStreamTaskId = streamTaskId;
            this.mAudioSource = audioSource;
            this.mAudioSink = audioSink;
            this.mCopyBufferLength = copyBufferLength;
            this.mDetectorType = detectorType;
            this.mUid = uid;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            Thread.currentThread().setName(HotwordAudioStreamCopier.THREAD_NAME_PREFIX + this.mStreamTaskId);
            InputStream fis = null;
            OutputStream fos = null;
            InputStream fis2 = new ParcelFileDescriptor.AutoCloseInputStream(this.mAudioSource);     // Catch: Throwable -> L7 IOException -> L9
            fos = new ParcelFileDescriptor.AutoCloseOutputStream(this.mAudioSink);     // Catch: Throwable -> L7 IOException -> L9
            byte[] buffer = new byte[this.mCopyBufferLength];     // Catch: Throwable -> L7 IOException -> L9
        L5:
            if (Thread.interrupted() == true) goto L6;
            int bytesRead = fis2.read(buffer);     // Catch: Throwable -> L7 IOException -> L9
            if (bytesRead < 0) goto L13;
            if (bytesRead <= 0) goto L5;
            fos.write(buffer, 0, bytesRead);     // Catch: Throwable -> L7 IOException -> L9
            this.mTotalCopiedBytes += bytesRead;     // Catch: Throwable -> L7 IOException -> L9
            goto L5
        L13:
            Slog.i(HotwordAudioStreamCopier.TAG, this.mStreamTaskId + ": Reached end of audio stream");     // Catch: Throwable -> L7 IOException -> L9
        L14:
            fis2.close();
        L15:
            fos.close();
            return null;
        L6:
            Slog.e(HotwordAudioStreamCopier.TAG, this.mStreamTaskId + ": SingleAudioStreamCopyTask task was interrupted");     // Catch: Throwable -> L7 IOException -> L9
        L9:
            e = move-exception;
            this.mAudioSource.closeWithError(e.getMessage());     // Catch: Throwable -> L7
            this.mAudioSink.closeWithError(e.getMessage());     // Catch: Throwable -> L7
            Slog.i(HotwordAudioStreamCopier.TAG, this.mStreamTaskId + ": Failed to copy audio stream", e);     // Catch: Throwable -> L7
            HotwordMetricsLogger.writeAudioEgressEvent(this.mDetectorType, 10, this.mUid, 0, 0, 0);     // Catch: Throwable -> L7
            if (0 == 0) goto L24;
            fis.close();
        L24:
            if (0 != 0) goto L15;
            return null;
        L7:
            th = move-exception;
            if (0 == 0) goto L30;
            fis.close();
        L30:
            if (0 == 0) goto L32;
            fos.close();
        L32:
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m9370$$Nest$fgetmAppOpsManager(HotwordAudioStreamCopier r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetectorType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9371$$Nest$fgetmDetectorType(HotwordAudioStreamCopier r0) {
        return r0.mDetectorType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVoiceInteractorAttributionTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9372$$Nest$fgetmVoiceInteractorAttributionTag(HotwordAudioStreamCopier r0) {
        return r0.mVoiceInteractorAttributionTag;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVoiceInteractorPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9373$$Nest$fgetmVoiceInteractorPackageName(HotwordAudioStreamCopier r0) {
        return r0.mVoiceInteractorPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVoiceInteractorUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9374$$Nest$fgetmVoiceInteractorUid(HotwordAudioStreamCopier r0) {
        return r0.mVoiceInteractorUid;
    }

    HotwordAudioStreamCopier(AppOpsManager appOpsManager, int detectorType, int voiceInteractorUid, String voiceInteractorPackageName, String voiceInteractorAttributionTag) {
        this.mExecutorService = Executors.newCachedThreadPool();
        this.mAppOpsManager = appOpsManager;
        this.mDetectorType = detectorType;
        this.mVoiceInteractorUid = voiceInteractorUid;
        this.mVoiceInteractorPackageName = voiceInteractorPackageName;
        this.mVoiceInteractorAttributionTag = voiceInteractorAttributionTag;
    }

    public HotwordDetectedResult startCopyingAudioStreams(HotwordDetectedResult result) throws IOException {
        return startCopyingAudioStreams(result, true);
    }

    public HotwordDetectedResult startCopyingAudioStreams(HotwordDetectedResult result, boolean shouldNotifyAppOpsManager) throws IOException {
        List<HotwordAudioStream> audioStreams = result.getAudioStreams();
        if (audioStreams.isEmpty() == false) goto L6;
        HotwordMetricsLogger.writeAudioEgressEvent(this.mDetectorType, 7, this.mVoiceInteractorUid, 0, 0, 0);
        return result;
    L6:
        int audioStreamCount = audioStreams.size();
        List<HotwordAudioStream> newAudioStreams = new ArrayList(audioStreams.size());
        List<CopyTaskInfo> copyTaskInfos = new ArrayList(audioStreams.size());
        int totalMetadataBundleSizeBytes = 0;
        Iterator<HotwordAudioStream> r4 = audioStreams.iterator();
        int totalInitialAudioSizeBytes = 0;
    L8:
        if (r4.hasNext() == false) goto L20;
        HotwordAudioStream audioStream = r4.next();
        ParcelFileDescriptor[] clientPipe = ParcelFileDescriptor.createReliablePipe();
        ParcelFileDescriptor clientAudioSource = clientPipe[0];
        ParcelFileDescriptor clientAudioSink = clientPipe[1];
        HotwordAudioStream newAudioStream = audioStream.buildUpon().setAudioStreamParcelFileDescriptor(clientAudioSource).build();
        newAudioStreams.add(newAudioStream);
        int copyBufferLength = 32768;
        PersistableBundle metadata = audioStream.getMetadata();
        totalMetadataBundleSizeBytes = totalMetadataBundleSizeBytes + HotwordDetectedResult.getParcelableSize(metadata);
        if (metadata.containsKey("android.service.voice.key.AUDIO_STREAM_COPY_BUFFER_LENGTH_BYTES") == false) goto L19;
        copyBufferLength = metadata.getInt("android.service.voice.key.AUDIO_STREAM_COPY_BUFFER_LENGTH_BYTES", -1);
        if (copyBufferLength >= 1) goto L14;
    L17:
        HotwordMetricsLogger.writeAudioEgressEvent(this.mDetectorType, 9, this.mVoiceInteractorUid, 0, 0, audioStreamCount);
        Slog.w(TAG, "Attempted to set an invalid copy buffer length (" + copyBufferLength + ") for: " + audioStream);
        copyBufferLength = 32768;
        goto L19
    L14:
        if (copyBufferLength > 65536) goto L17;
    L19:
        totalInitialAudioSizeBytes = totalInitialAudioSizeBytes + audioStream.getInitialAudio().length;
        ParcelFileDescriptor serviceAudioSource = audioStream.getAudioStreamParcelFileDescriptor();
        copyTaskInfos.add(new CopyTaskInfo(serviceAudioSource, clientAudioSink, copyBufferLength));
        goto L8
    L20:
        String resultTaskId = TASK_ID_PREFIX + System.identityHashCode(result);
        this.mExecutorService.execute(new HotwordDetectedResultCopyTask(this, resultTaskId, copyTaskInfos, totalMetadataBundleSizeBytes, totalInitialAudioSizeBytes, shouldNotifyAppOpsManager));
        return result.buildUpon().setAudioStreams(newAudioStreams).build();
    }
}
