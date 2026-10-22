package com.stepos.ability.commoninternal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/ability/commoninternal/CallSource;", "", AppAgent.CONSTRUCT, "()V", CallSource.SLA, "", "CLOUD", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallSource {
    public static final String CLOUD = "CLOUD";
    public static final CallSource INSTANCE = new CallSource();
    public static final String SLA = "SLA";

    private CallSource() {
    }
}
