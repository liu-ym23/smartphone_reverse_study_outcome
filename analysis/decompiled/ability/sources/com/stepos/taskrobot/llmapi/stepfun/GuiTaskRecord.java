package com.stepos.taskrobot.llmapi.stepfun;

import D7.v;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.tencent.mmkv.MMKV;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010\u001fJ\u0015\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\u001dJ\u000f\u0010(\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u001fJ\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001fJ\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001fJ\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u001fJ\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001fJ\u0010\u0010/\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b/\u0010\u001dJ\u0010\u00100\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010\u001fJ\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010\u001fJ\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010\u001fJ\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u001fJ\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b6\u00107J\u009a\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u001fJ\u0010\u0010;\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b;\u0010\u001dJ\u001a\u0010?\u001a\u00020>2\b\u0010=\u001a\u0004\u0018\u00010<HÖ\u0003¢\u0006\u0004\b?\u0010@R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010A\u001a\u0004\bC\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010A\u001a\u0004\bD\u0010\u001fR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010A\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010GR$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010A\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010GR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010J\u001a\u0004\bK\u0010\u001dR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010L\u001a\u0004\bM\u00101\"\u0004\bN\u0010OR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010A\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010GR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010A\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010GR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010A\u001a\u0004\bT\u0010\u001f\"\u0004\bU\u0010GR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010A\u001a\u0004\bV\u0010\u001f\"\u0004\bW\u0010GR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010X\u001a\u0004\bY\u00107¨\u0006["}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "Landroid/os/Parcelable;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "startTime", "endTime", "appName", "", "taskType", "Lstepai/aios/guiagent/model/SessionState;", "taskState", AgentBusWakeContract.EXTRA_TRACE_ID, "modelId", "modelCell", "sjflTraceId", "", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "actions", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "getStateDisplayName", "()Ljava/lang/String;", "", "calculateDuration", "()Ljava/lang/Long;", "calculateDurationFormatted", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "addAction", "(Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;)V", "getActionCount", "getLastAction", "()Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "()Lstepai/aios/guiagent/model/SessionState;", "component8", "component9", "component10", "component11", "component12", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskName", "getTaskId", "getStartTime", "getEndTime", "setEndTime", "(Ljava/lang/String;)V", "getAppName", "setAppName", "I", "getTaskType", "Lstepai/aios/guiagent/model/SessionState;", "getTaskState", "setTaskState", "(Lstepai/aios/guiagent/model/SessionState;)V", "getTraceId", "setTraceId", "getModelId", "setModelId", "getModelCell", "setModelCell", "getSjflTraceId", "setSjflTraceId", "Ljava/util/List;", "getActions", "CREATOR", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuiTaskRecord implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final List<GuiActionRecord> actions;
    private String appName;
    private String endTime;
    private String modelCell;
    private String modelId;
    private String sjflTraceId;
    private final String startTime;
    private final String taskId;
    private final String taskName;
    private SessionState taskState;
    private final int taskType;
    private String traceId;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", AppAgent.CONSTRUCT, "()V", "TIME_FORMAT", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "getStateName", "state", "Lstepai/aios/guiagent/model/SessionState;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<GuiTaskRecord> {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.GuiTaskRecord$CREATOR$WhenMappings */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SessionState.values().length];
                try {
                    SessionState sessionState = SessionState.f6031a;
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    SessionState sessionState2 = SessionState.f6031a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    SessionState sessionState3 = SessionState.f6031a;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    SessionState sessionState4 = SessionState.f6031a;
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    SessionState sessionState5 = SessionState.f6031a;
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    SessionState sessionState6 = SessionState.f6031a;
                    iArr[5] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    SessionState sessionState7 = SessionState.f6031a;
                    iArr[6] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    SessionState sessionState8 = SessionState.f6031a;
                    iArr[7] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    SessionState sessionState9 = SessionState.f6031a;
                    iArr[8] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final String getStateName(SessionState state) {
            kotlin.jvm.internal.k.f(state, "state");
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    return "已创建";
                case 2:
                    return "已启动";
                case 3:
                    return "运行中";
                case 4:
                    return "等待用户输入";
                case 5:
                    return "已暂停";
                case 6:
                    return "人工接管中";
                case 7:
                    return "已完成";
                case 8:
                    return "失败";
                case 9:
                    return "已取消";
                default:
                    return state.name();
            }
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuiTaskRecord createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.k.f(parcel, "parcel");
            return new GuiTaskRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuiTaskRecord[] newArray(int size) {
            return new GuiTaskRecord[size];
        }
    }

    public GuiTaskRecord(String taskName, String taskId, String startTime, String str, String str2, int i, SessionState taskState, String str3, String str4, String str5, String str6, List<GuiActionRecord> actions) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(startTime, "startTime");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(actions, "actions");
        this.taskName = taskName;
        this.taskId = taskId;
        this.startTime = startTime;
        this.endTime = str;
        this.appName = str2;
        this.taskType = i;
        this.taskState = taskState;
        this.traceId = str3;
        this.modelId = str4;
        this.modelCell = str5;
        this.sjflTraceId = str6;
        this.actions = actions;
    }

    public static /* synthetic */ GuiTaskRecord copy$default(GuiTaskRecord guiTaskRecord, String str, String str2, String str3, String str4, String str5, int i, SessionState sessionState, String str6, String str7, String str8, String str9, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = guiTaskRecord.taskName;
        }
        if ((i6 & 2) != 0) {
            str2 = guiTaskRecord.taskId;
        }
        if ((i6 & 4) != 0) {
            str3 = guiTaskRecord.startTime;
        }
        if ((i6 & 8) != 0) {
            str4 = guiTaskRecord.endTime;
        }
        if ((i6 & 16) != 0) {
            str5 = guiTaskRecord.appName;
        }
        if ((i6 & 32) != 0) {
            i = guiTaskRecord.taskType;
        }
        if ((i6 & 64) != 0) {
            sessionState = guiTaskRecord.taskState;
        }
        if ((i6 & 128) != 0) {
            str6 = guiTaskRecord.traceId;
        }
        if ((i6 & 256) != 0) {
            str7 = guiTaskRecord.modelId;
        }
        if ((i6 & 512) != 0) {
            str8 = guiTaskRecord.modelCell;
        }
        if ((i6 & 1024) != 0) {
            str9 = guiTaskRecord.sjflTraceId;
        }
        if ((i6 & 2048) != 0) {
            list = guiTaskRecord.actions;
        }
        String str10 = str9;
        List list2 = list;
        String str11 = str7;
        String str12 = str8;
        SessionState sessionState2 = sessionState;
        String str13 = str6;
        String str14 = str5;
        int i10 = i;
        return guiTaskRecord.copy(str, str2, str3, str4, str14, i10, sessionState2, str13, str11, str12, str10, list2);
    }

    public final synchronized void addAction(GuiActionRecord action) {
        kotlin.jvm.internal.k.f(action, "action");
        this.actions.add(action);
    }

    public final Long calculateDuration() throws ParseException {
        if (this.endTime == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
            Date date = simpleDateFormat.parse(this.startTime);
            if (date != null) {
                long time = date.getTime();
                Date date2 = simpleDateFormat.parse(this.endTime);
                if (date2 != null) {
                    return Long.valueOf((date2.getTime() - time) / 1000);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final String calculateDurationFormatted() throws ParseException {
        Long lCalculateDuration = calculateDuration();
        if (lCalculateDuration == null) {
            return null;
        }
        long jLongValue = lCalculateDuration.longValue();
        long j5 = MMKV.ExpireInHour;
        long j6 = jLongValue / j5;
        long j10 = 60;
        long j11 = (jLongValue % j5) / j10;
        long j12 = jLongValue % j10;
        StringBuilder sb = new StringBuilder();
        if (j6 > 0) {
            sb.append(j6 + "小时");
        }
        if (j11 > 0) {
            sb.append(j11 + "分钟");
        }
        if (j12 > 0 || sb.length() == 0) {
            sb.append(j12 + "秒");
        }
        return sb.toString();
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getModelCell() {
        return this.modelCell;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSjflTraceId() {
        return this.sjflTraceId;
    }

    public final List<GuiActionRecord> component12() {
        return this.actions;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component7, reason: from getter */
    public final SessionState getTaskState() {
        return this.taskState;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    public final GuiTaskRecord copy(String taskName, String taskId, String startTime, String endTime, String appName, int taskType, SessionState taskState, String traceId, String modelId, String modelCell, String sjflTraceId, List<GuiActionRecord> actions) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(startTime, "startTime");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(actions, "actions");
        return new GuiTaskRecord(taskName, taskId, startTime, endTime, appName, taskType, taskState, traceId, modelId, modelCell, sjflTraceId, actions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskRecord)) {
            return false;
        }
        GuiTaskRecord guiTaskRecord = (GuiTaskRecord) other;
        return kotlin.jvm.internal.k.b(this.taskName, guiTaskRecord.taskName) && kotlin.jvm.internal.k.b(this.taskId, guiTaskRecord.taskId) && kotlin.jvm.internal.k.b(this.startTime, guiTaskRecord.startTime) && kotlin.jvm.internal.k.b(this.endTime, guiTaskRecord.endTime) && kotlin.jvm.internal.k.b(this.appName, guiTaskRecord.appName) && this.taskType == guiTaskRecord.taskType && this.taskState == guiTaskRecord.taskState && kotlin.jvm.internal.k.b(this.traceId, guiTaskRecord.traceId) && kotlin.jvm.internal.k.b(this.modelId, guiTaskRecord.modelId) && kotlin.jvm.internal.k.b(this.modelCell, guiTaskRecord.modelCell) && kotlin.jvm.internal.k.b(this.sjflTraceId, guiTaskRecord.sjflTraceId) && kotlin.jvm.internal.k.b(this.actions, guiTaskRecord.actions);
    }

    public final synchronized int getActionCount() {
        return this.actions.size();
    }

    public final List<GuiActionRecord> getActions() {
        return this.actions;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final synchronized GuiActionRecord getLastAction() {
        return (GuiActionRecord) v.L0(this.actions);
    }

    public final String getModelCell() {
        return this.modelCell;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getSjflTraceId() {
        return this.sjflTraceId;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getStateDisplayName() {
        return INSTANCE.getStateName(this.taskState);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final SessionState getTaskState() {
        return this.taskState;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iC = B7.a.c(B7.a.c(this.taskName.hashCode() * 31, 31, this.taskId), 31, this.startTime);
        String str = this.endTime;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appName;
        int iHashCode2 = (this.taskState.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.taskType, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31)) * 31;
        String str3 = this.traceId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modelId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.modelCell;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sjflTraceId;
        return this.actions.hashCode() + ((iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31);
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setModelCell(String str) {
        this.modelCell = str;
    }

    public final void setModelId(String str) {
        this.modelId = str;
    }

    public final void setSjflTraceId(String str) {
        this.sjflTraceId = str;
    }

    public final void setTaskState(SessionState sessionState) {
        kotlin.jvm.internal.k.f(sessionState, "<set-?>");
        this.taskState = sessionState;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        String str = this.taskName;
        String str2 = this.taskId;
        String str3 = this.startTime;
        String str4 = this.endTime;
        String str5 = this.appName;
        int i = this.taskType;
        SessionState sessionState = this.taskState;
        String str6 = this.traceId;
        String str7 = this.modelId;
        String str8 = this.modelCell;
        String str9 = this.sjflTraceId;
        List<GuiActionRecord> list = this.actions;
        StringBuilder sbW = B7.a.w("GuiTaskRecord(taskName=", str, ", taskId=", str2, ", startTime=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", endTime=", str4, ", appName=");
        androidx.compose.foundation.b.B(sbW, str5, ", taskType=", i, ", taskState=");
        sbW.append(sessionState);
        sbW.append(", traceId=");
        sbW.append(str6);
        sbW.append(", modelId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", modelCell=", str8, ", sjflTraceId=");
        sbW.append(str9);
        sbW.append(", actions=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        parcel.writeString(this.taskName);
        parcel.writeString(this.taskId);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        parcel.writeString(this.appName);
        parcel.writeInt(this.taskType);
        parcel.writeString(this.taskState.name());
        parcel.writeString(this.traceId);
        parcel.writeString(this.modelId);
        parcel.writeString(this.modelCell);
        parcel.writeString(this.sjflTraceId);
        synchronized (this) {
            parcel.writeTypedList(this.actions);
        }
    }

    public /* synthetic */ GuiTaskRecord(String str, String str2, String str3, String str4, String str5, int i, SessionState sessionState, String str6, String str7, String str8, String str9, List list, int i6, kotlin.jvm.internal.e eVar) {
        this(str, str2, str3, (i6 & 8) != 0 ? null : str4, str5, i, sessionState, (i6 & 128) != 0 ? null : str6, (i6 & 256) != 0 ? null : str7, (i6 & 512) != 0 ? null : str8, (i6 & 1024) != 0 ? null : str9, (i6 & 2048) != 0 ? new ArrayList() : list);
    }

    public GuiTaskRecord(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        int i = parcel.readInt();
        String string6 = parcel.readString();
        SessionState sessionStateValueOf = SessionState.valueOf(string6 == null ? "CREATED" : string6);
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, GuiActionRecord.INSTANCE);
        this(str, str2, str3, string4, string5, i, sessionStateValueOf, string7, string8, string9, string10, arrayList);
    }
}
