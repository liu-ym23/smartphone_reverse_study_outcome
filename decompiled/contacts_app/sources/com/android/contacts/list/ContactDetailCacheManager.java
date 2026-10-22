package com.android.contacts.list;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.GroupMetaData;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.blocked.BlockedCall;
import com.android.contacts.calllog.blocked.data.BlockedCallEntity;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountTypeWithDataSet;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.DataStatus;
import com.android.contacts.util.UriUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.obric.cloudsdk.kv.base.KvConstant;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes2.dex */
public class ContactDetailCacheManager {
    private static final boolean DEBUG = false;
    private static final int INIT_GROUP_DELAY_TIME = 50;
    private static final String KEY_PROFILE_URI = "profile_uri";
    private static final int MESSAGE_INIT_GROUP = 1;
    private static final int MESSAGE_PREPARE_BLOCKED_CALL_LOG = 5;
    private static final int MESSAGE_PREPARE_CALL_LOG = 3;
    private static final int MESSAGE_PREPARE_CURSOR = 2;
    private static final int MESSAGE_PREPARE_VIEW = 4;
    private static final int PROFILE_LOADER_ID = 1700;
    private static final String TAG = "ContactDetailCacheManager";
    private static int[] sCacheResIds;
    private static ContactDetailCacheManager sDetailCacheManager;
    private Cursor mBlockedCallLogCursor;
    private final byte[] mBlockedCallLogLock;
    private byte[] mBuffer;
    private Map<Uri, MatrixCursor> mCachedQuickContacts;
    private Map<Uri, ContactLoader.Result> mCachedResults;
    private Cursor mCallLogCursor;
    private final byte[] mCallLogLock;
    private ContactLoader.Result mContactResult;
    private Context mContext;
    private Context mContextUI;
    private boolean mDBChanged;
    private Cursor mDirectoryCursor;
    private ArrayList<Long> mDirectoryIds;
    private Cursor mEntitiesCursor;
    private ArrayList<GroupMetaData> mGroupCacheList;
    private GroupObserver mGroupObserver;
    private LoaderHandler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mInitializingGroup;
    private final byte[] mLock;
    private ArrayList<Uri> mLookupUriList;
    private Handler mMainHandler;
    private Handler mOneshotHandler;
    private HandlerThread mOneshotHandlerThread;
    private ArrayList<Long> mPreBlockedCallLogIds;
    private ArrayList<Long> mPreCallLogIds;
    private final LoaderManager.LoaderCallbacks<ContactLoader.Result> mProfileLoaderListener;
    private ContactLoader.Result mProfileResult;
    private Uri mProfileUri;
    private ContentResolver mResolver;
    private Uri mUri;
    private SparseArray<View> mViewList;

    private static class ContactQuery {
        public static final int ACCOUNT_NAME = 15;
        public static final int ACCOUNT_TYPE = 16;
        public static final int ACCOUNT_TYPE_AND_DATA_SET = 18;
        public static final int ALT_DISPLAY_NAME = 4;
        public static final int CHAT_CAPABILITY = 54;
        static final String[] COLUMNS = null;
        public static final int CONTACT_ID = 13;
        public static final int CONTACT_PRESENCE = 8;
        public static final int CONTACT_STATUS = 9;
        public static final int CONTACT_STATUS_LABEL = 12;
        public static final int CONTACT_STATUS_RES_PACKAGE = 11;
        public static final int CONTACT_STATUS_TIMESTAMP = 10;
        public static final int CUSTOM_RINGTONE = 62;
        public static final int DATA1 = 28;
        public static final int DATA10 = 37;
        public static final int DATA11 = 38;
        public static final int DATA12 = 39;
        public static final int DATA13 = 40;
        public static final int DATA14 = 41;
        public static final int DATA15 = 42;
        public static final int DATA2 = 29;
        public static final int DATA3 = 30;
        public static final int DATA4 = 31;
        public static final int DATA5 = 32;
        public static final int DATA6 = 33;
        public static final int DATA7 = 34;
        public static final int DATA8 = 35;
        public static final int DATA9 = 36;
        public static final int DATA_ID = 27;
        public static final int DATA_SET = 17;
        public static final int DATA_SYNC1 = 43;
        public static final int DATA_SYNC2 = 44;
        public static final int DATA_SYNC3 = 45;
        public static final int DATA_SYNC4 = 46;
        public static final int DATA_VERSION = 47;
        public static final int DELETED = 26;
        public static final int DIRTY = 19;
        public static final int DISPLAY_NAME = 3;
        public static final int DISPLAY_NAME_SOURCE = 1;
        public static final int GROUP_SOURCE_ID = 52;
        public static final int IS_PRIMARY = 48;
        public static final int IS_SUPERPRIMARY = 49;
        public static final int IS_USER_PROFILE = 63;
        public static final int LOOKUP_KEY = 2;
        public static final int MIMETYPE = 50;
        public static final int NAME_RAW_CONTACT_ID = 0;
        public static final int PHONETIC_NAME = 5;
        public static final int PHOTO_ID = 6;
        public static final int PHOTO_URI = 60;
        public static final int PRESENCE = 53;
        public static final int RAW_CONTACT_ID = 14;
        public static final int RES_PACKAGE = 51;
        public static final int SEND_TO_VOICEMAIL = 61;
        public static final int SOURCE_ID = 21;
        public static final int STARRED = 7;
        public static final int STATUS = 55;
        public static final int STATUS_ICON = 57;
        public static final int STATUS_LABEL = 58;
        public static final int STATUS_RES_PACKAGE = 56;
        public static final int STATUS_TIMESTAMP = 59;
        public static final int SYNC1 = 22;
        public static final int SYNC2 = 23;
        public static final int SYNC3 = 24;
        public static final int SYNC4 = 25;
        public static final int VERSION = 20;

        private ContactQuery() {
        }

        static {
            COLUMNS = new String[]{"name_raw_contact_id", "display_name_source", "lookup", "display_name", "display_name_alt", "phonetic_name", "photo_id", ContactSaveService.EXTRA_STARRED_FLAG, "contact_presence", "contact_status", "contact_status_ts", "contact_status_res_package", "contact_status_label", "contact_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_name", "account_type", "data_set", "account_type_and_data_set", "dirty", GloableSearchConfig.KEY_VERSION, "sourceid", "sync1", "sync2", "sync3", "sync4", "deleted", KvConstant.KV_DATA_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "data_sync1", "data_sync2", "data_sync3", "data_sync4", "data_version", "is_primary", "is_super_primary", "mimetype", "res_package", "group_sourceid", "mode", "chat_capability", "status", "status_res_package", "status_icon", "status_label", "status_ts", "photo_uri", "send_to_voicemail", "custom_ringtone", "is_user_profile"};
        }
    }

    private static class DirectoryQuery {
        public static final int ACCOUNT_NAME = 4;
        public static final int ACCOUNT_TYPE = 3;
        static final String[] COLUMNS = null;
        public static final int DISPLAY_NAME = 0;
        public static final int EXPORT_SUPPORT = 5;
        public static final int PACKAGE_NAME = 1;
        public static final int TYPE_RESOURCE_ID = 2;
        public static final int _ID = 6;

