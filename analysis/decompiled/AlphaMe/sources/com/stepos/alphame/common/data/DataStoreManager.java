package com.stepos.alphame.common.data;

import S.C0098d;
import S.M;
import V.d;
import V.e;
import V.k;
import Z2.F;
import Z2.G;
import Z2.I;
import Z2.Q;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.common.internal.f;
import com.stepos.alphame.common.utils.BaseApplication;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import t0.J;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/stepos/alphame/common/data/DataStoreManager;", "", "", "dataStoreFileName", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Lcom/stepos/alphame/common/data/DataStorePreferences;", "getDataStore", "(Ljava/lang/String;Landroid/content/Context;)Lcom/stepos/alphame/common/data/DataStorePreferences;", "(Ljava/lang/String;)Lcom/stepos/alphame/common/data/DataStorePreferences;", "TAG", "Ljava/lang/String;", "LZ2/F;", "coroutineScope", "LZ2/F;", "", "Lcom/stepos/alphame/common/data/DataStoreManager$DataStoreMetaData;", "mapDataStoreMetaData", "Ljava/util/Map;", "mapDataStore", "<init>", "()V", "DataStoreMetaData", "common_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataStoreManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreManager.kt\ncom/stepos/alphame/common/data/DataStoreManager\n+ 2 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n20#2:85\n20#2:86\n1#3:87\n*S KotlinDebug\n*F\n+ 1 DataStoreManager.kt\ncom/stepos/alphame/common/data/DataStoreManager\n*L\n61#1:85\n67#1:86\n*E\n"})
/* loaded from: classes.dex */
public final class DataStoreManager {

    @NotNull
    private static final String TAG = "DataStoreManager";

    @NotNull
    public static final DataStoreManager INSTANCE = new DataStoreManager();

    @NotNull
    private static final F coroutineScope = G.a(Q.f2190b.plus(I.b()));

    @NotNull
    private static final Map<String, DataStoreMetaData> mapDataStoreMetaData = MapsKt.mutableMapOf(TuplesKt.to("DataBuried", new DataStoreMetaData(CollectionsKt.emptyList())), TuplesKt.to("AgreementStatus", new DataStoreMetaData(CollectionsKt.emptyList())));

    @NotNull
    private static final Map<String, DataStorePreferences> mapDataStore = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00010\u0002¢\u0006\u0004\b\b\u0010\tR#\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/common/data/DataStoreManager$DataStoreMetaData;", "", "", "LV/h;", "produceMigrations", "Ljava/util/List;", "getProduceMigrations", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "common_release"}, k = 1, mv = {1, 9, 0})
    public static final class DataStoreMetaData {

        @NotNull
        private final List<Object> produceMigrations;

        /* JADX WARN: Multi-variable type inference failed */
        public DataStoreMetaData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final List<Object> getProduceMigrations() {
            return this.produceMigrations;
        }

        public DataStoreMetaData(@NotNull List<Object> produceMigrations) {
            Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
            this.produceMigrations = produceMigrations;
        }

        public /* synthetic */ DataStoreMetaData(List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    private DataStoreManager() {
    }

    @NotNull
    public final DataStorePreferences getDataStore(@NotNull final String dataStoreFileName, @NotNull final Context context) {
        Intrinsics.checkNotNullParameter(dataStoreFileName, "dataStoreFileName");
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, DataStoreMetaData> map = mapDataStoreMetaData;
        if (map.get(dataStoreFileName) == null) {
            Log.d(TAG, "no found the DataStoreMetaData：[" + dataStoreFileName + "]");
            synchronized (map) {
                try {
                    if (map.get(dataStoreFileName) == null) {
                        map.put(dataStoreFileName, new DataStoreMetaData(CollectionsKt.emptyList()));
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Map<String, DataStorePreferences> map2 = mapDataStore;
        DataStorePreferences dataStorePreferences = map2.get(dataStoreFileName);
        if (dataStorePreferences == null) {
            DataStoreMetaData dataStoreMetaData = map.get(dataStoreFileName);
            Intrinsics.checkNotNull(dataStoreMetaData);
            DataStoreMetaData dataStoreMetaData2 = dataStoreMetaData;
            synchronized (dataStoreMetaData2) {
                dataStorePreferences = map2.get(dataStoreFileName);
                if (dataStorePreferences == null) {
                    List<Object> migrations = dataStoreMetaData2.getProduceMigrations();
                    F scope = coroutineScope;
                    Function0<File> produceFile = new Function0<File>() { // from class: com.stepos.alphame.common.data.DataStoreManager$getDataStore$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final File invoke() {
                            return J.E(context, dataStoreFileName);
                        }
                    };
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(produceFile, "produceFile");
                    k serializer = k.f1927a;
                    e produceFile2 = new e(produceFile, 0);
                    Intrinsics.checkNotNullParameter(serializer, "serializer");
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    Intrinsics.checkNotNullParameter(produceFile2, "produceFile");
                    f fVar = new f();
                    Intrinsics.checkNotNullParameter(migrations, "migrations");
                    dataStorePreferences = new DataStorePreferences(new d(new M(produceFile2, CollectionsKt.listOf(new C0098d(migrations, null)), fVar, scope)));
                    map2.put(dataStoreFileName, dataStorePreferences);
                }
            }
        }
        return dataStorePreferences;
    }

    @NotNull
    public final DataStorePreferences getDataStore(@NotNull String dataStoreFileName) {
        Intrinsics.checkNotNullParameter(dataStoreFileName, "dataStoreFileName");
        return getDataStore(dataStoreFileName, BaseApplication.INSTANCE.getAppContext());
    }
}
