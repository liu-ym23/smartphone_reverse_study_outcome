package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class VersionSafeCallbacks {

    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        public BidirectionalStreamCallback(BidirectionalStream.Callback r1) {
            this.mWrappedCallback = r1;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream r1) {
            this.mWrappedCallback.onStreamReady(r1);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream r1, UrlResponseInfo r2) {
            this.mWrappedCallback.onResponseHeadersReceived(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream r1, UrlResponseInfo r2, ByteBuffer r3, boolean r4) {
            this.mWrappedCallback.onReadCompleted(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream r1, UrlResponseInfo r2, ByteBuffer r3, boolean r4) {
            this.mWrappedCallback.onWriteCompleted(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream r1, UrlResponseInfo r2, UrlResponseInfo.HeaderBlock r3) {
            this.mWrappedCallback.onResponseTrailersReceived(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream r1, UrlResponseInfo r2) {
            this.mWrappedCallback.onSucceeded(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream r1, UrlResponseInfo r2, CronetException r3) {
            this.mWrappedCallback.onFailed(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream r1, UrlResponseInfo r2) {
            this.mWrappedCallback.onCanceled(r1, r2);
        }
    }

    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
            this.mWrappedLoader = r1;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String r1) {
            this.mWrappedLoader.loadLibrary(r1);
        }
    }

    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener r2) {
            super(r2.getExecutor());
            this.mWrappedListener = r2;
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int r1, long r2, int r4) {
            this.mWrappedListener.onRttObservation(r1, r2, r4);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public boolean equals(Object r2) {
            if (r2 != null) goto L4;
            return false;
        L4:
            if ((r2 instanceof NetworkQualityRttListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) r2).mWrappedListener);
        }
    }

    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener r2) {
            super(r2.getExecutor());
            this.mWrappedListener = r2;
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int r1, long r2, int r4) {
            this.mWrappedListener.onThroughputObservation(r1, r2, r4);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public boolean equals(Object r2) {
            if (r2 != null) goto L4;
            return false;
        L4:
            if ((r2 instanceof NetworkQualityThroughputListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) r2).mWrappedListener);
        }
    }

    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener r2) {
            super(r2.getExecutor());
            this.mWrappedListener = r2;
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo r1) {
            this.mWrappedListener.onRequestFinished(r1);
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }
    }

    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider r1) {
            this.mWrappedProvider = r1;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return this.mWrappedProvider.getLength();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r1, ByteBuffer r2) throws IOException {
            this.mWrappedProvider.read(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r1) throws IOException {
            this.mWrappedProvider.rewind(r1);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mWrappedProvider.close();
        }
    }

    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback r1) {
            this.mWrappedCallback = r1;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r1, UrlResponseInfo r2, String r3, String r4) throws Exception {
            this.mWrappedCallback.onRedirectReceived(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r1, UrlResponseInfo r2, String r3) throws Exception {
            this.mWrappedCallback.onResponseStarted(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r1, UrlResponseInfo r2, ByteBuffer r3) throws Exception {
            this.mWrappedCallback.onReadCompleted(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r1, UrlResponseInfo r2) {
            this.mWrappedCallback.onSucceeded(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r1, UrlResponseInfo r2, CronetException r3) {
            this.mWrappedCallback.onFailed(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r1, RequestFinishedInfo r2) {
            this.mWrappedCallback.onMetricsCollected(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r1, RequestFinishedInfo r2) {
            this.mWrappedCallback.onRequestLogCollected(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r1, UrlResponseInfo r2) {
            this.mWrappedCallback.onCanceled(r1, r2);
        }
    }

    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener r1) {
            this.mWrappedListener = r1;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int r1) {
            this.mWrappedListener.onStatus(r1);
        }
    }

    public VersionSafeCallbacks() {
    }
}
