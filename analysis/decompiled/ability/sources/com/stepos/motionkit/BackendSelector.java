package com.stepos.motionkit;

import android.content.Context;
import android.opengl.EGL14;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/motionkit/BackendSelector;", "", AppAgent.CONSTRUCT, "()V", "select", "Lcom/stepos/motionkit/BackendHint;", "definition", "Lcom/stepos/motionkit/EffectDefinition;", "config", "Lcom/stepos/motionkit/FxConfig;", "context", "Landroid/content/Context;", "isGlesAvailable", "", "isVulkanAvailable", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackendSelector {
    public static final BackendSelector INSTANCE = new BackendSelector();

    private BackendSelector() {
    }

    public final boolean isGlesAvailable() {
        try {
            return !k.b(EGL14.eglGetDisplay(0), EGL14.EGL_NO_DISPLAY);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isVulkanAvailable() {
        try {
            System.loadLibrary("vulkan");
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public final BackendHint select(EffectDefinition definition, FxConfig config, Context context) {
        k.f(definition, "definition");
        k.f(config, "config");
        k.f(context, "context");
        BackendHint backend = config.getBackend();
        BackendHint backendHint = BackendHint.AUTO;
        return backend != backendHint ? config.getBackend() : definition.getBackendHint() != backendHint ? definition.getBackendHint() : BackendHint.RUNTIME_SHADER;
    }
}
