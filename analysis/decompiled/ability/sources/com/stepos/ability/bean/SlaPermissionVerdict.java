package com.stepos.ability.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/ability/bean/SlaPermissionVerdict;", "", AppAgent.CONSTRUCT, "()V", "ALLOWED", "", "DENIED", "UNAVAILABLE", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaPermissionVerdict {
    public static final int ALLOWED = 0;
    public static final int DENIED = 1;
    public static final SlaPermissionVerdict INSTANCE = new SlaPermissionVerdict();
    public static final int UNAVAILABLE = 2;

    private SlaPermissionVerdict() {
    }
}
