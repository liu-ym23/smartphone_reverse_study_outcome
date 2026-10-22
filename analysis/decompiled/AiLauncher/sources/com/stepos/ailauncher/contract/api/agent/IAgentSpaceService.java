package com.stepos.ailauncher.contract.api.agent;

import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IAgentSpaceService;", "", "LY8/t;", "init", "()V", "showWindow", "hideWindow", "", "isWindowShowing", "()Z", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "taskId", "notifyAiReply", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAgentSpaceService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void notifyAiReply$default(IAgentSpaceService iAgentSpaceService, String str, String str2, String str3, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAiReply");
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        iAgentSpaceService.notifyAiReply(str, str2, str3);
    }

    void hideWindow();

    void init();

    boolean isWindowShowing();

    void notifyAiReply(String title, String content, String taskId);

    void showWindow();
}
