package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139511a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f139512b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f139513c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f139514d = null;

    static {
        int[] r100 = new int[AiAgentViewState.values().length];
        f139511a = r100;
        AiAgentViewState r101 = AiAgentViewState.NO_OR_OLD_AI;
        r100[r101.ordinal()] = 1;
        AiAgentViewState r102 = AiAgentViewState.AI_AGENT_EMPTY;
        r100[r102.ordinal()] = 2;
        AiAgentViewState r103 = AiAgentViewState.AI_AGENT_MESSAGE;
        r100[r103.ordinal()] = 3;
        AiAgentViewState r104 = AiAgentViewState.AI_AGENT_FOLD;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[AiAgentViewState.values().length];
        f139512b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        int[] r106 = new int[AiAgentViewState.values().length];
        f139513c = r106;
        r106[r102.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
        r106[r104.ordinal()] = 3;
        int[] r107 = new int[AiAgentViewState.values().length];
        f139514d = r107;
        r107[r101.ordinal()] = 1;
        r107[r102.ordinal()] = 2;
        r107[r104.ordinal()] = 3;
        r107[r103.ordinal()] = 4;
    }
}
