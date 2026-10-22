package com.stepos.alphame.dailyusage;

import B0.g;
import F1.n;
import Z2.AbstractC0123e0;
import Z2.C0125f0;
import Z2.F;
import Z2.G;
import Z2.I;
import android.content.Context;
import android.util.Log;
import androidx.annotation.WorkerThread;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.model.Response;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.common.utils.EventUtils;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import com.stepos.alphame.dailyusage.utils.DailyUsageRequestValidator;
import com.stepos.alphame.data.model.dailyusage.AppUsage;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.HourlyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.MultiDailyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.TimeUsageEntity;
import com.stepos.alphame.data.repo.DailyUsageRepository;
import com.stepos.alphame.data.repo.DefaultDailyUsageRepository;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.data.utils.DigitalHealthHelper;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.utils.Consts;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 J2\u00020\u0001:\nKJLMNOPQRSB\u0007¢\u0006\u0004\bI\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016JC\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J7\u0010%\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b%\u0010\u0016J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\b¢\u0006\u0004\b,\u0010\u001eJ\u001d\u00100\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b2\u0010 J\u001d\u00103\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b3\u0010 J\u001b\u00106\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000204¢\u0006\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010:\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006T"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService;", "Lcom/stepos/alphame/engine/EngineBase;", "", "from", "Lcom/stepos/alphame/data/model/dailyusage/MultiDailyUsageSummary;", "multi", "", "now", "", "logMultiFutureBuckets", "(Ljava/lang/String;Lcom/stepos/alphame/data/model/dailyusage/MultiDailyUsageSummary;J)V", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "summary", "logFutureHourBuckets", "(Ljava/lang/String;Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;J)V", "", "mode", "userId", "startTime", "endTime", "requestTime", "getMultiDailyUsageSummaryInner", "(IJJJJ)Ljava/lang/String;", "startDate", "endDate", "", "dailyUsageSummaries", "fillDailyUsageSummaryData", "(IJJJLjava/util/List;)Ljava/util/List;", "onStart", "()V", "getTodayUsageSummary", "(IJ)Ljava/lang/String;", "getCurrentMode", "()I", "getActiveMinorsId", "()J", "getMultiDailyUsageSummary", "", "isSupportMinorsMode", "()Z", "enable", "enableDigitalHealthFeature", "(Z)V", "clearDailyUsageData", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "content", "saveJsonAndGetUriString", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getTodayTimeRestrictedAppTimeUsages", "getTodayTimeRestrictedAppTimeUsagesByUri", "", "appList", "setTimeRestrictedAppList", "([Ljava/lang/String;)V", "Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "dailyUsageRepository$delegate", "Lkotlin/Lazy;", "getDailyUsageRepository", "()Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "dailyUsageRepository", "LZ2/e0;", "singleDispatcher", "LZ2/e0;", "LZ2/F;", "engineScope$delegate", "getEngineScope", "()LZ2/F;", "engineScope", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<init>", "Companion", "ClearDailyUsageData", "EnableDigitalHealthFeature", "GetActiveMinorsId", "GetCurrentMode", "GetTodayTimeRestrictedAppTimeUsages", "GetTodayTimeRestrictedAppTimeUsagesByUri", "GetTodayUsageSummary", "IsSupportMinorsMode", "SetTimeRestrictedAppList", "app_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDailyUsageEngineService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsageEngineService.kt\ncom/stepos/alphame/dailyusage/DailyUsageEngineService\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,585:1\n1855#2,2:586\n1569#2,11:588\n1864#2,2:599\n1866#2:602\n1580#2:603\n1477#2:604\n1502#2,3:605\n1505#2,3:615\n766#2:618\n857#2,2:619\n1#3:601\n372#4,7:608\n*S KotlinDebug\n*F\n+ 1 DailyUsageEngineService.kt\ncom/stepos/alphame/dailyusage/DailyUsageEngineService\n*L\n109#1:586,2\n117#1:588,11\n117#1:599,2\n117#1:602\n117#1:603\n314#1:604\n314#1:605,3\n314#1:615,3\n395#1:618\n395#1:619,2\n117#1:601\n314#1:608,7\n*E\n"})
/* loaded from: classes.dex */
public final class DailyUsageEngineService extends EngineBase {

