package com.android.contacts.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncImageLoader {
    private static final double FONT_OFFSET_LEFT = 0.3d;
    private static final double FONT_OFFSET_TOP = 3.3d;
    private static final float FONT_SIZE = 34.0f;
    private static final int MAX_QUEUE_NUMBER = 200;
    private static final String TAG = "AsyncImageLoader";
    private static AsyncImageLoader mAsyncImageLoader;
    private ExecutorService executorService;
    private Context mContext;
    private Map<String, Bitmap> mImageCache;
    private int mOffsetLeft;
    private int mOffsetTop;
    private Queue<String> mQueue;
    private Bitmap mRoundBG;

    public interface ImageCallback {
        void imageLoaded(Bitmap r1, String r2);
    }

    static {
    }

    public static final synchronized AsyncImageLoader getInstances(Context r2) {
        monitor-enter(AsyncImageLoader.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mAsyncImageLoader != null) goto L7;
        mAsyncImageLoader = new AsyncImageLoader(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        AsyncImageLoader r3 = mAsyncImageLoader;     // Catch: Throwable -> L10
        monitor-exit(AsyncImageLoader.class);
        return r3;
    }

    private void init() {
        this.mOffsetTop = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_TOP);
        this.mOffsetLeft = ContactsUtils.dipTopx(this.mContext, FONT_OFFSET_LEFT);
    }

    private AsyncImageLoader(Context r2) {
        this.mImageCache = new HashMap();
        this.mQueue = new LinkedList();
        this.executorService = Executors.newFixedThreadPool(5);
        this.mRoundBG = null;
        this.mOffsetTop = 0;
        this.mOffsetLeft = 0;
        this.mContext = r2;
        this.mRoundBG = BitmapFactory.decodeResource(r2.getResources(), R.drawable.roundphotobg);
        init();
    }

    public void clearImageCache() {
        Map<String, Bitmap> r0 = this.mImageCache;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Bitmap r1 = this.mRoundBG;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        new BitmapFactory.Options().inMutable = true;
        this.mRoundBG = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.roundphotobg);
    }

    public void resume() {
        this.executorService.notifyAll();
    }

    public void pause() {
        this.executorService.wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void putBitmap(String r3, Bitmap r4) {
        if (this.mImageCache.size() <= 200) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Release the earliest resource");
        String r0 = this.mQueue.poll();
        this.mImageCache.remove(r0);
    L5:
        this.mImageCache.put(r3, r4);
        this.mQueue.offer(r3);
    }
}
