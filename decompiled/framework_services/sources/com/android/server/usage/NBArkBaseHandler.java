package com.android.server.usage;

import android.app.usage.UsageEvents;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Slog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class NBArkBaseHandler extends Handler {
    private static final String AB_USAGE_TIME_TABLE_BEGIN_TIME_COL = "begin_time";
    private static final String AB_USAGE_TIME_TABLE_END_TIME_COL = "end_time";
    private static final String AB_USAGE_TIME_TABLE_PACKAGE_NAME_COL = "packageName";
    private static final String AB_USAGE_TIME_TABLE_PRIMARY_LABEL_COL = "primaryLabel";
    private static final String AB_USAGE_TIME_TABLE_SECONDARY_LABEL_COL = "secondaryLabel";
    private static final String ARK_BASE_URI = "content://cn.nubia.arkbase.provider/ark_base_usage_time";
    private static final String ATTR_APP_NAME = "component";
    private static final String GAME_SPACE_URI = "content://cn.nubia.gamelauncher.db.AppAddProvider/appadd?notify=false";
    public static final long HALF_MINS_IN_MILLIS = 30000;
    public static final int MSG_HANDLE_EVENT = 1;
    public static final int MSG_INIT_DATA_EVENT = 2;
    private static final String TAG = "NBArkBaseHandler";
    private Context mContext;
    private HashSet<String> mGameApps;
    private final Object mGameListLock;
    private ContentObserver mGameSpaceListChanged;
    private PackageManager mPkgMgr;
    private ContentResolver mResolver;
    private Map<Integer, UsageEvents.Event> mResumedEvents;

    /* JADX INFO: renamed from: -$$Nest$mupdateGameAppList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9096$$Nest$mupdateGameAppList(NBArkBaseHandler r0) {
        r0.updateGameAppList();
    }

    public NBArkBaseHandler(Context context, Looper looper) {
        super(looper);
        this.mGameListLock = new Object();
        this.mGameApps = new HashSet();
        this.mResumedEvents = new HashMap();
        this.mGameSpaceListChanged = new AnonymousClass1(this, this);
        this.mContext = context;
        this.mResolver = this.mContext.getContentResolver();
        this.mPkgMgr = this.mContext.getPackageManager();
    }

    private void initGameAppsList() {
        updateGameAppList();
        registerContentObserver();
    }

    private void updateGameAppList() {
        Cursor cursor = this.mResolver.query(Uri.parse(GAME_SPACE_URI), null, null, null, null);     // Catch: Exception -> L29
        if (cursor != null) goto L41;
    L33:
        if (cursor == null) goto L52;
        cursor.close();     // Catch: Exception -> L29
        return;
    L52:
        return;
    L41:
        int index = cursor.getColumnIndex(ATTR_APP_NAME);     // Catch: Throwable -> L13
        HashSet<String> temp = new HashSet();     // Catch: Throwable -> L13
        cursor.moveToPosition(-1);     // Catch: Throwable -> L13
    L7:
        if (cursor.moveToNext() == false) goto L16;
        String appinfo = cursor.getString(index);     // Catch: Throwable -> L13
        String[] array = appinfo.split(",");     // Catch: Throwable -> L13
        if (array == null) goto L7;
        if (TextUtils.isEmpty(array[0]) == true) goto L7;
        temp.add(array[0]);     // Catch: Throwable -> L13
        goto L7
    L16:
        Object r4 = this.mGameListLock;     // Catch: Throwable -> L13
        monitor-enter(r4);     // Catch: Throwable -> L13
        this.mGameApps = temp;     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (cursor != null) goto L43;
        throw th;     // Catch: Exception -> L29
    L43:
        cursor.close();     // Catch: Throwable -> L27
    L50:
        throw th;     // Catch: Exception -> L29
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L9;
        };
    L5:
        initGameAppsList();
        return;
    L6:
        handleEvent((UsageEvents.Event) msg.obj);
        return;
    }

    private void handleEvent(UsageEvents.Event event) {
        String pkgname = event.mPackage;
        Object r1 = this.mGameListLock;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mGameApps.size() == 0) goto L21;
        if (this.mGameApps.contains(pkgname) == false) goto L21;
        monitor-exit(r1);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(pkgname) == false) goto L14;
        return;
    L14:
        switch(event.mEventType) {
            case 1: goto L17;
            case 2: goto L16;
            case 23: goto L16;
            case 26: goto L16;
            default: goto L27;
        };
    L16:
        handleEndEvent(event);
        return;
    L17:
        this.mResumedEvents.put(Integer.valueOf(event.mInstanceId), copyFrom(event));
        return;
    L27:
        return;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L19
    }

    private void handleEndEvent(UsageEvents.Event event) {
        UsageEvents.Event resumedEvent = this.mResumedEvents.get(Integer.valueOf(event.mInstanceId));
        if (resumedEvent == null) goto L9;
        long during = event.mTimeStamp - resumedEvent.mTimeStamp;
        if (during <= 30000) goto L7;
        ContentValues values = createContentValues(resumedEvent, event);
        persistData(values);
    L7:
        this.mResumedEvents.remove(Integer.valueOf(event.mInstanceId));
        return;
    }

    private ContentValues createContentValues(UsageEvents.Event startEvent, UsageEvents.Event endEvent) {
        ContentValues values = new ContentValues();
        values.put("packageName", startEvent.mPackage);
        values.put(AB_USAGE_TIME_TABLE_BEGIN_TIME_COL, Long.valueOf(startEvent.mTimeStamp));
        values.put(AB_USAGE_TIME_TABLE_END_TIME_COL, Long.valueOf(endEvent.mTimeStamp));
        String label = getAppLabel(startEvent.mPackage);
        if (isChineseLanguage() == false) goto L5;
        values.put(AB_USAGE_TIME_TABLE_PRIMARY_LABEL_COL, label);
    L6:
        return values;
    L5:
        values.put(AB_USAGE_TIME_TABLE_SECONDARY_LABEL_COL, label);
        goto L6
    }

    private void persistData(ContentValues values) {
        Uri uri = this.mResolver.insert(Uri.parse(ARK_BASE_URI), values);     // Catch: Exception -> L4
        Slog.i(TAG, "persistData uri : " + uri);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void registerContentObserver() {
        this.mResolver.registerContentObserver(Uri.parse(GAME_SPACE_URI), false, this.mGameSpaceListChanged);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void unregisterContentObserver() {
        this.mResolver.unregisterContentObserver(this.mGameSpaceListChanged);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isArkBaseAppExist(Context context) {
        PackageManager pm = context.getPackageManager();
        pm.getApplicationInfo("cn.nubia.arkbase", 8192);     // Catch: PackageManager.NameNotFoundException -> L6
        Slog.i(TAG, "isArkBaseAppExist : true");     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L7:
        Slog.i(TAG, "isArkBaseAppExist : false");
        return false;
    }

    private String getAppLabel(String pkgname) {
        CharSequence label = null;
        ApplicationInfo appInfo = this.mPkgMgr.getApplicationInfo(pkgname, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (appInfo == null) goto L11;
        label = appInfo.loadLabel(this.mPkgMgr);     // Catch: PackageManager.NameNotFoundException -> L7
    L11:
        if (label != null) goto L17;
        return "";
    L17:
        return label.toString();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private boolean isChineseLanguage() {
        String language = "";
        language = Locale.getDefault().getLanguage();     // Catch: Exception -> L5
    L8:
        return "zh".equals(language);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private UsageEvents.Event copyFrom(UsageEvents.Event orig) {
        UsageEvents.Event event = new UsageEvents.Event();
        event.mPackage = orig.mPackage;
        event.mClass = orig.mClass;
        event.mInstanceId = orig.mInstanceId;
        event.mTaskRootPackage = orig.mTaskRootPackage;
        event.mTaskRootClass = orig.mTaskRootClass;
        event.mTimeStamp = orig.mTimeStamp;
        event.mEventType = orig.mEventType;
        event.mConfiguration = orig.mConfiguration;
        event.mShortcutId = orig.mShortcutId;
        event.mAction = orig.mAction;
        event.mContentType = orig.mContentType;
        event.mContentAnnotations = orig.mContentAnnotations;
        event.mFlags = orig.mFlags;
        event.mBucketAndReason = orig.mBucketAndReason;
        event.mNotificationChannelId = orig.mNotificationChannelId;
        event.mLocusId = orig.mLocusId;
        return event;
    }

    public void extractEvents2ArkBase(UsageEvents.Event event) {
        switch(event.mEventType) {
            case 1: goto L5;
            case 2: goto L5;
            case 23: goto L5;
            default: goto L7;
        };
    L5:
        Message msg = obtainMessage(1);
        msg.obj = event;
        sendMessage(msg);
        return;
    }
}