    @NotNull
    public static final String ACTION_GET_MULTI_DAILY_USAGE_SUMMARY = "action_get_multi_daily_usage_summary";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<DailyUsageEngineService> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<DailyUsageEngineService>() { // from class: com.stepos.alphame.dailyusage.DailyUsageEngineService$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DailyUsageEngineService invoke() {
            return new DailyUsageEngineService();
        }
    });

    @NotNull
    public static final String TAG = "DailyUsageEngine";

    /* renamed from: dailyUsageRepository$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dailyUsageRepository;

    /* renamed from: engineScope$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy engineScope;

    @NotNull
    private final ReentrantReadWriteLock rwLock;

    @NotNull
    private final AbstractC0123e0 singleDispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$ClearDailyUsageData;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClearDailyUsageData extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearDailyUsageData(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "clearDailyUsageData";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"清除dailyUsage所有數據"};
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$Companion;", "", "()V", "ACTION_GET_MULTI_DAILY_USAGE_SUMMARY", "", "INSTANCE", "Lcom/stepos/alphame/dailyusage/DailyUsageEngineService;", "getINSTANCE", "()Lcom/stepos/alphame/dailyusage/DailyUsageEngineService;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DailyUsageEngineService getINSTANCE() {
            return (DailyUsageEngineService) DailyUsageEngineService.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$EnableDigitalHealthFeature;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EnableDigitalHealthFeature extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnableDigitalHealthFeature(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "enableDigitalHealthFeature";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{"enable"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"关闭数据健康"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$GetActiveMinorsId;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetActiveMinorsId extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetActiveMinorsId(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getActiveMinorsId";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 5;
            this.annotation = new String[]{"获取当前用户id"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$GetCurrentMode;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetCurrentMode extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCurrentMode(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getCurrentMode";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"获取当前模式"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$GetTodayTimeRestrictedAppTimeUsages;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetTodayTimeRestrictedAppTimeUsages extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTodayTimeRestrictedAppTimeUsages(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getTodayTimeRestrictedAppTimeUsages";
            this.argsType = new byte[]{4, 5};
            this.argsName = new String[]{"mode", "userId"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取今天受限应用的使用条目", "@param mode 用户模式", "@param userId 用户id", "@return 今天受限应用的使用条目"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$GetTodayTimeRestrictedAppTimeUsagesByUri;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetTodayTimeRestrictedAppTimeUsagesByUri extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTodayTimeRestrictedAppTimeUsagesByUri(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getTodayTimeRestrictedAppTimeUsagesByUri";
            this.argsType = new byte[]{4, 5};
            this.argsName = new String[]{"mode", "userId"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取今天受限应用的使用条目", "@param mode 用户模式", "@param userId 用户id", "@return 今天受限应用的使用条目"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$GetTodayUsageSummary;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetTodayUsageSummary extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTodayUsageSummary(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "getTodayUsageSummary";
            this.argsType = new byte[]{4, 5};
            this.argsName = new String[]{"mode", "userId"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取当天使用总览", "@param mode 用户模式", "@param userId 用户id", "@return 使用总览"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$IsSupportMinorsMode;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class IsSupportMinorsMode extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IsSupportMinorsMode(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "isSupportMinorsMode";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"是否支持未成年人模式", "@return 是否支持"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageEngineService$SetTimeRestrictedAppList;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetTimeRestrictedAppList extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetTimeRestrictedAppList(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = "setTimeRestrictedAppList";
            this.argsType = new byte[]{9};
            this.argsName = new String[]{"appList"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置受限应用列表", "@param appList 受限应用列表", "@return 无"};
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.DailyUsageEngineService$clearDailyUsageData$1", f = "DailyUsageEngineService.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.DailyUsageEngineService$clearDailyUsageData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DailyUsageEngineService.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DailyUsageRepository dailyUsageRepository = DailyUsageEngineService.this.getDailyUsageRepository();
                this.label = 1;
                if (dailyUsageRepository.clearDailyUsage(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public DailyUsageEngineService() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.dailyUsageRepository = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DefaultDailyUsageRepository>() { // from class: com.stepos.alphame.dailyusage.DailyUsageEngineService$dailyUsageRepository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DefaultDailyUsageRepository invoke() {
                return DefaultDailyUsageRepository.Companion.getINSTANCE();
            }
        });
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a(0));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.singleDispatcher = new C0125f0(executorServiceNewSingleThreadExecutor);
        this.engineScope = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<F>() { // from class: com.stepos.alphame.dailyusage.DailyUsageEngineService$engineScope$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final F invoke() {
                return G.a(this.this$0.singleDispatcher.plus(I.b()));
            }
        });
        this.rwLock = new ReentrantReadWriteLock();
    }

    private final List<DailyUsageSummary> fillDailyUsageSummaryData(int mode, long userId, long startDate, long endDate, List<DailyUsageSummary> dailyUsageSummaries) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : dailyUsageSummaries) {
            Long lValueOf = Long.valueOf(((DailyUsageSummary) obj).getDate());
            Object arrayList2 = linkedHashMap.get(lValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        long progressionLastElement = ProgressionUtilKt.getProgressionLastElement(startDate, endDate, 86400000L);
        if (startDate <= progressionLastElement) {
            long j4 = startDate;
            while (true) {
                List list = (List) linkedHashMap.get(Long.valueOf(j4));
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    arrayList.add(new DailyUsageSummary(j4, mode, userId, 0L, 0L, 0, 0, new ArrayList(), new ArrayList()));
                } else {
                    arrayList.add(list.get(0));
                }
                if (j4 == progressionLastElement) {
                    break;
                }
                j4 += 86400000;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailyUsageRepository getDailyUsageRepository() {
        return (DailyUsageRepository) this.dailyUsageRepository.getValue();
    }

    private final F getEngineScope() {
        return (F) this.engineScope.getValue();
    }

    private final String getMultiDailyUsageSummaryInner(int mode, long userId, long startTime, long endTime, long requestTime) {
        long baseTimeMill = TimeUtils.getBaseTimeMill(startTime);
        long baseTimeMill2 = TimeUtils.getBaseTimeMill(endTime);
        n nVar = new n();
        Response response = new Response();
        List<DailyUsageSummary> multiDailyUsageSummary = getDailyUsageRepository().getMultiDailyUsageSummary(mode, userId, baseTimeMill, baseTimeMill2);
        MultiDailyUsageSummary multiDailyUsageSummary2 = new MultiDailyUsageSummary(new ArrayList(), requestTime);
        multiDailyUsageSummary2.getDailyUsageSummaries().addAll(fillDailyUsageSummaryData(mode, userId, baseTimeMill, baseTimeMill2, multiDailyUsageSummary));
        response.success();
        response.setResult(multiDailyUsageSummary2);
        Log.d(TAG, "getMultiDailyUsageSummaryInner  mode is " + mode + "   userid is " + userId);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size = multiDailyUsageSummary2.getDailyUsageSummaries().size();
        for (int i4 = 0; i4 < size; i4++) {
            DailyUsageSummary dailyUsageSummary = multiDailyUsageSummary2.getDailyUsageSummaries().get(i4);
            String dateDay = TimeUtilsKt.formatDateDay(dailyUsageSummary.getDate());
            String duration = TimeUtilsKt.formatDuration(dailyUsageSummary.getDailyUsedTime());
            List<AppUsage> appDailyUsages = dailyUsageSummary.getAppDailyUsages();
            StringBuilder sbX = g.x("date is ", dateDay, "    usedTime is ", duration, "    appDailyUsages:");
            sbX.append(appDailyUsages);
            Log.d(TAG, sbX.toString());
            logFutureHourBuckets("getMultiDailyUsageSummaryInner", dailyUsageSummary, jCurrentTimeMillis);
        }
        String strG = nVar.g(response);
        Intrinsics.checkNotNull(strG);
        return strG;
    }

    private final void logFutureHourBuckets(String from, DailyUsageSummary summary, long now) {
        if (summary == null) {
            return;
        }
        long baseTimeMill = TimeUtils.getBaseTimeMill(now);
        if (summary.getDate() != baseTimeMill) {
            return;
        }
        int i4 = (int) ((now - baseTimeMill) / 3600000);
        List<HourlyUsageSummary> hourlyUsageSummaries = summary.getHourlyUsageSummaries();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : hourlyUsageSummaries) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HourlyUsageSummary hourlyUsageSummary = (HourlyUsageSummary) obj;
            String str = (i5 <= i4 || hourlyUsageSummary.getHourlyUsageTime() <= 0) ? null : "h" + i5 + Consts.SPLITTER_EQUAL + TimeUtilsKt.formatDuration(hourlyUsageSummary.getHourlyUsageTime());
            if (str != null) {
                arrayList.add(str);
            }
            i5 = i6;
        }
        String dateYear = TimeUtilsKt.formatDateYear(now);
        String duration = TimeUtilsKt.formatDuration(summary.getDailyUsedTime());
        String duration2 = TimeUtilsKt.formatDuration(summary.getMaximumUsageTime());
        String strJoinToString$default = arrayList.isEmpty() ? "NONE" : CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
        StringBuilder sbX = g.x("FUTURE_CHECK[", from, "] now=", dateYear, " curHour=");
        sbX.append(i4);
        sbX.append(" daily=");
        sbX.append(duration);
        sbX.append(" max=");
        sbX.append(duration2);
        sbX.append(" futureBuckets=");
        sbX.append(strJoinToString$default);
        Log.d(TAG, sbX.toString());
    }

    private final void logMultiFutureBuckets(String from, MultiDailyUsageSummary multi, long now) {
        Iterator<T> it = multi.getDailyUsageSummaries().iterator();
        while (it.hasNext()) {
            logFutureHourBuckets(from, (DailyUsageSummary) it.next(), now);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleDispatcher$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "dailyUsageEngineService");
        thread.setDaemon(true);
        return thread;
    }

    public final void clearDailyUsageData() {
        J.y(getEngineScope(), null, new AnonymousClass1(null), 3);
    }

    public final void enableDigitalHealthFeature(boolean enable) {
        DigitalHealthHelper.INSTANCE.setDigitalHealthFeatureEnableStatus(enable);
        if (enable) {
            return;
        }
        DailyUsageMessageHelperKt.sendDailyUsageDataClearMessage(0, -1L, System.currentTimeMillis());
    }

    public final long getActiveMinorsId() {
        return DigitalHealthHelper.INSTANCE.getActiveMinorsId(BaseApplication.INSTANCE.getAppContext());
    }

    public final int getCurrentMode() {
        return DigitalHealthHelper.INSTANCE.getCurrentMode(BaseApplication.INSTANCE.getAppContext());
    }

    @WorkerThread
    @NotNull
    public final String getMultiDailyUsageSummary(int mode, long userId, long startTime, long endTime, long requestTime) {
        Log.d(TAG, "invoke getMultiDailyUsageSummary , " + mode + " userId " + userId + " startDate " + TimeUtilsKt.formatDateYear(startTime) + " endDate " + TimeUtilsKt.formatDateYear(endTime));
        n nVar = new n();
        Response response = new Response();
        Pair<Integer, String> pairValidateParameter = DailyUsageRequestValidator.INSTANCE.validateParameter(mode, userId, startTime, endTime);
        if (pairValidateParameter.getFirst().intValue() != 200) {
            response.error(pairValidateParameter.getFirst().intValue(), pairValidateParameter.getSecond());
            String strG = nVar.g(response);
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        long baseTimeMill = TimeUtils.getBaseTimeMill(startTime);
        long baseTimeMill2 = TimeUtils.getBaseTimeMill(endTime);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long baseTimeMill3 = TimeUtils.getBaseTimeMill(jCurrentTimeMillis);
        MultiDailyUsageSummary multiDailyUsageSummary = new MultiDailyUsageSummary(new ArrayList(), requestTime);
        if (baseTimeMill == baseTimeMill2 && baseTimeMill3 == baseTimeMill) {
            DailyUsageSummary todayUsageSummary = getDailyUsageRepository().getTodayUsageSummary(mode, userId);
            Log.d(TAG, "todaySummary  is   " + todayUsageSummary);
            logFutureHourBuckets("getMultiDailyUsageSummary.today", todayUsageSummary, jCurrentTimeMillis);
            if (todayUsageSummary != null) {
                multiDailyUsageSummary.getDailyUsageSummaries().add(todayUsageSummary);
            }
            response.success();
            response.setResult(multiDailyUsageSummary);
            String strG2 = nVar.g(response);
            Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
            getDailyUsageRepository().saveDailyUsages();
            return strG2;
        }
        getDailyUsageRepository().saveDailyUsages();
        long firstUpgradeTime = DailyUsageLegacyMigrationHandlerKt.getFirstUpgradeTime();
        String dateYear = TimeUtilsKt.formatDateYear(firstUpgradeTime);
        String dateYear2 = TimeUtilsKt.formatDateYear(startTime);
        String dateYear3 = TimeUtilsKt.formatDateYear(endTime);
        String dateYear4 = TimeUtilsKt.formatDateYear(requestTime);
        StringBuilder sbX = g.x("upgradeTime ", dateYear, " startTime ", dateYear2, " endTime ");
        sbX.append(dateYear3);
        sbX.append(" requestTime ");
        sbX.append(dateYear4);
        Log.d(TAG, sbX.toString());
        if (mode == 0 && firstUpgradeTime > startTime) {
            long baseTimeMill4 = TimeUtils.getBaseTimeMill(firstUpgradeTime);
            long j4 = baseTimeMill4 + 86400000;
            MultiDailyUsageSummary multiDailySummaryFromUserBehavior = DailyUsageLegacyMigrationHandlerKt.getMultiDailySummaryFromUserBehavior(startTime, baseTimeMill4 - 86400000, false);
            MultiDailyUsageSummary userBehaviorDataInUpgradeDate = DailyUsageLegacyMigrationHandlerKt.getUserBehaviorDataInUpgradeDate();
            List<DailyUsageSummary> multiDailyUsageSummary2 = getDailyUsageRepository().getMultiDailyUsageSummary(mode, userId, baseTimeMill4, baseTimeMill4);
            DailyUsageSummary dailyUsageSummaryMergeDailyUsageSummaryInUpgradeDate = (userBehaviorDataInUpgradeDate.getDailyUsageSummaries().isEmpty() && (multiDailyUsageSummary2.isEmpty() ^ true)) ? multiDailyUsageSummary2.get(0) : ((userBehaviorDataInUpgradeDate.getDailyUsageSummaries().isEmpty() ^ true) && (multiDailyUsageSummary2.isEmpty() ^ true)) ? DailyUsageLegacyMigrationHandlerKt.mergeDailyUsageSummaryInUpgradeDate(userBehaviorDataInUpgradeDate.getDailyUsageSummaries().get(0), multiDailyUsageSummary2.get(0)) : userBehaviorDataInUpgradeDate.getDailyUsageSummaries().isEmpty() ^ true ? userBehaviorDataInUpgradeDate.getDailyUsageSummaries().get(0) : null;
            List<DailyUsageSummary> multiDailyUsageSummary3 = getDailyUsageRepository().getMultiDailyUsageSummary(mode, userId, j4, baseTimeMill2);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(multiDailySummaryFromUserBehavior.getDailyUsageSummaries());
            if (dailyUsageSummaryMergeDailyUsageSummaryInUpgradeDate != null) {
                arrayList.add(dailyUsageSummaryMergeDailyUsageSummaryInUpgradeDate);
            }
            arrayList.addAll(multiDailyUsageSummary3);
            multiDailyUsageSummary.getDailyUsageSummaries().addAll(fillDailyUsageSummaryData(mode, userId, baseTimeMill, baseTimeMill2, arrayList));
            logMultiFutureBuckets("getMultiDailyUsageSummary.upgradeMerge", multiDailyUsageSummary, jCurrentTimeMillis);
            response.success();
            response.setResult(multiDailyUsageSummary);
            String strG3 = nVar.g(response);
            Intrinsics.checkNotNullExpressionValue(strG3, "toJson(...)");
            return strG3;
        }
        return getMultiDailyUsageSummaryInner(mode, userId, startTime, endTime, requestTime);
    }

    @NotNull
    public final String getTodayTimeRestrictedAppTimeUsages(int mode, long userId) {
        Response response = new Response();
        List<TimeUsageEntity> todayTimeRestrictedAppTimeUsages = getDailyUsageRepository().getTodayTimeRestrictedAppTimeUsages(mode, userId);
        response.success();
        response.setResult(todayTimeRestrictedAppTimeUsages);
        String strG = new n().g(response);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (Object obj : todayTimeRestrictedAppTimeUsages) {
            TimeUsageEntity timeUsageEntity = (TimeUsageEntity) obj;
            if (timeUsageEntity.getStartTime() > jCurrentTimeMillis || timeUsageEntity.getEndTime() > jCurrentTimeMillis) {
                arrayList.add(obj);
            }
        }
        Log.w(TAG, "FUTURE_CHECK[restricted] now=" + TimeUtilsKt.formatDateYear(jCurrentTimeMillis) + " total=" + todayTimeRestrictedAppTimeUsages.size() + " futureCount=" + arrayList.size() + AwarenessDataItem.PERMISSION_SPLITTER + CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<TimeUsageEntity, CharSequence>() { // from class: com.stepos.alphame.dailyusage.DailyUsageEngineService.getTodayTimeRestrictedAppTimeUsages.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TimeUsageEntity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getPackageName() + "(" + TimeUtilsKt.formatDateYear(it.getStartTime()) + "->" + TimeUtilsKt.formatDateYear(it.getEndTime()) + ")";
            }
        }, 31, null));
        StringBuilder sb = new StringBuilder("getTodayTimeRestrictedAppTimeUsages, ");
        sb.append(strG);
        Log.d(TAG, sb.toString());
        Intrinsics.checkNotNull(strG);
        return strG;
    }

    @NotNull
    public final String getTodayTimeRestrictedAppTimeUsagesByUri(int mode, long userId) {
        Response response = new Response();
        List<TimeUsageEntity> todayTimeRestrictedAppTimeUsages = getDailyUsageRepository().getTodayTimeRestrictedAppTimeUsages(mode, userId);
        response.success();
        response.setResult(todayTimeRestrictedAppTimeUsages);
        String strG = new n().g(response);
        Log.d(TAG, "getTodayTimeRestrictedAppTimeUsagesByUri, " + strG);
        Context applicationContext = ApplicationImpl.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intrinsics.checkNotNull(strG);
        return saveJsonAndGetUriString(applicationContext, strG);
    }

    @NotNull
    public final String getTodayUsageSummary(int mode, long userId) {
        DailyUsageSummary todayUsageSummary = getDailyUsageRepository().getTodayUsageSummary(mode, userId);
        logFutureHourBuckets("getTodayUsageSummary", todayUsageSummary, System.currentTimeMillis());
        String strG = new n().g(todayUsageSummary);
        Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
        return strG;
    }

    public final boolean isSupportMinorsMode() {
        return DailyUsageLegacyMigrationHandlerKt.getFirstUpgradeTime() != 0;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new IsSupportMinorsMode(this));
        EngineBase.addFunc(new EnableDigitalHealthFeature(this));
        EngineBase.addFunc(new ClearDailyUsageData(this));
        EngineBase.addFunc(new GetCurrentMode(this));
        EngineBase.addFunc(new GetActiveMinorsId(this));
        EngineBase.addFunc(new GetTodayUsageSummary(this));
        EngineBase.addFunc(new GetTodayTimeRestrictedAppTimeUsages(this));
        EngineBase.addFunc(new GetTodayTimeRestrictedAppTimeUsagesByUri(this));
        EngineBase.addFunc(new SetTimeRestrictedAppList(this));
        if (DailyUsageLegacyMigrationHandlerKt.getFirstUpgradeTime() == 0) {
            Log.d(TAG, "starting upgrade");
            long jCurrentTimeMillis = System.currentTimeMillis();
            DailyUsageLegacyMigrationHandlerKt.migrateUserBehaviorDataWhenUpgrade(jCurrentTimeMillis);
            DailyUsageLegacyMigrationHandlerKt.saveUpgradeTimeWhenFirstUpgrade(jCurrentTimeMillis);
            DailyUsageMessageHelperKt.sendDailyUsageScreenMessage(EventUtils.SCREEN_ON, jCurrentTimeMillis);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock] */
    @NotNull
    public final String saveJsonAndGetUriString(@NotNull Context context, @NotNull String content) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        Log.d(TAG, "quey  saveJsonAndGetUriString start      " + System.currentTimeMillis());
        this.rwLock.writeLock().lock();
        try {
            try {
                FilesKt__FileReadWriteKt.writeText$default(new File(context.getFilesDir(), "my_data.json"), content, null, 2, null);
                str = "content://com.stepos.alphame.dailyusage.restrictprovider/my_data.json";
                Log.d(TAG, "file saved，URI is: content://com.stepos.alphame.dailyusage.restrictprovider/my_data.json");
                Log.d(TAG, "quey  saveJsonAndGetUriString end      " + System.currentTimeMillis());
            } catch (Exception e4) {
                e4.printStackTrace();
                str = "";
            }
            return str;
        } finally {
            Log.d(TAG, "release lock");
            this.rwLock.writeLock().unlock();
        }
    }

    public final void setTimeRestrictedAppList(@NotNull String[] appList) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        getDailyUsageRepository().setTimeRestrictedAppList(ArraysKt.toList(appList));
        Log.d(TAG, "setTimeRestrictedAppList");
    }
}
