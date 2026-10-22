package com.stepos.ailauncher.foundation.sprite.bean;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEventType;", "", "<init>", "()V", "TASK", "", "SYSTEM", "SPACE", "NIGHT", "COUNTING", "USER", "NETWORK", "AGENT_WORK", "AGENT_WAKE", "TASK_READ", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpriteEventType {
    public static final String AGENT_WAKE = "agent_wake_event";
    public static final String AGENT_WORK = "agent_work_event";
    public static final String COUNTING = "counting_event";
    public static final SpriteEventType INSTANCE = new SpriteEventType();
    public static final String NETWORK = "network_event";
    public static final String NIGHT = "night_event";
    public static final String SPACE = "space_event";
    public static final String SYSTEM = "system_event";
    public static final String TASK = "task_event";
    public static final String TASK_READ = "task_read_event";
    public static final String USER = "user_event";

    private SpriteEventType() {
    }
}