        private DirectoryQuery() {
        }

        static {
            COLUMNS = new String[]{"displayName", "packageName", "typeResourceId", ContactSaveService.EXTRA_ACCOUNT_TYPE, ContactSaveService.EXTRA_ACCOUNT_NAME, "exportSupport", "_id"};
        }
    }

    private class GroupObserver extends ContentObserver {
        final /* synthetic */ ContactDetailCacheManager this$0;

        public GroupObserver(ContactDetailCacheManager r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            ContactDetailCacheManager.access$802(this.this$0, true);
            if (ContactDetailCacheManager.access$900(this.this$0).hasMessages(1) == false) goto L6;
            ContactDetailCacheManager.access$900(this.this$0).removeMessages(1);
        L6:
            if (ContactDetailCacheManager.access$1000(this.this$0).isAlive() == false) goto L9;
            ContactDetailCacheManager.access$900(this.this$0).sendEmptyMessageDelayed(1, 50);
            return;
        }
    }

    private static class GroupQuery {
        public static final int ACCOUNT_NAME = 0;
        public static final int ACCOUNT_TYPE = 1;
        public static final int ACCOUNT_TYPE_AND_DATA_SET = 3;
        public static final int AUTO_ADD = 6;
        static final String[] COLUMNS = null;
        public static final int DATA_SET = 2;
        public static final int FAVORITES = 7;
        public static final int ID = 4;
        public static final int TITLE = 5;

        private GroupQuery() {
        }

        static {
            COLUMNS = new String[]{"account_name", "account_type", "data_set", "account_type_and_data_set", "_id", "title", "auto_add", "favorites"};
        }
    }

    private final class LoaderHandler extends Handler {
        final /* synthetic */ ContactDetailCacheManager this$0;

        public LoaderHandler(ContactDetailCacheManager r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = r3.what;
            if (r0 != 1) goto L5;
            ContactDetailCacheManager.access$400(this.this$0);
            return;
        L5:
            if (r0 != 2) goto L7;
            Uri[] r4 = (Uri[]) r3.obj;
            ContactDetailCacheManager.access$500(this.this$0, r4);
            return;
        L7:
            if (r0 != 3) goto L9;
            long[] r5 = (long[]) r3.obj;
            ContactDetailCacheManager.access$600(this.this$0, r5);
            return;
        L9:
            if (r0 != 5) goto L19;
            long[] r6 = (long[]) r3.obj;
            ContactDetailCacheManager.access$700(this.this$0, r6);
            return;
        }
    }

    public boolean isDirectoryEntry(long r3) {
        if (r3 != (-1)) goto L5;
    L9:
        return false;
    L5:
        if (r3 == 0) goto L9;
        if (r3 == 1) goto L9;
        return true;
    }

    static /* synthetic */ void access$000(ContactDetailCacheManager r0, ArrayList r1) {
        r0.startQueryCallLog(r1);
    }

    static /* synthetic */ void access$100(ContactDetailCacheManager r0, ArrayList r1) {
        r0.startQueryBlockedCallLog(r1);
    }

    static /* synthetic */ HandlerThread access$1000(ContactDetailCacheManager r0) {
        return r0.mHandlerThread;
    }

    static /* synthetic */ Context access$1100(ContactDetailCacheManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ ContactLoader.Result access$1202(ContactDetailCacheManager r0, ContactLoader.Result r1) {
        r0.mProfileResult = r1;
        return r1;
    }

    static /* synthetic */ Uri access$1302(ContactDetailCacheManager r0, Uri r1) {
        r0.mProfileUri = r1;
        return r1;
    }

    static /* synthetic */ void access$200(ContactDetailCacheManager r0) {
        r0.doCacheView();
    }

    static /* synthetic */ void access$300(ContactDetailCacheManager r0) {
        r0.quitOneShotLooper();
    }

    static /* synthetic */ void access$400(ContactDetailCacheManager r0) {
        r0.initGroupCache();
    }

    static /* synthetic */ void access$500(ContactDetailCacheManager r0, Uri[] r1) {
        r0.cache(r1);
    }

    static /* synthetic */ void access$600(ContactDetailCacheManager r0, long[] r1) {
        r0.cacheCallLog(r1);
    }

    static /* synthetic */ void access$700(ContactDetailCacheManager r0, long[] r1) {
        r0.cacheBlockedCallLog(r1);
    }

    static /* synthetic */ boolean access$802(ContactDetailCacheManager r0, boolean r1) {
        r0.mDBChanged = r1;
        return r1;
    }

    static /* synthetic */ LoaderHandler access$900(ContactDetailCacheManager r0) {
        return r0.mHandler;
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
        sCacheResIds = new int[0];
    }

    private ContactDetailCacheManager() {
        this.mUri = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "lookup/multi_entities");
        this.mLookupUriList = new ArrayList();
        this.mDirectoryIds = new ArrayList();
        this.mLock = new byte[0];
        this.mCallLogLock = new byte[0];
        this.mBlockedCallLogLock = new byte[0];
        this.mGroupCacheList = new ArrayList();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitializingGroup = false;
        this.mDBChanged = false;
        this.mViewList = new SparseArray(sCacheResIds.length);
        this.mProfileLoaderListener = new AnonymousClass5(this);
        this.mPreCallLogIds = new ArrayList();
        this.mPreBlockedCallLogIds = new ArrayList();
        ContactsApplication r0 = ContactsApplication.getInstance();
        this.mContext = r0;
        this.mContextUI = null;
        this.mResolver = r0.getContentResolver();
        init();
    }

    public static synchronized ContactDetailCacheManager getInstance() {
        monitor-enter(ContactDetailCacheManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sDetailCacheManager != null) goto L7;
        sDetailCacheManager = new ContactDetailCacheManager();     // Catch: Throwable -> L10
    L7:
        ContactDetailCacheManager r1 = sDetailCacheManager;     // Catch: Throwable -> L10
        monitor-exit(ContactDetailCacheManager.class);
        return r1;
    }

