package com.stepos.agentframework.adapter.agentbus;

import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import Z8.C1173v;
import a4.Attachment;
import a4.BatchDeleteItem;
import a4.C;
import a4.ChannelReadyEvent;
import a4.CustomEvent;
import a4.ErrorShape;
import a4.InvokeResult;
import a4.Message;
import a4.StepClawEvent;
import a4.Task;
import a4.ToolCall;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.AgentBusBindingBase;
import com.stepos.agentbus.generated.Role;
import com.stepos.agentbus.generated.ToolStatus;
import com.stepos.agentbus.generated.c;
import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.core.ability.AbilityType;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\f\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ4\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0014¢\u0006\u0004\b \u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\b\u0002\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b#\u0010$J0\u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H\u0086@¢\u0006\u0004\b(\u0010)J0\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H\u0086@¢\u0006\u0004\b+\u0010)J$\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b-\u0010.J:\u00100\u001a\u00020/2\u0006\u0010%\u001a\u00020\u00062\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\b\b\u0002\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00102R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R&\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b06058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000209058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00108R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020>0@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020E058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00108R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020E0@8\u0006¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010DR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00104\u001a\u0004\bM\u0010\b\"\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\bP\u00104R$\u0010Q\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u00104\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010OR\u0014\u0010T\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010UR\u0017\u0010V\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bV\u00104\u001a\u0004\bW\u0010\bR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\"0X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020]0X8\u0006¢\u0006\f\n\u0004\b^\u0010Z\u001a\u0004\b_\u0010\\R\u001b\u0010a\u001a\u00060`R\u00020\u00008\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001b\u0010f\u001a\u00060eR\u00020\u00008\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001b\u0010k\u001a\u00060jR\u00020\u00008\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u00060oR\u00020\u00008\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001f\u0010y\u001a\u00060tR\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0011\u0010|\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bz\u0010{RE\u0010\u0084\u0001\u001a\u0010\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u0014\u0018\u00010}2\u0014\u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u0014\u0018\u00010}8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0013\u0010\u0086\u0001\u001a\u00020\"8F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010{¨\u0006\u008d\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;", "impl", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;)V", "", "K", "()Ljava/lang/String;", "q", "sessionId", "La4/w;", "message", SpriteEventAction.AGENT_THINKING_START, "", "remoteTimeoutMs", "M", "(Ljava/lang/String;La4/w;Ljava/lang/String;Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "frame", "LY8/t;", "r", "(Lorg/json/JSONObject;Le9/c;)Ljava/lang/Object;", "payload", ExifInterface.LONGITUDE_EAST, "(Lorg/json/JSONObject;)La4/w;", "obj", "La4/E;", "H", "(Lorg/json/JSONObject;)La4/E;", "Q", "()V", "R", "timeoutMs", "", "m", "(JLe9/c;)Ljava/lang/Object;", "method", "", "params", "N", "(Ljava/lang/String;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "event", "L", "frameId", "o", "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "La4/v;", "I", "(Ljava/lang/String;Ljava/util/Map;JLe9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;", "runScopeId", "Ljava/lang/String;", "LXa/j;", "Lkotlin/Pair;", "incomingMessages", "LXa/j;", "", "incomingBffMessages", "LUa/M;", "onMessageScope", "LUa/M;", "La4/r;", "customEventBus", "LXa/o;", "customEvents", "LXa/o;", "v", "()LXa/o;", "La4/z;", "stepClawEventBus", "stepClawEvents", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "base", "Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "clientId", "getClientId", "O", "(Ljava/lang/String;)V", "clientIdFallback", "packageName", "getPackageName", "P", "idleTimeoutMs", "J", "defaultSessionId", "w", "LXa/t;", "connected", "LXa/t;", "u", "()LXa/t;", "Lcom/stepos/agentbus/generated/AgentBusBindingBase$b;", "status", "getStatus", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$b;", "health", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$b;", "x", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$b;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$ChatApi;", AbilityType.CHAT, "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$ChatApi;", "t", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$ChatApi;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$BffApi;", "bff", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$BffApi;", "s", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$BffApi;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$SessionsApi;", "sessions", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$SessionsApi;", "z", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$SessionsApi;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$TaskApi;", "task$delegate", "LY8/h;", "B", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$TaskApi;", "task", "D", "()Z", "isConnected", "Lkotlin/Function1;", "La4/q;", UxipConstants.f30680s, "y", "()Lp9/l;", "setOnChannelReady", "(Lp9/l;)V", "onChannelReady", "C", "isCloudConnected", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "BffApi", "ChatApi", "SessionsApi", "TaskApi", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding {
    private final AgentBusBindingBase base;
    private final BffApi bff;
    private final ChatApi chat;
    private volatile String clientId;
    private final String clientIdFallback;
    private final Xa.t<Boolean> connected;
    private final Xa.j<CustomEvent> customEventBus;
    private final Xa.o<CustomEvent> customEvents;
    private final String defaultSessionId;
    private final b health;
    private final long idleTimeoutMs;
    private final ClawChannel impl;
    private final Xa.j<byte[]> incomingBffMessages;
    private final Xa.j<Pair<String, Message>> incomingMessages;
    private final Ua.M onMessageScope;
    private volatile String packageName;
    private final String runScopeId;
    private final SessionsApi sessions;
    private final Xa.t<AgentBusBindingBase.ConnectionStatus> status;
    private final Xa.j<StepClawEvent> stepClawEventBus;
    private final Xa.o<StepClawEvent> stepClawEvents;

    /* renamed from: task$delegate, reason: from kotlin metadata */
    private final Y8.h task;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$BffApi;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "", "payload", "", "timeoutMs", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$a;", Const.INTENT_KEY_UMID, "([BJLe9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Le9/c;", "LY8/t;", "handler", "Lkotlin/Function0;", Const.INTENT_KEY_PKGNAME, "(Lp9/p;)Lp9/a;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class BffApi {
        public BffApi() {
        }

        public static final Y8.t c(kotlinx.coroutines.g gVar) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            return Y8.t.f7040a;
        }

        public static /* synthetic */ Object e(BffApi bffApi, byte[] bArr, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                j10 = 30000;
            }
            return bffApi.d(bArr, j10, interfaceC4014c);
        }

        public final InterfaceC5063a<Y8.t> b(p9.p<? super byte[], ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
            kotlin.jvm.internal.p.i(handler, "handler");
            final kotlinx.coroutines.g gVarD = C1060i.d(ClawChannelAgentBusBinding.this.onMessageScope, null, null, new ClawChannelAgentBusBinding$BffApi$onMessage$job$1(ClawChannelAgentBusBinding.this, handler, null), 3, null);
            return new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.B
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ClawChannelAgentBusBinding.BffApi.c(gVarD);
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object d(byte[] r17, long r18, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.BffSendResult> r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 347
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.BffApi.d(byte[], long, e9.c):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJJ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2(\u0010\u001c\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$ChatApi;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "", "sessionId", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "La4/w;", "message", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;La4/w;Le9/c;)Ljava/lang/Object;", "", "limit", "before", "", "timeoutMs", "lastUpdateTs", "", "c", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/Long;Le9/c;)Ljava/lang/Object;", "Lorg/json/JSONArray;", "arr", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lorg/json/JSONArray;)Ljava/util/List;", "Lkotlin/Function3;", "Le9/c;", "handler", "Lkotlin/Function0;", "e", "(Lp9/q;)Lp9/a;", UxipConstants.f30680s, "currentSessionId", "Ljava/lang/String;", "getCurrentSessionId", "()Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class ChatApi {
        private volatile String currentSessionId;

        public ChatApi() {
            this.currentSessionId = ClawChannelAgentBusBinding.this.getDefaultSessionId();
        }

        public static /* synthetic */ Object d(ChatApi chatApi, String str, int i10, String str2, long j10, Long l10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
            Long l11;
            ChatApi chatApi2;
            String str3;
            InterfaceC4014c interfaceC4014c2;
            if ((i11 & 2) != 0) {
                i10 = 20;
            }
            int i12 = i10;
            String str4 = (i11 & 4) != 0 ? null : str2;
            if ((i11 & 8) != 0) {
                j10 = 10000;
            }
            long j11 = j10;
            if ((i11 & 16) != 0) {
                l11 = null;
                str3 = str;
                interfaceC4014c2 = interfaceC4014c;
                chatApi2 = chatApi;
            } else {
                l11 = l10;
                chatApi2 = chatApi;
                str3 = str;
                interfaceC4014c2 = interfaceC4014c;
            }
            return chatApi2.c(str3, i12, str4, j11, l11, interfaceC4014c2);
        }

        public static final Y8.t f(kotlinx.coroutines.g gVar) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            return Y8.t.f7040a;
        }

        public static final Message h(ClawChannelAgentBusBinding clawChannelAgentBusBinding, JSONObject it) {
            kotlin.jvm.internal.p.i(it, "it");
            return clawChannelAgentBusBinding.E(it);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00e8, code lost:
        
            if (r14 == r1) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(java.lang.String r8, int r9, java.lang.String r10, long r11, java.lang.Long r13, e9.InterfaceC4014c<? super java.util.List<a4.Message>> r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 289
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.ChatApi.c(java.lang.String, int, java.lang.String, long, java.lang.Long, e9.c):java.lang.Object");
        }

        public final InterfaceC5063a<Y8.t> e(p9.q<? super String, ? super Message, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
            kotlin.jvm.internal.p.i(handler, "handler");
            final kotlinx.coroutines.g gVarD = C1060i.d(ClawChannelAgentBusBinding.this.onMessageScope, null, null, new ClawChannelAgentBusBinding$ChatApi$onMessage$job$1(ClawChannelAgentBusBinding.this, handler, null), 3, null);
            return new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.C
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ClawChannelAgentBusBinding.ChatApi.f(gVarD);
                }
            };
        }

        public final List<Message> g(JSONArray arr) {
            kotlin.jvm.internal.p.i(arr, "arr");
            AgentBusBindingBase agentBusBindingBase = ClawChannelAgentBusBinding.this.base;
            final ClawChannelAgentBusBinding clawChannelAgentBusBinding = ClawChannelAgentBusBinding.this;
            return agentBusBindingBase.B(arr, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.D
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ClawChannelAgentBusBinding.ChatApi.h(clawChannelAgentBusBinding, (JSONObject) obj);
                }
            });
        }

        public final Object i(String str, Message wVar, InterfaceC4014c<? super String> interfaceC4014c) {
            return ClawChannelAgentBusBinding.this.M(str, wVar, null, null, interfaceC4014c);
        }

        public final void j(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            String string = La.H.D1(sessionId).toString();
            ClawChannelAgentBusBinding clawChannelAgentBusBinding = ClawChannelAgentBusBinding.this;
            if (string.length() == 0) {
                string = clawChannelAgentBusBinding.getDefaultSessionId();
            }
            this.currentSessionId = string;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$SessionsApi;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "newLabel", "", "timeoutMs", "", "c", "(Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SessionsApi {
        public SessionsApi() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
        
            if (r11 == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.String r8, long r9, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$clear$1
                if (r0 == 0) goto L13
                r0 = r11
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$clear$1 r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$clear$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$clear$1 r0 = new com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$clear$1
                r0.<init>(r7, r11)
            L18:
                java.lang.Object r11 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3c
                if (r2 != r3) goto L34
                java.lang.Object r7 = r0.L$1
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r7 = r0.L$0
                java.lang.String r7 = (java.lang.String) r7
                kotlin.C4849c.b(r11)
                goto L97
            L34:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3c:
                long r9 = r0.J$0
                java.lang.Object r8 = r0.L$0
                java.lang.String r8 = (java.lang.String) r8
                kotlin.C4849c.b(r11)
                goto L78
            L46:
                kotlin.C4849c.b(r11)
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r11 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r11 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r11)
                java.lang.String r2 = "key"
                kotlin.Pair r2 = Y8.j.a(r2, r8)
                java.lang.String r5 = "reason"
                java.lang.String r6 = "reset"
                kotlin.Pair r5 = Y8.j.a(r5, r6)
                kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r5}
                java.util.Map r2 = kotlin.collections.a.m(r2)
                java.lang.Object r5 = g9.h.a(r8)
                r0.L$0 = r5
                r0.J$0 = r9
                r0.label = r4
                java.lang.String r5 = "sessions.reset"
                java.lang.Object r11 = r11.f0(r5, r2, r0)
                if (r11 != r1) goto L78
                goto L96
            L78:
                java.lang.String r11 = (java.lang.String) r11
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r7 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r7 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r7)
                java.lang.Object r8 = g9.h.a(r8)
                r0.L$0 = r8
                java.lang.Object r8 = g9.h.a(r11)
                r0.L$1 = r8
                r0.J$0 = r9
                r0.label = r3
                java.lang.Object r11 = r7.D(r11, r9, r0)
                if (r11 != r1) goto L97
            L96:
                return r1
            L97:
                org.json.JSONObject r11 = (org.json.JSONObject) r11
                r7 = 0
                if (r11 == 0) goto La5
                java.lang.String r8 = "ok"
                boolean r8 = r11.optBoolean(r8, r7)
                if (r8 != r4) goto La5
                goto La6
            La5:
                r4 = r7
            La6:
                java.lang.Boolean r7 = g9.C4109a.a(r4)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.SessionsApi.a(java.lang.String, long, e9.c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0088, code lost:
        
            if (r10 == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(java.lang.String r7, long r8, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r10 instanceof com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$delete$1
                if (r0 == 0) goto L13
                r0 = r10
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$delete$1 r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$delete$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$delete$1 r0 = new com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$delete$1
                r0.<init>(r6, r10)
            L18:
                java.lang.Object r10 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3c
                if (r2 != r3) goto L34
                java.lang.Object r6 = r0.L$1
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r6 = r0.L$0
                java.lang.String r6 = (java.lang.String) r6
                kotlin.C4849c.b(r10)
                goto L8b
            L34:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3c:
                long r8 = r0.J$0
                java.lang.Object r7 = r0.L$0
                java.lang.String r7 = (java.lang.String) r7
                kotlin.C4849c.b(r10)
                goto L6c
            L46:
                kotlin.C4849c.b(r10)
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r10 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r10)
                java.lang.String r2 = "key"
                kotlin.Pair r2 = Y8.j.a(r2, r7)
                java.util.Map r2 = Z8.Q.f(r2)
                java.lang.Object r5 = g9.h.a(r7)
                r0.L$0 = r5
                r0.J$0 = r8
                r0.label = r4
                java.lang.String r5 = "sessions.delete"
                java.lang.Object r10 = r10.f0(r5, r2, r0)
                if (r10 != r1) goto L6c
                goto L8a
            L6c:
                java.lang.String r10 = (java.lang.String) r10
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r6 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r6 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r6)
                java.lang.Object r7 = g9.h.a(r7)
                r0.L$0 = r7
                java.lang.Object r7 = g9.h.a(r10)
                r0.L$1 = r7
                r0.J$0 = r8
                r0.label = r3
                java.lang.Object r10 = r6.D(r10, r8, r0)
                if (r10 != r1) goto L8b
            L8a:
                return r1
            L8b:
                org.json.JSONObject r10 = (org.json.JSONObject) r10
                r6 = 0
                if (r10 == 0) goto L99
                java.lang.String r7 = "ok"
                boolean r7 = r10.optBoolean(r7, r6)
                if (r7 != r4) goto L99
                goto L9a
            L99:
                r4 = r6
            L9a:
                java.lang.Boolean r6 = g9.C4109a.a(r4)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.SessionsApi.b(java.lang.String, long, e9.c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a7, code lost:
        
            if (r11 == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(java.lang.String r7, java.lang.String r8, long r9, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$rename$1
                if (r0 == 0) goto L13
                r0 = r11
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$rename$1 r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$rename$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$rename$1 r0 = new com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$SessionsApi$rename$1
                r0.<init>(r6, r11)
            L18:
                java.lang.Object r11 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L4f
                if (r2 == r4) goto L40
                if (r2 != r3) goto L38
                java.lang.Object r6 = r0.L$2
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r6 = r0.L$1
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r6 = r0.L$0
                java.lang.String r6 = (java.lang.String) r6
                kotlin.C4849c.b(r11)
                goto Laa
            L38:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L40:
                long r9 = r0.J$0
                java.lang.Object r7 = r0.L$1
                r8 = r7
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r7 = r0.L$0
                java.lang.String r7 = (java.lang.String) r7
                kotlin.C4849c.b(r11)
                goto L85
            L4f:
                kotlin.C4849c.b(r11)
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r11 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r11 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r11)
                java.lang.String r2 = "key"
                kotlin.Pair r2 = Y8.j.a(r2, r7)
                java.lang.String r5 = "label"
                kotlin.Pair r5 = Y8.j.a(r5, r8)
                kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r5}
                java.util.Map r2 = kotlin.collections.a.m(r2)
                java.lang.Object r5 = g9.h.a(r7)
                r0.L$0 = r5
                java.lang.Object r5 = g9.h.a(r8)
                r0.L$1 = r5
                r0.J$0 = r9
                r0.label = r4
                java.lang.String r5 = "sessions.patch"
                java.lang.Object r11 = r11.f0(r5, r2, r0)
                if (r11 != r1) goto L85
                goto La9
            L85:
                java.lang.String r11 = (java.lang.String) r11
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r6 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.this
                com.stepos.agentbus.generated.AgentBusBindingBase r6 = com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.f(r6)
                java.lang.Object r7 = g9.h.a(r7)
                r0.L$0 = r7
                java.lang.Object r7 = g9.h.a(r8)
                r0.L$1 = r7
                java.lang.Object r7 = g9.h.a(r11)
                r0.L$2 = r7
                r0.J$0 = r9
                r0.label = r3
                java.lang.Object r11 = r6.D(r11, r9, r0)
                if (r11 != r1) goto Laa
            La9:
                return r1
            Laa:
                org.json.JSONObject r11 = (org.json.JSONObject) r11
                r6 = 0
                if (r11 == 0) goto Lb8
                java.lang.String r7 = "ok"
                boolean r7 = r11.optBoolean(r7, r6)
                if (r7 != r4) goto Lb8
                goto Lb9
            Lb8:
                r4 = r6
            Lb9:
                java.lang.Boolean r6 = g9.C4109a.a(r4)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.SessionsApi.c(java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJR\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J@\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020%0(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$TaskApi;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "", "taskId", "message", "", "cancel", "reason", "idempotencyKey", "", "timeoutMs", "La4/k;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "", "expectedVersion", "killSubagents", "La4/p;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;JLe9/c;)Ljava/lang/Object;", "La4/s;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "", "taskIds", "La4/n;", "c", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "event", "Lorg/json/JSONObject;", "payload", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Lorg/json/JSONObject;)V", "LXa/j;", "La4/C;", "eventBus", "LXa/j;", "LXa/o;", "events", "LXa/o;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LXa/o;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class TaskApi {
        private final Xa.j<a4.C> eventBus;
        private final Xa.o<a4.C> events;

        public TaskApi() {
            Xa.j<a4.C> jVarB = Xa.p.b(0, 64, null, 4, null);
            this.eventBus = jVarB;
            this.events = Xa.d.b(jVarB);
        }

        public static final BatchDeleteItem d(JSONObject obj) {
            String strOptString;
            String strOptString2;
            kotlin.jvm.internal.p.i(obj, "obj");
            String strOptString3 = obj.optString("taskId");
            kotlin.jvm.internal.p.h(strOptString3, "optString(...)");
            boolean zOptBoolean = obj.optBoolean("ok", false);
            Long lValueOf = Long.valueOf(obj.optLong("deletedAt", 0L));
            ErrorShape errorShape = null;
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            if (obj.has("error")) {
                JSONObject jSONObjectOptJSONObject = obj.optJSONObject("error");
                if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("errorCode")) == null) {
                    strOptString = "ERROR";
                }
                if (jSONObjectOptJSONObject == null || (strOptString2 = jSONObjectOptJSONObject.optString("message")) == null) {
                    strOptString2 = "unknown";
                }
                errorShape = new ErrorShape(strOptString, strOptString2);
            }
            return new BatchDeleteItem(strOptString3, zOptBoolean, lValueOf, errorShape);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0134, code lost:
        
            if (r5 == r8) goto L38;
         */
        /* JADX WARN: Removed duplicated region for block: B:63:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(java.lang.String r20, java.lang.String r21, boolean r22, java.lang.String r23, java.lang.String r24, long r25, e9.InterfaceC4014c<? super a4.AnswerResult> r27) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 581
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.TaskApi.b(java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00dc, code lost:
        
            if (r14 == r1) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(java.util.List<java.lang.String> r9, java.lang.String r10, java.lang.String r11, long r12, e9.InterfaceC4014c<? super a4.BatchDeleteResult> r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 328
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.TaskApi.c(java.util.List, java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
        
            if (r5 == r8) goto L35;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object e(java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.String r20, java.lang.Boolean r21, long r22, e9.InterfaceC4014c<? super a4.CancelResult> r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 516
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.TaskApi.e(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, long, e9.c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00dc, code lost:
        
            if (r15 == r1) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(java.lang.String r10, java.lang.String r11, java.lang.String r12, long r13, e9.InterfaceC4014c<? super a4.DeleteResult> r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.TaskApi.f(java.lang.String, java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
        }

        public final Xa.o<a4.C> g() {
            return this.events;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void h(String event, JSONObject payload) {
            kotlin.jvm.internal.p.i(event, "event");
            kotlin.jvm.internal.p.i(payload, "payload");
            Map<String, ? extends Object> mapU = ClawChannelAgentBusBinding.this.base.U(payload);
            Long lValueOf = payload.has(c.a.COL_SEQ) ? Long.valueOf(payload.optLong(c.a.COL_SEQ)) : null;
            Long lValueOf2 = payload.has("ts") ? Long.valueOf(payload.optLong("ts")) : null;
            String strOptString = payload.optString(SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY);
            String str = strOptString.length() != 0 ? strOptString : null;
            if (mapU.containsKey("task") && (mapU.get("task") instanceof Map)) {
                Object obj = mapU.get("task");
                kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                mapU = (Map) obj;
            }
            boolean z10 = true;
            switch (event.hashCode()) {
                case -1840237352:
                    if (event.equals("stepclaw.tasks.updated")) {
                        Log.d("TASK_EVENT", "stepclaw.tasks.updated taskData keys=" + Z8.F.A0(mapU.keySet(), null, null, null, 0, null, null, 63, null));
                        Log.d("TASK_EVENT", "taskData has pendingQuestions/pendingInquiry=" + (mapU.containsKey("pendingQuestions") || mapU.containsKey("pendingInquiry")));
                        try {
                            Task taskE = com.stepos.agentbus.generated.d.f22322a.e(mapU);
                            if (taskE.i() == null) {
                                z10 = false;
                            }
                            Log.d("TASK_EVENT", "parsed task pendingQuestions=" + z10);
                            this.eventBus.a(new C.Updated(taskE, lValueOf, lValueOf2, str));
                            break;
                        } catch (Exception e10) {
                            Log.d("TASK_EVENT", "updated error=" + e10.getMessage());
                            e10.printStackTrace();
                            return;
                        }
                    }
                    break;
                case -577252603:
                    if (event.equals("stepclaw.tasks.created")) {
                        this.eventBus.a(new C.Created(com.stepos.agentbus.generated.d.f22322a.e(mapU), lValueOf, lValueOf2, str));
                        break;
                    }
                    break;
                case -489493910:
                    if (event.equals("stepclaw.tasks.waiting")) {
                        Log.d("TASK_EVENT", "stepclaw.tasks.waiting taskData keys=" + Z8.F.A0(mapU.keySet(), null, null, null, 0, null, null, 63, null));
                        Log.d("TASK_EVENT", "taskData has pendingQuestions/pendingInquiry=" + (mapU.containsKey("pendingQuestions") || mapU.containsKey("pendingInquiry")));
                        try {
                            Task taskE2 = com.stepos.agentbus.generated.d.f22322a.e(mapU);
                            if (taskE2.i() == null) {
                                z10 = false;
                            }
                            Log.d("TASK_EVENT", "parsed task pendingQuestions=" + z10);
                            this.eventBus.a(new C.Updated(taskE2, lValueOf, lValueOf2, str));
                            break;
                        } catch (Exception e11) {
                            Log.d("TASK_EVENT", "waiting error=" + e11.getMessage());
                            e11.printStackTrace();
                            return;
                        }
                    }
                    break;
                case 1604695848:
                    if (event.equals("stepclaw.tasks.completed")) {
                        Log.d("TASK_EVENT", "stepclaw.tasks.completed taskData=" + mapU);
                        this.eventBus.a(new C.Completed(com.stepos.agentbus.generated.d.f22322a.e(mapU), lValueOf, lValueOf2, str));
                        break;
                    }
                    break;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$b;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", "LXa/t;", "Lcom/stepos/agentbus/generated/c;", Const.INTENT_KEY_PKGNAME, "()LXa/t;", ExecutionBundle.PREF_CLOUD, Const.INTENT_KEY_APIKEY, "bff", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b {
        public b() {
        }

        public final Xa.t<com.stepos.agentbus.generated.c> a() {
            return ClawChannelAgentBusBinding.this.base.M();
        }

        public final Xa.t<com.stepos.agentbus.generated.c> b() {
            return ClawChannelAgentBusBinding.this.base.Q();
        }
    }

    public ClawChannelAgentBusBinding(ClawChannel impl) {
        kotlin.jvm.internal.p.i(impl, "impl");
        this.impl = impl;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String strSubstring = string.substring(0, 8);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        this.runScopeId = strSubstring;
        this.incomingMessages = Xa.p.b(0, 32, null, 5, null);
        this.incomingBffMessages = Xa.p.b(0, 32, null, 5, null);
        this.onMessageScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        Xa.j<CustomEvent> jVarB = Xa.p.b(0, 64, null, 5, null);
        this.customEventBus = jVarB;
        this.customEvents = Xa.d.b(jVarB);
        Xa.j<StepClawEvent> jVarB2 = Xa.p.b(0, 64, null, 5, null);
        this.stepClawEventBus = jVarB2;
        this.stepClawEvents = Xa.d.b(jVarB2);
        AgentBusBindingBase agentBusBindingBase = new AgentBusBindingBase(C1963x.AGENT_TYPE_AGENTBUS, new ClawChannelAgentBusBinding$base$1(this), "AgentFramework", "1.0.0", "channel", "as-", 1000L, 3, 3, new ClawChannelAgentBusBinding$base$2(this), new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ClawChannelAgentBusBinding.p(this.f22336a);
            }
        }, null, 0L, 2048, null);
        this.base = agentBusBindingBase;
        this.clientIdFallback = "agentframework";
        this.defaultSessionId = "agent:main:desktop-" + UUID.randomUUID();
        this.connected = agentBusBindingBase.N();
        this.status = agentBusBindingBase.P();
        this.health = new b();
        this.chat = new ChatApi();
        this.bff = new BffApi();
        this.sessions = new SessionsApi();
        this.task = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ClawChannelAgentBusBinding.S(this.f22337a);
            }
        });
    }

    public static final Attachment F(ClawChannelAgentBusBinding clawChannelAgentBusBinding, JSONObject it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Attachment.INSTANCE.a(clawChannelAgentBusBinding.base.U(it));
    }

    public static final ToolCall G(ClawChannelAgentBusBinding clawChannelAgentBusBinding, JSONObject it) {
        kotlin.jvm.internal.p.i(it, "it");
        return clawChannelAgentBusBinding.H(it);
    }

    public static /* synthetic */ Object J(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, Map map, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = kotlin.collections.a.i();
        }
        Map map2 = map;
        if ((i10 & 4) != 0) {
            j10 = 10000;
        }
        return clawChannelAgentBusBinding.I(str, map2, j10, interfaceC4014c);
    }

    public static final TaskApi S(ClawChannelAgentBusBinding clawChannelAgentBusBinding) {
        return clawChannelAgentBusBinding.new TaskApi();
    }

    public static /* synthetic */ Object n(ClawChannelAgentBusBinding clawChannelAgentBusBinding, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 5000;
        }
        return clawChannelAgentBusBinding.m(j10, interfaceC4014c);
    }

    public static final String p(ClawChannelAgentBusBinding clawChannelAgentBusBinding) {
        return clawChannelAgentBusBinding.q();
    }

    public final Xa.o<StepClawEvent> A() {
        return this.stepClawEvents;
    }

    public final TaskApi B() {
        return (TaskApi) this.task.getValue();
    }

    public final boolean C() {
        return this.base.Q().getValue() instanceof c.Available;
    }

    public final boolean D() {
        return this.base.S();
    }

    public final Message E(JSONObject payload) {
        Object objB;
        Map<String, Object> mapI;
        JSONArray jSONArrayOptJSONArray = payload.optJSONArray("attachments");
        List listM = jSONArrayOptJSONArray == null ? C1173v.m() : this.base.B(jSONArrayOptJSONArray, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ClawChannelAgentBusBinding.F(this.f22338a, (JSONObject) obj);
            }
        });
        JSONArray jSONArrayOptJSONArray2 = payload.optJSONArray("toolCalls");
        List listM2 = jSONArrayOptJSONArray2 == null ? C1173v.m() : this.base.B(jSONArrayOptJSONArray2, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ClawChannelAgentBusBinding.G(this.f22323a, (JSONObject) obj);
            }
        });
        String strOptString = payload.optString(BundleContentBridge.KEY_ROLE, "assistant");
        kotlin.jvm.internal.p.h(strOptString, "optString(...)");
        String upperCase = strOptString.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Role.valueOf(upperCase));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Role role = Role.ASSISTANT;
        if (Result.g(objB)) {
            objB = role;
        }
        Role role2 = (Role) objB;
        String strOptString2 = payload.optString("text");
        kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
        String strOptString3 = payload.optString("replyTo");
        if (strOptString3.length() == 0) {
            strOptString3 = null;
        }
        JSONObject jSONObjectOptJSONObject = payload.optJSONObject("metadata");
        if (jSONObjectOptJSONObject == null || (mapI = this.base.U(jSONObjectOptJSONObject)) == null) {
            mapI = kotlin.collections.a.i();
        }
        Map<String, Object> map = mapI;
        String strOptString4 = payload.optString("delta");
        return new Message(role2, strOptString2, listM, listM2, strOptString3, map, strOptString4.length() == 0 ? null : strOptString4);
    }

    public final ToolCall H(JSONObject obj) {
        Map<String, Object> mapI;
        Object objB;
        String strOptString = obj.optString("id");
        kotlin.jvm.internal.p.h(strOptString, "optString(...)");
        String strOptString2 = obj.optString("name");
        kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
        JSONObject jSONObjectOptJSONObject = obj.optJSONObject("arguments");
        if (jSONObjectOptJSONObject == null || (mapI = this.base.U(jSONObjectOptJSONObject)) == null) {
            mapI = kotlin.collections.a.i();
        }
        Map<String, Object> map = mapI;
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString3 = obj.optString("status", "OK");
            kotlin.jvm.internal.p.h(strOptString3, "optString(...)");
            String upperCase = strOptString3.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            objB = Result.b(ToolStatus.valueOf(upperCase));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        ToolStatus toolStatus = ToolStatus.OK;
        if (Result.g(objB)) {
            objB = toolStatus;
        }
        ToolStatus toolStatus2 = (ToolStatus) objB;
        JSONObject jSONObjectOptJSONObject2 = obj.optJSONObject("result");
        Map<String, Object> mapU = jSONObjectOptJSONObject2 != null ? this.base.U(jSONObjectOptJSONObject2) : null;
        String strOptString4 = obj.optString("errorCode");
        String str = strOptString4.length() == 0 ? null : strOptString4;
        String strOptString5 = obj.optString("errorMessage");
        String str2 = strOptString5.length() == 0 ? null : strOptString5;
        JSONObject jSONObjectOptJSONObject3 = obj.optJSONObject(com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE);
        return new ToolCall(strOptString, strOptString2, map, toolStatus2, mapU, str, str2, jSONObjectOptJSONObject3 != null ? this.base.U(jSONObjectOptJSONObject3) : null);
    }

    public final Object I(String str, Map<String, ? extends Object> map, long j10, InterfaceC4014c<? super InvokeResult> interfaceC4014c) {
        return this.base.a0(str, map, j10, interfaceC4014c);
    }

    public final String K() {
        String str = this.clientId;
        if (str != null) {
            if (La.H.x0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (La.H.x0(this.clientIdFallback)) {
            throw new IllegalStateException("clientId required: set binding.clientId before start() or use toAgentBusBinding(clientId=…)");
        }
        return this.clientIdFallback;
    }

    public final Object L(String str, Map<String, ? extends Object> map, InterfaceC4014c<? super String> interfaceC4014c) {
        return this.base.e0(str, map, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M(java.lang.String r9, a4.Message r10, java.lang.String r11, java.lang.Long r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.M(java.lang.String, a4.w, java.lang.String, java.lang.Long, e9.c):java.lang.Object");
    }

    public final Object N(String str, Map<String, ? extends Object> map, InterfaceC4014c<? super String> interfaceC4014c) {
        return this.base.f0(str, map, interfaceC4014c);
    }

    public final void O(String str) {
        this.clientId = str;
    }

    public final void P(String str) {
        this.packageName = str;
    }

    public final void Q() {
        this.base.g0();
    }

    public final void R() {
        this.base.h0();
    }

    public final Object m(long j10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return this.base.C(j10, interfaceC4014c);
    }

    public final Object o(String str, long j10, InterfaceC4014c<? super JSONObject> interfaceC4014c) {
        return this.base.D(str, j10, interfaceC4014c);
    }

    public final String q() {
        ArrayList arrayList = new ArrayList();
        String str = this.packageName;
        if (str != null) {
            arrayList.add("\"packageName\":\"" + str + "\"");
        }
        long j10 = this.idleTimeoutMs;
        if (j10 > 0) {
            arrayList.add("\"idleTimeout\":" + j10);
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        return Const.STR_MART_COMMA + Z8.F.A0(arrayList, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(org.json.JSONObject r12, e9.InterfaceC4014c<? super Y8.t> r13) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding.r(org.json.JSONObject, e9.c):java.lang.Object");
    }

    /* renamed from: s, reason: from getter */
    public final BffApi getBff() {
        return this.bff;
    }

    /* renamed from: t, reason: from getter */
    public final ChatApi getChat() {
        return this.chat;
    }

    public final Xa.t<Boolean> u() {
        return this.connected;
    }

    public final Xa.o<CustomEvent> v() {
        return this.customEvents;
    }

    /* renamed from: w, reason: from getter */
    public final String getDefaultSessionId() {
        return this.defaultSessionId;
    }

    /* renamed from: x, reason: from getter */
    public final b getHealth() {
        return this.health;
    }

    public final InterfaceC5074l<ChannelReadyEvent, Y8.t> y() {
        return this.base.O();
    }

    /* renamed from: z, reason: from getter */
    public final SessionsApi getSessions() {
        return this.sessions;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding$a;", "", "", "frameId", "", "accepted", "queued", "<init>", "(Ljava/lang/String;ZZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", Const.INTENT_KEY_APIKEY, "()Z", "c", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$a, reason: from toString */
    public static final /* data */ class BffSendResult {
        private final boolean accepted;
        private final String frameId;
        private final boolean queued;

        public BffSendResult(String frameId, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(frameId, "frameId");
            this.frameId = frameId;
            this.accepted = z10;
            this.queued = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAccepted() {
            return this.accepted;
        }

        /* renamed from: b, reason: from getter */
        public final String getFrameId() {
            return this.frameId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getQueued() {
            return this.queued;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BffSendResult)) {
                return false;
            }
            BffSendResult bffSendResult = (BffSendResult) other;
            return kotlin.jvm.internal.p.d(this.frameId, bffSendResult.frameId) && this.accepted == bffSendResult.accepted && this.queued == bffSendResult.queued;
        }

        public int hashCode() {
            return (((this.frameId.hashCode() * 31) + Boolean.hashCode(this.accepted)) * 31) + Boolean.hashCode(this.queued);
        }

        public String toString() {
            return "BffSendResult(frameId=" + this.frameId + ", accepted=" + this.accepted + ", queued=" + this.queued + ")";
        }

        public /* synthetic */ BffSendResult(String str, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
            this(str, z10, (i10 & 4) != 0 ? false : z11);
        }
    }
}
