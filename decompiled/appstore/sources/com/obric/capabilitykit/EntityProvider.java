package com.obric.capabilitykit;

import android.annotation.SuppressLint;
import android.app.assist.AssistContent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.UserManager;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import cb.e;
import cb.f;
import cb.k;
import cb.l;
import cb.y;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonSyntaxException;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.ResultCallback;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.utils.IndexResult;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.capabilitykit.sync.EntitySyncUtil;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.capabilitykit.version.EntityVersionData;
import com.obric.capabilitykit.version.PersonalContextData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.z;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00011\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u008d\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u0006H\u0007J(\u0010J\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0007J-\u0010O\u001a\u00020F2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0001¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020FH\u0002J\u0018\u0010R\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u0006H\u0002J\u0018\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0006H\u0007J\u0006\u0010V\u001a\u00020FJ,\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020Y2\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020L\u0018\u00010Zj\n\u0012\u0004\u0012\u00020L\u0018\u0001`[H\u0007J\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020L0H2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0HH\u0002J\u001e\u0010]\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\f\u0010M\u001a\b\u0012\u0004\u0012\u00020^0NH\u0007J\u0012\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010I\u001a\u00020\u0006H\u0003J \u0010`\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010H2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u0004H\u0007J\"\u0010c\u001a\u00020F2\u0006\u0010d\u001a\u00020L2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0007J\u0015\u0010e\u001a\u00020F2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\u001e\u0010i\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u0006H\u0002J(\u0010j\u001a\u00020k2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0H2\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010NH\u0002J0\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u00042\b\u0010p\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010q\u001a\u0004\u0018\u00010mH\u0002J\b\u0010r\u001a\u00020<H\u0002J\u0010\u0010s\u001a\u00020<2\u0006\u0010I\u001a\u00020\u0006H\u0007J\b\u0010t\u001a\u00020<H\u0002J\u000f\u0010u\u001a\u0004\u0018\u00010mH\u0000¢\u0006\u0002\bvJ\u0017\u0010w\u001a\u00020<2\b\u0010x\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\byJ\r\u0010z\u001a\u00020FH\u0000¢\u0006\u0002\b{J\"\u0010|\u001a\u00020F2\b\u0010}\u001a\u0004\u0018\u00010m2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u007fH\u0002J!\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020L0H2\u0007\u0010\u0081\u0001\u001a\u0002042\u0007\u0010\u0082\u0001\u001a\u00020\u0004H\u0002J\u0016\u0010\u0083\u0001\u001a\u00020F2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060HJ\u001a\u0010\u0085\u0001\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020\u000eH\u0002J\u0019\u0010\u0087\u0001\u001a\u00020F2\u000e\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010HH\u0002J \u0010\u0087\u0001\u001a\u00020F2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020L0H2\u0006\u0010~\u001a\u00020\u007fH\u0002J'\u0010\u0087\u0001\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040H2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u007fH\u0002J\u0010\u0010\u008b\u0001\u001a\u00020F2\u0007\u0010\u008c\u0001\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0012\u00100\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020<@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006\u008e\u0001"}, d2 = {"Lcom/obric/capabilitykit/EntityProvider;", "", "()V", "ENTITY_FIRST_FLAG", "", "ENTITY_LIST_CHUNK_SIZE", "", "ENTITY_REPO", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getENTITY_URI$capabilitykit_release", "()Landroid/net/Uri;", "INIT_TASK_DELAY_TIME", "", "INSERT_ENTITY_RETRY_TIMES", "KEY_APP_ENTITY_COUNT", "KEY_CLEAN_BEFORE_TIMESTAMP", "KEY_ENTITY_IDS", "KEY_ENTITY_LIST", "KEY_ENTITY_TYPE", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_INDEX_PROGRESS", "KEY_IS_DONATE_ALLOWED", "KEY_MAX_LAST_MODIFIED_TIME", "KEY_ON_SCREEN_ENTITIES", "KEY_PKG_NAME", "KEY_PRODUCT_NAME", "KEY_SUCCESS_IDS", "MAX_TRANSACTION_SIZE_BYTES", "METHOD_CHECK_SYNCED_DATA", "METHOD_DATA_CLEAN", "METHOD_DELETE", "METHOD_FETCH_SYNC_INFO", "METHOD_GET_ENTITY_INDEX_PROGRESS", "METHOD_GET_ON_SCREEN_ENTITIES", "METHOD_INDEX", "METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH", "METHOD_QUERY_PERSONAL_CONTEXT_DATA", "METHOD_SYNC_DELETE", "TAG", "dbHelper", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getDbHelper", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "deviceUnlockedReceiver", "com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Lcom/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "featureRunProcessName", "firstRunCleanBeforeTimestamp", "initialCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "<set-?>", "", "isInitialized", "()Z", "sContext", "Landroid/content/Context;", "getSContext", "()Landroid/content/Context;", "setSContext", "(Landroid/content/Context;)V", "bulkDelete", "", "entityIds", "", "entityType", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/capabilitykit/entity/ResultCallback;", "bulkIndexInner", "bulkIndexInner$capabilitykit_release", "checkIfFirstRunOrDataClean", "checkSyncedData", "entityCount", EntityProvider.METHOD_DELETE, "entityId", "deleteAllEntityData", "donateOnScreenData", "outContent", "Landroid/app/assist/AssistContent;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterLastUniqueEntities", "getIndexProgress", "Lcom/obric/capabilitykit/entity/IndexProgress;", "getIndexProgressInternal", "getOnScreenData", "productName", "pkgName", "index", "entity", "init", "entityInitParam", "Lcom/obric/capabilitykit/entity/EntityInitParam;", "init$capabilitykit_release", "innerBulkDelete", "innerBulkIndex", "Lcom/obric/capabilitykit/entity/utils/IndexResult;", "innerCall", "Landroid/os/Bundle;", "uri", "method", "arg", WsConstants.KEY_EXTRA, "isCredentialProtectionLocked", "isDonateAllowed", "isNotInFeatureProcess", "queryPersonalContextData", "queryPersonalContextData$capabilitykit_release", "reDonateCheck", "paramString", "reDonateCheck$capabilitykit_release", "reindexEntityData", "reindexEntityData$capabilitykit_release", "removeProcessedEntityFromDB", "result", "action", "Lcom/obric/capabilitykit/entity/ActionType;", "safeProvideAllEntities", "supplier", "source", "syncData", "indexedEntityTypes", "syncDelete", "lastModifiedTime", "tryInsertBulkEntityHistory", "entityDaoList", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "entityList", "waitEntityProviderInit", "timeOutMs", "EntitySyncBackedSupplier", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityProvider {

    @NotNull
    private static final String ENTITY_FIRST_FLAG = "first_run_flag";
    private static final int ENTITY_LIST_CHUNK_SIZE = 100;

    @NotNull
    private static final String ENTITY_REPO = "entity_repo";
    private static final Uri ENTITY_URI = null;
    private static final long INIT_TASK_DELAY_TIME = 10000;
    private static final int INSERT_ENTITY_RETRY_TIMES = 3;

    @NotNull
    public static final EntityProvider INSTANCE = null;

    @NotNull
    private static final String KEY_APP_ENTITY_COUNT = "app_entity_count";

    @NotNull
    public static final String KEY_CLEAN_BEFORE_TIMESTAMP = "clean_before_timestamp";

    @NotNull
    public static final String KEY_ENTITY_IDS = "entity_ids";

    @NotNull
    public static final String KEY_ENTITY_LIST = "entity_list";

    @NotNull
    public static final String KEY_ENTITY_TYPE = "entity_type";

    @NotNull
    private static final String KEY_ERROR_CODE = "error_code";

    @NotNull
    private static final String KEY_ERROR_MSG = "error_msg";

    @NotNull
    private static final String KEY_INDEX_PROGRESS = "index_progress";

    @NotNull
    private static final String KEY_IS_DONATE_ALLOWED = "is_donate_allowed";

    @NotNull
    private static final String KEY_MAX_LAST_MODIFIED_TIME = "max_last_modified_time";

    @NotNull
    private static final String KEY_ON_SCREEN_ENTITIES = "on_screen_entities";

    @NotNull
    private static final String KEY_PKG_NAME = "pkg_name";

    @NotNull
    private static final String KEY_PRODUCT_NAME = "product_name";

    @NotNull
    public static final String KEY_SUCCESS_IDS = "success_ids";
    private static final int MAX_TRANSACTION_SIZE_BYTES = 921600;

    @NotNull
    private static final String METHOD_CHECK_SYNCED_DATA = "check_synced_data";

    @NotNull
    private static final String METHOD_DATA_CLEAN = "data_clean";

    @NotNull
    private static final String METHOD_DELETE = "delete";

    @NotNull
    private static final String METHOD_FETCH_SYNC_INFO = "fetch_sync_info";

    @NotNull
    private static final String METHOD_GET_ENTITY_INDEX_PROGRESS = "get_entity_index_progress";

    @NotNull
    private static final String METHOD_GET_ON_SCREEN_ENTITIES = "get_on_screen_entities";

    @NotNull
    private static final String METHOD_INDEX = "index";

    @NotNull
    private static final String METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH = "is_donate_allowed_by_local_switch";

    @NotNull
    private static final String METHOD_QUERY_PERSONAL_CONTEXT_DATA = "query_personal_context_data";

    @NotNull
    private static final String METHOD_SYNC_DELETE = "sync_delete";

    @NotNull
    public static final String TAG = "EntityProvider";

    @NotNull
    private static final Lazy dbHelper$delegate = null;

    @Keep
    @NotNull
    private static final EntityProvider$deviceUnlockedReceiver$1 deviceUnlockedReceiver = null;

    @Nullable
    private static EntitySupplier entitySupplier;

    @Nullable
    private static EntitySyncDataSupplier entitySyncDataSupplier;

    @Nullable
    private static String featureRunProcessName;
    private static long firstRunCleanBeforeTimestamp;

    @NotNull
    private static CountDownLatch initialCountDownLatch;
    private static volatile boolean isInitialized;

    @SuppressLint({"StaticFieldLeak"})
    public static Context sContext;

    public static final class a implements EntitySupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EntitySyncDataSupplier f11209a;

        public a(EntitySyncDataSupplier r10) {
            kotlin.jvm.internal.q.g(r10, "entitySyncDataSupplier");
            this.f11209a = r10;
        }

        @Override // com.obric.capabilitykit.EntitySupplier
        public List provideAllEntities() {
            List<EntityIdData> r10 = this.f11209a.provideSampleEntities();     // Catch: Throwable -> L29
            if (r10.isEmpty() == true) goto L7;
            ArrayList r11 = new ArrayList();
            LinkedHashMap r12 = new LinkedHashMap();
            Iterator<T> r13 = r10.iterator();
        L10:
            if (r13.hasNext() == false) goto L15;
            Object r14 = r13.next();
            Integer r15 = Integer.valueOf(((EntityIdData) r14).getType());
            Object r16 = r12.get(r15);
            if (r16 != null) goto L14;
            r16 = new ArrayList();
            r12.put(r15, r16);
        L14:
            ((List) r16).add(r14);
            goto L10
        L15:
            Iterator r17 = r12.values().iterator();
        L17:
            if (r17.hasNext() == false) goto L28;
            List r18 = (List) r17.next();
            EntitySyncDataSupplier r19 = this.f11209a;     // Catch: Throwable -> L23
            ArrayList r20 = new ArrayList(kotlin.collections.u.r(r18, 10));     // Catch: Throwable -> L23
            Iterator r21 = r18.iterator();     // Catch: Throwable -> L23
        L21:
            if (r21.hasNext() == false) goto L25;
            r20.add(((EntityIdData) r21.next()).getId());     // Catch: Throwable -> L23
            goto L21
        L25:
            r11.addAll(r19.getWholeEntities(r20, ((EntityIdData) b0.Y(r18)).getType()));     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Logger.INSTANCE.e(EntityProvider.TAG, "getWholeEntities failed, type=" + ((EntityIdData) b0.Y(r18)).getType() + ", requestedSize=" + r18.size() + ", return partial result", th);
            goto L17
        L28:
            return r11;
        L7:
            return kotlin.collections.t.i();
        L29:
            th = move-exception;
            Logger.INSTANCE.e(EntityProvider.TAG, "provideSampleEntities failed, return partial result", th);
            return kotlin.collections.t.i();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<cb.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11210a = null;

        static {
            f11210a = new b();
        }

        public b() {
            super(0);
        }

        @NotNull
        public final cb.t a() {
            return cb.t.f6104b.a(EntityProvider.INSTANCE.getSContext());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ cb.t invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.EntityProvider$getIndexProgress$1$1", f = "EntityProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IndexProgress f11212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResultCallback<IndexProgress> f11213c;

        public c(IndexProgress r10, ResultCallback<IndexProgress> r11, Continuation<? super c> r12) {
            this.f11212b = r10;
            this.f11213c = r11;
            super(2, r12);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new c(this.f11212b, this.f11213c, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11211a != 0) goto L11;
            kotlin.c.b(r10);
            IndexProgress r11 = this.f11212b;
            if (r11 != null) goto L7;
            ResultCallback.a.a(this.f11213c, 501, "failed to get index progress", null, 4, null);
        L9:
            return Unit.f21064a;
        L7:
            this.f11213c.onResult(0, "ok", r11);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "method", "", "bundle", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function3<Uri, String, Bundle, Bundle> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11214a = null;

        static {
            f11214a = new d();
        }

        public d() {
            super(3);
        }

        @Nullable
        public final Bundle a(@NotNull Uri r10, @NotNull String r11, @Nullable Bundle r12) {
            kotlin.jvm.internal.q.g(r10, "uri");
            kotlin.jvm.internal.q.g(r11, "method");
            return EntityProvider.access$innerCall(EntityProvider.INSTANCE, r10, r11, null, r12);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Bundle invoke(Uri r10, String r11, Bundle r12) {
            return a(r10, r11, r12);
        }
    }

    static {
        INSTANCE = new EntityProvider();
        ENTITY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
        dbHelper$delegate = kotlin.b.b(b.f11210a);
        initialCountDownLatch = new CountDownLatch(1);
        deviceUnlockedReceiver = new EntityProvider$deviceUnlockedReceiver$1();
    }

    private EntityProvider() {
    }

    public static /* synthetic */ void a(List r10, ResultCallback r11) {
        bulkIndexInner$lambda$13(r10, r11);
    }

    public static final /* synthetic */ void access$checkIfFirstRunOrDataClean(EntityProvider r10) {
        r10.checkIfFirstRunOrDataClean();
    }

    public static final /* synthetic */ Bundle access$innerCall(EntityProvider r10, Uri r11, String r12, String r13, Bundle r14) {
        return r10.innerCall(r11, r12, r13, r14);
    }

    public static /* synthetic */ void b() {
        deleteAllEntityData$lambda$16();
    }

    private static final void bulkDelete$lambda$15(List r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "$entityIds");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = (String) r12.next();
        INSTANCE.getDbHelper().d(r13, r11);
        goto L4
    L6:
        EntityProvider r14 = INSTANCE;
        r14.tryInsertBulkEntityHistory(r10, r11, m.f11372d);
        r14.innerBulkDelete(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndex$default(EntityProvider r10, List r11, ResultCallback r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.bulkIndex(r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bulkIndexInner$capabilitykit_release$default(EntityProvider r10, List r11, ResultCallback r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.bulkIndexInner$capabilitykit_release(r11, r12);
    }

    private static final void bulkIndexInner$lambda$13(List r13, ResultCallback r14) {
        kotlin.jvm.internal.q.g(r13, "$entities");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r11 = r15.next();
        Integer r12 = Integer.valueOf(((AppEntity) r11).getType());
        Object r16 = r10.get(r12);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r10.put(r12, r16);
    L8:
        ((List) r16).add(r11);
        goto L4
    L9:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r10.entrySet().iterator();
    L11:
        if (r18.hasNext() == false) goto L20;
        Map.Entry r19 = (Map.Entry) r18.next();
        List<AppEntity> r20 = INSTANCE.filterLastUniqueEntities((List) r19.getValue());
        Iterator<T> r21 = r20.iterator();
    L14:
        if (r21.hasNext() == false) goto L16;
        AppEntity r22 = (AppEntity) r21.next();
        INSTANCE.getDbHelper().d(r22.getId(), r22.getType());
        goto L14
    L16:
        EntityProvider r23 = INSTANCE;
        r23.tryInsertBulkEntityHistory(r20, m.f11371c);
        IndexResult r24 = r23.innerBulkIndex(r20, r14);
        if (r24.getCode() == 0) goto L11;
        r17.put(r19.getKey(), r24);
        goto L11
    L20:
        if (r17.isEmpty() == true) goto L43;
        Logger.INSTANCE.w(TAG, "bulkIndexInner failed, failedMessageMap: " + r17);
        Collection r25 = r17.values();
        ArrayList r26 = new ArrayList(kotlin.collections.u.r(r25, 10));
        Iterator r27 = r25.iterator();
    L23:
        if (r27.hasNext() == false) goto L25;
        r26.add(Integer.valueOf(((IndexResult) r27.next()).getCode()));
        goto L23
    L25:
        Set r28 = b0.B0(r26);
        if (r28.size() != r17.size()) goto L28;
        boolean r29 = true;
    L30:
        if (r28.size() != 1) goto L34;
        IndexResult r110 = (IndexResult) b0.X(r17.values());
        if (r14 == null) goto L57;
        ResultCallback.a.a(r14, r110.getCode(), r110.getMessage(), null, 4, null);
        return;
    L57:
        return;
    L34:
        if (r29 == false) goto L36;
        String r30 = "all ";
    L37:
        Iterator r111 = r17.entrySet().iterator();
        String r31 = r30 + " entity type index failed:";
    L39:
        if (r111.hasNext() == false) goto L41;
        Map.Entry r32 = (Map.Entry) r111.next();
        r31 = r31 + "\n entity type " + ((Number) r32.getKey()).intValue() + " reason: " + ((IndexResult) r32.getValue()).getMessage();
        goto L39
    L41:
        if (r14 == null) goto L59;
        ResultCallback.a.a(r14, 304, r31, null, 4, null);
        return;
    L59:
        return;
    L36:
        r30 = "some ";
        goto L37
    L28:
        r29 = false;
        goto L30
    L43:
        if (r14 == null) goto L61;
        ResultCallback.a.a(r14, 0, "success", null, 4, null);
        return;
    }

    public static /* synthetic */ void c(CountDownLatch r10, Set r11) {
        reDonateCheck$lambda$46(r10, r11);
    }

    private final void checkIfFirstRunOrDataClean() {
        y.f6116a.a();
        SharedPreferences r10 = getSContext().getSharedPreferences(ENTITY_REPO, 0);
        if (r10.getBoolean(ENTITY_FIRST_FLAG, false) == true) goto L8;
        SharedPreferences.Editor r11 = r10.edit();
        r11.putBoolean(ENTITY_FIRST_FLAG, true);
        r11.apply();
        if (kotlin.jvm.internal.q.b("com.android.gallery3d", getSContext().getPackageName()) == true) goto L7;
        Logger.INSTANCE.i(TAG, "app's data may cleared, need to clean relative entity data, firstRunTimeStamp=" + firstRunCleanBeforeTimestamp);
        Bundle r12 = new Bundle();
        r12.putLong(KEY_CLEAN_BEFORE_TIMESTAMP, firstRunCleanBeforeTimestamp);
        Uri r13 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r13, "ENTITY_URI");
        innerCall(r13, METHOD_DATA_CLEAN, null, r12);
    L7:
        EntitySupplier r14 = entitySupplier;
        kotlin.jvm.internal.q.d(r14);
        bulkIndex$default(this, safeProvideAllEntities(r14, "checkIfFirstRunOrDataClean"), null, 2, null);
        return;
    L8:
        p.f11375a.f();
    }

    private final void checkSyncedData(int r10, int r11) {
        Bundle r12 = new Bundle();
        r12.putInt(KEY_ENTITY_TYPE, r10);
        r12.putInt(KEY_APP_ENTITY_COUNT, r11);
        Uri r13 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r13, "ENTITY_URI");
        innerCall(r13, METHOD_CHECK_SYNCED_DATA, null, r12);
    }

    public static /* synthetic */ void d() {
        init$lambda$2();
    }

    private static final void deleteAllEntityData$lambda$16() {
        EntityProvider r10 = INSTANCE;
        Uri r11 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r11, "ENTITY_URI");
        innerCall$default(r10, r11, METHOD_DATA_CLEAN, null, null, 8, null);
    }

    public static /* synthetic */ void e(List r10, CountDownLatch r11) {
        syncData$lambda$47(r10, r11);
    }

    public static /* synthetic */ void f(List r10, int r11) {
        bulkDelete$lambda$15(r10, r11);
    }

    private final List<AppEntity> filterLastUniqueEntities(List<? extends AppEntity> r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        ArrayList r12 = new ArrayList();
        Iterator r13 = z.J(r10).iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        AppEntity r14 = (AppEntity) r13.next();
        if (r11.contains(r14.getId()) == true) goto L4;
        r12.add(r14);
        r11.add(r14.getId());
        goto L4
    L9:
        return z.K(r12);
    }

    public static /* synthetic */ void g(CountDownLatch r10) {
        reindexEntityData$lambda$49(r10);
    }

    private final cb.t getDbHelper() {
        return (cb.t) dbHelper$delegate.getValue();
    }

    private static final void getIndexProgress$lambda$5(int r10, ResultCallback r11) {
        kotlin.jvm.internal.q.g(r11, "$callback");
        IndexProgress r12 = INSTANCE.getIndexProgressInternal(r10);
        h.d(d0.a(l0.c()), null, null, new c(r12, r11, null), 3, null);
    }

    @WorkerThread
    private final IndexProgress getIndexProgressInternal(int r10) {
        Bundle r11 = new Bundle();
        r11.putInt(KEY_ENTITY_TYPE, r10);
        Uri r12 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r12, "ENTITY_URI");
        Object r13 = null;
        Bundle r14 = innerCall(r12, METHOD_GET_ENTITY_INDEX_PROGRESS, null, r11);
        if (r14 == null) goto L11;
        String r15 = r14.getString(KEY_INDEX_PROGRESS);
        if (r15 == null) goto L11;
        if (r15.length() == 0) goto L11;
        r13 = UtilsKt.getGson().fromJson(r15, IndexProgress.class);
    L11:
        return (IndexProgress) r13;
    }

    public static /* synthetic */ void h(int r10, ResultCallback r11) {
        getIndexProgress$lambda$5(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void index$default(EntityProvider r10, AppEntity r11, ResultCallback r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.index(r11, r12);
    }

    private static final void init$lambda$2() {
        INSTANCE.checkIfFirstRunOrDataClean();
    }

    private final void innerBulkDelete(List<String> r10, int r11) {
        if (isCredentialProtectionLocked() == false) goto L6;
        Logger.INSTANCE.w(TAG, "device is locked, delete entity will retry when user unlocked device");
        return;
    L6:
        Iterator r12 = b0.R(r10, 100).iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        List r13 = (List) r12.next();
        Logger.INSTANCE.i(TAG, "innerBulkDelete ids: " + q.b(r10));
        Bundle r14 = new Bundle();
        Object[] r15 = r13.toArray(new String[0]);
        if (r15 == null) goto L13;
        r14.putStringArray(KEY_ENTITY_IDS, (String[]) r15);
        r14.putInt(KEY_ENTITY_TYPE, r11);
        EntityProvider r16 = INSTANCE;
        Uri r17 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r17, "ENTITY_URI");
        r16.removeProcessedEntityFromDB(r16.innerCall(r17, METHOD_DELETE, null, r14), r11, m.f11372d);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final IndexResult innerBulkIndex(List<? extends AppEntity> r14, ResultCallback<Unit> r15) {
        if (isCredentialProtectionLocked() == true) goto L5;
        PersonalContextData r13 = y.f6116a.a();
        Parcel r10 = null;
        Integer r11 = null;
        if (r13 == null) goto L9;
        Set<Integer> r16 = r13.getSupportEntityTypes();
    L11:
        if (r16 != null) goto L14;
        Logger.INSTANCE.w(TAG, "innerBulkIndex get PersonalContextData failed");
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
        return new IndexResult(303, "donate failed temporarily, personal context will retry internally");
    L14:
        ArrayList r12 = new ArrayList();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r14.iterator();
    L16:
        if (r18.hasNext() == false) goto L22;
        AppEntity r19 = (AppEntity) r18.next();
        if (r16.contains(Integer.valueOf(r19.getType())) == true) goto L19;
        r12.add(r19);
        goto L16
    L19:
        r17.add(r19);
        goto L16
    L22:
        if (r12.isEmpty() == true) goto L28;
        Logger.INSTANCE.i(TAG, "innerBulkIndex, unsupported ids: " + q.b(q.a(r12)));
        Iterator r110 = r12.iterator();
    L25:
        if (r110.hasNext() == false) goto L28;
        AppEntity r20 = (AppEntity) r110.next();
        INSTANCE.getDbHelper().f(r20.getId(), r20.getType(), m.f11371c.b());
    L28:
        if (r17.isEmpty() == false) goto L34;
        Logger r111 = Logger.INSTANCE;
        StringBuilder r112 = new StringBuilder();
        r112.append("innerBulkIndex, no supporting entity type ");
        AppEntity r113 = (AppEntity) b0.Z(r14);
        if (r113 == null) goto L32;
        r11 = Integer.valueOf(r113.getType());
    L32:
        r112.append(r11);
        r111.w(TAG, r112.toString());
        return new IndexResult(302, "unsupported entity type");
    L34:
        ArrayList r114 = new ArrayList();
        if (r17.size() >= 3) goto L41;
        Iterator r115 = r17.iterator();
    L38:
        if (r115.hasNext() == false) goto L40;
        ((AppEntity) r115.next()).countHashCode();
        goto L38
    L40:
        r114.add(r17);
    L76:
        Iterator r116 = r114.iterator();
    L78:
        if (r116.hasNext() == false) goto L101;
        List r117 = (List) r116.next();
        Logger r21 = Logger.INSTANCE;
        r21.i(TAG, "innerBulkIndex ids: " + q.b(q.a(r117)));
        Bundle r22 = new Bundle();
        r22.putParcelableArrayList(KEY_ENTITY_LIST, new ArrayList(r117));
        EntityProvider r23 = INSTANCE;
        Uri r24 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r24, "ENTITY_URI");
        Bundle r25 = r23.innerCall(r24, "index", null, r22);
        String r26 = "internal error";
        if (r25 == null) goto L81;
        int r27 = r25.getInt("error_code");
        String r28 = r25.getString(KEY_ERROR_MSG);
        if (r28 == null) goto L89;
        r26 = r28;
    L89:
        kotlin.jvm.internal.q.f(r26, "this.getString(KEY_ERROR_MSG)?: \"internal error\"");
        if (r27 != 0) goto L92;
        r23.removeProcessedEntityFromDB(r25, ((AppEntity) r117.get(0)).getType(), m.f11371c);
        goto L78
    L92:
        r21.w(TAG, "innerBulkIndex failed, errorCode: " + r27 + ", errorMsg: " + r26);
        if (r27 != 111) goto L99;
        Iterator r118 = r117.iterator();
    L96:
        if (r118.hasNext() == false) goto L99;
        AppEntity r119 = (AppEntity) r118.next();
        INSTANCE.getDbHelper().d(r119.getId(), r119.getType());
    L99:
        return new IndexResult(r27, r26);
    L81:
        if (r15 == null) goto L84;
        ResultCallback.a.a(r15, 501, "internal error", null, 4, null);
    L84:
        return new IndexResult(501, "internal error");
    L101:
        return new IndexResult(0, "success");
    L41:
        ArrayList r120 = new ArrayList();
        Iterator r29 = r17.iterator();
        int r30 = 0;
    L43:
        if (r29.hasNext() == false) goto L74;
        AppEntity r31 = (AppEntity) r29.next();
        r31.countHashCode();
        Parcel r32 = Parcel.obtain();     // Catch: Throwable -> L52 Exception -> L54
        r32.writeParcelable(r31, 0);     // Catch: Throwable -> L48 Exception -> L50
        int r33 = r32.dataSize();     // Catch: Throwable -> L48 Exception -> L50
        r32.recycle();
    L63:
        if (r120.isEmpty() == true) goto L69;
        if ((r30 + r33) <= MAX_TRANSACTION_SIZE_BYTES) goto L67;
    L68:
        r114.add(r120);
        r120 = new ArrayList();
        r30 = 0;
        goto L69
    L67:
        if (r120.size() >= 100) goto L68;
    L69:
        r120.add(r31);
        r30 = r30 + r33;
        goto L43
    L50:
        e = e;
    L58:
        Logger.INSTANCE.e(TAG, "calculate parcel size error", e);     // Catch: Throwable -> L48
        if (r32 == null) goto L61;
        r32.recycle();
    L61:
        r33 = 1024;
    L48:
        th = th;
        r10 = r32;
    L70:
        if (r10 == null) goto L72;
        r10.recycle();
    L72:
        throw th;
    L54:
        e = e;
        r32 = null;
    L52:
        th = th;
        goto L70
    L74:
        if (r120.isEmpty() == true) goto L76;
        r114.add(r120);
        goto L76
    L9:
        r16 = null;
        goto L11
    L5:
        return new IndexResult(305, "device is locked, donate will try when user unlocked device");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexResult innerBulkIndex$default(EntityProvider r10, List r11, ResultCallback r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.innerBulkIndex(r11, r12);
    }

    private final Bundle innerCall(Uri r10, String r11, String r12, Bundle r13) {
    L7:
        e = move-exception;
        Logger.INSTANCE.e(TAG, kotlin.a.b(e));
        return null;
    L4:
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L9;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip call " + r11);     // Catch: Exception -> L7
        return null;
    L9:
        ContentProviderClient r14 = getSContext().getContentResolver().acquireUnstableContentProviderClient(r10);     // Catch: Exception -> L7
        if (r14 != null) goto L31;
        Logger.INSTANCE.w(TAG, "failed to acquire unstable provider client, skip call " + r11);     // Catch: Exception -> L7
        return null;
    L31:
        Bundle r15 = r14.call(r11, r12, r13);     // Catch: Throwable -> L15 Exception -> L17 DeadObjectException -> L20
    L23:
        r14.close();     // Catch: Exception -> L7
        return r15;
    L17:
        e = e;
        Logger r16 = Logger.INSTANCE;     // Catch: Throwable -> L15
        String r17 = "provider call failed " + r11;     // Catch: Throwable -> L15
    L19:
        r16.e(TAG, r17, e);     // Catch: Throwable -> L15
        r15 = null;
    L20:
        e = e;
        r16 = Logger.INSTANCE;     // Catch: Throwable -> L15
        r17 = "unstable provider died during call " + r11;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r14.close();     // Catch: Exception -> L7
        throw th;     // Catch: Exception -> L7
    }

    public static /* synthetic */ Bundle innerCall$default(EntityProvider r10, Uri r11, String r12, String r13, Bundle r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = new Bundle();
    L6:
        return r10.innerCall(r11, r12, r13, r14);
    }

    private final boolean isCredentialProtectionLocked() {
        return !((UserManager) getSContext().getSystemService(UserManager.class)).isUserUnlocked();
    }

    private final boolean isNotInFeatureProcess() {
        if (isInitialized == true) goto L5;
        return true;
    L5:
        String r10 = featureRunProcessName;
        if (r10 == null) goto L9;
        return true ^ kotlin.jvm.internal.q.b(cb.q.f6086a.a(INSTANCE.getSContext()), r10);
    L9:
        if (cb.q.f6086a.b(getSContext()) == false) goto L14;
        return false;
    L14:
        return true;
    }

    private static final void reDonateCheck$lambda$46(CountDownLatch r10, Set r11) {
        kotlin.jvm.internal.q.g(r10, "$finishDonateCountDownLatch");
        kotlin.jvm.internal.q.g(r11, "$needDonateVersions");
        EntitySupplier r12 = entitySupplier;
        if (r12 == null) goto L5;
        List<AppEntity> r13 = INSTANCE.safeProvideAllEntities(r12, "reDonateCheck");
    L6:
        if (r13 != null) goto L9;
        r10.countDown();
        return;
    L9:
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<T> r15 = r13.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        Object r16 = r15.next();
        Integer r17 = Integer.valueOf(((AppEntity) r16).getType());
        Object r18 = r14.get(r17);
        if (r18 != null) goto L15;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L15:
        ((List) r18).add(r16);
        goto L11
    L16:
        Iterator r19 = r14.entrySet().iterator();
    L18:
        if (r19.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r19.next();
        if (r11.contains(r20.getKey()) == false) goto L18;
        Logger.INSTANCE.i(TAG, "reDonateCheck, reDonate type: " + ((Number) r20.getKey()).intValue());
        bulkIndexInner$capabilitykit_release$default(INSTANCE, (List) r20.getValue(), null, 2, null);
        goto L18
    L22:
        r10.countDown();
        return;
    L5:
        r13 = null;
        goto L6
    }

    private static final void reindexEntityData$lambda$49(CountDownLatch r10) {
        kotlin.jvm.internal.q.g(r10, "$finishDonateCountDownLatch");
        EntitySupplier r11 = entitySupplier;     // Catch: Throwable -> L7 Exception -> L9
        if (r11 == null) goto L11;
        EntityProvider r12 = INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
        bulkIndex$default(r12, r12.safeProvideAllEntities(r11, "reindexEntityData"), null, 2, null);     // Catch: Throwable -> L7 Exception -> L9
    L11:
        r10.countDown();
        return;
    L9:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityDataInner error", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r10.countDown();
        throw th;
    }

    private final void removeProcessedEntityFromDB(Bundle r10, int r11, m r12) {
        if (r10 == null) goto L9;
        ArrayList<String> r13 = r10.getStringArrayList(KEY_SUCCESS_IDS);
        if (r13 == null) goto L9;
        Logger.INSTANCE.i(TAG, "callback successIds: " + q.b(r13) + " entityType: " + r11 + " type: " + r12.b());
        Iterator<T> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        String r15 = (String) r14.next();
        cb.t r16 = INSTANCE.getDbHelper();
        kotlin.jvm.internal.q.f(r15, "id");
        r16.f(r15, r11, r12.b());
        p.f11375a.c(r15, r11, r12.b());
    L9:
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
    }

    private final List<AppEntity> safeProvideAllEntities(EntitySupplier r10, String r11) {
        return r10.provideAllEntities();
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, r11 + " provideAllEntities failed, return partial result", th);
        return kotlin.collections.t.i();
    }

    private static final void syncData$lambda$47(List r10, CountDownLatch r11) {
        kotlin.jvm.internal.q.g(r10, "$indexedEntityTypes");
        kotlin.jvm.internal.q.g(r11, "$finishSyncDataCountDownLatch");
        EntitySyncUtil.INSTANCE.syncData(entitySyncDataSupplier, entitySupplier, r10, null, d.f11214a);     // Catch: Throwable -> L5
    L7:
        r11.countDown();
        return;
    L5:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "syncData error", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r11.countDown();
        throw th;
    }

    private final void syncDelete(int r10, long r11) {
        Logger.INSTANCE.d(TAG, "to delete entities which lastModifiedTime > " + r11 + " for type " + r10);
        Bundle r12 = new Bundle();
        r12.putInt(KEY_ENTITY_TYPE, r10);
        r12.putLong(KEY_MAX_LAST_MODIFIED_TIME, r11);
        Uri r13 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r13, "ENTITY_URI");
        innerCall(r13, METHOD_SYNC_DELETE, null, r12);
    }

    private final void tryInsertBulkEntityHistory(List<cb.u> r10) {
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        r12.addAll(r10);
        int r13 = 0;
    L4:
        if (r13 >= 3) goto L13;
        Pair r14 = INSTANCE.getDbHelper().j(r12);
        r11.addAll((Collection) r14.getSecond());
        Iterator r15 = ((Iterable) r14.getSecond()).iterator();
    L7:
        if (r15.hasNext() == false) goto L10;
        r12.remove((cb.u) r15.next());
        goto L7
    L10:
        if (r11.size() == r10.size()) goto L11;
        r13 = r13 + 1;
        goto L4
    L11:
        return;
    }

    @AnyThread
    public final void bulkDelete(@NotNull final List<String> r10, final int r11) {
        kotlin.jvm.internal.q.g(r10, "entityIds");
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip delete");
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
        return;
    L9:
        IndexTaskManager.INSTANCE.runTask("bulkDelete(size:" + r10.size() + ')', new e(r10, r11));
    }

    @AnyThread
    public final void bulkIndex(@NotNull List<? extends AppEntity> r10, @Nullable ResultCallback<Unit> r11) {
        kotlin.jvm.internal.q.g(r10, "entities");
        if (r10.isEmpty() == false) goto L7;
        if (r11 == null) goto L9;
        ResultCallback.a.a(r11, 301, "entity list is empty", null, 4, null);
        return;
    L9:
        return;
    L7:
        bulkIndexInner$capabilitykit_release(r10, r11);
    }

    @AnyThread
    public final void bulkIndexInner$capabilitykit_release(@NotNull final List<? extends AppEntity> r10, @Nullable final ResultCallback<Unit> r11) {
        kotlin.jvm.internal.q.g(r10, "entities");
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L8;
        if (r11 == null) goto L14;
        ResultCallback.a.a(r11, 306, "EntityProvider is disabled", null, 4, null);
        return;
    L14:
        return;
    L8:
        if (isCredentialProtectionLocked() == false) goto L12;
        if (r11 == null) goto L15;
        ResultCallback.a.a(r11, 305, "device is locked, retry donate when user unlocked device", null, 4, null);
        return;
    L15:
        return;
    L12:
        IndexTaskManager.INSTANCE.runTask("bulkIndexInner(size:" + r10.size() + ')', new cb.j(r10, r11));
    }

    @AnyThread
    public final void delete(@NotNull String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "entityId");
        bulkDelete(kotlin.collections.s.e(r10), r11);
    }

    public final void deleteAllEntityData() {
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip deleteAllEntityData");
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("deleteAllEntityData", new cb.g());
    }

    @RequiresApi(23)
    @UiThread
    public final void donateOnScreenData(@NotNull AssistContent r10, @Nullable ArrayList<AppEntity> r11) {
        kotlin.jvm.internal.q.g(r10, "outContent");
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip donateOnScreenData");
        return;
    L6:
        Logger r12 = Logger.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        r13.append("donateOnScreenData entity list: ");
        if (r11 == null) goto L12;
        ArrayList r14 = new ArrayList(kotlin.collections.u.r(r11, 10));
        Iterator<T> r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        AppEntity r16 = (AppEntity) r15.next();
        r14.add(r16.getId() + " - " + r16.getType());
    L13:
        r13.append(r14);
        r12.d(TAG, r13.toString());
        if (r11 != null) goto L16;
        return;
    L16:
        r10.getExtras().putParcelableArrayList("entities", r11);
        return;
    L12:
        r14 = null;
        goto L13
    }

    public final Uri getENTITY_URI$capabilitykit_release() {
        return ENTITY_URI;
    }

    @AnyThread
    public final void getIndexProgress(final int r10, @NotNull final ResultCallback<IndexProgress> r11) {
        kotlin.jvm.internal.q.g(r11, "callback");
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        ResultCallback.a.a(r11, 306, "Memory service is not available", null, 4, null);
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("getIndexProgress", new cb.h(r10, r11));
    }

    @WorkerThread
    @Nullable
    public final List<AppEntity> getOnScreenData(@NotNull String r10, @NotNull String r11) {
        kotlin.jvm.internal.q.g(r10, "productName");
        kotlin.jvm.internal.q.g(r11, "pkgName");
        Bundle r12 = new Bundle();
        r12.putString(KEY_PRODUCT_NAME, r10);
        r12.putString(KEY_PKG_NAME, r11);
        Uri r13 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r13, "ENTITY_URI");
        Bundle r14 = innerCall(r13, METHOD_GET_ON_SCREEN_ENTITIES, null, r12);
        if (r14 == null) goto L6;
        r14.setClassLoader(AppEntity.class.getClassLoader());
        return r14.getParcelableArrayList(KEY_ON_SCREEN_ENTITIES);
    L6:
        return null;
    }

    @NotNull
    public final Context getSContext() {
        Context r10 = sContext;
        if (r10 == null) goto L5;
        return r10;
    L5:
        kotlin.jvm.internal.q.y("sContext");
        return null;
    }

    @AnyThread
    public final void index(@NotNull AppEntity r10, @Nullable ResultCallback<Unit> r11) {
        kotlin.jvm.internal.q.g(r10, "entity");
        bulkIndex(kotlin.collections.s.e(r10), r11);
    }

    public final synchronized void init$capabilitykit_release(@NotNull EntityInitParam r10) {
        monitor-enter(this);
        kotlin.jvm.internal.q.g(r10, "entityInitParam");     // Catch: Throwable -> L12
        if (isInitialized == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Context r11 = AppHost.Companion.getApplication().getApplicationContext();     // Catch: Throwable -> L12
        kotlin.jvm.internal.q.f(r11, "AppHost.application.applicationContext");     // Catch: Throwable -> L12
        setSContext(r11);     // Catch: Throwable -> L12
        String r12 = r10.getRunProcessName();     // Catch: Throwable -> L12
        boolean r13 = false;
        EntitySupplier r14 = null;
        if (r12 != null) goto L10;
        r12 = null;
    L15:
        featureRunProcessName = r12;     // Catch: Throwable -> L12
        firstRunCleanBeforeTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L12
        String r15 = featureRunProcessName;     // Catch: Throwable -> L12
        if (r15 != null) goto L18;
    L20:
        Logger r16 = Logger.INSTANCE;     // Catch: Throwable -> L12
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L12
        r17.append("init, supplier==null:");     // Catch: Throwable -> L12
        if (r10.getSupplier() != null) goto L23;
        boolean r18 = true;
    L24:
        r17.append(r18);     // Catch: Throwable -> L12
        r17.append(", syncSupplier==null:");     // Catch: Throwable -> L12
        if (r10.getEntitySyncDataSupplier() != null) goto L27;
        r13 = true;
    L27:
        r17.append(r13);     // Catch: Throwable -> L12
        r16.i(TAG, r17.toString());     // Catch: Throwable -> L12
        entitySyncDataSupplier = r10.getEntitySyncDataSupplier();     // Catch: Throwable -> L12
        EntitySupplier r19 = r10.getSupplier();     // Catch: Throwable -> L12
        if (r19 != null) goto L32;
        EntitySyncDataSupplier r20 = entitySyncDataSupplier;     // Catch: Throwable -> L12
        if (r20 == null) goto L33;
        r16.i(TAG, "init with entitySyncDataSupplier-backed entitySupplier");     // Catch: Throwable -> L12
        r14 = new a(r20);     // Catch: Throwable -> L12
    L33:
        entitySupplier = r14;     // Catch: Throwable -> L12
        EntityContextHolder.INSTANCE.init(getSContext());     // Catch: Throwable -> L12
        isInitialized = true;     // Catch: Throwable -> L12
        initialCountDownLatch.countDown();     // Catch: Throwable -> L12
        if (isNotInFeatureProcess() == false) goto L42;
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L12
        r21.append("initTask, featureProcess: ");     // Catch: Throwable -> L12
        String r22 = featureRunProcessName;     // Catch: Throwable -> L12
        if (r22 != null) goto L38;
        r22 = "MainProcess";
    L38:
        r21.append(r22);     // Catch: Throwable -> L12
        r21.append(", currentProcess: ");     // Catch: Throwable -> L12
        r21.append(cb.q.f6086a.a(getSContext()));     // Catch: Throwable -> L12
        r16.w(TAG, r21.toString());     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L42:
        if (entitySupplier != null) goto L46;
        monitor-exit(this);
        return;
    L46:
        if (isCredentialProtectionLocked() == false) goto L48;
        r16.d(TAG, "device locked, wait user unlock");     // Catch: Throwable -> L12
        getSContext().registerReceiver(deviceUnlockedReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));     // Catch: Throwable -> L12
    L49:
        monitor-exit(this);
        return;
    L48:
        IndexTaskManager.INSTANCE.postTaskDelay(INIT_TASK_DELAY_TIME, "checkIfFirstRunOrDataClean", new cb.i());     // Catch: Throwable -> L12
        goto L49
    L32:
        r14 = r19;
        goto L33
    L23:
        r18 = false;
        goto L24
    L18:
        if (r15.length() != 0) goto L20;
        featureRunProcessName = null;     // Catch: Throwable -> L12
        goto L20
    L10:
        if (o.B(r12, ":", false, 2, null) == false) goto L15;
        r12 = INSTANCE.getSContext().getPackageName() + r12;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @WorkerThread
    public final boolean isDonateAllowed(int r10) {
        Bundle r11 = new Bundle();
        r11.putInt(KEY_ENTITY_TYPE, r10);
        Uri r12 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r12, "ENTITY_URI");
        Boolean r13 = null;
        Bundle r14 = innerCall(r12, METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH, null, r11);
        if (r14 == null) goto L5;
        r14.setClassLoader(AppEntity.class.getClassLoader());
    L7:
        if (r14 == null) goto L9;
        r13 = Boolean.valueOf(r14.getBoolean(KEY_IS_DONATE_ALLOWED, false));
    L9:
        Logger.INSTANCE.i(TAG, "isDonateAllowed:type=" + r10 + ",value=" + r13);
        if (r13 != null) goto L12;
        return false;
    L12:
        return r13.booleanValue();
    L5:
        r14 = null;
        goto L7
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    @Nullable
    public final Bundle queryPersonalContextData$capabilitykit_release() {
        Uri r10 = ENTITY_URI;
        kotlin.jvm.internal.q.f(r10, "ENTITY_URI");
        return innerCall$default(this, r10, METHOD_QUERY_PERSONAL_CONTEXT_DATA, null, null, 8, null);
    }

    public final boolean reDonateCheck$capabilitykit_release(@Nullable String r10) {
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reDonateCheck");
        return false;
    L6:
        if (r10 != null) goto L29;
        return false;
    L29:
        EntityUpdateVersionParams r11 = (EntityUpdateVersionParams) UtilsKt.getGson().fromJson(r10, EntityUpdateVersionParams.class);     // Catch: JsonSyntaxException -> L26
        final LinkedHashSet r12 = new LinkedHashSet();
        Iterator<Map.Entry<Integer, EntityVersionData>> r13 = r11.getOldEntityVersions().entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L21;
        Map.Entry<Integer, EntityVersionData> r14 = r13.next();
        EntityVersionData r15 = r14.getValue();
        EntityClassData<? extends AppEntity> r16 = EntityType.INSTANCE.getClassMap().get(r14.getKey());
        if (r16 == null) goto L15;
        int r17 = r16.getVersion();
    L16:
        EntityVersionData r18 = new EntityVersionData(r17, AppEntity.CREATOR.getVersion());
        Logger.INSTANCE.i(TAG, "reDonateCheck, type: " + r14.getKey().intValue() + " sdkVersion: " + r18 + " personalContextVersion: " + r15);
        if (r18.getSelfVersion() == (-1)) goto L11;
        if (r18.compareTo2(r15) <= 0) goto L11;
        r12.add(r14.getKey());
        goto L11
    L15:
        r17 = -1;
        goto L16
    L21:
        Logger r19 = Logger.INSTANCE;
        r19.i(TAG, "reDonateCheck, needDonateVersions" + r12);
        if (r12.isEmpty() == false) goto L24;
        return true;
    L24:
        final CountDownLatch r20 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("reDonateTask", new l(r20, r12));
        r20.await();
        r19.i(TAG, "reDonateCheck, reDonate finish");
        return true;
    L26:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reDonateCheck parse json error, jsonString: " + r10, e);
        return false;
    }

    public final void reindexEntityData$capabilitykit_release() {
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L13;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reindexEntityData");
        return;
    L13:
        final CountDownLatch r10 = new CountDownLatch(1);     // Catch: Exception -> L10
        IndexTaskManager r11 = IndexTaskManager.INSTANCE;     // Catch: Exception -> L10
        r11.runTask("reindexEntityData", new f(r10));     // Catch: Exception -> L10
        r10.await();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityData error", e);
    }

    public final void setSContext(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        sContext = r10;
    }

    public final void syncData(@NotNull final List<Integer> r10) {
        kotlin.jvm.internal.q.g(r10, "indexedEntityTypes");
        if (db.a.f19145a.a(getSContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip syncData");
        return;
    L7:
        if (isCredentialProtectionLocked() == false) goto L10;
        Logger.INSTANCE.w(TAG, "syncData, credentialProtectionLocked");
        return;
    L10:
        final CountDownLatch r11 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("syncData", new k(r10, r11));
        r11.await();
    }

    public final void waitEntityProviderInit(long r10) {
        initialCountDownLatch.await(r10, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "waitEntityProviderInit throwable", th);
    }

    private final void tryInsertBulkEntityHistory(List<String> r12, int r13, m r14) {
        ArrayList r10 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r10.add(new cb.u(0, (String) r15.next(), "", r13, r14, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r10);
    }

    private final void tryInsertBulkEntityHistory(List<? extends AppEntity> r13, m r14) {
        ArrayList r10 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        AppEntity r11 = (AppEntity) r15.next();
        r10.add(new cb.u(0, r11.getId(), EntityExtKt.toJsonKeepTimeStamp(r11), r11.getType(), r14, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r10);
    }
}
