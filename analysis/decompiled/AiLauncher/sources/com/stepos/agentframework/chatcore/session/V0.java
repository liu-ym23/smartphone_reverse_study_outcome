package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.adapter.netcore.BusTask;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.O0;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.channels.BufferOverflow;
import p9.InterfaceC5063a;
import u4.AgentMessage;
import u4.AgentTaskEvent;
import u4.m;
import w4.ChatMessage;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0003J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060'H\u0002¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u0003J\u001f\u0010-\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u00100J7\u00106\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b8\u00109J1\u0010<\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b<\u0010=J1\u0010@\u001a\u00020?2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b@\u0010AJ!\u0010B\u001a\u0004\u0018\u00010;2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010GRT\u0010K\u001aB\u0012\f\u0012\n I*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n I*\u0004\u0018\u00010\u001a0\u001a I* \u0012\f\u0012\n I*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n I*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010J0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010ER\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020X0[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001f0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010ZR\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0[8\u0006¢\u0006\f\n\u0004\ba\u0010]\u001a\u0004\bb\u0010_¨\u0006c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/V0;", "", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/stepos/agentframework/chatcore/session/X0;", "observer", "LY8/t;", "w", "(Landroidx/lifecycle/LifecycleOwner;Lcom/stepos/agentframework/chatcore/session/X0;)V", "x", "(Lcom/stepos/agentframework/chatcore/session/X0;)V", "C", "", "u", "()I", "", "sessionId", "LK6/x;", "hint", "Lcom/stepos/agentframework/chatcore/session/O0;", "f", "(Ljava/lang/String;LK6/x;)Lcom/stepos/agentframework/chatcore/session/O0;", "Lu4/h;", "event", "", "broadcast", Const.INTENT_KEY_UMID, "(Lu4/h;Z)Lcom/stepos/agentframework/chatcore/session/O0;", "taskId", "Lcom/stepos/agentframework/chatcore/session/c0;", "y", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/c0;", "removal", "k", "(Lcom/stepos/agentframework/chatcore/session/c0;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "D", "", "v", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "t", "z", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)Ljava/lang/String;", "taskEvent", "agentId", "requestSessionKey", "", "cardTime", "q", "(Lu4/h;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "p", "(Lu4/h;)Z", "type", "Lw4/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lw4/c;", "messageId", "Lu4/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lu4/a;", "l", "(Ljava/lang/String;Ljava/lang/String;)Lw4/c;", "TAG", "Ljava/lang/String;", "OBSERVER_LEAK_SUSPECT_THRESHOLD", "I", "", "kotlin.jvm.PlatformType", "", "observers", "Ljava/util/Map;", "Lx4/f;", "messageRepository", "Lx4/f;", "Lx4/x;", "taskSessionLinkRepository$delegate", "LY8/h;", "n", "()Lx4/x;", "taskSessionLinkRepository", "FALLBACK_AGENT_ID", "LXa/j;", "Lcom/stepos/agentframework/chatcore/session/W0;", "_updates", "LXa/j;", "LXa/o;", AlgorithmUpdateBundle.KEY_UPDATES, "LXa/o;", "o", "()LXa/o;", "_chatRemovals", "chatRemovals", "m", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class V0 {
    private static final int OBSERVER_LEAK_SUSPECT_THRESHOLD = 8;
    private static final String TAG = "TaskMessageStore";
    private static final Xa.j<ImageTaskChatRemoval> _chatRemovals;
    private static final Xa.j<TaskMessageUpdate> _updates;
    private static final Xa.o<ImageTaskChatRemoval> chatRemovals;
    private static final Xa.o<TaskMessageUpdate> updates;
    public static final V0 INSTANCE = new V0();
    private static final Map<X0, Boolean> observers = Collections.synchronizedMap(new WeakHashMap());
    private static final x4.f messageRepository = new x4.v(null, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.S0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return V0.r();
        }
    }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.T0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return V0.s();
        }
    }, 1, null);

    /* renamed from: taskSessionLinkRepository$delegate, reason: from kotlin metadata */
    private static final Y8.h taskSessionLinkRepository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.U0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return V0.B();
        }
    });
    private static final String FALLBACK_AGENT_ID = PrimaryAgent.AGENT_BUS.getId();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMessageType.values().length];
            try {
                iArr[AgentMessageType.TOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentMessageType.TASK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatcore/session/V0$b", "Landroidx/lifecycle/m;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC1395m {
        final /* synthetic */ X0 $observer;

        public b(X0 x02) {
            this.$observer = x02;
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(event, "event");
            if (event == Lifecycle.Event.ON_DESTROY) {
                V0.INSTANCE.C(this.$observer);
                source.getLifecycle().d(this);
            }
        }
    }

    static {
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        Xa.j<TaskMessageUpdate> jVarA = Xa.p.a(0, 256, bufferOverflow);
        _updates = jVarA;
        updates = jVarA;
        Xa.j<ImageTaskChatRemoval> jVarA2 = Xa.p.a(0, 64, bufferOverflow);
        _chatRemovals = jVarA2;
        chatRemovals = jVarA2;
    }

    public static final x4.x B() {
        return new x4.x();
    }

    public static /* synthetic */ O0 e(V0 v02, AgentTaskEvent agentTaskEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return v02.d(agentTaskEvent, z10);
    }

    public static final Y8.t r() {
        INSTANCE.t();
        return Y8.t.f7040a;
    }

    public static final String s() {
        return INSTANCE.j();
    }

    public static final void w(LifecycleOwner owner, X0 observer) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(observer, "observer");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getState() != Lifecycle.State.DESTROYED) {
            INSTANCE.x(observer);
            lifecycle.a(new b(observer));
            return;
        }
        C4148a.u(TAG, "registerObserver skipped: owner=" + owner + " already DESTROYED", false, 4, null);
    }

    public final String A(String sessionId) {
        String str;
        if (sessionId.length() == 0) {
            return "";
        }
        Iterator it = Z8.B.U(messageRepository.g(sessionId)).iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            String traceId = ((ChatMessage) it.next()).getTraceId();
            if (!La.H.x0(traceId)) {
                str = traceId;
            }
        } while (str == null);
        return str == null ? "" : str;
    }

    public final void C(X0 observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        observers.remove(observer);
    }

    public final void D() {
        int iU = u();
        if (iU <= 8) {
            return;
        }
        C4148a.h(TAG, "UI observer count=" + iU + " exceeds 8, host may be leaking SessionHandler (missing release/bindLifecycle)", false, 4, null);
    }

    public final O0 d(AgentTaskEvent event, boolean broadcast) {
        Object objB;
        kotlin.jvm.internal.p.i(event, "event");
        String strA = event.a();
        String string = La.H.D1(event.y()).toString();
        if (strA.length() == 0) {
            C4148a.u(TAG, "taskEvent ignored, missing conversationKey event:" + event, false, 4, null);
            return O0.c.INSTANCE;
        }
        if (string.length() == 0) {
            C4148a.u(TAG, "taskEvent ignored, missing taskId event:" + event, false, 4, null);
            return O0.c.INSTANCE;
        }
        String strZ = z(string, strA);
        if (!kotlin.jvm.internal.p.d(event.C(), "image")) {
            P0.a(strA, event);
            C4148a.k(TAG, "taskEvent dispatched without card (non-image) taskId:" + string + " sessionId:" + strA + " type:" + event.C() + " eventType:" + event.getEventType(), false, 4, null);
            return O0.b.INSTANCE;
        }
        if (p(event)) {
            P0.a(strA, event);
            C4148a.k(TAG, "taskEvent deferred image terminal chat handling taskId:" + string + " sessionId:" + strA + " status=" + event.s(), false, 4, null);
            return O0.b.INSTANCE;
        }
        ChatMessage chatMessageL = l(strA, string);
        if (chatMessageL != null) {
            if (La.H.x0(chatMessageL.getTraceId())) {
                chatMessageL.X(INSTANCE.A(strA));
            }
            if (chatMessageL.i().isEmpty()) {
                chatMessageL.L(C1173v.s(INSTANCE.i(string, strA, chatMessageL.getMessageId(), event.C())));
            } else {
                Iterator<AgentMessage> it = chatMessageL.i().iterator();
                int i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    }
                    AgentMessage next = it.next();
                    if (next.getType() == AgentMessageType.TASK) {
                        u4.m content = next.getContent();
                        m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                        if (kotlin.jvm.internal.p.d(taskMessage != null ? taskMessage.getTaskId() : null, string)) {
                            break;
                        }
                    }
                    i10++;
                }
                if (i10 < 0) {
                    chatMessageL.i().add(INSTANCE.i(string, strA, chatMessageL.getMessageId(), event.C()));
                }
            }
        } else {
            chatMessageL = h(strA, string, strZ, event.C());
        }
        ChatMessage chatMessage = chatMessageL;
        try {
            Result.Companion companion = Result.INSTANCE;
            messageRepository.t(chatMessage);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "taskEvent save failed taskId:" + string + " sessionId:" + strA + " eventType:" + event.getEventType(), thE, false, 8, null);
        }
        if (!Result.h(objB)) {
            return O0.e.INSTANCE;
        }
        q(event, strZ, strA, string, chatMessage.getTime());
        P0.a(strA, event);
        TaskMessageUpdate taskMessageUpdate = new TaskMessageUpdate(strA, strZ, chatMessage, event, kotlin.jvm.internal.p.d(event.n(), strA));
        if (broadcast) {
            _updates.a(taskMessageUpdate);
        }
        C4148a.k(TAG, "taskEvent upserted taskId:" + string + " sessionId:" + strA + " agentId:" + strZ + " messageId:" + chatMessage.getMessageId() + " eventType:" + event.getEventType(), false, 4, null);
        return new O0.Applied(taskMessageUpdate);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.session.O0 f(java.lang.String r39, kotlin.HistoryTaskCreateHint r40) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.V0.f(java.lang.String, K6.x):com.stepos.agentframework.chatcore.session.O0");
    }

    public final ImageTaskChatRemoval g(String sessionId, String taskId) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(sessionId) || La.H.x0(taskId)) {
            return new ImageTaskChatRemoval(sessionId, taskId, C1173v.m(), C1173v.m());
        }
        ArrayList arrayList = new ArrayList();
        for (ChatMessage chatMessage : messageRepository.g(sessionId)) {
            boolean z10 = false;
            for (AgentMessage agentMessage : chatMessage.i()) {
                if (agentMessage.getType() == AgentMessageType.TOOL) {
                    List<AgentTool> listG = agentMessage.g();
                    if (listG == null) {
                        listG = C1173v.m();
                    }
                    Iterator<T> it = listG.iterator();
                    while (it.hasNext()) {
                        AppUIData appUIData = ((AgentTool) it.next()).getAppUIData();
                        if (appUIData != null) {
                            q4.j jVar = q4.j.INSTANCE;
                            if (kotlin.jvm.internal.p.d(jVar.C(appUIData), taskId) && jVar.f(appUIData)) {
                                z10 = true;
                            }
                        }
                    }
                }
            }
            if (z10) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    messageRepository.t(chatMessage);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(TAG, "save image task loading clear failed messageId=" + chatMessage.getMessageId(), thE, false, 8, null);
                }
                if (Result.h(objB)) {
                    arrayList.add(chatMessage);
                }
            }
        }
        return new ImageTaskChatRemoval(sessionId, taskId, C1173v.m(), arrayList);
    }

    public final ChatMessage h(String sessionId, String taskId, String agentId, String type) {
        ChatMessage chatMessage = new ChatMessage("task-" + UUID.randomUUID(), sessionId, agentId, System.currentTimeMillis(), AgentRole.ASSISTANT, "", 0, 0, "", "task-" + taskId, A(sessionId), EReplyStatus.COMPLETED, 0, null, null, null, false, null, null, null, 0, null, 4190208, null);
        chatMessage.L(C1173v.s(INSTANCE.i(taskId, sessionId, chatMessage.getMessageId(), type)));
        return chatMessage;
    }

    public final AgentMessage i(String taskId, String sessionId, String messageId, String type) {
        return new AgentMessage(AgentMessageType.TASK, null, new m.TaskMessage(taskId, sessionId, messageId, type), null, false, false, 58, null);
    }

    public final String j() {
        Iterator<T> it = v().iterator();
        while (it.hasNext()) {
            String strA = ((X0) it.next()).a();
            if (strA != null) {
                return strA;
            }
        }
        return null;
    }

    public final void k(ImageTaskChatRemoval removal) {
        kotlin.jvm.internal.p.i(removal, "removal");
        if (removal.a()) {
            _chatRemovals.a(removal);
        }
    }

    public final ChatMessage l(String sessionId, String taskId) {
        Object obj;
        Iterator it = Z8.F.d0(messageRepository.g(sessionId)).iterator();
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

    public final Xa.o<ImageTaskChatRemoval> m() {
        return chatRemovals;
    }

    public final x4.x n() {
        return (x4.x) taskSessionLinkRepository.getValue();
    }

    public final Xa.o<TaskMessageUpdate> o() {
        return updates;
    }

    public final boolean p(AgentTaskEvent event) {
        BusTaskStatus busTaskStatusS = event.s();
        if (busTaskStatusS == null) {
            return false;
        }
        return busTaskStatusS == BusTaskStatus.FAILED || busTaskStatusS == BusTaskStatus.CANCELLED;
    }

    public final void q(AgentTaskEvent taskEvent, String agentId, String requestSessionKey, String taskId, long cardTime) {
        String sessionKey;
        if (taskEvent.j()) {
            BusTask task = taskEvent.getTask();
            String string = (task == null || (sessionKey = task.getSessionKey()) == null) ? null : La.H.D1(sessionKey).toString();
            if (string == null) {
                string = "";
            }
            String str = string;
            if (str.length() == 0 || requestSessionKey.length() == 0 || kotlin.jvm.internal.p.d(str, requestSessionKey)) {
                return;
            }
            boolean z10 = n().b(str) == null;
            n().c(new TaskSessionLink(str, requestSessionKey, taskId, agentId, cardTime, 0L, 32, null));
            if (z10) {
                PushMessageCenter.INSTANCE.R(agentId, str, requestSessionKey, taskId, cardTime);
            }
        }
    }

    public final void t() {
        Object objB;
        for (X0 x02 : v()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                x02.b();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "observer order-change failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final int u() {
        int size;
        Map<X0, Boolean> observers2 = observers;
        kotlin.jvm.internal.p.h(observers2, "observers");
        synchronized (observers2) {
            size = observers2.size();
        }
        return size;
    }

    public final List<X0> v() {
        List<X0> listN0;
        Map<X0, Boolean> observers2 = observers;
        kotlin.jvm.internal.p.h(observers2, "observers");
        synchronized (observers2) {
            listN0 = Z8.F.n0(observers2.keySet());
        }
        return listN0;
    }

    public final void x(X0 observer) {
        kotlin.jvm.internal.p.i(observer, "observer");
        Map<X0, Boolean> observers2 = observers;
        kotlin.jvm.internal.p.h(observers2, "observers");
        observers2.put(observer, Boolean.TRUE);
        D();
    }

    public final ImageTaskChatRemoval y(String sessionId, String taskId) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(sessionId) || La.H.x0(taskId)) {
            return new ImageTaskChatRemoval(sessionId, taskId, C1173v.m(), C1173v.m());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ChatMessage chatMessageL = l(sessionId, taskId);
        if (chatMessageL != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                messageRepository.q(chatMessageL.getMessageId());
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "delete standalone image task message failed taskId=" + taskId, thE, false, 8, null);
            }
            arrayList.add(chatMessageL.getMessageId());
        }
        for (ChatMessage chatMessage : messageRepository.g(sessionId)) {
            if (!arrayList.contains(chatMessage.getMessageId())) {
                ListIterator<AgentMessage> listIterator = chatMessage.i().listIterator();
                boolean z10 = false;
                while (listIterator.hasNext()) {
                    AgentMessage next = listIterator.next();
                    int i10 = a.$EnumSwitchMapping$0[next.getType().ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            u4.m content = next.getContent();
                            m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                            if (taskMessage != null && kotlin.jvm.internal.p.d(taskMessage.getTaskId(), taskId) && kotlin.jvm.internal.p.d(taskMessage.k(), m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE)) {
                                listIterator.remove();
                                z10 = true;
                            }
                        }
                    } else if (q4.j.INSTANCE.x(next.g(), taskId)) {
                        z10 = true;
                    }
                }
                if (z10) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        messageRepository.t(chatMessage);
                        objB2 = Result.b(Y8.t.f7040a);
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th2));
                    }
                    Throwable thE2 = Result.e(objB2);
                    if (thE2 != null) {
                        C4148a.t(TAG, "save image task strip failed messageId=" + chatMessage.getMessageId(), thE2, false, 8, null);
                    }
                    if (Result.h(objB2)) {
                        arrayList2.add(chatMessage);
                    }
                }
            }
        }
        return new ImageTaskChatRemoval(sessionId, taskId, arrayList, arrayList2);
    }

    public final String z(String taskId, String sessionId) {
        String agentId;
        String agentId2;
        TaskSessionLink taskSessionLinkA = n().a(taskId);
        if (taskSessionLinkA != null && (agentId2 = taskSessionLinkA.getAgentId()) != null) {
            if (La.H.x0(agentId2)) {
                agentId2 = null;
            }
            if (agentId2 != null) {
                return agentId2;
            }
        }
        Iterator<T> it = messageRepository.g(sessionId).iterator();
        while (true) {
            if (!it.hasNext()) {
                agentId = null;
                break;
            }
            agentId = ((ChatMessage) it.next()).getAgentId();
            if (La.H.x0(agentId)) {
                agentId = null;
            }
            if (agentId != null) {
                break;
            }
        }
        if (agentId != null) {
            return agentId;
        }
        String str = FALLBACK_AGENT_ID;
        C4148a.h(TAG, "resolveAgentId fell back to " + str + ", no link & no session message taskId:" + taskId + " sessionId:" + sessionId, false, 4, null);
        return str;
    }
}
