package com.obric.eventkit.eventstaskmanager;

/* JADX INFO: loaded from: classes4.dex */
public final class AssistantSessionState {
    public static final int ACTIVE = 1;
    public static final int IDLE = 0;
    public static final AssistantSessionState INSTANCE = null;
    public static final int LISTENING = 3;
    public static final int REALTIME_CALLING = 2;

    static {
        INSTANCE = new AssistantSessionState();
    }

    private AssistantSessionState() {
    }
}
