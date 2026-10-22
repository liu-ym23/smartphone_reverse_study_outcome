package com.stepos.agentframework.chatcore.agents;

import La.C;
import La.H;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.I;
import Ua.InterfaceC1083u;
import Ua.Y;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.X;
import android.content.Context;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.TaskEventPayload;
import com.stepos.agentframework.adapter.netcore.TaskEventType;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.R0;
import com.stepos.agentframework.chatcore.session.bean.AgentTaskEventType;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import h8.C4148a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.VoteRequest;
import kotlin.text.Regex;
import n4.AbstractC4939a;
import o4.C5000a;
import o4.InterfaceC5002c;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t4.InterfaceC5507a;
import u4.AgentResponse;
import u4.AgentTaskEvent;
import w4.C5732a;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002w[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u000b*\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!2\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010\u0003J\u0017\u0010)\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\"\u00103\u001a\u0004\u0018\u0001022\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b3\u00104JZ\u0010=\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b=\u0010>J'\u0010A\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u0002072\u0006\u00109\u001a\u00020\u0006H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ.\u0010H\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bH\u0010IJ(\u0010J\u001a\u00020C2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bJ\u0010IJ \u0010K\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bK\u00104J(\u0010L\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bL\u0010IJ0\u0010N\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bN\u0010OJ\u0018\u0010R\u001a\u00020C2\u0006\u0010Q\u001a\u00020PH\u0096@¢\u0006\u0004\bR\u0010SJ\u0018\u0010U\u001a\u00020C2\u0006\u0010Q\u001a\u00020TH\u0096@¢\u0006\u0004\bU\u0010VJ\u0018\u0010X\u001a\u00020C2\u0006\u0010Q\u001a\u00020WH\u0096@¢\u0006\u0004\bX\u0010YJ\u0018\u0010[\u001a\u00020C2\u0006\u0010Q\u001a\u00020ZH\u0096@¢\u0006\u0004\b[\u0010\\J.\u0010`\u001a\u00020_2\u0006\u00106\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00060FH\u0096@¢\u0006\u0004\b`\u0010aJ)\u0010c\u001a\u0004\u0018\u00010%2\u0006\u00106\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\bc\u0010dJ\u0018\u0010f\u001a\u00020C2\u0006\u0010Q\u001a\u00020eH\u0096@¢\u0006\u0004\bf\u0010gJ8\u0010m\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020h2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u0010k\u001a\u00020j2\u0006\u0010,\u001a\u00020lH\u0096@¢\u0006\u0004\bm\u0010nJ2\u0010q\u001a\u00020C2\u0006\u0010i\u001a\u00020h2\u0006\u0010o\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\bq\u0010rJ,\u0010t\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\u0010s\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\bt\u0010IJ\u0012\u0010u\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\bu\u0010vJ\u001a\u0010w\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bw\u0010xJ\u0012\u0010y\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\by\u0010vJ\u001a\u0010z\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u0006H\u0096@¢\u0006\u0004\bz\u0010xJ\u0018\u0010}\u001a\u00020|2\u0006\u0010Q\u001a\u00020{H\u0096@¢\u0006\u0004\b}\u0010~J@\u0010\u0083\u0001\u001a\u00020C2\u0006\u00106\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u00062\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00068\u0002X\u0082D¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\r \u008a\u0001*\u0005\u0018\u00010\u0087\u00010\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R+\u0010\u008e\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\"0\u008d\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R%\u0010\u0091\u0001\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0005\u0012\u00030\u0090\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008f\u0001R%\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u0092\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u008f\u0001R%\u0010\u0095\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u0094\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008f\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentBusClient;", "Lcom/stepos/agentframework/chatcore/agents/u;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "", "t0", "(Lcom/stepos/agentframework/chatcore/agents/y;)Ljava/lang/String;", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", "w0", "(Lu4/d;)V", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "u0", "(Lcom/stepos/agentframework/chatcore/intent/e;)V", "q0", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/C;", "v0", "(Lcom/stepos/agentframework/adapter/netcore/C;)Lu4/d;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lcom/stepos/agentframework/chatcore/agents/AgentBusClient$b;", "l0", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lcom/stepos/agentframework/chatcore/agents/AgentBusClient$b;", "LK6/n;", "k0", "(LK6/n;)V", "rawUrl", "", "", "s0", "(Ljava/lang/String;)Ljava/util/Map;", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "close", "r0", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)V", "Lcom/stepos/agentframework/chatcore/agents/u$a;", "listener", "y", "(Lcom/stepos/agentframework/chatcore/agents/u$a;)V", "q", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "Lp4/a;", "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "U", "s", "newTitle", "I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/G;", "request", "f", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_APIKEY, "(LK6/H;Le9/c;)Ljava/lang/Object;", "inquiryId", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "outboundId", "w", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LK6/I;", "l", "(LK6/I;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "filePath", "mime", "B", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "deviceId", "G", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LK6/J;", "LK6/K;", Const.INTENT_KEY_UMID, "(LK6/J;Le9/c;)Ljava/lang/Object;", "requestId", "decision", "reason", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "tag", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "noEscapeGson", "Ljava/util/concurrent/ConcurrentHashMap;", "", "callbackCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/adapter/netcore/B;", "taskListenerMap", "Lcom/stepos/agentframework/adapter/netcore/n;", "inFlightCancelHandles", "Lcom/stepos/agentframework/chatcore/agents/AgentBusClient$a;", "attachmentCache", "LUa/I;", "streamSerial", "LUa/I;", "Leb/a;", "streamMutex", "Leb/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusClient implements u {
    private final String tag = " [AgentBusClient] ";
    private final Gson gson = new Gson();
    private final Gson noEscapeGson = new GsonBuilder().disableHtmlEscaping().create();
    private final ConcurrentHashMap<AgentDispatcher.b, Set<Object>> callbackCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<u.a, B> taskListenerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, com.stepos.agentframework.adapter.netcore.n> inFlightCancelHandles = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AttachmentMeta> attachmentCache = new ConcurrentHashMap<>();
    private final I streamSerial = I.t1(Y.b(), 1, null, 2, null);
    private final InterfaceC4021a streamMutex = eb.f.b(false, 1, null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentBusClient$a;", "", "", "fileId", "", ContentDisposition.Parameters.Size, "devicePath", ContentDisposition.Parameters.FileName, "mimeType", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "J", "e", "()J", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.agents.AgentBusClient$a, reason: from toString */
    public static final /* data */ class AttachmentMeta {
        private final String devicePath;
        private final String fileId;
        private final String filename;
        private final String mimeType;
        private final long size;

        public AttachmentMeta(String fileId, long j10, String devicePath, String filename, String mimeType) {
            kotlin.jvm.internal.p.i(fileId, "fileId");
            kotlin.jvm.internal.p.i(devicePath, "devicePath");
            kotlin.jvm.internal.p.i(filename, "filename");
            kotlin.jvm.internal.p.i(mimeType, "mimeType");
            this.fileId = fileId;
            this.size = j10;
            this.devicePath = devicePath;
            this.filename = filename;
            this.mimeType = mimeType;
        }

        /* renamed from: a, reason: from getter */
        public final String getDevicePath() {
            return this.devicePath;
        }

        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: c, reason: from getter */
        public final String getFilename() {
            return this.filename;
        }

        /* renamed from: d, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: e, reason: from getter */
        public final long getSize() {
            return this.size;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttachmentMeta)) {
                return false;
            }
            AttachmentMeta attachmentMeta = (AttachmentMeta) other;
            return kotlin.jvm.internal.p.d(this.fileId, attachmentMeta.fileId) && this.size == attachmentMeta.size && kotlin.jvm.internal.p.d(this.devicePath, attachmentMeta.devicePath) && kotlin.jvm.internal.p.d(this.filename, attachmentMeta.filename) && kotlin.jvm.internal.p.d(this.mimeType, attachmentMeta.mimeType);
        }

        public int hashCode() {
            return (((((((this.fileId.hashCode() * 31) + Long.hashCode(this.size)) * 31) + this.devicePath.hashCode()) * 31) + this.filename.hashCode()) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "AttachmentMeta(fileId=" + this.fileId + ", size=" + this.size + ", devicePath=" + this.devicePath + ", filename=" + this.filename + ", mimeType=" + this.mimeType + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentBusClient$b;", "", "Lo4/a;", "requester", "Lcom/stepos/agentframework/adapter/netcore/h;", "eventListener", "Lkotlin/Function1;", "Lcom/stepos/agentframework/adapter/netcore/n;", "LY8/t;", "bindHandle", "<init>", "(Lo4/a;Lcom/stepos/agentframework/adapter/netcore/h;Lp9/l;)V", "Lo4/a;", "c", "()Lo4/a;", "Lcom/stepos/agentframework/adapter/netcore/h;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/h;", "Lp9/l;", Const.INTENT_KEY_APIKEY, "()Lp9/l;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final InterfaceC5074l<com.stepos.agentframework.adapter.netcore.n, Y8.t> bindHandle;
        private final com.stepos.agentframework.adapter.netcore.h eventListener;
        private final C5000a requester;

        /* JADX WARN: Multi-variable type inference failed */
        public b(C5000a requester, com.stepos.agentframework.adapter.netcore.h eventListener, InterfaceC5074l<? super com.stepos.agentframework.adapter.netcore.n, Y8.t> bindHandle) {
            kotlin.jvm.internal.p.i(requester, "requester");
            kotlin.jvm.internal.p.i(eventListener, "eventListener");
            kotlin.jvm.internal.p.i(bindHandle, "bindHandle");
            this.requester = requester;
            this.eventListener = eventListener;
            this.bindHandle = bindHandle;
        }

        public final InterfaceC5074l<com.stepos.agentframework.adapter.netcore.n, Y8.t> a() {
            return this.bindHandle;
        }

        /* renamed from: b, reason: from getter */
        public final com.stepos.agentframework.adapter.netcore.h getEventListener() {
            return this.eventListener;
        }

        /* renamed from: c, reason: from getter */
        public final C5000a getRequester() {
            return this.requester;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskEventType.values().length];
            try {
                iArr[TaskEventType.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskEventType.UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskEventType.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskEventType.ANSWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final B h0(final u.a aVar, final AgentBusClient agentBusClient, u.a it) {
        kotlin.jvm.internal.p.i(it, "it");
        B b10 = new B() { // from class: com.stepos.agentframework.chatcore.agents.h
            @Override // com.stepos.agentframework.adapter.netcore.B
            public final void a(TaskEventPayload taskEventPayload) {
                AgentBusClient.i0(aVar, agentBusClient, taskEventPayload);
            }
        };
        ApiManager.INSTANCE.l(ApiType.AGENTBUS, b10);
        return b10;
    }

    public static final void i0(u.a aVar, AgentBusClient agentBusClient, TaskEventPayload payload) {
        kotlin.jvm.internal.p.i(payload, "payload");
        aVar.a(agentBusClient.v0(payload));
    }

    public static final B j0(InterfaceC5074l interfaceC5074l, Object obj) {
        return (B) interfaceC5074l.invoke(obj);
    }

    public static final void m0(AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, AgentBusClient agentBusClient, String str) {
        com.stepos.agentframework.adapter.netcore.n nVar = atomicReference.get();
        if (nVar == null) {
            return;
        }
        agentBusClient.inFlightCancelHandles.remove(str, nVar);
    }

    public static final void n0(AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, boolean z10, InterfaceC5063a<Y8.t> interfaceC5063a) {
        boolean z11 = false;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (z10 && !atomicBoolean2.get()) {
                z11 = true;
            }
            agentBusStreamBridge.l(z11, interfaceC5063a);
        }
    }

    public static /* synthetic */ void o0(AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        n0(atomicBoolean, agentBusStreamBridge, atomicBoolean2, z10, interfaceC5063a);
    }

    public static final Y8.t p0(AtomicReference atomicReference, AgentBusClient agentBusClient, String str, AtomicBoolean atomicBoolean, AtomicReference atomicReference2, com.stepos.agentframework.adapter.netcore.n nVar) {
        atomicReference.set(nVar);
        if (nVar != null) {
            agentBusClient.inFlightCancelHandles.put(str, nVar);
        }
        if (atomicBoolean.get()) {
            if (nVar != null) {
                Object obj = atomicReference2.get();
                kotlin.jvm.internal.p.h(obj, "get(...)");
                nVar.cancel((String) obj);
            }
            m0(atomicReference, agentBusClient, str);
        }
        return Y8.t.f7040a;
    }

    private final String t0(RequestParameter parameter) {
        String sessionId;
        if (parameter.getIsToolResult()) {
            Object extra = parameter.getExtra();
            C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
            sessionId = c0917m != null ? c0917m.getConversationId() : null;
        } else {
            sessionId = parameter.getSessionId();
        }
        String string = sessionId != null ? H.D1(sessionId).toString() : null;
        return string == null ? "" : string;
    }

    public static final Y8.t x0(InterfaceC1083u interfaceC1083u, Context context, FileInfo fileInfo, AgentBusClient agentBusClient, InterfaceC5507a interfaceC5507a, AbstractC4939a status) {
        kotlin.jvm.internal.p.i(status, "status");
        if (status instanceof AbstractC4939a.Progress) {
            Function2.b(new AgentBusClient$uploadFile$2$1(interfaceC5507a, fileInfo, status, null));
        } else if (status instanceof AbstractC4939a.Failed) {
            Function2.b(new AgentBusClient$uploadFile$2$2(status, interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.FALSE);
        } else {
            if (!(status instanceof AbstractC4939a.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            String type = context.getContentResolver().getType(fileInfo.getFileUri());
            if (type == null && (type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(H.t1(fileInfo.getFileName(), ".", null, 2, null))) == null) {
                type = "";
            }
            AbstractC4939a.Success success = (AbstractC4939a.Success) status;
            String fileUrl = success.getFileUrl();
            String str = fileUrl != null ? fileUrl : "";
            fileInfo.setFileUrl(str);
            fileInfo.setMimeType(type);
            fileInfo.setDevicePath(fileInfo.getFilePath());
            if (success.getFileId().length() > 0) {
                fileInfo.setFileId(success.getFileId());
            }
            Long fileSize = success.getFileSize();
            long jLongValue = (fileSize == null && (fileSize = C.y(fileInfo.getFileSize())) == null) ? 0L : fileSize.longValue();
            if (str.length() > 0) {
                agentBusClient.attachmentCache.put(str, new AttachmentMeta(fileInfo.getFileId(), jLongValue, fileInfo.getDevicePath(), fileInfo.getFileName(), fileInfo.getMimeType()));
            }
            C4148a.k(agentBusClient.tag, "upload success url:" + str + " mime:" + type + " size:" + jLongValue, false, 4, null);
            Function2.b(new AgentBusClient$uploadFile$2$3(interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.TRUE);
        }
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object B(Context context, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ApiManager.INSTANCE.t(ApiType.AGENTBUS, str, str2, str3, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(java.lang.String r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$createConversationSession$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createConversationSession$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$createConversationSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createConversationSession$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$createConversationSession$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r7 = r0.L$3
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r7 = move-exception
            goto L77
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r10 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r10 = r10.D(r2, r7, r0)     // Catch: java.lang.Throwable -> L3a
            if (r10 != r1) goto L70
            return r1
        L70:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r7 = kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L3a
            goto L81
        L77:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L81:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            r9 = 0
            if (r8 == 0) goto La3
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "createConversationSession failed: "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r10 = 4
            h8.C4148a.h(r6, r8, r3, r10, r9)
        La3:
            boolean r6 = kotlin.Result.g(r7)
            if (r6 == 0) goto Laa
            r7 = r9
        Laa:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.G(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void H(String toolCallId, int toolLikeStatus, String taskId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        int i10 = 1;
        if (toolLikeStatus != 1) {
            i10 = 2;
            if (toolLikeStatus != 2) {
                i10 = 3;
            }
        }
        C1060i.d(C1073o0.f6391a, Y.b(), null, new AgentBusClient$toolLikeFeedback$1(new VoteRequest(null, taskId, toolCallId, i10, null, null, null, null, 240, null), this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object I(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$renameConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.chatcore.agents.AgentBusClient$renameConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$renameConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$renameConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$renameConversationRemote$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 != r4) goto L40
            java.lang.Object r6 = r0.L$4
            com.stepos.agentframework.chatcore.agents.AgentBusClient r6 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r6
            java.lang.Object r6 = r0.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L3e
            goto L7a
        L3e:
            r6 = move-exception
            goto L81
        L40:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L48:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3e
            com.stepos.agentframework.adapter.ApiManager r10 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3e
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3e
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L3e
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3e
            r0.L$4 = r6     // Catch: java.lang.Throwable -> L3e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3e
            r0.label = r4     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = r10.h0(r2, r8, r9, r0)     // Catch: java.lang.Throwable -> L3e
            if (r6 != r1) goto L7a
            return r1
        L7a:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3e
            goto L8b
        L81:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L8b:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto Lad
            java.lang.String r5 = r5.tag
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "renameConversationRemote failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 4
            r8 = 0
            h8.C4148a.h(r5, r6, r3, r7, r8)
        Lad:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.I(java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(java.lang.String r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteConversationRemote$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.L$3
            com.stepos.agentframework.chatcore.agents.AgentBusClient r6 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r6 = move-exception
            goto L7f
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r9 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L3a
            r0.label = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r9 = r9.E(r2, r8, r0)     // Catch: java.lang.Throwable -> L3a
            if (r9 != r1) goto L70
            return r1
        L70:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3a
            boolean r6 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3a
            goto L89
        L7f:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L89:
            java.lang.Throwable r7 = kotlin.Result.e(r6)
            if (r7 == 0) goto Lab
            java.lang.String r5 = r5.tag
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "deleteConversationRemote failed: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r8 = 4
            r9 = 0
            h8.C4148a.h(r5, r7, r4, r8, r9)
        Lab:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            boolean r7 = kotlin.Result.g(r6)
            if (r7 == 0) goto Lb6
            r6 = r5
        Lb6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.K(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object N(java.lang.String r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super java.util.List<p4.AgentRemoteChatMessage>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.N(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c S(RequestParameter parameter, AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        String strT0 = t0(parameter);
        com.stepos.agentframework.adapter.netcore.n nVarRemove = this.inFlightCancelHandles.remove(strT0);
        if (nVarRemove != null) {
            if (nVarRemove.getCancelled()) {
                nVarRemove = null;
            }
            if (nVarRemove != null) {
                nVarRemove.cancel("client.superseded");
            }
        }
        b bVarL0 = l0(strT0, callback);
        C1060i.d(C1073o0.f6391a, Y.b(), null, new AgentBusClient$send$2(parameter, bVarL0, callback, this, null), 2, null);
        return bVarL0.getRequester();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object U(java.lang.String r6, java.lang.String r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$abortSessionRemote$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$abortSessionRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$abortSessionRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$abortSessionRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$abortSessionRemote$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.chatcore.agents.AgentBusClient r6 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L36
            goto L66
        L36:
            r6 = move-exception
            goto L6d
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L36
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L36
            r0.label = r4     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = r8.d(r2, r7, r0)     // Catch: java.lang.Throwable -> L36
            if (r6 != r1) goto L66
            return r1
        L66:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L36
            goto L77
        L6d:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L77:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto L99
            java.lang.String r5 = r5.tag
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "abortSessionRemote failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 4
            r8 = 0
            h8.C4148a.h(r5, r6, r3, r7, r8)
        L99:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.U(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(kotlin.TaskInteractRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$interactTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$interactTask$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$interactTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$interactTask$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$interactTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            K6.H r7 = (kotlin.TaskInteractRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.Q(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "interactTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.a(K6.H, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$4
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$4 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$4 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$4
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L58
        L32:
            r8 = move-exception
            goto L5f
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.K(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L58
            return r1
        L58:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L69
        L5f:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L69:
            java.lang.Throwable r0 = kotlin.Result.e(r8)
            r1 = 0
            if (r0 == 0) goto L93
            java.lang.String r6 = r6.tag
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getHotSession(agentId="
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = ") failed: "
            r2.append(r7)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r0 = 4
            h8.C4148a.h(r6, r7, r3, r0, r1)
        L93:
            boolean r6 = kotlin.Result.g(r8)
            if (r6 == 0) goto L9a
            r8 = r1
        L9a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.b(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, e9.InterfaceC4014c<? super java.lang.Boolean> r17) throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$sendApproval$1
            if (r1 == 0) goto L16
            r1 = r0
            com.stepos.agentframework.chatcore.agents.AgentBusClient$sendApproval$1 r1 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$sendApproval$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r9 = r1
            goto L1c
        L16:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$sendApproval$1 r1 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$sendApproval$1
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.label
            r3 = 1
            r10 = 0
            if (r2 == 0) goto L51
            if (r2 != r3) goto L49
            java.lang.Object r12 = r9.L$5
            com.stepos.agentframework.chatcore.agents.AgentBusClient r12 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r12
            java.lang.Object r12 = r9.L$4
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.L$3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.L$2
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L46
            goto L90
        L46:
            r0 = move-exception
            r12 = r0
            goto L9f
        L49:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L51:
            kotlin.C4849c.b(r0)
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.agentframework.adapter.ApiManager r2 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.agentframework.adapter.netcore.ApiType r0 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L46
            r9.L$0 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L46
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r14)     // Catch: java.lang.Throwable -> L46
            r9.L$2 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r15)     // Catch: java.lang.Throwable -> L46
            r9.L$3 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r16)     // Catch: java.lang.Throwable -> L46
            r9.L$4 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L46
            r9.L$5 = r4     // Catch: java.lang.Throwable -> L46
            r9.I$0 = r10     // Catch: java.lang.Throwable -> L46
            r9.label = r3     // Catch: java.lang.Throwable -> L46
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r3 = r0
            java.lang.Object r0 = r2.i0(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L46
            if (r0 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L46
            boolean r12 = r0.booleanValue()     // Catch: java.lang.Throwable -> L46
            java.lang.Boolean r12 = g9.C4109a.a(r12)     // Catch: java.lang.Throwable -> L46
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L46
            goto La9
        L9f:
            kotlin.Result$a r13 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        La9:
            java.lang.Throwable r13 = kotlin.Result.e(r12)
            if (r13 == 0) goto Lcb
            java.lang.String r11 = r11.tag
            java.lang.String r13 = r13.getMessage()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "sendApproval failed: "
            r14.append(r0)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r14 = 4
            r0 = 0
            h8.C4148a.h(r11, r13, r10, r14, r0)
        Lcb:
            java.lang.Boolean r11 = g9.C4109a.a(r10)
            boolean r13 = kotlin.Result.g(r12)
            if (r13 == 0) goto Ld6
            r12 = r11
        Ld6:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void close() {
        Collection<B> collectionValues = this.taskListenerMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (B b10 : collectionValues) {
            ApiManager apiManager = ApiManager.INSTANCE;
            ApiType apiType = ApiType.AGENTBUS;
            kotlin.jvm.internal.p.f(b10);
            apiManager.g0(apiType, b10);
        }
        this.taskListenerMap.clear();
        this.callbackCache.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlin.TranscriptAppendRequest r19, e9.InterfaceC4014c<? super kotlin.TranscriptAppendResult> r20) throws java.lang.Throwable {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$1
            if (r2 == 0) goto L17
            r2 = r0
            com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$1 r2 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$1 r2 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$1
            r2.<init>(r1, r0)
        L1c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r2.label
            r5 = 0
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L41
            if (r4 != r7) goto L39
            java.lang.Object r3 = r2.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r3 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r3
            java.lang.Object r2 = r2.L$0
            K6.J r2 = (kotlin.TranscriptAppendRequest) r2
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L37
            goto L66
        L37:
            r0 = move-exception
            goto L83
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.C4849c.b(r0)
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L37
            com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$2$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$appendTranscript$2$1     // Catch: java.lang.Throwable -> L37
            r4 = r19
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L37
            r2.L$0 = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L37
            r2.L$1 = r4     // Catch: java.lang.Throwable -> L37
            r2.I$0 = r6     // Catch: java.lang.Throwable -> L37
            r2.label = r7     // Catch: java.lang.Throwable -> L37
            r7 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.e(r7, r0, r2)     // Catch: java.lang.Throwable -> L37
            if (r0 != r3) goto L66
            return r3
        L66:
            K6.K r0 = (kotlin.TranscriptAppendResult) r0     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L7e
            K6.K r7 = new K6.K     // Catch: java.lang.Throwable -> L37
            java.lang.String r14 = "timeout"
            java.lang.String r15 = "appendTranscript timeout 3000ms"
            r16 = 62
            r17 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L37
            r0 = r7
        L7e:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L37
            goto L8d
        L83:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L8d:
            java.lang.Throwable r2 = kotlin.Result.e(r0)
            if (r2 == 0) goto Lae
            java.lang.String r1 = r1.tag
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "appendTranscript failed: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 4
            h8.C4148a.h(r1, r2, r6, r3, r5)
        Lae:
            java.lang.Throwable r1 = kotlin.Result.e(r0)
            if (r1 != 0) goto Lb5
            goto Lca
        Lb5:
            K6.K r2 = new K6.K
            java.lang.String r10 = r1.getMessage()
            r11 = 62
            r12 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "exception"
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r2
        Lca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.d(K6.J, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(kotlin.TaskCancelRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$cancelTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$cancelTask$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$cancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$cancelTask$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$cancelTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            K6.F r7 = (kotlin.TaskCancelRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.p(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cancelTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.e(K6.F, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(kotlin.TaskDeleteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteTask$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteTask$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$deleteTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            K6.G r7 = (kotlin.TaskDeleteRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.F(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deleteTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.f(K6.G, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(kotlin.TaskBatchDeleteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$batchDeleteTasks$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$batchDeleteTasks$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$batchDeleteTasks$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$batchDeleteTasks$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$batchDeleteTasks$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            K6.E r7 = (kotlin.TaskBatchDeleteRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.o(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "batchDeleteTasks failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.g(K6.E, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public boolean h() {
        return ApiManager.INSTANCE.S(ApiType.AGENTBUS);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$getHotSession$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.L$0
            com.stepos.agentframework.chatcore.agents.AgentBusClient r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r0
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L52
        L2e:
            r7 = move-exception
            goto L59
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2e
            com.stepos.agentframework.adapter.ApiManager r7 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L2e
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L2e
            r0.label = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.J(r2, r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L52
            return r1
        L52:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L63
        L59:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L63:
            java.lang.Throwable r0 = kotlin.Result.e(r7)
            r1 = 0
            if (r0 == 0) goto L85
            java.lang.String r6 = r6.tag
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getHotSession failed: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 4
            h8.C4148a.h(r6, r0, r3, r2, r1)
        L85:
            boolean r6 = kotlin.Result.g(r7)
            if (r6 == 0) goto L8c
            r7 = r1
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.i(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$createSessionForAgent$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createSessionForAgent$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$createSessionForAgent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createSessionForAgent$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$createSessionForAgent$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L58
        L32:
            r8 = move-exception
            goto L5f
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.C(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L58
            return r1
        L58:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L69
        L5f:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L69:
            java.lang.Throwable r0 = kotlin.Result.e(r8)
            r1 = 0
            if (r0 == 0) goto L93
            java.lang.String r6 = r6.tag
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "createSessionForAgent(agentId="
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = ") failed: "
            r2.append(r7)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r0 = 4
            h8.C4148a.h(r6, r7, r3, r0, r1)
        L93:
            boolean r6 = kotlin.Result.g(r8)
            if (r6 == 0) goto L9a
            r8 = r1
        L9a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.j(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r9, java.lang.String r10, java.util.List<java.lang.String> r11, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.InquiryAnswerResult> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$answerInquiry$1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.agentframework.chatcore.agents.AgentBusClient$answerInquiry$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$answerInquiry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$answerInquiry$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$answerInquiry$1
            r0.<init>(r8, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            r7 = 0
            if (r1 == 0) goto L47
            if (r1 != r2) goto L3f
            java.lang.Object r9 = r6.L$3
            com.stepos.agentframework.chatcore.agents.AgentBusClient r9 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r9
            java.lang.Object r9 = r6.L$2
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r6.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L3c:
            r0 = move-exception
            r9 = r0
            goto L7e
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            kotlin.C4849c.b(r12)
            kotlin.Result$a r12 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3c
            com.stepos.agentframework.adapter.ApiManager r1 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3c
            r12 = r2
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L3c
            r6.L$0 = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3c
            r6.L$1 = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3c
            r6.L$2 = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3c
            r6.L$3 = r3     // Catch: java.lang.Throwable -> L3c
            r6.I$0 = r7     // Catch: java.lang.Throwable -> L3c
            r6.label = r12     // Catch: java.lang.Throwable -> L3c
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.m(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3c
            if (r12 != r0) goto L77
            return r0
        L77:
            com.stepos.agentframework.adapter.netcore.q r12 = (com.stepos.agentframework.adapter.netcore.InquiryAnswerResult) r12     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L3c
            goto L88
        L7e:
            kotlin.Result$a r10 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.C4849c.a(r9)
            java.lang.Object r9 = kotlin.Result.b(r9)
        L88:
            java.lang.Throwable r10 = kotlin.Result.e(r9)
            r11 = 0
            if (r10 == 0) goto Laa
            java.lang.String r8 = r8.tag
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "answerInquiry failed: "
            r12.append(r0)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r12 = 4
            h8.C4148a.h(r8, r10, r7, r12, r11)
        Laa:
            com.stepos.agentframework.adapter.netcore.q r8 = new com.stepos.agentframework.adapter.netcore.q
            r10 = 2
            r8.<init>(r7, r11, r10, r11)
            boolean r10 = kotlin.Result.g(r9)
            if (r10 == 0) goto Lb7
            r9 = r8
        Lb7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.k(java.lang.String, java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    public final void k0(C0918n c0918n) {
        int iNextIndex;
        Map<String, Object> mapS0;
        List<AbstractC0913i> listJ = c0918n.j();
        if (listJ == null) {
            listJ = C1173v.m();
        }
        if (listJ.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<AbstractC0913i> list = listJ;
        Iterator<T> it = list.iterator();
        while (true) {
            String url = null;
            if (!it.hasNext()) {
                break;
            }
            AbstractC0913i abstractC0913i = (AbstractC0913i) it.next();
            if (abstractC0913i instanceof AbstractC0913i.Image) {
                url = ((AbstractC0913i.Image) abstractC0913i).getUrl();
            } else if (abstractC0913i instanceof AbstractC0913i.File) {
                url = ((AbstractC0913i.File) abstractC0913i).getUrl();
            }
            if (url != null && !H.x0(url) && (mapS0 = s0(url)) != null) {
                arrayList.add(mapS0);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String str = "<extra>" + this.noEscapeGson.toJson(Q.f(Y8.j.a("attachments", arrayList))) + "</extra>";
        ListIterator<AbstractC0913i> listIterator = listJ.listIterator(listJ.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous() instanceof AbstractC0913i.Text) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex = -1;
                break;
            }
        }
        if (iNextIndex < 0) {
            c0918n.A(F.T0(listJ, new AbstractC0913i.Text(str)));
        } else {
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                AbstractC0913i abstractC0913i2 = (AbstractC0913i) obj;
                if (i10 == iNextIndex && (abstractC0913i2 instanceof AbstractC0913i.Text)) {
                    AbstractC0913i.Text text = (AbstractC0913i.Text) abstractC0913i2;
                    AbstractC0913i.Text text2 = new AbstractC0913i.Text(text.getText().length() == 0 ? str : text.getText() + "\n" + str);
                    text2.a(abstractC0913i2.c());
                    abstractC0913i2 = text2;
                }
                arrayList2.add(abstractC0913i2);
                i10 = i11;
            }
            c0918n.A(arrayList2);
        }
        C4148a.k(this.tag, "aggregated attachments size:" + arrayList.size(), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(kotlin.TaskSyncRemoteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$syncTaskWithRemote$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.AgentBusClient$syncTaskWithRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$syncTaskWithRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$syncTaskWithRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$syncTaskWithRemote$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.AgentBusClient r7 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r7
            java.lang.Object r7 = r0.L$0
            K6.I r7 = (kotlin.TaskSyncRemoteRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.o0(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "syncTaskWithRemote failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.l(K6.I, e9.c):java.lang.Object");
    }

    public final b l0(final String sessionKey, final AgentDispatcher.b callback) {
        C5000a c5000a = new C5000a();
        final AtomicReference atomicReference = new AtomicReference(null);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicReference atomicReference2 = new AtomicReference("user.abort");
        final AgentBusStreamBridge agentBusStreamBridge = new AgentBusStreamBridge(callback, 0L, 2, null);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        c5000a.b(new C5000a.InterfaceC0479a() { // from class: com.stepos.agentframework.chatcore.agents.AgentBusClient$attachInboundStream$1
            @Override // o4.C5000a.InterfaceC0479a
            public void cancel(String reason) {
                kotlin.jvm.internal.p.i(reason, "reason");
                atomicBoolean.set(true);
                atomicReference2.set(reason);
                com.stepos.agentframework.adapter.netcore.n nVar = atomicReference.get();
                if (nVar != null) {
                    nVar.cancel(reason);
                }
                AgentBusClient.m0(atomicReference, this, sessionKey);
                C1060i.d(C1073o0.f6391a, this.streamSerial, null, new AgentBusClient$attachInboundStream$1$cancel$1(this, callback, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }
        });
        com.stepos.agentframework.adapter.netcore.h hVar = new com.stepos.agentframework.adapter.netcore.h() { // from class: com.stepos.agentframework.chatcore.agents.AgentBusClient$attachInboundStream$eventListener$1
            @Override // com.stepos.agentframework.adapter.netcore.h
            public void a() {
                callback.e();
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void b(C0918n chatRequestInfo, Integer code, String message) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new AgentBusClient$attachInboundStream$eventListener$1$onFailure$1(this.this$0, callback, code, message, atomicReference, sessionKey, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void c(C0918n chatRequestInfo, boolean success, Integer code, String message) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                callback.b(success, code, message);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void d() {
                callback.n();
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void e(C0918n chatRequestInfo, String runId, List<ReferenceSource> sources) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                kotlin.jvm.internal.p.i(runId, "runId");
                kotlin.jvm.internal.p.i(sources, "sources");
                callback.g(runId, sources);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void f(C0918n chatRequestInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void g(C0918n chatRequestInfo, C0917m chatReplyInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new AgentBusClient$attachInboundStream$eventListener$1$onEvent$1(this.this$0, chatReplyInfo, agentBusStreamBridge, null), 2, null);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void h(C0918n chatRequestInfo, String runId, String name, String resultJson) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                kotlin.jvm.internal.p.i(runId, "runId");
                kotlin.jvm.internal.p.i(name, "name");
                kotlin.jvm.internal.p.i(resultJson, "resultJson");
                callback.m(runId, name, resultJson);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public /* bridge */ void i(Object obj) {
                super.i(obj);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void j(C0918n chatRequestInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new AgentBusClient$attachInboundStream$eventListener$1$onClosed$1(this.this$0, callback, atomicReference, sessionKey, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }
        };
        this.callbackCache.put(callback, X.d(hVar));
        return new b(c5000a, hVar, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.agents.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentBusClient.p0(atomicReference, this, sessionKey, atomicBoolean, atomicReference2, (com.stepos.agentframework.adapter.netcore.n) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$createSession$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createSession$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$createSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$createSession$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$createSession$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.L$0
            com.stepos.agentframework.chatcore.agents.AgentBusClient r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r0
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L52
        L2e:
            r7 = move-exception
            goto L59
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2e
            com.stepos.agentframework.adapter.ApiManager r7 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L2e
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L2e
            r0.label = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.A(r2, r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L52
            return r1
        L52:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L63
        L59:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L63:
            java.lang.Throwable r0 = kotlin.Result.e(r7)
            r1 = 0
            if (r0 == 0) goto L85
            java.lang.String r6 = r6.tag
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "createSession failed: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 4
            h8.C4148a.h(r6, r0, r3, r2, r1)
        L85:
            boolean r6 = kotlin.Result.g(r7)
            if (r6 == 0) goto L8c
            r7 = r1
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.m(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.n(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void q(u.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        B bRemove = this.taskListenerMap.remove(listener);
        if (bRemove != null) {
            ApiManager.INSTANCE.g0(ApiType.AGENTBUS, bRemove);
        }
    }

    public final String q0(String parameter) {
        Object objB;
        if (parameter.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objFromJson = this.gson.fromJson(parameter, (Class<Object>) Map.class);
            Map map = objFromJson instanceof Map ? (Map) objFromJson : null;
            Object obj = map != null ? map.get("command") : null;
            objB = Result.b(obj instanceof String ? (String) obj : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return new C5732a(str, "AgentBus", "Agent via AgentBus", "", "", null, 32, null);
    }

    public void r0(AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.callbackCache.remove(callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(java.lang.String r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.agents.AgentBusClient$clearConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.agents.AgentBusClient$clearConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentBusClient$clearConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentBusClient$clearConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentBusClient$clearConversationRemote$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r6 = r0.L$3
            com.stepos.agentframework.chatcore.agents.AgentBusClient r6 = (com.stepos.agentframework.chatcore.agents.AgentBusClient) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r6 = move-exception
            goto L77
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r9 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = r9.y(r2, r8, r0)     // Catch: java.lang.Throwable -> L3a
            if (r6 != r1) goto L70
            return r1
        L70:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3a
            goto L81
        L77:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L81:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto La3
            java.lang.String r5 = r5.tag
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "clearConversationRemote failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 4
            r8 = 0
            h8.C4148a.h(r5, r6, r3, r7, r8)
        La3:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.s(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final Map<String, Object> s0(String rawUrl) {
        AttachmentMeta attachmentMeta = this.attachmentCache.get(rawUrl);
        if (attachmentMeta == null) {
            return null;
        }
        return kotlin.collections.a.m(Y8.j.a("id", attachmentMeta.getFileId()), Y8.j.a(ContentDisposition.Parameters.Size, Long.valueOf(attachmentMeta.getSize())), Y8.j.a("devicePath", attachmentMeta.getDevicePath()), Y8.j.a(ContentDisposition.Parameters.FileName, attachmentMeta.getFilename()), Y8.j.a("mimeType", attachmentMeta.getMimeType()));
    }

    public final void u0(AgentTool tool) {
        String strQ0;
        La.m mVarD;
        List<String> listC;
        if (kotlin.jvm.internal.p.d(tool.getName(), "exec") && (strQ0 = q0(tool.getParameter())) != null) {
            La.m mVarD2 = Regex.d(l.EXEC_TOOL_NAME_REGEX, strQ0, 0, 2, null);
            if (kotlin.jvm.internal.p.d((mVarD2 == null || (listC = mVarD2.c()) == null) ? null : listC.get(1), "gui_agent") && (mVarD = Regex.d(l.EXEC_PARAMS_REGEX, strQ0, 0, 2, null)) != null) {
                String str = mVarD.c().get(1);
                if (str.length() == 0) {
                    str = mVarD.c().get(2);
                }
                String str2 = str;
                if (str2.length() == 0) {
                    return;
                }
                tool.E("gui_agent");
                tool.w("gui_agent");
                tool.G(str2);
            }
        }
    }

    public final AgentResponse v0(TaskEventPayload taskEventPayload) {
        AgentTaskEventType agentTaskEventType;
        int i10 = c.$EnumSwitchMapping$0[taskEventPayload.getEventType().ordinal()];
        if (i10 == 1) {
            agentTaskEventType = AgentTaskEventType.CREATED;
        } else if (i10 == 2) {
            agentTaskEventType = AgentTaskEventType.UPDATED;
        } else if (i10 == 3) {
            agentTaskEventType = AgentTaskEventType.COMPLETED;
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            agentTaskEventType = AgentTaskEventType.ANSWER;
        }
        return new AgentResponse(null, null, taskEventPayload.a(), null, AgentMessageType.TASK, null, null, null, EReplyStatus.COMPLETED, null, null, null, null, new AgentTaskEvent(agentTaskEventType, taskEventPayload.getSeq(), taskEventPayload.getTs(), taskEventPayload.getSessionKey(), taskEventPayload.getTask(), taskEventPayload.getAnswer()), null, null, null, null, null, null, null, null, 4185835, null);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c w(String sessionId, String outboundId, AgentDispatcher.b callback) {
        com.stepos.agentframework.adapter.netcore.n nVarRemove;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        kotlin.jvm.internal.p.i(callback, "callback");
        String string = H.D1(sessionId).toString();
        String string2 = H.D1(outboundId).toString();
        if (string.length() == 0 || string2.length() == 0) {
            C4148a.u(this.tag, "registerPendingInbound skip: empty sessionId/outboundId", false, 4, null);
            return null;
        }
        ApiManager apiManager = ApiManager.INSTANCE;
        if (!apiManager.L(string2) && (nVarRemove = this.inFlightCancelHandles.remove(string)) != null) {
            if (nVarRemove.getCancelled()) {
                nVarRemove = null;
            }
            if (nVarRemove != null) {
                nVarRemove.cancel("client.superseded");
            }
        }
        b bVarL0 = l0(string, callback);
        com.stepos.agentframework.adapter.netcore.n nVarF0 = apiManager.f0(string, string2, bVarL0.getEventListener());
        if (nVarF0 == null) {
            C4148a.u(this.tag, "registerPendingInbound failed sessionId=" + string + " outboundId=" + string2, false, 4, null);
            r0(callback);
            return null;
        }
        bVarL0.a().invoke(nVarF0);
        C4148a.k(this.tag, "registerPendingInbound ok sessionId=" + string + " outboundId=" + string2, false, 4, null);
        return bVarL0.getRequester();
    }

    public final void w0(AgentResponse response) {
        List<AgentTool> listY;
        if ((response.getType() == AgentMessageType.TOOL_SHOW || response.getType() == AgentMessageType.TOOL_RESULT) && (listY = response.y()) != null) {
            Iterator<T> it = listY.iterator();
            while (it.hasNext()) {
                u0((AgentTool) it.next());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0121, code lost:
    
        if (r2.a1(r7) == r8) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x(final android.content.Context r16, java.lang.String r17, java.lang.String r18, final com.stepos.agentframework.chatcore.file.FileInfo r19, final t4.InterfaceC5507a r20, e9.InterfaceC4014c<? super Y8.t> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentBusClient.x(android.content.Context, java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.file.FileInfo, t4.a, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void y(final u.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        if (R0.a()) {
            C4148a.d(this.tag, "addGlobalTaskListener no-op under TaskIngress", false, 4, null);
            return;
        }
        ConcurrentHashMap<u.a, B> concurrentHashMap = this.taskListenerMap;
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.agents.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentBusClient.h0(listener, this, (u.a) obj);
            }
        };
        concurrentHashMap.computeIfAbsent(listener, new Function() { // from class: com.stepos.agentframework.chatcore.agents.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AgentBusClient.j0(interfaceC5074l, obj);
            }
        });
    }
}
