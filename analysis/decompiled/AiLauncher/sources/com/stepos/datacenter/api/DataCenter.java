package com.stepos.datacenter.api;

import U6.e;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import V6.SearchRequest;
import V6.SearchResult;
import V6.f;
import V6.g;
import Y8.h;
import Y8.t;
import Z8.C1173v;
import Z8.r;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.DataCenter;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.core.storage.BackupManager;
import com.stepos.datacenter.entity.BaseEntity;
import com.stepos.datacenter.vector.EmbedProvider;
import com.stepos.datacenter.vector.VectorSearchRequest;
import com.stepos.datacenter.vector.VectorSearchResult;
import com.stepos.datacenter.vector.VectorStoreManager;
import e7.C4005h;
import e7.InterfaceC4007j;
import e7.VectorStoreConfig;
import e7.m;
import e7.o;
import e7.p;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\b\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0006H\u0086H¢\u0006\u0004\b\t\u0010\nJ(\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@¢\u0006\u0004\b\t\u0010\rJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u001e\u0010\u001bJI\u0010$\u001a\u00020\u001c2:\u0010#\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0 0\u001f\"\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0 ¢\u0006\u0004\b$\u0010%J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0086@¢\u0006\u0004\b'\u0010(J*\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f\"\u00020\u0001H\u0086@¢\u0006\u0004\b'\u0010)J\u001e\u0010*\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0086@¢\u0006\u0004\b*\u0010(J$\u0010*\u001a\u00020\u001c2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f\"\u00020\u0001H\u0086@¢\u0006\u0004\b*\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u00100\u001a\u0004\bE\u0010FR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/stepos/datacenter/api/DataCenter;", "", "LW6/a;", "storageRouter", "<init>", "(LW6/a;)V", "Lcom/stepos/datacenter/entity/BaseEntity;", ExifInterface.GPS_DIRECTION_TRUE, "", "clearTable", "(Le9/c;)Ljava/lang/Object;", "Ljava/lang/Class;", "entityClass", "(Ljava/lang/Class;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/vector/VectorSearchRequest;", "request", "", "Lcom/stepos/datacenter/vector/VectorSearchResult;", "searchVectors$sdk_release", "(Lcom/stepos/datacenter/vector/VectorSearchRequest;Le9/c;)Ljava/lang/Object;", "searchVectors", "LV6/j;", "LV6/k;", "search", "(LV6/j;Le9/c;)Ljava/lang/Object;", Const.LBS_FAIL_BD_ENTITY, "save", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "LY8/t;", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "remove", "", "Lkotlin/Pair;", "Lw9/d;", "LU6/e$a;", "pairs", "bindEntities", "([Lkotlin/Pair;)V", "entities", "saveAll", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "([Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "removeAll", "LW6/a;", "getStorageRouter", "()LW6/a;", "Lcom/stepos/datacenter/api/e;", "vectors$delegate", "LY8/h;", "getVectors", "()Lcom/stepos/datacenter/api/e;", "vectors", "LV6/g;", "fts$delegate", "getFts", "()LV6/g;", "fts", "Lcom/stepos/datacenter/api/d;", "spi$delegate", "getSpi", "()Lcom/stepos/datacenter/api/d;", "spi", "LV6/f;", "files$delegate", "getFiles", "()LV6/f;", "files", "LV6/h;", "graph$delegate", "getGraph", "()LV6/h;", "graph", "Le7/p;", "vectorStorageProvider", "Le7/p;", "getVectorStorageProvider", "()Le7/p;", "setVectorStorageProvider", "(Le7/p;)V", "Companion", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCenter {
    private static final String TAG = "DataCenter";
    private static volatile Context appContext;
    private static volatile EmbedProvider embedProvider;
    private static volatile DataCenter instance;
    private static volatile InterfaceC4007j rerankerProvider;
    private static volatile o vectorRegistry;
    private static volatile boolean vectorStoreEnabled;
    private static volatile VectorStoreManager vectorStoreManager;

    /* renamed from: files$delegate, reason: from kotlin metadata */
    private final h files;

    /* renamed from: fts$delegate, reason: from kotlin metadata */
    private final h fts;

    /* renamed from: graph$delegate, reason: from kotlin metadata */
    private final h graph;

    /* renamed from: spi$delegate, reason: from kotlin metadata */
    private final h spi;
    private final W6.a storageRouter;
    private p vectorStorageProvider;

    /* renamed from: vectors$delegate, reason: from kotlin metadata */
    private final h vectors;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, EmbedProvider> embedProviders = new ConcurrentHashMap<>();
    private static volatile m textChunker = new C4005h(0, 0, 3, null);
    private static volatile InterfaceC1083u<Boolean> ameInitDone = C1087w.c(null, 1, null);

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0087@¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H\u0087@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0087@¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0011H\u0007¢\u0006\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010!\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R&\u0010A\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u0002080?8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00040Z8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006c"}, d2 = {"Lcom/stepos/datacenter/api/DataCenter$Companion;", "", "<init>", "()V", "", "isInitialized", "()Z", "Ljava/io/File;", "destZip", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", "backupTo", "(Ljava/io/File;Le9/c;)Ljava/lang/Object;", "srcZip", "dataRoot", "restoreFrom", "(Ljava/io/File;Ljava/io/File;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "Landroid/content/Context;", "context", "Le7/q;", "config", "LY8/t;", "init", "(Landroid/content/Context;Le7/q;)V", "awaitVectorBackendReady", "(Le9/c;)Ljava/lang/Object;", "", "timeoutMs", "(JLe9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/api/DataCenter;", "getInstance", "()Lcom/stepos/datacenter/api/DataCenter;", "getApplicationContext", "()Landroid/content/Context;", "instance", "Lcom/stepos/datacenter/api/DataCenter;", "getInstance$sdk_release", "setInstance$sdk_release", "(Lcom/stepos/datacenter/api/DataCenter;)V", "appContext", "Landroid/content/Context;", "getAppContext$sdk_release", "setAppContext$sdk_release", "(Landroid/content/Context;)V", "Lcom/stepos/datacenter/vector/VectorStoreManager;", "vectorStoreManager", "Lcom/stepos/datacenter/vector/VectorStoreManager;", "getVectorStoreManager$sdk_release", "()Lcom/stepos/datacenter/vector/VectorStoreManager;", "setVectorStoreManager$sdk_release", "(Lcom/stepos/datacenter/vector/VectorStoreManager;)V", "vectorStoreEnabled", "Z", "getVectorStoreEnabled$sdk_release", "setVectorStoreEnabled$sdk_release", "(Z)V", "Lcom/stepos/datacenter/vector/EmbedProvider;", "embedProvider", "Lcom/stepos/datacenter/vector/EmbedProvider;", "getEmbedProvider$sdk_release", "()Lcom/stepos/datacenter/vector/EmbedProvider;", "setEmbedProvider$sdk_release", "(Lcom/stepos/datacenter/vector/EmbedProvider;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "", "embedProviders", "Ljava/util/concurrent/ConcurrentHashMap;", "getEmbedProviders$sdk_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "Le7/m;", "textChunker", "Le7/m;", "getTextChunker$sdk_release", "()Le7/m;", "setTextChunker$sdk_release", "(Le7/m;)V", "Le7/j;", "rerankerProvider", "Le7/j;", "getRerankerProvider$sdk_release", "()Le7/j;", "setRerankerProvider$sdk_release", "(Le7/j;)V", "Le7/o;", "vectorRegistry", "Le7/o;", "getVectorRegistry$sdk_release", "()Le7/o;", "setVectorRegistry$sdk_release", "(Le7/o;)V", "LUa/u;", "ameInitDone", "LUa/u;", "getAmeInitDone$sdk_release", "()LUa/u;", "setAmeInitDone$sdk_release", "(LUa/u;)V", "TAG", "Ljava/lang/String;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, VectorStoreConfig vectorStoreConfig, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                vectorStoreConfig = null;
            }
            companion.init(context, vectorStoreConfig);
        }

        public final Object awaitVectorBackendReady(InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return getAmeInitDone$sdk_release().a1(interfaceC4014c);
        }

        public final Object backupTo(File file, InterfaceC4014c<? super DataCenterResult<BackupManager.BackupManifest>> interfaceC4014c) {
            return BackupOps.f29803a.a(file, interfaceC4014c);
        }

        public final InterfaceC1083u<Boolean> getAmeInitDone$sdk_release() {
            return DataCenter.ameInitDone;
        }

        public final Context getAppContext$sdk_release() {
            return DataCenter.appContext;
        }

        public final Context getApplicationContext() {
            Context appContext$sdk_release = getAppContext$sdk_release();
            if (appContext$sdk_release != null) {
                return appContext$sdk_release;
            }
            throw new IllegalStateException("DataCenter not initialized");
        }

        public final EmbedProvider getEmbedProvider$sdk_release() {
            return DataCenter.embedProvider;
        }

        public final ConcurrentHashMap<String, EmbedProvider> getEmbedProviders$sdk_release() {
            return DataCenter.embedProviders;
        }

        public final DataCenter getInstance() {
            DataCenter instance$sdk_release = getInstance$sdk_release();
            if (instance$sdk_release != null) {
                return instance$sdk_release;
            }
            throw new IllegalStateException("DataCenter not initialized. Call init() first.");
        }

        public final DataCenter getInstance$sdk_release() {
            return DataCenter.instance;
        }

        public final InterfaceC4007j getRerankerProvider$sdk_release() {
            DataCenter.access$getRerankerProvider$cp();
            return null;
        }

        public final m getTextChunker$sdk_release() {
            return DataCenter.textChunker;
        }

        public final o getVectorRegistry$sdk_release() {
            return DataCenter.vectorRegistry;
        }

        public final boolean getVectorStoreEnabled$sdk_release() {
            return DataCenter.vectorStoreEnabled;
        }

        public final VectorStoreManager getVectorStoreManager$sdk_release() {
            return DataCenter.vectorStoreManager;
        }

        public final void init(Context context, VectorStoreConfig config) {
            kotlin.jvm.internal.p.i(context, "context");
            LifecycleOps.f29881a.a(context, config);
        }

        public final boolean isInitialized() {
            return getInstance$sdk_release() != null;
        }

        public final DataCenterResult<BackupManager.BackupManifest> restoreFrom(File srcZip, File dataRoot) {
            kotlin.jvm.internal.p.i(srcZip, "srcZip");
            kotlin.jvm.internal.p.i(dataRoot, "dataRoot");
            return BackupOps.f29803a.b(srcZip, dataRoot);
        }

        public final void setAmeInitDone$sdk_release(InterfaceC1083u<Boolean> interfaceC1083u) {
            kotlin.jvm.internal.p.i(interfaceC1083u, "<set-?>");
            DataCenter.ameInitDone = interfaceC1083u;
        }

        public final void setAppContext$sdk_release(Context context) {
            DataCenter.appContext = context;
        }

        public final void setEmbedProvider$sdk_release(EmbedProvider embedProvider) {
            DataCenter.embedProvider = embedProvider;
        }

        public final void setInstance$sdk_release(DataCenter dataCenter) {
            DataCenter.instance = dataCenter;
        }

        public final void setRerankerProvider$sdk_release(InterfaceC4007j interfaceC4007j) {
            DataCenter.access$setRerankerProvider$cp(interfaceC4007j);
        }

        public final void setTextChunker$sdk_release(m mVar) {
            kotlin.jvm.internal.p.i(mVar, "<set-?>");
            DataCenter.textChunker = mVar;
        }

        public final void setVectorRegistry$sdk_release(o oVar) {
            DataCenter.vectorRegistry = oVar;
        }

        public final void setVectorStoreEnabled$sdk_release(boolean z10) {
            DataCenter.vectorStoreEnabled = z10;
        }

        public final void setVectorStoreManager$sdk_release(VectorStoreManager vectorStoreManager) {
            DataCenter.vectorStoreManager = vectorStoreManager;
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object awaitVectorBackendReady(long r5, e9.InterfaceC4014c<? super java.lang.Boolean> r7) {
            /*
                r4 = this;
                boolean r0 = r7 instanceof com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$2
                if (r0 == 0) goto L13
                r0 = r7
                com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$2 r0 = (com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$2) r0
                int r1 = r0.f29822c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f29822c = r1
                goto L18
            L13:
                com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$2 r0 = new com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$2
                r0.<init>(r4, r7)
            L18:
                java.lang.Object r4 = r0.f29820a
                java.lang.Object r7 = f9.C4063a.g()
                int r1 = r0.f29822c
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                kotlin.C4849c.b(r4)
                goto L43
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.C4849c.b(r4)
                com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$3 r4 = new com.stepos.datacenter.api.DataCenter$Companion$awaitVectorBackendReady$3
                r1 = 0
                r4.<init>(r1)
                r0.f29822c = r2
                java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.e(r5, r4, r0)
                if (r4 != r7) goto L43
                return r7
            L43:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                if (r4 == 0) goto L4c
                boolean r4 = r4.booleanValue()
                goto L4d
            L4c:
                r4 = 0
            L4d:
                java.lang.Boolean r4 = g9.C4109a.a(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.DataCenter.Companion.awaitVectorBackendReady(long, e9.c):java.lang.Object");
        }
    }

    public DataCenter(W6.a storageRouter) {
        kotlin.jvm.internal.p.i(storageRouter, "storageRouter");
        this.storageRouter = storageRouter;
        this.vectors = C4848b.b(new InterfaceC5063a() { // from class: V6.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenter.vectors_delegate$lambda$0(this.f6478a);
            }
        });
        this.fts = C4848b.b(new InterfaceC5063a() { // from class: V6.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenter.fts_delegate$lambda$1(this.f6479a);
            }
        });
        this.spi = C4848b.b(new InterfaceC5063a() { // from class: V6.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenter.spi_delegate$lambda$2(this.f6480a);
            }
        });
        this.files = C4848b.b(new InterfaceC5063a() { // from class: V6.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenter.files_delegate$lambda$3(this.f6481a);
            }
        });
        this.graph = C4848b.b(new InterfaceC5063a() { // from class: V6.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenter.graph_delegate$lambda$4(this.f6482a);
            }
        });
    }

    public static final /* synthetic */ InterfaceC4007j access$getRerankerProvider$cp() {
        return null;
    }

    public static final /* synthetic */ void access$setRerankerProvider$cp(InterfaceC4007j interfaceC4007j) {
    }

    public static final Object awaitVectorBackendReady(long j10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return INSTANCE.awaitVectorBackendReady(j10, interfaceC4014c);
    }

    public static final Object backupTo(File file, InterfaceC4014c<? super DataCenterResult<BackupManager.BackupManifest>> interfaceC4014c) {
        return INSTANCE.backupTo(file, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f files_delegate$lambda$3(DataCenter dataCenter) {
        return new f(dataCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g fts_delegate$lambda$1(DataCenter dataCenter) {
        return new g(dataCenter);
    }

    public static final Context getApplicationContext() {
        return INSTANCE.getApplicationContext();
    }

    public static final DataCenter getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V6.h graph_delegate$lambda$4(DataCenter dataCenter) {
        return new V6.h(dataCenter);
    }

    public static final void init(Context context, VectorStoreConfig vectorStoreConfig) {
        INSTANCE.init(context, vectorStoreConfig);
    }

    public static final boolean isInitialized() {
        return INSTANCE.isInitialized();
    }

    public static final DataCenterResult<BackupManager.BackupManifest> restoreFrom(File file, File file2) {
        return INSTANCE.restoreFrom(file, file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d spi_delegate$lambda$2(DataCenter dataCenter) {
        return new d(dataCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e vectors_delegate$lambda$0(DataCenter dataCenter) {
        return new e(dataCenter);
    }

    public final void bindEntities(Pair<? extends InterfaceC5745d<?>, ? extends e.a<?>>... pairs) {
        kotlin.jvm.internal.p.i(pairs, "pairs");
        EntityCrudOps.f29848a.a(pairs);
    }

    public final /* synthetic */ <T extends BaseEntity> Object clearTable(InterfaceC4014c<? super Long> interfaceC4014c) {
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        n.c(0);
        Object objClearTable = clearTable(BaseEntity.class, interfaceC4014c);
        n.c(1);
        return objClearTable;
    }

    public final f getFiles() {
        return (f) this.files.getValue();
    }

    public final g getFts() {
        return (g) this.fts.getValue();
    }

    public final V6.h getGraph() {
        return (V6.h) this.graph.getValue();
    }

    public final d getSpi() {
        return (d) this.spi.getValue();
    }

    public final W6.a getStorageRouter() {
        return this.storageRouter;
    }

    public final p getVectorStorageProvider() {
        return this.vectorStorageProvider;
    }

    public final e getVectors() {
        return (e) this.vectors.getValue();
    }

    public final Object remove(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objB = EntityCrudOps.f29848a.b(this, obj, interfaceC4014c);
        return objB == C4063a.g() ? objB : t.f7040a;
    }

    public final Object removeAll(List<? extends Object> list, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objC = EntityCrudOps.f29848a.c(this, list, interfaceC4014c);
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final Object save(Object obj, InterfaceC4014c<? super Long> interfaceC4014c) {
        return EntityCrudOps.f29848a.d(this, obj, interfaceC4014c);
    }

    public final Object saveAll(List<? extends Object> list, InterfaceC4014c<? super List<Long>> interfaceC4014c) {
        return EntityCrudOps.f29848a.e(this, list, interfaceC4014c);
    }

    public final Object search(SearchRequest searchRequest, InterfaceC4014c<? super SearchResult> interfaceC4014c) {
        return UnifiedSearchOps.f29900a.i(this, searchRequest, interfaceC4014c);
    }

    public final Object searchVectors$sdk_release(VectorSearchRequest vectorSearchRequest, InterfaceC4014c<? super List<VectorSearchResult>> interfaceC4014c) {
        return DispatchKt.a("vector.search", C1173v.m(), new DataCenter$searchVectors$2(this, vectorSearchRequest, null), interfaceC4014c);
    }

    public final void setVectorStorageProvider(p pVar) {
        this.vectorStorageProvider = pVar;
    }

    public final Object update(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF = EntityCrudOps.f29848a.f(this, obj, interfaceC4014c);
        return objF == C4063a.g() ? objF : t.f7040a;
    }

    public static final Object awaitVectorBackendReady(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return INSTANCE.awaitVectorBackendReady(interfaceC4014c);
    }

    public final <T extends BaseEntity> Object clearTable(Class<T> cls, InterfaceC4014c<? super Long> interfaceC4014c) {
        return StorageOps.f29894a.a(this, cls, interfaceC4014c);
    }

    public final Object removeAll(Object[] objArr, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objC = EntityCrudOps.f29848a.c(this, r.T0(objArr), interfaceC4014c);
        return objC == C4063a.g() ? objC : t.f7040a;
    }

    public final Object saveAll(Object[] objArr, InterfaceC4014c<? super List<Long>> interfaceC4014c) {
        return EntityCrudOps.f29848a.e(this, r.T0(objArr), interfaceC4014c);
    }
}
