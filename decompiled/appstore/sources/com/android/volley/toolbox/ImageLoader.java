package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class ImageLoader {
    private int mBatchResponseDelayMs;
    private final HashMap<String, BatchedImageRequest> mBatchedResponses;
    private final ImageCache mCache;
    private final Handler mHandler;
    private final HashMap<String, BatchedImageRequest> mInFlightRequests;
    private final RequestQueue mRequestQueue;
    private Runnable mRunnable;

    public class BatchedImageRequest {
        private final LinkedList<ImageContainer> mContainers;
        private VolleyError mError;
        private final Request<?> mRequest;
        private Bitmap mResponseBitmap;
        final /* synthetic */ ImageLoader this$0;

        public BatchedImageRequest(ImageLoader r10, Request<?> r11, ImageContainer r12) {
            this.this$0 = r10;
            LinkedList<ImageContainer> r13 = new LinkedList();
            this.mContainers = r13;
            this.mRequest = r11;
            r13.add(r12);
        }

        public static /* synthetic */ Bitmap access$000(BatchedImageRequest r10) {
            return r10.mResponseBitmap;
        }

        public static /* synthetic */ Bitmap access$002(BatchedImageRequest r10, Bitmap r11) {
            r10.mResponseBitmap = r11;
            return r11;
        }

        public static /* synthetic */ LinkedList access$300(BatchedImageRequest r10) {
            return r10.mContainers;
        }

        public void addContainer(ImageContainer r10) {
            this.mContainers.add(r10);
        }

        public VolleyError getError() {
            return this.mError;
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer r10) {
            this.mContainers.remove(r10);
            if (this.mContainers.size() != 0) goto L6;
            this.mRequest.cancel();
            return true;
        L6:
            return false;
        }

        public void setError(VolleyError r10) {
            this.mError = r10;
        }
    }

    public interface ImageCache {
        Bitmap getBitmap(String r10);

        void putBitmap(String r10, Bitmap r11);
    }

    public class ImageContainer {
        private Bitmap mBitmap;
        private final String mCacheKey;
        private final ImageListener mListener;
        private final String mRequestUrl;
        final /* synthetic */ ImageLoader this$0;

        public ImageContainer(ImageLoader r10, Bitmap r11, String r12, String r13, ImageListener r14) {
            this.this$0 = r10;
            this.mBitmap = r11;
            this.mRequestUrl = r12;
            this.mCacheKey = r13;
            this.mListener = r14;
        }

        public static /* synthetic */ ImageListener access$400(ImageContainer r10) {
            return r10.mListener;
        }

        public static /* synthetic */ Bitmap access$502(ImageContainer r10, Bitmap r11) {
            r10.mBitmap = r11;
            return r11;
        }

        public void cancelRequest() {
            if (this.mListener != null) goto L5;
            return;
        L5:
            BatchedImageRequest r10 = (BatchedImageRequest) ImageLoader.access$100(this.this$0).get(this.mCacheKey);
            if (r10 != null) goto L8;
            BatchedImageRequest r11 = (BatchedImageRequest) ImageLoader.access$200(this.this$0).get(this.mCacheKey);
            if (r11 == null) goto L18;
            r11.removeContainerAndCancelIfNecessary(this);
            if (BatchedImageRequest.access$300(r11).size() != 0) goto L19;
            ImageLoader.access$200(this.this$0).remove(this.mCacheKey);
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r10.removeContainerAndCancelIfNecessary(this) == false) goto L16;
            ImageLoader.access$100(this.this$0).remove(this.mCacheKey);
            return;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer r10, boolean r11);
    }

    public ImageLoader(RequestQueue r10, ImageCache r11) {
        this.mBatchResponseDelayMs = 100;
        this.mInFlightRequests = new HashMap();
        this.mBatchedResponses = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRequestQueue = r10;
        this.mCache = r11;
    }

    public static /* synthetic */ HashMap access$100(ImageLoader r10) {
        return r10.mInFlightRequests;
    }

    public static /* synthetic */ HashMap access$200(ImageLoader r10) {
        return r10.mBatchedResponses;
    }

    public static /* synthetic */ Runnable access$602(ImageLoader r10, Runnable r11) {
        r10.mRunnable = r11;
        return r11;
    }

    private void batchResponse(String r10, BatchedImageRequest r11) {
        this.mBatchedResponses.put(r10, r11);
        if (this.mRunnable != null) goto L6;
        Runnable r12 = new AnonymousClass4(this);
        this.mRunnable = r12;
        this.mHandler.postDelayed(r12, this.mBatchResponseDelayMs);
        return;
    }

    private static String getCacheKey(String r10, int r11, int r12, ImageView.ScaleType r13) {
        StringBuilder r14 = new StringBuilder(r10.length() + 12);
        r14.append("#W");
        r14.append(r11);
        r14.append("#H");
        r14.append(r12);
        r14.append("#S");
        r14.append(r13.ordinal());
        r14.append(r10);
        return r14.toString();
    }

    public static ImageListener getImageListener(final ImageView r10, final int r11, final int r12) {
        return new AnonymousClass1(r12, r10, r11);
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }

    public ImageContainer get(String r10, ImageListener r11) {
        return get(r10, r11, 0, 0);
    }

    public boolean isCached(String r10, int r11, int r12) {
        return isCached(r10, r11, r12, ImageView.ScaleType.CENTER_INSIDE);
    }

    public Request<Bitmap> makeImageRequest(String r10, int r11, int r12, ImageView.ScaleType r13, final String r14) {
        return new ImageRequest(r10, new AnonymousClass2(this, r14), r11, r12, r13, Bitmap.Config.RGB_565, new AnonymousClass3(this, r14));
    }

    public void onGetImageError(String r10, VolleyError r11) {
        BatchedImageRequest r12 = this.mInFlightRequests.remove(r10);
        if (r12 == null) goto L6;
        r12.setError(r11);
        batchResponse(r10, r12);
        return;
    }

    public void onGetImageSuccess(String r10, Bitmap r11) {
        this.mCache.putBitmap(r10, r11);
        BatchedImageRequest r12 = this.mInFlightRequests.remove(r10);
        if (r12 == null) goto L6;
        BatchedImageRequest.access$002(r12, r11);
        batchResponse(r10, r12);
        return;
    }

    public void setBatchedResponseDelay(int r10) {
        this.mBatchResponseDelayMs = r10;
    }

    public ImageContainer get(String r10, ImageListener r11, int r12, int r13) {
        return get(r10, r11, r12, r13, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String r10, int r11, int r12, ImageView.ScaleType r13) {
        throwIfNotOnMainThread();
        String r14 = getCacheKey(r10, r11, r12, r13);
        if (this.mCache.getBitmap(r14) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ImageContainer get(String r16, ImageListener r17, int r18, int r19, ImageView.ScaleType r20) {
        throwIfNotOnMainThread();
        String r12 = getCacheKey(r16, r18, r19, r20);
        Bitmap r10 = this.mCache.getBitmap(r12);
        if (r10 == null) goto L6;
        ImageContainer r11 = new ImageContainer(this, r10, r16, null, null);
        r17.onResponse(r11, true);
        return r11;
    L6:
        ImageContainer r14 = new ImageContainer(this, null, r16, r12, r17);
        r17.onResponse(r14, true);
        BatchedImageRequest r13 = this.mInFlightRequests.get(r12);
        if (r13 == null) goto L10;
        r13.addContainer(r14);
        return r14;
    L10:
        Request<Bitmap> r15 = makeImageRequest(r16, r18, r19, r20, r12);
        this.mRequestQueue.add(r15);
        this.mInFlightRequests.put(r12, new BatchedImageRequest(this, r15, r14));
        return r14;
    }
}
