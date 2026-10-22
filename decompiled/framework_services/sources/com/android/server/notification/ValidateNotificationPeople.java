package com.android.server.notification;

import android.app.Person;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.LruCache;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class ValidateNotificationPeople implements NotificationSignalExtractor {
    private static final boolean DEBUG = false;
    private static final boolean ENABLE_PEOPLE_VALIDATOR = true;
    private static final String[] LOOKUP_PROJECTION = null;
    private static final int MAX_PEOPLE = 10;
    static final float NONE = 0.0f;
    private static final int PEOPLE_CACHE_SIZE = 200;
    static final String[] PHONE_LOOKUP_PROJECTION = null;
    private static final String SETTING_ENABLE_PEOPLE_VALIDATOR = "validate_notification_people_enabled";
    static final float STARRED_CONTACT = 1.0f;
    private static final String TAG = "ValidateNoPeople";
    static final float VALID_CONTACT = 0.5f;
    private static final boolean VERBOSE = false;
    private Context mBaseContext;
    protected boolean mEnabled;
    private int mEvictionCount;
    private Handler mHandler;
    private ContentObserver mObserver;
    private LruCache<String, LookupResult> mPeopleCache;
    private NotificationUsageStats mUsageStats;
    private Map<Integer, Context> mUserToContextMap;

    protected static class LookupResult {
        private static final long CONTACT_REFRESH_MILLIS = 3600000;
        private float mAffinity;
        private final long mExpireMillis;
        private boolean mHasPhone;
        private String mPhoneLookupKey;
        private ArraySet<String> mPhoneNumbers;

        public LookupResult() {
            this.mAffinity = ValidateNotificationPeople.NONE;
            this.mHasPhone = false;
            this.mPhoneLookupKey = null;
            this.mPhoneNumbers = new ArraySet();
            this.mExpireMillis = System.currentTimeMillis() + 3600000;
        }

        public void mergeContact(Cursor cursor) {
            this.mAffinity = Math.max(this.mAffinity, ValidateNotificationPeople.VALID_CONTACT);
            int idIdx = cursor.getColumnIndex("_id");
            if (idIdx < 0) goto L7;
            int id = cursor.getInt(idIdx);
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L8;
            Slog.d(ValidateNotificationPeople.TAG, "contact _ID is: " + id);
        L8:
            int lookupKeyIdx = cursor.getColumnIndex("lookup");
            if (lookupKeyIdx < 0) goto L14;
            this.mPhoneLookupKey = cursor.getString(lookupKeyIdx);
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L16;
            Slog.d(ValidateNotificationPeople.TAG, "contact LOOKUP_KEY is: " + this.mPhoneLookupKey);
        L16:
            int starIdx = cursor.getColumnIndex("starred");
            boolean r5 = false;
            if (starIdx < 0) goto L29;
            if (cursor.getInt(starIdx) == 0) goto L21;
            boolean isStarred = true;
        L22:
            if (isStarred == false) goto L25;
            this.mAffinity = Math.max(this.mAffinity, 1.0f);
        L25:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L31;
            Slog.d(ValidateNotificationPeople.TAG, "contact STARRED is: " + isStarred);
        L31:
            int hasPhoneIdx = cursor.getColumnIndex("has_phone_number");
            if (hasPhoneIdx < 0) goto L40;
            if (cursor.getInt(hasPhoneIdx) == 0) goto L36;
            r5 = true;
        L36:
            this.mHasPhone = r5;
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L43;
            Slog.d(ValidateNotificationPeople.TAG, "contact HAS_PHONE_NUMBER is: " + this.mHasPhone);
            return;
        L43:
            return;
        L40:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L45;
            Slog.d(ValidateNotificationPeople.TAG, "invalid cursor: no HAS_PHONE_NUMBER");
            return;
        L45:
            return;
        L21:
            isStarred = false;
            goto L22
        L29:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L31;
            Slog.d(ValidateNotificationPeople.TAG, "invalid cursor: no STARRED");
            goto L31
        L14:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L16;
            Slog.d(ValidateNotificationPeople.TAG, "invalid cursor: no LOOKUP_KEY");
            goto L16
        L7:
            Slog.i(ValidateNotificationPeople.TAG, "invalid cursor: no _ID");
            goto L8
        }

        public String getPhoneLookupKey() {
            if (this.mHasPhone == true) goto L7;
            return null;
        L7:
            return this.mPhoneLookupKey;
        }

        public void mergePhoneNumber(Cursor cursor) {
            int normalizedNumIdx = cursor.getColumnIndex("data4");
            if (normalizedNumIdx < 0) goto L6;
            this.mPhoneNumbers.add(cursor.getString(normalizedNumIdx));
        L8:
            int numIdx = cursor.getColumnIndex("data1");
            if (numIdx < 0) goto L12;
            this.mPhoneNumbers.add(cursor.getString(numIdx));
            return;
        L12:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L16;
            Slog.d(ValidateNotificationPeople.TAG, "cursor data not found: no NUMBER");
            return;
        L16:
            return;
        L6:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L8;
            Slog.d(ValidateNotificationPeople.TAG, "cursor data not found: no NORMALIZED_NUMBER");
            goto L8
        }

        public ArraySet<String> getPhoneNumbers() {
            return this.mPhoneNumbers;
        }

        protected boolean isExpired() {
            if (this.mExpireMillis >= System.currentTimeMillis()) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isInvalid() {
            if (this.mAffinity != ValidateNotificationPeople.NONE) goto L5;
        L8:
            return true;
        L5:
            if (isExpired() == true) goto L8;
            return false;
        }

        public float getAffinity() {
            if (isInvalid() == false) goto L7;
            return ValidateNotificationPeople.NONE;
        L7:
            return this.mAffinity;
        }
    }

    class PeopleRankingReconsideration extends RankingReconsideration {
        private float mContactAffinity;
        private final Context mContext;
        private final LinkedList<String> mPendingLookups;
        private ArraySet<String> mPhoneNumbers;
        private NotificationRecord mRecord;
        final /* synthetic */ ValidateNotificationPeople this$0;

        /* synthetic */ PeopleRankingReconsideration(ValidateNotificationPeople r1, Context r2, String r3, LinkedList r4, ValidateNotificationPeopleIA r5) {
            this(r1, r2, r3, r4);
        }

        private PeopleRankingReconsideration(ValidateNotificationPeople this$0, Context context, String key, LinkedList<String> pendingLookups) {
            this.this$0 = this$0;
            super(key);
            this.mContactAffinity = ValidateNotificationPeople.NONE;
            this.mPhoneNumbers = null;
            this.mContext = context;
            this.mPendingLookups = pendingLookups;
        }

        @Override // com.android.server.notification.RankingReconsideration
        public void work() {
            if (ValidateNotificationPeople.m6299$$Nest$sfgetVERBOSE() == false) goto L5;
            Slog.i(ValidateNotificationPeople.TAG, "Executing: validation for: " + this.mKey);
        L5:
            long timeStartMs = System.currentTimeMillis();
            Iterator<String> r2 = this.mPendingLookups.iterator();
        L7:
            if (r2.hasNext() == false) goto L66;
            String handle = r2.next();
            String cacheKey = ValidateNotificationPeople.getCacheKey(this.mContext.getUserId(), handle);
            boolean cacheHit = false;
            LruCache r6 = ValidateNotificationPeople.m6294$$Nest$fgetmPeopleCache(this.this$0);
            monitor-enter(r6);
            LookupResult lookupResult = (LookupResult) ValidateNotificationPeople.m6294$$Nest$fgetmPeopleCache(this.this$0).get(cacheKey);     // Catch: Throwable -> L15
            if (lookupResult != null) goto L13;
        L17:
            monitor-exit(r6);     // Catch: Throwable -> L15
            if (cacheHit == true) goto L40;
            Uri uri = Uri.parse(handle);
            if ("tel".equals(uri.getScheme()) == false) goto L26;
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L24;
            Slog.d(ValidateNotificationPeople.TAG, "checking telephone URI: " + handle);
        L24:
            lookupResult = resolvePhoneContact(this.mContext, uri.getSchemeSpecificPart());
            goto L40
        L26:
            if ("mailto".equals(uri.getScheme()) == false) goto L32;
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L30;
            Slog.d(ValidateNotificationPeople.TAG, "checking mailto URI: " + handle);
        L30:
            lookupResult = resolveEmailContact(this.mContext, uri.getSchemeSpecificPart());
            goto L40
        L32:
            if (handle.startsWith(ContactsContract.Contacts.CONTENT_LOOKUP_URI.toString()) == true) goto L34;
            lookupResult = new LookupResult();
            if ("name".equals(uri.getScheme()) == true) goto L40;
            Slog.w(ValidateNotificationPeople.TAG, "unsupported URI " + handle);
            goto L40
        L34:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L36;
            Slog.d(ValidateNotificationPeople.TAG, "checking lookup URI: " + handle);
        L36:
            lookupResult = searchContactsAndLookupNumbers(this.mContext, uri);
        L40:
            if (lookupResult != null) goto L41;
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L7;
            Slog.d(ValidateNotificationPeople.TAG, "lookupResult is null");
            goto L7
        L41:
            if (cacheHit == true) goto L51;
            LruCache r7 = ValidateNotificationPeople.m6294$$Nest$fgetmPeopleCache(this.this$0);
            monitor-enter(r7);
            ValidateNotificationPeople.m6294$$Nest$fgetmPeopleCache(this.this$0).put(cacheKey, lookupResult);     // Catch: Throwable -> L47
            monitor-exit(r7);     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;
        L51:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L53;
            Slog.d(ValidateNotificationPeople.TAG, "lookup contactAffinity is " + lookupResult.getAffinity());
        L53:
            this.mContactAffinity = Math.max(this.mContactAffinity, lookupResult.getAffinity());
            if (lookupResult.getPhoneNumbers() == null) goto L7;
            if (this.mPhoneNumbers != null) goto L58;
            this.mPhoneNumbers = new ArraySet();
        L58:
            this.mPhoneNumbers.addAll(lookupResult.getPhoneNumbers());
            goto L7
        L13:
            if (lookupResult.isExpired() == true) goto L17;
            cacheHit = true;
        L15:
            th = move-exception;
            throw th;
        L66:
            if (ValidateNotificationPeople.m6297$$Nest$sfgetDEBUG() == false) goto L69;
            Slog.d(ValidateNotificationPeople.TAG, "Validation finished in " + (System.currentTimeMillis() - timeStartMs) + "ms");
        L69:
            if (this.mRecord == null) goto L94;
            NotificationUsageStats r3 = ValidateNotificationPeople.m6295$$Nest$fgetmUsageStats(this.this$0);
            NotificationRecord r4 = this.mRecord;
            boolean r5 = true;
            if (this.mContactAffinity <= ValidateNotificationPeople.NONE) goto L73;
            boolean r8 = true;
        L75:
            if (this.mContactAffinity == 1.0f) goto L78;
            r5 = false;
        L78:
            r3.registerPeopleAffinity(r4, r8, r5, false);
            return;
        L73:
            r8 = false;
            goto L75
        }

        private static LookupResult resolvePhoneContact(Context context, String number) {
            Uri phoneUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
            return searchContacts(context, phoneUri);
        }

        private static LookupResult resolveEmailContact(Context context, String email) {
            Uri numberUri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_LOOKUP_URI, Uri.encode(email));
            return searchContacts(context, numberUri);
        }

        static LookupResult searchContacts(Context context, Uri lookupUri) {
            LookupResult lookupResult = new LookupResult();
            Uri corpLookupUri = ContactsContract.Contacts.createCorpLookupUriFromEnterpriseLookupUri(lookupUri);
            if (corpLookupUri != null) goto L5;
            addContacts(lookupResult, context, lookupUri);
        L6:
            return lookupResult;
        L5:
            addWorkContacts(lookupResult, context, corpLookupUri);
            goto L6
        }

        static LookupResult searchContactsAndLookupNumbers(Context context, Uri lookupUri) {
            LookupResult lookupResult = searchContacts(context, lookupUri);
            String phoneLookupKey = lookupResult.getPhoneLookupKey();
            if (phoneLookupKey == null) goto L31;
            String[] selectionArgs = {phoneLookupKey};
            Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, ValidateNotificationPeople.PHONE_LOOKUP_PROJECTION, "lookup = ?", selectionArgs, null);     // Catch: Throwable -> L12
            if (cursor != null) goto L18;
            Slog.w(ValidateNotificationPeople.TAG, "Cursor is null when querying contact phone number.");     // Catch: Throwable -> L15
            if (cursor == null) goto L14;
            cursor.close();     // Catch: Throwable -> L12
        L14:
            return lookupResult;
        L18:
            if (cursor.moveToNext() == false) goto L21;
            lookupResult.mergePhoneNumber(cursor);     // Catch: Throwable -> L15
            goto L18
        L21:
            cursor.close();     // Catch: Throwable -> L12
        L15:
            th = move-exception;
            if (cursor == null) goto L37;
            cursor.close();     // Catch: Throwable -> L26
        L38:
            throw th;     // Catch: Throwable -> L12
        L26:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L37:
            throw th;     // Catch: Throwable -> L12
        L12:
            t = move-exception;
            Slog.w(ValidateNotificationPeople.TAG, "Problem getting content resolver or querying phone numbers.", t);
        L31:
            return lookupResult;
        }

        private static void addWorkContacts(LookupResult lookupResult, Context context, Uri corpLookupUri) {
            int workUserId = findWorkUserId(context);
            if (workUserId != (-1)) goto L6;
            Slog.w(ValidateNotificationPeople.TAG, "Work profile user ID not found for work contact: " + corpLookupUri);
            return;
        L6:
            Uri corpLookupUriWithUserId = ContentProvider.maybeAddUserId(corpLookupUri, workUserId);
            addContacts(lookupResult, context, corpLookupUriWithUserId);
        }

        private static int findWorkUserId(Context context) {
            UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
            int[] profileIds = userManager.getProfileIds(context.getUserId(), true);
            int r2 = profileIds.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            int profileId = profileIds[r3];
            if (userManager.isManagedProfile(profileId) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return profileId;
        L8:
            return -1;
        }

        private static void addContacts(LookupResult lookupResult, Context context, Uri uri) {
            Cursor c = context.getContentResolver().query(uri, ValidateNotificationPeople.m6298$$Nest$sfgetLOOKUP_PROJECTION(), null, null, null);     // Catch: Throwable -> L11
            if (c != null) goto L17;
            Slog.w(ValidateNotificationPeople.TAG, "Null cursor from contacts query.");     // Catch: Throwable -> L14
            if (c == null) goto L13;
            c.close();     // Catch: Throwable -> L11
            return;
        L13:
            return;
        L17:
            if (c.moveToNext() == false) goto L20;
            lookupResult.mergeContact(c);     // Catch: Throwable -> L14
            goto L17
        L20:
            c.close();     // Catch: Throwable -> L11
            return;
        L14:
            th = move-exception;
            if (c == null) goto L41;
            c.close();     // Catch: Throwable -> L25
        L42:
            throw th;     // Catch: Throwable -> L11
        L25:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L41:
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Throwable t = th;
        L31:
            Slog.w(ValidateNotificationPeople.TAG, "Problem getting content resolver or performing contacts query.", t);
            return;
        L29:
            th = move-exception;
            t = th;
            goto L31
        }

        @Override // com.android.server.notification.RankingReconsideration
        public void applyChangesLocked(NotificationRecord operand) {
            float affinityBound = operand.getContactAffinity();
            operand.setContactAffinity(Math.max(this.mContactAffinity, affinityBound));
            if (ValidateNotificationPeople.m6299$$Nest$sfgetVERBOSE() == false) goto L5;
            Slog.i(ValidateNotificationPeople.TAG, "final affinity: " + operand.getContactAffinity());
        L5:
            operand.mergePhoneNumbers(this.mPhoneNumbers);
        }

        public float getContactAffinity() {
            return this.mContactAffinity;
        }

        public void setRecord(NotificationRecord record) {
            this.mRecord = record;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvictionCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6293$$Nest$fgetmEvictionCount(ValidateNotificationPeople r0) {
        return r0.mEvictionCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPeopleCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ LruCache m6294$$Nest$fgetmPeopleCache(ValidateNotificationPeople r0) {
        return r0.mPeopleCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsageStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationUsageStats m6295$$Nest$fgetmUsageStats(ValidateNotificationPeople r0) {
        return r0.mUsageStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEvictionCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6296$$Nest$fputmEvictionCount(ValidateNotificationPeople r0, int r1) {
        r0.mEvictionCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6297$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOOKUP_PROJECTION, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m6298$$Nest$sfgetLOOKUP_PROJECTION() {
        return LOOKUP_PROJECTION;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetVERBOSE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6299$$Nest$sfgetVERBOSE() {
        return VERBOSE;
    }

    public ValidateNotificationPeople() {
    }

    static {
        VERBOSE = Log.isLoggable(TAG, 2);
        DEBUG = Log.isLoggable(TAG, 3);
        LOOKUP_PROJECTION = new String[]{"_id", "lookup", "starred", "has_phone_number"};
        PHONE_LOOKUP_PROJECTION = new String[]{"data4", "data1"};
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context context, NotificationUsageStats usageStats) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Initializing  " + getClass().getSimpleName() + ".");
    L5:
        this.mUserToContextMap = new ArrayMap();
        this.mBaseContext = context;
        this.mUsageStats = usageStats;
        this.mPeopleCache = new LruCache(200);
        if (1 != Settings.Global.getInt(this.mBaseContext.getContentResolver(), SETTING_ENABLE_PEOPLE_VALIDATOR, 1)) goto L8;
        boolean r0 = true;
    L9:
        this.mEnabled = r0;
        if (this.mEnabled == false) goto L13;
        this.mHandler = new Handler();
        final Handler r1 = this.mHandler;
        this.mObserver = new AnonymousClass1(this, r1);
        this.mBaseContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mObserver, -1);
        return;
    L13:
        return;
    L8:
        r0 = false;
        goto L9
    }

    protected void initForTests(Context context, NotificationUsageStats usageStats, LruCache<String, LookupResult> peopleCache) {
        this.mUserToContextMap = new ArrayMap();
        this.mBaseContext = context;
        this.mUsageStats = usageStats;
        this.mPeopleCache = peopleCache;
        this.mEnabled = true;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (this.mEnabled == false) goto L5;
        if (record == null) goto L27;
        if (record.getNotification() == null) goto L27;
        if (record.getUserId() == (-1)) goto L15;
        Context context = getContextAsUser(record.getUser());
        if (context != null) goto L25;
        if (VERBOSE == false) goto L23;
        Slog.i(TAG, "skipping notification that lacks a context");
    L23:
        return null;
    L25:
        return validatePeople(context, record);
    L15:
        if (VERBOSE == false) goto L17;
        Slog.i(TAG, "skipping global notification");
    L17:
        return null;
    L27:
        if (VERBOSE == false) goto L29;
        Slog.i(TAG, "skipping empty notification");
    L29:
        return null;
    L5:
        if (VERBOSE == false) goto L7;
        Slog.i(TAG, ServiceConfigAccessor.PROVIDER_MODE_DISABLED);
    L7:
        return null;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }

    public float getContactAffinity(UserHandle userHandle, Bundle extras, int timeoutMs, float timeoutAffinity) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "checking affinity for " + userHandle);
    L6:
        if (extras != null) goto L8;
        return NONE;
    L8:
        String key = Long.toString(System.nanoTime());
        float[] affinityOut = new float[1];
        Context context = getContextAsUser(userHandle);
        if (context != null) goto L11;
        return NONE;
    L11:
        final PeopleRankingReconsideration prr = validatePeople(context, key, extras, null, affinityOut, null);
        float affinity = affinityOut[0];
        if (prr == null) goto L24;
        final Semaphore s = new Semaphore(0);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass2(this, prr, s));
    L18:
        e = move-exception;
        Slog.w(TAG, "InterruptedException while waiting for affinity: " + key + ". Returning affinity=" + affinity, e);
        return affinity;
    L15:
        if (s.tryAcquire(timeoutMs, TimeUnit.MILLISECONDS) == true) goto L27;
        Slog.w(TAG, "Timeout while waiting for affinity: " + key + ". Returning timeoutAffinity=" + timeoutAffinity);     // Catch: InterruptedException -> L18
        return timeoutAffinity;
    L27:
        return Math.max(prr.getContactAffinity(), affinity);
    L24:
        return affinity;
    }

    private Context getContextAsUser(UserHandle userHandle) {
        Context context = this.mUserToContextMap.get(Integer.valueOf(userHandle.getIdentifier()));
        if (context != null) goto L11;
        context = this.mBaseContext.createPackageContextAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, userHandle);     // Catch: PackageManager.NameNotFoundException -> L6
        this.mUserToContextMap.put(Integer.valueOf(userHandle.getIdentifier()), context);     // Catch: PackageManager.NameNotFoundException -> L6
        return context;
    L6:
        e = move-exception;
        Log.e(TAG, "failed to create package context for lookups", e);
        return context;
    L11:
        return context;
    }

    protected RankingReconsideration validatePeople(Context context, NotificationRecord record) {
        String key = record.getKey();
        Bundle extras = record.getNotification().extras;
        float[] affinityOut = new float[1];
        ArraySet<String> phoneNumbersOut = new ArraySet();
        PeopleRankingReconsideration rr = validatePeople(context, key, extras, record.getPeopleOverride(), affinityOut, phoneNumbersOut);
        boolean r4 = false;
        float affinity = affinityOut[0];
        record.setContactAffinity(affinity);
        if (phoneNumbersOut.size() <= 0) goto L5;
        record.mergePhoneNumbers(phoneNumbersOut);
    L5:
        if (rr != null) goto L14;
        NotificationUsageStats r9 = this.mUsageStats;
        if (affinity <= NONE) goto L9;
        boolean r10 = true;
    L11:
        if (affinity != 1.0f) goto L13;
        r4 = true;
    L13:
        r9.registerPeopleAffinity(record, r10, r4, true);
    L15:
        return rr;
    L9:
        r10 = false;
        goto L11
    L14:
        rr.setRecord(record);
        goto L15
    }

    private PeopleRankingReconsideration validatePeople(Context context, String key, Bundle extras, List<String> peopleOverride, float[] affinityOut, ArraySet<String> phoneNumbersOut) {
        PeopleRankingReconsideration r2 = null;
        if (extras != null) goto L5;
        return null;
    L5:
        Set<String> people = new ArraySet(peopleOverride);
        String[] notificationPeople = getExtraPeople(extras);
        if (notificationPeople == null) goto L9;
        people.addAll(Arrays.asList(notificationPeople));
    L9:
        if (VERBOSE == false) goto L11;
        Slog.i(TAG, "Validating: " + key + " for " + context.getUserId());
    L11:
        LinkedList<String> pendingLookups = new LinkedList();
        Iterator<String> r10 = people.iterator();
        int personIdx = 0;
        float affinity = 0.0f;
    L13:
        if (r10.hasNext() == false) goto L47;
        String handle = r10.next();
        if (TextUtils.isEmpty(handle) == true) goto L13;
        LruCache<String, LookupResult> r13 = this.mPeopleCache;
        monitor-enter(r13);
        String cacheKey = getCacheKey(context.getUserId(), handle);     // Catch: Throwable -> L27
        LookupResult lookupResult = this.mPeopleCache.get(cacheKey);     // Catch: Throwable -> L27
        if (lookupResult == null) goto L31;
        if (lookupResult.isExpired() == true) goto L31;
        if (DEBUG == false) goto L29;
        r2 = r2;
        Slog.d(TAG, "using cached lookupResult");     // Catch: Throwable -> L27
    L32:
        if (lookupResult == null) goto L40;
        affinity = Math.max(affinity, lookupResult.getAffinity());     // Catch: Throwable -> L27
        if (phoneNumbersOut == null) goto L40;
        ArraySet<String> phoneNumbers = lookupResult.getPhoneNumbers();     // Catch: Throwable -> L27
        if (phoneNumbers == null) goto L40;
        if (phoneNumbers.size() <= 0) goto L40;
        phoneNumbersOut.addAll(phoneNumbers);     // Catch: Throwable -> L27
    L40:
        monitor-exit(r13);     // Catch: Throwable -> L27
        personIdx = personIdx + 1;     // Catch: Throwable -> L27
        if (personIdx == 10) goto L43;
        r2 = r2;
        goto L13
    L43:
        float affinity2 = affinity;
    L48:
        affinityOut[0] = affinity2;
        if (pendingLookups.isEmpty() == false) goto L55;
        if (VERBOSE == false) goto L53;
        Slog.i(TAG, "final affinity: " + affinity2);
    L53:
        return r2;
    L55:
        if (DEBUG == false) goto L58;
        Slog.d(TAG, "Pending: future work scheduled for: " + key);
    L58:
        return new PeopleRankingReconsideration(this, context, key, pendingLookups, null);
    L29:
        r2 = r2;
    L31:
        pendingLookups.add(handle);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L47:
        r2 = r2;
        affinity2 = affinity;
        goto L48
    }

    protected static String getCacheKey(int userId, String handle) {
        return Integer.toString(userId) + ":" + handle;
    }

    public static String[] getExtraPeople(Bundle extras) {
        String[] peopleList = getExtraPeopleForKey(extras, "android.people.list");
        String[] legacyPeople = getExtraPeopleForKey(extras, "android.people");
        return combineLists(legacyPeople, peopleList);
    }

    private static String[] combineLists(String[] first, String[] second) {
        if (first != null) goto L4;
        return second;
    L4:
        if (second != null) goto L6;
        return first;
    L6:
        ArraySet<String> people = new ArraySet(first.length + second.length);
        int r1 = first.length;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        String person = first[r3];
        people.add(person);
        r3 = r3 + 1;
        goto L7
    L9:
        int r4 = second.length;
    L10:
        if (r2 >= r4) goto L13;
        String person2 = second[r2];
        people.add(person2);
        r2 = r2 + 1;
        goto L10
    L13:
        return (String[]) people.toArray(EmptyArray.STRING);
    }

    private static String[] getExtraPeopleForKey(Bundle extras, String key) {
        Object people = extras.get(key);
        if ((people instanceof String[]) == false) goto L7;
        return (String[]) people;
    L7:
        if ((people instanceof ArrayList) == false) goto L31;
        ArrayList arrayList = (ArrayList) people;
        if (arrayList.isEmpty() == false) goto L12;
        return null;
    L12:
        if ((arrayList.get(0) instanceof String) == false) goto L16;
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    L16:
        if ((arrayList.get(0) instanceof CharSequence) == false) goto L23;
        int N = arrayList.size();
        String[] array = new String[N];
        int i = 0;
    L18:
        if (i >= N) goto L21;
        array[i] = ((CharSequence) arrayList.get(i)).toString();
        i = i + 1;
        goto L18
    L21:
        return array;
    L23:
        if ((arrayList.get(0) instanceof Person) == false) goto L29;
        int N2 = arrayList.size();
        String[] array2 = new String[N2];
        int i2 = 0;
    L25:
        if (i2 >= N2) goto L28;
        array2[i2] = ((Person) arrayList.get(i2)).resolveToLegacyUri();
        i2 = i2 + 1;
        goto L25
    L28:
        return array2;
    L29:
        return null;
    L31:
        if ((people instanceof String) == false) goto L35;
        return new String[]{(String) people};
    L35:
        if ((people instanceof char[]) == false) goto L39;
        return new String[]{new String((char[]) people)};
    L39:
        if ((people instanceof CharSequence) == false) goto L43;
        return new String[]{((CharSequence) people).toString()};
    L43:
        if ((people instanceof CharSequence[]) == false) goto L49;
        CharSequence[] charSeqArray = (CharSequence[]) people;
        int N3 = charSeqArray.length;
        String[] array3 = new String[N3];
        int i3 = 0;
    L45:
        if (i3 >= N3) goto L48;
        array3[i3] = charSeqArray[i3].toString();
        i3 = i3 + 1;
        goto L45
    L48:
        return array3;
    L49:
        return null;
    }
}
