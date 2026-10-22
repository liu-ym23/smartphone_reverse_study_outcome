package com.stepos.motionkit.fx.backend;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.backend.sf.SfDrawableChannel;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003¨\u0006\u001b"}, d2 = {"Lcom/stepos/motionkit/fx/backend/NoopSfEffectChannel;", "Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", AppAgent.CONSTRUCT, "()V", "", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "log", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "attach", "(Landroid/view/View;)V", "agsl", "submitShader", "", "enabled", "setBackgroundSampling", "(Z)V", "", "", "uniforms", "submitUniforms", "(Ljava/util/Map;)V", "start", "stop", "detach", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoopSfEffectChannel implements SfEffectChannel {
    private final void log(String msg) {
        MKLog.INSTANCE.d(SfDrawableChannel.TAG, "[noop] " + msg);
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void attach(View view) {
        kotlin.jvm.internal.k.f(view, "view");
        log("attach view=" + view);
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void detach() {
        log("detach");
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void setBackgroundSampling(boolean enabled) {
        log("setBackgroundSampling " + enabled);
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void start() {
        log("start");
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void stop() {
        log("stop");
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void submitShader(String agsl) {
        kotlin.jvm.internal.k.f(agsl, "agsl");
        log(androidx.appfunctions.metadata.a.i(agsl.length(), "submitShader ", " chars"));
    }

    @Override // com.stepos.motionkit.fx.backend.SfEffectChannel
    public void submitUniforms(Map<String, float[]> uniforms) {
        kotlin.jvm.internal.k.f(uniforms, "uniforms");
        log("submitUniforms " + uniforms.keySet());
    }
}
