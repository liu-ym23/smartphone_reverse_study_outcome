package com.obric.cloudsdk.kv.base;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import com.android.contacts.ContactSaveService;
import com.google.gson.Gson;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.cloudsdk.CommonUtil;
import com.obric.cloudsdk.TaskExecutor;
import com.obric.cloudsdk.kv.SdkGlobals;
import com.obric.cloudsdk.kv.room.manager.DataSyncStateManager;
import com.obric.cloudsdk.kv.room.model.DataSyncStateModel;
import com.obric.cloudsdk.kv.syncconfig.KvSyncConfig;
import com.obric.cloudsdk.kv.syncstate.SyncStateListener;
import com.obric.cloudsdk.utils.CompositeAccessThrottle;
import com.obric.cloudsdk.utils.KtExt;
import com.obric.cloudservice.IKvSyncInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KvSyncManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003\u0013\"%\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002{|B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,J\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u0011H\u0002J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u000103H\u0003J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0019H\u0002J\u0018\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0001H\u0002J\"\u0010<\u001a\u00020.2\u0006\u00101\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0006J\b\u0010F\u001a\u00020\u0019H\u0007J\u0006\u0010G\u001a\u000203J\b\u0010H\u001a\u00020\u0019H\u0007J\u0006\u0010I\u001a\u00020\bJ\b\u0010J\u001a\u000203H\u0007J\b\u0010K\u001a\u00020.H\u0002J\"\u0010L\u001a\u00020.2\u0006\u00101\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0007J\u0010\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020)H\u0003J\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020.2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010R\u001a\u00020.2\u0006\u0010O\u001a\u00020PH\u0002J&\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\bJ.\u0010X\u001a\u00020.2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\u0006J\u000e\u0010^\u001a\u00020.2\u0006\u0010_\u001a\u00020\u0019J\u000e\u0010`\u001a\u00020.2\u0006\u0010a\u001a\u00020\u0019J\u000e\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020\bJ\u0016\u0010d\u001a\u00020.2\u0006\u0010c\u001a\u00020\b2\u0006\u00106\u001a\u000203J\u001e\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020f2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010BJ\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010k\u001a\u00020.H\u0002J\u000e\u0010l\u001a\u00020.2\u0006\u0010/\u001a\u00020,J\b\u0010m\u001a\u00020.H\u0002J\u001c\u0010n\u001a\u00020\b2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00040B2\u0006\u0010E\u001a\u00020\u0006J\u0016\u0010p\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0006J\u001e\u0010p\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u0019J&\u0010p\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u0006J\u001e\u0010r\u001a\u00020.2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u0019J\u0010\u0010s\u001a\u00020\u00192\u0006\u0010a\u001a\u00020\u0019H\u0007J\u0016\u0010t\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0006J\u000e\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020wJ\u0016\u0010x\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u0006J\b\u0010z\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncManager;", "", "()V", "ACCESS_THROTTLE_MS", "", "CLOUD_SERVICE_SYNC_MANAGER_AUTHORITY", "", "MSG_SET_DELETED", "", "MSG_SET_INSERTED", "MSG_SET_UPDATED", "REBIND_MIN_GAP", "TAG", "accessThrottle", "Lcom/obric/cloudsdk/utils/CompositeAccessThrottle;", "appId", "context", "Landroid/content/Context;", "handler", "com/obric/cloudsdk/kv/base/KvSyncManager$handler$2$1", "getHandler", "()Lcom/obric/cloudsdk/kv/base/KvSyncManager$handler$2$1;", "handler$delegate", "Lkotlin/Lazy;", "isInited", "", "value", "isSyncing", "setSyncing", "(Z)V", "lastRebindTime", "mCloudInterface", "Lcom/obric/cloudservice/IKvSyncInterface;", "mServiceConnection", "com/obric/cloudsdk/kv/base/KvSyncManager$mServiceConnection$1", "Lcom/obric/cloudsdk/kv/base/KvSyncManager$mServiceConnection$1;", "mSyncStateChangeListener", "com/obric/cloudsdk/kv/base/KvSyncManager$mSyncStateChangeListener$1", "Lcom/obric/cloudsdk/kv/base/KvSyncManager$mSyncStateChangeListener$1;", "packageName", "syncConfig", "Lcom/obric/cloudsdk/kv/base/KvSyncManager$SyncConfig;", "syncStateListeners", "", "Lcom/obric/cloudsdk/kv/syncstate/SyncStateListener;", "addSyncStateListener", "", "listener", "bindCloudService", "ctx", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "canRebind", "checkIfSyncShouldFail", "delaySendMsg", "msgId", "msgObj", "doInit", "syncInfo", "Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "logger", "Lcom/obric/cloudsdk/kv/base/ILogger;", "getByDataIdAndTableName", "", "Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;", ContactSaveService.EXTRA_DATA_ID, "tableName", "getSwitchStatus", "getSyncConfig", "getSyncSettingsStatus", "getSyncStatus", "getUsedSpaceDetail", "grantPermissions", "init", "config", "invokeSetDeleted", "syncParam", "Lcom/obric/cloudsdk/kv/base/KvSyncManager$SyncParam;", "invokeSetInserted", "invokeSetUpdated", "notifyFileTaskInit", "localUpsertCount", "localDeleteCount", "cloudUpsertCount", "cloudDeleteCount", "notifyFileTaskProgress", "taskType", "uniqueId", "cloudId", "failCode", "failMsg", "notifySwitchChanged", "isSwitchOn", "notifySyncSettingsChanged", "enabled", "onSyncStateChanged", "state", "onSyncStateChangedWithExtraInfo", "putFileListToResult", "Landroid/database/Cursor;", "originalCursor", "fileList", "readKvSyncConfig", "Lcom/obric/cloudsdk/kv/syncconfig/KvSyncConfig;", "rebindCloudService", "removeSyncStateListener", "resetBinderIfNotAlive", "setDeleted", "dataIdList", "setInserted", "syncable", "setItemSyncable", "setSwitchStatus", "setUpdated", "triggerSync", "syncScene", "Lcom/obric/cloudsdk/kv/base/SyncScene;", "tryRenameLocalFile", "newFileName", "unbindCloudService", "SyncConfig", "SyncParam", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvSyncManager {
    private static final long ACCESS_THROTTLE_MS = 3000;
    private static final String CLOUD_SERVICE_SYNC_MANAGER_AUTHORITY = "com.cloudservice.provider.kvsync.KvSyncManagerProvider";
    public static final KvSyncManager INSTANCE = null;
    private static final int MSG_SET_DELETED = 1002;
    private static final int MSG_SET_INSERTED = 1001;
    private static final int MSG_SET_UPDATED = 1003;
    private static final long REBIND_MIN_GAP = 10000;
    private static final String TAG = "KvSyncManager";
    private static final CompositeAccessThrottle accessThrottle = null;
    private static int appId;
    private static Context context;
    private static final Lazy handler$delegate = null;
    private static volatile boolean isInited;
    private static volatile boolean isSyncing;
    private static long lastRebindTime;
    private static volatile IKvSyncInterface mCloudInterface;
    private static final KvSyncManager$mServiceConnection$1 mServiceConnection = null;
    private static final KvSyncManager$mSyncStateChangeListener$1 mSyncStateChangeListener = null;
    private static String packageName;
    private static SyncConfig syncConfig;
    private static final List<SyncStateListener> syncStateListeners = null;

    /* JADX INFO: compiled from: KvSyncManager.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncManager$SyncConfig;", "", "context", "Landroid/content/Context;", "syncInfo", "Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "(Landroid/content/Context;Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;)V", "cloudFirst", "", "getCloudFirst", "()Z", "setCloudFirst", "(Z)V", "getContext", "()Landroid/content/Context;", "fileProviderUris", "", "", "getFileProviderUris", "()Ljava/util/List;", "setFileProviderUris", "(Ljava/util/List;)V", "logger", "Lcom/obric/cloudsdk/kv/base/ILogger;", "getLogger", "()Lcom/obric/cloudsdk/kv/base/ILogger;", "setLogger", "(Lcom/obric/cloudsdk/kv/base/ILogger;)V", "getSyncInfo", "()Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "initKvSyncManager", "", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SyncConfig {
        private boolean cloudFirst;
        private final Context context;
        private List<String> fileProviderUris;
        private ILogger logger;
        private final AbsSyncInfo syncInfo;

        public SyncConfig(Context r2, AbsSyncInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "syncInfo");
            this.context = r2;
            this.syncInfo = r3;
            this.fileProviderUris = CollectionsKt.emptyList();
        }

        public final Context getContext() {
            return this.context;
        }

        public final AbsSyncInfo getSyncInfo() {
            return this.syncInfo;
        }

        public final ILogger getLogger() {
            return this.logger;
        }

        public final void setLogger(ILogger r1) {
            this.logger = r1;
        }

        public final boolean getCloudFirst() {
            return this.cloudFirst;
        }

        public final void setCloudFirst(boolean r1) {
            this.cloudFirst = r1;
        }

        public final List<String> getFileProviderUris() {
            return this.fileProviderUris;
        }

        public final void setFileProviderUris(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.fileProviderUris = r2;
        }

        public final void initKvSyncManager() {
            KvSyncManager.access$init(KvSyncManager.INSTANCE, this);
        }
    }

    /* JADX INFO: compiled from: KvSyncManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvSyncManager$SyncParam;", "", ContactSaveService.EXTRA_DATA_ID, "", "tableName", "", "(JLjava/lang/String;)V", "getDataId", "()J", "getTableName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SyncParam {
        private final long dataId;
        private final String tableName;

        public static /* synthetic */ SyncParam copy$default(SyncParam r0, long r1, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.dataId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r0.tableName;
        L9:
            return r0.copy(r1, r3);
        }

        public final long component1() {
            return this.dataId;
        }

        public final String component2() {
            return this.tableName;
        }

        public final SyncParam copy(long r1, String r3) {
            Intrinsics.checkNotNullParameter(r3, "tableName");
            return new SyncParam(r1, r3);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof SyncParam) == true) goto L8;
            return false;
        L8:
            SyncParam r9 = (SyncParam) r8;
            if (this.dataId == r9.dataId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tableName, r9.tableName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.dataId) * 31) + this.tableName.hashCode();
        }

        public String toString() {
            return "SyncParam(dataId=" + this.dataId + ", tableName=" + this.tableName + ')';
        }

        public SyncParam(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "tableName");
            this.dataId = r2;
            this.tableName = r4;
        }

        public final long getDataId() {
            return this.dataId;
        }

        public final String getTableName() {
            return this.tableName;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$f9khb1I8eIAqJ2unBtz2grKha-E, reason: not valid java name */
    public static /* synthetic */ void m347$r8$lambda$f9khb1I8eIAqJ2unBtz2grKhaE(Context r0, AbsSyncInfo r1, ILogger r2) {
        init$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$y2EJSbAo_LGKmzmv_NeO4l0bdJs(long r0, String r2, boolean r3) {
        setItemSyncable$lambda$3(r0, r2, r3);
    }

    private KvSyncManager() {
    }

    public static final /* synthetic */ void access$delaySendMsg(KvSyncManager r0, int r1, Object r2) {
        r0.delaySendMsg(r1, r2);
    }

    public static final /* synthetic */ CompositeAccessThrottle access$getAccessThrottle$p() {
        return accessThrottle;
    }

    public static final /* synthetic */ IKvSyncInterface access$getMCloudInterface$p() {
        return mCloudInterface;
    }

    public static final /* synthetic */ KvSyncManager$mSyncStateChangeListener$1 access$getMSyncStateChangeListener$p() {
        return mSyncStateChangeListener;
    }

    public static final /* synthetic */ String access$getPackageName$p() {
        return packageName;
    }

    public static final /* synthetic */ void access$init(KvSyncManager r0, SyncConfig r1) {
        r0.init(r1);
    }

    public static final /* synthetic */ void access$invokeSetDeleted(KvSyncManager r0, SyncParam r1) {
        r0.invokeSetDeleted(r1);
    }

    public static final /* synthetic */ void access$invokeSetInserted(KvSyncManager r0, SyncParam r1) {
        r0.invokeSetInserted(r1);
    }

    public static final /* synthetic */ void access$invokeSetUpdated(KvSyncManager r0, SyncParam r1) {
        r0.invokeSetUpdated(r1);
    }

    public static final /* synthetic */ boolean access$isSyncing$p() {
        return isSyncing;
    }

    public static final /* synthetic */ void access$rebindCloudService(KvSyncManager r0) {
        r0.rebindCloudService();
    }

    public static final /* synthetic */ void access$resetBinderIfNotAlive(KvSyncManager r0) {
        r0.resetBinderIfNotAlive();
    }

    public static final /* synthetic */ void access$setMCloudInterface$p(IKvSyncInterface r0) {
        mCloudInterface = r0;
    }

    public static final /* synthetic */ void access$setSyncing(KvSyncManager r0, boolean r1) {
        r0.setSyncing(r1);
    }

    public static final /* synthetic */ void access$unbindCloudService(KvSyncManager r0) {
        r0.unbindCloudService();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.cloudsdk.kv.base.KvSyncManager$mSyncStateChangeListener$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.cloudsdk.kv.base.KvSyncManager$mServiceConnection$1] */
    static {
        INSTANCE = new KvSyncManager();
        syncStateListeners = new ArrayList();
        handler$delegate = LazyKt.lazy(KvSyncManager$handler$2.INSTANCE);
        accessThrottle = new CompositeAccessThrottle(3000);
        mSyncStateChangeListener = new KvSyncManager$mSyncStateChangeListener$1();
        mServiceConnection = new KvSyncManager$mServiceConnection$1();
    }

    private final KvSyncManager$handler$2.AnonymousClass1 getHandler() {
        return (KvSyncManager$handler$2.AnonymousClass1) handler$delegate.getValue();
    }

    private final void setSyncing(boolean r3) {
        isSyncing = r3;
        KvLog.INSTANCE.d(TAG, "isSyncing: " + r3);
    }

    @Deprecated(message = "This init fun does not support new feature", replaceWith = @ReplaceWith(expression = "KvSyncManager.SyncConfig#initKvSyncManager", imports = {}))
    public final void init(final Context r2, final AbsSyncInfo r3, final ILogger r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "syncInfo");
        getHandler().post(new KvSyncManager$$ExternalSyntheticLambda0(r2, r3, r4));
    }

    private static final void init$lambda$0(Context r1, AbsSyncInfo r2, ILogger r3) {
        Intrinsics.checkNotNullParameter(r1, "$ctx");
        Intrinsics.checkNotNullParameter(r2, "$syncInfo");
        INSTANCE.doInit(r1, r2, r3);
    }

    private final void init(SyncConfig r3) {
        syncConfig = r3;
        doInit(r3.getContext(), r3.getSyncInfo(), r3.getLogger());
        grantPermissions();
    }

    private final void doInit(Context r4, AbsSyncInfo r5, ILogger r6) {
        if (isInited == false) goto L6;
        KvLog.INSTANCE.w(TAG, "init, isInited is true, return");
        return;
    L6:
        isInited = true;
        KvLog.INSTANCE.setLogger(r6);
        SdkGlobals.INSTANCE.setAppContext(r4);
        SdkGlobals.INSTANCE.setSyncInfo(r5);
        Context r7 = r4.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r7, "ctx.applicationContext");
        context = r7;
        String r8 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r8, "ctx.packageName");
        packageName = r8;
        Context r9 = context;
        Context r10 = null;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r9 = null;
    L9:
        KvSyncConfig r11 = readKvSyncConfig(r9);
        if (r11 == null) goto L12;
        int r12 = r11.getAppId();
    L13:
        appId = r12;
        KvLog r13 = KvLog.INSTANCE;
        StringBuilder r0 = new StringBuilder("init, appId: ").append(appId).append(", packageName: ");
        String r2 = packageName;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");
        r2 = null;
    L16:
        r13.d(TAG, r0.append(r2).append(", BUILD_TYPE: release, SDK_BUILD_NO: 20260615-20:34:38|72ec9e3}").toString());
        Context r14 = context;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L20:
        bindCloudService(r10);
        return;
    L19:
        r10 = r14;
        goto L20
    L12:
        r12 = 0;
        goto L13
    }

    private final void rebindCloudService() {
        if (context != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        Context r2 = null;
        if (canRebind() == false) goto L12;
        KvLog.INSTANCE.i(TAG, "rebindCloudService()");
        lastRebindTime = System.currentTimeMillis();
        Context r0 = context;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L11:
        bindCloudService(r2);
        return;
    L10:
        r2 = r0;
        goto L11
    L12:
        KvLog r5 = KvLog.INSTANCE;
        StringBuilder r1 = new StringBuilder("rebindCloudService, can not rebind cloud service, context ");
        Context r4 = context;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L16:
        r5.w(TAG, r1.append(r2).append(",lastRebindTime: ").append(lastRebindTime).toString());
        return;
    L15:
        r2 = r4;
        goto L16
    }

    private final void bindCloudService(Context r3) {
        setSyncing(true);     // Catch: Exception -> L5
        Intent r2 = new Intent("com.obric.cloudservice.action.KV_SYNC_SERVICE");     // Catch: Exception -> L5
        r2.setPackage("com.obric.cloudservice");     // Catch: Exception -> L5
        r3.bindService(r2, mServiceConnection, 1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        KvLog.INSTANCE.e(TAG, "bindCloudService error", e);
    }

    private final boolean canRebind() {
        long r0 = System.currentTimeMillis() - lastRebindTime;
        if (r0 <= REBIND_MIN_GAP) goto L5;
        boolean r5 = true;
    L6:
        KvLog.INSTANCE.i(TAG, "canRebind returned " + r5 + ", timeInterval: " + r0 + ", lastRebindTime: " + lastRebindTime);
        return r5;
    L5:
        r5 = false;
        goto L6
    }

    public final int triggerSync(final SyncScene r9) {
        Intrinsics.checkNotNullParameter(r9, "syncScene");
        setSyncing(true);
        resetBinderIfNotAlive();
        if (mCloudInterface != null) goto L6;
        KvLog.e$default(KvLog.INSTANCE, TAG, "triggerSync, mCloudInterface is null, return CLOUD_SERVICE_NOT_READY", null, 4, null);
        rebindCloudService();
        return 3;
    L6:
        Integer r8 = (Integer) KtExt.INSTANCE.safeExecute(new C02491(r9));
        if (r8 != null) goto L9;
        return 3;
    L9:
        return r8.intValue();
    }

    public final int getSyncStatus() {
        resetBinderIfNotAlive();
        if (mCloudInterface != null) goto L18;
        KvLog.INSTANCE.d(TAG, "getSyncStatus, mCloudInterface is null, get sync state from provider!");
        rebindCloudService();
        Bundle r4 = new Bundle();     // Catch: Exception -> L15
        String r6 = packageName;     // Catch: Exception -> L15
        Integer r7 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Exception -> L15
        r6 = null;
    L8:
        r4.putString(KvConstant.KEY_PKG_NAME, r6);     // Catch: Exception -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L15
        Bundle r8 = call(KvConstant.METHOD_GET_SYNC_STATUS, null, r4);     // Catch: Exception -> L15
        if (r8 == null) goto L11;
        r7 = Integer.valueOf(r8.getInt("state"));     // Catch: Exception -> L15
    L11:
        KvLog.INSTANCE.i(TAG, "getSyncStatus, mCloudInterface is null, state: " + r7);     // Catch: Exception -> L15
        if (r7 == null) goto L25;
        return r7.intValue();
    L25:
        return -2;
    L15:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, TAG, "getSyncStatus failed, error: " + e, null, 4, null);
        return -2;
    L18:
        Integer r9 = (Integer) KtExt.INSTANCE.safeExecute(KvSyncManager$getSyncStatus$ret$1.INSTANCE);
        KvLog.INSTANCE.i(TAG, "getSyncStatus, state: " + r9);
        if (r9 != null) goto L26;
        return 3;
    L26:
        return r9.intValue();
    }

    public final void addSyncStateListener(SyncStateListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        syncStateListeners.add(r1);
    }

    public final void removeSyncStateListener(SyncStateListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        syncStateListeners.remove(r1);
    }

    public final int setInserted(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "tableName");
        return setInserted(r2, r4, true);
    }

    public final int setInserted(final long r3, final String r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "tableName");
        if (SdkGlobals.INSTANCE.getSyncInfo().isLogin() == true) goto L6;
        KvLog.INSTANCE.i(TAG, "setInserted, user is NOT login");
        return 4;
    L6:
        KvLog.INSTANCE.d(TAG, "setInserted, user is login");
        TaskExecutor.INSTANCE.execute(new C02471(r6, r3, r5));
        return 0;
    }

    public final int setInserted(final long r8, final String r10, final boolean r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, "tableName");
        Intrinsics.checkNotNullParameter(r12, "uniqueId");
        if (SdkGlobals.INSTANCE.getSyncInfo().isLogin() == true) goto L6;
        KvLog.INSTANCE.i(TAG, "setInserted, user is NOT login");
        return 4;
    L6:
        KvLog.INSTANCE.d(TAG, "setInserted, user is login");
        TaskExecutor.INSTANCE.execute(new AnonymousClass2(r11, r8, r10, r12));
        return 0;
    }

    public final int setDeleted(final List<Long> r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "dataIdList");
        Intrinsics.checkNotNullParameter(r3, "tableName");
        TaskExecutor.INSTANCE.execute(new C02461(r2, r3));
        return 0;
    }

    public final int setUpdated(final long r2, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "tableName");
        TaskExecutor.INSTANCE.execute(new C02481(r2, r4));
        return 0;
    }

    public final List<DataSyncStateModel> getByDataIdAndTableName(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "tableName");
        return DataSyncStateManager.INSTANCE.getByDataIdAndTableName(r1, r3);
    }

    private final void delaySendMsg(int r3, Object r4) {
        if (getHandler().hasMessages(r3) == false) goto L5;
        getHandler().removeMessages(r3);
    L5:
        Message r5 = getHandler().obtainMessage(r3);
        r5.obj = r4;
        Intrinsics.checkNotNullExpressionValue(r5, "handler.obtainMessage(ms…   obj = msgObj\n        }");
        getHandler().sendMessageDelayed(r5, 3000);
    }

    private final void invokeSetInserted(final SyncParam r4) {
        if (checkIfSyncShouldFail() == false) goto L6;
        KvLog.INSTANCE.w(TAG, "setInserted mCloudInterface is null");
        return;
    L6:
        KvLog.INSTANCE.d(TAG, "setInserted, param: " + r4);
        KtExt.INSTANCE.safeExecute(new C02441(r4));
    }

    private final void invokeSetDeleted(final SyncParam r4) {
        if (checkIfSyncShouldFail() == false) goto L6;
        KvLog.INSTANCE.w(TAG, "setDeleted mCloudInterface is null");
        return;
    L6:
        KvLog.INSTANCE.d(TAG, "setDeleted, param: " + r4);
        KtExt.INSTANCE.safeExecute(new AnonymousClass1(r4));
    }

    private final void invokeSetUpdated(final SyncParam r4) {
        if (checkIfSyncShouldFail() == false) goto L6;
        KvLog.INSTANCE.w(TAG, "setUpdated mCloudInterface is null");
        return;
    L6:
        KvLog.INSTANCE.d(TAG, "setUpdated, param: " + r4);
        KtExt.INSTANCE.safeExecute(new C02451(r4));
    }

    private final boolean checkIfSyncShouldFail() {
        resetBinderIfNotAlive();
        if (mCloudInterface != null) goto L6;
        rebindCloudService();
        return true;
    L6:
        setSyncing(true);
        return false;
    }

    private final KvSyncConfig readKvSyncConfig(Context r4) {
        String r3 = CommonUtil.INSTANCE.readAssertFileContent(r4, KvConstant.KV_CONFIG_FILE_NAME);
        KvLog.INSTANCE.d(TAG, "readKvSyncConfig, jsonString: " + r3);
        String r5 = r3;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        KvSyncConfig r7 = null;
    L12:
        KvLog.INSTANCE.d(TAG, "readKvSyncConfig, result: " + r7);
        return r7;
    L11:
        r7 = (KvSyncConfig) new Gson().fromJson(r3, KvSyncConfig.class);
        goto L12
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    public final Cursor putFileListToResult(Cursor r14, List<String> r15) {
        Intrinsics.checkNotNullParameter(r14, "originalCursor");
        List<String> r13 = r15;
        if (r13 != null) goto L5;
    L8:
        boolean r16 = true;
    L10:
        if (r16 == false) goto L14;
        KvLog.INSTANCE.d(TAG, "addFileListToCursor, fileList is null or empty");
        return r14;
    L14:
        if (r14.getColumnCount() != 0) goto L17;
        KvLog.INSTANCE.d(TAG, "addFileListToCursor, originalCursor.columnCount is 0");
        return r14;
    L17:
        String[] r17 = r14.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(r17, "originalColumnNames");
        String[] r3 = (String[]) ArraysKt.plus(r17, KvConstant.KEY_FILE_LIST);
        MatrixCursor r4 = new MatrixCursor(r3);
        KvLog r5 = KvLog.INSTANCE;
        StringBuilder r6 = new StringBuilder("addFileListToCursor, originalColumnNames: ");
        String r7 = Arrays.toString(r17);
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        r5.d(TAG, r6.append(r7).append(", count: ").append(r14.getCount()).toString());
        if (r14.moveToFirst() == false) goto L26;
        KvLog.INSTANCE.d(TAG, "addFileListToCursor, originalCursor.moveToFirst() is true");
        int r8 = 0;
    L20:
        String r9 = r15.get(r8);
        KvLog.INSTANCE.d(TAG, "addFileListToCursor, fileListString: " + r9);
        Object[] r10 = new Object[r17.length + 1];
        int r11 = r17.length;
        int r12 = 0;
    L21:
        if (r12 >= r11) goto L23;
        r10[r12] = r14.getString(r12);
        r12 = r12 + 1;
        goto L21
    L23:
        r10[r17.length] = r9;
        r4.addRow(r10);
        r8 = r8 + 1;
        if (r14.moveToNext() == true) goto L20;
    L27:
        r14.close();
        KvLog r18 = KvLog.INSTANCE;
        StringBuilder r19 = new StringBuilder("addFileListToCursor, newColumnNames: ");
        String r110 = Arrays.toString(r3);
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        r18.d(TAG, r19.append(r110).append(", count: ").append(r4.getCount()).toString());
        return r4;
    L26:
        KvLog.INSTANCE.d(TAG, "addFileListToCursor, originalCursor.moveToFirst() is false");
        goto L27
    L5:
        if (r13.isEmpty() == true) goto L8;
        r16 = false;
        goto L10
    }

    public final void setItemSyncable(final String r4, final long r5, final boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "tableName");
        KvLog.INSTANCE.d(TAG, "setItemSyncable, dataId: " + r5 + ", tableName: " + r4 + ", syncable: " + r7);
        getHandler().post(new KvSyncManager$$ExternalSyntheticLambda1(r5, r4, r7));
    }

    private static final void setItemSyncable$lambda$3(final long r2, final String r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "$tableName");
        TaskExecutor.INSTANCE.execute(new KvSyncManager$setItemSyncable$1$1(r2, r4, r5));
    }

    public final void onSyncStateChanged(int r4) {
        KvLog.INSTANCE.d(TAG, "onSyncStateChanged, state: " + r4);
        Iterator<T> r0 = syncStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SyncStateListener) r0.next()).onSyncStateChanged(r4);
        goto L4
    L6:
        boolean r1 = true;
        if (r4 == 1) goto L10;
        r1 = false;
    L10:
        setSyncing(r1);
    }

    public final void notifyFileTaskInit(int r3, int r4, int r5, int r6) {
        KvLog.INSTANCE.d(TAG, "notifyFileTaskInit, localUpsertCount: " + r3 + ", localDeleteCount: " + r4 + ", cloudUpsertCount: " + r5 + ", cloudDeleteCount: " + r6);
        Iterator<T> r2 = syncStateListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SyncStateListener) r2.next()).onFileTaskInit(r3, r4, r5, r6);
        goto L4
    }

    public final void notifyFileTaskProgress(int r8, String r9, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "uniqueId");
        Intrinsics.checkNotNullParameter(r10, "cloudId");
        Intrinsics.checkNotNullParameter(r12, "failMsg");
        KvLog.INSTANCE.d(TAG, "notifyFileTaskProgress, taskType: " + r8 + ", uniqueId: " + r9 + ", cloudId: " + r10 + ", failCode: " + r11 + ", failMsg: " + r12);
        Iterator<T> r7 = syncStateListeners.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((SyncStateListener) r7.next()).onFileTaskProgress(r8, r9, r10, r11, r12);
        goto L4
    }

    public final void notifySwitchChanged(boolean r3) {
        KvLog.INSTANCE.d(TAG, "notifySwitchChanged, isSwitchOn: " + r3);
        Iterator<T> r2 = syncStateListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SyncStateListener) r2.next()).onSwitchChanged(r3);
        goto L4
    }

    public final void onSyncStateChangedWithExtraInfo(int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "extras");
        KvLog.INSTANCE.d(TAG, "onSyncStateChangedWithExtraInfo, state: " + r3 + ", extras: " + r4);
        Iterator<T> r2 = syncStateListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SyncStateListener) r2.next()).onSyncStateChanged(r3, r4);
        goto L4
    }

    public final Bundle getSyncConfig() {
        KvLog.INSTANCE.d(TAG, "getSyncConfig, isInited: " + isInited + ", syncConfig: " + syncConfig);
        grantPermissions();
        Bundle r3 = new Bundle();
        SyncConfig r0 = syncConfig;
        if (r0 == null) goto L5;
        boolean r1 = r0.getCloudFirst();
    L6:
        r3.putBoolean(KvConstant.KV_IS_CLOUD_FIRST, r1);
        r3.putBoolean(KvConstant.KV_IS_CLIENT_INITED, isInited);
        SyncConfig r2 = syncConfig;
        if (r2 == null) goto L12;
        List<String> r4 = r2.getFileProviderUris();
        if (r4 == null) goto L12;
        ArrayList<String> r5 = (ArrayList) CollectionsKt.toCollection(r4, new ArrayList());
        if (r5 == null) goto L12;
    L13:
        r3.putStringArrayList(KvConstant.KV_FILE_PROVIDER_URIS, r5);
        return r3;
    L12:
        r5 = new ArrayList();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private final void resetBinderIfNotAlive() {
        IKvSyncInterface r2 = mCloudInterface;
        boolean r0 = false;
        if (r2 == null) goto L9;
        IBinder r3 = r2.asBinder();
        if (r3 == null) goto L9;
        if (r3.isBinderAlive() == true) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L12;
        KvLog.INSTANCE.w(TAG, "binder is not alive! reset");
        mCloudInterface = null;
        return;
    }

    private final void unbindCloudService() {
        if (isSyncing == true) goto L28;
        IKvSyncInterface r6 = mCloudInterface;
        boolean r0 = false;
        if (r6 == null) goto L11;
        IBinder r7 = r6.asBinder();
        if (r7 == null) goto L11;
        if (r7.isBinderAlive() != true) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L29;
        KvLog.INSTANCE.d(TAG, "unbindCloudService, unbindService");     // Catch: Exception -> L23
        IKvSyncInterface r8 = mCloudInterface;     // Catch: Exception -> L23
        if (r8 == null) goto L18;
        String r1 = packageName;     // Catch: Exception -> L23
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Exception -> L23
        r1 = null;
    L17:
        r8.removeSyncStateListener(r1, mSyncStateChangeListener);     // Catch: Exception -> L23
    L18:
        Context r9 = context;     // Catch: Exception -> L23
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("context");     // Catch: Exception -> L23
        r9 = null;
    L21:
        r9.unbindService(mServiceConnection);     // Catch: Exception -> L23
        mCloudInterface = null;     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, TAG, "unbindCloudService error: " + e, null, 4, null);
        return;
    L29:
        return;
    }

    private final void grantPermissions() {
        KvLog.INSTANCE.d(TAG, "grantPermissions, isInited: " + isInited);
        SyncConfig r7 = syncConfig;     // Catch: Exception -> L21
        if (r7 == null) goto L34;
        List<String> r8 = r7.getFileProviderUris();     // Catch: Exception -> L21
        if (r8 == null) goto L35;
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L21
        Iterator<T> r9 = r8.iterator();     // Catch: Exception -> L21
    L9:
        if (r9.hasNext() == false) goto L13;
        Object r1 = r9.next();     // Catch: Exception -> L21
        if (StringsKt.startsWith$default((String) r1, Params.CONTENT, false, 2, null) == false) goto L9;
        r0.add(r1);     // Catch: Exception -> L21
        goto L9
    L13:
        Iterator r10 = r0.iterator();     // Catch: Exception -> L21
    L14:
        if (r10.hasNext() == false) goto L36;
        String r2 = (String) r10.next();     // Catch: Exception -> L21
        Context r3 = context;     // Catch: Exception -> L21
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("context");     // Catch: Exception -> L21
        r3 = null;
    L19:
        r3.grantUriPermission("com.obric.cloudservice", Uri.parse(r2), 195);     // Catch: Exception -> L21
        goto L14
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L21:
        e = move-exception;
        KvLog.e$default(KvLog.INSTANCE, TAG, "grantPermissions failed, error: " + e, null, 4, null);
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0077: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:24:0x0077 */
    private final Bundle call(String r11, String r12, Bundle r13) {
        ContentProviderClient r2 = null;
        Context r3 = context;     // Catch: Throwable -> L15 Exception -> L17
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("context");     // Catch: Throwable -> L15 Exception -> L17
        r3 = null;
    L6:
        ContentProviderClient r4 = r3.getContentResolver().acquireUnstableContentProviderClient(CLOUD_SERVICE_SYNC_MANAGER_AUTHORITY);     // Catch: Throwable -> L15 Exception -> L17
        if (r4 == null) goto L14;
        KvLog.INSTANCE.d(TAG, "call cloud service sync manager, method: " + r11 + ", arg: " + r12);     // Catch: Exception -> L11 Throwable -> L23
        Bundle r10 = r4.call(CLOUD_SERVICE_SYNC_MANAGER_AUTHORITY, r11, r12, r13);     // Catch: Exception -> L11 Throwable -> L23
        r4.close();
        return r10;
    L11:
        e = e;
    L19:
        KvLog.e$default(KvLog.INSTANCE, TAG, "call cloud service sync manager failed, method: " + r11 + ", error: " + e, null, 4, null);     // Catch: Throwable -> L23
        if (r4 == null) goto L22;
        r4.close();
    L22:
        return null;
    L14:
        throw new IllegalStateException("acquireUnstableContentProviderClient failed");     // Catch: Throwable -> L15 Exception -> L17
    L23:
        th = th;
        r2 = r3;
    L25:
        if (r2 == null) goto L27;
        r2.close();
    L27:
        throw th;
    L17:
        e = e;
        r4 = null;
    L15:
        th = th;
        goto L25
    }

    public final boolean getSwitchStatus() {
        Bundle r4 = new Bundle();     // Catch: Throwable -> L13
        String r6 = packageName;     // Catch: Throwable -> L13
        Boolean r7 = null;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Throwable -> L13
        r6 = null;
    L6:
        r4.putString(KvConstant.KEY_PKG_NAME, r6);     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        Bundle r8 = call(KvConstant.METHOD_GET_SWITCH_STATUS, null, r4);     // Catch: Throwable -> L13
        if (r8 == null) goto L9;
        r7 = Boolean.valueOf(r8.getBoolean(KvConstant.KV_SWITCH_STATE));     // Catch: Throwable -> L13
    L9:
        KvLog.INSTANCE.i(TAG, "getSwitchStatus, enabled: " + r7);     // Catch: Throwable -> L13
        if (r7 == null) goto L18;
        return r7.booleanValue();
    L18:
        return false;
    L13:
        th = move-exception;
        KvLog.INSTANCE.e(TAG, "getSwitchStatus failed, error: " + th, th);
        return false;
    }

    public final boolean setSwitchStatus(boolean r9) {
        Bundle r4 = new Bundle();     // Catch: Throwable -> L13
        String r6 = packageName;     // Catch: Throwable -> L13
        Boolean r7 = null;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Throwable -> L13
        r6 = null;
    L6:
        r4.putString(KvConstant.KEY_PKG_NAME, r6);     // Catch: Throwable -> L13
        r4.putBoolean(KvConstant.KV_SWITCH_STATE, r9);     // Catch: Throwable -> L13
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        Bundle r8 = call(KvConstant.METHOD_SET_SWITCH_STATUS, null, r4);     // Catch: Throwable -> L13
        if (r8 == null) goto L9;
        r7 = Boolean.valueOf(r8.getBoolean("result"));     // Catch: Throwable -> L13
    L9:
        KvLog.INSTANCE.i(TAG, "setSwitchStatus, res: " + r7);     // Catch: Throwable -> L13
        if (r7 == null) goto L18;
        return r7.booleanValue();
    L18:
        return false;
    L13:
        th = move-exception;
        KvLog.INSTANCE.e(TAG, "setSwitchStatus failed, error: " + th, th);
        return false;
    }

    public final boolean getSyncSettingsStatus() {
        Bundle r4 = new Bundle();     // Catch: Throwable -> L13
        String r6 = packageName;     // Catch: Throwable -> L13
        Boolean r7 = null;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Throwable -> L13
        r6 = null;
    L6:
        r4.putString(KvConstant.KEY_PKG_NAME, r6);     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        Bundle r8 = call(KvConstant.METHOD_GET_SYNC_SETTINGS_STATUS, null, r4);     // Catch: Throwable -> L13
        if (r8 == null) goto L9;
        r7 = Boolean.valueOf(r8.getBoolean(KvConstant.KEY_IS_CURRENT_SYNCABLE));     // Catch: Throwable -> L13
    L9:
        KvLog.INSTANCE.i(TAG, "getSyncSettingsStatus, enabled: " + r7);     // Catch: Throwable -> L13
        if (r7 == null) goto L18;
        return r7.booleanValue();
    L18:
        return false;
    L13:
        th = move-exception;
        KvLog.INSTANCE.e(TAG, "getSyncSettingsStatus failed, error: " + th, th);
        return false;
    }

    public final Bundle getUsedSpaceDetail() {
        KvLog.INSTANCE.d(TAG, "getUsedSpaceDetail");
        Bundle r2 = new Bundle();     // Catch: Throwable -> L19
        String r5 = packageName;     // Catch: Throwable -> L19
        Long r6 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("packageName");     // Catch: Throwable -> L19
        r5 = null;
    L6:
        r2.putString(KvConstant.KEY_PKG_NAME, r5);     // Catch: Throwable -> L19
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Bundle r7 = call(KvConstant.METHOD_GET_USED_SPACE_DETAIL, null, r2);     // Catch: Throwable -> L19
        if (r7 == null) goto L9;
        Long r1 = Long.valueOf(r7.getLong(KvConstant.KEY_USED_SPACE));     // Catch: Throwable -> L19
    L10:
        if (r7 == null) goto L12;
        Long r3 = Long.valueOf(r7.getLong(KvConstant.KEY_TOTAL_SPACE));     // Catch: Throwable -> L19
    L13:
        if (r7 == null) goto L15;
        r6 = Long.valueOf(r7.getLong(KvConstant.KEY_APP_USED_SPACE));     // Catch: Throwable -> L19
    L15:
        KvLog.INSTANCE.i(TAG, "getUsedSpaceDetail, usedSpace: " + r1 + ", totalSpace: " + r3 + ", appUsedSpace: " + r6);     // Catch: Throwable -> L19
        if (r7 != null) goto L24;
        return new Bundle();
    L24:
        return r7;
    L12:
        r3 = null;
        goto L13
    L9:
        r1 = null;
    L19:
        th = move-exception;
        KvLog.INSTANCE.e(TAG, "getUsedSpaceDetail failed, error: " + th, th);
        return new Bundle();
    }

    public final void notifySyncSettingsChanged(boolean r3) {
        KvLog.INSTANCE.d(TAG, "notifySyncSettingsChanged, enabled: " + r3);
        Iterator<T> r2 = syncStateListeners.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SyncStateListener) r2.next()).onSyncSettingsChanged(r3);
        goto L4
    }

    public final boolean tryRenameLocalFile(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "newFileName");
        KvLog.INSTANCE.d(TAG, "tryRenameLocalFile, dataId: " + r4);
        Iterator<T> r3 = syncStateListeners.iterator();
    L3:
        boolean r1 = true;
    L5:
        if (r3.hasNext() == false) goto L12;
        SyncStateListener r2 = (SyncStateListener) r3.next();
        if (r1 == false) goto L11;
        if (r2.tryRenameLocalFile(r4, r6) == true) goto L3;
    L11:
        r1 = false;
        goto L5
    L12:
        return r1;
    }
}
