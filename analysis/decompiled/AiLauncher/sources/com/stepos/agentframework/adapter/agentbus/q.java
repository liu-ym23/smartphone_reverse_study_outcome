package com.stepos.agentframework.adapter.agentbus;

import Z8.C1172u;
import Z8.C1173v;
import Z8.Q;
import a4.Message;
import a4.ToolCall;
import android.app.KeyguardManager;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentbus.generated.Role;
import com.stepos.agentbus.generated.ToolStatus;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.FunctionCall;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.AbstractC0913i;
import kotlin.C0914j;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001b\u001a\u00020\u0011*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001d\u001a\u00020\u0011*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ)\u0010\u001f\u001a\u00020\u001e*\u00020\u001e2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J9\u0010!\u001a\u00020\u0011*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u001b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u0007*\u00020\u0018H\u0002¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b)\u0010*J9\u0010+\u001a\u00020\u0011*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b+\u0010\u001cJ\u001b\u0010-\u001a\u00020\u001e*\u00020\u00182\u0006\u0010,\u001a\u00020\u0014H\u0002¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020\u0014*\u00020\rH\u0002¢\u0006\u0004\b/\u00100J%\u00101\u001a\u0004\u0018\u00010\u0011*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u00020\r*\u00020\u0004¢\u0006\u0004\b3\u00104J9\u00108\u001a\b\u0012\u0004\u0012\u00020\u001107*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u00106\u001a\u0002052\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u0004\u0018\u00010\u0007*\u00020\r¢\u0006\u0004\b:\u0010;J\u0011\u0010<\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b<\u00100J\u0011\u0010=\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b=\u00100J\u0011\u0010>\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b>\u00100J\u0011\u0010?\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b?\u00100J\u0011\u0010@\u001a\u00020\u0014*\u00020\r¢\u0006\u0004\b@\u00100J!\u0010A\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\bA\u00102J!\u0010B\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\bB\u00102J\u0013\u0010C\u001a\u0004\u0018\u00010\r*\u00020\u0004¢\u0006\u0004\bC\u00104R\u0014\u0010D\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\bF\u0010ER\u0014\u0010G\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010H\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\bH\u0010ER\u0014\u0010I\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\bI\u0010ER\u0014\u0010J\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\bJ\u0010ER\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\fR\u0014\u0010R\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010E¨\u0006S"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/q;", "", "<init>", "()V", "LK6/n;", "chatInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LK6/n;)Ljava/util/HashMap;", "o", "()Ljava/lang/String;", "La4/w;", "request", "sessionId", "requestId", "LK6/m;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(La4/w;LK6/n;Ljava/lang/String;Ljava/lang/String;)LK6/m;", "", "textCanFinish", "G", "(La4/w;LK6/n;Ljava/lang/String;Z)LK6/m;", "La4/E;", "", "metadata", "K", "(La4/E;LK6/n;Ljava/lang/String;Ljava/util/Map;)LK6/m;", "J", "Lcom/stepos/common/FunctionCall;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/common/FunctionCall;Ljava/util/Map;)Lcom/stepos/common/FunctionCall;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "", "m", "(Ljava/lang/Object;)Ljava/lang/Integer;", "v", "(La4/E;)Ljava/lang/String;", "", "l", "(Ljava/lang/Object;)Ljava/lang/Long;", "L", "includeResult", "D", "(La4/E;Z)Lcom/stepos/common/FunctionCall;", "p", "(La4/w;)Z", ExifInterface.LONGITUDE_EAST, "(La4/w;LK6/n;Ljava/lang/String;)LK6/m;", "w", "(LK6/n;)La4/w;", "Lcom/stepos/agentframework/adapter/agentbus/N;", "toolTracker", "", "y", "(La4/w;LK6/n;Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/N;Z)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(La4/w;)Ljava/lang/String;", "r", "s", "u", "t", "q", "x", "F", "H", "APPROVAL_REQUIRED", "Ljava/lang/String;", "EXTRA_RAW_DELTA", "EXTRA_DISCONNECT_REASON", "EXTRA_TOOL_UPDATE", "EXTRA_TOOL_UPDATE_PERCENT", "EXTRA_TOOL_UPDATE_DURATION", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "appVersionName$delegate", "LY8/h;", "n", "appVersionName", "PRIVACY_BLOCKED_PRESET_TEXT", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class q {
    private static final String APPROVAL_REQUIRED = "required";
    public static final String EXTRA_DISCONNECT_REASON = "disconnectReason";
    public static final String EXTRA_RAW_DELTA = "__rawDelta";
    public static final String EXTRA_TOOL_UPDATE = "__toolUpdate";
    public static final String EXTRA_TOOL_UPDATE_DURATION = "__toolUpdateDuration";
    public static final String EXTRA_TOOL_UPDATE_PERCENT = "__toolUpdatePercent";
    public static final String PRIVACY_BLOCKED_PRESET_TEXT = "抱歉，换个问题试试吧";
    public static final q INSTANCE = new q();
    private static final Gson gson = new Gson();

    /* renamed from: appVersionName$delegate, reason: from kotlin metadata */
    private static final Y8.h appVersionName = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return q.f();
        }
    });

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolStatus.values().length];
            try {
                iArr[ToolStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolStatus.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolStatus.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String B(String str) {
        String string;
        if (str == null || (string = La.H.D1(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static final String C(String str) {
        String string;
        if (str == null || (string = La.H.D1(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public static final CharSequence I(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        Object key = entry.getKey();
        kotlin.jvm.internal.p.h(key, "component1(...)");
        Object value = entry.getValue();
        kotlin.jvm.internal.p.h(value, "component2(...)");
        return ((String) key) + "=" + gson.toJson(value);
    }

    public static final String f() {
        J7.a aVar = J7.a.f3739a;
        Context contextB = O6.a.INSTANCE.b();
        kotlin.jvm.internal.p.f(contextB);
        return aVar.b(contextB);
    }

    public static final String k(Object obj) {
        String string;
        String string2;
        if (obj == null || (string = obj.toString()) == null || (string2 = La.H.D1(string).toString()) == null || string2.length() <= 0) {
            return null;
        }
        return string2;
    }

    public static /* synthetic */ List z(q qVar, Message message, C0918n c0918n, String str, N n10, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = AgentBusChannelOpsKt.v(message) && (!AgentBusChannelOpsKt.I(message) || AgentBusChannelOpsKt.h(message));
        }
        return qVar.y(message, c0918n, str, n10, z10);
    }

    public final C0917m A(Message message, C0918n c0918n, String str, String str2) {
        String string;
        String string2;
        String string3;
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        if (obj == null) {
            obj = message.d().get("run_id");
        }
        if (obj == null || (string3 = obj.toString()) == null || (string = La.H.D1(string3).toString()) == null || string.length() <= 0) {
            string = null;
        }
        String replyTo = message.getReplyTo();
        Object obj2 = message.d().get("messageId");
        String string4 = obj2 != null ? obj2.toString() : null;
        Object obj3 = message.d().get(RequestParameter.META_KEY_MESSAGE_ID);
        String str3 = (String) SequencesKt___SequencesKt.J(SequencesKt___SequencesKt.S(Ka.t.w(string, replyTo, string4, obj3 != null ? obj3.toString() : null, str2), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj4) {
                return q.B((String) obj4);
            }
        }));
        Object obj4 = message.d().get("agentId");
        String string5 = obj4 != null ? obj4.toString() : null;
        Object obj5 = message.d().get("agent");
        String str4 = (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(Ka.t.w(string5, obj5 != null ? obj5.toString() : null, c0918n.getAgentId()), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj6) {
                return q.C((String) obj6);
            }
        }));
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        String secretkey = c0918n.getSecretkey();
        List listE = C1172u.e(new AbstractC0913i.Text(La.H.D1(message.getContent()).toString()));
        String replyTo2 = message.getReplyTo();
        String traceId = c0918n.getTraceId();
        if (traceId == null) {
            Object obj6 = message.d().get(DidiCardProvider.KEY_TRACE_ID);
            string2 = obj6 != null ? obj6.toString() : null;
        } else {
            string2 = traceId;
        }
        Map mapC = Q.c();
        mapC.put(kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID, str2);
        if (string != null) {
            mapC.put(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, string);
        }
        return new C0917m(listE, null, str, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, str5, secretkey, null, 5, false, null, 0, null, 0, null, 0, null, null, null, null, null, str3, replyTo2, null, "answer", null, null, null, null, null, string2, null, null, null, null, null, null, -1619222598, 8126, null);
    }

    public final FunctionCall D(ToolCall toolCall, boolean z10) {
        Map<String, Object> mapF;
        if (!z10) {
            mapF = null;
        } else if (toolCall.f() != null) {
            mapF = toolCall.f();
        } else if (toolCall.getStatus() == ToolStatus.ERROR) {
            Pair pairA = Y8.j.a("error", Boolean.TRUE);
            String errorMessage = toolCall.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "tool error";
            }
            mapF = kotlin.collections.a.m(pairA, Y8.j.a("errorMessage", errorMessage));
        } else {
            mapF = Q.f(Y8.j.a("ok", Boolean.TRUE));
        }
        return new FunctionCall(null, toolCall.getName(), toolCall.a(), toolCall.getName(), null, null, null, null, null, null, toolCall.getId(), mapF != null ? gson.toJson(mapF) : null, false, null, 13297, null);
    }

    public final C0917m E(Message message, C0918n c0918n, String str) {
        String str2;
        String str3;
        Object obj = message.d().get("decision");
        String str4 = obj instanceof String ? (String) obj : null;
        if (str4 == null || str4.length() == 0) {
            return null;
        }
        Object obj2 = message.d().get("presetText");
        String str5 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = message.d().get("reason");
        String str6 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = message.d().get("riskLevel");
        String str7 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = message.d().get("toast");
        String str8 = obj5 instanceof String ? (String) obj5 : null;
        StringBuilder sb2 = new StringBuilder();
        if (str5 == null) {
            str5 = "内容已被审核拦截";
        }
        sb2.append(str5);
        if (str6 != null) {
            sb2.append(" (" + str6 + ")");
        }
        if (str7 != null) {
            sb2.append(" [风险等级: " + str7 + "]");
        }
        String string = sb2.toString();
        Object obj6 = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String replyTo = obj6 instanceof String ? (String) obj6 : null;
        if (replyTo == null || replyTo.length() <= 0) {
            replyTo = null;
        }
        String agentId = c0918n.getAgentId();
        String secretkey = c0918n.getSecretkey();
        List listE = C1172u.e(new AbstractC0913i.Text(string));
        if (replyTo == null && (replyTo = message.getReplyTo()) == null) {
            Object obj7 = message.d().get("messageId");
            if (obj7 instanceof String) {
                replyTo = (String) obj7;
                str2 = replyTo;
            } else {
                str2 = null;
            }
        } else {
            str2 = replyTo;
        }
        String replyTo2 = message.getReplyTo();
        String traceId = c0918n.getTraceId();
        if (traceId == null) {
            Object obj8 = message.d().get(DidiCardProvider.KEY_TRACE_ID);
            if (obj8 instanceof String) {
                traceId = (String) obj8;
                str3 = traceId;
            } else {
                str3 = null;
            }
        } else {
            str3 = traceId;
        }
        Map mapC = Q.c();
        for (Map.Entry<String, Object> entry : message.d().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String string2 = value != null ? value.toString() : null;
            if (string2 == null) {
                string2 = "";
            }
            mapC.put(key, string2);
        }
        if (str8 != null) {
            mapC.put("toast", str8);
        }
        return new C0917m(listE, null, str, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, true, null, 0, null, 0, null, 0, null, null, null, null, null, str2, replyTo2, null, "moderation", null, null, null, null, null, str3, null, null, null, null, null, null, -1619222598, 8126, null);
    }

    public final C0917m F(Message message, C0918n request, String sessionId) {
        String str;
        String str2;
        kotlin.jvm.internal.p.i(message, "<this>");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str3 = obj instanceof String ? (String) obj : null;
        if (str3 == null || str3.length() <= 0) {
            str3 = null;
        }
        String agentId = request.getAgentId();
        String secretkey = request.getSecretkey();
        List listE = C1172u.e(new AbstractC0913i.Text(PRIVACY_BLOCKED_PRESET_TEXT));
        if (str3 == null) {
            String replyTo = message.getReplyTo();
            if (replyTo == null) {
                Object obj2 = message.d().get("messageId");
                if (obj2 instanceof String) {
                    replyTo = (String) obj2;
                    str = replyTo;
                } else {
                    str = null;
                }
            } else {
                str = replyTo;
            }
        } else {
            str = str3;
        }
        String replyTo2 = message.getReplyTo();
        String traceId = request.getTraceId();
        if (traceId == null) {
            Object obj3 = message.d().get(DidiCardProvider.KEY_TRACE_ID);
            str2 = obj3 instanceof String ? (String) obj3 : null;
        } else {
            str2 = traceId;
        }
        Map mapC = Q.c();
        mapC.put("kind", RunBlockedEvent.SCENE_PRIVACY_BLOCKED);
        mapC.put("decision", "block");
        mapC.put("presetText", PRIVACY_BLOCKED_PRESET_TEXT);
        mapC.put(com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED, "true");
        if (str3 != null) {
            mapC.put(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, str3);
        }
        return new C0917m(listE, null, sessionId, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, true, null, 0, null, 0, null, 0, null, null, null, null, null, str, replyTo2, null, "moderation", null, null, null, null, null, str2, null, null, null, null, null, null, -1619222598, 8126, null);
    }

    public final C0917m G(Message message, C0918n c0918n, String str, boolean z10) {
        String str2;
        String str3;
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str4 = obj instanceof String ? (String) obj : null;
        Object obj2 = message.d().get("streaming");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Object obj3 = message.d().get("livenessState");
        String str5 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = message.d().get("lifecyclePhase");
        String str6 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = message.d().get("error");
        String strA = C1833i.INSTANCE.a(zBooleanValue, str5, str6, obj5 instanceof String ? (String) obj5 : null);
        String agentId = c0918n.getAgentId();
        String secretkey = c0918n.getSecretkey();
        List listE = C1172u.e(new AbstractC0913i.Text(message.getContent()));
        boolean z11 = !zBooleanValue && z10;
        if (str4 == null) {
            String replyTo = message.getReplyTo();
            if (replyTo == null) {
                Object obj6 = message.d().get("messageId");
                if (obj6 instanceof String) {
                    replyTo = (String) obj6;
                    str2 = replyTo;
                } else {
                    str2 = null;
                }
            } else {
                str2 = replyTo;
            }
        } else {
            str2 = str4;
        }
        String replyTo2 = message.getReplyTo();
        String traceId = c0918n.getTraceId();
        if (traceId == null) {
            Object obj7 = message.d().get(DidiCardProvider.KEY_TRACE_ID);
            if (obj7 instanceof String) {
                traceId = (String) obj7;
                str3 = traceId;
            } else {
                str3 = null;
            }
        } else {
            str3 = traceId;
        }
        Map mapC = Q.c();
        if (str4 != null) {
        }
        if (strA != null) {
        }
        String delta = message.getDelta();
        if (delta != null) {
            String str7 = delta.length() > 0 ? delta : null;
            if (str7 != null) {
                mapC.put(EXTRA_RAW_DELTA, str7);
            }
        }
        return new C0917m(listE, null, str, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, z11, null, 0, null, 0, null, 0, null, null, null, null, null, str2, replyTo2, null, "answer", null, null, null, null, null, str3, null, null, null, null, null, null, -1619222598, 8126, null);
    }

    public final Message H(C0918n c0918n) {
        kotlin.jvm.internal.p.i(c0918n, "<this>");
        HashMap<String, Object> mapS = c0918n.s();
        if (mapS == null) {
            return null;
        }
        Set<Map.Entry<String, Object>> setEntrySet = mapS.entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
        return new Message(Role.TOOL, Z8.F.A0(setEntrySet, "\n", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return q.I((Map.Entry) obj);
            }
        }, 30, null), null, null, null, Q.f(Y8.j.a("toolOutputs", mapS)), null, 92, null);
    }

    public final C0917m J(ToolCall toolCall, C0918n c0918n, String str, Map<String, ? extends Object> map) {
        C0917m c0917mH = h(toolCall, c0918n, str, map);
        c0917mH.O(0);
        c0917mH.L("tool_response");
        q qVar = INSTANCE;
        c0917mH.R(qVar.g(qVar.D(toolCall, true), map));
        c0917mH.Q(false);
        c0917mH.S(toolCall.getId());
        c0917mH.T(toolCall.getId());
        return c0917mH;
    }

    public final C0917m K(ToolCall toolCall, C0918n c0918n, String str, Map<String, ? extends Object> map) {
        C0917m c0917mH = h(toolCall, c0918n, str, map);
        c0917mH.O(0);
        c0917mH.L("function_call");
        q qVar = INSTANCE;
        c0917mH.R(qVar.g(qVar.D(toolCall, false), map));
        c0917mH.Q(false);
        c0917mH.S(toolCall.getId());
        c0917mH.T(toolCall.getId());
        return c0917mH;
    }

    public final C0917m L(ToolCall toolCall, C0918n c0918n, String str, Map<String, ? extends Object> map) {
        C0917m c0917mH = h(toolCall, c0918n, str, map);
        c0917mH.O(0);
        c0917mH.L("function_call");
        q qVar = INSTANCE;
        String id = toolCall.getId();
        c0917mH.R(qVar.g(new FunctionCall(null, toolCall.getName(), toolCall.a(), toolCall.getName(), null, null, null, null, null, null, id, null, false, null, 13297, null), map));
        c0917mH.Q(false);
        c0917mH.S(toolCall.getId());
        c0917mH.T(toolCall.getId());
        return c0917mH;
    }

    public final FunctionCall g(FunctionCall functionCall, Map<String, ? extends Object> map) {
        boolean zBooleanValue;
        String string;
        Object obj = map.get("stepclaw");
        String str = null;
        Map map2 = obj instanceof Map ? (Map) obj : null;
        if (map2 == null) {
            return functionCall;
        }
        Object obj2 = map2.get("hidden");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Object obj3 = map2.get("hidden");
            Boolean boolValueOf = (obj3 == null || (string = obj3.toString()) == null) ? null : Boolean.valueOf(Boolean.parseBoolean(string));
            zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : false;
        }
        functionCall.setHidden(zBooleanValue);
        Object obj4 = map2.get("displayName");
        String str2 = obj4 instanceof String ? (String) obj4 : null;
        if (str2 != null && !La.H.x0(str2)) {
            str = str2;
        }
        functionCall.setDisplayName(str);
        return functionCall;
    }

    public final C0917m h(ToolCall toolCall, C0918n c0918n, String str, Map<String, ? extends Object> map) {
        String str2;
        String agentId = c0918n.getAgentId();
        String secretkey = c0918n.getSecretkey();
        List listM = C1173v.m();
        String traceId = c0918n.getTraceId();
        if (traceId == null) {
            Object obj = map.get(DidiCardProvider.KEY_TRACE_ID);
            if (obj instanceof String) {
                traceId = (String) obj;
                str2 = traceId;
            } else {
                str2 = null;
            }
        } else {
            str2 = traceId;
        }
        Map mapC = Q.c();
        Object obj2 = map.get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        if (str3 != null) {
            String str4 = str3.length() > 0 ? str3 : null;
            if (str4 != null) {
            }
        }
        Map<String, Object> mapH = toolCall.h();
        if (mapH != null) {
            String json = gson.toJson(mapH);
            kotlin.jvm.internal.p.h(json, "toJson(...)");
            mapC.put(EXTRA_TOOL_UPDATE, json);
            q qVar = INSTANCE;
            Integer numM = qVar.m(mapH);
            if (numM != null) {
            }
            Long l10 = qVar.l(mapH);
            if (l10 != null) {
                mapC.put(EXTRA_TOOL_UPDATE_DURATION, String.valueOf(l10.longValue()));
            }
        }
        return new C0917m(listM, null, str, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str2, null, null, null, null, null, null, -90182, 8127, null);
    }

    public final HashMap<String, String> i(C0918n chatInfo) {
        String str;
        String str2;
        String str3;
        HashMap<String, String> map = new HashMap<>();
        map.put("device_model", J7.a.f3739a.d());
        map.put(Parameters.OS_VERSION, O6.p.INSTANCE.e());
        map.put("app_version", n());
        map.put("trace_id", chatInfo.getTraceId());
        map.put(Parameters.DEVICE_ID, J7.c.b());
        O6.h hVarA = O6.a.INSTANCE.a();
        map.put("user_id", hVarA != null ? hVarA.a() : null);
        map.put("session_id", chatInfo.getConversationId());
        map.put("msg_id", chatInfo.getMessageId());
        map.put("screenLockState", o());
        Map<String, String> mapO = chatInfo.o();
        if (mapO != null && (str3 = mapO.get(RequestParameter.META_KEY_MSG_SOURCE)) != null) {
            if (str3.length() <= 0) {
                str3 = null;
            }
            if (str3 != null) {
                map.put(RequestParameter.META_KEY_MSG_SOURCE, str3);
            }
        }
        Map<String, String> mapO2 = chatInfo.o();
        if (mapO2 != null && (str2 = mapO2.get(RequestParameter.META_KEY_ACTIVE_FILE_ID)) != null) {
            if (str2.length() <= 0) {
                str2 = null;
            }
            if (str2 != null) {
                map.put(RequestParameter.META_KEY_ACTIVE_FILE_ID, str2);
            }
        }
        Map<String, String> mapO3 = chatInfo.o();
        if (mapO3 != null && (str = mapO3.get(RequestParameter.META_KEY_ACTIVE_FILE_PATH)) != null) {
            String str4 = str.length() > 0 ? str : null;
            if (str4 != null) {
                map.put(RequestParameter.META_KEY_ACTIVE_FILE_PATH, str4);
            }
        }
        return map;
    }

    public final String j(Message message) {
        String string;
        kotlin.jvm.internal.p.i(message, "<this>");
        if (message.getRole() != Role.ASSISTANT) {
            return null;
        }
        Object obj = message.d().get("approval");
        if (La.D.L((obj == null || (string = obj.toString()) == null) ? null : La.H.D1(string).toString(), APPROVAL_REQUIRED, true)) {
            return (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(Ka.t.w(message.d().get("requestId"), message.d().get("request_id")), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return q.k(obj2);
                }
            }));
        }
        return null;
    }

    public final Long l(Object update) {
        Map map = update instanceof Map ? (Map) update : null;
        if (map == null) {
            return null;
        }
        Object obj = map.get("transition");
        Map map2 = obj instanceof Map ? (Map) obj : null;
        if (map2 == null) {
            return null;
        }
        Object obj2 = map2.get("target");
        if (!kotlin.jvm.internal.p.d(obj2 instanceof String ? (String) obj2 : null, "percent")) {
            return null;
        }
        Object obj3 = map2.get("durationMs");
        Number number = obj3 instanceof Number ? (Number) obj3 : null;
        if (number != null) {
            Long lValueOf = Long.valueOf(number.longValue());
            if (lValueOf.longValue() > 0) {
                return lValueOf;
            }
        }
        return null;
    }

    public final Integer m(Object update) {
        Map map = update instanceof Map ? (Map) update : null;
        if (map == null) {
            return null;
        }
        Object obj = map.get("transition");
        Map map2 = obj instanceof Map ? (Map) obj : null;
        if (map2 == null) {
            return null;
        }
        Object obj2 = map2.get("target");
        if (!kotlin.jvm.internal.p.d(obj2 instanceof String ? (String) obj2 : null, "percent")) {
            return null;
        }
        Object obj3 = map2.get(UxipConstants.f30680s);
        Number number = obj3 instanceof Number ? (Number) obj3 : null;
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }

    public final String n() {
        return (String) appVersionName.getValue();
    }

    public final String o() {
        Context contextB = O6.a.INSTANCE.b();
        if (contextB == null) {
            return "0";
        }
        Object systemService = contextB.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return (keyguardManager == null || keyguardManager.isKeyguardLocked()) ? "0" : "1";
    }

    public final boolean p(Message message) {
        return message.getContent().length() == 0 && message.d().get("stream") != null;
    }

    public final boolean q(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (!kotlin.jvm.internal.p.d(message.d().get("lifecyclePhase"), "error")) {
            return false;
        }
        Object obj = message.d().get("disconnectReason");
        String str = obj instanceof String ? (String) obj : null;
        return str != null && str.length() > 0;
    }

    public final boolean r(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        return j(message) != null;
    }

    public final boolean s(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (!p(message)) {
            return false;
        }
        Object obj = message.d().get("stream");
        return kotlin.jvm.internal.p.d(obj instanceof String ? (String) obj : null, "moderation");
    }

    public final boolean t(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        Object obj = message.d().get("_privacyBlocked");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return La.D.L((String) obj, "true", true);
        }
        return false;
    }

    public final boolean u(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (!p(message)) {
            return false;
        }
        Object obj = message.d().get("stream");
        return kotlin.jvm.internal.p.d(obj instanceof String ? (String) obj : null, com.stepos.agentframework.adapter.netcore.x.STREAM);
    }

    public final String v(ToolCall toolCall) {
        Integer numM = m(toolCall.h());
        Long l10 = l(toolCall.h());
        Map<String, Object> mapH = toolCall.h();
        Object obj = null;
        if (!(mapH instanceof Map)) {
            mapH = null;
        }
        Object obj2 = mapH != null ? mapH.get("type") : null;
        Map<String, Object> mapH2 = toolCall.h();
        if (!(mapH2 instanceof Map)) {
            mapH2 = null;
        }
        if (mapH2 != null) {
            Object obj3 = mapH2.get("transition");
            Map map = obj3 instanceof Map ? (Map) obj3 : null;
            if (map != null) {
                obj = map.get(UxipConstants.f30680s);
            }
        }
        return numM + "|" + l10 + "|" + obj2 + "|" + obj;
    }

    public final Message w(C0918n c0918n) {
        kotlin.jvm.internal.p.i(c0918n, "<this>");
        String strB = C0914j.b(c0918n.j());
        if (strB == null) {
            strB = "";
        }
        String str = strB;
        HashMap<String, String> mapI = i(c0918n);
        Role role = Role.USER;
        Map mapC = Q.c();
        String traceId = c0918n.getTraceId();
        if (traceId != null) {
            if (traceId.length() <= 0) {
                traceId = null;
            }
            if (traceId != null) {
                mapC.put(DidiCardProvider.KEY_TRACE_ID, traceId);
            }
        }
        mapC.put("agentId", c0918n.getAgentId());
        String messageId = c0918n.getMessageId();
        if (messageId != null) {
            String str2 = messageId.length() > 0 ? messageId : null;
            if (str2 != null) {
                mapI.put("channelMessageId", str2);
            }
        }
        mapC.put("stepclaw", mapI);
        Y8.t tVar = Y8.t.f7040a;
        return new Message(role, str, null, null, null, Q.b(mapC), null, 92, null);
    }

    public final C0917m x(Message message, C0918n request, String sessionId) {
        String str;
        String str2;
        kotlin.jvm.internal.p.i(message, "<this>");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        String replyTo = obj instanceof String ? (String) obj : null;
        Object obj2 = message.d().get("disconnectReason");
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        if (str3 == null) {
            str3 = "";
        }
        if (str3.length() == 0) {
            str3 = "upstream_offline_timeout";
        }
        String agentId = request.getAgentId();
        String secretkey = request.getSecretkey();
        List listM = C1173v.m();
        if (replyTo == null && (replyTo = message.getReplyTo()) == null) {
            Object obj3 = message.d().get("messageId");
            if (obj3 instanceof String) {
                replyTo = (String) obj3;
                str = replyTo;
            } else {
                str = null;
            }
        } else {
            str = replyTo;
        }
        String replyTo2 = message.getReplyTo();
        String traceId = request.getTraceId();
        if (traceId == null) {
            Object obj4 = message.d().get(DidiCardProvider.KEY_TRACE_ID);
            str2 = obj4 instanceof String ? (String) obj4 : null;
        } else {
            str2 = traceId;
        }
        return new C0917m(listM, null, sessionId, null, 0, false, Q.f(Y8.j.a("disconnectReason", str3)), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, true, null, 0, null, 0, null, 0, null, null, null, null, null, str, replyTo2, null, "answer", null, null, null, null, null, str2, null, null, null, null, null, null, -1619222598, 8126, null);
    }

    public final List<C0917m> y(Message message, C0918n request, String sessionId, N toolTracker, boolean z10) {
        kotlin.jvm.internal.p.i(message, "<this>");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(toolTracker, "toolTracker");
        String strJ = j(message);
        if (strJ != null) {
            return C1172u.e(INSTANCE.A(message, request, sessionId, strJ));
        }
        if (p(message)) {
            Object obj = message.d().get("stream");
            String str = obj instanceof String ? (String) obj : null;
            return kotlin.jvm.internal.p.d(str, "moderation") ? C1173v.q(E(message, request, sessionId)) : kotlin.jvm.internal.p.d(str, com.stepos.agentframework.adapter.netcore.x.STREAM) ? C1173v.m() : C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Object obj2 = message.d().get("streaming");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        String delta = message.getDelta();
        boolean z11 = delta == null || delta.length() == 0;
        if (!q(message) && (message.getContent().length() > 0 || (zBooleanValue && !z11))) {
            arrayList.add(G(message, request, sessionId, z10));
        }
        for (ToolCall toolCall : message.g()) {
            int i10 = a.$EnumSwitchMapping$0[toolCall.getStatus().ordinal()];
            if (i10 == 1) {
                if (toolTracker.c(toolCall.getId())) {
                    arrayList.add(INSTANCE.K(toolCall, request, sessionId, message.d()));
                }
                if (toolCall.f() != null && toolTracker.b(toolCall.getId())) {
                    arrayList.add(INSTANCE.J(toolCall, request, sessionId, message.d()));
                }
            } else if (i10 == 2 || i10 == 3) {
                if (toolTracker.c(toolCall.getId())) {
                    arrayList.add(INSTANCE.K(toolCall, request, sessionId, message.d()));
                }
                if (toolCall.f() != null && toolTracker.b(toolCall.getId())) {
                    arrayList.add(INSTANCE.J(toolCall, request, sessionId, message.d()));
                }
            } else if (i10 == 4) {
                if (toolCall.h() != null) {
                    if (toolTracker.c(toolCall.getId())) {
                        arrayList.add(INSTANCE.K(toolCall, request, sessionId, message.d()));
                    }
                    q qVar = INSTANCE;
                    if (toolTracker.a(toolCall.getId(), qVar.v(toolCall))) {
                        arrayList.add(qVar.L(toolCall, request, sessionId, message.d()));
                        M6.c.INSTANCE.t(qVar.m(toolCall.h()));
                    } else {
                        M6.c.INSTANCE.s();
                    }
                }
                if (toolCall.f() != null && toolTracker.b(toolCall.getId())) {
                    arrayList.add(INSTANCE.J(toolCall, request, sessionId, message.d()));
                }
            }
        }
        return arrayList;
    }
}
