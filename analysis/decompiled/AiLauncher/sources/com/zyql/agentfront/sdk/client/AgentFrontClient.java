package com.zyql.agentfront.sdk.client;

import La.D;
import La.H;
import Y8.t;
import Z8.C1174w;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import c8.AbstractC1504b;
import c8.InterfaceC1505c;
import c8.RetryConfig;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.bean.CancelMessageRequest;
import com.zyql.agentfront.bean.CancelMessageResponse;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.SessionOperationRequest;
import com.zyql.agentfront.bean.SessionOperationResponse;
import com.zyql.agentfront.bean.SyncHistoryRequest;
import com.zyql.agentfront.bean.SyncHistoryResponse;
import com.zyql.agentfront.bean.ToolCall;
import com.zyql.agentfront.bean.ToolCallRequest;
import com.zyql.agentfront.bean.ToolResultRequest;
import com.zyql.agentfront.bean.ToolResultResponse;
import d8.InterfaceC3961a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001Y\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001^B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0017\u001a\u00020\f2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0014¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0014¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020\f¢\u0006\u0004\b'\u0010%J\u0017\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u001d\u0010.\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0015\u00103\u001a\u0002022\u0006\u00101\u001a\u000200¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u0002062\u0006\u00101\u001a\u000205¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u000f¢\u0006\u0004\b9\u0010\u0011J\u0015\u0010<\u001a\u00020;2\u0006\u00101\u001a\u00020:¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\u0006\u0010>\u001a\u00020\u00132\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bA\u0010BJ!\u0010C\u001a\u00020@2\u0006\u0010>\u001a\u00020\u00132\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bC\u0010BJ)\u0010E\u001a\u00020@2\u0006\u0010>\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00132\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020@2\u0006\u00101\u001a\u00020G¢\u0006\u0004\bH\u0010IR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020,0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR \u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020,0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "Lc8/b;", "Lcom/zyql/agentfront/IMessageBridge;", "Landroid/content/Context;", "context", "Lc8/d;", "retryConfig", "<init>", "(Landroid/content/Context;Lc8/d;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "LY8/t;", "c0", "(Ljava/lang/Exception;)V", "", "b0", "()Z", "Lkotlin/Function1;", "", "onFailed", "Lkotlin/Function0;", "onReady", "Z", "(Lp9/l;Lp9/a;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "Y", "(Lcom/zyql/agentfront/bean/Message;)V", "n", "()Ljava/lang/String;", "o", "Landroid/os/IBinder;", "binder", "Q", "(Landroid/os/IBinder;)Lcom/zyql/agentfront/IMessageBridge;", "s", "()V", "t", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/zyql/agentfront/sdk/client/o;", "listener", "m0", "(Lcom/zyql/agentfront/sdk/client/o;)V", "Lcom/zyql/agentfront/sdk/client/j;", "callback", "i0", "(Lcom/zyql/agentfront/bean/Message;Lcom/zyql/agentfront/sdk/client/j;)Ljava/lang/String;", "Lcom/zyql/agentfront/bean/ToolResultRequest;", "request", "Lcom/zyql/agentfront/bean/ToolResultResponse;", "o0", "(Lcom/zyql/agentfront/bean/ToolResultRequest;)Lcom/zyql/agentfront/bean/ToolResultResponse;", "Lcom/zyql/agentfront/bean/CancelMessageRequest;", "Lcom/zyql/agentfront/bean/CancelMessageResponse;", "R", "(Lcom/zyql/agentfront/bean/CancelMessageRequest;)Lcom/zyql/agentfront/bean/CancelMessageResponse;", "d0", "Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "q0", "(Lcom/zyql/agentfront/bean/SyncHistoryRequest;)Lcom/zyql/agentfront/bean/SyncHistoryResponse;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, DidiCardProvider.KEY_TRACE_ID, "Lcom/zyql/agentfront/bean/SessionOperationResponse;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SessionOperationResponse;", ExifInterface.GPS_DIRECTION_TRUE, "newTitle", "g0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SessionOperationResponse;", "Lcom/zyql/agentfront/bean/SessionOperationRequest;", "e0", "(Lcom/zyql/agentfront/bean/SessionOperationRequest;)Lcom/zyql/agentfront/bean/SessionOperationResponse;", "k", "Landroid/content/Context;", "l", "contextRef", "Ljava/util/concurrent/ConcurrentHashMap;", "m", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMap", "toolCallbackMap", "Lcom/zyql/agentfront/sdk/client/o;", "pushMessageListener", "Landroid/os/Handler;", "p", "Landroid/os/Handler;", "callbackHandler", "com/zyql/agentfront/sdk/client/AgentFrontClient$messageListenerStub$1", "q", "Lcom/zyql/agentfront/sdk/client/AgentFrontClient$messageListenerStub$1;", "messageListenerStub", "r", Const.INTENT_KEY_APIKEY, "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AgentFrontClient extends AbstractC1504b<IMessageBridge> {

    /* renamed from: s, reason: collision with root package name */
    public static volatile o f31907s;

    /* renamed from: t, reason: collision with root package name */
    public static volatile Context f31908t;

    /* renamed from: u, reason: collision with root package name */
    public static volatile AgentFrontClient f31909u;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public Context contextRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, j> callbackMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, j> toolCallbackMap;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public volatile o pushMessageListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Handler callbackHandler;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final AgentFrontClient$messageListenerStub$1 messageListenerStub;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: v, reason: collision with root package name */
    public static volatile InterfaceC3961a f31910v = InterfaceC3961a.INSTANCE.a();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010 ¨\u0006!"}, d2 = {"Lcom/zyql/agentfront/sdk/client/AgentFrontClient$a;", "", "<init>", "()V", "Lcom/zyql/agentfront/sdk/client/o;", "c", "()Lcom/zyql/agentfront/sdk/client/o;", "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/Context;", "Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", Const.INTENT_KEY_APIKEY, "()Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "Ld8/a;", "logger", "LY8/t;", Const.INTENT_KEY_UMID, "(Ld8/a;)V", "", "TAG", "Ljava/lang/String;", "SERVICE_PACKAGE", "SERVICE_CLASS", "SERVICE_ACTION", "CLIENT_TYPE", "INVALID_MESSAGE_ID", "savedPushMessageListener", "Lcom/zyql/agentfront/sdk/client/o;", "savedApplicationContext", "Landroid/content/Context;", "currentInstance", "Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "Ld8/a;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.sdk.client.AgentFrontClient$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AgentFrontClient a() {
            return AgentFrontClient.f31909u;
        }

        public final Context b() {
            return AgentFrontClient.f31908t;
        }

        public final o c() {
            return AgentFrontClient.f31907s;
        }

        public final void d(InterfaceC3961a logger) {
            if (logger == null) {
                logger = InterfaceC3961a.INSTANCE.a();
            }
            AgentFrontClient.f31910v = logger;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/zyql/agentfront/sdk/client/AgentFrontClient$b", "Lc8/c;", "LY8/t;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC1505c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1505c f31918a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AgentFrontClient f31919b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5063a<t> f31920c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l<String, t> f31921d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(InterfaceC1505c interfaceC1505c, AgentFrontClient agentFrontClient, InterfaceC5063a<t> interfaceC5063a, InterfaceC5074l<? super String, t> interfaceC5074l) {
            this.f31918a = interfaceC1505c;
            this.f31919b = agentFrontClient;
            this.f31920c = interfaceC5063a;
            this.f31921d = interfaceC5074l;
        }

        @Override // c8.InterfaceC1505c
        public /* bridge */ void a(int i10, int i11) {
            super.a(i10, i11);
        }

        @Override // c8.InterfaceC1505c
        public void onBindFailed(String reason) {
            InterfaceC1505c interfaceC1505c = this.f31918a;
            if (interfaceC1505c != null) {
                interfaceC1505c.onBindFailed(reason);
            }
            InterfaceC5074l<String, t> interfaceC5074l = this.f31921d;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(reason);
            }
        }

        @Override // c8.InterfaceC1505c
        public void onConnected() {
            InterfaceC1505c interfaceC1505c = this.f31918a;
            if (interfaceC1505c != null) {
                interfaceC1505c.onConnected();
            }
            this.f31919b.z(this.f31918a);
            this.f31920c.invoke();
        }

        @Override // c8.InterfaceC1505c
        public void onDisconnected() {
            InterfaceC1505c interfaceC1505c = this.f31918a;
            if (interfaceC1505c != null) {
                interfaceC1505c.onDisconnected();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFrontClient(Context context, RetryConfig retryConfig) {
        super(retryConfig);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(retryConfig, "retryConfig");
        this.context = context;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.contextRef = applicationContext;
        f31909u = this;
        this.callbackMap = new ConcurrentHashMap<>();
        this.toolCallbackMap = new ConcurrentHashMap<>();
        this.callbackHandler = new Handler(Looper.getMainLooper());
        this.messageListenerStub = new AgentFrontClient$messageListenerStub$1(this);
    }

    public static final t S(AgentFrontClient agentFrontClient, CancelMessageRequest cancelMessageRequest) {
        IMessageBridge iMessageBridgeM = agentFrontClient.m();
        CancelMessageResponse cancelMessageResponseCancelMessage = iMessageBridgeM != null ? iMessageBridgeM.cancelMessage(cancelMessageRequest) : null;
        f31910v.e("AgentFrontClient", "[API] cancel message:" + cancelMessageRequest.getMessageId() + " end. result:" + cancelMessageResponseCancelMessage);
        return t.f7040a;
    }

    public static /* synthetic */ SessionOperationResponse U(AgentFrontClient agentFrontClient, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return agentFrontClient.T(str, str2);
    }

    public static /* synthetic */ SessionOperationResponse X(AgentFrontClient agentFrontClient, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return agentFrontClient.W(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a0(AgentFrontClient agentFrontClient, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = null;
        }
        agentFrontClient.Z(interfaceC5074l, interfaceC5063a);
    }

    public static final t f0(AgentFrontClient agentFrontClient, Message msg) throws RemoteException {
        kotlin.jvm.internal.p.i(msg, "msg");
        f31910v.e("AgentFrontClient", "Resending pending message: " + msg.getMessageId());
        IMessageBridge iMessageBridgeM = agentFrontClient.m();
        if (iMessageBridgeM != null) {
            iMessageBridgeM.sendMessage(msg);
        }
        return t.f7040a;
    }

    public static /* synthetic */ SessionOperationResponse h0(AgentFrontClient agentFrontClient, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return agentFrontClient.g0(str, str2, str3);
    }

    public static final t j0(Message message, j jVar, AgentFrontClient agentFrontClient, String str) {
        InterfaceC3961a.b(f31910v, "AgentFrontClient", "Failed to connect service for message: " + message.getMessageId() + ", reason: " + str, null, 4, null);
        String messageId = message.getMessageId();
        if (str == null) {
            str = "Service connection failed";
        }
        jVar.a(messageId, str);
        agentFrontClient.callbackMap.remove(message.getMessageId());
        return t.f7040a;
    }

    public static final t k0(final AgentFrontClient agentFrontClient) {
        agentFrontClient.u(new InterfaceC5074l() { // from class: com.zyql.agentfront.sdk.client.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentFrontClient.l0(this.f31929a, (Message) obj);
            }
        });
        return t.f7040a;
    }

    public static final t l0(AgentFrontClient agentFrontClient, Message msg) {
        kotlin.jvm.internal.p.i(msg, "msg");
        try {
            IMessageBridge iMessageBridgeM = agentFrontClient.m();
            if (iMessageBridgeM != null) {
                iMessageBridgeM.sendMessage(msg);
            }
        } catch (RemoteException e10) {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "Failed to send pending message: " + e10.getMessage(), null, 4, null);
        }
        return t.f7040a;
    }

    public static final t n0() {
        f31910v.a("AgentFrontClient", "[API] setPushMessageListener: service connected, listener registered");
        return t.f7040a;
    }

    public static final t p0(AgentFrontClient agentFrontClient, ToolResultRequest toolResultRequest) {
        try {
            IMessageBridge iMessageBridgeM = agentFrontClient.m();
            ToolResultResponse toolResultResponseSubmitToolResult = iMessageBridgeM != null ? iMessageBridgeM.submitToolResult(toolResultRequest) : null;
            f31910v.a("AgentFrontClient", "[API] submitToolResult tool:" + toolResultRequest.getToolCallId() + " traceId:" + toolResultRequest.getTraceId() + " end after reconnect. result:" + toolResultResponseSubmitToolResult);
        } catch (RemoteException e10) {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "[API] Failed to submit tool:" + toolResultRequest.getToolCallId() + " traceId:" + toolResultRequest.getTraceId() + " result after connect: " + e10.getMessage() + ".", null, 4, null);
        }
        return t.f7040a;
    }

    @Override // c8.AbstractC1504b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public IMessageBridge f(IBinder binder) {
        kotlin.jvm.internal.p.i(binder, "binder");
        IMessageBridge iMessageBridgeAsInterface = IMessageBridge.Stub.asInterface(binder);
        kotlin.jvm.internal.p.h(iMessageBridgeAsInterface, "asInterface(...)");
        return iMessageBridgeAsInterface;
    }

    public final CancelMessageResponse R(final CancelMessageRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        f31910v.a("AgentFrontClient", "[API] cancelMessage. request:" + request);
        try {
            try {
                IMessageBridge iMessageBridgeM = m();
                f31910v.e("AgentFrontClient", "[API] cancel message:" + request.getMessageId() + ", traceId:" + request.getTraceId() + " start. service:" + (iMessageBridgeM != null));
                if (iMessageBridgeM == null || !r()) {
                    a0(this, null, new InterfaceC5063a() { // from class: com.zyql.agentfront.sdk.client.e
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return AgentFrontClient.S(this.f31927a, request);
                        }
                    }, 1, null);
                } else {
                    IMessageBridge iMessageBridgeM2 = m();
                    CancelMessageResponse cancelMessageResponseCancelMessage = iMessageBridgeM2 != null ? iMessageBridgeM2.cancelMessage(request) : null;
                    InterfaceC3961a.b(f31910v, "AgentFrontClient", "[API] cancelMessage message:" + request.getMessageId() + ", traceId:" + request.getTraceId() + " end. result:" + cancelMessageResponseCancelMessage, null, 4, null);
                }
                CancelMessageResponse cancelMessageResponse = new CancelMessageResponse(true, null, null, null, null, 30, null);
                this.callbackMap.remove(request.getMessageId());
                return cancelMessageResponse;
            } catch (RemoteException e10) {
                f31910v.d("AgentFrontClient", "[API] cancelMessage message:" + request.getMessageId() + ", traceId:" + request.getTraceId() + " failed: " + e10.getMessage(), e10);
                c0(e10);
                CancelMessageResponse.Companion companion = CancelMessageResponse.INSTANCE;
                String message = e10.getMessage();
                if (message == null) {
                    message = "RemoteException";
                }
                CancelMessageResponse cancelMessageResponseC = CancelMessageResponse.Companion.c(companion, null, message, request.getTraceId(), 1, null);
                this.callbackMap.remove(request.getMessageId());
                return cancelMessageResponseC;
            }
        } catch (Throwable th) {
            this.callbackMap.remove(request.getMessageId());
            throw th;
        }
    }

    public final SessionOperationResponse T(String sessionKey, String traceId) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        return e0(new SessionOperationRequest(sessionKey, 2, null, traceId, 4, null));
    }

    public final void V() {
        h(this.contextRef);
        f31910v.e("AgentFrontClient", "[API] connect call");
    }

    public final SessionOperationResponse W(String sessionKey, String traceId) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        return e0(new SessionOperationRequest(sessionKey, 1, null, traceId, 4, null));
    }

    public final void Y(Message message) {
        String originMessageId = message.getOriginMessageId();
        f31910v.a("AgentFrontClient", "dispatchMessage: originMessageId=" + originMessageId + ", messageId=" + message.getMessageId() + ", conversationId:" + message.getConversationId() + ", type=" + message.getType() + " sourcePackage=" + message.getSourcePackage() + " targetPackage=" + message.getTargetPackage());
        if (kotlin.jvm.internal.p.d(message.getType(), "channel")) {
            o oVar = this.pushMessageListener;
            if (oVar != null) {
                oVar.a(message);
                return;
            } else {
                f31910v.a("AgentFrontClient", "dispatchMessage: no PushMessageListener for channel message");
                return;
            }
        }
        List<ToolCall> toolCalls = message.getToolCalls();
        if (kotlin.jvm.internal.p.d(message.getType(), "tool_call") && toolCalls != null && !toolCalls.isEmpty()) {
            f31910v.a("AgentFrontClient", "dispatchMessage: batch TOOL_CALL received, count=" + toolCalls.size() + ", isActive=" + message.isActive());
            List<ToolCall> list = toolCalls;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (ToolCall toolCall : list) {
                String toolCallId = toolCall.getToolCallId();
                String conversationId = message.getConversationId();
                if (conversationId == null) {
                    conversationId = "";
                }
                arrayList.add(new ToolCallRequest(originMessageId, toolCallId, conversationId, toolCall.getToolName(), toolCall.getArguments(), message.getTraceId()));
            }
            if (message.isActive()) {
                f31910v.a("AgentFrontClient", "dispatchMessage: batch PushToolCall received, forwarding to pushMessageListener");
                o oVar2 = this.pushMessageListener;
                if (oVar2 != null) {
                    oVar2.b(arrayList);
                    return;
                } else {
                    f31910v.a("AgentFrontClient", "dispatchMessage: no PushMessageListener for batch PushToolCall");
                    return;
                }
            }
            if (originMessageId != null && this.callbackMap.get(originMessageId) != null) {
                j jVar = this.callbackMap.get(originMessageId);
                kotlin.jvm.internal.p.f(jVar);
                jVar.c(arrayList);
                f31910v.a("AgentFrontClient", "dispatchMessage: batch TOOL_CALL dispatched to callback, count=" + arrayList.size());
                return;
            }
            f31910v.e("AgentFrontClient", "dispatchMessage: no callback for originMessageId=" + originMessageId + ", forwarding to pushMessageListener");
            o oVar3 = this.pushMessageListener;
            if (oVar3 != null) {
                oVar3.b(arrayList);
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.p.d(message.getType(), "tool_call") && message.getToolCall() != null) {
            ToolCall toolCall2 = message.getToolCall();
            kotlin.jvm.internal.p.f(toolCall2);
            f31910v.a("AgentFrontClient", "dispatchMessage: TOOL_CALL received, toolCallId=" + toolCall2.getToolCallId() + ", toolName=" + toolCall2.getToolName() + ", isActive=" + message.isActive() + ", cid=" + message.getConversationId());
            if (message.isActive()) {
                f31910v.a("AgentFrontClient", "dispatchMessage: PushToolCall received, forwarding to pushMessageListener");
                o oVar4 = this.pushMessageListener;
                if (oVar4 == null) {
                    f31910v.a("AgentFrontClient", "dispatchMessage: no PushMessageListener for PushToolCall");
                    return;
                }
                String toolCallId2 = toolCall2.getToolCallId();
                String conversationId2 = message.getConversationId();
                oVar4.c(new ToolCallRequest(originMessageId, toolCallId2, conversationId2 != null ? conversationId2 : "", toolCall2.getToolName(), toolCall2.getArguments(), message.getTraceId()));
                return;
            }
            String toolCallId3 = toolCall2.getToolCallId();
            String conversationId3 = message.getConversationId();
            if (conversationId3 == null) {
                conversationId3 = "";
            }
            ToolCallRequest toolCallRequest = new ToolCallRequest(originMessageId, toolCallId3, conversationId3, toolCall2.getToolName(), toolCall2.getArguments(), message.getTraceId());
            if (originMessageId == null || this.callbackMap.get(originMessageId) == null) {
                f31910v.e("AgentFrontClient", "没有发现:" + originMessageId + " 对应的callback. sourceMessageId:" + originMessageId + ", 广播回去:" + (this.pushMessageListener != null));
                o oVar5 = this.pushMessageListener;
                if (oVar5 != null) {
                    oVar5.c(toolCallRequest);
                    return;
                }
                return;
            }
            j jVar2 = this.callbackMap.get(originMessageId);
            kotlin.jvm.internal.p.f(jVar2);
            jVar2.b(toolCallRequest);
            f31910v.a("AgentFrontClient", "dispatchMessage. onReply ToolCall end: message: originMessageId=" + originMessageId + ", conversationId=" + message.getConversationId() + ", toolCallId=" + toolCall2.getToolCallId() + ", traceId=" + message.getTraceId() + ", tTraceId=" + toolCall2.getTraceId());
            return;
        }
        if (!kotlin.jvm.internal.p.d(message.getType(), "tool_result") || message.getToolCall() == null) {
            String originMessageId2 = message.getOriginMessageId();
            j jVar3 = this.callbackMap.get(originMessageId2);
            if (originMessageId2 != null && jVar3 != null) {
                jVar3.d(message);
                f31910v.a("AgentFrontClient", "dispatchMessage. onReply Message end. sourceMessageId:" + originMessageId2);
                if (message.isFinish()) {
                    this.callbackMap.remove(originMessageId2);
                    f31910v.a("AgentFrontClient", "dispatchMessage. Message finished, callback removed. sourceMessageId:" + originMessageId2);
                    return;
                }
                return;
            }
            f31910v.e("AgentFrontClient", "dispatchMessage. onReply Message end. sourceMessageId:" + originMessageId2 + ", callbackMap.keys=" + this.callbackMap.keySet() + ", 广播回去:" + (this.pushMessageListener != null));
            o oVar6 = this.pushMessageListener;
            if (oVar6 != null) {
                oVar6.a(message);
                return;
            }
            return;
        }
        ToolCall toolCall3 = message.getToolCall();
        kotlin.jvm.internal.p.f(toolCall3);
        f31910v.a("AgentFrontClient", "dispatchMessage: TOOL_RESULT received, toolCallId=" + toolCall3.getToolCallId() + ", extra=" + message.getExtra());
        j jVar4 = this.toolCallbackMap.get(toolCall3.getToolCallId());
        if (jVar4 == null) {
            f31910v.a("AgentFrontClient", "dispatchMessage. onReply ToolResult failed. toolCallId:" + toolCall3.getToolCallId());
            return;
        }
        jVar4.d(message);
        f31910v.a("AgentFrontClient", "dispatchMessage. onReply ToolResult end: message: messageId=" + message.getMessageId() + ", conversionId=" + message.getConversationId() + ", source=" + message.getSourcePackage() + ", target=" + message.getTargetPackage());
        if (message.isFinish()) {
            f31910v.a("AgentFrontClient", "dispatchMessage. onReply ToolResult finish. remove callback");
            this.toolCallbackMap.remove(toolCall3.getToolCallId());
        }
    }

    public final void Z(InterfaceC5074l<? super String, t> onFailed, InterfaceC5063a<t> onReady) {
        if (r()) {
            onReady.invoke();
            return;
        }
        f31910v.a("AgentFrontClient", "Service not connected, starting service and binding...");
        if (b0()) {
            h(this.contextRef);
            z(new b(getClientStateListener(), this, onReady, onFailed));
        } else {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "Failed to start service", null, 4, null);
            if (onFailed != null) {
                onFailed.invoke("Failed to start service");
            }
        }
    }

    public final boolean b0() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zyql.agentfront", "com.zyql.agentfront.service.MessageBridgeService");
            this.contextRef.startService(intent);
            f31910v.a("AgentFrontClient", "startService success for com.zyql.agentfront.service.MessageBridgeService");
            return true;
        } catch (Exception e10) {
            f31910v.d("AgentFrontClient", "Failed to start remote service: " + e10.getMessage(), e10);
            return false;
        }
    }

    public final void c0(Exception e10) {
        InterfaceC3961a.b(f31910v, "AgentFrontClient", "Remote communication failed: " + e10.getMessage(), null, 4, null);
        if (q()) {
            return;
        }
        f31910v.e("AgentFrontClient", "Remote communication failed. reconnect");
        i(this.contextRef);
        V();
    }

    public final boolean d0() {
        try {
            IMessageBridge iMessageBridgeM = m();
            f31910v.e("AgentFrontClient", "[API] isServiceReady. ready:" + (iMessageBridgeM != null ? Boolean.valueOf(iMessageBridgeM.isReady()) : null));
            if (iMessageBridgeM != null) {
                return iMessageBridgeM.isReady();
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    public final SessionOperationResponse e0(SessionOperationRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        f31910v.a("AgentFrontClient", "[API] manageSession: sessionKey=" + request.getSessionKey() + ", operation=" + request.getOperation() + ", traceId=" + request.getTraceId());
        try {
            IMessageBridge iMessageBridgeM = m();
            if (iMessageBridgeM != null && r()) {
                SessionOperationResponse sessionOperationResponseManageSession = iMessageBridgeM.manageSession(request);
                f31910v.e("AgentFrontClient", "[API] manageSession sessionKey:" + request.getSessionKey() + " operation:" + request.getOperation() + " end. success=" + sessionOperationResponseManageSession.getSuccess());
                kotlin.jvm.internal.p.f(sessionOperationResponseManageSession);
                return sessionOperationResponseManageSession;
            }
            f31910v.c("AgentFrontClient", "[API] manageSession: Service not connected");
            return SessionOperationResponse.INSTANCE.b("Service not connected", request.getTraceId());
        } catch (RemoteException e10) {
            f31910v.d("AgentFrontClient", "[API] manageSession failed: " + e10.getMessage(), e10);
            c0(e10);
            return SessionOperationResponse.INSTANCE.b(e10.getMessage(), request.getTraceId());
        }
    }

    public final SessionOperationResponse g0(String sessionKey, String newTitle, String traceId) {
        kotlin.jvm.internal.p.i(sessionKey, "sessionKey");
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        return e0(new SessionOperationRequest(sessionKey, 3, newTitle, traceId));
    }

    public final String i0(final Message message, final j callback) {
        IBinder iBinderAsBinder;
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(callback, "callback");
        f31910v.a("AgentFrontClient", "[API] sendMessage: messageId=" + message.getMessageId() + ", conversationId:" + message.getConversationId() + ", traceId:" + message.getTraceId() + ", targetPackage=" + message.getTargetPackage() + ", type=" + message.getType());
        String packageName = this.contextRef.getPackageName();
        String sourcePackage = message.getSourcePackage();
        if (sourcePackage == null || H.x0(sourcePackage)) {
            message.setSourcePackage(packageName);
        }
        if (H.x0(message.getMessageId()) || kotlin.jvm.internal.p.d(message.getMessageId(), "0")) {
            kotlin.jvm.internal.p.f(packageName);
            String strS1 = H.s1(packageName, '.', null, 2, null);
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            message.setMessageId(strS1 + "_" + D.T(string, O6.l.DATE_SEPARATOR, "", false, 4, null));
            f31910v.a("AgentFrontClient", "[API] Generate messageId=" + message.getMessageId());
        }
        this.callbackMap.put(message.getMessageId(), callback);
        f31910v.a("AgentFrontClient", "[API] start getService.");
        IMessageBridge iMessageBridgeM = m();
        f31910v.a("AgentFrontClient", "[API] end getService.");
        boolean zIsBinderAlive = (iMessageBridgeM == null || (iBinderAsBinder = iMessageBridgeM.asBinder()) == null) ? false : iBinderAsBinder.isBinderAlive();
        f31910v.a("AgentFrontClient", "[API] isBinderAlive=" + zIsBinderAlive);
        if (iMessageBridgeM == null || !r() || !zIsBinderAlive) {
            f31910v.c("AgentFrontClient", "Service connection invalid (Alive=" + zIsBinderAlive + "). reconnecting...");
            e(message);
            if (iMessageBridgeM == null || !zIsBinderAlive) {
                c0(new Exception("Binder is dead or null"));
            }
            f31910v.c("AgentFrontClient", "Service not connected, starting service and queuing message: " + message.getMessageId());
            Z(new InterfaceC5074l() { // from class: com.zyql.agentfront.sdk.client.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentFrontClient.j0(message, callback, this, (String) obj);
                }
            }, new InterfaceC5063a() { // from class: com.zyql.agentfront.sdk.client.d
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentFrontClient.k0(this.f31926a);
                }
            });
            return message.getMessageId();
        }
        try {
            String strSendMessage = iMessageBridgeM.sendMessage(message);
            kotlin.jvm.internal.p.f(strSendMessage);
            return strSendMessage;
        } catch (Exception e10) {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "Failed to send message: " + e10.getMessage(), null, 4, null);
            e(message);
            c0(e10);
            f31910v.e("AgentFrontClient", "sendMessage caught exception, message pending for retry. msgId:" + message.getMessageId());
            return message.getMessageId();
        }
    }

    public final void m0(o listener) {
        this.pushMessageListener = listener;
        f31907s = listener;
        f31908t = this.contextRef;
        f31910v.a("AgentFrontClient", "[API] setPushMessageListener: listener set = " + (listener != null));
        if (listener == null || r()) {
            return;
        }
        f31910v.a("AgentFrontClient", "[API] setPushMessageListener: service not connected, ensuring connection...");
        a0(this, null, new InterfaceC5063a() { // from class: com.zyql.agentfront.sdk.client.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentFrontClient.n0();
            }
        }, 1, null);
    }

    @Override // c8.AbstractC1504b
    public String n() {
        return "com.zyql.agentfront.BIND_MESSAGE_BRIDGE";
    }

    @Override // c8.AbstractC1504b
    public String o() {
        return "com.zyql.agentfront";
    }

    public final ToolResultResponse o0(final ToolResultRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        f31910v.a("AgentFrontClient", "[API] submitToolResult. request:" + request);
        IMessageBridge iMessageBridgeM = m();
        if (iMessageBridgeM == null || !r()) {
            f31910v.c("AgentFrontClient", "[API] Service not connected, starting service and retrying...");
            a0(this, null, new InterfaceC5063a() { // from class: com.zyql.agentfront.sdk.client.g
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentFrontClient.p0(this.f31930a, request);
                }
            }, 1, null);
            return new ToolResultResponse(true, null, null, null, request.getTraceId(), 14, null);
        }
        try {
            ToolResultResponse toolResultResponseSubmitToolResult = iMessageBridgeM.submitToolResult(request);
            f31910v.a("AgentFrontClient", "[API] submitToolResult tool:" + request.getToolCallId() + " traceId:" + request.getTraceId() + " end. result:" + toolResultResponseSubmitToolResult);
            kotlin.jvm.internal.p.f(toolResultResponseSubmitToolResult);
            return toolResultResponseSubmitToolResult;
        } catch (RemoteException e10) {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "[API] Failed to submit tool:" + request.getToolCallId() + " traceId:" + request.getTraceId() + ". result: " + e10.getMessage(), null, 4, null);
            c0(e10);
            ToolResultResponse.Companion companion = ToolResultResponse.INSTANCE;
            String message = e10.getMessage();
            if (message == null) {
                message = "RemoteException";
            }
            return ToolResultResponse.Companion.c(companion, null, message, request.getTraceId(), 1, null);
        }
    }

    public final SyncHistoryResponse q0(SyncHistoryRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        f31910v.a("AgentFrontClient", "[API] syncHistory: sessionKey=" + request.getSessionKey() + ", traceId=" + request.getTraceId());
        try {
            IMessageBridge iMessageBridgeM = m();
            if (iMessageBridgeM != null && r()) {
                SyncHistoryResponse syncHistoryResponseSyncHistory = iMessageBridgeM.syncHistory(request);
                f31910v.e("AgentFrontClient", "[API] syncHistory sessionKey:" + request.getSessionKey() + " end. success=" + syncHistoryResponseSyncHistory.getSuccess() + ", messages=" + syncHistoryResponseSyncHistory.getMessages().size());
                kotlin.jvm.internal.p.f(syncHistoryResponseSyncHistory);
                return syncHistoryResponseSyncHistory;
            }
            f31910v.c("AgentFrontClient", "[API] syncHistory: Service not connected");
            return SyncHistoryResponse.INSTANCE.b("Service not connected", request.getTraceId());
        } catch (RemoteException e10) {
            f31910v.d("AgentFrontClient", "[API] syncHistory failed: " + e10.getMessage(), e10);
            c0(e10);
            return SyncHistoryResponse.INSTANCE.b(e10.getMessage(), request.getTraceId());
        }
    }

    @Override // c8.AbstractC1504b
    public void s() {
        try {
            IMessageBridge iMessageBridgeM = m();
            if (iMessageBridgeM != null) {
                iMessageBridgeM.registerListener(this.messageListenerStub, "business", this.contextRef.getPackageName());
            }
            f31910v.e("AgentFrontClient", "Re-registered listener after reconnection.");
            u(new InterfaceC5074l() { // from class: com.zyql.agentfront.sdk.client.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentFrontClient.f0(this.f31922a, (Message) obj);
                }
            });
        } catch (RemoteException e10) {
            InterfaceC3961a.b(f31910v, "AgentFrontClient", "Failed to register listener: " + e10.getMessage(), null, 4, null);
        }
    }

    @Override // c8.AbstractC1504b
    public void t() {
    }

    public /* synthetic */ AgentFrontClient(Context context, RetryConfig retryConfig, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? new RetryConfig(0, 0L, 0L, 0.0f, false, 31, null) : retryConfig);
    }
}
