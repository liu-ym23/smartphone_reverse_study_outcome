package com.stepos.core.ota.downloader;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface DownloadListener {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static void onAdded(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onCancelled(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onCompleted(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onDeleted(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onDownloadBlockUpdated(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onError(DownloadListener downloadListener, DownloadTask task, Throwable th) {
            g.f(task, "task");
        }

        public static void onPaused(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onProgress(DownloadListener downloadListener, DownloadTask task, long j10, long j11) {
            g.f(task, "task");
        }

        public static void onQueued(DownloadListener downloadListener, DownloadTask task, boolean z) {
            g.f(task, "task");
        }

        public static void onRemoved(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onResumed(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onStarted(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }

        public static void onWaitingNetwork(DownloadListener downloadListener, DownloadTask task) {
            g.f(task, "task");
        }
    }

    void onAdded(DownloadTask downloadTask);

    void onCancelled(DownloadTask downloadTask);

    void onCompleted(DownloadTask downloadTask);

    void onDeleted(DownloadTask downloadTask);

    void onDownloadBlockUpdated(DownloadTask downloadTask);

    void onError(DownloadTask downloadTask, Throwable th);

    void onPaused(DownloadTask downloadTask);

    void onProgress(DownloadTask downloadTask, long j10, long j11);

    void onQueued(DownloadTask downloadTask, boolean z);

    void onRemoved(DownloadTask downloadTask);

    void onResumed(DownloadTask downloadTask);

    void onStarted(DownloadTask downloadTask);

    void onWaitingNetwork(DownloadTask downloadTask);
}
