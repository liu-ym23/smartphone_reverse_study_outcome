package com.stepos.ailauncher.taskstore.mapper;

import Z8.C1174w;
import Z8.F;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stepos.agentframework.adapter.netcore.BusActor;
import com.stepos.agentframework.adapter.netcore.BusActorSource;
import com.stepos.agentframework.adapter.netcore.BusAnswerPhase;
import com.stepos.agentframework.adapter.netcore.BusContentType;
import com.stepos.agentframework.adapter.netcore.BusOption;
import com.stepos.agentframework.adapter.netcore.BusPart;
import com.stepos.agentframework.adapter.netcore.BusPartType;
import com.stepos.agentframework.adapter.netcore.BusQuestion;
import com.stepos.agentframework.adapter.netcore.BusTaskAnswer;
import com.stepos.agentframework.adapter.netcore.BusTaskProgress;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.session.bean.AgentTaskEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoActor;
import com.stepos.ailauncher.taskstore.entity.TaskInfoActorSource;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswerPhase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoOption;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoProgress;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.p;
import u4.AgentTaskEvent;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bF\u0010GJ)\u0010K\u001a\u0004\u0018\u00010I2\u0016\u0010J\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010I0H\"\u0004\u0018\u00010IH\u0002¢\u0006\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010T\u001a\n S*\u0004\u0018\u00010R0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006V"}, d2 = {"Lcom/stepos/ailauncher/taskstore/mapper/AgentTaskEventMapper;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "previous", "Lu4/h;", "event", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Lu4/h;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "", "taskId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lu4/h;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;", "type", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "e", "(Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "raw", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "Lcom/stepos/agentframework/adapter/netcore/g;", "progress", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "n", "(Lcom/stepos/agentframework/adapter/netcore/g;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "Lcom/stepos/agentframework/adapter/netcore/c;", "part", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "m", "(Lcom/stepos/agentframework/adapter/netcore/c;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "Lcom/stepos/agentframework/adapter/netcore/BusPartType;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "f", "(Lcom/stepos/agentframework/adapter/netcore/BusPartType;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "Lcom/stepos/agentframework/adapter/netcore/BusContentType;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/adapter/netcore/BusContentType;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", "Lcom/stepos/agentframework/adapter/netcore/d;", "question", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "o", "(Lcom/stepos/agentframework/adapter/netcore/d;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "Lcom/stepos/agentframework/adapter/netcore/b;", "option", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoOption;", "l", "(Lcom/stepos/agentframework/adapter/netcore/b;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoOption;", "Lcom/stepos/agentframework/adapter/netcore/f;", "answer", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "k", "(Lcom/stepos/agentframework/adapter/netcore/f;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "Lcom/stepos/agentframework/adapter/netcore/BusAnswerPhase;", "phase", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "c", "(Lcom/stepos/agentframework/adapter/netcore/BusAnswerPhase;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "Lcom/stepos/agentframework/adapter/netcore/a;", "actor", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/adapter/netcore/a;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActor;", "Lcom/stepos/agentframework/adapter/netcore/BusActorSource;", "source", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/adapter/netcore/BusActorSource;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "", "", "values", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Ljava/lang/Long;)Ljava/lang/Long;", "DEFAULT_TYPE", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "taskInfoCardListType", "Ljava/lang/reflect/Type;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentTaskEventMapper {
    public static final String DEFAULT_TYPE = "agent_task";
    public static final AgentTaskEventMapper INSTANCE = new AgentTaskEventMapper();
    private static final Gson gson;
    private static final Type taskInfoCardListType;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[AgentTaskEventType.values().length];
            try {
                iArr[AgentTaskEventType.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentTaskEventType.UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentTaskEventType.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentTaskEventType.ANSWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BusTaskStatus.values().length];
            try {
                iArr2[BusTaskStatus.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BusTaskStatus.PLANNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BusTaskStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BusTaskStatus.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BusTaskStatus.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[BusTaskStatus.WAITING.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[BusTaskStatus.IN_PROGRESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[BusTaskStatus.COMPLETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[BusTaskStatus.FAILED.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[BusTaskStatus.CANCELLED.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[BusTaskStatus.SKIPPED.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BusAnswerPhase.values().length];
            try {
                iArr3[BusAnswerPhase.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[BusAnswerPhase.APPLIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[BusAnswerPhase.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[BusActorSource.values().length];
            try {
                iArr4[BusActorSource.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[BusActorSource.MODEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr4[BusActorSource.SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    static {
        Gson gsonCreate = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
        p.h(gsonCreate, "create(...)");
        gson = gsonCreate;
        taskInfoCardListType = new TypeToken<List<? extends TaskInfoCard>>() { // from class: com.stepos.ailauncher.taskstore.mapper.AgentTaskEventMapper$taskInfoCardListType$1
        }.getType();
    }

    public final TaskInfoCard a(String taskId, AgentTaskEvent event) {
        Long ts = event.getTs();
        long jCurrentTimeMillis = (ts == null && (ts = event.D()) == null) ? System.currentTimeMillis() : ts.longValue();
        return new TaskInfoCard(e(event.getEventType()), null, null, null, taskId, null, null, DEFAULT_TYPE, null, null, 0, 0, false, TaskInfoStatus.CREATED, null, null, null, null, null, null, null, null, jCurrentTimeMillis, null, null, jCurrentTimeMillis, null, null, null, null, null, null, null, null, -37757074, 3, null);
    }

    public final TaskInfoActorSource b(BusActorSource source) {
        int i10 = a.$EnumSwitchMapping$3[source.ordinal()];
        if (i10 == 1) {
            return TaskInfoActorSource.USER;
        }
        if (i10 == 2) {
            return TaskInfoActorSource.MODEL;
        }
        if (i10 == 3) {
            return TaskInfoActorSource.SYSTEM;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final TaskInfoAnswerPhase c(BusAnswerPhase phase) {
        int i10 = a.$EnumSwitchMapping$2[phase.ordinal()];
        if (i10 == 1) {
            return TaskInfoAnswerPhase.ACCEPTED;
        }
        if (i10 == 2) {
            return TaskInfoAnswerPhase.APPLIED;
        }
        if (i10 == 3) {
            return TaskInfoAnswerPhase.REJECTED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final TaskInfoContentType d(BusContentType type) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(TaskInfoContentType.valueOf(type.name()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        TaskInfoContentType taskInfoContentType = TaskInfoContentType.INLINE;
        if (Result.g(objB)) {
            objB = taskInfoContentType;
        }
        return (TaskInfoContentType) objB;
    }

    public final TaskInfoEventType e(AgentTaskEventType type) {
        int i10 = a.$EnumSwitchMapping$0[type.ordinal()];
        if (i10 == 1) {
            return TaskInfoEventType.CREATED;
        }
        if (i10 == 2) {
            return TaskInfoEventType.UPDATED;
        }
        if (i10 == 3) {
            return TaskInfoEventType.COMPLETED;
        }
        if (i10 == 4) {
            return TaskInfoEventType.ANSWER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final TaskInfoPartType f(BusPartType type) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(TaskInfoPartType.valueOf(type.name()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        TaskInfoPartType taskInfoPartType = TaskInfoPartType.TEXT;
        if (Result.g(objB)) {
            objB = taskInfoPartType;
        }
        return (TaskInfoPartType) objB;
    }

    public final TaskInfoStatus g(BusTaskStatus raw) {
        switch (raw == null ? -1 : a.$EnumSwitchMapping$1[raw.ordinal()]) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return TaskInfoStatus.CREATED;
            case 2:
                return TaskInfoStatus.PLANNING;
            case 3:
                return TaskInfoStatus.PENDING;
            case 4:
                return TaskInfoStatus.RUNNING;
            case 5:
                return TaskInfoStatus.PAUSED;
            case 6:
                return TaskInfoStatus.WAITING;
            case 7:
                return TaskInfoStatus.IN_PROGRESS;
            case 8:
                return TaskInfoStatus.COMPLETED;
            case 9:
                return TaskInfoStatus.FAILED;
            case 10:
                return TaskInfoStatus.CANCELLED;
            case 11:
                return TaskInfoStatus.SKIPPED;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x030a A[PHI: r1
      0x030a: PHI (r1v2 java.lang.Long) = (r1v1 java.lang.Long), (r1v8 java.lang.Long) binds: [B:172:0x0302, B:174:0x0306] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0319 A[PHI: r1
      0x0319: PHI (r1v4 java.lang.Long) = (r1v3 java.lang.Long), (r1v7 java.lang.Long) binds: [B:178:0x0311, B:180:0x0315] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x036b A[PHI: r16
      0x036b: PHI (r16v9 java.lang.Integer) = (r16v2 java.lang.Integer), (r16v4 java.lang.Integer) binds: [B:206:0x0369, B:211:0x037d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0395 A[PHI: r17
      0x0395: PHI (r17v10 java.lang.Integer) = (r17v3 java.lang.Integer), (r17v5 java.lang.Integer) binds: [B:218:0x0393, B:223:0x03a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03bc A[PHI: r19
      0x03bc: PHI (r19v1 java.lang.String) = (r19v0 java.lang.String), (r19v13 java.lang.String) binds: [B:227:0x03b4, B:229:0x03b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03cd A[PHI: r19
      0x03cd: PHI (r19v3 java.lang.String) = (r19v2 java.lang.String), (r19v12 java.lang.String) binds: [B:233:0x03c5, B:235:0x03c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03de A[PHI: r19
      0x03de: PHI (r19v5 java.lang.String) = (r19v4 java.lang.String), (r19v11 java.lang.String) binds: [B:239:0x03d6, B:241:0x03da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03ef A[PHI: r19
      0x03ef: PHI (r19v7 java.lang.String) = (r19v6 java.lang.String), (r19v10 java.lang.String) binds: [B:245:0x03e7, B:247:0x03eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0410 A[PHI: r4
      0x0410: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v17 java.lang.String) binds: [B:253:0x0408, B:255:0x040c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0436 A[PHI: r4
      0x0436: PHI (r4v5 java.lang.Long) = (r4v4 java.lang.Long), (r4v14 java.lang.Long), (r4v15 java.lang.Long) binds: [B:259:0x0419, B:263:0x0423, B:270:0x0434] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0451 A[PHI: r4
      0x0451: PHI (r4v7 java.lang.Long) = (r4v6 java.lang.Long), (r4v10 java.lang.Long), (r4v11 java.lang.Long) binds: [B:274:0x043f, B:278:0x0449, B:280:0x044f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c A[PHI: r0
      0x013c: PHI (r0v78 java.lang.Long) = (r0v12 java.lang.Long), (r0v14 java.lang.Long) binds: [B:58:0x013a, B:63:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoCard h(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r46, u4.AgentTaskEvent r47) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.mapper.AgentTaskEventMapper.h(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, u4.h):com.stepos.ailauncher.taskstore.entity.TaskInfoCard");
    }

    public final Long i(Long... values) {
        return (Long) F.G0(r.V(values));
    }

    public final TaskInfoActor j(BusActor actor) {
        return new TaskInfoActor(b(actor.getSource()), actor.getId(), actor.getDisplayName());
    }

    public final TaskInfoAnswer k(BusTaskAnswer answer) {
        String actionId = answer.getActionId();
        String taskId = answer.getTaskId();
        Map<String, Object> mapC = answer.c();
        return new TaskInfoAnswer(actionId, taskId, mapC != null ? gson.toJson(mapC) : null, answer.getCancel(), c(answer.getPhase()), j(answer.getActor()), answer.getReason(), answer.getError(), answer.getTs());
    }

    public final TaskInfoOption l(BusOption option) {
        return new TaskInfoOption(option.getLabel(), option.getDescription());
    }

    public final TaskInfoPart m(BusPart part) {
        return new TaskInfoPart(part.getPartId(), part.getStatus(), f(part.getType()), d(part.getContentType()), part.getFileId(), part.getContent(), part.getFileName(), part.getTitle(), part.getMimeType(), part.getSize(), part.getSha256(), part.getTaskVersion(), part.getErrorReason(), part.getErrorDetail());
    }

    public final TaskInfoProgress n(BusTaskProgress progress) {
        return new TaskInfoProgress(progress.getCompleted(), progress.getTotal(), progress.getFailed(), progress.getInProgress(), progress.getPending());
    }

    public final TaskInfoQuestion o(BusQuestion question) {
        String question2 = question.getQuestion();
        String header = question.getHeader();
        List<BusOption> listC = question.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(l((BusOption) it.next()));
        }
        return new TaskInfoQuestion(question2, header, arrayList, question.getMultiSelect());
    }
}
