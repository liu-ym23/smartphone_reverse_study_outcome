package com.stepos.agentframework.adapter.bff;

import A6.i;
import B9.Q;
import C7.f;
import C7.r;
import H4.o;
import J7.c;
import S7.n;
import V4.AbstractC0262i;
import V4.C0257d;
import V4.l;
import android.util.Base64;
import androidx.collection.ArraySet;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.protobuf.X1;
import com.google.protobuf.a3;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.bff.utils.SafeCounterUtils;
import com.stepos.agentframework.adapter.netcore.ExtKt;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.ToolResponse;
import com.stepos.common.RequiredAction;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.zyql.protobuf.common.Content$Builder;
import com.zyql.protobuf.common.LogLevel;
import com.zyql.protobuf.connection.AuthBindReq$Builder;
import com.zyql.protobuf.connection.Head$Builder;
import com.zyql.protobuf.omni.ChatRequest$Builder;
import com.zyql.protobuf.runtime.ExecutionOptions$Builder;
import com.zyql.protobuf.skull.Message$Builder;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.AbstractC1702U;
import m9.C1703V;
import m9.C1704W;
import m9.InterfaceC1733z;
import m9.c0;
import org.java_websocket.enums.ReadyState;
import q7.C1808f;
import r7.g;
import s7.C1918a;
import t7.h;
import u7.q;
import v7.v;
import w7.C2105a;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¯\u00012\u00020\u0001:\u0002¯\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J%\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010!\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u0019\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010%\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b%\u0010)J!\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0004\b-\u0010.J\u000f\u00101\u001a\u00020\u0006H\u0000¢\u0006\u0004\b0\u0010\bJ\u001f\u00107\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001b2\u0006\u00104\u001a\u000203H\u0000¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\f¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\bJ)\u0010=\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010<\u001a\u00020\fH\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010B\u001a\u00020\u00062\u000e\u0010A\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\bJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\bJ\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\bJ\u000f\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010\bJ\u001f\u0010J\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010KJE\u0010O\u001a\u00020N2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\b\u0002\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0L2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010\bJ#\u0010U\u001a\u00020\u00062\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00060RH\u0002¢\u0006\u0004\bU\u0010VJ+\u0010U\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001b2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00060RH\u0002¢\u0006\u0004\bU\u0010WJ\u0017\u0010Y\u001a\u00020X2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b[\u0010\bJ\u000f\u0010\\\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\\\u0010\bJ\u0019\u0010^\u001a\u00020\f2\b\u0010]\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\u001bH\u0002¢\u0006\u0004\b`\u0010aJ\u001f\u0010c\u001a\u00020b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u001bH\u0002¢\u0006\u0004\bc\u0010dJ%\u0010f\u001a\u00020e2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010LH\u0002¢\u0006\u0004\bf\u0010gJ\u000f\u0010i\u001a\u00020hH\u0002¢\u0006\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010\u0013R4\u0010}\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020S0{j\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020S`|8\u0006¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0083\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00010\u0081\u00018\u0006¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u0088\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0087\u00010\u0081\u00018\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0084\u0001\u001a\u0006\b\u0089\u0001\u0010\u0086\u0001R(\u0010\u008a\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0005\b\u008e\u0001\u0010&R'\u0010\u008f\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0005\b\u008f\u0001\u0010\u000e\"\u0005\b\u0091\u0001\u0010:R\u0019\u0010\u0092\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\u0097\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0097\u0001\u0010\u0090\u0001\u001a\u0005\b\u0097\u0001\u0010\u000e\"\u0005\b\u0098\u0001\u0010:R\u0019\u0010\u0099\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0090\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0090\u0001R\u0019\u0010\u009b\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0090\u0001R\u001a\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0096\u0001RD\u0010¤\u0001\u001a/\u0012\u000f\u0012\r ¢\u0001*\u0005\u0018\u00010¡\u00010¡\u0001 ¢\u0001*\u0016\u0012\u000f\u0012\r ¢\u0001*\u0005\u0018\u00010¡\u00010¡\u0001\u0018\u00010£\u00010 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010§\u0001\u001a\u00030¦\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R \u0010ª\u0001\u001a\u00030©\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u008b\u0001¨\u0006°\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffClient;", "Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;", "Lcom/stepos/agentframework/adapter/bff/Option;", "option", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/bff/Option;)V", "LC7/r;", "init", "()V", "reconnect", "(LH7/c;)Ljava/lang/Object;", "reconnectSafe", "", "isClose", "()Z", "isOpen", "Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "authInfo", "updateAuth", "(Lcom/stepos/agentframework/adapter/bff/AuthInfo;)V", "sendAuth", "Lcom/stepos/agentframework/adapter/bff/BffRouter;", "router", "LV4/l;", "requestInfo", "Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "callback", "", "chat", "(Lcom/stepos/agentframework/adapter/bff/BffRouter;LV4/l;Lcom/stepos/agentframework/adapter/bff/IDataCallback;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/ToolResponse;", "toolResponse", AgentBusWakeContract.EXTRA_TRACE_ID, "sendToolResponse", "(Lcom/stepos/agentframework/adapter/bff/BffRouter;Lcom/stepos/agentframework/adapter/netcore/ToolResponse;Ljava/lang/String;)Ljava/lang/String;", "onConnect", SettingsConfig.KEY_DATA, "onDataReceived", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "_data", "(Ljava/nio/ByteBuffer;)V", "", "code", "reason", "authFail$bff_debug", "(ILjava/lang/String;)V", "authFail", "authSuccess$bff_debug", "authSuccess", "id", "Lv7/v;", "toolCall", "callTool$bff_debug", "(Ljava/lang/String;Lv7/v;)V", "callTool", "isAvailable", "onNetworkChanged", "(Z)V", "close", "remote", "onClose", "(ILjava/lang/String;Z)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onError", "(Ljava/lang/Exception;)V", Constants.METHOD_CONNECT, "reconnectAuto", "checkReconnect", "sendHeart", "", "byteArray", "send", "(Ljava/lang/String;[B)V", "", "map", "Lr7/f;", "createHeader", "(Lcom/stepos/agentframework/adapter/bff/BffRouter;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lr7/f;", "removeNull", "Lkotlin/Function1;", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "notifyCallback", "(LS7/k;)V", "(Ljava/lang/String;LS7/k;)V", "Lcom/stepos/common/RequiredAction$SubmitToolOutputs$ToolCall;", "toolCallToRequiredToolcall", "(Lv7/v;)Lcom/stepos/common/RequiredAction$SubmitToolOutputs$ToolCall;", "refreshIdleTimer", "closeForIdle", "aiCommand", "isNewProtocol", "(Ljava/lang/String;)Z", "getWrapperAgentId", "(Ljava/lang/String;)Ljava/lang/String;", "Lu7/d;", "getChatRequest", "(LV4/l;Ljava/lang/String;)Lu7/d;", "Lcom/google/protobuf/Struct;", "getMetadata", "(Ljava/util/Map;)Lcom/google/protobuf/Struct;", "Lu7/f;", "getExecutionOptions", "()Lu7/f;", "Lm9/U;", "wsDispatcher", "Lm9/U;", "Lw9/a;", "reconnectMutex", "Lw9/a;", "Lcom/stepos/agentframework/adapter/bff/ZyqlWebSocketClient;", "client$delegate", "LC7/f;", "getClient", "()Lcom/stepos/agentframework/adapter/bff/ZyqlWebSocketClient;", "client", "Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "getAuthInfo", "()Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "setAuthInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callbackCache", "Ljava/util/HashMap;", "getCallbackCache", "()Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/IAuthCallback;", "authCallback", "Ljava/lang/ref/WeakReference;", "getAuthCallback", "()Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/IConnectCallback;", "connectCallback", "getConnectCallback", "deviceId", "Ljava/lang/String;", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "isAutoReconnect", "Z", "setAutoReconnect", "reconnectCount", "I", "Lm9/c0;", "reconnectJob", "Lm9/c0;", "isCloseSelf", "setCloseSelf", "isAuthSuccess", "isLazyConnect", "isIdleClose", "", "idleTimeout", "J", "idleJob", "", "Lcom/stepos/agentframework/adapter/bff/PendingTask;", "kotlin.jvm.PlatformType", "", "pendingQueue", "Ljava/util/List;", "Lcom/stepos/agentframework/adapter/bff/BffCommandDispatcher;", "commandDispatcher", "Lcom/stepos/agentframework/adapter/bff/BffCommandDispatcher;", "Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "heartbeatManager", "Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "getHeartbeatManager$bff_debug", "()Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "resumeToken", "Companion", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BffClient implements IOriDataCallback {
    private static final long BASE_BACKOFF_TIMEOUT = 2000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AbstractC1702U HeartPool;
    private static final long MAX_BACKOFF_TIMEOUT = 60000;
    private static final int MAX_RECONNECT_COUNT = 5;
    public static final String TAG = " [BffClient] ";
    private final WeakReference<IAuthCallback> authCallback;
    private AuthInfo authInfo;
    private final HashMap<String, CacheBean> callbackCache;

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private final f client;
    private final BffCommandDispatcher commandDispatcher;
    private final WeakReference<IConnectCallback> connectCallback;
    private String deviceId;
    private final BffHeartbeatManager heartbeatManager;
    private c0 idleJob;
    private long idleTimeout;
    private boolean isAuthSuccess;
    private boolean isAutoReconnect;
    private boolean isCloseSelf;
    private boolean isIdleClose;
    private boolean isLazyConnect;
    private final List<PendingTask> pendingQueue;
    private int reconnectCount;
    private c0 reconnectJob;
    private final InterfaceC2108a reconnectMutex;
    private String resumeToken;
    private final AbstractC1702U wsDispatcher;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffClient$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lm9/U;", "HeartPool", "Lm9/U;", "getHeartPool", "()Lm9/U;", "", "TAG", "Ljava/lang/String;", "", "BASE_BACKOFF_TIMEOUT", "J", "MAX_BACKOFF_TIMEOUT", "", "MAX_RECONNECT_COUNT", "I", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AbstractC1702U getHeartPool() {
            return BffClient.HeartPool;
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.agentframework.adapter.bff.BffClient$reconnectAuto$1", f = "BffClient.kt", l = {193, 197}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.bff.BffClient$reconnectAuto$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = BffClient.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
        
            if (r11.reconnect(r10) == r1) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r10.label
                java.lang.String r3 = " [BffClient] "
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L25
                if (r2 == r5) goto L1f
                if (r2 != r4) goto L17
                kotlin.b.b(r11)
                goto La9
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1f:
                long r6 = r10.J$0
                kotlin.b.b(r11)
                goto L7f
            L25:
                kotlin.b.b(r11)
                com.stepos.agentframework.adapter.bff.BffClient r11 = com.stepos.agentframework.adapter.bff.BffClient.this
                int r11 = com.stepos.agentframework.adapter.bff.BffClient.access$getReconnectCount$p(r11)
                r2 = 5
                if (r11 >= r2) goto Lb2
                com.stepos.agentframework.adapter.bff.BffClient r11 = com.stepos.agentframework.adapter.bff.BffClient.this
                int r11 = com.stepos.agentframework.adapter.bff.BffClient.access$getReconnectCount$p(r11)
                double r6 = (double) r11
                r8 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r6 = java.lang.Math.pow(r8, r6)
                long r6 = (long) r6
                r8 = 2000(0x7d0, double:9.88E-321)
                long r6 = r6 * r8
                r8 = 60000(0xea60, double:2.9644E-319)
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 <= 0) goto L4a
                r6 = r8
            L4a:
                com.stepos.agentframework.adapter.netcore.ILogger r11 = com.stepos.agentframework.adapter.bff.LogUtilKt.getLogger()
                com.stepos.agentframework.adapter.bff.BffClient r2 = com.stepos.agentframework.adapter.bff.BffClient.this
                int r2 = com.stepos.agentframework.adapter.bff.BffClient.access$getReconnectCount$p(r2)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "Next reconnect attempt in "
                r8.<init>(r9)
                r8.append(r6)
                java.lang.String r9 = "ms (count="
                r8.append(r9)
                r8.append(r2)
                java.lang.String r2 = ")"
                r8.append(r2)
                java.lang.String r2 = r8.toString()
                r11.i(r3, r2)
                r10.L$0 = r0
                r10.J$0 = r6
                r10.label = r5
                java.lang.Object r11 = kotlinx.coroutines.a.f(r6, r10)
                if (r11 != r1) goto L7f
                goto La8
            L7f:
                boolean r11 = m9.AbstractC1683A.l(r0)
                if (r11 == 0) goto Lb2
                com.stepos.agentframework.adapter.bff.BffClient r11 = com.stepos.agentframework.adapter.bff.BffClient.this
                boolean r11 = r11.isOpen()
                if (r11 != 0) goto Lb2
                com.stepos.agentframework.adapter.bff.BffClient r11 = com.stepos.agentframework.adapter.bff.BffClient.this
                int r11 = com.stepos.agentframework.adapter.bff.BffClient.access$getReconnectCount$p(r11)
                com.stepos.agentframework.adapter.bff.BffClient r0 = com.stepos.agentframework.adapter.bff.BffClient.this
                int r11 = r11 + r5
                com.stepos.agentframework.adapter.bff.BffClient.access$setReconnectCount$p(r0, r11)
                com.stepos.agentframework.adapter.bff.BffClient r11 = com.stepos.agentframework.adapter.bff.BffClient.this
                r0 = 0
                r10.L$0 = r0
                r10.J$0 = r6
                r10.label = r4
                java.lang.Object r10 = r11.reconnect(r10)
                if (r10 != r1) goto La9
            La8:
                return r1
            La9:
                com.stepos.agentframework.adapter.netcore.ILogger r10 = com.stepos.agentframework.adapter.bff.LogUtilKt.getLogger()
                java.lang.String r11 = "reconnectAuto"
                r10.i(r3, r11)
            Lb2:
                C7.r r10 = C7.r.f317a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffClient.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.bff.BffClient", f = "BffClient.kt", l = {801, 167}, m = "reconnectSafe", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10831 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10831(H7.c<? super C10831> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BffClient.this.reconnectSafe(this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.bff.BffClient$refreshIdleTimer$1", f = "BffClient.kt", l = {673}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.bff.BffClient$refreshIdleTimer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10841 extends SuspendLambda implements n {
        int label;

        public C10841(H7.c<? super C10841> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return BffClient.this.new C10841(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                long j5 = BffClient.this.idleTimeout;
                this.label = 1;
                if (kotlinx.coroutines.a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            if (BffClient.this.isOpen()) {
                LogUtilKt.getLogger().i(BffClient.TAG, androidx.compose.foundation.b.q(BffClient.this.idleTimeout, "Idle timeout reached (", " ms),will closing connection."));
                BffClient.this.closeForIdle();
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10841) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        HeartPool = new C1703V(executorServiceNewSingleThreadExecutor);
    }

    public BffClient(Option option) {
        k.f(option, "option");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.wsDispatcher = new C1703V(executorServiceNewSingleThreadExecutor);
        this.reconnectMutex = new kotlinx.coroutines.sync.a();
        this.client = kotlin.a.a(new i(13, option, this));
        this.authInfo = option.getAuthInfo();
        this.callbackCache = new HashMap<>();
        this.authCallback = new WeakReference<>(option.getAuthCallback());
        this.connectCallback = new WeakReference<>(option.getConnectCallback());
        this.deviceId = option.getDeviceId();
        this.isAutoReconnect = option.isAutoReconnect();
        this.isLazyConnect = option.isLazyConnect();
        this.isIdleClose = option.isIdleClose();
        this.idleTimeout = option.getIdleTimeout();
        this.pendingQueue = Collections.synchronizedList(new ArrayList());
        this.commandDispatcher = new BffCommandDispatcher(this);
        final int i = 0;
        final int i6 = 1;
        this.heartbeatManager = new BffHeartbeatManager(new S7.a(this) { // from class: com.stepos.agentframework.adapter.bff.a
            public final /* synthetic */ BffClient b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i10 = i;
                BffClient bffClient = this.b;
                switch (i10) {
                    case 0:
                        return BffClient.heartbeatManager$lambda$0(bffClient);
                    default:
                        return BffClient.heartbeatManager$lambda$1(bffClient);
                }
            }
        }, new S7.a(this) { // from class: com.stepos.agentframework.adapter.bff.a
            public final /* synthetic */ BffClient b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i10 = i6;
                BffClient bffClient = this.b;
                switch (i10) {
                    case 0:
                        return BffClient.heartbeatManager$lambda$0(bffClient);
                    default:
                        return BffClient.heartbeatManager$lambda$1(bffClient);
                }
            }
        });
        this.resumeToken = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r callTool$lambda$0(RequiredAction requiredAction, String str, CacheBean it) {
        k.f(it, "it");
        l chatRequestInfo = it.getChatRequestInfo();
        k.c(chatRequestInfo);
        V4.k kVar = new V4.k(null, "assistant", chatRequestInfo.e, "text", null, chatRequestInfo.f1364a, null, 1, false, null, 2, "111111111", null, null, -679682063);
        IDataCallback iDataCallback = it.getCallback().get();
        if (iDataCallback != null) {
            iDataCallback.onDataReceived(str, kVar);
        }
        return r.f317a;
    }

    private final void checkReconnect() {
        LogUtilKt.getLogger().i(TAG, "onClose:isAutoReconnect:" + this.isAutoReconnect + ",isCloseSelf:" + this.isCloseSelf);
        if (!this.isAutoReconnect || this.isCloseSelf) {
            return;
        }
        reconnectAuto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZyqlWebSocketClient client_delegate$lambda$0(Option option, BffClient bffClient) {
        return new ZyqlWebSocketClient(new URI(option.getUrl()), bffClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeForIdle() {
        try {
            this.isCloseSelf = true;
            getClient().close();
            LogUtilKt.getLogger().i(TAG, "Start close for idle.");
        } catch (Exception e) {
            LogUtilKt.getLogger().e(TAG, "closeForIdle error: " + e);
        }
    }

    private final void connect() {
        LogUtilKt.getLogger().i(TAG, "connect:" + isOpen() + ", " + isClose() + ", " + getClient().getReadyState());
        try {
            if (getClient().getReadyState() == ReadyState.NOT_YET_CONNECTED) {
                getClient().connect();
            } else {
                getClient().reconnect();
            }
        } catch (Exception e) {
            LogUtilKt.getLogger().e(TAG, "connect error:" + e.getMessage());
            IConnectCallback iConnectCallback = this.connectCallback.get();
            if (iConnectCallback != null) {
                iConnectCallback.onError(e);
            }
        }
    }

    private final r7.f createHeader(BffRouter router, Map<String, String> map, String id, String traceId) {
        String strValueOf = String.valueOf(UUID.randomUUID());
        d.s(TAG, "createHeader traceId: " + traceId + ", uuid: " + strValueOf);
        Head$Builder msgType = r7.f.e0().setFrameType(0).setMsgType(0);
        if (id == null) {
            id = strValueOf;
        }
        Head$Builder head$BuilderPutMeta = msgType.setMsgId(id).setModule(router.getBizModule()).setCommand(router.getBizCommand()).putMeta(BffConstant._DeviceId, this.deviceId);
        if (traceId == null) {
            traceId = strValueOf;
        }
        Head$Builder head$BuilderPutMeta2 = head$BuilderPutMeta.putMeta(BffConstant._TraceId, traceId);
        String str = this.resumeToken;
        if (str == null) {
            str = "";
        }
        r7.f fVar = (r7.f) head$BuilderPutMeta2.putMeta("resume_token", str).putAllMeta(map).k();
        k.c(fVar);
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r7.f createHeader$default(BffClient bffClient, BffRouter bffRouter, Map map, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return bffClient.createHeader(bffRouter, map, str, str2);
    }

    private final u7.d getChatRequest(l requestInfo, String aiCommand) {
        String wrapperAgentId = getWrapperAgentId(aiCommand);
        LogUtilKt.getLogger().i(TAG, "getChatRequest requestInfo: " + requestInfo + ", aiCommand: " + aiCommand + ", agentId: " + wrapperAgentId);
        Content$Builder role = C1808f.U().setRole(BffConstant.Role.User);
        List list = requestInfo.c;
        C1808f c1808f = (C1808f) role.addAllParts(list != null ? ChatContentExtKt.toPrats(list, false) : null).k();
        requestInfo.h = SafeCounterUtils.INSTANCE.incrementAndGet();
        String str = requestInfo.e;
        u7.d dVar = (str == null || str.length() == 0) ? (u7.d) u7.d.Y().setId(requestInfo.h).setStartAgentRequest(q.p0().setAgentId(wrapperAgentId).addAllMessages(o.M(c1808f)).setMetadata(getMetadata(null)).setOptions(getExecutionOptions())).k() : (u7.d) u7.d.Y().setId(requestInfo.h).setSendInputRequest(u7.o.Z().setSessionId(requestInfo.e).addAllMessages(o.M(c1808f)).setMetadata(getMetadata(null))).k();
        LogUtilKt.getLogger().i(TAG, "getChatRequest request: " + ExtKt.toJson(dVar));
        k.c(dVar);
        return dVar;
    }

    private final u7.f getExecutionOptions() {
        ExecutionOptions$Builder executionOptions$BuilderB0 = u7.f.b0();
        boolean z10 = BuildConfig.DEBUG;
        GeneratedMessageLite generatedMessageLiteBuild = executionOptions$BuilderB0.setIncludeFunctionCallOutput(z10).setSendCompleteMessage(false).setIncludeSubAgentOutput(z10).setObserverMode(z10).setLogLevel(z10 ? LogLevel.LOG_LEVEL_DEBUG : LogLevel.LOG_LEVEL_INFO).k();
        k.e(generatedMessageLiteBuild, "build(...)");
        return (u7.f) generatedMessageLiteBuild;
    }

    private final Struct getMetadata(Map<String, String> map) {
        C1014y2 c1014y2G = Struct.e.toBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                a3 a3VarL = Value.f.toBuilder();
                String value = entry.getValue();
                value.getClass();
                a3VarL.e = 3;
                a3VarL.f = value;
                a3VarL.L();
                Value value2 = (Value) a3VarL.k();
                c1014y2G.getClass();
                if (key == null) {
                    throw new NullPointerException("map key");
                }
                if (value2 == null) {
                    throw new NullPointerException("map value");
                }
                c1014y2G.O().J().put(key, value2);
                c1014y2G.e |= 1;
            }
        }
        X1 x1Build = c1014y2G.k();
        k.e(x1Build, "build(...)");
        return (Struct) x1Build;
    }

    private final String getWrapperAgentId(String aiCommand) {
        return k.b(aiCommand, BffConstant.Cmd.VideoNewEdit) ? "2" : k.b(aiCommand, BffConstant.Cmd.NewChat) ? "1" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r heartbeatManager$lambda$0(BffClient bffClient) {
        bffClient.sendHeart();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r heartbeatManager$lambda$1(BffClient bffClient) {
        bffClient.removeNull();
        return r.f317a;
    }

    private final boolean isNewProtocol(String aiCommand) {
        return BffConstant.Cmd.VideoNewEdit.equals(aiCommand) || BffConstant.Cmd.NewChat.equals(aiCommand);
    }

    private final void notifyCallback(S7.k action) {
        Collection<CacheBean> collectionValues = this.callbackCache.values();
        k.e(collectionValues, "<get-values>(...)");
        for (CacheBean cacheBean : collectionValues) {
            k.c(cacheBean);
            action.invoke(cacheBean);
        }
        removeNull();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onDataReceived$lambda$1(Ref$BooleanRef ref$BooleanRef, r7.f fVar, r7.k kVar, CacheBean it) {
        boolean zOnOriginalDataReceived;
        k.f(it, "it");
        IDataCallback iDataCallback = it.getCallback().get();
        if (iDataCallback != null) {
            String strB0 = fVar.b0();
            k.e(strB0, "getMsgId(...)");
            zOnOriginalDataReceived = iDataCallback.onOriginalDataReceived(strB0, kVar);
        } else {
            zOnOriginalDataReceived = false;
        }
        ref$BooleanRef.f4916a = zOnOriginalDataReceived;
        return r.f317a;
    }

    private final void reconnectAuto() {
        if (this.isCloseSelf || !this.isAutoReconnect) {
            return;
        }
        c0 c0Var = this.reconnectJob;
        if (c0Var == null || !c0Var.isActive()) {
            c0 c0Var2 = this.reconnectJob;
            if (c0Var2 != null) {
                c0Var2.cancel(null);
            }
            u9.d dVar = AbstractC1691I.f5315a;
            this.reconnectJob = AbstractC1683A.n(C1704W.f5321a, u9.c.f6743a, new AnonymousClass1(null), 2);
        }
    }

    private final void refreshIdleTimer() {
        LogUtilKt.getLogger().i(TAG, "refreshIdleTimer isIdleClose: " + this.isIdleClose);
        if (this.isIdleClose) {
            c0 c0Var = this.idleJob;
            if (c0Var != null) {
                c0Var.cancel(null);
            }
            this.idleJob = AbstractC1683A.n(C1704W.f5321a, HeartPool, new C10841(null), 2);
        }
    }

    private final void removeNull() {
        int size = this.callbackCache.size();
        ArraySet arraySet = new ArraySet(0, 1, null);
        for (Map.Entry<String, CacheBean> entry : this.callbackCache.entrySet()) {
            if (entry.getValue().getCallback().get() == null) {
                arraySet.add(entry.getKey());
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            this.callbackCache.remove((String) it.next());
        }
        LogUtilKt.getLogger().i(TAG, androidx.compose.foundation.b.n(size, this.callbackCache.size(), "removeNull: ", " -> "));
    }

    private final void send(String id, byte[] byteArray) {
        try {
            LogUtilKt.getLogger().i(TAG, "send_id:" + id);
            if (!getClient().isClosed()) {
                getClient().send(byteArray);
            } else {
                LogUtilKt.getLogger().i(TAG, "send client is closed");
                notifyCallback(new androidx.compose.ui.text.d(18));
            }
        } catch (Exception e) {
            LogUtilKt.getLogger().e(TAG, "send:" + e);
            notifyCallback(id, new Q(e, 27));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r send$lambda$0(CacheBean it) {
        k.f(it, "it");
        IDataCallback iDataCallback = it.getCallback().get();
        if (iDataCallback != null) {
            iDataCallback.onError(it.getSendId(), 100001, "connect break");
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r send$lambda$1(Exception exc, CacheBean it) {
        k.f(it, "it");
        IDataCallback iDataCallback = it.getCallback().get();
        if (iDataCallback != null) {
            iDataCallback.onError(it.getSendId(), BffConstant.Error.RuntimeError, exc.toString());
        }
        return r.f317a;
    }

    private final void sendHeart() {
        if (!isOpen()) {
            LogUtilKt.getLogger().i(TAG, "send heart break client is closed");
            return;
        }
        LogUtilKt.getLogger().i(TAG, "sendHeartReal");
        r7.f fVarCreateHeader$default = createHeader$default(this, new BffRouter(BffConstant.Module.Stream, BffConstant.Cmd.Heartbeat, null, null, 12, null), null, null, null, 14, null);
        r7.k kVar = (r7.k) r7.k.M().setBody(((g) g.E().k()).n()).setHead(fVarCreateHeader$default).k();
        try {
            String strB0 = fVarCreateHeader$default.b0();
            k.e(strB0, "getMsgId(...)");
            send(strB0, kVar.m());
            this.heartbeatManager.scheduleNext();
        } catch (Exception e) {
            LogUtilKt.getLogger().e(TAG, "Heartbeat send failed: " + e);
        }
    }

    private final RequiredAction.SubmitToolOutputs.ToolCall toolCallToRequiredToolcall(v toolCall) {
        String strI = toolCall.T().I();
        k.e(strI, "getParams(...)");
        String strW = toolCall.V().W();
        k.e(strW, "getName(...)");
        RequiredAction.SubmitToolOutputs.ToolCall.Function function = new RequiredAction.SubmitToolOutputs.ToolCall.Function(strI, strW, toolCall.V().U());
        String strQ = toolCall.Q();
        k.e(strQ, "getCallId(...)");
        return new RequiredAction.SubmitToolOutputs.ToolCall(function, strQ, null, null, 12, null);
    }

    public final void authFail$bff_debug(int code, String reason) {
        IAuthCallback iAuthCallback;
        LogUtilKt.getLogger().i(TAG, androidx.constraintlayout.core.dsl.a.c(code, "authError: ", " ", reason));
        this.isAuthSuccess = false;
        WeakReference<IAuthCallback> weakReference = this.authCallback;
        if (weakReference == null || (iAuthCallback = weakReference.get()) == null) {
            return;
        }
        iAuthCallback.onAuthFail(code, reason);
    }

    public final void authSuccess$bff_debug() {
        IAuthCallback iAuthCallback;
        LogUtilKt.getLogger().i(TAG, "authSuccess");
        this.isAuthSuccess = true;
        WeakReference<IAuthCallback> weakReference = this.authCallback;
        if (weakReference != null && (iAuthCallback = weakReference.get()) != null) {
            iAuthCallback.onAuthSuccess();
        }
        List<PendingTask> pendingQueue = this.pendingQueue;
        k.e(pendingQueue, "pendingQueue");
        synchronized (pendingQueue) {
            Iterator<PendingTask> it = this.pendingQueue.iterator();
            while (it.hasNext()) {
                PendingTask next = it.next();
                LogUtilKt.getLogger().i(TAG, "Sending pending task after auth: " + next.getId());
                this.callbackCache.put(next.getId(), next.getBean());
                send(next.getId(), next.getData());
                it.remove();
            }
        }
        sendHeart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void callTool$bff_debug(String id, v toolCall) {
        k.f(id, "id");
        k.f(toolCall, "toolCall");
        notifyCallback(id, new R3.b(22, new RequiredAction(new RequiredAction.SubmitToolOutputs(o.M(toolCallToRequiredToolcall(toolCall))), null, 2, 0 == true ? 1 : 0), id));
    }

    public final String chat(BffRouter router, l requestInfo, IDataCallback callback) {
        AbstractC0262i abstractC0262i;
        ByteString byteStringN;
        Object next;
        k.f(router, "router");
        k.f(requestInfo, "requestInfo");
        k.f(callback, "callback");
        LogUtilKt.getLogger().i(TAG, "chat_router:" + ExtKt.toJson(router));
        r7.f fVarCreateHeader$default = createHeader$default(this, new BffRouter(router.getBizModule(), router.getBizCommand(), null, null, 12, null), new HashMap(), null, requestInfo.f1370j, 4, null);
        String strB0 = fVarCreateHeader$default.b0();
        k.e(strB0, "getMsgId(...)");
        CacheBean cacheBean = new CacheBean(strB0, requestInfo, new WeakReference(callback));
        List list = requestInfo.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((AbstractC0262i) next) instanceof C0257d) {
                    break;
                }
            }
            abstractC0262i = (AbstractC0262i) next;
        } else {
            abstractC0262i = null;
        }
        C0257d c0257d = abstractC0262i instanceof C0257d ? (C0257d) abstractC0262i : null;
        byte[] bArr = c0257d != null ? c0257d.b : null;
        if (bArr != null) {
            byteStringN = ByteString.e(bArr, 0, bArr.length);
        } else if (isNewProtocol(router.getAiCommand())) {
            String aiCommand = router.getAiCommand();
            k.c(aiCommand);
            byteStringN = getChatRequest(requestInfo, aiCommand).n();
        } else {
            Message$Builder message$BuilderZ = v7.i.Z();
            if (list != null) {
                k.c(message$BuilderZ);
                List<v7.l> resourceList = ChatContentExtKt.toResourceList(list, message$BuilderZ);
                if (resourceList != null) {
                    LogUtilKt.getLogger().i(TAG, "resources:" + resourceList + ". content:" + message$BuilderZ.getContent());
                    message$BuilderZ.addAllResources(resourceList);
                }
            }
            ChatRequest$Builder message = h.l0().setMessage((v7.i) message$BuilderZ.setRole(BffConstant.Role.User).k());
            String str = requestInfo.e;
            if (str == null) {
                str = "";
            }
            byteStringN = ((h) message.setChatId(str).setIsMock(false).setNeedTts(false).k()).n();
        }
        r7.k kVar = (r7.k) r7.k.M().setBody(((C2105a) C2105a.W().setMsgId(fVarCreateHeader$default.b0()).setCommand(router.getAiCommand()).setModule(router.getAiModule()).setBody(byteStringN).k()).n()).setHead(fVarCreateHeader$default).k();
        byte[] bArrM = kVar.m();
        if (isOpen() && this.isAuthSuccess) {
            LogUtilKt.getLogger().i(TAG, "sendText:" + ExtKt.toJson(kVar));
            this.callbackCache.put(fVarCreateHeader$default.b0(), cacheBean);
            String strB02 = fVarCreateHeader$default.b0();
            k.e(strB02, "getMsgId(...)");
            send(strB02, kVar.m());
            refreshIdleTimer();
            String strB03 = fVarCreateHeader$default.b0();
            k.e(strB03, "getMsgId(...)");
            return strB03;
        }
        LogUtilKt.getLogger().i(TAG, "Connection not ready, queuing message: " + fVarCreateHeader$default.b0());
        if (!isOpen()) {
            this.isCloseSelf = false;
            this.reconnectCount = 0;
            connect();
        }
        List<PendingTask> list2 = this.pendingQueue;
        String strB04 = fVarCreateHeader$default.b0();
        k.e(strB04, "getMsgId(...)");
        list2.add(new PendingTask(strB04, bArrM, cacheBean));
        String strB05 = fVarCreateHeader$default.b0();
        k.e(strB05, "getMsgId(...)");
        return strB05;
    }

    public final void close() {
        try {
            LogUtilKt.getLogger().i(TAG, "do close");
            this.isCloseSelf = true;
            this.pendingQueue.clear();
            c0 c0Var = this.idleJob;
            if (c0Var != null) {
                c0Var.cancel(null);
            }
            this.heartbeatManager.stop();
            getClient().close();
        } catch (Exception e) {
            LogUtilKt.getLogger().i(TAG, "close error: " + e);
        }
    }

    public final WeakReference<IAuthCallback> getAuthCallback() {
        return this.authCallback;
    }

    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public final HashMap<String, CacheBean> getCallbackCache() {
        return this.callbackCache;
    }

    public final ZyqlWebSocketClient getClient() {
        return (ZyqlWebSocketClient) this.client.getF4884a();
    }

    public final WeakReference<IConnectCallback> getConnectCallback() {
        return this.connectCallback;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: getHeartbeatManager$bff_debug, reason: from getter */
    public final BffHeartbeatManager getHeartbeatManager() {
        return this.heartbeatManager;
    }

    public final void init() {
        LogUtilKt.getLogger().i(TAG, "init: isLazyConnect=" + this.isLazyConnect);
        if (this.isLazyConnect) {
            LogUtilKt.getLogger().i(TAG, "lazy connnect. will connect later");
        } else {
            connect();
        }
    }

    /* renamed from: isAutoReconnect, reason: from getter */
    public final boolean getIsAutoReconnect() {
        return this.isAutoReconnect;
    }

    public final boolean isClose() {
        return getClient().isClosed();
    }

    /* renamed from: isCloseSelf, reason: from getter */
    public final boolean getIsCloseSelf() {
        return this.isCloseSelf;
    }

    public final boolean isOpen() {
        return getClient().isOpen();
    }

    @Override // com.stepos.agentframework.adapter.bff.IConnectCallback
    public void onClose(int code, String reason, boolean remote) {
        IConnectCallback iConnectCallback;
        ILogger logger = LogUtilKt.getLogger();
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(code, "onClose: ", " ", reason, " ");
        sbK.append(remote);
        logger.i(TAG, sbK.toString());
        if (this.isCloseSelf) {
            this.resumeToken = "";
        }
        this.isAuthSuccess = false;
        WeakReference<IConnectCallback> weakReference = this.connectCallback;
        if (weakReference != null && (iConnectCallback = weakReference.get()) != null) {
            iConnectCallback.onClose(code, reason, remote);
        }
        checkReconnect();
    }

    @Override // com.stepos.agentframework.adapter.bff.IConnectCallback
    public void onConnect() {
        IConnectCallback iConnectCallback;
        LogUtilKt.getLogger().i(TAG, "onConnect:" + isOpen() + "," + isClose() + " " + Thread.currentThread().getName());
        this.reconnectCount = 0;
        c0 c0Var = this.reconnectJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        WeakReference<IConnectCallback> weakReference = this.connectCallback;
        if (weakReference != null && (iConnectCallback = weakReference.get()) != null) {
            iConnectCallback.onConnect();
        }
        AuthInfo authInfo = this.authInfo;
        if (authInfo != null) {
            sendAuth(authInfo);
        }
        refreshIdleTimer();
    }

    @Override // com.stepos.agentframework.adapter.bff.IOriDataCallback
    public void onDataReceived(String data) {
        LogUtilKt.getLogger().i(TAG, "onDataReceived str:" + data);
    }

    @Override // com.stepos.agentframework.adapter.bff.IConnectCallback
    public void onError(Exception e) {
        IConnectCallback iConnectCallback;
        LogUtilKt.getLogger().i(TAG, "onError:" + e);
        this.isAuthSuccess = false;
        if (this.isCloseSelf) {
            List<PendingTask> pendingQueue = this.pendingQueue;
            k.e(pendingQueue, "pendingQueue");
            synchronized (pendingQueue) {
                try {
                    List<PendingTask> pendingQueue2 = this.pendingQueue;
                    k.e(pendingQueue2, "pendingQueue");
                    for (PendingTask pendingTask : pendingQueue2) {
                        IDataCallback iDataCallback = pendingTask.getBean().getCallback().get();
                        if (iDataCallback != null) {
                            iDataCallback.onError(pendingTask.getId(), 100001, "Connection failed");
                        }
                    }
                    this.pendingQueue.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        WeakReference<IConnectCallback> weakReference = this.connectCallback;
        if (weakReference != null && (iConnectCallback = weakReference.get()) != null) {
            iConnectCallback.onError(e);
        }
        checkReconnect();
    }

    public final void onNetworkChanged(boolean isAvailable) {
        LogUtilKt.getLogger().i(TAG, "onNetworkChanged: isAvailable = " + isAvailable);
        if (!isAvailable) {
            c0 c0Var = this.reconnectJob;
            if (c0Var != null) {
                c0Var.cancel(null);
            }
            LogUtilKt.getLogger().i(TAG, "Netowrk unavailable, temple stop reconnect.");
            return;
        }
        if (this.isCloseSelf || isOpen()) {
            return;
        }
        LogUtilKt.getLogger().i(TAG, "Network recover. start to reconnect.");
        this.reconnectCount = 0;
        reconnectAuto();
    }

    public final Object reconnect(H7.c<? super r> cVar) throws Throwable {
        Object objReconnectSafe = reconnectSafe(cVar);
        return objReconnectSafe == CoroutineSingletons.f4909a ? objReconnectSafe : r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reconnectSafe(H7.c<? super C7.r> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.bff.BffClient.C10831
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1 r0 = (com.stepos.agentframework.adapter.bff.BffClient.C10831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1 r0 = new com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r10 = r0.L$0
            w9.a r10 = (w9.InterfaceC2108a) r10
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L30
            goto L7c
        L30:
            r11 = move-exception
            goto L88
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            w9.a r5 = (w9.InterfaceC2108a) r5
            kotlin.b.b(r11)
            r11 = r5
            goto L58
        L45:
            kotlin.b.b(r11)
            w9.a r11 = r10.reconnectMutex
            r0.L$0 = r11
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r11.lock(r6, r0)
            if (r2 != r1) goto L57
            goto L78
        L57:
            r2 = r3
        L58:
            com.stepos.agentframework.adapter.netcore.ILogger r5 = com.stepos.agentframework.adapter.bff.LogUtilKt.getLogger()     // Catch: java.lang.Throwable -> L84
            java.lang.String r7 = " [BffClient] "
            java.lang.String r8 = "reconnectSafe"
            r5.i(r7, r8)     // Catch: java.lang.Throwable -> L84
            m9.U r5 = r10.wsDispatcher     // Catch: java.lang.Throwable -> L84
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$2$1 r7 = new com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$2$1     // Catch: java.lang.Throwable -> L84
            r7.<init>(r10, r6)     // Catch: java.lang.Throwable -> L84
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L84
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L84
            r0.I$1 = r3     // Catch: java.lang.Throwable -> L84
            r0.label = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r10 = m9.AbstractC1683A.w(r5, r7, r0)     // Catch: java.lang.Throwable -> L84
            if (r10 != r1) goto L79
        L78:
            return r1
        L79:
            r9 = r11
            r11 = r10
            r10 = r9
        L7c:
            C7.r r11 = (C7.r) r11     // Catch: java.lang.Throwable -> L30
            r10.unlock(r6)
            C7.r r10 = C7.r.f317a
            return r10
        L84:
            r10 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
        L88:
            r10.unlock(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffClient.reconnectSafe(H7.c):java.lang.Object");
    }

    public final void sendAuth(AuthInfo authInfo) {
        k.f(authInfo, "authInfo");
        LogUtilKt.getLogger().i(TAG, "sendAuth:" + authInfo);
        AuthBindReq$Builder authBindReq$BuilderPutAllReserved = r7.b.x0().setToken(authInfo.getToken()).setUid(authInfo.getUid()).setTokenType(authInfo.getToken_type()).setPlatform(authInfo.getPlatform()).setProduct(authInfo.getProduct()).setDevice(authInfo.getDevice()).setAppVersion(authInfo.getApp_version()).setChannel(authInfo.getChannel()).putAllReserved(authInfo.getReserved());
        String str = this.resumeToken;
        if (str == null) {
            str = "";
        }
        r7.b bVar = (r7.b) authBindReq$BuilderPutAllReserved.putReserved("resume_token", str).k();
        r7.f fVarCreateHeader$default = createHeader$default(this, new BffRouter(BffConstant.Module.Stream, BffConstant.Cmd.Auth, null, null, 12, null), null, null, null, 14, null);
        r7.k kVar = (r7.k) r7.k.M().setBody(bVar.n()).setHead(fVarCreateHeader$default).k();
        String strB0 = fVarCreateHeader$default.b0();
        k.e(strB0, "getMsgId(...)");
        send(strB0, kVar.m());
    }

    public final String sendToolResponse(BffRouter router, ToolResponse toolResponse, String traceId) {
        k.f(router, "router");
        k.f(toolResponse, "toolResponse");
        LogUtilKt.getLogger().i(TAG, "sendToolResponse:" + ExtKt.toJson(toolResponse.getResponse()));
        r7.f fVarCreateHeader$default = createHeader$default(this, new BffRouter(router.getBizModule(), router.getBizCommand(), null, null, 12, null), null, null, traceId, 6, null);
        r7.k kVar = (r7.k) r7.k.M().setBody(((C1918a) C1918a.O().setRequestId(toolResponse.getCallId()).setBody(ExtKt.toJson(toolResponse.getResponse())).k()).n()).setHead(fVarCreateHeader$default).k();
        d.D(TAG, "sendToolResponse_id:" + fVarCreateHeader$default.b0());
        byte[] bArrM = kVar.m();
        if (isOpen() && this.isAuthSuccess) {
            LogUtilKt.getLogger().i(TAG, "sendToolResponse:" + ExtKt.toJson(kVar));
            String strB0 = fVarCreateHeader$default.b0();
            k.e(strB0, "getMsgId(...)");
            send(strB0, bArrM);
            refreshIdleTimer();
        } else {
            LogUtilKt.getLogger().i(TAG, "Connection not ready, queuing tool response");
            List<PendingTask> list = this.pendingQueue;
            String strB02 = fVarCreateHeader$default.b0();
            k.e(strB02, "getMsgId(...)");
            String strB03 = fVarCreateHeader$default.b0();
            k.e(strB03, "getMsgId(...)");
            list.add(new PendingTask(strB02, bArrM, new CacheBean(strB03, null, new WeakReference(null))));
            this.isCloseSelf = false;
            connect();
        }
        String strB04 = fVarCreateHeader$default.b0();
        k.e(strB04, "getMsgId(...)");
        return strB04;
    }

    public final void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public final void setAutoReconnect(boolean z10) {
        this.isAutoReconnect = z10;
    }

    public final void setCloseSelf(boolean z10) {
        this.isCloseSelf = z10;
    }

    public final void setDeviceId(String str) {
        k.f(str, "<set-?>");
        this.deviceId = str;
    }

    public final void updateAuth(AuthInfo authInfo) {
        k.f(authInfo, "authInfo");
        this.authInfo = authInfo;
        if (!isOpen() || this.isAuthSuccess) {
            return;
        }
        sendAuth(authInfo);
    }

    @Override // com.stepos.agentframework.adapter.bff.IOriDataCallback
    public void onDataReceived(ByteBuffer _data) {
        byte[] bArrArray;
        try {
            ILogger logger = LogUtilKt.getLogger();
            Integer numValueOf = (_data == null || (bArrArray = _data.array()) == null) ? null : Integer.valueOf(bArrArray.length);
            logger.i(TAG, "onDataReceived byte:" + numValueOf + "," + Thread.currentThread().getName());
            r7.k kVarN = r7.k.N(_data);
            r7.f fVarK = kVarN.K();
            if (fVarK.S("resume_token")) {
                String strY = fVarK.Y("resume_token", "");
                LogUtilKt.getLogger().i(TAG, "resume_token:" + strY);
                if (strY != null) {
                    this.resumeToken = strY;
                }
            }
            LogUtilKt.getLogger().d(TAG, "receive_head:" + fVarK.Z() + "," + fVarK.T() + "," + fVarK.b0() + " ~~~");
            String strZ = fVarK.Z();
            if (strZ == null || strZ.length() == 0) {
                LogUtilKt.getLogger().d(TAG, "receive_body:" + Base64.encodeToString(kVarN.J().o(), 2));
                LogUtilKt.getLogger().d(TAG, "receive_data:" + ExtKt.toJson(kVarN));
            }
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            String strB0 = fVarK.b0();
            k.e(strB0, "getMsgId(...)");
            notifyCallback(strB0, new R3.k(ref$BooleanRef, fVarK, kVarN, 7));
            if (ref$BooleanRef.f4916a) {
                LogUtilKt.getLogger().i(TAG, "isHandle by OriginalDataReceived:" + fVarK.b0());
                return;
            }
            BffCommandDispatcher bffCommandDispatcher = this.commandDispatcher;
            r7.f fVarK2 = kVarN.K();
            k.e(fVarK2, "getHead(...)");
            ByteString byteStringJ = kVarN.J();
            k.e(byteStringJ, "getBody(...)");
            bffCommandDispatcher.dispatch(fVarK2, byteStringJ, this.callbackCache.get(kVarN.K().b0()));
        } catch (Exception e) {
            LogUtilKt.getLogger().e(TAG, "onDataReceived error: " + e);
        }
    }

    private final void notifyCallback(String id, S7.k action) {
        CacheBean cacheBean = this.callbackCache.get(id);
        if (cacheBean != null) {
            action.invoke(cacheBean);
        }
        removeNull();
    }
}
