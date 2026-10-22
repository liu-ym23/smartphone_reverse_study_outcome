package com.stepos.agentframework.adapter.bff;

import Ua.AbstractC1067l0;
import Ua.C1060i;
import Ua.C1071n0;
import Ua.C1073o0;
import Ua.Y;
import Z8.C1172u;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.stepos.agentframework.adapter.netcore.ToolResponse;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.RequiredAction;
import com.stepos.core.error.AIEngineError;
import com.zyql.protobuf.common.Content;
import com.zyql.protobuf.common.LogLevel;
import com.zyql.protobuf.connection.AuthBindReq;
import com.zyql.protobuf.connection.Head;
import com.zyql.protobuf.connection.HeartbeatReq;
import com.zyql.protobuf.connection.StreamMsg;
import com.zyql.protobuf.internetplatform.CallBackReq;
import com.zyql.protobuf.omni.Audio;
import com.zyql.protobuf.omni.ChatRequest;
import com.zyql.protobuf.runtime.ChatRequest;
import com.zyql.protobuf.runtime.ExecutionOptions;
import com.zyql.protobuf.runtime.SendInputRequest;
import com.zyql.protobuf.runtime.StartAgentRequest;
import com.zyql.protobuf.skull.Message;
import com.zyql.protobuf.skull.Resource;
import com.zyql.protobuf.skull.ToolCall;
import com.zyql.protobuf.task.engine.InvokeReq;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f4.C4057a;
import f9.C4063a;
import h8.C4148a;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.java_websocket.enums.ReadyState;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ©\u00012\u00020\u0001:\u0001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\bJ#\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010 \u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001bH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\bJ\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\bJ\u0019\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u00103J%\u00105\u001a\u0002042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\bJ\u0010\u0010;\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020*¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020*¢\u0006\u0004\b@\u0010?J\u0015\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DJ%\u0010G\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00100\u001a\u00020/2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ'\u0010K\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010J\u001a\u00020I2\b\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0006H\u0016¢\u0006\u0004\bM\u0010\bJ\u0019\u0010O\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\bO\u0010PJ\u0019\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0004\bS\u0010TJ!\u0010X\u001a\u00020\u00062\u0006\u0010V\u001a\u00020U2\b\u0010W\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0006H\u0000¢\u0006\u0004\bZ\u0010\bJ\u001f\u0010[\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b[\u0010\\J\u0015\u0010^\u001a\u00020\u00062\u0006\u0010]\u001a\u00020*¢\u0006\u0004\b^\u0010_J)\u0010a\u001a\u00020\u00062\u0006\u0010V\u001a\u00020U2\b\u0010W\u001a\u0004\u0018\u00010\f2\u0006\u0010`\u001a\u00020*H\u0016¢\u0006\u0004\ba\u0010bJ\u001f\u0010e\u001a\u00020\u00062\u000e\u0010M\u001a\n\u0018\u00010cj\u0004\u0018\u0001`dH\u0016¢\u0006\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010r\u001a\u00020m8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010DR#\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c0w8\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R!\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010}0|8\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R$\u0010\u0083\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00010|8\u0006¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010\u007f\u001a\u0006\b\u0084\u0001\u0010\u0081\u0001R(\u0010\u0085\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0005\b\u0089\u0001\u0010PR'\u0010\u008a\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0005\b\u008a\u0001\u0010?\"\u0005\b\u008c\u0001\u0010_R\u0018\u0010\u008d\u0001\u001a\u00020U8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010-R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R'\u0010\u0091\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0091\u0001\u0010\u008b\u0001\u001a\u0005\b\u0091\u0001\u0010?\"\u0005\b\u0092\u0001\u0010_R\u0019\u0010\u0093\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u008b\u0001R\u0019\u0010\u0094\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u008b\u0001R\u0019\u0010\u0095\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008b\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0090\u0001RD\u0010\u009e\u0001\u001a/\u0012\u000f\u0012\r \u009c\u0001*\u0005\u0018\u00010\u009b\u00010\u009b\u0001 \u009c\u0001*\u0016\u0012\u000f\u0012\r \u009c\u0001*\u0005\u0018\u00010\u009b\u00010\u009b\u0001\u0018\u00010\u009d\u00010\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R \u0010¤\u0001\u001a\u00030£\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u0086\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffClient;", "Lcom/stepos/agentframework/adapter/bff/q;", "Lcom/stepos/agentframework/adapter/bff/s;", "option", "<init>", "(Lcom/stepos/agentframework/adapter/bff/s;)V", "LY8/t;", "y", "()V", "U", "v", "c0", "", "id", "", "byteArray", "Y", "(Ljava/lang/String;[B)V", "Lcom/stepos/agentframework/adapter/bff/k;", "router", "", C3081a.FOCUS_MAP_NAME, DidiCardProvider.KEY_TRACE_ID, "Lcom/zyql/protobuf/connection/Head;", "z", "(Lcom/stepos/agentframework/adapter/bff/k;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/protobuf/connection/Head;", "X", "Lkotlin/Function1;", "Lcom/stepos/agentframework/adapter/bff/l;", "action", "Q", "(Lp9/l;)V", "P", "(Ljava/lang/String;Lp9/l;)V", "Lcom/zyql/protobuf/skull/ToolCall;", "toolCall", "Lcom/stepos/common/RequiredAction$SubmitToolOutputs$ToolCall;", "e0", "(Lcom/zyql/protobuf/skull/ToolCall;)Lcom/stepos/common/RequiredAction$SubmitToolOutputs$ToolCall;", ExifInterface.LONGITUDE_WEST, "x", "aiCommand", "", "N", "(Ljava/lang/String;)Z", "I", "(Ljava/lang/String;)Ljava/lang/String;", "LK6/n;", "requestInfo", "Lcom/zyql/protobuf/runtime/ChatRequest;", "C", "(LK6/n;Ljava/lang/String;)Lcom/zyql/protobuf/runtime/ChatRequest;", "Lcom/google/protobuf/Struct;", "H", "(Ljava/util/Map;)Lcom/google/protobuf/Struct;", "Lcom/zyql/protobuf/runtime/ExecutionOptions;", "F", "()Lcom/zyql/protobuf/runtime/ExecutionOptions;", "L", ExifInterface.GPS_DIRECTION_TRUE, "(Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "M", "()Z", "O", "Lcom/stepos/agentframework/adapter/bff/a;", "authInfo", "b0", "(Lcom/stepos/agentframework/adapter/bff/a;)V", "Lcom/stepos/agentframework/adapter/bff/p;", "callback", "u", "(Lcom/stepos/agentframework/adapter/bff/k;LK6/n;Lcom/stepos/agentframework/adapter/bff/p;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/E;", "toolResponse", "d0", "(Lcom/stepos/agentframework/adapter/bff/k;Lcom/stepos/agentframework/adapter/netcore/E;Ljava/lang/String;)Ljava/lang/String;", "e", "data", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "_data", Const.INTENT_KEY_PKGNAME, "(Ljava/nio/ByteBuffer;)V", "", "code", "reason", "q", "(ILjava/lang/String;)V", "r", "t", "(Ljava/lang/String;Lcom/zyql/protobuf/skull/ToolCall;)V", "isAvailable", ExifInterface.LATITUDE_SOUTH, "(Z)V", "remote", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;Z)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "c", "(Ljava/lang/Exception;)V", "LUa/l0;", "wsDispatcher", "LUa/l0;", "Leb/a;", "reconnectMutex", "Leb/a;", "Lcom/stepos/agentframework/adapter/bff/u;", "client$delegate", "LY8/h;", "D", "()Lcom/stepos/agentframework/adapter/bff/u;", "client", "Lcom/stepos/agentframework/adapter/bff/a;", "B", "()Lcom/stepos/agentframework/adapter/bff/a;", "setAuthInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackCache", "Ljava/util/concurrent/ConcurrentHashMap;", "getCallbackCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/n;", "authCallback", "Ljava/lang/ref/WeakReference;", "getAuthCallback", "()Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/o;", "connectCallback", ExifInterface.LONGITUDE_EAST, "deviceId", "Ljava/lang/String;", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "isAutoReconnect", "Z", "setAutoReconnect", "reconnectCount", "Lkotlinx/coroutines/g;", "reconnectJob", "Lkotlinx/coroutines/g;", "isCloseSelf", "setCloseSelf", "isAuthSuccess", "isLazyConnect", "isIdleClose", "", "idleTimeout", "J", "idleJob", "", "Lcom/stepos/agentframework/adapter/bff/t;", "kotlin.jvm.PlatformType", "", "pendingQueue", "Ljava/util/List;", "Lcom/stepos/agentframework/adapter/bff/i;", "commandDispatcher", "Lcom/stepos/agentframework/adapter/bff/i;", "Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "heartbeatManager", "Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "G", "()Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "resumeToken", "Companion", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BffClient implements q {
    private static final long BASE_BACKOFF_TIMEOUT = 2000;
    private static final AbstractC1067l0 HeartPool;
    private static final long MAX_BACKOFF_TIMEOUT = 60000;
    private static final int MAX_RECONNECT_COUNT = 5;
    public static final String TAG = " [BffClient] ";
    private final WeakReference<n> authCallback;
    private AuthInfo authInfo;
    private final ConcurrentHashMap<String, CacheBean> callbackCache;

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private final Y8.h client;
    private final i commandDispatcher;
    private final WeakReference<o> connectCallback;
    private String deviceId;
    private final BffHeartbeatManager heartbeatManager;
    private kotlinx.coroutines.g idleJob;
    private long idleTimeout;
    private boolean isAuthSuccess;
    private boolean isAutoReconnect;
    private boolean isCloseSelf;
    private boolean isIdleClose;
    private boolean isLazyConnect;
    private final List<PendingTask> pendingQueue;
    private int reconnectCount;
    private kotlinx.coroutines.g reconnectJob;
    private final InterfaceC4021a reconnectMutex;
    private String resumeToken;
    private final AbstractC1067l0 wsDispatcher;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        HeartPool = C1071n0.c(executorServiceNewSingleThreadExecutor);
    }

    public BffClient(final Option option) {
        kotlin.jvm.internal.p.i(option, "option");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.wsDispatcher = C1071n0.c(executorServiceNewSingleThreadExecutor);
        this.reconnectMutex = eb.f.b(false, 1, null);
        this.client = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.bff.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return BffClient.w(option, this);
            }
        });
        this.authInfo = option.getAuthInfo();
        this.callbackCache = new ConcurrentHashMap<>();
        this.authCallback = new WeakReference<>(option.getAuthCallback());
        this.connectCallback = new WeakReference<>(option.getConnectCallback());
        this.deviceId = option.getDeviceId();
        this.isAutoReconnect = option.getIsAutoReconnect();
        this.isLazyConnect = option.getIsLazyConnect();
        this.isIdleClose = option.getIsIdleClose();
        this.idleTimeout = option.getIdleTimeout();
        this.pendingQueue = Collections.synchronizedList(new ArrayList());
        this.commandDispatcher = new i(this);
        this.heartbeatManager = new BffHeartbeatManager(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.bff.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return BffClient.J(this.f22343a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.bff.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return BffClient.K(this.f22344a);
            }
        });
        this.resumeToken = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Head A(BffClient bffClient, BffRouter bffRouter, Map map, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = new HashMap();
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return bffClient.z(bffRouter, map, str, str2);
    }

    public static final Y8.t J(BffClient bffClient) {
        bffClient.c0();
        return Y8.t.f7040a;
    }

    public static final Y8.t K(BffClient bffClient) {
        bffClient.X();
        return Y8.t.f7040a;
    }

    public static final Y8.t R(Ref$BooleanRef ref$BooleanRef, Head head, StreamMsg streamMsg, CacheBean it) {
        boolean zB;
        kotlin.jvm.internal.p.i(it, "it");
        p pVar = it.a().get();
        if (pVar != null) {
            String msgId = head.getMsgId();
            kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
            zB = pVar.b(msgId, streamMsg);
        } else {
            zB = false;
        }
        ref$BooleanRef.f34815a = zB;
        return Y8.t.f7040a;
    }

    public static final Y8.t Z(CacheBean it) {
        kotlin.jvm.internal.p.i(it, "it");
        p pVar = it.a().get();
        if (pVar != null) {
            pVar.onError(it.getSendId(), 100001, "connect break");
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(Exception exc, CacheBean it) {
        kotlin.jvm.internal.p.i(it, "it");
        p pVar = it.a().get();
        if (pVar != null) {
            pVar.onError(it.getSendId(), AIEngineError.INVALID_ARGUMENT, exc.toString());
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t s(RequiredAction requiredAction, String str, CacheBean it) {
        kotlin.jvm.internal.p.i(it, "it");
        C0918n chatRequestInfo = it.getChatRequestInfo();
        kotlin.jvm.internal.p.f(chatRequestInfo);
        C0917m c0917m = new C0917m(null, "assistant", chatRequestInfo.getConversationId(), "text", 0, false, null, 0, null, 0L, 0, 0, false, chatRequestInfo.getAgentId(), null, null, 1, false, null, 0, null, 0, null, 2, null, null, null, null, null, "111111111", null, null, null, requiredAction, chatRequestInfo.getChatId(), null, null, null, null, null, null, null, null, null, null, -679682063, 8169, null);
        p pVar = it.a().get();
        if (pVar != null) {
            pVar.a(str, c0917m);
        }
        return Y8.t.f7040a;
    }

    public static final u w(Option option, BffClient bffClient) {
        return new u(new URI(option.getUrl()), bffClient);
    }

    /* renamed from: B, reason: from getter */
    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public final ChatRequest C(C0918n requestInfo, String aiCommand) {
        String strI = I(aiCommand);
        r.a().c(TAG, "getChatRequest requestInfo: " + requestInfo + ", aiCommand: " + aiCommand + ", agentId: " + strI);
        Content.Builder role = Content.newBuilder().setRole("user");
        List<AbstractC0913i> listJ = requestInfo.j();
        Content contentBuild = role.addAllParts(listJ != null ? m.e(listJ, requestInfo.getThinking()) : null).build();
        requestInfo.J(C4057a.INSTANCE.a());
        String conversationId = requestInfo.getConversationId();
        ChatRequest chatRequestBuild = (conversationId == null || conversationId.length() == 0) ? ChatRequest.newBuilder().setId(requestInfo.get_id()).setStartAgentRequest(StartAgentRequest.newBuilder().setAgentId(strI).addAllMessages(C1172u.e(contentBuild)).setMetadata(H(requestInfo.o())).setOptions(F())).build() : ChatRequest.newBuilder().setId(requestInfo.get_id()).setSendInputRequest(SendInputRequest.newBuilder().setSessionId(requestInfo.getConversationId()).addAllMessages(C1172u.e(contentBuild)).setMetadata(H(requestInfo.o()))).build();
        r.a().c(TAG, "getChatRequest request: " + com.stepos.agentframework.adapter.netcore.j.b(chatRequestBuild));
        kotlin.jvm.internal.p.f(chatRequestBuild);
        return chatRequestBuild;
    }

    public final u D() {
        return (u) this.client.getValue();
    }

    public final WeakReference<o> E() {
        return this.connectCallback;
    }

    public final ExecutionOptions F() {
        ExecutionOptions executionOptionsBuild = ExecutionOptions.newBuilder().setIncludeFunctionCallOutput(false).setSendCompleteMessage(false).setIncludeSubAgentOutput(false).setObserverMode(false).setLogLevel(LogLevel.LOG_LEVEL_INFO).build();
        kotlin.jvm.internal.p.h(executionOptionsBuild, "build(...)");
        return executionOptionsBuild;
    }

    /* renamed from: G, reason: from getter */
    public final BffHeartbeatManager getHeartbeatManager() {
        return this.heartbeatManager;
    }

    public final Struct H(Map<String, String> map) {
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderNewBuilder.putFields(entry.getKey(), Value.newBuilder().setStringValue(entry.getValue()).build());
            }
        }
        Struct structBuild = builderNewBuilder.build();
        kotlin.jvm.internal.p.h(structBuild, "build(...)");
        return structBuild;
    }

    public final String I(String aiCommand) {
        return kotlin.jvm.internal.p.d(aiCommand, "VideoNewEdit") ? "2" : kotlin.jvm.internal.p.d(aiCommand, "NewChat") ? "1" : "";
    }

    public final void L() {
        r.a().c(TAG, "init: isLazyConnect=" + this.isLazyConnect);
        if (this.isLazyConnect) {
            r.a().c(TAG, "lazy connnect. will connect later");
        } else {
            y();
        }
    }

    public final boolean M() {
        return D().O();
    }

    public final boolean N(String aiCommand) {
        return kotlin.jvm.internal.p.d("VideoNewEdit", aiCommand) || kotlin.jvm.internal.p.d("NewChat", aiCommand);
    }

    public final boolean O() {
        return D().Q();
    }

    public final void P(String id, InterfaceC5074l<? super CacheBean, Y8.t> action) {
        CacheBean cacheBean = this.callbackCache.get(id);
        if (cacheBean != null) {
            action.invoke(cacheBean);
        }
        X();
    }

    public final void Q(InterfaceC5074l<? super CacheBean, Y8.t> action) {
        Collection<CacheBean> collectionValues = this.callbackCache.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (CacheBean cacheBean : collectionValues) {
            kotlin.jvm.internal.p.f(cacheBean);
            action.invoke(cacheBean);
        }
        X();
    }

    public final void S(boolean isAvailable) {
        r.a().c(TAG, "onNetworkChanged: isAvailable = " + isAvailable);
        if (!isAvailable) {
            kotlinx.coroutines.g gVar = this.reconnectJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            r.a().c(TAG, "Netowrk unavailable, temple stop reconnect.");
            return;
        }
        if (this.isCloseSelf || O()) {
            return;
        }
        r.a().c(TAG, "Network recover. start to reconnect.");
        this.reconnectCount = 0;
        U();
    }

    public final Object T(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objV = V(interfaceC4014c);
        return objV == C4063a.g() ? objV : Y8.t.f7040a;
    }

    public final void U() {
        if (this.isCloseSelf || !this.isAutoReconnect) {
            return;
        }
        kotlinx.coroutines.g gVar = this.reconnectJob;
        if (gVar != null) {
            if (gVar == null) {
                return;
            }
            kotlin.jvm.internal.p.f(gVar);
            if (gVar.b()) {
                return;
            }
        }
        kotlinx.coroutines.g gVar2 = this.reconnectJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.reconnectJob = C1060i.d(C1073o0.f6391a, Y.b(), null, new BffClient$reconnectAuto$1(this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V(e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1 r0 = (com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1 r0 = new com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r10 = r0.L$0
            eb.a r10 = (eb.InterfaceC4021a) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L32
            goto L7e
        L32:
            r11 = move-exception
            goto L8a
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            eb.a r5 = (eb.InterfaceC4021a) r5
            kotlin.C4849c.b(r11)
            r11 = r5
            goto L5a
        L47:
            kotlin.C4849c.b(r11)
            eb.a r11 = r10.reconnectMutex
            r0.L$0 = r11
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r11.m(r6, r0)
            if (r2 != r1) goto L59
            goto L7a
        L59:
            r2 = r3
        L5a:
            com.stepos.agentframework.adapter.netcore.p r5 = com.stepos.agentframework.adapter.bff.r.a()     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = " [BffClient] "
            java.lang.String r8 = "reconnectSafe"
            r5.c(r7, r8)     // Catch: java.lang.Throwable -> L86
            Ua.l0 r5 = r10.wsDispatcher     // Catch: java.lang.Throwable -> L86
            com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$2$1 r7 = new com.stepos.agentframework.adapter.bff.BffClient$reconnectSafe$2$1     // Catch: java.lang.Throwable -> L86
            r7.<init>(r10, r6)     // Catch: java.lang.Throwable -> L86
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L86
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L86
            r0.I$1 = r3     // Catch: java.lang.Throwable -> L86
            r0.label = r4     // Catch: java.lang.Throwable -> L86
            java.lang.Object r10 = Ua.C1056g.j(r5, r7, r0)     // Catch: java.lang.Throwable -> L86
            if (r10 != r1) goto L7b
        L7a:
            return r1
        L7b:
            r9 = r11
            r11 = r10
            r10 = r9
        L7e:
            Y8.t r11 = (Y8.t) r11     // Catch: java.lang.Throwable -> L32
            r10.l(r6)
            Y8.t r10 = Y8.t.f7040a
            return r10
        L86:
            r10 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
        L8a:
            r10.l(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffClient.V(e9.c):java.lang.Object");
    }

    public final void W() {
        r.a().c(TAG, "refreshIdleTimer isIdleClose: " + this.isIdleClose);
        if (this.isIdleClose) {
            kotlinx.coroutines.g gVar = this.idleJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.idleJob = C1060i.d(C1073o0.f6391a, HeartPool, null, new BffClient$refreshIdleTimer$1(this, null), 2, null);
        }
    }

    public final void X() {
        int size = this.callbackCache.size();
        androidx.collection.b bVar = new androidx.collection.b(0, 1, null);
        for (Map.Entry<String, CacheBean> entry : this.callbackCache.entrySet()) {
            if (entry.getValue().a().get() == null) {
                bVar.add(entry.getKey());
            }
        }
        Iterator<E> it = bVar.iterator();
        while (it.hasNext()) {
            this.callbackCache.remove((String) it.next());
        }
        r.a().c(TAG, "removeNull: " + size + " -> " + this.callbackCache.size());
    }

    public final void Y(String id, byte[] byteArray) {
        try {
            r.a().c(TAG, "send_id:" + id);
            if (!D().O()) {
                D().c0(byteArray);
            } else {
                r.a().c(TAG, "send client is closed");
                Q(new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.bff.e
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return BffClient.Z((CacheBean) obj);
                    }
                });
            }
        } catch (Exception e10) {
            r.a().b(TAG, "send:" + e10);
            P(id, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.bff.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return BffClient.a0(e10, (CacheBean) obj);
                }
            });
        }
    }

    @Override // com.stepos.agentframework.adapter.bff.o
    public void a(int code, String reason, boolean remote) {
        o oVar;
        r.a().c(TAG, "onClose: " + code + " " + reason + " " + remote);
        if (this.isCloseSelf) {
            this.resumeToken = "";
        }
        this.isAuthSuccess = false;
        WeakReference<o> weakReference = this.connectCallback;
        if (weakReference != null && (oVar = weakReference.get()) != null) {
            oVar.a(code, reason, remote);
        }
        v();
    }

    @Override // com.stepos.agentframework.adapter.bff.q
    public void b(ByteBuffer _data) {
        byte[] bArrArray;
        try {
            com.stepos.agentframework.adapter.netcore.p pVarA = r.a();
            Integer numValueOf = (_data == null || (bArrArray = _data.array()) == null) ? null : Integer.valueOf(bArrArray.length);
            pVarA.c(TAG, "onDataReceived byte:" + numValueOf + Const.STR_MART_COMMA + Thread.currentThread().getName());
            final StreamMsg from = StreamMsg.parseFrom(_data);
            final Head head = from.getHead();
            if (head.containsMeta("resume_token")) {
                String metaOrDefault = head.getMetaOrDefault("resume_token", "");
                r.a().c(TAG, "resume_token:" + metaOrDefault);
                if (metaOrDefault != null) {
                    this.resumeToken = metaOrDefault;
                }
            }
            r.a().a(TAG, "receive_head:" + head.getModule() + Const.STR_MART_COMMA + head.getCommand() + Const.STR_MART_COMMA + head.getMsgId() + " ~~~");
            String module = head.getModule();
            if (module == null || module.length() == 0) {
                r.a().a(TAG, "receive_body:" + Base64.encodeToString(from.getBody().toByteArray(), 2));
                r.a().a(TAG, "receive_data:" + com.stepos.agentframework.adapter.netcore.j.b(from));
            }
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            String msgId = head.getMsgId();
            kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
            P(msgId, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.bff.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return BffClient.R(ref$BooleanRef, head, from, (CacheBean) obj);
                }
            });
            if (ref$BooleanRef.f34815a) {
                r.a().c(TAG, "isHandle by OriginalDataReceived:" + head.getMsgId());
                return;
            }
            i iVar = this.commandDispatcher;
            Head head2 = from.getHead();
            kotlin.jvm.internal.p.h(head2, "getHead(...)");
            ByteString body = from.getBody();
            kotlin.jvm.internal.p.h(body, "getBody(...)");
            iVar.a(head2, body, this.callbackCache.get(from.getHead().getMsgId()));
        } catch (Exception e10) {
            r.a().b(TAG, "onDataReceived error: " + e10);
        }
    }

    public final void b0(AuthInfo authInfo) {
        kotlin.jvm.internal.p.i(authInfo, "authInfo");
        r.a().c(TAG, "sendAuth:" + authInfo);
        AuthBindReq.Builder builderPutAllReserved = AuthBindReq.newBuilder().setToken(authInfo.getToken()).setUid(authInfo.getUid()).setTokenType(authInfo.getToken_type()).setPlatform(authInfo.getPlatform()).setProduct(authInfo.getProduct()).setDevice(authInfo.getDevice()).setAppVersion(authInfo.getApp_version()).setChannel(authInfo.getChannel()).putAllReserved(authInfo.f());
        String str = this.resumeToken;
        if (str == null) {
            str = "";
        }
        AuthBindReq authBindReqBuild = builderPutAllReserved.putReserved("resume_token", str).build();
        Head headA = A(this, new BffRouter("Stream", "Auth", null, null, 12, null), null, null, null, 14, null);
        StreamMsg streamMsgBuild = StreamMsg.newBuilder().setBody(authBindReqBuild.toByteString()).setHead(headA).build();
        String msgId = headA.getMsgId();
        kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
        byte[] byteArray = streamMsgBuild.toByteArray();
        kotlin.jvm.internal.p.h(byteArray, "toByteArray(...)");
        Y(msgId, byteArray);
    }

    @Override // com.stepos.agentframework.adapter.bff.o
    public void c(Exception e10) {
        o oVar;
        r.a().c(TAG, "onError:" + e10);
        this.isAuthSuccess = false;
        if (this.isCloseSelf) {
            List<PendingTask> pendingQueue = this.pendingQueue;
            kotlin.jvm.internal.p.h(pendingQueue, "pendingQueue");
            synchronized (pendingQueue) {
                try {
                    List<PendingTask> pendingQueue2 = this.pendingQueue;
                    kotlin.jvm.internal.p.h(pendingQueue2, "pendingQueue");
                    for (PendingTask pendingTask : pendingQueue2) {
                        p pVar = pendingTask.getBean().a().get();
                        if (pVar != null) {
                            pVar.onError(pendingTask.getId(), 100001, "Connection failed");
                        }
                    }
                    this.pendingQueue.clear();
                    Y8.t tVar = Y8.t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        WeakReference<o> weakReference = this.connectCallback;
        if (weakReference != null && (oVar = weakReference.get()) != null) {
            oVar.c(e10);
        }
        v();
    }

    public final void c0() {
        if (!O()) {
            r.a().c(TAG, "send heart break client is closed");
            return;
        }
        r.a().c(TAG, "sendHeartReal");
        Head headA = A(this, new BffRouter("Stream", "Heartbeat", null, null, 12, null), null, null, null, 14, null);
        StreamMsg streamMsgBuild = StreamMsg.newBuilder().setBody(HeartbeatReq.newBuilder().build().toByteString()).setHead(headA).build();
        try {
            String msgId = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
            byte[] byteArray = streamMsgBuild.toByteArray();
            kotlin.jvm.internal.p.h(byteArray, "toByteArray(...)");
            Y(msgId, byteArray);
            this.heartbeatManager.d();
        } catch (Exception e10) {
            r.a().b(TAG, "Heartbeat send failed: " + e10);
        }
    }

    @Override // com.stepos.agentframework.adapter.bff.q
    public void d(String data) {
        r.a().c(TAG, "onDataReceived str:" + data);
    }

    public final String d0(BffRouter router, ToolResponse toolResponse, String traceId) {
        kotlin.jvm.internal.p.i(router, "router");
        kotlin.jvm.internal.p.i(toolResponse, "toolResponse");
        r.a().c(TAG, "sendToolResponse:" + com.stepos.agentframework.adapter.netcore.j.b(toolResponse.getResponse()));
        Head headA = A(this, new BffRouter(router.getBizModule(), router.getBizCommand(), null, null, 12, null), null, null, traceId, 6, null);
        StreamMsg streamMsgBuild = StreamMsg.newBuilder().setBody(CallBackReq.newBuilder().setRequestId(toolResponse.getCallId()).setBody(com.stepos.agentframework.adapter.netcore.j.b(toolResponse.getResponse())).build().toByteString()).setHead(headA).build();
        C4148a.k(TAG, "sendToolResponse_id:" + headA.getMsgId(), false, 4, null);
        byte[] byteArray = streamMsgBuild.toByteArray();
        if (O() && this.isAuthSuccess) {
            r.a().c(TAG, "sendToolResponse:" + com.stepos.agentframework.adapter.netcore.j.b(streamMsgBuild));
            String msgId = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
            kotlin.jvm.internal.p.f(byteArray);
            Y(msgId, byteArray);
            W();
        } else {
            r.a().c(TAG, "Connection not ready, queuing tool response");
            List<PendingTask> list = this.pendingQueue;
            String msgId2 = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId2, "getMsgId(...)");
            kotlin.jvm.internal.p.f(byteArray);
            String msgId3 = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId3, "getMsgId(...)");
            list.add(new PendingTask(msgId2, byteArray, new CacheBean(msgId3, null, new WeakReference(null))));
            this.isCloseSelf = false;
            y();
        }
        String msgId4 = headA.getMsgId();
        kotlin.jvm.internal.p.h(msgId4, "getMsgId(...)");
        return msgId4;
    }

    @Override // com.stepos.agentframework.adapter.bff.o
    public void e() {
        o oVar;
        r.a().c(TAG, "onConnect:" + O() + Const.STR_MART_COMMA + M() + " " + Thread.currentThread().getName());
        this.reconnectCount = 0;
        kotlinx.coroutines.g gVar = this.reconnectJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        WeakReference<o> weakReference = this.connectCallback;
        if (weakReference != null && (oVar = weakReference.get()) != null) {
            oVar.e();
        }
        AuthInfo authInfo = this.authInfo;
        if (authInfo != null) {
            b0(authInfo);
        }
        W();
    }

    public final RequiredAction.SubmitToolOutputs.ToolCall e0(ToolCall toolCall) {
        String params = toolCall.getParams().getParams();
        kotlin.jvm.internal.p.h(params, "getParams(...)");
        String name = toolCall.getTool().getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        RequiredAction.SubmitToolOutputs.ToolCall.Function function = new RequiredAction.SubmitToolOutputs.ToolCall.Function(params, name, toolCall.getTool().getId());
        String callId = toolCall.getCallId();
        kotlin.jvm.internal.p.h(callId, "getCallId(...)");
        return new RequiredAction.SubmitToolOutputs.ToolCall(function, callId, null, null, 12, null);
    }

    public final void q(int code, String reason) {
        n nVar;
        r.a().c(TAG, "authError: " + code + " " + reason);
        this.isAuthSuccess = false;
        WeakReference<n> weakReference = this.authCallback;
        if (weakReference == null || (nVar = weakReference.get()) == null) {
            return;
        }
        nVar.a(code, reason);
    }

    public final void r() {
        n nVar;
        r.a().c(TAG, "authSuccess");
        this.isAuthSuccess = true;
        WeakReference<n> weakReference = this.authCallback;
        if (weakReference != null && (nVar = weakReference.get()) != null) {
            nVar.b();
        }
        List<PendingTask> pendingQueue = this.pendingQueue;
        kotlin.jvm.internal.p.h(pendingQueue, "pendingQueue");
        synchronized (pendingQueue) {
            try {
                Iterator<PendingTask> it = this.pendingQueue.iterator();
                while (it.hasNext()) {
                    PendingTask next = it.next();
                    r.a().c(TAG, "Sending pending task after auth: " + next.getId());
                    this.callbackCache.put(next.getId(), next.getBean());
                    Y(next.getId(), next.getData());
                    it.remove();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        c0();
    }

    public final void t(final String id, ToolCall toolCall) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(toolCall, "toolCall");
        final RequiredAction requiredAction = new RequiredAction(new RequiredAction.SubmitToolOutputs(C1172u.e(e0(toolCall))), null, 2, null);
        P(id, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.bff.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BffClient.s(requiredAction, id, (CacheBean) obj);
            }
        });
    }

    public final String u(BffRouter router, C0918n requestInfo, p callback) {
        AbstractC0913i abstractC0913i;
        ByteString byteString;
        Object next;
        kotlin.jvm.internal.p.i(router, "router");
        kotlin.jvm.internal.p.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.p.i(callback, "callback");
        r.a().c(TAG, "chat_router:" + com.stepos.agentframework.adapter.netcore.j.b(router));
        Head headA = A(this, new BffRouter(router.getBizModule(), router.getBizCommand(), null, null, 12, null), new HashMap(), null, requestInfo.getTraceId(), 4, null);
        String msgId = headA.getMsgId();
        kotlin.jvm.internal.p.h(msgId, "getMsgId(...)");
        CacheBean cacheBean = new CacheBean(msgId, requestInfo, new WeakReference(callback));
        List<AbstractC0913i> listJ = requestInfo.j();
        if (listJ != null) {
            Iterator<T> it = listJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((AbstractC0913i) next) instanceof AbstractC0913i.Bytes) {
                    break;
                }
            }
            abstractC0913i = (AbstractC0913i) next;
        } else {
            abstractC0913i = null;
        }
        AbstractC0913i.Bytes bytes = abstractC0913i instanceof AbstractC0913i.Bytes ? (AbstractC0913i.Bytes) abstractC0913i : null;
        byte[] content = bytes != null ? bytes.getContent() : null;
        if (content != null) {
            byteString = ByteString.copyFrom(content);
        } else if (N(router.getAiCommand())) {
            String aiCommand = router.getAiCommand();
            kotlin.jvm.internal.p.f(aiCommand);
            byteString = C(requestInfo, aiCommand).toByteString();
        } else {
            Message.Builder builderNewBuilder = Message.newBuilder();
            List<AbstractC0913i> listJ2 = requestInfo.j();
            if (listJ2 != null) {
                kotlin.jvm.internal.p.f(builderNewBuilder);
                List<Resource> listG = m.g(listJ2, builderNewBuilder);
                if (listG != null) {
                    r.a().c(TAG, "resources:" + listG + ". content:" + builderNewBuilder.getContent());
                    builderNewBuilder.addAllResources(listG);
                }
            }
            ChatRequest.Builder message = com.zyql.protobuf.omni.ChatRequest.newBuilder().setMessage(builderNewBuilder.setRole("user").build());
            String conversationId = requestInfo.getConversationId();
            if (conversationId == null) {
                conversationId = "";
            }
            ChatRequest.Builder needTts = message.setChatId(conversationId).setIsMock(false).setNeedTts(false);
            if (requestInfo.getAudio() != null) {
                Audio.Builder builderNewBuilder2 = Audio.newBuilder();
                AbstractC0913i.AudioStream audio = requestInfo.getAudio();
                kotlin.jvm.internal.p.f(audio);
                Audio.Builder data = builderNewBuilder2.setData(ByteString.copyFrom(audio.getData()));
                AbstractC0913i.AudioStream audio2 = requestInfo.getAudio();
                kotlin.jvm.internal.p.f(audio2);
                needTts.setAudio(data.setIsEnd(audio2.getIsEnd())).build();
            }
            if (requestInfo.o() != null) {
                C4148a.k(TAG, "requestInfo.meta:" + requestInfo.o(), false, 4, null);
                Map<String, String> mapO = requestInfo.o();
                kotlin.jvm.internal.p.f(mapO);
                needTts.putAllMeta(mapO);
            }
            byteString = needTts.build().toByteString();
        }
        StreamMsg streamMsgBuild = StreamMsg.newBuilder().setBody(InvokeReq.newBuilder().setMsgId(headA.getMsgId()).setCommand(router.getAiCommand()).setModule(router.getAiModule()).setBody(byteString).build().toByteString()).setHead(headA).build();
        byte[] byteArray = streamMsgBuild.toByteArray();
        if (O() && this.isAuthSuccess) {
            r.a().c(TAG, "sendText:" + com.stepos.agentframework.adapter.netcore.j.b(streamMsgBuild));
            this.callbackCache.put(headA.getMsgId(), cacheBean);
            String msgId2 = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId2, "getMsgId(...)");
            byte[] byteArray2 = streamMsgBuild.toByteArray();
            kotlin.jvm.internal.p.h(byteArray2, "toByteArray(...)");
            Y(msgId2, byteArray2);
            W();
            String msgId3 = headA.getMsgId();
            kotlin.jvm.internal.p.h(msgId3, "getMsgId(...)");
            return msgId3;
        }
        r.a().c(TAG, "Connection not ready, queuing message: " + headA.getMsgId());
        if (!O()) {
            this.isCloseSelf = false;
            this.reconnectCount = 0;
            y();
        }
        List<PendingTask> list = this.pendingQueue;
        String msgId4 = headA.getMsgId();
        kotlin.jvm.internal.p.h(msgId4, "getMsgId(...)");
        kotlin.jvm.internal.p.f(byteArray);
        list.add(new PendingTask(msgId4, byteArray, cacheBean));
        String msgId5 = headA.getMsgId();
        kotlin.jvm.internal.p.h(msgId5, "getMsgId(...)");
        return msgId5;
    }

    public final void v() {
        r.a().c(TAG, "onClose:isAutoReconnect:" + this.isAutoReconnect + ",isCloseSelf:" + this.isCloseSelf);
        if (!this.isAutoReconnect || this.isCloseSelf) {
            return;
        }
        U();
    }

    public final void x() {
        try {
            this.isCloseSelf = true;
            D().I();
            r.a().c(TAG, "Start close for idle.");
        } catch (Exception e10) {
            r.a().b(TAG, "closeForIdle error: " + e10);
        }
    }

    public final void y() {
        r.a().c(TAG, "connect:" + O() + ", " + M() + ", " + D().M());
        try {
            if (D().M() == ReadyState.NOT_YET_CONNECTED) {
                D().K();
            } else {
                D().a0();
            }
        } catch (Exception e10) {
            r.a().b(TAG, "connect error:" + e10.getMessage());
            o oVar = this.connectCallback.get();
            if (oVar != null) {
                oVar.c(e10);
            }
        }
    }

    public final Head z(BffRouter router, Map<String, String> map, String id, String traceId) {
        String strValueOf = String.valueOf(UUID.randomUUID());
        C4148a.d(TAG, "createHeader traceId: " + traceId + ", uuid: " + strValueOf, false, 4, null);
        Head.Builder msgType = Head.newBuilder().setFrameType(0).setMsgType(0);
        if (id == null) {
            id = strValueOf;
        }
        Head.Builder builderPutMeta = msgType.setMsgId(id).setModule(router.getBizModule()).setCommand(router.getBizCommand()).putMeta("DeviceId", this.deviceId);
        if (traceId == null) {
            traceId = strValueOf;
        }
        Head.Builder builderPutMeta2 = builderPutMeta.putMeta("TraceId", traceId);
        String str = this.resumeToken;
        if (str == null) {
            str = "";
        }
        Head headBuild = builderPutMeta2.putMeta("resume_token", str).putAllMeta(map).build();
        kotlin.jvm.internal.p.f(headBuild);
        return headBuild;
    }
}
