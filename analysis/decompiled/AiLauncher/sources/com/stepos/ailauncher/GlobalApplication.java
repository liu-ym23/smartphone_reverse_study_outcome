package com.stepos.ailauncher;

import G7.HttpMetrics;
import Ua.C1060i;
import Ua.Y;
import Z8.C1173v;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import c6.C1500a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.session.AgentFrameworkConfig;
import com.stepos.agentframework.chatui.appui.RemoteAppUIHostView;
import com.stepos.agentframework.chatui.appui.web.AgentWebView;
import com.stepos.ailauncher.AIHOmeBarService;
import com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl;
import com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider;
import com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketServiceImpl;
import com.stepos.ailauncher.agent.service.AgentSpaceServiceImpl;
import com.stepos.ailauncher.agent.skill.opera.SkillOperaManager;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.controller.C2536e;
import com.stepos.ailauncher.chat.lockscreen.C2673f;
import com.stepos.ailauncher.chat.lowpower.TempPowerLowMonitor;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.C2686b;
import com.stepos.ailauncher.chat.manager.C2703j0;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.common.memory.d;
import com.stepos.ailauncher.common.startup.InitStrategy;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.common.utils.NetworkStateMonitor;
import com.stepos.ailauncher.common.utils.r;
import com.stepos.ailauncher.container.api.IOverlayPageRegistry;
import com.stepos.ailauncher.container.g0;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.api.agent.IAgentSpaceService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.api.amap.IPoiDetailPageProvider;
import com.stepos.ailauncher.contract.api.artifact.IArtifactDetailPageProvider;
import com.stepos.ailauncher.contract.api.chat.IChatRoundAbortService;
import com.stepos.ailauncher.contract.api.express.IExpressService;
import com.stepos.ailauncher.contract.api.feishu.IFeishuConnectService;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import com.stepos.ailauncher.contract.api.repair.IRepairService;
import com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService;
import com.stepos.ailauncher.contract.api.vector.IVectorIndexService;
import com.stepos.ailauncher.contract.api.wecom.IWecomConnectService;
import com.stepos.ailauncher.express.service.ExpressServiceImpl;
import com.stepos.ailauncher.floatcard.FloatCardServiceImpl;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.k0;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.interceptor.BizInterceptor;
import com.stepos.ailauncher.network.repository.DictionaryRepositoryManager;
import com.stepos.ailauncher.oobe.WakeAnywhereActivity;
import com.stepos.ailauncher.sla.SlaAtomicDispatcher;
import com.stepos.ailauncher.speech.SpeechServiceImpl;
import com.stepos.ailauncher.task.agentbus.AgentBusEventRouter;
import com.stepos.ailauncher.task.detail.C3528k;
import com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl;
import com.stepos.ailauncher.task.space.ContentSafetyApi;
import com.stepos.ailauncher.task.space.E0;
import com.stepos.ailauncher.task.space.MinusOneHomeRoots;
import com.stepos.ailauncher.task.space.credential.CredentialApi;
import com.stepos.ailauncher.task.vector.TaskVectorIndexServiceImpl;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.chat.C3698a;
import com.stepos.ailauncher.taskstore.chat.C3700c;
import com.stepos.ailauncher.taskstore.chat.C3701d;
import com.stepos.ailauncher.taskstore.chat.C3702e;
import com.stepos.ailauncher.taskstore.livenotification.C3720h;
import com.stepos.ailauncher.taskstore.livenotification.C3728p;
import com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import com.stepos.common.utils.filestorage.FileStorageConfig;
import com.stepos.common.utils.filestorage.FileStorageManager;
import com.stepos.net.HttpConfig;
import com.stepos.net.HttpManager;
import com.stepos.net.exception.ApiException;
import com.stepos.net.token.TokenProvider;
import com.stepos.policy.sdk.PolicySdk;
import d4.C3954a;
import e9.InterfaceC4014c;
import h8.C4148a;
import i5.C4169b;
import i5.C4170c;
import j1.InterfaceC4757d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import m6.C4904a;
import n5.C4941b;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;
import x5.C5851b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0003R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/GlobalApplication;", "Landroid/app/Application;", "<init>", "()V", "Landroid/content/Context;", "base", "LY8/t;", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", "E0", "f0", "c0", "context", "R", ExifInterface.LONGITUDE_WEST, "k0", "l0", "d0", "X", "u0", "v0", ExifInterface.LATITUDE_SOUTH, "o0", "A0", "b0", "n0", "C0", "e0", "m0", "a0", "B0", "H0", "p0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D0", "U", "Lcom/stepos/ailauncher/contract/api/vector/IVectorIndexService;", "vectorIndexService$delegate", "LY8/h;", "Q", "()Lcom/stepos/ailauncher/contract/api/vector/IVectorIndexService;", "vectorIndexService", "Companion", Const.INTENT_KEY_APIKEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GlobalApplication extends Application {
    private static final String TAG = "AILauncher-GlobalApplication";

    /* renamed from: vectorIndexService$delegate, reason: from kotlin metadata */
    private final Y8.h vectorIndexService = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.q
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return GlobalApplication.G0(this.f27656a);
        }
    });

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$A", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class A extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.H0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$B", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class B extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.D0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$C", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.c0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$D", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class D extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.U();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$E", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class E extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public E(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            IExpressService iExpressService = (IExpressService) D5.a.INSTANCE.a(IExpressService.class);
            if (iExpressService != null) {
                iExpressService.init(this.this$0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$F", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class F extends com.stepos.ailauncher.common.startup.h {
        public F(String str, InitStrategy initStrategy, List list, long j10, boolean z10) {
            super(str, initStrategy, list, j10, z10);
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            AgentBusEventRouter.INSTANCE.i0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$G", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class G extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public G(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.V();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$H", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class H extends com.stepos.ailauncher.common.startup.h {
        public H(String str, InitStrategy initStrategy, List list, long j10, boolean z10) {
            super(str, initStrategy, list, j10, z10);
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            C1060i.d(kotlinx.coroutines.d.b(), null, null, new GlobalApplication$setupStartup$36$1(null), 3, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$I", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class I extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public I(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            GlobalApplication globalApplication = this.this$0;
            globalApplication.R(globalApplication);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$J", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class J extends com.stepos.ailauncher.common.startup.h {
        public J(String str, InitStrategy initStrategy, List list, long j10, boolean z10) {
            super(str, initStrategy, list, j10, z10);
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            SlaAtomicDispatcher.INSTANCE.o(context);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$K", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class K extends com.stepos.ailauncher.common.startup.h {
        public K(String str, InitStrategy initStrategy, List list, long j10, boolean z10) {
            super(str, initStrategy, list, j10, z10);
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            F5.b.c();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$L", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class L extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public L(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            com.stepos.ailauncher.foundation.account.f.INSTANCE.s(this.this$0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$M", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class M extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public M(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.f0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$N", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class N extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public N(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.W();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$O", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class O extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public O(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.k0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$P", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class P extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.d0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$b", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$b, reason: case insensitive filesystem */
    public static final class C2160b implements com.stepos.ailauncher.foundation.account.i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            C4148a.d("GlobalApplication", "accountStateChanged: " + accountInfo, false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/GlobalApplication$c", "LO6/h;", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "getToken", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$c, reason: case insensitive filesystem */
    public static final class C2161c implements O6.h {
        @Override // O6.h
        public String a() {
            String strK = com.stepos.ailauncher.foundation.account.f.INSTANCE.k();
            if (strK.length() > 0) {
                return strK;
            }
            return null;
        }

        @Override // O6.h
        public String getToken() {
            return com.stepos.ailauncher.foundation.account.f.o(com.stepos.ailauncher.foundation.account.f.INSTANCE, false, null, 3, null);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$d, reason: case insensitive filesystem */
    public static final class C2162d implements com.stepos.common.utils.filestorage.e {
        public static final C2162d INSTANCE = new C2162d();

        @Override // com.stepos.common.utils.filestorage.e
        public final Object a(InterfaceC4014c<? super String> interfaceC4014c) {
            return com.stepos.ailauncher.foundation.account.f.o(com.stepos.ailauncher.foundation.account.f.INSTANCE, false, null, 3, null);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$e, reason: case insensitive filesystem */
    public static final class C2163e implements com.stepos.common.utils.filestorage.a {
        public C2163e() {
        }

        @Override // com.stepos.common.utils.filestorage.a
        public final Object a(InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
            C6.a aVar = C6.a.INSTANCE;
            return kotlin.collections.a.m(Y8.j.a("zy-device-id", aVar.d(GlobalApplication.this)), Y8.j.a("zy-app-ver-name", aVar.b(GlobalApplication.this)), Y8.j.a("zy-app-ver-code", String.valueOf(aVar.a(GlobalApplication.this))), Y8.j.a("zy-client-lang", aVar.e()), Y8.j.a("zy-system-ver", aVar.i()), Y8.j.a("zy-device-model", aVar.f()), Y8.j.a("zy-device-brand", aVar.c()));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/GlobalApplication$f", "Lcom/stepos/net/token/TokenProvider;", "", "getToken", "()Ljava/lang/String;", "refreshToken", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$f, reason: case insensitive filesystem */
    public static final class C2164f implements TokenProvider {
        @Override // com.stepos.net.token.TokenProvider
        /* renamed from: getToken */
        public String getCachedToken() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strO = com.stepos.ailauncher.foundation.account.f.o(com.stepos.ailauncher.foundation.account.f.INSTANCE, false, null, 3, null);
            C4148a.d(GlobalApplication.TAG, "getToken cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            return strO;
        }

        @Override // com.stepos.net.token.TokenProvider
        public /* bridge */ String headerName() {
            return super.headerName();
        }

        @Override // com.stepos.net.token.TokenProvider
        public String refreshToken() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strO = com.stepos.ailauncher.foundation.account.f.o(com.stepos.ailauncher.foundation.account.f.INSTANCE, true, null, 2, null);
            C4148a.d(GlobalApplication.TAG, "refreshToken cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            return strO;
        }

        @Override // com.stepos.net.token.TokenProvider
        public /* bridge */ String tokenPrefix() {
            return super.tokenPrefix();
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"com/stepos/ailauncher/GlobalApplication$g", "Lcom/stepos/ailauncher/contract/api/homebar/IHomeBarSysUiService;", "", "notifyHomeBarLighted", "()Z", "show", "", "msg", "LY8/t;", "showHomeBarCapsule", "(ZLjava/lang/String;)V", "", "startTime", "notifyChatViewClosed", "(J)V", "isWhiteHomeBar", "openChatViewAfterAgentAuth", "()V", "Lkotlin/Function0;", "listener", "setOnHomeBarCapsuleClickListener", "(Lp9/a;)V", "setOnHomeBarSysUiConnectedListener", "Lcom/stepos/ailauncher/H;", "capsuleCallback", "Lcom/stepos/ailauncher/H;", "sysUiConnectedCallback", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$g, reason: case insensitive filesystem */
    public static final class C2165g implements IHomeBarSysUiService {
        private com.stepos.ailauncher.H capsuleCallback;
        private com.stepos.ailauncher.H sysUiConnectedCallback;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/GlobalApplication$g$a", "Lcom/stepos/ailauncher/H;", "LY8/t;", "onHomeBarCapsuleClick", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.GlobalApplication$g$a */
        public static final class a implements com.stepos.ailauncher.H {
            final /* synthetic */ InterfaceC5063a<Y8.t> $cb;

            public a(InterfaceC5063a<Y8.t> interfaceC5063a) {
                this.$cb = interfaceC5063a;
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void a() {
                super.a();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void onHomeBarCancel() {
                super.onHomeBarCancel();
            }

            @Override // com.stepos.ailauncher.H
            public void onHomeBarCapsuleClick() {
                this.$cb.invoke();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void onHomeBarPressed() {
                super.onHomeBarPressed();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void tryToShowChatView(long j10, boolean z10) {
                super.tryToShowChatView(j10, z10);
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/GlobalApplication$g$b", "Lcom/stepos/ailauncher/H;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.GlobalApplication$g$b */
        public static final class b implements com.stepos.ailauncher.H {
            final /* synthetic */ InterfaceC5063a<Y8.t> $cb;

            public b(InterfaceC5063a<Y8.t> interfaceC5063a) {
                this.$cb = interfaceC5063a;
            }

            @Override // com.stepos.ailauncher.H
            public void a() {
                this.$cb.invoke();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void onHomeBarCancel() {
                super.onHomeBarCancel();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void onHomeBarCapsuleClick() {
                super.onHomeBarCapsuleClick();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void onHomeBarPressed() {
                super.onHomeBarPressed();
            }

            @Override // com.stepos.ailauncher.H
            public /* bridge */ void tryToShowChatView(long j10, boolean z10) {
                super.tryToShowChatView(j10, z10);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public boolean isWhiteHomeBar() {
            return AIHOmeBarService.INSTANCE.j();
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public void notifyChatViewClosed(long startTime) {
            AIHOmeBarService.INSTANCE.k(startTime);
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public boolean notifyHomeBarLighted() {
            return AIHOmeBarService.INSTANCE.l();
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public void openChatViewAfterAgentAuth() {
            AIHOmeBarService.INSTANCE.m();
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public void setOnHomeBarCapsuleClickListener(InterfaceC5063a<Y8.t> listener) {
            a aVar;
            com.stepos.ailauncher.H h10 = this.capsuleCallback;
            if (h10 != null) {
                AIHOmeBarService.INSTANCE.p(h10);
            }
            if (listener != null) {
                aVar = new a(listener);
                AIHOmeBarService.INSTANCE.e(aVar);
            } else {
                aVar = null;
            }
            this.capsuleCallback = aVar;
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public void setOnHomeBarSysUiConnectedListener(InterfaceC5063a<Y8.t> listener) {
            b bVar;
            com.stepos.ailauncher.H h10 = this.sysUiConnectedCallback;
            if (h10 != null) {
                AIHOmeBarService.INSTANCE.p(h10);
            }
            if (listener != null) {
                bVar = new b(listener);
                AIHOmeBarService.Companion companion = AIHOmeBarService.INSTANCE;
                companion.e(bVar);
                if (companion.i()) {
                    listener.invoke();
                }
            } else {
                bVar = null;
            }
            this.sysUiConnectedCallback = bVar;
        }

        @Override // com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService
        public void showHomeBarCapsule(boolean show, String msg) {
            AIHOmeBarService.INSTANCE.q(show, msg);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$h", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$h, reason: case insensitive filesystem */
    public static final class C2166h extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2166h(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.u0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$i", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$i, reason: case insensitive filesystem */
    public static final class C2167i extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2167i(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.v0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$j", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$j, reason: case insensitive filesystem */
    public static final class C2168j extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2168j(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) throws RuntimeException {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.o0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$k", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$k, reason: case insensitive filesystem */
    public static final class C2169k extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2169k(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            C2686b.INSTANCE.d(this.this$0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$l", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$l, reason: case insensitive filesystem */
    public static final class C2170l extends com.stepos.ailauncher.common.startup.h {
        public C2170l(String str, InitStrategy initStrategy, List list, long j10, boolean z10) {
            super(str, initStrategy, list, j10, z10);
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            x5.h.INSTANCE.g();
            C5851b.INSTANCE.d();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$m", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$m, reason: case insensitive filesystem */
    public static final class C2171m extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2171m(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.X();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$n", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$n, reason: case insensitive filesystem */
    public static final class C2172n extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2172n(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.l0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$o", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$o, reason: case insensitive filesystem */
    public static final class C2173o extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2173o(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            h5.c.INSTANCE.c(this.this$0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$p", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.GlobalApplication$p, reason: case insensitive filesystem */
    public static final class C2174p extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2174p(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            W7.a.a(this.this$0.getApplicationContext(), "0ec483562f", false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$q", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class q extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.S();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$r", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class r extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.m0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$s", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class s extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.A0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$t", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class t extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.b0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$u", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class u extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.n0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$v", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class v extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.C0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$w", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class w extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.e0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$x", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class x extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.a0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$y", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class y extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.p0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/GlobalApplication$z", "Lcom/stepos/ailauncher/common/startup/h;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class z extends com.stepos.ailauncher.common.startup.h {
        final /* synthetic */ GlobalApplication this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(String str, InitStrategy initStrategy, List list, long j10, boolean z10, GlobalApplication globalApplication) {
            super(str, initStrategy, list, j10, z10);
            this.this$0 = globalApplication;
        }

        @Override // com.stepos.ailauncher.common.startup.h
        public void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.this$0.B0();
        }
    }

    public static final boolean F0() {
        return AuthManager.INSTANCE.Y();
    }

    public static final TaskVectorIndexServiceImpl G0(GlobalApplication globalApplication) {
        return new TaskVectorIndexServiceImpl(globalApplication);
    }

    public static final InterfaceC4757d.c T(GlobalApplication globalApplication, String dbName) {
        kotlin.jvm.internal.p.i(dbName, "dbName");
        return com.stepos.ailauncher.storage.database.cipher.a.d(com.stepos.ailauncher.storage.database.cipher.a.INSTANCE, globalApplication, dbName, true, false, 8, null);
    }

    public static final Y8.t Y(RecentsWindowMonitor.RecentsState state) {
        kotlin.jvm.internal.p.i(state, "state");
        com.stepos.ailauncher.common.utils.r.INSTANCE.G(state == RecentsWindowMonitor.RecentsState.OVERVIEW);
        return Y8.t.f7040a;
    }

    public static final void Z(GlobalApplication globalApplication, r.ForegroundApp app) {
        kotlin.jvm.internal.p.i(app, "app");
        WakeAnywhereActivity.INSTANCE.b(globalApplication, app.getPackageName(), app.getIsHomeLauncher());
    }

    public static final Y8.t g0(GlobalApplication globalApplication, HttpConfig.Builder init) {
        kotlin.jvm.internal.p.i(init, "$this$init");
        init.setDebug(false);
        BizInterceptor.Companion companion = BizInterceptor.INSTANCE;
        init.setAppId(companion.getAppId(globalApplication));
        init.setAppSecret(companion.getAppSecret(globalApplication));
        RetrofitProvider.setBaseUrl(C4.a.INSTANCE.a(globalApplication).c());
        init.setDefaultBaseUrl(RetrofitProvider.getBaseUrl());
        H5.a aVar = H5.a.INSTANCE;
        init.addBaseUrl("skillStore", aVar.a(globalApplication).d());
        init.addBaseUrl(ContentSafetyApi.BASE_URL_KEY, aVar.a(globalApplication).f());
        init.addBaseUrl("botMsg", aVar.a(globalApplication).n());
        init.addBaseUrl("amooExpress", aVar.a(globalApplication).k());
        init.addBaseUrl(CredentialApi.BASE_URL_KEY, aVar.a(globalApplication).l());
        String strT = aVar.a(globalApplication).t();
        if (La.H.x0(strT)) {
            strT = null;
        }
        if (strT == null || init.addBaseUrl("appStore", strT) == null) {
            C4148a.u(TAG, "appStore baseUrl 未配置，应用详情元数据将不可用（见 IEnvConfig.getAppStoreBaseUrl）", false, 4, null);
        }
        String strJ = aVar.a(globalApplication).j();
        if (La.H.x0(strJ)) {
            strJ = null;
        }
        if (strJ == null || init.addBaseUrl("mcpGw", strJ) == null) {
            C4148a.u(TAG, "mcpGw baseUrl 未配置，打车卡端侧轮询将不启动（见 IEnvConfig.getMcpGwBaseUrl）", false, 4, null);
        }
        k0.INSTANCE.a(aVar.a(globalApplication).u());
        String strC = aVar.a(globalApplication).c();
        if (La.H.x0(strC)) {
            strC = null;
        }
        if (strC == null || init.addBaseUrl("agiAiTools", strC) == null) {
            C4148a.u(TAG, "agiAiTools baseUrl 未配置，滴滴端侧刷卡将不启动（见 IEnvConfig.getAgiAiToolsBaseUrl）", false, 4, null);
        }
        String strQ = aVar.a(globalApplication).q();
        if (La.H.x0(strQ)) {
            strQ = null;
        }
        if (strQ == null || init.addBaseUrl("didiOauth", strQ) == null) {
            C4148a.u(TAG, "didiOauth baseUrl 未配置，滴滴授权状态不会查询（见 IEnvConfig.getDidiOauthBaseUrl）", false, 4, null);
        }
        String strO = aVar.a(globalApplication).o();
        if (La.H.x0(strO)) {
            strO = null;
        }
        if (strO == null || init.addBaseUrl("credentialService", strO) == null) {
            C4148a.u(TAG, "credentialService baseUrl 未配置，三方授权取数将不可用（见 IEnvConfig.getCredentialServiceBaseUrl）", false, 4, null);
        }
        String strM = aVar.a(globalApplication).m();
        if (La.H.x0(strM)) {
            strM = null;
        }
        if (strM == null || init.addBaseUrl("caocaoCredentialStatus", strM) == null) {
            C4148a.u(TAG, "caocaoCredentialStatus baseUrl 未配置，曹操授权状态不会查询", false, 4, null);
        }
        init.setPrivacyGate(new InterfaceC5063a() { // from class: com.stepos.ailauncher.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(GlobalApplication.h0());
            }
        });
        init.setTokenProvider(new C2164f());
        init.setGlobalErrorListener(new InterfaceC5074l() { // from class: com.stepos.ailauncher.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GlobalApplication.i0((ApiException) obj);
            }
        });
        init.setMetricsListener(new InterfaceC5074l() { // from class: com.stepos.ailauncher.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GlobalApplication.j0((HttpMetrics) obj);
            }
        });
        return Y8.t.f7040a;
    }

    public static final boolean h0() {
        return com.stepos.ailauncher.common.privacy.b.INSTANCE.b();
    }

    public static final Y8.t i0(ApiException ex) {
        kotlin.jvm.internal.p.i(ex, "ex");
        C4148a.g(TAG, "Network error: ", ex, false, 8, null);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t j0(G7.HttpMetrics r28) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.GlobalApplication.j0(G7.c):Y8.t");
    }

    public static final com.stepos.agentframework.chatui.appui.a q0() {
        return new C3698a();
    }

    public static final com.stepos.agentframework.chatui.appui.a r0() {
        return new C3702e();
    }

    public static final com.stepos.agentframework.chatui.appui.a s0() {
        return new C3701d();
    }

    public static final com.stepos.agentframework.chatui.appui.a t0() {
        return new C3700c();
    }

    public static final String w0() {
        return "live=" + RemoteAppUIHostView.INSTANCE.a().get();
    }

    public static final String x0() {
        return "live=" + AgentWebView.INSTANCE.a().get();
    }

    public static final String y0() {
        return "live=" + com.stepos.agentframework.chatui.appui.taskrobot.f.INSTANCE.a().get();
    }

    public static final String z0() {
        return "live=" + com.stepos.agentframework.chatui.appui.taskrobot.b.INSTANCE.a().get();
    }

    public final void A0() {
        DictionaryRepositoryManager.INSTANCE.preloadUiConfig(kotlinx.coroutines.d.b());
    }

    public final void B0() {
        D5.a aVar = D5.a.INSTANCE;
        aVar.b(IExpressService.class, new ExpressServiceImpl());
        aVar.b(IAccountStatusService.class, AccountStatusServiceImpl.INSTANCE);
        aVar.b(IOverlayPageRegistry.class, new g0());
        aVar.b(IAgentSpaceService.class, new AgentSpaceServiceImpl());
        aVar.b(IExternalAgentUiService.class, new ExternalAgentUiServiceImpl());
        aVar.b(IAgentMarketService.class, new AgentMarketServiceImpl());
        aVar.b(IFloatCardService.class, new FloatCardServiceImpl());
        aVar.b(X4.a.class, SkillOperaManager.INSTANCE);
        aVar.b(ITaskStoreService.class, new TaskStoreServiceImpl());
        aVar.b(IRiskLiveNotificationService.class, new C3728p());
        aVar.b(ILiveNotificationService.class, new C3720h());
        com.stepos.ailauncher.foundation.appui.card.provider.alipay.E.INSTANCE.d();
        aVar.b(IVectorIndexService.class, Q());
        aVar.b(IUnifiedSessionSearchService.class, new UnifiedSessionSearchServiceImpl(this));
        aVar.b(IChatRoundAbortService.class, new C4170c());
        aVar.b(ISpeechService.class, new SpeechServiceImpl(this));
        aVar.b(IFeishuConnectService.class, new U4.b());
        aVar.b(IWecomConnectService.class, new V4.b());
        aVar.b(ISkillUiService.class, new b5.o());
        aVar.b(IRepairService.class, new E0());
        aVar.b(IArtifactDetailPageProvider.class, new C3528k());
        aVar.b(IPoiDetailPageProvider.class, new com.stepos.ailauncher.task.amap.a());
        aVar.b(IExternalAgentBindService.class, new MockExternalAgentBindService());
        aVar.b(IHomeBarSysUiService.class, new C2165g());
    }

    public final void C0() {
        com.stepos.ailauncher.configuration.b.INSTANCE.a().f();
    }

    public final void D0() {
        s6.b.a();
    }

    public final void E0() {
        com.stepos.ailauncher.common.startup.g gVarV = com.stepos.ailauncher.common.startup.g.INSTANCE.v(new InterfaceC5063a() { // from class: com.stepos.ailauncher.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(GlobalApplication.F0());
            }
        });
        InitStrategy initStrategy = InitStrategy.BACKGROUND;
        com.stepos.ailauncher.common.startup.g gVarS = gVarV.s(new r("policySdk", initStrategy, C1173v.m(), 0L, false, this)).s(new C("fileStorage", initStrategy, C1173v.m(), 0L, false, this)).s(new J("slaAtomicSdk", initStrategy, C1173v.m(), 0L, false));
        InitStrategy initStrategy2 = InitStrategy.MAIN_IMMEDIATE;
        gVarS.s(new K("finalizerWatchdogGuard", initStrategy2, C1173v.m(), 0L, false)).s(new L("account", initStrategy2, C1173v.m(), 0L, false, this)).s(new M("httpConfig", initStrategy2, C1173v.m(), 0L, false, this)).s(new N("appContext", initStrategy2, C1173v.m(), 0L, false, this)).s(new O("micMonitor", initStrategy2, C1173v.m(), 0L, false, this)).s(new P("foregroundTracker", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2166h("tempPowerMonitor", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2167i("wallpaperColor", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2168j("storage", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2169k("accountIdentityReconcile", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2170l("voiceWakeupSwitchSync", initStrategy2, C1173v.m(), 0L, false)).s(new C2171m("appSwitch", initStrategy2, C1173v.m(), 0L, false, this)).s(new C2172n("networkMonitor", initStrategy2, C1173v.m(), 0L, true, this)).s(new C2173o("analytics", initStrategy2, C1173v.m(), 0L, true, this)).s(new C2174p("crashReport", initStrategy, C1173v.m(), 0L, true, this)).s(new q("agentFramework", initStrategy2, C1173v.m(), 0L, true, this)).s(new s("dictionaryPreload", initStrategy2, C1173v.m(), 0L, true, this)).s(new t("chatManagers", initStrategy2, C1173v.m(), 0L, false, this)).s(new u("recentsWindowMonitor", initStrategy2, C1173v.m(), 0L, false, this)).s(new v("configDispatcher", initStrategy2, C1173v.m(), 0L, false, this)).s(new w("guiAgentControllers", initStrategy2, C1173v.m(), 0L, true, this)).s(new x("card", initStrategy2, C1173v.m(), 0L, false, this)).s(new y("taskStore", initStrategy2, C1173v.m(), 0L, true, this)).s(new z("apiServices", initStrategy2, C1173v.m(), 0L, false, this)).s(new A("apiServicesNetwork", initStrategy2, C1173v.m(), 0L, true, this)).s(new B("overlayPages", initStrategy2, C1173v.m(), 0L, false, this)).s(new D("agentSpace", initStrategy2, C1173v.m(), 0L, true, this)).s(new E("express", initStrategy2, C1173v.m(), 0L, true, this)).s(new F("guiListener", initStrategy2, C1173v.m(), 0L, true)).s(new G("sprite", initStrategy2, C1173v.m(), 0L, false, this)).s(new H("prefetchSession", InitStrategy.MAIN_IDLE, C1173v.m(), 0L, true)).s(new I("agentCache", InitStrategy.DELAYED, C1173v.m(), 500L, true, this)).w(this);
    }

    public final void H0() {
        C1060i.d(kotlinx.coroutines.d.b(), null, null, new GlobalApplication$warmUpNetworkServices$1(null), 3, null);
        AgentFileSyncProvider.INSTANCE.m();
        C1060i.d(kotlinx.coroutines.d.b(), Y.b(), null, new GlobalApplication$warmUpNetworkServices$2(null), 2, null);
    }

    public final IVectorIndexService Q() {
        return (IVectorIndexService) this.vectorIndexService.getValue();
    }

    public final void R(Context context) {
        AgentCacheSdk.init$default(AgentCacheSdk.INSTANCE, context, null, null, 6, null);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.C(new C2160b());
    }

    public final void S() {
        O6.a aVar = O6.a.INSTANCE;
        aVar.e(new C2161c());
        I5.b bVarA = H5.a.INSTANCE.a(this);
        C3954a.INSTANCE.a(this, new AgentFrameworkConfig(bVarA.getAppId(), bVarA.i(), bVarA.f(), bVarA.p(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GlobalApplication.T(this.f23852a, (String) obj);
            }
        }), C1173v.p(ApiType.AGENTBUS, ApiType.AGENTBUS_BFF));
        aVar.f(com.stepos.ailauncher.agent.aispace.w.INSTANCE);
        com.stepos.ailauncher.chat.manager.Y.INSTANCE.a();
    }

    public final void U() {
        IAgentSpaceService iAgentSpaceService = (IAgentSpaceService) D5.a.INSTANCE.a(IAgentSpaceService.class);
        if (iAgentSpaceService != null) {
            iAgentSpaceService.init();
        }
    }

    public final void V() {
        com.stepos.ailauncher.sprite.d.INSTANCE.o(this);
    }

    public final void W() {
        C3197a.INSTANCE.b(this);
    }

    public final void X() {
        com.stepos.ailauncher.common.utils.r rVar = com.stepos.ailauncher.common.utils.r.INSTANCE;
        rVar.r(this);
        RecentsWindowMonitor.INSTANCE.c(new InterfaceC5074l() { // from class: com.stepos.ailauncher.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GlobalApplication.Y((RecentsWindowMonitor.RecentsState) obj);
            }
        });
        rVar.o(new r.b() { // from class: com.stepos.ailauncher.G
            @Override // com.stepos.ailauncher.common.utils.r.b
            public final void a(r.ForegroundApp foregroundApp) {
                GlobalApplication.Z(this.f23853a, foregroundApp);
            }
        });
    }

    public final void a0() {
        Object objB;
        Object objB2;
        S5.a.INSTANCE.a(this);
        try {
            Result.Companion companion = Result.INSTANCE;
            AppCenterSdk.getInstance().init(this);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h("GlobalApplication", "AppCenterSdk init failed: " + thE.getMessage(), false, 4, null);
        }
        try {
            C4941b.INSTANCE.d(this);
            C4169b.INSTANCE.d(this);
            objB2 = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            C4148a.h("GlobalApplication", "DidiAuthResumeMonitor start failed: " + thE2.getMessage(), false, 4, null);
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        kotlin.jvm.internal.p.i(base, "base");
        super.attachBaseContext(z5.c.INSTANCE.h(base));
    }

    public final void b0() {
        InputViewManager.INSTANCE.G0(this);
        C2536e.INSTANCE.d(this);
        com.stepos.ailauncher.chat.trace.e.INSTANCE.d(this);
        C2673f.INSTANCE.g(this);
        com.stepos.ailauncher.chat.trace.i.INSTANCE.a();
        C2703j0.INSTANCE.b();
    }

    public final void c0() {
        FileStorageManager fileStorageManager = FileStorageManager.INSTANCE;
        BizInterceptor.Companion companion = BizInterceptor.INSTANCE;
        fileStorageManager.m(new FileStorageConfig(companion.getAppId(this), companion.getAppSecret(this), "os_app", H5.a.INSTANCE.a(this).h(), "file-storage", null, "client", null, 0, 0, 0L, 0L, 0L, 0L, 16288, null), C2162d.INSTANCE, new C2163e());
    }

    public final void d0() {
        C3202f.INSTANCE.f(this);
    }

    public final void e0() {
    }

    public final void f0() {
        HttpManager.INSTANCE.init(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GlobalApplication.g0(this.f23851a, (HttpConfig.Builder) obj);
            }
        });
    }

    public final void k0() {
        MicOccupancyMonitor.INSTANCE.m(this);
    }

    public final void l0() {
        NetworkStateMonitor.f(this);
    }

    public final void m0() {
        HashMap map = new HashMap();
        map.put("pp", "file:////android_asset/pp_15.html");
        map.put("up", "file:////android_asset/up_2.html");
        map.put("ueip", "file:////android_asset/ueip_2.html");
        map.put("vrs", "file:////android_asset/vrs_2.html");
        map.put("picl", "file:////android_asset/picl_1.html");
        map.put("per", "file:////android_asset/per_1.html");
        map.put("tisl", "file:////android_asset/tisl_1.html");
        map.put("pcpi", "file:////android_asset/pcpi_1.html");
        String strB = C6.a.INSTANCE.b(this);
        PolicySdk.setCloudPolicyUidCategoryMap(kotlin.collections.a.k(Y8.j.a("1d68483a1fc441529efe7352440c7286", "picl"), Y8.j.a("fe814e2f33ae4f74b75faed3f9056186", "per"), Y8.j.a("720416230ae34ab9817ad22fddc3cf85", "tisl"), Y8.j.a("1fc85872a3d849289a89936263e3669f", "pcpi")));
        PolicySdk.setBlockNetworkBeforeAgree(true);
        PolicySdk.initSDK(this, "18299428619464943300", "e5f666b6c55f4817aac1c83effd15bca", strB, map);
        C4148a.d(TAG, "PolicySdk initialized", false, 4, null);
    }

    public final void n0() {
        com.stepos.ailauncher.homegesture.w.INSTANCE.c(this);
        RecentsWindowMonitor.INSTANCE.k(this);
        j5.b.INSTANCE.b(this);
        MinusOneHomeRoots.INSTANCE.d();
        com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.m(this);
    }

    public final void o0() throws RuntimeException {
        C4904a.INSTANCE.c(this);
        com.stepos.ailauncher.debug.a.INSTANCE.a();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        z5.c cVar = z5.c.INSTANCE;
        Resources resources = getResources();
        kotlin.jvm.internal.p.h(resources, "getResources(...)");
        cVar.f(resources, newConfig);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        androidx.appcompat.app.g.M(2);
        z5.c cVar = z5.c.INSTANCE;
        Resources resources = getResources();
        kotlin.jvm.internal.p.h(resources, "getResources(...)");
        cVar.e(resources);
        String processName = Application.getProcessName();
        if (!kotlin.jvm.internal.p.d(processName, getPackageName())) {
            Log.d(TAG, "onCreate skipped in child process: " + processName + " (main=" + getPackageName() + ")");
            return;
        }
        h8.h.c(h8.h.f32979a, this, null, 2, null);
        B5.c.INSTANCE.d(this);
        C4148a.d(TAG, "onCreate", false, 4, null);
        AIHOmeBarService.INSTANCE.f(this);
        com.stepos.ailauncher.common.imageloader.g.INSTANCE.o(this);
        com.stepos.ailauncher.common.memory.e.INSTANCE.g(this);
        com.stepos.ailauncher.common.memory.d dVar = com.stepos.ailauncher.common.memory.d.INSTANCE;
        dVar.k(this);
        try {
            Result.Companion companion = Result.INSTANCE;
            dVar.s("appuiCard", new d.a() { // from class: com.stepos.ailauncher.y
                @Override // com.stepos.ailauncher.common.memory.d.a
                public final String a() {
                    return GlobalApplication.w0();
                }
            });
            dVar.s("agentWebView", new d.a() { // from class: com.stepos.ailauncher.z
                @Override // com.stepos.ailauncher.common.memory.d.a
                public final String a() {
                    return GlobalApplication.x0();
                }
            });
            dVar.s("taskRobotSurface", new d.a() { // from class: com.stepos.ailauncher.A
                @Override // com.stepos.ailauncher.common.memory.d.a
                public final String a() {
                    return GlobalApplication.y0();
                }
            });
            dVar.s("appuiSurfaceView", new d.a() { // from class: com.stepos.ailauncher.B
                @Override // com.stepos.ailauncher.common.memory.d.a
                public final String a() {
                    return GlobalApplication.z0();
                }
            });
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        z5.c.INSTANCE.g(this);
        E0();
    }

    public final void p0() {
        TaskStoreModule.INSTANCE.q(this);
        com.stepos.agentframework.chatui.appui.f fVar = com.stepos.agentframework.chatui.appui.f.INSTANCE;
        fVar.b(m.TaskMessage.defaultTaskCardAppUIName, new InterfaceC5063a() { // from class: com.stepos.ailauncher.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GlobalApplication.q0();
            }
        });
        fVar.b(m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GlobalApplication.r0();
            }
        });
        fVar.b("app_ui_name_task_result_file", new InterfaceC5063a() { // from class: com.stepos.ailauncher.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GlobalApplication.s0();
            }
        });
        fVar.b(C3700c.APP_UI_NAME, new InterfaceC5063a() { // from class: com.stepos.ailauncher.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GlobalApplication.t0();
            }
        });
        O5.c.INSTANCE.c();
        C1500a.INSTANCE.a(this);
        AgentBusEventRouter.INSTANCE.h0();
    }

    public final void u0() {
        TempPowerLowMonitor.INSTANCE.i(this);
    }

    public final void v0() {
        com.stepos.ailauncher.container.wallpaper.e.b();
        com.stepos.ailauncher.container.wallpaper.c.INSTANCE.f(this);
    }
}
