package com.stepos.alphame.data.repo;

import B0.g;
import F1.n;
import Z2.A;
import Z2.F;
import Z2.Q;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.google.gson.reflect.TypeToken;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.common.utils.TimeUtils;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.data.local.database.CommonRoomDatabase;
import com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao;
import com.stepos.alphame.data.model.dailyusage.DailyUsage;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntity;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntityKt;
import com.stepos.alphame.data.model.dailyusage.DailyUsageKt;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummaryKt;
import com.stepos.alphame.data.model.dailyusage.NotificationUsage;
import com.stepos.alphame.data.model.dailyusage.ScreenUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsageEntity;
import com.stepos.alphame.data.model.dailyusage.TimeUsageType;
import com.stepos.alphame.data.utils.DigitalHealthHelper;
import com.stepos.alphame.model.event.DailyUsageAudioMessage;
import com.stepos.alphame.model.event.DailyUsageMessage;
import com.stepos.alphame.model.event.DailyUsageMzWindowMessage;
import com.stepos.alphame.model.event.DailyUsageScreenMessage;
import com.stepos.alphame.model.event.DailyUsageWindowMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s.AbstractC0831a;
import t0.J;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B\u0019\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u0010y\u001a\u00020x¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J/\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110*2\u0006\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010.J\u0017\u00105\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010.J\u0017\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0017H\u0016¢\u0006\u0004\b>\u0010?J\u001d\u0010@\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BH\u0096@¢\u0006\u0004\bC\u0010DJ\u0018\u0010G\u001a\u00020\u00022\u0006\u0010F\u001a\u00020EH\u0096@¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020BH\u0017¢\u0006\u0004\bI\u0010JJ \u0010K\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\u0002H\u0096@¢\u0006\u0004\bM\u0010DJ\u0010\u0010N\u001a\u00020\u0002H\u0096@¢\u0006\u0004\bN\u0010DJ5\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0*2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0017¢\u0006\u0004\bR\u0010SJ!\u0010T\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010UJ%\u0010W\u001a\b\u0012\u0004\u0012\u00020V0*2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000f0*H\u0016¢\u0006\u0004\bY\u0010ZJ\u001d\u0010\\\u001a\u00020\u00022\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0*H\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020B2\u0006\u0010^\u001a\u00020\u000fH\u0016¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u0011H\u0002¢\u0006\u0004\bb\u0010cJ'\u0010d\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u0002H\u0002¢\u0006\u0004\bf\u0010\u0004J\u000f\u0010g\u001a\u00020\u0002H\u0002¢\u0006\u0004\bg\u0010\u0004J\u001f\u0010h\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00072\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bh\u0010iJ\u001f\u0010k\u001a\u00020B2\u0006\u0010j\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020B2\u0006\u0010^\u001a\u00020\u000fH\u0002¢\u0006\u0004\bm\u0010`J\u0017\u0010n\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u0011H\u0002¢\u0006\u0004\bn\u0010cJ\u0017\u0010p\u001a\u00020E2\u0006\u0010o\u001a\u00020\u0017H\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010s\u001a\u00020\u00172\u0006\u0010r\u001a\u00020EH\u0002¢\u0006\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001c\u0010\u0080\u0001\u001a\u00020{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f¨\u0006\u0084\u0001"}, d2 = {"Lcom/stepos/alphame/data/repo/DefaultDailyUsageRepository;", "Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "", "onInit", "()V", "", "mode", "", "userId", "setUserInfo", "(IJ)V", "getCurrentUserMode", "()I", "getCurrentUserId", "()J", "", Action.KEY_ATTRIBUTE, "Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "getTimeUsage", "(Ljava/lang/String;)Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "Ljava/util/concurrent/ConcurrentHashMap;", "getTimeUsageMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "getDailyUsageMap", "clearTodayDailyUsage", "removeTimeUsage", "(Ljava/lang/String;)V", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "dailyUsageEvent", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageType;", "timeUsageType", "setTimeUsageWhenRunning", "(Lcom/stepos/alphame/model/event/DailyUsageMessage;Lcom/stepos/alphame/data/model/dailyusage/TimeUsageType;)V", "endTimeUsage", "endTime", "setTimeUsageWhenRunningEnd", "(Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;J)V", "triggerTime", "endRunningTimeUsages", "(JIJLcom/stepos/alphame/model/event/DailyUsageMessage;)V", "currentTime", "", "getRunningTimeUsagesUntilCurrentTime", "(J)Ljava/util/List;", "resetRunningTimeUsages", "(J)V", "boundaryTime", "restartTime", "splitRunningTimeUsagesAtJump", "(JJ)V", "now", "clampTodayUsagesToWallClock", "restartFutureRunningTimeUsages", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsage;", "screenUsage", "addScreenUsage", "(Lcom/stepos/alphame/data/model/dailyusage/ScreenUsage;)V", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;", "notificationUsage", "addNotificationUsage", "(Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;)V", "getCurrentDailyUsage", "()Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "getUserDailyUsage", "(IJ)Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "", "restoreDailyUsage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "dailyUsageEntity", "insertDailyUsage", "(Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDailyUsages", "()Z", "deleteDailyUsage", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDailyUsage", "clearData", "startDate", "endDate", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "getMultiDailyUsageSummary", "(IJJJ)Ljava/util/List;", "getTodayUsageSummary", "(IJ)Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "getTodayTimeRestrictedAppTimeUsages", "(IJ)Ljava/util/List;", "getTimeRestrictedAppList", "()Ljava/util/List;", "dataList", "setTimeRestrictedAppList", "(Ljava/util/List;)V", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "isInTimeRestrictedAppList", "(Ljava/lang/String;)Z", "timeUsage", "addTimeUsage", "(Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;)V", "addUserTimeUsage", "(Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;IJ)V", "tryCleanupOldData", "setTimeRestrictedAppListInner", "addRunningTimeUsageInTodayDailyUsage", "(JLcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;)V", "date", "isToday", "(JJ)Z", "isRunningAppEnd", "sendAppEventBroadcast", "dailyUsage", "convertToEntityAndSaveFiles", "(Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;)Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "entity", "convertEntityToDailyUsageAndReadFiles", "(Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;)Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "LZ2/A;", "coroutineDispatcher", "LZ2/A;", "Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;", "dailyUsageDao", "Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;", "Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "<init>", "(LZ2/A;Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;)V", "Companion", "data_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDefaultDailyUsageRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDailyUsageRepository.kt\ncom/stepos/alphame/data/repo/DefaultDailyUsageRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,722:1\n1855#2,2:723\n1549#2:725\n1620#2,3:726\n1855#2,2:729\n1855#2,2:731\n1549#2:733\n1620#2,3:734\n1549#2:737\n1620#2,3:738\n*S KotlinDebug\n*F\n+ 1 DefaultDailyUsageRepository.kt\ncom/stepos/alphame/data/repo/DefaultDailyUsageRepository\n*L\n394#1:723,2\n420#1:725\n420#1:726,3\n468#1:729,2\n526#1:731,2\n668#1:733\n668#1:734,3\n705#1:737\n705#1:738,3\n*E\n"})
/* loaded from: classes.dex */
public final class DefaultDailyUsageRepository implements DailyUsageRepository {
    private static final long CLEANUP_INTERVAL_MS = 604800000;

