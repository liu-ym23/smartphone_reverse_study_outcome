package com.stepos.motionkit.fx.material.capability;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/InWindowBlurBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "token", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "LC7/r;", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "()V", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class InWindowBlurBinding implements MaterialBinding {
    private final InWindowMaterialBackend.Token token;

    public InWindowBlurBinding(InWindowMaterialBackend.Token token) {
        k.f(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(BlurParams blurParams, InWindowMaterialBackend.Config c) {
        k.f(c, "c");
        c.setRadius(blurParams.getRadius());
        c.setTintColor(blurParams.getTintColor());
        c.setBlendMode(blurParams.getOverlay() ? 3 : 2);
        c.setBlendColor(blurParams.getBlendColor());
        c.setFrost(blurParams.getFrost());
        c.setUseAospBlur(blurParams.getUseAospBlur());
        if (blurParams instanceof GradientBlurParams) {
            GradientBlurParams gradientBlurParams = (GradientBlurParams) blurParams;
            c.setBlurMode(gradientBlurParams.getDirection().getMode());
            c.setBlurScale(gradientBlurParams.getGradientScale());
            c.setCgStart(gradientBlurParams.getStartColor());
            c.setCgMiddle(gradientBlurParams.getMiddleColor());
            c.setCgEnd(gradientBlurParams.getEndColor());
            c.setCgMidpoint(gradientBlurParams.getColorMidpoint());
            c.setCgMode(BlurCapabilityKt.colorGradMode(gradientBlurParams));
        } else {
            c.setBlurMode(0);
            c.setBlurScale(0.0f);
            c.setCgStart(0);
            c.setCgMiddle(0);
            c.setCgEnd(0);
            c.setCgMidpoint(0.5f);
            c.setCgMode(0);
        }
        return r.f317a;
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        InWindowMaterialBackend.Token.release$default(this.token, null, 1, null);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) {
        k.f(params, "params");
        BlurParams blurParams = params instanceof BlurParams ? (BlurParams) params : null;
        if (blurParams == null) {
            return;
        }
        this.token.config(new i(blurParams, 0));
    }
}
