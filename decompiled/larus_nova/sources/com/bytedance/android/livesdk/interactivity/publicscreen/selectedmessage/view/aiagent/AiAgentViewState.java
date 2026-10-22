package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/AiAgentViewState;", "", "", SocialConstants.PARAM_APP_DESC, "DEFAULT", "NO_OR_OLD_AI", "AI_AGENT_EMPTY", "AI_AGENT_MESSAGE", "AI_AGENT_FOLD", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AiAgentViewState extends Enum<AiAgentViewState> {
    public static final AiAgentViewState AI_AGENT_EMPTY = null;
    public static final AiAgentViewState AI_AGENT_FOLD = null;
    public static final AiAgentViewState AI_AGENT_MESSAGE = null;
    public static final AiAgentViewState DEFAULT = null;
    public static final AiAgentViewState NO_OR_OLD_AI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AiAgentViewState[] f139501a = null;

    static {
        AiAgentViewState r100 = new AiAgentViewState("DEFAULT", 0);
        DEFAULT = r100;
        AiAgentViewState r101 = new AiAgentViewState("NO_OR_OLD_AI", 1);
        NO_OR_OLD_AI = r101;
        AiAgentViewState r102 = new AiAgentViewState("AI_AGENT_EMPTY", 2);
        AI_AGENT_EMPTY = r102;
        AiAgentViewState r103 = new AiAgentViewState("AI_AGENT_MESSAGE", 3);
        AI_AGENT_MESSAGE = r103;
        AiAgentViewState r104 = new AiAgentViewState("AI_AGENT_FOLD", 4);
        AI_AGENT_FOLD = r104;
        f139501a = new AiAgentViewState[]{r100, r101, r102, r103, r104};
    }

    public static AiAgentViewState valueOf(String r100) {
        return (AiAgentViewState) r27.a.a(AiAgentViewState.class, r100);
    }

    public static AiAgentViewState[] values() {
        return (AiAgentViewState[]) f139501a.clone();
    }

    public final String desc() {
        int r100 = j.f139524a[ordinal()];
        if (r100 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r100 != 2) goto L7;
        return "NO_OR_OLD_AI";
    L7:
        if (r100 != 3) goto L9;
        return "AI_AGENT_EMPTY";
    L9:
        if (r100 != 4) goto L11;
        return "AI_AGENT_MESSAGE";
    L11:
        if (r100 != 5) goto L14;
        return "AI_AGENT_FOLD";
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public AiAgentViewState(String r100, int r101) {
        super(r100, r101);
    }
}
