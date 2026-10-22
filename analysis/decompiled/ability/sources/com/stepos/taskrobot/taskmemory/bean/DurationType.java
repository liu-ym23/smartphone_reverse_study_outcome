package com.stepos.taskrobot.taskmemory.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/bean/DurationType;", "", AppAgent.CONSTRUCT, "()V", "SCREENSHOT_SAVE", "", "SCREENSHOT_UPLOAD", "INFERENCE", "ACTION_EXECUTION", "STEP_TOTAL", "IMAGE_PROCESSING", "NETWORK_REQUEST", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DurationType {
    public static final String ACTION_EXECUTION = "action_execution";
    public static final String IMAGE_PROCESSING = "image_processing";
    public static final String INFERENCE = "inference";
    public static final DurationType INSTANCE = new DurationType();
    public static final String NETWORK_REQUEST = "network_request";
    public static final String SCREENSHOT_SAVE = "screenshot_save";
    public static final String SCREENSHOT_UPLOAD = "screenshot_upload";
    public static final String STEP_TOTAL = "step_total";

    private DurationType() {
    }
}
