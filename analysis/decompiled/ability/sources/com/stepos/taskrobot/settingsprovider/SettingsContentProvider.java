package com.stepos.taskrobot.settingsprovider;

import D7.q;
import D7.v;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.statsrpk.service.c;
import com.stepos.taskrobot.dictionary.model.WhitelistApp;
import com.tencent.mmkv.MMKV;
import f6.AbstractC1436a;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.cell.config.IModelConfig;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u0019\u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u0019\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJM\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0004\b&\u0010'J-\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001f2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J#\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b.\u0010/J1\u00100\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108¨\u0006<"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/SettingsContentProvider;", "Landroid/content/ContentProvider;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "enforceCallerPermission", "Landroid/database/Cursor;", "queryMasterSwitch", "()Landroid/database/Cursor;", "Landroid/content/ContentValues;", "values", "", "updateMasterSwitch", "(Landroid/content/ContentValues;)I", "queryWhitelist", "Landroid/net/Uri;", "uri", "queryWhitelistItem", "(Landroid/net/Uri;)Landroid/database/Cursor;", "updateWhitelistItem", "(Landroid/net/Uri;Landroid/content/ContentValues;)I", "queryAuthorizationStatus", "updateAuthorizationStatus", "queryLocalRun", "updateLocalRun", "updateHostActivityDismissed", "emptyCursor", "", AppAgent.ON_CREATE, "()Z", "", "", "projection", "selection", "selectionArgs", "sortOrder", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "arg", "Landroid/os/Bundle;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager;", "cacheManager", "Lcom/stepos/taskrobot/settingsprovider/WhitelistCacheManager;", "updateMasterSwitchCallCount", "I", "updateWhitelistItemCallCount", "queryMasterSwitchCallCount", "Companion", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsContentProvider extends ContentProvider {
    private static final int AUTHORIZATION_STATUS = 5;
    private static final int HOST_ACTIVITY_DISMISSED = 7;
    private static final int LOCAL_RUN = 6;
    private static final int MASTER_SWITCH = 1;
    private static final String TAG = "SettingsContentProvider";
    private static final int TRIGGER_SYNC = 4;
    private static final int WHITELIST = 2;
    private static final int WHITELIST_ITEM = 3;
    private static final UriMatcher uriMatcher;
    private WhitelistCacheManager cacheManager;
    private int queryMasterSwitchCallCount;
    private int updateMasterSwitchCallCount;
    private int updateWhitelistItemCallCount;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, SettingsConfig.PATH_MASTER_SWITCH, 1);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, SettingsConfig.PATH_WHITELIST, 2);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, "whitelist/*", 3);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, SettingsConfig.PATH_TRIGGER_SYNC, 4);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, "authorization_status", 5);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, SettingsConfig.PATH_LOCAL_RUN, 6);
        uriMatcher2.addURI(SettingsConfig.AUTHORITY, SettingsConfig.PATH_HOST_ACTIVITY_DISMISSED, 7);
        uriMatcher = uriMatcher2;
    }

    private final Cursor emptyCursor() {
        return new MatrixCursor(new String[]{SettingsConfig.KEY_DATA});
    }

    private final void enforceCallerPermission() {
        Context context = getContext();
        if (context == null || context.checkCallingPermission(SettingsConfig.PERMISSION) != 0) {
            throw new SecurityException(a.i(Binder.getCallingUid(), "Caller uid=", " lacks com.stepos.taskrobot.permission.ACCESS_SETTINGS; external callers must declare <uses-permission> for it AND be signed with the platform key."));
        }
    }

    private final Cursor queryAuthorizationStatus() {
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        boolean authorizationStatus = whitelistCacheManager.getAuthorizationStatus();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"enabled"});
        matrixCursor.addRow(new String[]{String.valueOf(authorizationStatus)});
        return matrixCursor;
    }

    private final Cursor queryLocalRun() {
        Context context = getContext();
        if (context != null) {
            ModelConfigs.instance.initialize(context);
        }
        String currentModelId = ModelConfigs.instance.getCurrentModelId();
        boolean zB = k.b(currentModelId, "local-vlm");
        AbstractC1436a.d(TAG, "queryLocalRun: currentModelId=" + currentModelId + ", enabled=" + zB, true);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"enabled"});
        matrixCursor.addRow(new String[]{String.valueOf(zB)});
        return matrixCursor;
    }

    private final Cursor queryMasterSwitch() {
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        boolean masterSwitch = whitelistCacheManager.getMasterSwitch();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"enabled"});
        matrixCursor.addRow(new String[]{String.valueOf(masterSwitch)});
        return matrixCursor;
    }

    private final Cursor queryWhitelist() {
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        String json = new Gson().toJson(whitelistCacheManager.getWhitelist());
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{SettingsConfig.KEY_DATA});
        matrixCursor.addRow(new String[]{json});
        return matrixCursor;
    }

    private final Cursor queryWhitelistItem(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return emptyCursor();
        }
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        WhitelistApp whitelistItem = whitelistCacheManager.getWhitelistItem(lastPathSegment);
        if (whitelistItem == null) {
            return emptyCursor();
        }
        String json = new Gson().toJson(whitelistItem);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{SettingsConfig.KEY_DATA});
        matrixCursor.addRow(new String[]{json});
        return matrixCursor;
    }

    private final int updateAuthorizationStatus(ContentValues values) {
        String asString;
        Boolean boolP0;
        if (values == null || (asString = values.getAsString("enabled")) == null || (boolP0 = m.P0(asString)) == null) {
            return 0;
        }
        boolean zBooleanValue = boolP0.booleanValue();
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        whitelistCacheManager.setAuthorizationStatus(zBooleanValue);
        Log.d(TAG, "updateAuthorizationStatus: authorized=" + zBooleanValue);
        return 1;
    }

    private final int updateHostActivityDismissed(ContentValues values) {
        AbstractC1436a.d(TAG, "[RELAUNCH] updateHostActivityDismissed: values=" + values + ", thread=" + Thread.currentThread().getName(), true);
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        whitelistCacheManager.notifyHostActivityDismissed();
        AbstractC1436a.d(TAG, "[RELAUNCH] updateHostActivityDismissed: fired notifyHostActivityDismissed", true);
        return 1;
    }

    private final int updateLocalRun(ContentValues values) {
        String asString;
        Boolean boolP0 = (values == null || (asString = values.getAsString("enabled")) == null) ? null : m.P0(asString);
        if (boolP0 == null) {
            AbstractC1436a.e(TAG, "updateLocalRun: invalid values=" + values + ", ignored", true);
            return 0;
        }
        Context context = getContext();
        if (context == null) {
            AbstractC1436a.b(TAG, "updateLocalRun: context is null, ignored", true);
            return 0;
        }
        IModelConfig iModelConfig = ModelConfigs.instance;
        iModelConfig.initialize(context);
        String default_model_id = boolP0.booleanValue() ? "local-vlm" : ModelConfigs.INSTANCE.getDEFAULT_MODEL_ID();
        String currentModelId = iModelConfig.getCurrentModelId();
        StringBuilder sb = new StringBuilder("updateLocalRun: enabled=");
        sb.append(boolP0);
        sb.append(", from=");
        sb.append(currentModelId);
        sb.append(", to=");
        c.r(sb, default_model_id, TAG, true);
        iModelConfig.setCurrentModel(default_model_id);
        context.getContentResolver().notifyChange(Uri.parse("content://com.stepos.taskrobot.settingsprovider/local_run"), null);
        return 1;
    }

    private final int updateMasterSwitch(ContentValues values) {
        String asString;
        Boolean boolP0;
        this.updateMasterSwitchCallCount++;
        if (values == null || (asString = values.getAsString("enabled")) == null || (boolP0 = m.P0(asString)) == null) {
            return 0;
        }
        boolean zBooleanValue = boolP0.booleanValue();
        AbstractC1436a.e(TAG, "[LOOP-DEBUG] updateMasterSwitch: enabled=" + zBooleanValue + ", callCount=" + this.updateMasterSwitchCallCount + ", thread=" + Thread.currentThread().getName(), true);
        int i = this.updateMasterSwitchCallCount;
        if (i % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i, "[LOOP-DEBUG] updateMasterSwitch SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        whitelistCacheManager.setMasterSwitch(zBooleanValue);
        Log.d(TAG, "updateMasterSwitch: enabled=" + zBooleanValue);
        return 1;
    }

    private final int updateWhitelistItem(Uri uri, ContentValues values) {
        String asString;
        Boolean boolP0;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || values == null || (asString = values.getAsString("enabled")) == null || (boolP0 = m.P0(asString)) == null) {
            return 0;
        }
        boolean zBooleanValue = boolP0.booleanValue();
        int i = this.updateWhitelistItemCallCount + 1;
        this.updateWhitelistItemCallCount = i;
        String name = Thread.currentThread().getName();
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[LOOP-DEBUG] updateWhitelistItem: appName=", lastPathSegment, ", enabled=", ", callCount=", zBooleanValue);
        sbL.append(i);
        sbL.append(", thread=");
        sbL.append(name);
        AbstractC1436a.e(TAG, sbL.toString(), true);
        int i6 = this.updateWhitelistItemCallCount;
        if (i6 % 10 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            k.e(stackTrace, "getStackTrace(...)");
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] updateWhitelistItem SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
        }
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        boolean appEnabled = whitelistCacheManager.setAppEnabled(lastPathSegment, zBooleanValue);
        if (appEnabled) {
            Log.d(TAG, "updateWhitelistItem: appName=" + lastPathSegment + " enabled=" + zBooleanValue);
        }
        return appEnabled ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        k.f(method, "method");
        enforceCallerPermission();
        if (!method.equals(SettingsConfig.PATH_TRIGGER_SYNC)) {
            return super.call(method, arg, extras);
        }
        WhitelistCacheManager whitelistCacheManager = this.cacheManager;
        if (whitelistCacheManager == null) {
            k.n("cacheManager");
            throw null;
        }
        whitelistCacheManager.syncFromServer();
        Bundle bundle = new Bundle();
        bundle.putString("status", "triggered");
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        k.f(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        k.f(uri, "uri");
        return "vnd.android.cursor.item/SettingsContentProvider";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        MMKV.initialize(context);
        this.cacheManager = WhitelistCacheManager.INSTANCE.getInstance(context);
        Log.d(TAG, "onCreate: provider initialized");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        k.f(uri, "uri");
        AbstractC1436a.a(TAG, "[LOOP-DEBUG] query: uri=" + uri + ", thread=" + Thread.currentThread().getName(), true);
        int iMatch = uriMatcher.match(uri);
        if (iMatch == 1) {
            int i = this.queryMasterSwitchCallCount + 1;
            this.queryMasterSwitchCallCount = i;
            AbstractC1436a.d(TAG, "[LOOP-DEBUG] queryMasterSwitch: callCount=" + i, true);
            return queryMasterSwitch();
        }
        if (iMatch == 2) {
            return queryWhitelist();
        }
        if (iMatch == 3) {
            return queryWhitelistItem(uri);
        }
        if (iMatch == 5) {
            return queryAuthorizationStatus();
        }
        if (iMatch == 6) {
            return queryLocalRun();
        }
        throw new IllegalArgumentException(B7.a.j("Unknown URI: ", uri));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        k.f(uri, "uri");
        AbstractC1436a.a(TAG, "[LOOP-DEBUG] update: uri=" + uri + ", thread=" + Thread.currentThread().getName(), true);
        int iMatch = uriMatcher.match(uri);
        if (iMatch == 1) {
            return updateMasterSwitch(values);
        }
        if (iMatch == 3) {
            return updateWhitelistItem(uri, values);
        }
        if (iMatch == 5) {
            return updateAuthorizationStatus(values);
        }
        if (iMatch == 6) {
            return updateLocalRun(values);
        }
        if (iMatch == 7) {
            return updateHostActivityDismissed(values);
        }
        throw new IllegalArgumentException(B7.a.j("Unknown URI: ", uri));
    }
}
