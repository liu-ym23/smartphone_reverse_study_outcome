package u4;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusPart;
import com.stepos.agentframework.adapter.netcore.BusQuestion;
import com.stepos.agentframework.adapter.netcore.BusTask;
import com.stepos.agentframework.adapter.netcore.BusTaskAnswer;
import com.stepos.agentframework.adapter.netcore.BusTaskProgress;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.session.bean.AgentTaskEventType;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0013\u0010+\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00101\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u0013\u00104\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00106\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b5\u0010\u0010R\u0013\u00108\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\u0010R\u0011\u0010:\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b9\u0010\u0014R\u0011\u0010<\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u0011\u0010?\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0013\u0010C\u001a\u0004\u0018\u00010@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0013\u0010E\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bD\u0010\u0010R\u0013\u0010G\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bF\u0010\u0010R\u0013\u0010K\u001a\u0004\u0018\u00010H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0019\u0010M\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bL\u0010.R\u0013\u0010O\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010\u0010R\u0013\u0010Q\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bP\u0010\u0010R\u0019\u0010T\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bS\u0010.R\u0013\u0010V\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bU\u0010\u0010R\u0013\u0010X\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bW\u0010\u001eR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\bY\u0010\u001eR\u0013\u0010\\\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b[\u0010\u001eR\u0013\u0010^\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b]\u0010\u001eR\u0019\u0010a\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b`\u0010.R!\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010b8F¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lu4/h;", "", "Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;", "eventType", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "Lcom/stepos/agentframework/adapter/netcore/e;", "task", "Lcom/stepos/agentframework/adapter/netcore/f;", "answer", "<init>", "(Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/e;Lcom/stepos/agentframework/adapter/netcore/f;)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;", "f", "()Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;", "Ljava/lang/Long;", "p", "()Ljava/lang/Long;", "B", "Ljava/lang/String;", "q", "Lcom/stepos/agentframework/adapter/netcore/e;", "x", "()Lcom/stepos/agentframework/adapter/netcore/e;", "Lcom/stepos/agentframework/adapter/netcore/f;", "c", "()Lcom/stepos/agentframework/adapter/netcore/f;", "y", "taskId", "k", "parentTaskId", "", "t", "()Ljava/util/List;", "subTaskIds", "C", "type", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/Integer;", "version", "F", "versionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "iconUrl", "z", "taskVersion", Const.INTENT_KEY_PKGNAME, "activeTaskVersion", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "noTaskDetail", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "s", "()Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "status", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "title", "v", "subTitle", "Lcom/stepos/agentframework/adapter/netcore/g;", "m", "()Lcom/stepos/agentframework/adapter/netcore/g;", "progress", "u", "subTasks", "w", c.a.COL_SUMMARY, "n", "requestSessionKey", "Lcom/stepos/agentframework/adapter/netcore/d;", "l", "pendingQuestions", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "intention", Const.INTENT_KEY_UMID, "createdAt", "r", "startedAt", "e", "endedAt", "D", "updatedAt", "Lcom/stepos/agentframework/adapter/netcore/c;", "o", "result", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Map;", "extensions", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.h, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTaskEvent {
    private final BusTaskAnswer answer;
    private final AgentTaskEventType eventType;
    private final Long seq;
    private final String sessionKey;
    private final BusTask task;
    private final Long ts;

    public AgentTaskEvent(AgentTaskEventType eventType, Long l10, Long l11, String str, BusTask busTask, BusTaskAnswer busTaskAnswer) {
        p.i(eventType, "eventType");
        this.eventType = eventType;
        this.seq = l10;
        this.ts = l11;
        this.sessionKey = str;
        this.task = busTask;
        this.answer = busTaskAnswer;
    }

    public final String A() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getTitle();
        }
        return null;
    }

    /* renamed from: B, reason: from getter */
    public final Long getTs() {
        return this.ts;
    }

    public final String C() {
        String type;
        BusTask busTask = this.task;
        return (busTask == null || (type = busTask.getType()) == null) ? "" : type;
    }

    public final Long D() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return Long.valueOf(busTask.getUpdatedAt());
        }
        return null;
    }

    public final Integer E() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getVersion();
        }
        return null;
    }

    public final String F() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getVersionId();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018 A[PHI: r1
      0x0018: PHI (r1v6 java.lang.String) = (r1v3 java.lang.String), (r1v8 java.lang.String) binds: [B:21:0x002c, B:10:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r4 = this;
            com.stepos.agentframework.chatcore.session.M0 r0 = com.stepos.agentframework.chatcore.session.M0.INSTANCE
            com.stepos.agentframework.adapter.netcore.e r1 = r4.task
            r2 = 0
            if (r1 == 0) goto L1a
            java.lang.String r1 = r1.getRequestSessionKey()
            if (r1 == 0) goto L1a
            boolean r3 = La.H.x0(r1)
            if (r3 != 0) goto L14
            goto L15
        L14:
            r1 = r2
        L15:
            if (r1 != 0) goto L18
            goto L1a
        L18:
            r2 = r1
            goto L39
        L1a:
            com.stepos.agentframework.adapter.netcore.e r1 = r4.task
            if (r1 == 0) goto L2b
            java.lang.String r1 = r1.getSessionKey()
            if (r1 == 0) goto L2b
            boolean r3 = La.H.x0(r1)
            if (r3 != 0) goto L2b
            goto L2c
        L2b:
            r1 = r2
        L2c:
            if (r1 != 0) goto L18
            java.lang.String r4 = r4.sessionKey
            if (r4 == 0) goto L39
            boolean r1 = La.H.x0(r4)
            if (r1 != 0) goto L39
            r2 = r4
        L39:
            java.lang.String r4 = r0.f(r2)
            if (r4 != 0) goto L41
            java.lang.String r4 = ""
        L41:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.AgentTaskEvent.a():java.lang.String");
    }

    public final int b() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getActiveTaskVersion();
        }
        return 0;
    }

    /* renamed from: c, reason: from getter */
    public final BusTaskAnswer getAnswer() {
        return this.answer;
    }

    public final Long d() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return Long.valueOf(busTask.getCreatedAt());
        }
        return null;
    }

    public final Long e() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getEndedAt();
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTaskEvent)) {
            return false;
        }
        AgentTaskEvent agentTaskEvent = (AgentTaskEvent) other;
        return this.eventType == agentTaskEvent.eventType && p.d(this.seq, agentTaskEvent.seq) && p.d(this.ts, agentTaskEvent.ts) && p.d(this.sessionKey, agentTaskEvent.sessionKey) && p.d(this.task, agentTaskEvent.task) && p.d(this.answer, agentTaskEvent.answer);
    }

    /* renamed from: f, reason: from getter */
    public final AgentTaskEventType getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> g() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.d();
        }
        return null;
    }

    public final String h() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getIconUrl();
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Long l10 = this.seq;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.ts;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.sessionKey;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        BusTask busTask = this.task;
        int iHashCode5 = (iHashCode4 + (busTask == null ? 0 : busTask.hashCode())) * 31;
        BusTaskAnswer busTaskAnswer = this.answer;
        return iHashCode5 + (busTaskAnswer != null ? busTaskAnswer.hashCode() : 0);
    }

    public final String i() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getIntention();
        }
        return null;
    }

    public final boolean j() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getNoTaskDetail();
        }
        return false;
    }

    public final String k() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getParentTaskId();
        }
        return null;
    }

    public final List<BusQuestion> l() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.i();
        }
        return null;
    }

    public final BusTaskProgress m() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getProgress();
        }
        return null;
    }

    public final String n() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getRequestSessionKey();
        }
        return null;
    }

    public final List<BusPart> o() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.l();
        }
        return null;
    }

    /* renamed from: p, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    /* renamed from: q, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final Long r() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getStartedAt();
        }
        return null;
    }

    public final BusTaskStatus s() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getStatus();
        }
        return null;
    }

    public final List<String> t() {
        List<String> listP;
        BusTask busTask = this.task;
        return (busTask == null || (listP = busTask.p()) == null) ? C1173v.m() : listP;
    }

    public String toString() {
        return "AgentTaskEvent(eventType=" + this.eventType + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ", task=" + this.task + ", answer=" + this.answer + ")";
    }

    public final List<BusTask> u() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.q();
        }
        return null;
    }

    public final String v() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getSubTitle();
        }
        return null;
    }

    public final String w() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getSummary();
        }
        return null;
    }

    /* renamed from: x, reason: from getter */
    public final BusTask getTask() {
        return this.task;
    }

    public final String y() {
        String taskId;
        BusTask busTask = this.task;
        if (busTask != null && (taskId = busTask.getTaskId()) != null) {
            return taskId;
        }
        BusTaskAnswer busTaskAnswer = this.answer;
        return busTaskAnswer != null ? busTaskAnswer.getTaskId() : "";
    }

    public final int z() {
        BusTask busTask = this.task;
        if (busTask != null) {
            return busTask.getTaskVersion();
        }
        return 0;
    }

    public /* synthetic */ AgentTaskEvent(AgentTaskEventType agentTaskEventType, Long l10, Long l11, String str, BusTask busTask, BusTaskAnswer busTaskAnswer, int i10, kotlin.jvm.internal.i iVar) {
        this(agentTaskEventType, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : l11, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : busTask, (i10 & 32) != 0 ? null : busTaskAnswer);
    }
}