    @NotNull
    private static final String KEY_LAST_CLEANUP_TIME = "key_last_cleanup_timestamp";
    private static final long MAX_SAFE_TIME_JUMP = 5184000000L;
    private static final long RETENTION_PERIOD_MS = 2592000000L;

    @NotNull
    public static final String TAG = "DefaultDailyUsageRepository";
    private static volatile int currentUserMode;

    /* renamed from: context$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy context;

    @NotNull
    private final A coroutineDispatcher;

    @NotNull
    private final DailyUsageDao dailyUsageDao;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<DefaultDailyUsageRepository> INSTANCE$delegate = LazyKt.lazy(new Function0<DefaultDailyUsageRepository>() { // from class: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DefaultDailyUsageRepository invoke() {
            return new DefaultDailyUsageRepository(Q.f2190b, CommonRoomDatabase.INSTANCE.getInstance(BaseApplication.INSTANCE.getAppContext()).getDailyUsageDao());
        }
    });

    @NotNull
    private static final ConcurrentHashMap<String, DailyUsage> dailyUsageMap = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, TimeUsage> timeUsageMap = new ConcurrentHashMap<>();
    private static volatile long currentUserId = -1;

    @NotNull
    private static final ArrayList<String> timeRestrictedAppList = new ArrayList<>();

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0002R\u0018\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0002R&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0002R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001e0\u00168\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0002¨\u0006 "}, d2 = {"Lcom/stepos/alphame/data/repo/DefaultDailyUsageRepository$Companion;", "", "()V", "CLEANUP_INTERVAL_MS", "", "INSTANCE", "Lcom/stepos/alphame/data/repo/DefaultDailyUsageRepository;", "getINSTANCE", "()Lcom/stepos/alphame/data/repo/DefaultDailyUsageRepository;", "INSTANCE$delegate", "Lkotlin/Lazy;", "KEY_LAST_CLEANUP_TIME", "", "MAX_SAFE_TIME_JUMP", "RETENTION_PERIOD_MS", "TAG", "currentUserId", "getCurrentUserId$annotations", "currentUserMode", "", "getCurrentUserMode$annotations", "dailyUsageMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "getDailyUsageMap$annotations", "timeRestrictedAppList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTimeRestrictedAppList$annotations", "timeUsageMap", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "getTimeUsageMap$annotations", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getCurrentUserId$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getCurrentUserMode$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getDailyUsageMap$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getTimeRestrictedAppList$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getTimeUsageMap$annotations() {
        }

        @NotNull
        public final DefaultDailyUsageRepository getINSTANCE() {
            return (DefaultDailyUsageRepository) DefaultDailyUsageRepository.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)I"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.data.repo.DefaultDailyUsageRepository$clearDailyUsage$2", f = "DefaultDailyUsageRepository.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$clearDailyUsage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<F, Continuation<? super Integer>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageRepository.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Integer> continuation) {
            return ((AnonymousClass2) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DailyUsageDao dailyUsageDao = DefaultDailyUsageRepository.this.dailyUsageDao;
                this.label = 1;
                obj = dailyUsageDao.clearDailyUsage(0, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxInt(Log.i(DefaultDailyUsageRepository.TAG, "clear daily usage data in normal, row " + ((Number) obj).intValue()));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.data.repo.DefaultDailyUsageRepository$clearData$2", f = "DefaultDailyUsageRepository.kt", i = {}, l = {511}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$clearData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04732 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public C04732(Continuation<? super C04732> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageRepository.this.new C04732(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04732) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DailyUsageDao dailyUsageDao = DefaultDailyUsageRepository.this.dailyUsageDao;
                this.label = 1;
                if (dailyUsageDao.clearData(this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.data.repo.DefaultDailyUsageRepository$deleteDailyUsage$2", f = "DefaultDailyUsageRepository.kt", i = {}, l = {497}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nDefaultDailyUsageRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDailyUsageRepository.kt\ncom/stepos/alphame/data/repo/DefaultDailyUsageRepository$deleteDailyUsage$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,722:1\n1855#2,2:723\n*S KotlinDebug\n*F\n+ 1 DefaultDailyUsageRepository.kt\ncom/stepos/alphame/data/repo/DefaultDailyUsageRepository$deleteDailyUsage$2\n*L\n491#1:723,2\n*E\n"})
    /* renamed from: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$deleteDailyUsage$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04742 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $mode;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04742(int i4, long j4, Continuation<? super C04742> continuation) {
            super(2, continuation);
            this.$mode = i4;
            this.$userId = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageRepository.this.new C04742(this.$mode, this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04742) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                List<DailyUsageEntity> userDailyUsages = DefaultDailyUsageRepository.this.dailyUsageDao.getUserDailyUsages(this.$mode, this.$userId, 0L, LongCompanionObject.MAX_VALUE);
                if (userDailyUsages != null) {
                    for (DailyUsageEntity dailyUsageEntity : userDailyUsages) {
                        DailyUsageFileHelper dailyUsageFileHelper = DailyUsageFileHelper.INSTANCE;
                        dailyUsageFileHelper.deleteFile(dailyUsageEntity.getTimeUsagePath());
                        dailyUsageFileHelper.deleteFile(dailyUsageEntity.getScreenUsagePath());
                        dailyUsageFileHelper.deleteFile(dailyUsageEntity.getNotificationUsagePath());
                    }
                }
                DailyUsageDao dailyUsageDao = DefaultDailyUsageRepository.this.dailyUsageDao;
                long j4 = this.$userId;
                this.label = 1;
                obj = dailyUsageDao.deleteDailyUsage(j4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            int iIntValue = ((Number) obj).intValue();
            Log.d(DefaultDailyUsageRepository.TAG, "delete daily usage mode " + this.$mode + " userId " + this.$userId + " row " + iIntValue);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.data.repo.DefaultDailyUsageRepository$insertDailyUsage$2", f = "DefaultDailyUsageRepository.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$insertDailyUsage$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04752 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ DailyUsageEntity $dailyUsageEntity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04752(DailyUsageEntity dailyUsageEntity, Continuation<? super C04752> continuation) {
            super(2, continuation);
            this.$dailyUsageEntity = dailyUsageEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDailyUsageRepository.this.new C04752(this.$dailyUsageEntity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04752) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Log.e(DefaultDailyUsageRepository.TAG, "Direct insertDailyUsage is risky if containing big list. Use saveDailyUsages() instead.");
                DailyUsageDao dailyUsageDao = DefaultDailyUsageRepository.this.dailyUsageDao;
                DailyUsageEntity dailyUsageEntity = this.$dailyUsageEntity;
                this.label = 1;
                if (dailyUsageDao.insertDailyUsage(dailyUsageEntity, this) == coroutine_suspended) {
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

    public DefaultDailyUsageRepository(@NotNull A coroutineDispatcher, @NotNull DailyUsageDao dailyUsageDao) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(dailyUsageDao, "dailyUsageDao");
        this.coroutineDispatcher = coroutineDispatcher;
        this.dailyUsageDao = dailyUsageDao;
        this.context = LazyKt.lazy(new Function0<Context>() { // from class: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$context$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Context invoke() {
                return BaseApplication.INSTANCE.getAppContext();
            }
        });
    }

    private final void addRunningTimeUsageInTodayDailyUsage(long currentTime, DailyUsageEntity dailyUsageEntity) {
        Iterator<TimeUsage> it = getRunningTimeUsagesUntilCurrentTime(currentTime).iterator();
        while (it.hasNext()) {
            TimeUsageEntity timeUsageEntityAsEntity = DailyUsageKt.asEntity(it.next());
            dailyUsageEntity.getTimeUsages().add(timeUsageEntityAsEntity);
            Log.d(TAG, "addRunningTimeUsageInTodayDailyUsage  " + timeUsageEntityAsEntity.getPackageName() + "   " + timeUsageEntityAsEntity.getStartTime() + "   " + timeUsageEntityAsEntity.getEndTime());
        }
    }

    private final void addTimeUsage(TimeUsage timeUsage) {
        DailyUsage currentDailyUsage = getCurrentDailyUsage();
        Log.d(TAG, "add time usage mode " + currentDailyUsage.getMode() + " user id " + currentDailyUsage.getUserId() + "  starttime " + timeUsage.getStartTime() + "  endtime " + timeUsage.getEndTime() + "  ");
        currentDailyUsage.getTimeUsages().add(timeUsage);
    }

    private final void addUserTimeUsage(TimeUsage timeUsage, int mode, long userId) {
        getUserDailyUsage(mode, userId).getTimeUsages().add(timeUsage);
    }

    private final DailyUsage convertEntityToDailyUsageAndReadFiles(DailyUsageEntity entity) {
        DailyUsage dailyUsage = new DailyUsage(entity.getDate(), entity.getMode(), entity.getUserId(), null, null, null, 56, null);
        ArrayList listFromFile = DailyUsageFileHelper.INSTANCE.readListFromFile(entity.getTimeUsagePath(), TimeUsageEntity.class);
        List<TimeUsage> timeUsages = dailyUsage.getTimeUsages();
        ArrayList arrayList = new ArrayList(CollectionsKt.e(listFromFile));
        Iterator it = listFromFile.iterator();
        while (it.hasNext()) {
            arrayList.add(DailyUsageKt.asTimeUsage((TimeUsageEntity) it.next()));
        }
        timeUsages.addAll(arrayList);
        DailyUsageFileHelper dailyUsageFileHelper = DailyUsageFileHelper.INSTANCE;
        dailyUsage.getScreenUsages().addAll(dailyUsageFileHelper.readListFromFile(entity.getScreenUsagePath(), ScreenUsage.class));
        dailyUsage.getNotificationUsages().addAll(dailyUsageFileHelper.readListFromFile(entity.getNotificationUsagePath(), NotificationUsage.class));
        return dailyUsage;
    }

    private final DailyUsageEntity convertToEntityAndSaveFiles(DailyUsage dailyUsage) {
        String strP = AbstractC0351g.p(DailyUsageEntityKt.generateDailyUsageId(dailyUsage.getDate(), dailyUsage.getMode(), dailyUsage.getUserId()), ".json");
        DailyUsageFileHelper dailyUsageFileHelper = DailyUsageFileHelper.INSTANCE;
        Context context = getContext();
        String strM = g.m("time_usage_", strP);
        List<TimeUsage> timeUsages = dailyUsage.getTimeUsages();
        ArrayList arrayList = new ArrayList(CollectionsKt.e(timeUsages));
        Iterator<T> it = timeUsages.iterator();
        while (it.hasNext()) {
            arrayList.add(DailyUsageKt.asEntity((TimeUsage) it.next()));
        }
        String strSaveListToFile = dailyUsageFileHelper.saveListToFile(context, strM, arrayList);
        DailyUsageFileHelper dailyUsageFileHelper2 = DailyUsageFileHelper.INSTANCE;
        String strSaveListToFile2 = dailyUsageFileHelper2.saveListToFile(getContext(), g.m("screen_usage_", strP), dailyUsage.getScreenUsages());
        String strSaveListToFile3 = dailyUsageFileHelper2.saveListToFile(getContext(), g.m("notif_usage_", strP), dailyUsage.getNotificationUsages());
        return new DailyUsageEntity(DailyUsageEntityKt.generateDailyUsageId(dailyUsage.getDate(), dailyUsage.getMode(), dailyUsage.getUserId()), dailyUsage.getDate(), dailyUsage.getMode(), dailyUsage.getUserId(), strSaveListToFile, strSaveListToFile2, strSaveListToFile3);
    }

    private final Context getContext() {
        return (Context) this.context.getValue();
    }

    private final boolean isRunningAppEnd(String packageName) {
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            Intrinsics.checkNotNull(timeUsage);
            if (DailyUsageKt.isRunning(timeUsage) && Intrinsics.areEqual(timeUsage.getPackageName(), packageName)) {
                Log.d(TAG, timeUsage + " is running");
                return false;
            }
        }
        return true;
    }

    private final boolean isToday(long date, long currentTime) {
        return TimeUtils.getBaseTimeMill(currentTime) == date;
    }

    private final void sendAppEventBroadcast(TimeUsage timeUsage) {
        Intent intent = new Intent(DataContractKt.ACTION_APP_EVENT);
        intent.addFlags(32);
        intent.putExtra("package_name", timeUsage.getPackageName());
        intent.putExtra(DataContractKt.EXTRA_START_TIME, timeUsage.getStartTime());
        intent.putExtra(DataContractKt.EXTRA_END_TIME, timeUsage.getEndTime());
        intent.setPackage(DataContractKt.PACKAGE_NAME_SCENE_INFO);
        BaseApplication.INSTANCE.getAppContext().sendBroadcast(intent);
        Log.d(TAG, "send app event broadcast   pkg is " + timeUsage.getPackageName() + "   start_time is " + timeUsage.getStartTime() + "    end_time is " + timeUsage.getEndTime());
    }

    private final void setTimeRestrictedAppListInner() {
        List<String> timeRestrictedAppList2 = getTimeRestrictedAppList();
        ArrayList<String> arrayList = timeRestrictedAppList;
        arrayList.clear();
        arrayList.addAll(CollectionsKt.mutableListOf(EngineContract.NOTE_PAPER_PACKAGE_NAME, "tv.danmaku.bili"));
        arrayList.addAll(timeRestrictedAppList2);
    }

    private final void tryCleanupOldData() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DataStorePreferences dataStore = DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME);
        long jLongValue = ((Number) dataStore.getData(KEY_LAST_CLEANUP_TIME, 0L)).longValue();
        if (jCurrentTimeMillis < jLongValue) {
            dataStore.putData(KEY_LAST_CLEANUP_TIME, Long.valueOf(jCurrentTimeMillis));
            return;
        }
        long j4 = jCurrentTimeMillis - jLongValue;
        if (j4 > MAX_SAFE_TIME_JUMP) {
            dataStore.putData(KEY_LAST_CLEANUP_TIME, Long.valueOf(jCurrentTimeMillis));
            return;
        }
        if (j4 < CLEANUP_INTERVAL_MS) {
            return;
        }
        Log.i(TAG, "start clean file");
        try {
            List<DailyUsageEntity> dailyUsages = this.dailyUsageDao.getDailyUsages(0L, jCurrentTimeMillis - RETENTION_PERIOD_MS);
            List<DailyUsageEntity> list = dailyUsages;
            if (list == null || list.isEmpty()) {
                Log.d(TAG, "no file need to clean");
            } else {
                Log.d(TAG, dailyUsages.size() + " data is need to clean");
                for (DailyUsageEntity dailyUsageEntity : dailyUsages) {
                    DailyUsageFileHelper dailyUsageFileHelper = DailyUsageFileHelper.INSTANCE;
                    dailyUsageFileHelper.deleteFile(dailyUsageEntity.getTimeUsagePath());
                    dailyUsageFileHelper.deleteFile(dailyUsageEntity.getScreenUsagePath());
                    dailyUsageFileHelper.deleteFile(dailyUsageEntity.getNotificationUsagePath());
                }
                Log.i(TAG, "file clean success");
            }
            dataStore.putData(KEY_LAST_CLEANUP_TIME, Long.valueOf(jCurrentTimeMillis));
        } catch (Exception e4) {
            Log.e(TAG, "auto clear fail", e4);
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void addNotificationUsage(@NotNull NotificationUsage notificationUsage) {
        Intrinsics.checkNotNullParameter(notificationUsage, "notificationUsage");
        getCurrentDailyUsage().getNotificationUsages().add(notificationUsage);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void addScreenUsage(@NotNull ScreenUsage screenUsage) {
        Intrinsics.checkNotNullParameter(screenUsage, "screenUsage");
        getCurrentDailyUsage().getScreenUsages().add(screenUsage);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void clampTodayUsagesToWallClock(long now) {
        DailyUsage currentDailyUsage = getCurrentDailyUsage();
        List<TimeUsage> timeUsages = currentDailyUsage.getTimeUsages();
        int size = timeUsages.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                TimeUsage timeUsage = timeUsages.get(size);
                if (timeUsage.getStartTime() > now) {
                    timeUsages.remove(size);
                    Log.d(TAG, "clamp remove future timeUsage " + timeUsage.getPackageName() + AwarenessDataItem.PERMISSION_SPLITTER + timeUsage.getStartTime());
                } else if (timeUsage.getEndTime() > now) {
                    timeUsage.setEndTime(now);
                }
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        List<ScreenUsage> screenUsages = currentDailyUsage.getScreenUsages();
        int size2 = screenUsages.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i5 = size2 - 1;
                if (screenUsages.get(size2).getTriggerTime() > now) {
                    screenUsages.remove(size2);
                }
                if (i5 < 0) {
                    break;
                } else {
                    size2 = i5;
                }
            }
        }
        List<NotificationUsage> notificationUsages = currentDailyUsage.getNotificationUsages();
        int size3 = notificationUsages.size() - 1;
        if (size3 < 0) {
            return;
        }
        while (true) {
            int i6 = size3 - 1;
            if (notificationUsages.get(size3).getTriggerTime() > now) {
                notificationUsages.remove(size3);
            }
            if (i6 < 0) {
                return;
            } else {
                size3 = i6;
            }
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public Object clearDailyUsage(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object objO = J.O(continuation, this.coroutineDispatcher, new AnonymousClass2(null));
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public Object clearData(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object objO = J.O(continuation, this.coroutineDispatcher, new C04732(null));
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void clearTodayDailyUsage() {
        dailyUsageMap.clear();
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public Object deleteDailyUsage(int i4, long j4, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object objO = J.O(continuation, this.coroutineDispatcher, new C04742(i4, j4, null));
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void endRunningTimeUsages(long triggerTime, int mode, long userId, @NotNull DailyUsageMessage dailyUsageEvent) {
        Intrinsics.checkNotNullParameter(dailyUsageEvent, "dailyUsageEvent");
        Log.e(TAG, "end all time usages instance --------------------------------");
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            if (timeUsage.getStartTime() > triggerTime) {
                Log.e(TAG, "user reset phone time");
            } else {
                Intrinsics.checkNotNull(timeUsage);
                if (DailyUsageKt.isRunning(timeUsage) && (!(dailyUsageEvent instanceof DailyUsageScreenMessage) || timeUsage.getType() != TimeUsageType.AUDIO.getType())) {
                    DailyUsageKt.endRunning(timeUsage, triggerTime);
                    TimeUsage timeUsage2 = new TimeUsage(timeUsage.getPackageName(), timeUsage.getStartTime(), timeUsage.getEndTime(), timeUsage.getType());
                    Log.d(TAG, "endRunningTimeUsages  newTimeUsage  " + timeUsage.getPackageName() + "   " + timeUsage.getStartTime() + "    " + timeUsage.getType());
                    addUserTimeUsage(timeUsage2, mode, userId);
                }
            }
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public synchronized DailyUsage getCurrentDailyUsage() {
        DailyUsage dailyUsage;
        long baseTimeMill = TimeUtils.getBaseTimeMill(System.currentTimeMillis());
        String strGenerateDailyUsageId = DailyUsageEntityKt.generateDailyUsageId(baseTimeMill, currentUserMode, currentUserId);
        ConcurrentHashMap<String, DailyUsage> concurrentHashMap = dailyUsageMap;
        dailyUsage = concurrentHashMap.get(strGenerateDailyUsageId);
        if (dailyUsage == null) {
            Log.d(TAG, "new daily usage");
            DailyUsage dailyUsage2 = new DailyUsage(baseTimeMill, currentUserMode, currentUserId, null, null, null, 56, null);
            concurrentHashMap.put(strGenerateDailyUsageId, dailyUsage2);
            dailyUsage = dailyUsage2;
        }
        return dailyUsage;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public long getCurrentUserId() {
        return currentUserId;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public int getCurrentUserMode() {
        return currentUserMode;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public ConcurrentHashMap<String, DailyUsage> getDailyUsageMap() {
        return dailyUsageMap;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @WorkerThread
    @NotNull
    public List<DailyUsageSummary> getMultiDailyUsageSummary(int mode, long userId, long startDate, long endDate) {
        List<DailyUsageEntity> userDailyUsages;
        Log.d(TAG, "get multi daily usage summary mode " + mode + " ...");
        ArrayList arrayList = new ArrayList();
        if (startDate <= endDate && (userDailyUsages = this.dailyUsageDao.getUserDailyUsages(mode, userId, startDate, endDate)) != null) {
            Iterator<T> it = userDailyUsages.iterator();
            while (it.hasNext()) {
                DailyUsage dailyUsageConvertEntityToDailyUsageAndReadFiles = convertEntityToDailyUsageAndReadFiles((DailyUsageEntity) it.next());
                long jCurrentTimeMillis = System.currentTimeMillis();
                DailyUsageEntity dailyUsageEntityAsEntity = DailyUsageKt.asEntity(dailyUsageConvertEntityToDailyUsageAndReadFiles);
                if (mode == currentUserMode && userId == currentUserId && isToday(dailyUsageConvertEntityToDailyUsageAndReadFiles.getDate(), jCurrentTimeMillis)) {
                    addRunningTimeUsageInTodayDailyUsage(jCurrentTimeMillis, dailyUsageEntityAsEntity);
                }
                arrayList.add(DailyUsageSummaryKt.asDailyUsageSummary(dailyUsageEntityAsEntity, jCurrentTimeMillis));
            }
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public List<TimeUsage> getRunningTimeUsagesUntilCurrentTime(long currentTime) {
        ArrayList arrayList = new ArrayList();
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            if (timeUsage.getStartTime() > currentTime) {
                Log.e(TAG, "user reset phone time");
            } else {
                Intrinsics.checkNotNull(timeUsage);
                if (DailyUsageKt.isRunning(timeUsage)) {
                    arrayList.add(new TimeUsage(timeUsage.getPackageName(), timeUsage.getStartTime(), currentTime, timeUsage.getType()));
                    Log.d(TAG, "getRunningTimeUsagesUntilCurrentTime  newTimeUsage  " + timeUsage.getPackageName() + "   " + timeUsage.getStartTime() + "    " + timeUsage.getType());
                }
            }
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public List<String> getTimeRestrictedAppList() {
        String str = (String) DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).getData(DataContractKt.KEY_TIME_RESTRICTED_APPS, "");
        if (str.length() <= 0) {
            return CollectionsKt.emptyList();
        }
        Object objD = new n().d(str, new TypeToken<List<? extends String>>() { // from class: com.stepos.alphame.data.repo.DefaultDailyUsageRepository$getTimeRestrictedAppList$type$1
        }.getType());
        Intrinsics.checkNotNull(objD);
        return (List) objD;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public TimeUsage getTimeUsage(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return timeUsageMap.get(key);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public ConcurrentHashMap<String, TimeUsage> getTimeUsageMap() {
        return timeUsageMap;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @NotNull
    public List<TimeUsageEntity> getTodayTimeRestrictedAppTimeUsages(int mode, long userId) {
        ArrayList arrayList = new ArrayList();
        DailyUsage dailyUsage = dailyUsageMap.get(DailyUsageEntityKt.generateDailyUsageId(TimeUtils.getBaseTimeMill(System.currentTimeMillis()), mode, userId));
        if (dailyUsage != null) {
            DailyUsageEntity dailyUsageEntityAsEntity = DailyUsageKt.asEntity(dailyUsage);
            if (mode == currentUserMode && userId == currentUserId) {
                addRunningTimeUsageInTodayDailyUsage(System.currentTimeMillis(), dailyUsageEntityAsEntity);
            }
            for (TimeUsageEntity timeUsageEntity : dailyUsageEntityAsEntity.getTimeUsages()) {
                if (isInTimeRestrictedAppList(timeUsageEntity.getPackageName())) {
                    arrayList.add(timeUsageEntity);
                }
            }
        }
        Log.d(TAG, "timeUsageList is " + arrayList);
        return arrayList;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public DailyUsageSummary getTodayUsageSummary(int mode, long userId) {
        DailyUsage dailyUsage = dailyUsageMap.get(DailyUsageEntityKt.generateDailyUsageId(TimeUtils.getBaseTimeMill(System.currentTimeMillis()), mode, userId));
        if (dailyUsage == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        DailyUsageEntity dailyUsageEntityAsEntity = DailyUsageKt.asEntity(dailyUsage);
        if (mode == currentUserMode && userId == currentUserId) {
            addRunningTimeUsageInTodayDailyUsage(jCurrentTimeMillis, dailyUsageEntityAsEntity);
        }
        return DailyUsageSummaryKt.asDailyUsageSummary(dailyUsageEntityAsEntity, jCurrentTimeMillis);
    }

    @NotNull
    public final DailyUsage getUserDailyUsage(int mode, long userId) {
        long baseTimeMill = TimeUtils.getBaseTimeMill(System.currentTimeMillis());
        String strGenerateDailyUsageId = DailyUsageEntityKt.generateDailyUsageId(baseTimeMill, mode, userId);
        ConcurrentHashMap<String, DailyUsage> concurrentHashMap = dailyUsageMap;
        DailyUsage dailyUsage = concurrentHashMap.get(strGenerateDailyUsageId);
        if (dailyUsage != null) {
            return dailyUsage;
        }
        Log.d(TAG, "new daily usage");
        DailyUsage dailyUsage2 = new DailyUsage(baseTimeMill, mode, userId, null, null, null, 56, null);
        concurrentHashMap.put(strGenerateDailyUsageId, dailyUsage2);
        return dailyUsage2;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public Object insertDailyUsage(@NotNull DailyUsageEntity dailyUsageEntity, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        Object objO = J.O(continuation, this.coroutineDispatcher, new C04752(dailyUsageEntity, null));
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public boolean isInTimeRestrictedAppList(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return timeRestrictedAppList.contains(packageName);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void onInit() {
        Log.d(TAG, "daily usage repository onInit");
        DigitalHealthHelper digitalHealthHelper = DigitalHealthHelper.INSTANCE;
        setUserInfo(digitalHealthHelper.getCurrentMode(getContext()), digitalHealthHelper.getCurrentUserId(getContext()));
        setTimeRestrictedAppListInner();
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void removeTimeUsage(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Log.d(TAG, "remove time usage " + key);
        timeUsageMap.remove(key);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void resetRunningTimeUsages(long triggerTime) {
        Log.e(TAG, "end all time usages instance --------------------------------");
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            if (timeUsage.getStartTime() > triggerTime) {
                Log.e(TAG, "user reset phone time");
            } else {
                Intrinsics.checkNotNull(timeUsage);
                DailyUsageKt.setRunning(timeUsage, triggerTime);
            }
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void restartFutureRunningTimeUsages(long now) {
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            Intrinsics.checkNotNull(timeUsage);
            if (DailyUsageKt.isRunning(timeUsage) && timeUsage.getStartTime() > now) {
                Log.i(TAG, "restart future running usage " + timeUsage.getPackageName() + " start=" + timeUsage.getStartTime() + " -> " + now);
                DailyUsageKt.setRunning(timeUsage, now);
            }
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @Nullable
    public Object restoreDailyUsage(@NotNull Continuation<? super Boolean> continuation) {
        long baseTimeMill = TimeUtils.getBaseTimeMill(System.currentTimeMillis());
        List<DailyUsageEntity> dailyUsagesByDate = this.dailyUsageDao.getDailyUsagesByDate(baseTimeMill);
        List<DailyUsageEntity> list = dailyUsagesByDate;
        if (list == null || list.isEmpty()) {
            Log.d(TAG, "daily usage not found in db for date: " + baseTimeMill);
            return Boxing.boxBoolean(true);
        }
        for (DailyUsageEntity dailyUsageEntity : dailyUsagesByDate) {
            try {
                DailyUsage dailyUsageConvertEntityToDailyUsageAndReadFiles = convertEntityToDailyUsageAndReadFiles(dailyUsageEntity);
                String strGenerateDailyUsageId = DailyUsageEntityKt.generateDailyUsageId(dailyUsageEntity.getDate(), dailyUsageEntity.getMode(), dailyUsageEntity.getUserId());
                dailyUsageMap.put(strGenerateDailyUsageId, dailyUsageConvertEntityToDailyUsageAndReadFiles);
                Log.d(TAG, "restore success: id=" + strGenerateDailyUsageId + ", mode=" + dailyUsageEntity.getMode() + ", user=" + dailyUsageEntity.getUserId());
            } catch (Exception e4) {
                Log.e(TAG, "restore failed for entity: " + dailyUsageEntity.getId(), e4);
            }
        }
        Log.d(TAG, "restoreDailyUsage finished. Total loaded: " + dailyUsageMap.size());
        return Boxing.boxBoolean(true);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    @WorkerThread
    public boolean saveDailyUsages() {
        try {
            Log.d(TAG, "save daily usages with file system");
            Collection<DailyUsage> collectionValues = dailyUsageMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            Collection<DailyUsage> collection = collectionValues;
            ArrayList arrayList = new ArrayList(CollectionsKt.e(collection));
            for (DailyUsage dailyUsage : collection) {
                Intrinsics.checkNotNull(dailyUsage);
                arrayList.add(convertToEntityAndSaveFiles(dailyUsage));
            }
            this.dailyUsageDao.insertDailyUsages(arrayList);
            tryCleanupOldData();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e(TAG, "saveDailyUsages failed: " + e4.getMessage());
            return false;
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void setTimeRestrictedAppList(@NotNull List<String> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        DataStoreManager.INSTANCE.getDataStore(DataContractKt.DAILY_USAGE_FILE_NAME).putData(DataContractKt.KEY_TIME_RESTRICTED_APPS, new n().g(CollectionsKt.distinct(dataList)));
        setTimeRestrictedAppListInner();
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void setTimeUsageWhenRunning(@NotNull DailyUsageMessage dailyUsageEvent, @NotNull TimeUsageType timeUsageType) {
        Intrinsics.checkNotNullParameter(dailyUsageEvent, "dailyUsageEvent");
        Intrinsics.checkNotNullParameter(timeUsageType, "timeUsageType");
        ConcurrentHashMap<String, TimeUsage> concurrentHashMap = timeUsageMap;
        TimeUsage timeUsage = concurrentHashMap.get(timeUsageType.getKey());
        String packageName = "unKnow";
        if (timeUsage != null) {
            if (dailyUsageEvent instanceof DailyUsageAudioMessage) {
                packageName = ((DailyUsageAudioMessage) dailyUsageEvent).getPackageName();
            } else if (dailyUsageEvent instanceof DailyUsageWindowMessage) {
                packageName = ((DailyUsageWindowMessage) dailyUsageEvent).getPackageName();
            } else if (dailyUsageEvent instanceof DailyUsageMzWindowMessage) {
                packageName = ((DailyUsageMzWindowMessage) dailyUsageEvent).getPackageName();
            }
            timeUsage.setPackageName(packageName);
            DailyUsageKt.setRunning(timeUsage, dailyUsageEvent.getRequestTime());
            timeUsage.setType(timeUsageType.getType());
            Log.i(TAG, timeUsage.getPackageName() + AwarenessDataItem.PERMISSION_SPLITTER + TimeUtilsKt.formatDateYear(timeUsage.getStartTime()) + " start running  " + TimeUtilsKt.formatDateYear(timeUsage.getEndTime()));
        } else {
            if (dailyUsageEvent instanceof DailyUsageAudioMessage) {
                packageName = ((DailyUsageAudioMessage) dailyUsageEvent).getPackageName();
            } else if (dailyUsageEvent instanceof DailyUsageWindowMessage) {
                packageName = ((DailyUsageWindowMessage) dailyUsageEvent).getPackageName();
            } else if (dailyUsageEvent instanceof DailyUsageMzWindowMessage) {
                packageName = ((DailyUsageMzWindowMessage) dailyUsageEvent).getPackageName();
            }
            concurrentHashMap.put(timeUsageType.getKey(), new TimeUsage(packageName, dailyUsageEvent.getRequestTime(), dailyUsageEvent.getRequestTime(), timeUsageType.getType()));
            String key = timeUsageType.getKey();
            TimeUsage timeUsage2 = concurrentHashMap.get(timeUsageType.getKey());
            String packageName2 = timeUsage2 != null ? timeUsage2.getPackageName() : null;
            TimeUsage timeUsage3 = concurrentHashMap.get(timeUsageType.getKey());
            String dateYear = timeUsage3 != null ? TimeUtilsKt.formatDateYear(timeUsage3.getStartTime()) : null;
            TimeUsage timeUsage4 = concurrentHashMap.get(timeUsageType.getKey());
            String dateYear2 = timeUsage4 != null ? TimeUtilsKt.formatDateYear(timeUsage4.getEndTime()) : null;
            StringBuilder sbX = g.x("new type ", key, AwarenessDataItem.PERMISSION_SPLITTER, packageName2, AwarenessDataItem.PERMISSION_SPLITTER);
            sbX.append(dateYear);
            sbX.append(" start running ");
            sbX.append(dateYear2);
            Log.d(TAG, sbX.toString());
        }
        TimeUsage timeUsage5 = concurrentHashMap.get(timeUsageType.getKey());
        if (timeUsage5 == null || !isInTimeRestrictedAppList(timeUsage5.getPackageName())) {
            return;
        }
        Log.d(TAG, "setTimeUsageWhenRunning");
        sendAppEventBroadcast(timeUsage5);
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void setTimeUsageWhenRunningEnd(@NotNull TimeUsage endTimeUsage, long endTime) {
        Intrinsics.checkNotNullParameter(endTimeUsage, "endTimeUsage");
        if (endTimeUsage.getStartTime() > endTime) {
            Log.e(TAG, "user reset phone time, drop this usage time " + endTimeUsage);
            return;
        }
        DailyUsageKt.endRunning(endTimeUsage, endTime);
        TimeUsage timeUsage = new TimeUsage(endTimeUsage.getPackageName(), endTimeUsage.getStartTime(), endTimeUsage.getEndTime(), endTimeUsage.getType());
        addTimeUsage(timeUsage);
        if (isRunningAppEnd(endTimeUsage.getPackageName()) && isInTimeRestrictedAppList(endTimeUsage.getPackageName())) {
            Log.d(TAG, AbstractC0351g.n("setTimeUsageWhenRunningEnd   endTime is ", endTime), new Throwable());
            sendAppEventBroadcast(timeUsage);
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public synchronized void setUserInfo(int mode, long userId) {
        if (mode == 1) {
            if (DataContractKt.isUserIdInvalid(userId)) {
                Log.e(TAG, userId + " is invalid userId in minors mode");
                return;
            }
        }
        if (mode != 0 || userId == -1) {
            currentUserMode = mode;
            currentUserId = userId;
        } else {
            Log.e(TAG, userId + " is not right, in normal mode is only -1 ");
        }
    }

    @Override // com.stepos.alphame.data.repo.DailyUsageRepository
    public void splitRunningTimeUsagesAtJump(long boundaryTime, long restartTime) {
        StringBuilder sbE = AbstractC0831a.e("splitRunningTimeUsagesAtJump boundary=", boundaryTime, " restart=");
        sbE.append(restartTime);
        Log.i(TAG, sbE.toString());
        for (TimeUsage timeUsage : timeUsageMap.values()) {
            Intrinsics.checkNotNull(timeUsage);
            if (DailyUsageKt.isRunning(timeUsage)) {
                if (timeUsage.getStartTime() <= boundaryTime) {
                    TimeUsage timeUsage2 = new TimeUsage(timeUsage.getPackageName(), timeUsage.getStartTime(), boundaryTime, timeUsage.getType());
                    addTimeUsage(timeUsage2);
                    Log.d(TAG, "split persist segment " + timeUsage2.getPackageName() + AwarenessDataItem.PERMISSION_SPLITTER + timeUsage2.getStartTime() + " -> " + timeUsage2.getEndTime());
                } else {
                    Log.e(TAG, "split skip future-start running usage " + timeUsage.getPackageName());
                }
                DailyUsageKt.setRunning(timeUsage, restartTime);
            }
        }
    }
}
