package com.mdisdk;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/mdisdk/Constant;", "", AppAgent.CONSTRUCT, "()V", "DEFAULT_DURATION_CLICK", "", "DEFAULT_DURATION_LONG_CLICK", "DEFAULT_DURATION_SCALE", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Constant {
    public static final long DEFAULT_DURATION_CLICK = 50;
    public static final long DEFAULT_DURATION_LONG_CLICK = 250;
    public static final long DEFAULT_DURATION_SCALE = 500;
    public static final Constant INSTANCE = new Constant();

    private Constant() {
    }
}