    public synchronized void refreshCache(AbsListView r3) {
        monitor-enter(this);
        refreshCache(r3.getAdapter(), r3.getFirstVisiblePosition(), r3.getLastVisiblePosition());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void refreshCache(final Adapter r3, final int r4, final int r5) {
        monitor-enter(this);
        this.mMainHandler.post(new AnonymousClass1(this, r3, r5, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void refreshBlockedCallLogCache(final ArrayList<Long> r3) {
        monitor-enter(this);
        this.mMainHandler.post(new AnonymousClass2(this, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void ensureOneshotHandler() {
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ensureOneshotHandler");
    L6:
        if (this.mOneshotHandlerThread != null) goto L9;
        HandlerThread r0 = new HandlerThread("SecondHandlerThread");
        this.mOneshotHandlerThread = r0;
        r0.start();
    L9:
        if (this.mOneshotHandler != null) goto L12;
        this.mOneshotHandler = new Handler(this.mOneshotHandlerThread.getLooper(), new AnonymousClass3(this));
        return;
    }

    private void quitOneShotLooper() {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "quitOneShotLooper..");
    L5:
        HandlerThread r0 = this.mOneshotHandlerThread;
        if (r0 == null) goto L8;
        r0.quitSafely();
    L8:
        this.mOneshotHandler = null;
        this.mOneshotHandlerThread = null;
    }

    public void cacheView(Context r4) {
        this.mContextUI = r4;
        ensureOneshotHandler();
        Handler r5 = this.mOneshotHandler;
        if (r5 == null) goto L6;
        r5.removeMessages(4);
        this.mOneshotHandler.sendEmptyMessageDelayed(4, 500);
        return;
    }

    private void doCacheView() {
        Context r0 = this.mContextUI;     // Catch: OutOfMemoryError -> L10
        if (r0 == null) goto L8;
        LayoutInflater r1 = LayoutInflater.from(r0);     // Catch: OutOfMemoryError -> L10
        int[] r2 = sCacheResIds;     // Catch: OutOfMemoryError -> L10
        int r3 = r2.length;     // Catch: OutOfMemoryError -> L10
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L8;
        int r5 = r2[r4];     // Catch: OutOfMemoryError -> L10
        this.mViewList.put(r5, r1.inflate(r5, null, false));     // Catch: OutOfMemoryError -> L10
        r4 = r4 + 1;
    L8:
        this.mMainHandler.post(new AnonymousClass4(this));
        return;
    L10:
        e = move-exception;
        if (DEBUG == false) goto L14;
        ContactsUtils.catchHprofs();     // Catch: Exception -> L15
    L14:
        throw e;
    }

    public View getCachedView(int r3) {
        View r0 = this.mViewList.get(r3);
        this.mViewList.put(r3, null);
        return r0;
    }

    private void init() {
        if (this.mHandlerThread != null) goto L6;
        HandlerThread r0 = new HandlerThread("loader");
        this.mHandlerThread = r0;
        r0.start();
    L6:
        if (this.mHandler != null) goto L8;
        this.mHandler = new LoaderHandler(this, this.mHandlerThread.getLooper());
    L8:
        this.mHandler.sendEmptyMessageDelayed(1, 500);
        registerObserver();
    }

    public ContactLoader.Result getResult(Uri r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (ContactsContract.isProfileId(ContentUris.parseId(r4)) == false) goto L14;
        ContactLoader.Result r1 = this.mProfileResult;
        if (r1 != null) goto L10;
    L13:
        return null;
    L10:
        if (r4.equals(r1.getLookupUri()) == false) goto L13;
        return this.mProfileResult;
    L14:
        ContactLoader.Result r2 = this.mContactResult;
        if (r2 != null) goto L17;
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "failed to hit cached mContactResult");
        return null;
    L17:
        if (r4.equals(r2.getLookupUri()) == false) goto L21;
        ContactLoader.Result r5 = this.mContactResult;
        this.mContactResult = null;
        return r5;
    }

    public void startQuery(Uri[] r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length == 0) goto L51;
        HashSet r0 = new HashSet();
        int r1 = r10.length;
        boolean r2 = true;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L28;
        Uri r6 = r10[r4];
        if (r6 == null) goto L12;
        List<String> r7 = r6.getPathSegments();
        if (r7 == null) goto L25;
        if (r7.size() < 4) goto L25;
        if (r2 == true) goto L21;
    L23:
        r0.add(r6);
    L27:
        r4 = r4 + 1;
        goto L8
    L21:
        if (this.mLookupUriList.contains(r6) == true) goto L23;
        r2 = false;
    L25:
        if (DEBUG == false) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Illegal lookupUri, uri = " + r6.toString());
        goto L27
    L12:
        if (DEBUG == false) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Illegal lookupUri, uri is null!");
        goto L27
    L28:
        if (r2 == true) goto L30;
    L36:
        this.mDBChanged = false;
        Message r11 = new Message();
        r11.what = 2;
        r11.obj = r0.toArray(new Uri[0]);
        if (this.mHandler.hasMessages(2) == false) goto L40;
        this.mHandler.removeMessages(2);
    L40:
        if (this.mHandlerThread.isAlive() == false) goto L50;
        this.mCachedResults = null;
        this.mHandler.sendMessage(r11);
        return;
    L50:
        return;
    L30:
        if (this.mDBChanged == true) goto L36;
        if (DEBUG == false) goto L34;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "All valid uris is contained in the pre-load cursor.");
    L34:
        r0.clear();
        return;
    }

    public void loadResultData(Uri r4) {
        if (this.mInitializingGroup == true) goto L5;
        if (r4 != null) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "the Uri, which want to get result is null!");
        return;
    L11:
        List<String> r0 = r4.getPathSegments();
        if (r0 != null) goto L14;
    L17:
        buildResult(r4);
        return;
    L14:
        if (r0.size() >= 4) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "the Uri is illegal!");
        return;
    L5:
        if (DEBUG == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Initializing group data, the cache data may not right.");
        return;
    }

    private void cache(Uri[] r11) {
        this.mLookupUriList.clear();
        this.mDirectoryIds.clear();
        ArrayList r0 = new ArrayList();
        int r1 = r11.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L23;
        Uri r4 = r11[r3];
        List<String> r5 = r4.getPathSegments();
        if (r5 == null) goto L22;
        if (r5.size() <= 3) goto L22;
        String r6 = r5.get(3);
        long r8 = 0;
        if (Long.parseLong(r6) <= 0) goto L22;
        r0.add(r6);
        this.mLookupUriList.add(r4);
        String r7 = r4.getQueryParameter("directory");
        if (r7 == null) goto L20;
        r8 = Long.parseLong(r7);
    L20:
        if (isDirectoryEntry(r8) == false) goto L22;
        this.mDirectoryIds.add(Long.valueOf(r8));
    L22:
        r3 = r3 + 1;
        goto L3
    L23:
        String[] r9 = (String[]) r0.toArray(new String[0]);
        if (r9 != null) goto L26;
        return;
    L26:
        if (r9.length == 0) goto L58;
        Cursor r12 = this.mResolver.query(this.mUri, ContactQuery.COLUMNS, null, r9, null);
        if (r12 != null) goto L31;
        return;
    L31:
        swapEntitiesCursor(r12);
        int r13 = this.mDirectoryIds.size();
        if (r13 != 0) goto L34;
        return;
    L34:
        StringBuilder r10 = new StringBuilder("_id IN ( ");
    L35:
        if (r2 >= r13) goto L40;
        if (r2 != 0) goto L38;
        r10.append(this.mDirectoryIds.get(r2));
    L39:
        r2 = r2 + 1;
        goto L35
    L38:
        r10.append(", " + this.mDirectoryIds.get(r2));
        goto L39
    L40:
        r10.append(")");
        Cursor r14 = this.mResolver.query(ContactsContract.Directory.CONTENT_URI, DirectoryQuery.COLUMNS, r10.toString(), null, null);
        if (r14 != null) goto L43;
        return;
    L43:
        swapDirectoryCursor(r14);
        return;
    }

    private void swapEntitiesCursor(Cursor r3) {
        Cursor r0 = null;
        byte[] r1 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        r0 = this.mEntitiesCursor;     // Catch: Throwable -> L10
        this.mEntitiesCursor = r3;     // Catch: Throwable -> L10
        preLoadEntities();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r0 == null) goto L21;
        r0.close();
        return;
    L21:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    }

    private void preLoadEntities() {
        Cursor r1 = this.mEntitiesCursor;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isClosed() == false) goto L7;
        return;
    L7:
        if (this.mEntitiesCursor.moveToFirst() == true) goto L10;
        return;
    L10:
        if (ContactsUtils.DEBUG == false) goto L73;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "preLoadEntities start");
    L73:
        HashMap r2 = new HashMap();     // Catch: Exception -> L70
        HashMap r3 = new HashMap();     // Catch: Exception -> L70
        String[] r4 = QuickContactHelper.DataQuery.PROJECTION;     // Catch: Exception -> L70
        int[] r5 = new int[r4.length];     // Catch: Exception -> L70
        Object[] r6 = new Object[r4.length];     // Catch: Exception -> L70
        int r8 = 0;
    L14:
        if (r8 >= r4.length) goto L16;
        r5[r8] = this.mEntitiesCursor.getColumnIndex(r4[r8]);     // Catch: Exception -> L70
        r8 = r8 + 1;     // Catch: Exception -> L70
        goto L14
    L16:
        r5[0] = this.mEntitiesCursor.getColumnIndex(KvConstant.KV_DATA_ID);     // Catch: Exception -> L70
        long r9 = -1;
        boolean r13 = false;
        long r11 = -1;
        ArrayList<Entity> r14 = null;
        Entity r15 = null;
        HashMap<Long, DataStatus> r16 = null;
        ContactLoader.Result r17 = null;
    L18:
        if (this.mEntitiesCursor.isAfterLast() == true) goto L66;
        boolean r18 = r13;
        ArrayList<Entity> r19 = r14;
        long r110 = this.mEntitiesCursor.getLong(13);     // Catch: Exception -> L70
        Uri r7 = ContactsContract.Contacts.getLookupUri(r110, this.mEntitiesCursor.getString(2));     // Catch: Exception -> L70
        if (r9 == r110) goto L22;
        r9 = r110;
        r13 = false;
    L23:
        if (r13 == true) goto L25;
        ContactLoader.Result r111 = loadContactHeaderData(this.mEntitiesCursor, r7);     // Catch: Exception -> L70
        ArrayList<Entity> r112 = r111.getEntities();     // Catch: Exception -> L70
        HashMap<Long, DataStatus> r113 = r111.getStatuses();     // Catch: Exception -> L70
        r2.put(r7, r111);     // Catch: Exception -> L70
        ContactLoader.Result r114 = r111;
        ArrayList<Entity> r10 = r112;
        HashMap<Long, DataStatus> r115 = r113;
        r13 = true;
    L26:
        long r12 = this.mEntitiesCursor.getLong(14);     // Catch: Exception -> L70
        if (r12 == r11) goto L30;
        r15 = new Entity(loadRawContact(this.mEntitiesCursor));     // Catch: Exception -> L70
        r10.add(r15);     // Catch: Exception -> L70
        r11 = r12;
    L30:
        if (this.mEntitiesCursor.isNull(27) == true) goto L38;
        r15.addSubValue(ContactsContract.Data.CONTENT_URI, loadData(this.mEntitiesCursor));     // Catch: Exception -> L70
        if (this.mEntitiesCursor.isNull(53) == true) goto L34;
    L35:
        r115.put(Long.valueOf(this.mEntitiesCursor.getLong(27)), new DataStatus(this.mEntitiesCursor));     // Catch: Exception -> L70
        goto L38
    L34:
        if (this.mEntitiesCursor.isNull(55) == false) goto L35;
    L38:
        if (r114.isDirectoryEntry() == false) goto L40;
        ContactLoader.Result r20 = r114;
        loadDirectoryEntry(r20);     // Catch: Exception -> L70
    L41:
        loadGroupMeta(r20);     // Catch: Exception -> L70
        computeFormattedPhoneNumbers(r20);     // Catch: Exception -> L70
        loadPhotoBinaryData(r20);     // Catch: Exception -> L70
        if (r20.isUserProfile() == true) goto L44;
        loadInvitableAccountTypes(r20);     // Catch: Exception -> L70
    L44:
        MatrixCursor r21 = (MatrixCursor) r3.get(r7);     // Catch: Exception -> L70
        if (r21 != null) goto L47;
        r21 = new MatrixCursor(r4);     // Catch: Exception -> L70
        r3.put(r7, r21);     // Catch: Exception -> L70
    L47:
        int r22 = 0;
    L49:
        if (r22 >= r4.length) goto L64;
        String[] r116 = r4;
        int r23 = this.mEntitiesCursor.getType(r5[r22]);     // Catch: Exception -> L70
        if (r23 != 1) goto L53;
        r6[r22] = Integer.valueOf(this.mEntitiesCursor.getInt(r5[r22]));     // Catch: Exception -> L70
    L63:
        r22 = r22 + 1;     // Catch: Exception -> L70
        r4 = r116;
        goto L49
    L53:
        if (r23 != 2) goto L55;
        r6[r22] = Float.valueOf(this.mEntitiesCursor.getFloat(r5[r22]));     // Catch: Exception -> L70
        goto L63
    L55:
        if (r23 != 3) goto L57;
        r6[r22] = this.mEntitiesCursor.getString(r5[r22]);     // Catch: Exception -> L70
        goto L63
    L57:
        if (r23 == 4) goto L59;
        r6[r22] = null;     // Catch: Exception -> L70
        goto L63
    L59:
        r6[r22] = this.mEntitiesCursor.getBlob(r5[r22]);     // Catch: Exception -> L70
        goto L63
    L64:
        r21.addRow(r6);     // Catch: Exception -> L70
        this.mEntitiesCursor.moveToNext();     // Catch: Exception -> L70
        r17 = r20;
        r16 = r115;
        r4 = r4;
        r9 = r9;
        r14 = r10;
        goto L18
    L40:
        r20 = r114;
        goto L41
    L25:
        r115 = r16;
        r114 = r17;
        r10 = r19;
        goto L26
    L22:
        r13 = r18;
        goto L23
    L66:
        if (ContactsUtils.DEBUG == false) goto L68;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "preLoadEntities finish");     // Catch: Exception -> L70
    L68:
        this.mCachedResults = r2;     // Catch: Exception -> L70
        this.mCachedQuickContacts = r3;     // Catch: Exception -> L70
        return;
    L70:
        e = move-exception;
        e.printStackTrace();
    }

    private void swapDirectoryCursor(Cursor r3) {
        Cursor r0 = null;
        byte[] r1 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        r0 = this.mDirectoryCursor;     // Catch: Throwable -> L10
        this.mDirectoryCursor = r3;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r0 == null) goto L20;
        r0.close();
        return;
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    }

    private void buildResult(Uri r3) {
        Map<Uri, ContactLoader.Result> r0 = this.mCachedResults;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey(r3) == true) goto L7;
        return;
    L7:
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "build from cached results directly");
    L9:
        this.mContactResult = this.mCachedResults.get(r3);
    }

    private void loadInvitableAccountTypes(ContactLoader.Result r5) {
        Map<AccountTypeWithDataSet, AccountType> r4 = AccountTypeManager.getInstance(this.mContext).getUsableInvitableAccountTypes();
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r6 = Maps.newHashMap(r4);
        Iterator<Entity> r0 = r5.getEntities().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ContentValues r1 = r0.next().getEntityValues();
        r6.remove(AccountTypeWithDataSet.get(r1.getAsString("account_type"), r1.getAsString("data_set")));
        goto L7
    L9:
        r5.mInvitableAccountTypes.addAll(r6.values());
    }

    private void loadDirectoryEntry(ContactLoader.Result r9) {
        Cursor r0 = this.mDirectoryCursor;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCount() == 0) goto L30;
        long r1 = r9.getDirectoryId();
        if (this.mDirectoryCursor.moveToFirst() == true) goto L10;
        return;
    L10:
        if (r1 == this.mDirectoryCursor.getLong(6)) goto L11;
        if (this.mDirectoryCursor.moveToNext() == true) goto L10;
        return;
    L11:
        String r3 = this.mDirectoryCursor.getString(0);
        String r2 = this.mDirectoryCursor.getString(1);
        int r4 = this.mDirectoryCursor.getInt(2);
        String r5 = this.mDirectoryCursor.getString(3);
        String r6 = this.mDirectoryCursor.getString(4);
        int r7 = this.mDirectoryCursor.getInt(5);
        String r8 = null;
        if (TextUtils.isEmpty(r2) == false) goto L23;
    L19:
        r9.setDirectoryMetaData(r3, r8, r5, r6, r7);
        return;
    L23:
        Resources r10 = this.mContext.getPackageManager().getResourcesForApplication(r2);     // Catch: PackageManager.NameNotFoundException -> L18
        if (r10 == null) goto L19;
        r8 = r10.getString(r4);     // Catch: PackageManager.NameNotFoundException -> L18
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Contact directory resource not found: " + r2 + LibrarianImpl.Constants.DOT + r4);
        goto L19
    }

    private ContactLoader.Result loadContactEntity(Cursor r12, Uri r13, long r14) {
        ContactLoader.Result r0 = null;
        if (r12 == null) goto L30;
        if (r12.moveToFirst() == false) goto L30;
        boolean r4 = false;
        long r5 = -1;
        ArrayList<Entity> r1 = null;
        Entity r2 = null;
        HashMap<Long, DataStatus> r3 = null;
    L9:
        if (r12.isAfterLast() == true) goto L28;
        if (r12.getLong(13) != r14) goto L27;
        if (r4 == true) goto L15;
        r0 = loadContactHeaderData(r12, r13);
        r1 = r0.getEntities();
        r3 = r0.getStatuses();
        r4 = true;
    L15:
        long r7 = r12.getLong(14);
        if (r7 == r5) goto L19;
        r2 = new Entity(loadRawContact(r12));
        r1.add(r2);
        r5 = r7;
    L19:
        if (r12.isNull(27) == true) goto L27;
        if (r2 == null) goto L23;
        r2.addSubValue(ContactsContract.Data.CONTENT_URI, loadData(r12));
    L23:
        if (r12.isNull(53) == true) goto L25;
    L26:
        r3.put(Long.valueOf(r12.getLong(27)), new DataStatus(r12));
        goto L27
    L25:
        if (r12.isNull(55) == false) goto L26;
    L27:
        r12.moveToNext();
        goto L9
    L28:
        return r0;
    L30:
        if (DEBUG == false) goto L32;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "loadContactEntity cursor is null or empty! ");
    L32:
        return null;
    }

    private ContactLoader.Result loadContactHeaderData(Cursor r26, Uri r27) {
        String r1 = r27.getQueryParameter("directory");
        if (r1 != null) goto L5;
        long r6 = 0;
    L6:
        long r9 = r26.getLong(13);
        String r8 = r26.getString(2);
        long r11 = r26.getLong(0);
        int r13 = r26.getInt(1);
        String r17 = r26.getString(3);
        String r18 = r26.getString(4);
        String r19 = r26.getString(5);
        long r14 = r26.getLong(6);
        String r16 = r26.getString(60);
        if (r26.getInt(7) == 0) goto L9;
        boolean r20 = true;
    L11:
        if (r26.isNull(8) == false) goto L13;
        Integer r2 = null;
    L14:
        Integer r21 = r2;
        if (r26.getInt(61) != 1) goto L17;
        boolean r22 = true;
    L18:
        String r23 = r26.getString(62);
        if (r26.getInt(63) != 1) goto L21;
        boolean r24 = true;
    L23:
        if (r6 != 0) goto L25;
    L28:
        Uri r5 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, r8), r9);
    L30:
        return new ContactLoader.Result(r27, r27, r5, r6, r8, r9, r11, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L25:
        if (r6 == 1) goto L28;
        r5 = r27;
        goto L30
    L21:
        r24 = false;
        goto L23
    L17:
        r22 = false;
        goto L18
    L13:
        r2 = Integer.valueOf(r26.getInt(8));
        goto L14
    L9:
        r20 = false;
        goto L11
    L5:
        r6 = Long.parseLong(r1);
        goto L6
    }

    private ContentValues loadRawContact(Cursor r4) {
        ContentValues r0 = new ContentValues();
        r0.put("_id", Long.valueOf(r4.getLong(14)));
        cursorColumnToContentValues(r4, r0, 15);
        cursorColumnToContentValues(r4, r0, 16);
        cursorColumnToContentValues(r4, r0, 17);
        cursorColumnToContentValues(r4, r0, 18);
        cursorColumnToContentValues(r4, r0, 19);
        cursorColumnToContentValues(r4, r0, 20);
        cursorColumnToContentValues(r4, r0, 21);
        cursorColumnToContentValues(r4, r0, 22);
        cursorColumnToContentValues(r4, r0, 23);
        cursorColumnToContentValues(r4, r0, 24);
        cursorColumnToContentValues(r4, r0, 25);
        cursorColumnToContentValues(r4, r0, 26);
        cursorColumnToContentValues(r4, r0, 13);
        cursorColumnToContentValues(r4, r0, 7);
        return r0;
    }

    private ContentValues loadData(Cursor r4) {
        ContentValues r0 = new ContentValues();
        r0.put("_id", Long.valueOf(r4.getLong(27)));
        cursorColumnToContentValues(r4, r0, 28);
        cursorColumnToContentValues(r4, r0, 29);
        cursorColumnToContentValues(r4, r0, 30);
        cursorColumnToContentValues(r4, r0, 31);
        cursorColumnToContentValues(r4, r0, 32);
        cursorColumnToContentValues(r4, r0, 33);
        cursorColumnToContentValues(r4, r0, 34);
        cursorColumnToContentValues(r4, r0, 35);
        cursorColumnToContentValues(r4, r0, 36);
        cursorColumnToContentValues(r4, r0, 37);
        cursorColumnToContentValues(r4, r0, 38);
        cursorColumnToContentValues(r4, r0, 39);
        cursorColumnToContentValues(r4, r0, 40);
        cursorColumnToContentValues(r4, r0, 41);
        cursorColumnToContentValues(r4, r0, 42);
        cursorColumnToContentValues(r4, r0, 43);
        cursorColumnToContentValues(r4, r0, 44);
        cursorColumnToContentValues(r4, r0, 45);
        cursorColumnToContentValues(r4, r0, 46);
        cursorColumnToContentValues(r4, r0, 47);
        cursorColumnToContentValues(r4, r0, 48);
        cursorColumnToContentValues(r4, r0, 49);
        cursorColumnToContentValues(r4, r0, 50);
        cursorColumnToContentValues(r4, r0, 51);
        cursorColumnToContentValues(r4, r0, 52);
        cursorColumnToContentValues(r4, r0, 54);
        return r0;
    }

    private void cursorColumnToContentValues(Cursor r3, ContentValues r4, int r5) {
        int r2 = r3.getType(r5);
        if (r2 != 0) goto L5;
        return;
    L5:
        if (r2 != 1) goto L7;
        r4.put(ContactQuery.COLUMNS[r5], Long.valueOf(r3.getLong(r5)));
        return;
    L7:
        if (r2 != 3) goto L9;
        r4.put(ContactQuery.COLUMNS[r5], r3.getString(r5));
        return;
    L9:
        if (r2 != 4) goto L12;
        r4.put(ContactQuery.COLUMNS[r5], r3.getBlob(r5));
        return;
    L12:
        throw new IllegalStateException("Invalid or unhandled data type");
    }

    private void computeFormattedPhoneNumbers(ContactLoader.Result r4) {
        Iterator<Entity> r3 = r4.getEntities().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Iterator<Entity.NamedContentValues> r5 = r3.next().getSubValues().iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        ContentValues r0 = r5.next().values;
        if ("vnd.android.cursor.item/phone_v2".equals(r0.getAsString("mimetype")) == false) goto L7;
        r0.put("data1", ContactsUtils.formatNumber(r0.getAsString("data1")));
        goto L7
    }

    private void loadPhotoBinaryData(ContactLoader.Result r7) {
        String r0 = r7.getPhotoUri();
        if (r0 != null) goto L36;
    L17:
        long r1 = r7.getPhotoId();
        if (r1 > 0) goto L20;
        return;
    L20:
        Iterator<Entity> r6 = r7.getEntities().iterator();
    L22:
        if (r6.hasNext() == false) goto L32;
        Iterator<Entity.NamedContentValues> r2 = r6.next().getSubValues().iterator();
    L25:
        if (r2.hasNext() == false) goto L22;
        ContentValues r3 = r2.next().values;
        if (r3.getAsLong("_id").longValue() != r1) goto L25;
        if ("vnd.android.cursor.item/photo".equals(r3.getAsString("mimetype")) == false) goto L30;
        r7.setPhotoBinaryData(r3.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG));
        goto L22
    L30:
        return;
    L32:
        return;
    L36:
        AssetFileDescriptor r4 = this.mResolver.openAssetFileDescriptor(Uri.parse(r0), "r");     // Catch: Throwable -> L33
        if (this.mBuffer != null) goto L7;
        this.mBuffer = new byte[16384];     // Catch: Throwable -> L33
    L7:
        FileInputStream r5 = r4.createInputStream();     // Catch: Throwable -> L33
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();     // Catch: Throwable -> L33
    L34:
        int r9 = r5.read(this.mBuffer);     // Catch: Throwable -> L14
        if (r9 == (-1)) goto L11;
        r8.write(this.mBuffer, 0, r9);     // Catch: Throwable -> L14
        goto L34
    L11:
        r7.setPhotoBinaryData(r8.toByteArray());     // Catch: Throwable -> L14
        r5.close();     // Catch: Throwable -> L33 Throwable -> L33
        r8.close();     // Catch: Throwable -> L33 Throwable -> L33
        r4.close();     // Catch: Throwable -> L33 Throwable -> L33
        return;
    L14:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L33 Throwable -> L33
        r8.close();     // Catch: Throwable -> L33 Throwable -> L33
        r4.close();     // Catch: Throwable -> L33 Throwable -> L33
        throw th;     // Catch: Throwable -> L33 Throwable -> L33
    }

    private void initGroupCache() {
        this.mInitializingGroup = true;
        Cursor r1 = this.mResolver.query(ContactsContract.Groups.CONTENT_URI, GroupQuery.COLUMNS, "account_type NOT NULL AND account_name NOT NULL AND auto_add=0 AND favorites=0 AND deleted=0", null, null);
        if (r1 != null) goto L40;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "fetch group list failed!");
        return;
    L40:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L28 Exception -> L30
        if (r1.moveToFirst() == false) goto L23;
    L9:
        String r6 = r1.getString(0);     // Catch: Throwable -> L28 Exception -> L30
        String r7 = r1.getString(1);     // Catch: Throwable -> L28 Exception -> L30
        String r8 = r1.getString(2);     // Catch: Throwable -> L28 Exception -> L30
        long r9 = r1.getLong(4);     // Catch: Throwable -> L28 Exception -> L30
        String r11 = r1.getString(5);     // Catch: Throwable -> L28 Exception -> L30
        if (r1.isNull(6) == false) goto L12;
    L14:
        boolean r12 = false;
    L16:
        if (r1.isNull(7) == false) goto L18;
    L20:
        boolean r13 = false;
    L21:
        r3.add(new GroupMetaData(r6, r7, r8, r9, r11, r12, r13));     // Catch: Throwable -> L28 Exception -> L30
        if (r1.moveToNext() == true) goto L9;
    L18:
        if (r1.getInt(7) == 0) goto L20;
        r13 = true;
        goto L21
    L12:
        if (r1.getInt(6) == 0) goto L14;
        r12 = true;
    L23:
        this.mGroupCacheList.clear();     // Catch: Throwable -> L28 Exception -> L30
        if (r3.size() <= 0) goto L26;
        this.mGroupCacheList.addAll(r3);     // Catch: Throwable -> L28 Exception -> L30
    L26:
        if (r1 != null) goto L33;
    L34:
        this.mInitializingGroup = false;
        return;
    L33:
        r1.close();
    L28:
        th = move-exception;
        if (r1 == null) goto L38;
        r1.close();
    L38:
        this.mInitializingGroup = false;
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        if (r1 == null) goto L34;
        goto L33
    }

    public GroupMetaData getGroupMetaDataByID(long r4) {
        Iterator<GroupMetaData> r3 = this.mGroupCacheList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        GroupMetaData r0 = r3.next();
        if (r0.getGroupId() != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    private void loadGroupMeta(ContactLoader.Result r9) {
        ArrayList r0 = new ArrayList();
        Iterator<Entity> r1 = r9.mEntities.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        ContentValues r2 = r1.next().getEntityValues();
        String r3 = r2.getAsString("account_name");
        String r4 = r2.getAsString("account_type");
        String r5 = r2.getAsString("data_set");
        if (r3 == null) goto L4;
        if (r4 == null) goto L4;
        AccountWithDataSet r6 = new AccountWithDataSet(r3, r4, r5);
        if (r0.contains(r6) == true) goto L4;
        r0.add(r6);
        Iterator<GroupMetaData> r7 = this.mGroupCacheList.iterator();
    L13:
        if (r7.hasNext() == false) goto L4;
        GroupMetaData r8 = r7.next();
        if (Objects.equal(r3, r8.getAccountName()) == false) goto L13;
        if (Objects.equal(r4, r8.getAccountType()) == false) goto L13;
        if (Objects.equal(r5, r8.getDataSet()) == false) goto L13;
        r9.addGroupMetaData(r8);
        goto L13
    }

    private void registerObserver() {
        if (this.mGroupObserver != null) goto L6;
        this.mGroupObserver = new GroupObserver(this, new Handler());
        this.mResolver.registerContentObserver(ContactsContract.Groups.CONTENT_URI, true, this.mGroupObserver);
        return;
    }

    private void unregisterObserver() {
        GroupObserver r0 = this.mGroupObserver;
        if (r0 == null) goto L6;
        this.mResolver.unregisterContentObserver(r0);
        this.mGroupObserver = null;
        return;
    }

    public synchronized void destroy() {
        monitor-enter(this);
        unregisterObserver();     // Catch: Throwable -> L12
        new Thread(new ContactDetailCacheManager$$ExternalSyntheticLambda0(this)).start();     // Catch: Throwable -> L12
        HandlerThread r0 = this.mHandlerThread;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.getLooper().quit();     // Catch: Throwable -> L12
    L6:
        LoaderHandler r1 = this.mHandler;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L12
    L9:
        this.mGroupCacheList.clear();     // Catch: Throwable -> L12
        this.mPreCallLogIds.clear();     // Catch: Throwable -> L12
        this.mLookupUriList.clear();     // Catch: Throwable -> L12
        sDetailCacheManager = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$destroy$0$com-android-contacts-list-ContactDetailCacheManager, reason: not valid java name */
    /* synthetic */ void m195x6617c3c2() {
        byte[] r0 = this.mLock;
        monitor-enter(r0);
        Cursor r1 = this.mEntitiesCursor;     // Catch: Throwable -> L38
        if (r1 != null) goto L7;
    L9:
        Cursor r2 = this.mDirectoryCursor;     // Catch: Throwable -> L38
        if (r2 != null) goto L12;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L38
        byte[] r3 = this.mCallLogLock;
        monitor-enter(r3);
        Cursor r4 = this.mCallLogCursor;     // Catch: Throwable -> L35
        if (r4 != null) goto L20;
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L35
        byte[] r5 = this.mBlockedCallLogLock;
        monitor-enter(r5);
        Cursor r6 = this.mBlockedCallLogCursor;     // Catch: Throwable -> L32
        if (r6 != null) goto L28;
    L30:
        monitor-exit(r5);     // Catch: Throwable -> L32
        return;
    L28:
        if (r6.isClosed() == true) goto L30;
        this.mBlockedCallLogCursor.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L20:
        if (r4.isClosed() == true) goto L22;
        this.mCallLogCursor.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L12:
        if (r2.isClosed() == true) goto L14;
        this.mDirectoryCursor.close();     // Catch: Throwable -> L38
        goto L14
    L7:
        if (r1.isClosed() == true) goto L9;
        this.mEntitiesCursor.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    public void initProfileCache(FragmentActivity r3, Uri r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.equals(this.mProfileUri) == true) goto L13;
        Bundle r0 = new Bundle();
        r0.putParcelable(KEY_PROFILE_URI, r4);
        LoaderManager r5 = LoaderManager.getInstance(r3);
        if (r5.getLoader(PROFILE_LOADER_ID) != null) goto L10;
        r5.initLoader(PROFILE_LOADER_ID, r0, this.mProfileLoaderListener);
        return;
    L10:
        r5.restartLoader(PROFILE_LOADER_ID, r0, this.mProfileLoaderListener);
        return;
    }

    public void destroyProfileLoader(FragmentActivity r3) {
        LoaderManager r4 = LoaderManager.getInstance(r3);
        if (r4.getLoader(PROFILE_LOADER_ID) == null) goto L5;
        r4.destroyLoader(PROFILE_LOADER_ID);
    L5:
        this.mProfileResult = null;
    }

    public Cursor getSubCursorForQuickContact(Uri r3) {
        Map<Uri, MatrixCursor> r0 = this.mCachedQuickContacts;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.containsKey(r3) == true) goto L7;
        return null;
    L7:
        if (ContactsUtils.DEBUG == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getSubCursorForQuickContact from cached results directly");
    L10:
        return this.mCachedQuickContacts.get(r3);
    }

    private void startQueryCallLog(ArrayList<Long> r6) {
        if (this.mPreCallLogIds.equals(r6) == true) goto L5;
        this.mPreCallLogIds.clear();
        this.mPreCallLogIds.addAll(r6);
        long[] r7 = new long[this.mPreCallLogIds.size()];
        Iterator<Long> r0 = this.mPreCallLogIds.iterator();
        int r1 = 0;
    L10:
        if (r0.hasNext() == false) goto L13;
        r7[r1] = r0.next().longValue();
        r1 = r1 + 1;
        goto L10
    L13:
        if (this.mHandler.hasMessages(3) == false) goto L16;
        this.mHandler.removeMessages(3);
    L16:
        if (this.mHandlerThread.isAlive() == false) goto L21;
        Message r2 = new Message();
        r2.what = 3;
        r2.obj = r7;
        this.mHandler.sendMessage(r2);
        return;
    L21:
        return;
    L5:
        if (DEBUG == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "All call log is contained in the pre-load cursor.");
        return;
    }

    private void startQueryBlockedCallLog(ArrayList<Long> r6) {
        if (this.mPreBlockedCallLogIds.equals(r6) == true) goto L5;
        this.mPreBlockedCallLogIds.clear();
        this.mPreBlockedCallLogIds.addAll(r6);
        long[] r7 = new long[this.mPreBlockedCallLogIds.size()];
        Iterator<Long> r0 = this.mPreBlockedCallLogIds.iterator();
        int r1 = 0;
    L10:
        if (r0.hasNext() == false) goto L13;
        r7[r1] = r0.next().longValue();
        r1 = r1 + 1;
        goto L10
    L13:
        if (this.mHandler.hasMessages(5) == false) goto L16;
        this.mHandler.removeMessages(5);
    L16:
        if (this.mHandlerThread.isAlive() == false) goto L21;
        Message r2 = new Message();
        r2.what = 5;
        r2.obj = r7;
        this.mHandler.sendMessage(r2);
        return;
    L21:
        return;
    L5:
        if (DEBUG == false) goto L20;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "All call log is contained in the pre-load cursor.");
        return;
    }

    private void cacheCallLog(long[] r9) {
        StringBuilder r0 = new StringBuilder("_id IN (");
        int r1 = r9.length;
        boolean r2 = true;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        long r5 = r9[r4];
        if (r2 == false) goto L7;
        r2 = false;
    L8:
        r0.append(r5);
        r4 = r4 + 1;
        goto L3
    L7:
        r0.append(SimContactsConstants.EMAIL_SEP);
        goto L8
    L9:
        r0.append(")");
        swapCallLogCursor(this.mContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, CallLogQuery._PROJECTION, r0.toString(), null, "date DESC"));
    }

    private void swapCallLogCursor(Cursor r3) {
        Cursor r0 = null;
        byte[] r1 = this.mCallLogLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        r0 = this.mCallLogCursor;     // Catch: Throwable -> L10
        this.mCallLogCursor = r3;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r0 == null) goto L20;
        r0.close();
        return;
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    }

    private void cacheBlockedCallLog(long[] r9) {
        StringBuilder r0 = new StringBuilder("_id IN (");
        int r1 = r9.length;
        boolean r2 = true;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        long r5 = r9[r4];
        if (r2 == false) goto L7;
        r2 = false;
    L8:
        r0.append(r5);
        r4 = r4 + 1;
        goto L3
    L7:
        r0.append(SimContactsConstants.EMAIL_SEP);
        goto L8
    L9:
        r0.append(")");
        swapBlockedCallLogCursor(this.mContext.getContentResolver().query(BlockedCall.INSTANCE.getBLOCKED_CALL_LOG_URI(), BlockedCall.INSTANCE.getBLOCKED_CALLS_PROJECTION(), r0.toString(), null, "bcl_datetime DESC"));
    }

    private void swapBlockedCallLogCursor(Cursor r3) {
        Cursor r0 = null;
        byte[] r1 = this.mBlockedCallLogLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        r0 = this.mBlockedCallLogCursor;     // Catch: Throwable -> L10
        this.mBlockedCallLogCursor = r3;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r0 == null) goto L20;
        r0.close();
        return;
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    }

    public PhoneCallDetails[] getPhoneCallDetails(long[] r19) {
        if (r19 != null) goto L5;
        return null;
    L5:
        if (r19.length == 0) goto L41;
        Arrays.sort(r19);
        PhoneCallDetails[] r2 = new PhoneCallDetails[r19.length];
        byte[] r3 = this.mCallLogLock;
        monitor-enter(r3);
        Cursor r4 = this.mCallLogCursor;     // Catch: Throwable -> L32
        if (r4 != null) goto L12;
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L32
        return r2;
    L12:
        if (r4.moveToFirst() == false) goto L30;
        int r5 = 0;
    L15:
        if (Arrays.binarySearch(r19, this.mCallLogCursor.getLong(0)) < 0) goto L29;
        boolean r7 = true;
        String r6 = this.mCallLogCursor.getString(1);     // Catch: Throwable -> L32
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        long r11 = this.mCallLogCursor.getLong(2);     // Catch: Throwable -> L32
        long r13 = this.mCallLogCursor.getLong(3);     // Catch: Throwable -> L32
        r2[r5] = new PhoneCallDetails(r6, new int[]{this.mCallLogCursor.getInt(4)}, r11, r13, UriUtils.parseUriOrNull(this.mCallLogCursor.getString(11)), this.mCallLogCursor.getString(30));     // Catch: Throwable -> L32
        if (DSUtils.isMultiSimEnabled() == false) goto L27;
        r2[r5].simId = DSUtils.getSimSlotId(this.mContext, CallLogQuery.getSubscription(this.mCallLogCursor), this.mCallLogCursor.getString(28));     // Catch: Throwable -> L32
        PhoneCallDetails r8 = r2[r5];     // Catch: Throwable -> L32
        if (this.mCallLogCursor.getInt(27) == 1) goto L26;
        r7 = false;
    L26:
        r8.showSimId = r7;     // Catch: Throwable -> L32
    L27:
        r5 = r5 + 1;     // Catch: Throwable -> L32
    L29:
        if (this.mCallLogCursor.moveToNext() == true) goto L15;
    L32:
        th = move-exception;
        throw th;
    L41:
        return null;
    }

    public PhoneCallDetails[] getBlockedCallDetails(long[] r20) {
        if (r20 != null) goto L5;
        return null;
    L5:
        if (r20.length == 0) goto L44;
        Arrays.sort(r20);
        PhoneCallDetails[] r2 = new PhoneCallDetails[r20.length];
        if (DSUtils.isMultiSimEnabled() == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        byte[] r6 = this.mBlockedCallLogLock;
        monitor-enter(r6);
        Cursor r7 = this.mBlockedCallLogCursor;     // Catch: Throwable -> L35
        if (r7 != null) goto L18;
    L33:
        monitor-exit(r6);     // Catch: Throwable -> L35
        return r2;
    L18:
        if (r7.moveToFirst() == false) goto L33;
        int r8 = 0;
    L20:
        BlockedCallEntity r9 = ObricCallLogProviderHelper.INSTANCE.cursorToBlockedCallEntity(this.mBlockedCallLogCursor, r3);     // Catch: Throwable -> L35
        if (Arrays.binarySearch(r20, r9.getId()) < 0) goto L32;
        r2[r8] = new PhoneCallDetails(r9.getNumber(), new int[]{r9.getCallType()}, r9.getDate(), 0, null, null);     // Catch: Throwable -> L35
        if (DSUtils.isMultiSimEnabled() == false) goto L30;
        r2[r8].simId = r9.getSimId();     // Catch: Throwable -> L35
        PhoneCallDetails r10 = r2[r8];     // Catch: Throwable -> L35
        if (r9.getShowSimIcon() != 1) goto L28;
        boolean r11 = true;
    L29:
        r10.showSimId = r11;     // Catch: Throwable -> L35
        goto L30
    L28:
        r11 = false;
    L30:
        r8 = r8 + 1;     // Catch: Throwable -> L35
    L32:
        if (this.mBlockedCallLogCursor.moveToNext() == true) goto L20;
    L35:
        th = move-exception;
        throw th;
    L10:
        if (DSUtils.isAllSimsEnable() == false) goto L12;
        r3 = true;
        goto L13
    L44:
        return null;
    }
}
