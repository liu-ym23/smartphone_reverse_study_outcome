package com.stepos.agentframework.chatcore.session;

import Ua.C1062j;
import Z8.C1173v;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.audit.RecentModerationKeySet;
import com.stepos.agentframework.chatcore.audit.RevertedSessionGuard;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.FunctionCall;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.AskUserConversation;
import kotlin.C0917m;
import kotlin.C4848b;
import kotlin.Function2;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s4.C5443d;
import u4.AgentMessage;
import u4.AgentResponse;
import u4.m;
import v9.C5685n;
import w4.ChatMessage;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J'\u0010#\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004H\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010-J\u001f\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u0002042\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u00106J)\u00108\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010=J'\u0010>\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010+J-\u0010?\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b?\u0010@J7\u0010B\u001a\u0002042\u0006\u00100\u001a\u00020/2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010CJ=\u0010D\u001a\u0002042\u0006\u00100\u001a\u00020/2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010A\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020/2\u0006\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010GJ!\u0010L\u001a\u0004\u0018\u00010\u00102\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ/\u0010N\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004H\u0002¢\u0006\u0004\bN\u0010OJ'\u0010S\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u001fH\u0002¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0005¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0005¢\u0006\u0004\bX\u0010WJ\r\u0010Y\u001a\u00020\u0014¢\u0006\u0004\bY\u0010\u0003J\u0017\u0010[\u001a\u0002042\u0006\u0010Z\u001a\u00020\bH\u0000¢\u0006\u0004\b[\u00106J\u001d\u0010]\u001a\u0002042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\b¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u0014¢\u0006\u0004\b_\u0010\u0003J\u001f\u0010a\u001a\u0004\u0018\u00010\u00102\u0006\u0010`\u001a\u0002042\u0006\u0010I\u001a\u00020H¢\u0006\u0004\ba\u0010bJ\u001d\u0010c\u001a\u00020\u00142\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bc\u0010dJ\u001d\u0010e\u001a\u00020\u00142\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\be\u0010dJ\u0015\u0010f\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\bf\u0010gJ\u0015\u0010h\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\bh\u0010-J5\u0010m\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u0010l\u001a\u00020k¢\u0006\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020;8\u0002X\u0082T¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020k8\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010LR\u001b\u0010y\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010v\u001a\u0004\b|\u0010}R\u001f\u0010\u0083\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0080\u0001\u0010v\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R^\u0010\u0087\u0001\u001aI\u0012\r\u0012\u000b \u0085\u0001*\u0004\u0018\u00010\u00050\u0005\u0012\r\u0012\u000b \u0085\u0001*\u0004\u0018\u00010k0k \u0085\u0001*#\u0012\r\u0012\u000b \u0085\u0001*\u0004\u0018\u00010\u00050\u0005\u0012\r\u0012\u000b \u0085\u0001*\u0004\u0018\u00010k0k\u0018\u00010\u0086\u00010\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008e\u0001R\u0018\u0010\u0090\u0001\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010LR\u0018\u0010\u0091\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010pR*\u0010\u0093\u0001\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/PushMessageCenter;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "z", "()Ljava/util/List;", "", "K", "()Ljava/lang/String;", "sessionId", "h0", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lw4/c;", "target", "Lu4/d;", UxipConstants.f30685x, "agentId", DidiCardProvider.KEY_TRACE_ID, "LY8/t;", "i0", "(Lw4/c;Lu4/d;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lu4/a;", "part", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "incoming", "Z", "(Lu4/a;Ljava/util/List;)V", "message", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "f0", "(Lw4/c;)Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "titleHint", "O", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "tools", "l0", "(Ljava/util/List;)Ljava/lang/String;", "existing", "contentText", "G", "(Lw4/c;Lu4/d;Ljava/lang/String;)V", "N", "(Lw4/c;)V", "M", "Lw4/l;", "link", "reason", "e0", "(Lw4/l;Ljava/lang/String;)V", "", "X", "(Ljava/lang/String;)Z", "taskId", "Q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lw4/c;", "card", "", "j0", "(Lw4/c;)I", "D", ExifInterface.LONGITUDE_EAST, "(Lw4/c;Lu4/d;Ljava/util/List;)V", "resolvedAgentId", "B", "(Lw4/l;Lu4/d;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "C", "(Lw4/l;Lu4/d;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Z", "P", "(Lw4/l;Ljava/lang/String;)Lw4/c;", "LK6/m;", "chatReplyInfo", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "apiType", "J", "(LK6/m;Lcom/stepos/agentframework/adapter/netcore/ApiType;)Lu4/d;", "g0", "(Lu4/d;Ljava/lang/String;Ljava/util/List;)V", "inboundSessionId", "parentSessionId", "status", "Y", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "handler", "d0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "o0", "c0", "idempotencyKey", "H", "outboundId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)Z", "b0", "isToolCall", "m0", "(ZLK6/m;)Lu4/d;", ExifInterface.LONGITUDE_WEST, "(LK6/m;Lcom/stepos/agentframework/adapter/netcore/ApiType;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "F", "(Lw4/c;)Z", "L", "subSessionKey", "requestSessionKey", "", "cardTime", "R", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "TAG", "Ljava/lang/String;", "PUSH_TITLE_MAX_LEN", "I", "CRON_HISTORY_CATCHUP_THROTTLE_MS", "Lx4/f;", "messageRepository$delegate", "LY8/h;", ExifInterface.GPS_DIRECTION_TRUE, "()Lx4/f;", "messageRepository", "Lx4/e;", "conversationTitleRepository$delegate", ExifInterface.LATITUDE_SOUTH, "()Lx4/e;", "conversationTitleRepository", "Lx4/g;", "taskSessionLinkRepository$delegate", "U", "()Lx4/g;", "taskSessionLinkRepository", "", "kotlin.jvm.PlatformType", "", "handlerRegistrationOrder", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicLong;", "nextHandlerRegistrationOrder", "Ljava/util/concurrent/atomic/AtomicLong;", "Lcom/stepos/agentframework/chatcore/audit/RecentModerationKeySet;", "processedModerationKeys", "Lcom/stepos/agentframework/chatcore/audit/RecentModerationKeySet;", "processedPushKeys", "lastCronCatchUpAt", "lastCronCatchUpSid", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingUiActions", "Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushMessageCenter {
    private static final long CRON_HISTORY_CATCHUP_THROTTLE_MS = 30000;
    private static final int PUSH_TITLE_MAX_LEN = 50;
    private static final String TAG = "PushMessageCenter";
    private static volatile long lastCronCatchUpAt;
    public static final PushMessageCenter INSTANCE = new PushMessageCenter();

    /* renamed from: messageRepository$delegate, reason: from kotlin metadata */
    private static final Y8.h messageRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.y0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PushMessageCenter.a0();
        }
    });

    /* renamed from: conversationTitleRepository$delegate, reason: from kotlin metadata */
    private static final Y8.h conversationTitleRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.z0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PushMessageCenter.I();
        }
    });

    /* renamed from: taskSessionLinkRepository$delegate, reason: from kotlin metadata */
    private static final Y8.h taskSessionLinkRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.A0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PushMessageCenter.k0();
        }
    });
    private static final Map<SessionHandler, Long> handlerRegistrationOrder = Collections.synchronizedMap(new WeakHashMap());
    private static final AtomicLong nextHandlerRegistrationOrder = new AtomicLong(0);
    private static final RecentModerationKeySet processedModerationKeys = new RecentModerationKeySet(512);
    private static final RecentModerationKeySet processedPushKeys = new RecentModerationKeySet(512);
    private static volatile String lastCronCatchUpSid = "";
    private static final ConcurrentHashMap<String, List<String>> pendingUiActions = new ConcurrentHashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApiType.values().length];
            try {
                iArr[ApiType.AGENTBUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApiType.OPENCLAW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final x4.d I() {
        return new x4.d();
    }

    public static final x4.v a0() {
        return new x4.v(null, null, null, 7, null);
    }

    public static final x4.x k0() {
        return new x4.x();
    }

    public static final List n0(C0917m chatReplyInfo, AgentResponse agentResponse) {
        kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
        kotlin.jvm.internal.p.i(agentResponse, "agentResponse");
        FunctionCall functionCall = chatReplyInfo.getFunctionCall();
        kotlin.jvm.internal.p.f(functionCall);
        return C1173v.s(ExtKt.w(functionCall, false));
    }

    public final boolean A(String sessionId, String outboundId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        SessionHandler sessionHandlerH0 = h0(sessionId);
        if (sessionHandlerH0 != null) {
            return ((Boolean) C1062j.b(null, new PushMessageCenter$adoptServerInitiatedRound$1(sessionHandlerH0, sessionId, outboundId, null), 1, null)).booleanValue();
        }
        C4148a.u(TAG, "adoptServerInitiatedRound: no SessionHandler sessionId=" + sessionId, false, 4, null);
        return false;
    }

    public final boolean B(TaskSessionLink link, AgentResponse response, String contentText, String resolvedAgentId, String traceId) {
        ChatMessage chatMessageP = P(link, resolvedAgentId);
        if (chatMessageP == null) {
            return false;
        }
        D(chatMessageP, response, contentText);
        T().t(chatMessageP);
        N(chatMessageP);
        C4148a.k(TAG, "sub-session text merged into card taskId:" + link.getTaskId() + " req:" + link.getRequestSessionKey() + " messageId:" + chatMessageP.getMessageId(), false, 4, null);
        return true;
    }

    public final boolean C(TaskSessionLink link, AgentResponse response, List<AgentTool> tools, String resolvedAgentId, String traceId) {
        ChatMessage chatMessageP = P(link, resolvedAgentId);
        if (chatMessageP == null) {
            return false;
        }
        E(chatMessageP, response, tools);
        T().t(chatMessageP);
        N(chatMessageP);
        C4148a.k(TAG, "sub-session toolCall merged into card taskId:" + link.getTaskId() + " req:" + link.getRequestSessionKey() + " messageId:" + chatMessageP.getMessageId(), false, 4, null);
        return true;
    }

    public final void D(ChatMessage card, AgentResponse response, String contentText) {
        int iJ0 = j0(card);
        AgentMessage agentMessage = (AgentMessage) Z8.F.t0(card.i(), iJ0 - 1);
        AgentMessageType type = agentMessage != null ? agentMessage.getType() : null;
        AgentMessageType agentMessageType = AgentMessageType.TEXT;
        if (type != agentMessageType) {
            List<AgentMessage> listI = card.i();
            String deepThinkingText = response.getDeepThinkingText();
            listI.add(iJ0, new AgentMessage(agentMessageType, deepThinkingText == null ? "" : deepThinkingText, new m.TextMessage(contentText, contentText), response.y(), false, false, 48, null));
            return;
        }
        agentMessage.getContent().b(contentText);
        agentMessage.getContent().a(contentText);
        String deepThinkText = agentMessage.getDeepThinkText();
        String deepThinkingText2 = response.getDeepThinkingText();
        agentMessage.j(deepThinkText + (deepThinkingText2 != null ? deepThinkingText2 : ""));
    }

    public final void E(ChatMessage card, AgentResponse response, List<AgentTool> tools) {
        int iJ0 = j0(card);
        AgentMessage agentMessage = (AgentMessage) Z8.F.t0(card.i(), iJ0 - 1);
        AgentMessageType type = agentMessage != null ? agentMessage.getType() : null;
        AgentMessageType agentMessageType = AgentMessageType.TOOL;
        if (type != agentMessageType) {
            List<AgentMessage> listI = card.i();
            String deepThinkingText = response.getDeepThinkingText();
            listI.add(iJ0, new AgentMessage(agentMessageType, deepThinkingText == null ? "" : deepThinkingText, new m.TextMessage("", null), tools, false, true, 16, null));
            return;
        }
        Z(agentMessage, tools);
        String deepThinkText = agentMessage.getDeepThinkText();
        String deepThinkingText2 = response.getDeepThinkingText();
        agentMessage.j(deepThinkText + (deepThinkingText2 != null ? deepThinkingText2 : ""));
        agentMessage.k(true);
    }

    public final boolean F(ChatMessage message) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        kotlin.jvm.internal.p.i(message, "message");
        String messageId = message.getMessageId();
        if (La.H.x0(messageId) || (list = (concurrentHashMap = pendingUiActions).get(messageId)) == null) {
            return false;
        }
        if (list.isEmpty()) {
            concurrentHashMap.remove(messageId);
            List<String> listX = message.x();
            if (listX != null && listX.isEmpty()) {
                return false;
            }
            message.Y(list);
            C4148a.k(TAG, "push uiActions applied on persist messageId:" + messageId + " actions=[]", false, 4, null);
            return true;
        }
        if (message.x() != null) {
            concurrentHashMap.remove(messageId);
            return false;
        }
        concurrentHashMap.remove(messageId);
        message.Y(list);
        C4148a.k(TAG, "push uiActions applied on persist messageId:" + messageId + " actions=" + list, false, 4, null);
        return true;
    }

    public final void G(ChatMessage existing, AgentResponse response, String contentText) {
        int iIntValue;
        Integer next;
        if (response.getType() == AgentMessageType.TEXT && existing.getStatus() == EReplyStatus.TOOL_EXECUTING) {
            Iterator<AgentMessage> it = existing.i().iterator();
            int i10 = 0;
            while (true) {
                iIntValue = -1;
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (it.next().getType() == AgentMessageType.TOOL) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 > 0) {
                Iterator<Integer> it2 = C5685n.p(i10 - 1, 0).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (existing.i().get(next.intValue()).getType() == AgentMessageType.TEXT) {
                            break;
                        }
                    }
                }
                Integer num = next;
                if (num != null) {
                    iIntValue = num.intValue();
                }
            }
            if (iIntValue >= 0) {
                AgentMessage agentMessage = existing.i().get(iIntValue);
                agentMessage.getContent().b(contentText);
                agentMessage.getContent().a(contentText);
                String deepThinkText = agentMessage.getDeepThinkText();
                String deepThinkingText = response.getDeepThinkingText();
                agentMessage.j(deepThinkText + (deepThinkingText != null ? deepThinkingText : ""));
                return;
            }
        }
        AgentMessage agentMessage2 = (AgentMessage) Z8.F.E0(existing.i());
        AgentMessageType type = response.getType();
        AgentMessageType agentMessageType = AgentMessageType.TEXT;
        if (type == agentMessageType) {
            if ((agentMessage2 != null ? agentMessage2.getType() : null) == agentMessageType) {
                agentMessage2.getContent().b(contentText);
                agentMessage2.getContent().a(contentText);
                String deepThinkText2 = agentMessage2.getDeepThinkText();
                String deepThinkingText2 = response.getDeepThinkingText();
                agentMessage2.j(deepThinkText2 + (deepThinkingText2 != null ? deepThinkingText2 : ""));
                return;
            }
        }
        List<AgentMessage> listI = existing.i();
        AgentMessageType type2 = response.getType();
        String deepThinkingText3 = response.getDeepThinkingText();
        listI.add(new AgentMessage(type2, deepThinkingText3 == null ? "" : deepThinkingText3, new m.TextMessage(contentText, contentText), response.y(), false, false, 48, null));
    }

    public final boolean H(String idempotencyKey) {
        kotlin.jvm.internal.p.i(idempotencyKey, "idempotencyKey");
        return processedModerationKeys.b(idempotencyKey);
    }

    public final AgentResponse J(C0917m chatReplyInfo, ApiType apiType) {
        int i10 = a.$EnumSwitchMapping$0[apiType.ordinal()];
        if (i10 == 1) {
            return ExtKt.f(chatReplyInfo);
        }
        if (i10 != 2) {
            return null;
        }
        return m0(false, chatReplyInfo);
    }

    public final String K() {
        O6.h hVarA = O6.a.INSTANCE.a();
        String strA = hVarA != null ? hVarA.a() : null;
        return strA == null ? "" : strA;
    }

    public final void L(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        N(message);
    }

    public final void M(ChatMessage message) {
        Object next;
        List<SessionHandler> listZ = z();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ) {
            if (C1963x.INSTANCE.a(((SessionHandler) obj).getConfiguration().getSessionConfig().getAgentType())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            C4148a.u(TAG, "no SessionHandler for push message sessionId:" + message.getSessionId() + " messageId:" + message.getMessageId(), false, 4, null);
            return;
        }
        if (!processedPushKeys.b(K() + "|" + message.getMessageId() + "|" + message.getStatus())) {
            C4148a.k(TAG, "skip duplicate push dispatch messageId:" + message.getMessageId() + " status:" + message.getStatus(), false, 4, null);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((SessionHandler) obj2).f2(message.getSessionId())) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList2 = arrayList;
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Long l10 = handlerRegistrationOrder.get((SessionHandler) next);
                long jLongValue = l10 != null ? l10.longValue() : Long.MIN_VALUE;
                do {
                    Object next2 = it.next();
                    Long l11 = handlerRegistrationOrder.get((SessionHandler) next2);
                    long jLongValue2 = l11 != null ? l11.longValue() : Long.MIN_VALUE;
                    if (jLongValue < jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        SessionHandler sessionHandler = (SessionHandler) next;
        if (sessionHandler == null) {
            return;
        }
        C4148a.k(TAG, "dispatch push message once sessionId:" + message.getSessionId() + " messageId:" + message.getMessageId() + " handler:" + System.identityHashCode(sessionHandler) + " candidates:" + arrayList.size(), false, 4, null);
        sessionHandler.q1(message);
    }

    public final void N(ChatMessage message) {
        List<SessionHandler> listZ = z();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ) {
            if (C1963x.INSTANCE.a(((SessionHandler) obj).getConfiguration().getSessionConfig().getAgentType())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SessionHandler) it.next()).q1(message);
        }
    }

    public final void O(String agentId, String sessionId, String titleHint) {
        if (sessionId.length() == 0) {
            return;
        }
        if (ConversationSessionIds.INSTANCE.f(sessionId) || X(sessionId)) {
            C4148a.d(TAG, "skip ConversationTitle for internal agent session sessionId:" + sessionId, false, 4, null);
            return;
        }
        if (S().g(sessionId) != null) {
            return;
        }
        if (RevertedSessionGuard.INSTANCE.a(sessionId)) {
            C4148a.k(TAG, "skip ConversationTitle for reverted session sessionId:" + sessionId, false, 4, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(sessionId, ConversationSessionIds.MAIN_SESSION_ID) && agentId.length() > 0 && !com.stepos.agentframework.chatcore.audit.l.INSTANCE.b(agentId)) {
            C4148a.k(TAG, "skip ConversationTitle for main session not established by this uid agentId:" + agentId + " sessionId:" + sessionId, false, 4, null);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = La.H.D1(titleHint).toString();
        String strR1 = string.length() > 0 ? La.K.R1(string, 50) : "新会话";
        S().m(new w4.e(0, sessionId, strR1, agentId, null, jCurrentTimeMillis, jCurrentTimeMillis, 0L, false, ConversationSessionKind.INSTANCE.b(sessionId).getCode(), false, 0, 0, 7185, null));
        C4148a.k(TAG, "push created local ConversationTitle agentId:" + agentId + " sessionId:" + sessionId + " title:" + strR1, false, 4, null);
        List<SessionHandler> listZ = z();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ) {
            if (C1963x.INSTANCE.a(((SessionHandler) obj).getConfiguration().getSessionConfig().getAgentType())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SessionHandler) it.next()).A2();
        }
    }

    public final ChatMessage P(TaskSessionLink link, String resolvedAgentId) {
        ChatMessage chatMessageQ;
        ChatMessage chatMessageQ2 = Q(link.getAgentId(), link.getRequestSessionKey(), link.getTaskId());
        if (chatMessageQ2 != null) {
            return chatMessageQ2;
        }
        if (resolvedAgentId.length() > 0 && !kotlin.jvm.internal.p.d(resolvedAgentId, link.getAgentId()) && (chatMessageQ = Q(resolvedAgentId, link.getRequestSessionKey(), link.getTaskId())) != null) {
            return chatMessageQ;
        }
        C4148a.u(TAG, "card not found taskId:" + link.getTaskId() + " req:" + link.getRequestSessionKey() + " agentId:" + link.getAgentId() + "/" + resolvedAgentId, false, 4, null);
        return null;
    }

    public final ChatMessage Q(String agentId, String sessionId, String taskId) {
        Object obj;
        Iterator<T> it = T().g(sessionId).iterator();
        loop0: while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<AgentMessage> listI = ((ChatMessage) next).i();
            if (!(listI instanceof Collection) || !listI.isEmpty()) {
                for (AgentMessage agentMessage : listI) {
                    if (agentMessage.getType() == AgentMessageType.TASK) {
                        u4.m content = agentMessage.getContent();
                        m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                        if (kotlin.jvm.internal.p.d(taskMessage != null ? taskMessage.getTaskId() : null, taskId)) {
                            obj = next;
                            break loop0;
                        }
                    }
                }
            }
        }
        return (ChatMessage) obj;
    }

    public final void R(String agentId, String subSessionKey, String requestSessionKey, String taskId, long cardTime) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(subSessionKey, "subSessionKey");
        kotlin.jvm.internal.p.i(requestSessionKey, "requestSessionKey");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Function2.c(new PushMessageCenter$foldEarlySubSessionMessages$1(subSessionKey, agentId, requestSessionKey, taskId, null));
    }

    public final x4.e S() {
        return (x4.e) conversationTitleRepository.getValue();
    }

    public final x4.f T() {
        return (x4.f) messageRepository.getValue();
    }

    public final x4.g U() {
        return (x4.g) taskSessionLinkRepository.getValue();
    }

    public final void V(C0917m chatReplyInfo, ApiType apiType) {
        String content;
        kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
        kotlin.jvm.internal.p.i(apiType, "apiType");
        C5443d.c(chatReplyInfo);
        AgentResponse agentResponseJ = J(chatReplyInfo, apiType);
        boolean z10 = agentResponseJ != null && C0.a(agentResponseJ, chatReplyInfo);
        C4148a.d(TAG, "handlePushMessage onResponse: messageId=" + (agentResponseJ != null ? agentResponseJ.getMessageId() : null) + " sessionId=" + (agentResponseJ != null ? agentResponseJ.getSessionId() : null) + " status=" + (agentResponseJ != null ? agentResponseJ.getStatus() : null) + " type=" + (agentResponseJ != null ? agentResponseJ.getType() : null) + " contentLen=" + ((agentResponseJ == null || (content = agentResponseJ.getContent()) == null) ? 0 : content.length()) + " disconnectFinalize=" + z10, false, 4, null);
        Function2.c(new PushMessageCenter$handlePushMessage$1(agentResponseJ, chatReplyInfo, z10, kotlin.jvm.internal.p.d(chatReplyInfo.getRole(), "user") ? AgentRole.USER : AgentRole.ASSISTANT, null));
    }

    public final void W(C0917m chatReplyInfo, ApiType apiType) {
        List<AgentTool> listY;
        List<AgentTool> listY2;
        AgentTool agentTool;
        List<AgentTool> listY3;
        String str;
        Long lY;
        String str2;
        Integer numW;
        List<AgentTool> listY4;
        kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
        kotlin.jvm.internal.p.i(apiType, "apiType");
        C5443d.e(chatReplyInfo);
        AgentResponse agentResponseJ = J(chatReplyInfo, apiType);
        C4148a.d(TAG, "handlePushToolCall onResponse: messageId=" + (agentResponseJ != null ? agentResponseJ.getMessageId() : null) + " sessionId=" + (agentResponseJ != null ? agentResponseJ.getSessionId() : null) + " tools=" + ((agentResponseJ == null || (listY4 = agentResponseJ.y()) == null) ? 0 : listY4.size()) + " status=" + (agentResponseJ != null ? agentResponseJ.getStatus() : null) + " type=" + (agentResponseJ != null ? agentResponseJ.getType() : null), false, 4, null);
        AgentRole agentRole = kotlin.jvm.internal.p.d(chatReplyInfo.getRole(), "user") ? AgentRole.USER : AgentRole.ASSISTANT;
        Map<String, String> mapS = chatReplyInfo.s();
        int iIntValue = (mapS == null || (str2 = mapS.get(com.stepos.agentframework.adapter.agentbus.q.EXTRA_TOOL_UPDATE_PERCENT)) == null || (numW = La.C.w(str2)) == null) ? 0 : numW.intValue();
        Map<String, String> mapS2 = chatReplyInfo.s();
        long jLongValue = (mapS2 == null || (str = mapS2.get(com.stepos.agentframework.adapter.agentbus.q.EXTRA_TOOL_UPDATE_DURATION)) == null || (lY = La.C.y(str)) == null) ? 0L : lY.longValue();
        if (iIntValue > 0) {
            if (agentResponseJ != null && (listY3 = agentResponseJ.y()) != null) {
                for (AgentTool agentTool2 : listY3) {
                    agentTool2.J(iIntValue);
                    agentTool2.I(jLongValue);
                }
            }
            C4148a.d(TAG, "push toolCall progressPercent=" + iIntValue + " durationMs=" + jLongValue + " sessionId=" + (agentResponseJ != null ? agentResponseJ.getSessionId() : null) + " apiName=" + ((agentResponseJ == null || (listY2 = agentResponseJ.y()) == null || (agentTool = (AgentTool) Z8.F.s0(listY2)) == null) ? null : agentTool.getApiName()), false, 4, null);
        }
        Map<String, String> mapS3 = chatReplyInfo.s();
        if ((mapS3 != null ? mapS3.get(com.stepos.agentframework.adapter.agentbus.q.EXTRA_TOOL_UPDATE) : null) != null && agentResponseJ != null && (listY = agentResponseJ.y()) != null) {
            Iterator<T> it = listY.iterator();
            while (it.hasNext()) {
                ((AgentTool) it.next()).N(true);
            }
        }
        Function2.c(new PushMessageCenter$handlePushToolCall$3(agentResponseJ, chatReplyInfo, agentRole, null));
    }

    public final boolean X(String sessionId) {
        return ConversationSessionIds.INSTANCE.h(sessionId) || U().b(sessionId) != null;
    }

    public final void Y(String inboundSessionId, String parentSessionId, EReplyStatus status) {
        Object next;
        if (!ConversationSessionIds.INSTANCE.e(inboundSessionId) || parentSessionId.length() == 0 || kotlin.jvm.internal.p.d(parentSessionId, inboundSessionId)) {
            return;
        }
        if (status == EReplyStatus.COMPLETED || status == EReplyStatus.ERROR || status == EReplyStatus.CANCELED) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!kotlin.jvm.internal.p.d(parentSessionId, lastCronCatchUpSid) || jElapsedRealtime - lastCronCatchUpAt >= 30000) {
                lastCronCatchUpAt = jElapsedRealtime;
                lastCronCatchUpSid = parentSessionId;
                List<SessionHandler> listZ = z();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listZ) {
                    if (C1963x.INSTANCE.a(((SessionHandler) obj).getConfiguration().getSessionConfig().getAgentType())) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((SessionHandler) next).f2(parentSessionId)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                SessionHandler sessionHandler = (SessionHandler) next;
                if (sessionHandler != null) {
                    sessionHandler.e4("cronCatchUp");
                    return;
                }
                C4148a.d(TAG, "cron catch-up skipped (no live handler) parent=" + parentSessionId, false, 4, null);
            }
        }
    }

    public final void Z(AgentMessage part, List<AgentTool> incoming) {
        List<AgentTool> arrayList;
        List<AgentTool> listG = part.g();
        if (listG == null || (arrayList = Z8.F.p1(listG)) == null) {
            arrayList = new ArrayList<>();
        }
        for (AgentTool agentTool : incoming) {
            int i10 = -1;
            if (agentTool.getToolCallId().length() > 0) {
                Iterator<AgentTool> it = arrayList.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (kotlin.jvm.internal.p.d(it.next().getToolCallId(), agentTool.getToolCallId())) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
            }
            q4.j.INSTANCE.g(arrayList, agentTool);
            if (i10 >= 0) {
                com.stepos.agentframework.chatcore.intent.f.a(agentTool, arrayList.get(i10));
                arrayList.set(i10, agentTool);
            } else {
                arrayList.add(agentTool);
            }
        }
        part.l(arrayList);
        q4.j.INSTANCE.e(arrayList);
    }

    public final void b0() {
        Iterator<T> it = z().iterator();
        while (it.hasNext()) {
            ((SessionHandler) it.next()).A2();
        }
    }

    public final void c0() {
        processedModerationKeys.c();
        RevertedSessionGuard.INSTANCE.b();
        com.stepos.agentframework.chatcore.audit.l.INSTANCE.a();
        CronSessionBinder.INSTANCE.f();
        lastCronCatchUpAt = 0L;
        lastCronCatchUpSid = "";
        Iterator<T> it = z().iterator();
        while (it.hasNext()) {
            ((SessionHandler) it.next()).L2();
        }
    }

    public final void d0(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        Map<SessionHandler, Long> handlerRegistrationOrder2 = handlerRegistrationOrder;
        kotlin.jvm.internal.p.h(handlerRegistrationOrder2, "handlerRegistrationOrder");
        handlerRegistrationOrder2.put(handler, Long.valueOf(nextHandlerRegistrationOrder.incrementAndGet()));
    }

    public final void e0(TaskSessionLink link, String reason) {
        String requestSessionKey = link.getRequestSessionKey();
        if (requestSessionKey.length() == 0) {
            return;
        }
        List<SessionHandler> listZ = z();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ) {
            if (C1963x.INSTANCE.a(((SessionHandler) obj).getConfiguration().getSessionConfig().getAgentType())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SessionHandler) it.next()).u2(requestSessionKey, reason);
        }
    }

    public final EReplyStatus f0(ChatMessage message) {
        EReplyStatus status = message.getStatus();
        if (status.isTerminal()) {
            return status;
        }
        List<AgentMessage> listI = message.i();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG == null) {
                listG = C1173v.m();
            }
            Z8.A.E(arrayList, listG);
        }
        if (arrayList.isEmpty()) {
            return EReplyStatus.TOOL_EXECUTING;
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!((AgentTool) it2.next()).getIsFinished()) {
                    return EReplyStatus.TOOL_EXECUTING;
                }
            }
        }
        return EReplyStatus.COMPLETED;
    }

    public final void g0(AgentResponse response, String agentId, List<AgentTool> tools) {
        String sessionId = response.getSessionId();
        if (sessionId == null) {
            sessionId = "";
        }
        if (ConversationSessionIds.INSTANCE.e(sessionId)) {
            CronSessionBinder cronSessionBinder = CronSessionBinder.INSTANCE;
            if (tools == null) {
                tools = C1173v.m();
            }
            String strM = cronSessionBinder.m(sessionId, agentId, tools);
            if (strM == null || La.H.x0(strM)) {
                C4148a.u(TAG, "cron session unmapped, keep inbound=" + sessionId, false, 4, null);
                return;
            }
            if (kotlin.jvm.internal.p.d(strM, sessionId)) {
                return;
            }
            response.Q(strM);
            C4148a.k(TAG, "rewrite cron session inbound=" + sessionId + " parent=" + strM, false, 4, null);
        }
    }

    public final SessionHandler h0(String sessionId) {
        Object obj;
        List<SessionHandler> listZ = z();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listZ) {
            if (C1963x.INSTANCE.a(((SessionHandler) obj2).getConfiguration().getSessionConfig().getAgentType())) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((SessionHandler) obj3).f2(sessionId)) {
                arrayList2.add(obj3);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Long l10 = handlerRegistrationOrder.get((SessionHandler) next);
                long jLongValue = l10 != null ? l10.longValue() : Long.MIN_VALUE;
                do {
                    Object next2 = it.next();
                    Long l11 = handlerRegistrationOrder.get((SessionHandler) next2);
                    long jLongValue2 = l11 != null ? l11.longValue() : Long.MIN_VALUE;
                    if (jLongValue < jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (SessionHandler) obj;
    }

    public final void i0(ChatMessage target, AgentResponse response, String sessionId, String agentId, String traceId) {
        AskUserConversation askUserConversation;
        String strA;
        target.S(sessionId);
        target.E(agentId);
        String serverItemId = response.getServerItemId();
        if (serverItemId == null) {
            serverItemId = "";
        }
        target.R(serverItemId);
        target.N(response.getMessageId());
        target.X(traceId);
        List<String> listU = response.u();
        if (listU != null) {
            target.V(listU);
        }
        Object extra = response.getExtra();
        C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
        if (c0917m != null && (strA = kotlin.r.a(c0917m)) != null) {
            target.F(strA);
        }
        Object extra2 = response.getExtra();
        C0917m c0917m2 = extra2 instanceof C0917m ? (C0917m) extra2 : null;
        if (c0917m2 == null || (askUserConversation = c0917m2.getAskUserConversation()) == null) {
            return;
        }
        target.G(askUserConversation);
    }

    public final int j0(ChatMessage card) {
        Iterator<AgentMessage> it = card.i().iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (it.next().getType() == AgentMessageType.TASK) {
                break;
            }
            i10++;
        }
        return i10 >= 0 ? i10 : card.i().size();
    }

    public final String l0(List<AgentTool> tools) {
        String name;
        AgentTool agentTool = (AgentTool) Z8.F.s0(tools);
        String string = (agentTool == null || (name = agentTool.getName()) == null) ? null : La.H.D1(name).toString();
        if (string == null) {
            string = "";
        }
        return string.length() == 0 ? "[工具调用]" : string;
    }

    public final AgentResponse m0(boolean isToolCall, C0917m chatReplyInfo) {
        kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
        return isToolCall ? ExtKt.t(chatReplyInfo, new p9.p() { // from class: com.stepos.agentframework.chatcore.session.B0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return PushMessageCenter.n0((C0917m) obj, (AgentResponse) obj2);
            }
        }) : ExtKt.i(ExtKt.h(ExtKt.u(chatReplyInfo, null, 1, null), chatReplyInfo), chatReplyInfo);
    }

    public final void o0(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        handlerRegistrationOrder.remove(handler);
    }

    public final List<SessionHandler> z() {
        List<SessionHandler> listM1;
        Map<SessionHandler, Long> handlerRegistrationOrder2 = handlerRegistrationOrder;
        kotlin.jvm.internal.p.h(handlerRegistrationOrder2, "handlerRegistrationOrder");
        synchronized (handlerRegistrationOrder2) {
            listM1 = Z8.F.m1(handlerRegistrationOrder2.keySet());
        }
        return listM1;
    }
}
