package com.stepos.core.ota.remote;

import ad.l;
import ad.n;
import ad.s;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.reflect.TypeToken;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.debug.DebugInjectionGate;
import com.stepos.core.common.device.OaidResolver;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.data.OtaRemoteModelDeserializer;
import com.stepos.core.ota.install.OtaBucketLegacy;
import com.stepos.core.ota.remote.RemoteModelsFetchLogic;
import com.stepos.core.ota.storage.RemoteManifestEpoch;
import com.stepos.cpuset.b;
import d5.i;
import d5.j;
import g5.c;
import g5.p;
import g5.r;
import gc.o;
import gc.q;
import h0.e;
import j5.d;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;
import mb.m;
import mb.v;
import okhttp3.Response;
import okhttp3.h;
import okhttp3.logging.HttpLoggingInterceptor;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RemoteModelsRepository {
    private static final long CACHE_TTL_MS = 43200000;
    private static final String PROD_URL = "https://upush.stepaos.com/model/v2/check";
    private static final String SIGN_KEY = "5bdbbf945b54ca9cea8aa3212286bb4f";
    private static final String TAG = "RemoteModelsRepo";
    private static final String TEST_URL = "https://upush.t-stepos.com/model/v2/check";
    private static final i gson;
    private static final d httpClient$delegate;
    private static volatile long lastServerReachedAtMs;
    private static volatile boolean loaded;
    private static volatile long seenEpoch;
    public static final RemoteModelsRepository INSTANCE = new RemoteModelsRepository();
    private static final l JSON_MEDIA_TYPE = bd.d.a("application/json; charset=utf-8");
    private static final ConcurrentHashMap<String, OtaRemoteModel> resultsMap = new ConcurrentHashMap<>();
    private static volatile a<String> frameworkProvider = new b(5);
    private static final ConcurrentHashMap<String, Long> fetchTime = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteModelsFetchLogic.EmptyFetchOutcome.values().length];
            try {
                iArr[RemoteModelsFetchLogic.EmptyFetchOutcome.BATCH_EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteModelsFetchLogic.EmptyFetchOutcome.STALE_EVICTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RemoteModelsFetchLogic.EmptyFetchOutcome.UP_TO_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RemoteModelsFetchLogic.EmptyFetchOutcome.UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        r rVar;
        r rVar2;
        j jVar = new j();
        jVar.a(ApiResponse.class, new ApiResponseDeserializer());
        jVar.a(OtaRemoteModel.class, new OtaRemoteModelDeserializer());
        ArrayList arrayList = jVar.f8372e;
        int size = arrayList.size();
        ArrayList arrayList2 = jVar.f8373f;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        int i10 = jVar.f8374g;
        int i11 = jVar.h;
        c.b.a aVar = c.b.f8975b;
        boolean z = j5.d.f9702a;
        if (i10 != 2 || i11 != 2) {
            c cVar = new c(aVar, i10, i11);
            r rVar3 = p.f9035a;
            r rVar4 = new r(Date.class, cVar);
            if (z) {
                d.b bVar = j5.d.f9704c;
                bVar.getClass();
                rVar = new r(bVar.f8976a, new c(bVar, i10, i11));
                d.a aVar2 = j5.d.f9703b;
                aVar2.getClass();
                rVar2 = new r(aVar2.f8976a, new c(aVar2, i10, i11));
            } else {
                rVar = null;
                rVar2 = null;
            }
            arrayList3.add(rVar4);
            if (z) {
                arrayList3.add(rVar);
                arrayList3.add(rVar2);
            }
        }
        gson = new i(jVar.f8368a, jVar.f8370c, new HashMap(jVar.f8371d), jVar.f8375i, jVar.f8376j, jVar.f8377k, jVar.f8369b, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, jVar.f8378l, jVar.f8379m, new ArrayList(jVar.f8380n));
        httpClient$delegate = kotlin.b.b(new com.stepos.cpuset.c(4));
    }

    private RemoteModelsRepository() {
    }

    private final String baseUrl(Context context) {
        return isTestEnv(context) ? TEST_URL : PROD_URL;
    }

    @SuppressLint({"HardwareIds"})
    private final String buildSignedRequestBody(Context context, RemoteModelsFetchLogic.FetchContext fetchContext) {
        long longVersionCode;
        try {
            longVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
        } catch (Exception unused) {
            longVersionCode = 0;
        }
        long j10 = longVersionCode;
        String str = OaidResolver.INSTANCE.get(context);
        RemoteModelsFetchLogic remoteModelsFetchLogic = RemoteModelsFetchLogic.INSTANCE;
        LinkedHashMap<String, String> linkedHashMapBuildRequestParams = remoteModelsFetchLogic.buildRequestParams(fetchContext, System.currentTimeMillis(), j10, str, Build.SOC_MODEL, frameworkProvider.invoke());
        try {
            linkedHashMapBuildRequestParams.put("sign", remoteModelsFetchLogic.hmacSha256(remoteModelsFetchLogic.signBase(linkedHashMapBuildRequestParams), SIGN_KEY));
            return gson.h(linkedHashMapBuildRequestParams);
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, TAG, "sign fail", e10);
            return null;
        }
    }

    private final String executeCheckRequest(Context context, String str) {
        h.a aVar = new h.a();
        aVar.e(baseUrl(context));
        s.a aVar2 = s.Companion;
        l lVar = JSON_MEDIA_TYPE;
        aVar2.getClass();
        aVar.c("POST", s.a.b(str, lVar));
        h hVar = new h(aVar);
        Log.d(TAG, "executeCheckRequest: url=" + hVar.f10992a + ", bodyLen=" + str.length());
        try {
            Response responseD = getHttpClient().a(hVar).d();
            Log.d(TAG, "executeCheckRequest: ============================");
            try {
                if (responseD.r) {
                    return responseD.f10893j.C();
                }
                AIEngineLogger.e(LogModule.OTA, TAG, "fetch failed: HTTP " + responseD.f10891d + " ");
                return null;
            } finally {
                bd.i.b(responseD);
            }
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, TAG, "fetch network error", e10);
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    private final boolean executeFetch(Context context, String str, RemoteModelsFetchLogic.FetchContext fetchContext) {
        String strExecuteCheckRequest;
        List<OtaRemoteModel> list;
        boolean z;
        String strBuildSignedRequestBody = buildSignedRequestBody(context, fetchContext);
        boolean z3 = false;
        if (strBuildSignedRequestBody == null || (strExecuteCheckRequest = executeCheckRequest(context, strBuildSignedRequestBody)) == null) {
            return false;
        }
        lastServerReachedAtMs = System.currentTimeMillis();
        ApiResponse checkResponse = parseCheckResponse(strExecuteCheckRequest);
        if (checkResponse == null) {
            return false;
        }
        Log.d(TAG, "executeCheckRequest: code=" + checkResponse.getCode() + ", items=" + checkResponse.getValue().size());
        if (DebugInjectionGate.INSTANCE.isEnabled()) {
            Iterator<T> it = checkResponse.getValue().iterator();
            while (it.hasNext()) {
                a0.a.v("[fetch-model] ", ((OtaRemoteModel) it.next()).toFullDumpString(), TAG);
            }
        }
        if (checkResponse.getCode() != 0) {
            LogModule logModule = LogModule.OTA;
            StringBuilder sbE = e.e("check failed: code=", checkResponse.getCode(), " msg=", checkResponse.getMessage(), " name=");
            sbE.append(str);
            AIEngineLogger.e(logModule, TAG, sbE.toString());
            return false;
        }
        List<OtaRemoteModel> value = checkResponse.getValue();
        LogModule logModule2 = LogModule.OTA;
        int code = checkResponse.getCode();
        int size = value.size();
        ArrayList arrayList = new ArrayList(m.Z(value, 10));
        for (OtaRemoteModel otaRemoteModel : value) {
            String name = otaRemoteModel.getName();
            int version_code = otaRemoteModel.getVersion_code();
            boolean z10 = z3;
            long file_size = otaRemoteModel.getFile_size();
            String md5 = otaRemoteModel.getMd5();
            int length = otaRemoteModel.getDek_cipher().length();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append("(v");
            sb2.append(version_code);
            sb2.append(",size=");
            ai.onnxruntime.a.u(file_size, ",md5=", md5, sb2);
            sb2.append(",dekLen=");
            sb2.append(length);
            sb2.append(")");
            arrayList.add(sb2.toString());
            value = value;
            z3 = z10;
        }
        boolean z11 = z3;
        List<OtaRemoteModel> list2 = value;
        StringBuilder sbD = e.d(code, "fetch parsed: respCode=", size, " count=", " models=");
        sbD.append(arrayList);
        AIEngineLogger.i(logModule2, TAG, sbD.toString());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list2.isEmpty()) {
            Pair<Boolean, RemoteModelsFetchLogic.EmptyFetchOutcome> pairApplyEmptyResponse = RemoteModelsFetchLogic.INSTANCE.applyEmptyResponse(fetchContext, resultsMap, fetchTime, jCurrentTimeMillis);
            boolean zBooleanValue = pairApplyEmptyResponse.f9985a.booleanValue();
            logEmptyFetchOutcome(fetchContext, pairApplyEmptyResponse.f9986b);
            z = zBooleanValue;
            list = list2;
        } else {
            list = list2;
            onNewResults(list);
            if (fetchContext.getMultiName()) {
                RemoteModelsFetchLogic remoteModelsFetchLogic = RemoteModelsFetchLogic.INSTANCE;
                Set<String> setMissingNamesInBatch = remoteModelsFetchLogic.missingNamesInBatch(str, list);
                if (!setMissingNamesInBatch.isEmpty()) {
                    remoteModelsFetchLogic.pruneMissing(setMissingNamesInBatch, resultsMap, fetchTime);
                    AIEngineLogger.w(LogModule.OTA, TAG, "prune missing from batch: " + setMissingNamesInBatch);
                }
            }
            z = true;
        }
        saveResults(context);
        RemoteModelsFetchLogic.INSTANCE.recordFetchTimes(fetchContext, list, fetchTime, jCurrentTimeMillis);
        if (fetchContext.getMultiName()) {
            return true;
        }
        if (!z || get(str) == null) {
            return z11;
        }
        return true;
    }

    @SuppressLint({"HardwareIds"})
    public static final synchronized boolean fetch(Context context, String name, boolean z) {
        g.f(context, "context");
        g.f(name, "name");
        if (q.t0(name)) {
            AIEngineLogger.w(LogModule.OTA, TAG, "fetch: name is blank, skip");
            return false;
        }
        RemoteModelsRepository remoteModelsRepository = INSTANCE;
        remoteModelsRepository.loadResultsIfNeeded(context);
        if (z || !remoteModelsRepository.isRecentlyFetched(name)) {
            return remoteModelsRepository.executeFetch(context, name, RemoteModelsFetchLogic.INSTANCE.buildFetchContext(name));
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "recently fetched: ".concat(name));
        return true;
    }

    public static /* synthetic */ boolean fetch$default(Context context, String str, boolean z, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        return fetch(context, str, z);
    }

    public static final synchronized boolean fetchIgnoringInstalledVersion(Context context, String name) {
        g.f(context, "context");
        g.f(name, "name");
        if (q.t0(name)) {
            AIEngineLogger.w(LogModule.OTA, TAG, "fetchIgnoringInstalledVersion: name is blank, skip");
            return false;
        }
        RemoteModelsRepository remoteModelsRepository = INSTANCE;
        remoteModelsRepository.loadResultsIfNeeded(context);
        return remoteModelsRepository.executeFetch(context, name, new RemoteModelsFetchLogic.FetchContext(name, false, 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String frameworkProvider$lambda$0() {
        return "";
    }

    public static final OtaRemoteModel get(String name) {
        g.f(name, "name");
        return OtaBucketLegacy.INSTANCE.resolveRemote(resultsMap, name);
    }

    private final File getCacheFile(Context context) {
        return new File(context.getCacheDir().getAbsoluteFile(), "remote_models.json");
    }

    private final n getHttpClient() {
        return (n) httpClient$delegate.getValue();
    }

    public static final List<OtaRemoteModel> getWithDependencies(String name) {
        g.f(name, "name");
        ArrayList arrayList = new ArrayList();
        OtaRemoteModel otaRemoteModelResolveRemote = OtaBucketLegacy.INSTANCE.resolveRemote(resultsMap, name);
        if (otaRemoteModelResolveRemote == null) {
            return null;
        }
        arrayList.add(otaRemoteModelResolveRemote);
        if (getWithDependencies$addDeps(arrayList, otaRemoteModelResolveRemote)) {
            return null;
        }
        return arrayList;
    }

    private static final boolean getWithDependencies$addDeps(List<OtaRemoteModel> list, OtaRemoteModel otaRemoteModel) {
        List<String> dependencies = otaRemoteModel.getDependencies();
        if (dependencies == null) {
            dependencies = EmptyList.f10001a;
        }
        Iterator<String> it = dependencies.iterator();
        while (it.hasNext()) {
            OtaRemoteModel otaRemoteModel2 = resultsMap.get(it.next());
            if (otaRemoteModel2 == null) {
                return true;
            }
            if (!list.contains(otaRemoteModel2)) {
                list.add(otaRemoteModel2);
                if (getWithDependencies$addDeps(list, otaRemoteModel2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n httpClient_delegate$lambda$2() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(0);
        httpLoggingInterceptor.f11305d = HttpLoggingInterceptor.Level.f11307b;
        n.a aVar = new n.a();
        aVar.a(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.b(5L, timeUnit);
        aVar.c(10L, timeUnit);
        return new n(aVar);
    }

    public static final void invalidate(String name) {
        g.f(name, "name");
        if (resultsMap.remove(name) != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "invalidate cached model: ".concat(name));
        }
        if (fetchTime.remove(name) != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "invalidate fetch time: ".concat(name));
        }
        INSTANCE.invalidateBatchKeysContaining(name);
    }

    private final void invalidateBatchKeysContaining(String str) {
        RemoteModelsFetchLogic remoteModelsFetchLogic = RemoteModelsFetchLogic.INSTANCE;
        Set<String> setKeySet = fetchTime.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        for (String str2 : remoteModelsFetchLogic.batchKeysContaining(str, setKeySet)) {
            fetchTime.remove(str2);
            AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("invalidate batch fetch time containing ", str, ": ", str2));
        }
    }

    public static final void invalidateTtl(String name) {
        g.f(name, "name");
        if (fetchTime.remove(name) != null) {
            AIEngineLogger.i(LogModule.OTA, TAG, "invalidate fetch time (keep cached data): ".concat(name));
        }
        INSTANCE.invalidateBatchKeysContaining(name);
    }

    private final boolean isTestEnv(Context context) {
        Object objA;
        try {
            objA = Boolean.valueOf(g.b(Settings.Secure.getString(context.getContentResolver(), "net_env"), "test"));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final void loadResultsIfNeeded(Context context) {
        if (loaded) {
            syncPeerRefreshIfNeeded(context);
        } else {
            loadResults(context);
            loaded = true;
        }
    }

    private final void logEmptyFetchOutcome(RemoteModelsFetchLogic.FetchContext fetchContext, RemoteModelsFetchLogic.EmptyFetchOutcome emptyFetchOutcome) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[emptyFetchOutcome.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                AIEngineLogger.w(LogModule.OTA, TAG, ai.onnxruntime.a.i("evict stale cache: ", fetchContext.getLocalVer(), fetchContext.getName(), " (server returned empty, local v", ")"));
            } else if (i10 == 3) {
                AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.i("fetch: no update for ", fetchContext.getLocalVer(), fetchContext.getName(), " (up-to-date, localVer=", ")"));
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                AIEngineLogger.w(LogModule.OTA, TAG, "fetch: server returned empty value for " + fetchContext.getName() + ", cleared cache + throttle");
            }
        }
    }

    private final ApiResponse parseCheckResponse(String str) {
        try {
            return (ApiResponse) gson.b(ApiResponse.class, str);
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, TAG, "parse json failed", e10);
            return null;
        }
    }

    private final void replaceAll(List<OtaRemoteModel> list) {
        int iA0 = v.a0(m.Z(list, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (Object obj : list) {
            linkedHashMap.put(((OtaRemoteModel) obj).getName(), obj);
        }
        ConcurrentHashMap<String, OtaRemoteModel> concurrentHashMap = resultsMap;
        concurrentHashMap.putAll(linkedHashMap);
        concurrentHashMap.keySet().retainAll(linkedHashMap.keySet());
    }

    public static final synchronized void seedFromPush(Context context, String otaId, int i10, Long l10) {
        try {
            g.f(context, "context");
            g.f(otaId, "otaId");
            RemoteModelsRepository remoteModelsRepository = INSTANCE;
            remoteModelsRepository.loadResultsIfNeeded(context);
            remoteModelsRepository.onNewResults(b1.P(new OtaRemoteModel(otaId, i10, null, l10 != null ? l10.longValue() : 0L, null, null, 0L, null, null, null, null, null, 4084, null)));
            remoteModelsRepository.saveResults(context);
            AIEngineLogger.w(LogModule.OTA, TAG, "seedFromPush: otaId=" + otaId + " ver=" + i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void syncPeerRefreshIfNeeded(Context context) {
        long jCurrent = RemoteManifestEpoch.INSTANCE.current();
        if (jCurrent == seenEpoch) {
            return;
        }
        AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.m(ai.onnxruntime.a.q(seenEpoch, "peer process refreshed manifests (epoch ", " -> "), jCurrent, "), reload cache from disk"));
        loadResults(context);
    }

    public static final boolean wasServerReachedRecently(long j10) {
        long j11 = lastServerReachedAtMs;
        return j11 > 0 && System.currentTimeMillis() - j11 <= j10;
    }

    public static /* synthetic */ boolean wasServerReachedRecently$default(long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS;
        }
        return wasServerReachedRecently(j10);
    }

    public final void clearResults(Context context) {
        g.f(context, "context");
        resultsMap.clear();
        fetchTime.clear();
        saveResults(context);
    }

    public final List<String> dump() {
        Set<Map.Entry<String, OtaRemoteModel>> setEntrySet = resultsMap.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        Set<Map.Entry<String, OtaRemoteModel>> set = setEntrySet;
        ArrayList arrayList = new ArrayList(m.Z(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add("[" + entry.getKey() + "] " + ((OtaRemoteModel) entry.getValue()).toDumpString());
        }
        return arrayList;
    }

    public final long getCheckTime(String models) {
        g.f(models, "models");
        if (q.t0(models)) {
            return -1L;
        }
        if (!q.l0(models, "|", false)) {
            Long l10 = fetchTime.get(models);
            if (l10 != null) {
                return l10.longValue();
            }
            return -1L;
        }
        Iterator it = kotlin.collections.a.R0(q.D0(models, new String[]{"|"}, 6)).iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            Long l11 = fetchTime.get((String) it.next());
            if (l11 == null) {
                return -1L;
            }
            jMin = Math.min(jMin, l11.longValue());
        }
        if (jMin == Long.MAX_VALUE) {
            return -1L;
        }
        return jMin;
    }

    public final ConcurrentHashMap<String, Long> getFetchTime() {
        return fetchTime;
    }

    public final a<String> getFrameworkProvider() {
        return frameworkProvider;
    }

    public final List<OtaRemoteModel> getPluginModels(String modelType) {
        int i10;
        g.f(modelType, "modelType");
        Set<String> setKeySet = resultsMap.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            g.c(str);
            if (o.k0(str, modelType.concat("."), false)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            OtaRemoteModel otaRemoteModel = resultsMap.get((String) obj);
            if (otaRemoteModel != null) {
                arrayList2.add(otaRemoteModel);
            }
        }
        return arrayList2;
    }

    public final boolean isRecentlyFetched(String name) {
        g.f(name, "name");
        Long l10 = fetchTime.get(name);
        return System.currentTimeMillis() - (l10 != null ? l10.longValue() : 0L) < CACHE_TTL_MS;
    }

    public final synchronized void loadResults(Context context) {
        g.f(context, "context");
        seenEpoch = RemoteManifestEpoch.INSTANCE.current();
        File cacheFile = getCacheFile(context);
        if (cacheFile.isFile()) {
            try {
                Type type = new TypeToken<List<? extends OtaRemoteModel>>() { // from class: com.stepos.core.ota.remote.RemoteModelsRepository$loadResults$type$1
                }.getType();
                i iVar = gson;
                String strZ = wb.d.Z(cacheFile, gc.a.f9106b);
                iVar.getClass();
                List<OtaRemoteModel> list = (List) iVar.c(strZ, TypeToken.get(type));
                if (list == null) {
                } else {
                    replaceAll(list);
                }
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.OTA, TAG, "loadResults error", e10);
            }
        }
    }

    public final void onNewResults(List<OtaRemoteModel> list) {
        Object objA;
        g.f(list, "list");
        for (OtaRemoteModel otaRemoteModel : list) {
            OtaRemoteModel otaRemoteModel2 = resultsMap.get(otaRemoteModel.getName());
            int iIntValue = 0;
            if (otaRemoteModel2 != null && otaRemoteModel2.getVersion_code() > otaRemoteModel.getVersion_code()) {
                try {
                    objA = Integer.valueOf(OtaBucketLegacy.INSTANCE.effectiveVersion(otaRemoteModel.getName()));
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = 0;
                }
                iIntValue = ((Number) objA).intValue();
            }
            if (RemoteModelsFetchLogic.INSTANCE.acceptsIncoming(otaRemoteModel2 != null ? Integer.valueOf(otaRemoteModel2.getVersion_code()) : null, otaRemoteModel.getVersion_code(), iIntValue)) {
                if (otaRemoteModel2 != null && otaRemoteModel2.getVersion_code() > otaRemoteModel.getVersion_code()) {
                    LogModule logModule = LogModule.OTA;
                    String name = otaRemoteModel.getName();
                    int version_code = otaRemoteModel2.getVersion_code();
                    int version_code2 = otaRemoteModel.getVersion_code();
                    StringBuilder sbE = e.e("accept downgrade (installed v", iIntValue, "): ", name, " cached=v");
                    sbE.append(version_code);
                    sbE.append(" -> incoming=v");
                    sbE.append(version_code2);
                    AIEngineLogger.i(logModule, TAG, sbE.toString());
                }
                resultsMap.put(otaRemoteModel.getName(), otaRemoteModel);
            } else {
                LogModule logModule2 = LogModule.OTA;
                String name2 = otaRemoteModel.getName();
                Integer numValueOf = otaRemoteModel2 != null ? Integer.valueOf(otaRemoteModel2.getVersion_code()) : null;
                int version_code3 = otaRemoteModel.getVersion_code();
                StringBuilder sbE2 = e.e("skip stale downgrade (jitter, installed v", iIntValue, "): ", name2, " cached=v");
                sbE2.append(numValueOf);
                sbE2.append(" -> incoming=v");
                sbE2.append(version_code3);
                AIEngineLogger.w(logModule2, TAG, sbE2.toString());
            }
        }
    }

    public final void saveResults(Context context) {
        g.f(context, "context");
        try {
            File cacheFile = getCacheFile(context);
            File parentFile = cacheFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            i iVar = gson;
            Collection<OtaRemoteModel> collectionValues = resultsMap.values();
            g.e(collectionValues, "<get-values>(...)");
            String strH = iVar.h(kotlin.collections.a.O0(collectionValues));
            g.e(strH, "toJson(...)");
            wb.d.e0(cacheFile, strH);
            seenEpoch = RemoteManifestEpoch.INSTANCE.bump();
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, TAG, "saveResults error", e10);
        }
    }

    public final void setFrameworkProvider(a<String> aVar) {
        g.f(aVar, "<set-?>");
        frameworkProvider = aVar;
    }
}
