package com.stepos.agentframework.adapter.agentbus;

import Ua.C1056g;
import Ua.Y;
import Z8.C1172u;
import Z8.C1173v;
import Z8.Q;
import a4.Message;
import a4.ToolCall;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.Role;
import com.stepos.agentbus.generated.ToolStatus;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.C4849c;
import kotlin.HistoryTaskCreateHint;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.SyncHistoryResult;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a*\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0010\u0010\u000f\u001a$\u0010\u0012\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u001a\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u001a\u0010\u001b\u001a(\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b\u001e\u0010\u0006\u001a<\u0010#\u001a\u00020\r*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010!0 2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b#\u0010$\u001a>\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010!0 2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b%\u0010$\u001a(\u0010'\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b'\u0010\u0006\u001a.\u0010)\u001a\u00020\r*\u00020\u00002\u0006\u0010&\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b)\u0010*\u001a:\u0010.\u001a\u00020\r*\u00020\u00002\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b.\u0010/\u001a1\u00102\u001a\u0004\u0018\u00010\u0001*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010!0 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000100H\u0002¢\u0006\u0004\b2\u00103\u001a1\u00104\u001a\u0004\u0018\u00010\u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010!0 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000100H\u0002¢\u0006\u0004\b4\u00105\u001a\u0013\u00108\u001a\u000207*\u000206H\u0002¢\u0006\u0004\b8\u00109\u001a\u0019\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:*\u000206H\u0002¢\u0006\u0004\b<\u0010=\u001a\u001b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010>\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b@\u0010A\u001a\u0013\u0010B\u001a\u00020\r*\u000206H\u0000¢\u0006\u0004\bB\u0010C\u001a\u0013\u0010D\u001a\u00020\r*\u000206H\u0000¢\u0006\u0004\bD\u0010C\u001a\u0013\u0010E\u001a\u00020\r*\u000206H\u0000¢\u0006\u0004\bE\u0010C\u001a\u0013\u0010F\u001a\u00020\r*\u000206H\u0000¢\u0006\u0004\bF\u0010C\u001a\u0013\u0010G\u001a\u00020\r*\u000206H\u0000¢\u0006\u0004\bG\u0010C\u001a\u0017\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\rH\u0000¢\u0006\u0004\bI\u0010J\u001a'\u0010O\u001a\u00020N2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\rH\u0000¢\u0006\u0004\bO\u0010P\u001a\u0017\u0010R\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\rH\u0000¢\u0006\u0004\bR\u0010S\u001a\u0017\u0010U\u001a\u00020\r2\u0006\u0010T\u001a\u00020NH\u0000¢\u0006\u0004\bU\u0010V\u001a-\u0010Y\u001a\u00020\r2\u0006\u0010W\u001a\u00020\u00012\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0000¢\u0006\u0004\bY\u0010Z\u001a\u001b\u0010\\\u001a\u0004\u0018\u00010\u00012\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\\\u0010]\u001a?\u0010b\u001a\u00020\r2\b\u0010[\u001a\u0004\u0018\u00010\u00012\b\u0010^\u001a\u0004\u0018\u00010\u00012\b\u0010_\u001a\u0004\u0018\u00010\u00012\b\u0010`\u001a\u0004\u0018\u00010\u00012\u0006\u0010a\u001a\u00020\rH\u0000¢\u0006\u0004\bb\u0010c\u001a\u0019\u0010e\u001a\u00020\r2\b\u0010d\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\be\u0010f\u001aK\u0010k\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0:0j2\u0006\u0010g\u001a\u00020\u00012\b\u0010[\u001a\u0004\u0018\u00010\u00012\b\u0010_\u001a\u0004\u0018\u00010\u00012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020h0:H\u0000¢\u0006\u0004\bk\u0010l\"\u0014\u0010m\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bm\u0010I\"\u0014\u0010n\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010I\"\u0014\u0010o\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bo\u0010p\"\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010r\"\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010r\"\u0014\u0010t\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010p¨\u0006u"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "", "agentId", "", "timeoutMs", "m", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "", "limit", "LK6/D;", "L", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "", "o", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "l", "title", "z", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/O;", "request", "K", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;LK6/O;Le9/c;)Ljava/lang/Object;", "message", "idempotencyKey", "F", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "frameId", "Lcom/stepos/agentframework/adapter/agentbus/H;", "e", "method", "", "", "params", "D", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/util/Map;JLe9/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "type", "x", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "O", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "fileUri", "mime", DidiCardProvider.KEY_TRACE_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "", "keys", "s", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/String;", "r", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/Long;", "La4/w;", "LK6/B;", "N", "(La4/w;)LK6/B;", "", "LK6/x;", "q", "(La4/w;)Ljava/util/List;", "result", "Lorg/json/JSONObject;", "B", "(Ljava/lang/Object;)Lorg/json/JSONObject;", "v", "(La4/w;)Z", "t", "u", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "hasDispatchedAnswer", "J", "(Z)J", "hasDispatchedReply", "terminalFrameSeen", "hasInflightTool", "Lcom/stepos/agentframework/adapter/agentbus/TurnDoneCloseAction;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ZZZ)Lcom/stepos/agentframework/adapter/agentbus/TurnDoneCloseAction;", "turnDone", "G", "(Z)Z", "action", "H", "(Lcom/stepos/agentframework/adapter/agentbus/TurnDoneCloseAction;)Z", "event", "payload", "w", "(Ljava/lang/String;Ljava/util/Map;)Z", "replyTo", "p", "(Ljava/lang/String;)Ljava/lang/String;", "outboundId", "incomingRunId", "boundRunId", "waitingEmptyTerminal", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z", "activeRunId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Z", "inboundSessionId", "Lcom/stepos/agentframework/adapter/agentbus/a;", "chats", "Lkotlin/Pair;", "C", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lkotlin/Pair;", "CHANNEL_REQ_TIMEOUT_MS", "PRIVACY_CHECK_TIMEOUT_MS", "TAG", "Ljava/lang/String;", "MESSAGE_ID_KEYS", "[Ljava/lang/String;", "TIMESTAMP_KEYS", "TOOL_NAME_TASK_CREATE", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusChannelOpsKt {
    private static final long CHANNEL_REQ_TIMEOUT_MS = 10000;
    private static final long PRIVACY_CHECK_TIMEOUT_MS = 35000;
    private static final String TAG = "AgentBusChannelOps";
    private static final String TOOL_NAME_TASK_CREATE = "task_create";
    private static final String[] MESSAGE_ID_KEYS = {"messageId", RequestParameter.META_KEY_MESSAGE_ID, "id", "msgId", "msg_id"};
    private static final String[] TIMESTAMP_KEYS = {"timestamp", "timestampMs", "createdAtMs", c.a.COL_CREATED_AT, "createdAt", "ts", "time"};

    public static final TurnDoneCloseAction A(boolean z10, boolean z11, boolean z12) {
        if (!z10) {
            return TurnDoneCloseAction.AWAIT_REPLY;
        }
        if (!z12 && z11) {
            return TurnDoneCloseAction.CLOSE_NOW;
        }
        return TurnDoneCloseAction.ARM_GRACE;
    }

    public static final JSONObject B(Object obj) {
        Object objB;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (obj == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (obj instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj;
            } else if (obj instanceof Map) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key != null) {
                        linkedHashMap.put(key.toString(), value);
                    }
                }
                jSONObject2 = new JSONObject(linkedHashMap);
            } else {
                if (obj instanceof String) {
                    String string = La.H.D1((String) obj).toString();
                    if (string.length() <= 0) {
                        string = null;
                    }
                    if (string != null) {
                        jSONObject = new JSONObject(string);
                    } else {
                        jSONObject2 = null;
                    }
                } else {
                    jSONObject = new JSONObject(obj.toString());
                }
                jSONObject2 = jSONObject;
            }
            objB = Result.b(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JSONObject) (Result.g(objB) ? null : objB);
    }

    public static final Pair<String, List<ActiveChatSnapshot>> C(String inboundSessionId, String str, String str2, List<ActiveChatSnapshot> chats) {
        Object next;
        Object next2;
        kotlin.jvm.internal.p.i(inboundSessionId, "inboundSessionId");
        kotlin.jvm.internal.p.i(chats, "chats");
        String strP = p(str);
        Object obj = null;
        if (strP != null) {
            List<ActiveChatSnapshot> list = chats;
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                ActiveChatSnapshot activeChatSnapshot = (ActiveChatSnapshot) next2;
                if (kotlin.jvm.internal.p.d(activeChatSnapshot.getSessionId(), inboundSessionId) && kotlin.jvm.internal.p.d(activeChatSnapshot.getOutboundId(), strP)) {
                    break;
                }
            }
            ActiveChatSnapshot activeChatSnapshot2 = (ActiveChatSnapshot) next2;
            if (activeChatSnapshot2 != null) {
                return Y8.j.a(inboundSessionId, C1172u.e(activeChatSnapshot2));
            }
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (kotlin.jvm.internal.p.d(((ActiveChatSnapshot) next3).getOutboundId(), strP)) {
                    obj = next3;
                    break;
                }
            }
            ActiveChatSnapshot activeChatSnapshot3 = (ActiveChatSnapshot) obj;
            return activeChatSnapshot3 != null ? Y8.j.a(activeChatSnapshot3.getSessionId(), C1172u.e(activeChatSnapshot3)) : Y8.j.a(inboundSessionId, C1173v.m());
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : chats) {
            ActiveChatSnapshot activeChatSnapshot4 = (ActiveChatSnapshot) obj2;
            if (!activeChatSnapshot4.getFinished() && !activeChatSnapshot4.getCancelled()) {
                arrayList.add(obj2);
            }
        }
        if (str2 == null || str2.length() <= 0) {
            str2 = null;
        }
        if (str2 != null) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                ActiveChatSnapshot activeChatSnapshot5 = (ActiveChatSnapshot) next;
                if (kotlin.jvm.internal.p.d(activeChatSnapshot5.getSessionId(), inboundSessionId) && kotlin.jvm.internal.p.d(activeChatSnapshot5.getRunId(), str2)) {
                    break;
                }
            }
            ActiveChatSnapshot activeChatSnapshot6 = (ActiveChatSnapshot) next;
            if (activeChatSnapshot6 != null) {
                return Y8.j.a(inboundSessionId, C1172u.e(activeChatSnapshot6));
            }
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                Object next4 = it4.next();
                if (kotlin.jvm.internal.p.d(((ActiveChatSnapshot) next4).getRunId(), str2)) {
                    obj = next4;
                    break;
                }
            }
            ActiveChatSnapshot activeChatSnapshot7 = (ActiveChatSnapshot) obj;
            if (activeChatSnapshot7 != null) {
                return Y8.j.a(activeChatSnapshot7.getSessionId(), C1172u.e(activeChatSnapshot7));
            }
        }
        List arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            ActiveChatSnapshot activeChatSnapshot8 = (ActiveChatSnapshot) obj3;
            if (kotlin.jvm.internal.p.d(activeChatSnapshot8.getSessionId(), inboundSessionId) && activeChatSnapshot8.getWaitingEmptyTerminal()) {
                arrayList2.add(obj3);
            }
        }
        if (arrayList2.isEmpty()) {
            return Y8.j.a(inboundSessionId, C1173v.m());
        }
        if (arrayList2.size() != 1) {
            Iterator it5 = arrayList2.iterator();
            if (!it5.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next5 = it5.next();
            if (it5.hasNext()) {
                long createdAtMs = ((ActiveChatSnapshot) next5).getCreatedAtMs();
                do {
                    Object next6 = it5.next();
                    long createdAtMs2 = ((ActiveChatSnapshot) next6).getCreatedAtMs();
                    if (createdAtMs < createdAtMs2) {
                        next5 = next6;
                        createdAtMs = createdAtMs2;
                    }
                } while (it5.hasNext());
            }
            arrayList2 = C1172u.e(next5);
        }
        return Y8.j.a(inboundSessionId, arrayList2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (r10 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object D(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5, java.lang.String r6, java.util.Map<java.lang.String, ? extends java.lang.Object> r7, long r8, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReq$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReq$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReq$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReq$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReq$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r5 = r0.L$3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r5
            kotlin.C4849c.b(r10)
            goto L99
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            long r8 = r0.J$0
            java.lang.Object r5 = r0.L$2
            r7 = r5
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r5
            kotlin.C4849c.b(r10)
            goto L74
        L58:
            kotlin.C4849c.b(r10)
            r0.L$0 = r5
            java.lang.Object r10 = g9.h.a(r6)
            r0.L$1 = r10
            java.lang.Object r10 = g9.h.a(r7)
            r0.L$2 = r10
            r0.J$0 = r8
            r0.label = r4
            java.lang.Object r10 = r5.N(r6, r7, r0)
            if (r10 != r1) goto L74
            goto L98
        L74:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = g9.h.a(r5)
            r0.L$0 = r2
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$1 = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.L$2 = r6
            java.lang.Object r6 = g9.h.a(r10)
            r0.L$3 = r6
            r0.J$0 = r8
            r0.label = r3
            java.lang.Object r10 = r5.o(r10, r8, r0)
            if (r10 != r1) goto L99
        L98:
            return r1
        L99:
            org.json.JSONObject r10 = (org.json.JSONObject) r10
            r5 = 0
            if (r10 == 0) goto La7
            java.lang.String r6 = "ok"
            boolean r6 = r10.optBoolean(r6, r5)
            if (r6 != r4) goto La7
            goto La8
        La7:
            r4 = r5
        La8:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.D(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, java.lang.String, java.util.Map, long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (r10 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object E(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5, java.lang.String r6, java.util.Map<java.lang.String, ? extends java.lang.Object> r7, long r8, e9.InterfaceC4014c<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReqForContent$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReqForContent$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReqForContent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReqForContent$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$sendChannelReqForContent$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r5 = r0.L$3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r5
            kotlin.C4849c.b(r10)
            goto L99
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            long r8 = r0.J$0
            java.lang.Object r5 = r0.L$2
            r7 = r5
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r5 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r5
            kotlin.C4849c.b(r10)
            goto L74
        L58:
            kotlin.C4849c.b(r10)
            r0.L$0 = r5
            java.lang.Object r10 = g9.h.a(r6)
            r0.L$1 = r10
            java.lang.Object r10 = g9.h.a(r7)
            r0.L$2 = r10
            r0.J$0 = r8
            r0.label = r4
            java.lang.Object r10 = r5.N(r6, r7, r0)
            if (r10 != r1) goto L74
            goto L98
        L74:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = g9.h.a(r5)
            r0.L$0 = r2
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$1 = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.L$2 = r6
            java.lang.Object r6 = g9.h.a(r10)
            r0.L$3 = r6
            r0.J$0 = r8
            r0.label = r3
            java.lang.Object r10 = r5.o(r10, r8, r0)
            if (r10 != r1) goto L99
        L98:
            return r1
        L99:
            org.json.JSONObject r10 = (org.json.JSONObject) r10
            r5 = 0
            if (r10 != 0) goto L9f
            return r5
        L9f:
            java.lang.String r6 = "ok"
            r7 = 0
            boolean r6 = r10.optBoolean(r6, r7)
            if (r6 != 0) goto La9
            return r5
        La9:
            java.lang.String r6 = "payload"
            org.json.JSONObject r6 = r10.optJSONObject(r6)
            if (r6 == 0) goto Lb7
            java.lang.String r5 = "content"
            java.lang.String r5 = r6.optString(r5)
        Lb7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.E(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, java.lang.String, java.util.Map, long, e9.c):java.lang.Object");
    }

    public static final Object F(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, String str3, InterfaceC4014c<? super String> interfaceC4014c) {
        Map mapC = Q.c();
        mapC.put(SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, str);
        mapC.put("message", str2);
        mapC.put("idempotencyKey", str3);
        Y8.t tVar = Y8.t.f7040a;
        return clawChannelAgentBusBinding.N("stepclaw.regenerate", Q.b(mapC), interfaceC4014c);
    }

    public static final boolean G(boolean z10) {
        return !z10;
    }

    public static final boolean H(TurnDoneCloseAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        return action != TurnDoneCloseAction.AWAIT_REPLY;
    }

    public static final boolean I(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        return v(message) && !message.g().isEmpty();
    }

    public static final long J(boolean z10) {
        return z10 ? 3000L : 120000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object K(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r9, kotlin.VoteRequest r10, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$submitVote$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$submitVote$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$submitVote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$submitVote$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$submitVote$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            r5 = 0
            r6 = 0
            java.lang.String r7 = "AgentBusChannelOps"
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r9 = r0.L$1
            r10 = r9
            K6.O r10 = (kotlin.VoteRequest) r10
            java.lang.Object r9 = r0.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r9 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r9
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L37
            goto L75
        L37:
            r9 = move-exception
            goto Lad
        L39:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L41:
            kotlin.C4849c.b(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L37
            r11.<init>()     // Catch: java.lang.Exception -> L37
            java.lang.String r2 = "vote request: "
            r11.append(r2)     // Catch: java.lang.Exception -> L37
            r11.append(r10)     // Catch: java.lang.Exception -> L37
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L37
            h8.C4148a.k(r7, r11, r6, r3, r5)     // Catch: java.lang.Exception -> L37
            com.stepos.net.HttpManager r11 = com.stepos.net.HttpManager.INSTANCE     // Catch: java.lang.Exception -> L37
            java.lang.String r2 = "__default__"
            java.lang.Class<com.stepos.agentframework.adapter.netcore.service.a> r8 = com.stepos.agentframework.adapter.netcore.service.a.class
            java.lang.Object r11 = r11.create(r8, r2)     // Catch: java.lang.Exception -> L37
            com.stepos.agentframework.adapter.netcore.service.a r11 = (com.stepos.agentframework.adapter.netcore.service.a) r11     // Catch: java.lang.Exception -> L37
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Exception -> L37
            r0.L$0 = r9     // Catch: java.lang.Exception -> L37
            r0.L$1 = r10     // Catch: java.lang.Exception -> L37
            r0.label = r4     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = r11.a(r5, r10, r0)     // Catch: java.lang.Exception -> L37
            if (r11 != r1) goto L75
            return r1
        L75:
            yc.v r11 = (yc.v) r11     // Catch: java.lang.Exception -> L37
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L37
            r9.<init>()     // Catch: java.lang.Exception -> L37
            java.lang.String r0 = " [Vote-4-Response] 服务器响应成功: response="
            r9.append(r0)     // Catch: java.lang.Exception -> L37
            r9.append(r11)     // Catch: java.lang.Exception -> L37
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L37
            h8.C4148a.j(r7, r9, r4)     // Catch: java.lang.Exception -> L37
            java.lang.String r9 = r10.getTaskId()     // Catch: java.lang.Exception -> L37
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L37
            r10.<init>()     // Catch: java.lang.Exception -> L37
            java.lang.String r0 = " [Vote-4] HTTP请求成功! task_id="
            r10.append(r0)     // Catch: java.lang.Exception -> L37
            r10.append(r9)     // Catch: java.lang.Exception -> L37
            java.lang.String r9 = " 已上报到后端服务器"
            r10.append(r9)     // Catch: java.lang.Exception -> L37
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Exception -> L37
            h8.C4148a.k(r7, r9, r6, r3, r5)     // Catch: java.lang.Exception -> L37
            boolean r6 = r11.f()     // Catch: java.lang.Exception -> L37
            goto Lc5
        Lad:
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = " [Vote-4] HTTP请求失败: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.h(r7, r9, r6, r3, r5)
        Lc5:
            java.lang.Boolean r9 = g9.C4109a.a(r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.K(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, K6.O, e9.c):java.lang.Object");
    }

    public static final Object L(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, int i10, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new AgentBusChannelOpsKt$syncHistory$2(clawChannelAgentBusBinding, str, i10, null), interfaceC4014c);
    }

    public static /* synthetic */ Object M(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 50;
        }
        return L(clawChannelAgentBusBinding, str, i10, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.RemoteChatMessage N(a4.Message r8) {
        /*
            com.stepos.agentbus.generated.Role r0 = r8.getRole()
            java.lang.String r0 = r0.name()
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r4 = r0.toLowerCase(r1)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r4, r0)
            java.util.Map r0 = r8.d()
            java.lang.String[] r1 = com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.MESSAGE_ID_KEYS
            java.lang.String r0 = s(r0, r1)
            if (r0 != 0) goto L64
            java.lang.String r0 = r8.getReplyTo()
            r1 = 0
            if (r0 == 0) goto L45
            int r2 = r0.length()
            if (r2 <= 0) goto L2d
            goto L2e
        L2d:
            r0 = r1
        L2e:
            if (r0 == 0) goto L45
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = "-reply-"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L46
        L45:
            r0 = r1
        L46:
            if (r0 != 0) goto L64
            java.lang.String r0 = r8.getContent()
            int r0 = r0.hashCode()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = "-"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L64:
            r3 = r0
            K6.B r2 = new K6.B
            java.lang.String r5 = r8.getContent()
            java.util.Map r8 = r8.d()
            java.lang.String[] r0 = com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.TIMESTAMP_KEYS
            java.lang.Long r8 = r(r8, r0)
            if (r8 == 0) goto L7d
            long r0 = r8.longValue()
        L7b:
            r6 = r0
            goto L80
        L7d:
            r0 = 0
            goto L7b
        L80:
            r2.<init>(r3, r4, r5, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.N(a4.w):K6.B");
    }

    public static final Object O(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, long j10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return D(clawChannelAgentBusBinding, "files.write_core", kotlin.collections.a.m(Y8.j.a("type", str), Y8.j.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, str2)), j10, interfaceC4014c);
    }

    public static /* synthetic */ Object P(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10000;
        }
        return O(clawChannelAgentBusBinding, str, str2, j10, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r4, java.lang.String r5, long r6, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.agentbus.RegenerateAck> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.e(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, java.lang.String, long, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object f(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 10000;
        }
        return e(clawChannelAgentBusBinding, str, j10, interfaceC4014c);
    }

    public static final boolean g(String str) {
        return str == null || str.length() == 0;
    }

    public static final boolean h(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        return I(message) && !La.H.x0(message.getContent());
    }

    public static final boolean i(String str, String str2, String str3, String str4, boolean z10) {
        String strP = p(str);
        if (strP != null) {
            return kotlin.jvm.internal.p.d(strP, str2);
        }
        if (z10) {
            return true;
        }
        if (str4 == null) {
            return false;
        }
        if (str4.length() <= 0) {
            str4 = null;
        }
        if (str4 == null || str3 == null) {
            return false;
        }
        if (str3.length() <= 0) {
            str3 = null;
        }
        if (str3 == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(str3, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12, e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt.j(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, java.lang.String, java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object k(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, String str3, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i10 & 8) != 0) {
            j10 = PRIVACY_CHECK_TIMEOUT_MS;
        }
        return j(clawChannelAgentBusBinding, str, str2, str4, j10, interfaceC4014c);
    }

    public static final Object l(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return clawChannelAgentBusBinding.getSessions().a(str, 10000L, interfaceC4014c);
    }

    public static final Object m(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, long j10, InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Y.b(), new AgentBusChannelOpsKt$createOpenClawSession$2(str, clawChannelAgentBusBinding, j10, null), interfaceC4014c);
    }

    public static /* synthetic */ Object n(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "main";
        }
        if ((i10 & 2) != 0) {
            j10 = 10000;
        }
        return m(clawChannelAgentBusBinding, str, j10, interfaceC4014c);
    }

    public static final Object o(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return clawChannelAgentBusBinding.getSessions().b(str, 10000L, interfaceC4014c);
    }

    public static final String p(String str) {
        if (str == null || str.length() <= 0 || kotlin.jvm.internal.p.d(str, "null")) {
            return null;
        }
        return str;
    }

    public static final List<HistoryTaskCreateHint> q(Message message) {
        JSONObject jSONObjectB;
        if (message.g().isEmpty()) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (ToolCall toolCall : message.g()) {
            if (La.D.L(toolCall.getName(), TOOL_NAME_TASK_CREATE, true) && (jSONObjectB = B(toolCall.f())) != null) {
                String strOptString = jSONObjectB.optString("taskId");
                kotlin.jvm.internal.p.h(strOptString, "optString(...)");
                String string = La.H.D1(strOptString).toString();
                if (string.length() != 0) {
                    String strOptString2 = jSONObjectB.optString("childSessionKey");
                    kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
                    String string2 = La.H.D1(strOptString2).toString();
                    if (string2.length() == 0) {
                        string2 = null;
                    }
                    String strOptString3 = jSONObjectB.optString("type");
                    kotlin.jvm.internal.p.h(strOptString3, "optString(...)");
                    String string3 = La.H.D1(strOptString3).toString();
                    if (string3.length() == 0) {
                        string3 = null;
                    }
                    String strOptString4 = jSONObjectB.optString("title");
                    kotlin.jvm.internal.p.h(strOptString4, "optString(...)");
                    String string4 = La.H.D1(strOptString4).toString();
                    arrayList.add(new HistoryTaskCreateHint(string, string2, string3, string4.length() != 0 ? string4 : null));
                }
            }
        }
        return arrayList;
    }

    public static final Long r(Map<String, ? extends Object> map, String[] strArr) {
        Long l10;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            l10 = null;
            if (i10 >= length) {
                break;
            }
            Object obj = map.get(strArr[i10]);
            Long lValueOf = obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : obj instanceof String ? La.C.y((String) obj) : null;
            if (lValueOf != null && lValueOf.longValue() > 0) {
                l10 = lValueOf;
            }
            if (l10 != null) {
                break;
            }
            i10++;
        }
        return l10;
    }

    public static final String s(Map<String, ? extends Object> map, String[] strArr) {
        String str;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            str = null;
            if (i10 >= length) {
                break;
            }
            Object obj = map.get(strArr[i10]);
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 != null && str2.length() > 0) {
                str = str2;
            }
            if (str != null) {
                break;
            }
            i10++;
        }
        return str;
    }

    public static final boolean t(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        List<ToolCall> listG = message.g();
        if ((listG instanceof Collection) && listG.isEmpty()) {
            return false;
        }
        for (ToolCall toolCall : listG) {
            if (toolCall.getStatus() == ToolStatus.PENDING || toolCall.getStatus() == ToolStatus.RUNNING) {
                return true;
            }
        }
        return false;
    }

    public static final boolean u(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (message.getRole() != Role.ASSISTANT || v(message) || message.d().get("stream") != null || message.d().get("approval") != null) {
            return false;
        }
        q qVar = q.INSTANCE;
        if (qVar.t(message) || qVar.q(message) || qVar.r(message) || message.getContent().length() > 0) {
            return false;
        }
        String delta = message.getDelta();
        return (delta == null || delta.length() == 0) && message.g().isEmpty() && message.a().isEmpty();
    }

    public static final boolean v(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (q.INSTANCE.r(message) || kotlin.jvm.internal.p.d(message.d().get("streaming"), Boolean.TRUE)) {
            return false;
        }
        return !t(message);
    }

    public static final boolean w(String event, Map<String, ? extends Object> payload) {
        kotlin.jvm.internal.p.i(event, "event");
        kotlin.jvm.internal.p.i(payload, "payload");
        if (!kotlin.jvm.internal.p.d(event, "agent") || !kotlin.jvm.internal.p.d(payload.get("stream"), "lifecycle")) {
            return false;
        }
        Object obj = payload.get("data");
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(map.get("lifecyclePhase"), "turn_done");
    }

    public static final Object x(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, long j10, InterfaceC4014c<? super String> interfaceC4014c) {
        return E(clawChannelAgentBusBinding, "files.read_core", Q.f(Y8.j.a("type", str)), j10, interfaceC4014c);
    }

    public static /* synthetic */ Object y(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 10000;
        }
        return x(clawChannelAgentBusBinding, str, j10, interfaceC4014c);
    }

    public static final Object z(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return clawChannelAgentBusBinding.getSessions().c(str, str2, 10000L, interfaceC4014c);
    }
}
