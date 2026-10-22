package com.android.contacts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.LruCache;
import android.widget.ImageView;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.MemoryUtils;
import com.android.contacts.util.UriUtils;
import com.google.android.collect.Lists;
import com.google.android.collect.Sets;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ContactPhotoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ContactPhotoManagerImpl extends ContactPhotoManager implements Handler.Callback {
    private static final int BITMAP_CACHE_SIZE = 1769472;
    private static final String[] COLUMNS = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final int HOLDER_CACHE_SIZE = 2000000;
    private static final int LARGE_RAM_THRESHOLD = 671088640;
    private static final String LOADER_THREAD_NAME = "ContactPhotoLoader";
    private static final int MESSAGE_PHOTOS_LOADED = 2;
    private static final int MESSAGE_REQUEST_LOADING = 1;
    private final LruCache<Object, Bitmap> mBitmapCache;
    private final LruCache<Object, BitmapHolder> mBitmapHolderCache;
    private final int mBitmapHolderCacheRedZoneBytes;
    private final Context mContext;
    private final AtomicInteger mFreshCacheOverwrite;
    private LoaderThread mLoaderThread;
    private boolean mLoadingRequested;
    private final Handler mMainThreadHandler;
    private boolean mPaused;
    private final ConcurrentHashMap<ImageView, Request> mPendingRequests;
    private final AtomicInteger mStaleCacheOverwrite;

    /* JADX INFO: compiled from: ContactPhotoManager.java */
    private static class BitmapHolder {
        Bitmap bitmap;
        Reference<Bitmap> bitmapRef;
        final byte[] bytes;
        volatile boolean fresh;

        public BitmapHolder(byte[] r1) {
            this.bytes = r1;
            this.fresh = true;
        }
    }

    /* JADX INFO: compiled from: ContactPhotoManager.java */
    private class LoaderThread extends HandlerThread implements Handler.Callback {
        private static final int BUFFER_SIZE = 16384;
        private static final int MAX_PHOTOS_TO_PRELOAD = 100;
        private static final int MESSAGE_LOAD_PHOTOS = 1;
        private static final int MESSAGE_PRELOAD_PHOTOS = 0;
        private static final int PHOTO_PRELOAD_DELAY = 1000;
        private static final int PRELOAD_BATCH = 25;
        private static final int PRELOAD_STATUS_DONE = 2;
        private static final int PRELOAD_STATUS_IN_PROGRESS = 1;
        private static final int PRELOAD_STATUS_NOT_STARTED = 0;
        private byte[] mBuffer;
        private Handler mLoaderThreadHandler;
        private final Set<Long> mPhotoIds;
        private final Set<String> mPhotoIdsAsStrings;
        private final Set<Uri> mPhotoUris;
        private final List<Long> mPreloadPhotoIds;
        private int mPreloadStatus;
        private final ContentResolver mResolver;
        private final StringBuilder mStringBuilder;
        final /* synthetic */ ContactPhotoManagerImpl this$0;

        public LoaderThread(ContactPhotoManagerImpl r1, ContentResolver r2) {
            this.this$0 = r1;
            super(ContactPhotoManagerImpl.LOADER_THREAD_NAME);
            this.mStringBuilder = new StringBuilder();
            this.mPhotoIds = Sets.newHashSet();
            this.mPhotoIdsAsStrings = Sets.newHashSet();
            this.mPhotoUris = Sets.newHashSet();
            this.mPreloadPhotoIds = Lists.newArrayList();
            this.mPreloadStatus = 0;
            this.mResolver = r2;
        }

        public void ensureHandler() {
            if (this.mLoaderThreadHandler != null) goto L6;
            this.mLoaderThreadHandler = new Handler(getLooper(), this);
            return;
        }

        public void requestPreloading() {
            if (this.mPreloadStatus != 2) goto L5;
            return;
        L5:
            ensureHandler();
            if (this.mLoaderThreadHandler.hasMessages(1) == false) goto L8;
            return;
        L8:
            this.mLoaderThreadHandler.sendEmptyMessageDelayed(0, 1000);
        }

        public void requestLoading() {
            ensureHandler();
            this.mLoaderThreadHandler.removeMessages(0);
            this.mLoaderThreadHandler.sendEmptyMessage(1);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r2) {
            int r3 = r2.what;
            if (r3 == 0) goto L7;
            if (r3 != 1) goto L8;
            loadPhotosInBackground();
        L8:
            return true;
        L7:
            preloadPhotosInBackground();
            goto L8
        }

        private void preloadPhotosInBackground() {
            int r0 = this.mPreloadStatus;
            if (r0 != 2) goto L6;
            return;
        L6:
            if (r0 != 0) goto L14;
            queryPhotosForPreload();
            if (this.mPreloadPhotoIds.isEmpty() == false) goto L10;
            this.mPreloadStatus = 2;
        L11:
            requestPreloading();
            return;
        L10:
            this.mPreloadStatus = 1;
            goto L11
        L14:
            if (ContactPhotoManagerImpl.access$200(this.this$0).size() <= ContactPhotoManagerImpl.access$300(this.this$0)) goto L17;
            this.mPreloadStatus = 2;
            return;
        L17:
            this.mPhotoIds.clear();
            this.mPhotoIdsAsStrings.clear();
            int r1 = this.mPreloadPhotoIds.size();
        L18:
            if (r1 <= 0) goto L22;
            if (this.mPhotoIds.size() >= 25) goto L22;
            r1 = r1 - 1;
            Long r3 = this.mPreloadPhotoIds.get(r1);
            this.mPhotoIds.add(r3);
            this.mPhotoIdsAsStrings.add(r3.toString());
            this.mPreloadPhotoIds.remove(r1);
        L22:
            loadPhotosFromDatabase(true);
            if (r1 != 0) goto L25;
            this.mPreloadStatus = 2;
        L25:
            requestPreloading();
        }

        private void queryPhotosForPreload() {
            Cursor r0 = null;
            Uri r3 = ContactsContract.Contacts.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).appendQueryParameter("limit", String.valueOf(100)).build();     // Catch: Throwable -> L12
            r0 = this.mResolver.query(r3, new String[]{"photo_id"}, "photo_id NOT NULL AND photo_id!=0", null, "starred DESC, last_time_contacted DESC");     // Catch: Throwable -> L12
            if (r0 != null) goto L6;
        L9:
            if (r0 == null) goto L20;
            r0.close();
            return;
        L20:
            return;
        L6:
            if (r0.moveToNext() == false) goto L9;
            this.mPreloadPhotoIds.add(0, Long.valueOf(r0.getLong(0)));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (r0 == null) goto L15;
            r0.close();
        L15:
            throw th;
        }

        private void loadPhotosInBackground() {
            ContactPhotoManagerImpl.access$400(this.this$0, this.mPhotoIds, this.mPhotoIdsAsStrings, this.mPhotoUris);
            loadPhotosFromDatabase(false);
            loadRemotePhotos();
            requestPreloading();
        }

        private void loadPhotosFromDatabase(boolean r14) {
            if (this.mPhotoIds.isEmpty() == false) goto L6;
            return;
        L6:
            if (r14 == false) goto L8;
        L16:
            this.mStringBuilder.setLength(0);
            this.mStringBuilder.append("_id IN(");
            int r2 = 0;
        L18:
            if (r2 >= this.mPhotoIds.size()) goto L22;
            if (r2 == 0) goto L21;
            this.mStringBuilder.append(',');
        L21:
            this.mStringBuilder.append('?');
            r2 = r2 + 1;
            goto L18
        L22:
            this.mStringBuilder.append(')');
            this.mStringBuilder.append(" AND mimetype = \"vnd.android.cursor.item/photo\"");
            Cursor r3 = null;
            Cursor r4 = this.mResolver.query(ContactsContract.Data.CONTENT_URI, ContactPhotoManagerImpl.access$500(), this.mStringBuilder.toString(), (String[]) this.mPhotoIdsAsStrings.toArray(ContactPhotoManagerImpl.access$600()), null);     // Catch: Throwable -> L60
            if (r4 != null) goto L68;
        L36:
            if (r4 == null) goto L38;
            r4.close();
        L38:
            Iterator<Long> r5 = this.mPhotoIds.iterator();
        L40:
            if (r5.hasNext() == false) goto L58;
            Long r6 = r5.next();
            if (ContactsContract.isProfileId(r6.longValue()) == false) goto L57;
            Cursor r7 = this.mResolver.query(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r6.longValue()), ContactPhotoManagerImpl.access$500(), null, null, null);     // Catch: Throwable -> L53
            if (r7 != null) goto L70;
        L48:
            ContactPhotoManagerImpl.access$700(this.this$0, r6, null, r14);     // Catch: Throwable -> L51
        L49:
            if (r7 == null) goto L40;
            r7.close();
            goto L40
        L70:
            if (r7.moveToFirst() == false) goto L48;
            ContactPhotoManagerImpl.access$700(this.this$0, Long.valueOf(r7.getLong(0)), r7.getBlob(1), r14);     // Catch: Throwable -> L51
        L51:
            th = th;
            r3 = r7;
        L54:
            if (r3 == null) goto L56;
            r3.close();
        L56:
            throw th;
        L53:
            th = th;
            goto L54
        L57:
            ContactPhotoManagerImpl.access$700(this.this$0, r6, null, r14);
            goto L40
        L58:
            ContactPhotoManagerImpl.access$800(this.this$0).sendEmptyMessage(2);
            return;
        L68:
            if (r4.moveToNext() == false) goto L36;
            Long r8 = Long.valueOf(r4.getLong(0));     // Catch: Throwable -> L34
            byte[] r9 = r4.getBlob(1);     // Catch: Throwable -> L34
            if (r9 == null) goto L32;
            if (r9.length == 0) goto L32;
            ContactPhotoManagerImpl.access$700(this.this$0, r8, r9, r14);     // Catch: Throwable -> L34
        L32:
            this.mPhotoIds.remove(r8);     // Catch: Throwable -> L34
        L34:
            th = th;
            r3 = r4;
        L61:
            if (r3 == null) goto L63;
            r3.close();
        L63:
            throw th;
        L60:
            th = th;
            goto L61
        L8:
            if (this.mPreloadStatus != 1) goto L16;
            Iterator<Long> r10 = this.mPhotoIds.iterator();
        L11:
            if (r10.hasNext() == false) goto L14;
            this.mPreloadPhotoIds.remove(r10.next());
            goto L11
        L14:
            if (this.mPreloadPhotoIds.isEmpty() == false) goto L16;
            this.mPreloadStatus = 2;
            goto L16
        }

        private void loadRemotePhotos() {
            Iterator<Uri> r0 = this.mPhotoUris.iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            Uri r1 = r0.next();
            if (this.mBuffer != null) goto L26;
            this.mBuffer = new byte[16384];
        L26:
            InputStream r4 = this.mResolver.openInputStream(r1);     // Catch: Exception -> L22
            if (r4 != null) goto L11;
            ContactPhotoManagerImpl.access$700(this.this$0, r1, null, false);     // Catch: Exception -> L22
            goto L4
        L11:
            ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Exception -> L22
        L24:
            int r6 = r4.read(this.mBuffer);     // Catch: Throwable -> L17
            if (r6 == (-1)) goto L16;
            r5.write(this.mBuffer, 0, r6);     // Catch: Throwable -> L17
        L16:
            r4.close();     // Catch: Exception -> L22
            ContactPhotoManagerImpl.access$700(this.this$0, r1, r5.toByteArray(), false);     // Catch: Exception -> L22
            ContactPhotoManagerImpl.access$800(this.this$0).sendEmptyMessage(2);     // Catch: Exception -> L22
        L17:
            th = move-exception;
            r4.close();     // Catch: Exception -> L22
            throw th;     // Catch: Exception -> L22
        L22:
            ContactPhotoManagerImpl.access$700(this.this$0, r1, null, false);
            goto L4
        }
    }

    /* JADX INFO: compiled from: ContactPhotoManager.java */
    private static final class Request {
        private final boolean mDarkTheme;
        private final ContactPhotoManager.DefaultImageProvider mDefaultProvider;
        private final boolean mHires;
        private final long mId;
        private final Uri mUri;

        static /* synthetic */ Uri access$000(Request r0) {
            return r0.mUri;
        }

        static /* synthetic */ long access$100(Request r2) {
            return r2.mId;
        }

        private Request(long r1, Uri r3, boolean r4, boolean r5, ContactPhotoManager.DefaultImageProvider r6) {
            this.mId = r1;
            this.mUri = r3;
            this.mDarkTheme = r5;
            this.mHires = r4;
            this.mDefaultProvider = r6;
        }

        public static Request createFromId(long r8, boolean r10, boolean r11, ContactPhotoManager.DefaultImageProvider r12) {
            return new Request(r8, null, r10, r11, r12);
        }

        public static Request createFromUri(Uri r8, boolean r9, boolean r10, ContactPhotoManager.DefaultImageProvider r11) {
            return new Request(0, r8, r9, r10, r11);
        }

        public boolean isDarkTheme() {
            return this.mDarkTheme;
        }

        public boolean isHires() {
            return this.mHires;
        }

        public boolean isUriRequest() {
            if (this.mUri == null) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            Uri r0 = this.mUri;
            if (r0 != null) goto L5;
            long r1 = this.mId;
            return (int) (r1 ^ (r1 >>> 32));
        L5:
            return r0.hashCode();
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof Request) == true) goto L5;
            return false;
        L5:
            Request r8 = (Request) r7;
            if (this.mId == r8.mId) goto L8;
            return false;
        L8:
            if (UriUtils.areEqual(this.mUri, r8.mUri) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public Object getKey() {
            Uri r0 = this.mUri;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Long.valueOf(this.mId);
        }

        public void applyDefaultImage(ImageView r3) {
            this.mDefaultProvider.applyDefaultImage(r3, this.mHires, this.mDarkTheme);
        }
    }

    private void dumpStats() {
    }

    static /* synthetic */ LruCache access$200(ContactPhotoManagerImpl r0) {
        return r0.mBitmapHolderCache;
    }

    static /* synthetic */ int access$300(ContactPhotoManagerImpl r0) {
        return r0.mBitmapHolderCacheRedZoneBytes;
    }

    static /* synthetic */ void access$400(ContactPhotoManagerImpl r0, Set r1, Set r2, Set r3) {
        r0.obtainPhotoIdsAndUrisToLoad(r1, r2, r3);
    }

    static /* synthetic */ String[] access$500() {
        return COLUMNS;
    }

    static /* synthetic */ String[] access$600() {
        return EMPTY_STRING_ARRAY;
    }

    static /* synthetic */ void access$700(ContactPhotoManagerImpl r0, Object r1, byte[] r2, boolean r3) {
        r0.cacheBitmap(r1, r2, r3);
    }

    static /* synthetic */ Handler access$800(ContactPhotoManagerImpl r0) {
        return r0.mMainThreadHandler;
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
        COLUMNS = new String[]{"photo_id", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
    }

    ContactPhotoManagerImpl(Context r5) {
        this.mPendingRequests = new ConcurrentHashMap();
        this.mMainThreadHandler = new Handler(this);
        this.mStaleCacheOverwrite = new AtomicInteger();
        this.mFreshCacheOverwrite = new AtomicInteger();
        this.mContext = r5.getApplicationContext();
        if (MemoryUtils.getTotalMemorySize() < 671088640) goto L5;
        float r6 = 1.0f;
    L6:
        final int r0 = (int) (1769472.0f * r6);
        this.mBitmapCache = new AnonymousClass1(this, r0);
        final int r1 = (int) (2000000.0f * r6);
        this.mBitmapHolderCache = new AnonymousClass2(this, r1);
        this.mBitmapHolderCacheRedZoneBytes = (int) (((double) r1) * 0.75d);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("ContactPhotoManager", "Cache adj: " + r6);
        return;
    L5:
        r6 = 0.5f;
        goto L6
    }

    private static String btk(int r1) {
        return ((r1 + 1023) / 1024) + "K";
    }

    private static final int safeDiv(int r0, int r1) {
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return r0 / r1;
    }

    @Override // com.android.contacts.ContactPhotoManager, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 < 60) goto L6;
        clear();
        return;
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void preloadPhotosInBackground() {
        ensureLoaderThread();
        this.mLoaderThread.requestPreloading();
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void loadPhoto(ImageView r3, long r4, boolean r6, boolean r7, ContactPhotoManager.DefaultImageProvider r8) {
        if (r4 != 0) goto L5;
        this.mPendingRequests.remove(r3);
        return;
    L5:
        loadPhotoByIdOrUri(r3, Request.createFromId(r4, r6, r7, r8));
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void loadPhoto(ImageView r1, Uri r2, boolean r3, boolean r4, ContactPhotoManager.DefaultImageProvider r5) {
        if (r2 != null) goto L4;
        r5.applyDefaultImage(r1, r3, r4);
        this.mPendingRequests.remove(r1);
        return;
    L4:
        loadPhotoByIdOrUri(r1, Request.createFromUri(r2, r3, r4, r5));
    }

    private void loadPhotoByIdOrUri(ImageView r2, Request r3) {
        if (loadCachedPhoto(r2, r3) == false) goto L5;
        this.mPendingRequests.remove(r2);
        return;
    L5:
        this.mPendingRequests.put(r2, r3);
        if (this.mPaused == true) goto L10;
        requestLoading();
        return;
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void removePhoto(ImageView r2) {
        r2.setImageDrawable(null);
        this.mPendingRequests.remove(r2);
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void refreshCache() {
        Iterator<BitmapHolder> r2 = this.mBitmapHolderCache.snapshot().values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().fresh = false;
        goto L4
    }

    private boolean loadCachedPhoto(ImageView r4, Request r5) {
        BitmapHolder r0 = this.mBitmapHolderCache.get(r5.getKey());
        if (r0 != null) goto L7;
        r5.applyDefaultImage(r4);
        return false;
    L7:
        if (r0.bytes != null) goto L10;
        r5.applyDefaultImage(r4);
        return r0.fresh;
    L10:
        inflateBitmap(r0);
        if (r0.bitmap == null) goto L13;
        r4.setImageBitmap(NameAvatarController.getCircleBitmap(r0.bitmap, false));
        this.mBitmapCache.put(r5, r0.bitmap);
    L13:
        r0.bitmap = null;
        return r0.fresh;
    }

    private static void inflateBitmap(BitmapHolder r4) {
        byte[] r0 = r4.bytes;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length != 0) goto L8;
        return;
    L8:
        if (r4.bitmapRef == null) goto L15;
        r4.bitmap = r4.bitmapRef.get();
        if (r4.bitmap == null) goto L15;
        return;
    L15:
        Bitmap r1 = BitmapFactory.decodeByteArray(r0, 0, r0.length, null);     // Catch: OutOfMemoryError -> L14
        r4.bitmap = r1;     // Catch: OutOfMemoryError -> L14
        r4.bitmapRef = new SoftReference(r1);     // Catch: OutOfMemoryError -> L14
        return;
    }

    public void clear() {
        this.mPendingRequests.clear();
        this.mBitmapHolderCache.evictAll();
        this.mBitmapCache.evictAll();
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void pause() {
        this.mPaused = true;
    }

    @Override // com.android.contacts.ContactPhotoManager
    public void resume() {
        this.mPaused = false;
        if (this.mPendingRequests.isEmpty() == true) goto L6;
        requestLoading();
        return;
    }

    private void requestLoading() {
        if (this.mLoadingRequested == true) goto L6;
        this.mLoadingRequested = true;
        this.mMainThreadHandler.sendEmptyMessage(1);
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        int r5 = r4.what;
        if (r5 != 1) goto L5;
        this.mLoadingRequested = false;
        if (this.mPaused == true) goto L14;
        ensureLoaderThread();
        this.mLoaderThread.requestLoading();
    L14:
        return true;
    L5:
        if (r5 == 2) goto L8;
        return false;
    L8:
        if (this.mPaused == true) goto L10;
        processLoadedImages();
    L10:
        return true;
    }

    public void ensureLoaderThread() {
        if (this.mLoaderThread != null) goto L6;
        LoaderThread r0 = new LoaderThread(this, this.mContext.getContentResolver());
        this.mLoaderThread = r0;
        r0.start();
        return;
    }

    private void processLoadedImages() {
        Iterator<ImageView> r0 = this.mPendingRequests.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ImageView r1 = r0.next();
        if (loadCachedPhoto(r1, this.mPendingRequests.get(r1)) == false) goto L4;
        r0.remove();
        goto L4
    L8:
        softenCache();
        if (this.mPendingRequests.isEmpty() == true) goto L17;
        requestLoading();
        return;
    }

    private void softenCache() {
        Iterator<BitmapHolder> r2 = this.mBitmapHolderCache.snapshot().values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().bitmap = null;
        goto L4
    }

    private void cacheBitmap(Object r2, byte[] r3, boolean r4) {
        BitmapHolder r0 = new BitmapHolder(r3);
        r0.fresh = true;
        if (r4 == true) goto L5;
        inflateBitmap(r0);
    L5:
        this.mBitmapHolderCache.put(r2, r0);
    }

    private void obtainPhotoIdsAndUrisToLoad(Set<Long> r5, Set<String> r6, Set<Uri> r7) {
        r5.clear();
        r6.clear();
        r7.clear();
        Iterator<Request> r0 = this.mPendingRequests.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Request r1 = r0.next();
        BitmapHolder r2 = this.mBitmapHolderCache.get(r1);
        if (r2 == null) goto L10;
        if (r2.fresh == true) goto L4;
    L10:
        if (r1.isUriRequest() == true) goto L11;
        r5.add(Long.valueOf(Request.access$100(r1)));
        r6.add(String.valueOf(Request.access$100(r1)));
        goto L4
    L11:
        r7.add(Request.access$000(r1));
        goto L4
    }
}
