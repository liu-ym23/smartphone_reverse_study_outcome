package com.stepos.ability.commoninternal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/ability/commoninternal/SLAScene;", "", AppAgent.CONSTRUCT, "()V", "SLA_SCENE", "", "SLA_TYPE_NO_PAGE_REDIRECTION", "", "SLA_TYPE_REDIRECTING_TO_PAGE", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SLAScene {
    public static final SLAScene INSTANCE = new SLAScene();
    public static final String SLA_SCENE = "slaScene";
    public static final int SLA_TYPE_NO_PAGE_REDIRECTION = 1;
    public static final int SLA_TYPE_REDIRECTING_TO_PAGE = 2;

    private SLAScene() {
    }
}
