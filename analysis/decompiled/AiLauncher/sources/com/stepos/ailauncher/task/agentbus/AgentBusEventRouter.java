package com.stepos.ailauncher.task.agentbus;

import La.C;
import La.D;
import La.H;
import La.K;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.A;
import com.stepos.agentframework.adapter.netcore.SessionUpdate;
import com.stepos.agentframework.adapter.netcore.TaskDismiss;
import com.stepos.agentframework.adapter.netcore.u;
import com.stepos.agentframework.adapter.netcore.w;
import com.stepos.agentframework.adapter.netcore.x;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.agentframework.chatcore.session.InterfaceC1859a0;
import com.stepos.agentframework.chatcore.session.InterfaceC1861b0;
import com.stepos.agentframework.chatcore.session.P0;
import com.stepos.agentframework.chatcore.session.V0;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.session.e1;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import com.stepos.ailauncher.task.common.ArtifactAvailabilityStore;
import com.stepos.ailauncher.task.space.I;
import com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger;
import com.stepos.ailauncher.taskstore.chat.B;
import com.stepos.ailauncher.taskstore.chat.C3699b;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardKt;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.livenotification.A;
import com.stepos.ailauncher.taskstore.provider.TaskCreatedSideEffects;
import com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge;
import com.stepos.ailauncher.taskstore.sync.TaskSyncOp;
import com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView;
import com.stepos.ailauncher.taskstore.widget.TextToImageCardView;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.text.Regex;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.AgentTaskEvent;
import u6.C5578a;
import w4.ChatMessage;
import x6.InterfaceC5853a;
import y6.C5943a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b$\u0010#J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001dJ#\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010!J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b-\u0010!J\u001f\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u00104J#\u00106\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000e2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0002¢\u0006\u0004\b<\u0010\u0003J'\u0010?\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b?\u0010@J;\u0010C\u001a\u00020B2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020=2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u001a2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\bC\u0010DJA\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0E2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020=2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\bF\u0010GJ5\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0E2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020=2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u001aH\u0002¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bK\u0010\u001dJ\u0017\u0010L\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020B2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u0004\u0018\u00010\u000e2\u0006\u0010P\u001a\u00020\u000eH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bS\u0010MJ\u0019\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010P\u001a\u00020\u000eH\u0002¢\u0006\u0004\bT\u0010RJ\u0019\u0010U\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bU\u0010VJ#\u0010Z\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bZ\u0010[J'\u0010]\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b]\u0010^J\u0013\u0010_\u001a\u00020\u000e*\u00020\u001aH\u0002¢\u0006\u0004\b_\u0010VJ\u0015\u0010`\u001a\u00020X*\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b`\u0010aJ\u001d\u0010c\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u0006\u0010b\u001a\u00020XH\u0002¢\u0006\u0004\bc\u0010[R\u0014\u0010d\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010\nR\u0016\u0010g\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010 R\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR \u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010 R\u0014\u0010o\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\bo\u0010 ¨\u0006p"}, d2 = {"Lcom/stepos/ailauncher/task/agentbus/AgentBusEventRouter;", "", "<init>", "()V", "LY8/t;", "h0", "i0", "q0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "m0", "Z", "f0", "o0", "O", "", "reason", "A0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "y0", "(Le9/c;)Ljava/lang/Object;", "Lu4/h;", "event", "B", "(Lu4/h;)V", "sessionId", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "H", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "J", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "F", "json", "key", "R", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "s0", "j0", "N", "G", "taskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "op", "t0", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "versionId", "u0", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "ttiView", "w0", "(Ljava/lang/String;Landroid/view/View;)V", "X", "Lw4/c;", "message", "C", "(Ljava/lang/String;Lw4/c;Lcom/stepos/agentframework/chatcore/intent/e;)V", "failedTool", "", "B0", "(Ljava/lang/String;Lw4/c;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Z", "", "l0", "(Ljava/lang/String;Lw4/c;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Ljava/util/List;", "current", "z", "(Ljava/lang/String;Lw4/c;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/util/List;", "E0", "G0", "(Lcom/stepos/agentframework/chatcore/intent/e;)V", "F0", "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "parameter", "Q", "(Ljava/lang/String;)Ljava/lang/String;", "U", ExifInterface.LONGITUDE_EAST, "D", "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/lang/String;", "text", "", "max", "P", "(Ljava/lang/String;I)Ljava/lang/String;", "messageId", "K", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/e;)V", "D0", "I", "(Ljava/lang/String;)I", "maxChars", "C0", "TAG", "Ljava/lang/String;", "reconnectSyncing", "lastReconnectSyncAt", "Leb/a;", "taskCardWriteMutex", "Leb/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "liveDidiToolCalls", "Ljava/util/concurrent/ConcurrentHashMap;", "LIVE_DIDI_TOOL_TTL_MS", "RECONNECT_SYNC_RETRY_DELAY_MS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter {
    private static final long LIVE_DIDI_TOOL_TTL_MS = 300000;
    private static final long RECONNECT_SYNC_RETRY_DELAY_MS = 8000;
    private static final String TAG = "AILauncher-AgentBus";
    private static long lastReconnectSyncAt;
    private static volatile boolean reconnectSyncing;
    public static final AgentBusEventRouter INSTANCE = new AgentBusEventRouter();
    private static final InterfaceC4021a taskCardWriteMutex = eb.f.b(false, 1, null);
    private static final ConcurrentHashMap<String, Long> liveDidiToolCalls = new ConcurrentHashMap<>();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((TaskInfoCard) t10).getUpdatedAt()), Long.valueOf(((TaskInfoCard) t11).getUpdatedAt()));
        }
    }

    public static final boolean L(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object value = it.getValue();
        kotlin.jvm.internal.p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() > 300000;
    }

    public static final boolean M(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final void W(String sessionId, AgentTaskEvent event) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(event, "event");
        C4148a.d(TAG, "TaskEventBus onTaskEvent sessionId=" + sessionId + " " + C5943a.INSTANCE.b(event), false, 4, null);
        INSTANCE.B(event);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Y(java.lang.String r34, w4.ChatMessage r35, com.stepos.agentframework.chatcore.intent.AgentTool r36) {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.Y(java.lang.String, w4.c, com.stepos.agentframework.chatcore.intent.e):void");
    }

    public static final t a0(String fileId, InterfaceC5074l onUrl, InterfaceC5074l onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onUrl, "onUrl");
        kotlin.jvm.internal.p.i(onError, "onError");
        u6.i.INSTANCE.e(fileId, onUrl, onError);
        return t.f7040a;
    }

    public static final t b0(String fileId, InterfaceC5074l onUrl, InterfaceC5074l onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onUrl, "onUrl");
        kotlin.jvm.internal.p.i(onError, "onError");
        u6.i.INSTANCE.k(fileId, C5578a.DST_JPG, null, 600, onUrl, onError);
        return t.f7040a;
    }

    public static final t c0(String fileId, InterfaceC5074l onText, InterfaceC5074l onError) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(onText, "onText");
        kotlin.jvm.internal.p.i(onError, "onError");
        com.stepos.ailauncher.task.common.l.INSTANCE.g(fileId, onText, onError);
        return t.f7040a;
    }

    public static final t d0(List fileIds, InterfaceC5074l onResult) {
        kotlin.jvm.internal.p.i(fileIds, "fileIds");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        ArtifactAvailabilityStore.INSTANCE.t(fileIds, onResult);
        return t.f7040a;
    }

    public static final t e0(List fileIds, InterfaceC5074l onResult) {
        kotlin.jvm.internal.p.i(fileIds, "fileIds");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        ArtifactAvailabilityStore.INSTANCE.r(fileIds, onResult);
        return t.f7040a;
    }

    public static final void g0(TaskDismiss d10) {
        Object objB;
        kotlin.jvm.internal.p.i(d10, "d");
        String surface = d10.getSurface();
        if (H.x0(surface)) {
            surface = null;
        }
        if (surface == null) {
            surface = "all";
        }
        C4148a.k(TAG, "task dismiss taskId=" + d10.getTaskId() + " surface=" + surface + " reason=" + d10.getReason(), false, 4, null);
        if (H.x0(d10.getTaskId())) {
            return;
        }
        int iHashCode = surface.hashCode();
        if (iHashCode == 96673 ? !surface.equals("all") : !(iHashCode == 595233003 ? surface.equals("notification") : iHashCode == 1815657730 && surface.equals("live_activity"))) {
            C4148a.k(TAG, "dismiss surface=" + surface + " not actionable on client, ignored", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            A.INSTANCE.g(C3197a.INSTANCE.a(), d10.getTaskId());
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "cancel live notification failed taskId=" + d10.getTaskId(), thE, false, 8, null);
        }
        Result.a(objB);
    }

    public static final void k0(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        AgentBusEventRouter agentBusEventRouter = INSTANCE;
        agentBusEventRouter.G(card);
        agentBusEventRouter.N(card);
        if (card.getStatus() == TaskInfoStatus.COMPLETED) {
            Function2.b(new AgentBusEventRouter$registerImageTaskTerminalFailureReceiver$1$1(card, null));
        }
    }

    public static final void n0() {
        INSTANCE.O();
    }

    public static final void p0(SessionUpdate update) {
        Object objB;
        kotlin.jvm.internal.p.i(update, "update");
        C4148a.k(TAG, "session.update sessionId=" + update.getSessionId() + " label='" + update.getLabel() + "' seq=" + update.getSeq(), false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            A.INSTANCE.n(update.getSessionId(), update.getLabel());
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "updateSessionSummary failed sessionId=" + update.getSessionId(), thE, false, 8, null);
        }
    }

    public static final void r0(String taskId, String type, Bundle bundle) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(type, "type");
        C4148a.d(TAG, "TaskCreatedSideEffect: taskId=" + taskId + ", type=" + type + ", extrasKeys=" + (bundle != null ? bundle.keySet() : null), false, 4, null);
    }

    public static /* synthetic */ void v0(AgentBusEventRouter agentBusEventRouter, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        agentBusEventRouter.u0(str, str2);
    }

    public static final void x0(View view, String str) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            ViewParent parent = view.getParent();
            t tVar = null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
                tVar = t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "removeView text-to-image card failed taskId=" + str, thE, false, 8, null);
        }
    }

    public static final CharSequence z0(long j10, TaskInfoCard it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getTaskId() + "/" + it.getStatus() + "/age=" + (j10 - it.getUpdatedAt()) + Const.SP_KEY_GSM_UPLOAD_MXSIZE;
    }

    public final void A(String taskId) {
        TextToImageCardView textToImageCardViewW = B.INSTANCE.w(taskId);
        if (textToImageCardViewW == null) {
            return;
        }
        w0(taskId, textToImageCardViewW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r7 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A0(java.lang.String r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$runReconnectTaskSync$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$runReconnectTaskSync$1 r0 = (com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$runReconnectTaskSync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$runReconnectTaskSync$1 r0 = new com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$runReconnectTaskSync$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            java.lang.Long r5 = (java.lang.Long) r5
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)
            goto L65
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)
            goto L53
        L45:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.y0(r0)
            if (r7 != r1) goto L53
            goto L64
        L53:
            r5 = r7
            java.lang.Long r5 = (java.lang.Long) r5
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r7 = com.stepos.ailauncher.taskstore.sync.TaskSyncManager.INSTANCE
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.A(r5, r0)
            if (r7 != r1) goto L65
        L64:
            return r1
        L65:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reconnect syncTaskWithRemote reason="
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " lastUpdateTs="
            r0.append(r6)
            r0.append(r5)
            java.lang.String r5 = " ok="
            r0.append(r5)
            r0.append(r7)
            java.lang.String r5 = r0.toString()
            r6 = 4
            r7 = 0
            java.lang.String r0 = "AILauncher-AgentBus"
            r1 = 0
            h8.C4148a.u(r0, r5, r1, r6, r7)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.A0(java.lang.String, e9.c):java.lang.Object");
    }

    public final void B(AgentTaskEvent event) {
        Function2.b(new AgentBusEventRouter$dispatchAgentTaskEvent$1(event, null));
    }

    public final boolean B0(String sessionId, ChatMessage message, String taskId, AgentTool failedTool, String versionId) {
        B b10 = B.INSTANCE;
        if (b10.V(taskId, versionId) || !b10.J(taskId, versionId).isEmpty() || !b10.L(taskId, versionId).isEmpty()) {
            return true;
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
        if (q4.j.INSTANCE.w(arrayList, taskId, failedTool.getToolCallId())) {
            return true;
        }
        return !z(sessionId, message, taskId, failedTool).isEmpty();
    }

    public final void C(String sessionId, ChatMessage message, AgentTool tool) {
        AgentTool agentTool;
        AgentBusEventRouter agentBusEventRouter;
        String str;
        String name = tool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null) {
            name = tool.getApiName();
        }
        if (kotlin.jvm.internal.p.d(name, q4.i.TOOL_NAME_TEXT_TO_IMAGE)) {
            B b10 = B.INSTANCE;
            if (b10.U(tool.getToolCallId())) {
                return;
            }
            String strN = b10.N(tool.getToolCallId());
            String strP = b10.P(tool.getToolCallId());
            if (tool.getIsUpdate() && strN == null) {
                return;
            }
            if (tool.getIsUpdate() && strN != null) {
                if (b10.J(strN, strP).isEmpty()) {
                    l0(sessionId, message, strN, tool, strP);
                    return;
                }
                return;
            }
            q4.i iVar = q4.i.INSTANCE;
            if (iVar.n(name, tool.getParameter())) {
                return;
            }
            String strU = iVar.u(tool.getResult());
            if (strU == null && (strU = b10.N(tool.getToolCallId())) == null && (strU = q4.j.INSTANCE.y(message.i())) == null && (strU = b10.M(sessionId)) == null) {
                return;
            }
            String str2 = strU;
            String strR = R(tool.getResult(), "version_id");
            if (strR != null) {
                strP = strR;
            } else if (strP == null) {
                strP = b10.O(sessionId);
            }
            boolean z10 = tool.getIsFinished() && iVar.m(tool.getResult());
            if (z10) {
                agentTool = tool;
                agentBusEventRouter = this;
                str = sessionId;
                if (!agentBusEventRouter.B0(str, message, str2, agentTool, strP)) {
                    agentBusEventRouter.u0(str2, strP);
                    V0 v02 = V0.INSTANCE;
                    v02.k(v02.y(str, str2));
                    agentTool.x(null);
                    agentTool.B(false);
                    return;
                }
                b10.C(str2, agentTool.getToolCallId(), true, strP);
                agentTool.x(null);
                agentTool.B(false);
                C4148a.k(TAG, "keep text-to-image card on tool failure taskId=" + str2 + " toolCallId=" + agentTool.getToolCallId(), false, 4, null);
            } else {
                agentTool = tool;
                agentBusEventRouter = this;
                str = sessionId;
                if (agentTool.getIsFinished()) {
                    b10.C(str2, agentTool.getToolCallId(), false, strP);
                }
            }
            b10.Y(str, str2, strP);
            b10.Z(agentTool.getToolCallId(), str2, strP);
            List<String> listL0 = agentBusEventRouter.l0(str, message, str2, agentTool, strP);
            if (listL0.isEmpty() && !z10 && !agentTool.getIsFinished() && !agentTool.getIsUpdate()) {
                b10.x(str2, agentTool.getToolCallId(), strP);
            }
            if (!z10 && agentTool.getAppUIData() == null) {
                String result = agentTool.getResult();
                String packageName = C3197a.INSTANCE.a().getPackageName();
                kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
                agentTool.x(iVar.d(result, str2, packageName));
            }
            q4.j.INSTANCE.d(message.i());
            if (!z10) {
                agentTool.B(agentTool.getIsFinished() && agentTool.getAppUIData() != null);
            }
            String str3 = agentTool.getIsFinished() ? "FINISHED" : "RUNNING";
            C4148a.d(TAG, "text_to_image lifecycle ensure sessionId=" + str + " taskId=" + str2 + " phase=" + str3 + " failed=" + z10 + " pending=" + listL0.size(), false, 4, null);
        }
    }

    public final String C0(String str, int i10) {
        if (str == null) {
            return "null";
        }
        if (str.length() <= i10) {
            return str;
        }
        return K.R1(str, i10) + "...(len=" + str.length() + ")";
    }

    public final String D(AgentTool tool) {
        Object objB;
        String parameter = tool.getParameter();
        if (parameter == null) {
            return null;
        }
        if (H.x0(parameter)) {
            parameter = null;
        }
        if (parameter == null) {
            return null;
        }
        String name = tool.getName();
        String apiName = tool.getApiName();
        if (!kotlin.jvm.internal.p.d(name, "ability") && !kotlin.jvm.internal.p.d(apiName, "ability")) {
            if (kotlin.jvm.internal.p.d(name, "nodes") || kotlin.jvm.internal.p.d(apiName, "nodes")) {
                return R5.a.INSTANCE.c(parameter);
            }
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(parameter).optString("method"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }

    public final String D0(AgentTool agentTool) {
        return "name=" + agentTool.getName() + " apiName=" + agentTool.getApiName() + " toolCallId=" + agentTool.getToolCallId() + " finished=" + agentTool.getIsFinished() + " hidden=" + agentTool.getHidden() + " displayName=" + C0(agentTool.getDisplayName(), 256) + " parameterLen=" + I(agentTool.getParameter()) + " resultLen=" + I(agentTool.getResult()) + " appUIData=" + (agentTool.getAppUIData() != null) + " toolId=" + agentTool.getToolId() + " likeStatus=" + agentTool.getLikeStatus();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String E(java.lang.String r2) {
        /*
            r1 = this;
            r1 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L33
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L33
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "invokeParamsJson"
            java.lang.String r2 = r0.optString(r2)     // Catch: java.lang.Throwable -> L33
            kotlin.jvm.internal.p.f(r2)     // Catch: java.lang.Throwable -> L33
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L33
            if (r0 <= 0) goto L18
            goto L19
        L18:
            r2 = r1
        L19:
            if (r2 != 0) goto L1d
        L1b:
            r2 = r1
            goto L51
        L1d:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L33
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "params"
            java.lang.Object r2 = r0.opt(r2)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L2c
            goto L1b
        L2c:
            boolean r0 = r2 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L35
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch: java.lang.Throwable -> L33
            goto L41
        L33:
            r2 = move-exception
            goto L56
        L35:
            boolean r0 = r2 instanceof java.lang.String     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L1b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L33
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L33
            r2 = r0
        L41:
            java.lang.String r0 = "taskId"
            java.lang.String r2 = r2.optString(r0)     // Catch: java.lang.Throwable -> L33
            kotlin.jvm.internal.p.f(r2)     // Catch: java.lang.Throwable -> L33
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L33
            if (r0 <= 0) goto L1b
        L51:
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L33
            goto L60
        L56:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.C4849c.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L60:
            boolean r0 = kotlin.Result.g(r2)
            if (r0 == 0) goto L67
            goto L68
        L67:
            r1 = r2
        L68:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.E(java.lang.String):java.lang.String");
    }

    public final void E0(String sessionId, AgentTool tool) {
        SessionUpdate sessionUpdateE;
        Object objB;
        String parameter = tool.getParameter();
        if (parameter != null) {
            if (!H.g0(parameter, x.STREAM, false, 2, null)) {
                parameter = null;
            }
            if (parameter == null || (sessionUpdateE = x.INSTANCE.e(parameter, sessionId)) == null) {
                return;
            }
            C4148a.k(TAG, "session.update via toolcall sessionId=" + sessionUpdateE.getSessionId() + " toolCallId=" + tool.getToolCallId() + " label='" + sessionUpdateE.getLabel() + "'", false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                A.INSTANCE.n(sessionUpdateE.getSessionId(), sessionUpdateE.getLabel());
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "updateSessionSummary from toolcall failed sessionId=" + sessionUpdateE.getSessionId(), thE, false, 8, null);
            }
        }
    }

    public final void F(String sessionId, AgentTool tool) {
        String name = tool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null) {
            name = tool.getApiName();
        }
        String str = name;
        if (F.f0(q.ARTIFACT_TOOL_NAMES, str)) {
            if (kotlin.jvm.internal.p.d(str, q4.i.TOOL_NAME_TASK_ARTIFACT) && !kotlin.jvm.internal.p.d(R(tool.getParameter(), "action"), "upload")) {
                C4148a.d(TAG, "task_artifact non-upload action, skip sessionId=" + sessionId, false, 4, null);
                return;
            }
            if (q4.i.INSTANCE.n(str, tool.getParameter())) {
                C4148a.k(TAG, "text_to_image skip_upload=true (中间素材), skip artifacts sessionId=" + sessionId, false, 4, null);
                return;
            }
            TaskArtifactPartMerger.Parsed bVarH = TaskArtifactPartMerger.INSTANCE.h(tool.getResult());
            if (bVarH == null) {
                C4148a.d(TAG, "no artifacts in " + str + " result sessionId=" + sessionId + " resultLen=" + I(tool.getResult()), false, 4, null);
                return;
            }
            String strB = bVarH.getTaskId();
            if (strB == null) {
                B b10 = B.INSTANCE;
                String strN = b10.N(tool.getToolCallId());
                if (strN == null) {
                    strB = b10.M(sessionId);
                    if (strB == null) {
                        C4148a.u(TAG, "artifact tool=" + str + " without taskId, dropped sessionId=" + sessionId, false, 4, null);
                        return;
                    }
                } else {
                    strB = strN;
                }
            }
            C4148a.k(TAG, "artifact tool=" + str + " sessionId=" + sessionId + " taskId=" + strB + " parts=" + bVarH.a().size() + " versionId=" + bVarH.getVersionId(), false, 4, null);
            Function2.b(new AgentBusEventRouter$handleArtifactTool$1(str, strB, tool, bVarH, sessionId, null));
        }
    }

    public final boolean F0(AgentTool tool) {
        String parameter;
        Object objB;
        Object objB2;
        if ((kotlin.jvm.internal.p.d(tool.getName(), "ability") || kotlin.jvm.internal.p.d(tool.getApiName(), "ability")) && (parameter = tool.getParameter()) != null) {
            if (H.x0(parameter)) {
                parameter = null;
            }
            if (parameter != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(new JSONObject(parameter).optString("method"));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                String str = (String) objB;
                if (str != null) {
                    if (str.length() <= 0) {
                        str = null;
                    }
                    if (str == null || !kotlin.jvm.internal.p.d(str, "gui_agent")) {
                        return false;
                    }
                    try {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(parameter).optJSONObject("params");
                        objB2 = Result.b(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null);
                    } catch (Throwable th2) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th2));
                    }
                    if (Result.g(objB2)) {
                        objB2 = null;
                    }
                    String str2 = (String) objB2;
                    if (str2 != null) {
                        parameter = str2;
                    }
                    tool.E("gui_agent");
                    tool.w("gui_agent");
                    tool.G(parameter);
                    if (tool.getAppUIData() != null) {
                        return true;
                    }
                    tool.x(I.g(I.INSTANCE, tool, null, 2, null));
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r15) {
        /*
            r14 = this;
            boolean r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoCardKt.isImageTaskCard(r15)
            if (r0 != 0) goto L8
            goto Lb0
        L8:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r15.getStatus()
            boolean r0 = r0.isTerminalFailure()
            if (r0 != 0) goto L14
            goto Lb0
        L14:
            java.lang.String r0 = r15.getRequestSessionKey()
            r1 = 0
            if (r0 == 0) goto L25
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L22
            goto L23
        L22:
            r0 = r1
        L23:
            if (r0 != 0) goto L33
        L25:
            java.lang.String r0 = r15.getSessionKey()
            if (r0 == 0) goto L32
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L32
            goto L33
        L32:
            r0 = r1
        L33:
            boolean r2 = com.stepos.ailauncher.taskstore.entity.TaskInfoCardKt.hasSuccessfulImagePart(r15)
            r3 = 4
            java.lang.String r4 = " status="
            java.lang.String r5 = "AILauncher-AgentBus"
            r6 = 0
            if (r2 == 0) goto La7
            if (r0 == 0) goto L4e
            com.stepos.agentframework.chatcore.session.V0 r14 = com.stepos.agentframework.chatcore.session.V0.INSTANCE
            java.lang.String r2 = r15.getTaskId()
            com.stepos.agentframework.chatcore.session.c0 r0 = r14.g(r0, r2)
            r14.k(r0)
        L4e:
            com.stepos.ailauncher.taskstore.chat.B r7 = com.stepos.ailauncher.taskstore.chat.B.INSTANCE
            java.lang.String r8 = r15.getTaskId()
            java.lang.String r11 = r15.getVersionId()
            r12 = 2
            r13 = 0
            r9 = 0
            r10 = 0
            com.stepos.ailauncher.taskstore.chat.B.D(r7, r8, r9, r10, r11, r12, r13)
            java.lang.String r14 = r15.getTaskId()
            java.lang.String r0 = r15.getVersionId()
            com.stepos.ailauncher.taskstore.widget.TextToImageCardView r14 = r7.Q(r14, r0)
            if (r14 == 0) goto L70
            r14.X(r15)
        L70:
            java.lang.String r14 = r15.getTaskId()
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r15.getStatus()
            java.util.List r15 = r15.getResult()
            if (r15 == 0) goto L83
            int r15 = r15.size()
            goto L84
        L83:
            r15 = r6
        L84:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "keep image card with successful results on terminal failure taskId="
            r2.append(r7)
            r2.append(r14)
            r2.append(r4)
            r2.append(r0)
            java.lang.String r14 = " resultSize="
            r2.append(r14)
            r2.append(r15)
            java.lang.String r14 = r2.toString()
            h8.C4148a.k(r5, r14, r6, r3, r1)
            return
        La7:
            java.lang.String r2 = r15.getTaskId()
            r14.A(r2)
            if (r0 != 0) goto Lb1
        Lb0:
            return
        Lb1:
            com.stepos.agentframework.chatcore.session.V0 r14 = com.stepos.agentframework.chatcore.session.V0.INSTANCE
            java.lang.String r2 = r15.getTaskId()
            com.stepos.agentframework.chatcore.session.c0 r2 = r14.y(r0, r2)
            r14.k(r2)
            java.lang.String r14 = r15.getTaskId()
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r15 = r15.getStatus()
            java.util.List r7 = r2.b()
            int r7 = r7.size()
            java.util.List r2 = r2.e()
            int r2 = r2.size()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "image task terminal failure taskId="
            r8.append(r9)
            r8.append(r14)
            r8.append(r4)
            r8.append(r15)
            java.lang.String r14 = " sessionId="
            r8.append(r14)
            r8.append(r0)
            java.lang.String r14 = " removed="
            r8.append(r14)
            r8.append(r7)
            java.lang.String r14 = " updated="
            r8.append(r14)
            r8.append(r2)
            java.lang.String r14 = r8.toString()
            h8.C4148a.k(r5, r14, r6, r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.G(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):void");
    }

    public final void G0(AgentTool tool) {
        String strQ;
        La.m mVarD;
        List<String> listC;
        String str;
        La.m mVarD2;
        if (F0(tool)) {
            return;
        }
        if ((!q.f(tool.getName()) && !q.f(tool.getApiName())) || (strQ = Q(tool.getParameter())) == null || (mVarD = Regex.d(q.EXEC_TOOL_NAME_REGEX, strQ, 0, 2, null)) == null || (listC = mVarD.c()) == null || (str = listC.get(1)) == null || !kotlin.jvm.internal.p.d(str, "gui_agent") || (mVarD2 = Regex.d(q.EXEC_PARAMS_REGEX, strQ, 0, 2, null)) == null) {
            return;
        }
        String str2 = mVarD2.c().get(1);
        if (str2.length() == 0) {
            str2 = mVarD2.c().get(2);
        }
        String str3 = str2;
        if (str3.length() == 0) {
            return;
        }
        tool.E("gui_agent");
        tool.w("gui_agent");
        tool.G(str3);
        if (tool.getAppUIData() == null) {
            tool.x(I.g(I.INSTANCE, tool, null, 2, null));
        }
    }

    public final void H(String sessionId, AgentTool tool) {
        String name = tool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null) {
            name = tool.getApiName();
        }
        if (kotlin.jvm.internal.p.d(name, "task")) {
            Function2.b(new AgentBusEventRouter$handleTaskLifecycleTool$1(sessionId, tool, null));
        }
    }

    public final int I(String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    public final void J(TaskInfoCard card) {
        if (TaskInfoCardKt.isImageTaskCard(card) && !card.getStatus().isTerminal()) {
            B b10 = B.INSTANCE;
            b10.Y(card.getSessionKey(), card.getTaskId(), card.getVersionId());
            b10.Y(card.getRequestSessionKey(), card.getTaskId(), card.getVersionId());
        }
    }

    public final void K(String sessionId, String messageId, AgentTool tool) {
        String string;
        String string2;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ConcurrentHashMap<String, Long> concurrentHashMap = liveDidiToolCalls;
        Set<Map.Entry<String, Long>> setEntrySet = concurrentHashMap.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.agentbus.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AgentBusEventRouter.L(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.task.agentbus.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AgentBusEventRouter.M(interfaceC5074l, obj);
            }
        });
        String strD = D(tool);
        Integer numW = null;
        if (strD == null) {
            strD = tool.getName();
            if (H.x0(strD)) {
                strD = null;
            }
            if (strD == null) {
                strD = tool.getApiName();
            }
        }
        if (strD == null || !D.V(strD, "didi_", true) || H.x0(tool.getToolCallId())) {
            return;
        }
        String str = sessionId + "|" + tool.getToolCallId();
        if (!tool.getIsFinished()) {
            concurrentHashMap.put(str, Long.valueOf(jElapsedRealtime));
            return;
        }
        if (concurrentHashMap.remove(str) == null) {
            return;
        }
        AppUIData appUIData = tool.getAppUIData();
        if (appUIData == null && (appUIData = TripartiteAppUiCoercion.n(TripartiteAppUiCoercion.INSTANCE, tool, null, 2, null)) == null) {
            return;
        }
        Object structuredContent = appUIData.getStructuredContent();
        Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
        if (map == null) {
            return;
        }
        Object obj = map.get("templateType");
        String string3 = (obj == null || (string2 = obj.toString()) == null) ? null : H.D1(string2).toString();
        Object obj2 = map.get("bizChannel");
        String string4 = (obj2 == null || (string = obj2.toString()) == null) ? null : H.D1(string).toString();
        Object obj3 = map.get(D6.a.KEY_TASK_STATUS);
        if (obj3 instanceof Number) {
            numW = Integer.valueOf(((Number) obj3).intValue());
        } else if (obj3 instanceof String) {
            numW = C.w((String) obj3);
        }
        if (D.L(string3, O5.c.DIDI, true) || D.L(string3, TripartiteAppUiCoercion.CARD_CENTER_ALIAS, true) || D.L(string3, "oauth-authorize", true)) {
            if ((string4 == null || H.x0(string4) || D.L(string4, q0.DIDI, true)) && numW != null && numW.intValue() == 91) {
                tool.y("realtime");
                R5.b.INSTANCE.c("didi.card.renderSource.realtime", Y8.j.a("sessionId", sessionId), Y8.j.a("messageId", messageId), Y8.j.a("toolCallId", tool.getToolCallId()), Y8.j.a("taskId", map.get("taskId")));
            }
        }
    }

    public final void N(TaskInfoCard card) {
        if (card.getStatus().isTerminal()) {
            String requestSessionKey = card.getRequestSessionKey();
            if (requestSessionKey == null || H.x0(requestSessionKey)) {
                requestSessionKey = null;
            }
            String sessionKey = card.getSessionKey();
            if (sessionKey == null || H.x0(sessionKey)) {
                sessionKey = null;
            }
            List listG0 = F.g0(C1173v.r(requestSessionKey, sessionKey));
            if (listG0.isEmpty()) {
                return;
            }
            Function2.b(new AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1(card, listG0, null));
        }
    }

    public final void O() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!reconnectSyncing && jCurrentTimeMillis - lastReconnectSyncAt >= 2000) {
            reconnectSyncing = true;
            lastReconnectSyncAt = jCurrentTimeMillis;
            Function2.a(new AgentBusEventRouter$onRemoteReconnected$1(null));
        } else {
            C4148a.u(TAG, "reconnect sync skipped (inflight=" + reconnectSyncing + " throttle)", false, 4, null);
        }
    }

    public final String P(String text, int max) {
        String strS;
        String strS2;
        String strR1 = (text == null || (strS = D.S(text, '\n', ' ', false, 4, null)) == null || (strS2 = D.S(strS, '\r', ' ', false, 4, null)) == null) ? null : K.R1(strS2, max);
        return strR1 == null ? "" : strR1;
    }

    public final String Q(String parameter) {
        Object objB;
        if (parameter.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = new JSONObject(parameter).optString("command");
            kotlin.jvm.internal.p.f(strOptString);
            if (strOptString.length() <= 0) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final String R(String json, String key) {
        Object objB;
        if (json == null || H.x0(json)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = new JSONObject(json).optString(key);
            kotlin.jvm.internal.p.f(strOptString);
            if (strOptString.length() <= 0) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.S(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [eb.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r51, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r52) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.T(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    public final void U(AgentTool tool) {
        Object objB;
        R5.a aVar;
        String strC;
        if (!kotlin.jvm.internal.p.d(tool.getName(), "ask_third_party_agent") && !kotlin.jvm.internal.p.d(tool.getApiName(), "ask_third_party_agent")) {
            if ((kotlin.jvm.internal.p.d(tool.getName(), "nodes") || kotlin.jvm.internal.p.d(tool.getApiName(), "nodes")) && (strC = (aVar = R5.a.INSTANCE).c(tool.getParameter())) != null) {
                if (kotlin.jvm.internal.p.d(strC, q.TRIPARTITE_CARD_TOOL_NAME) || D.X(strC, "proxy_third_party_ability_", false, 2, null)) {
                    aVar.e(tool.getToolCallId(), strC, aVar.b(tool.getParameter()), kotlin.jvm.internal.p.d(strC, q.TRIPARTITE_CARD_TOOL_NAME) ? E(tool.getParameter()) : null);
                    return;
                }
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(tool.getParameter()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JSONObject jSONObject = (JSONObject) objB;
        R5.a.INSTANCE.g(tool.getToolCallId(), jSONObject != null ? jSONObject.optString("task") : null, jSONObject != null ? jSONObject.optString("target") : null);
    }

    public final void V() {
        P0.b(AgentBusEventRouter.class, new InterfaceC1859a0() { // from class: com.stepos.ailauncher.task.agentbus.j
            @Override // com.stepos.agentframework.chatcore.session.InterfaceC1859a0
            public final void b(String str, AgentTaskEvent agentTaskEvent) {
                AgentBusEventRouter.W(str, agentTaskEvent);
            }
        });
        C4148a.u(TAG, "AgentTaskEvent receiver registered on TaskEventBus", false, 4, null);
    }

    public final void X() {
        e1.b(AgentBusEventRouter.class, new InterfaceC1861b0() { // from class: com.stepos.ailauncher.task.agentbus.k
            @Override // com.stepos.agentframework.chatcore.session.InterfaceC1861b0
            public final void a(String str, ChatMessage chatMessage, AgentTool agentTool) {
                AgentBusEventRouter.Y(str, chatMessage, agentTool);
            }
        });
        C4148a.d(TAG, "AgentToolEvent receiver registered on ToolEventBus", false, 4, null);
    }

    public final void Z() {
        com.stepos.ailauncher.taskstore.artifact.a aVar = com.stepos.ailauncher.taskstore.artifact.a.INSTANCE;
        aVar.g(new p9.q() { // from class: com.stepos.ailauncher.task.agentbus.o
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AgentBusEventRouter.a0((String) obj, (InterfaceC5074l) obj2, (InterfaceC5074l) obj3);
            }
        });
        aVar.j(new p9.q() { // from class: com.stepos.ailauncher.task.agentbus.p
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AgentBusEventRouter.b0((String) obj, (InterfaceC5074l) obj2, (InterfaceC5074l) obj3);
            }
        });
        aVar.k(new p9.q() { // from class: com.stepos.ailauncher.task.agentbus.b
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AgentBusEventRouter.c0((String) obj, (InterfaceC5074l) obj2, (InterfaceC5074l) obj3);
            }
        });
        aVar.h(new p9.p() { // from class: com.stepos.ailauncher.task.agentbus.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AgentBusEventRouter.d0((List) obj, (InterfaceC5074l) obj2);
            }
        });
        aVar.i(new p9.p() { // from class: com.stepos.ailauncher.task.agentbus.d
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AgentBusEventRouter.e0((List) obj, (InterfaceC5074l) obj2);
            }
        });
        C4148a.u(TAG, "Artifact url resolver registered on TaskArtifactUrlResolver", false, 4, null);
    }

    public final void f0() {
        com.stepos.agentframework.adapter.netcore.A.b(AgentBusEventRouter.class, new A.a() { // from class: com.stepos.ailauncher.task.agentbus.f
            @Override // com.stepos.agentframework.adapter.netcore.A.a
            public final void a(TaskDismiss taskDismiss) {
                AgentBusEventRouter.g0(taskDismiss);
            }
        });
        C4148a.u(TAG, "Dismiss receiver registered on TaskDismissEventBus", false, 4, null);
    }

    public final void h0() {
        V();
        m0();
        f0();
        o0();
        X();
        s0();
        j0();
        q0();
        Z();
        SpriteTaskBridge.INSTANCE.f(C3197a.INSTANCE.a());
    }

    public final void i0() {
        Function2.b(new AgentBusEventRouter$registerGuiActionListener$1(null));
    }

    public final void j0() {
        x6.b.b(C3197a.INSTANCE.a(), new InterfaceC5853a() { // from class: com.stepos.ailauncher.task.agentbus.g
            @Override // x6.InterfaceC5853a
            public final void a(TaskInfoCard taskInfoCard) {
                AgentBusEventRouter.k0(taskInfoCard);
            }
        });
    }

    public final List<String> l0(String sessionId, ChatMessage message, String taskId, AgentTool tool, String versionId) {
        List<String> listZ = z(sessionId, message, taskId, tool);
        if (!listZ.isEmpty()) {
            B.INSTANCE.b0(taskId, listZ, versionId);
        }
        return listZ;
    }

    public final void m0() {
        u.b(AgentBusEventRouter.class, new u.a() { // from class: com.stepos.ailauncher.task.agentbus.e
            @Override // com.stepos.agentframework.adapter.netcore.u.a
            public final void a() {
                AgentBusEventRouter.n0();
            }
        });
        C4148a.u(TAG, "Reconnect receiver registered on ReconnectEventBus", false, 4, null);
    }

    public final void o0() {
        w.b(AgentBusEventRouter.class, new w.a() { // from class: com.stepos.ailauncher.task.agentbus.l
            @Override // com.stepos.agentframework.adapter.netcore.w.a
            public final void a(SessionUpdate sessionUpdate) {
                AgentBusEventRouter.p0(sessionUpdate);
            }
        });
        C4148a.u(TAG, "SessionUpdate receiver registered on SessionUpdateEventBus", false, 4, null);
    }

    public final void q0() {
        TaskCreatedSideEffects.c(new com.stepos.ailauncher.taskstore.provider.b() { // from class: com.stepos.ailauncher.task.agentbus.m
            @Override // com.stepos.ailauncher.taskstore.provider.b
            public final void a(String str, String str2, Bundle bundle) {
                AgentBusEventRouter.r0(str, str2, bundle);
            }
        });
    }

    public final void s0() {
        Function2.b(new AgentBusEventRouter$registerTaskSyncEventReceiver$1(null));
    }

    public final void t0(String taskId, TaskSyncOp op) {
        Object objB;
        TaskInfoCardMediumView taskInfoCardMediumViewD = C3699b.INSTANCE.d(taskId);
        if (taskInfoCardMediumViewD != null) {
            t tVar = null;
            C4148a.u(TAG, "remove inline medium card on task delete taskId=" + taskId + " op=" + op, false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                ViewParent parent = taskInfoCardMediumViewD.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(taskInfoCardMediumViewD);
                    tVar = t.f7040a;
                }
                objB = Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "removeView medium card failed taskId=" + taskId, thE, false, 8, null);
            }
        }
    }

    public final void u0(String taskId, String versionId) {
        TextToImageCardView textToImageCardViewF0 = (versionId == null || H.x0(versionId)) ? B.INSTANCE.f0(taskId) : B.INSTANCE.o0(taskId, versionId);
        if (textToImageCardViewF0 == null) {
            return;
        }
        w0(taskId, textToImageCardViewF0);
    }

    public final void w0(final String taskId, final View ttiView) {
        C4148a.u(TAG, "remove inline text-to-image card taskId=" + taskId, false, 4, null);
        ttiView.post(new Runnable() { // from class: com.stepos.ailauncher.task.agentbus.n
            @Override // java.lang.Runnable
            public final void run() {
                AgentBusEventRouter.x0(ttiView, taskId);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0189, code lost:
    
        if (r0 == r3) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.stepos.ailauncher.taskstore.repository.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.stepos.ailauncher.taskstore.repository.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.stepos.ailauncher.taskstore.repository.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y0(e9.InterfaceC4014c<? super java.lang.Long> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.y0(e9.c):java.lang.Object");
    }

    public final List<String> z(String sessionId, ChatMessage message, String taskId, AgentTool current) {
        List<AgentMessage> listI = message.i();
        ArrayList<AgentTool> arrayList = new ArrayList();
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG == null) {
                listG = C1173v.m();
            }
            Z8.A.E(arrayList, listG);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(q4.j.INSTANCE.E(arrayList, taskId));
        for (AgentTool agentTool : arrayList) {
            if (q4.j.INSTANCE.m(agentTool) && !linkedHashSet.contains(agentTool.getToolCallId())) {
                B b10 = B.INSTANCE;
                String strN = b10.N(agentTool.getToolCallId());
                if (strN == null) {
                    strN = b10.M(sessionId);
                }
                if (strN == null || kotlin.jvm.internal.p.d(strN, taskId)) {
                    linkedHashSet.add(agentTool.getToolCallId());
                }
            }
        }
        if (q4.j.INSTANCE.m(current)) {
            linkedHashSet.add(current.getToolCallId());
        }
        return F.m1(linkedHashSet);
    }
}
