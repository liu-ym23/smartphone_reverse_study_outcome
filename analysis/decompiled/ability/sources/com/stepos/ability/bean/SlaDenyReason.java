package com.stepos.ability.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/ability/bean/SlaDenyReason;", "", AppAgent.CONSTRUCT, "()V", "NONE", "", "MODE_NOT_ALLOW", "REDLINE", "UNKNOWN_FUNCTION", "SCOPE_MISSING", "NO_MODE_SNAPSHOT", "NO_MAPPING_SNAPSHOT", "STALE", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaDenyReason {
    public static final SlaDenyReason INSTANCE = new SlaDenyReason();
    public static final int MODE_NOT_ALLOW = 1;
    public static final int NONE = 0;
    public static final int NO_MAPPING_SNAPSHOT = 6;
    public static final int NO_MODE_SNAPSHOT = 5;
    public static final int REDLINE = 2;
    public static final int SCOPE_MISSING = 4;
    public static final int STALE = 7;
    public static final int UNKNOWN_FUNCTION = 3;

    private SlaDenyReason() {
    }
}
