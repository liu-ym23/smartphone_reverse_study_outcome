package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139523a = null;

    static {
        int[] r100 = new int[AiAgentViewChangeReason.values().length];
        f139523a = r100;
        r100[AiAgentViewChangeReason.INIT.ordinal()] = 1;
        r100[AiAgentViewChangeReason.CONTAINER_SHOW.ordinal()] = 2;
        r100[AiAgentViewChangeReason.CONTAINER_HIDE.ordinal()] = 3;
        r100[AiAgentViewChangeReason.MESSAGE_INSERT.ordinal()] = 4;
        r100[AiAgentViewChangeReason.MESSAGE_REMOVE.ordinal()] = 5;
        r100[AiAgentViewChangeReason.ZOOM_OUT.ordinal()] = 6;
        r100[AiAgentViewChangeReason.ZOOM_IN.ordinal()] = 7;
        r100[AiAgentViewChangeReason.MODE_CHANGE.ordinal()] = 8;
        r100[AiAgentViewChangeReason.TIMEOUT.ordinal()] = 9;
    }
}
