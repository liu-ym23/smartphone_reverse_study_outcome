package com.stepos.motionkit.fx.material.capability;

import android.content.Context;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialCapability;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GradientBlurCapability;", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", AppAgent.CONSTRUCT, "()V", "delegate", "Lcom/stepos/motionkit/fx/material/capability/BlurCapability;", "id", "", "getId", "()Ljava/lang/String;", "defaultParams", "isSupported", "", "context", "Landroid/content/Context;", "bind", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "view", "Landroid/view/View;", "params", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GradientBlurCapability implements MaterialCapability<GradientBlurParams> {
    private final BlurCapability delegate = new BlurCapability();
    private final String id = "gradient_blur";

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public String getId() {
        return this.id;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public boolean isSupported(Context context) {
        k.f(context, "context");
        return this.delegate.isSupported(context);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public MaterialBinding bind(View view, GradientBlurParams params) {
        k.f(view, "view");
        k.f(params, "params");
        return this.delegate.bind(view, (BlurParams) params);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public GradientBlurParams defaultParams() {
        return new GradientBlurParams();
    }
}
