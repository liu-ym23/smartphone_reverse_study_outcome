package com.stepos.ability.manager;

import C7.f;
import C7.r;
import C9.B;
import C9.m;
import C9.q;
import C9.x;
import D7.w;
import S7.n;
import T3.c;
import W3.d;
import W3.e;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import c4.C0878a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataReq;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import com.stepos.ability.beaninternal.ability.AiActivityWidgetInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.database.AppDatabase;
import com.stepos.ability.database.dao.AbilityReportDao;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import com.stepos.ability.manager.sync.SyncPhase;
import com.stepos.ability.net.INet;
import com.stepos.ability.net.biz.ApiService;
import com.stepos.ability.net.biz.model.AbilityInfoRsp;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import z2.l;

@Singleton
@Metadata(d1 = {"\u0000Õ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001j\b\u0007\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001nB!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ2\u0010%\u001a\b\u0012\u0004\u0012\u00020$0!2\b\u0010 \u001a\u0004\u0018\u00010\u00182\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!H\u0096@¢\u0006\u0004\b%\u0010&J1\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b,\u0010-J\"\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b.\u0010/J\"\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010*\u001a\u00020)H\u0082@¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010(\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b2\u00103J\u001a\u00104\u001a\u0004\u0018\u00010\u00152\u0006\u0010*\u001a\u00020)H\u0082@¢\u0006\u0004\b4\u00105J\"\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b6\u0010/J\u000f\u00107\u001a\u00020\rH\u0003¢\u0006\u0004\b7\u0010\u0012J\u0019\u0010:\u001a\u0002092\b\u00108\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b:\u0010;J\u0013\u0010=\u001a\u00020\u0015*\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0013\u0010=\u001a\u00020\u0015*\u00020?H\u0002¢\u0006\u0004\b=\u0010@J\u001f\u0010A\u001a\b\u0012\u0004\u0012\u00020$0!*\b\u0012\u0004\u0012\u00020<0!H\u0002¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010CR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010DR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010ER\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u000fR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001d\u0010d\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/stepos/ability/manager/AbilityManager;", "Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/net/INet;", "iNet", "LT3/c;", "deviceIdManager", "LH3/b;", "accountUtil", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/net/INet;LT3/c;LH3/b;)V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "setup", "destroy", "()V", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;", "request", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "getAbilityMetaData", "(Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;LH7/c;)Ljava/lang/Object;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "", "extra", "Lcom/stepos/ability/beaninternal/ability/AiActivityWidgetInfo;", "getCreateAiActivityWidgetInfo", "(Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "query", "", "Lcom/stepos/ability/bean/AbilityQueryParamsParcelable;", "params", "Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "queryAbilities", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", AgentBusWakeContract.EXTRA_SOURCE, "toolName", "", "abilityId", "result", "logMetaDataOutcome", "(Ljava/lang/String;Ljava/lang/String;JLcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;)V", "queryWithToolName", "(Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "queryWithAbilityIdOnly", "(Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;JLH7/c;)Ljava/lang/Object;", "queryFromDatabaseByToolName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "queryFromDatabaseByAbilityId", "(JLH7/c;)Ljava/lang/Object;", "queryFromNetworkFallback", "startNetworkMonitor", InjectExperienceResult.REASON_TIMEOUT, "", "convertTimeout", "(Ljava/lang/String;)I", "Lcom/stepos/ability/net/biz/model/AbilityInfoRsp;", "toAbilityMetaDataResult", "(Lcom/stepos/ability/net/biz/model/AbilityInfoRsp;)Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "Lcom/stepos/ability/database/entity/AtomicAbilityEntity;", "(Lcom/stepos/ability/database/entity/AtomicAbilityEntity;)Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "toAbilityMetadataParcelableList", "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/ability/net/INet;", "LT3/c;", "LH3/b;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "Lcom/stepos/ability/manager/watcher/b;", "abilityInstallerWatcher", "Lcom/stepos/ability/manager/watcher/b;", "Lcom/stepos/ability/manager/discovery/a;", "discoveryProcessor", "Lcom/stepos/ability/manager/discovery/a;", "Ld4/d;", "uploadGate", "Ld4/d;", "Lcom/stepos/ability/manager/sync/a;", "syncCoordinator", "Lcom/stepos/ability/manager/sync/a;", "Lm9/z;", "setupScope", "Lm9/z;", "Lcom/stepos/ability/database/dao/AbilityReportDao;", "reportDao", "Lcom/stepos/ability/database/dao/AbilityReportDao;", "Lcom/stepos/ability/manager/reporter/a;", "reportProcessor", "Lcom/stepos/ability/manager/reporter/a;", "Lcom/stepos/ability/net/biz/ApiService;", "api$delegate", "LC7/f;", "getApi", "()Lcom/stepos/ability/net/biz/ApiService;", "api", "deviceId", "Ljava/lang/String;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "W3/e", "onDeviceIdChangedListener", "LW3/e;", "Companion", "W3/d", "manager_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityManager implements IAbilityManager, IInit {
    public static final d Companion = new d();
    private static final String TAG = "AbilityManager";
    private com.stepos.ability.manager.watcher.b abilityInstallerWatcher;
    private final H3.b accountUtil;

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private final f api;
    public Context context;
    private String deviceId;
    private final c deviceIdManager;
    private com.stepos.ability.manager.discovery.a discoveryProcessor;
    private final INet iNet;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final e onDeviceIdChangedListener;
    private AbilityReportDao reportDao;
    private com.stepos.ability.manager.reporter.a reportProcessor;
    private final InterfaceC1733z setupScope;
    private com.stepos.ability.manager.sync.a syncCoordinator;
    private d4.d uploadGate;

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {211, 212}, m = "getAbilityMetaData", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$getAbilityMetaData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3104a;
        public int c;

        public AnonymousClass1(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3104a = obj;
            this.c |= Integer.MIN_VALUE;
            return AbilityManager.this.getAbilityMetaData(null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {428}, m = "queryAbilities", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryAbilities$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10251 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f3105a;
        public /* synthetic */ Object b;
        public int d;

        public C10251(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AbilityManager.this.queryAbilities(null, null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {357}, m = "queryFromDatabaseByAbilityId", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryFromDatabaseByAbilityId$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10261 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3106a;
        public int c;

        public C10261(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3106a = obj;
            this.c |= Integer.MIN_VALUE;
            return AbilityManager.this.queryFromDatabaseByAbilityId(0L, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {345}, m = "queryFromDatabaseByToolName", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryFromDatabaseByToolName$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10271 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public String f3107a;
        public /* synthetic */ Object b;
        public int d;

        public C10271(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return AbilityManager.this.queryFromDatabaseByToolName(null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {377, 389}, m = "queryFromNetworkFallback", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryFromNetworkFallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10281 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityMetaDataReq f3108a;
        public String b;
        public AbilityInfoRsp c;
        public /* synthetic */ Object d;
        public int f;

        public C10281(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AbilityManager.this.queryFromNetworkFallback(null, null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, 321, 330}, m = "queryWithAbilityIdOnly", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryWithAbilityIdOnly$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10291 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityMetaDataReq f3109a;
        public long b;
        public /* synthetic */ Object c;
        public int e;

        public C10291(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return AbilityManager.this.queryWithAbilityIdOnly(null, 0L, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager", f = "AbilityManager.kt", l = {263, 270, 277, 286, 291}, m = "queryWithToolName", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.manager.AbilityManager$queryWithToolName$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10301 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public AbilityMetaDataReq f3110a;
        public String b;
        public long c;
        public /* synthetic */ Object d;
        public int f;

        public C10301(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AbilityManager.this.queryWithToolName(null, null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.manager.AbilityManager$setup$6", f = "AbilityManager.kt", l = {161}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.manager.AbilityManager$setup$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3112a;
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Context context, H7.c cVar) {
            super(2, cVar);
            this.c = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return AbilityManager.this.new AnonymousClass6(this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass6) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3112a;
            if (i == 0) {
                kotlin.b.b(obj);
                AbilityManager abilityManager = AbilityManager.this;
                com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
                if (aVar == null) {
                    k.n("syncCoordinator");
                    throw null;
                }
                String str = abilityManager.deviceId;
                if (str == null) {
                    k.n("deviceId");
                    throw null;
                }
                this.f3112a = 1;
                if (aVar.i(this.c, str, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @Inject
    public AbilityManager(INet iNet, c deviceIdManager, H3.b accountUtil) {
        k.f(iNet, "iNet");
        k.f(deviceIdManager, "deviceIdManager");
        k.f(accountUtil, "accountUtil");
        this.iNet = iNet;
        this.deviceIdManager = deviceIdManager;
        this.accountUtil = accountUtil;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.setupScope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.api = kotlin.a.a(new W3.b(this, 2));
        this.onDeviceIdChangedListener = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApiService api_delegate$lambda$0(AbilityManager abilityManager) {
        return (ApiService) abilityManager.iNet.create(ApiService.class);
    }

    private final int convertTimeout(String timeout) {
        if (timeout != null) {
            try {
                return Integer.parseInt(timeout);
            } catch (Exception e) {
                Log.e(TAG, "buildAbilityMetaDataResult timeout convert error", e);
            }
        }
        return 150;
    }

    private final ApiService getApi() {
        return (ApiService) this.api.getF4884a();
    }

    private final void logMetaDataOutcome(String source, String toolName, long abilityId, AbilityMetaDataResult result) {
        if (result == null) {
            Log.i(TAG, androidx.appfunctions.metadata.a.m("getAbilityMetaData miss source=", source, " reqToolName=", toolName, " reqAbilityId=<redacted>"));
            return;
        }
        String toolName2 = result.getToolName();
        String packageName = result.getPackageName();
        String functionName = result.getFunctionName();
        StringBuilder sbW = B7.a.w("getAbilityMetaData hit source=", source, " reqToolName=", toolName, " reqAbilityId=<redacted> resultToolName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, toolName2, " resultPkg=", packageName, " resultFn=");
        sbW.append(functionName);
        Log.i(TAG, sbW.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryFromDatabaseByAbilityId(long r6, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.ability.manager.AbilityManager.C10261
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.manager.AbilityManager$queryFromDatabaseByAbilityId$1 r0 = (com.stepos.ability.manager.AbilityManager.C10261) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.AbilityManager$queryFromDatabaseByAbilityId$1 r0 = new com.stepos.ability.manager.AbilityManager$queryFromDatabaseByAbilityId$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f3106a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L28
            goto L50
        L28:
            r5 = move-exception
            goto L5a
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.b.b(r8)
            F.i r8 = com.stepos.ability.manager.cache.a.e     // Catch: java.lang.Exception -> L28
            android.content.Context r2 = r5.getContext()     // Catch: java.lang.Exception -> L28
            com.stepos.ability.manager.cache.a r8 = r8.x(r2)     // Catch: java.lang.Exception -> L28
            int r6 = (int) r6     // Catch: java.lang.Exception -> L28
            r0.c = r4     // Catch: java.lang.Exception -> L28
            if (r6 >= 0) goto L46
            r8 = r3
            goto L4d
        L46:
            com.stepos.ability.database.dao.AtomicAbilityDao r7 = r8.b     // Catch: java.lang.Exception -> L28
            java.lang.Object r6 = r7.getByAbilityId(r6, r0)     // Catch: java.lang.Exception -> L28
            r8 = r6
        L4d:
            if (r8 != r1) goto L50
            return r1
        L50:
            com.stepos.ability.database.entity.AtomicAbilityEntity r8 = (com.stepos.ability.database.entity.AtomicAbilityEntity) r8     // Catch: java.lang.Exception -> L28
            if (r8 == 0) goto L59
            com.stepos.ability.beaninternal.ability.AbilityMetaDataResult r5 = r5.toAbilityMetaDataResult(r8)     // Catch: java.lang.Exception -> L28
            return r5
        L59:
            return r3
        L5a:
            java.lang.String r6 = "AbilityManager"
            java.lang.String r7 = "queryFromDatabaseByAbilityId failed. abilityId=<redacted>"
            android.util.Log.e(r6, r7, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryFromDatabaseByAbilityId(long, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryFromDatabaseByToolName(java.lang.String r6, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ability.manager.AbilityManager.C10271
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ability.manager.AbilityManager$queryFromDatabaseByToolName$1 r0 = (com.stepos.ability.manager.AbilityManager.C10271) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.stepos.ability.manager.AbilityManager$queryFromDatabaseByToolName$1 r0 = new com.stepos.ability.manager.AbilityManager$queryFromDatabaseByToolName$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            java.lang.String r6 = r0.f3107a
            kotlin.b.b(r7)     // Catch: java.lang.Exception -> L2a
            goto L4e
        L2a:
            r5 = move-exception
            goto L58
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.b.b(r7)
            F.i r7 = com.stepos.ability.manager.cache.a.e     // Catch: java.lang.Exception -> L2a
            android.content.Context r2 = r5.getContext()     // Catch: java.lang.Exception -> L2a
            com.stepos.ability.manager.cache.a r7 = r7.x(r2)     // Catch: java.lang.Exception -> L2a
            r0.f3107a = r6     // Catch: java.lang.Exception -> L2a
            r0.d = r4     // Catch: java.lang.Exception -> L2a
            com.stepos.ability.database.dao.AtomicAbilityDao r7 = r7.b     // Catch: java.lang.Exception -> L2a
            java.lang.Object r7 = r7.getByToolName(r6, r0)     // Catch: java.lang.Exception -> L2a
            if (r7 != r1) goto L4e
            return r1
        L4e:
            com.stepos.ability.database.entity.AtomicAbilityEntity r7 = (com.stepos.ability.database.entity.AtomicAbilityEntity) r7     // Catch: java.lang.Exception -> L2a
            if (r7 == 0) goto L57
            com.stepos.ability.beaninternal.ability.AbilityMetaDataResult r5 = r5.toAbilityMetaDataResult(r7)     // Catch: java.lang.Exception -> L2a
            return r5
        L57:
            return r3
        L58:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "queryFromDatabaseByToolName failed. toolName="
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "AbilityManager"
            android.util.Log.e(r7, r6, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryFromDatabaseByToolName(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf A[Catch: Exception -> 0x00b2, TryCatch #5 {Exception -> 0x00b2, blocks: (B:37:0x00af, B:48:0x00cf, B:50:0x00d5, B:53:0x00dd, B:56:0x00f5, B:58:0x00fb, B:62:0x010a, B:64:0x011c, B:83:0x0188, B:86:0x0195, B:89:0x01a3, B:91:0x01aa, B:34:0x009c, B:42:0x00ba, B:43:0x00c2), top: B:105:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[Catch: Exception -> 0x00b2, TryCatch #5 {Exception -> 0x00b2, blocks: (B:37:0x00af, B:48:0x00cf, B:50:0x00d5, B:53:0x00dd, B:56:0x00f5, B:58:0x00fb, B:62:0x010a, B:64:0x011c, B:83:0x0188, B:86:0x0195, B:89:0x01a3, B:91:0x01aa, B:34:0x009c, B:42:0x00ba, B:43:0x00c2), top: B:105:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0188 A[Catch: Exception -> 0x00b2, TRY_ENTER, TryCatch #5 {Exception -> 0x00b2, blocks: (B:37:0x00af, B:48:0x00cf, B:50:0x00d5, B:53:0x00dd, B:56:0x00f5, B:58:0x00fb, B:62:0x010a, B:64:0x011c, B:83:0x0188, B:86:0x0195, B:89:0x01a3, B:91:0x01aa, B:34:0x009c, B:42:0x00ba, B:43:0x00c2), top: B:105:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0195 A[Catch: Exception -> 0x00b2, TryCatch #5 {Exception -> 0x00b2, blocks: (B:37:0x00af, B:48:0x00cf, B:50:0x00d5, B:53:0x00dd, B:56:0x00f5, B:58:0x00fb, B:62:0x010a, B:64:0x011c, B:83:0x0188, B:86:0x0195, B:89:0x01a3, B:91:0x01aa, B:34:0x009c, B:42:0x00ba, B:43:0x00c2), top: B:105:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a3 A[Catch: Exception -> 0x00b2, TryCatch #5 {Exception -> 0x00b2, blocks: (B:37:0x00af, B:48:0x00cf, B:50:0x00d5, B:53:0x00dd, B:56:0x00f5, B:58:0x00fb, B:62:0x010a, B:64:0x011c, B:83:0x0188, B:86:0x0195, B:89:0x01a3, B:91:0x01aa, B:34:0x009c, B:42:0x00ba, B:43:0x00c2), top: B:105:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a8  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryFromNetworkFallback(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq r19, java.lang.String r20, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r21) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryFromNetworkFallback(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:14:0x0038, B:56:0x00ea, B:21:0x004d, B:46:0x00ac, B:24:0x0058, B:39:0x008b, B:41:0x0090, B:43:0x0098, B:28:0x0063, B:31:0x0069, B:35:0x0077, B:48:0x00b7, B:49:0x00bc, B:50:0x00bd, B:52:0x00c1, B:58:0x00f5, B:59:0x00f8, B:60:0x00f9, B:61:0x00fc), top: B:64:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:14:0x0038, B:56:0x00ea, B:21:0x004d, B:46:0x00ac, B:24:0x0058, B:39:0x008b, B:41:0x0090, B:43:0x0098, B:28:0x0063, B:31:0x0069, B:35:0x0077, B:48:0x00b7, B:49:0x00bc, B:50:0x00bd, B:52:0x00c1, B:58:0x00f5, B:59:0x00f8, B:60:0x00f9, B:61:0x00fc), top: B:64:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryWithAbilityIdOnly(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq r17, long r18, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r20) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryWithAbilityIdOnly(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq, long, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01b5, code lost:
    
        if (r3 == r8) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef A[Catch: Exception -> 0x00f5, TryCatch #3 {Exception -> 0x00f5, blocks: (B:67:0x0112, B:58:0x00ea, B:60:0x00ef, B:64:0x00f9, B:102:0x01b8, B:95:0x018e, B:75:0x0145, B:77:0x0149, B:79:0x0151, B:81:0x015a, B:104:0x01c1, B:105:0x01c5), top: B:110:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9 A[Catch: Exception -> 0x00f5, TryCatch #3 {Exception -> 0x00f5, blocks: (B:67:0x0112, B:58:0x00ea, B:60:0x00ef, B:64:0x00f9, B:102:0x01b8, B:95:0x018e, B:75:0x0145, B:77:0x0149, B:79:0x0151, B:81:0x015a, B:104:0x01c1, B:105:0x01c5), top: B:110:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149 A[Catch: Exception -> 0x00f5, TryCatch #3 {Exception -> 0x00f5, blocks: (B:67:0x0112, B:58:0x00ea, B:60:0x00ef, B:64:0x00f9, B:102:0x01b8, B:95:0x018e, B:75:0x0145, B:77:0x0149, B:79:0x0151, B:81:0x015a, B:104:0x01c1, B:105:0x01c5), top: B:110:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0151 A[Catch: Exception -> 0x00f5, TryCatch #3 {Exception -> 0x00f5, blocks: (B:67:0x0112, B:58:0x00ea, B:60:0x00ef, B:64:0x00f9, B:102:0x01b8, B:95:0x018e, B:75:0x0145, B:77:0x0149, B:79:0x0151, B:81:0x015a, B:104:0x01c1, B:105:0x01c5), top: B:110:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryWithToolName(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq r20, java.lang.String r21, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r22) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryWithToolName(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setup$lambda$0(AbilityManager abilityManager, Context context) {
        Log.i(TAG, "account logged in, trigger full rescan");
        AbstractC1683A.n(abilityManager.setupScope, null, new AbilityManager$setup$1$1(abilityManager, context, null), 3);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setup$lambda$1(AbilityManager abilityManager, Context context) {
        Log.i(TAG, "account logged out, reset sync session");
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar != null) {
            aVar.h(context);
            return r.f317a;
        }
        k.n("syncCoordinator");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setup$lambda$2(AbilityManager abilityManager) {
        return abilityManager.accountUtil.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncPhase setup$lambda$3(AbilityManager abilityManager) {
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar != null) {
            return aVar.e();
        }
        k.n("syncCoordinator");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setup$lambda$4(AbilityManager abilityManager, Context context, boolean z10, String str, boolean z11) {
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar != null) {
            aVar.g(context, z10, str, z11);
            return r.f317a;
        }
        k.n("syncCoordinator");
        throw null;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private final void startNetworkMonitor() {
        Object systemService = getContext().getSystemService("connectivity");
        k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.networkCallback = new b(this);
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback = this.networkCallback;
        k.c(networkCallback);
        ((ConnectivityManager) systemService).registerNetworkCallback(networkRequestBuild, networkCallback);
    }

    private final AbilityMetaDataResult toAbilityMetaDataResult(AbilityInfoRsp abilityInfoRsp) {
        String name = abilityInfoRsp.getName();
        if (name == null) {
            name = "";
        }
        String description = abilityInfoRsp.getDescription();
        if (description == null) {
            description = "";
        }
        String appVersion = abilityInfoRsp.getAppVersion();
        String pkg = abilityInfoRsp.getPkg();
        if (pkg == null) {
            pkg = "";
        }
        String functionName = abilityInfoRsp.getFunctionName();
        Map<String, Object> extra = abilityInfoRsp.getExtra();
        f fVar = P3.a.f1084a;
        String strC = P3.a.c(abilityInfoRsp.getInputSchema());
        if (strC == null) {
            strC = "{}";
        }
        return new AbilityMetaDataResult(name, description, "", appVersion, pkg, "", functionName, extra, strC, convertTimeout(abilityInfoRsp.getTimeout()), abilityInfoRsp.getCallingMethod(), abilityInfoRsp.getCallType(), abilityInfoRsp.getSlaScene());
    }

    private final List<AbilityMetadataParcelable> toAbilityMetadataParcelableList(List<AbilityInfoRsp> list) {
        List<AbilityInfoRsp> list2 = list;
        ArrayList arrayList = new ArrayList(w.c0(list2, 10));
        for (AbilityInfoRsp abilityInfoRsp : list2) {
            String name = abilityInfoRsp.getName();
            if (name == null) {
                name = "";
            }
            String description = abilityInfoRsp.getDescription();
            if (description == null) {
                description = "";
            }
            String pkg = abilityInfoRsp.getPkg();
            String str = pkg != null ? pkg : "";
            f fVar = P3.a.f1084a;
            String strC = P3.a.c(abilityInfoRsp.getInputSchema());
            if (strC == null) {
                strC = "{}";
            }
            arrayList.add(new AbilityMetadataParcelable(name, description, str, strC));
        }
        return arrayList;
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public void destroy() {
        Log.i(TAG, "destroy.");
        H3.b bVar = this.accountUtil;
        bVar.getClass();
        Log.i("AccountUtil", "unregisterAccountChangeListener");
        AccountManager.get(bVar.f733a).removeOnAccountsUpdatedListener(bVar.f);
        c cVar = this.deviceIdManager;
        e listener = this.onDeviceIdChangedListener;
        T3.b bVar2 = (T3.b) cVar;
        bVar2.getClass();
        k.f(listener, "listener");
        bVar2.d.remove(listener);
        com.stepos.ability.manager.discovery.a aVar = this.discoveryProcessor;
        if (aVar != null) {
            aVar.b();
        }
        com.stepos.ability.manager.sync.a aVar2 = this.syncCoordinator;
        if (aVar2 == null) {
            k.n("syncCoordinator");
            throw null;
        }
        aVar2.d();
        com.stepos.ability.manager.watcher.b bVar3 = this.abilityInstallerWatcher;
        if (bVar3 == null) {
            k.n("abilityInstallerWatcher");
            throw null;
        }
        Log.i("AbilityInstallerWatcher", "unregister start.");
        Context context = bVar3.f;
        try {
            if (context != null) {
                try {
                    context.unregisterReceiver(bVar3.h);
                    bVar3.f = null;
                    Log.i("AbilityInstallerWatcher", "unregister success.");
                } catch (Exception e) {
                    Log.w("AbilityInstallerWatcher", "unregister error:" + e.getMessage());
                }
            }
            com.stepos.ability.manager.reporter.a aVar3 = this.reportProcessor;
            if (aVar3 != null) {
                Context context2 = aVar3.f3149a;
                Log.i("AbilityReportProcessor", "stop.");
                AbstractC1683A.e(aVar3.e, null);
                C0878a c0878a = aVar3.g;
                if (c0878a != null) {
                    Object systemService = context2.getSystemService("connectivity");
                    k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                    ((ConnectivityManager) systemService).unregisterNetworkCallback(c0878a);
                }
                context2.unregisterReceiver(aVar3.h);
            }
            Object systemService2 = getContext().getSystemService("connectivity");
            k.d(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService2;
            ConnectivityManager.NetworkCallback networkCallback = this.networkCallback;
            if (networkCallback != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
        } finally {
            bVar3.f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ce, code lost:
    
        if (r2 == r4) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.ability.commoninternal.ability.IAbilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getAbilityMetaData(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq r18, H7.c<? super com.stepos.ability.beaninternal.ability.AbilityMetaDataResult> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.getAbilityMetaData(com.stepos.ability.beaninternal.ability.AbilityMetaDataReq, H7.c):java.lang.Object");
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        k.n("context");
        throw null;
    }

    @Override // com.stepos.ability.commoninternal.ability.IAbilityManager
    public Object getCreateAiActivityWidgetInfo(String str, Map<String, ? extends Object> map, H7.c<? super AiActivityWidgetInfo> cVar) {
        Log.i("ActivityWidgetAbilityScanner", "getCreateAiActivityWidgetInfo method: " + str + ", extra: <redacted>");
        if (str == null || str.length() == 0) {
            Log.e("ActivityWidgetAbilityScanner", "getCreateAiActivityWidgetInfo method is null");
            return null;
        }
        if (map != null && !map.isEmpty()) {
            Object orDefault = map.getOrDefault("ZYQL_AI_ACTIVITY_WIDGET_TOOL_NAME", "");
            String str2 = orDefault instanceof String ? (String) orDefault : null;
            if (str2 == null) {
                str2 = "";
            }
            if (str2.length() > 0) {
                Object orDefault2 = map.getOrDefault("ZYQL_AI_ACTIVITY_WIDGET_PKG", "");
                String str3 = orDefault2 instanceof String ? (String) orDefault2 : null;
                if (str3 == null) {
                    str3 = "";
                }
                Object orDefault3 = map.getOrDefault("ZYQL_AI_ACTIVITY_WIDGET_CLS", "");
                String str4 = orDefault3 instanceof String ? (String) orDefault3 : null;
                String str5 = str4 != null ? str4 : "";
                if (str3.length() > 0 && str5.length() > 0) {
                    q qVarB = com.stepos.ability.task.executor.e.b(new Ba.f(27));
                    x9.b bVarSerializer = C9.l.Companion.serializer();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    B element = m.b(str3);
                    k.f(element, "element");
                    B element2 = m.b(str5);
                    k.f(element2, "element");
                    return new AiActivityWidgetInfo(str2, qVarB.b(bVarSerializer, new x(linkedHashMap)));
                }
            }
        }
        return null;
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        setContext(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // com.stepos.ability.commoninternal.ability.IAbilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object queryAbilities(java.lang.String r20, java.util.List<com.stepos.ability.bean.AbilityQueryParamsParcelable> r21, H7.c<? super java.util.List<com.stepos.ability.bean.AbilityMetadataParcelable>> r22) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.AbilityManager.queryAbilities(java.lang.String, java.util.List, H7.c):java.lang.Object");
    }

    public final void setContext(Context context) {
        k.f(context, "<set-?>");
        this.context = context;
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public void setup(Context context) throws Throwable {
        k.f(context, "context");
        Log.i(TAG, "setup.");
        d4.d dVar = new d4.d(this.accountUtil);
        this.uploadGate = dVar;
        this.syncCoordinator = new com.stepos.ability.manager.sync.a(this.iNet, dVar);
        H3.b bVar = this.accountUtil;
        W3.a aVar = new W3.a(this, context, 0);
        bVar.getClass();
        Log.i("AccountUtil", "setLoggedInListener");
        bVar.b = aVar;
        H3.b bVar2 = this.accountUtil;
        W3.a aVar2 = new W3.a(this, context, 1);
        bVar2.getClass();
        Log.i("AccountUtil", "setLoggedOutListener");
        bVar2.c = aVar2;
        H3.b bVar3 = this.accountUtil;
        bVar3.getClass();
        Log.i("AccountUtil", "registerAccountChangeListener");
        AccountManager.get(bVar3.f733a).addOnAccountsUpdatedListener(bVar3.f, null, true);
        c cVar = this.deviceIdManager;
        e listener = this.onDeviceIdChangedListener;
        T3.b bVar4 = (T3.b) cVar;
        bVar4.getClass();
        k.f(listener, "listener");
        bVar4.d.add(listener);
        this.deviceId = this.deviceIdManager.a();
        this.iNet.setTokenProvider(new W3.b(this, 0));
        AbilityReportDao abilityReportDao = AppDatabase.Companion.b(context).abilityReportDao();
        this.reportDao = abilityReportDao;
        if (abilityReportDao == null) {
            k.n("reportDao");
            throw null;
        }
        INet iNet = this.iNet;
        d4.d dVar2 = this.uploadGate;
        if (dVar2 == null) {
            k.n("uploadGate");
            throw null;
        }
        com.stepos.ability.manager.reporter.a aVar3 = new com.stepos.ability.manager.reporter.a(context, abilityReportDao, iNet, dVar2);
        this.reportProcessor = aVar3;
        aVar3.b();
        INet iNet2 = this.iNet;
        String str = this.deviceId;
        if (str == null) {
            k.n("deviceId");
            throw null;
        }
        d4.d dVar3 = this.uploadGate;
        if (dVar3 == null) {
            k.n("uploadGate");
            throw null;
        }
        this.abilityInstallerWatcher = new com.stepos.ability.manager.watcher.b(iNet2, str, dVar3, new W3.b(this, 1), new W3.c(0, this, context));
        com.stepos.ability.manager.discovery.a aVar4 = this.discoveryProcessor;
        if (aVar4 != null) {
            aVar4.b();
        }
        com.stepos.ability.manager.sync.a aVar5 = this.syncCoordinator;
        if (aVar5 == null) {
            k.n("syncCoordinator");
            throw null;
        }
        aVar5.d();
        INet iNet3 = this.iNet;
        String str2 = this.deviceId;
        if (str2 == null) {
            k.n("deviceId");
            throw null;
        }
        d4.d dVar4 = this.uploadGate;
        if (dVar4 == null) {
            k.n("uploadGate");
            throw null;
        }
        com.stepos.ability.manager.discovery.a aVar6 = new com.stepos.ability.manager.discovery.a(iNet3, str2, dVar4);
        this.discoveryProcessor = aVar6;
        com.stepos.ability.manager.sync.a aVar7 = this.syncCoordinator;
        if (aVar7 == null) {
            k.n("syncCoordinator");
            throw null;
        }
        aVar7.m = aVar6;
        if (aVar7 == null) {
            k.n("syncCoordinator");
            throw null;
        }
        com.stepos.ability.manager.cache.a.e.x(context).b(new d4.a(aVar7, context, 0));
        try {
            AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass6(context, null));
        } catch (Exception e) {
            Log.e(TAG, "restorePhaseOnStartup failed", e);
        }
        com.stepos.ability.manager.watcher.b bVar5 = this.abilityInstallerWatcher;
        if (bVar5 == null) {
            k.n("abilityInstallerWatcher");
            throw null;
        }
        Log.i("AbilityInstallerWatcher", "register.");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(bVar5.h, intentFilter);
        bVar5.f = context;
        Log.i("AbilityInstallerWatcher", "register success.");
        startNetworkMonitor();
    }

    private final AbilityMetaDataResult toAbilityMetaDataResult(AtomicAbilityEntity atomicAbilityEntity) {
        String str = atomicAbilityEntity.b;
        String str2 = atomicAbilityEntity.f;
        String str3 = atomicAbilityEntity.f3088s;
        String str4 = str3 == null ? "" : str3;
        String str5 = atomicAbilityEntity.f3084a;
        String str6 = atomicAbilityEntity.f3090v;
        String str7 = str6 == null ? "" : str6;
        String str8 = atomicAbilityEntity.c;
        f fVar = P3.a.f1084a;
        Map mapA = P3.a.a(atomicAbilityEntity.p);
        String str9 = atomicAbilityEntity.n;
        if (str9 == null) {
            str9 = "{}";
        }
        String str10 = str9;
        Integer num = atomicAbilityEntity.i;
        return new AbilityMetaDataResult(str, str2, "", str4, str5, str7, str8, mapA, str10, num != null ? num.intValue() : 150, atomicAbilityEntity.h, atomicAbilityEntity.g, atomicAbilityEntity.f3092x);
    }
}
