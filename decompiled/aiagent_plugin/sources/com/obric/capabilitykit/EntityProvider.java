package com.obric.capabilitykit;

import android.app.Application;
import android.app.assist.AssistContent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.UserManager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonSyntaxException;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.ResultCallback;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.utils.IndexResult;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.capabilitykit.sync.EntitySyncUtil;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.capabilitykit.version.EntityVersionData;
import com.obric.capabilitykit.version.PersonalContextData;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;

/* JADX INFO: loaded from: classes3.dex */
public final class EntityProvider {
    private static final String ENTITY_FIRST_FLAG = "first_run_flag";
    private static final int ENTITY_LIST_CHUNK_SIZE = 100;
    private static final String ENTITY_REPO = "entity_repo";
    private static final Uri ENTITY_URI = null;
    private static final long INIT_TASK_DELAY_TIME = 10000;
    private static final int INSERT_ENTITY_RETRY_TIMES = 3;
    public static final EntityProvider INSTANCE = null;
    private static final String KEY_APP_ENTITY_COUNT = "app_entity_count";
    public static final String KEY_CLEAN_BEFORE_TIMESTAMP = "clean_before_timestamp";
    public static final String KEY_ENTITY_IDS = "entity_ids";
    public static final String KEY_ENTITY_LIST = "entity_list";
    public static final String KEY_ENTITY_TYPE = "entity_type";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MSG = "error_msg";
    private static final String KEY_INDEX_PROGRESS = "index_progress";
    private static final String KEY_IS_DONATE_ALLOWED = "is_donate_allowed";
    private static final String KEY_MAX_LAST_MODIFIED_TIME = "max_last_modified_time";
    private static final String KEY_ON_SCREEN_ENTITIES = "on_screen_entities";
    private static final String KEY_PKG_NAME = "pkg_name";
    private static final String KEY_PRODUCT_NAME = "product_name";
    public static final String KEY_SUCCESS_IDS = "success_ids";
    private static final int MAX_TRANSACTION_SIZE_BYTES = 921600;
    private static final String METHOD_CHECK_SYNCED_DATA = "check_synced_data";
    private static final String METHOD_DATA_CLEAN = "data_clean";
    private static final String METHOD_DELETE = "delete";
    private static final String METHOD_FETCH_SYNC_INFO = "fetch_sync_info";
    private static final String METHOD_GET_ENTITY_INDEX_PROGRESS = "get_entity_index_progress";
    private static final String METHOD_GET_ON_SCREEN_ENTITIES = "get_on_screen_entities";
    private static final String METHOD_INDEX = "index";
    private static final String METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH = "is_donate_allowed_by_local_switch";
    private static final String METHOD_QUERY_PERSONAL_CONTEXT_DATA = "query_personal_context_data";
    private static final String METHOD_SYNC_DELETE = "sync_delete";
    public static final String TAG = "EntityProvider";
    private static final d.f dbHelper$delegate = null;
    private static final e deviceUnlockedReceiver = null;
    private static EntitySupplier entitySupplier;
    private static EntitySyncDataSupplier entitySyncDataSupplier;
    private static String featureRunProcessName;
    private static long firstRunCleanBeforeTimestamp;
    private static CountDownLatch initialCountDownLatch;
    private static volatile boolean isInitialized;
    public static Context sContext;

    public static final class a implements EntitySupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EntitySyncDataSupplier f31990a;

