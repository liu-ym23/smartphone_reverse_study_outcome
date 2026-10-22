package com.obric.autogui.common;

import android.os.Bundle;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AutoOperateTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoOperateTask {
    public static final a Companion = null;
    public static final String KEY_EXTRA_EVALUATED_TASK = "ao_evaluated_task";
    public static final String KEY_EXTRA_SESSION_EXECUTION_TRACKER = "ao_task_ses_exec_tracker";
    private final transient Map<String, Object> internalExtras;
    private int launchOrigin;
    private String scriptedTask;
    private transient Bundle taskExtras;
    private String taskId;
    private Integer taskMode;
    private Integer taskType;
    private String userTask;

    /* JADX INFO: compiled from: AutoOperateTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoOperateTask.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f28953a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f28954b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f28955c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f28956e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f28957d;

        private static final /* synthetic */ b[] b() {
            return new b[]{f28953a, f28954b, f28955c};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f28957d = r3;
        }

        public final int a() {
            return this.f28957d;
        }

        static {
            f28953a = new b("USER_TASK", 0, 33);
            f28954b = new b("SCRIPTED_TASK", 1, 17);
            f28955c = new b("UNKNOWN", 2, 0);
            b[] r0 = b();
            f28956e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f28956e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AutoOperateTask.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28958a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f28953a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[b.f28954b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[b.f28955c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f28958a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoOperateTask() {
        this.launchOrigin = 1;
        this.internalExtras = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final String getUserTask() {
        return this.userTask;
    }

    public final void setUserTask(String r1) {
        this.userTask = r1;
    }

    public final String getScriptedTask() {
        return this.scriptedTask;
    }

    public final void setScriptedTask(String r1) {
        this.scriptedTask = r1;
    }

    public final int getLaunchOrigin() {
        return this.launchOrigin;
    }

    public final void setLaunchOrigin(int r1) {
        this.launchOrigin = r1;
    }

    public final Bundle getTaskExtras() {
        return this.taskExtras;
    }

    public final void setTaskExtras(Bundle r3) {
        this.taskExtras = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.containsKey("timerTaskId") == false) goto L8;
        this.taskId = r3.getString("timerTaskId");
    L8:
        if (r3.containsKey(KnowledgeActivity.KEY_TASK_TYPE) == false) goto L11;
        this.taskType = Integer.valueOf(r3.getInt(KnowledgeActivity.KEY_TASK_TYPE));
    L11:
        if (r3.containsKey("task_mode") == false) goto L15;
        this.taskMode = Integer.valueOf(r3.getInt("task_mode"));
        return;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    /* JADX INFO: renamed from: getTaskType, reason: collision with other method in class */
    public final Integer m799getTaskType() {
        return this.taskType;
    }

    public final void setTaskType(Integer r1) {
        this.taskType = r1;
    }

    public final Integer getTaskMode() {
        return this.taskMode;
    }

    public final void setTaskMode(Integer r1) {
        this.taskMode = r1;
    }

    public final Map<String, Object> getInternalExtras() {
        return this.internalExtras;
    }

    public final Long doubaoMessageId() {
        Bundle r2 = this.taskExtras;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.containsKey("doubao_message_id") == true) goto L7;
        return null;
    L7:
        return Long.valueOf(r2.getLong("doubao_message_id"));
    }

    public final String getTimerTaskId() {
        Bundle r2 = this.taskExtras;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.containsKey("timerTaskId") == true) goto L7;
        return null;
    L7:
        return r2.getString("timerTaskId");
    }

    public final long getTriggeredBootTime() {
        Bundle r6 = this.taskExtras;
        if (r6 == null) goto L5;
        long r2 = r6.getLong("triggered_boot_time", -1);
    L7:
        if (r2 <= 0) goto L9;
        return r2;
    L9:
        return -1;
    L5:
        r2 = -1;
        goto L7
    }

    public final boolean isTestRun() {
        Bundle r2 = this.taskExtras;
        if (r2 == null) goto L5;
        String r3 = r2.getString("execution_mode", "DEFAULT");
    L7:
        return o.a(r3, "TEST_RUN");
    L5:
        r3 = null;
        goto L7
    }

    public final boolean isOmni() {
        if (this.launchOrigin != 36) goto L5;
        return true;
    L5:
        return false;
    }

    public final e checkParameters() {
        if (this.userTask != null) goto L9;
        if (this.scriptedTask != null) goto L9;
        return e.f29014b.b("invalid parameters; both `userTask` and `scriptedTask` are null");
    L9:
        return e.f29014b.a();
    }

    public final b getTaskType() {
        if (this.userTask == null) goto L7;
        return b.f28953a;
    L7:
        if (this.scriptedTask == null) goto L11;
        return b.f28954b;
    L11:
        return b.f28955c;
    }

    public final String getRepresentativeTaskString() {
        b r0 = getTaskType();
        int r1 = c.f28958a[r0.ordinal()];
        if (r1 != 1) goto L5;
        String r2 = this.userTask;
    L13:
        if (r2 != null) goto L16;
        return "NA";
    L16:
        return r2;
    L5:
        if (r1 != 2) goto L7;
        r2 = this.scriptedTask;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        r2 = "UNKNOWN";
        goto L13
    L10:
        throw new k();
    }

    public final int getTaskCatalogueNumber() {
        int r0 = getTaskType().a();
        return this.launchOrigin | (r0 << 8);
    }

    public String toString() {
        return "AOTask(u=" + this.userTask + "/s=" + this.scriptedTask + ",cl=" + Integer.toHexString(getTaskCatalogueNumber()) + ')';
    }
}
