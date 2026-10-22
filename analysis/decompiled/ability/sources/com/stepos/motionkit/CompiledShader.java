package com.stepos.motionkit;

import android.graphics.RuntimeShader;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/motionkit/CompiledShader;", "", AgentBusWakeContract.EXTRA_SOURCE, "", "backendType", "Lcom/stepos/motionkit/BackendHint;", "runtimeShader", "Landroid/graphics/RuntimeShader;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/BackendHint;Landroid/graphics/RuntimeShader;)V", "getSource", "()Ljava/lang/String;", "getBackendType", "()Lcom/stepos/motionkit/BackendHint;", "getRuntimeShader", "()Landroid/graphics/RuntimeShader;", "isValid", "", "()Z", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CompiledShader {
    private final BackendHint backendType;
    private final RuntimeShader runtimeShader;
    private final String source;

    public CompiledShader(String source, BackendHint backendType, RuntimeShader runtimeShader) {
        k.f(source, "source");
        k.f(backendType, "backendType");
        this.source = source;
        this.backendType = backendType;
        this.runtimeShader = runtimeShader;
    }

    public final BackendHint getBackendType() {
        return this.backendType;
    }

    public final RuntimeShader getRuntimeShader() {
        return this.runtimeShader;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean isValid() {
        return this.runtimeShader != null || this.source.length() > 0;
    }

    public /* synthetic */ CompiledShader(String str, BackendHint backendHint, RuntimeShader runtimeShader, int i, e eVar) {
        this(str, backendHint, (i & 4) != 0 ? null : runtimeShader);
    }
}