        public a(EntitySyncDataSupplier r3) {
            EntitySyncDataSupplier r4 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "entitySyncDataSupplier");
            this.f31990a = r4;
        }

        @Override // com.obric.capabilitykit.EntitySupplier
        public List<AppEntity> provideAllEntities() {
            List<EntityIdData> r1 = this.f31990a.provideSampleEntities();     // Catch: Throwable -> L28
            if (r1.isEmpty() == true) goto L7;
            ArrayList r2 = new ArrayList();
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator<T> r4 = r1.iterator();
        L10:
            if (r4.hasNext() == false) goto L15;
            Object r5 = r4.next();
            Integer r6 = Integer.valueOf(((EntityIdData) ZeusTransformUtils.preCheckCast(r5, EntityIdData.class, "com.obric.aiagent.plugin")).getType());
            Object r7 = r3.get(r6);
            if (r7 != null) goto L14;
            r7 = new ArrayList();
            r3.put(r6, r7);
        L14:
            ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).add(r5);
            goto L10
        L15:
            Iterator r8 = r3.values().iterator();
        L17:
            if (r8.hasNext() == false) goto L27;
            List r9 = (List) ZeusTransformUtils.preCheckCast(r8.next(), List.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r10 = this.f31990a;     // Catch: Throwable -> L25
            ArrayList r11 = new ArrayList(d.a.p.a(r9, 10));     // Catch: Throwable -> L25
            Iterator r12 = r9.iterator();     // Catch: Throwable -> L25
        L21:
            if (r12.hasNext() == false) goto L23;
            r11.add(((EntityIdData) ZeusTransformUtils.preCheckCast(r12.next(), EntityIdData.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L25
            goto L21
        L23:
            r2.addAll(r10.getWholeEntities(r11, ((EntityIdData) ZeusTransformUtils.preCheckCast(d.a.p.k(r9), EntityIdData.class, "com.obric.aiagent.plugin")).getType()));     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Logger.INSTANCE.e(EntityProvider.TAG, "getWholeEntities failed, type=" + ((EntityIdData) ZeusTransformUtils.preCheckCast(d.a.p.k(r9), EntityIdData.class, "com.obric.aiagent.plugin")).getType() + ", requestedSize=" + r9.size() + ", return partial result", th);
            goto L17
        L27:
            return r2;
        L7:
            return d.a.p.b();
        L28:
            th = move-exception;
            Logger.INSTANCE.e(EntityProvider.TAG, "provideSampleEntities failed, return partial result", th);
            return d.a.p.b();
        }
    }

    public static final class b extends d.h.b.p implements d.h.a.a<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f31991a = null;

        static {
            f31991a = new b();
        }

        public b() {
            super(0);
        }

        public final n a() {
            return n.f32162b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(EntityProvider.INSTANCE.getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ n invoke() {
            return a();
        }
    }

    @d.c.b.a.f(b = "EntityProvider.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.EntityProvider$getIndexProgress$1$1")
    public static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IndexProgress f31993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResultCallback<IndexProgress> f31994c;

        public c(IndexProgress r3, ResultCallback<IndexProgress> r4, d.c.d<? super c> r5) {
            ResultCallback<IndexProgress> r6 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, ResultCallback.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31993b = r3;
            this.f31994c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new c(this.f31993b, this.f31994c, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f31992a != 0) goto L11;
            d.o.a(r7);
            IndexProgress r8 = this.f31993b;
            if (r8 != null) goto L7;
            ResultCallback.a.a(this.f31994c, 501, "failed to get index progress", null, 4, null);
        L9:
            return x.f38692a;
        L7:
            this.f31994c.onResult(0, "ok", r8);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d extends d.h.b.p implements d.h.a.q<Uri, String, Bundle, Bundle> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f31995a = null;

        static {
            f31995a = new d();
        }

        public d() {
            super(3);
        }

        public final Bundle a(Uri r2, String r3, Bundle r4) {
            d.h.b.o.e(r2, "uri");
            d.h.b.o.e(r3, "method");
            return EntityProvider.access$innerCall(EntityProvider.INSTANCE, r2, r3, null, r4);
        }

        @Override // d.h.a.q
        public /* synthetic */ Bundle invoke(Uri r3, String r4, Bundle r5) {
            return a((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final class e extends PluginBroadcastReceiver {
        public e() {
        }

        private static final void a() {
            EntityProvider.access$checkIfFirstRunOrDataClean(EntityProvider.INSTANCE);
        }

        public static /* synthetic */ void lambda$Fqv5qQUmnrePfDOD4hBKWbc3GQI() {
            a();
        }

        public void onReceive(Context r1, Intent r2) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
            Logger.INSTANCE.d(EntityProvider.TAG, "user unlocked");
            IndexTaskManager.INSTANCE.postTask("checkIfFirstRunOrDataClean", $$Lambda$EntityProvider$e$Fqv5qQUmnrePfDOD4hBKWbc3GQI.INSTANCE);
        }
    }

    static {
        INSTANCE = new EntityProvider();
        ENTITY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
        dbHelper$delegate = d.g.a(b.f31991a);
        initialCountDownLatch = new CountDownLatch(1);
        deviceUnlockedReceiver = new e();
    }

    private EntityProvider() {
    }

    public static final /* synthetic */ void access$checkIfFirstRunOrDataClean(EntityProvider r0) {
        r0.checkIfFirstRunOrDataClean();
    }

    public static final /* synthetic */ Bundle access$innerCall(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4) {
        return r0.innerCall(r1, r2, r3, r4);
    }

    private static final void bulkDelete$lambda$15(List r4, int r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "$entityIds");
        Iterator r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        INSTANCE.getDbHelper().a(r2, r5);
        goto L4
    L6:
        EntityProvider r1 = INSTANCE;
        r1.tryInsertBulkEntityHistory(r6, r5, j.f32149c);
        r1.innerBulkDelete(r6, r5);
    }

    public static /* synthetic */ void bulkIndex$default(EntityProvider r1, List r2, ResultCallback r3, int r4, Object r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        ResultCallback<x> r7 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ResultCallback.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.bulkIndex(r6, r7);
    }

    public static /* synthetic */ void bulkIndexInner$capabilitykit_release$default(EntityProvider r1, List r2, ResultCallback r3, int r4, Object r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        ResultCallback<x> r7 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ResultCallback.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.bulkIndexInner$capabilitykit_release(r6, r7);
    }

    private static final void bulkIndexInner$lambda$13(List r8, ResultCallback r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        ResultCallback<x> r2 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r9, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "$entities");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r0 = r12.next();
        Integer r3 = Integer.valueOf(((AppEntity) ZeusTransformUtils.preCheckCast(r0, AppEntity.class, "com.obric.aiagent.plugin")).getType());
        Object r4 = r11.get(r3);
        if (r4 != null) goto L8;
        r4 = new ArrayList();
        r11.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).add(r0);
        goto L4
    L9:
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r11.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        List<AppEntity> r5 = INSTANCE.filterLastUniqueEntities((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin"));
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        AppEntity r7 = (AppEntity) ZeusTransformUtils.preCheckCast(r6.next(), AppEntity.class, "com.obric.aiagent.plugin");
        INSTANCE.getDbHelper().a(r7.getId(), r7.getType());
        goto L14
    L16:
        EntityProvider r15 = INSTANCE;
        r15.tryInsertBulkEntityHistory(r5, j.f32148b);
        IndexResult r16 = r15.innerBulkIndex(r5, r2);
        if (r16.getCode() == 0) goto L11;
        r13.put(r1.getKey(), r16);
        goto L11
    L20:
        if ((!r13.isEmpty()) == false) goto L44;
        Logger.INSTANCE.w(TAG, "bulkIndexInner failed, failedMessageMap: " + r13);
        Collection r17 = r13.values();
        ArrayList r18 = new ArrayList(d.a.p.a(r17, 10));
        Iterator r19 = r17.iterator();
    L23:
        if (r19.hasNext() == false) goto L25;
        r18.add(Integer.valueOf(((IndexResult) ZeusTransformUtils.preCheckCast(r19.next(), IndexResult.class, "com.obric.aiagent.plugin")).getCode()));
        goto L23
    L25:
        Set r20 = d.a.p.q(r18);
        if (r20.size() != r13.size()) goto L28;
        boolean r21 = true;
    L30:
        if (r20.size() != 1) goto L35;
        IndexResult r22 = (IndexResult) ZeusTransformUtils.preCheckCast(d.a.p.e(r13.values()), IndexResult.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L59;
        int r23 = r22.getCode();
        String r24 = r22.getMessage();
    L34:
        Object r25 = null;
        int r26 = 4;
        Object r27 = null;
    L46:
        ResultCallback.a.a(r2, r23, r24, r25, r26, r27);
        return;
    L59:
        return;
    L35:
        if (r21 == false) goto L37;
        String r28 = "all ";
    L38:
        Iterator r29 = r13.entrySet().iterator();
        r24 = r28 + " entity type index failed:";
    L40:
        if (r29.hasNext() == false) goto L42;
        Map.Entry r30 = (Map.Entry) ZeusTransformUtils.preCheckCast(r29.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r24 = r24 + "\n entity type " + ((Number) ZeusTransformUtils.preCheckCast(r30.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue() + " reason: " + ((IndexResult) ZeusTransformUtils.preCheckCast(r30.getValue(), IndexResult.class, "com.obric.aiagent.plugin")).getMessage();
        goto L40
    L42:
        if (r2 == null) goto L60;
        r23 = ResultCode.ERROR_MULTI_DETAIL;
        goto L34
    L60:
        return;
    L37:
        r28 = "some ";
        goto L38
    L28:
        r21 = false;
        goto L30
    L44:
        if (r2 == null) goto L61;
        r23 = 0;
        r25 = null;
        r26 = 4;
        r27 = null;
        r24 = "success";
        goto L46
    }

    private final void checkIfFirstRunOrDataClean() {
        u.f32246a.a();
        SharedPreferences r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(ENTITY_REPO, 0);
        if ((!r0.getBoolean(ENTITY_FIRST_FLAG, false)) == false) goto L8;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putBoolean(ENTITY_FIRST_FLAG, true);
        r1.apply();
        if (d.h.b.o.a("com.android.gallery3d", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName()) == true) goto L7;
        Logger.INSTANCE.i(TAG, "app's data may cleared, need to clean relative entity data, firstRunTimeStamp=" + firstRunCleanBeforeTimestamp);
        Bundle r2 = new Bundle();
        r2.putLong(KEY_CLEAN_BEFORE_TIMESTAMP, firstRunCleanBeforeTimestamp);
        Uri r3 = ENTITY_URI;
        d.h.b.o.c(r3, "ENTITY_URI");
        innerCall(r3, METHOD_DATA_CLEAN, null, r2);
    L7:
        EntitySupplier r4 = entitySupplier;
        d.h.b.o.a(r4);
        bulkIndex$default(this, safeProvideAllEntities(r4, "checkIfFirstRunOrDataClean"), null, 2, null);
        return;
    L8:
        l.f32157a.a();
    }

    private final void checkSyncedData(int r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r3);
        r0.putInt(KEY_APP_ENTITY_COUNT, r4);
        Uri r5 = ENTITY_URI;
        d.h.b.o.c(r5, "ENTITY_URI");
        innerCall(r5, METHOD_CHECK_SYNCED_DATA, null, r0);
    }

    private static final void deleteAllEntityData$lambda$16() {
        EntityProvider r0 = INSTANCE;
        Uri r1 = ENTITY_URI;
        d.h.b.o.c(r1, "ENTITY_URI");
        innerCall$default(r0, r1, METHOD_DATA_CLEAN, null, null, 8, null);
    }

    private final List<AppEntity> filterLastUniqueEntities(List<? extends AppEntity> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        LinkedHashSet r6 = new LinkedHashSet();
        ArrayList r1 = new ArrayList();
        Iterator r7 = d.a.p.h(r4).iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(r7.next(), AppEntity.class, "com.obric.aiagent.plugin");
        if (r6.contains(r2.getId()) == true) goto L4;
        r1.add(r2);
        r6.add(r2.getId());
        goto L4
    L9:
        return d.a.p.i(r1);
    }

    private final n getDbHelper() {
        return (n) ZeusTransformUtils.preCheckCast(dbHelper$delegate.b(), n.class, "com.obric.aiagent.plugin");
    }

    private static final void getIndexProgress$lambda$5(int r7, ResultCallback r8) {
        ResultCallback r9 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r8, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "$callback");
        IndexProgress r10 = INSTANCE.getIndexProgressInternal(r7);
        kotlinx.coroutines.i.a(an.a(bd.b()), null, null, new c(r10, r9, null), 3, null);
    }

    private final IndexProgress getIndexProgressInternal(int r4) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        Uri r5 = ENTITY_URI;
        d.h.b.o.c(r5, "ENTITY_URI");
        Object r2 = null;
        Bundle r3 = innerCall(r5, METHOD_GET_ENTITY_INDEX_PROGRESS, null, r0);
        if (r3 == null) goto L14;
        String r6 = r3.getString(KEY_INDEX_PROGRESS);
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L14;
        r2 = com.obric.capabilitykit.common.a.a().fromJson(r6, IndexProgress.class);
        goto L14
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
    L14:
        return (IndexProgress) ZeusTransformUtils.preCheckCast(r2, IndexProgress.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void index$default(EntityProvider r1, AppEntity r2, ResultCallback r3, int r4, Object r5) {
        ResultCallback<x> r6 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ResultCallback.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.index(r2, r6);
    }

    private static final void init$lambda$2() {
        INSTANCE.checkIfFirstRunOrDataClean();
    }

    private final void innerBulkDelete(List<String> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (isCredentialProtectionLocked() == false) goto L6;
        Logger.INSTANCE.w(TAG, "device is locked, delete entity will retry when user unlocked device");
        return;
    L6:
        Iterator r7 = d.a.p.d(r10, 100).iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.aiagent.plugin");
        Logger.INSTANCE.i(TAG, "innerBulkDelete ids: " + m.a(r10));
        Bundle r3 = new Bundle();
        Object[] r4 = r2.toArray(new String[0]);
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Array<T>");
        r3.putStringArray(KEY_ENTITY_IDS, (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.aiagent.plugin"));
        r3.putInt(KEY_ENTITY_TYPE, r9);
        EntityProvider r5 = INSTANCE;
        Uri r6 = ENTITY_URI;
        d.h.b.o.c(r6, "ENTITY_URI");
        r5.removeProcessedEntityFromDB(r5.innerCall(r6, METHOD_DELETE, null, r3), r9, j.f32149c);
        goto L8
    }

    private final IndexResult innerBulkIndex(List<? extends AppEntity> r13, ResultCallback<x> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        ResultCallback r2 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r14, ResultCallback.class, "com.obric.aiagent.plugin");
        if (isCredentialProtectionLocked() == true) goto L5;
        PersonalContextData r12 = u.f32246a.a();
        Parcel r16 = null;
        Integer r17 = null;
        if (r12 == null) goto L9;
        Set<Integer> r18 = r12.getSupportEntityTypes();
    L11:
        if (r18 != null) goto L14;
        Logger.INSTANCE.w(TAG, "innerBulkIndex get PersonalContextData failed");
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
        return new IndexResult(303, "donate failed temporarily, personal context will retry internally");
    L14:
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r15.iterator();
    L16:
        if (r5.hasNext() == false) goto L22;
        AppEntity r6 = (AppEntity) ZeusTransformUtils.preCheckCast(r5.next(), AppEntity.class, "com.obric.aiagent.plugin");
        if (r18.contains(Integer.valueOf(r6.getType())) == true) goto L19;
        r3.add(r6);
        goto L16
    L19:
        r4.add(r6);
        goto L16
    L22:
        if ((!r3.isEmpty()) == false) goto L28;
        Logger.INSTANCE.i(TAG, "innerBulkIndex, unsupported ids: " + m.a(m.b(r3)));
        Iterator r19 = r3.iterator();
    L25:
        if (r19.hasNext() == false) goto L28;
        AppEntity r7 = (AppEntity) ZeusTransformUtils.preCheckCast(r19.next(), AppEntity.class, "com.obric.aiagent.plugin");
        INSTANCE.getDbHelper().a(r7.getId(), r7.getType(), j.f32148b.a());
    L28:
        if (r4.isEmpty() == false) goto L34;
        Logger r110 = Logger.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("innerBulkIndex, no supporting entity type ");
        AppEntity r111 = (AppEntity) ZeusTransformUtils.preCheckCast(d.a.p.l(r15), AppEntity.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L32;
        r17 = Integer.valueOf(r111.getType());
    L32:
        r110.w(TAG, r8.append(r17).toString());
        return new IndexResult(302, "unsupported entity type");
    L34:
        ArrayList r112 = new ArrayList();
        if (r4.size() >= 3) goto L41;
        Iterator r113 = r4.iterator();
    L38:
        if (r113.hasNext() == false) goto L40;
        ((AppEntity) ZeusTransformUtils.preCheckCast(r113.next(), AppEntity.class, "com.obric.aiagent.plugin")).countHashCode();
        goto L38
    L40:
        r112.add(r4);
    L75:
        Iterator r114 = r112.iterator();
    L77:
        if (r114.hasNext() == false) goto L100;
        List r115 = (List) ZeusTransformUtils.preCheckCast(r114.next(), List.class, "com.obric.aiagent.plugin");
        Logger r9 = Logger.INSTANCE;
        r9.i(TAG, "innerBulkIndex ids: " + m.a(m.b(r115)));
        Bundle r10 = new Bundle();
        r10.putParcelableArrayList(KEY_ENTITY_LIST, new ArrayList(r115));
        EntityProvider r11 = INSTANCE;
        Uri r20 = ENTITY_URI;
        d.h.b.o.c(r20, "ENTITY_URI");
        Bundle r21 = r11.innerCall(r20, METHOD_INDEX, null, r10);
        String r22 = "internal error";
        if (r21 == null) goto L80;
        int r23 = r21.getInt("error_code");
        String r24 = r21.getString("error_msg");
        if (r24 == null) goto L88;
        r22 = r24;
    L88:
        d.h.b.o.c(r22, "this.getString(KEY_ERROR_MSG)?: \"internal error\"");
        if (r23 != 0) goto L91;
        r11.removeProcessedEntityFromDB(r21, ((AppEntity) ZeusTransformUtils.preCheckCast(r115.get(0), AppEntity.class, "com.obric.aiagent.plugin")).getType(), j.f32148b);
        goto L77
    L91:
        r9.w(TAG, "innerBulkIndex failed, errorCode: " + r23 + ", errorMsg: " + r22);
        if (r23 != 111) goto L98;
        Iterator r116 = r115.iterator();
    L95:
        if (r116.hasNext() == false) goto L98;
        AppEntity r117 = (AppEntity) ZeusTransformUtils.preCheckCast(r116.next(), AppEntity.class, "com.obric.aiagent.plugin");
        INSTANCE.getDbHelper().a(r117.getId(), r117.getType());
    L98:
        return new IndexResult(r23, r22);
    L80:
        if (r2 == null) goto L83;
        ResultCallback.a.a(r2, 501, "internal error", null, 4, null);
    L83:
        return new IndexResult(501, "internal error");
    L100:
        return new IndexResult(0, "success");
    L41:
        ArrayList r118 = new ArrayList();
        Iterator r25 = r4.iterator();
        int r26 = 0;
    L43:
        if (r25.hasNext() == false) goto L73;
        AppEntity r27 = (AppEntity) ZeusTransformUtils.preCheckCast(r25.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r27.countHashCode();
        int r28 = 1024;
        Parcel r29 = Parcel.obtain();     // Catch: Throwable -> L52 Exception -> L54
        r29.writeParcelable(r27, 0);     // Catch: Throwable -> L48 Exception -> L50
        r28 = r29.dataSize();     // Catch: Throwable -> L48 Exception -> L50
    L47:
        r29.recycle();
    L62:
        if ((!r118.isEmpty()) == false) goto L68;
        if ((r26 + r28) <= MAX_TRANSACTION_SIZE_BYTES) goto L66;
    L67:
        r112.add(r118);
        r118 = new ArrayList();
        r26 = 0;
        goto L68
    L66:
        if (r118.size() >= 100) goto L67;
    L68:
        r118.add(r27);
        r26 = r26 + r28;
        goto L43
    L48:
        th = th;
        r16 = r29;
    L69:
        if (r16 == null) goto L71;
        r16.recycle();
    L71:
        throw th;
    L50:
        e = e;
    L58:
        Logger.INSTANCE.e(TAG, "calculate parcel size error", e);     // Catch: Throwable -> L48
        if (r29 == null) goto L62;
    L54:
        e = e;
        r29 = null;
    L52:
        th = th;
        goto L69
    L73:
        if ((!r118.isEmpty()) == false) goto L75;
        r112.add(r118);
        goto L75
    L9:
        r18 = null;
        goto L11
    L5:
        return new IndexResult(ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED, "device is locked, donate will try when user unlocked device");
    }

    public static /* synthetic */ IndexResult innerBulkIndex$default(EntityProvider r1, List r2, ResultCallback r3, int r4, Object r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        ResultCallback<x> r7 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ResultCallback.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return r1.innerBulkIndex(r6, r7);
    }

    private final Bundle innerCall(Uri r7, String r8, String r9, Bundle r10) {
    L26:
        e = move-exception;
        Logger.INSTANCE.e(TAG, d.a.a(e));
        return null;
    L4:
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip call " + r8);     // Catch: Exception -> L26
        return null;
    L7:
        ContentProviderClient r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().acquireUnstableContentProviderClient(r7);     // Catch: Exception -> L26
        if (r6 != null) goto L30;
        Logger.INSTANCE.w(TAG, "failed to acquire unstable provider client, skip call " + r8);     // Catch: Exception -> L26
        return null;
    L30:
        Bundle r11 = r6.call(r8, r9, r10);     // Catch: Throwable -> L13 Exception -> L15 DeadObjectException -> L18
    L22:
        r6.close();     // Catch: Exception -> L26
        return r11;
    L18:
        e = e;
        Logger r12 = Logger.INSTANCE;     // Catch: Throwable -> L13
        String r13 = "unstable provider died during call " + r8;     // Catch: Throwable -> L13
    L17:
        r12.e(TAG, r13, e);     // Catch: Throwable -> L13
        r11 = null;
    L15:
        e = e;
        r12 = Logger.INSTANCE;     // Catch: Throwable -> L13
        r13 = "provider call failed " + r8;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r6.close();     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    }

    public static /* synthetic */ Bundle innerCall$default(EntityProvider r0, Uri r1, String r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r0.innerCall(r1, r2, r3, r4);
    }

    private final boolean isCredentialProtectionLocked() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return !((UserManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService(UserManager.class), UserManager.class, "com.obric.aiagent.plugin")).isUserUnlocked();
    }

    private final boolean isNotInFeatureProcess() {
        if (isInitialized == true) goto L5;
        return true;
    L5:
        String r0 = featureRunProcessName;
        if (r0 == null) goto L9;
        return true ^ d.h.b.o.a(f.f32140a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(INSTANCE.getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r0);
    L9:
        if (f.f32140a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX INFO: renamed from: lambda$-yesnujBXqZMkrEHC2vaMhwCF6s, reason: not valid java name */
    public static /* synthetic */ void m924lambda$yesnujBXqZMkrEHC2vaMhwCF6s() {
        deleteAllEntityData$lambda$16();
    }

    /* JADX INFO: renamed from: lambda$APlMT52z3FZTlZeSmM-b4lyIUKs, reason: not valid java name */
    public static /* synthetic */ void m925lambda$APlMT52z3FZTlZeSmMb4lyIUKs(CountDownLatch r0, Set r1) {
        reDonateCheck$lambda$46(r0, r1);
    }

    public static /* synthetic */ void lambda$EF7xpMdp_X3aHArsSjDUZflacho(List r0, int r1) {
        bulkDelete$lambda$15(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Ie8d-B7SjaC02pw8jND2yE3F6VI, reason: not valid java name */
    public static /* synthetic */ void m926lambda$Ie8dB7SjaC02pw8jND2yE3F6VI(List r0, ResultCallback r1) {
        bulkIndexInner$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JbOMKf2Cj-ZEoIm2xLpeCtV_0vo, reason: not valid java name */
    public static /* synthetic */ void m927lambda$JbOMKf2CjZEoIm2xLpeCtV_0vo(List r0, CountDownLatch r1) {
        syncData$lambda$47(r0, r1);
    }

    public static /* synthetic */ void lambda$Sd4CehMm_u8kCJJSGMbxNYl_LaA() {
        init$lambda$2();
    }

    public static /* synthetic */ void lambda$cXFfYfjHjuvQ5UMv7w1b4CMrLKM(int r0, ResultCallback r1) {
        getIndexProgress$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$p2b8GV0fzbTeMYECkutK3iyoRDY(CountDownLatch r0) {
        reindexEntityData$lambda$49(r0);
    }

    private static final void reDonateCheck$lambda$46(CountDownLatch r8, Set r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "$finishDonateCountDownLatch");
        d.h.b.o.e(r10, "$needDonateVersions");
        EntitySupplier r0 = entitySupplier;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = INSTANCE.safeProvideAllEntities(r0, "reDonateCheck");
    L6:
        if (r1 != null) goto L9;
        r8.countDown();
        return;
    L9:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        Integer r5 = Integer.valueOf(((AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.aiagent.plugin")).getType());
        Object r6 = r3.get(r5);
        if (r6 != null) goto L15;
        r6 = new ArrayList();
        r3.put(r5, r6);
    L15:
        ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin")).add(r4);
        goto L11
    L16:
        Iterator r7 = r3.entrySet().iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r10.contains(r11.getKey()) == false) goto L18;
        Logger.INSTANCE.i(TAG, "reDonateCheck, reDonate type: " + ((Number) ZeusTransformUtils.preCheckCast(r11.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue());
        bulkIndexInner$capabilitykit_release$default(INSTANCE, (List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.aiagent.plugin"), null, 2, null);
        goto L18
    L22:
        r8.countDown();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void reindexEntityData$lambda$49(CountDownLatch r4) {
        d.h.b.o.e(r4, "$finishDonateCountDownLatch");
        EntitySupplier r0 = entitySupplier;     // Catch: Throwable -> L7 Exception -> L9
        if (r0 == null) goto L6;
        EntityProvider r1 = INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
        bulkIndex$default(r1, r1.safeProvideAllEntities(r0, "reindexEntityData"), null, 2, null);     // Catch: Throwable -> L7 Exception -> L9
    L6:
        r4.countDown();
        return;
    L9:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityDataInner error", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    private final void removeProcessedEntityFromDB(Bundle r3, int r4, j r5) {
        if (r3 == null) goto L9;
        ArrayList<String> r2 = r3.getStringArrayList(KEY_SUCCESS_IDS);
        if (r2 == null) goto L9;
        Logger.INSTANCE.i(TAG, "callback successIds: " + m.a(r2) + " entityType: " + r4 + " type: " + r5.a());
        Iterator<T> r6 = r2.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        n r0 = INSTANCE.getDbHelper();
        d.h.b.o.c(r7, DbHelper.COL_ID);
        r0.a(r7, r4, r5.a());
        l.f32157a.a(r7, r4, r5.a());
    L9:
        IndexTaskManager.INSTANCE.scheduleRestoreHistoryProcessTask();
    }

    private final List<AppEntity> safeProvideAllEntities(EntitySupplier r2, String r3) {
        return ((EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r2, EntitySupplier.class, "com.obric.aiagent.plugin")).provideAllEntities();
    L5:
        th = move-exception;
        Logger.INSTANCE.e(TAG, r3 + " provideAllEntities failed, return partial result", th);
        return d.a.p.b();
    }

    private static final void syncData$lambda$47(List r6, CountDownLatch r7) {
        List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$indexedEntityTypes");
        d.h.b.o.e(r7, "$finishSyncDataCountDownLatch");
        EntitySyncUtil.INSTANCE.syncData(entitySyncDataSupplier, entitySupplier, r3, null, d.f31995a);     // Catch: Throwable -> L5
    L7:
        r7.countDown();
        return;
    L5:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "syncData error", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r7.countDown();
        throw th;
    }

    private final void syncDelete(int r4, long r5) {
        Logger.INSTANCE.d(TAG, "to delete entities which lastModifiedTime > " + r5 + " for type " + r4);
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r4);
        r0.putLong(KEY_MAX_LAST_MODIFIED_TIME, r5);
        Uri r6 = ENTITY_URI;
        d.h.b.o.c(r6, "ENTITY_URI");
        innerCall(r6, METHOD_SYNC_DELETE, null, r0);
    }

    private final void tryInsertBulkEntityHistory(List<k> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList();
        ArrayList r1 = new ArrayList();
        r1.addAll(r6);
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L13;
        d.m<Boolean, List<k>> r3 = INSTANCE.getDbHelper().b(r1);
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(r3.b(), Collection.class, "com.obric.aiagent.plugin"));
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        r1.remove((k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin"));
        goto L7
    L10:
        if (r8.size() == r6.size()) goto L11;
        r2 = r2 + 1;
        goto L4
    L11:
        return;
    }

    private final void tryInsertBulkEntityHistory(List<String> r13, int r14, j r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        r0.add(new k(0, (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"), "", r14, r15, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    private final void tryInsertBulkEntityHistory(List<? extends AppEntity> r14, j r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(r17.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r0.add(new k(0, r2.getId(), EntityExtKt.toJsonKeepTimeStamp(r2), r2.getType(), r15, 1, null));
        goto L4
    L6:
        tryInsertBulkEntityHistory(r0);
    }

    public final void bulkDelete(List<String> r4, final int r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "entityIds");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip delete");
        return;
    L7:
        if (r6.isEmpty() == false) goto L9;
        return;
    L9:
        IndexTaskManager.INSTANCE.runTask("bulkDelete(size:" + r6.size() + ')', new $$Lambda$EntityProvider$EF7xpMdp_X3aHArsSjDUZflacho(r6, r5));
    }

    public final void bulkIndex(List<? extends AppEntity> r7, ResultCallback<x> r8) {
        List<? extends AppEntity> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        ResultCallback<x> r0 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r8, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "entities");
        if (r9.isEmpty() == false) goto L7;
        if (r0 == null) goto L9;
        ResultCallback.a.a(r0, 301, "entity list is empty", null, 4, null);
        return;
    L9:
        return;
    L7:
        bulkIndexInner$capabilitykit_release(r9, r0);
    }

    public final void bulkIndexInner$capabilitykit_release(List<? extends AppEntity> r9, ResultCallback<x> r10) {
        final List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        final ResultCallback r2 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r10, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "entities");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L8;
        if (r2 == null) goto L14;
        ResultCallback.a.a(r2, ResultCode.ERROR_MEMORY_SERVICE_DISABLED, "EntityProvider is disabled", null, 4, null);
        return;
    L14:
        return;
    L8:
        if (isCredentialProtectionLocked() == false) goto L12;
        if (r2 == null) goto L15;
        ResultCallback.a.a(r2, ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED, "device is locked, retry donate when user unlocked device", null, 4, null);
        return;
    L15:
        return;
    L12:
        IndexTaskManager.INSTANCE.runTask("bulkIndexInner(size:" + r11.size() + ')', new $$Lambda$EntityProvider$Ie8dB7SjaC02pw8jND2yE3F6VI(r11, r2));
    }

    public final void delete(String r2, int r3) {
        d.h.b.o.e(r2, "entityId");
        bulkDelete(d.a.p.a(r2), r3);
    }

    public final void deleteAllEntityData() {
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip deleteAllEntityData");
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("deleteAllEntityData", $$Lambda$EntityProvider$yesnujBXqZMkrEHC2vaMhwCF6s.INSTANCE);
    }

    public final void donateOnScreenData(AssistContent r9, ArrayList<AppEntity> r10) {
        d.h.b.o.e(r9, "outContent");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip donateOnScreenData");
        return;
    L6:
        Logger r8 = Logger.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("donateOnScreenData entity list: ");
        if (r10 == null) goto L12;
        ArrayList r3 = new ArrayList(d.a.p.a(r10, 10));
        Iterator<T> r4 = r10.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r4.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r3.add(r5.getId() + " - " + r5.getType());
    L13:
        r8.d(TAG, r0.append(r3).toString());
        if (r10 != null) goto L16;
        return;
    L16:
        r9.getExtras().putParcelableArrayList("entities", r10);
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final Uri getENTITY_URI$capabilitykit_release() {
        return ENTITY_URI;
    }

    public final void getIndexProgress(final int r9, ResultCallback<IndexProgress> r10) {
        final ResultCallback r2 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r10, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "callback");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        ResultCallback.a.a(r2, ResultCode.ERROR_MEMORY_SERVICE_DISABLED, "Memory service is not available", null, 4, null);
        return;
    L6:
        IndexTaskManager.INSTANCE.runTask("getIndexProgress", new $$Lambda$EntityProvider$cXFfYfjHjuvQ5UMv7w1b4CMrLKM(r9, r2));
    }

    public final List<AppEntity> getOnScreenData(String r3, String r4) {
        d.h.b.o.e(r3, "productName");
        d.h.b.o.e(r4, "pkgName");
        Bundle r0 = new Bundle();
        r0.putString(KEY_PRODUCT_NAME, r3);
        r0.putString("pkg_name", r4);
        Uri r5 = ENTITY_URI;
        d.h.b.o.c(r5, "ENTITY_URI");
        Bundle r2 = innerCall(r5, METHOD_GET_ON_SCREEN_ENTITIES, null, r0);
        if (r2 == null) goto L6;
        r2.setClassLoader(AppEntity.class.getClassLoader());
        return r2.getParcelableArrayList(KEY_ON_SCREEN_ENTITIES);
    L6:
        return null;
    }

    public final Context getSContext() {
        Context r0 = sContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("sContext");
        return null;
    }

    public final void index(AppEntity r3, ResultCallback<x> r4) {
        ResultCallback<x> r5 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r4, ResultCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "entity");
        bulkIndex(d.a.p.a(r3), r5);
    }

    public final synchronized void init$capabilitykit_release(EntityInitParam r8) {
        monitor-enter(this);
        d.h.b.o.e(r8, "entityInitParam");     // Catch: Throwable -> L55
        if (isInitialized == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        d.h.b.o.c(r0, "AppHost.application.applicationContext");     // Catch: Throwable -> L55
        setSContext(r0);     // Catch: Throwable -> L55
        String r1 = r8.getRunProcessName();     // Catch: Throwable -> L55
        EntitySupplier r2 = null;
        boolean r3 = false;
        if (r1 != null) goto L10;
        r1 = null;
    L13:
        featureRunProcessName = r1;     // Catch: Throwable -> L55
        firstRunCleanBeforeTimestamp = System.currentTimeMillis();     // Catch: Throwable -> L55
        String r4 = featureRunProcessName;     // Catch: Throwable -> L55
        if (r4 != null) goto L16;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L24;
        featureRunProcessName = null;     // Catch: Throwable -> L55
    L24:
        Logger r6 = Logger.INSTANCE;     // Catch: Throwable -> L55
        StringBuilder r7 = new StringBuilder().append("init, supplier==null:");     // Catch: Throwable -> L55
        if (r8.getSupplier() != null) goto L27;
        boolean r9 = true;
    L28:
        StringBuilder r10 = r7.append(r9).append(", syncSupplier==null:");     // Catch: Throwable -> L55
        if (r8.getEntitySyncDataSupplier() != null) goto L31;
        r3 = true;
    L31:
        r6.i(TAG, r10.append(r3).toString());     // Catch: Throwable -> L55
        entitySyncDataSupplier = r8.getEntitySyncDataSupplier();     // Catch: Throwable -> L55
        EntitySupplier r11 = r8.getSupplier();     // Catch: Throwable -> L55
        if (r11 != null) goto L36;
        EntitySyncDataSupplier r12 = entitySyncDataSupplier;     // Catch: Throwable -> L55
        if (r12 == null) goto L37;
        r6.i(TAG, "init with entitySyncDataSupplier-backed entitySupplier");     // Catch: Throwable -> L55
        r2 = new a(r12);     // Catch: Throwable -> L55
    L37:
        entitySupplier = r2;     // Catch: Throwable -> L55
        EntityContextHolder.INSTANCE.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L55
        isInitialized = true;     // Catch: Throwable -> L55
        initialCountDownLatch.countDown();     // Catch: Throwable -> L55
        if (isNotInFeatureProcess() == false) goto L46;
        StringBuilder r13 = new StringBuilder().append("initTask, featureProcess: ");     // Catch: Throwable -> L55
        String r14 = featureRunProcessName;     // Catch: Throwable -> L55
        if (r14 != null) goto L42;
        r14 = "MainProcess";
    L42:
        r6.w(TAG, r13.append(r14).append(", currentProcess: ").append(f.f32140a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"))).toString());     // Catch: Throwable -> L55
        monitor-exit(this);
        return;
    L46:
        if (entitySupplier != null) goto L50;
        monitor-exit(this);
        return;
    L50:
        if (isCredentialProtectionLocked() == false) goto L52;
        r6.d(TAG, "device locked, wait user unlock");     // Catch: Throwable -> L55
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), deviceUnlockedReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
    L53:
        monitor-exit(this);
        return;
    L52:
        IndexTaskManager.INSTANCE.postTaskDelay(INIT_TASK_DELAY_TIME, "checkIfFirstRunOrDataClean", $$Lambda$EntityProvider$Sd4CehMm_u8kCJJSGMbxNYl_LaA.INSTANCE);     // Catch: Throwable -> L55
        goto L53
    L36:
        r2 = r11;
        goto L37
    L27:
        r9 = false;
        goto L28
    L16:
        if (r4.length() != 0) goto L18;
        boolean r15 = true;
    L19:
        if (r15 != true) goto L21;
        r5 = true;
        goto L22
    L18:
        r15 = false;
        goto L19
    L10:
        if (d.o.o.b(r1, ":", false, 2, null) == false) goto L13;
        r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(INSTANCE.getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName() + r1;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    public final boolean isDonateAllowed(int r5) {
        Bundle r0 = new Bundle();
        r0.putInt(KEY_ENTITY_TYPE, r5);
        Uri r1 = ENTITY_URI;
        d.h.b.o.c(r1, "ENTITY_URI");
        Boolean r3 = null;
        Bundle r4 = innerCall(r1, METHOD_IS_DONATE_ALLOWED_BY_LOCAL_SWITCH, null, r0);
        if (r4 == null) goto L5;
        r4.setClassLoader(AppEntity.class.getClassLoader());
    L7:
        if (r4 == null) goto L9;
        r3 = Boolean.valueOf(r4.getBoolean(KEY_IS_DONATE_ALLOWED, false));
    L9:
        Logger.INSTANCE.i(TAG, "isDonateAllowed:type=" + r5 + ",value=" + r3);
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.booleanValue();
    L5:
        r4 = null;
        goto L7
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    public final Bundle queryPersonalContextData$capabilitykit_release() {
        Uri r1 = ENTITY_URI;
        d.h.b.o.c(r1, "ENTITY_URI");
        return innerCall$default(this, r1, METHOD_QUERY_PERSONAL_CONTEXT_DATA, null, null, 8, null);
    }

    public final boolean reDonateCheck$capabilitykit_release(String r11) {
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L6;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reDonateCheck");
        return false;
    L6:
        if (r11 != null) goto L29;
        return false;
    L29:
        EntityUpdateVersionParams r10 = (EntityUpdateVersionParams) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r11, EntityUpdateVersionParams.class), EntityUpdateVersionParams.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L26
        final LinkedHashSet r12 = new LinkedHashSet();
        Iterator<Map.Entry<Integer, EntityVersionData>> r13 = r10.getOldEntityVersions().entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        EntityVersionData r2 = (EntityVersionData) ZeusTransformUtils.preCheckCast(r0.getValue(), EntityVersionData.class, "com.obric.aiagent.plugin");
        EntityClassData r5 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(r0.getKey()), EntityClassData.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        int r6 = r5.getVersion();
    L16:
        EntityVersionData r4 = new EntityVersionData(r6, AppEntity.CREATOR.getVersion());
        Logger.INSTANCE.i(TAG, "reDonateCheck, type: " + ((Number) ZeusTransformUtils.preCheckCast(r0.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue() + " sdkVersion: " + r4 + " personalContextVersion: " + r2);
        if (r4.getSelfVersion() == (-1)) goto L11;
        if (r4.compareTo2(r2) <= 0) goto L11;
        r12.add(r0.getKey());
        goto L11
    L15:
        r6 = -1;
        goto L16
    L21:
        Logger r14 = Logger.INSTANCE;
        r14.i(TAG, "reDonateCheck, needDonateVersions" + r12);
        if (r12.isEmpty() == false) goto L24;
        return true;
    L24:
        final CountDownLatch r1 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("reDonateTask", new $$Lambda$EntityProvider$APlMT52z3FZTlZeSmMb4lyIUKs(r1, r12));
        r1.await();
        r14.i(TAG, "reDonateCheck, reDonate finish");
        return true;
    L26:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reDonateCheck parse json error, jsonString: " + r11, e);
        return false;
    }

    public final void reindexEntityData$capabilitykit_release() {
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L13;
        Logger.INSTANCE.i(TAG, "EntityProvider is not available, skip reindexEntityData");
        return;
    L13:
        final CountDownLatch r4 = new CountDownLatch(1);     // Catch: Exception -> L10
        IndexTaskManager r0 = IndexTaskManager.INSTANCE;     // Catch: Exception -> L10
        r0.runTask("reindexEntityData", new $$Lambda$EntityProvider$p2b8GV0fzbTeMYECkutK3iyoRDY(r4));     // Catch: Exception -> L10
        r4.await();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "reindexEntityData error", e);
    }

    public final void setSContext(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "<set-?>");
        sContext = r1;
    }

    public final void syncData(List<Integer> r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "indexedEntityTypes");
        if (com.obric.capabilitykit.entity.memory.a.f32135a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getSContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L7;
        Logger.INSTANCE.w(TAG, "EntityProvider is not available, skip syncData");
        return;
    L7:
        if (isCredentialProtectionLocked() == false) goto L10;
        Logger.INSTANCE.w(TAG, "syncData, credentialProtectionLocked");
        return;
    L10:
        final CountDownLatch r4 = new CountDownLatch(1);
        IndexTaskManager.INSTANCE.runTask("syncData", new $$Lambda$EntityProvider$JbOMKf2CjZEoIm2xLpeCtV_0vo(r6, r4));
        r4.await();
    }

    public final void waitEntityProviderInit(long r2) {
        initialCountDownLatch.await(r2, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.INSTANCE.e(TAG, "waitEntityProviderInit throwable", th);
    }
}
