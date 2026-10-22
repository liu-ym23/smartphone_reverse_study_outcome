package com.stepos.motionkit.fx.backend;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SfInstance;", "", "Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", "channel", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/backend/SfEffectChannel;Lcom/stepos/motionkit/fx/uniform/UniformBinder;)V", "", "elapsedMs", "LC7/r;", "pushFrame", "(J)V", "Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", "getChannel", "()Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SfInstance {
    private final UniformBinder binder;
    private final SfEffectChannel channel;

    public SfInstance(SfEffectChannel channel, UniformBinder binder) {
        kotlin.jvm.internal.k.f(channel, "channel");
        kotlin.jvm.internal.k.f(binder, "binder");
        this.channel = channel;
        this.binder = binder;
    }

    public final SfEffectChannel getChannel() {
        return this.channel;
    }

    public final void pushFrame(long elapsedMs) {
        this.binder.resolve(elapsedMs);
        this.channel.submitUniforms(this.binder.snapshotUniforms());
    }
}
