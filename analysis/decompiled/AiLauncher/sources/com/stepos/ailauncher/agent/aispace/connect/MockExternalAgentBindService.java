package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1056g;
import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository;
import com.stepos.ailauncher.agent.aispace.connect.data.DeviceAgentItem;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository;
import com.stepos.ailauncher.agent.aispace.market.data.GetAgentStatusData;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010 \u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001f\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b \u0010!JC\u0010&\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b&\u0010'J-\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b*\u0010+J-\u0010-\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b-\u0010+J-\u0010/\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b/\u0010+J-\u00101\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b1\u0010+JC\u00102\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b2\u0010'JC\u00103\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b3\u0010'J+\u00104\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001eH\u0016¢\u0006\u0004\b4\u0010+J\u001a\u00106\u001a\u0004\u0018\u00010\u00102\u0006\u00105\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/MockExternalAgentBindService;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService;", "<init>", "()V", "", "deviceToken", "agentType", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "callback", "LY8/t;", "bindDevice", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "listConnectedDevices", "()Ljava/util/List;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "listSidebarAgents", "deviceId", "findDevice", "(Ljava/lang/String;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "", "alsoDeleteData", "deleteDevice", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "newName", "renameDevice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "reconnectDevice", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lkotlin/Result;", "queryDeviceAgentOnline", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "assetId", "reversionId", "semver", "displayName", "uninstallInstalledAgent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "agentId", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ReinstallInfo;", "resolveReinstallableAgent", "(Ljava/lang/String;Lp9/l;)V", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$UpdateInfo;", "resolveUpdatableAgent", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$DisabledInfo;", "resolveDisabledMarketAgent", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyInfo;", "resolveBusyMarketAgent", "installMarketAgent", "updateMarketAgent", "enableMarketAgent", "id", "o", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "LUa/M;", "scope", "LUa/M;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MockExternalAgentBindService implements IExternalAgentBindService {
    private static final a Companion = new a(null);
    private static final String TAG = "ExternalAgentBindSvc";
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Ua.M scope = kotlinx.coroutines.d.a(Ua.Y.b().plus(Ua.L0.b(null, 1, null)));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/MockExternalAgentBindService$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$bindDevice$1", f = "MockExternalAgentBindService.kt", l = {53}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$bindDevice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $agentType;
        final /* synthetic */ IExternalAgentBindService.BindCallback $callback;
        final /* synthetic */ String $deviceToken;
        int label;
        final /* synthetic */ MockExternalAgentBindService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, MockExternalAgentBindService mockExternalAgentBindService, IExternalAgentBindService.BindCallback bindCallback, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$deviceToken = str;
            this.$agentType = str2;
            this.this$0 = mockExternalAgentBindService;
            this.$callback = bindCallback;
        }

        public static final void h(Object obj, IExternalAgentBindService.BindCallback bindCallback) {
            Throwable thE = Result.e(obj);
            if (thE == null) {
                bindCallback.onSuccess((IExternalAgentBindService.ConnectedDevice) obj);
                return;
            }
            String message = thE.getMessage();
            if (message == null) {
                message = "bind failed";
            }
            bindCallback.onFailure(message);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$deviceToken, this.$agentType, this.this$0, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                kotlin.C4849c.b(r6)
                kotlin.Result r6 = (kotlin.Result) r6
                java.lang.Object r6 = r6.getValue()
                goto L31
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1d:
                kotlin.C4849c.b(r6)
                com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r6 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.INSTANCE
                java.lang.String r1 = r5.$deviceToken
                java.lang.String r3 = r5.$agentType
                r5.label = r2
                java.lang.String r4 = ""
                java.lang.Object r6 = r6.q(r4, r1, r3, r5)
                if (r6 != r0) goto L31
                return r0
            L31:
                java.lang.String r0 = r5.$agentType
                boolean r1 = kotlin.Result.h(r6)
                if (r1 == 0) goto L58
                com.stepos.ailauncher.agent.aispace.connect.data.q r6 = (com.stepos.ailauncher.agent.aispace.connect.data.DeviceInfoDto) r6
                java.lang.String r1 = r6.getDeviceId()
                java.lang.String r3 = r6.getDeviceName()
                if (r3 == 0) goto L4f
                boolean r4 = La.H.x0(r3)
                if (r4 != 0) goto L4c
                goto L4d
            L4c:
                r3 = 0
            L4d:
                if (r3 != 0) goto L53
            L4f:
                java.lang.String r3 = r6.getDeviceId()
            L53:
                com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice r6 = new com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice
                r6.<init>(r1, r3, r0, r2)
            L58:
                java.lang.Object r6 = kotlin.Result.b(r6)
                com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService r0 = r5.this$0
                android.os.Handler r0 = com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.i(r0)
                com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$BindCallback r5 = r5.$callback
                com.stepos.ailauncher.agent.aispace.connect.x0 r1 = new com.stepos.ailauncher.agent.aispace.connect.x0
                r1.<init>()
                r0.post(r1)
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$deleteDevice$1", f = "MockExternalAgentBindService.kt", l = {102}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$deleteDevice$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21791 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
        final /* synthetic */ String $agentType;
        final /* synthetic */ String $deviceId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21791(String str, String str2, InterfaceC4014c<? super C21791> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$deviceId = str;
            this.$agentType = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21791(this.$deviceId, this.$agentType, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((C21791) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objN;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                String str = this.$deviceId;
                String str2 = this.$agentType;
                this.label = 1;
                objN = agentDeviceRepository.n(str, str2, false, this);
                if (objN == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objN = ((Result) obj).getValue();
            }
            return Result.g(objN) ? C4109a.a(false) : objN;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$enableMarketAgent$1", f = "MockExternalAgentBindService.kt", l = {354}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$enableMarketAgent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21801 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $assetId;
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $callback;
        int label;
        final /* synthetic */ MockExternalAgentBindService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21801(String str, MockExternalAgentBindService mockExternalAgentBindService, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21801> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$assetId = str;
            this.this$0 = mockExternalAgentBindService;
            this.$callback = interfaceC5074l;
        }

        public static final void h(InterfaceC5074l interfaceC5074l, boolean z10) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21801(this.$assetId, this.this$0, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21801) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            final boolean zH;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                if (La.H.x0(this.$assetId)) {
                    zH = false;
                    C4148a.u(MockExternalAgentBindService.TAG, "enableMarketAgent: blank assetId", false, 4, null);
                    Handler handler = this.this$0.main;
                    final InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = this.$callback;
                    handler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.y0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MockExternalAgentBindService.C21801.h(interfaceC5074l, zH);
                        }
                    });
                    return Y8.t.f7040a;
                }
                AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
                String str = this.$assetId;
                this.label = 1;
                objC = agentMarketRepository.C(str, true, this);
                if (objC == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objC = ((Result) obj).getValue();
            }
            zH = Result.h(objC);
            Handler handler2 = this.this$0.main;
            final InterfaceC5074l interfaceC5074l2 = this.$callback;
            handler2.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.y0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.C21801.h(interfaceC5074l2, zH);
                }
            });
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$listConnectedDevices$1", f = "MockExternalAgentBindService.kt", l = {79}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$listConnectedDevices$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21811 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends IExternalAgentBindService.ConnectedDevice>>, Object> {
        int label;

        public C21811(InterfaceC4014c<? super C21811> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21811(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<IExternalAgentBindService.ConnectedDevice>> interfaceC4014c) {
            return ((C21811) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                this.label = 1;
                objD = agentDeviceRepository.D(this);
                if (objD == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objD = ((Result) obj).getValue();
            }
            List listM = C1173v.m();
            if (Result.g(objD)) {
                objD = listM;
            }
            Iterable iterable = (Iterable) objD;
            ArrayList arrayList = new ArrayList(C1174w.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(AgentDeviceRepository.INSTANCE.S((DeviceAgentItem) it.next()));
            }
            return arrayList;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends IExternalAgentBindService.ConnectedDevice>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super List<IExternalAgentBindService.ConnectedDevice>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$listSidebarAgents$1", f = "MockExternalAgentBindService.kt", l = {90}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$listSidebarAgents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21821 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends IExternalAgentBindService.SidebarAgent>>, Object> {
        int label;

        public C21821(InterfaceC4014c<? super C21821> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21821(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<IExternalAgentBindService.SidebarAgent>> interfaceC4014c) {
            return ((C21821) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objH;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                this.label = 1;
                objH = agentDeviceRepository.H(this);
                if (objH == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objH = ((Result) obj).getValue();
            }
            return Result.g(objH) ? C1173v.m() : objH;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends IExternalAgentBindService.SidebarAgent>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super List<IExternalAgentBindService.SidebarAgent>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$queryDeviceAgentOnline$1", f = "MockExternalAgentBindService.kt", l = {132}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$queryDeviceAgentOnline$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21831 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $agentType;
        final /* synthetic */ InterfaceC5074l<Result<Boolean>, Y8.t> $callback;
        final /* synthetic */ String $deviceId;
        int label;
        final /* synthetic */ MockExternalAgentBindService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21831(String str, String str2, MockExternalAgentBindService mockExternalAgentBindService, InterfaceC5074l<? super Result<Boolean>, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21831> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$deviceId = str;
            this.$agentType = str2;
            this.this$0 = mockExternalAgentBindService;
            this.$callback = interfaceC5074l;
        }

        public static final void h(InterfaceC5074l interfaceC5074l, Object obj) {
            interfaceC5074l.invoke(Result.a(obj));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21831(this.$deviceId, this.$agentType, this.this$0, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21831) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final Object objJ;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                String str = this.$deviceId;
                String str2 = this.$agentType;
                this.label = 1;
                objJ = agentDeviceRepository.J(str, str2, this);
                if (objJ == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objJ = ((Result) obj).getValue();
            }
            String str3 = this.$deviceId;
            String str4 = this.$agentType;
            if (Result.h(objJ)) {
                com.stepos.ailauncher.agent.aispace.w.INSTANCE.b(str3, str4, ((Boolean) objJ).booleanValue());
            }
            Handler handler = this.this$0.main;
            final InterfaceC5074l<Result<Boolean>, Y8.t> interfaceC5074l = this.$callback;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.z0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.C21831.h(interfaceC5074l, objJ);
                }
            });
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$reconnectDevice$1", f = "MockExternalAgentBindService.kt", l = {119}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$reconnectDevice$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21841 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
        final /* synthetic */ String $deviceId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21841(String str, InterfaceC4014c<? super C21841> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$deviceId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21841(this.$deviceId, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((C21841) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objK;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                String str = this.$deviceId;
                this.label = 1;
                objK = agentDeviceRepository.K(str, this);
                if (objK == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objK = ((Result) obj).getValue();
            }
            return Result.g(objK) ? C4109a.a(false) : objK;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$renameDevice$1", f = "MockExternalAgentBindService.kt", l = {109}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$renameDevice$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21851 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
        final /* synthetic */ String $agentType;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $newName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21851(String str, String str2, String str3, InterfaceC4014c<? super C21851> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$deviceId = str;
            this.$agentType = str2;
            this.$newName = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21851(this.$deviceId, this.$agentType, this.$newName, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((C21851) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objL;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                String str = this.$deviceId;
                String str2 = this.$agentType;
                String str3 = this.$newName;
                this.label = 1;
                objL = agentDeviceRepository.L(str, str2, str3, this);
                if (objL == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objL = ((Result) obj).getValue();
            }
            return Result.g(objL) ? C4109a.a(false) : objL;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveBusyMarketAgent$2", f = "MockExternalAgentBindService.kt", l = {267}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveBusyMarketAgent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<IExternalAgentBindService.BusyInfo, Y8.t> $callback;
        final /* synthetic */ String $id;
        int label;
        final /* synthetic */ MockExternalAgentBindService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(String str, MockExternalAgentBindService mockExternalAgentBindService, InterfaceC5074l<? super IExternalAgentBindService.BusyInfo, Y8.t> interfaceC5074l, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
            this.this$0 = mockExternalAgentBindService;
            this.$callback = interfaceC5074l;
        }

        public static final void h(InterfaceC5074l interfaceC5074l, IExternalAgentBindService.BusyKind busyKind, String str) {
            interfaceC5074l.invoke(busyKind != null ? new IExternalAgentBindService.BusyInfo(str, busyKind) : null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$id, this.this$0, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objP;
            String upperCase;
            String status;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
                String str = this.$id;
                this.label = 1;
                objP = agentMarketRepository.p(str, this);
                if (objP == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objP = ((Result) obj).getValue();
            }
            final IExternalAgentBindService.BusyKind busyKind = null;
            if (Result.g(objP)) {
                objP = null;
            }
            GetAgentStatusData getAgentStatusData = (GetAgentStatusData) objP;
            if (getAgentStatusData == null || (status = getAgentStatusData.getStatus()) == null) {
                upperCase = null;
            } else {
                upperCase = status.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            }
            if (upperCase != null) {
                switch (upperCase.hashCode()) {
                    case -805319996:
                        if (upperCase.equals("AGENT_STATUS_PENDING")) {
                            busyKind = IExternalAgentBindService.BusyKind.PENDING;
                            break;
                        }
                        break;
                    case -398663686:
                        if (upperCase.equals("AGENT_STATUS_INSTALLING")) {
                            busyKind = IExternalAgentBindService.BusyKind.INSTALLING;
                            break;
                        }
                        break;
                    case 113944211:
                        if (upperCase.equals("AGENT_STATUS_UNINSTALLING")) {
                            busyKind = IExternalAgentBindService.BusyKind.UNINSTALLING;
                            break;
                        }
                        break;
                    case 1812867993:
                        if (upperCase.equals("AGENT_STATUS_UPDATING")) {
                            busyKind = IExternalAgentBindService.BusyKind.UPDATING;
                            break;
                        }
                        break;
                }
            }
            Handler handler = this.this$0.main;
            final InterfaceC5074l<IExternalAgentBindService.BusyInfo, Y8.t> interfaceC5074l = this.$callback;
            final String str2 = this.$id;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.A0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.AnonymousClass2.h(interfaceC5074l, busyKind, str2);
                }
            });
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveDisabledMarketAgent$2", f = "MockExternalAgentBindService.kt", l = {240, 241, 247}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveDisabledMarketAgent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C21862 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<IExternalAgentBindService.DisabledInfo, Y8.t> $callback;
        final /* synthetic */ String $id;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21862(String str, InterfaceC5074l<? super IExternalAgentBindService.DisabledInfo, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21862> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
            this.$callback = interfaceC5074l;
        }

        public static final void h(InterfaceC5074l interfaceC5074l, IExternalAgentBindService.DisabledInfo disabledInfo) {
            interfaceC5074l.invoke(disabledInfo);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return MockExternalAgentBindService.this.new C21862(this.$id, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21862) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ce, code lost:
        
            if (r15 == r0) goto L46;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0110  */
        /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r15v17, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.C21862.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveReinstallableAgent$2", f = "MockExternalAgentBindService.kt", l = {DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 173, 181}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveReinstallableAgent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C21872 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<IExternalAgentBindService.ReinstallInfo, Y8.t> $callback;
        final /* synthetic */ String $id;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21872(String str, InterfaceC5074l<? super IExternalAgentBindService.ReinstallInfo, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21872> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
            this.$callback = interfaceC5074l;
        }

        public static final void i(InterfaceC5074l interfaceC5074l) {
            interfaceC5074l.invoke(null);
        }

        public static final void n(InterfaceC5074l interfaceC5074l, IExternalAgentBindService.ReinstallInfo reinstallInfo) {
            interfaceC5074l.invoke(reinstallInfo);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C21872 c21872 = MockExternalAgentBindService.this.new C21872(this.$id, this.$callback, interfaceC4014c);
            c21872.L$0 = obj;
            return c21872;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21872) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
        
            if (r0 == r7) goto L50;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x013d  */
        /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v20 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.C21872.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveUpdatableAgent$2", f = "MockExternalAgentBindService.kt", l = {208, 211, 216}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveUpdatableAgent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C21882 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<IExternalAgentBindService.UpdateInfo, Y8.t> $callback;
        final /* synthetic */ String $id;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21882(String str, InterfaceC5074l<? super IExternalAgentBindService.UpdateInfo, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21882> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
            this.$callback = interfaceC5074l;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(InterfaceC5074l interfaceC5074l) {
            interfaceC5074l.invoke(null);
        }

        public static final void n(InterfaceC5074l interfaceC5074l, IExternalAgentBindService.UpdateInfo updateInfo) {
            interfaceC5074l.invoke(updateInfo);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C21882 c21882 = MockExternalAgentBindService.this.new C21882(this.$id, this.$callback, interfaceC4014c);
            c21882.L$0 = obj;
            return c21882;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21882) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:49:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0159  */
        /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v21 */
        /* JADX WARN: Type inference failed for: r5v25 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 411
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.C21882.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$uninstallInstalledAgent$1", f = "MockExternalAgentBindService.kt", l = {152}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$uninstallInstalledAgent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C21891 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $assetId;
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $callback;
        final /* synthetic */ String $displayName;
        final /* synthetic */ String $reversionId;
        final /* synthetic */ String $semver;
        int label;
        final /* synthetic */ MockExternalAgentBindService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21891(String str, String str2, String str3, String str4, MockExternalAgentBindService mockExternalAgentBindService, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super C21891> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$assetId = str;
            this.$reversionId = str2;
            this.$semver = str3;
            this.$displayName = str4;
            this.this$0 = mockExternalAgentBindService;
            this.$callback = interfaceC5074l;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(InterfaceC5074l interfaceC5074l, boolean z10) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C21891(this.$assetId, this.$reversionId, this.$semver, this.$displayName, this.this$0, this.$callback, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C21891) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C21891 c21891;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
                String str = this.$assetId;
                String str2 = this.$reversionId;
                String str3 = this.$semver;
                String str4 = this.$displayName;
                this.label = 1;
                c21891 = this;
                obj = agentMarketRepository.G(str, str2, str3, str4, c21891);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                c21891 = this;
            }
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (zBooleanValue) {
                AgentMarketOperaManager.INSTANCE.F(c21891.$assetId);
            }
            Handler handler = c21891.this$0.main;
            final InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = c21891.$callback;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.G0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.C21891.h(interfaceC5074l, zBooleanValue);
                }
            });
            return Y8.t.f7040a;
        }
    }

    public static final void k(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(Boolean.FALSE);
    }

    public static final void l(String str, String str2, String str3, String str4, InterfaceC5074l interfaceC5074l) {
        String str5;
        String str6;
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        if (La.H.x0(str4)) {
            str5 = str;
            str6 = str5;
        } else {
            str5 = str;
            str6 = str4;
        }
        agentMarketOperaManager.z(str5, str2, str3, str6, interfaceC5074l);
    }

    public static final void m(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(null);
    }

    public static final void n(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(null);
    }

    public static final void p(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(null);
    }

    public static final void q(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(null);
    }

    public static final void r(InterfaceC5074l interfaceC5074l) {
        interfaceC5074l.invoke(Boolean.FALSE);
    }

    public static final void s(String str, String str2, String str3, String str4, InterfaceC5074l interfaceC5074l) {
        String str5;
        String str6;
        AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
        if (La.H.x0(str4)) {
            str5 = str;
            str6 = str5;
        } else {
            str5 = str;
            str6 = str4;
        }
        agentMarketOperaManager.W(str5, str2, str3, str6, interfaceC5074l);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void bindDevice(String deviceToken, String agentType, IExternalAgentBindService.BindCallback callback) {
        kotlin.jvm.internal.p.i(deviceToken, "deviceToken");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(callback, "callback");
        C4148a.u(TAG, "bindDevice called (legacy path) — ScanQrActivity 已经内置 confirmDevice，这里只是兼容旧 caller，pair_id 缺失大概率失败", false, 4, null);
        C1060i.d(this.scope, null, null, new AnonymousClass1(deviceToken, agentType, this, callback, null), 3, null);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public boolean deleteDevice(String deviceId, String agentType, boolean alsoDeleteData) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        return ((Boolean) C1056g.h(Ua.Y.b(), new C21791(deviceId, agentType, null))).booleanValue();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void enableMarketAgent(String assetId, InterfaceC5074l<? super Boolean, Y8.t> callback) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(callback, "callback");
        C1060i.d(this.scope, null, null, new C21801(assetId, this, callback, null), 3, null);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public IExternalAgentBindService.ConnectedDevice findDevice(String deviceId) {
        Object next;
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        Iterator<T> it = listConnectedDevices().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((IExternalAgentBindService.ConnectedDevice) next).getDeviceId(), deviceId)) {
                break;
            }
        }
        return (IExternalAgentBindService.ConnectedDevice) next;
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void installMarketAgent(final String assetId, final String reversionId, final String semver, final String displayName, final InterfaceC5074l<? super Boolean, Y8.t> callback) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(callback, "callback");
        if (!La.H.x0(assetId) && !La.H.x0(reversionId) && !La.H.x0(semver)) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.u0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.l(assetId, reversionId, semver, displayName, callback);
                }
            });
            return;
        }
        C4148a.u(TAG, "installMarketAgent: missing params assetId=" + assetId + " rev=" + reversionId + " semver=" + semver, false, 4, null);
        this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.t0
            @Override // java.lang.Runnable
            public final void run() {
                MockExternalAgentBindService.k(callback);
            }
        });
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public List<IExternalAgentBindService.ConnectedDevice> listConnectedDevices() {
        return (List) C1056g.h(Ua.Y.b(), new C21811(null));
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public List<IExternalAgentBindService.SidebarAgent> listSidebarAgents() {
        return (List) C1056g.h(Ua.Y.b(), new C21821(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r6, e9.InterfaceC4014c<? super com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveInstalledSidebarAgent$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveInstalledSidebarAgent$1 r0 = (com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveInstalledSidebarAgent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveInstalledSidebarAgent$1 r0 = new com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService$resolveInstalledSidebarAgent$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.L$1
            com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService r5 = (com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService) r5
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L39
            kotlin.Result r7 = (kotlin.Result) r7     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r7.getValue()     // Catch: java.lang.Throwable -> L39
            goto L5f
        L39:
            r5 = move-exception
            goto Lb2
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L39
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.INSTANCE     // Catch: java.lang.Throwable -> L39
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L39
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L39
            r0.label = r4     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r7.H(r0)     // Catch: java.lang.Throwable -> L39
            if (r5 != r1) goto L5f
            return r1
        L5f:
            boolean r7 = kotlin.Result.g(r5)     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto L66
            r5 = r3
        L66:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto Lac
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L39
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L39
        L70:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto La8
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L39
            r0 = r7
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r0 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent) r0     // Catch: java.lang.Throwable -> L39
            boolean r1 = r0.getInstalled()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L70
            java.lang.String r1 = r0.getAssetId()     // Catch: java.lang.Throwable -> L39
            java.lang.CharSequence r1 = La.H.D1(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L39
            boolean r1 = La.D.L(r1, r6, r4)     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto La9
            java.lang.String r0 = r0.getAgentId()     // Catch: java.lang.Throwable -> L39
            java.lang.CharSequence r0 = La.H.D1(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L39
            boolean r0 = La.D.L(r0, r6, r4)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L70
            goto La9
        La8:
            r7 = r3
        La9:
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r7 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent) r7     // Catch: java.lang.Throwable -> L39
            goto Lad
        Lac:
            r7 = r3
        Lad:
            java.lang.Object r5 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L39
            goto Lbc
        Lb2:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        Lbc:
            boolean r6 = kotlin.Result.g(r5)
            if (r6 == 0) goto Lc3
            goto Lc4
        Lc3:
            r3 = r5
        Lc4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.MockExternalAgentBindService.o(java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void queryDeviceAgentOnline(String deviceId, String agentType, InterfaceC5074l<? super Result<Boolean>, Y8.t> callback) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(callback, "callback");
        C1060i.d(this.scope, null, null, new C21831(deviceId, agentType, this, callback, null), 3, null);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public boolean reconnectDevice(String deviceId) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        return ((Boolean) C1056g.h(Ua.Y.b(), new C21841(deviceId, null))).booleanValue();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public boolean renameDevice(String deviceId, String agentType, String newName) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(newName, "newName");
        return ((Boolean) C1056g.h(Ua.Y.b(), new C21851(deviceId, agentType, newName, null))).booleanValue();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void resolveBusyMarketAgent(String agentId, final InterfaceC5074l<? super IExternalAgentBindService.BusyInfo, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = La.H.D1(agentId).toString();
        if (string.length() == 0) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.r0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.m(callback);
                }
            });
        } else {
            C1060i.d(this.scope, null, null, new AnonymousClass2(string, this, callback, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void resolveDisabledMarketAgent(String agentId, final InterfaceC5074l<? super IExternalAgentBindService.DisabledInfo, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = La.H.D1(agentId).toString();
        if (string.length() == 0) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.s0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.n(callback);
                }
            });
        } else {
            C1060i.d(this.scope, null, null, new C21862(string, callback, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void resolveReinstallableAgent(String agentId, final InterfaceC5074l<? super IExternalAgentBindService.ReinstallInfo, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = La.H.D1(agentId).toString();
        if (string.length() == 0) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.q0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.p(callback);
                }
            });
        } else {
            C1060i.d(this.scope, null, null, new C21872(string, callback, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void resolveUpdatableAgent(String agentId, final InterfaceC5074l<? super IExternalAgentBindService.UpdateInfo, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = La.H.D1(agentId).toString();
        if (string.length() == 0) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.p0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.q(callback);
                }
            });
        } else {
            C1060i.d(this.scope, null, null, new C21882(string, callback, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void uninstallInstalledAgent(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, Y8.t> callback) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(callback, "callback");
        C1060i.d(this.scope, null, null, new C21891(assetId, reversionId, semver, displayName, this, callback, null), 3, null);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService
    public void updateMarketAgent(final String assetId, final String reversionId, final String semver, final String displayName, final InterfaceC5074l<? super Boolean, Y8.t> callback) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(callback, "callback");
        if (!La.H.x0(assetId) && !La.H.x0(reversionId) && !La.H.x0(semver)) {
            this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.w0
                @Override // java.lang.Runnable
                public final void run() {
                    MockExternalAgentBindService.s(assetId, reversionId, semver, displayName, callback);
                }
            });
            return;
        }
        C4148a.u(TAG, "updateMarketAgent: missing params assetId=" + assetId + " rev=" + reversionId + " semver=" + semver, false, 4, null);
        this.main.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.v0
            @Override // java.lang.Runnable
            public final void run() {
                MockExternalAgentBindService.r(callback);
            }
        });
    }
}
