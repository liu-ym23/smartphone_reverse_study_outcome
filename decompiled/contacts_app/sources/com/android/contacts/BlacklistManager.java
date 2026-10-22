package com.android.contacts;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.HanziToPinyin;
import com.google.android.collect.Sets;
import com.obric.appintents.IntentsUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BlacklistManager implements ComponentCallbacks2, Handler.Callback {
    private static final int BLACKLIST_CACHE_ADD_NUMBER = 100;
    private static final int BLACKLIST_IN = 1;
    private static final int BLACKLIST_MAX_CACHE_SIZE = 500;
    private static final int BLACKLIST_OUT = 2;
    private static final int BLACKLIST_UNKNOWN = 0;
    private static final Uri BLACK_LIST_NUMBER_URI = null;
    private static final boolean DEBUG = false;
    private static final int MESSAGE_REQUEST_LOADED = 2;
    private static final int MESSAGE_REQUEST_LOADING = 1;
    private static final int MESSAGE_REQUEST_QUERY_BLACKLISTS = 3;
    private static final int MESSAGE_REQUEST_QUERY_BLACKLISTS_COMPLETED = 4;
    private static final Uri QUERY_BLACKLISTS_URI = null;
    private static final Uri QUERY_BLACK_NUMBER_URI = null;
    private static final String TAG = "BlacklistManager";
    private static BlacklistManager sBlacklistManager;
    private BlacklistChangeObserver mBlacklistChangeObserver;
    private final HashSet<OnBlacklistChangeListener> mBlacklistChangedListeners;
    private Set<String> mBlacklistNumbersSet;
    private LruCache<Long, Integer> mContactBlacklistCache;
    private Map<Long, Integer> mContactBlacklistCacheSnapshot;
    private ConcurrentHashMap<ImageView, Long> mContactPendingRequest;
    private Context mContext;
    private LoaderThread mLoaderThread;
    private Handler mMainHandler;
    private boolean mPaused;
    private ConcurrentHashMap<ImageView, String> mPendingRequest;

    class BlacklistChangeObserver extends ContentObserver {
        final /* synthetic */ BlacklistManager this$0;

        public BlacklistChangeObserver(BlacklistManager r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            BlacklistManager.access$100("receive onChange");
            this.this$0.requestQueryBlackLists();
            BlacklistManager.access$200(this.this$0);
        }
    }

    private class LoaderThread extends HandlerThread implements Handler.Callback {
        public static final int MESSAGE_LOAD_BLACKLISTS = 2;
        public static final int MESSAGE_LOAD_PENDING = 1;
        private Handler mLoaderThreadHandler;
        private boolean mLoadingBlackList;
        private ContentResolver mResolver;
        final /* synthetic */ BlacklistManager this$0;

        static /* synthetic */ boolean access$000(LoaderThread r0) {
            return r0.mLoadingBlackList;
        }

        public LoaderThread(BlacklistManager r1, ContentResolver r2) {
            this.this$0 = r1;
            super("blacklistLoaderThread");
            this.mLoadingBlackList = false;
            this.mResolver = r2;
        }

        private void ensureHandler() {
            if (this.mLoaderThreadHandler != null) goto L6;
            this.mLoaderThreadHandler = new Handler(getLooper(), this);
            return;
        }

        public void request(int r1) {
            ensureHandler();
            this.mLoaderThreadHandler.sendEmptyMessage(r1);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r3) {
            int r4 = r3.what;
            if (r4 != 1) goto L5;
            loadInBackground();
            return true;
        L5:
            if (r4 == 2) goto L8;
            return false;
        L8:
            queryBlacklists();
            return true;
        }

        private void loadInBackground() {
            loadContactsInBackground();
            BlacklistManager.access$300(this.this$0).sendEmptyMessage(2);
        }

        private void loadContactsInBackground() {
            queryBlacklists();
            Collection r0 = BlacklistManager.access$400(this.this$0).values();
            BlacklistManager.access$500(this.this$0, r0.size());
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L26;
            long r2 = ((Long) r1.next()).longValue();
            if (BlacklistManager.access$600(this.this$0) == true) goto L35;
            if (IntentsUtilsKt.isProfileContacts(BlacklistManager.access$700(this.this$0), r2) == false) goto L11;
            Cursor r3 = BlacklistManager.access$700(this.this$0).getContentResolver().query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[]{"data1"}, "name_raw_contact_id = " + r2, null, null);
        L12:
            if (r3 == null) goto L24;
            ArrayList r4 = new ArrayList();
        L21:
            th = move-exception;
            r3.close();
            throw th;
        L15:
            if (r3.moveToFirst() == false) goto L18;
        L16:
            r4.add(r3.getString(0));     // Catch: Throwable -> L21
            if (r3.moveToNext() == true) goto L16;
        L18:
            r3.close();
            if (BlacklistManager.access$800(this.this$0, r4) == false) goto L24;
            int r5 = 1;
        L25:
            BlacklistManager.access$900(this.this$0).put(Long.valueOf(r2), Integer.valueOf(r5));
        L24:
            r5 = 2;
            goto L25
        L11:
            r3 = BlacklistManager.access$700(this.this$0).getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0)).appendQueryParameter("remove_duplicate_entries", "true").build(), new String[]{"data1"}, "contact_id = " + r2, null, null);
            goto L12
        L35:
            return;
        }

        private void queryBlacklists() {
            boolean r0 = true;
            this.mLoadingBlackList = true;
            if (BlacklistManager.access$1000(this.this$0) != null) goto L5;
            BlacklistManager.access$1002(this.this$0, new HashSet());
        L6:
            Cursor r1 = this.mResolver.query(BlacklistManager.access$1100(), null, null, null, null);
            if (r1 == null) goto L22;
            int r3 = r1.getColumnIndex(BlackListQueryHandler.COLUMN_NUMBER);
        L19:
            th = move-exception;
            r1.close();
            throw th;
        L10:
            if (r1.moveToFirst() == false) goto L18;
        L11:
            String r4 = r1.getString(r3);     // Catch: Throwable -> L19
            BlacklistManager.access$1000(this.this$0).add(r4);     // Catch: Throwable -> L19
            if (TextUtils.isEmpty(r4) == true) goto L17;
            if (r4.startsWith("+86") == false) goto L17;
            BlacklistManager.access$1000(this.this$0).add(r4.substring(3));     // Catch: Throwable -> L19
        L17:
            if (r1.moveToNext() == true) goto L11;
        L18:
            r1.close();
        L22:
            if (r0 == true) goto L24;
        L26:
            this.mLoadingBlackList = false;
            return;
        L24:
            if (BlacklistManager.access$1200(this.this$0).isEmpty() == true) goto L26;
            BlacklistManager.access$300(this.this$0).sendEmptyMessage(4);
            goto L26
        L5:
            BlacklistManager.access$1000(this.this$0).clear();
            r0 = false;
            goto L6
        }
    }

    public interface OnBlacklistChangeListener {
        void onBlacklistChanged();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    static /* synthetic */ void access$100(String r0) {
        log(r0);
    }

    static /* synthetic */ Set access$1000(BlacklistManager r0) {
        return r0.mBlacklistNumbersSet;
    }

    static /* synthetic */ Set access$1002(BlacklistManager r0, Set r1) {
        r0.mBlacklistNumbersSet = r1;
        return r1;
    }

    static /* synthetic */ Uri access$1100() {
        return QUERY_BLACKLISTS_URI;
    }

    static /* synthetic */ ConcurrentHashMap access$1200(BlacklistManager r0) {
        return r0.mPendingRequest;
    }

    static /* synthetic */ void access$200(BlacklistManager r0) {
        r0.sendBlacklistChangeNotification();
    }

    static /* synthetic */ Handler access$300(BlacklistManager r0) {
        return r0.mMainHandler;
    }

    static /* synthetic */ ConcurrentHashMap access$400(BlacklistManager r0) {
        return r0.mContactPendingRequest;
    }

    static /* synthetic */ void access$500(BlacklistManager r0, int r1) {
        r0.ensureContactCacheCapacity(r1);
    }

    static /* synthetic */ boolean access$600(BlacklistManager r0) {
        return r0.mPaused;
    }

    static /* synthetic */ Context access$700(BlacklistManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$800(BlacklistManager r0, List r1) {
        return r0.isBlacklistMarked(r1);
    }

    static /* synthetic */ LruCache access$900(BlacklistManager r0) {
        return r0.mContactBlacklistCache;
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
        QUERY_BLACKLISTS_URI = Uri.parse("content://com.obric.nodisturb.provider/blacklist");
        BLACK_LIST_NUMBER_URI = Uri.parse("content://com.obric.nodisturb.provider/blacknumber");
        QUERY_BLACK_NUMBER_URI = Uri.parse("content://com.obric.nodisturb.provider/inblacklist");
    }

    public static synchronized BlacklistManager getInstances(Context r2) {
        monitor-enter(BlacklistManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sBlacklistManager != null) goto L7;
        BlacklistManager r1 = new BlacklistManager(r2);     // Catch: Throwable -> L10
        sBlacklistManager = r1;     // Catch: Throwable -> L10
        r1.requestQueryBlackLists();     // Catch: Throwable -> L10
    L7:
        BlacklistManager r3 = sBlacklistManager;     // Catch: Throwable -> L10
        monitor-exit(BlacklistManager.class);
        return r3;
    }

    private BlacklistManager(Context r4) {
        this.mBlacklistChangedListeners = Sets.newHashSet();
        this.mPendingRequest = new ConcurrentHashMap();
        this.mBlacklistNumbersSet = null;
        this.mContactBlacklistCache = new LruCache(500);
        this.mContactBlacklistCacheSnapshot = null;
        this.mContactPendingRequest = new ConcurrentHashMap();
        this.mPaused = false;
        this.mMainHandler = new Handler(Looper.getMainLooper(), this);
        this.mContext = r4.getApplicationContext();
        this.mBlacklistChangeObserver = new BlacklistChangeObserver(this, new Handler(Looper.getMainLooper()));
        this.mContext.getContentResolver().registerContentObserver(BLACK_LIST_NUMBER_URI, true, this.mBlacklistChangeObserver);     // Catch: Throwable -> L5
        return;
    }

    public void addOnBlacklistChangeListener(OnBlacklistChangeListener r2) {
        HashSet<OnBlacklistChangeListener> r0 = this.mBlacklistChangedListeners;
        monitor-enter(r0);
        this.mBlacklistChangedListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeOnBlacklistChangeListener(OnBlacklistChangeListener r2) {
        HashSet<OnBlacklistChangeListener> r0 = this.mBlacklistChangedListeners;
        monitor-enter(r0);
        this.mBlacklistChangedListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void sendBlacklistChangeNotification() {
        HashSet<OnBlacklistChangeListener> r0 = this.mBlacklistChangedListeners;
        monitor-enter(r0);
        Iterator<OnBlacklistChangeListener> r2 = this.mBlacklistChangedListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onBlacklistChanged();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void loadBlacklist(ImageView r1, String r2) {
        if (isBlacklistMarked(r1, r2) == false) goto L5;
        r1.setVisibility(0);
        return;
    L5:
        r1.setVisibility(8);
    }

    public void loadBlacklist(ImageView r7, long r8) {
        int r0 = getFromContactCache(r8);
        if (r0 == 0) goto L10;
        if (r0 != 1) goto L6;
        r7.setVisibility(0);
        return;
    L6:
        if (r0 != 2) goto L24;
        r7.setVisibility(8);
        return;
    L24:
        return;
    L10:
        Map<Long, Integer> r1 = this.mContactBlacklistCacheSnapshot;
        if (r1 != null) goto L14;
        r7.setVisibility(8);
    L17:
        this.mContactPendingRequest.put(r7, Long.valueOf(r8));
        if (this.mPaused == true) goto L23;
        requestLoading();
        return;
    L23:
        return;
    L14:
        if (r1.getOrDefault(Long.valueOf(r8), 0).intValue() != 1) goto L16;
        r7.setVisibility(0);
        goto L17
    L16:
        r7.setVisibility(8);
        goto L17
    }

    public void resume() {
        this.mPaused = false;
        if (this.mContactPendingRequest.isEmpty() == true) goto L6;
        requestLoading();
        return;
    }

    public void pause() {
        this.mPaused = true;
    }

    public void clearCache() {
        this.mContactBlacklistCacheSnapshot = this.mContactBlacklistCache.snapshot();
        this.mContactBlacklistCache.evictAll();
        this.mContactBlacklistCache.resize(500);
    }

    private void ensureContactCacheCapacity(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        int r0 = this.mContactBlacklistCache.size();
        int r1 = this.mContactBlacklistCache.maxSize();
        int r2 = r0 + r3;
        if (r2 > r1) goto L7;
        return;
    L7:
        int r4 = r2 + 100;
        if (r4 >= 500) goto L10;
        r4 = 500;
    L10:
        if (r4 <= r1) goto L13;
        this.mContactBlacklistCache.resize(r4);
        return;
    }

    public boolean isInBlackList(ContentResolver r4, Long r5, String r6) {
        Integer r0 = this.mContactBlacklistCache.get(r5);
        int r1 = 1;
        if (r0 != null) goto L5;
    L11:
        boolean r7 = isInBlackList(r4, r6);
        ensureContactCacheCapacity(1);
        LruCache<Long, Integer> r3 = this.mContactBlacklistCache;
        if (r7 == true) goto L15;
        r1 = 2;
    L15:
        r3.put(r5, Integer.valueOf(r1));
        return r7;
    L5:
        if (r0.intValue() == 0) goto L11;
        if (r0.intValue() == 1) goto L17;
        return false;
    L17:
        return true;
    }

    public boolean isInBlackList(ContentResolver r11, String r12) {
        boolean r2 = false;
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return false;
    L5:
        String r1 = r12.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        if (r1.startsWith("+86") == false) goto L8;
        r1 = r1.substring(3);
    L8:
        LoaderThread r3 = this.mLoaderThread;
        if (r3 != null) goto L11;
    L15:
        Cursor r10 = null;
        r10 = r11.query(Uri.withAppendedPath(QUERY_BLACK_NUMBER_URI, r1), null, null, null, null);     // Catch: Throwable -> L23 Exception -> L25
        if (r10 == null) goto L21;
        if (r10.moveToFirst() == false) goto L21;
        r2 = true;
        goto L21
    L21:
        MoreCloseables.closeQuietly(r10);
        return r2;
    L23:
        th = move-exception;
        MoreCloseables.closeQuietly(r10);
        throw th;
    L25:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Faild to query black state for number: " + r12 + ", ex: " + e);     // Catch: Throwable -> L23
        if (DEBUG == false) goto L29;
        e.printStackTrace();     // Catch: Throwable -> L23
    L29:
        MoreCloseables.closeQuietly(r10);
        return false;
    L11:
        if (LoaderThread.access$000(r3) == true) goto L15;
        Set<String> r13 = this.mBlacklistNumbersSet;
        if (r13 == null) goto L15;
        return r13.contains(r1);
    }

    private int getFromContactCache(long r1) {
        Integer r0 = this.mContactBlacklistCache.get(Long.valueOf(r1));
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public void requestLoading() {
        this.mMainHandler.removeMessages(1);
        this.mMainHandler.sendEmptyMessage(1);
    }

    public void requestQueryBlackLists() {
        requestQueryBlackLists(0);
    }

    public void requestQueryBlackLists(long r3) {
        this.mMainHandler.removeMessages(3);
        this.mMainHandler.sendEmptyMessageDelayed(3, r3);
    }

    private boolean isBlacklistMarked(List<String> r5) {
        if (r5 != null) goto L5;
    L22:
        return false;
    L5:
        if (r5.size() == 0) goto L22;
        Iterator<String> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L22;
        String r1 = r6.next();
        if (r1 == null) goto L9;
        String r2 = r1.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        Set<String> r3 = this.mBlacklistNumbersSet;
        if (r3 == null) goto L9;
        if (r3.contains(r2) == true) goto L20;
        if (r2.startsWith("+86") == false) goto L9;
        if (this.mBlacklistNumbersSet.contains(r2.substring(3)) == false) goto L9;
        return true;
    L20:
        return true;
    }

    private boolean isBlacklistMarked(ImageView r4, String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r6 = r5.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return false;
    L8:
        Set<String> r1 = this.mBlacklistNumbersSet;
        if (r1 != null) goto L12;
        this.mPendingRequest.put(r4, r6);
    L15:
        return false;
    L12:
        if (r1.contains(r6) == false) goto L15;
        return true;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 < 60) goto L6;
        this.mContactBlacklistCache.evictAll();
        this.mContactBlacklistCache.resize(500);
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        int r7 = r6.what;
        if (r7 == 1) goto L28;
        if (r7 == 2) goto L24;
        if (r7 != 3) goto L9;
        ensureLoaderThread();
        this.mLoaderThread.request(2);
        return true;
    L9:
        if (r7 == 4) goto L11;
        return false;
    L11:
        log("update cached image views");
        Iterator<ImageView> r8 = this.mPendingRequest.keySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L19;
        ImageView r1 = r8.next();
        String r3 = this.mPendingRequest.get(r1);
        if (this.mBlacklistNumbersSet.contains(r3) == false) goto L17;
        r1.setVisibility(0);
    L18:
        r8.remove();
        goto L13
    L17:
        r1.setVisibility(8);
        goto L18
    L19:
        this.mPendingRequest.clear();
        return true;
    L24:
        if (this.mPaused == true) goto L26;
        processLoaded();
    L26:
        return true;
    L28:
        if (this.mPaused == true) goto L30;
        ensureLoaderThread();
        this.mLoaderThread.request(1);
    L30:
        return true;
    }

    private void processLoaded() {
        processLoadedContacts();
    }

    private void processLoadedContacts() {
        Iterator<ImageView> r0 = this.mContactPendingRequest.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ImageView r1 = r0.next();
        int r2 = getFromContactCache(this.mContactPendingRequest.get(r1).longValue());
        if (r2 == 1) goto L7;
        if (r2 != 2) goto L4;
        r1.setVisibility(8);
        r0.remove();
        goto L4
    L7:
        r1.setVisibility(0);
        r0.remove();
        goto L4
    }

    public void ensureLoaderThread() {
        if (this.mLoaderThread != null) goto L6;
        LoaderThread r0 = new LoaderThread(this, this.mContext.getContentResolver());
        this.mLoaderThread = r0;
        r0.start();
        return;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
