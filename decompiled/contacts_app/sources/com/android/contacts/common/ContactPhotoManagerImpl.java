package com.android.contacts.common;

import android.accounts.Account;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.GlobalProxyLancet;
import com.android.contacts.common.util.BitmapUtil;
import com.android.contacts.common.util.PermissionsUtil;
import com.android.contacts.common.util.UriUtils;
import com.android.contacts.commonbind.util.UserAgentGenerator;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ContactPhotoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ContactPhotoManagerImpl extends ContactPhotoManager implements Handler.Callback {
    private static final int BITMAP_CACHE_SIZE = 1769472;
    private static final BitmapHolder BITMAP_UNAVAILABLE = null;
    private static final String[] COLUMNS = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final int FADE_TRANSITION_DURATION = 200;
    private static final int HOLDER_CACHE_SIZE = 2000000;
    private static final String LOADER_THREAD_NAME = "ContactPhotoLoader";
    private static final int MESSAGE_PHOTOS_LOADED = 2;
    private static final int MESSAGE_REQUEST_LOADING = 1;
    private static int mThumbnailSize;
    private final LruCache<Object, Bitmap> mBitmapCache;
    private final LruCache<Object, BitmapHolder> mBitmapHolderCache;
    private volatile boolean mBitmapHolderCacheAllUnfresh;
    private final int mBitmapHolderCacheRedZoneBytes;
    private final Context mContext;
    private final AtomicInteger mFreshCacheOverwrite;
    private LoaderThread mLoaderThread;
    private boolean mLoadingRequested;
    private final Handler mMainThreadHandler;
    private boolean mPaused;
    private final ConcurrentHashMap<ImageView, Request> mPendingRequests;
    private final AtomicInteger mStaleCacheOverwrite;
    private String mUserAgent;

    /* JADX INFO: compiled from: ContactPhotoManager.java */
    private static class BitmapHolder {
        Bitmap bitmap;
        Reference<Bitmap> bitmapRef;
        final byte[] bytes;
        int decodedSampleSize;
        volatile boolean fresh;
        final int originalSmallerExtent;

        public BitmapHolder(byte[] r1, int r2) {
            this.bytes = r1;
            this.fresh = true;
            this.originalSmallerExtent = r2;
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
        private final Set<Request> mPhotoUris;
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
            int r3 = 0;
        L18:
            if (r1 <= 0) goto L22;
            if (this.mPhotoIds.size() >= 25) goto L22;
            r1 = r1 - 1;
            r3 = r3 + 1;
            Long r4 = this.mPreloadPhotoIds.get(r1);
            this.mPhotoIds.add(r4);
            this.mPhotoIdsAsStrings.add(r4.toString());
            this.mPreloadPhotoIds.remove(r1);
        L22:
            loadThumbnails(true);
            if (r1 != 0) goto L25;
            this.mPreloadStatus = 2;
        L25:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ContactPhotoManager", "Preloaded " + r3 + " photos.  Cached bytes: " + ContactPhotoManagerImpl.access$200(this.this$0).size());
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
            if (PermissionsUtil.hasPermission(ContactPhotoManagerImpl.access$400(this.this$0), PermissionsUtil.CONTACTS) == true) goto L5;
            return;
        L5:
            ContactPhotoManagerImpl.access$500(this.this$0, this.mPhotoIds, this.mPhotoIdsAsStrings, this.mPhotoUris);
            loadThumbnails(false);
            loadUriBasedPhotos();
            requestPreloading();
        }

        private void loadThumbnails(boolean r15) {
            if (this.mPhotoIds.isEmpty() == false) goto L6;
            return;
        L6:
            if (r15 == false) goto L8;
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
            Cursor r3 = null;
            Cursor r4 = this.mResolver.query(ContactsContract.Data.CONTENT_URI, ContactPhotoManagerImpl.access$600(), this.mStringBuilder.toString(), (String[]) this.mPhotoIdsAsStrings.toArray(ContactPhotoManagerImpl.access$700()), null);     // Catch: Throwable -> L56
            if (r4 != null) goto L60;
        L32:
            if (r4 == null) goto L34;
            r4.close();
        L34:
            Iterator<Long> r5 = this.mPhotoIds.iterator();
        L36:
            if (r5.hasNext() == false) goto L54;
            Long r6 = r5.next();
            if (ContactsContract.isProfileId(r6.longValue()) == false) goto L53;
            Cursor r7 = this.mResolver.query(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r6.longValue()), ContactPhotoManagerImpl.access$600(), null, null, null);     // Catch: Throwable -> L49
            if (r7 != null) goto L62;
        L44:
            ContactPhotoManagerImpl.access$800(this.this$0, r6, null, r15, -1);     // Catch: Throwable -> L47
        L45:
            if (r7 == null) goto L36;
            r7.close();
            goto L36
        L62:
            if (r7.moveToFirst() == false) goto L44;
            ContactPhotoManagerImpl.access$800(this.this$0, Long.valueOf(r7.getLong(0)), r7.getBlob(1), r15, -1);     // Catch: Throwable -> L47
        L47:
            th = th;
            r3 = r7;
        L50:
            if (r3 == null) goto L52;
            r3.close();
        L52:
            throw th;
        L49:
            th = th;
            goto L50
        L53:
            ContactPhotoManagerImpl.access$800(this.this$0, r6, null, r15, -1);
            goto L36
        L54:
            ContactPhotoManagerImpl.access$900(this.this$0).sendEmptyMessage(2);
            return;
        L60:
        L30:
            th = th;
            r3 = r4;
        L57:
            if (r3 == null) goto L59;
            r3.close();
        L59:
            throw th;
        L27:
            if (r4.moveToNext() == false) goto L32;
            Long r8 = Long.valueOf(r4.getLong(0));     // Catch: Throwable -> L30
            ContactPhotoManagerImpl.access$800(this.this$0, r8, r4.getBlob(1), r15, -1);     // Catch: Throwable -> L30
            this.mPhotoIds.remove(r8);     // Catch: Throwable -> L30
        L56:
            th = th;
            goto L57
        L8:
            if (this.mPreloadStatus != 1) goto L16;
            Iterator<Long> r9 = this.mPhotoIds.iterator();
        L11:
            if (r9.hasNext() == false) goto L14;
            this.mPreloadPhotoIds.remove(r9.next());
            goto L11
        L14:
            if (this.mPreloadPhotoIds.isEmpty() == false) goto L16;
            this.mPreloadStatus = 2;
            goto L16
        }

        private void loadUriBasedPhotos() {
            Iterator<Request> r2 = this.mPhotoUris.iterator();
        L4:
            if (r2.hasNext() == false) goto L36;
            Request r3 = r2.next();
            Uri r4 = r3.getUri();
            Uri r5 = ContactPhotoManager.removeContactType(r4);
            if (this.mBuffer != null) goto L39;
            this.mBuffer = new byte[16384];
        L39:
            String r8 = r5.getScheme();     // Catch: Throwable -> L34
            if (r8.equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L12;
        L15:
            TrafficStats.setThreadStatsTag(1);     // Catch: Throwable -> L34
            HttpURLConnection r9 = (HttpURLConnection) new URL(r5.toString()).openConnection();     // Catch: Throwable -> L34
            if (TextUtils.isEmpty(ContactPhotoManagerImpl.access$1000(this.this$0)) == true) goto L37;
            r9.setRequestProperty("User-Agent", ContactPhotoManagerImpl.access$1000(this.this$0));     // Catch: Throwable -> L34
        L37:
            InputStream r10 = r9.getInputStream();     // Catch: IOException -> L20 Throwable -> L34 Throwable -> L34
        L21:
            TrafficStats.clearThreadStatsTag();     // Catch: Throwable -> L34 Throwable -> L34
        L22:
            if (r10 != null) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ContactPhotoManager", "Cannot load photo " + r5);     // Catch: Throwable -> L34 Throwable -> L34
            ContactPhotoManagerImpl.access$800(this.this$0, r4, null, false, r3.getRequestedExtent());     // Catch: Throwable -> L34 Throwable -> L34
            goto L4
        L23:
            ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L34 Throwable -> L34
        L41:
            int r12 = r10.read(this.mBuffer);     // Catch: Throwable -> L29
            if (r12 == (-1)) goto L28;
            r11.write(this.mBuffer, 0, r12);     // Catch: Throwable -> L29
            goto L41
        L28:
            r10.close();     // Catch: Throwable -> L34 Throwable -> L34
            ContactPhotoManagerImpl.access$800(this.this$0, r4, r11.toByteArray(), false, r3.getRequestedExtent());     // Catch: Throwable -> L34 Throwable -> L34
            ContactPhotoManagerImpl.access$900(this.this$0).sendEmptyMessage(2);     // Catch: Throwable -> L34 Throwable -> L34
        L29:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L34 Throwable -> L34
            throw th;     // Catch: Throwable -> L34 Throwable -> L34
        L20:
            r9.disconnect();     // Catch: Throwable -> L34 Throwable -> L34
            r10 = null;
            goto L21
        L12:
            if (r8.equals("https") == true) goto L15;
            r10 = this.mResolver.openInputStream(r5);     // Catch: Throwable -> L34
        L34:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ContactPhotoManager", "Cannot load photo " + r5, e);
            ContactPhotoManagerImpl.access$800(this.this$0, r4, null, false, r3.getRequestedExtent());
            goto L4
        }
    }

    /* JADX INFO: compiled from: ContactPhotoManager.java */
    private static final class Request {
        private final boolean mDarkTheme;
        private final ContactPhotoManager.DefaultImageProvider mDefaultProvider;
        private final long mId;
        private final boolean mIsCircular;
        private final int mRequestedExtent;
        private final Uri mUri;

        static /* synthetic */ boolean access$000(Request r0) {
            return r0.mIsCircular;
        }

        static /* synthetic */ long access$100(Request r2) {
            return r2.mId;
        }

        private Request(long r1, Uri r3, int r4, boolean r5, boolean r6, ContactPhotoManager.DefaultImageProvider r7) {
            this.mId = r1;
            this.mUri = r3;
            this.mDarkTheme = r5;
            this.mIsCircular = r6;
            this.mRequestedExtent = r4;
            this.mDefaultProvider = r7;
        }

        public static Request createFromThumbnailId(long r9, boolean r11, boolean r12, ContactPhotoManager.DefaultImageProvider r13) {
            return new Request(r9, null, -1, r11, r12, r13);
        }

        public static Request createFromUri(Uri r9, int r10, boolean r11, boolean r12, ContactPhotoManager.DefaultImageProvider r13) {
            return new Request(0, r9, r10, r11, r12, r13);
        }

        public boolean isUriRequest() {
            if (this.mUri == null) goto L5;
            return true;
        L5:
            return false;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public long getId() {
            return this.mId;
        }

        public int getRequestedExtent() {
            return this.mRequestedExtent;
        }

        public int hashCode() {
            long r0 = this.mId;
            int r1 = (((((int) (r0 ^ (r0 >>> 32))) + 31) * 31) + this.mRequestedExtent) * 31;
            Uri r4 = this.mUri;
            if (r4 != null) goto L5;
            int r5 = 0;
        L7:
            return r1 + r5;
        L5:
            r5 = r4.hashCode();
            goto L7
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (r7 != null) goto L9;
            return false;
        L9:
            if (getClass() == r7.getClass()) goto L11;
            return false;
        L11:
            Request r8 = (Request) r7;
            if (this.mId == r8.mId) goto L15;
            return false;
        L15:
            if (this.mRequestedExtent == r8.mRequestedExtent) goto L18;
            return false;
        L18:
            if (UriUtils.areEqual(this.mUri, r8.mUri) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public Object getKey() {
            Uri r0 = this.mUri;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Long.valueOf(this.mId);
        }

        public void applyDefaultImage(ImageView r3, boolean r4) {
            if (r4 == false) goto L8;
            if (ContactPhotoManager.isBusinessContactUri(this.mUri) == false) goto L6;
            ContactPhotoManager.DefaultImageRequest r5 = ContactPhotoManager.DefaultImageRequest.EMPTY_CIRCULAR_BUSINESS_IMAGE_REQUEST;
        L11:
            this.mDefaultProvider.applyDefaultImage(r3, this.mRequestedExtent, this.mDarkTheme, r5);
            return;
        L6:
            r5 = ContactPhotoManager.DefaultImageRequest.EMPTY_CIRCULAR_DEFAULT_IMAGE_REQUEST;
            goto L11
        L8:
            if (ContactPhotoManager.isBusinessContactUri(this.mUri) == false) goto L10;
            r5 = ContactPhotoManager.DefaultImageRequest.EMPTY_DEFAULT_BUSINESS_IMAGE_REQUEST;
            goto L11
        L10:
            r5 = ContactPhotoManager.DefaultImageRequest.EMPTY_DEFAULT_IMAGE_REQUEST;
            goto L11
        }
    }

    private void dumpStats() {
    }

    static /* synthetic */ String access$1000(ContactPhotoManagerImpl r0) {
        return r0.mUserAgent;
    }

    static /* synthetic */ LruCache access$200(ContactPhotoManagerImpl r0) {
        return r0.mBitmapHolderCache;
    }

    static /* synthetic */ int access$300(ContactPhotoManagerImpl r0) {
        return r0.mBitmapHolderCacheRedZoneBytes;
    }

    static /* synthetic */ Context access$400(ContactPhotoManagerImpl r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$500(ContactPhotoManagerImpl r0, Set r1, Set r2, Set r3) {
        r0.obtainPhotoIdsAndUrisToLoad(r1, r2, r3);
    }

    static /* synthetic */ String[] access$600() {
        return COLUMNS;
    }

    static /* synthetic */ String[] access$700() {
        return EMPTY_STRING_ARRAY;
    }

    static /* synthetic */ void access$800(ContactPhotoManagerImpl r0, Object r1, byte[] r2, boolean r3, int r4) {
        r0.cacheBitmap(r1, r2, r3, r4);
    }

    static /* synthetic */ Handler access$900(ContactPhotoManagerImpl r0) {
        return r0.mMainThreadHandler;
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
        COLUMNS = new String[]{"_id", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
        BitmapHolder r1 = new BitmapHolder(new byte[0], 0);
        BITMAP_UNAVAILABLE = r1;
        r1.bitmapRef = new SoftReference(null);
    }

    public ContactPhotoManagerImpl(Context r6) {
        this.mBitmapHolderCacheAllUnfresh = true;
        this.mPendingRequests = new ConcurrentHashMap();
        this.mMainThreadHandler = new Handler(this);
        this.mStaleCacheOverwrite = new AtomicInteger();
        this.mFreshCacheOverwrite = new AtomicInteger();
        this.mContext = r6;
        if (((ActivityManager) r6.getSystemService("activity")).isLowRamDevice() == false) goto L5;
        float r0 = 0.5f;
    L6:
        final int r1 = (int) (1769472.0f * r0);
        this.mBitmapCache = new AnonymousClass1(this, r1);
        final int r2 = (int) (2000000.0f * r0);
        this.mBitmapHolderCache = new AnonymousClass2(this, r2);
        this.mBitmapHolderCacheRedZoneBytes = (int) (((double) r2) * 0.75d);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("ContactPhotoManager", "Cache adj: " + r0);
        mThumbnailSize = r6.getResources().getDimensionPixelSize(R.dimen.contact_browser_list_item_photo_size);
        String r7 = UserAgentGenerator.getUserAgent(r6);
        this.mUserAgent = r7;
        if (r7 != null) goto L10;
        this.mUserAgent = "";
        return;
    L10:
        return;
    L5:
        r0 = 1.0f;
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

    @Override // com.android.contacts.common.ContactPhotoManager, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 < 60) goto L6;
        clear();
        return;
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void preloadPhotosInBackground() {
        ensureLoaderThread();
        this.mLoaderThread.requestPreloading();
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void loadThumbnail(ImageView r8, long r9, Account r11, boolean r12, boolean r13, ContactPhotoManager.DefaultImageRequest r14, ContactPhotoManager.DefaultImageProvider r15) {
        if (r9 != 0) goto L5;
        r15.applyDefaultImage(r8, r11, -1, r12, r14);
        this.mPendingRequests.remove(r8);
        return;
    L5:
        loadPhotoByIdOrUri(r8, Request.createFromThumbnailId(r9, r12, r13, r15));
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void loadPhoto(ImageView r9, Uri r10, Account r11, int r12, boolean r13, boolean r14, ContactPhotoManager.DefaultImageRequest r15, ContactPhotoManager.DefaultImageProvider r16) {
        if (r10 != null) goto L6;
        r16.applyDefaultImage(r9, r11, r12, r13, r15);
        this.mPendingRequests.remove(r9);
        return;
    L6:
        if (isDefaultImageUri(r10) == false) goto L8;
        createAndApplyDefaultImageForUri(r9, r11, r10, r12, r13, r14, r16);
        return;
    L8:
        loadPhotoByIdOrUri(r9, Request.createFromUri(r10, r12, r13, r14, r16));
    }

    private void createAndApplyDefaultImageForUri(ImageView r7, Account r8, Uri r9, int r10, boolean r11, boolean r12, ContactPhotoManager.DefaultImageProvider r13) {
        ContactPhotoManager.DefaultImageRequest r5 = getDefaultImageRequestFromUri(r9);
        r5.isCircular = r12;
        r13.applyDefaultImage(r7, r8, r10, r11, r5);
    }

    private void loadPhotoByIdOrUri(ImageView r2, Request r3) {
        if (loadCachedPhoto(r2, r3, false) == false) goto L5;
        this.mPendingRequests.remove(r2);
        return;
    L5:
        this.mPendingRequests.put(r2, r3);
        if (this.mPaused == true) goto L10;
        requestLoading();
        return;
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void removePhoto(ImageView r2) {
        r2.setImageDrawable(null);
        this.mPendingRequests.remove(r2);
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void cancelPendingRequests(View r3) {
        if (r3 != null) goto L5;
        this.mPendingRequests.clear();
        return;
    L5:
        Iterator<Map.Entry<ImageView, Request>> r2 = this.mPendingRequests.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        ImageView r0 = r2.next().getKey();
        if (r0.getParent() == null) goto L12;
        if (isChildView(r3, r0) == false) goto L7;
    L12:
        r2.remove();
        goto L7
    }

    private static boolean isChildView(View r1, View r2) {
        if (r2.getParent() != null) goto L5;
    L11:
        return false;
    L5:
        if (r2.getParent() != r1) goto L7;
    L10:
        return true;
    L7:
        if ((r2.getParent() instanceof ViewGroup) == false) goto L11;
        if (isChildView(r1, (ViewGroup) r2.getParent()) == false) goto L11;
        goto L10
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void refreshCache() {
        if (this.mBitmapHolderCacheAllUnfresh == false) goto L5;
        return;
    L5:
        this.mBitmapHolderCacheAllUnfresh = true;
        Iterator<BitmapHolder> r2 = this.mBitmapHolderCache.snapshot().values().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        BitmapHolder r0 = r2.next();
        if (r0 == BITMAP_UNAVAILABLE) goto L7;
        r0.fresh = false;
        goto L7
    }

    private boolean loadCachedPhoto(ImageView r8, Request r9, boolean r10) {
        BitmapHolder r0 = this.mBitmapHolderCache.get(r9.getKey());
        if (r0 != null) goto L7;
        r9.applyDefaultImage(r8, Request.access$000(r9));
        return false;
    L7:
        if (r0.bytes != null) goto L11;
        r9.applyDefaultImage(r8, Request.access$000(r9));
        return r0.fresh;
    L11:
        if (r0.bitmapRef != null) goto L13;
        Bitmap r2 = null;
    L14:
        if (r2 == null) goto L16;
    L22:
        Drawable r4 = r8.getDrawable();
        if (r10 == false) goto L30;
        if (r4 == null) goto L30;
        Drawable[] r11 = new Drawable[2];
        if ((r4 instanceof TransitionDrawable) == false) goto L28;
        TransitionDrawable r5 = (TransitionDrawable) r4;
        r11[0] = r5.getDrawable(r5.getNumberOfLayers() - 1);
    L29:
        r11[1] = getDrawableForBitmap(this.mContext.getResources(), r2, r9);
        TransitionDrawable r1 = new TransitionDrawable(r11);
        r8.setImageDrawable(r1);
        r1.startTransition(200);
    L32:
        if (r2.getByteCount() >= (this.mBitmapCache.maxSize() / 6)) goto L34;
        this.mBitmapCache.put(r9.getKey(), r2);
    L34:
        r0.bitmap = null;
        return r0.fresh;
    L28:
        r11[0] = r4;
    L30:
        r8.setImageDrawable(getDrawableForBitmap(this.mContext.getResources(), r2, r9));
        goto L32
    L16:
        if (r0.bytes.length >= 8192) goto L20;
        inflateBitmap(r0, r9.getRequestedExtent());
        r2 = r0.bitmap;
        if (r2 != null) goto L22;
        return false;
    L20:
        r9.applyDefaultImage(r8, Request.access$000(r9));
        return false;
    L13:
        r2 = r0.bitmapRef.get();
        goto L14
    }

    private Drawable getDrawableForBitmap(Resources r1, Bitmap r2, Request r3) {
        if (Request.access$000(r3) == false) goto L7;
        RoundedBitmapDrawable r0 = RoundedBitmapDrawableFactory.create(r1, r2);
        r0.setAntiAlias(true);
        r0.setCornerRadius(r2.getHeight() / 2);
        return r0;
    L7:
        return new BitmapDrawable(r1, r2);
    }

    private static void inflateBitmap(BitmapHolder r5, int r6) {
        int r7 = BitmapUtil.findOptimalSampleSize(r5.originalSmallerExtent, r6);
        byte[] r0 = r5.bytes;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length != 0) goto L8;
        return;
    L8:
        if (r7 == r5.decodedSampleSize) goto L10;
    L25:
        Bitmap r1 = BitmapUtil.decodeBitmapFromBytes(r0, r7);     // Catch: OutOfMemoryError -> L24
        if (r1 != null) goto L17;
        return;
    L17:
        int r2 = r1.getHeight();     // Catch: OutOfMemoryError -> L24
        int r3 = r1.getWidth();     // Catch: OutOfMemoryError -> L24
        if (r2 != r3) goto L20;
    L22:
        r5.decodedSampleSize = r7;     // Catch: OutOfMemoryError -> L24
        r5.bitmap = r1;     // Catch: OutOfMemoryError -> L24
        r5.bitmapRef = new SoftReference(r1);     // Catch: OutOfMemoryError -> L24
        return;
    L20:
        if (Math.min(r2, r3) > (mThumbnailSize * 2)) goto L22;
        int r4 = Math.min(r2, r3);     // Catch: OutOfMemoryError -> L24
        r1 = ThumbnailUtils.extractThumbnail(r1, r4, r4);     // Catch: OutOfMemoryError -> L24
    L29:
        return;
    L10:
        if (r5.bitmapRef == null) goto L25;
        r5.bitmap = r5.bitmapRef.get();
        if (r5.bitmap == null) goto L25;
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void clear() {
        this.mPendingRequests.clear();
        this.mBitmapHolderCache.evictAll();
        this.mBitmapCache.evictAll();
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void pause() {
        this.mPaused = true;
    }

    @Override // com.android.contacts.common.ContactPhotoManager
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
        Iterator<Map.Entry<ImageView, Request>> r0 = this.mPendingRequests.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<ImageView, Request> r1 = r0.next();
        if (loadCachedPhoto(r1.getKey(), r1.getValue(), false) == false) goto L4;
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

    private void cacheBitmap(Object r3, byte[] r4, boolean r5, int r6) {
        if (r4 != null) goto L5;
        int r1 = -1;
    L6:
        BitmapHolder r0 = new BitmapHolder(r4, r1);
        if (r5 == true) goto L9;
        inflateBitmap(r0, r6);
    L9:
        if (r4 == null) goto L13;
        this.mBitmapHolderCache.put(r3, r0);
        if (this.mBitmapHolderCache.get(r3) == r0) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("ContactPhotoManager", "Bitmap too big to fit in cache.");
        this.mBitmapHolderCache.put(r3, BITMAP_UNAVAILABLE);
    L14:
        this.mBitmapHolderCacheAllUnfresh = false;
        return;
    L13:
        this.mBitmapHolderCache.put(r3, BITMAP_UNAVAILABLE);
        goto L14
    L5:
        r1 = BitmapUtil.getSmallerExtentFromBytes(r4);
        goto L6
    }

    @Override // com.android.contacts.common.ContactPhotoManager
    public void cacheBitmap(Uri r4, Bitmap r5, byte[] r6) {
        int r0 = Math.min(r5.getWidth(), r5.getHeight());
        Request r7 = Request.createFromUri(r4, r0, false, false, DEFAULT_AVATAR);
        BitmapHolder r1 = new BitmapHolder(r6, r0);
        r1.bitmapRef = new SoftReference(r5);
        this.mBitmapHolderCache.put(r7.getKey(), r1);
        this.mBitmapHolderCacheAllUnfresh = false;
        this.mBitmapCache.put(r7.getKey(), r5);
    }

    private void obtainPhotoIdsAndUrisToLoad(Set<Long> r6, Set<String> r7, Set<Request> r8) {
        r6.clear();
        r7.clear();
        r8.clear();
        Iterator<Request> r0 = this.mPendingRequests.values().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L25;
        Request r2 = r0.next();
        BitmapHolder r3 = this.mBitmapHolderCache.get(r2.getKey());
        if (r3 == BITMAP_UNAVAILABLE) goto L4;
        if (r3 == null) goto L18;
        if (r3.bytes == null) goto L18;
        if (r3.fresh == false) goto L18;
        if (r3.bitmapRef == null) goto L17;
        if (r3.bitmapRef.get() != null) goto L18;
    L17:
        inflateBitmap(r3, r2.getRequestedExtent());
        r1 = true;
    L18:
        if (r3 == null) goto L22;
        if (r3.fresh == true) goto L4;
    L22:
        if (r2.isUriRequest() == true) goto L23;
        r6.add(Long.valueOf(r2.getId()));
        r7.add(String.valueOf(Request.access$100(r2)));
        goto L4
    L23:
        r8.add(r2);
        goto L4
    L25:
        if (r1 == false) goto L46;
        this.mMainThreadHandler.sendEmptyMessage(2);
        return;
    }
}
