package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/TaskTimeouts;", "", AppAgent.CONSTRUCT, "()V", "LLM_TAKEOVER_MS", "", "LLM_TAKEOVER_MAX_RETRIES", "", "TASK_EXECUTION_MS", "INJECT_EXPERIENCE_MS", "TAKEOVER_IDLE_MS", "FULLSCREEN_DOCKED_MS", "FULLSCREEN_COUNTDOWN_SECONDS", "PENDING_SURFACE_MS", "FULLSCREEN_ANTI_MISTOUCH_PROMPT_MS", "FULLSCREEN_TAKEOVER_ACK_MS", "STATUS_BAR_CAROUSEL_INTERVAL_MS", "MAIN_DISPLAY_SETTLE_MS", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskTimeouts {
    public static final long FULLSCREEN_ANTI_MISTOUCH_PROMPT_MS = 3000;
    public static final int FULLSCREEN_COUNTDOWN_SECONDS = 5;
    public static final long FULLSCREEN_DOCKED_MS = 3000;
    public static final long FULLSCREEN_TAKEOVER_ACK_MS = 5000;
    public static final long INJECT_EXPERIENCE_MS = 15000;
    public static final TaskTimeouts INSTANCE = new TaskTimeouts();
    public static final int LLM_TAKEOVER_MAX_RETRIES = 2;
    public static final long LLM_TAKEOVER_MS = 60000;
    public static final long MAIN_DISPLAY_SETTLE_MS = 3000;
    public static final long PENDING_SURFACE_MS = 1220000;
    public static final long STATUS_BAR_CAROUSEL_INTERVAL_MS = 5000;
    public static final long TAKEOVER_IDLE_MS = 300000;
    public static final long TASK_EXECUTION_MS = 1220000;

    private TaskTimeouts() {
    }
}
