package com.stepos.motionkit.fx.material.capability;

import android.content.Context;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialCapability;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/BlendCapability;", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "Lcom/stepos/motionkit/fx/material/capability/BlendParams;", AppAgent.CONSTRUCT, "()V", "id", "", "getId", "()Ljava/lang/String;", "defaultParams", "isSupported", "", "context", "Landroid/content/Context;", "bind", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "view", "Landroid/view/View;", "params", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlendCapability implements MaterialCapability<BlendParams> {
    private final String id = "glass_blend";

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public String getId() {
        return this.id;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public boolean isSupported(Context context) {
        k.f(context, "context");
        return CrossWindowMaterialBackend.INSTANCE.isAvailable() || InWindowMaterialBackend.INSTANCE.isAvailable();
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public MaterialBinding bind(View view, BlendParams params) {
        k.f(view, "view");
        k.f(params, "params");
        if (params.getCrossWindow()) {
            CrossWindowMaterialBackend.Token tokenAcquire = CrossWindowMaterialBackend.INSTANCE.acquire(view);
            if (tokenAcquire == null) {
                return null;
            }
            CrossBlendBinding crossBlendBinding = new CrossBlendBinding(tokenAcquire);
            crossBlendBinding.update(params);
            return crossBlendBinding;
        }
        InWindowMaterialBackend.Token tokenAcquire2 = InWindowMaterialBackend.INSTANCE.acquire(view);
        if (tokenAcquire2 == null) {
            return null;
        }
        InWindowBlendBinding inWindowBlendBinding = new InWindowBlendBinding(tokenAcquire2);
        inWindowBlendBinding.update(params);
        return inWindowBlendBinding;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialCapability
    public BlendParams defaultParams() {
        return new BlendParams();
    }
}
